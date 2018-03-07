content
	contentId  //内容编号，主键
	title      //标题
	digest     //摘要
	image      //图片
	price      //当前价格
	detail     //全文，详细内容
	inventory  //库存，保留字段，不作处理

order
	orderId    //订单编号，主键
	orderTime  //购买时间
	orderPrice //购买价格
	orderCount //购买数量
	contentId  //内容编号，外键
	userId     //用户Id，外键

user
	userId     //用户Id
	userName   //用户昵称
	userRole   //用户角色，买家还是卖家
	password   //密码

