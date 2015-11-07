package com.hummingbird.tag.dao;

import java.util.List;

import com.hummingbird.tag.model.Tag;

public interface TagDao {

	/**
	 * 添加标签
	 * @param tag  标签对象
	 * @return
	 */
	public Tag insertTag(Tag tag);
	
	
	/**
	 * 根据名称查找标签列表
	 * @param tagName  标签名称
	 * @return
	 */
	public List<Tag> findTag(String tagName);
	
	
	/**
	 * 根据主键查找对象
	 * @param tagId  标签ID
	 * @return
	 */
	public Tag getTagByTagId(Integer tagId);
	
	
	/**
	 * 根据分类查找标签列表
	 * @param tagTypeId  标签类型ID
	 * @return
	 */
	public List<Tag> findTag(Integer tagTypeId);
	
	
	/**
	 * 修改标签
	 * @param tag  标签对象
	 * @return
	 */
	public int updateTag(Tag tag);
	
	
	/**
	 * 根据标签类型ID和标签名称，标签创建者查找对象
	 * @param tagTypeId  标签类型ID
	 * @param tagName  标签名称
	 * @param tagCreateObject  标签的创建者
	 * @return
	 */
	public Tag getTag(Integer tagTypeId, String tagName, String tagCreateObject);
	
	
	/**
	 * 根据条件查找标签列表
	 * @param tagTypeId  标签类型ID
	 * @param tagCreateObject  标签的创建者
	 * @return
	 */
	public List<Tag> findTag(Integer tagTypeId, String tagCreateObject);
	
	
	/**
	 * 根据ID删除对象
	 * @param tagId  标签ID
	 * @return
	 */
	public int delTag(Integer tagId);
	
	
	/**
	 * 根据标签类型ID和标签名称（模糊），标签创建者查找列表
	 * @param tagTypeId  标签类型ID
	 * @param tagName  标签名称
	 * @param tagCreateObject  标签的创建者
	 * @return
	 */
	public List<Tag> findTag(Integer tagTypeId, String tagName, String tagCreateObject);
}
