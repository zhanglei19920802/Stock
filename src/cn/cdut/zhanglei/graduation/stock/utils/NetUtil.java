package cn.cdut.zhanglei.graduation.stock.utils;


import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

public class NetUtil {
	
	/**
	 * 检测网络是否链接
	 * @param connectManager
	 * @return 连接返回真,否则返回false
	 */
	public  static boolean chkNetState(ConnectivityManager connectManager) {
		State stateWIFI = connectManager.getNetworkInfo(
				ConnectivityManager.TYPE_WIFI).getState();
		State stateMOBILE = connectManager.getNetworkInfo(
				ConnectivityManager.TYPE_MOBILE).getState();

		if (stateWIFI != NetworkInfo.State.CONNECTED
				&& stateMOBILE != NetworkInfo.State.CONNECTED) {// 未连接
			return false;
		}

		return true;
	}
}
