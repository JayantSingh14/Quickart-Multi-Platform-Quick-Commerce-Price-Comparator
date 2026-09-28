package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import java.io.EOFException;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzxv implements zzaga {
    public boolean A;

    /* renamed from: a, reason: collision with root package name */
    public final zzxq f35871a;

    /* renamed from: d, reason: collision with root package name */
    public final zztk f35874d;

    /* renamed from: e, reason: collision with root package name */
    public zzxu f35875e;

    /* renamed from: f, reason: collision with root package name */
    public zzv f35876f;

    /* renamed from: g, reason: collision with root package name */
    public zztd f35877g;
    public int o;
    public int p;
    public int q;
    public int r;
    public boolean v;
    public zzv y;

    /* renamed from: b, reason: collision with root package name */
    public final zzxr f35872b = new zzxr();

    /* renamed from: h, reason: collision with root package name */
    public int f35878h = 1000;

    /* renamed from: i, reason: collision with root package name */
    public long[] f35879i = new long[1000];

    /* renamed from: j, reason: collision with root package name */
    public long[] f35880j = new long[1000];

    /* renamed from: m, reason: collision with root package name */
    public long[] f35883m = new long[1000];

    /* renamed from: l, reason: collision with root package name */
    public int[] f35882l = new int[1000];

    /* renamed from: k, reason: collision with root package name */
    public int[] f35881k = new int[1000];
    public zzafz[] n = new zzafz[1000];

    /* renamed from: c, reason: collision with root package name */
    public final zzyc f35873c = new zzyc(zzxs.f35868a);
    public long s = Long.MIN_VALUE;
    public long t = Long.MIN_VALUE;
    public long u = Long.MIN_VALUE;
    public boolean x = true;
    public boolean w = true;
    public boolean z = true;

    public zzxv(zzaah zzaahVar, zztk zztkVar, zztf zztfVar) {
        this.f35874d = zztkVar;
        this.f35871a = new zzxq(zzaahVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaga
    public final int a(zzj zzjVar, int i2, boolean z) throws EOFException {
        zzxq zzxqVar = this.f35871a;
        int iB = zzxqVar.b(i2);
        zzxp zzxpVar = zzxqVar.f35863e;
        zzaaf zzaafVar = zzxpVar.f35857c;
        byte[] bArr = zzaafVar.f22583a;
        long j2 = zzxqVar.f35864f - zzxpVar.f35855a;
        zzaafVar.getClass();
        int iB2 = zzjVar.b((int) j2, bArr, iB);
        if (iB2 == -1) {
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        long j3 = zzxqVar.f35864f + iB2;
        zzxqVar.f35864f = j3;
        zzxp zzxpVar2 = zzxqVar.f35863e;
        if (j3 == zzxpVar2.f35856b) {
            zzxqVar.f35863e = zzxpVar2.f35858d;
        }
        return iB2;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0049 A[Catch: all -> 0x0047, TryCatch #0 {all -> 0x0047, blocks: (B:4:0x0002, B:8:0x000e, B:13:0x001e, B:15:0x0034, B:19:0x004b, B:18:0x0049), top: B:29:0x0002 }] */
    @Override // com.google.android.gms.internal.ads.zzaga
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(com.google.android.gms.internal.ads.zzv r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r5.x = r0     // Catch: java.lang.Throwable -> L47
            com.google.android.gms.internal.ads.zzv r1 = r5.y     // Catch: java.lang.Throwable -> L47
            boolean r1 = java.util.Objects.equals(r6, r1)     // Catch: java.lang.Throwable -> L47
            if (r1 == 0) goto Le
            monitor-exit(r5)
            goto L5e
        Le:
            com.google.android.gms.internal.ads.zzyc r1 = r5.f35873c     // Catch: java.lang.Throwable -> L47
            android.util.SparseArray r2 = r1.f35895b     // Catch: java.lang.Throwable -> L47
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L47
            r3 = 1
            if (r2 != 0) goto L1b
            r2 = r3
            goto L1c
        L1b:
            r2 = r0
        L1c:
            if (r2 != 0) goto L49
            android.util.SparseArray r2 = r1.f35895b     // Catch: java.lang.Throwable -> L47
            int r4 = r2.size()     // Catch: java.lang.Throwable -> L47
            int r4 = r4 + (-1)
            java.lang.Object r2 = r2.valueAt(r4)     // Catch: java.lang.Throwable -> L47
            com.google.android.gms.internal.ads.zzxt r2 = (com.google.android.gms.internal.ads.zzxt) r2     // Catch: java.lang.Throwable -> L47
            com.google.android.gms.internal.ads.zzv r2 = r2.f35869a     // Catch: java.lang.Throwable -> L47
            boolean r2 = r2.equals(r6)     // Catch: java.lang.Throwable -> L47
            if (r2 == 0) goto L49
            android.util.SparseArray r6 = r1.f35895b     // Catch: java.lang.Throwable -> L47
            int r1 = r6.size()     // Catch: java.lang.Throwable -> L47
            int r1 = r1 + (-1)
            java.lang.Object r6 = r6.valueAt(r1)     // Catch: java.lang.Throwable -> L47
            com.google.android.gms.internal.ads.zzxt r6 = (com.google.android.gms.internal.ads.zzxt) r6     // Catch: java.lang.Throwable -> L47
            com.google.android.gms.internal.ads.zzv r6 = r6.f35869a     // Catch: java.lang.Throwable -> L47
            r5.y = r6     // Catch: java.lang.Throwable -> L47
            goto L4b
        L47:
            r6 = move-exception
            goto L6e
        L49:
            r5.y = r6     // Catch: java.lang.Throwable -> L47
        L4b:
            boolean r6 = r5.z     // Catch: java.lang.Throwable -> L47
            com.google.android.gms.internal.ads.zzv r1 = r5.y     // Catch: java.lang.Throwable -> L47
            java.lang.String r2 = r1.f35691m     // Catch: java.lang.Throwable -> L47
            java.lang.String r1 = r1.f35688j     // Catch: java.lang.Throwable -> L47
            boolean r1 = com.google.android.gms.internal.ads.zzas.d(r2, r1)     // Catch: java.lang.Throwable -> L47
            r6 = r6 & r1
            r5.z = r6     // Catch: java.lang.Throwable -> L47
            r5.A = r0     // Catch: java.lang.Throwable -> L47
            monitor-exit(r5)
            r0 = r3
        L5e:
            com.google.android.gms.internal.ads.zzxu r6 = r5.f35875e
            if (r6 == 0) goto L6d
            if (r0 == 0) goto L6d
            com.google.android.gms.internal.ads.zzxk r6 = (com.google.android.gms.internal.ads.zzxk) r6
            android.os.Handler r0 = r6.o
            java.lang.Runnable r6 = r6.f35843m
            r0.post(r6)
        L6d:
            return
        L6e:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L47
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxv.c(com.google.android.gms.internal.ads.zzv):void");
    }

    @Override // com.google.android.gms.internal.ads.zzaga
    public final void d(zzer zzerVar, int i2, int i3) {
        while (true) {
            zzxq zzxqVar = this.f35871a;
            if (i2 <= 0) {
                zzxqVar.getClass();
                return;
            }
            int iB = zzxqVar.b(i2);
            zzxp zzxpVar = zzxqVar.f35863e;
            zzaaf zzaafVar = zzxpVar.f35857c;
            byte[] bArr = zzaafVar.f22583a;
            long j2 = zzxqVar.f35864f - zzxpVar.f35855a;
            zzaafVar.getClass();
            zzerVar.H((int) j2, bArr, iB);
            i2 -= iB;
            long j3 = zzxqVar.f35864f + iB;
            zzxqVar.f35864f = j3;
            zzxp zzxpVar2 = zzxqVar.f35863e;
            if (j3 == zzxpVar2.f35856b) {
                zzxqVar.f35863e = zzxpVar2.f35858d;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00b8 A[Catch: all -> 0x005d, TryCatch #0 {all -> 0x005d, blocks: (B:21:0x003e, B:23:0x0043, B:27:0x0059, B:30:0x0060, B:34:0x0068, B:39:0x00a1, B:60:0x0106, B:62:0x010f, B:41:0x00b8, B:43:0x00bc, B:45:0x00ce, B:49:0x00d7, B:50:0x00dc, B:52:0x00e2, B:56:0x00f0, B:58:0x00f5, B:59:0x0103, B:68:0x017d), top: B:71:0x003e }] */
    @Override // com.google.android.gms.internal.ads.zzaga
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(long r10, int r12, int r13, int r14, com.google.android.gms.internal.ads.zzafz r15) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxv.e(long, int, int, int, com.google.android.gms.internal.ads.zzafz):void");
    }

    public final void g(zzv zzvVar, zzle zzleVar) {
        zzv zzvVar2 = this.f35876f;
        zzq zzqVar = zzvVar2 == null ? null : zzvVar2.q;
        this.f35876f = zzvVar;
        zzq zzqVar2 = zzvVar.q;
        ((zzth) this.f35874d).getClass();
        zzq zzqVar3 = zzvVar.q;
        int i2 = zzqVar3 != null ? 1 : 0;
        zzt zztVar = new zzt(zzvVar);
        zztVar.K = i2;
        zzleVar.f35082b = new zzv(zztVar);
        zzleVar.f35081a = this.f35877g;
        if (zzvVar2 == null || !Objects.equals(zzqVar, zzqVar2)) {
            zztl zztlVar = zzqVar3 != null ? new zztl(new zztc(new zztm())) : null;
            this.f35877g = zztlVar;
            zzleVar.f35081a = zztlVar;
        }
    }

    public final int h(int i2, int i3, long j2, boolean z) {
        int i4 = -1;
        for (int i5 = 0; i5 < i3; i5++) {
            long j3 = this.f35883m[i2];
            if (j3 > j2) {
                break;
            }
            if (!z || (this.f35882l[i2] & 1) != 0) {
                if (j3 == j2) {
                    return i5;
                }
                i4 = i5;
            }
            i2++;
            if (i2 == this.f35878h) {
                i2 = 0;
            }
        }
        return i4;
    }

    public final long i(int i2) {
        long j2 = this.t;
        long jMax = Long.MIN_VALUE;
        int i3 = 0;
        if (i2 != 0) {
            int iJ = j(i2 - 1);
            for (int i4 = 0; i4 < i2; i4++) {
                jMax = Math.max(jMax, this.f35883m[iJ]);
                if ((this.f35882l[iJ] & 1) != 0) {
                    break;
                }
                iJ--;
                if (iJ == -1) {
                    iJ = this.f35878h - 1;
                }
            }
        }
        this.t = Math.max(j2, jMax);
        this.o -= i2;
        int i5 = this.p + i2;
        this.p = i5;
        int i6 = this.q + i2;
        this.q = i6;
        int i7 = this.f35878h;
        if (i6 >= i7) {
            this.q = i6 - i7;
        }
        int i8 = this.r - i2;
        this.r = i8;
        if (i8 < 0) {
            this.r = 0;
        }
        while (true) {
            zzyc zzycVar = this.f35873c;
            SparseArray sparseArray = zzycVar.f35895b;
            if (i3 >= sparseArray.size() - 1) {
                break;
            }
            int i9 = i3 + 1;
            if (i5 < sparseArray.keyAt(i9)) {
                break;
            }
            zzycVar.f35896c.zza(sparseArray.valueAt(i3));
            sparseArray.removeAt(i3);
            int i10 = zzycVar.f35894a;
            if (i10 > 0) {
                zzycVar.f35894a = i10 - 1;
            }
            i3 = i9;
        }
        if (this.o != 0) {
            return this.f35880j[this.q];
        }
        int i11 = this.q;
        if (i11 == 0) {
            i11 = this.f35878h;
        }
        return this.f35880j[i11 - 1] + this.f35881k[r12];
    }

    public final int j(int i2) {
        int i3 = this.q + i2;
        int i4 = this.f35878h;
        return i3 < i4 ? i3 : i3 - i4;
    }

    public final void k(boolean z) {
        zzyc zzycVar;
        SparseArray sparseArray;
        zzxq zzxqVar = this.f35871a;
        zzxp zzxpVar = zzxqVar.f35861c;
        zzaaf zzaafVar = zzxpVar.f35857c;
        zzaah zzaahVar = zzxqVar.f35859a;
        if (zzaafVar != null) {
            zzaahVar.a(zzxpVar);
            zzxpVar.f35857c = null;
            zzxpVar.f35858d = null;
        }
        zzxp zzxpVar2 = zzxqVar.f35861c;
        int i2 = 0;
        zzgqa.f(zzxpVar2.f35857c == null);
        zzxpVar2.f35855a = 0L;
        zzxpVar2.f35856b = 65536L;
        zzxp zzxpVar3 = zzxqVar.f35861c;
        zzxqVar.f35862d = zzxpVar3;
        zzxqVar.f35863e = zzxpVar3;
        zzxqVar.f35864f = 0L;
        zzaahVar.zzd();
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.w = true;
        this.s = Long.MIN_VALUE;
        this.t = Long.MIN_VALUE;
        this.u = Long.MIN_VALUE;
        this.v = false;
        while (true) {
            zzycVar = this.f35873c;
            sparseArray = zzycVar.f35895b;
            if (i2 >= sparseArray.size()) {
                break;
            }
            zzycVar.f35896c.zza(sparseArray.valueAt(i2));
            i2++;
        }
        zzycVar.f35894a = -1;
        sparseArray.clear();
        if (z) {
            this.y = null;
            this.x = true;
            this.z = true;
        }
    }

    public final synchronized boolean l(boolean z) {
        int i2 = this.r;
        boolean z2 = false;
        if (i2 != this.o) {
            if (((zzxt) this.f35873c.a(this.p + i2)).f35869a != this.f35876f) {
                return true;
            }
            int iJ = j(this.r);
            if (this.f35877g != null) {
                int i3 = this.f35882l[iJ];
            } else {
                z2 = true;
            }
            return z2;
        }
        if (z || this.v) {
            z2 = true;
        } else {
            zzv zzvVar = this.y;
            if (zzvVar != null) {
                if (zzvVar == this.f35876f) {
                    return false;
                }
                z2 = true;
            }
        }
        return z2;
    }

    public final synchronized boolean m(long j2, boolean z) {
        zzxv zzxvVar;
        long j3;
        try {
            synchronized (this) {
                try {
                    try {
                        this.r = 0;
                        zzxq zzxqVar = this.f35871a;
                        zzxqVar.f35862d = zzxqVar.f35861c;
                        int iJ = j(0);
                        int i2 = this.r;
                        int iH = this.o;
                        if ((i2 != iH) && j2 >= this.f35883m[iJ]) {
                            if (j2 > this.u) {
                                if (z) {
                                    z = true;
                                }
                            }
                            if (this.z) {
                                int i3 = 0;
                                while (true) {
                                    if (i3 < iH) {
                                        try {
                                            if (this.f35883m[iJ] >= j2) {
                                                zzxvVar = this;
                                                j3 = j2;
                                                iH = i3;
                                                break;
                                            }
                                            iJ++;
                                            if (iJ == this.f35878h) {
                                                iJ = 0;
                                            }
                                            i3++;
                                        } catch (Throwable th) {
                                            Throwable th2 = th;
                                            throw th2;
                                        }
                                    } else {
                                        zzxvVar = this;
                                        j3 = j2;
                                        if (!z) {
                                            iH = -1;
                                        }
                                    }
                                }
                            } else {
                                zzxvVar = this;
                                j3 = j2;
                                iH = zzxvVar.h(iJ, iH, j3, true);
                            }
                            if (iH != -1) {
                                zzxvVar.s = j3;
                                zzxvVar.r += iH;
                                return true;
                            }
                        }
                        return false;
                    } finally {
                        th = th;
                        while (true) {
                            Throwable th3 = th;
                            try {
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    throw th2;
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public final void n() {
        long jI;
        zzxq zzxqVar = this.f35871a;
        synchronized (this) {
            int i2 = this.o;
            jI = i2 == 0 ? -1L : i(i2);
        }
        zzxqVar.a(jI);
    }
}
