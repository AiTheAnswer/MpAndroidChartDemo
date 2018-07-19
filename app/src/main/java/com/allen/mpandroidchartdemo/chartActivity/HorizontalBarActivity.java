package com.allen.mpandroidchartdemo.chartActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.allen.mpandroidchartdemo.R;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.XAxis;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HorizontalBarActivity extends AppCompatActivity {

    @BindView(R.id.horizontal_bar)
    HorizontalBarChart mHorizontalBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_bar);
        ButterKnife.bind(this);
        initHorizontalBar();
    }

    private void initHorizontalBar() {
        //1.基本设置(描述、背景和边界、缩放)
        mHorizontalBar.getDescription().setEnabled(false);
        mHorizontalBar.setScaleEnabled(false);
        mHorizontalBar.setPinchZoom(false);
        mHorizontalBar.setScaleYEnabled(true);
        mHorizontalBar.setScaleXEnabled(false);
        mHorizontalBar.setDrawBorders(false);
        mHorizontalBar.setDrawGridBackground(false);
        mHorizontalBar.setDrawValueAboveBar(true);
        //2.设置x轴(位置、间隔、最值、是否绘制线、值的格式化)
        XAxis xAxis = mHorizontalBar.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisLineWidth(2f);
        xAxis.setAxisLineColor(Color.RED);
        xAxis.setDrawAxisLine(true);
        xAxis.setAvoidFirstLastClipping(false);
        xAxis.setLabelRotationAngle(0);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(10f);
        xAxis.setDrawLabels(true);


    }
}
