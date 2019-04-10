package com.skype.raider;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class UninstallerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		//showToast("该应用已锁定，禁止卸载!", Style.CONFIRM);

		this.finish();
	}


}
