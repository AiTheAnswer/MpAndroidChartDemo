package com.allen.mpandroidchartdemo.chartActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.allen.mpandroidchartdemo.R;
import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 蜡烛图
 */
public class CandleStickChartActivity extends AppCompatActivity {

    @BindView(R.id.candle_stick_chart)
    CandleStickChart mCandlChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candle_stick_chart);
        ButterKnife.bind(this);
        //不设置描述
        mCandlChart.getDescription().setEnabled(false);
        List<ICandleDataSet> dataSets = new ArrayList<>();
        List<CandleEntry> yVals = new ArrayList<>();
       // yVals.add(new CandleEntry())
        CandleDataSet dataSet = new CandleDataSet(yVals, "Demo");
        dataSets.add(dataSet);
        CandleData data = new CandleData(dataSets);
        mCandlChart.setData(data);
    }
}
