package com.google.android.play.core.appupdate;

import android.content.Context;
import com.facebook.react.bridge.ReactApplicationContext;

/* loaded from: classes.dex */
public final class AppUpdateManagerFactory {
    public static AppUpdateManager a(ReactApplicationContext reactApplicationContext) {
        zza zzaVar;
        synchronized (zzb.class) {
            try {
                if (zzb.f41713a == null) {
                    Context applicationContext = reactApplicationContext.getApplicationContext();
                    if (applicationContext != null) {
                        reactApplicationContext = applicationContext;
                    }
                    zzb.f41713a = new zzz(new zzi(reactApplicationContext));
                }
                zzaVar = zzb.f41713a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return (AppUpdateManager) ((zzz) zzaVar).f41753e.zza();
    }
}
