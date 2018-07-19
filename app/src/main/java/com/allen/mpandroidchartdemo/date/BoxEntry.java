package com.allen.mpandroidchartdemo.date;

import com.github.mikephil.charting.data.Entry;

import java.util.List;

/**
 * Created by Allen on 2017/12/5.
 */

public class BoxEntry extends Entry {
    //上限
    private Float mCapped;
    //上边缘
    private Float mUpperEdge;
    //上四分位数
    private Float mUpperFourthQuarter;
    //中位数
    private Float mMedian;
    //下四分位数
    private Float mNextQuarter;
    //下边缘
    private Float mUnderEdge;
    //下限
    private Float mLowerLimit;
    //异常值
    private List<Float> mAbnormalDates;



    public BoxEntry(int x,Float mCapped, Float mUpperEdge, Float mUpperFourthQuarter, Float mMedian, Float mNextQuarter, Float mUnderEdge, Float mLowerLimit, List<Float> mAbnormalDates) {
        super(x,mMedian);
        this.mCapped = mCapped;
        this.mUpperEdge = mUpperEdge;
        this.mUpperFourthQuarter = mUpperFourthQuarter;
        this.mMedian = mMedian;
        this.mNextQuarter = mNextQuarter;
        this.mUnderEdge = mUnderEdge;
        this.mLowerLimit = mLowerLimit;
        this.mAbnormalDates = mAbnormalDates;
    }

    public Float getmCapped() {
        return mCapped;
    }

    public void setmCapped(Float mCapped) {
        this.mCapped = mCapped;
    }

    public Float getmUpperEdge() {
        return mUpperEdge;
    }

    public void setmUpperEdge(Float mUpperEdge) {
        this.mUpperEdge = mUpperEdge;
    }

    public Float getmUpperFourthQuarter() {
        return mUpperFourthQuarter;
    }

    public void setmUpperFourthQuarter(Float mUpperFourthQuarter) {
        this.mUpperFourthQuarter = mUpperFourthQuarter;
    }

    public Float getmMedian() {
        return mMedian;
    }

    public void setmMedian(Float mMedian) {
        this.mMedian = mMedian;
    }

    public Float getmNextQuarter() {
        return mNextQuarter;
    }

    public void setmNextQuarter(Float mNextQuarter) {
        this.mNextQuarter = mNextQuarter;
    }

    public Float getmUnderEdge() {
        return mUnderEdge;
    }

    public void setmUnderEdge(Float mUnderEdge) {
        this.mUnderEdge = mUnderEdge;
    }

    public Float getmLowerLimit() {
        return mLowerLimit;
    }

    public void setmLowerLimit(Float mLowerLimit) {
        this.mLowerLimit = mLowerLimit;
    }

    public List<Float> getmAbnormalDates() {
        return mAbnormalDates;
    }

    public void setmAbnormalDates(List<Float> mAbnormalDates) {
        this.mAbnormalDates = mAbnormalDates;
    }
}
