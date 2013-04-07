package cn.cdut.zhanglei.graduation.stock;

import android.app.Application;

/**
 *   Application 全局数据对象存储
 * @author zhanglei
 *
 */

public class StockApplication extends Application {
	public static final String TAG = "StockApplication";
	private  static StockApplication application = null;
		//global vars
		private String userName = null;
		private String password = null;
		private int Port = 0;
		private String IP = null;
	
	

	public synchronized static StockApplication getInstance(){
		if(application ==null){
			application = new StockApplication();
		}
		return application;
	}

	@Override
	public void onCreate() {
		System.out.println("StockApplication.onCreate():::"+TAG);
		super.onCreate();
	}
	
	
	public synchronized static void setApplication(StockApplication application){
			StockApplication.application = application;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPort() {
		return Port;
	}

	public void setPort(int port) {
		Port = port;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}
	
	
	
}
