package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import java.io.EOFException;
import java.io.InterruptedIOException;

/* loaded from: classes4.dex */
public final class zzapf implements zzaeo {

    /* renamed from: e, reason: collision with root package name */
    public boolean f24054e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f24055f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f24056g;

    /* renamed from: h, reason: collision with root package name */
    public long f24057h;

    /* renamed from: i, reason: collision with root package name */
    public zzapb f24058i;

    /* renamed from: j, reason: collision with root package name */
    public zzaer f24059j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f24060k;

    /* renamed from: a, reason: collision with root package name */
    public final zzfg f24050a = new zzfg();

    /* renamed from: c, reason: collision with root package name */
    public final zzer f24052c = new zzer(4096);

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray f24051b = new SparseArray();

    /* renamed from: d, reason: collision with root package name */
    public final zzapc f24053d = new zzapc();

    /* JADX WARN: Removed duplicated region for block: B:14:0x0021  */
    @Override // com.google.android.gms.internal.ads.zzaeo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(long r5, long r7) {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzfg r5 = r4.f24050a
            monitor-enter(r5)
            long r0 = r5.f31048b     // Catch: java.lang.Throwable -> L46
            monitor-exit(r5)
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L21
            long r0 = r5.a()
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L24
            r2 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L24
            int r6 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r6 == 0) goto L24
        L21:
            r5.b(r7)
        L24:
            com.google.android.gms.internal.ads.zzapb r5 = r4.f24058i
            r6 = 0
            if (r5 == 0) goto L2c
            r5.a(r7)
        L2c:
            r5 = r6
        L2d:
            android.util.SparseArray r7 = r4.f24051b
            int r8 = r7.size()
            if (r5 >= r8) goto L45
            java.lang.Object r7 = r7.valueAt(r5)
            com.google.android.gms.internal.ads.zzapd r7 = (com.google.android.gms.internal.ads.zzapd) r7
            r7.f24048f = r6
            com.google.android.gms.internal.ads.zzaog r7 = r7.f24043a
            r7.zza()
            int r5 = r5 + 1
            goto L2d
        L45:
            return
        L46:
            r6 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L46
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzapf.a(long, long):void");
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void b(zzaer zzaerVar) {
        this.f24059j = zzaerVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final boolean c(zzaep zzaepVar) throws EOFException, InterruptedIOException {
        byte[] bArr = new byte[14];
        zzaef zzaefVar = (zzaef) zzaepVar;
        zzaefVar.t(bArr, 0, 14, false);
        if ((((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) == 442 && (bArr[4] & 196) == 68 && (bArr[6] & 4) == 4 && (bArr[8] & 4) == 4 && (bArr[9] & 1) == 1 && (bArr[12] & 3) == 3) {
            zzaefVar.f(bArr[13] & 7, false);
            zzaefVar.t(bArr, 0, 3, false);
            if ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[2] & 255)) == 1) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0229  */
    @Override // com.google.android.gms.internal.ads.zzaeo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int d(com.google.android.gms.internal.ads.zzaep r26, com.google.android.gms.internal.ads.zzafo r27) throws java.io.EOFException, java.io.InterruptedIOException {
        /*
            Method dump skipped, instructions count: 803
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzapf.d(com.google.android.gms.internal.ads.zzaep, com.google.android.gms.internal.ads.zzafo):int");
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void zzf() {
    }
}
