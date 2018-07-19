package com.allen.mpandroidchartdemo.customerView;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import com.allen.mpandroidchartdemo.date.BoxData;
import com.allen.mpandroidchartdemo.date.BoxEntry;
import com.allen.mpandroidchartdemo.date.IBoxDataSet;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.renderer.LineScatterCandleRadarRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Allen on 2017/12/5.
 */

public class BoxChartRenderer extends LineScatterCandleRadarRenderer {
    private BoxDataProvider mBoxDataProvider;
    private float[] mShadowBuffers = new float[8];
    private float[] mBodyBuffers = new float[4];
    private float[] mMedianBuffers = new float[4];
    private float[] mLimitBuffers = new float[8];
    private float[] mAbnormalBuffers;
    private float barSpace;

    public BoxChartRenderer(BoxDataProvider chart, ChartAnimator animator, ViewPortHandler viewPortHandler) {
        super(animator, viewPortHandler);
        this.mBoxDataProvider = chart;

    }

    @Override
    public void initBuffers() {

    }

    @Override
    public void drawData(Canvas canvas) {
        BoxData boxData = this.mBoxDataProvider.getBoxData();
        Iterator var3 = boxData.getDataSets().iterator();

        while (var3.hasNext()) {
            IBoxDataSet set = (IBoxDataSet) var3.next();
            if (set.isVisible()) {
                drawDataSet(canvas, set);
            }
        }

    }

    private void drawDataSet(Canvas canvas, IBoxDataSet dataSet) {
        Transformer trans = this.mBoxDataProvider.getTransformer(dataSet.getAxisDependency());
        float phaseY = this.mAnimator.getPhaseY();
        barSpace = dataSet.getBarSpace();
        this.mXBounds.set(this.mBoxDataProvider, dataSet);
        this.mRenderPaint.setStrokeWidth(dataSet.getShadowWidth());
        for (int j = this.mXBounds.min; j <= this.mXBounds.range + this.mXBounds.min; ++j) {
            BoxEntry entry = dataSet.getEntryForIndex(j);
            if (entry != null) {
                float xPos = entry.getX();//x轴的位置
                Float capped = entry.getmCapped();//上限
                Float upperEdge = entry.getmUpperEdge();//上边缘
                Float upperFourthQuarter = entry.getmUpperFourthQuarter();//上四分位数
                Float median = entry.getmMedian();//中位数
                Float nextQuarter = entry.getmNextQuarter();//下四分位数
                Float underEdge = entry.getmUnderEdge();//下边缘
                Float lowerLimit = entry.getmLowerLimit();//下限
                List<Float> abnormalDates = entry.getmAbnormalDates();//异常值
                mShadowBuffers[0] = xPos;
                mShadowBuffers[2] = xPos;
                mShadowBuffers[4] = xPos;
                mShadowBuffers[6] = xPos;
                mShadowBuffers[1] = underEdge * phaseY;
                mShadowBuffers[3] = nextQuarter * phaseY;
                mShadowBuffers[5] = upperFourthQuarter * phaseY;
                mShadowBuffers[7] = upperEdge * phaseY;
                trans.pointValuesToPixel(this.mShadowBuffers);
                mRenderPaint.setColor(dataSet.getShadowColor());
                mRenderPaint.setStyle(Paint.Style.STROKE);
                mRenderPaint.setStrokeWidth(dataSet.getShadowWidth());
                //画上下边缘线
                canvas.drawLines(this.mShadowBuffers, this.mRenderPaint);
                mBodyBuffers[0] = xPos - 0.5F + barSpace;
                mBodyBuffers[1] = nextQuarter * phaseY;
                mBodyBuffers[2] = xPos + 0.5F - barSpace;
                mBodyBuffers[3] = upperFourthQuarter * phaseY;
                trans.pointValuesToPixel(mBodyBuffers);
                mRenderPaint.setStyle(Paint.Style.STROKE);
                mRenderPaint.setColor(dataSet.getBoxColor());
                //画中间的箱子
                canvas.drawRect(mBodyBuffers[0], mBodyBuffers[3], mBodyBuffers[2], mBodyBuffers[1], mRenderPaint);
                mMedianBuffers[0] = xPos - 0.5F + barSpace;
                mMedianBuffers[1] = median * phaseY;
                mMedianBuffers[2] = xPos + 0.5F - barSpace;
                mMedianBuffers[3] = median * phaseY;
                trans.pointValuesToPixel(mMedianBuffers);
                mRenderPaint.setStrokeWidth(dataSet.getMedianLineWidth());
                mRenderPaint.setColor(dataSet.getMedianLineColor());
                //画中位数线
                canvas.drawLines(mMedianBuffers, mRenderPaint);
                //绘制上下限
                mLimitBuffers[0] = xPos - 0.5F + barSpace;
                mLimitBuffers[1] = upperEdge * phaseY;
                mLimitBuffers[2] = xPos + 0.5F - barSpace;
                mLimitBuffers[3] = upperEdge * phaseY;
                mLimitBuffers[4] = xPos - 0.5F + barSpace;
                mLimitBuffers[5] = underEdge * phaseY;
                mLimitBuffers[6] = xPos + 0.5F - barSpace;
                mLimitBuffers[7] = underEdge * phaseY;
                trans.pointValuesToPixel(mLimitBuffers);
                mRenderPaint.setStrokeWidth(dataSet.getLimitLineWidth());
                mRenderPaint.setColor(dataSet.getLimitLineColor());
                canvas.drawLines(mLimitBuffers, mRenderPaint);
                //绘制异常值
                if (abnormalDates != null && abnormalDates.size() > 0) {
                    mAbnormalBuffers = new float[abnormalDates.size() * 2];
                    for (int i = 0; i < mAbnormalBuffers.length; i += 2) {
                        mAbnormalBuffers[i] = xPos;
                        mAbnormalBuffers[i + 1] = abnormalDates.get(i / 2);
                    }
                    trans.pointValuesToPixel(mAbnormalBuffers);
                    mRenderPaint.setStyle(dataSet.getAbnormalCircleStyle());
                    mRenderPaint.setColor(dataSet.getAbnormalCircleColor());
                    for (int i = 0; i < mAbnormalBuffers.length; i += 2) {
                        canvas.drawCircle(mAbnormalBuffers[i], mAbnormalBuffers[i + 1], dataSet.getAbnormalCircleRadius(), mRenderPaint);
                    }
                }
            }
        }

    }

