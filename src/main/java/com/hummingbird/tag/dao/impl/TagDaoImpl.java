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
	
	private static String tag_sql = "tag_id, tag_name, tab_use_num, tag_create_time, tag_update_time, tag_status, tag_create_object, tag_type_id, tag_update_remark";
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public Tag insertTag(Tag tag) {
		try{
            NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
            SqlParameterSource paramSource = new BeanPropertySqlParameterSource(tag);
            String sql = "insert into t_tag("+tag_sql+") " +
            		"values (:tagId, :tagName, :tabUseNum, :tagCreateTime, :tagUpdateTime, :tagStatus, :tagCreateObject, :tagTypeId, :tagUpdateRemark)";

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
	public List<Tag> findTag(String tagName) {
		String sql = "select "+tag_sql+" from t_tag where 1=1 and tag_name=?";
		List<Tag> tags = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Tag.class), tagName);
		return tags;
	}

	@Override
	public Tag getTagByTagId(Integer tagId) {
		String sql = "select "+tag_sql+" from t_tag where 1=1 and tag_id=?";
		List<Tag> tags = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Tag.class), tagId);
		if(tags.size() > 0){
			return tags.get(0);
		}else{
			return null;
		}
	}

	@Override
	public List<Tag> findTag(Integer tagTypeId) {
		String sql = "select "+tag_sql+" from t_tag where 1=1 and tag_type_id=?";
		List<Tag> tags = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Tag.class), tagTypeId);
		return tags;
	}

	@Override
	public int updateTag(Tag tag) {
		String sql = "update t_tag set tag_name=?, tab_use_num=?, tag_status=?, tag_update_time=?, tag_create_object=?, tag_type_id=?, tag_update_remark=? where tag_id=?";
        int count = jdbcTemplate.update(
                sql, tag.getTagName(), tag.getTabUseNum(), tag.getTagStatus(), new Date(), tag.getTagCreateObject(), tag.getTagTypeId(), tag.getTagUpdateRemark(), tag.getTagId());
        return count;
	}

	@Override
	public Tag getTag(Integer tagTypeId, String tagName, String tagCreateObject) {
		String sql = "select "+tag_sql+" from t_tag where 1=1 and tag_name=? and tag_type_id=? and tag_create_object=?";
		List<Tag> tags = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Tag.class), tagName, tagTypeId, tagCreateObject);
		if(tags.size() > 0){
			return tags.get(0);
		}else{
			return null;
		}
	}

	@Override
	public List<Tag> findTag(Integer tagTypeId, String tagCreateObject) {
		String sql = "select "+tag_sql+" from t_tag where 1=1 and tag_type_id=? and tag_create_object=?";
		List<Tag> tags = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Tag.class), tagTypeId, tagCreateObject);
		return tags;
	}

	@Override
	public int delTag(Integer tagId) {
		String sql = "DELETE FROM t_tag where tag_id=?";
		int count = jdbcTemplate.update(sql, tagId);
		return count;
	}

	@Override
	public List<Tag> findTag(Integer tagTypeId, String tagName, String tagCreateObject) {
		String sql = "select "+tag_sql+" from t_tag where 1=1 and tag_name like '%"+tagName+"%' and tag_type_id=? and tag_create_object=?";
		List<Tag> tags = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Tag.class), tagTypeId, tagCreateObject);
		return tags;
	}
	

}
