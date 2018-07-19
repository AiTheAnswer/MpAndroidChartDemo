package com.allen.mpandroidchartdemo.customerView;

import android.content.Context;
import android.widget.TextView;

import com.allen.mpandroidchartdemo.R;
import com.allen.mpandroidchartdemo.date.BoxEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;

/**
 * Created by Allen on 2017/12/5.
 */

public class BoxMarkerView extends BoxChartMarkerView {
    //上边缘
    private TextView mTxtUpperEdge;
    //上四分位数
    private TextView mTxtUpperFourthQuarter;
    //中位数
    private TextView mTxtMedian;
    //下四分位数
    private TextView mTxtNextQuarter;
    //下边缘
    private TextView mTxtUnderEdge;

    public BoxMarkerView(Context context) {
        super(context, R.layout.box_chart_marker_view);
        mTxtUpperEdge = (TextView) findViewById(R.id.tv_marker_upper_edge);
        mTxtUpperFourthQuarter = (TextView) findViewById(R.id.tv_marker_upper_fourth_quarter);
        mTxtMedian = (TextView) findViewById(R.id.tv_marker_median);
        mTxtNextQuarter = (TextView) findViewById(R.id.tv_marker_next_quarter);
        mTxtUnderEdge = (TextView) findViewById(R.id.tv_marker_under_edge);
    }

    @Override
    public void refreshContent(Entry entry, Highlight highlight) {
        BoxEntry boxEntry = (BoxEntry) entry;
        mTxtUpperEdge.setText("上边缘 : " + boxEntry.getmUpperEdge());
        mTxtUpperFourthQuarter.setText("上四分位数 : " + boxEntry.getmUpperFourthQuarter());
        mTxtMedian.setText("中位数 : " + boxEntry.getmMedian());
        mTxtNextQuarter.setText("下四分位数 : " + boxEntry.getmNextQuarter());
        mTxtUnderEdge.setText("下边缘 : " + boxEntry.getmUnderEdge());
        super.refreshContent(entry, highlight);
    }

    @Override
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2), -getHeight());
    }

}
