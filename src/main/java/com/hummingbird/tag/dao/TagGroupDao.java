package com.hummingbird.tag.dao;

import com.hummingbird.tag.model.TagGroup;

public interface TagGroupDao {

	/**
	 * 根据组名查找对象
	 * @param tagGroupName
	 * @return
	 */
	public TagGroup getTagGroupByName(String tagGroupName);
}
