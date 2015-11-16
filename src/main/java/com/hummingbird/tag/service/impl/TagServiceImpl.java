package com.hummingbird.tag.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hummingbird.tag.dao.TagDao;
import com.hummingbird.tag.dao.TagmapDao;
import com.hummingbird.tag.model.Tag;
import com.hummingbird.tag.model.Tagmap;
import com.hummingbird.tag.service.TagService;

@Service
public class TagServiceImpl implements TagService {
	
	@Autowired
	private TagDao tagDao;
	
	@Autowired
	private TagmapDao tagmapDap;

	@Override
	public Tag insertTag(Tag tag) {
		return tagDao.insertTag(tag);
	}

	@Override
	public int updateTag(Tag tag) {
		return tagDao.updateTag(tag);
	}

	@Override
	public Tag getTag(Integer tagGroupId, String tagName, String tagCreateObject, Integer tagObjectId) {
		return tagDao.getTag(tagGroupId, tagName, tagCreateObject, tagObjectId);
	}

	@Override
	public List<Tag> findTag(Integer tagGroupId, String tagCreateObject, Integer tagObjectId) {
		return tagDao.findTag(tagGroupId, tagCreateObject, tagObjectId);
	}

	@Override
	public int delTag(Integer tagId) {
		return tagDao.delTag(tagId);
	}

	@Override
	public List<Tag> findTag(Integer tagGroupId, String tagName, String tagCreateObject, Integer tagObjectId) {
		return tagDao.findTag(tagGroupId, tagName, tagCreateObject, tagObjectId);
	}

	@Override
	public void logic(Tag tag, Tagmap tagmap, Integer tagId, Integer businessId) {
		tagDao.updateTag(tag);
		tagmapDap.insertTagmap(tagmap);
		tagmapDap.delTagmap(tagId, businessId);
	}

}
