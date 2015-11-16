package com.hummingbird.tag.model;

import java.util.Date;

public class Tag {
    private Integer tagId;

    private Integer tagObjectId;

    private Integer tagGroupId;

    private String tagName;

    private Integer tabUseNum;

    private Date tagCreateTime;

    private Integer tagStatus;

    private String tagCreateObject;

    private Date tagUpdateTime;

    private String tagUpdateRemark;
    
    private String tagGroupName;
    
    private String tagObjectCode;
    
    private Integer businessId;

    public Tag() {
		super();
	}
    
	public Tag(Integer tagId, Integer tagObjectId, Integer tagGroupId,
			String tagName, Integer tabUseNum, Date tagCreateTime,
			Integer tagStatus, String tagCreateObject, Date tagUpdateTime,
			String tagUpdateRemark) {
		super();
		this.tagId = tagId;
		this.tagObjectId = tagObjectId;
		this.tagGroupId = tagGroupId;
		this.tagName = tagName;
		this.tabUseNum = tabUseNum;
		this.tagCreateTime = tagCreateTime;
		this.tagStatus = tagStatus;
		this.tagCreateObject = tagCreateObject;
		this.tagUpdateTime = tagUpdateTime;
		this.tagUpdateRemark = tagUpdateRemark;
	}



	public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getTagObjectId() {
        return tagObjectId;
    }

    public void setTagObjectId(Integer tagObjectId) {
        this.tagObjectId = tagObjectId;
    }

    public Integer getTagGroupId() {
        return tagGroupId;
    }

    public void setTagGroupId(Integer tagGroupId) {
        this.tagGroupId = tagGroupId;
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

    public Date getTagUpdateTime() {
        return tagUpdateTime;
    }

    public void setTagUpdateTime(Date tagUpdateTime) {
        this.tagUpdateTime = tagUpdateTime;
    }

    public String getTagUpdateRemark() {
        return tagUpdateRemark;
    }

    public void setTagUpdateRemark(String tagUpdateRemark) {
        this.tagUpdateRemark = tagUpdateRemark == null ? null : tagUpdateRemark.trim();
    }

	public String getTagGroupName() {
		return tagGroupName;
	}

	public void setTagGroupName(String tagGroupName) {
		this.tagGroupName = tagGroupName;
	}

	public String getTagObjectCode() {
		return tagObjectCode;
	}

	public void setTagObjectCode(String tagObjectCode) {
		this.tagObjectCode = tagObjectCode;
	}

	public Integer getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}

	@Override
	public String toString() {
		return "Tag [tagId=" + tagId + ", tagObjectId=" + tagObjectId
				+ ", tagGroupId=" + tagGroupId + ", tagName=" + tagName
				+ ", tabUseNum=" + tabUseNum + ", tagCreateTime="
				+ tagCreateTime + ", tagStatus=" + tagStatus
				+ ", tagCreateObject=" + tagCreateObject + ", tagUpdateTime="
				+ tagUpdateTime + ", tagUpdateRemark=" + tagUpdateRemark + "]";
	}
}