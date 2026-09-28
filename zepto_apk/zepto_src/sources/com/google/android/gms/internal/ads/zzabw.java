package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Trace;
import android.util.SparseArray;
import android.view.Surface;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import org.xbill.DNS.SimpleResolver;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
public final class zzabw extends zzuq implements zzacl {
    public static final int[] V1 = {1920, 1600, 1440, SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE, 960, 854, 640, 540, 480};
    public static boolean W1;
    public static boolean X1;
    public zzes A1;
    public boolean B1;
    public int C1;
    public int D1;
    public long E1;
    public int F1;
    public int G1;
    public int H1;
    public zzmp I1;
    public boolean J1;
    public long K1;
    public int L1;
    public long M1;
    public zzbv N1;
    public zzbv O1;
    public int P1;
    public int Q1;
    public zzacj R1;
    public long S1;
    public long T1;
    public boolean U1;
    public final Context j1;
    public final boolean k1;
    public final zzadf l1;
    public final boolean m1;
    public final zzacm n1;
    public final zzack o1;
    public final long p1;
    public final PriorityQueue q1;
    public zzabv r1;
    public boolean s1;
    public boolean t1;
    public zzadl u1;
    public boolean v1;
    public int w1;
    public List x1;
    public Surface y1;
    public zzaby z1;

    public zzabw(zzabu zzabuVar) {
        super(2, zzabuVar.f22680d, zzabuVar.f22679c, 30.0f);
        Context applicationContext = zzabuVar.f22677a.getApplicationContext();
        this.j1 = applicationContext;
        this.u1 = null;
        this.l1 = new zzadf(zzabuVar.f22681e, zzabuVar.f22682f);
        this.k1 = this.u1 == null;
        this.n1 = new zzacm(applicationContext, this);
        this.o1 = new zzack();
        this.m1 = "NVIDIA".equals(Build.MANUFACTURER);
        this.A1 = zzes.f30200c;
        this.C1 = 1;
        this.D1 = 0;
        this.N1 = zzbv.f25577d;
        this.Q1 = 0;
        this.O1 = null;
        this.P1 = -1000;
        this.S1 = -9223372036854775807L;
        this.T1 = -9223372036854775807L;
        this.q1 = new PriorityQueue();
        this.p1 = -9223372036854775807L;
        this.I1 = null;
    }

