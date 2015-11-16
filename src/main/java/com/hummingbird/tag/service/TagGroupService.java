package com.hummingbird.tag.service;

import com.hummingbird.tag.model.TagGroup;


/**
 * 
 * @ClassName: TagTypeService 
 * @Description: 标签组
 * @author dingxuefei
 * @date 2015年11月5日 下午7:02:29 
 *
 */
public interface TagGroupService {
	
	/**
	 * 根据组名查找对象
	 * @param tagGroupName
	 * @return
	 */
	public TagGroup getTagGroupByName(String tagGroupName);
}
