package com.hummingbird.tag.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hummingbird.tag.dao.TagObjectDao;
import com.hummingbird.tag.model.TagObject;
import com.hummingbird.tag.service.TagObjectService;


@Service
public class TagObjectServiceImpl implements TagObjectService {

	@Autowired
	private TagObjectDao tagObjectDao;

	@Override
	public TagObject getTagObjectByCode(String tagObjectCode) {
		return tagObjectDao.getTagObjectByCode(tagObjectCode);
	}
	
	
}
