package cn.cdut.zhanglei.graduation.stock.bean;

import java.io.Serializable;

/**
 * 股票实例类
 * 
 * @author 张雷
 * 
 */
public class StockBean implements Serializable {

	private static final long serialVersionUID = 3967017674351550076L;
	public static final String TAG = "StockBean";
	private String id = null;
	private String Name = null;

	public StockBean() {
		super();
	}

	public StockBean(String id, String name) {
		// super();
		this.id = id;
		Name = name;
	}

}
