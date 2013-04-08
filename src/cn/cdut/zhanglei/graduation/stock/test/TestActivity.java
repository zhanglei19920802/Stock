package cn.cdut.zhanglei.graduation.stock.test;

import cn.cdut.zhanglei.graduation.stock.events.LoginSuccessEvent;
import cn.cdut.zhanglei.graduation.stock.events.StockEvent;
import cn.cdut.zhanglei.graduation.stock.oprations.UserOpt;
import cn.cdut.zhanglei.graduation.stock.views.MainAcitvity;
import cn.cdut.zhanglei.graduation.stock.views.extend.MyDialog;
import cn.cdut.zhanglei.graduation.stock.views.extend.Style;
import cn.cdut.zhanglei.graduation.stock.views.listener.StockEventListener;

import cn.cdut.zhangleigraduation.stock.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TestActivity extends Activity implements StockEventListener {
	private Button login = null;
	private StockEventListener mlistener = null;
	private MyDialog dialog = null;
	private OnClickListener loginListener = new OnClickListener() {

		@Override
		public void onClick(View v) {

			Bundle datas = new Bundle();
			datas.putString("name", "zhanglei");
			datas.putString("pwd", "920802");

			mUserOpt.notifyLoginAttempt(datas);

			MyDialog.drawable = Style.Circl_4;
			dialog.show();
		}
	};
	private UserOpt mUserOpt = null;
	public static TestActivity _this = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);

		login = (Button) this.findViewById(R.id.login);
		login.setOnClickListener(loginListener);
		dialog = new MyDialog(TestActivity.this, "登录中");

		mUserOpt = UserOpt.getInstance();
		mUserOpt.setLoginListener(mUserOpt, this);
		mlistener = this;

	}

	public static synchronized TestActivity getInstance() {
		if (_this == null) {
			_this = new TestActivity();
		}

		return _this;
	}

	@Override
	public void handleEvent(StockEvent event) {

		System.out.println("TestActivity.handleEvent()====="
				+ ((LoginSuccessEvent) event).getData().getString("name"));

		this.startActivity(new Intent(this, MainAcitvity.class));
		finish();
		// if (dialog != null) {
		// // dialog.cancel();
		// dialog.distory();
		// // login.setText("登录成功");
		// }

		// TextView tx = new TextView(this);
		// tx.setText("登录成功");
		// LayoutInflater inflator =
		// (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	}

}
