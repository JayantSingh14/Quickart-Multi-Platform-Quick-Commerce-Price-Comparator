package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzow implements zzgv {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f39570a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzpi f39571b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzpf f39572c;

    public zzow(zzpf zzpfVar, String str, zzpi zzpiVar) {
        this.f39570a = str;
        this.f39571b = zzpiVar;
        Objects.requireNonNull(zzpfVar);
        this.f39572c = zzpfVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001f A[Catch: all -> 0x000b, TRY_ENTER, TryCatch #0 {all -> 0x000b, blocks: (B:4:0x0008, B:20:0x0058, B:23:0x007c, B:14:0x001f, B:16:0x0045, B:18:0x0050, B:19:0x0054), top: B:28:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0054 A[Catch: all -> 0x000b, TryCatch #0 {all -> 0x000b, blocks: (B:4:0x0008, B:20:0x0058, B:23:0x007c, B:14:0x001f, B:16:0x0045, B:18:0x0050, B:19:0x0054), top: B:28:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.lang.String] */
    @Override // com.google.android.gms.measurement.internal.zzgv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.String r6, int r7, java.io.IOException r8, byte[] r9, java.util.Map r10) {
        /*
            r5 = this;
            com.google.android.gms.measurement.internal.zzpf r6 = r5.f39572c
            androidx.fragment.app.e.y(r6)
            r10 = 0
            if (r9 != 0) goto Le
            byte[] r9 = new byte[r10]     // Catch: java.lang.Throwable -> Lb
            goto Le
        Lb:
            r7 = move-exception
            goto L94
        Le:
            com.google.android.gms.measurement.internal.zzpi r0 = r5.f39571b
            r1 = 200(0xc8, float:2.8E-43)
            long r2 = r0.f39617a
            java.lang.String r0 = r5.f39570a
            if (r7 == r1) goto L1d
            r1 = 204(0xcc, float:2.86E-43)
            if (r7 != r1) goto L58
            r7 = r1
        L1d:
            if (r8 != 0) goto L58
            com.google.android.gms.measurement.internal.zzav r8 = r6.f39596c     // Catch: java.lang.Throwable -> Lb
            com.google.android.gms.measurement.internal.zzpf.S(r8)     // Catch: java.lang.Throwable -> Lb
            java.lang.Long r9 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> Lb
            r8.n(r9)     // Catch: java.lang.Throwable -> Lb
            com.google.android.gms.measurement.internal.zzgt r8 = r6.b()     // Catch: java.lang.Throwable -> Lb
            com.google.android.gms.measurement.internal.zzgr r8 = r8.n     // Catch: java.lang.Throwable -> Lb
            java.lang.String r9 = "Successfully uploaded batch from upload queue. appId, status"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> Lb
            r8.c(r9, r0, r7)     // Catch: java.lang.Throwable -> Lb
            com.google.android.gms.measurement.internal.zzgy r7 = r6.f39595b     // Catch: java.lang.Throwable -> Lb
            com.google.android.gms.measurement.internal.zzpf.S(r7)     // Catch: java.lang.Throwable -> Lb
            boolean r7 = r7.k()     // Catch: java.lang.Throwable -> Lb
            if (r7 == 0) goto L54
            com.google.android.gms.measurement.internal.zzav r7 = r6.f39596c     // Catch: java.lang.Throwable -> Lb
            com.google.android.gms.measurement.internal.zzpf.S(r7)     // Catch: java.lang.Throwable -> Lb
            boolean r7 = r7.m(r0)     // Catch: java.lang.Throwable -> Lb
            if (r7 == 0) goto L54
            r6.t(r0)     // Catch: java.lang.Throwable -> Lb
            goto L8e
        L54:
            r6.L()     // Catch: java.lang.Throwable -> Lb
            goto L8e
        L58:
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Throwable -> Lb
            java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> Lb
            r1.<init>(r9, r4)     // Catch: java.lang.Throwable -> Lb
            int r9 = r1.length()     // Catch: java.lang.Throwable -> Lb
            r4 = 32
            int r9 = java.lang.Math.min(r4, r9)     // Catch: java.lang.Throwable -> Lb
            java.lang.String r9 = r1.substring(r10, r9)     // Catch: java.lang.Throwable -> Lb
            com.google.android.gms.measurement.internal.zzgt r1 = r6.b()     // Catch: java.lang.Throwable -> Lb
            com.google.android.gms.measurement.internal.zzgr r1 = r1.f38963k     // Catch: java.lang.Throwable -> Lb
            java.lang.String r4 = "Network upload failed. Will retry later. appId, status, error"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> Lb
            if (r8 != 0) goto L7c
            r8 = r9
        L7c:
            r1.d(r4, r0, r7, r8)     // Catch: java.lang.Throwable -> Lb
            com.google.android.gms.measurement.internal.zzav r7 = r6.f39596c     // Catch: java.lang.Throwable -> Lb
            com.google.android.gms.measurement.internal.zzpf.S(r7)     // Catch: java.lang.Throwable -> Lb
            java.lang.Long r8 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> Lb
            r7.s(r8)     // Catch: java.lang.Throwable -> Lb
            r6.L()     // Catch: java.lang.Throwable -> Lb
        L8e:
            r6.u = r10
            r6.M()
            return
        L94:
            r6.u = r10
            r6.M()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzow.a(java.lang.String, int, java.io.IOException, byte[], java.util.Map):void");
    }
}
