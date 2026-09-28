package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.os.StrictMode;
import com.google.android.gms.internal.ads.zzbxv;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzcb {
    public static Object a(Context context, Callable callable) {
        try {
            StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
            try {
                StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
                return callable.call();
            } finally {
                StrictMode.setThreadPolicy(threadPolicy);
            }
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.d("Unexpected exception.", th);
            zzbxv.c(context).a("StrictModeUtil.runWithLaxStrictMode", th);
            return null;
        }
    }
}
