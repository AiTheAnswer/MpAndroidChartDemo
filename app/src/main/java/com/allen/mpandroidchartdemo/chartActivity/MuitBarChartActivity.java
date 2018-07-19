package com.allen.mpandroidchartdemo.chartActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.allen.mpandroidchartdemo.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;

public class MuitBarChartActivity extends AppCompatActivity {

    private BarChart mBarChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muit_bar_chart);
        initView();
        initBarChart();
        initDate();
    }

    private void initBarChart() {
        mBarChart.getDescription().setEnabled(false);
        XAxis xAxis = mBarChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMinimum(0);
        xAxis.setGranularity(1);
        xAxis.setCenterAxisLabels(true);
        YAxis axisLeft = mBarChart.getAxisLeft();
        axisLeft.setDrawGridLines(false);
        axisLeft.setAxisMinimum(0);
        mBarChart.getAxisRight().setEnabled(false);
    }

    private void initDate() {
        ArrayList<IBarDataSet> barDataSets = new ArrayList<>();
        List<BarEntry> yVals0 = new ArrayList<>();
        List<BarEntry> yVals1 = new ArrayList<>();
        List<BarEntry> yVals2 = new ArrayList<>();
        List<BarEntry> yVals3 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            yVals0.add(new BarEntry(i, (float) (Math.random() * 100)));
            yVals1.add(new BarEntry(i, (float) (Math.random() * 100)));
            yVals2.add(new BarEntry(i, (float) (Math.random() * 100)));
            yVals3.add(new BarEntry(i, (float) (Math.random() * 100)));
        }
        BarDataSet barDataSet0 = new BarDataSet(yVals0, "测试数据0");
        barDataSets.add(barDataSet0);
        BarDataSet barDataSet1 = new BarDataSet(yVals1, "测试数据1");
        barDataSets.add(barDataSet1);
        BarDataSet barDataSet2 = new BarDataSet(yVals2, "测试数据2");
        barDataSets.add(barDataSet2);
        BarDataSet barDataSet3 = new BarDataSet(yVals3, "测试数据3");
        barDataSets.add(barDataSet3);
        BarData barData = new BarData(barDataSets);
        mBarChart.setData(barData);
        int groupCount = yVals0.size();
        float groupSpace = 0.08f;
        float barSpace = 0.03f; // x4 DataSet
        float barWidth = 0.2f; // x4 DataSet
        // (0.2 + 0.03) * 4 + 0.08 = 1.00 -> interval per "group"

        mBarChart.getBarData().setBarWidth(barWidth);
        mBarChart.groupBars(0, groupSpace, barSpace);
        mBarChart.getXAxis().setAxisMaximum(0 + groupCount);
        mBarChart.invalidate();
    }

    private void initView() {
        mBarChart = (BarChart) findViewById(R.id.bar_chart_muit);
    }
}
