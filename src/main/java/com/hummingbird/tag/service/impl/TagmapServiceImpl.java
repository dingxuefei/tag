package com.hummingbird.tag.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hummingbird.tag.dao.TagmapDao;
import com.hummingbird.tag.model.Tagmap;
import com.hummingbird.tag.service.TagmapService;

@Service
public class TagmapServiceImpl implements TagmapService {

	@Autowired
	private TagmapDao tagmapDao;
	
	@Override
	public Tagmap insertTagmap(Tagmap tagmap) {
		return tagmapDao.insertTagmap(tagmap);
	}

	@Override
	public List<Tagmap> findTagMapByTagId(Map<String, Integer> map) {
		return tagmapDao.findTagMapByTagId(map);
	}

	@Override
	public int updateTagmap(Tagmap tagmap) {
		return tagmapDao.updateTagmap(tagmap);
	}

	@Override
	public Tagmap getTagmap(Integer tagId, Integer businessId) {
		return tagmapDao.getTagmap(tagId, businessId);
	}

	@Override
	public int delTagmap(Integer tagId, Integer businessId) {
		return tagmapDao.delTagmap(tagId, businessId);
	}

}
