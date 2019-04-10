package com.skype.raider;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class BaseApplication extends Application {

	public static final String TAG = "Application";
	// 图片缓存路径
	public static String IMG_CACHE_RELATIVE_PATH = "";

	public static Context mContext;
	public static SharedPreferences mPref;
	private static BaseApplication globalContext = null;
	private Activity activity = null;

	@Override
	public void onCreate() {
		super.onCreate();
		globalContext = this;
		mContext = this.getApplicationContext();
		mPref = PreferenceManager.getDefaultSharedPreferences(this);

	}

	public static BaseApplication getInstance() {
		return globalContext;
	}

}
