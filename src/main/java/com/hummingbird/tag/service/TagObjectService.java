package com.hummingbird.tag.service;

import com.hummingbird.tag.model.TagObject;

/**
 * @ClassName: ObjectService 
 * @Description: 操作的对象接口
 * @author dingxuefei
 * @date 2015年11月16日 下午4:55:42 
 *
 */
public interface TagObjectService {

	/**
	 * 根据编码返回对象
	 * @param tagObjectCode
	 * @return
	 */
	public TagObject getTagObjectByCode(String tagObjectCode);
}
