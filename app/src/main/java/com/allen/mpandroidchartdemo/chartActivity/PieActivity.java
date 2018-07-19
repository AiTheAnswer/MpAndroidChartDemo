package com.allen.mpandroidchartdemo.chartActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.allen.mpandroidchartdemo.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PieActivity extends AppCompatActivity {

    @BindView(R.id.pie_chart)
    PieChart mPieChart;
    private List<PieEntry> pieEntrys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie);
        ButterKnife.bind(this);
        initDate();
        initPieChart();
        initPieChartDate();
    }

    private void initPieChartDate() {
        PieDataSet dataSet = new PieDataSet(pieEntrys, "");
        dataSet.setDrawValues(true);
        dataSet.setHighlightEnabled(true);
        dataSet.setColors(Color.GRAY, Color.BLUE, Color.GREEN);
        dataSet.setValueTextColor(Color.RED);
        dataSet.setValueLineColor(Color.BLACK);
        dataSet.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float v, Entry entry, int i, ViewPortHandler viewPortHandler) {
                String str = "";
                str = (int) (v * 100) + "%";
                return str;
            }
        });
        PieData pieDate = new PieData(dataSet);
        mPieChart.setData(pieDate);
    }

    private void initDate() {
        pieEntrys = new ArrayList<>();
        pieEntrys.add(new PieEntry(0.4f, "男人"));
        pieEntrys.add(new PieEntry(0.4f, "女人"));
        pieEntrys.add(new PieEntry(0.2f, "程序猿"));
    }

    private void initPieChart() {
        mPieChart.getDescription().setEnabled(false);
        //设置中心字的样式
        mPieChart.setCenterText("饼状图");
        mPieChart.setCenterTextColor(Color.RED);
        mPieChart.setDrawCenterText(true);
        //设置padding值
        mPieChart.setExtraOffsets(5, 10, 5, 5);
        //设置中心孔
        mPieChart.setDrawHoleEnabled(true);
        mPieChart.setHoleRadius(20f);
        mPieChart.setHoleColor(Color.WHITE);
        mPieChart.setDrawSlicesUnderHole(true);
        //设置透明圈
        mPieChart.setTransparentCircleColor(Color.RED);
        mPieChart.setTransparentCircleAlpha(110);
        mPieChart.setTransparentCircleRadius(25f);
        //设置是否可以转到
        mPieChart.setRotationEnabled(true);
        mPieChart.setRotationAngle(30);
        //设置转动
        mPieChart.setDragDecelerationEnabled(false);//设置手指转动离开后是否可以立即停止
        mPieChart.setDragDecelerationFrictionCoef(0.6f);//设置手指离开后转到的摩擦系数 0 到1
        //设置点击是否高亮显示
        mPieChart.setHighlightPerTapEnabled(true);
        //
        mPieChart.setDrawEntryLabels(true);
        mPieChart.setEntryLabelColor(Color.BLUE);
    }
}
