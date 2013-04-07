package cn.cdut.zhanglei.graduation.stock.models;

/**
 * 模型层
 * 
 * 在一个MOVE模式的Models中只包装知识。
 * 这意味着除了Get和Set功能，它们可以包含检查用户密码是否正确这样的方法，但不会包含把密码保存到数据库或传递给外部API这样的功能，因为后面这些工作将由Operations来完成。
 * 该层只封装应用程序所需知道的一切
 * 
 * @author zhanglei
 *
 */
public interface UserModel {


	public boolean isLogin();
	public boolean isLock();
	
}

