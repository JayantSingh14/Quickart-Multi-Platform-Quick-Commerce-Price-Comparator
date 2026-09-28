package com.google.android.play.core.splitinstall;

import android.content.Context;

/* loaded from: classes4.dex */
public final class SplitInstallManagerFactory {
    public static SplitInstallManager a(Context context) {
        zzp zzpVar;
        synchronized (zzu.class) {
            try {
                if (zzu.f42135a == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    zzu.f42135a = new zze(new zzac(context));
                }
                zzpVar = zzu.f42135a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return (SplitInstallManager) ((zze) zzpVar).f42118i.zza();
    }
}
