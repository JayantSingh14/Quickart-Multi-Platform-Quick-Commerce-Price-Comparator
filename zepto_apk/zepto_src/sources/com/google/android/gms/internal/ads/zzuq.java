package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.xbill.DNS.Flags;

/* loaded from: classes4.dex */
public abstract class zzuq extends zzij {
    public static final byte[] i1 = {0, 0, 1, 103, 66, -64, Flags.CD, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    public final ArrayDeque A;
    public zzum A0;
    public final zzsx B;
    public zzuj B0;
    public final AtomicInteger C;
    public int C0;
    public zzv D;
    public boolean D0;
    public zzv E;
    public boolean E0;
    public zztd F;
    public boolean F0;
    public zztd G;
    public boolean G0;
    public zzmh H;
    public long H0;
    public final long I;
    public long I0;
    public float J;
    public int J0;
    public float K;
    public int K0;
    public zzug L;
    public ByteBuffer L0;
    public zzv M;
    public boolean M0;
    public boolean N0;
    public boolean O0;
    public boolean P0;
    public MediaFormat Q;
    public boolean Q0;
    public int R0;
    public int S0;
    public int T0;
    public boolean U0;
    public boolean V0;
    public boolean W0;
    public boolean X;
    public long X0;
    public float Y;
    public boolean Y0;
    public ArrayDeque Z;
    public boolean Z0;
    public boolean a1;
    public zzik b1;
    public zzup c1;
    public long d1;
    public boolean e1;
    public boolean f1;
    public boolean g1;
    public long h1;
    public final zzty s;
    public final zzus t;
    public final float u;
    public final zzih v;
    public final zzih w;
    public final zzih x;
    public final zztx y;
    public final MediaCodec.BufferInfo z;

    public zzuq(int i2, zzty zztyVar, zzus zzusVar, float f2) {
        super(i2);
        this.s = zztyVar;
        zzusVar.getClass();
        this.t = zzusVar;
        this.u = f2;
        this.C = new AtomicInteger();
        this.v = new zzih(0);
        this.w = new zzih(0);
        this.x = new zzih(2);
        zztx zztxVar = new zztx();
        this.y = zztxVar;
        this.z = new MediaCodec.BufferInfo();
        this.J = 1.0f;
        this.K = 1.0f;
        this.I = -9223372036854775807L;
        this.A = new ArrayDeque();
        this.c1 = zzup.f35664f;
        zztxVar.d(0);
        zztxVar.f34829d.order(ByteOrder.nativeOrder());
        this.B = new zzsx();
        this.Y = -1.0f;
        this.C0 = 0;
        this.R0 = 0;
        this.J0 = -1;
        this.K0 = -1;
        this.I0 = -9223372036854775807L;
        this.X0 = -9223372036854775807L;
        this.d1 = -9223372036854775807L;
        this.H0 = -9223372036854775807L;
        this.S0 = 0;
        this.T0 = 0;
        this.b1 = new zzik();
        this.g1 = false;
        this.h1 = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public void B() {
        this.D = null;
        t0(zzup.f35664f);
        this.A.clear();
        if (this.N0) {
            this.N0 = false;
            m0();
        } else {
            if (this.L == null) {
                return;
            }
            if (M()) {
                L();
            } else if (N()) {
                n0();
            } else {
                this.g1 = true;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public void C() {
        try {
            this.N0 = false;
            m0();
            L();
        } finally {
            this.G = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public void H(boolean z, boolean z2) {
        this.b1 = new zzik();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        if (r4 >= r0) goto L16;
     */
    @Override // com.google.android.gms.internal.ads.zzij
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void I(com.google.android.gms.internal.ads.zzv[] r12, long r13, long r15, com.google.android.gms.internal.ads.zzwg r17) {
        /*
            r11 = this;
            com.google.android.gms.internal.ads.zzup r12 = r11.c1
            long r0 = r12.f35667c
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 != 0) goto L24
            com.google.android.gms.internal.ads.zzup r4 = new com.google.android.gms.internal.ads.zzup
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = r13
            r9 = r15
            r4.<init>(r5, r7, r9)
            r11.t0(r4)
            boolean r12 = r11.f1
            if (r12 == 0) goto L56
            r11.i0()
            return
        L24:
            java.util.ArrayDeque r12 = r11.A
            boolean r0 = r12.isEmpty()
            if (r0 == 0) goto L57
            long r0 = r11.X0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L3c
            long r4 = r11.d1
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 == 0) goto L57
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 < 0) goto L57
        L3c:
            com.google.android.gms.internal.ads.zzup r4 = new com.google.android.gms.internal.ads.zzup
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = r13
            r9 = r15
            r4.<init>(r5, r7, r9)
            r11.t0(r4)
            com.google.android.gms.internal.ads.zzup r12 = r11.c1
            long r12 = r12.f35667c
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 == 0) goto L56
            r11.i0()
        L56:
            return
        L57:
            com.google.android.gms.internal.ads.zzup r0 = new com.google.android.gms.internal.ads.zzup
            long r1 = r11.X0
            r3 = r13
            r5 = r15
            r0.<init>(r1, r3, r5)
            r12.add(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzuq.I(com.google.android.gms.internal.ads.zzv[], long, long, com.google.android.gms.internal.ads.zzwg):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0225 A[Catch: Exception -> 0x0256, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x0256, blocks: (B:87:0x0143, B:142:0x0225), top: B:205:0x0143 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02a6 A[Catch: zzum -> 0x02c1, TryCatch #11 {zzum -> 0x02c1, blocks: (B:168:0x0278, B:170:0x02a6, B:172:0x02b1, B:174:0x02be, B:178:0x02d8, B:181:0x02e0, B:182:0x02e2, B:177:0x02c3, B:184:0x02e6, B:185:0x02e7, B:187:0x02f4, B:188:0x02f5, B:189:0x0302, B:191:0x0308), top: B:214:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02be A[Catch: zzum -> 0x02c1, TryCatch #11 {zzum -> 0x02c1, blocks: (B:168:0x0278, B:170:0x02a6, B:172:0x02b1, B:174:0x02be, B:178:0x02d8, B:181:0x02e0, B:182:0x02e2, B:177:0x02c3, B:184:0x02e6, B:185:0x02e7, B:187:0x02f4, B:188:0x02f5, B:189:0x0302, B:191:0x0308), top: B:214:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02c3 A[Catch: zzum -> 0x02c1, TryCatch #11 {zzum -> 0x02c1, blocks: (B:168:0x0278, B:170:0x02a6, B:172:0x02b1, B:174:0x02be, B:178:0x02d8, B:181:0x02e0, B:182:0x02e2, B:177:0x02c3, B:184:0x02e6, B:185:0x02e7, B:187:0x02f4, B:188:0x02f5, B:189:0x0302, B:191:0x0308), top: B:214:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0258 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02e0 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r17v0, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v12 */
    /* JADX WARN: Type inference failed for: r17v13 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r17v6, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r17v7 */
    /* JADX WARN: Type inference failed for: r17v8 */
    /* JADX WARN: Type inference failed for: r17v9, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r20v3, types: [java.util.ArrayDeque] */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v39 */
    /* JADX WARN: Type inference failed for: r7v40 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void J() {
        /*
            Method dump skipped, instructions count: 786
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzuq.J():void");
    }

    public boolean K(zzuj zzujVar) {
        return true;
    }

    public final void L() {
        try {
            zzug zzugVar = this.L;
            if (zzugVar != null) {
                zzugVar.zzl();
                this.b1.f34912b++;
                zzuj zzujVar = this.B0;
                if (zzujVar == null) {
                    throw null;
                }
                e0(zzujVar.f35645a);
            }
            this.L = null;
            this.F = null;
            P();
        } catch (Throwable th) {
            this.L = null;
            this.F = null;
            P();
            throw th;
        }
    }

    public boolean M() {
        int i2 = this.T0;
        if (i2 == 3 || (this.D0 && !this.W0)) {
            return true;
        }
        if (i2 == 2) {
            try {
                zztd zztdVar = this.G;
                zztdVar.getClass();
                this.F = zztdVar;
                this.S0 = 0;
                this.T0 = 0;
            } catch (zzit e2) {
                zzee.d("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e2);
                return true;
            }
        }
        return false;
    }

    public boolean N() {
        return true;
    }

    public void O() {
        this.J0 = -1;
        this.w.f34829d = null;
        this.K0 = -1;
        this.L0 = null;
        this.X0 = -9223372036854775807L;
        u0().f35669e = -9223372036854775807L;
        this.d1 = -9223372036854775807L;
        this.I0 = -9223372036854775807L;
        this.V0 = false;
        this.H0 = -9223372036854775807L;
        this.U0 = false;
        this.E0 = false;
        this.F0 = false;
        this.M0 = false;
        this.S0 = 0;
        this.T0 = 0;
        this.R0 = this.Q0 ? 1 : 0;
        this.g1 = false;
        this.h1 = 0L;
    }

    public final void P() {
        O();
        this.Z = null;
        this.B0 = null;
        this.M = null;
        this.Q = null;
        this.X = false;
        this.W0 = false;
        this.Y = -1.0f;
        this.C0 = 0;
        this.D0 = false;
        this.G0 = false;
        this.Q0 = false;
        this.R0 = 0;
    }

    public zzui Q(IllegalStateException illegalStateException, zzuj zzujVar) {
        return new zzui(illegalStateException, zzujVar);
    }

    public void S(zzih zzihVar) {
    }

    public int T(zzih zzihVar) {
        return 0;
    }

    public boolean U(zzih zzihVar) {
        return false;
    }

    public void V(long j2) {
        this.d1 = j2;
        while (true) {
            ArrayDeque arrayDeque = this.A;
            if (arrayDeque.isEmpty() || j2 < ((zzup) arrayDeque.peek()).f35665a) {
                return;
            }
            zzup zzupVar = (zzup) arrayDeque.poll();
            zzupVar.getClass();
            t0(zzupVar);
            i0();
        }
    }

    public abstract int W(zzus zzusVar, zzv zzvVar);

    public abstract ArrayList X(zzus zzusVar, zzv zzvVar);

    public boolean Y(zzv zzvVar) {
        return false;
    }

    public abstract zzud Z(zzuj zzujVar, zzv zzvVar, float f2);

    public zzil a0(zzuj zzujVar, zzv zzvVar, zzv zzvVar2) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzmk
    public final int b(zzv zzvVar) throws zzit {
        try {
            return W(this.t, zzvVar);
        } catch (zzuu e2) {
            throw F(e2, zzvVar, false, 4002);
        }
    }

    public long b0(long j2, long j3) {
        return super.i(j2, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzij, com.google.android.gms.internal.ads.zzmk
    public final int c() {
        return 8;
    }

    public float c0(float f2, zzv zzvVar, zzv[] zzvVarArr) {
        throw null;
    }

    public void d0(long j2, long j3, String str) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzmi
    public boolean e() {
        throw null;
    }

    public void e0(String str) {
        throw null;
    }

    public void f0(Exception exc) {
        throw null;
    }

    public zzil g0(zzle zzleVar) {
        int i2;
        boolean z = true;
        this.a1 = true;
        zzv zzvVar = zzleVar.f35082b;
        zzvVar.getClass();
        String str = zzvVar.f35691m;
        if (str == null) {
            throw F(new IllegalArgumentException("Sample MIME type is null."), zzvVar, false, 4005);
        }
        if ((str.equals("video/av01") || str.equals("video/x-vnd.on2.vp9")) && !zzvVar.p.isEmpty()) {
            zzt zztVar = new zzt(zzvVar);
            zztVar.o = null;
            zzvVar = new zzv(zztVar);
        }
        zzv zzvVar2 = zzvVar;
        this.G = zzleVar.f35081a;
        this.D = zzvVar2;
        if (this.N0) {
            this.P0 = true;
            return null;
        }
        zzug zzugVar = this.L;
        if (zzugVar == null) {
            this.Z = null;
            J();
            return null;
        }
        zzuj zzujVar = this.B0;
        zzujVar.getClass();
        zzv zzvVar3 = this.M;
        zzvVar3.getClass();
        zztd zztdVar = this.F;
        zztd zztdVar2 = this.G;
        if (zztdVar != zztdVar2) {
            r0();
            return new zzil(zzujVar.f35645a, zzvVar3, zzvVar2, 0, 128);
        }
        zzil zzilVarA0 = a0(zzujVar, zzvVar3, zzvVar2);
        int i3 = zzilVarA0.f34926d;
        if (i3 != 0) {
            if (i3 == 1) {
                if (p0(zzvVar2)) {
                    this.M = zzvVar2;
                    if (zztdVar2 != zztdVar) {
                        q0();
                    } else if (this.U0) {
                        this.S0 = 1;
                        this.T0 = 1;
                    }
                }
                i2 = 16;
            } else if (i3 != 2) {
                if (p0(zzvVar2)) {
                    this.M = zzvVar2;
                    if (zztdVar2 != zztdVar) {
                        q0();
                    }
                }
                i2 = 16;
            } else {
                if (p0(zzvVar2)) {
                    this.Q0 = true;
                    this.R0 = 1;
                    int i4 = this.C0;
                    if (i4 != 2 && (i4 != 1 || zzvVar2.t != zzvVar3.t || zzvVar2.u != zzvVar3.u)) {
                        z = false;
                    }
                    this.E0 = z;
                    this.M = zzvVar2;
                    if (zztdVar2 != zztdVar) {
                        q0();
                    }
                }
                i2 = 16;
            }
            return (i3 != 0 || (this.L == zzugVar && this.T0 != 3)) ? zzilVarA0 : new zzil(zzujVar.f35645a, zzvVar3, zzvVar2, 0, i2);
        }
        r0();
        i2 = 0;
        if (i3 != 0) {
        }
    }

    public void h0(zzv zzvVar, MediaFormat mediaFormat) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzmi
    public final long i(long j2, long j3) {
        return b0(j2, j3);
    }

    public abstract boolean j0(long j2, long j3, zzug zzugVar, ByteBuffer byteBuffer, int i2, int i3, int i4, long j4, boolean z, boolean z2, zzv zzvVar);

    public void k0() {
        throw null;
    }

    public void l0(zzih zzihVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzmi
    public void m(float f2, float f3) {
        this.J = f2;
        this.K = f3;
        p0(this.M);
    }

    public final void m0() {
        this.X0 = -9223372036854775807L;
        u0().f35669e = -9223372036854775807L;
        this.d1 = -9223372036854775807L;
        this.P0 = false;
        this.y.c();
        this.x.c();
        this.O0 = false;
        zzsx zzsxVar = this.B;
        zzsxVar.getClass();
        zzsxVar.f35555a = zzco.f26781a;
        zzsxVar.f35557c = 0;
        zzsxVar.f35556b = 2;
    }

    public final void n0() {
        try {
            zzug zzugVar = this.L;
            if (zzugVar == null) {
                throw null;
            }
            zzugVar.zzk();
        } finally {
            O();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0089, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01f1 A[Catch: IllegalStateException -> 0x00b0, CryptoException -> 0x00b4, TryCatch #0 {IllegalStateException -> 0x00b0, blocks: (B:132:0x023c, B:48:0x00ad, B:58:0x00bf, B:60:0x00c3, B:62:0x00c9, B:66:0x00e6, B:67:0x00f5, B:71:0x0102, B:73:0x0108, B:122:0x021a, B:124:0x0220, B:125:0x0223, B:127:0x0229, B:129:0x022d, B:75:0x011a, B:77:0x0121, B:78:0x0135, B:80:0x0145, B:84:0x0154, B:85:0x015c, B:88:0x0162, B:90:0x0166, B:92:0x0170, B:94:0x017a, B:95:0x01a2, B:96:0x01aa, B:97:0x01ab, B:99:0x01b2, B:101:0x01ba, B:103:0x01c2, B:104:0x01c9, B:109:0x01dc, B:111:0x01ea, B:116:0x0201, B:120:0x020c, B:114:0x01f1, B:121:0x020f, B:137:0x024a, B:139:0x0257, B:140:0x0265, B:142:0x0269, B:152:0x0283, B:154:0x0289, B:156:0x0291, B:158:0x029b, B:160:0x02a3, B:162:0x02af, B:163:0x02b4, B:164:0x02b5, B:166:0x02b9, B:168:0x02bd, B:170:0x02c1, B:171:0x02c4, B:173:0x02ca, B:175:0x02db), top: B:406:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0208 A[LOOP:4: B:67:0x00f5->B:119:0x0208, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x03f9 A[Catch: CryptoException -> 0x0010, IllegalStateException -> 0x0085, TryCatch #1 {CryptoException -> 0x0010, blocks: (B:3:0x0003, B:5:0x0007, B:12:0x0014, B:14:0x0019, B:16:0x001f, B:23:0x0045, B:25:0x0067, B:27:0x007b, B:38:0x0098, B:33:0x008d, B:238:0x03f3, B:240:0x03f9, B:249:0x0422, B:251:0x0426, B:253:0x042b, B:257:0x0433, B:259:0x0437, B:261:0x043f, B:263:0x044d, B:266:0x0452, B:268:0x0456, B:269:0x0465, B:270:0x0468, B:223:0x03be, B:225:0x03c4, B:230:0x03d4, B:232:0x03d8, B:234:0x03dc, B:235:0x03e7, B:237:0x03ef), top: B:407:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x040f A[LOOP:0: B:140:0x0265->B:247:0x040f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0620 A[LOOP:1: B:249:0x0422->B:372:0x0620, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0657  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0671  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x067c  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x067f  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x068e  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x0691  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x040e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:436:0x0628 A[EDGE_INSN: B:436:0x0628->B:374:0x0628 BREAK  A[LOOP:1: B:249:0x0422->B:372:0x0620], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:458:0x0207 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0162 A[Catch: IllegalStateException -> 0x00b0, CryptoException -> 0x00b4, TRY_ENTER, TryCatch #0 {IllegalStateException -> 0x00b0, blocks: (B:132:0x023c, B:48:0x00ad, B:58:0x00bf, B:60:0x00c3, B:62:0x00c9, B:66:0x00e6, B:67:0x00f5, B:71:0x0102, B:73:0x0108, B:122:0x021a, B:124:0x0220, B:125:0x0223, B:127:0x0229, B:129:0x022d, B:75:0x011a, B:77:0x0121, B:78:0x0135, B:80:0x0145, B:84:0x0154, B:85:0x015c, B:88:0x0162, B:90:0x0166, B:92:0x0170, B:94:0x017a, B:95:0x01a2, B:96:0x01aa, B:97:0x01ab, B:99:0x01b2, B:101:0x01ba, B:103:0x01c2, B:104:0x01c9, B:109:0x01dc, B:111:0x01ea, B:116:0x0201, B:120:0x020c, B:114:0x01f1, B:121:0x020f, B:137:0x024a, B:139:0x0257, B:140:0x0265, B:142:0x0269, B:152:0x0283, B:154:0x0289, B:156:0x0291, B:158:0x029b, B:160:0x02a3, B:162:0x02af, B:163:0x02b4, B:164:0x02b5, B:166:0x02b9, B:168:0x02bd, B:170:0x02c1, B:171:0x02c4, B:173:0x02ca, B:175:0x02db), top: B:406:0x002f }] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v39 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v46 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v21, types: [com.google.android.gms.internal.ads.zztd, com.google.android.gms.internal.ads.zzv, java.lang.Throwable, java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v30 */
    /* JADX WARN: Type inference failed for: r13v31 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [android.media.MediaFormat, com.google.android.gms.internal.ads.zztd, com.google.android.gms.internal.ads.zzv, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r31v0, types: [com.google.android.gms.internal.ads.zzij, com.google.android.gms.internal.ads.zzuq] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    @Override // com.google.android.gms.internal.ads.zzmi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void o(long r32, long r34) {
        /*
            Method dump skipped, instructions count: 1706
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzuq.o(long, long):void");
    }

    public final boolean o0(int i2) {
        zzle zzleVar = this.f34881c;
        zzleVar.f35081a = null;
        zzleVar.f35082b = null;
        zzih zzihVar = this.v;
        zzihVar.c();
        int iG = G(zzleVar, zzihVar, i2 | 4);
        if (iG == -5) {
            g0(zzleVar);
            return true;
        }
        if (iG != -4 || !zzihVar.b(4)) {
            return false;
        }
        this.Y0 = true;
        s0();
        return false;
    }

    public final boolean p0(zzv zzvVar) {
        if (this.L != null && this.T0 != 3 && this.f34886h != 0) {
            float f2 = this.K;
            zzvVar.getClass();
            zzv[] zzvVarArr = this.f34888j;
            zzvVarArr.getClass();
            float fC0 = c0(f2, zzvVar, zzvVarArr);
            float f3 = this.Y;
            if (f3 != fC0) {
                if (fC0 == -1.0f) {
                    r0();
                    return false;
                }
                if (f3 != -1.0f || fC0 > this.u) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("operating-rate", fC0);
                    zzug zzugVar = this.L;
                    zzugVar.getClass();
                    zzugVar.c0(bundle);
                    this.Y = fC0;
                }
            }
        }
        return true;
    }

    public final boolean q0() {
        if (this.U0) {
            this.S0 = 1;
            this.T0 = 2;
            return true;
        }
        zztd zztdVar = this.G;
        zztdVar.getClass();
        this.F = zztdVar;
        this.S0 = 0;
        this.T0 = 0;
        return true;
    }

    public final void r0() {
        if (this.U0) {
            this.S0 = 1;
            this.T0 = 3;
        } else {
            L();
            J();
        }
    }

    public final void s0() {
        int i2 = this.T0;
        if (i2 == 1) {
            n0();
            return;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                this.Z0 = true;
                k0();
                return;
            } else {
                L();
                J();
                return;
            }
        }
        n0();
        zztd zztdVar = this.G;
        zztdVar.getClass();
        this.F = zztdVar;
        this.S0 = 0;
        this.T0 = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzmi
    public boolean t() {
        return this.Z0;
    }

    public final void t0(zzup zzupVar) {
        this.c1 = zzupVar;
        if (zzupVar.f35667c != -9223372036854775807L) {
            this.e1 = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzij, com.google.android.gms.internal.ads.zzmd
    public void u(int i2, Object obj) {
        if (i2 == 11) {
            zzmh zzmhVar = (zzmh) obj;
            zzmhVar.getClass();
            this.H = zzmhVar;
        }
    }

    public final zzup u0() {
        ArrayDeque arrayDeque = this.A;
        return !arrayDeque.isEmpty() ? (zzup) arrayDeque.getLast() : this.c1;
    }

    public final boolean v0(long j2, long j3) {
        if (j3 >= j2) {
            return false;
        }
        zzv zzvVar = this.E;
        return zzvVar == null || !Objects.equals(zzvVar.f35691m, "audio/opus") || j2 - j3 > 80000;
    }

    @Override // com.google.android.gms.internal.ads.zzij
    public void y(long j2, boolean z, boolean z2) {
        ArrayDeque arrayDeque = this.A;
        if (!arrayDeque.isEmpty()) {
            this.c1 = (zzup) arrayDeque.getLast();
        }
        arrayDeque.clear();
        if (z2) {
            this.Y0 = false;
            this.Z0 = false;
            if (this.N0) {
                m0();
            } else if (this.L != null) {
                if (M()) {
                    L();
                    J();
                } else if (N()) {
                    n0();
                } else {
                    this.g1 = true;
                }
            }
            zzff zzffVar = this.c1.f35668d;
            if (zzffVar.b() > 0) {
                this.a1 = true;
            }
            synchronized (zzffVar) {
                zzffVar.f30998c = 0;
                zzffVar.f30999d = 0;
                Arrays.fill(zzffVar.f30997b, (Object) null);
            }
        }
    }

    public void i0() {
    }

    public void R(zzv zzvVar) {
    }
}
