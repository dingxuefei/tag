package com.hummingbird.tag.service;

import java.util.List;
import java.util.Map;

import com.hummingbird.tag.model.Tag;
import com.hummingbird.tag.model.Tagmap;

/**
 * 
 * @ClassName: TagmapService 
 * @Description: 标签关系表借口
 * @author dingxuefei
 * @date 2015年11月5日 下午5:46:07 
 *
 */
public interface TagmapService {

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
	 * 移除标签
	 * @param tagId
	 * @param businessId
	 * @param tag
	 */
	public void delTagmap(Integer businessId, Tag tag);
	
	
}
