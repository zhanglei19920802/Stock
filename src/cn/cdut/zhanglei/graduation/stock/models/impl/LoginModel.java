package cn.cdut.zhanglei.graduation.stock.models.impl;

import android.os.Bundle;
import cn.cdut.zhanglei.graduation.stock.events.LoginSuccessEvent;
import cn.cdut.zhanglei.graduation.stock.models.NotifyViews;
import cn.cdut.zhanglei.graduation.stock.test.TestActivity;
/**
 * 处理用户登录的模型层
 * @author Administrator
 *
 */
public class LoginModel implements NotifyViews {
	private String mUsername = null;
	private boolean mIsLoginSuccess = false;
	private int code = 0;
	private TestActivity ts= null;
	private Bundle mBundle = new Bundle();
	public LoginModel(){
		super();
	}
	
	public LoginModel(String userName,int code){
		super();
		this.mUsername =userName;
		this.code =code;
	}
	public String getmUsername() {
		return mUsername;
	}

	public void setmUsername(String mUsername) {
		this.mUsername = mUsername;
	}

	public boolean ismIsLoginSuccess() {
		return mIsLoginSuccess;
	}

	public void setmIsLoginSuccess(boolean mIsLoginSuccess) {
		this.mIsLoginSuccess = mIsLoginSuccess;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public TestActivity getTs() {
		return ts;
	}

	public void setTs(TestActivity ts) {
		this.ts = ts;
	}

	@Override
	public void notifyView() {
		
		switch(code){
		case 0:
			System.out.println("LoginModel.notifyView()"+"未登录");
			
			break;
		case 1:
			System.out.println("LoginModel.notifyView()===="+"登录成功.userName="+this.mUsername);
			mBundle.putString("name", "zhanglei");
			mBundle.putInt("age", 21);
			ts.handleEvent(new LoginSuccessEvent(this, 2, mBundle));
			break;
			
			}
	}
}
