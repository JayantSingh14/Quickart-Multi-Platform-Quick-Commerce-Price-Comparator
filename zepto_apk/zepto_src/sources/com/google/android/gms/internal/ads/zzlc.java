package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzlc implements Handler.Callback, zzwd, zzaac, zzly, zziq, zzmc, zzcc, zzacj {
    public static final long M0 = zzfj.r(10000);
    public static final /* synthetic */ int N0 = 0;
    public zzlb A0;
    public boolean B;
    public long B0;
    public boolean C;
    public long C0;
    public zzlb D;
    public int D0;
    public int E;
    public boolean E0;
    public zzma F;
    public zzit F0;
    public zzkz G;
    public boolean H;
    public zzjd H0;
    public boolean J;
    public boolean J0;
    public boolean K;
    public final zzim L0;
    public boolean M;
    public boolean Y;
    public int Z;

    /* renamed from: a, reason: collision with root package name */
    public final zzmm[] f35068a;

    /* renamed from: b, reason: collision with root package name */
    public final zzmk[] f35069b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean[] f35070c;

    /* renamed from: d, reason: collision with root package name */
    public final zzaad f35071d;

    /* renamed from: e, reason: collision with root package name */
    public final zzaae f35072e;

    /* renamed from: f, reason: collision with root package name */
    public final zzlg f35073f;

    /* renamed from: g, reason: collision with root package name */
    public final zzaam f35074g;

    /* renamed from: h, reason: collision with root package name */
    public final zzdx f35075h;

    /* renamed from: i, reason: collision with root package name */
    public final zzmb f35076i;

    /* renamed from: j, reason: collision with root package name */
    public final Looper f35077j;

    /* renamed from: k, reason: collision with root package name */
    public final zzbe f35078k;

    /* renamed from: l, reason: collision with root package name */
    public final zzbd f35079l;

    /* renamed from: m, reason: collision with root package name */
    public final long f35080m;
    public final zzir n;
    public final ArrayList o;
    public final zzfc p;
    public final zzla q;
    public final zzln r;
    public final zzlz s;
    public final long t;
    public final zzpn u;
    public final zzoz v;
    public final zzdx w;
    public final boolean x;
    public final zzcd y;
    public zzmq z;
    public long I0 = -9223372036854775807L;
    public int Q = 0;
    public boolean X = false;
    public boolean I = false;
    public float K0 = 1.0f;
    public zzmp A = zzmp.f35219b;
    public long G0 = -9223372036854775807L;
    public long L = -9223372036854775807L;

    public zzlc(Context context, zzmi[] zzmiVarArr, zzmi[] zzmiVarArr2, zzaad zzaadVar, zzaae zzaaeVar, zzlg zzlgVar, zzaam zzaamVar, zzoz zzozVar, zzmq zzmqVar, zzim zzimVar, long j2, Looper looper, zzfc zzfcVar, zzla zzlaVar, zzpn zzpnVar, zzjd zzjdVar, final zzacj zzacjVar) {
        Looper looper2;
        this.q = zzlaVar;
        this.f35071d = zzaadVar;
        this.f35072e = zzaaeVar;
        this.f35073f = zzlgVar;
        this.f35074g = zzaamVar;
        this.z = zzmqVar;
        this.L0 = zzimVar;
        this.t = j2;
        this.p = zzfcVar;
        this.u = zzpnVar;
        this.H0 = zzjdVar;
        this.v = zzozVar;
        this.f35080m = zzlgVar.zzf();
        zzlgVar.zzg();
        zzbf zzbfVar = zzbf.f24868a;
        zzma zzmaVarA = zzma.a(zzaaeVar);
        this.F = zzmaVarA;
        this.G = new zzkz(zzmaVarA);
        int length = zzmiVarArr.length;
        this.f35069b = new zzmk[2];
        this.f35070c = new boolean[2];
        zzmj zzmjVarD = zzaadVar.d();
        this.f35068a = new zzmm[2];
        int i2 = 0;
        boolean z = false;
        for (int i3 = 2; i2 < i3; i3 = 2) {
            zzmiVarArr[i2].n(i2, zzpnVar, zzfcVar);
            this.f35069b[i2] = zzmiVarArr[i2].zzb();
            this.f35069b[i2].q(zzmjVarD);
            zzmi zzmiVar = zzmiVarArr2[i2];
            if (zzmiVar != null) {
                zzmiVar.n(i2, zzpnVar, zzfcVar);
                z = true;
            }
            this.f35068a[i2] = new zzmm(zzmiVarArr[i2], zzmiVarArr2[i2], i2);
            i2++;
        }
        this.x = z;
        this.n = new zzir(this);
        this.o = new ArrayList();
        this.f35078k = new zzbe();
        this.f35079l = new zzbd();
        zzgqa.f(zzaadVar.f22576a == null);
        zzaadVar.f22576a = this;
        zzaadVar.f22577b = zzaamVar;
        this.E0 = true;
        zzdx zzdxVarA = zzfcVar.a(looper, null);
        this.w = zzdxVarA;
        this.r = new zzln(zzozVar, zzdxVarA, new zzkv(this), zzjdVar);
        this.s = new zzlz(this, zzozVar, zzdxVarA, zzpnVar);
        zzmb zzmbVar = new zzmb(0);
        this.f35076i = zzmbVar;
        synchronized (zzmbVar.f35192a) {
            try {
                if (zzmbVar.f35193b == null) {
                    zzgqa.f(zzmbVar.f35195d == 0 && zzmbVar.f35194c == null);
                    HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
                    zzmbVar.f35194c = handlerThread;
                    handlerThread.start();
                    zzmbVar.f35193b = zzmbVar.f35194c.getLooper();
                }
                zzmbVar.f35195d++;
                looper2 = zzmbVar.f35193b;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f35077j = looper2;
        zzdx zzdxVarA2 = zzfcVar.a(looper2, this);
        this.f35075h = zzdxVarA2;
        this.y = new zzcd(context, looper2, this);
        ((zzfd) ((zzfe) zzdxVarA2).g(35, new zzacj() { // from class: com.google.android.gms.internal.ads.zzkr
            @Override // com.google.android.gms.internal.ads.zzacj
            public final /* synthetic */ void a(long j3, long j4, zzv zzvVar, MediaFormat mediaFormat) {
                this.f35048a.a(j3, j4, zzvVar, mediaFormat);
            }
        })).a();
    }

    public static Pair A(zzbf zzbfVar, zzlb zzlbVar, int i2, boolean z, zzbe zzbeVar, zzbd zzbdVar) {
        zzbf zzbfVar2 = zzlbVar.f35065a;
        if (zzbfVar.g()) {
            return null;
        }
        zzbf zzbfVar3 = true == zzbfVar2.g() ? zzbfVar : zzbfVar2;
        try {
            Pair pairM = zzbfVar3.m(zzbeVar, zzbdVar, zzlbVar.f35066b, zzlbVar.f35067c);
            if (!zzbfVar.equals(zzbfVar3)) {
                if (zzbfVar.e(pairM.first) == -1) {
                    int iX = X(zzbeVar, zzbdVar, i2, z, pairM.first, zzbfVar3, zzbfVar);
                    if (iX != -1) {
                        return zzbfVar.m(zzbeVar, zzbdVar, iX, -9223372036854775807L);
                    }
                    return null;
                }
                if (zzbfVar3.o(pairM.first, zzbdVar).f24741e && zzbfVar3.b(zzbdVar.f24739c, zzbeVar, 0L).f24833k == zzbfVar3.e(pairM.first)) {
                    return zzbfVar.m(zzbeVar, zzbdVar, zzbfVar.o(pairM.first, zzbdVar).f24739c, zzlbVar.f35067c);
                }
            }
            return pairM;
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.internal.ads.zzwe, com.google.android.gms.internal.ads.zzxy, java.lang.Object] */
    public static final boolean B(zzlk zzlkVar) {
        if (zzlkVar != null) {
            try {
                ?? r1 = zzlkVar.f35096a;
                if (zzlkVar.f35100e) {
                    zzxw[] zzxwVarArr = zzlkVar.f35098c;
                    for (int i2 = 0; i2 < 2; i2++) {
                        zzxw zzxwVar = zzxwVarArr[i2];
                        if (zzxwVar != null) {
                            zzxwVar.zzc();
                        }
                    }
                } else {
                    r1.zzc();
                }
                if ((!zzlkVar.f35100e ? 0L : r1.zzl()) != Long.MIN_VALUE) {
                    return true;
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }

    public static int X(zzbe zzbeVar, zzbd zzbdVar, int i2, boolean z, Object obj, zzbf zzbfVar, zzbf zzbfVar2) {
        zzbe zzbeVar2 = zzbeVar;
        zzbf zzbfVar3 = zzbfVar;
        Object obj2 = zzbfVar3.b(zzbfVar3.o(obj, zzbdVar).f24739c, zzbeVar, 0L).f24823a;
        for (int i3 = 0; i3 < zzbfVar2.a(); i3++) {
            if (zzbfVar2.b(i3, zzbeVar, 0L).f24823a.equals(obj2)) {
                return i3;
            }
        }
        int iE = zzbfVar3.e(obj);
        int iC = zzbfVar3.c();
        int iE2 = -1;
        int i4 = 0;
        while (true) {
            if (i4 >= iC || iE2 != -1) {
                break;
            }
            zzbf zzbfVar4 = zzbfVar3;
            int iL = zzbfVar4.l(iE, zzbdVar, zzbeVar2, i2, z);
            if (iL == -1) {
                iE2 = -1;
                break;
            }
            iE2 = zzbfVar2.e(zzbfVar4.f(iL));
            i4++;
            zzbfVar3 = zzbfVar4;
            iE = iL;
            zzbeVar2 = zzbeVar;
        }
        if (iE2 == -1) {
            return -1;
        }
        return zzbfVar2.d(iE2, zzbdVar, false).f24739c;
    }

    public final void C() {
        for (int i2 = 0; i2 < 2; i2++) {
            zzmm[] zzmmVarArr = this.f35068a;
            int iQ = zzmmVarArr[i2].q();
            zzmm zzmmVar = zzmmVarArr[i2];
            zzmi zzmiVar = zzmmVar.f35212a;
            zzir zzirVar = this.n;
            zzmmVar.i(zzmiVar, zzirVar);
            zzmi zzmiVar2 = zzmmVar.f35214c;
            if (zzmiVar2 != null) {
                boolean z = (zzmiVar2.zze() == 0 || zzmmVar.f35215d == 3) ? false : true;
                zzmmVar.i(zzmiVar2, zzirVar);
                zzmmVar.j(false);
                if (z) {
                    zzmiVar2.getClass();
                    zzmiVar2.u(17, zzmmVar.f35212a);
                }
            }
            zzmmVar.f35215d = 0;
            n(i2, false);
            this.Z -= iQ;
        }
        this.I0 = -9223372036854775807L;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D() {
        /*
            r10 = this;
            boolean r0 = r10.x
            if (r0 == 0) goto L5a
            boolean r0 = r10.W()
            if (r0 != 0) goto Lb
            goto L5a
        Lb:
            r0 = 0
            r1 = r0
        Ld:
            r2 = 2
            if (r1 >= r2) goto L53
            com.google.android.gms.internal.ads.zzmm[] r3 = r10.f35068a
            r3 = r3[r1]
            int r4 = r3.q()
            boolean r5 = r3.p()
            if (r5 != 0) goto L1f
            goto L46
        L1f:
            int r5 = r3.f35215d
            r6 = 1
            r7 = 4
            if (r5 == r7) goto L2c
            if (r5 != r2) goto L29
        L27:
            r5 = r6
            goto L2e
        L29:
            r2 = r5
            r5 = r0
            goto L2e
        L2c:
            r2 = r5
            goto L27
        L2e:
            if (r5 == 0) goto L33
            com.google.android.gms.internal.ads.zzmi r8 = r3.f35212a
            goto L38
        L33:
            com.google.android.gms.internal.ads.zzmi r8 = r3.f35214c
            r8.getClass()
        L38:
            com.google.android.gms.internal.ads.zzir r9 = r10.n
            r3.i(r8, r9)
            r3.j(r5)
            if (r2 != r7) goto L43
            goto L44
        L43:
            r6 = r0
        L44:
            r3.f35215d = r6
        L46:
            int r2 = r10.Z
            int r3 = r3.q()
            int r4 = r4 - r3
            int r2 = r2 - r4
            r10.Z = r2
            int r1 = r1 + 1
            goto Ld
        L53:
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r10.I0 = r0
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlc.D():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E() {
        /*
            Method dump skipped, instructions count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlc.E():void");
    }

    public final boolean F() {
        zzlk zzlkVar = this.r.f35127h;
        long j2 = zzlkVar.f35102g.f35113e;
        if (zzlkVar.f35100e) {
            return j2 == -9223372036854775807L || this.F.r < j2 || !U();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01fc  */
    /* JADX WARN: Type inference failed for: r0v40, types: [com.google.android.gms.internal.ads.zzdx] */
    /* JADX WARN: Type inference failed for: r15v13, types: [int] */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v22, types: [int] */
    /* JADX WARN: Type inference failed for: r15v33 */
    /* JADX WARN: Type inference failed for: r15v38 */
    /* JADX WARN: Type inference failed for: r15v39 */
    /* JADX WARN: Type inference failed for: r2v20, types: [com.google.android.gms.internal.ads.zzdx] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G(com.google.android.gms.internal.ads.zzbf r32, boolean r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1090
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlc.G(com.google.android.gms.internal.ads.zzbf, boolean):void");
    }

    public final void H(zzbf zzbfVar, zzwg zzwgVar, zzbf zzbfVar2, zzwg zzwgVar2, long j2, boolean z) {
        if (!p(zzbfVar, zzwgVar)) {
            zzav zzavVar = zzwgVar.b() ? zzav.f24411d : this.F.o;
            zzir zzirVar = this.n;
            if (zzirVar.zzj().equals(zzavVar)) {
                return;
            }
            this.f35075h.r(16);
            zzirVar.s(zzavVar);
            L(this.F.o, zzavVar.f24412a, false, false);
            return;
        }
        Object obj = zzwgVar.f35758a;
        zzbd zzbdVar = this.f35079l;
        int i2 = zzbfVar.o(obj, zzbdVar).f24739c;
        zzbe zzbeVar = this.f35078k;
        zzbfVar.b(i2, zzbeVar, 0L);
        zzaf zzafVar = zzbeVar.f24830h;
        String str = zzfj.f31254a;
        zzim zzimVar = this.L0;
        zzimVar.getClass();
        zzafVar.getClass();
        long jS = zzfj.s(-9223372036854775807L);
        zzimVar.f34930c = jS;
        zzimVar.f34933f = jS;
        zzimVar.f34934g = jS;
        zzimVar.c();
        if (j2 != -9223372036854775807L) {
            zzimVar.f34931d = o(zzbfVar, obj, j2);
            zzimVar.c();
            return;
        }
        if (!Objects.equals(!zzbfVar2.g() ? zzbfVar2.b(zzbfVar2.o(zzwgVar2.f35758a, zzbdVar).f24739c, zzbeVar, 0L).f24823a : null, zzbeVar.f24823a) || z) {
            zzimVar.f34931d = -9223372036854775807L;
            zzimVar.c();
        }
    }

    public final long I(zzlk zzlkVar) {
        if (zzlkVar == null) {
            return 0L;
        }
        long jMax = zzlkVar.p;
        if (zzlkVar.f35100e) {
            for (int i2 = 0; i2 < 2; i2++) {
                zzmm[] zzmmVarArr = this.f35068a;
                if (zzmmVarArr[i2].m(zzlkVar) != null) {
                    zzmi zzmiVarM = zzmmVarArr[i2].m(zzlkVar);
                    Objects.requireNonNull(zzmiVarM);
                    long jZzk = zzmiVarM.zzk();
                    if (jZzk == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    }
                    jMax = Math.max(jZzk, jMax);
                }
            }
        }
        return jMax;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.gms.internal.ads.zzwe, com.google.android.gms.internal.ads.zzxy, java.lang.Object] */
    public final void J() {
        boolean z;
        zzln zzlnVar = this.r;
        zzlnVar.z();
        zzlk zzlkVar = zzlnVar.f35131l;
        if (zzlkVar != null) {
            if (!zzlkVar.f35099d || zzlkVar.f35100e) {
                ?? r1 = zzlkVar.f35096a;
                if (r1.zzn()) {
                    return;
                }
                zzbf zzbfVar = this.F.f35179a;
                if (zzlkVar.f35100e) {
                    r1.zzi();
                }
                if (this.f35073f.zzj()) {
                    if (!zzlkVar.f35099d) {
                        zzll zzllVar = zzlkVar.f35102g;
                        zzlkVar.f35099d = true;
                        r1.j(this, zzllVar.f35110b);
                        return;
                    }
                    zzlh zzlhVar = new zzlh();
                    zzlhVar.f35090a = this.B0 - zzlkVar.p;
                    float f2 = this.n.zzj().f24412a;
                    zzgqa.a(f2 > 0.0f || f2 == -3.4028235E38f);
                    zzlhVar.f35091b = f2;
                    long j2 = this.L;
                    if (j2 >= 0) {
                        z = true;
                    } else if (j2 == -9223372036854775807L) {
                        j2 = -9223372036854775807L;
                        z = true;
                    } else {
                        z = false;
                    }
                    zzgqa.a(z);
                    zzlhVar.f35092c = j2;
                    zzli zzliVar = new zzli(zzlhVar);
                    zzgqa.f(zzlkVar.f35108m == null);
                    r1.b(zzliVar);
                }
            }
        }
    }

    public final void K() {
        zzlk zzlkVar = this.r.f35127h;
        boolean z = false;
        if (zzlkVar != null && zzlkVar.f35102g.f35115g && this.I) {
            z = true;
        }
        this.J = z;
    }

    public final void L(zzav zzavVar, float f2, boolean z, boolean z2) {
        int i2;
        if (z) {
            if (z2) {
                this.G.a(1);
            }
            zzma zzmaVar = this.F;
            this.F = new zzma(zzmaVar.f35179a, zzmaVar.f35180b, zzmaVar.f35181c, zzmaVar.f35182d, zzmaVar.f35183e, zzmaVar.f35184f, zzmaVar.f35185g, zzmaVar.f35186h, zzmaVar.f35187i, zzmaVar.f35188j, zzmaVar.f35189k, zzmaVar.f35190l, zzmaVar.f35191m, zzmaVar.n, zzavVar, zzmaVar.p, zzmaVar.q, zzmaVar.r, zzmaVar.s);
        }
        float f3 = zzavVar.f24412a;
        zzlk zzlkVar = this.r.f35127h;
        while (true) {
            i2 = 0;
            if (zzlkVar == null) {
                break;
            }
            zzzw[] zzzwVarArr = zzlkVar.o.f22580c;
            int length = zzzwVarArr.length;
            while (i2 < length) {
                zzzw zzzwVar = zzzwVarArr[i2];
                i2++;
            }
            zzlkVar = zzlkVar.f35108m;
        }
        zzmm[] zzmmVarArr = this.f35068a;
        while (i2 < 2) {
            zzmm zzmmVar = zzmmVarArr[i2];
            zzmmVar.f35212a.m(f2, f3);
            zzmi zzmiVar = zzmmVar.f35214c;
            if (zzmiVar != null) {
                zzmiVar.m(f2, f3);
            }
            i2++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00f0  */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.gms.internal.ads.zzxy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v1, types: [com.google.android.gms.internal.ads.zzxy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v17, types: [com.google.android.gms.internal.ads.zzwe, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void M() {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlc.M():void");
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.google.android.gms.internal.ads.zzxy, java.lang.Object] */
    public final void N() {
        zzlk zzlkVar = this.r.f35130k;
        boolean z = true;
        if (!this.M && (zzlkVar == null || !zzlkVar.f35096a.zzn())) {
            z = false;
        }
        zzma zzmaVar = this.F;
        if (z != zzmaVar.f35185g) {
            this.F = zzmaVar.f(z);
        }
    }

    public final zzma O(zzwg zzwgVar, long j2, long j3, long j4, boolean z, int i2) {
        zzyh zzyhVar;
        zzaae zzaaeVar;
        List list;
        zzgtd zzgtdVarF;
        int i3;
        zzyh zzyhVar2;
        this.E0 = (!this.E0 && j2 == this.F.r && zzwgVar.equals(this.F.f35180b)) ? false : true;
        K();
        zzma zzmaVar = this.F;
        zzyh zzyhVar3 = zzmaVar.f35186h;
        zzaae zzaaeVar2 = zzmaVar.f35187i;
        List list2 = zzmaVar.f35188j;
        if (this.s.f35175j) {
            zzln zzlnVar = this.r;
            zzlk zzlkVar = zzlnVar.f35127h;
            zzyh zzyhVar4 = zzlkVar == null ? zzyh.f35904d : zzlkVar.n;
            zzaae zzaaeVar3 = zzlkVar == null ? this.f35072e : zzlkVar.o;
            zzzw[] zzzwVarArr = zzaaeVar3.f22580c;
            zzgta zzgtaVar = new zzgta();
            int length = zzzwVarArr.length;
            int i4 = 0;
            boolean z2 = false;
            while (i4 < length) {
                zzzw zzzwVar = zzzwVarArr[i4];
                if (zzzwVar != null) {
                    zzap zzapVar = zzzwVar.zzb(0).f35689k;
                    if (zzapVar == null) {
                        zzyhVar2 = zzyhVar4;
                        zzgtaVar.c(new zzap(new zzao[0]));
                    } else {
                        zzyhVar2 = zzyhVar4;
                        zzgtaVar.c(zzapVar);
                        z2 = true;
                    }
                } else {
                    zzyhVar2 = zzyhVar4;
                }
                i4++;
                zzyhVar4 = zzyhVar2;
            }
            zzyh zzyhVar5 = zzyhVar4;
            int i5 = 1;
            if (z2) {
                zzgtdVarF = zzgtaVar.f();
            } else {
                zzgvs zzgvsVar = zzgtd.f33183b;
                zzgtdVarF = zzguy.f33232e;
            }
            if (zzlkVar != null) {
                zzll zzllVar = zzlkVar.f35102g;
                if (zzllVar.f35111c != j3) {
                    zzlkVar.f35102g = zzllVar.b(j3);
                }
            }
            zzlk zzlkVar2 = zzlnVar.f35127h;
            if (zzlkVar2 == zzlnVar.f35128i && zzlkVar2 != null) {
                zzaae zzaaeVar4 = zzlkVar2.o;
                int i6 = 0;
                while (true) {
                    zzmm[] zzmmVarArr = this.f35068a;
                    if (i6 >= 2) {
                        break;
                    }
                    if (zzaaeVar4.a(i6)) {
                        i3 = i5;
                        if (zzmmVarArr[i6].f35212a.zza() != i3) {
                            break;
                        }
                        zzaaeVar4.f22579b[i6].getClass();
                    } else {
                        i3 = i5;
                    }
                    i6 += i3;
                    i5 = i3;
                }
            }
            list = zzgtdVarF;
            zzaaeVar = zzaaeVar3;
            zzyhVar = zzyhVar5;
        } else {
            if (!zzwgVar.equals(zzmaVar.f35180b)) {
                zzaaeVar2 = this.f35072e;
                zzyhVar3 = zzyh.f35904d;
                list2 = zzguy.f33232e;
            }
            zzyhVar = zzyhVar3;
            zzaaeVar = zzaaeVar2;
            list = list2;
        }
        if (z) {
            zzkz zzkzVar = this.G;
            if (!zzkzVar.f35062d || zzkzVar.f35063e == 5) {
                zzkzVar.f35059a = true;
                zzkzVar.f35062d = true;
                zzkzVar.f35063e = i2;
            } else {
                zzgqa.a(i2 == 5);
            }
        }
        zzma zzmaVar2 = this.F;
        return zzmaVar2.b(zzwgVar, j2, j3, j4, S(zzmaVar2.p), zzyhVar, zzaaeVar, list);
    }

    public final void P(boolean[] zArr, long j2) {
        zzmm[] zzmmVarArr;
        long j3;
        zzlk zzlkVar = this.r.f35128i;
        zzaae zzaaeVar = zzlkVar.o;
        int i2 = 0;
        while (true) {
            zzmmVarArr = this.f35068a;
            if (i2 >= 2) {
                break;
            }
            if (!zzaaeVar.a(i2)) {
                zzmmVarArr[i2].b();
            }
            i2++;
        }
        int i3 = 0;
        while (i3 < 2) {
            if (zzaaeVar.a(i3) && zzmmVarArr[i3].m(zzlkVar) == null) {
                j3 = j2;
                Q(zzlkVar, i3, zArr[i3], j3);
            } else {
                j3 = j2;
            }
            i3++;
            j2 = j3;
        }
    }

    public final void Q(zzlk zzlkVar, int i2, boolean z, long j2) {
        zzmm zzmmVar = this.f35068a[i2];
        if (zzmmVar.g()) {
            return;
        }
        boolean z2 = zzlkVar == this.r.f35127h;
        zzaae zzaaeVar = zzlkVar.o;
        zzml zzmlVar = zzaaeVar.f22579b[i2];
        zzzw zzzwVar = zzaaeVar.f22580c[i2];
        boolean z3 = U() && this.F.f35183e == 3;
        boolean z4 = !z && z3;
        this.Z++;
        zzxw zzxwVar = zzlkVar.f35098c[i2];
        long j3 = zzlkVar.p;
        zzll zzllVar = zzlkVar.f35102g;
        int iZze = zzzwVar != null ? zzzwVar.zze() : 0;
        zzv[] zzvVarArr = new zzv[iZze];
        for (int i3 = 0; i3 < iZze; i3++) {
            zzzwVar.getClass();
            zzvVarArr[i3] = zzzwVar.zzb(i3);
        }
        int i4 = zzmmVar.f35215d;
        zzwg zzwgVar = zzllVar.f35109a;
        zzir zzirVar = this.n;
        if (i4 == 0 || i4 == 2 || i4 == 4) {
            zzmmVar.f35216e = true;
            zzmi zzmiVar = zzmmVar.f35212a;
            zzmiVar.l(zzmlVar, zzvVarArr, zzxwVar, z4, z2, j2, j3, zzwgVar);
            zzirVar.a(zzmiVar);
        } else {
            zzmmVar.f35217f = true;
            zzmi zzmiVar2 = zzmmVar.f35214c;
            zzmiVar2.getClass();
            zzmiVar2.l(zzmlVar, zzvVarArr, zzxwVar, z4, z2, j2, j3, zzwgVar);
            zzirVar.a(zzmiVar2);
        }
        zzkq zzkqVar = new zzkq(this);
        zzmi zzmiVarM = zzmmVar.m(zzlkVar);
        zzmiVarM.getClass();
        zzmiVarM.u(11, zzkqVar);
        if (z3 && z2) {
            zzmmVar.B();
        }
    }

    public final void R(boolean z) {
        zzlk zzlkVar = this.r.f35130k;
        zzwg zzwgVar = zzlkVar == null ? this.F.f35180b : zzlkVar.f35102g.f35109a;
        boolean zEquals = this.F.f35189k.equals(zzwgVar);
        if (!zEquals) {
            this.F = this.F.g(zzwgVar);
        }
        zzma zzmaVar = this.F;
        zzmaVar.p = zzlkVar == null ? zzmaVar.r : zzlkVar.d();
        zzma zzmaVar2 = this.F;
        zzmaVar2.q = S(zzmaVar2.p);
        if ((!zEquals || z) && zzlkVar != null && zzlkVar.f35100e) {
            T(zzlkVar.f35102g.f35109a, zzlkVar.n, zzlkVar.o);
        }
    }

    public final long S(long j2) {
        zzlk zzlkVar = this.r.f35130k;
        if (zzlkVar == null) {
            return 0L;
        }
        return Math.max(0L, j2 - (this.B0 - zzlkVar.p));
    }

    public final void T(zzwg zzwgVar, zzyh zzyhVar, zzaae zzaaeVar) {
        long j2;
        long j3;
        zzln zzlnVar = this.r;
        zzlk zzlkVar = zzlnVar.f35130k;
        zzlkVar.getClass();
        if (zzlkVar == zzlnVar.f35127h) {
            j2 = this.B0;
            j3 = zzlkVar.p;
        } else {
            j2 = this.B0 - zzlkVar.p;
            j3 = zzlkVar.f35102g.f35110b;
        }
        long j4 = j2 - j3;
        long jS = S(zzlkVar.d());
        long j5 = p(this.F.f35179a, zzlkVar.f35102g.f35109a) ? this.L0.f34935h : -9223372036854775807L;
        zzbf zzbfVar = this.F.f35179a;
        float f2 = this.n.zzj().f24412a;
        boolean z = this.F.f35190l;
        this.f35073f.e(new zzlf(this.u, zzbfVar, zzwgVar, j4, jS, f2, this.K, j5), zzaaeVar.f22580c);
    }

    public final boolean U() {
        zzma zzmaVar = this.F;
        return zzmaVar.f35190l && zzmaVar.n == 0;
    }

    public final void V(int i2) {
        zzmm zzmmVar = this.f35068a[i2];
        try {
            zzlk zzlkVar = this.r.f35127h;
            if (zzlkVar == null) {
                throw null;
            }
            zzmi zzmiVarM = zzmmVar.m(zzlkVar);
            zzmiVarM.getClass();
            zzmiVarM.zzn();
        } catch (IOException | RuntimeException e2) {
            zzmmVar.f35212a.getClass();
            throw e2;
        }
    }

    public final boolean W() {
        if (!this.x) {
            return false;
        }
        for (int i2 = 0; i2 < 2; i2++) {
            if (this.f35068a[i2].p()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final void a(long j2, long j3, zzv zzvVar, MediaFormat mediaFormat) {
        if (this.C) {
            ((zzfd) this.f35075h.l(37)).a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmc
    public final void b(zzme zzmeVar) {
        if (!this.H && this.f35077j.getThread().isAlive()) {
            ((zzfd) this.f35075h.g(14, zzmeVar)).a();
        } else {
            zzee.c("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            zzmeVar.a(false);
        }
    }

    public final void c(IOException iOException, int i2) {
        zzit zzitVar = new zzit(0, iOException, i2);
        zzlk zzlkVar = this.r.f35127h;
        if (zzlkVar != null) {
            zzitVar = zzitVar.a(zzlkVar.f35102g.f35109a);
        }
        zzee.f("ExoPlayerImplInternal", "Playback error", zzitVar);
        v(false, false);
        this.F = this.F.e(zzitVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwd
    public final void d(zzwe zzweVar) {
        ((zzfd) this.f35075h.g(8, zzweVar)).a();
    }

    @Override // com.google.android.gms.internal.ads.zzxx
    public final /* bridge */ /* synthetic */ void e(zzxy zzxyVar) {
        ((zzfd) this.f35075h.g(9, (zzwe) zzxyVar)).a();
    }

    public final void f(int i2) {
        zzma zzmaVar = this.F;
        if (zzmaVar.f35183e != i2) {
            if (i2 != 2) {
                this.G0 = -9223372036854775807L;
            }
            this.F = zzmaVar.d(i2);
        }
    }

    public final void g() {
        zzkz zzkzVar = this.G;
        zzma zzmaVar = this.F;
        boolean z = zzkzVar.f35059a | (zzkzVar.f35060b != zzmaVar);
        zzkzVar.f35059a = z;
        zzkzVar.f35060b = zzmaVar;
        if (z) {
            this.q.a(zzkzVar);
            this.G = new zzkz(this.F);
        }
    }

    public final void h(float f2) {
        this.K0 = f2;
        float f3 = f2 * this.y.f25929g;
        for (int i2 = 0; i2 < 2; i2++) {
            zzmm zzmmVar = this.f35068a[i2];
            zzmi zzmiVar = zzmmVar.f35212a;
            if (zzmiVar.zza() == 1) {
                Float fValueOf = Float.valueOf(f3);
                zzmiVar.u(2, fValueOf);
                zzmi zzmiVar2 = zzmmVar.f35214c;
                if (zzmiVar2 != null) {
                    zzmiVar2.u(2, fValueOf);
                }
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:431:0x082c
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:195)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:62)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.processFallThroughCases(SwitchRegionMaker.java:105)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:317:0x063f  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x075e A[Catch: IOException -> 0x002b, zzvg -> 0x002e, zzhc -> 0x0031, zzat -> 0x0034, zztc -> 0x0037, RuntimeException -> 0x0514, zzit -> 0x0517, LOOP:20: B:372:0x075c->B:373:0x075e, LOOP_END, TryCatch #1 {RuntimeException -> 0x0514, blocks: (B:248:0x0505, B:258:0x052c, B:260:0x0532, B:261:0x0537, B:265:0x0542, B:267:0x0546, B:269:0x0555, B:271:0x0559, B:273:0x055d, B:275:0x0561, B:277:0x0567, B:279:0x056d, B:281:0x0573, B:283:0x0579, B:285:0x0581, B:287:0x05a3, B:289:0x05ad, B:290:0x05b3, B:292:0x05b7, B:294:0x05bd, B:296:0x05c5, B:298:0x05cd, B:300:0x05ea, B:301:0x05ef, B:303:0x05fc, B:305:0x060a, B:310:0x0629, B:405:0x07bb, B:407:0x07c1, B:409:0x07c7, B:412:0x07cc, B:413:0x07d7, B:415:0x07db, B:419:0x0800, B:421:0x0806, B:426:0x0814, B:427:0x081c, B:428:0x081f, B:430:0x0828, B:477:0x08f9, B:478:0x08fe, B:483:0x090b, B:486:0x0915, B:489:0x091b, B:497:0x094d, B:433:0x0831, B:435:0x0835, B:437:0x083b, B:439:0x0841, B:441:0x084b, B:444:0x0851, B:445:0x0854, B:447:0x085d, B:449:0x086f, B:451:0x0878, B:453:0x0880, B:458:0x088c, B:460:0x08b9, B:462:0x08bf, B:464:0x08c4, B:465:0x08cc, B:467:0x08d2, B:468:0x08d5, B:469:0x08de, B:471:0x08e2, B:473:0x08e8, B:474:0x08ed, B:476:0x08f8, B:313:0x0635, B:323:0x0652, B:328:0x0663, B:332:0x0675, B:337:0x068b, B:342:0x06e0, B:344:0x06e7, B:346:0x06eb, B:350:0x06fb, B:352:0x06ff, B:356:0x0706, B:358:0x070c, B:360:0x072b, B:363:0x0734, B:365:0x0739, B:367:0x073f, B:368:0x0747, B:370:0x074d, B:348:0x06f1, B:373:0x075e, B:389:0x0791, B:391:0x0797, B:393:0x079b, B:395:0x07a0, B:404:0x07b8, B:401:0x07af, B:403:0x07b5, B:268:0x0552, B:255:0x0519, B:257:0x051f), top: B:741:0x04d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:415:0x07db A[Catch: IOException -> 0x002b, zzvg -> 0x002e, zzhc -> 0x0031, zzat -> 0x0034, zztc -> 0x0037, RuntimeException -> 0x0514, zzit -> 0x0517, LOOP:11: B:413:0x07d7->B:415:0x07db, LOOP_END, TryCatch #1 {RuntimeException -> 0x0514, blocks: (B:248:0x0505, B:258:0x052c, B:260:0x0532, B:261:0x0537, B:265:0x0542, B:267:0x0546, B:269:0x0555, B:271:0x0559, B:273:0x055d, B:275:0x0561, B:277:0x0567, B:279:0x056d, B:281:0x0573, B:283:0x0579, B:285:0x0581, B:287:0x05a3, B:289:0x05ad, B:290:0x05b3, B:292:0x05b7, B:294:0x05bd, B:296:0x05c5, B:298:0x05cd, B:300:0x05ea, B:301:0x05ef, B:303:0x05fc, B:305:0x060a, B:310:0x0629, B:405:0x07bb, B:407:0x07c1, B:409:0x07c7, B:412:0x07cc, B:413:0x07d7, B:415:0x07db, B:419:0x0800, B:421:0x0806, B:426:0x0814, B:427:0x081c, B:428:0x081f, B:430:0x0828, B:477:0x08f9, B:478:0x08fe, B:483:0x090b, B:486:0x0915, B:489:0x091b, B:497:0x094d, B:433:0x0831, B:435:0x0835, B:437:0x083b, B:439:0x0841, B:441:0x084b, B:444:0x0851, B:445:0x0854, B:447:0x085d, B:449:0x086f, B:451:0x0878, B:453:0x0880, B:458:0x088c, B:460:0x08b9, B:462:0x08bf, B:464:0x08c4, B:465:0x08cc, B:467:0x08d2, B:468:0x08d5, B:469:0x08de, B:471:0x08e2, B:473:0x08e8, B:474:0x08ed, B:476:0x08f8, B:313:0x0635, B:323:0x0652, B:328:0x0663, B:332:0x0675, B:337:0x068b, B:342:0x06e0, B:344:0x06e7, B:346:0x06eb, B:350:0x06fb, B:352:0x06ff, B:356:0x0706, B:358:0x070c, B:360:0x072b, B:363:0x0734, B:365:0x0739, B:367:0x073f, B:368:0x0747, B:370:0x074d, B:348:0x06f1, B:373:0x075e, B:389:0x0791, B:391:0x0797, B:393:0x079b, B:395:0x07a0, B:404:0x07b8, B:401:0x07af, B:403:0x07b5, B:268:0x0552, B:255:0x0519, B:257:0x051f), top: B:741:0x04d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:464:0x08c4 A[Catch: IOException -> 0x002b, zzvg -> 0x002e, zzhc -> 0x0031, zzat -> 0x0034, zztc -> 0x0037, RuntimeException -> 0x0514, zzit -> 0x0517, LOOP:14: B:463:0x08c2->B:464:0x08c4, LOOP_END, TryCatch #1 {RuntimeException -> 0x0514, blocks: (B:248:0x0505, B:258:0x052c, B:260:0x0532, B:261:0x0537, B:265:0x0542, B:267:0x0546, B:269:0x0555, B:271:0x0559, B:273:0x055d, B:275:0x0561, B:277:0x0567, B:279:0x056d, B:281:0x0573, B:283:0x0579, B:285:0x0581, B:287:0x05a3, B:289:0x05ad, B:290:0x05b3, B:292:0x05b7, B:294:0x05bd, B:296:0x05c5, B:298:0x05cd, B:300:0x05ea, B:301:0x05ef, B:303:0x05fc, B:305:0x060a, B:310:0x0629, B:405:0x07bb, B:407:0x07c1, B:409:0x07c7, B:412:0x07cc, B:413:0x07d7, B:415:0x07db, B:419:0x0800, B:421:0x0806, B:426:0x0814, B:427:0x081c, B:428:0x081f, B:430:0x0828, B:477:0x08f9, B:478:0x08fe, B:483:0x090b, B:486:0x0915, B:489:0x091b, B:497:0x094d, B:433:0x0831, B:435:0x0835, B:437:0x083b, B:439:0x0841, B:441:0x084b, B:444:0x0851, B:445:0x0854, B:447:0x085d, B:449:0x086f, B:451:0x0878, B:453:0x0880, B:458:0x088c, B:460:0x08b9, B:462:0x08bf, B:464:0x08c4, B:465:0x08cc, B:467:0x08d2, B:468:0x08d5, B:469:0x08de, B:471:0x08e2, B:473:0x08e8, B:474:0x08ed, B:476:0x08f8, B:313:0x0635, B:323:0x0652, B:328:0x0663, B:332:0x0675, B:337:0x068b, B:342:0x06e0, B:344:0x06e7, B:346:0x06eb, B:350:0x06fb, B:352:0x06ff, B:356:0x0706, B:358:0x070c, B:360:0x072b, B:363:0x0734, B:365:0x0739, B:367:0x073f, B:368:0x0747, B:370:0x074d, B:348:0x06f1, B:373:0x075e, B:389:0x0791, B:391:0x0797, B:393:0x079b, B:395:0x07a0, B:404:0x07b8, B:401:0x07af, B:403:0x07b5, B:268:0x0552, B:255:0x0519, B:257:0x051f), top: B:741:0x04d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:467:0x08d2 A[Catch: IOException -> 0x002b, zzvg -> 0x002e, zzhc -> 0x0031, zzat -> 0x0034, zztc -> 0x0037, RuntimeException -> 0x0514, zzit -> 0x0517, TryCatch #1 {RuntimeException -> 0x0514, blocks: (B:248:0x0505, B:258:0x052c, B:260:0x0532, B:261:0x0537, B:265:0x0542, B:267:0x0546, B:269:0x0555, B:271:0x0559, B:273:0x055d, B:275:0x0561, B:277:0x0567, B:279:0x056d, B:281:0x0573, B:283:0x0579, B:285:0x0581, B:287:0x05a3, B:289:0x05ad, B:290:0x05b3, B:292:0x05b7, B:294:0x05bd, B:296:0x05c5, B:298:0x05cd, B:300:0x05ea, B:301:0x05ef, B:303:0x05fc, B:305:0x060a, B:310:0x0629, B:405:0x07bb, B:407:0x07c1, B:409:0x07c7, B:412:0x07cc, B:413:0x07d7, B:415:0x07db, B:419:0x0800, B:421:0x0806, B:426:0x0814, B:427:0x081c, B:428:0x081f, B:430:0x0828, B:477:0x08f9, B:478:0x08fe, B:483:0x090b, B:486:0x0915, B:489:0x091b, B:497:0x094d, B:433:0x0831, B:435:0x0835, B:437:0x083b, B:439:0x0841, B:441:0x084b, B:444:0x0851, B:445:0x0854, B:447:0x085d, B:449:0x086f, B:451:0x0878, B:453:0x0880, B:458:0x088c, B:460:0x08b9, B:462:0x08bf, B:464:0x08c4, B:465:0x08cc, B:467:0x08d2, B:468:0x08d5, B:469:0x08de, B:471:0x08e2, B:473:0x08e8, B:474:0x08ed, B:476:0x08f8, B:313:0x0635, B:323:0x0652, B:328:0x0663, B:332:0x0675, B:337:0x068b, B:342:0x06e0, B:344:0x06e7, B:346:0x06eb, B:350:0x06fb, B:352:0x06ff, B:356:0x0706, B:358:0x070c, B:360:0x072b, B:363:0x0734, B:365:0x0739, B:367:0x073f, B:368:0x0747, B:370:0x074d, B:348:0x06f1, B:373:0x075e, B:389:0x0791, B:391:0x0797, B:393:0x079b, B:395:0x07a0, B:404:0x07b8, B:401:0x07af, B:403:0x07b5, B:268:0x0552, B:255:0x0519, B:257:0x051f), top: B:741:0x04d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:471:0x08e2 A[Catch: IOException -> 0x002b, zzvg -> 0x002e, zzhc -> 0x0031, zzat -> 0x0034, zztc -> 0x0037, RuntimeException -> 0x0514, zzit -> 0x0517, TryCatch #1 {RuntimeException -> 0x0514, blocks: (B:248:0x0505, B:258:0x052c, B:260:0x0532, B:261:0x0537, B:265:0x0542, B:267:0x0546, B:269:0x0555, B:271:0x0559, B:273:0x055d, B:275:0x0561, B:277:0x0567, B:279:0x056d, B:281:0x0573, B:283:0x0579, B:285:0x0581, B:287:0x05a3, B:289:0x05ad, B:290:0x05b3, B:292:0x05b7, B:294:0x05bd, B:296:0x05c5, B:298:0x05cd, B:300:0x05ea, B:301:0x05ef, B:303:0x05fc, B:305:0x060a, B:310:0x0629, B:405:0x07bb, B:407:0x07c1, B:409:0x07c7, B:412:0x07cc, B:413:0x07d7, B:415:0x07db, B:419:0x0800, B:421:0x0806, B:426:0x0814, B:427:0x081c, B:428:0x081f, B:430:0x0828, B:477:0x08f9, B:478:0x08fe, B:483:0x090b, B:486:0x0915, B:489:0x091b, B:497:0x094d, B:433:0x0831, B:435:0x0835, B:437:0x083b, B:439:0x0841, B:441:0x084b, B:444:0x0851, B:445:0x0854, B:447:0x085d, B:449:0x086f, B:451:0x0878, B:453:0x0880, B:458:0x088c, B:460:0x08b9, B:462:0x08bf, B:464:0x08c4, B:465:0x08cc, B:467:0x08d2, B:468:0x08d5, B:469:0x08de, B:471:0x08e2, B:473:0x08e8, B:474:0x08ed, B:476:0x08f8, B:313:0x0635, B:323:0x0652, B:328:0x0663, B:332:0x0675, B:337:0x068b, B:342:0x06e0, B:344:0x06e7, B:346:0x06eb, B:350:0x06fb, B:352:0x06ff, B:356:0x0706, B:358:0x070c, B:360:0x072b, B:363:0x0734, B:365:0x0739, B:367:0x073f, B:368:0x0747, B:370:0x074d, B:348:0x06f1, B:373:0x075e, B:389:0x0791, B:391:0x0797, B:393:0x079b, B:395:0x07a0, B:404:0x07b8, B:401:0x07af, B:403:0x07b5, B:268:0x0552, B:255:0x0519, B:257:0x051f), top: B:741:0x04d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:789:0x07fb A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v116, types: [com.google.android.gms.internal.ads.zzwe, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v123, types: [com.google.android.gms.internal.ads.zzwe, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v37, types: [com.google.android.gms.internal.ads.zzwe, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v104, types: [com.google.android.gms.internal.ads.zzwe, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v48, types: [com.google.android.gms.internal.ads.zzwe, java.lang.Object] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean handleMessage(android.os.Message r36) {
        /*
            Method dump skipped, instructions count: 3458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlc.handleMessage(android.os.Message):boolean");
    }

    public final void i(int i2, int i3, int i4, boolean z) {
        boolean z2;
        if (!z) {
            z2 = false;
        } else if (i2 != -1) {
            z2 = true;
        } else {
            i2 = -1;
            z2 = false;
        }
        if (i2 == -1) {
            i4 = 2;
        } else if (i4 == 2) {
            i4 = 1;
        }
        boolean z3 = this.B;
        if (i2 == 0) {
            i3 = 1;
        } else if (i3 == 1) {
            i3 = z3 ? 4 : 0;
        }
        zzma zzmaVar = this.F;
        if (zzmaVar.f35190l == z2 && zzmaVar.n == i3 && zzmaVar.f35191m == i4) {
            return;
        }
        this.F = zzmaVar.h(i4, i3, z2);
        z(false, false);
        zzln zzlnVar = this.r;
        for (zzlk zzlkVar = zzlnVar.f35127h; zzlkVar != null; zzlkVar = zzlkVar.f35108m) {
            for (zzzw zzzwVar : zzlkVar.o.f22580c) {
            }
        }
        if (!U()) {
            l();
            m();
            this.F.getClass();
            zzlnVar.n(this.B0);
            return;
        }
        int i5 = this.F.f35183e;
        zzdx zzdxVar = this.f35075h;
        if (i5 != 3) {
            if (i5 == 2) {
                zzdxVar.zzh(2);
                return;
            }
            return;
        }
        zzir zzirVar = this.n;
        zzirVar.f34965f = true;
        zzmt zzmtVar = zzirVar.f34960a;
        if (!zzmtVar.f35228a) {
            zzmtVar.f35230c = SystemClock.elapsedRealtime();
            zzmtVar.f35228a = true;
        }
        k();
        zzdxVar.zzh(2);
    }

    public final void j(boolean z) {
        zzwg zzwgVar = this.r.f35127h.f35102g.f35109a;
        long jS = s(zzwgVar, this.F.r, true, false);
        if (jS != this.F.r) {
            zzma zzmaVar = this.F;
            this.F = O(zzwgVar, jS, zzmaVar.f35181c, zzmaVar.f35182d, z, 5);
        }
    }

    public final void k() {
        zzlk zzlkVar = this.r.f35127h;
        if (zzlkVar == null) {
            return;
        }
        zzaae zzaaeVar = zzlkVar.o;
        for (int i2 = 0; i2 < 2; i2++) {
            if (zzaaeVar.a(i2)) {
                this.f35068a[i2].B();
            }
        }
    }

    public final void l() {
        zzir zzirVar = this.n;
        zzirVar.f34965f = false;
        zzmt zzmtVar = zzirVar.f34960a;
        if (zzmtVar.f35228a) {
            zzmtVar.a(zzmtVar.zzg());
            zzmtVar.f35228a = false;
        }
        for (int i2 = 0; i2 < 2; i2++) {
            zzmm zzmmVar = this.f35068a[i2];
            zzmi zzmiVar = zzmmVar.f35212a;
            if (zzmm.l(zzmiVar) && zzmiVar.zze() == 2) {
                zzmiVar.zzq();
            }
            zzmi zzmiVar2 = zzmmVar.f35214c;
            if (zzmiVar2 != null && zzmiVar2.zze() != 0 && zzmiVar2.zze() == 2) {
                zzmiVar2.zzq();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:131:0x015f, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ea  */
    /* JADX WARN: Type inference failed for: r18v10 */
    /* JADX WARN: Type inference failed for: r18v11 */
    /* JADX WARN: Type inference failed for: r18v12 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r2v28, types: [com.google.android.gms.internal.ads.zzwe, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m() {
        /*
            Method dump skipped, instructions count: 825
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlc.m():void");
    }

    public final void n(final int i2, final boolean z) {
        boolean[] zArr = this.f35070c;
        if (zArr[i2] != z) {
            zArr[i2] = z;
            this.w.e(new Runnable(i2, z) { // from class: com.google.android.gms.internal.ads.zzks

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ int f35051b;

                @Override // java.lang.Runnable
                public final void run() {
                    zzlc zzlcVar = this.f35050a;
                    zzlcVar.f35068a[this.f35051b].f35212a.getClass();
                    zzoz zzozVar = zzlcVar.v;
                    zzozVar.k(zzozVar.o(), 1033, new zznu());
                }
            });
        }
    }

    public final long o(zzbf zzbfVar, Object obj, long j2) {
        int i2 = zzbfVar.o(obj, this.f35079l).f24739c;
        zzbe zzbeVar = this.f35078k;
        zzbfVar.b(i2, zzbeVar, 0L);
        if (zzbeVar.f24826d == -9223372036854775807L || !zzbeVar.b() || !zzbeVar.f24829g) {
            return -9223372036854775807L;
        }
        long j3 = zzbeVar.f24827e;
        String str = zzfj.f31254a;
        return zzfj.s((j3 == -9223372036854775807L ? System.currentTimeMillis() : j3 + SystemClock.elapsedRealtime()) - zzbeVar.f24826d) - j2;
    }

    public final boolean p(zzbf zzbfVar, zzwg zzwgVar) {
        if (zzwgVar.b() || zzbfVar.g()) {
            return false;
        }
        int i2 = zzbfVar.o(zzwgVar.f35758a, this.f35079l).f24739c;
        zzbe zzbeVar = this.f35078k;
        zzbfVar.b(i2, zzbeVar, 0L);
        return zzbeVar.b() && zzbeVar.f24829g && zzbeVar.f24826d != -9223372036854775807L;
    }

    public final void q(long j2) {
        boolean z;
        if (this.B) {
            this.A.getClass();
            z = true;
        } else {
            z = false;
        }
        long j3 = M0;
        if (z) {
            jMin = this.F.f35183e != 3 ? j3 : 1000L;
            for (int i2 = 0; i2 < 2; i2++) {
                zzmm zzmmVar = this.f35068a[i2];
                long j4 = this.B0;
                long j5 = this.C0;
                zzmi zzmiVar = zzmmVar.f35212a;
                long jI = zzmm.l(zzmiVar) ? zzmiVar.i(j4, j5) : Long.MAX_VALUE;
                zzmi zzmiVar2 = zzmmVar.f35214c;
                if (zzmiVar2 != null && zzmiVar2.zze() != 0) {
                    jI = Math.min(jI, zzmiVar2.i(j4, j5));
                }
                jMin = Math.min(jMin, zzfj.r(jI));
            }
            if (this.F.i()) {
                zzlk zzlkVar = this.r.f35127h;
                if ((zzlkVar != null ? zzlkVar.f35108m : null) != null) {
                    if (this.B0 + (zzfj.s(jMin) * this.F.o.f24412a) >= r0.a()) {
                        jMin = Math.min(jMin, j3);
                    }
                }
            }
        } else if (this.F.f35183e != 3 || U()) {
            jMin = j3;
        }
        this.f35075h.a(j2 + jMin);
    }

    /* JADX WARN: Type inference failed for: r0v27, types: [com.google.android.gms.internal.ads.zzwe, java.lang.Object] */
    public final void r(zzlb zzlbVar, boolean z) throws Throwable {
        long jLongValue;
        long j2;
        long j3;
        zzwg zzwgVarE;
        boolean z2;
        int i2;
        long j4;
        boolean z3;
        long j5;
        long jI;
        long j6;
        boolean z4;
        long j7;
        long j8;
        boolean z5;
        zzma zzmaVar;
        int i3;
        this.G.a(z ? 1 : 0);
        if (this.C) {
            if (this.D != null) {
                this.E++;
            }
            this.D = zzlbVar;
            return;
        }
        zzbf zzbfVar = this.F.f35179a;
        int i4 = this.Q;
        boolean z6 = this.X;
        zzbe zzbeVar = this.f35078k;
        zzbd zzbdVar = this.f35079l;
        Pair pairA = A(zzbfVar, zzlbVar, i4, z6, zzbeVar, zzbdVar);
        if (pairA == null) {
            Pair pairX = x(this.F.f35179a);
            zzwg zzwgVar = (zzwg) pairX.first;
            jLongValue = ((Long) pairX.second).longValue();
            z2 = !this.F.f35179a.g();
            zzwgVarE = zzwgVar;
            j2 = -9223372036854775807L;
            j3 = 0;
        } else {
            Object obj = pairA.first;
            jLongValue = ((Long) pairA.second).longValue();
            long j9 = zzlbVar.f35067c;
            j2 = j9 == -9223372036854775807L ? -9223372036854775807L : jLongValue;
            j3 = 0;
            zzwgVarE = this.r.E(this.F.f35179a, obj);
            if (zzwgVarE.b()) {
                this.F.f35179a.o(zzwgVarE.f35758a, zzbdVar);
                zza zzaVarA = zzbdVar.f24742f.a(-1);
                int i5 = 0;
                while (true) {
                    int[] iArr = zzaVarA.f22572d;
                    if (i5 >= iArr.length || (i2 = iArr[i5]) == 0 || i2 == 1) {
                        break;
                    } else {
                        i5++;
                    }
                }
                if (i5 == -1) {
                    zzbdVar.f24742f.getClass();
                }
                z2 = true;
                jLongValue = 0;
            } else {
                z2 = j9 == -9223372036854775807L;
            }
        }
        try {
            if (this.F.f35179a.g()) {
                this.A0 = zzlbVar;
            } else if (pairA == null) {
                if (this.F.f35183e != 1) {
                    f(4);
                }
                w(false, true, false, true);
            } else {
                if (zzwgVarE.equals(this.F.f35180b)) {
                    zzlk zzlkVar = this.r.f35127h;
                    if (zzlkVar == null || !zzlkVar.f35100e || jLongValue == j3) {
                        jI = jLongValue;
                    } else {
                        ?? r0 = zzlkVar.f35096a;
                        long j10 = zzbeVar.f24832j;
                        if (this.B && j10 != -9223372036854775807L) {
                            this.A.getClass();
                        }
                        jI = r0.i(jLongValue, this.z);
                    }
                    if (zzfj.r(jI) == zzfj.r(this.F.r) && ((i3 = (zzmaVar = this.F).f35183e) == 2 || i3 == 3)) {
                        jLongValue = zzmaVar.r;
                    }
                } else {
                    jI = jLongValue;
                }
                if (this.B) {
                    zzmm[] zzmmVarArr = this.f35068a;
                    int i6 = 0;
                    while (true) {
                        if (i6 >= 2) {
                            break;
                        }
                        zzmm zzmmVar = zzmmVarArr[i6];
                        if (zzmmVar.g() && zzmmVar.f35212a.zza() == 2) {
                            this.C = true;
                            break;
                        }
                        i6++;
                    }
                }
                if (this.F.f35183e == 4) {
                    j6 = jI;
                    z4 = true;
                } else {
                    j6 = jI;
                    z4 = false;
                }
                zzln zzlnVar = this.r;
                long jS = s(zzwgVarE, j6, zzlnVar.f35127h != zzlnVar.f35128i, z4);
                boolean z7 = z2 | (jLongValue != jS);
                try {
                    zzma zzmaVar2 = this.F;
                    zzwg zzwgVar2 = zzwgVarE;
                    try {
                        zzbf zzbfVar2 = zzmaVar2.f35179a;
                        long j11 = j2;
                        try {
                            H(zzbfVar2, zzwgVar2, zzbfVar2, zzmaVar2.f35180b, j11, true);
                            zzwgVarE = zzwgVar2;
                            j7 = j11;
                            j8 = jS;
                            z5 = z7;
                            this.F = O(zzwgVarE, j8, j7, j8, z5, 2);
                        } catch (Throwable th) {
                            th = th;
                            zzwgVarE = zzwgVar2;
                            j4 = j11;
                            j5 = jS;
                            z3 = z7;
                            this.F = O(zzwgVarE, j5, j4, j5, z3, 2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        zzwgVarE = zzwgVar2;
                        j4 = j2;
                        j5 = jS;
                        z3 = z7;
                        this.F = O(zzwgVarE, j5, j4, j5, z3, 2);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            z5 = z2;
            j8 = jLongValue;
            j7 = j2;
            this.F = O(zzwgVarE, j8, j7, j8, z5, 2);
        } catch (Throwable th4) {
            th = th4;
            j4 = j2;
            z3 = z2;
            j5 = jLongValue;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00d4  */
    /* JADX WARN: Type inference failed for: r10v16, types: [com.google.android.gms.internal.ads.zzwe, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v7, types: [com.google.android.gms.internal.ads.zzwe, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long s(com.google.android.gms.internal.ads.zzwg r10, long r11, boolean r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlc.s(com.google.android.gms.internal.ads.zzwg, long, boolean, boolean):long");
    }

    public final void t(long j2, boolean z) {
        zzlk zzlkVar = this.r.f35127h;
        long j3 = j2 + (zzlkVar == null ? 1000000000000L : zzlkVar.p);
        this.B0 = j3;
        this.n.f34960a.a(j3);
        for (int i2 = 0; i2 < 2; i2++) {
            zzmm zzmmVar = this.f35068a[i2];
            long j4 = this.B0;
            zzmi zzmiVarM = zzmmVar.m(zzlkVar);
            if (zzmiVarM != null) {
                zzmiVarM.h(j4, z);
            }
        }
        for (zzlk zzlkVar2 = r0.f35127h; zzlkVar2 != null; zzlkVar2 = zzlkVar2.f35108m) {
            for (zzzw zzzwVar : zzlkVar2.o.f22580c) {
            }
        }
    }

    public final void u() {
        for (int i2 = 0; i2 < 2; i2++) {
            zzmm zzmmVar = this.f35068a[i2];
            zzmp zzmpVar = this.B ? this.A : null;
            zzmmVar.f35212a.u(18, zzmpVar);
            zzmi zzmiVar = zzmmVar.f35214c;
            if (zzmiVar != null) {
                zzmiVar.u(18, zzmpVar);
            }
        }
    }

    public final void v(boolean z, boolean z2) {
        w(z || !this.Y, false, true, false);
        this.G.a(z2 ? 1 : 0);
        this.f35073f.a(this.u);
        this.y.b(1, this.F.f35190l);
        f(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b0 A[PHI: r2 r7 r9
      0x00b0: PHI (r2v2 com.google.android.gms.internal.ads.zzwg) = (r2v1 com.google.android.gms.internal.ads.zzwg), (r2v8 com.google.android.gms.internal.ads.zzwg) binds: [B:30:0x0085, B:32:0x00aa] A[DONT_GENERATE, DONT_INLINE]
      0x00b0: PHI (r7v4 long) = (r7v3 long), (r7v17 long) binds: [B:30:0x0085, B:32:0x00aa] A[DONT_GENERATE, DONT_INLINE]
      0x00b0: PHI (r9v2 long) = (r9v1 long), (r9v9 long) binds: [B:30:0x0085, B:32:0x00aa] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(boolean r34, boolean r35, boolean r36, boolean r37) {
        /*
            Method dump skipped, instructions count: 421
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlc.w(boolean, boolean, boolean, boolean):void");
    }

    public final Pair x(zzbf zzbfVar) {
        int i2;
        long j2 = 0;
        if (zzbfVar.g()) {
            return Pair.create(zzma.t, 0L);
        }
        int iK = zzbfVar.k(this.X);
        zzbe zzbeVar = this.f35078k;
        zzbd zzbdVar = this.f35079l;
        Pair pairM = zzbfVar.m(zzbeVar, zzbdVar, iK, -9223372036854775807L);
        zzwg zzwgVarE = this.r.E(zzbfVar, pairM.first);
        long jLongValue = ((Long) pairM.second).longValue();
        if (zzwgVarE.b()) {
            zzbfVar.o(zzwgVarE.f35758a, zzbdVar);
            zza zzaVarA = zzbdVar.f24742f.a(-1);
            int i3 = 0;
            while (true) {
                int[] iArr = zzaVarA.f22572d;
                if (i3 >= iArr.length || (i2 = iArr[i3]) == 0 || i2 == 1) {
                    break;
                }
                i3++;
            }
            if (-1 == i3) {
                zzbdVar.f24742f.getClass();
            }
        } else {
            j2 = jLongValue;
        }
        return Pair.create(zzwgVarE, Long.valueOf(j2));
    }

    public final void y(zzbf zzbfVar, zzbf zzbfVar2) {
        if (zzbfVar.g() && zzbfVar2.g()) {
            return;
        }
        ArrayList arrayList = this.o;
        int size = arrayList.size() - 1;
        if (size < 0) {
            Collections.sort(arrayList);
        } else {
            ((zzky) arrayList.get(size)).getClass();
            String str = zzfj.f31254a;
            throw null;
        }
    }

    public final void z(boolean z, boolean z2) {
        this.K = z;
        long jElapsedRealtime = -9223372036854775807L;
        if (z && !z2) {
            jElapsedRealtime = SystemClock.elapsedRealtime();
        }
        this.L = jElapsedRealtime;
    }
}
