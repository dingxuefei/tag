package com.hummingbird.tag.service;

import com.hummingbird.tag.model.TagType;


/**
 * 
 * @ClassName: TagTypeService 
 * @Description: 标签类型
 * @author dingxuefei
 * @date 2015年11月5日 下午7:02:29 
 *
 */
public interface TagTypeService {
	
	/**
	 * 根据ID查找对象
	 * @param tagTypeId
	 * @return
	 */
	public TagType getTagTypeById(Integer tagTypeId);
}
