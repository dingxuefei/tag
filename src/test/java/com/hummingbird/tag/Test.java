package com.hummingbird.tag;

import net.sf.json.JSONObject;

import com.google.gson.Gson;

public class Test {

	public static void main(String[] args) throws Exception {
		
		/*String url = "http://localhost:8080/tag/insert";
		Tag tag = new Tag();
		tag.setTagCreateObject("王小二");
		tag.setTagTypeId(1);
		tag.setTagName("放弃");
		tag.setBusinessId(5);
		
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
		
		
		
		/*String url = "http://localhost:8080/tag/searchBusinessId";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("tagTypeId", 1);
		jsonObject.put("tagName", "次要");
		jsonObject.put("tagCreateObject", "张三");
		
		System.out.println(jsonObject);
		String result = HttpPostUtils.sendHttpPost(url, jsonObject.toString());
		System.out.println(result);*/
		
		///candidate/income
		String url = "http://localhost:8080/if/customerDev/addEvent";
		String result = HttpPostUtils.sendHttpPost(url, "123");
		System.out.println(result);
		
		
		/**
		 * 接口测试
		 * @param args
		 *//*
		public static void main(String args[]){
			CustomerincomeVO customerincomeVO = new CustomerincomeVO();
			
			AppVO appVO =  new AppVO();
			appVO.setAppId("babyspace");
			appVO.setNonce("275281");
			appVO.setTimeStamp("1447065940");
			appVO.setSignature("3c05ba98c8bcc1925eb4ea6824de9b03");
			customerincomeVO.setApp(appVO);
			
			CustomerincomeBodyVO body = new CustomerincomeBodyVO(
					"13798133462","张三","科学家","FAT", "小张三","三儿","2015-11-10","MALE###", "广州","", "越秀校","市场活动",
					"13898767876","0208787654","", "",null,"","段子鹏|18312019654","");
			customerincomeVO.setBody(body);

			String json = new Gson().toJson(customerincomeVO);

			System.out.println("添加客户POST数据：" + json);

			*//** 通过接口调用添加客户数据 **//*
			// 需要post的url地址
			String postUrl = "http://127.0.0.1:8080/if/customerDev/candidate/income";
			try {
				String result = HttpPostUtils.sendHttpPost(postUrl, json);
				System.out.println("添加客户POST数据返回值：" + result);
			} catch (Exception e) {
				System.out.println("添加客户POST数据出错：" + e);
			}
		}*/
	}

}
