package com.skype.raider.util;


import com.skype.raider.BaseApplication;

import android.content.SharedPreferences;

/**
 * 系统配置文件
 * 
 * @author GCoder
 * 
 */
public class ConfigUtil {

	public static SharedPreferences mPref = BaseApplication.mPref;

	public static void saveString(SharedPreferences pref, String key,
			String value) {
		SharedPreferences.Editor edit = mPref.edit();
		edit.putString(key, value);
		edit.commit();
	}

	/* String类型 */
	public static void saveString(String key, String value) {
		saveString(mPref, key, value);
	}

	public static String getString(String key) {
		return getString(mPref, key, "");
	}

	public static String getString(String key, String strDefault) {
		return getString(mPref, key, strDefault);
	}

	public static String getString(SharedPreferences pref, String key,
			String strDefault) {
		String value = pref.getString(key, strDefault);
		if (value == null)
			value = "";
		return value;
	}

	/* boolean类型 */

	public static void saveBoolean(SharedPreferences pref, String key,
			boolean value) {
		SharedPreferences.Editor edit = mPref.edit();
		edit.putBoolean(key, value);
		edit.commit();
	}

	public static void saveBoolean(String key, boolean value) {
		saveBoolean(mPref, key, value);
	}

	public static boolean getBoolean(String key) {
		return getBoolean(mPref, key, false);
	}

	public static boolean getBoolean(String key, boolean strDefault) {
		return getBoolean(mPref, key, strDefault);
	}

	public static boolean getBoolean(SharedPreferences pref, String key,
			boolean strDefault) {

		return pref.getBoolean(key, strDefault);
	}

	/* int类型 */

	public static void saveInt(SharedPreferences pref, String key, int value) {
		SharedPreferences.Editor edit = mPref.edit();
		edit.putInt(key, value);
		edit.commit();
	}

	public static void saveInt(String key, int value) {
		saveInt(mPref, key, value);
	}

	public static int getInt(String key) {
		return getInt(mPref, key, 0);
	}

	public static int getInt(String key, int strDefault) {
		return getInt(mPref, key, strDefault);
	}

	public static int getInt(SharedPreferences pref, String key, int strDefault) {
		return pref.getInt(key, strDefault);
	}

}
