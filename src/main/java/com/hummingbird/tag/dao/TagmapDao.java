package com.hummingbird.tag.dao;

import java.util.List;
import java.util.Map;

import com.hummingbird.tag.model.Tagmap;

public interface TagmapDao {

	/**
	 * 添加数据
	 * @param tagmap
	 * @return
	 */
	public Tagmap insertTagmap(Tagmap tagmap);
	
	
	/**
	 * 根据map条件返回列表
	 * @param tagId
	 * @return
	 */
	public List<Tagmap> findTagMapByMap(Map<String, Integer> map);
	
	
	/**
	 * 更新对象
	 * @param tagmap
	 * @return
	 */
	public int updateTagmap(Tagmap tagmap);
	
	
	/**
	 * 根据条件查找对象
	 * @param tagId
	 * @param tagGroupId
	 * @param tagObjectId
	 * @param businessId
	 * @return
	 */
	public Tagmap getTagmap(Integer tagId, Integer tagGroupId, Integer tagObjectId, Integer businessId);
	
	
	/**
	 * 删除关联
	 * @param tagId
	 * @param businessId
	 * @return
	 */
	public int delTagmap(Integer tagId, Integer businessId);
	
}
