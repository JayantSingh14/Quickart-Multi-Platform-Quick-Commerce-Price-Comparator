package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzbrl extends zzcea {

    /* renamed from: c, reason: collision with root package name */
    public final Object f25478c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public final zzbrq f25479d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f25480e;

    public zzbrl(zzbrq zzbrqVar) {
        this.f25479d = zzbrqVar;
    }

    public final void d() {
        com.google.android.gms.ads.internal.util.zze.k("release: Trying to acquire lock");
        synchronized (this.f25478c) {
            try {
                com.google.android.gms.ads.internal.util.zze.k("release: Lock acquired");
                if (this.f25480e) {
                    com.google.android.gms.ads.internal.util.zze.k("release: Lock already released");
                    return;
                }
                this.f25480e = true;
                a(new zzbri(), new zzcdw());
                a(new zzbrj(this), new zzbrk(this));
                com.google.android.gms.ads.internal.util.zze.k("release: Lock released");
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
