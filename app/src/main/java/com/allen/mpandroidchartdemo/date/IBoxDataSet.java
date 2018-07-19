package com.allen.mpandroidchartdemo.date;


import android.graphics.Paint;

import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;

/**
 * Created by Allen on 2017/12/5.
 */

public interface IBoxDataSet extends ILineScatterCandleRadarDataSet<BoxEntry> {
    float getBarSpace();//获取箱子左右两边的间隔

    float getShadowWidth();//边缘线的宽度

    int getShadowColor();//边缘线的颜色

    int getBoxColor();//箱子的颜色

    float getMedianLineWidth();//中位数线的宽度

    int getMedianLineColor();//中位数线的颜色

    float getLimitLineWidth();//上下限处线的宽度

    int getLimitLineColor();//上下限处线的颜色

    int getAbnormalCircleColor();//异常值圆的颜色

    float getAbnormalCircleRadius();//异常值圆的半径

    Paint.Style getAbnormalCircleStyle();//异常值圆的样式
}
