package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.util.CrashUtils;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
final class zzcdm implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.zzf f25980a = new com.google.android.gms.ads.internal.util.zzf(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            this.f25980a.post(runnable);
            return;
        }
        try {
            runnable.run();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
            Context context = com.google.android.gms.ads.internal.zzt.C.f21684h.f25935e;
            if (context != null) {
                try {
                    if (((Boolean) zzbit.f25214b.c()).booleanValue()) {
                        CrashUtils.addDynamiteErrorToDropBox(context, th);
                    }
                } catch (IllegalStateException unused) {
                }
            }
            throw th;
        }
    }
}
