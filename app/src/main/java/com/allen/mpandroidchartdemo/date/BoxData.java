package com.allen.mpandroidchartdemo.date;

import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;

import java.util.List;

/**
 * Created by Allen on 2017/12/5.
 */

public class BoxData extends BarLineScatterCandleBubbleData<IBoxDataSet> {
    public BoxData() {
    }

    public BoxData(IBoxDataSet... dataSets) {
        super(dataSets);
    }

    public BoxData(List<IBoxDataSet> dataSets) {
        super(dataSets);
    }
}
