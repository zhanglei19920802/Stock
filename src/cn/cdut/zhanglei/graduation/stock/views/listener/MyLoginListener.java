package cn.cdut.zhanglei.graduation.stock.views.listener;

import android.content.Context;
import cn.cdut.zhanglei.graduation.stock.events.Event;
import cn.cdut.zhanglei.graduation.stock.events.EventType;
import cn.cdut.zhanglei.graduation.stock.events.LoginEvent;
import cn.cdut.zhanglei.graduation.stock.oprations.UserOpt.LoginListener;
/**
 * 操作层应该采用单实例模式,因为操作层过多,可能会影响程序运行的性能
 * 
 * 
 * 登录监听器
 * 
 * 当View发送一个登录事件的时候，
 * @author zhanglei
 *
 */
public class MyLoginListener implements LoginListener {
	public static final String TAG = "MyLoginListener";

	private Context mCtx = null;

	public MyLoginListener(Context ctx) {
		super();
		this.mCtx = ctx;

	}

	@Override
	public void doLogin(LoginEvent event) {
		if (event.getSource() == null) {
			try {
				throw new Exception("事件源为空");
			} catch (Exception e) {
				System.out.println("MyLoginListener.doLogin()+++++"+e.getMessage());
			}
			
			if(event.getEventType()==EventType.LOGIN_EVENT){
				//执行登录.调用操作层
			}
		}
	}

	@Override
	public void doLogout(LoginEvent event) {
		if (event.getSource() == null) {
			try {
				throw new Exception("事件源为空");
			} catch (Exception e) {
				System.out.println("MyLoginListener.doLogout()++++"+e.getMessage());
			}
			
			if(event.getEventType()==EventType.LOGOUT_EVENT){
				//执行退出，调用相应的操作层
				
			}
		}
	}

	public Context getContext() {
		return this.mCtx;
	}
}
