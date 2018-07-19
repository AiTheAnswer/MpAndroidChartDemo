package com.allen.mpandroidchartdemo.customerView;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import com.allen.mpandroidchartdemo.R;
import com.allen.mpandroidchartdemo.date.Util;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;

import org.w3c.dom.Text;

/**
 * Created by Allen on 2017/8/10.
 */

public class MyMarkerView extends MarkerView {
    private TextView mTime;
    private TextView mValue;

    public MyMarkerView(Context context, int layoutResource) {
        super(context, layoutResource);
        mTime = (TextView) findViewById(R.id.tv_marker_time);
        mValue = (TextView) findViewById(R.id.tv_marker_value);
    }

    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        String[] year = Util.getYear();
        mTime.setText(year[(int) e.getX() % year.length]);
        mValue.setText("集客力：" +  e.getY());
        super.refreshContent(e, highlight);
    }

    @Override
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2),-getHeight());
    }

}
