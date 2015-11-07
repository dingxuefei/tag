package com.hummingbird.tag.dao;

import com.hummingbird.tag.model.TagType;

public interface TagTypeDao {

	
	/**
	 * 根据ID查找对象
	 * @param tagTypeId
	 * @return
	 */
	public TagType getTagTypeById(Integer tagTypeId);
}
