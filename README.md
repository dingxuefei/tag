# tag
通用标签系统


#接口

##1、添加标签接口说明

http://xxx/tag/insert

http请求方式: post

POST数据格式：JSON

{"tagName":"重要","tagCreateObject":"张三","tagGroupName":"组名称","tagObjectCode":"KH","businessId":1}

参数|是否必须|说明
----|----|-----
tagName|是|标签名称
tagCreateObject|是|标签的创建者
tagGroupName|是|组名称
tagObjectCode|是|标签的所属业务编码
businessId|是|被打标签的信息ID

返回说明

格式：json

内容事例：

不成功事例

{"errcode":10000,"errmsg":"接收的数据为空"}  

成功事例

{"errcode":0000,"errmsg":"标签添加成功"}    





##2、标签创建人员发生变更时的调配接口

http://xxx/tag/tagDispatch

http请求方式: post

POST数据格式：JSON

{"dispatchUserNameFrom":"李四","dispatchUserNameTo":"张三","tagGroupName":"组名称","tagObjectCode":"KH"}

参数|是否必须|说明
----|----|-----
dispatchUserNameFrom|是|需要被调配的人
dispatchUserNameTo|是|调配的接收者
tagGroupName|是|组名称
tagObjectCode|是|标签的所属业务编码

返回说明

格式：json

内容事例：

不成功事例

{"errcode":10000,"errmsg":"接收的数据为空"}  

成功事例

{"errcode":0000,"errmsg":"调配完成"}  





##3、搜索相关的信息

http://xxx/tag/searchBusinessId

http请求方式: post

POST数据格式：JSON

{"tagGroupName":"组名称","tagCreateObject":"张三","tagName":"次要","tagObjectCode":"KH"}

参数|是否必须|说明
----|----|-----
tagName|是|标签名称（支持模糊查询）
tagCreateObject|是|标签的创建者
tagGroupName|是|组名称
tagObjectCode|是|标签的所属业务编码



返回说明：

返回要查询信息的ID，然后第三方系统根据ID到自己系统中查询相关的详细信息（id之间逗号隔开）

格式：逗号隔开的数字

内容事例：1,2,3,4





##4、移除标签

http://xxx/tag/cancelTag

http请求方式: post

POST数据格式：JSON

{"tagName":"重要","tagCreateObject":"张三","tagGroupName":"组名称","tagObjectCode":"KH","businessId":1}

参数|是否必须|说明
----|----|-----
tagName|是|标签名称
tagCreateObject|是|标签的创建者
tagGroupName|是|组名称
tagObjectCode|是|标签的所属业务编码
businessId|是|被打标签的信息ID

返回说明

格式：json

内容事例：

不成功事例

{"errcode":10000,"errmsg":"必要参数为空"}  

成功事例 

{"errcode":0000,"errmsg":"移除标签成功"}  





##5、查询业务的标签

http://xxx/tag/searchTag

http请求方式: post

POST数据格式：JSON

{"tagCreateObject":"张三","tagGroupName":"组名称","tagObjectCode":"KH","businessId":1}

参数|是否必须|说明
----|----|-----
tagCreateObject|是|标签的创建者
tagGroupName|是|组名称
tagObjectCode|是|标签的所属业务编码
businessId|是|被打标签的信息ID

返回说明

格式：json

内容事例：

不成功事例

{"errcode":10000,"errmsg":"必要参数为空"}  

成功事例 

[{"tagId\":1,"tagObjectId":1,"tagGroupId":1,"tagName":"市场活动","tabUseNum":1,"tagCreateTime":"Nov 19, 2015 5:55:33 PM","tagStatus":1,"tagCreateObject":"张三","tagUpdateTime":"Nov 20, 2015 5:57:19 PM","tagUpdateRemark":\"标签使用数量+1"}]  

