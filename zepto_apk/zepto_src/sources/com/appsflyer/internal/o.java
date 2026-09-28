package com.appsflyer.internal;

import android.os.Process;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import io.sentry.android.ndk.SentryNdk;

/* loaded from: classes.dex */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15335a;

    public /* synthetic */ o(int i2) {
        this.f15335a = i2;
    }

    @Override // java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        switch (this.f15335a) {
            case 0:
                AFj1sSDK.getCurrencyIso4217Code();
                break;
            case 1:
                Process.setThreadPriority(0);
                ReactMarker.logMarker(ReactMarkerConstants.CHANGE_THREAD_PRIORITY, "js_default");
                break;
            case 2:
                Process.setThreadPriority(0);
                break;
            default:
                SentryNdk.lambda$static$0();
                break;
        }
    }
}
