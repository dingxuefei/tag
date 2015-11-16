package com.hummingbird.tag.model;

import java.util.Date;

public class TagGroup {
    private Integer tagGroupId;

    private String tagGroupName;

    private Date tagGroupCreateTime;

    private String tagGroupRemark;

    public Integer getTagGroupId() {
        return tagGroupId;
    }

    public void setTagGroupId(Integer tagGroupId) {
        this.tagGroupId = tagGroupId;
    }

    public String getTagGroupName() {
        return tagGroupName;
    }

    public void setTagGroupName(String tagGroupName) {
        this.tagGroupName = tagGroupName == null ? null : tagGroupName.trim();
    }

    public Date getTagGroupCreateTime() {
        return tagGroupCreateTime;
    }

    public void setTagGroupCreateTime(Date tagGroupCreateTime) {
        this.tagGroupCreateTime = tagGroupCreateTime;
    }

    public String getTagGroupRemark() {
        return tagGroupRemark;
    }

    public void setTagGroupRemark(String tagGroupRemark) {
        this.tagGroupRemark = tagGroupRemark == null ? null : tagGroupRemark.trim();
    }

	public TagGroup() {
		super();
	}

	public TagGroup(Integer tagGroupId, String tagGroupName,
			Date tagGroupCreateTime, String tagGroupRemark) {
		super();
		this.tagGroupId = tagGroupId;
		this.tagGroupName = tagGroupName;
		this.tagGroupCreateTime = tagGroupCreateTime;
		this.tagGroupRemark = tagGroupRemark;
	}

	@Override
	public String toString() {
		return "TagGroup [tagGroupId=" + tagGroupId + ", tagGroupName="
				+ tagGroupName + ", tagGroupCreateTime=" + tagGroupCreateTime
				+ ", tagGroupRemark=" + tagGroupRemark + "]";
	}
    
    
}