package cn.cdut.zhanglei.graduation.stock.oprations;

import java.util.Vector;

import android.os.Bundle;
import cn.cdut.zhanglei.graduation.stock.events.EventType;
import cn.cdut.zhanglei.graduation.stock.events.LoginEvent;
import cn.cdut.zhanglei.graduation.stock.events.StockEvent;
import cn.cdut.zhanglei.graduation.stock.models.impl.LoginModel;
import cn.cdut.zhanglei.graduation.stock.models.impl.UserModel;
import cn.cdut.zhanglei.graduation.stock.test.TestActivity;
import cn.cdut.zhanglei.graduation.stock.views.listener.StockEventListener;

/**
 * 如何接受一个外部事件呢？
 * 
 * 操作层
 * 
 * 封装该应用程序要做的一切
 *       
 * 对应用程序来说，一个常见的操作是用户登陆。
 * 
 * 这实际上是由两个子操作组成：首先从用户那里获得邮件地址和密码，然后从数据库载入“user”模型并检查密码是否匹配。
 * 
 * Operations是MOVE模式中的行动者。它负责修改模型，在正确的时间显示正确的视图，以及响应由用户交互引发的事件。
 * 在一个分解良好的应用程序中，每个子操作都可以独立运行。
 * 
 * 采用这种方式的操作有一点很令人振奋，即程序启动后，整个应用本身就可以被当作一个Operations。
 * 
 * 它会根据需要生成尽可能多的子操作，其中每个子操作都并行地运行。
 * 
 * 当所有子操作都完成时，程序也便退出
 * 
 * @author zhanglei
 * 
 */
public class UserOpt implements StockEventListener {
	public static final String TAG = "UserOpt";
	private String mUserName = null;// 用户名
	private String password = null;// 密码
	private static UserOpt mUserOpt = null;
	private StockEventListener mMyLoginListener = null;
	private LoginModel mLoginModel = new LoginModel();
	private TestActivity ts = null;
	public static synchronized UserOpt getInstance() {
		if (mUserOpt == null) {
			mUserOpt = new UserOpt();
		}
		return mUserOpt;
	}

	/**
	 * 处理用户登录操作
	 */
	public void userLogin(Bundle infos) {
			mUserName = infos.getString("name");
		System.out.println("UserOpt.userLogin()===="+"用戶登录.username="+infos.getString("name")+"pwd="+infos.getString("pwd"));
		if(mLoginModel==null){
			mLoginModel = new LoginModel();
		}
		mLoginModel.setmUsername(mUserName);
		mLoginModel.setCode(1);
		mLoginModel.setTs(ts);
		mLoginModel.notifyView();
	}

	/**
	 * 获取服务器返回的登录操作代码
	 */
	public int getCode() {
		return 0;
	}

	/**
	 * 用戶註銷
	 */

	public boolean userLogout() {
		return false;
	}

	/**
	 * 获取当前登录用户的用户名
	 * 
	 * @return
	 */
	public String getUserName() {
		return mUserName;
	}

	/**
	 * 设置当前登录用户
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.mUserName = userName;
	}

	/**
	 * 获取用户密码
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置密码
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public boolean removeLoginListener() {
		return false;
	}
	
	public void setLoginListener(StockEventListener l,TestActivity ts){
		if( l != null){
				this.mMyLoginListener = l;
		}
		this.ts = ts;
	}
	
	public void notifyLoginAttempt(Bundle datas){
		if(mMyLoginListener!=null){
			mMyLoginListener.handleEvent(new LoginEvent(this, EventType.LOGIN_EVENT, datas));
		}
	}

	@Override
	public void handleEvent(StockEvent event) {
			System.out.println("UserOpt.handleEvent()====="+event.getCurDateFormat2String());
			userLogin(((LoginEvent)event).getDatas());
	}
	
	
}
