package com.hummingbird.tag.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hummingbird.tag.dao.TagTypeDao;
import com.hummingbird.tag.model.TagType;

@Repository
public class TagTypeDaoImpl implements TagTypeDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	private static String tag_type_sql = "tag_type_id, tag_type_name, tag_type_create_time, tag_type_remark";

	@Override
	public TagType getTagTypeById(Integer tagTypeId) {
		String sql = "select "+tag_type_sql+" from t_tag_type where 1=1 and tag_type_id=?";
		List<TagType> tags = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(TagType.class), tagTypeId);
		if(tags.size() > 0){
			return tags.get(0);
		}else{
			return null;
		}
	}
}
