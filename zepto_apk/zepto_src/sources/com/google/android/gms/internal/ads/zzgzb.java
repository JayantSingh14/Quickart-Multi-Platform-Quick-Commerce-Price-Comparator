package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgxf;

/* loaded from: classes4.dex */
final class zzgzb extends zzgxf.zzf implements Runnable {

    /* renamed from: h, reason: collision with root package name */
    public final Runnable f33394h;

    public zzgzb(Runnable runnable) {
        runnable.getClass();
        this.f33394h = runnable;
    }

    @Override // com.google.android.gms.internal.ads.zzgxf
    public final String f() {
        String string = this.f33394h.toString();
        return android.support.v4.media.b.s(new StringBuilder(string.length() + 7), "task=[", string, "]");
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f33394h.run();
        } catch (Throwable th) {
            d(th);
            throw th;
        }
    }
}
