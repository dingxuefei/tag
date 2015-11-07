# tag
通用标签系统


#接口

##1、添加标签接口说明

http://ip:port/tag/insert

http请求方式: post
POST数据格式：JSON
{"tagName":"重要","tagCreateObject":"张三","tagTypeId":1,"businessId":1}

参数|是否必须|说明
----|----|-----
tagName|是|标签名称
tagCreateObject|是|标签的创建者
tagTypeId|是|标签的类型ID
businessId|是|被打标签的信息ID

返回说明
格式：json

内容事例：{"errcode":10000,"errmsg":"接收的数据为空"}  不成功事例
		  {"errcode":0000,"errmsg":"标签添加成功"}    成功事例





##2、标签创建人员发生变更时的调配接口

http://ip:port/tag/tagDispatch

http请求方式: post
POST数据格式：JSON
{"dispatchUserNameFrom":"李四","tagTypeId":1,"dispatchUserNameTo":"张三"}

参数|是否必须|说明
----|----|-----
dispatchUserNameFrom|是|需要被调配的人
tagTypeId|是|标签的类型ID
dispatchUserNameTo|是|调配的接收者

返回说明
格式：json

内容事例：{"errcode":10000,"errmsg":"接收的数据为空"}  不成功事例
		  {"errcode":0000,"errmsg":"调配完成"}  成功事例





##3、搜索相关的信息

http://ip:port/tag/searchBusinessId

http请求方式: post
POST数据格式：JSON
{"tagTypeId":1,"tagCreateObject":"张三","tagName":"次要"}

参数|是否必须|说明
----|----|-----
tagTypeId|是|标签类型ID
tagCreateObject|是|标签的创建者
tagName|是|标签名称（支持模糊查询）


返回说明：返回要查询信息的ID，然后第三方系统根据ID到自己系统中查询相关的详细信息（id之间逗号隔开）
格式：逗号隔开的数字

内容事例：1,2,3,4
