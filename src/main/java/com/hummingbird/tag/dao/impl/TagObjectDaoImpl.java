package com.hummingbird.tag.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hummingbird.tag.dao.TagObjectDao;
import com.hummingbird.tag.model.TagObject;

@Repository("TagObjectDao")
public class TagObjectDaoImpl implements TagObjectDao {

	private static String object_sql = "tag_object_id, tag_object_code, tag_object_remark";
	
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public TagObject getTagObjectByCode(String tagObjectCode) {
		String sql = "select "+object_sql+" from t_tag_object where tag_object_code=?";
		List<TagObject> objects = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(TagObject.class), tagObjectCode);
		if(objects.size() > 0){
			return objects.get(0);
		}else{
			return null;
		}
	}

}
