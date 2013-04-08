package cn.cdut.zhanglei.graduation.stock.events;

import android.os.Bundle;

/**
 * 登录事件
 * 
 * 规则：
 * 
 * 例如事件监听让MOVE实现控制反转,视图会发生LoginAttempt事件。
 * 
 * 在登录操作完成之后,CurUser模型会发起一个事件通知应用程序状态已经改变
 * 
 * @author Administrator
 * 
 */

public class LoginEvent extends StockEvent {

	private Bundle datas = null;

	public LoginEvent(Object source, int EventType, Bundle datas) {
		super(source, EventType);
		this.datas = datas;

	}

	public Bundle getDatas(){
		return datas;
	}
}
