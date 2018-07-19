package com.allen.mpandroidchartdemo.chartActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.allen.mpandroidchartdemo.R;
import com.allen.mpandroidchartdemo.customerView.BoxChart;
import com.allen.mpandroidchartdemo.customerView.BoxMarkerView;
import com.allen.mpandroidchartdemo.date.BoxData;
import com.allen.mpandroidchartdemo.date.BoxDataSet;
import com.allen.mpandroidchartdemo.date.BoxEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BoxChartActivity extends AppCompatActivity {

    @BindView(R.id.box_chart)
    BoxChart boxChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box_chart);
        ButterKnife.bind(this);
        initBoxChart();
        initData();

    }

    private void initBoxChart() {
        boxChart.getDescription().setEnabled(false);
        boxChart.setDrawGridBackground(false);
        boxChart.setDrawBorders(false);
        boxChart.setPinchZoom(false);
        boxChart.setScaleEnabled(true);
        XAxis xAxis = boxChart.getXAxis();
        xAxis.setGranularity(1f);//设置x轴的跨度
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        YAxis axisRight = boxChart.getAxisRight();
        axisRight.setEnabled(false);
        YAxis axisLeft = boxChart.getAxisLeft();
        axisLeft.setDrawGridLines(false);
        BoxMarkerView markerView = new BoxMarkerView(this);
        markerView.setChartView(boxChart);
        boxChart.setMarker(markerView);
        boxChart.getLegend().setEnabled(false);

    }

    private void initData() {

        List<BoxEntry> yVals = new ArrayList<>();
        ArrayList<Float> abnormalDates = new ArrayList<>();
        abnormalDates.add(320f);
        abnormalDates.add(260f);
        yVals.add(new BoxEntry(0, 332f, 312f, 300f, 290f, 288f, 270f, 260f, abnormalDates));
        ArrayList<Float> abnormalDates1 = new ArrayList<>();
        abnormalDates1.add(325f);
        abnormalDates1.add(270f);
        yVals.add(new BoxEntry(1, 350f, 320f, 315f, 300f, 292f, 280f, 270f, abnormalDates1));
        yVals.add(new BoxEntry(2, 300f, 290f, 275f, 260f, 250f, 235f, 220f, null));
        ArrayList<Float> abnormalDates2 = new ArrayList<>();
        abnormalDates2.add(325f);
        abnormalDates2.add(270f);
        yVals.add(new BoxEntry(3, 342f, 322f, 310f, 300f, 298f, 280f, 270f, abnormalDates2));
        ArrayList<Float> abnormalDates3 = new ArrayList<>();
        abnormalDates3.add(315f);
        abnormalDates3.add(240f);
        yVals.add(new BoxEntry(4, 320f, 309f, 300f, 280f, 265f, 255f, 240f, abnormalDates3));
        yVals.add(new BoxEntry(5, 360f, 330f, 320f, 300f, 288f, 270f, 260f, null));
        yVals.add(new BoxEntry(6, 332f, 312f, 300f, 290f, 288f, 270f, 260f, null));
        yVals.add(new BoxEntry(7, 350f, 320f, 315f, 300f, 292f, 280f, 270f, null));
        yVals.add(new BoxEntry(8, 300f, 290f, 275f, 260f, 250f, 235f, 220f, null));
        yVals.add(new BoxEntry(9, 342f, 322f, 310f, 300f, 298f, 280f, 270f, null));
        yVals.add(new BoxEntry(10, 320f, 309f, 300f, 280f, 265f, 255f, 240f, null));
        yVals.add(new BoxEntry(11, 360f, 330f, 320f, 300f, 288f, 270f, 260f, null));
        yVals.add(new BoxEntry(12, 360f, 355f, 350f, 345f, 340f, 280f, 250f, null));
        yVals.add(new BoxEntry(13, 290f, 280f, 240f, 230f, 223f, 221f, 220f, null));
        BoxDataSet boxDataSet = new BoxDataSet(yVals, "");
        boxDataSet.setmBarSpace(0.3f);
        boxDataSet.setHighlightEnabled(true);
        boxDataSet.setHighLightColor(getResources().getColor(R.color.red));
        BoxData boxData = new BoxData(boxDataSet);
        boxChart.setData(boxData);
        boxChart.setVisibleXRangeMaximum(6);
    }
}
