package com.hummingbird.tag.service;

import java.util.List;

import com.hummingbird.tag.model.Tag;
import com.hummingbird.tag.model.Tagmap;

/**
 * 
 * @ClassName: TagService 
 * @Description: 标签
 * @author dingxuefei
 * @date 2015年11月5日 下午5:23:10 
 *
 */
public interface TagService {

	/**
	 * 添加标签
	 * @param tag  标签对象
	 * @return
	 */
	public Tag insertTag(Tag tag);
	
	
	/**
	 * 修改标签
	 * @param tag  标签对象
	 * @return
	 */
	public int updateTag(Tag tag);
	
	
	/**
	 * 根据标标签组ID、标签名称、标签创建者、标签的所属业务ID查找对象
	 * @param tagGroupId  标签组ID
	 * @param tagName  标签名称
	 * @param tagCreateObject  标签的创建者
	 * @param tagObjectId  标签的所属业务ID
	 * @return
	 */
	public Tag getTag(Integer tagGroupId, String tagName, String tagCreateObject, Integer tagObjectId);
	
	
	/**
	 * 根据条件查找标签列表
	 * @param tagGroupId  标签组ID
	 * @param tagCreateObject  标签的创建者
	 * @param tagObjectId  标签的所属业务ID
	 * @return
	 */
	public List<Tag> findTag(Integer tagGroupId, String tagCreateObject, Integer tagObjectId);
	
	
	/**
	 * 根据ID删除对象
	 * @param tagId  标签ID
	 * @return
	 */
	public int delTag(Integer tagId);
	
	
	
	/**
	 * 根据标签组ID、标签名称（模糊）、标签创建者查、标签的所属业务ID返回集合
	 * @param tagGroupId  标签组ID
	 * @param tagName  标签名称
	 * @param tagCreateObject  标签的创建者
	 * @return
	 */
	public List<Tag> findTag(Integer tagGroupId, String tagName, String tagCreateObject, Integer tagObjectId);
	
	/**
	 * 调配的时候的处理
	 * @param tag
	 * @param tagmap
	 * @param tagId
	 * @param businessId
	 */
	public void logic(Tag tag, Tagmap tagmap, Integer tagId, Integer businessId);
	
	
	/**
	 * 通过ID查询对象
	 * @param tagId
	 * @return
	 */
	public Tag getTag(Integer tagId);
}
