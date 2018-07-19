package com.allen.mpandroidchartdemo.chartActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.allen.mpandroidchartdemo.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BarActivity extends AppCompatActivity {

    @BindView(R.id.bar_chart)
    BarChart mBarChart;
    private ArrayList<BarEntry> mBarEntries = new ArrayList<>();
    private ArrayList<BarEntry> mBarEntries2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);
        ButterKnife.bind(this);
        initDate();
        initBarChart();
        setBarChartDate();


    }

    private void initDate() {
        mBarEntries.add(new BarEntry(0, 15));
        mBarEntries.add(new BarEntry(1, 26));
        mBarEntries.add(new BarEntry(2, 12));
        mBarEntries.add(new BarEntry(3, 9));
        mBarEntries.add(new BarEntry(4, 20));
        mBarEntries.add(new BarEntry(5, 15));
        mBarEntries.add(new BarEntry(6, 600));

        mBarEntries2.add(new BarEntry(6, 15));
        mBarEntries2.add(new BarEntry(5, 35));
        mBarEntries2.add(new BarEntry(4, 25));
        mBarEntries2.add(new BarEntry(3, 40));
        mBarEntries2.add(new BarEntry(2, 10));
        mBarEntries2.add(new BarEntry(1, 50));
        mBarEntries2.add(new BarEntry(0, 30));

    }

    private void setBarChartDate() {
        BarDataSet dataSet = new BarDataSet(mBarEntries, "XXXXX1");
        dataSet.setDrawValues(true);
        dataSet.setHighlightEnabled(true);
        dataSet.setHighLightColor(getResources().getColor(R.color.colorPrimary));
        dataSet.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float v, Entry entry, int i, ViewPortHandler viewPortHandler) {
                return v + "$";
            }
        });
        dataSet.setColor(getResources().getColor(R.color.transparent));
        dataSet.setBarBorderWidth(1);
        dataSet.setBarBorderColor(getResources().getColor(R.color.colorPrimary));
        BarDataSet dataSet2 = new BarDataSet(mBarEntries2, "XXXXX2");
        dataSet2.setDrawValues(true);
        dataSet2.setHighlightEnabled(true);
        dataSet2.setHighLightColor(Color.RED);
        dataSet2.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float v, Entry entry, int i, ViewPortHandler viewPortHandler) {
                return v + "$";
            }
        });
        dataSet2.setColor(Color.rgb(60, 45, 98));
        List<IBarDataSet> setList = new ArrayList<>();
        setList.add(dataSet);
        setList.add(dataSet2);
        BarData barData = new BarData(setList);
        barData.setBarWidth(0.5f);
        mBarChart.setData(barData);
        mBarChart.invalidate();
    }

    private void initBarChart() {
        //基本设置
        mBarChart.setPinchZoom(false);
        mBarChart.setScaleEnabled(false);
        mBarChart.setScaleXEnabled(true);
        mBarChart.setDrawBorders(false);
        mBarChart.setDrawBorders(false);
        mBarChart.getDescription().setEnabled(false);
        //x轴设置
        XAxis xAxis = mBarChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisLineWidth(1);
        xAxis.setAxisLineColor(Color.GREEN);
        xAxis.setTextSize(8);
        xAxis.setTextColor(Color.GREEN);
        xAxis.setAvoidFirstLastClipping(true);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float v, AxisBase axisBase) {
                int x = (int) v;
                String str = "周一";
                switch (x) {
                    case 0:
                        str = "周一";
                        break;
                    case 1:
                        str = "周二";
                        break;
                    case 2:
                        str = "周三";
                        break;
                    case 3:
                        str = "周四";
                        break;
                    case 4:
                        str = "周五";
                        break;
                    case 5:
                        str = "周六";
                        break;
                    case 6:
                        str = "周日";
                        break;


                }
                return str;
            }
        });
        //右边y轴设置
        YAxis axisRight = mBarChart.getAxisRight();
        axisRight.setEnabled(false);
        //左边y轴的设置
        YAxis axisLeft = mBarChart.getAxisLeft();
        axisLeft.setDrawGridLines(false);
        axisLeft.setAxisMinimum(0);
        axisLeft.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        axisLeft.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float v, AxisBase axisBase) {
                return v + "$";
            }
        });
    }
}
