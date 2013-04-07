package cn.cdut.zhanglei.graduation.stock.oprations;

import cn.cdut.zhanglei.graduation.stock.config.AppConfig;
import android.os.Handler;

/**
 * 程序初始化操作
 * 
 * @author zhanglei
 * 
 */
public class InitOpt extends Thread {

	private Handler mHandler = null;
	
	public InitOpt(Handler handler) {
		super();
		this.mHandler = handler;

	}

	@Override
	public void run() {
		if (getDataFromInet() != null) {
			mHandler.sendMessage(mHandler.obtainMessage(AppConfig.LOGIN_WHAT,
					getDataFromInet()));
		}
		super.run();
	}

	/**
	 * 从网络之中获取数据
	 */
	public String getDataFromInet() {
		return null;
	}

	

}
