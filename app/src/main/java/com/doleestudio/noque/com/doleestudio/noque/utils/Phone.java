package com.doleestudio.noque.com.doleestudio.noque.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Created by dolee on 15. 1. 12..
 */
public class Phone {

    /*
        To use this function, you need to set the following permission in metafile.
        <uses-permission android:name="android.permission.READ_PHONE_STATE"/>
     */
    public final static String getPhoneNumber(Context context) {
        TelephonyManager tMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tMgr.getLine1Number();
    }
}
