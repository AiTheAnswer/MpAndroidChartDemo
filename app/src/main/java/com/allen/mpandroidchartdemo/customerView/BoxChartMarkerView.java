package com.allen.mpandroidchartdemo.customerView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.IMarker;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;

import java.lang.ref.WeakReference;

/**
 * Created by Allen on 2017/12/5.
 */

public class BoxChartMarkerView extends RelativeLayout implements IMarker {
    private MPPointF mOffset = new MPPointF();
    private MPPointF mOffset2 = new MPPointF();
    private WeakReference<Chart> mWeakChart;

    public BoxChartMarkerView(Context context, int layoutResource) {
        super(context);
        this.setupLayoutResource(layoutResource);
    }

    private void setupLayoutResource(int layoutResource) {
        View inflated = LayoutInflater.from(this.getContext()).inflate(layoutResource, this);
        inflated.setLayoutParams(new LayoutParams(-2, -2));
        inflated.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
        inflated.layout(0, 0, inflated.getMeasuredWidth(), inflated.getMeasuredHeight());
    }

    public void setOffset(MPPointF offset) {
        this.mOffset = offset;
        if (this.mOffset == null) {
            this.mOffset = new MPPointF();
        }

    }

    public void setOffset(float offsetX, float offsetY) {
        this.mOffset.x = offsetX;
        this.mOffset.y = offsetY;
    }

    public MPPointF getOffset() {
        return this.mOffset;
    }

    public void setChartView(Chart chart) {
        this.mWeakChart = new WeakReference(chart);
    }

    public Chart getChartView() {
        return this.mWeakChart == null ? null : (Chart) this.mWeakChart.get();
    }

    public MPPointF getOffsetForDrawingAtPoint(float posX, float posY) {
        Chart chart = this.getChartView();
        BoxChart boxChart = null;
        //箱子的宽度
        float boxWidth = 0;
        if (chart instanceof BoxChart) {
            boxChart = (BoxChart) chart;
            boxWidth = boxChart.getBoxWidth() * 1.3f;
        }
        //图表的宽高
        RectF contentRect = chart.getContentRect();
        int chartWidth = (int) contentRect.right;
        int chartHeight = (int) contentRect.bottom;
        int chartTop = (int) contentRect.top;
        //MarkerView的宽高
        float markerWidth = (float) getWidth();
        float markerHeight = (float) getHeight();
        MPPointF offset = this.getOffset();
        this.mOffset2.x = boxWidth * 0.3f;
        if (markerWidth + posX > chartWidth) {
            this.mOffset2.x = offset.x * 2 - boxWidth;
        }
        this.mOffset2.y = offset.y * 0.5f;
        if (posY + this.mOffset2.y < chartTop) {
            this.mOffset2.y = -posY + chartTop;
        } else if (posY + markerHeight + this.mOffset2.y > chartHeight) {
            this.mOffset2.y = chartHeight - posY - markerHeight - Utils.convertDpToPixel(3);
        }

        return this.mOffset2;
    }

    public void refreshContent(Entry e, Highlight highlight) {
        this.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
        this.layout(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight());
    }

    public void draw(Canvas canvas, float posX, float posY) {
        MPPointF offset = this.getOffsetForDrawingAtPoint(posX, posY);
        int saveId = canvas.save();
        canvas.translate(posX + offset.x, posY + offset.y);
        this.draw(canvas);
        canvas.restoreToCount(saveId);
    }
}
