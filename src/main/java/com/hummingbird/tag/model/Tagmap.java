package com.hummingbird.tag.model;

import java.util.Date;

public class Tagmap {
    private Integer tagmapId;

    private Integer tagId;

    private Integer businessId;

    private Date tagmapCreateTime;

    private Date tagmapUpdateTime;

    
    
    public Tagmap() {
		super();
	}

    
	public Tagmap(Integer tagmapId, Integer tagId, Integer businessId, Date tagmapCreateTime, Date tagmapUpdateTime) {
		super();
		this.tagmapId = tagmapId;
		this.tagId = tagId;
		this.businessId = businessId;
		this.tagmapCreateTime = tagmapCreateTime;
		this.tagmapUpdateTime = tagmapUpdateTime;
	}


	public Integer getTagmapId() {
        return tagmapId;
    }

    public void setTagmapId(Integer tagmapId) {
        this.tagmapId = tagmapId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Date getTagmapCreateTime() {
        return tagmapCreateTime;
    }

    public void setTagmapCreateTime(Date tagmapCreateTime) {
        this.tagmapCreateTime = tagmapCreateTime;
    }

    public Date getTagmapUpdateTime() {
        return tagmapUpdateTime;
    }

    public void setTagmapUpdateTime(Date tagmapUpdateTime) {
        this.tagmapUpdateTime = tagmapUpdateTime;
    }


	@Override
	public String toString() {
		return "Tagmap [tagmapId=" + tagmapId + ", tagId=" + tagId
				+ ", businessId=" + businessId + ", tagmapCreateTime=" + tagmapCreateTime
				+ ", tagmapUpdateTime=" + tagmapUpdateTime + "]";
	}
    
    
}