    @Override
    public void drawValues(Canvas canvas) {

    }

    @Override
    public void drawExtras(Canvas canvas) {

    }

    @Override
    public void drawHighlighted(Canvas canvas, Highlight[] highlights) {
        BoxData boxData = this.mBoxDataProvider.getBoxData();
        Highlight[] var4 = highlights;
        int var5 = highlights.length;
        for (int var6 = 0; var6 < var5; ++var6) {
            Highlight high = var4[var6];
            IBoxDataSet set = (IBoxDataSet) boxData.getDataSetByIndex(high.getDataSetIndex());
            Transformer transformer = mBoxDataProvider.getTransformer(set.getAxisDependency());
            if (set != null && set.isHighlightEnabled()) {
                BoxEntry e = (BoxEntry) set.getEntryForXValue(high.getX(), high.getY());
                if (this.isInBoundsX(e, set)) {
                    MPPointD markerViewPix = transformer.getPixelForValues(e.getX() + (1 - 2 * barSpace) * 0.5f, (e.getmUpperFourthQuarter() + e.getmNextQuarter()) * 0.5f);
                    MPPointD highLightPix = transformer.getPixelForValues(e.getX(), Float.NaN);
                    mBoxDataProvider.setBoxWidth((float) ((markerViewPix.x - highLightPix.x) * 2));
                    high.setDraw((float) markerViewPix.x, (float) markerViewPix.y);
                    this.drawHighlightLines(canvas, (float) highLightPix.x, Float.NaN, set);
                }
            }
        }
    }
}
