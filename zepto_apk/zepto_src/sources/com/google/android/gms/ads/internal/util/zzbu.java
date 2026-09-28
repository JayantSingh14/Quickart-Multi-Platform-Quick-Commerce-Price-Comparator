package com.google.android.gms.ads.internal.util;

/* loaded from: classes4.dex */
public final class zzbu {

    /* renamed from: a, reason: collision with root package name */
    public long f21544a;

    /* renamed from: b, reason: collision with root package name */
    public long f21545b = Long.MIN_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public final Object f21546c = new Object();

    public zzbu(long j2) {
        this.f21544a = j2;
    }

    public final boolean a() {
        synchronized (this.f21546c) {
            try {
                long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime();
                if (this.f21545b + this.f21544a > jElapsedRealtime) {
                    return false;
                }
                this.f21545b = jElapsedRealtime;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
