package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.LoudnessCodecController;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.gms.common.Scopes;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzsw extends zzuq implements zzlj {
    public final zzqx j1;
    public final zzss k1;
    public final zzuc l1;
    public int m1;
    public boolean n1;
    public zzv o1;
    public zzv p1;
    public long q1;
    public boolean r1;
    public boolean s1;
    public boolean t1;
    public int u1;
    public boolean v1;
    public long w1;

    public zzsw(Context context, zzty zztyVar, Handler handler, zzqy zzqyVar, zzss zzssVar) {
        zzuc zzucVar;
        zzur zzurVar = zzur.f35670b;
        if (Build.VERSION.SDK_INT >= 35) {
            zzub zzubVar = zzub.f35636a;
            zzucVar = new zzuc(0);
        } else {
            zzucVar = null;
        }
        super(1, zztyVar, zzurVar, 44100.0f);
        context.getApplicationContext();
        this.k1 = zzssVar;
        this.l1 = zzucVar;
        this.u1 = -1000;
        this.j1 = new zzqx(handler, zzqyVar);
        this.w1 = -9223372036854775807L;
        zzssVar.f35551m = new zzsv(this);
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final void A() {
        w0();
        this.v1 = false;
        zzss zzssVar = this.k1;
        zzssVar.M = false;
        if (zzssVar.k()) {
            zzssVar.r.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuq, com.google.android.gms.internal.ads.zzij
    public final void B() {
        final zzqx zzqxVar = this.j1;
        this.s1 = true;
        this.o1 = null;
        this.w1 = -9223372036854775807L;
        try {
            try {
                this.k1.a();
                super.B();
                final zzik zzikVar = this.b1;
                zzqxVar.getClass();
                synchronized (zzikVar) {
                }
                Handler handler = zzqxVar.f35417a;
                if (handler != null) {
                    handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqr
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzqx zzqxVar2 = zzqxVar;
                            zzik zzikVar2 = zzikVar;
                            zzqxVar2.getClass();
                            synchronized (zzikVar2) {
                            }
                            String str = zzfj.f31254a;
                            zzoz zzozVar = ((zzjl) zzqxVar2.f35418b).f35004a.r;
                            zzozVar.k(zzozVar.n(zzozVar.f35271d.f35266e), 1013, new zzow());
                        }
                    });
                }
            } catch (Throwable th) {
                super.B();
                final zzik zzikVar2 = this.b1;
                zzqxVar.getClass();
                synchronized (zzikVar2) {
                    Handler handler2 = zzqxVar.f35417a;
                    if (handler2 != null) {
                        handler2.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqr
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzqx zzqxVar2 = zzqxVar;
                                zzik zzikVar22 = zzikVar2;
                                zzqxVar2.getClass();
                                synchronized (zzikVar22) {
                                }
                                String str = zzfj.f31254a;
                                zzoz zzozVar = ((zzjl) zzqxVar2.f35418b).f35004a.r;
                                zzozVar.k(zzozVar.n(zzozVar.f35271d.f35266e), 1013, new zzow());
                            }
                        });
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            final zzik zzikVar3 = this.b1;
            zzqxVar.getClass();
            synchronized (zzikVar3) {
                Handler handler3 = zzqxVar.f35417a;
                if (handler3 != null) {
                    handler3.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqr
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzqx zzqxVar2 = zzqxVar;
                            zzik zzikVar22 = zzikVar3;
                            zzqxVar2.getClass();
                            synchronized (zzikVar22) {
                            }
                            String str = zzfj.f31254a;
                            zzoz zzozVar = ((zzjl) zzqxVar2.f35418b).f35004a.r;
                            zzozVar.k(zzozVar.n(zzozVar.f35271d.f35266e), 1013, new zzow());
                        }
                    });
                }
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuq, com.google.android.gms.internal.ads.zzij
    public final void C() {
        zzss zzssVar = this.k1;
        this.t1 = false;
        this.w1 = -9223372036854775807L;
        try {
            super.C();
            if (this.s1) {
                this.s1 = false;
                zzssVar.b();
            }
        } catch (Throwable th) {
            if (this.s1) {
                this.s1 = false;
                zzssVar.b();
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final void D() {
        zzuc zzucVar;
        zzse zzseVar = this.k1.f35540b;
        zzed zzedVar = zzseVar.f35487c;
        if (zzedVar != null) {
            zzedVar.e();
        }
        zzpu zzpuVar = zzseVar.f35490f;
        if (zzpuVar != null && zzpuVar.f35351j) {
            zzpuVar.f35348g = null;
            Context context = zzpuVar.f35342a;
            zzcj.a(context).unregisterAudioDeviceCallback(zzpuVar.f35345d);
            context.unregisterReceiver(zzpuVar.f35346e);
            zzpr zzprVar = zzpuVar.f35347f;
            if (zzprVar != null) {
                zzprVar.f35338a.unregisterContentObserver(zzprVar);
            }
            zzpuVar.f35351j = false;
        }
        if (Build.VERSION.SDK_INT < 35 || (zzucVar = this.l1) == null) {
            return;
        }
        zzucVar.f35637a.clear();
        LoudnessCodecController loudnessCodecController = zzucVar.f35638b;
        if (loudnessCodecController != null) {
            loudnessCodecController.close();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuq, com.google.android.gms.internal.ads.zzij
    public final void H(boolean z, boolean z2) {
        super.H(z, z2);
        final zzik zzikVar = this.b1;
        final zzqx zzqxVar = this.j1;
        Handler handler = zzqxVar.f35417a;
        if (handler != null) {
            handler.post(new Runnable(zzikVar) { // from class: com.google.android.gms.internal.ads.zzqw
                @Override // java.lang.Runnable
                public final void run() {
                    zzqx zzqxVar2 = this.f35416a;
                    zzqxVar2.getClass();
                    String str = zzfj.f31254a;
                    zzoz zzozVar = ((zzjl) zzqxVar2.f35418b).f35004a.r;
                    zzozVar.k(zzozVar.o(), 1007, new zzof());
                }
            });
        }
        E();
        zzpn zzpnVar = this.f34884f;
        zzpnVar.getClass();
        zzss zzssVar = this.k1;
        zzssVar.f35550l = zzpnVar;
        zzfc zzfcVar = this.f34885g;
        zzfcVar.getClass();
        zzssVar.f35540b.f35488d = zzfcVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c6  */
    @Override // com.google.android.gms.internal.ads.zzuq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int W(com.google.android.gms.internal.ads.zzus r12, com.google.android.gms.internal.ads.zzv r13) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsw.W(com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzv):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
    @Override // com.google.android.gms.internal.ads.zzuq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList X(com.google.android.gms.internal.ads.zzus r4, com.google.android.gms.internal.ads.zzv r5) {
        /*
            r3 = this;
            java.lang.String r0 = r5.f35691m
            if (r0 != 0) goto L9
            com.google.android.gms.internal.ads.zzgvs r4 = com.google.android.gms.internal.ads.zzgtd.f33183b
            com.google.android.gms.internal.ads.zzgtd r4 = com.google.android.gms.internal.ads.zzguy.f33232e
            goto L31
        L9:
            com.google.android.gms.internal.ads.zzss r0 = r3.k1
            boolean r0 = r0.n(r5)
            r1 = 0
            if (r0 == 0) goto L2d
            java.lang.String r0 = "audio/raw"
            java.util.List r0 = com.google.android.gms.internal.ads.zzvc.a(r0, r1, r1)
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L20
            r0 = 0
            goto L26
        L20:
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.ads.zzuj r0 = (com.google.android.gms.internal.ads.zzuj) r0
        L26:
            if (r0 == 0) goto L2d
            com.google.android.gms.internal.ads.zzgtd r4 = com.google.android.gms.internal.ads.zzgtd.n(r0)
            goto L31
        L2d:
            java.util.List r4 = com.google.android.gms.internal.ads.zzvc.b(r4, r5, r1, r1)
        L31:
            java.util.HashMap r0 = com.google.android.gms.internal.ads.zzvc.f35693a
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r4)
            com.google.android.gms.internal.ads.zzva r4 = new com.google.android.gms.internal.ads.zzva
            r4.<init>(r5)
            com.google.android.gms.internal.ads.zzuz r5 = new com.google.android.gms.internal.ads.zzuz
            r5.<init>(r4)
            java.util.Collections.sort(r0, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsw.X(com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzv):java.util.ArrayList");
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final boolean Y(zzv zzvVar) {
        E();
        return this.k1.n(zzvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final zzud Z(zzuj zzujVar, zzv zzvVar, float f2) {
        zzv[] zzvVarArr = this.f34888j;
        zzvVarArr.getClass();
        int length = zzvVarArr.length;
        String str = zzujVar.f35645a;
        "OMX.google.raw.decoder".equals(str);
        int iMax = zzvVar.n;
        if (length != 1) {
            for (zzv zzvVar2 : zzvVarArr) {
                if (zzujVar.d(zzvVar, zzvVar2).f34926d != 0) {
                    "OMX.google.raw.decoder".equals(str);
                    iMax = Math.max(iMax, zzvVar2.n);
                }
            }
        }
        this.m1 = iMax;
        int i2 = Build.VERSION.SDK_INT;
        this.n1 = str.equals("OMX.google.opus.decoder") || str.equals("c2.android.opus.decoder") || str.equals("OMX.google.vorbis.decoder") || str.equals("c2.android.vorbis.decoder");
        int i3 = this.m1;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", zzujVar.f35647c);
        int i4 = zzvVar.E;
        mediaFormat.setInteger("channel-count", i4);
        int i5 = zzvVar.F;
        mediaFormat.setInteger("sample-rate", i5);
        zzeh.a(mediaFormat, zzvVar.p);
        zzeh.b(mediaFormat, "max-input-size", i3);
        mediaFormat.setInteger("priority", 0);
        if (f2 != -1.0f) {
            mediaFormat.setFloat("operating-rate", f2);
        }
        String str2 = zzvVar.f35691m;
        if ("audio/ac4".equals(str2)) {
            Pair pairB = zzdo.b(zzvVar);
            if (pairB != null) {
                zzeh.b(mediaFormat, Scopes.PROFILE, ((Integer) pairB.first).intValue());
                zzeh.b(mediaFormat, "level", ((Integer) pairB.second).intValue());
            }
            if (i2 <= 28) {
                mediaFormat.setInteger("ac4-is-sync", 1);
            }
        }
        zzt zztVar = new zzt();
        zztVar.e("audio/raw");
        zztVar.D = i4;
        zztVar.E = i5;
        zztVar.F = 4;
        if (this.k1.o(new zzv(zztVar)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        if (i2 >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        if (i2 >= 35) {
            mediaFormat.setInteger("importance", Math.max(0, -this.u1));
        }
        zzv zzvVar3 = null;
        if ("audio/raw".equals(zzujVar.f35646b) && !"audio/raw".equals(str2)) {
            zzvVar3 = zzvVar;
        }
        this.p1 = zzvVar3;
        return new zzud(zzujVar, mediaFormat, zzvVar, null, this.l1);
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final zzil a0(zzuj zzujVar, zzv zzvVar, zzv zzvVar2) {
        int i2;
        int i3;
        zzil zzilVarD = zzujVar.d(zzvVar, zzvVar2);
        boolean z = this.G == null && Y(zzvVar2);
        int i4 = zzilVarD.f34927e;
        if (z) {
            i4 |= 32768;
        }
        "OMX.google.raw.decoder".equals(zzujVar.f35645a);
        if (zzvVar2.n > this.m1) {
            i4 |= 64;
        }
        if (i4 != 0) {
            i2 = 0;
            i3 = i4;
        } else {
            i2 = zzilVarD.f34926d;
            i3 = 0;
        }
        return new zzil(zzujVar.f35645a, zzvVar, zzvVar2, i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final long b0(long j2, long j3) {
        long jU;
        zzss zzssVar = this.k1;
        boolean z = zzssVar.s() && this.w1 != -9223372036854775807L;
        if (this.v1) {
            if (!zzssVar.k()) {
                jU = -9223372036854775807L;
            } else if (zzssVar.o.a()) {
                jU = zzfj.t(zzssVar.o.f35525e.f35393b, zzssVar.r.zzj());
            } else {
                long jZzj = zzssVar.r.zzj();
                int iB = zzaes.b(zzssVar.o.f35525e.f35392a);
                zzgqa.f(iB != -2147483647);
                jU = zzfj.u(jZzj, 1000000L, iB, RoundingMode.DOWN);
            }
            if (z && jU != -9223372036854775807L) {
                float fMin = Math.min(jU, this.w1 - j2);
                zzav zzavVar = zzssVar.v;
                float f2 = zzavVar != null ? zzavVar.f24412a : 1.0f;
                this.f34885g.getClass();
                return Math.max(10000L, ((long) ((fMin / f2) / 2.0f)) - (zzfj.s(SystemClock.elapsedRealtime()) - j3));
            }
        } else if (z || this.Z0) {
            return 1000000L;
        }
        return 10000L;
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final float c0(float f2, zzv zzvVar, zzv[] zzvVarArr) {
        int iMax = -1;
        for (zzv zzvVar2 : zzvVarArr) {
            int i2 = zzvVar2.F;
            if (i2 != -1) {
                iMax = Math.max(iMax, i2);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return iMax * f2;
    }

    @Override // com.google.android.gms.internal.ads.zzmi, com.google.android.gms.internal.ads.zzmk
    public final String d() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final void d0(final long j2, final long j3, final String str) {
        final zzqx zzqxVar = this.j1;
        Handler handler = zzqxVar.f35417a;
        if (handler != null) {
            handler.post(new Runnable(str, j2, j3) { // from class: com.google.android.gms.internal.ads.zzqk
                @Override // java.lang.Runnable
                public final void run() {
                    zzqx zzqxVar2 = this.f35399a;
                    zzqxVar2.getClass();
                    String str2 = zzfj.f31254a;
                    zzoz zzozVar = ((zzjl) zzqxVar2.f35418b).f35004a.r;
                    zzozVar.k(zzozVar.o(), 1008, new zzop());
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuq, com.google.android.gms.internal.ads.zzmi
    public final boolean e() {
        return this.k1.s();
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final void e0(final String str) {
        final zzqx zzqxVar = this.j1;
        Handler handler = zzqxVar.f35417a;
        if (handler != null) {
            handler.post(new Runnable(str) { // from class: com.google.android.gms.internal.ads.zzqq
                @Override // java.lang.Runnable
                public final void run() {
                    zzqx zzqxVar2 = this.f35408a;
                    zzqxVar2.getClass();
                    String str2 = zzfj.f31254a;
                    zzoz zzozVar = ((zzjl) zzqxVar2.f35418b).f35004a.r;
                    zzozVar.k(zzozVar.o(), 1012, new zzov());
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final void f0(final Exception exc) {
        zzee.f("MediaCodecAudioRenderer", "Audio codec error", exc);
        final zzqx zzqxVar = this.j1;
        Handler handler = zzqxVar.f35417a;
        if (handler != null) {
            handler.post(new Runnable(exc) { // from class: com.google.android.gms.internal.ads.zzqu
                @Override // java.lang.Runnable
                public final void run() {
                    zzqx zzqxVar2 = this.f35414a;
                    zzqxVar2.getClass();
                    String str = zzfj.f31254a;
                    zzoz zzozVar = ((zzjl) zzqxVar2.f35418b).f35004a.r;
                    zzozVar.k(zzozVar.o(), 1029, new zzna());
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final zzil g0(zzle zzleVar) {
        final zzv zzvVar = zzleVar.f35082b;
        zzvVar.getClass();
        this.o1 = zzvVar;
        final zzil zzilVarG0 = super.g0(zzleVar);
        final zzqx zzqxVar = this.j1;
        Handler handler = zzqxVar.f35417a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqn
                @Override // java.lang.Runnable
                public final void run() {
                    zzqx zzqxVar2 = zzqxVar;
                    zzqxVar2.getClass();
                    String str = zzfj.f31254a;
                    zzoz zzozVar = ((zzjl) zzqxVar2.f35418b).f35004a.r;
                    zzmv zzmvVarO = zzozVar.o();
                    zzozVar.k(zzmvVarO, 1009, new zzdy(zzmvVarO, zzvVar, zzilVarG0) { // from class: com.google.android.gms.internal.ads.zzos

                        /* renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ zzv f35259a;

                        {
                            this.f35259a = zzvVar;
                        }

                        @Override // com.google.android.gms.internal.ads.zzdy
                        public final /* synthetic */ void zza(Object obj) {
                            ((zzmx) obj).k(this.f35259a);
                        }
                    });
                }
            });
        }
        return zzilVarG0;
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final void h0(zzv zzvVar, MediaFormat mediaFormat) throws zzit {
        zzv zzvVar2 = this.p1;
        int[] iArr = null;
        boolean z = true;
        if (zzvVar2 != null) {
            zzvVar = zzvVar2;
        } else if (this.L != null) {
            mediaFormat.getClass();
            int integer = "audio/raw".equals(zzvVar.f35691m) ? zzvVar.G : mediaFormat.containsKey("pcm-encoding") ? mediaFormat.getInteger("pcm-encoding") : mediaFormat.containsKey("v-bits-per-sample") ? zzfj.y(mediaFormat.getInteger("v-bits-per-sample"), ByteOrder.LITTLE_ENDIAN) : 2;
            zzt zztVar = new zzt();
            zztVar.e("audio/raw");
            zztVar.F = integer;
            zztVar.G = zzvVar.H;
            zztVar.H = zzvVar.I;
            zztVar.f35573j = zzvVar.f35689k;
            zztVar.f35564a = zzvVar.f35679a;
            zztVar.f35565b = zzvVar.f35680b;
            zztVar.f35566c = zzgtd.r(zzvVar.f35681c);
            zztVar.f35567d = zzvVar.f35682d;
            zztVar.f35568e = zzvVar.f35683e;
            zztVar.f35569f = zzvVar.f35684f;
            zztVar.D = mediaFormat.getInteger("channel-count");
            zztVar.E = mediaFormat.getInteger("sample-rate");
            zzvVar = new zzv(zztVar);
            if (this.n1) {
                int i2 = zzvVar.E;
                if (i2 == 3) {
                    iArr = new int[]{0, 2, 1};
                } else if (i2 == 5) {
                    iArr = new int[]{0, 2, 1, 3, 4};
                } else if (i2 == 6) {
                    iArr = new int[]{0, 2, 1, 5, 3, 4};
                } else if (i2 == 7) {
                    iArr = new int[]{0, 2, 1, 6, 5, 3, 4};
                } else if (i2 == 8) {
                    iArr = new int[]{0, 2, 1, 7, 5, 6, 3, 4};
                }
            }
        }
        try {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 29) {
                if (this.N0) {
                    E();
                }
                if (i3 < 29) {
                    z = false;
                }
                zzgqa.f(z);
            }
            this.k1.p(zzvVar, iArr);
        } catch (zzra e2) {
            throw F(e2, e2.f35421a, false, 5001);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final void i0() {
        this.k1.C = true;
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final boolean j0(long j2, long j3, zzug zzugVar, ByteBuffer byteBuffer, int i2, int i3, int i4, long j4, boolean z, boolean z2, zzv zzvVar) throws zzit {
        byteBuffer.getClass();
        this.w1 = -9223372036854775807L;
        if (this.p1 != null && (i3 & 2) != 0) {
            zzugVar.getClass();
            zzugVar.l(i2);
            return true;
        }
        zzss zzssVar = this.k1;
        if (z) {
            if (zzugVar != null) {
                zzugVar.l(i2);
            }
            this.b1.f34916f += i4;
            zzssVar.C = true;
            return true;
        }
        try {
            if (!zzssVar.r(byteBuffer, i4, j4)) {
                this.w1 = j4;
                return false;
            }
            if (zzugVar != null) {
                zzugVar.l(i2);
            }
            this.b1.f34915e += i4;
            return true;
        } catch (zzrb e2) {
            zzv zzvVar2 = this.o1;
            if (this.N0) {
                E();
            }
            throw F(e2, zzvVar2, false, 5001);
        } catch (zzre e3) {
            if (this.N0) {
                E();
            }
            throw F(e3, zzvVar, e3.f35423b, 5002);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final void k0() throws zzit {
        try {
            zzss zzssVar = this.k1;
            if (!zzssVar.J && zzssVar.k() && zzssVar.f()) {
                if (!zzssVar.K) {
                    zzssVar.K = true;
                    if (zzssVar.r.zzg()) {
                        zzssVar.L = false;
                    }
                    zzssVar.r.zzd();
                }
                zzssVar.J = true;
            }
            long j2 = this.c1.f35669e;
            if (j2 != -9223372036854775807L) {
                this.w1 = j2;
            }
        } catch (zzre e2) {
            throw F(e2, e2.f35424c, e2.f35423b, true != this.N0 ? 5002 : 5003);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuq
    public final void l0(zzih zzihVar) {
        zzv zzvVar;
        if (Build.VERSION.SDK_INT < 29 || (zzvVar = zzihVar.f34827b) == null || !Objects.equals(zzvVar.f35691m, "audio/opus") || !this.N0) {
            return;
        }
        ByteBuffer byteBuffer = zzihVar.f34832g;
        byteBuffer.getClass();
        zzihVar.f34827b.getClass();
        if (byteBuffer.remaining() == 8) {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong();
            zzpz zzpzVar = this.k1.r;
            if (zzpzVar != null) {
                zzpzVar.zzg();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlj
    public final void s(zzav zzavVar) {
        zzss zzssVar = this.k1;
        zzssVar.getClass();
        float f2 = zzavVar.f24412a;
        String str = zzfj.f31254a;
        zzssVar.v = new zzav(Math.max(0.1f, Math.min(f2, 8.0f)), Math.max(0.1f, Math.min(zzavVar.f24413b, 8.0f)));
        zzsq zzsqVar = new zzsq(zzavVar, -9223372036854775807L, -9223372036854775807L);
        if (zzssVar.k()) {
            zzssVar.t = zzsqVar;
        } else {
            zzssVar.u = zzsqVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuq, com.google.android.gms.internal.ads.zzmi
    public final boolean t() {
        if (!this.Z0) {
            return false;
        }
        zzss zzssVar = this.k1;
        if (zzssVar.k()) {
            return zzssVar.J && !zzssVar.s();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x003d  */
    @Override // com.google.android.gms.internal.ads.zzuq, com.google.android.gms.internal.ads.zzij, com.google.android.gms.internal.ads.zzmd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(int r9, java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsw.u(int, java.lang.Object):void");
    }

    public final void w0() {
        long jMax;
        ArrayDeque arrayDeque;
        long j2;
        t();
        final zzss zzssVar = this.k1;
        if (!zzssVar.k() || zzssVar.D) {
            jMax = Long.MIN_VALUE;
        } else {
            long jMin = Math.min(zzssVar.r.zzk(), zzfj.t(zzssVar.o.f35525e.f35393b, zzssVar.l()));
            while (true) {
                arrayDeque = zzssVar.f35546h;
                if (arrayDeque.isEmpty() || jMin < ((zzsq) arrayDeque.getFirst()).f35534c) {
                    break;
                } else {
                    zzssVar.u = (zzsq) arrayDeque.remove();
                }
            }
            zzsq zzsqVar = zzssVar.u;
            long jU = jMin - zzsqVar.f35534c;
            long jW = zzfj.w(jU, zzsqVar.f35532a.f24412a);
            boolean zIsEmpty = arrayDeque.isEmpty();
            zzsn zzsnVar = zzssVar.W;
            if (zIsEmpty) {
                zzcu zzcuVar = zzsnVar.f35529c;
                if (zzcuVar.zzc()) {
                    if (zzcuVar.n >= 1024) {
                        long j3 = zzcuVar.f27153m;
                        zzcuVar.f27150j.getClass();
                        long jZza = j3 - ((r12.f27091j * r12.f27083b) * r12.f27090i.zza());
                        int i2 = zzcuVar.f27148h.f26485a;
                        int i3 = zzcuVar.f27147g.f26485a;
                        jU = i2 == i3 ? zzfj.u(jU, jZza, zzcuVar.n, RoundingMode.DOWN) : zzfj.u(jU, jZza * i2, zzcuVar.n * i3, RoundingMode.DOWN);
                    } else {
                        jU = (long) (zzcuVar.f27143c * jU);
                    }
                }
                zzsq zzsqVar2 = zzssVar.u;
                j2 = zzsqVar2.f35533b + jU;
                zzsqVar2.f35535d = jU - jW;
            } else {
                zzsq zzsqVar3 = zzssVar.u;
                j2 = zzsqVar3.f35533b + jW + zzsqVar3.f35535d;
            }
            long j4 = zzsnVar.f35528b.f35561l;
            jMax = zzfj.t(zzssVar.o.f35525e.f35393b, j4) + j2;
            long j5 = zzssVar.T;
            if (j4 > j5) {
                long jT = zzfj.t(zzssVar.o.f35525e.f35393b, j4 - j5);
                zzssVar.T = j4;
                zzssVar.U += jT;
                if (zzssVar.V == null) {
                    zzssVar.V = new Handler(Looper.myLooper());
                }
                zzssVar.V.removeCallbacksAndMessages(null);
                zzssVar.V.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzsp
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzss zzssVar2 = zzssVar;
                        if (zzssVar2.U >= 300000) {
                            ((zzsv) zzssVar2.f35551m).f35552a.t1 = true;
                            zzssVar2.U = 0L;
                        }
                    }
                }, 100L);
            }
        }
        if (jMax != Long.MIN_VALUE) {
            if (!this.r1) {
                jMax = Math.max(this.q1, jMax);
            }
            this.q1 = jMax;
            this.r1 = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuq, com.google.android.gms.internal.ads.zzij
    public final void y(long j2, boolean z, boolean z2) {
        super.y(j2, z, z2);
        this.k1.a();
        this.q1 = j2;
        this.w1 = -9223372036854775807L;
        this.t1 = false;
        this.r1 = true;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public final void z() {
        this.k1.q();
        this.v1 = true;
    }

    @Override // com.google.android.gms.internal.ads.zzij, com.google.android.gms.internal.ads.zzmi
    public final zzlj zzd() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzlj
    public final long zzg() {
        if (this.f34886h == 2) {
            w0();
        }
        return this.q1;
    }

    @Override // com.google.android.gms.internal.ads.zzlj
    public final boolean zzh() {
        boolean z = this.t1;
        this.t1 = false;
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzlj
    public final zzav zzj() {
        return this.k1.v;
    }
}
