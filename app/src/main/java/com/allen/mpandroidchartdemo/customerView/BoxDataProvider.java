package com.allen.mpandroidchartdemo.customerView;


import com.allen.mpandroidchartdemo.date.BoxData;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;

/**
 * Created by Allen on 2017/12/5.
 */

public interface BoxDataProvider extends BarLineScatterCandleBubbleDataProvider {
    BoxData getBoxData();

    float getBoxWidth();

    void setBoxWidth(float boxWidth);
}
