package com.hummingbird.tag.model;

import java.util.Date;

public class Tagmap {
    private Integer tagmapId;

    private Integer tagId;

    private Integer tagGroupId;

    private Integer tagObjectId;

    private Date tagmapCreateTime;

    private Date tagmapUpdateTime;

    private Integer businessId;

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

    public Integer getTagGroupId() {
        return tagGroupId;
    }

    public void setTagGroupId(Integer tagGroupId) {
        this.tagGroupId = tagGroupId;
    }

    public Integer getTagObjectId() {
        return tagObjectId;
    }

    public void setTagObjectId(Integer tagObjectId) {
        this.tagObjectId = tagObjectId;
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

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

	public Tagmap() {
		super();
	}

	public Tagmap(Integer tagmapId, Integer tagId, Integer tagGroupId,
			Integer tagObjectId, Date tagmapCreateTime, Date tagmapUpdateTime,
			Integer businessId) {
		super();
		this.tagmapId = tagmapId;
		this.tagId = tagId;
		this.tagGroupId = tagGroupId;
		this.tagObjectId = tagObjectId;
		this.tagmapCreateTime = tagmapCreateTime;
		this.tagmapUpdateTime = tagmapUpdateTime;
		this.businessId = businessId;
	}

	@Override
	public String toString() {
		return "Tagmap [tagmapId=" + tagmapId + ", tagId=" + tagId
				+ ", tagGroupId=" + tagGroupId + ", tagObjectId=" + tagObjectId
				+ ", tagmapCreateTime=" + tagmapCreateTime
				+ ", tagmapUpdateTime=" + tagmapUpdateTime + ", businessId="
				+ businessId + "]";
	}
}