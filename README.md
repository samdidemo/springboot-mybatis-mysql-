# springboot-mybatis-mysql-
使用的是springboot+mybatis+mysql+thymeleaf+bootstrap
前端是借用别人的模板进行修改，后台都是自己写的，分页不是bootstraptable前端分页，而是后端使用pageHelper进行分页

其中model里面的TableSplitResult就是中间类（泛型），用于返回bootstraptable所要求的类型

由于一开始想写关于学生管理的，后来改为酒店管理
所以里面有涉及到student的，后期将改为酒店的用户

这个版本想快点提交，所以只有三层，缺少了service一层，不过没太大关系
下面是效果图

前端填写姓名，入住时间，离开时间，房型进行预订
#后台管理订单页面进行房间订单的创建
订单的金额是根据房间的房型进行自动填入
订单形成的时候进行财务表的更新以及房间入住状态的改变
# springboot-bootstrap-thymeleaf-mybatis-
![image](https://github.com/samdidemo/springboot-mybatis-mysql-/blob/master/image/QQ%E6%88%AA%E5%9B%BE20190203120604.png)
![image](https://github.com/samdidemo/springboot-mybatis-mysql-/blob/master/image/QQ%E6%88%AA%E5%9B%BE20190203122401.png)
![image](https://github.com/samdidemo/springboot-mybatis-mysql-/blob/master/image/QQ%E6%88%AA%E5%9B%BE20190203122530.png)
![image](https://github.com/samdidemo/springboot-mybatis-mysql-/blob/master/image/QQ%E6%88%AA%E5%9B%BE20190203122549.png)
![image](https://github.com/samdidemo/springboot-mybatis-mysql-/blob/master/image/QQ%E6%88%AA%E5%9B%BE20190206225509.png)



