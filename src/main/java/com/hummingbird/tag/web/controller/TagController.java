package com.hummingbird.tag.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hummingbird.tag.model.Tag;
import com.hummingbird.tag.model.TagType;
import com.hummingbird.tag.model.Tagmap;
import com.hummingbird.tag.service.TagService;
import com.hummingbird.tag.service.TagTypeService;
import com.hummingbird.tag.service.TagmapService;
import com.hummingbird.tag.util.RequestUtil;

@Controller
@RequestMapping("/")
public class TagController {

	@Autowired
	private TagService tagService;
	
	@Autowired
	private TagTypeService tagTypeService;
	
	@Autowired
	private TagmapService tagmapService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private Gson gson = new Gson();
	
	
	@RequestMapping()
    public String index(Model model) {
        return "tag/index";
    }
	
	/**
	  * 添加标签
	  * @param request
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value = "insert", method =RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String insertTag(HttpServletRequest request)throws Exception{
		try{
			String jsonStr = RequestUtil.getRequestPostData(request);
	    	if(jsonStr.length() == 0){
	    		logger.debug("接收的数据为空");
	    		return "{\"errcode\":10000,\"errmsg\":\"接收的数据为空\"}";
	    	}
	    	
	    	Tag tag = gson.fromJson(jsonStr, new TypeToken<Tag>() {}.getType());
	    	tag.setTagCreateTime(new Date());
	    	tag.setTagUpdateTime(new Date());
	    	tag.setTagStatus(1);
	    	tag.setTabUseNum(1);
	    	
	    	String tagName = tag.getTagName();
	    	String tagCreateObject = tag.getTagCreateObject();
	    	Integer businessId = tag.getBusinessId();
	    	Integer tagTypeId = tag.getTagTypeId();
	    	
	    	if(StringUtils.isBlank(tagName)){
	    		logger.debug("标签名称为空");
	    		return "{\"errcode\":10000,\"errmsg\":\"标签名称为空\"}";
	    	}
			if(StringUtils.isBlank(tagCreateObject)){
				logger.debug("标签的创建者为空");
	    		return "{\"errcode\":10000,\"errmsg\":\"标签的创建者为空\"}";	
	    	}
			if(businessId == null){
				logger.debug("需要被打标签的对象ID为空");
	    		return "{\"errcode\":10000,\"errmsg\":\"需要被打标签的对象ID为空\"}";	
			}
			if(tagTypeId == null){
				logger.debug("标签的类型为空");
	    		return "{\"errcode\":10000,\"errmsg\":\"标签的类型为空\"}";
			}else{
				TagType tagType = tagTypeService.getTagTypeById(tagTypeId);
				if(tagType == null){
					logger.debug("标签的类型不存在");
		    		return "{\"errcode\":10000,\"errmsg\":\"标签的类型不存在\"}";
				}
			}
			
			Tag tag_ = tagService.getTag(tagTypeId, tagName, tagCreateObject);
			
			if(tag_ != null){
				Tagmap tagmap = tagmapService.getTagmap(tag_.getTagId(), businessId);
				if(tagmap != null){
					logger.debug("此信息已经存在该标签");
		    		return "{\"errcode\":10000,\"errmsg\":\"此信息已经存在该标签\"}";
				}else{
					tagmap = new Tagmap();
					tagmap.setTagId(tag_.getTagId());
					tagmap.setBusinessId(tag.getBusinessId());
					tagmap.setTagmapCreateTime(new Date());
					tagmap.setTagmapUpdateTime(new Date());
					Tagmap tagmap_ = tagmapService.insertTagmap(tagmap);
					if(tagmap_ != null){
						tag_.setTabUseNum(tag_.getTabUseNum()+1);
						tag_.setTagUpdateRemark("标签使用数量+1");
						int count = tagService.updateTag(tag_);
						if(count == 1){
							logger.debug("标签添加成功："+tag_.toString());
							return "{\"errcode\":0000,\"errmsg\":\"标签添加成功\"}";
						}else{
							logger.debug("系统错误，标签添加失败");
				    		return "{\"errcode\":10000,\"errmsg\":\"系统错误，标签添加失败\"}";
						}
					}
				}
			}else{
				tag_ = tagService.insertTag(tag);
				if(tag_ == null){
					logger.debug("系统错误，标签添加失败");
		    		return "{\"errcode\":10000,\"errmsg\":\"系统错误，标签添加失败\"}";
				}else{
					Tagmap tagmap = new Tagmap();
					tagmap.setTagId(tag_.getTagId());
					tagmap.setBusinessId(tag.getBusinessId());
					tagmap.setTagmapCreateTime(new Date());
					tagmap.setTagmapUpdateTime(new Date());
					Tagmap tagmap_ = tagmapService.insertTagmap(tagmap);
					
					if(tagmap_ == null){
						logger.debug("系统错误，标签添加失败");
			    		return "{\"errcode\":10000,\"errmsg\":\"系统错误，标签添加失败\"}";
					}else{
						logger.debug("标签添加成功："+tag_.toString());
						return "{\"errcode\":0000,\"errmsg\":\"标签添加成功\"}";
					}
				}
			}
		}catch(Exception e){
			logger.error("系统错误，标签添加失败", e);
    		return "{\"errcode\":10000,\"errmsg\":\"系统错误，标签添加失败\"}";
		}
		return null;
    }
	
	
	
	
	/**
	 * 标签创建人员发生变更时的调配
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "tagDispatch", method =RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String tagDispatch(HttpServletRequest request)throws Exception{
		try{
			String jsonStr = RequestUtil.getRequestPostData(request);
	    	if(jsonStr.length() == 0){
	    		logger.debug("接收的数据为空");
	    		return "{\"errcode\":10000,\"errmsg\":\"接收的数据为空\"}";
	    	}
	    	
	    	JSONObject jsonObject = gson.fromJson(jsonStr, new TypeToken<JSONObject>() {}.getType());
	    	Integer tagTypeId = jsonObject.getInt("tagTypeId");
	    	
	    	//需要被调配的人
	    	String dispatchUserNameFrom = jsonObject.getString("dispatchUserNameFrom");
	    	
	    	//调配到的那一个人（接收者）
	    	String dispatchUserNameTo = jsonObject.getString("dispatchUserNameTo");
	    	
	    	if(tagTypeId == null){
	    		logger.debug("必要参数为空");
	    		return "{\"errcode\":10000,\"errmsg\":\"必要参数为空\"}";
	    	}
	    	
	    	if(StringUtils.isBlank(dispatchUserNameFrom)){
	    		logger.debug("必要参数为空");
	    		return "{\"errcode\":10000,\"errmsg\":\"必要参数为空\"}";
	    	}
	    	
	    	if(StringUtils.isBlank(dispatchUserNameTo)){
	    		logger.debug("必要参数为空");
	    		return "{\"errcode\":10000,\"errmsg\":\"必要参数为空\"}";
	    	}
	    	
	    	//分别查询这两个人是否创建过标签
	    	List<Tag> tagFroms = tagService.findTag(tagTypeId, dispatchUserNameFrom);
	    	List<Tag> tagTos = tagService.findTag(tagTypeId, dispatchUserNameTo);
	    	
	    	List<String> tagToTagNames = new ArrayList<String>();
	    	for(Tag tag : tagTos){
	    		tagToTagNames.add(tag.getTagName());
	    	}
	    	
	    	if(tagFroms == null || tagFroms.size() == 0){
	    		logger.debug("需要被调配的人没有创建标签，无需调配");
	    		return "{\"errcode\":0000,\"errmsg\":\"需要被调配的人没有创建标签，无需调配\"}";
	    	}
	    	if(tagFroms != null && tagFroms.size() > 0){
	    		
	    		//接收者没有创建标签
	    		if(tagTos == null || tagTos.size() == 0){
	    			for(Tag tag : tagFroms){
	    				tag.setTagCreateObject(dispatchUserNameTo);
	    				tag.setTagUpdateRemark("标签创建人员调配 to "+dispatchUserNameTo);
	    				tagService.updateTag(tag);
	    			}
	    			logger.debug("调配完成 "+dispatchUserNameFrom+" TO "+dispatchUserNameTo);
	    			return "{\"errcode\":0000,\"errmsg\":\"调配完成\"}";
	    		}
	    		
	    		//接收者有创建标签
	    		if(tagTos != null && tagTos.size() != 0){
	    			for(Tag tag : tagFroms){
	    				Map<String, Integer> map = new HashMap<String, Integer>();
	    	    		map.put("tag_id", tag.getTagId());
	    				List<Tagmap> tagmaps = tagmapService.findTagMapByTagId(map);
	    				
	    				//如果创建有相同名称标签
	    				if(tagToTagNames.contains(tag.getTagName())){
	    					for(Tagmap tagmap : tagmaps){
	    						Integer businessId = tagmap.getBusinessId();
	    						Tag tag_ = tagService.getTag(tagTypeId, tag.getTagName(), dispatchUserNameTo);
		    					//更新标签使用数量
		    					tag_.setTabUseNum(tag_.getTabUseNum()+1);
		    					/*更新*/
		    					
