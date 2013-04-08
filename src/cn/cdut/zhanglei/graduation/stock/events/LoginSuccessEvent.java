package cn.cdut.zhanglei.graduation.stock.events;

import android.os.Bundle;

public class LoginSuccessEvent extends StockEvent{
	
	private Bundle datas = null;
	public LoginSuccessEvent(Object source, int EventType,Bundle datas) {
		super(source, EventType);
		this.datas =datas;
	}
	
	public Bundle getData(){
		if(this.datas!=null){
			return datas;
		}
		return null;
	}

	

}
