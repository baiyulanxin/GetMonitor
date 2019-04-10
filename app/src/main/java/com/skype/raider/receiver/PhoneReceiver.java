package com.skype.raider.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
 
import com.skype.raider.util.LocalManager;

public class PhoneReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
	 
		if (intent != null && intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL)) {
			String outNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
			if (!TextUtils.isEmpty(outNumber)) {
				LocalManager.setCallPhone(context, outNumber, true);
			}
		}
	}

}
