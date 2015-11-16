package com.hummingbird.tag.dao;

import com.hummingbird.tag.model.TagObject;

public interface TagObjectDao {

	
	/**
	 * 根据编码返回对象
	 * @param tagObjectCode
	 * @return
	 */
	public TagObject getTagObjectByCode(String tagObjectCode);
}
