package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
abstract class zzay {

    /* renamed from: d, reason: collision with root package name */
    public static volatile com.google.android.gms.internal.measurement.zzcn f38735d;

    /* renamed from: a, reason: collision with root package name */
    public final zzjf f38736a;

    /* renamed from: b, reason: collision with root package name */
    public final Runnable f38737b;

    /* renamed from: c, reason: collision with root package name */
    public volatile long f38738c;

    public zzay(zzjf zzjfVar) {
        Preconditions.checkNotNull(zzjfVar);
        this.f38736a = zzjfVar;
        this.f38737b = new zzax(this, zzjfVar);
    }

    public abstract void a();

    public final void b(long j2) {
        c();
        if (j2 >= 0) {
            zzjf zzjfVar = this.f38736a;
            this.f38738c = zzjfVar.f().currentTimeMillis();
            if (d().postDelayed(this.f38737b, j2)) {
                return;
            }
            zzjfVar.b().f38958f.b(Long.valueOf(j2), "Failed to schedule delayed post. time");
        }
    }

    public final void c() {
        this.f38738c = 0L;
        d().removeCallbacks(this.f38737b);
    }

    public final Handler d() {
        com.google.android.gms.internal.measurement.zzcn zzcnVar;
        if (f38735d != null) {
            return f38735d;
        }
        synchronized (zzay.class) {
            try {
                if (f38735d == null) {
                    f38735d = new com.google.android.gms.internal.measurement.zzcn(this.f38736a.e().getMainLooper());
                }
                zzcnVar = f38735d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzcnVar;
    }
}
