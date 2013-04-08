package cn.cdut.zhanglei.graduation.stock.events;

import java.util.Calendar;
import java.util.EventObject;

import cn.cdut.zhanglei.graduation.stock.utils.DateUtil;

public class StockEvent extends EventObject {

	private static final long serialVersionUID = -8988150771679761943L;

	public static final String TAG = "StockEvent";

	private int mEventType = EventType.INIT;
	private Calendar mCurTime = null;

	public StockEvent(Object source, int EventType) {
		super(source);
		this.mEventType = EventType;
		this.mCurTime = Calendar.getInstance();
		System.out.println("InitEvent.InitEvent()");

	}

	/**
	 * 返回将Calendar格式化之后的字符串
	 * 
	 * @return
	 */
	public String getCurDateFormat2String() {
		return DateUtil.formatCalendar2String(mCurTime);
	}

	public int getEventType() {
		return mEventType;
	}

}
