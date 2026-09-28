package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class zzss implements zzrf {
    public static final AtomicInteger X = new AtomicInteger();
    public long A;
    public int B;
    public boolean C;
    public boolean D;
    public long E;
    public float F;
    public ByteBuffer G;
    public int H;
    public ByteBuffer I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public int N;
    public boolean O;
    public zze P;
    public AudioDeviceInfo Q;
    public int R;
    public long S;
    public long T;
    public long U;
    public Handler V;
    public final zzsn W;

    /* renamed from: a, reason: collision with root package name */
    public final Context f35539a;

    /* renamed from: b, reason: collision with root package name */
    public final zzse f35540b;

    /* renamed from: c, reason: collision with root package name */
    public final zzsh f35541c;

    /* renamed from: d, reason: collision with root package name */
    public final zzta f35542d;

    /* renamed from: e, reason: collision with root package name */
    public final zzcv f35543e;

    /* renamed from: f, reason: collision with root package name */
    public final zzsz f35544f;

    /* renamed from: g, reason: collision with root package name */
    public final zzgtd f35545g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayDeque f35546h;

    /* renamed from: i, reason: collision with root package name */
    public zzsj f35547i;

    /* renamed from: j, reason: collision with root package name */
    public final zzsr f35548j;

    /* renamed from: k, reason: collision with root package name */
    public final zzsr f35549k;

    /* renamed from: l, reason: collision with root package name */
    public zzpn f35550l;

    /* renamed from: m, reason: collision with root package name */
    public zzrc f35551m;
    public zzsm n;
    public zzsm o;
    public zzck p;
    public zzqg q;
    public zzpz r;
    public zzd s;
    public zzsq t;
    public zzsq u;
    public zzav v;
    public boolean w;
    public long x;
    public long y;
    public long z;

    public zzss(zzsl zzslVar) {
        int deviceId;
        Context context = zzslVar.f35514a;
        this.f35539a = context == null ? null : context.getApplicationContext();
        this.s = zzd.f27533b;
        this.W = zzslVar.f35519f;
        this.f35540b = zzslVar.f35518e;
        zzsh zzshVar = new zzsh();
        this.f35541c = zzshVar;
        zzta zztaVar = new zzta();
        this.f35542d = zztaVar;
        this.f35543e = new zzcv();
        this.f35544f = new zzsz();
        this.f35545g = zzgtd.o(zztaVar, zzshVar);
        this.F = 1.0f;
        this.N = 0;
        this.P = new zze();
        zzav zzavVar = zzav.f24411d;
        this.u = new zzsq(zzavVar, 0L, 0L);
        this.v = zzavVar;
        this.w = false;
        this.f35546h = new ArrayDeque();
        this.f35548j = new zzsr();
        this.f35549k = new zzsr();
        int i2 = -1;
        if (Build.VERSION.SDK_INT >= 34 && context != null && (deviceId = context.getDeviceId()) != 0 && deviceId != -1) {
            i2 = deviceId;
        }
        this.R = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(int r10, java.nio.ByteBuffer r11) {
        /*
            Method dump skipped, instructions count: 552
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzss.c(int, java.nio.ByteBuffer):int");
    }

    public final void a() {
        if (k()) {
            this.x = 0L;
            this.y = 0L;
            this.z = 0L;
            this.A = 0L;
            this.B = 0;
            this.u = new zzsq(this.v, 0L, 0L);
            this.E = 0L;
            this.t = null;
            this.f35546h.clear();
            this.G = null;
            this.H = 0;
            this.I = null;
            this.K = false;
            this.J = false;
            this.L = false;
            this.f35542d.o = 0L;
            zzck zzckVar = this.o.f35526f;
            this.p = zzckVar;
            zzckVar.b(zzcm.f26529b);
            this.f35547i = null;
            zzsm zzsmVar = this.n;
            if (zzsmVar != null) {
                this.o = zzsmVar;
                this.n = null;
            }
            X.incrementAndGet();
            this.r.zze();
            this.r = null;
        }
        zzsr zzsrVar = this.f35549k;
        zzsrVar.f35536a = null;
        zzsrVar.f35537b = -9223372036854775807L;
        zzsrVar.f35538c = -9223372036854775807L;
        zzsr zzsrVar2 = this.f35548j;
        zzsrVar2.f35536a = null;
        zzsrVar2.f35537b = -9223372036854775807L;
        zzsrVar2.f35538c = -9223372036854775807L;
        this.T = 0L;
        this.U = 0L;
        Handler handler = this.V;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public final void b() {
        a();
        zzguy zzguyVar = (zzguy) this.f35545g;
        int i2 = zzguyVar.f33234d;
        for (int i3 = 0; i3 < i2; i3++) {
            ((zzco) zzguyVar.get(i3)).zzj();
        }
        this.f35543e.zzj();
        this.f35544f.zzj();
        zzck zzckVar = this.p;
        if (zzckVar != null) {
            int i4 = 0;
            while (true) {
                zzgtd zzgtdVar = zzckVar.f26458a;
                if (i4 >= ((zzguy) zzgtdVar).f33234d) {
                    break;
                }
                zzco zzcoVar = (zzco) ((zzguy) zzgtdVar).get(i4);
                zzcm zzcmVar = zzcm.f26529b;
                zzcoVar.zzi();
                zzcoVar.zzj();
                i4++;
            }
            zzckVar.f26460c = new ByteBuffer[0];
            zzcl zzclVar = zzcl.f26484e;
            zzckVar.f26461d = false;
        }
        this.M = false;
    }

    public final zzpz d(zzqi zzqiVar) throws zzrb {
        try {
            return this.f35540b.c(zzqiVar);
        } catch (zzqf e2) {
            int i2 = zzqiVar.f35393b;
            String strValueOf = String.valueOf(this.o.f35521a);
            int length = String.valueOf(i2).length();
            int i3 = zzqiVar.f35394c;
            int length2 = String.valueOf(i3).length();
            int i4 = zzqiVar.f35392a;
            int length3 = String.valueOf(i4).length();
            int i5 = zzqiVar.f35395d;
            StringBuilder sb = new StringBuilder(length + 34 + length2 + 2 + length3 + 2 + String.valueOf(i5).length() + 2 + strValueOf.length());
            androidx.fragment.app.e.w(i2, i3, "AudioTrack init failed 0 Config(", ", ", sb);
            androidx.fragment.app.e.w(i4, i5, ", ", ", ", sb);
            zzrb zzrbVar = new zzrb(android.support.v4.media.b.s(sb, ") ", strValueOf, ""), e2);
            zzrc zzrcVar = this.f35551m;
            if (zzrcVar == null) {
                throw zzrbVar;
            }
            ((zzsv) zzrcVar).a(zzrbVar);
            throw zzrbVar;
        }
    }

    public final void e(long j2) throws zzre {
        ByteBuffer byteBuffer;
        h(j2);
        if (this.I != null) {
            return;
        }
        if (!this.p.c()) {
            ByteBuffer byteBuffer2 = this.G;
            if (byteBuffer2 != null) {
                g(byteBuffer2);
                h(j2);
                return;
            }
            return;
        }
        while (!this.p.d()) {
            do {
                zzck zzckVar = this.p;
                if (zzckVar.c()) {
                    ByteBuffer byteBuffer3 = zzckVar.f26460c[zzckVar.f()];
                    if (byteBuffer3.hasRemaining()) {
                        byteBuffer = byteBuffer3;
                    } else {
                        zzckVar.e(zzco.f26781a);
                        byteBuffer = zzckVar.f26460c[zzckVar.f()];
                    }
                } else {
                    byteBuffer = zzco.f26781a;
                }
                if (byteBuffer.hasRemaining()) {
                    g(byteBuffer);
                    h(j2);
                } else {
                    ByteBuffer byteBuffer4 = this.G;
                    if (byteBuffer4 == null || !byteBuffer4.hasRemaining()) {
                        return;
                    }
                    zzck zzckVar2 = this.p;
                    ByteBuffer byteBuffer5 = this.G;
                    if (zzckVar2.c() && !zzckVar2.f26461d) {
                        zzckVar2.e(byteBuffer5);
                    }
                }
            } while (this.I == null);
            return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0045 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f() throws com.google.android.gms.internal.ads.zzre {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzck r0 = r6.p
            boolean r0 = r0.c()
            r1 = -9223372036854775808
            r3 = 0
            r4 = 1
            if (r0 != 0) goto L14
            r6.h(r1)
            java.nio.ByteBuffer r0 = r6.I
            if (r0 != 0) goto L45
            goto L44
        L14:
            com.google.android.gms.internal.ads.zzck r0 = r6.p
            boolean r5 = r0.c()
            if (r5 == 0) goto L2e
            boolean r5 = r0.f26461d
            if (r5 == 0) goto L21
            goto L2e
        L21:
            r0.f26461d = r4
            java.util.ArrayList r0 = r0.f26459b
            java.lang.Object r0 = r0.get(r3)
            com.google.android.gms.internal.ads.zzco r0 = (com.google.android.gms.internal.ads.zzco) r0
            r0.zze()
        L2e:
            r6.e(r1)
            com.google.android.gms.internal.ads.zzck r0 = r6.p
            boolean r0 = r0.d()
            if (r0 == 0) goto L45
            java.nio.ByteBuffer r0 = r6.I
            if (r0 == 0) goto L44
            boolean r0 = r0.hasRemaining()
            if (r0 == 0) goto L44
            goto L45
        L44:
            return r4
        L45:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzss.f():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01f8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0055 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(java.nio.ByteBuffer r19) {
        /*
            Method dump skipped, instructions count: 527
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzss.g(java.nio.ByteBuffer):void");
    }

    public final void h(long j2) throws zzre {
        if (this.I == null) {
            return;
        }
        zzsr zzsrVar = this.f35549k;
        if (zzsrVar.f35536a != null && (X.get() > 0 || SystemClock.elapsedRealtime() < zzsrVar.f35538c)) {
            return;
        }
        int iRemaining = this.I.remaining();
        try {
            boolean zA = this.r.a(this.H, this.I);
            this.S = SystemClock.elapsedRealtime();
            zzsrVar.f35536a = null;
            zzsrVar.f35537b = -9223372036854775807L;
            zzsrVar.f35538c = -9223372036854775807L;
            this.r.zzg();
            if (this.o.a()) {
                this.z += iRemaining - this.I.remaining();
            }
            if (zA) {
                if (!this.o.a()) {
                    zzgqa.f(this.I == this.G);
                    this.A = (this.B * this.H) + this.A;
                }
                this.I = null;
            }
        } catch (zzpy e2) {
            boolean z = e2.f35360b;
            if (z) {
                if (l() > 0) {
                    z = true;
                } else if (this.r.zzg()) {
                    this.o.getClass();
                    z = true;
                }
            }
            zzre zzreVar = new zzre(e2.f35359a, this.o.f35521a, z);
            zzrc zzrcVar = this.f35551m;
            if (zzrcVar != null) {
                ((zzsv) zzrcVar).a(zzreVar);
            }
            if (z) {
                throw zzreVar;
            }
            zzsrVar.a(zzreVar);
        }
    }

    public final void i() {
        if (this.o != null) {
            zzsm zzsmVar = this.n;
            if (zzsmVar != null) {
                this.o = zzsmVar;
                this.n = null;
            }
            try {
                zzqi zzqiVarB = this.f35540b.b(m(this.o.f35522b));
                zzsm zzsmVar2 = this.o;
                this.o = new zzsm(zzsmVar2.f35521a, zzsmVar2.f35522b, zzsmVar2.f35523c, zzsmVar2.f35524d, zzqiVarB, zzsmVar2.f35526f);
            } catch (zzqa e2) {
                throw new IllegalStateException(new zzra(e2, this.o.f35521a));
            }
        }
        a();
    }

    public final void j(long j2) {
        boolean z;
        zzav zzavVar;
        boolean z2 = false;
        if (this.o.a()) {
            int i2 = this.o.f35521a.G;
            z = true;
        } else {
            z = false;
        }
        zzsn zzsnVar = this.W;
        if (z) {
            zzavVar = this.v;
            zzsnVar.getClass();
            float f2 = zzavVar.f24412a;
            zzcu zzcuVar = zzsnVar.f35529c;
            zzcuVar.getClass();
            zzgqa.a(f2 > 0.0f);
            if (zzcuVar.f27143c != f2) {
                zzcuVar.f27143c = f2;
                zzcuVar.f27149i = true;
            }
            float f3 = zzavVar.f24413b;
            zzgqa.a(f3 > 0.0f);
            if (zzcuVar.f27144d != f3) {
                zzcuVar.f27144d = f3;
                zzcuVar.f27149i = true;
            }
        } else {
            zzavVar = zzav.f24411d;
        }
        zzav zzavVar2 = zzavVar;
        this.v = zzavVar2;
        if (this.o.a()) {
            int i3 = this.o.f35521a.G;
            z2 = this.w;
            zzsnVar.f35528b.f35559j = z2;
        }
        this.w = z2;
        this.f35546h.add(new zzsq(zzavVar2, Math.max(0L, j2), zzfj.t(this.o.f35525e.f35393b, l())));
        zzck zzckVar = this.o.f35526f;
        this.p = zzckVar;
        zzckVar.b(zzcm.f26529b);
        zzrc zzrcVar = this.f35551m;
        if (zzrcVar != null) {
            final boolean z3 = this.w;
            final zzqx zzqxVar = ((zzsv) zzrcVar).f35552a.j1;
            Handler handler = zzqxVar.f35417a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqs
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzqx zzqxVar2 = zzqxVar;
                        zzqxVar2.getClass();
                        String str = zzfj.f31254a;
                        zzkp zzkpVar = ((zzjl) zzqxVar2.f35418b).f35004a;
                        boolean z4 = zzkpVar.R;
                        boolean z5 = z3;
                        if (z4 == z5) {
                            return;
                        }
                        zzkpVar.R = z5;
                        zzjg zzjgVar = new zzjg();
                        zzed zzedVar = zzkpVar.f35046m;
                        zzedVar.c(23, zzjgVar);
                        zzedVar.d();
                    }
                });
            }
        }
    }

    public final boolean k() {
        return this.r != null;
    }

    public final long l() {
        if (!this.o.a()) {
            return this.A;
        }
        long j2 = this.z;
        long j3 = this.o.f35524d;
        String str = zzfj.f31254a;
        return ((j2 + j3) - 1) / j3;
    }

    public final zzqc m(zzv zzvVar) {
        zzqb zzqbVar = new zzqb(zzvVar);
        zzqbVar.f35366b = this.s;
        zzqbVar.f35367c = this.Q;
        zzqbVar.f35368d = this.N;
        zzqbVar.f35370f = -1;
        zzqbVar.f35369e = this.R;
        return new zzqc(zzqbVar);
    }

    public final boolean n(zzv zzvVar) {
        return o(zzvVar) != 0;
    }

    public final int o(zzv zzvVar) {
        int i2 = this.f35540b.a(m(zzvVar)).f35384d;
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2) {
                return 0;
            }
        }
        return i3;
    }

    public final void p(zzv zzvVar, int[] iArr) throws zzra {
        zzck zzckVar;
        zzv zzvVar2;
        int i2;
        int iD;
        zzqg zzqgVar = this.q;
        zzse zzseVar = this.f35540b;
        if (zzqgVar == null && this.f35539a != null) {
            zzqg zzqgVar2 = new zzqg() { // from class: com.google.android.gms.internal.ads.zzso
                @Override // com.google.android.gms.internal.ads.zzqg
                public final void zza() {
                    zzmj zzmjVar;
                    zzrc zzrcVar = this.f35530a.f35551m;
                    if (zzrcVar != null) {
                        zzsw zzswVar = ((zzsv) zzrcVar).f35552a;
                        synchronized (zzswVar.f34879a) {
                            zzmjVar = zzswVar.r;
                        }
                        if (zzmjVar != null) {
                            zzmjVar.zza();
                        }
                    }
                }
            };
            this.q = zzqgVar2;
            zzseVar.e();
            if (zzseVar.f35487c == null) {
                Looper looperMyLooper = Looper.myLooper();
                looperMyLooper.getClass();
                zzed zzedVar = new zzed(looperMyLooper, zzseVar.f35488d);
                zzseVar.f35487c = zzedVar;
                zzedVar.f29105i = false;
            }
            zzseVar.f35487c.a(zzqgVar2);
        }
        if ("audio/raw".equals(zzvVar.f35691m)) {
            int i3 = zzvVar.G;
            zzgqa.a(zzfj.a(i3));
            int iD2 = zzfj.d(i3);
            int i4 = zzvVar.E;
            int i5 = iD2 * i4;
            zzgta zzgtaVar = new zzgta();
            zzgtaVar.d(this.f35545g);
            zzgtaVar.c(this.f35543e);
            zzco[] zzcoVarArr = this.W.f35527a;
            zzguw.a(2, zzcoVarArr);
            zzgtaVar.e(2);
            System.arraycopy(zzcoVarArr, 0, zzgtaVar.f33171a, zzgtaVar.f33172b, 2);
            zzgtaVar.f33172b += 2;
            zzckVar = new zzck(zzgtaVar.f());
            if (zzckVar.equals(this.p)) {
                zzckVar = this.p;
            }
            int i6 = zzvVar.H;
            zzta zztaVar = this.f35542d;
            zztaVar.f35577i = i6;
            zztaVar.f35578j = zzvVar.I;
            this.f35541c.f35507i = iArr;
            try {
                zzcl zzclVarA = zzckVar.a(new zzcl(zzvVar.F, i4, i3));
                zzt zztVar = new zzt(zzvVar);
                int i7 = zzclVarA.f26487c;
                zztVar.F = i7;
                zztVar.E = zzclVarA.f26485a;
                int i8 = zzclVarA.f26486b;
                zztVar.D = i8;
                zzv zzvVar3 = new zzv(zztVar);
                iD = zzfj.d(i7) * i8;
                i2 = i5;
                zzvVar2 = zzvVar3;
            } catch (zzcn e2) {
                throw new zzra(e2, zzvVar);
            }
        } else {
            zzgvs zzgvsVar = zzgtd.f33183b;
            zzckVar = new zzck(zzguy.f33232e);
            zzvVar2 = zzvVar;
            i2 = -1;
            iD = -1;
        }
        try {
            zzsm zzsmVar = new zzsm(zzvVar, zzvVar2, i2, iD, zzseVar.b(m(zzvVar2)), zzckVar);
            if (k()) {
                this.n = zzsmVar;
            } else {
                this.o = zzsmVar;
            }
        } catch (zzqa e3) {
            throw new zzra(e3, zzvVar);
        }
    }

    public final void q() {
        this.M = true;
        if (k()) {
            this.r.zza();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x023e, code lost:
    
        if (r0 != 0) goto L122;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean r(java.nio.ByteBuffer r22, int r23, long r24) throws com.google.android.gms.internal.ads.zzrb, com.google.android.gms.internal.ads.zzre {
        /*
            Method dump skipped, instructions count: 813
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzss.r(java.nio.ByteBuffer, int, long):boolean");
    }

    public final boolean s() {
        if (!k()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 29 && this.r.zzg() && this.L) {
            return false;
        }
        long jL = l();
        long jZzk = this.r.zzk();
        zzpz zzpzVar = this.r;
        zzpzVar.getClass();
        return jL > zzfj.u(jZzk, (long) zzpzVar.zzi(), 1000000L, RoundingMode.UP);
    }
}
