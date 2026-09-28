package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes4.dex */
public class zzfsh implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public boolean f31783a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f31784b;

    /* renamed from: c, reason: collision with root package name */
    public zzfsg f31785c;

    public boolean a() {
        return false;
    }

    public void b(boolean z) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (!this.f31784b) {
            this.f31784b = true;
            if (this.f31783a) {
                b(true);
                zzfsg zzfsgVar = this.f31785c;
                if (zzfsgVar != null) {
                    zzfsgVar.a(true);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        boolean z = runningAppProcessInfo.importance == 100 || a();
        if (this.f31784b != z) {
            this.f31784b = z;
            if (this.f31783a) {
                b(z);
                zzfsg zzfsgVar = this.f31785c;
                if (zzfsgVar != null) {
                    zzfsgVar.a(z);
                }
            }
        }
    }
}
