package com.hummingbird.tag.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.tag.dao.TagDao;
import com.hummingbird.tag.dao.TagmapDao;
import com.hummingbird.tag.model.Tag;
import com.hummingbird.tag.model.Tagmap;
import com.hummingbird.tag.service.TagmapService;

@Service("TagmapService")
public class TagmapServiceImpl implements TagmapService {

	@Autowired
	private TagmapDao tagmapDao;
	
	@Autowired
	private TagDao tagDao;
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	@Override
	public Tagmap insertTagmap(Tagmap tagmap) {
		return tagmapDao.insertTagmap(tagmap);
	}

	@Override
	public List<Tagmap> findTagMapByMap(Map<String, Integer> map) {
		return tagmapDao.findTagMapByMap(map);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	@Override
	public int updateTagmap(Tagmap tagmap) {
		return tagmapDao.updateTagmap(tagmap);
	}

	@Override
	public Tagmap getTagmap(Integer tagId, Integer tagGroupId, Integer tagObjectId, Integer businessId) {
		return tagmapDao.getTagmap(tagId, tagGroupId, tagObjectId, businessId);
	}


	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	@Override
	public void delTagmap(Integer businessId, Tag tag, Integer tagObjectId) {
		tagmapDao.delTagmap(tag.getTagId(), businessId, tagObjectId, tag.getTagGroupId());
		tagDao.updateTag(tag);
	}

}
