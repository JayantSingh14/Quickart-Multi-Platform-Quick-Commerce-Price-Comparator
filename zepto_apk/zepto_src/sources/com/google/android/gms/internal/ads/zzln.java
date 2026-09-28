package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.ArrayList;

/* loaded from: classes4.dex */
final class zzln {

    /* renamed from: c, reason: collision with root package name */
    public final zzoz f35122c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdx f35123d;

    /* renamed from: e, reason: collision with root package name */
    public long f35124e;

    /* renamed from: f, reason: collision with root package name */
    public int f35125f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f35126g;

    /* renamed from: h, reason: collision with root package name */
    public zzlk f35127h;

    /* renamed from: i, reason: collision with root package name */
    public zzlk f35128i;

    /* renamed from: j, reason: collision with root package name */
    public zzlk f35129j;

    /* renamed from: k, reason: collision with root package name */
    public zzlk f35130k;

    /* renamed from: l, reason: collision with root package name */
    public zzlk f35131l;

    /* renamed from: m, reason: collision with root package name */
    public int f35132m;
    public Object n;
    public long o;
    public final zzkv q;

    /* renamed from: a, reason: collision with root package name */
    public final zzbd f35120a = new zzbd();

    /* renamed from: b, reason: collision with root package name */
    public final zzbe f35121b = new zzbe();
    public ArrayList p = new ArrayList();

    public zzln(zzoz zzozVar, zzdx zzdxVar, zzkv zzkvVar, zzjd zzjdVar) {
        this.f35122c = zzozVar;
        this.f35123d = zzdxVar;
        this.q = zzkvVar;
    }

    public static zzwg a(zzbf zzbfVar, Object obj, long j2, zzbe zzbeVar, zzbd zzbdVar) {
        zzbfVar.o(obj, zzbdVar);
        zzbfVar.b(zzbdVar.f24739c, zzbeVar, 0L);
        zzbfVar.e(obj);
        zzbdVar.f24742f.getClass();
        zzbfVar.o(obj, zzbdVar);
        zzbdVar.f24742f.a(-1);
        return new zzwg(obj, -1, j2);
    }

    public final zzlk A(zzwe zzweVar) {
        for (int i2 = 0; i2 < this.p.size(); i2++) {
            zzlk zzlkVar = (zzlk) this.p.get(i2);
            if (zzlkVar.f35096a == zzweVar) {
                return zzlkVar;
            }
        }
        return null;
    }