    public static int C0(zzuj zzujVar, zzv zzvVar) {
        int i2 = zzvVar.n;
        if (i2 == -1) {
            return x0(zzujVar, zzvVar);
        }
        List list = zzvVar.p;
        int size = list.size();
        int length = 0;
        for (int i3 = 0; i3 < size; i3++) {
            length += ((byte[]) list.get(i3)).length;
        }
        return i2 + length;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0080 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:507:0x0789  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean D0(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 2924
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabw.D0(java.lang.String):boolean");
    }

    public static List E0(Context context, zzus zzusVar, zzv zzvVar, boolean z, boolean z2) {
        List listA;
        String str = zzvVar.f35691m;
        if (str == null) {
            zzgvs zzgvsVar = zzgtd.f33183b;
            return zzguy.f33232e;
        }
        if (Build.VERSION.SDK_INT >= 26 && "video/dolby-vision".equals(str) && !zzabt.a(context)) {
            String strC = zzvc.c(zzvVar);
            if (strC == null) {
                zzgvs zzgvsVar2 = zzgtd.f33183b;
                listA = zzguy.f33232e;
            } else {
                ((zzur) zzusVar).getClass();
                listA = zzvc.a(strC, z, z2);
            }
            if (!listA.isEmpty()) {
                return listA;
            }
        }
        return zzvc.b(zzusVar, zzvVar, z, z2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int x0(com.google.android.gms.internal.ads.zzuj r11, com.google.android.gms.internal.ads.zzv r12) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabw.x0(com.google.android.gms.internal.ads.zzuj, com.google.android.gms.internal.ads.zzv):int");
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final void A() {
        int i2 = this.F1;
        final zzadf zzadfVar = this.l1;
        if (i2 > 0) {
            this.f34885g.getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            final long j2 = jElapsedRealtime - this.E1;
            final int i3 = this.F1;
            Handler handler = zzadfVar.f22796a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzacx
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzadf zzadfVar2 = zzadfVar;
                        zzadfVar2.getClass();
                        String str = zzfj.f31254a;
                        zzoz zzozVar = ((zzjl) zzadfVar2.f22797b).f35004a.r;
                        final zzmv zzmvVarN = zzozVar.n(zzozVar.f35271d.f35266e);
                        final int i4 = i3;
                        final long j3 = j2;
                        zzozVar.k(zzmvVarN, 1018, new zzdy(zzmvVarN, i4, j3) { // from class: com.google.android.gms.internal.ads.zznh

                            /* renamed from: a, reason: collision with root package name */
                            public final /* synthetic */ int f35246a;

                            {
                                this.f35246a = i4;
                            }

                            @Override // com.google.android.gms.internal.ads.zzdy
                            public final /* synthetic */ void zza(Object obj) {
                                ((zzmx) obj).j(this.f35246a);
                            }
                        });
                    }
                });
            }
            this.F1 = 0;
            this.E1 = jElapsedRealtime;
        }
        final int i4 = this.L1;
        if (i4 != 0) {
            final long j3 = this.K1;
            Handler handler2 = zzadfVar.f22796a;
            if (handler2 != null) {
                handler2.post(new Runnable(i4, j3, zzadfVar) { // from class: com.google.android.gms.internal.ads.zzacy

                    /* renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ zzadf f22785a;

                    {
                        this.f22785a = zzadfVar;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzadf zzadfVar2 = this.f22785a;
                        zzadfVar2.getClass();
                        String str = zzfj.f31254a;
                        zzoz zzozVar = ((zzjl) zzadfVar2.f22797b).f35004a.r;
                        zzozVar.k(zzozVar.n(zzozVar.f35271d.f35266e), 1021, new zznm());
                    }
                });
            }
            this.K1 = 0L;
            this.L1 = 0;
        }
        zzadl zzadlVar = this.u1;
        if (zzadlVar != null) {
            zzadlVar.zzb();
            return;
        }
        zzacm zzacmVar = this.n1;
        zzacmVar.f22732c = false;
        zzacmVar.f22737h = -9223372036854775807L;
        zzact zzactVar = zzacmVar.f22731b;
        zzactVar.f22756d = false;
        zzacp zzacpVar = zzactVar.f22755c;
        if (zzacpVar != null) {
            zzacpVar.b();
        }
        zzactVar.d();
    }

    public final void A0(long j2) {
        zzik zzikVar = this.b1;
        zzikVar.f34921k += j2;
        zzikVar.f34922l++;
        this.K1 += j2;
        this.L1++;
    }

    @Override // com.google.android.gms.internal.ads.zzuq, com.google.android.gms.internal.ads.zzij
    public final void B() {
        final zzadf zzadfVar = this.l1;
        this.O1 = null;
        this.T1 = -9223372036854775807L;
        this.B1 = false;
        this.J1 = true;
        try {
            super.B();
            final zzik zzikVar = this.b1;
            zzadfVar.getClass();
            synchronized (zzikVar) {
            }
            Handler handler = zzadfVar.f22796a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzadc
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzadf zzadfVar2 = zzadfVar;
                        final zzik zzikVar2 = zzikVar;
                        zzadfVar2.getClass();
                        synchronized (zzikVar2) {
                        }
                        String str = zzfj.f31254a;
                        zzoz zzozVar = ((zzjl) zzadfVar2.f22797b).f35004a.r;
                        final zzmv zzmvVarN = zzozVar.n(zzozVar.f35271d.f35266e);
                        zzozVar.k(zzmvVarN, 1020, new zzdy(zzmvVarN, zzikVar2) { // from class: com.google.android.gms.internal.ads.zznk

                            /* renamed from: a, reason: collision with root package name */
                            public final /* synthetic */ zzik f35247a;

                            {
                                this.f35247a = zzikVar2;
                            }

                            @Override // com.google.android.gms.internal.ads.zzdy
                            public final /* synthetic */ void zza(Object obj) {
                                ((zzmx) obj).d(this.f35247a);
                            }
                        });
                    }
                });
            }
            zzadfVar.a(zzbv.f25577d);
        } catch (Throwable th) {
            final zzik zzikVar2 = this.b1;
            zzadfVar.getClass();
            synchronized (zzikVar2) {
                Handler handler2 = zzadfVar.f22796a;
                if (handler2 != null) {
                    handler2.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzadc
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzadf zzadfVar2 = zzadfVar;
                            final zzik zzikVar22 = zzikVar2;
                            zzadfVar2.getClass();
                            synchronized (zzikVar22) {
                            }
                            String str = zzfj.f31254a;
                            zzoz zzozVar = ((zzjl) zzadfVar2.f22797b).f35004a.r;
                            final zzmv zzmvVarN = zzozVar.n(zzozVar.f35271d.f35266e);
                            zzozVar.k(zzmvVarN, 1020, new zzdy(zzmvVarN, zzikVar22) { // from class: com.google.android.gms.internal.ads.zznk

                                /* renamed from: a, reason: collision with root package name */
                                public final /* synthetic */ zzik f35247a;

                                {
                                    this.f35247a = zzikVar22;
                                }

                                @Override // com.google.android.gms.internal.ads.zzdy
                                public final /* synthetic */ void zza(Object obj) {
                                    ((zzmx) obj).d(this.f35247a);
                                }
                            });
                        }
                    });
                }
                zzadfVar.a(zzbv.f25577d);
                throw th;
            }
        }
    }

    public final void B0(zzug zzugVar, int i2, long j2) {
        Surface surface;
        Trace.beginSection("releaseOutputBuffer");
        zzugVar.b0(i2, j2);
        Trace.endSection();
        this.b1.f34915e++;
        this.G1 = 0;
        if (this.u1 == null) {
            zzbv zzbvVar = this.N1;
            boolean zEquals = zzbvVar.equals(zzbv.f25577d);
            zzadf zzadfVar = this.l1;
            if (!zEquals && !zzbvVar.equals(this.O1)) {
                this.O1 = zzbvVar;
                zzadfVar.a(zzbvVar);
            }
            zzacm zzacmVar = this.n1;
            int i3 = zzacmVar.f22733d;
            zzacmVar.f22733d = 3;
            zzacmVar.f22740k.getClass();
            zzacmVar.f22735f = zzfj.s(SystemClock.elapsedRealtime());
            if (i3 == 3 || (surface = this.y1) == null) {
                return;
            }
            Handler handler = zzadfVar.f22796a;
            if (handler != null) {
                handler.post(new zzada(zzadfVar, surface, SystemClock.elapsedRealtime()));
            }
            this.B1 = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuq, com.google.android.gms.internal.ads.zzij
    public final void C() {
        try {
            super.C();
        } finally {
            this.v1 = false;
            this.S1 = -9223372036854775807L;
            zzaby zzabyVar = this.z1;
            if (zzabyVar != null) {
                zzabyVar.release();
                this.z1 = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final void D() {
        zzadl zzadlVar = this.u1;
        if (zzadlVar == null || !this.k1) {
            return;
        }
        zzadlVar.y();
    }

    public final void F0(Object obj) {
        Handler handler;
        Surface surface = obj instanceof Surface ? (Surface) obj : null;
        Surface surface2 = this.y1;
        zzadf zzadfVar = this.l1;
        if (surface2 == surface) {
            if (surface != null) {
                zzbv zzbvVar = this.O1;
                if (zzbvVar != null) {
                    zzadfVar.a(zzbvVar);
                }
                Surface surface3 = this.y1;
                if (surface3 == null || !this.B1 || (handler = zzadfVar.f22796a) == null) {
                    return;
                }
                handler.post(new zzada(zzadfVar, surface3, SystemClock.elapsedRealtime()));
                return;
            }
            return;
        }
        this.y1 = surface;
        zzadl zzadlVar = this.u1;
        zzacm zzacmVar = this.n1;
        if (zzadlVar == null) {
            zzacmVar.c(surface);
        }
        this.B1 = false;
        int i2 = this.f34886h;
        zzug zzugVar = this.L;
        if (zzugVar != null && this.u1 == null) {
            zzuj zzujVar = this.B0;
            zzujVar.getClass();
            if (!H0(zzujVar) || this.s1) {
                L();
                J();
            } else {
                Surface surfaceI0 = I0(zzujVar);
                if (surfaceI0 != null) {
                    zzugVar.d0(surfaceI0);
                } else {
                    if (Build.VERSION.SDK_INT < 35) {
                        throw new IllegalStateException();
                    }
                    zzugVar.zzo();
                }
            }
        }
        if (surface != null) {
            zzbv zzbvVar2 = this.O1;
            if (zzbvVar2 != null) {
                zzadfVar.a(zzbvVar2);
            }
        } else {
            this.O1 = null;
            zzadl zzadlVar2 = this.u1;
            if (zzadlVar2 != null) {
                zzadlVar2.zzq();
            }
        }
        if (i2 == 2) {
            zzadl zzadlVar3 = this.u1;
            if (zzadlVar3 != null) {
                zzadlVar3.P(true);
            } else {
                zzacmVar.f22738i = true;
                zzacmVar.f22737h = -9223372036854775807L;
            }
        }
    }

    public final boolean G0(zzih zzihVar) {
        if (x() || zzihVar.b(536870912)) {
            return true;
        }
        long j2 = this.T1;
        return j2 == -9223372036854775807L || j2 - (zzihVar.f34831f - this.c1.f35667c) <= 100000;
    }

    @Override // com.google.android.gms.internal.ads.zzuq, com.google.android.gms.internal.ads.zzij
    public final void H(boolean z, boolean z2) {
        zzadl zzadlVar;
        super.H(z, z2);
        E();
        final zzik zzikVar = this.b1;
        final zzadf zzadfVar = this.l1;
        Handler handler = zzadfVar.f22796a;
        if (handler != null) {
            handler.post(new Runnable(zzikVar) { // from class: com.google.android.gms.internal.ads.zzade
                @Override // java.lang.Runnable
                public final void run() {
                    zzadf zzadfVar2 = this.f22795a;
                    zzadfVar2.getClass();
                    String str = zzfj.f31254a;
                    zzoz zzozVar = ((zzjl) zzadfVar2.f22797b).f35004a.r;
                    zzozVar.k(zzozVar.o(), 1015, new zzne());
                }
            });
        }
        boolean z3 = this.v1;
        zzacm zzacmVar = this.n1;
        if (!z3) {
            if (this.x1 != null && this.u1 == null) {
                zzaca zzacaVar = new zzaca(this.j1, zzacmVar);
                zzacaVar.f22699d = true;
                long j2 = this.p1;
                zzacaVar.f22702g = j2 != -9223372036854775807L ? -j2 : -9223372036854775807L;
                zzfc zzfcVar = this.f34885g;
                zzfcVar.getClass();
                zzacaVar.f22700e = zzfcVar;
                zzgqa.f(!zzacaVar.f22701f);
                if (zzacaVar.f22698c == null) {
                    zzacaVar.f22698c = new zzacg();
                }
                zzaci zzaciVar = new zzaci(zzacaVar);
                zzacaVar.f22701f = true;
                zzaciVar.p = 1;
                SparseArray sparseArray = zzaciVar.f22717c;
                if (sparseArray.indexOfKey(0) >= 0) {
                    zzadlVar = (zzadl) sparseArray.get(0);
                } else {
                    zzacc zzaccVar = new zzacc(zzaciVar, zzaciVar.f22715a);
                    zzaciVar.f22721g.add(zzaccVar);
                    sparseArray.put(0, zzaccVar);
                    zzadlVar = zzaccVar;
                }
                this.u1 = zzadlVar;
            }
            this.v1 = true;
        }
        int i2 = !z2 ? 1 : 0;
        zzadl zzadlVar2 = this.u1;
        if (zzadlVar2 == null) {
            zzfc zzfcVar2 = this.f34885g;
            zzfcVar2.getClass();
            zzacmVar.f22740k = zzfcVar2;
            zzacmVar.a(i2);
            return;
        }
        zzadlVar2.k1(new zzabr(this));
        zzacj zzacjVar = this.R1;
        if (zzacjVar != null) {
            this.u1.o1(zzacjVar);
        }
        if (this.y1 != null && !this.A1.equals(zzes.f30200c)) {
            this.u1.h1(this.y1, this.A1);
        }
        this.u1.f1(this.D1);
        this.u1.Q0(this.J);
        List list = this.x1;
        if (list != null) {
            this.u1.l1(list);
        }
        this.w1 = i2;
        this.f1 = true;
    }

    public final boolean H0(zzuj zzujVar) {
        if (this.u1 != null) {
            return true;
        }
        Surface surface = this.y1;
        if (surface != null && surface.isValid()) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 35 && zzujVar.f35652h) {
            return true;
        }
        if (D0(zzujVar.f35645a)) {
            return false;
        }
        return !zzujVar.f35650f || zzaby.a(this.j1);
    }

    @Override // com.google.android.gms.internal.ads.zzuq, com.google.android.gms.internal.ads.zzij
    public final void I(zzv[] zzvVarArr, long j2, long j3, zzwg zzwgVar) {
        super.I(zzvVarArr, j2, j3, zzwgVar);
        zzbf zzbfVar = this.p;
        if (zzbfVar.g()) {
            this.T1 = -9223372036854775807L;
        } else {
            this.T1 = zzbfVar.o(zzwgVar.f35758a, new zzbd()).f24740d;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.Surface I0(com.google.android.gms.internal.ads.zzuj r7) {
        /*
            Method dump skipped, instructions count: 197
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabw.I0(com.google.android.gms.internal.ads.zzuj):android.view.Surface");
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final boolean K(zzuj zzujVar) {
        return H0(zzujVar);
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final boolean M() {
        zzuj zzujVar = this.B0;
        if (this.u1 != null && zzujVar != null) {
            String str = zzujVar.f35645a;
            if (str.equals("c2.mtk.avc.decoder") || str.equals("c2.mtk.hevc.decoder")) {
                return true;
            }
        }
        return super.M();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0024  */
    @Override // com.google.android.gms.internal.ads.zzuq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean N() {
        /*
            r12 = this;
            com.google.android.gms.internal.ads.zzv r0 = r12.M
            long r1 = r12.T1
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r6 = 0
            r7 = 1
            if (r5 == 0) goto L24
            r8 = 1
            long r8 = r8 + r1
            com.google.android.gms.internal.ads.zzup r5 = r12.c1
            long r10 = r5.f35667c
            long r10 = r10 + r1
            long r1 = r12.h1
            long r1 = r1 + r8
            r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r8 = r8 - r10
            int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r1 <= 0) goto L26
        L24:
            r1 = r7
            goto L27
        L26:
            r1 = r6
        L27:
            com.google.android.gms.internal.ads.zzmp r2 = r12.I1
            if (r2 != 0) goto L2c
            goto L41
        L2c:
            boolean r2 = r12.J1
            if (r2 != 0) goto L41
            if (r0 == 0) goto L36
            int r0 = r0.o
            if (r0 > 0) goto L41
        L36:
            if (r1 != 0) goto L41
            com.google.android.gms.internal.ads.zzup r0 = r12.c1
            long r0 = r0.f35669e
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L41
            return r6
        L41:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabw.N():boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final void O() {
        super.O();
        this.q1.clear();
        this.H1 = 0;
        this.J1 = false;
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final zzui Q(IllegalStateException illegalStateException, zzuj zzujVar) {
        Surface surface = this.y1;
        zzabq zzabqVar = new zzabq(illegalStateException, zzujVar);
        System.identityHashCode(surface);
        if (surface != null) {
            surface.isValid();
        }
        return zzabqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final void R(zzv zzvVar) throws zzit {
        zzadl zzadlVar = this.u1;
        if (zzadlVar == null || zzadlVar.zze()) {
            return;
        }
        try {
            zzadlVar.j1(zzvVar);
        } catch (zzadk e2) {
            throw F(e2, zzvVar, false, 7000);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final void S(zzih zzihVar) {
        int iT = T(zzihVar);
        if (Build.VERSION.SDK_INT < 34 || (iT & 32) == 0) {
            this.H1++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final int T(zzih zzihVar) {
        return (Build.VERSION.SDK_INT < 34 || this.I1 == null || zzihVar.f34831f >= this.f34890l || G0(zzihVar)) ? 0 : 32;
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final boolean U(zzih zzihVar) {
        boolean z = false;
        if (!G0(zzihVar)) {
            if (zzihVar.f34831f < this.f34890l) {
                if (!zzihVar.b(268435456)) {
                    if (zzihVar.b(67108864)) {
                        zzihVar.c();
                        z = true;
                    }
                    if (z) {
                        this.b1.f34914d++;
                    }
                }
            }
            return z;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final void V(long j2) {
        super.V(j2);
        this.H1--;
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final int W(zzus zzusVar, zzv zzvVar) {
        boolean z;
        String str = zzvVar.f35691m;
        if (!zzas.b(str)) {
            return 128;
        }
        int i2 = 0;
        boolean z2 = zzvVar.q != null;
        Context context = this.j1;
        List listE0 = E0(context, zzusVar, zzvVar, z2, false);
        if (z2 && listE0.isEmpty()) {
            listE0 = E0(context, zzusVar, zzvVar, false, false);
        }
        if (listE0.isEmpty()) {
            return WKSRecord.Service.PWDGEN;
        }
        if (zzvVar.L != 0) {
            return WKSRecord.Service.CISCO_FNA;
        }
        zzuj zzujVar = (zzuj) listE0.get(0);
        boolean zB = zzujVar.b(zzvVar);
        if (zB) {
            z = true;
        } else {
            for (int i3 = 1; i3 < listE0.size(); i3++) {
                zzuj zzujVar2 = (zzuj) listE0.get(i3);
                if (zzujVar2.b(zzvVar)) {
                    zB = true;
                    z = false;
                    zzujVar = zzujVar2;
                    break;
                }
            }
            z = true;
        }
        int i4 = true != zB ? 3 : 4;
        int i5 = true != zzujVar.c(zzvVar) ? 8 : 16;
        int i6 = true != zzujVar.f35651g ? 0 : 64;
        int i7 = true != z ? 0 : 128;
        if (Build.VERSION.SDK_INT >= 26 && "video/dolby-vision".equals(str) && !zzabt.a(context)) {
            i7 = 256;
        }
        if (zB) {
            List listE02 = E0(context, zzusVar, zzvVar, z2, true);
            if (!listE02.isEmpty()) {
                HashMap map = zzvc.f35693a;
                ArrayList arrayList = new ArrayList(listE02);
                Collections.sort(arrayList, new zzuz(new zzva(zzvVar)));
                zzuj zzujVar3 = (zzuj) arrayList.get(0);
                if (zzujVar3.b(zzvVar) && zzujVar3.c(zzvVar)) {
                    i2 = 32;
                }
            }
        }
        return i4 | i5 | i2 | i6 | i7;
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final ArrayList X(zzus zzusVar, zzv zzvVar) {
        List listE0 = E0(this.j1, zzusVar, zzvVar, false, false);
        HashMap map = zzvc.f35693a;
        ArrayList arrayList = new ArrayList(listE0);
        Collections.sort(arrayList, new zzuz(new zzva(zzvVar)));
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ed, code lost:
    
        r23 = r13;
        r1 = null;
     */
    @Override // com.google.android.gms.internal.ads.zzuq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.zzud Z(com.google.android.gms.internal.ads.zzuj r25, com.google.android.gms.internal.ads.zzv r26, float r27) {
        /*
            Method dump skipped, instructions count: 610
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabw.Z(com.google.android.gms.internal.ads.zzuj, com.google.android.gms.internal.ads.zzv, float):com.google.android.gms.internal.ads.zzud");
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final zzil a0(zzuj zzujVar, zzv zzvVar, zzv zzvVar2) {
        int i2;
        int i3;
        zzil zzilVarD = zzujVar.d(zzvVar, zzvVar2);
        zzabv zzabvVar = this.r1;
        zzabvVar.getClass();
        int i4 = zzvVar2.t;
        int i5 = zzabvVar.f22683a;
        int i6 = zzilVarD.f34927e;
        if (i4 > i5 || zzvVar2.u > zzabvVar.f22684b) {
            i6 |= 256;
        }
        if (C0(zzujVar, zzvVar2) > zzabvVar.f22685c) {
            i6 |= 64;
        }
        if (i6 != 0) {
            i2 = 0;
            i3 = i6;
        } else {
            i2 = zzilVarD.f34926d;
            i3 = 0;
        }
        return new zzil(zzujVar.f35645a, zzvVar, zzvVar2, i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final float c0(float f2, zzv zzvVar, zzv[] zzvVarArr) {
        zzuj zzujVar;
        float fMax = -1.0f;
        for (zzv zzvVar2 : zzvVarArr) {
            float f3 = zzvVar2.x;
            if (f3 != -1.0f) {
                fMax = Math.max(fMax, f3);
            }
        }
        float f4 = fMax == -1.0f ? -1.0f : fMax * f2;
        if (this.I1 == null || (zzujVar = this.B0) == null) {
            return f4;
        }
        int i2 = zzvVar.t;
        float f5 = -3.4028235E38f;
        if (zzujVar.f35653i) {
            float f6 = zzujVar.f35656l;
            int i3 = zzvVar.u;
            if (f6 != -3.4028235E38f && zzujVar.f35654j == i2 && zzujVar.f35655k == i3) {
                f5 = f6;
            } else {
                f5 = 1024.0f;
                if (!zzujVar.e(i2, i3, 1024.0d)) {
                    float f7 = 0.0f;
                    while (true) {
                        float f8 = f5 - f7;
                        if (Math.abs(f8) <= 5.0f) {
                            break;
                        }
                        float f9 = (f8 / 2.0f) + f7;
                        boolean zE = zzujVar.e(i2, i3, f9);
                        if (true == zE) {
                            f7 = f9;
                        }
                        if (true != zE) {
                            f5 = f9;
                        }
                    }
                    f5 = f7;
                }
                zzujVar.f35656l = f5;
                zzujVar.f35654j = i2;
                zzujVar.f35655k = i3;
            }
        }
        return f4 != -1.0f ? Math.max(f4, f5) : f5;
    }

    @Override // com.google.android.gms.internal.ads.zzmi, com.google.android.gms.internal.ads.zzmk
    public final String d() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final void d0(final long j2, final long j3, String str) {
        final String str2;
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        final zzadf zzadfVar = this.l1;
        Handler handler = zzadfVar.f22796a;
        if (handler != null) {
            str2 = str;
            handler.post(new Runnable(str2, j2, j3) { // from class: com.google.android.gms.internal.ads.zzacv
                @Override // java.lang.Runnable
                public final void run() {
                    zzadf zzadfVar2 = this.f22778a;
                    zzadfVar2.getClass();
                    String str3 = zzfj.f31254a;
                    zzoz zzozVar = ((zzjl) zzadfVar2.f22797b).f35004a.r;
                    zzozVar.k(zzozVar.o(), 1016, new zznf());
                }
            });
        } else {
            str2 = str;
        }
        this.s1 = D0(str2);
        zzuj zzujVar = this.B0;
        zzujVar.getClass();
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 29 && "video/x-vnd.on2.vp9".equals(zzujVar.f35646b)) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = zzujVar.f35648d;
            if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
                codecProfileLevelArr = new MediaCodecInfo.CodecProfileLevel[0];
            }
            int length = codecProfileLevelArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (codecProfileLevelArr[i2].profile == 16384) {
                    z = true;
                    break;
                }
                i2++;
            }
        }
        this.t1 = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
    @Override // com.google.android.gms.internal.ads.zzuq, com.google.android.gms.internal.ads.zzmi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e() {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzv r0 = r7.D
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L3f
            boolean r0 = r7.x()
            if (r0 == 0) goto Lf
            boolean r0 = r7.n
            goto L18
        Lf:
            com.google.android.gms.internal.ads.zzxw r0 = r7.f34887i
            r0.getClass()
            boolean r0 = r0.zzb()
        L18:
            if (r0 != 0) goto L3e
            int r0 = r7.K0
            if (r0 < 0) goto L20
            r0 = r2
            goto L21
        L20:
            r0 = r1
        L21:
            if (r0 != 0) goto L3e
            long r3 = r7.I0
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L3f
            com.google.android.gms.internal.ads.zzfc r0 = r7.f34885g
            r0.getClass()
            long r3 = android.os.SystemClock.elapsedRealtime()
            long r5 = r7.I0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 < 0) goto L3e
            goto L3f
        L3e:
            r1 = r2
        L3f:
            com.google.android.gms.internal.ads.zzadl r0 = r7.u1
            if (r0 == 0) goto L48
            boolean r0 = r0.B0(r1)
            return r0
        L48:
            if (r1 == 0) goto L50
            com.google.android.gms.internal.ads.zzug r0 = r7.L
            if (r0 == 0) goto L4f
            goto L50
        L4f:
            return r2
        L50:
            com.google.android.gms.internal.ads.zzacm r0 = r7.n1
            boolean r0 = r0.e(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabw.e():boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final void e0(final String str) {
        final zzadf zzadfVar = this.l1;
        Handler handler = zzadfVar.f22796a;
        if (handler != null) {
            handler.post(new Runnable(str) { // from class: com.google.android.gms.internal.ads.zzadb
                @Override // java.lang.Runnable
                public final void run() {
                    zzadf zzadfVar2 = this.f22791a;
                    zzadfVar2.getClass();
                    String str2 = zzfj.f31254a;
                    zzoz zzozVar = ((zzjl) zzadfVar2.f22797b).f35004a.r;
                    zzozVar.k(zzozVar.o(), 1019, new zzni());
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final void f0(final Exception exc) {
        zzee.f("MediaCodecVideoRenderer", "Video codec error", exc);
        final zzadf zzadfVar = this.l1;
        Handler handler = zzadfVar.f22796a;
        if (handler != null) {
            handler.post(new Runnable(exc) { // from class: com.google.android.gms.internal.ads.zzadd
                @Override // java.lang.Runnable
                public final void run() {
                    zzadf zzadfVar2 = this.f22794a;
                    zzadfVar2.getClass();
                    String str = zzfj.f31254a;
                    zzoz zzozVar = ((zzjl) zzadfVar2.f22797b).f35004a.r;
                    zzozVar.k(zzozVar.o(), 1030, new zznn());
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmi
    public final boolean g(long j2) {
        long j3 = this.d1;
        return j3 == -9223372036854775807L || j2 > j3 - this.c1.f35667c;
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final zzil g0(zzle zzleVar) {
        final zzil zzilVarG0 = super.g0(zzleVar);
        final zzv zzvVar = zzleVar.f35082b;
        zzvVar.getClass();
        final zzadf zzadfVar = this.l1;
        Handler handler = zzadfVar.f22796a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzacw
                @Override // java.lang.Runnable
                public final void run() {
                    zzadf zzadfVar2 = zzadfVar;
                    zzadfVar2.getClass();
                    String str = zzfj.f31254a;
                    zzoz zzozVar = ((zzjl) zzadfVar2.f22797b).f35004a.r;
                    final zzmv zzmvVarO = zzozVar.o();
                    final zzv zzvVar2 = zzvVar;
                    final zzil zzilVar = zzilVarG0;
                    zzozVar.k(zzmvVarO, 1017, new zzdy(zzmvVarO, zzvVar2, zzilVar) { // from class: com.google.android.gms.internal.ads.zzng

                        /* renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ zzv f35245a;

                        {
                            this.f35245a = zzvVar2;
                        }

                        @Override // com.google.android.gms.internal.ads.zzdy
                        public final /* synthetic */ void zza(Object obj) {
                            ((zzmx) obj).o(this.f35245a);
                        }
                    });
                }
            });
        }
        return zzilVarG0;
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final void h0(zzv zzvVar, MediaFormat mediaFormat) {
        zzug zzugVar = this.L;
        if (zzugVar != null) {
            zzugVar.a0(this.C1);
        }
        mediaFormat.getClass();
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        int integer = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger(Snapshot.WIDTH);
        int integer2 = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger(Snapshot.HEIGHT);
        float f2 = zzvVar.z;
        int i2 = zzvVar.y;
        if (i2 == 90 || i2 == 270) {
            f2 = 1.0f / f2;
            int i3 = integer2;
            integer2 = integer;
            integer = i3;
        }
        this.N1 = new zzbv(f2, integer, integer2);
        zzadl zzadlVar = this.u1;
        if (zzadlVar == null || !this.U1) {
            this.n1.d(zzvVar.x);
        } else {
            zzt zztVar = new zzt(zzvVar);
            zztVar.s = integer;
            zztVar.t = integer2;
            zztVar.y = f2;
            zzv zzvVar2 = new zzv(zztVar);
            int i4 = this.w1;
            List list = this.x1;
            if (list == null) {
                zzgvs zzgvsVar = zzgtd.f33183b;
                list = zzguy.f33232e;
            }
            zzadlVar.n1(zzvVar2, this.c1.f35666b, i4, list);
            this.w1 = 2;
        }
        this.U1 = false;
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final void i0() {
        zzadl zzadlVar = this.u1;
        if (zzadlVar != null) {
            zzadlVar.zzi();
            long j2 = this.S1;
            if (j2 == -9223372036854775807L) {
                j2 = this.c1.f35666b;
                this.S1 = j2;
            }
            this.u1.m1(-j2);
        } else {
            this.n1.a(2);
        }
        this.U1 = true;
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final boolean j0(long j2, long j3, zzug zzugVar, ByteBuffer byteBuffer, int i2, int i3, int i4, long j4, boolean z, boolean z2, zzv zzvVar) {
        int i5;
        zzugVar.getClass();
        long j5 = j4 - this.c1.f35667c;
        int i6 = 0;
        while (true) {
            PriorityQueue priorityQueue = this.q1;
            Long l2 = (Long) priorityQueue.peek();
            if (l2 == null || l2.longValue() >= j4) {
                break;
            }
            priorityQueue.poll();
            i6++;
        }
        z0(i6, 0);
        zzadl zzadlVar = this.u1;
        if (zzadlVar != null) {
            if (!z || z2) {
                return zzadlVar.i1(j4, new zzabs(this, zzugVar, i2, j5));
            }
            y0(zzugVar, i2);
            return true;
        }
        long j6 = this.c1.f35666b;
        zzacm zzacmVar = this.n1;
        zzack zzackVar = this.o1;
        int iF = zzacmVar.f(j4, j2, j3, j6, z, z2, zzackVar);
        if (iF == 0) {
            this.f34885g.getClass();
            long jNanoTime = System.nanoTime();
            zzacj zzacjVar = this.R1;
            if (zzacjVar != null) {
                zzacjVar.a(j5, jNanoTime, zzvVar, this.Q);
            }
            B0(zzugVar, i2, jNanoTime);
            A0(zzackVar.f22728a);
            return true;
        }
        if (iF != 1) {
            if (iF != 2) {
                if (iF != 3) {
                    return false;
                }
                y0(zzugVar, i2);
                A0(zzackVar.f22728a);
                return true;
            }
            Trace.beginSection("dropVideoBuffer");
            zzugVar.l(i2);
            Trace.endSection();
            z0(0, 1);
            A0(zzackVar.f22728a);
            return true;
        }
        long j7 = zzackVar.f22729b;
        long j8 = zzackVar.f22728a;
        if (j7 == this.M1) {
            y0(zzugVar, i2);
        } else {
            zzacj zzacjVar2 = this.R1;
            if (zzacjVar2 != null) {
                i5 = i2;
                zzacjVar2.a(j5, j7, zzvVar, this.Q);
            } else {
                i5 = i2;
            }
            B0(zzugVar, i5, j7);
        }
        A0(j8);
        this.M1 = j7;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final void k0() {
        zzadl zzadlVar = this.u1;
        if (zzadlVar != null) {
            zzadlVar.zzi();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final void l0(zzih zzihVar) {
        if (this.t1) {
            ByteBuffer byteBuffer = zzihVar.f34832g;
            byteBuffer.getClass();
            if (byteBuffer.remaining() >= 7) {
                byte b2 = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b3 = byteBuffer.get();
                byte b4 = byteBuffer.get();
                byteBuffer.position(0);
                if (b2 == -75 && s == 60 && s2 == 1 && b3 == 4) {
                    if (b4 == 0 || b4 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        zzug zzugVar = this.L;
                        zzugVar.getClass();
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("hdr10-plus-info", bArr);
                        zzugVar.c0(bundle);
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuq, com.google.android.gms.internal.ads.zzmi
    public final void m(float f2, float f3) {
        super.m(f2, f3);
        zzadl zzadlVar = this.u1;
        if (zzadlVar != null) {
            zzadlVar.Q0(f2);
        } else {
            this.n1.g(f2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuq, com.google.android.gms.internal.ads.zzmi
    public final void o(long j2, long j3) throws zzit {
        zzadl zzadlVar = this.u1;
        if (zzadlVar != null) {
            try {
                zzadlVar.g1(j2, j3);
            } catch (zzadk e2) {
                throw F(e2, e2.f22799a, false, 7001);
            }
        }
        super.o(j2, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzmi
    public final void r() {
        zzadl zzadlVar = this.u1;
        if (zzadlVar == null) {
            zzacm zzacmVar = this.n1;
            if (zzacmVar.f22733d == 0) {
                zzacmVar.f22733d = 1;
                return;
            }
            return;
        }
        int i2 = this.w1;
        if (i2 == 0 || i2 == 1) {
            this.w1 = 0;
        } else {
            zzadlVar.f();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuq, com.google.android.gms.internal.ads.zzmi
    public final boolean t() {
        if (!this.Z0) {
            return false;
        }
        zzadl zzadlVar = this.u1;
        return zzadlVar == null || zzadlVar.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzuq, com.google.android.gms.internal.ads.zzij, com.google.android.gms.internal.ads.zzmd
    public final void u(int i2, Object obj) {
        if (i2 == 1) {
            F0(obj);
            return;
        }
        if (i2 == 7) {
            obj.getClass();
            zzacj zzacjVar = (zzacj) obj;
            this.R1 = zzacjVar;
            zzadl zzadlVar = this.u1;
            if (zzadlVar != null) {
                zzadlVar.o1(zzacjVar);
                return;
            }
            return;
        }
        if (i2 == 10) {
            obj.getClass();
            int iIntValue = ((Integer) obj).intValue();
            if (this.Q1 != iIntValue) {
                this.Q1 = iIntValue;
                return;
            }
            return;
        }
        if (i2 == 4) {
            obj.getClass();
            int iIntValue2 = ((Integer) obj).intValue();
            this.C1 = iIntValue2;
            zzug zzugVar = this.L;
            if (zzugVar != null) {
                zzugVar.a0(iIntValue2);
                return;
            }
            return;
        }
        if (i2 == 5) {
            obj.getClass();
            int iIntValue3 = ((Integer) obj).intValue();
            this.D1 = iIntValue3;
            zzadl zzadlVar2 = this.u1;
            if (zzadlVar2 != null) {
                zzadlVar2.f1(iIntValue3);
                return;
            }
            zzact zzactVar = this.n1.f22731b;
            if (zzactVar.f22762j == iIntValue3) {
                return;
            }
            zzactVar.f22762j = iIntValue3;
            zzactVar.c(true);
            return;
        }
        if (i2 == 13) {
            obj.getClass();
            List list = (List) obj;
            if (list.equals(zzbr.f25454a)) {
                zzadl zzadlVar3 = this.u1;
                if (zzadlVar3 == null || !zzadlVar3.zze()) {
                    return;
                }
                zzadlVar3.zzf();
                return;
            }
            this.x1 = list;
            zzadl zzadlVar4 = this.u1;
            if (zzadlVar4 != null) {
                zzadlVar4.l1(list);
                return;
            }
            return;
        }
        if (i2 == 14) {
            obj.getClass();
            zzes zzesVar = (zzes) obj;
            if (zzesVar.f30201a == 0 || zzesVar.f30202b == 0) {
                return;
            }
            this.A1 = zzesVar;
            zzadl zzadlVar5 = this.u1;
            if (zzadlVar5 != null) {
                Surface surface = this.y1;
                surface.getClass();
                zzadlVar5.h1(surface, zzesVar);
                return;
            }
            return;
        }
        switch (i2) {
            case 16:
                obj.getClass();
                this.P1 = ((Integer) obj).intValue();
                zzug zzugVar2 = this.L;
                if (zzugVar2 != null && Build.VERSION.SDK_INT >= 35) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("importance", Math.max(0, -this.P1));
                    zzugVar2.c0(bundle);
                    break;
                }
                break;
            case 17:
                Surface surface2 = this.y1;
                F0(null);
                obj.getClass();
                ((zzabw) obj).u(1, surface2);
                break;
            case 18:
                boolean z = this.I1 != null;
                zzmp zzmpVar = (zzmp) obj;
                this.I1 = zzmpVar;
                if (z != (zzmpVar != null)) {
                    p0(this.M);
                    break;
                }
                break;
            default:
                super.u(i2, obj);
                break;
        }
    }

    public final boolean w0(long j2, long j3, boolean z, boolean z2) {
        if (this.u1 != null && this.k1) {
            j3 -= -this.S1;
        }
        if (j2 < -500000 && !z) {
            zzxw zzxwVar = this.f34887i;
            zzxwVar.getClass();
            int iA = zzxwVar.a(j3 - this.f34889k);
            if (iA != 0) {
                PriorityQueue priorityQueue = this.q1;
                if (z2) {
                    zzik zzikVar = this.b1;
                    int i2 = zzikVar.f34914d + iA;
                    zzikVar.f34914d = i2;
                    zzikVar.f34916f += this.H1;
                    zzikVar.f34914d = priorityQueue.size() + i2;
                } else {
                    this.b1.f34920j++;
                    z0(priorityQueue.size() + iA, this.H1);
                }
                if (this.L != null) {
                    if (M()) {
                        L();
                        J();
                    } else if (N()) {
                        n0();
                    } else {
                        this.g1 = true;
                    }
                }
                zzadl zzadlVar = this.u1;
                if (zzadlVar != null) {
                    zzadlVar.N0(false);
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzuq, com.google.android.gms.internal.ads.zzij
    public final void y(long j2, boolean z, boolean z2) {
        zzadl zzadlVar = this.u1;
        if (zzadlVar != null && !z) {
            zzadlVar.N0(true);
        }
        super.y(j2, z, z2);
        zzadl zzadlVar2 = this.u1;
        zzacm zzacmVar = this.n1;
        if (zzadlVar2 == null) {
            zzacmVar.f22731b.a();
            zzacmVar.f22736g = -9223372036854775807L;
            zzacmVar.f22734e = -9223372036854775807L;
            zzacmVar.f22733d = Math.min(zzacmVar.f22733d, 1);
            zzacmVar.f22737h = -9223372036854775807L;
        }
        if (z) {
            zzadl zzadlVar3 = this.u1;
            if (zzadlVar3 != null) {
                zzadlVar3.P(false);
            } else {
                zzacmVar.f22738i = false;
                zzacmVar.f22737h = -9223372036854775807L;
            }
        }
        this.G1 = 0;
    }

    public final void y0(zzug zzugVar, int i2) {
        Trace.beginSection("skipVideoBuffer");
        zzugVar.l(i2);
        Trace.endSection();
        this.b1.f34916f++;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final void z() {
        this.F1 = 0;
        this.f34885g.getClass();
        this.E1 = SystemClock.elapsedRealtime();
        this.K1 = 0L;
        this.L1 = 0;
        zzadl zzadlVar = this.u1;
        if (zzadlVar != null) {
            zzadlVar.zza();
        } else {
            this.n1.b();
        }
    }

    public final void z0(int i2, int i3) {
        zzik zzikVar = this.b1;
        zzikVar.f34918h += i2;
        int i4 = i2 + i3;
        zzikVar.f34917g += i4;
        this.F1 += i4;
        int i5 = this.G1 + i4;
        this.G1 = i5;
        zzikVar.f34919i = Math.max(i5, zzikVar.f34919i);
    }
}
