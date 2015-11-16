package com.hummingbird.tag.model;

public class TagObject {
    private Integer tagObjectId;

    private String tagObjectCode;

    private String tagObjectRemark;

    public Integer getTagObjectId() {
        return tagObjectId;
    }

    public void setTagObjectId(Integer tagObjectId) {
        this.tagObjectId = tagObjectId;
    }

    public String getTagObjectCode() {
        return tagObjectCode;
    }

    public void setTagObjectCode(String tagObjectCode) {
        this.tagObjectCode = tagObjectCode == null ? null : tagObjectCode.trim();
    }

    public String getTagObjectRemark() {
        return tagObjectRemark;
    }

    public void setTagObjectRemark(String tagObjectRemark) {
        this.tagObjectRemark = tagObjectRemark == null ? null : tagObjectRemark.trim();
    }

	public TagObject() {
		super();
	}

	public TagObject(Integer tagObjectId, String tagObjectCode,
			String tagObjectRemark) {
		super();
		this.tagObjectId = tagObjectId;
		this.tagObjectCode = tagObjectCode;
		this.tagObjectRemark = tagObjectRemark;
	}

	@Override
	public String toString() {
		return "TagObject [tagObjectId=" + tagObjectId + ", tagObjectCode="
				+ tagObjectCode + ", tagObjectRemark=" + tagObjectRemark + "]";
	}
}