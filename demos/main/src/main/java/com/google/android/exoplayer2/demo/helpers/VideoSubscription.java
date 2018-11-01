package com.google.android.exoplayer2.demo.helpers;

import java.io.Serializable;

/**
 * Created by Hisham on 01/Nov/2018 - 19:48
 */
public class VideoSubscription implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Long startDate;
    private Long endDate;//  long subscriptionEndTime();
    public VideoSubscription() {
        super();
    }

    public VideoSubscription(Long startDate, Long endDate) {
        super();
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Long getStartDate() {
        return startDate;
    }
    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }
    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "VideoSubscription [startDate=" + startDate + ", endDate=" + endDate + "]";
    }
}
