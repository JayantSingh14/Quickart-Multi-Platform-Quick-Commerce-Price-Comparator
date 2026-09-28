package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzeys implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final zzfzf f30599a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfzf f30600b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f30601c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f30602d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f30603e = false;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f30604f;

    public zzeys(zzfzf zzfzfVar, zzfzf zzfzfVar2, boolean z, boolean z2, boolean z3) {
        this.f30599a = zzfzfVar;
        this.f30600b = zzfzfVar2;
        this.f30601c = z;
        this.f30602d = z2;
        this.f30604f = z3;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    @Override // com.google.android.gms.internal.ads.zzezv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(java.lang.Object r10) {
        /*
            r9 = this;
            com.google.android.gms.internal.ads.zzczm r10 = (com.google.android.gms.internal.ads.zzczm) r10
            android.os.Bundle r10 = r10.f27481a
            boolean r0 = r9.f30603e
            if (r0 == 0) goto La
            goto La7
        La:
            java.lang.String r0 = "pii"
            android.os.Bundle r1 = com.google.android.gms.internal.ads.zzfiz.a(r10, r0)
            r2 = 0
            boolean r4 = r9.f30604f
            if (r4 != 0) goto L28
            com.google.android.gms.internal.ads.zzbgb r5 = com.google.android.gms.internal.ads.zzbgk.G3
            com.google.android.gms.ads.internal.client.zzbd r6 = com.google.android.gms.ads.internal.client.zzbd.f21150e
            com.google.android.gms.internal.ads.zzbgi r6 = r6.f21153c
            java.lang.Object r5 = r6.a(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L3c
        L28:
            if (r4 == 0) goto L52
            com.google.android.gms.internal.ads.zzbgb r5 = com.google.android.gms.internal.ads.zzbgk.I3
            com.google.android.gms.ads.internal.client.zzbd r6 = com.google.android.gms.ads.internal.client.zzbd.f21150e
            com.google.android.gms.internal.ads.zzbgi r6 = r6.f21153c
            java.lang.Object r5 = r6.a(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L52
        L3c:
            com.google.android.gms.internal.ads.zzfzf r5 = r9.f30599a
            java.lang.String r6 = r5.f32087a
            if (r6 == 0) goto L52
            long r7 = r5.f32088b
            int r5 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r5 <= 0) goto L52
            java.lang.String r5 = "paidv1_id_android"
            r1.putString(r5, r6)
            java.lang.String r5 = "paidv1_creation_time_android"
            r1.putLong(r5, r7)
        L52:
            if (r4 != 0) goto L66
            com.google.android.gms.internal.ads.zzbgb r5 = com.google.android.gms.internal.ads.zzbgk.H3
            com.google.android.gms.ads.internal.client.zzbd r6 = com.google.android.gms.ads.internal.client.zzbd.f21150e
            com.google.android.gms.internal.ads.zzbgi r6 = r6.f21153c
            java.lang.Object r5 = r6.a(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L7a
        L66:
            if (r4 == 0) goto L9e
            com.google.android.gms.internal.ads.zzbgb r4 = com.google.android.gms.internal.ads.zzbgk.J3
            com.google.android.gms.ads.internal.client.zzbd r5 = com.google.android.gms.ads.internal.client.zzbd.f21150e
            com.google.android.gms.internal.ads.zzbgi r5 = r5.f21153c
            java.lang.Object r4 = r5.a(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L9e
        L7a:
            com.google.android.gms.internal.ads.zzfzf r4 = r9.f30600b
            java.lang.String r5 = r4.f32087a
            if (r5 == 0) goto L90
            long r6 = r4.f32088b
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 <= 0) goto L90
            java.lang.String r2 = "paidv2_id_android"
            r1.putString(r2, r5)
            java.lang.String r2 = "paidv2_creation_time_android"
            r1.putLong(r2, r6)
        L90:
            boolean r2 = r9.f30601c
            java.lang.String r3 = "paidv2_pub_option_android"
            r1.putBoolean(r3, r2)
            boolean r2 = r9.f30602d
            java.lang.String r3 = "paidv2_user_option_android"
            r1.putBoolean(r3, r2)
        L9e:
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto La7
            r10.putBundle(r0, r1)
        La7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeys.zza(java.lang.Object):void");
    }

    public zzeys(boolean z) {
        this.f30604f = z;
    }
}
