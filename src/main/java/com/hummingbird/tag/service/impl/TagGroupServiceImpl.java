package com.hummingbird.tag.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hummingbird.tag.dao.TagGroupDao;
import com.hummingbird.tag.model.TagGroup;
import com.hummingbird.tag.service.TagGroupService;

@Service("TagGroupService")
public class TagGroupServiceImpl implements TagGroupService {

	@Autowired
	private TagGroupDao tagGroupDao;

	@Override
	public TagGroup getTagGroupByName(String tagGroupName) {
		return tagGroupDao.getTagGroupByName(tagGroupName);
	}

}
