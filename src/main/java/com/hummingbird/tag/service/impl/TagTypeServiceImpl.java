package com.hummingbird.tag.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hummingbird.tag.dao.TagTypeDao;
import com.hummingbird.tag.model.TagType;
import com.hummingbird.tag.service.TagTypeService;

@Service
public class TagTypeServiceImpl implements TagTypeService {

	@Autowired
	private TagTypeDao tagTypeDao;
	
	@Override
	public TagType getTagTypeById(Integer tagTypeId) {
		return tagTypeDao.getTagTypeById(tagTypeId);
	}

}
