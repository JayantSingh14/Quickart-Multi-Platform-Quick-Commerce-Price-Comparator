package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzxk implements zzwe, zzaer, zzaar, zzaaw, zzxu {
    public static final Map Q;
    public static final zzv X;
    public boolean A;
    public boolean C;
    public boolean D;
    public boolean E;
    public int F;
    public boolean G;
    public long H;
    public boolean J;
    public int K;
    public boolean L;
    public boolean M;

    /* renamed from: a, reason: collision with root package name */
    public final Uri f35831a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhb f35832b;

    /* renamed from: c, reason: collision with root package name */
    public final zztk f35833c;

    /* renamed from: d, reason: collision with root package name */
    public final zzwq f35834d;

    /* renamed from: e, reason: collision with root package name */
    public final zztf f35835e;

    /* renamed from: f, reason: collision with root package name */
    public final zzxo f35836f;

    /* renamed from: g, reason: collision with root package name */
    public final zzaah f35837g;

    /* renamed from: h, reason: collision with root package name */
    public final long f35838h;

    /* renamed from: i, reason: collision with root package name */
    public final long f35839i;

    /* renamed from: k, reason: collision with root package name */
    public final zzwz f35841k;
    public zzwd p;
    public zzahv q;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public zzxj x;
    public zzafr y;
    public long z;

    /* renamed from: j, reason: collision with root package name */
    public final zzaaz f35840j = new zzaaz();

    /* renamed from: l, reason: collision with root package name */
    public final zzdq f35842l = new zzdq();

    /* renamed from: m, reason: collision with root package name */
    public final Runnable f35843m = new Runnable() { // from class: com.google.android.gms.internal.ads.zzxg
        @Override // java.lang.Runnable
        public final /* synthetic */ void run() {
            this.f35822a.q();
        }
    };
    public final Runnable n = new Runnable() { // from class: com.google.android.gms.internal.ads.zzxd
        @Override // java.lang.Runnable
        public final /* synthetic */ void run() {
            zzxk zzxkVar = this.f35818a;
            if (zzxkVar.M) {
                return;
            }
            zzwd zzwdVar = zzxkVar.p;
            zzwdVar.getClass();
            zzwdVar.e(zzxkVar);
        }
    };
    public final Handler o = zzfj.n();
    public zzxi[] s = new zzxi[0];
    public zzxv[] r = new zzxv[0];
    public long I = -9223372036854775807L;
    public int B = 1;

    static {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        Q = Collections.unmodifiableMap(map);
        zzt zztVar = new zzt();
        zztVar.f35564a = "icy";
        zztVar.e("application/x-icy");
        X = new zzv(zztVar);
    }

    public zzxk(Uri uri, zzhb zzhbVar, zzwz zzwzVar, zztk zztkVar, zztf zztfVar, zzwq zzwqVar, zzxo zzxoVar, zzaah zzaahVar, int i2, long j2) {
        this.f35831a = uri;
        this.f35832b = zzhbVar;
        this.f35833c = zztkVar;
        this.f35835e = zztfVar;
        this.f35834d = zzwqVar;
        this.f35836f = zzxoVar;
        this.f35837g = zzaahVar;
        this.f35838h = i2;
        this.f35841k = zzwzVar;
        this.f35839i = j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b1  */
    @Override // com.google.android.gms.internal.ads.zzwe
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long a(long r13) {
        /*
            Method dump skipped, instructions count: 195
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxk.a(long):long");
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final boolean b(zzli zzliVar) {
        if (this.L) {
            return false;
        }
        zzaaz zzaazVar = this.f35840j;
        if (zzaazVar.f22626c != null || this.J) {
            return false;
        }
        if (this.u && this.F == 0) {
            return false;
        }
        boolean zA = this.f35842l.a();
        if (zzaazVar.f22625b != null) {
            return zA;
        }
        r();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    @Override // com.google.android.gms.internal.ads.zzwe
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(long r12) {
        /*
            r11 = this;
            boolean r0 = r11.w
            if (r0 == 0) goto L5
            goto L5b
        L5:
            r11.v()
            boolean r0 = r11.u()
            if (r0 != 0) goto L5b
            com.google.android.gms.internal.ads.zzxj r0 = r11.x
            boolean[] r0 = r0.f35829c
            com.google.android.gms.internal.ads.zzxv[] r1 = r11.r
            int r1 = r1.length
            r2 = 0
        L16:
            if (r2 >= r1) goto L5b
            com.google.android.gms.internal.ads.zzxv[] r3 = r11.r
            r4 = r3[r2]
            boolean r3 = r0[r2]
            com.google.android.gms.internal.ads.zzxq r10 = r4.f35871a
            monitor-enter(r4)
            int r5 = r4.o     // Catch: java.lang.Throwable -> L3c
            if (r5 == 0) goto L30
            long[] r6 = r4.f35883m     // Catch: java.lang.Throwable -> L3c
            r7 = r5
            int r5 = r4.q     // Catch: java.lang.Throwable -> L3c
            r8 = r6[r5]     // Catch: java.lang.Throwable -> L3c
            int r6 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r6 >= 0) goto L32
        L30:
            r7 = r12
            goto L4f
        L32:
            if (r3 == 0) goto L3f
            int r3 = r4.r     // Catch: java.lang.Throwable -> L3c
            if (r3 == r7) goto L3f
            int r3 = r3 + 1
            r6 = r3
            goto L40
        L3c:
            r0 = move-exception
            r12 = r0
            goto L59
        L3f:
            r6 = r7
        L40:
            r9 = 0
            r7 = r12
            int r12 = r4.h(r5, r6, r7, r9)     // Catch: java.lang.Throwable -> L3c
            r13 = -1
            if (r12 == r13) goto L4f
            long r12 = r4.i(r12)     // Catch: java.lang.Throwable -> L3c
            monitor-exit(r4)
            goto L52
        L4f:
            monitor-exit(r4)
            r12 = -1
        L52:
            r10.a(r12)
            int r2 = r2 + 1
            r12 = r7
            goto L16
        L59:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L3c
            throw r12
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxk.c(long):void");
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final void d(final zzafr zzafrVar) {
        this.o.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzxe
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzxk zzxkVar = this.f35819a;
                zzahv zzahvVar = zzxkVar.q;
                zzafr zzafrVar2 = zzafrVar;
                zzxkVar.y = zzahvVar == null ? zzafrVar2 : new zzafq(-9223372036854775807L, 0L);
                zzxkVar.z = zzafrVar2.zza();
                boolean z = false;
                if (!zzxkVar.G && zzafrVar2.zza() == -9223372036854775807L) {
                    z = true;
                }
                zzxkVar.A = z;
                zzxkVar.B = true == z ? 7 : 1;
                if (zzxkVar.u) {
                    zzxkVar.f35836f.t(zzxkVar.z, zzafrVar2, z);
                } else {
                    zzxkVar.q();
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final zzaga e(int i2, int i3) {
        return p(new zzxi(i2, false));
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final long f(zzzw[] zzzwVarArr, boolean[] zArr, zzxw[] zzxwVarArr, boolean[] zArr2, long j2) {
        boolean[] zArr3;
        zzzw zzzwVar;
        v();
        zzxj zzxjVar = this.x;
        zzyh zzyhVar = zzxjVar.f35827a;
        int i2 = this.F;
        int i3 = 0;
        while (true) {
            int length = zzzwVarArr.length;
            zArr3 = zzxjVar.f35829c;
            if (i3 >= length) {
                break;
            }
            zzxw zzxwVar = zzxwVarArr[i3];
            if (zzxwVar != null && (zzzwVarArr[i3] == null || !zArr[i3])) {
                int i4 = ((zzxh) zzxwVar).f35823a;
                zzgqa.f(zArr3[i4]);
                this.F--;
                zArr3[i4] = false;
                zzxwVarArr[i3] = null;
            }
            i3++;
        }
        boolean z = !this.C ? j2 == 0 || this.w : i2 != 0;
        for (int i5 = 0; i5 < zzzwVarArr.length; i5++) {
            if (zzxwVarArr[i5] == null && (zzzwVar = zzzwVarArr[i5]) != null) {
                zzgqa.f(zzzwVar.zze() == 1);
                zzgqa.f(zzzwVar.zzf(0) == 0);
                int iIndexOf = zzyhVar.f35906b.indexOf(zzzwVar.zza());
                if (iIndexOf < 0) {
                    iIndexOf = -1;
                }
                zzgqa.f(!zArr3[iIndexOf]);
                this.F++;
                zArr3[iIndexOf] = true;
                this.E = zzzwVar.zzc().s | this.E;
                zzxwVarArr[i5] = new zzxh(this, iIndexOf);
                zArr2[i5] = true;
                if (!z) {
                    zzxv zzxvVar = this.r[iIndexOf];
                    z = (zzxvVar.p + zzxvVar.r == 0 || zzxvVar.m(j2, true)) ? false : true;
                }
            }
        }
        if (this.F == 0) {
            this.J = false;
            this.D = false;
            this.E = false;
            zzaaz zzaazVar = this.f35840j;
            if (zzaazVar.f22625b != null) {
                for (zzxv zzxvVar2 : this.r) {
                    zzxvVar2.n();
                }
                zzaau zzaauVar = zzaazVar.f22625b;
                zzaauVar.getClass();
                zzaauVar.a(false);
            } else {
                this.L = false;
                for (zzxv zzxvVar3 : this.r) {
                    zzxvVar3.k(false);
                }
            }
        } else if (z) {
            j2 = a(j2);
            for (int i6 = 0; i6 < zzxwVarArr.length; i6++) {
                if (zzxwVarArr[i6] != null) {
                    zArr2[i6] = true;
                }
            }
        }
        this.C = true;
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final void g(long j2) {
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final void h() {
        this.t = true;
        this.o.post(this.f35843m);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d7 A[RETURN] */
    @Override // com.google.android.gms.internal.ads.zzwe
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long i(long r26, com.google.android.gms.internal.ads.zzmq r28) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxk.i(long, com.google.android.gms.internal.ads.zzmq):long");
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final void j(zzwd zzwdVar, long j2) {
        this.p = zzwdVar;
        this.f35842l.a();
        r();
    }

    public final void k(zzaav zzaavVar, boolean z) {
        zzxb zzxbVar = (zzxb) zzaavVar;
        Uri uri = zzxbVar.f35806b.f34493b;
        zzvx zzvxVar = new zzvx();
        zzwc zzwcVar = new zzwc(-1, null, zzfj.r(zzxbVar.f35813i), zzfj.r(this.z));
        zzwq zzwqVar = this.f35834d;
        zzwqVar.a(new zzwl(zzwqVar, zzvxVar, zzwcVar));
        if (z) {
            return;
        }
        for (zzxv zzxvVar : this.r) {
            zzxvVar.k(false);
        }
        if (this.F > 0) {
            zzwd zzwdVar = this.p;
            zzwdVar.getClass();
            zzwdVar.e(this);
        }
    }

    public final void l(zzaav zzaavVar) {
        zzxb zzxbVar = (zzxb) zzaavVar;
        if (this.z == -9223372036854775807L && this.y != null) {
            long jT = t(true);
            long j2 = jT == Long.MIN_VALUE ? 0L : jT + 10000;
            this.z = j2;
            this.f35836f.t(j2, this.y, this.A);
        }
        Uri uri = zzxbVar.f35806b.f34493b;
        zzvx zzvxVar = new zzvx();
        zzwc zzwcVar = new zzwc(-1, null, zzfj.r(zzxbVar.f35813i), zzfj.r(this.z));
        zzwq zzwqVar = this.f35834d;
        zzwqVar.a(new zzwk(zzwqVar, zzvxVar, zzwcVar));
        this.L = true;
        zzwd zzwdVar = this.p;
        zzwdVar.getClass();
        zzwdVar.e(this);
    }

    public final void m(int i2) {
        v();
        zzxj zzxjVar = this.x;
        boolean[] zArr = zzxjVar.f35830d;
        if (zArr[i2]) {
            return;
        }
        zzv zzvVar = zzxjVar.f35827a.a(i2).f24986d[0];
        zzwc zzwcVar = new zzwc(zzas.f(zzvVar.f35691m), zzvVar, zzfj.r(this.H), -9223372036854775807L);
        zzwq zzwqVar = this.f35834d;
        zzwqVar.a(new zzwn(zzwqVar, zzwcVar));
        zArr[i2] = true;
    }

    public final void n(int i2) {
        v();
        if (this.J) {
            if ((!this.v || this.x.f35828b[i2]) && !this.r[i2].l(false)) {
                this.I = 0L;
                this.J = false;
                this.D = true;
                this.H = 0L;
                this.K = 0;
                for (zzxv zzxvVar : this.r) {
                    zzxvVar.k(false);
                }
                zzwd zzwdVar = this.p;
                zzwdVar.getClass();
                zzwdVar.e(this);
            }
        }
    }

    public final boolean o() {
        return this.D || u();
    }

    public final zzaga p(zzxi zzxiVar) {
        int length = this.r.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (zzxiVar.equals(this.s[i2])) {
                return this.r[i2];
            }
        }
        if (this.t) {
            int i3 = zzxiVar.f35825a;
            StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 55);
            sb.append("Extractor added new track (id=");
            sb.append(i3);
            sb.append(") after finishing tracks.");
            zzee.c("ProgressiveMediaPeriod", sb.toString());
            return new zzael();
        }
        zzxv zzxvVar = new zzxv(this.f35837g, this.f35833c, this.f35835e);
        zzxvVar.f35875e = this;
        int i4 = length + 1;
        zzxi[] zzxiVarArr = (zzxi[]) Arrays.copyOf(this.s, i4);
        zzxiVarArr[length] = zzxiVar;
        String str = zzfj.f31254a;
        this.s = zzxiVarArr;
        zzxv[] zzxvVarArr = (zzxv[]) Arrays.copyOf(this.r, i4);
        zzxvVarArr[length] = zzxvVar;
        this.r = zzxvVarArr;
        return zzxvVar;
    }

    public final void q() {
        long j2;
        zzv zzvVar;
        zzap zzapVarC;
        int i2;
        zzv zzvVar2;
        boolean z = false;
        if (this.M || this.u || !this.t || this.y == null) {
            return;
        }
        zzxv[] zzxvVarArr = this.r;
        int length = zzxvVarArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                zzdq zzdqVar = this.f35842l;
                synchronized (zzdqVar) {
                    zzdqVar.f28219a = false;
                }
                int length2 = this.r.length;
                zzbg[] zzbgVarArr = new zzbg[length2];
                boolean[] zArr = new boolean[length2];
                int i4 = 0;
                while (true) {
                    j2 = this.f35839i;
                    if (i4 >= length2) {
                        break;
                    }
                    zzxv zzxvVar = this.r[i4];
                    synchronized (zzxvVar) {
                        zzvVar = zzxvVar.x ? null : zzxvVar.y;
                    }
                    zzvVar.getClass();
                    String str = zzvVar.f35691m;
                    boolean zA = zzas.a(str);
                    boolean z2 = (zA || zzas.b(str)) ? true : z;
                    zArr[i4] = z2;
                    boolean z3 = z;
                    this.v |= z2;
                    this.w = (j2 != -9223372036854775807L && length2 == 1 && zzas.c(str)) ? true : z3 ? 1 : 0;
                    zzahv zzahvVar = this.q;
                    if (zzahvVar != null) {
                        if (zA || this.s[i4].f35826b) {
                            zzap zzapVar = zzvVar.f35689k;
                            if (zzapVar == null) {
                                zzao[] zzaoVarArr = new zzao[1];
                                zzaoVarArr[z3 ? 1 : 0] = zzahvVar;
                                zzapVarC = new zzap(zzaoVarArr);
                            } else {
                                zzao[] zzaoVarArr2 = new zzao[1];
                                zzaoVarArr2[z3 ? 1 : 0] = zzahvVar;
                                zzapVarC = zzapVar.c(zzaoVarArr2);
                            }
                            zzt zztVar = new zzt(zzvVar);
                            zztVar.f35573j = zzapVarC;
                            zzvVar = new zzv(zztVar);
                        }
                        if (zA && zzvVar.f35685g == -1 && zzvVar.f35686h == -1 && (i2 = zzahvVar.f23149a) != -1) {
                            zzt zztVar2 = new zzt(zzvVar);
                            zztVar2.f35570g = i2;
                            zzvVar = new zzv(zztVar2);
                        }
                    }
                    ((zzth) this.f35833c).getClass();
                    int i5 = zzvVar.q != null ? 1 : z3 ? 1 : 0;
                    zzt zztVar3 = new zzt(zzvVar);
                    zztVar3.K = i5;
                    zzv zzvVar3 = new zzv(zztVar3);
                    zzbgVarArr[i4] = new zzbg(Integer.toString(i4), zzvVar3);
                    this.E = zzvVar3.s | this.E;
                    i4++;
                    z = z3 ? 1 : 0;
                }
                this.x = new zzxj(new zzyh(zzbgVarArr), zArr);
                if (this.w && this.z == -9223372036854775807L) {
                    this.z = j2;
                    this.y = new zzxa(this, this.y);
                }
                this.f35836f.t(this.z, this.y, this.A);
                this.u = true;
                zzwd zzwdVar = this.p;
                zzwdVar.getClass();
                zzwdVar.d(this);
                return;
            }
            zzxv zzxvVar2 = zzxvVarArr[i3];
            synchronized (zzxvVar2) {
                zzvVar2 = zzxvVar2.x ? null : zzxvVar2.y;
            }
            if (zzvVar2 == null) {
                return;
            } else {
                i3++;
            }
        }
    }

    public final void r() {
        zzxb zzxbVar = new zzxb(this, this.f35831a, this.f35832b, this.f35841k, this, this.f35842l);
        if (this.u) {
            zzgqa.f(u());
            long j2 = this.z;
            if (j2 != -9223372036854775807L && this.I > j2) {
                this.L = true;
                this.I = -9223372036854775807L;
                return;
            }
            zzafr zzafrVar = this.y;
            zzafrVar.getClass();
            zzafs zzafsVar = zzafrVar.b(this.I).f22955a;
            long j3 = this.I;
            zzxbVar.f35810f.f22954a = zzafsVar.f22961b;
            zzxbVar.f35813i = j3;
            zzxbVar.f35812h = true;
            zzxbVar.f35816l = false;
            for (zzxv zzxvVar : this.r) {
                zzxvVar.s = this.I;
            }
            this.I = -9223372036854775807L;
        }
        this.K = s();
        zzaaz zzaazVar = this.f35840j;
        zzaazVar.getClass();
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper.getClass();
        zzaazVar.f22626c = null;
        zzaau zzaauVar = new zzaau(zzaazVar, looperMyLooper, zzxbVar, this, SystemClock.elapsedRealtime());
        zzaaz zzaazVar2 = zzaauVar.f22620h;
        zzgqa.f(zzaazVar2.f22625b == null);
        zzaazVar2.f22625b = zzaauVar;
        zzaauVar.b();
    }

    public final int s() {
        int i2 = 0;
        for (zzxv zzxvVar : this.r) {
            i2 += zzxvVar.p + zzxvVar.o;
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long t(boolean r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = -9223372036854775808
        L3:
            com.google.android.gms.internal.ads.zzxv[] r3 = r6.r
            int r4 = r3.length
            if (r0 >= r4) goto L25
            if (r7 != 0) goto L15
            com.google.android.gms.internal.ads.zzxj r4 = r6.x
            r4.getClass()
            boolean[] r4 = r4.f35829c
            boolean r4 = r4[r0]
            if (r4 == 0) goto L1f
        L15:
            r3 = r3[r0]
            monitor-enter(r3)
            long r4 = r3.u     // Catch: java.lang.Throwable -> L22
            monitor-exit(r3)
            long r1 = java.lang.Math.max(r1, r4)
        L1f:
            int r0 = r0 + 1
            goto L3
        L22:
            r7 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L22
            throw r7
        L25:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxk.t(boolean):long");
    }

    public final boolean u() {
        return this.I != -9223372036854775807L;
    }

    public final void v() {
        zzgqa.f(this.u);
        this.x.getClass();
        this.y.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final void zzc() throws IOException {
        IOException iOException;
        int i2 = this.B == 7 ? 6 : 3;
        zzaaz zzaazVar = this.f35840j;
        IOException iOException2 = zzaazVar.f22626c;
        if (iOException2 != null) {
            throw iOException2;
        }
        zzaau zzaauVar = zzaazVar.f22625b;
        if (zzaauVar != null && (iOException = zzaauVar.f22615c) != null && zzaauVar.f22616d > i2) {
            throw iOException;
        }
        if (this.L && !this.u) {
            throw zzat.a(null, "Loading finished before preparation is complete.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final zzyh zzd() {
        v();
        return this.x.f35827a;
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final long zzh() {
        if (this.E) {
            this.E = false;
        } else {
            if (!this.D) {
                return -9223372036854775807L;
            }
            if (!this.L && s() <= this.K) {
                return -9223372036854775807L;
            }
            this.D = false;
        }
        return this.H;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final long zzi() {
        long jT;
        boolean z;
        long j2;
        v();
        if (this.L || this.F == 0) {
            return Long.MIN_VALUE;
        }
        if (u()) {
            return this.I;
        }
        if (this.v) {
            int length = this.r.length;
            jT = Long.MAX_VALUE;
            for (int i2 = 0; i2 < length; i2++) {
                zzxj zzxjVar = this.x;
                if (zzxjVar.f35828b[i2] && zzxjVar.f35829c[i2]) {
                    zzxv zzxvVar = this.r[i2];
                    synchronized (zzxvVar) {
                        z = zzxvVar.v;
                    }
                    if (z) {
                        continue;
                    } else {
                        zzxv zzxvVar2 = this.r[i2];
                        synchronized (zzxvVar2) {
                            j2 = zzxvVar2.u;
                        }
                        jT = Math.min(jT, j2);
                    }
                }
            }
        } else {
            jT = Long.MAX_VALUE;
        }
        if (jT == Long.MAX_VALUE) {
            jT = t(false);
        }
        return jT == Long.MIN_VALUE ? this.H : jT;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final long zzl() {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final boolean zzn() {
        boolean z;
        if (this.f35840j.f22625b == null) {
            return false;
        }
        zzdq zzdqVar = this.f35842l;
        synchronized (zzdqVar) {
            z = zzdqVar.f28219a;
        }
        return z;
    }
}
