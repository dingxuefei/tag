package com.hummingbird.tag.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.hummingbird.tag.dao.TagDao;
import com.hummingbird.tag.model.Tag;

@Repository
public class TagDaoImpl implements TagDao {
	
	private static String tag_sql = "tag_id, tag_object_id, tag_group_id, tag_name, tab_use_num, tag_create_time, tag_status, tag_create_object, tag_update_time, tag_update_remark";
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public Tag insertTag(Tag tag) {
		try{
            NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
            SqlParameterSource paramSource = new BeanPropertySqlParameterSource(tag);
            String sql = "insert into t_tag("+tag_sql+") " +
            		"values (:tagId, :tagObjectId, :tagGroupId, :tagName, :tabUseNum, :tagCreateTime, :tagStatus, :tagCreateObject, :tagUpdateTime, :tagUpdateRemark)";

            KeyHolder keyHolder = new GeneratedKeyHolder();
            namedParameterJdbcTemplate.update(sql, paramSource, keyHolder);
            tag.setTagId(keyHolder.getKey().intValue());
            return tag;
        }catch (Exception e) {
        	e.printStackTrace();
        	return null;
		}
	}

	
	@Override
	public int updateTag(Tag tag) {
		String sql = "update t_tag set tag_object_id=?, tag_group_id=?, tag_name=?, tab_use_num=?, tag_status=?, tag_update_time=?, tag_create_object=?, tag_update_remark=? where tag_id=?";
        int count = jdbcTemplate.update(
                sql, tag.getTagObjectCode(), tag.getTagGroupId(), tag.getTagName(), tag.getTabUseNum(), tag.getTagStatus(), new Date(), tag.getTagCreateObject(), tag.getTagUpdateRemark(), tag.getTagId());
        return count;
	}

	@Override
	public Tag getTag(Integer tagGroupId, String tagName, String tagCreateObject, Integer tagObjectId) {
		String sql = "select "+tag_sql+" from t_tag where 1=1 and tag_group_id=? and tag_name=? and tag_create_object=? and tag_object_id=?";
		List<Tag> tags = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Tag.class), tagGroupId, tagName, tagCreateObject, tagObjectId);
		if(tags.size() > 0){
			return tags.get(0);
		}else{
			return null;
		}
	}

	@Override
	public List<Tag> findTag(Integer tagGroupId, String tagCreateObject, Integer tagObjectId) {
		String sql = "select "+tag_sql+" from t_tag where 1=1 and tag_group_id=? and tag_create_object=? and tag_object_id=?";
		List<Tag> tags = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Tag.class), tagGroupId, tagCreateObject, tagObjectId);
		return tags;
	}

	@Override
	public int delTag(Integer tagId) {
		String sql = "DELETE FROM t_tag where tag_id=?";
		int count = jdbcTemplate.update(sql, tagId);
		return count;
	}

	@Override
	public List<Tag> findTag(Integer tagGroupId, String tagName, String tagCreateObject, Integer tagObjectId) {
		String sql = "select "+tag_sql+" from t_tag where 1=1 and tag_group_id=? and tag_name='%"+tagName+"%' and tag_create_object=? and tag_object_id=?";
		List<Tag> tags = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Tag.class), tagGroupId, tagCreateObject, tagObjectId);
		return tags;
	}
}
