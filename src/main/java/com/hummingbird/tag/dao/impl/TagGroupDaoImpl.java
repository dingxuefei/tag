package com.hummingbird.tag.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hummingbird.tag.dao.TagGroupDao;
import com.hummingbird.tag.model.TagGroup;

@Repository("TagGroupDao")
public class TagGroupDaoImpl implements TagGroupDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	private static String tag_group_sql = "tag_group_id, tag_group_name, tag_group_create_time, tag_group_remark";

	@Override
	public TagGroup getTagGroupByName(String tagGroupName) {
		String sql = "select "+tag_group_sql+" from t_tag_group where 1=1 and tag_group_name=?";
		List<TagGroup> tags = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(TagGroup.class), tagGroupName);
		if(tags.size() > 0){
			return tags.get(0);
		}else{
			return null;
		}
	}
}
