package com.google.android.gms.internal.ads;

import java.io.EOFException;

/* loaded from: classes4.dex */
final class zzalh {

    /* renamed from: a, reason: collision with root package name */
    public int f23479a;

    /* renamed from: b, reason: collision with root package name */
    public long f23480b;

    /* renamed from: c, reason: collision with root package name */
    public int f23481c;

    /* renamed from: d, reason: collision with root package name */
    public int f23482d;

    /* renamed from: e, reason: collision with root package name */
    public int f23483e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f23484f = new int[255];

    /* renamed from: g, reason: collision with root package name */
    public final zzer f23485g = new zzer(255);

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:
    
        if (r13 == (-1)) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
    
        if (r12.f22872d >= r13) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004f, code lost:
    
        r0 = java.lang.Math.min(r12.f22875g, 1);
        r12.h(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0059, code lost:
    
        if (r0 != 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005b, code lost:
    
        r5 = r12;
        r0 = r5.i(r12.f22869a, 0, java.lang.Math.min(1, 4096), 0, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006c, code lost:
    
        r5 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006e, code lost:
    
        if (r0 == (-1)) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0070, code lost:
    
        r5.f22872d += r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0077, code lost:
    
        if (r0 != (-1)) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0079, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007a, code lost:
    
        r12 = r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(com.google.android.gms.internal.ads.zzaef r12, long r13) throws java.io.EOFException, java.io.InterruptedIOException {
        /*
            r11 = this;
            long r0 = r12.f22872d
            long r2 = r12.zzm()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            r2 = 1
            if (r0 != 0) goto Le
            r0 = r2
            goto Lf
        Le:
            r0 = r1
        Lf:
            com.google.android.gms.internal.ads.zzgqa.a(r0)
            com.google.android.gms.internal.ads.zzer r0 = r11.f23485g
            r3 = 4
            r0.y(r3)
        L18:
            r4 = -1
            int r4 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r4 == 0) goto L28
            long r5 = r12.f22872d
            r7 = 4
            long r5 = r5 + r7
            int r5 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r5 < 0) goto L28
            goto L47
        L28:
            byte[] r5 = r0.f30144a
            boolean r5 = r12.t(r5, r1, r3, r2)     // Catch: java.io.EOFException -> L2f
            goto L30
        L2f:
            r5 = r1
        L30:
            if (r5 == 0) goto L47
            r0.E(r1)
            long r4 = r0.P()
            r6 = 1332176723(0x4f676753, double:6.58182753E-315)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 != 0) goto L43
            r12.f22874f = r1
            return r2
        L43:
            r12.d(r2, r1)
            goto L18
        L47:
            if (r4 == 0) goto L4f
            long r2 = r12.f22872d
            int r0 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r0 >= 0) goto L79
        L4f:
            int r0 = r12.f22875g
            r2 = 1
            int r0 = java.lang.Math.min(r0, r2)
            r12.h(r0)
            if (r0 != 0) goto L6c
            r0 = 4096(0x1000, float:5.74E-42)
            int r8 = java.lang.Math.min(r2, r0)
            byte[] r6 = r12.f22869a
            r7 = 0
            r9 = 0
            r10 = 1
            r5 = r12
            int r0 = r5.i(r6, r7, r8, r9, r10)
            goto L6d
        L6c:
            r5 = r12
        L6d:
            r12 = -1
            if (r0 == r12) goto L76
            long r2 = r5.f22872d
            long r6 = (long) r0
            long r2 = r2 + r6
            r5.f22872d = r2
        L76:
            r12 = -1
            if (r0 != r12) goto L7a
        L79:
            return r1
        L7a:
            r12 = r5
            goto L47
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalh.a(com.google.android.gms.internal.ads.zzaef, long):boolean");
    }

    public final boolean b(zzaef zzaefVar, boolean z) throws zzat, EOFException {
        boolean zT;
        boolean zT2;
        this.f23479a = 0;
        this.f23480b = 0L;
        this.f23481c = 0;
        this.f23482d = 0;
        this.f23483e = 0;
        zzer zzerVar = this.f23485g;
        zzerVar.y(27);
        try {
            zT = zzaefVar.t(zzerVar.f30144a, 0, 27, z);
        } catch (EOFException e2) {
            if (!z) {
                throw e2;
            }
            zT = false;
        }
        if (zT && zzerVar.P() == 1332176723) {
            if (zzerVar.K() == 0) {
                this.f23479a = zzerVar.K();
                this.f23480b = zzerVar.e();
                zzerVar.a();
                zzerVar.a();
                zzerVar.a();
                int iK = zzerVar.K();
                this.f23481c = iK;
                this.f23482d = iK + 27;
                zzerVar.y(iK);
                try {
                    zT2 = zzaefVar.t(zzerVar.f30144a, 0, this.f23481c, z);
                } catch (EOFException e3) {
                    if (!z) {
                        throw e3;
                    }
                    zT2 = false;
                }
                if (zT2) {
                    for (int i2 = 0; i2 < this.f23481c; i2++) {
                        int iK2 = zzerVar.K();
                        this.f23484f[i2] = iK2;
                        this.f23483e += iK2;
                    }
                    return true;
                }
            } else if (!z) {
                throw zzat.b("unsupported bit stream revision");
            }
        }
        return false;
    }
}
