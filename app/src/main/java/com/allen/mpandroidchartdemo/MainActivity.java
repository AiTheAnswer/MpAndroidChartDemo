package com.allen.mpandroidchartdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.allen.mpandroidchartdemo.chartActivity.BarActivity;
import com.allen.mpandroidchartdemo.chartActivity.BoxChartActivity;
import com.allen.mpandroidchartdemo.chartActivity.CandleStickChartActivity;
import com.allen.mpandroidchartdemo.chartActivity.HorizontalBarActivity;
import com.allen.mpandroidchartdemo.chartActivity.LineActivity;
import com.allen.mpandroidchartdemo.chartActivity.MuitBarChartActivity;
import com.allen.mpandroidchartdemo.chartActivity.PieActivity;
import com.allen.mpandroidchartdemo.chartActivity.StepActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btn_line)
    Button btnLine;
    @BindView(R.id.btn_bar)
    Button btnBar;
    @BindView(R.id.btn_pie)
    Button btnPie;
    @BindView(R.id.btn_horizontal_bar)
    Button btnHorizontalBar;
    @BindView(R.id.btn_step_line_chart)
    Button btnStepLineChart;
    @BindView(R.id.btn_candle_stick_chart)
    Button btnCandleStickChart;
    @BindView(R.id.btn_box_chart)
    Button btnBoxChart;
    @BindView(R.id.multi_btn_chart)
    Button multiBtnChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initListener();
    }

    private void initListener() {
        btnLine.setOnClickListener(this);
        btnBar.setOnClickListener(this);
        btnPie.setOnClickListener(this);
        btnHorizontalBar.setOnClickListener(this);
        btnStepLineChart.setOnClickListener(this);
        btnCandleStickChart.setOnClickListener(this);
        btnBoxChart.setOnClickListener(this);
        multiBtnChart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_line:
                startActivity(new Intent(MainActivity.this, LineActivity.class));
                break;
            case R.id.btn_bar:
                startActivity(new Intent(MainActivity.this, BarActivity.class));
                break;
            case R.id.btn_pie:
                startActivity(new Intent(MainActivity.this, PieActivity.class));
                break;
            case R.id.btn_horizontal_bar:
                startActivity(new Intent(MainActivity.this, HorizontalBarActivity.class));
                break;
            case R.id.btn_step_line_chart:
                startActivity(new Intent(MainActivity.this, StepActivity.class));
                break;
            case R.id.btn_candle_stick_chart:
                startActivity(new Intent(MainActivity.this, CandleStickChartActivity.class));
                break;
            case R.id.btn_box_chart:
                startActivity(new Intent(MainActivity.this, BoxChartActivity.class));
                break;
            case R.id.multi_btn_chart:
                startActivity(new Intent(MainActivity.this, MuitBarChartActivity.class));
                break;
            default:
                break;
        }
    }
}