    public final void B() {
        if (this.f35132m == 0) {
            return;
        }
        zzlk zzlkVar = this.f35127h;
        zzlkVar.getClass();
        this.n = zzlkVar.f35097b;
        this.o = zzlkVar.f35102g.f35109a.f35761d;
        while (zzlkVar != null) {
            zzlkVar.h();
            zzlkVar = zzlkVar.f35108m;
        }
        this.f35127h = null;
        this.f35130k = null;
        this.f35128i = null;
        this.f35129j = null;
        this.f35132m = 0;
        b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a9, code lost:
    
        return y(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int C(com.google.android.gms.internal.ads.zzbf r17, long r18, long r20, long r22) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            com.google.android.gms.internal.ads.zzlk r2 = r0.f35127h
            r3 = 0
        L7:
            r4 = 0
            if (r2 == 0) goto Laa
            com.google.android.gms.internal.ads.zzll r5 = r2.f35102g
            if (r3 != 0) goto L15
            com.google.android.gms.internal.ads.zzll r3 = r0.D(r1, r5)
            r6 = r18
            goto L30
        L15:
            r6 = r18
            com.google.android.gms.internal.ads.zzll r8 = r0.e(r1, r3, r6)
            if (r8 == 0) goto La5
            long r9 = r5.f35110b
            long r11 = r8.f35110b
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 != 0) goto La5
            com.google.android.gms.internal.ads.zzwg r9 = r5.f35109a
            com.google.android.gms.internal.ads.zzwg r10 = r8.f35109a
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto La5
            r3 = r8
        L30:
            long r8 = r5.f35111c
            com.google.android.gms.internal.ads.zzll r8 = r3.b(r8)
            r2.f35102g = r8
            long r9 = r5.f35113e
            long r11 = r3.f35113e
            int r3 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r3 == 0) goto L9e
            java.lang.Object r1 = r2.f35096a
            boolean r3 = r1 instanceof com.google.android.gms.internal.ads.zzvk
            r5 = -9223372036854775808
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r3 == 0) goto L58
            long r7 = r8.f35112d
            int r3 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r3 != 0) goto L54
            r7 = r5
        L54:
            com.google.android.gms.internal.ads.zzvk r1 = (com.google.android.gms.internal.ads.zzvk) r1
            r1.f35714e = r7
        L58:
            int r1 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r1 != 0) goto L62
            r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            goto L65
        L62:
            long r7 = r2.p
            long r7 = r7 + r11
        L65:
            com.google.android.gms.internal.ads.zzlk r1 = r0.f35128i
            r3 = 1
            if (r2 != r1) goto L74
            int r1 = (r20 > r5 ? 1 : (r20 == r5 ? 0 : -1))
            if (r1 == 0) goto L72
            int r1 = (r20 > r7 ? 1 : (r20 == r7 ? 0 : -1))
            if (r1 < 0) goto L74
        L72:
            r1 = r3
            goto L75
        L74:
            r1 = r4
        L75:
            com.google.android.gms.internal.ads.zzlk r11 = r0.f35129j
            if (r2 != r11) goto L83
            int r5 = (r22 > r5 ? 1 : (r22 == r5 ? 0 : -1))
            if (r5 == 0) goto L81
            int r5 = (r22 > r7 ? 1 : (r22 == r7 ? 0 : -1))
            if (r5 < 0) goto L83
        L81:
            r5 = r3
            goto L84
        L83:
            r5 = r4
        L84:
            int r2 = r0.y(r2)
            if (r2 == 0) goto L8b
            return r2
        L8b:
            int r2 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r2 != 0) goto L90
            r9 = r13
        L90:
            if (r1 == 0) goto L98
            int r1 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r1 != 0) goto L97
            goto L98
        L97:
            r4 = r3
        L98:
            if (r5 == 0) goto L9d
            r1 = r4 | 2
            return r1
        L9d:
            return r4
        L9e:
            com.google.android.gms.internal.ads.zzlk r3 = r2.f35108m
            r15 = r3
            r3 = r2
            r2 = r15
            goto L7
        La5:
            int r1 = r0.y(r3)
            return r1
        Laa:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzln.C(com.google.android.gms.internal.ads.zzbf, long, long, long):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.zzll D(com.google.android.gms.internal.ads.zzbf r19, com.google.android.gms.internal.ads.zzll r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            com.google.android.gms.internal.ads.zzwg r3 = r2.f35109a
            boolean r4 = r3.b()
            r5 = -1
            int r6 = r3.f35762e
            if (r4 != 0) goto L16
            if (r6 != r5) goto L16
            r4 = 1
        L14:
            r11 = r4
            goto L18
        L16:
            r4 = 0
            goto L14
        L18:
            boolean r12 = r0.i(r1, r3)
            boolean r13 = r0.j(r1, r3, r11)
            java.lang.Object r4 = r3.f35758a
            com.google.android.gms.internal.ads.zzbd r7 = r0.f35120a
            r1.o(r4, r7)
            boolean r1 = r3.b()
            r8 = 0
            r14 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L36
            if (r6 != r5) goto L39
        L36:
            r16 = r14
            goto L44
        L39:
            com.google.android.gms.internal.ads.zzc r1 = r7.f24742f
            com.google.android.gms.internal.ads.zza r1 = r1.a(r6)
            r1.getClass()
            r16 = r8
        L44:
            boolean r1 = r3.b()
            int r4 = r3.f35759b
            if (r1 == 0) goto L56
            int r1 = r3.f35760c
            long r8 = r7.b(r4, r1)
        L52:
            r14 = r8
            r8 = r16
            goto L5f
        L56:
            int r1 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r1 == 0) goto L5c
            r14 = r8
            goto L5f
        L5c:
            long r8 = r7.f24740d
            goto L52
        L5f:
            boolean r1 = r3.b()
            if (r1 == 0) goto L69
            r7.c(r4)
            goto L6e
        L69:
            if (r6 == r5) goto L6e
            r7.c(r6)
        L6e:
            com.google.android.gms.internal.ads.zzll r1 = new com.google.android.gms.internal.ads.zzll
            r5 = r3
            long r3 = r2.f35110b
            long r6 = r2.f35111c
            r2 = r5
            r5 = r6
            r7 = r8
            r9 = r14
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzln.D(com.google.android.gms.internal.ads.zzbf, com.google.android.gms.internal.ads.zzll):com.google.android.gms.internal.ads.zzll");
    }

    public final zzwg E(zzbf zzbfVar, Object obj) {
        long jC;
        int iE;
        zzbd zzbdVar = this.f35120a;
        int i2 = zzbfVar.o(obj, zzbdVar).f24739c;
        Object obj2 = this.n;
        if (obj2 == null || (iE = zzbfVar.e(obj2)) == -1 || zzbfVar.d(iE, zzbdVar, false).f24739c != i2) {
            zzlk zzlkVar = this.f35127h;
            while (true) {
                if (zzlkVar == null) {
                    zzlk zzlkVar2 = this.f35127h;
                    while (true) {
                        if (zzlkVar2 != null) {
                            int iE2 = zzbfVar.e(zzlkVar2.f35097b);
                            if (iE2 != -1 && zzbfVar.d(iE2, zzbdVar, false).f24739c == i2) {
                                jC = zzlkVar2.f35102g.f35109a.f35761d;
                                break;
                            }
                            zzlkVar2 = zzlkVar2.f35108m;
                        } else {
                            jC = c(obj);
                            if (jC == -1) {
                                jC = this.f35124e;
                                this.f35124e = 1 + jC;
                                if (this.f35127h == null) {
                                    this.n = obj;
                                    this.o = jC;
                                }
                            }
                        }
                    }
                } else {
                    if (zzlkVar.f35097b.equals(obj)) {
                        jC = zzlkVar.f35102g.f35109a.f35761d;
                        break;
                    }
                    zzlkVar = zzlkVar.f35108m;
                }
            }
        } else {
            jC = this.o;
        }
        long j2 = jC;
        zzbfVar.o(obj, zzbdVar);
        int i3 = zzbdVar.f24739c;
        zzbe zzbeVar = this.f35121b;
        zzbfVar.b(i3, zzbeVar, 0L);
        for (int iE3 = zzbfVar.e(obj); iE3 >= zzbeVar.f24833k; iE3--) {
            zzbfVar.d(iE3, zzbdVar, true);
            zzbdVar.f24742f.getClass();
            zzbdVar.f24742f.a(-1);
        }
        return a(zzbfVar, obj, j2, zzbeVar, zzbdVar);
    }

    public final void b() {
        zzgvs zzgvsVar = zzgtd.f33183b;
        final zzgta zzgtaVar = new zzgta();
        for (zzlk zzlkVar = this.f35127h; zzlkVar != null; zzlkVar = zzlkVar.f35108m) {
            zzgtaVar.c(zzlkVar.f35102g.f35109a);
        }
        zzlk zzlkVar2 = this.f35128i;
        final zzwg zzwgVar = zzlkVar2 == null ? null : zzlkVar2.f35102g.f35109a;
        this.f35123d.e(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlm
            @Override // java.lang.Runnable
            public final void run() {
                zzln zzlnVar = this.f35117a;
                zzlnVar.getClass();
                zzgtd zzgtdVarF = zzgtaVar.f();
                zzoz zzozVar = zzlnVar.f35122c;
                zzms zzmsVar = zzozVar.f35274g;
                zzmsVar.getClass();
                zzoy zzoyVar = zzozVar.f35271d;
                zzoyVar.getClass();
                zzoyVar.f35263b = zzgtd.r(zzgtdVarF);
                if (!zzgtdVarF.isEmpty()) {
                    zzoyVar.f35266e = (zzwg) ((zzguy) zzgtdVarF).get(0);
                    zzwg zzwgVar2 = zzwgVar;
                    zzwgVar2.getClass();
                    zzoyVar.f35267f = zzwgVar2;
                }
                if (zzoyVar.f35265d == null) {
                    zzoyVar.f35265d = zzoy.c(zzmsVar, zzoyVar.f35263b, zzoyVar.f35266e, zzoyVar.f35262a);
                }
                zzoyVar.a(zzmsVar.zzq());
            }
        });
    }

    public final long c(Object obj) {
        for (int i2 = 0; i2 < this.p.size(); i2++) {
            zzlk zzlkVar = (zzlk) this.p.get(i2);
            if (zzlkVar.f35097b.equals(obj)) {
                return zzlkVar.f35102g.f35109a.f35761d;
            }
        }
        return -1L;
    }

    public final int d(zzbf zzbfVar) {
        zzbf zzbfVar2;
        zzlk zzlkVar;
        zzlk zzlkVar2 = this.f35127h;
        if (zzlkVar2 == null) {
            return 0;
        }
        int iE = zzbfVar.e(zzlkVar2.f35097b);
        while (true) {
            zzbfVar2 = zzbfVar;
            iE = zzbfVar2.l(iE, this.f35120a, this.f35121b, this.f35125f, this.f35126g);
            while (true) {
                zzlkVar = zzlkVar2.f35108m;
                if (zzlkVar == null || zzlkVar2.f35102g.f35114f) {
                    break;
                }
                zzlkVar2 = zzlkVar;
            }
            if (iE == -1 || zzlkVar == null || zzbfVar2.e(zzlkVar.f35097b) != iE) {
                break;
            }
            zzlkVar2 = zzlkVar;
            zzbfVar = zzbfVar2;
        }
        int iY = y(zzlkVar2);
        zzlkVar2.f35102g = D(zzbfVar2, zzlkVar2.f35102g);
        return iY;
    }

    public final zzll e(zzbf zzbfVar, zzlk zzlkVar, long j2) {
        int i2;
        zzbf zzbfVar2;
        zzbd zzbdVar;
        long j3;
        int i3;
        zzbe zzbeVar;
        Object obj;
        zzbd zzbdVar2;
        long j4;
        zzbf zzbfVar3;
        long j5;
        long jC;
        zzll zzllVar = zzlkVar.f35102g;
        long j6 = zzlkVar.p;
        long j7 = zzllVar.f35113e;
        long j8 = (j6 + j7) - j2;
        boolean z = zzllVar.f35114f;
        long jLongValue = 0;
        long jLongValue2 = zzllVar.f35111c;
        zzwg zzwgVar = zzllVar.f35109a;
        if (z) {
            Object obj2 = zzwgVar.f35758a;
            int iE = zzbfVar.e(obj2);
            int i4 = this.f35125f;
            boolean z2 = this.f35126g;
            zzbd zzbdVar3 = this.f35120a;
            zzbe zzbeVar2 = this.f35121b;
            int iL = zzbfVar.l(iE, zzbdVar3, zzbeVar2, i4, z2);
            if (iL != -1) {
                int i5 = zzbfVar.d(iL, zzbdVar3, true).f24739c;
                Object obj3 = zzbdVar3.f24738b;
                obj3.getClass();
                if (zzbfVar.b(i5, zzbeVar2, 0L).f24833k == iL) {
                    Pair pairN = zzbfVar.n(zzbeVar2, zzbdVar3, i5, -9223372036854775807L, Math.max(0L, j8));
                    if (pairN != null) {
                        Object obj4 = pairN.first;
                        jLongValue = ((Long) pairN.second).longValue();
                        zzlk zzlkVar2 = zzlkVar.f35108m;
                        if (zzlkVar2 == null || !zzlkVar2.f35097b.equals(obj4)) {
                            jC = c(obj4);
                            if (jC == -1) {
                                jC = this.f35124e;
                                this.f35124e = 1 + jC;
                            }
                        } else {
                            jC = zzlkVar2.f35102g.f35109a.f35761d;
                        }
                        zzbeVar = zzbeVar2;
                        obj = obj4;
                        zzbdVar2 = zzbdVar3;
                        j4 = jC;
                        zzbfVar3 = zzbfVar;
                        j5 = -9223372036854775807L;
                    }
                } else {
                    zzbeVar = zzbeVar2;
                    obj = obj3;
                    zzbdVar2 = zzbdVar3;
                    j4 = zzwgVar.f35761d;
                    zzbfVar3 = zzbfVar;
                    j5 = 0;
                }
                zzwg zzwgVarA = a(zzbfVar3, obj, j4, zzbeVar, zzbdVar2);
                zzbd zzbdVar4 = zzbdVar2;
                if (j5 != -9223372036854775807L && jLongValue2 != -9223372036854775807L) {
                    zzbfVar3.o(obj2, zzbdVar4).f24742f.getClass();
                    zzbdVar4.f24742f.getClass();
                }
                return f(zzbfVar3, zzwgVarA, j5, jLongValue);
            }
        } else {
            Object obj5 = zzwgVar.f35758a;
            zzbd zzbdVar5 = this.f35120a;
            zzbfVar.o(obj5, zzbdVar5);
            if (!zzwgVar.b()) {
                int i6 = zzwgVar.f35762e;
                if (i6 != -1) {
                    zzbdVar5.f24742f.getClass();
                    if (i6 == -1) {
                        zzbdVar5.f24742f.a(-1);
                    }
                }
                zza zzaVarA = zzbdVar5.f24742f.a(i6);
                int i7 = 0;
                while (true) {
                    int[] iArr = zzaVarA.f22572d;
                    if (i7 >= iArr.length || (i2 = iArr[i7]) == 0 || i2 == 1) {
                        break;
                    }
                    i7++;
                }
                zzbdVar5.c(i6);
                if (i7 != zzbdVar5.f24742f.a(i6).f22569a) {
                    return g(zzbfVar, obj5, i6, i7, j7, zzwgVar.f35761d);
                }
                zzbfVar.o(obj5, zzbdVar5);
                zzbdVar5.f24742f.a(i6).getClass();
                zzbdVar5.f24742f.a(i6).getClass();
                return h(zzbfVar, obj5, 0L, j7, zzwgVar.f35761d);
            }
            zzc zzcVar = zzbdVar5.f24742f;
            int i8 = zzwgVar.f35759b;
            if (zzcVar.a(i8).f22569a != -1) {
                zza zzaVarA2 = zzbdVar5.f24742f.a(i8);
                int i9 = zzwgVar.f35760c + 1;
                while (true) {
                    int[] iArr2 = zzaVarA2.f22572d;
                    if (i9 >= iArr2.length || (i3 = iArr2[i9]) == 0 || i3 == 1) {
                        break;
                    }
                    i9++;
                }
                if (i9 < 0) {
                    return g(zzbfVar, obj5, i8, i9, zzllVar.f35111c, zzwgVar.f35761d);
                }
                if (jLongValue2 == -9223372036854775807L) {
                    zzbdVar = zzbdVar5;
                    zzbfVar2 = zzbfVar;
                    Pair pairN2 = zzbfVar2.n(this.f35121b, zzbdVar, zzbdVar5.f24739c, -9223372036854775807L, Math.max(0L, j8));
                    if (pairN2 == null) {
                        return null;
                    }
                    jLongValue2 = ((Long) pairN2.second).longValue();
                    j3 = -9223372036854775807L;
                } else {
                    zzbfVar2 = zzbfVar;
                    zzbdVar = zzbdVar5;
                    j3 = jLongValue2;
                }
                zzbfVar2.o(obj5, zzbdVar);
                zzbdVar.f24742f.a(i8).getClass();
                zzbdVar.f24742f.a(i8).getClass();
                return h(zzbfVar2, obj5, Math.max(0L, jLongValue2), j3, zzwgVar.f35761d);
            }
        }
        return null;
    }

    public final zzll f(zzbf zzbfVar, zzwg zzwgVar, long j2, long j3) {
        Object obj = zzwgVar.f35758a;
        zzbfVar.o(obj, this.f35120a);
        return zzwgVar.b() ? g(zzbfVar, obj, zzwgVar.f35759b, zzwgVar.f35760c, j2, zzwgVar.f35761d) : h(zzbfVar, obj, j3, j2, zzwgVar.f35761d);
    }

    public final zzll g(zzbf zzbfVar, Object obj, int i2, int i3, long j2, long j3) {
        int i4;
        zzwg zzwgVar = new zzwg(obj, i2, i3, j3, -1);
        zzbd zzbdVar = this.f35120a;
        long jB = zzbfVar.o(obj, zzbdVar).b(i2, i3);
        zza zzaVarA = zzbdVar.f24742f.a(i2);
        int i5 = 0;
        while (true) {
            int[] iArr = zzaVarA.f22572d;
            if (i5 >= iArr.length || (i4 = iArr[i5]) == 0 || i4 == 1) {
                break;
            }
            i5++;
        }
        if (i3 == i5) {
            zzbdVar.f24742f.getClass();
        }
        zzbdVar.c(i2);
        long jMax = 0;
        if (jB != -9223372036854775807L && jB <= 0) {
            jMax = Math.max(0L, (-1) + jB);
        }
        return new zzll(zzwgVar, jMax, j2, -9223372036854775807L, jB, false, false, false);
    }

    public final zzll h(zzbf zzbfVar, Object obj, long j2, long j3, long j4) {
        zzbd zzbdVar = this.f35120a;
        zzbfVar.o(obj, zzbdVar);
        zzbdVar.getClass();
        zzbdVar.f24742f.getClass();
        zzwg zzwgVar = new zzwg(obj, -1, j4);
        boolean z = !zzwgVar.b();
        boolean zI = i(zzbfVar, zzwgVar);
        boolean zJ = j(zzbfVar, zzwgVar, z);
        long j5 = zzbdVar.f24740d;
        return new zzll(zzwgVar, (j5 == -9223372036854775807L || j2 < j5) ? j2 : Math.max(0L, (-1) + j5), j3, -9223372036854775807L, j5, z, zI, zJ);
    }

    public final boolean i(zzbf zzbfVar, zzwg zzwgVar) {
        if (!zzwgVar.b() && zzwgVar.f35762e == -1) {
            Object obj = zzwgVar.f35758a;
            if (zzbfVar.b(zzbfVar.o(obj, this.f35120a).f24739c, this.f35121b, 0L).f24834l == zzbfVar.e(obj)) {
                return true;
            }
        }
        return false;
    }

    public final boolean j(zzbf zzbfVar, zzwg zzwgVar, boolean z) {
        int iE = zzbfVar.e(zzwgVar.f35758a);
        zzbd zzbdVar = this.f35120a;
        int i2 = zzbfVar.d(iE, zzbdVar, false).f24739c;
        zzbe zzbeVar = this.f35121b;
        return !zzbfVar.b(i2, zzbeVar, 0L).f24829g && zzbfVar.l(iE, zzbdVar, zzbeVar, this.f35125f, this.f35126g) == -1 && z;
    }

    public final int k(zzbf zzbfVar, int i2) {
        this.f35125f = i2;
        return d(zzbfVar);
    }

    public final int l(zzbf zzbfVar, boolean z) {
        this.f35126g = z;
        return d(zzbfVar);
    }

    public final void m(zzjd zzjdVar) {
        zzjdVar.getClass();
        r();
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.android.gms.internal.ads.zzxy, java.lang.Object] */
    public final void n(long j2) {
        zzlk zzlkVar = this.f35130k;
        if (zzlkVar != null) {
            zzgqa.f(zzlkVar.f35108m == null);
            if (zzlkVar.f35100e) {
                zzlkVar.f35096a.g(j2 - zzlkVar.p);
            }
        }
    }

    public final boolean o() {
        zzlk zzlkVar = this.f35130k;
        if (zzlkVar != null) {
            return !zzlkVar.f35102g.f35116h && zzlkVar.b() && this.f35130k.f35102g.f35113e != -9223372036854775807L && this.f35132m < 100;
        }
        return true;
    }

    public final zzll p(long j2, zzma zzmaVar) {
        zzlk zzlkVar = this.f35130k;
        return zzlkVar == null ? f(zzmaVar.f35179a, zzmaVar.f35180b, zzmaVar.f35181c, zzmaVar.r) : e(zzmaVar.f35179a, zzlkVar, j2);
    }

    public final zzlk q(zzll zzllVar) {
        zzlk zzlkVar;
        zzlk zzlkVar2 = this.f35130k;
        long j2 = zzllVar.f35110b;
        long j3 = zzlkVar2 == null ? 1000000000000L : (zzlkVar2.p + zzlkVar2.f35102g.f35113e) - j2;
        int i2 = 0;
        while (true) {
            if (i2 >= this.p.size()) {
                zzlkVar = null;
                break;
            }
            zzll zzllVar2 = ((zzlk) this.p.get(i2)).f35102g;
            long j4 = zzllVar2.f35113e;
            if ((j4 == -9223372036854775807L || j4 == zzllVar.f35113e) && zzllVar2.f35110b == j2 && zzllVar2.f35109a.equals(zzllVar.f35109a)) {
                zzlkVar = (zzlk) this.p.remove(i2);
                break;
            }
            i2++;
        }
        if (zzlkVar == null) {
            zzlc zzlcVar = this.q.f35054a;
            zzaah zzaahVarB = zzlcVar.f35073f.b(zzlcVar.u);
            zzlcVar.H0.getClass();
            zzlkVar = new zzlk(zzlcVar.f35069b, j3, zzlcVar.f35071d, zzaahVarB, zzlcVar.s, zzllVar, zzlcVar.f35072e);
        } else {
            zzlkVar.f35102g = zzllVar;
            zzlkVar.p = j3;
        }
        zzlk zzlkVar3 = this.f35130k;
        if (zzlkVar3 == null) {
            this.f35127h = zzlkVar;
            this.f35128i = zzlkVar;
            this.f35129j = zzlkVar;
        } else if (zzlkVar != zzlkVar3.f35108m) {
            zzlkVar3.l();
            zzlkVar3.f35108m = zzlkVar;
        }
        this.n = null;
        this.f35130k = zzlkVar;
        this.f35132m++;
        b();
        return zzlkVar;
    }

    public final void r() {
        if (this.p.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.p.size(); i2++) {
            ((zzlk) this.p.get(i2)).h();
        }
        this.p = arrayList;
        this.f35131l = null;
        z();
    }

    public final zzlk s() {
        return this.f35127h;
    }

    public final zzlk t() {
        return this.f35128i;
    }

    public final zzlk u() {
        return this.f35129j;
    }

    public final zzlk v() {
        zzlk zzlkVar = this.f35129j;
        zzlk zzlkVar2 = this.f35128i;
        if (zzlkVar == zzlkVar2) {
            zzlkVar2.getClass();
            this.f35129j = zzlkVar2.f35108m;
        }
        zzlkVar2.getClass();
        this.f35128i = zzlkVar2.f35108m;
        b();
        zzlk zzlkVar3 = this.f35128i;
        zzlkVar3.getClass();
        return zzlkVar3;
    }

    public final void w() {
        zzlk zzlkVar = this.f35129j;
        zzlkVar.getClass();
        this.f35129j = zzlkVar.f35108m;
        b();
        this.f35129j.getClass();
    }

    public final zzlk x() {
        zzlk zzlkVar = this.f35127h;
        if (zzlkVar == null) {
            return null;
        }
        if (zzlkVar == this.f35128i) {
            this.f35128i = zzlkVar.f35108m;
        }
        if (zzlkVar == this.f35129j) {
            this.f35129j = zzlkVar.f35108m;
        }
        zzlkVar.h();
        int i2 = this.f35132m - 1;
        this.f35132m = i2;
        if (i2 == 0) {
            this.f35130k = null;
            zzlk zzlkVar2 = this.f35127h;
            this.n = zzlkVar2.f35097b;
            this.o = zzlkVar2.f35102g.f35109a.f35761d;
        }
        this.f35127h = this.f35127h.f35108m;
        b();
        return this.f35127h;
    }

    public final int y(zzlk zzlkVar) {
        zzlkVar.getClass();
        int i2 = 0;
        if (zzlkVar.equals(this.f35130k)) {
            return 0;
        }
        this.f35130k = zzlkVar;
        int i3 = 0;
        while (true) {
            zzlkVar = zzlkVar.f35108m;
            if (zzlkVar == null) {
                break;
            }
            if (zzlkVar == this.f35128i) {
                zzlk zzlkVar2 = this.f35127h;
                this.f35128i = zzlkVar2;
                this.f35129j = zzlkVar2;
                i3 = 3;
            }
            if (zzlkVar == this.f35129j) {
                this.f35129j = this.f35128i;
                i3 |= 2;
            }
            zzlkVar.h();
            this.f35132m--;
        }
        zzlk zzlkVar3 = this.f35130k;
        zzlkVar3.getClass();
        if (zzlkVar3.f35108m != null) {
            zzlkVar3.l();
            zzlkVar3.f35108m = null;
            while (true) {
                zzaae zzaaeVar = zzlkVar3.o;
                if (i2 >= zzaaeVar.f22578a) {
                    break;
                }
                zzaaeVar.a(i2);
                zzzw zzzwVar = zzlkVar3.o.f22580c[i2];
                i2++;
            }
        }
        b();
        return i3;
    }

    public final void z() {
        zzlk zzlkVar = this.f35131l;
        if (zzlkVar == null || zzlkVar.c()) {
            this.f35131l = null;
            for (int i2 = 0; i2 < this.p.size(); i2++) {
                zzlk zzlkVar2 = (zzlk) this.p.get(i2);
                if (!zzlkVar2.c()) {
                    this.f35131l = zzlkVar2;
                    return;
                }
            }
        }
    }
}
