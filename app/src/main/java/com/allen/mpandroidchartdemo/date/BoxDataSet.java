package com.allen.mpandroidchartdemo.date;

import android.graphics.Color;
import android.graphics.Paint;

import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.LineScatterCandleRadarDataSet;
import com.github.mikephil.charting.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Allen on 2017/12/5.
 */

public class BoxDataSet extends LineScatterCandleRadarDataSet<BoxEntry> implements IBoxDataSet {

    private float mBarSpace = 0.1F; //箱子左右两边的间隔
    private float mShadowWidth = Utils.convertDpToPixel(1);//边缘线的宽度
    private int mShadowColor = Color.RED;//边缘线的颜色
    private int mBoxColor = Color.RED;//箱子的颜色
    private float mMedianLineWidth = Utils.convertDpToPixel(3);//中位数线的宽度
    private int mMedianLineColor = Color.RED;//中位数线的颜色
    private float mLimitLineWidth = Utils.convertDpToPixel(1);//上下限线的宽度
    private int mLimitLineColor = Color.RED;//上下限的颜色
    private float mAbnormalCircleRadius = Utils.convertDpToPixel(3);//异常值圆的半径
    private int mAbnormalCircleColor = Color.RED;//异常值圆的颜色
    private Paint.Style mAbnormalCircleStyle = Paint.Style.FILL;//异常值圆的样式

    public BoxDataSet(List<BoxEntry> yVals, String label) {

        super(yVals, label);
    }

    @Override
    public DataSet<BoxEntry> copy() {
        ArrayList yVals = new ArrayList();
        yVals.clear();

        for (int copied = 0; copied < this.mValues.size(); ++copied) {
            yVals.add(((BoxEntry) this.mValues.get(copied)).copy());
        }

        BoxDataSet var3 = new BoxDataSet(yVals, this.getLabel());
        var3.mColors = this.mColors;
        var3.mShadowWidth = this.mShadowWidth;
        var3.mBarSpace = this.mBarSpace;
        var3.mHighLightColor = this.mHighLightColor;
        var3.mShadowColor = this.mShadowColor;
        return var3;
    }

    protected void calcMinMax(BoxEntry e) {
        if (e.getmLowerLimit() < this.mYMin) {
            this.mYMin = e.getmLowerLimit();
        }

        if (e.getmCapped() > this.mYMax) {
            this.mYMax = e.getmCapped();
        }

        this.calcMinMaxX(e);
    }

    protected void calcMinMaxY(BoxEntry e) {
        if (e.getmCapped() < this.mYMin) {
            this.mYMin = e.getmCapped();
        }

        if (e.getmCapped() > this.mYMax) {
            this.mYMax = e.getmCapped();
        }

        if (e.getmLowerLimit() < this.mYMin) {
            this.mYMin = e.getmLowerLimit();
        }

        if (e.getmLowerLimit() > this.mYMax) {
            this.mYMax = e.getmLowerLimit();
        }

    }

    public void setmBarSpace(float space) {
        if (space < 0.0F) {
            space = 0.0F;
        }

        if (space > 0.45F) {
            space = 0.45F;
        }

        this.mBarSpace = space;
    }

    public void setmShadowWidth(float width) {
        this.mShadowWidth = Utils.convertDpToPixel(width);
    }

    public void setmShadowColor(int mShadowColor) {
        this.mShadowColor = mShadowColor;
    }

    public void setmBoxColor(int mBoxColor) {
        this.mBoxColor = mBoxColor;
    }

    public void setmMedianLineWidth(float width) {
        this.mMedianLineWidth = Utils.convertDpToPixel(width);
    }

    public void setmMedianLineColor(int mMedianLineColor) {
        this.mMedianLineColor = mMedianLineColor;
    }

    public void setmLimitLineWidth(float width) {
        this.mLimitLineWidth = Utils.convertDpToPixel(width);
    }

    public void setmLimitLineColor(int mLimitLineColor) {
        this.mLimitLineColor = mLimitLineColor;
    }

    public void setmAbnormalCircleRadius(float radius) {
        this.mAbnormalCircleRadius = Utils.convertDpToPixel(radius);
    }

    public void setmAbnormalCircleColor(int mAbnormalCircleColor) {
        this.mAbnormalCircleColor = mAbnormalCircleColor;
    }

    public void setmAbnormalCircleStyle(Paint.Style mAbnormalCircleStyle) {
        this.mAbnormalCircleStyle = mAbnormalCircleStyle;
    }

    @Override
    public float getBarSpace() {
        return mBarSpace;
    }

    @Override
    public float getShadowWidth() {
        return mShadowWidth;
    }

    @Override
    public int getShadowColor() {
        return mShadowColor;
    }

    @Override
    public int getBoxColor() {
        return mBoxColor;
    }

    @Override
    public float getMedianLineWidth() {
        return mMedianLineWidth;
    }

    @Override
    public int getMedianLineColor() {
        return mMedianLineColor;
    }

    @Override
    public float getLimitLineWidth() {
        return mLimitLineWidth;
    }

    @Override
    public int getLimitLineColor() {
        return mLimitLineColor;
    }

    @Override
    public int getAbnormalCircleColor() {
        return mAbnormalCircleColor;
    }

    @Override
    public float getAbnormalCircleRadius() {
        return mAbnormalCircleRadius;
    }

    @Override
    public Paint.Style getAbnormalCircleStyle() {
        return mAbnormalCircleStyle;
    }


}
