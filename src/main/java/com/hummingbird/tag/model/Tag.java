package com.hummingbird.tag.model;

import java.util.Date;

public class Tag {
    private Integer tagId;

    private String tagName;

    private Integer tabUseNum;

    private Date tagCreateTime;

    private Date tagUpdateTime;
    
    private Integer tagStatus;

    private String tagCreateObject;

    private Integer tagTypeId;
    
    private Integer businessId;
    
    private String tagUpdateRemark;

    public Tag() {
		super();
	}

 

	public Tag(Integer tagId, String tagName, Integer tabUseNum,
			Date tagCreateTime, Date tagUpdateTime, Integer tagStatus,
			String tagCreateObject, Integer tagTypeId, Integer businessId, String tagUpdateRemark) {
		super();
		this.tagId = tagId;
		this.tagName = tagName;
		this.tabUseNum = tabUseNum;
		this.tagCreateTime = tagCreateTime;
		this.tagUpdateTime = tagUpdateTime;
		this.tagStatus = tagStatus;
		this.tagCreateObject = tagCreateObject;
		this.tagTypeId = tagTypeId;
		this.businessId = businessId;
		this.tagUpdateRemark = tagUpdateRemark;
	}

	public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }

    public Integer getTabUseNum() {
        return tabUseNum;
    }

    public void setTabUseNum(Integer tabUseNum) {
        this.tabUseNum = tabUseNum;
    }

    public Date getTagCreateTime() {
        return tagCreateTime;
    }

    public void setTagCreateTime(Date tagCreateTime) {
        this.tagCreateTime = tagCreateTime;
    }

    public Integer getTagStatus() {
        return tagStatus;
    }

    public void setTagStatus(Integer tagStatus) {
        this.tagStatus = tagStatus;
    }

    public String getTagCreateObject() {
        return tagCreateObject;
    }

    public void setTagCreateObject(String tagCreateObject) {
        this.tagCreateObject = tagCreateObject == null ? null : tagCreateObject.trim();
    }

    public Integer getTagTypeId() {
        return tagTypeId;
    }

    public void setTagTypeId(Integer tagTypeId) {
        this.tagTypeId = tagTypeId;
    }

	public Date getTagUpdateTime() {
		return tagUpdateTime;
	}

	public void setTagUpdateTime(Date tagUpdateTime) {
		this.tagUpdateTime = tagUpdateTime;
	}

	public Integer getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}

	public String getTagUpdateRemark() {
		return tagUpdateRemark;
	}

	public void setTagUpdateRemark(String tagUpdateRemark) {
		this.tagUpdateRemark = tagUpdateRemark;
	}



	@Override
	public String toString() {
		return "Tag [tagId=" + tagId + ", tagName=" + tagName + ", tabUseNum="
				+ tabUseNum + ", tagCreateTime=" + tagCreateTime
				+ ", tagUpdateTime=" + tagUpdateTime + ", tagStatus="
				+ tagStatus + ", tagCreateObject=" + tagCreateObject
				+ ", tagTypeId=" + tagTypeId + ", businessId=" + businessId
				+ ", tagUpdateRemark=" + tagUpdateRemark + "]";
	}


}