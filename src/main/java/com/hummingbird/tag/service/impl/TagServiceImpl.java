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
	public List<Tag> findTag(String tagName) {
		return tagDao.findTag(tagName);
	}

	@Override
	public Tag getTagByTagId(Integer tagId) {
		return tagDao.getTagByTagId(tagId);
	}

	@Override
	public List<Tag> findTag(Integer tagTypeId) {
		return tagDao.findTag(tagTypeId);
	}

	@Override
	public int updateTag(Tag tag) {
		return tagDao.updateTag(tag);
	}

	@Override
	public Tag getTag(Integer tagTypeId, String tagName, String tagCreateObject) {
		return tagDao.getTag(tagTypeId, tagName, tagCreateObject);
	}

	@Override
	public List<Tag> findTag(Integer tagTypeId, String tagCreateObject) {
		return tagDao.findTag(tagTypeId, tagCreateObject);
	}

	@Override
	public int delTag(Integer tagId) {
		return tagDao.delTag(tagId);
	}

	@Override
	public List<Tag> findTag(Integer tagTypeId, String tagName, String tagCreateObject) {
		return tagDao.findTag(tagTypeId, tagName, tagCreateObject);
	}

	@Override
	public void logic(Tag tag, Tagmap tagmap, Integer tagId, Integer businessId) {
		tagDao.updateTag(tag);
		tagmapDap.insertTagmap(tagmap);
		tagmapDap.delTagmap(tagId, businessId);
	}

}
