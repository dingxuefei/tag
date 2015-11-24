package com.hummingbird.tag.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.tag.dao.TagDao;
import com.hummingbird.tag.dao.TagmapDao;
import com.hummingbird.tag.model.Tag;
import com.hummingbird.tag.model.Tagmap;
import com.hummingbird.tag.service.TagService;

@Service("TagService")
public class TagServiceImpl implements TagService {
	
	@Autowired
	private TagDao tagDao;
	
	@Autowired
	private TagmapDao tagmapDao;

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	@Override
	public Tag insertTag(Tag tag) {
		return tagDao.insertTag(tag);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	@Override
	public int updateTag(Tag tag) {
		return tagDao.updateTag(tag);
	}

	@Override
	public Tag getTag(Integer tagGroupId, String tagName, String tagCreateObject) {
		return tagDao.getTag(tagGroupId, tagName, tagCreateObject);
	}

	@Override
	public List<Tag> findTag(Integer tagGroupId, String tagCreateObject) {
		return tagDao.findTag(tagGroupId, tagCreateObject);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	@Override
	public int delTag(Integer tagId) {
		return tagDao.delTag(tagId);
	}

	@Override
	public List<Tag> findTag(Integer tagGroupId, String tagName, String tagCreateObject) {
		return tagDao.findTag(tagGroupId, tagName, tagCreateObject);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	@Override
	public void logic(Tag tag, Tagmap tagmap, Integer tagId, Integer businessId, Integer tagGroupId, Integer tagObjectId) {
		tagDao.updateTag(tag);
		tagmapDao.insertTagmap(tagmap);
		tagmapDao.delTagmap(tagId, businessId, tagObjectId, tagGroupId);
	}


	@Override
	public Tag getTag(Integer tagId) {
		return tagDao.getTag(tagId);
	}

}
