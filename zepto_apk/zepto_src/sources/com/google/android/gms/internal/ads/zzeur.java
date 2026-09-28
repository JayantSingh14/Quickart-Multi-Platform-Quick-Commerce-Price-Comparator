package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzeur implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f30360a;

    /* renamed from: b, reason: collision with root package name */
    public final zzduz f30361b;

    /* renamed from: c, reason: collision with root package name */
    public final String f30362c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfik f30363d;

    public zzeur(zzgyw zzgywVar, zzduz zzduzVar, zzfik zzfikVar, String str) {
        this.f30360a = zzgywVar;
        this.f30361b = zzduzVar;
        this.f30363d = zzfikVar;
        this.f30362c = str;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return ((zzgxi) this.f30360a).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzeuq
            /* JADX WARN: Removed duplicated region for block: B:24:0x007a  */
            @Override // java.util.concurrent.Callable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object call() {
                /*
                    r7 = this;
                    com.google.android.gms.internal.ads.zzeur r0 = r7.f30359a
                    com.google.android.gms.internal.ads.zzfik r1 = r0.f30363d
                    com.google.android.gms.internal.ads.zzduz r2 = r0.f30361b
                    r2.getClass()
                    com.google.android.gms.internal.ads.zzbgb r3 = com.google.android.gms.internal.ads.zzbgk.J4
                    com.google.android.gms.ads.internal.client.zzbd r4 = com.google.android.gms.ads.internal.client.zzbd.f21150e
                    com.google.android.gms.internal.ads.zzbgi r5 = r4.f21153c
                    java.lang.Object r3 = r5.a(r3)
                    java.lang.Boolean r3 = (java.lang.Boolean) r3
                    boolean r3 = r3.booleanValue()
                    com.google.android.gms.internal.ads.zzbgi r4 = r4.f21153c
                    r5 = 0
                    if (r3 != 0) goto L1f
                    goto L7a
                L1f:
                    java.lang.String r1 = r1.f31219g
                    if (r1 == 0) goto L7a
                    java.lang.String r0 = r0.f30362c
                    if (r0 == 0) goto L7a
                    boolean r3 = r2.f28618d
                    if (r3 != 0) goto L57
                    r2.a()
                    com.google.android.gms.internal.ads.zzbgb r3 = com.google.android.gms.internal.ads.zzbgk.K4
                    java.lang.Object r3 = r4.a(r3)
                    java.lang.Boolean r3 = (java.lang.Boolean) r3
                    boolean r3 = r3.booleanValue()
                    if (r3 == 0) goto L57
                    java.util.concurrent.atomic.AtomicBoolean r3 = r2.f28620f
                    r6 = 1
                    boolean r3 = r3.getAndSet(r6)
                    if (r3 != 0) goto L57
                    com.google.android.gms.ads.internal.zzt r3 = com.google.android.gms.ads.internal.zzt.C
                    com.google.android.gms.internal.ads.zzcda r3 = r3.f21684h
                    com.google.android.gms.ads.internal.util.zzj r3 = r3.g()
                    com.google.android.gms.internal.ads.zzduw r6 = new com.google.android.gms.internal.ads.zzduw
                    r6.<init>(r2)
                    java.util.ArrayList r3 = r3.f21582c
                    r3.add(r6)
                L57:
                    java.util.concurrent.ConcurrentHashMap r3 = r2.f28615a
                    java.lang.Object r3 = r3.get(r0)
                    java.util.Map r3 = (java.util.Map) r3
                    if (r3 == 0) goto L7a
                    java.lang.Object r6 = r3.get(r1)
                    org.json.JSONObject r6 = (org.json.JSONObject) r6
                    if (r6 == 0) goto L6a
                    goto L7b
                L6a:
                    org.json.JSONObject r6 = r2.f28619e
                    java.lang.String r0 = com.google.android.gms.internal.ads.zzdvb.a(r6, r1, r0)
                    if (r0 == 0) goto L7a
                    java.lang.Object r0 = r3.get(r0)
                    r6 = r0
                    org.json.JSONObject r6 = (org.json.JSONObject) r6
                    goto L7b
                L7a:
                    r6 = r5
                L7b:
                    com.google.android.gms.internal.ads.zzbgb r0 = com.google.android.gms.internal.ads.zzbgk.L4
                    java.lang.Object r0 = r4.a(r0)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L8a
                    goto L8c
                L8a:
                    org.json.JSONObject r5 = r2.f28616b
                L8c:
                    com.google.android.gms.internal.ads.zzeus r0 = new com.google.android.gms.internal.ads.zzeus
                    r0.<init>(r6, r5)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeuq.call():java.lang.Object");
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 17;
    }
}
