package com.hummingbird.tag;

import net.sf.json.JSONObject;

import com.google.gson.Gson;

public class Test {

	public static void main(String[] args) throws Exception {
		
		/*String url = "http://localhost:8080/tag/insert";
		Tag tag = new Tag();
		tag.setTagCreateObject("李四");
		tag.setTagTypeId(1);
		tag.setTagName("次要");
		tag.setBusinessId(4);
		
		String json = new Gson().toJson(tag);
		System.out.println(json);
		
		String result = HttpPostUtils.sendHttpPost(url, json);
		System.out.println(result);*/
		
		/*String url = "http://localhost:8080/tag/tagDispatch";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("tagTypeId", 1);
		jsonObject.put("dispatchUserNameFrom", "李四");
		jsonObject.put("dispatchUserNameTo", "张三");
		
		System.out.println(jsonObject);
		String result = HttpPostUtils.sendHttpPost(url, jsonObject.toString());
		System.out.println(result);*/
		
		
		
		String url = "http://localhost:8080/tag/searchBusinessId";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("tagTypeId", 1);
		jsonObject.put("tagName", "次要");
		jsonObject.put("tagCreateObject", "张三");
		
		System.out.println(jsonObject);
		/*String result = HttpPostUtils.sendHttpPost(url, jsonObject.toString());
		System.out.println(result);*/
		
	}

}
