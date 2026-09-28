package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;

/* loaded from: classes4.dex */
final class zzahh implements zzaeo {

    /* renamed from: b, reason: collision with root package name */
    public zzaer f23107b;

    /* renamed from: c, reason: collision with root package name */
    public zzaef f23108c;

    /* renamed from: d, reason: collision with root package name */
    public zzafw f23109d;

    /* renamed from: e, reason: collision with root package name */
    public zzakp f23110e;

    /* renamed from: g, reason: collision with root package name */
    public int f23112g;

    /* renamed from: h, reason: collision with root package name */
    public long f23113h;

    /* renamed from: i, reason: collision with root package name */
    public int f23114i;

    /* renamed from: a, reason: collision with root package name */
    public final zzer f23106a = new zzer(16);

    /* renamed from: j, reason: collision with root package name */
    public long f23115j = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f23111f = 0;

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void a(long j2, long j3) {
        if (j2 != 0) {
            if (this.f23111f == 3) {
                zzakp zzakpVar = this.f23110e;
                zzakpVar.getClass();
                zzakpVar.a(j2, j3);
                return;
            }
            return;
        }
        this.f23111f = 0;
        this.f23114i = 0;
        this.f23115j = -1L;
        if (this.f23110e != null) {
            this.f23110e = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void b(zzaer zzaerVar) {
        this.f23107b = zzaerVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0068, code lost:
    
        return false;
     */
    @Override // com.google.android.gms.internal.ads.zzaeo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(com.google.android.gms.internal.ads.zzaep r13) throws java.io.EOFException, java.io.InterruptedIOException {
        /*
            r12 = this;
            com.google.android.gms.internal.ads.zzer r0 = new com.google.android.gms.internal.ads.zzer
            r1 = 16
            r0.<init>(r1)
            r2 = 1
            r3 = r2
        L9:
            r4 = 8
            r0.y(r4)
            byte[] r5 = r0.f30144a
            r6 = r13
            com.google.android.gms.internal.ads.zzaef r6 = (com.google.android.gms.internal.ads.zzaef) r6
            r7 = 0
            boolean r5 = r6.t(r5, r7, r4, r2)
            if (r5 != 0) goto L1b
            goto L68
        L1b:
            long r8 = r0.P()
            int r5 = r0.b()
            r10 = 1
            int r10 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r10 != 0) goto L38
            byte[] r8 = r0.f30144a
            boolean r6 = r6.t(r8, r4, r4, r2)
            if (r6 != 0) goto L32
            goto L68
        L32:
            long r8 = r0.j()
            r6 = r1
            goto L39
        L38:
            r6 = r4
        L39:
            long r10 = (long) r6
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 >= 0) goto L3f
            goto L68
        L3f:
            long r8 = r8 - r10
            int r6 = (int) r8
            if (r3 == 0) goto L69
            r3 = 1718909296(0x66747970, float:2.8862439E23)
            if (r5 != r3) goto L68
            if (r6 >= r4) goto L4b
            goto L68
        L4b:
            r3 = 4
            r0.y(r3)
            byte[] r4 = r0.f30144a
            r5 = r13
            com.google.android.gms.internal.ads.zzaef r5 = (com.google.android.gms.internal.ads.zzaef) r5
            r5.t(r4, r7, r3, r7)
            int r3 = r0.b()
            r4 = 1751476579(0x68656963, float:4.333464E24)
            if (r3 == r4) goto L61
            goto L68
        L61:
            int r6 = r6 + (-4)
            r5.f(r6, r7)
        L66:
            r3 = r7
            goto L9
        L68:
            return r7
        L69:
            r3 = 1836086884(0x6d707664, float:4.6512205E27)
            if (r5 != r3) goto L6f
            return r2
        L6f:
            if (r6 == 0) goto L66
            r3 = r13
            com.google.android.gms.internal.ads.zzaef r3 = (com.google.android.gms.internal.ads.zzaef) r3
            r3.f(r6, r7)
            goto L66
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahh.c(com.google.android.gms.internal.ads.zzaep):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final int d(zzaep zzaepVar, zzafo zzafoVar) throws zzat, EOFException, InterruptedIOException {
        while (true) {
            int i2 = this.f23111f;
            if (i2 == 0) {
                int i3 = this.f23114i;
                zzer zzerVar = this.f23106a;
                if (i3 == 0) {
                    if (!((zzaef) zzaepVar).v(zzerVar.f30144a, 0, 8, true)) {
                        zzaer zzaerVar = this.f23107b;
                        zzaerVar.getClass();
                        ((zzxk) zzaerVar).h();
                        ((zzxk) this.f23107b).d(new zzafq(-9223372036854775807L, 0L));
                        this.f23111f = 4;
                        return -1;
                    }
                    this.f23114i = 8;
                    zzerVar.E(0);
                    this.f23113h = zzerVar.P();
                    this.f23112g = zzerVar.b();
                }
                long j2 = this.f23113h;
                if (j2 == 1) {
                    ((zzaef) zzaepVar).v(zzerVar.f30144a, 8, 8, false);
                    this.f23114i += 8;
                    j2 = zzerVar.j();
                    this.f23113h = j2;
                }
                if (this.f23112g == 1836086884) {
                    long j3 = ((zzaef) zzaepVar).f22872d;
                    this.f23115j = j3;
                    long j4 = this.f23114i;
                    zzaho zzahoVar = new zzaho(0L, j3 - j4, -9223372036854775807L, j3, j2 - j4);
                    zzaer zzaerVar2 = this.f23107b;
                    zzaerVar2.getClass();
                    zzaga zzagaVarE = ((zzxk) zzaerVar2).e(1024, 4);
                    zzt zztVar = new zzt();
                    zztVar.d("image/heic");
                    zztVar.f35573j = new zzap(zzahoVar);
                    zzagaVarE.c(new zzv(zztVar));
                    this.f23111f = 2;
                } else {
                    this.f23111f = 1;
                }
            } else if (i2 == 1) {
                ((zzaef) zzaepVar).d((int) (this.f23113h - this.f23114i), false);
                this.f23114i = 0;
                this.f23111f = 0;
            } else {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return -1;
                    }
                    if (this.f23109d == null || zzaepVar != this.f23108c) {
                        zzaef zzaefVar = (zzaef) zzaepVar;
                        this.f23108c = zzaefVar;
                        this.f23109d = new zzafw(zzaefVar, this.f23115j);
                    }
                    zzakp zzakpVar = this.f23110e;
                    zzakpVar.getClass();
                    int iD = zzakpVar.d(this.f23109d, zzafoVar);
                    if (iD == 1) {
                        zzafoVar.f22954a += this.f23115j;
                    }
                    return iD;
                }
                if (this.f23110e == null) {
                    this.f23110e = new zzakp(8, zzalw.f23510a);
                }
                zzafw zzafwVar = new zzafw((zzaef) zzaepVar, this.f23115j);
                this.f23109d = zzafwVar;
                if (this.f23110e.c(zzafwVar)) {
                    zzakp zzakpVar2 = this.f23110e;
                    long j5 = this.f23115j;
                    zzaer zzaerVar3 = this.f23107b;
                    zzaerVar3.getClass();
                    zzakpVar2.b(new zzafy(j5, zzaerVar3));
                    this.f23111f = 3;
                } else {
                    zzaer zzaerVar4 = this.f23107b;
                    zzaerVar4.getClass();
                    ((zzxk) zzaerVar4).h();
                    ((zzxk) this.f23107b).d(new zzafq(-9223372036854775807L, 0L));
                    this.f23111f = 4;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void zzf() {
        if (this.f23110e != null) {
            this.f23110e = null;
        }
    }
}
