package cn.cdut.zhanglei.graduation.stock.events;

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

public class LoginEvent extends Event {

	private static final long serialVersionUID = -1017166192708651040L;

	public LoginEvent(Object source, int EventType) {
		super(source, EventType);

	}

}
