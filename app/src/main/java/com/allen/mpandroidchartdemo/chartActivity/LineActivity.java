package com.allen.mpandroidchartdemo.chartActivity;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

import com.allen.mpandroidchartdemo.customerView.MyMarkerView;
import com.allen.mpandroidchartdemo.R;
import com.allen.mpandroidchartdemo.date.Util;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.LargeValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.utils.Utils;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LineActivity extends AppCompatActivity {
    private Description description;

    @BindView(R.id.line_chart)
    LineChart lineChart;

    private List<Entry> date1;
    private List<Entry> date2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_line);
        ButterKnife.bind(this);
        initDescription();
        initLineChart();
        initListener();
        initLineChartDate();


    }

    private void initListener() {
        lineChart.setOnChartGestureListener(new OnChartGestureListener() {
            @Override
            public void onChartGestureStart(MotionEvent motionEvent, ChartTouchListener.ChartGesture chartGesture) {

            }

            @Override
            public void onChartGestureEnd(MotionEvent motionEvent, ChartTouchListener.ChartGesture chartGesture) {

            }

            @Override
            public void onChartLongPressed(MotionEvent motionEvent) {

            }

            @Override
            public void onChartDoubleTapped(MotionEvent motionEvent) {
                LineActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }

            @Override
            public void onChartSingleTapped(MotionEvent motionEvent) {

            }

            @Override
            public void onChartFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {

            }

            @Override
            public void onChartScale(MotionEvent motionEvent, float v, float v1) {

            }

            @Override
            public void onChartTranslate(MotionEvent motionEvent, float v, float v1) {

            }
        });
    }

    private void initLineChart() {
        //设置图表描述信息
        lineChart.setDescription(description);
        //设置没有数据显示的文字
        lineChart.setNoDataText("暂时没有数据");
        //设置没有数据时文字的颜色
        lineChart.setNoDataTextColor(Color.GREEN);
        //设置无数据文字的字体
        //lineChart.setNoDataTextTypeface(tf);
        lineChart.setDrawGridBackground(false);//chart 绘图区后面的背景矩形将绘制
        lineChart.setDrawBorders(false);//禁止绘制图表边框的线
        lineChart.setBorderColor(Color.RED); //设置 chart 边框线的颜色。
        lineChart.setBorderWidth(2); //设置 chart 边界线的宽度，单位 dp。
        lineChart.setPinchZoom(false);
        lineChart.setScaleEnabled(true);
        lineChart.setHardwareAccelerationEnabled(false);
        MyMarkerView markerView = new MyMarkerView(this, R.layout.marker_view);
        markerView.setChartView(lineChart);
        lineChart.setMarker(markerView);
        //lineChart.setLogEnabled(true);//打印日志
        //lineChart.notifyDataSetChanged();//刷新数据
        //lineChart.invalidate();//重绘
        //设置X轴
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//设置x轴的位置
        // xAxis.setLabelCount(6,false);//设置初始化是底部的标签的个数
        xAxis.setAvoidFirstLastClipping(true);
        xAxis.setAxisLineWidth(3);//设置x轴线的宽度
        xAxis.setAxisLineColor(Color.RED);//设置x轴线的颜色
        xAxis.setDrawGridLines(false);//设置是否绘制和x轴垂直的竖线
        xAxis.setDrawAxisLine(true);//设置是否绘制x轴
        xAxis.setLabelRotationAngle(-20);//设置x轴的标签旋转的角度
        xAxis.setAxisMinimum(0f);//设置x轴的最小值
        xAxis.setGranularity(1f);//设置x轴的跨度
        xAxis.setAvoidFirstLastClipping(false);//图表将避免第一个和最后一个标签条目被减掉在图表或屏幕的边缘

        //将x轴的值进行格式化
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float v, AxisBase axisBase) {
                String[] year = Util.getYear();
                return year[(int) v % year.length];
            }
        });
        //设置右边的y轴
        YAxis axisRight = lineChart.getAxisRight();
        axisRight.setDrawGridLines(false);
        axisRight.setEnabled(false);
        //设置左边的y轴
        YAxis axisLeft = lineChart.getAxisLeft();
        axisLeft.setDrawGridLines(false);
        axisLeft.setValueFormatter(new LargeValueFormatter());

        axisLeft.setAxisMinimum(0);
    }

    private void initLineChartDate() {
        date1 = new ArrayList<>();
        //Entry 坐标点对象  构造函数 第一个参数为x点坐标 第二个为y点
        date1.add(new Entry(0, 0.04f));
        date1.add(new Entry(1, 0.04f));
        date1.add(new Entry(2, 0.04f));
        date1.add(new Entry(3,  0.04f));
        date1.add(new Entry(4, 0.04f));
        date1.add(new Entry(5, 0.05f));
        date1.add(new Entry(6,  0.04f));
        date1.add(new Entry(7, 0.04f));
        date1.add(new Entry(8, 0.04f));
        date1.add(new Entry(9, 0.04f));
        date1.add(new Entry(10, 0.04f));
        date1.add(new Entry(11, 0.04f));
        date2 = new ArrayList<>();
        //Entry 坐标点对象  构造函数 第一个参数为x点坐标 第二个为y点
        date2.add(new Entry(0, 0.04f));
        date2.add(new Entry(1, 0.04f));
        date2.add(new Entry(2, 0.04f));
        date2.add(new Entry(3,  0.04f));
        date2.add(new Entry(4, 0.04f));
        date2.add(new Entry(5, 0.05f));
        date2.add(new Entry(6,  0.04f));
        date2.add(new Entry(7, 0.04f));
        date2.add(new Entry(8, 0.04f));
        date2.add(new Entry(9, 0.04f));
        date2.add(new Entry(10, 0.04f));
        date2.add(new Entry(11, 0.04f));
       /* date1.add(new Entry(12, 65));
        date1.add(new Entry(13, 90));
        date1.add(new Entry(14, 30));
        date1.add(new Entry(15, 70));
        date1.add(new Entry(16, 50));
        date1.add(new Entry(17, 32));*/
        LineDataSet set1;
        //判断图表中原来是否有数据
        if (lineChart.getData() != null &&
                lineChart.getData().getDataSetCount() > 0) {
            //获取数据1
            set1 = (LineDataSet) lineChart.getData().getDataSetByIndex(0);
            set1.setValues(date1);
            //刷新数据
            lineChart.getData().notifyDataChanged();
            lineChart.notifyDataSetChanged();
        } else {
            //设置数据1  参数1：数据源 参数2：图例名称
            set1 = new LineDataSet(date1, "测试数据1");
            set1.setColor(Color.BLACK);
            set1.setCircleColor(Color.BLACK);
            set1.setLineWidth(1f);//设置线宽
            set1.setCircleRadius(3f);//设置焦点圆心的大小
            set1.setDrawCircleHole(false);
            set1.setFormLineWidth(0);
            set1.enableDashedHighlightLine(10f, 5f, 0f);//点击后的高亮线的显示样式
            set1.setHighlightLineWidth(2f);//设置点击交点后显示高亮线宽
            set1.setHighlightEnabled(true);//是否禁用点击高亮线
            set1.setHighLightColor(Color.RED);//设置点击交点后显示交高亮线的颜色
            set1.setValueTextSize(0f);//设置显示值的文字大小
            set1.setDrawFilled(true);//设置禁用范围背景填充
            set1.setFormLineWidth(6f);
            set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
            set1.setFormSize(10.f);
            set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);

            if (Utils.getSDKInt() >= 18) {
                // fill drawable only supported on api level 18 and above
                Drawable drawable = ContextCompat.getDrawable(this, R.drawable.fade_red);
                set1.setFillDrawable(drawable);//设置范围背景填充
            } else {
                set1.setFillColor(Color.BLACK);
            }
            set1.setFillColor(Color.BLACK);
            //保存LineDataSet集合
            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1); // add the datasets
            dataSets.add(set1); // add the datasets
            //创建LineData对象 属于LineChart折线图的数据集合
            LineData data = new LineData(dataSets);
            // 添加到图表中
            lineChart.setData(data);

            lineChart.setVisibleXRangeMaximum(6);//设置显示数据的条数，需要在设置数据后生效

            //绘制图表
            lineChart.invalidate();
        }
    }

    /**
     * 初始化描述信息
     */
    private void initDescription() {
        description = new Description();
        description.setText("测试图表");
        description.setTextColor(Color.BLUE);
        description.setTextSize(20);
        //设置描述图表文字的文本对齐方式
        description.setTextAlign(Paint.Align.RIGHT);
        description.setEnabled(false);

    }
}
