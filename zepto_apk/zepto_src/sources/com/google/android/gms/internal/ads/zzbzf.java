package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Objects;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
final class zzbzf implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f25772a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbzh f25773b;

    public zzbzf(zzbzh zzbzhVar, Context context) {
        this.f25772a = context;
        Objects.requireNonNull(zzbzhVar);
        this.f25773b = zzbzhVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0036  */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object call() {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzbzh r0 = r7.f25773b
            java.util.WeakHashMap r1 = r0.f25776a
            android.content.Context r2 = r7.f25772a
            java.lang.Object r1 = r1.get(r2)
            com.google.android.gms.internal.ads.zzbzg r1 = (com.google.android.gms.internal.ads.zzbzg) r1
            if (r1 == 0) goto L36
            com.google.android.gms.internal.ads.zzbhu r3 = com.google.android.gms.internal.ads.zzbhz.f25110d
            java.lang.Object r3 = r3.c()
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            long r5 = r1.f25774a
            long r5 = r5 + r3
            com.google.android.gms.ads.internal.zzt r3 = com.google.android.gms.ads.internal.zzt.C
            com.google.android.gms.common.util.Clock r3 = r3.f21687k
            long r3 = r3.currentTimeMillis()
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 >= 0) goto L2a
            goto L36
        L2a:
            com.google.android.gms.internal.ads.zzbzd r3 = new com.google.android.gms.internal.ads.zzbzd
            com.google.android.gms.internal.ads.zzbze r1 = r1.f25775b
            r3.<init>(r2, r1)
            com.google.android.gms.internal.ads.zzbze r1 = r3.a()
            goto L3f
        L36:
            com.google.android.gms.internal.ads.zzbzd r1 = new com.google.android.gms.internal.ads.zzbzd
            r1.<init>(r2)
            com.google.android.gms.internal.ads.zzbze r1 = r1.a()
        L3f:
            com.google.android.gms.internal.ads.zzbzg r3 = new com.google.android.gms.internal.ads.zzbzg
            r3.<init>(r0, r1)
            java.util.WeakHashMap r0 = r0.f25776a
            r0.put(r2, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbzf.call():java.lang.Object");
    }
}
