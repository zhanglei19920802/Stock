package cn.cdut.zhanglei.graduation.stock.views;


import cn.cdut.zhanglei.graduation.stock.config.AppConfig;
import cn.cdut.zhanglei.graduation.stock.utils.NetUtil;
import cn.cdut.zhangleigraduation.stock.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;

/**
 * 启动Activity
 * 主要负责网络的连接和程序的初始化
 * 
 * @author Administrator
 * 
 * 
 *         视图层的原则: 用户能够看到的内容,以及能够能感受到的互动都由视图提供支持
 * 
 *         视图不会直接改变Model,他只是向Operations发起事件,然后通过监听器等待由模型发起的事件
 * 
 * 
 */

public class StartActivity extends Activity {
	public static final String TAG = "StartActivity";

	private ConnectivityManager mConnManager = null;
	private long mStartTime = System.currentTimeMillis();
	private long mEndTime = System.currentTimeMillis();
	
	private Handler mLoginHanlder = new Handler() {

		@Override
		public void handleMessage(Message msg) {

			if (msg.what == AppConfig.LOGIN_WHAT) {
				
			}
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		android.os.Debug.startMethodTracing(TAG);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_views_startactivity);

		mConnManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

	}

	@Override
	protected void onDestroy() {

		android.os.Debug.stopMethodTracing();

		super.onDestroy();
	}

	/**
	 * 处理登录
	 */
	public void processLogin() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while(mEndTime-mStartTime<2000){
						
					
					if(NetUtil.chkNetState(mConnManager)){
						//处理网络链接
					}else{
						changeNetDialog();
					}
					
					mEndTime=System.currentTimeMillis();
						
				}
				mLoginHanlder.sendEmptyMessage(AppConfig.LOGIN_WHAT);
				
				
			}
		}).start();
	}

	/**
	 * 创建修改网络对话框
	 */
	public void changeNetDialog(){
	Builder dialog =  new AlertDialog.Builder(StartActivity.this);
	dialog.setTitle(R.string.app_name);
	dialog.setMessage(R.string.welcomea_activity_no_network);
	dialog.setPositiveButton(R.string.welcomea_activity_confirm, new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface arg0, int arg1) {
			startActivity(new Intent(android.provider.Settings.ACTION_NETWORK_OPERATOR_SETTINGS));
			
		}
	});
	dialog.setNegativeButton(R.string.welcomea_activity_cancel, new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int which) {
			finish();
		}
	});
	
	dialog.create().show();
	
	}
}
