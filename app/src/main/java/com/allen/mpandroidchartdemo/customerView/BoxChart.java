package com.allen.mpandroidchartdemo.customerView;


import android.content.Context;
import android.util.AttributeSet;

import com.allen.mpandroidchartdemo.date.BoxData;
import com.github.mikephil.charting.charts.BarLineChartBase;

/**
 * Created by Allen on 2017/12/5.
 */

public class BoxChart extends BarLineChartBase<BoxData> implements BoxDataProvider {
    private float boxWidth;

    public BoxChart(Context context) {
        super(context);
    }

    public BoxChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BoxChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    protected void init() {
        super.init();
        this.mRenderer = new BoxChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        this.getXAxis().setSpaceMin(0.5F);
        this.getXAxis().setSpaceMax(0.5F);
    }

    @Override
    public BoxData getBoxData() {
        return this.mData;
    }


    @Override
    public float getBoxWidth() {
        return boxWidth;
    }

    @Override
    public void setBoxWidth(float boxWidth) {
        this.boxWidth = boxWidth;
    }
}
