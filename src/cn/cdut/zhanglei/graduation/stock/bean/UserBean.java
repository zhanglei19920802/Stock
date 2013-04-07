package cn.cdut.zhanglei.graduation.stock.bean;

import java.io.Serializable;

/**
 * 用户实例类
 * 
 * @author Administrator
 * 
 */
public class UserBean implements Serializable {
	public static final String TAG = "UserBean";
	private static final long serialVersionUID = 229935505382955702L;
	private String userName = null;

	public UserBean() {
		super();
	}

	public UserBean(String userName) {
		this.userName = userName;
	}

}