		    					//添加关联
		    					tagmap = new Tagmap();
		    					tagmap.setTagId(tag_.getTagId());
		    					tagmap.setBusinessId(businessId);
		    					tagmap.setTagmapCreateTime(new Date());
		    					tagmap.setTagmapUpdateTime(new Date());
		    					/*保存*/
		    					
		    					tagService.logic(tag_, tagmap, tag.getTagId(), businessId);
	    					}
	    					//调配完成之后删除
		    				tagService.delTag(tag.getTagId());
	    				}else{
	    					tag.setTagCreateObject(dispatchUserNameTo);
	        				tag.setTagUpdateRemark("标签创建人员调配  " +dispatchUserNameFrom+" to "+dispatchUserNameTo);
	        				tagService.updateTag(tag);
	    				}
	    			}
	    			logger.debug("调配完成 "+dispatchUserNameFrom+"  TO "+dispatchUserNameTo);
	    			return "{\"errcode\":0000,\"errmsg\":\"调配完成\"}";
	    		}
	    	}
		}catch(Exception e){
			logger.error("系统错误，标签创建人员调配失败", e);
			return "{\"errcode\":10000,\"errmsg\":\"系统错误，标签创建人员调配失败\"}";
		}
		return null;
	}
	
	
	/**
	 * 搜索相关的信息
	 * @param request
	 * @return  返回要查询信息的ID，然后第三方系统根据ID到自己系统中查询相关的详细信息（id之间逗号隔开）
	 * @throws Exception
	 */
	@RequestMapping(value = "searchBusinessId", method =RequestMethod.POST, produces = {"application/text;charset=UTF-8"})
    @ResponseBody
    public String searchBusinessId(HttpServletRequest request)throws Exception{
		try{
			String jsonStr = RequestUtil.getRequestPostData(request);
	    	if(jsonStr.length() == 0){
	    		logger.debug("接收的数据为空");
	    		return "{\"errcode\":10000,\"errmsg\":\"接收的数据为空\"}";
	    	}
	    	
	    	JSONObject jsonObject = gson.fromJson(jsonStr, new TypeToken<JSONObject>() {}.getType());
	    	Integer tagTypeId = jsonObject.getInt("tagTypeId");
	    	String tagName = jsonObject.getString("tagName");
	    	String tagCreateObject = jsonObject.getString("tagCreateObject");
	    	
	    	if(tagTypeId == null){
	    		logger.debug("必要参数为空");
	    		return "{\"errcode\":10000,\"errmsg\":\"必要参数为空\"}";
	    	}
	    	
	    	if(StringUtils.isBlank(tagName)){
	    		logger.debug("必要参数为空");
	    		return "{\"errcode\":10000,\"errmsg\":\"必要参数为空\"}";
	    	}
	    	
	    	if(StringUtils.isBlank(tagCreateObject)){
	    		logger.debug("必要参数为空");
	    		return "{\"errcode\":10000,\"errmsg\":\"必要参数为空\"}";
	    	}
	    	
	    	List<Tag> tags = tagService.findTag(tagTypeId, tagName, tagCreateObject);
	    	String result = "";
	    	for(Tag tag : tags){
	    		Map<String, Integer> map = new HashMap<String, Integer>();
	    		map.put("tag_id", tag.getTagId());
	    		List<Tagmap> tagmaps = tagmapService.findTagMapByTagId(map);
	    		for(Tagmap tagmap : tagmaps){
	    			result += tagmap.getBusinessId()+",";
	    		}
	    	}
	    	
	    	result = result.substring(0, result.length() - 1);
	    	return result;
	    	
		}catch(Exception e){
			logger.error("系统错误，查询失败", e);
			return "{\"errcode\":10000,\"errmsg\":\"系统错误，查询失败\"}";
		}
	}
}
