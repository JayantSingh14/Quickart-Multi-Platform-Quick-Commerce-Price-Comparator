package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* loaded from: classes4.dex */
final class zzejt implements zzdlh {

    /* renamed from: a, reason: collision with root package name */
    public final VersionInfoParcel f29498a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcdt f29499b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfhr f29500c;

    /* renamed from: d, reason: collision with root package name */
    public final zzcir f29501d;

    /* renamed from: e, reason: collision with root package name */
    public final zzfik f29502e;

    /* renamed from: f, reason: collision with root package name */
    public final zzbnq f29503f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f29504g;

    /* renamed from: h, reason: collision with root package name */
    public final zzeif f29505h;

    /* renamed from: i, reason: collision with root package name */
    public final zzdxe f29506i;

    public zzejt(VersionInfoParcel versionInfoParcel, zzcdt zzcdtVar, zzfhr zzfhrVar, zzcir zzcirVar, zzfik zzfikVar, boolean z, zzbnq zzbnqVar, zzeif zzeifVar, zzdxe zzdxeVar) {
        this.f29498a = versionInfoParcel;
        this.f29499b = zzcdtVar;
        this.f29500c = zzfhrVar;
        this.f29501d = zzcirVar;
        this.f29502e = zzfikVar;
        this.f29504g = z;
        this.f29503f = zzbnqVar;
        this.f29505h = zzeifVar;
        this.f29506i = zzdxeVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006c  */
    @Override // com.google.android.gms.internal.ads.zzdlh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(boolean r17, android.content.Context r18, com.google.android.gms.internal.ads.zzdax r19) {
        /*
            r16 = this;
            r1 = r16
            com.google.android.gms.internal.ads.zzcdt r0 = r1.f29499b
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzgym.m(r0)
            com.google.android.gms.internal.ads.zzcsn r0 = (com.google.android.gms.internal.ads.zzcsn) r0
            com.google.android.gms.internal.ads.zzcir r4 = r1.f29501d
            r15 = 1
            r4.g0(r15)
            com.google.android.gms.ads.internal.zzl r5 = new com.google.android.gms.ads.internal.zzl
            com.google.android.gms.internal.ads.zzbnq r2 = r1.f29503f
            boolean r3 = r1.f29504g
            if (r3 == 0) goto L1d
            boolean r6 = r2.a(r15)
            goto L1e
        L1d:
            r6 = r15
        L1e:
            r7 = 0
            if (r3 == 0) goto L29
            monitor-enter(r2)
            boolean r8 = r2.f25353b     // Catch: java.lang.Throwable -> L2b
            monitor-exit(r2)
            if (r8 == 0) goto L29
            r8 = r15
            goto L2e
        L29:
            r8 = r7
            goto L2e
        L2b:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2b
            throw r0
        L2e:
            if (r3 == 0) goto L39
            monitor-enter(r2)
            float r3 = r2.f25354c     // Catch: java.lang.Throwable -> L36
            monitor-exit(r2)
        L34:
            r9 = r3
            goto L3b
        L36:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L36
            throw r0
        L39:
            r3 = 0
            goto L34
        L3b:
            com.google.android.gms.internal.ads.zzfhr r2 = r1.f29500c
            boolean r11 = r2.O
            r12 = 0
            r7 = 1
            r10 = r17
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            if (r19 == 0) goto L4b
            r19.w0()
        L4b:
            com.google.android.gms.ads.internal.zzt r3 = com.google.android.gms.ads.internal.zzt.C
            com.google.android.gms.ads.internal.overlay.zzn r3 = r3.f21678b
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = new com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
            com.google.android.gms.internal.ads.zzdkw r0 = r0.i()
            com.google.android.gms.internal.ads.zzfik r6 = r1.f29502e
            int r7 = r2.Q
            r8 = -1
            if (r7 == r8) goto L5d
            goto L73
        L5d:
            com.google.android.gms.ads.internal.client.zzx r8 = r6.f31223k
            if (r8 == 0) goto L6c
            int r8 = r8.f21306a
            if (r8 != r15) goto L67
            r7 = 7
            goto L73
        L67:
            r9 = 2
            if (r8 != r9) goto L6c
            r7 = 6
            goto L73
        L6c:
            int r8 = com.google.android.gms.ads.internal.util.zze.f21576b
            java.lang.String r8 = "Error setting app open orientation; no targeting orientation available."
            com.google.android.gms.ads.internal.util.client.zzo.a(r8)
        L73:
            com.google.android.gms.internal.ads.zzfhw r8 = r2.s
            java.lang.String r9 = r8.f31180b
            boolean r10 = r2.b()
            if (r10 == 0) goto L81
            com.google.android.gms.internal.ads.zzeif r10 = r1.f29505h
        L7f:
            r13 = r10
            goto L83
        L81:
            r10 = 0
            goto L7f
        L83:
            java.lang.String r11 = r6.f31219g
            java.lang.String r14 = r4.zzn()
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r6 = r1.f29498a
            java.lang.String r2 = r2.B
            java.lang.String r10 = r8.f31179a
            r12 = r19
            r8 = r5
            r5 = r7
            r7 = r2
            r2 = r3
            r3 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            com.google.android.gms.internal.ads.zzdxe r0 = r1.f29506i
            r3 = r18
            com.google.android.gms.ads.internal.overlay.zzn.a(r3, r2, r15, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzejt.a(boolean, android.content.Context, com.google.android.gms.internal.ads.zzdax):void");
    }

    @Override // com.google.android.gms.internal.ads.zzdlh
    public final zzfhr zzb() {
        return this.f29500c;
    }
}
