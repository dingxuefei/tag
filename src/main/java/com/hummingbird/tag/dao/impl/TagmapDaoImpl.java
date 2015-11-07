package com.hummingbird.tag.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.hummingbird.tag.dao.TagmapDao;
import com.hummingbird.tag.model.Tagmap;

@Repository
public class TagmapDaoImpl implements TagmapDao {
	
	private static String tagmap_sql = "tagmap_id, tag_id, business_id, tagmap_create_time, tagmap_update_time";
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public Tagmap insertTagmap(Tagmap tagmap) {
		try{
            NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
            SqlParameterSource paramSource = new BeanPropertySqlParameterSource(tagmap);
            String sql = "insert into t_tagmap("+tagmap_sql+") " +
            		"values (:tagmapId, :tagId, :businessId, :tagmapCreateTime, :tagmapUpdateTime)";

            KeyHolder keyHolder = new GeneratedKeyHolder();
            namedParameterJdbcTemplate.update(sql, paramSource, keyHolder);
            tagmap.setTagmapId(keyHolder.getKey().intValue());
            return tagmap;
        }catch (Exception e) {
        	e.printStackTrace();
        	return null;
		}
	}

	@Override
	public List<Tagmap> findTagMapByTagId(Map<String, Integer> map) {
		String sql = "select "+tagmap_sql+" from t_tagmap where 1=1";
		if(map.get("tag_id") != null){
			sql +=" and tag_id="+map.get("tag_id")+"";
		}
		if(map.get("business_id") != null){
			sql +=" and business_id="+map.get("business_id")+"";
		}
		List<Tagmap> tagmaps = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Tagmap.class));
		return tagmaps;
	}

	@Override
	public int updateTagmap(Tagmap tagmap) {
		String sql = "update t_tagmap set tag_id=?, business_id=?, tagmap_update_time=? where tagmap_id=?";
        int count = jdbcTemplate.update(
                sql, tagmap.getTagId(), tagmap.getBusinessId(), new Date(), tagmap.getTagmapId());
        return count;
	}

	@Override
	public Tagmap getTagmap(Integer tagId, Integer businessId) {
		String sql = "select "+tagmap_sql+" from t_tagmap where 1=1 and tag_id=? and business_id=?";
		List<Tagmap> tagmaps = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Tagmap.class), tagId, businessId);
		if(tagmaps.size() > 0){
			return tagmaps.get(0);
		}else{
			return null;
		}
	}

	@Override
	public int delTagmap(Integer tagId, Integer businessId) {
		String sql = "DELETE FROM t_tagmap where tag_id=? and business_id=?";
		int count = jdbcTemplate.update(sql, tagId, businessId);
		return count;
	}
	
}
