package cn.cdut.zhanglei.graduation.stock.views.listener;

import java.util.EventListener;

import cn.cdut.zhanglei.graduation.stock.events.StockEvent;

public interface StockEventListener extends EventListener {
	public abstract void handleEvent(StockEvent event);
}
