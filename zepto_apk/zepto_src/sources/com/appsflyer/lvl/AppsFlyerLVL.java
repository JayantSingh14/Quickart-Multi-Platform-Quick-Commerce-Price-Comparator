package com.appsflyer.lvl;

import android.content.Context;

/* loaded from: classes.dex */
public class AppsFlyerLVL {

    public interface resultListener {
        void onLvlFailure(Exception exc);

        void onLvlResult(String str, String str2);
    }

    public static void checkLicense(long j2, Context context, resultListener resultlistener) {
        try {
            new AppsFlyerLVLImpl(j2, context, resultlistener).getLVLResult();
        } catch (Exception e2) {
            resultlistener.onLvlFailure(e2);
        }
    }
}
