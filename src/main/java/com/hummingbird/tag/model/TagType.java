package com.hummingbird.tag.model;

import java.util.Date;

public class TagType {
    private Integer tagTypeId;

    private String tagTypeName;

    private Date tagTypeCreateTime;

    private String tagTypeRemark;

    
    public TagType() {
		super();
	}

    
	public TagType(Integer tagTypeId, String tagTypeName,
			Date tagTypeCreateTime, String tagTypeRemark) {
		super();
		this.tagTypeId = tagTypeId;
		this.tagTypeName = tagTypeName;
		this.tagTypeCreateTime = tagTypeCreateTime;
		this.tagTypeRemark = tagTypeRemark;
	}


	public Integer getTagTypeId() {
        return tagTypeId;
    }

    public void setTagTypeId(Integer tagTypeId) {
        this.tagTypeId = tagTypeId;
    }

    public String getTagTypeName() {
        return tagTypeName;
    }

    public void setTagTypeName(String tagTypeName) {
        this.tagTypeName = tagTypeName == null ? null : tagTypeName.trim();
    }

    public Date getTagTypeCreateTime() {
        return tagTypeCreateTime;
    }

    public void setTagTypeCreateTime(Date tagTypeCreateTime) {
        this.tagTypeCreateTime = tagTypeCreateTime;
    }

    public String getTagTypeRemark() {
        return tagTypeRemark;
    }

    public void setTagTypeRemark(String tagTypeRemark) {
        this.tagTypeRemark = tagTypeRemark == null ? null : tagTypeRemark.trim();
    }


	@Override
	public String toString() {
		return "TagType [tagTypeId=" + tagTypeId + ", tagTypeName="
				+ tagTypeName + ", tagTypeCreateTime=" + tagTypeCreateTime
				+ ", tagTypeRemark=" + tagTypeRemark + "]";
	}
}