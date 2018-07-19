package com.allen.mpandroidchartdemo.chartActivity;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.allen.mpandroidchartdemo.R;
import com.allen.mpandroidchartdemo.customerView.MyMarkerView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StepActivity extends AppCompatActivity {

    @BindView(R.id.step_line_chart)
    LineChart stepLineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);
        ButterKnife.bind(this);
        initChart();
        initLineDate();
    }

    private void initChart() {
        //初始化图例
        Description description = new Description();
        description.setText("0-1 图");
        description.setTextSize(20);
        stepLineChart.setDescription(description);
        stepLineChart.getDescription().setEnabled(false);
        //初始化
        stepLineChart.setDrawGridBackground(false);//chart 绘图区后面的背景矩形将绘制
        stepLineChart.setDrawBorders(false);//禁止绘制图表边框的线
        stepLineChart.setBorderColor(Color.RED); //设置 chart 边框线的颜色。
        stepLineChart.setBorderWidth(2); //设置 chart 边界线的宽度，单位 dp。
        stepLineChart.setPinchZoom(false);
        stepLineChart.setScaleYEnabled(true);
        stepLineChart.setHardwareAccelerationEnabled(false);
        MyMarkerView markerView = new MyMarkerView(this, R.layout.marker_view);
        markerView.setChartView(stepLineChart);
        stepLineChart.setMarker(markerView);

        //设置X轴
        XAxis xAxis = stepLineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//设置x轴的位置
        // xAxis.setLabelCount(6,false);//设置初始化是底部的标签的个数
        xAxis.setAvoidFirstLastClipping(true);
        xAxis.setAxisLineWidth(1);//设置x轴线的宽度
        xAxis.setAxisLineColor(Color.BLACK );//设置x轴线的颜色
        xAxis.setDrawGridLines(false);//设置是否绘制和x轴垂直的竖线
        xAxis.setDrawAxisLine(true);//设置是否绘制x轴
        xAxis.setLabelRotationAngle(-20);//设置x轴的标签旋转的角度
        xAxis.setAxisMinimum(0f);//设置x轴的最小值
        xAxis.setGranularity(1f);//设置x轴的跨度
        xAxis.setAvoidFirstLastClipping(false);//图表将避免第一个和最后一个标签条目被减掉在图表或屏幕的边缘

        //设置右边的y轴
        YAxis axisRight = stepLineChart.getAxisRight();
        axisRight.setDrawGridLines(false);
        axisRight.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float v, AxisBase axisBase) {
                return null;
            }
        });
        axisRight.setEnabled(false);
        //设置左边的y轴
        YAxis axisLeft = stepLineChart.getAxisLeft();
        axisLeft.setDrawGridLines(false);
        axisLeft.setAxisLineWidth(1);
        axisLeft.setAxisLineColor(Color.BLACK);
        axisLeft.setAxisMinimum(0);
        axisLeft.setAxisMaximum(1.5f);
        axisLeft.setGranularity(1);
    }

    private void initLineDate() {
        ArrayList date1 = new ArrayList<>();
        //Entry 坐标点对象  构造函数 第一个参数为x点坐标 第二个为y点
        date1.add(new Entry(0, 1));
        date1.add(new Entry(1, 1));
        date1.add(new Entry(2, 1));
        date1.add(new Entry(3, 1));
        date1.add(new Entry(4, 0));
        date1.add(new Entry(5, 1));
        date1.add(new Entry(6, 1));
        date1.add(new Entry(7, 1));
        date1.add(new Entry(8, 0));
        date1.add(new Entry(9, 0));
        date1.add(new Entry(10, 1));
        date1.add(new Entry(11, 1));
        date1.add(new Entry(12, 0));
        date1.add(new Entry(13, 1));
        date1.add(new Entry(14, 1));
        date1.add(new Entry(15, 1));
        date1.add(new Entry(16, 0));
        date1.add(new Entry(17, 1));
        date1.add(new Entry(18, 1));
       /* date1.add(new Entry(12, 65));
        date1.add(new Entry(13, 90));
        date1.add(new Entry(14, 30));
        date1.add(new Entry(15, 70));
        date1.add(new Entry(16, 50));
        date1.add(new Entry(17, 32));*/
        LineDataSet set1;
        //判断图表中原来是否有数据
        if (stepLineChart.getData() != null &&
                stepLineChart.getData().getDataSetCount() > 0) {
            //获取数据1
            set1 = (LineDataSet) stepLineChart.getData().getDataSetByIndex(0);
            set1.setValues(date1);
            //刷新数据
            stepLineChart.getData().notifyDataChanged();
            stepLineChart.notifyDataSetChanged();
        } else {
            //设置数据1  参数1：数据源 参数2：图例名称
            set1 = new LineDataSet(date1, "测试数据1");
            set1.setColor(Color.parseColor("#89c4ff"));
            set1.setCircleColor(Color.parseColor("#89c4ff"));
            set1.setLineWidth(1f);//设置线宽
            set1.setCircleRadius(2.5f);//设置焦点圆心的大小
            set1.setDrawCircleHole(true);
            set1.setFormLineWidth(0);
            set1.enableDashedHighlightLine(10f, 5f, 0f);//点击后的高亮线的显示样式
            set1.setHighlightLineWidth(2f);//设置点击交点后显示高亮线宽
            set1.setHighlightEnabled(true);//是否禁用点击高亮线
            set1.setHighLightColor(Color.RED);//设置点击交点后显示交高亮线的颜色
            set1.setValueTextSize(0f);//设置显示值的文字大小
            set1.setDrawFilled(false);//设置禁用范围背景填充
            set1.setFormLineWidth(6f);
            set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
            set1.setFormSize(10.f);
            set1.setMode(LineDataSet.Mode.STEPPED);

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
            //创建LineData对象 属于LineChart折线图的数据集合
            LineData data = new LineData(dataSets);
            // 添加到图表中
            stepLineChart.setData(data);

            stepLineChart.setVisibleXRangeMaximum(12);//设置显示数据的条数，需要在设置数据后生效

            //绘制图表
            stepLineChart.invalidate();
        }
    }
}
