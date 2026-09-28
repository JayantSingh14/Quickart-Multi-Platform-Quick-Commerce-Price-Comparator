package com.google.android.gms.internal.ads;

import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.common.api.Api;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzakh implements zzaeo {
    public static final byte[] L = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    public static final zzv M;
    public zzakg A;
    public int B;
    public int C;
    public int D;
    public boolean E;
    public boolean F;
    public zzaer G;
    public zzaga[] H;
    public zzaga[] I;
    public boolean J;
    public long K;

    /* renamed from: a, reason: collision with root package name */
    public final zzalw f23359a;

    /* renamed from: b, reason: collision with root package name */
    public final int f23360b;

    /* renamed from: c, reason: collision with root package name */
    public final List f23361c;

    /* renamed from: d, reason: collision with root package name */
    public final SparseArray f23362d;

    /* renamed from: e, reason: collision with root package name */
    public final zzer f23363e;

    /* renamed from: f, reason: collision with root package name */
    public final zzer f23364f;

    /* renamed from: g, reason: collision with root package name */
    public final zzer f23365g;

    /* renamed from: h, reason: collision with root package name */
    public final byte[] f23366h;

    /* renamed from: i, reason: collision with root package name */
    public final zzer f23367i;

    /* renamed from: j, reason: collision with root package name */
    public final zzahs f23368j;

    /* renamed from: k, reason: collision with root package name */
    public final zzer f23369k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayDeque f23370l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayDeque f23371m;
    public final zzgq n;
    public final zzaed o;
    public zzgtd p;
    public int q;
    public int r;
    public long s;
    public int t;
    public zzer u;
    public long v;
    public int w;
    public long x;
    public long y;
    public long z;

    static {
        zzt zztVar = new zzt();
        zztVar.e("application/x-emsg");
        M = new zzv(zztVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @Deprecated
    public zzakh() {
        zzalw zzalwVar = zzalw.f23510a;
        zzgvs zzgvsVar = zzgtd.f33183b;
        this(zzalwVar, 32, zzguy.f33232e);
    }

    public static void g(int i2) throws zzat {
        if (i2 >= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 27);
        sb.append("Unexpected negative value: ");
        sb.append(i2);
        throw zzat.a(null, sb.toString());
    }

    public static void h(zzer zzerVar, int i2, zzakx zzakxVar) throws zzat {
        zzerVar.E(i2 + 8);
        int iB = zzerVar.b();
        byte[] bArr = zzaka.f23337a;
        if ((iB & 1) != 0) {
            throw zzat.b("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (iB & 2) != 0;
        int iH = zzerVar.h();
        if (iH == 0) {
            Arrays.fill(zzakxVar.f23437l, 0, zzakxVar.f23430e, false);
            return;
        }
        int i3 = zzakxVar.f23430e;
        if (iH != i3) {
            throw zzat.a(null, androidx.fragment.app.e.n(iH, i3, "Senc sample count ", " is different from fragment sample count", new StringBuilder(String.valueOf(iH).length() + 58 + String.valueOf(i3).length())));
        }
        Arrays.fill(zzakxVar.f23437l, 0, iH, z);
        int iB2 = zzerVar.B();
        zzer zzerVar2 = zzakxVar.n;
        zzerVar2.y(iB2);
        zzakxVar.f23436k = true;
        zzakxVar.o = true;
        zzerVar.H(0, zzerVar2.f30144a, zzerVar2.f30146c);
        zzerVar2.E(0);
        zzakxVar.o = false;
    }

    public static Pair i(long j2, zzer zzerVar) throws zzat {
        long j3;
        long j4;
        zzer zzerVar2 = zzerVar;
        zzerVar2.E(8);
        int iA = zzaka.a(zzerVar2.b());
        zzerVar2.G(4);
        long jP = zzerVar2.P();
        if (iA == 0) {
            j3 = zzerVar2.P();
            j4 = zzerVar2.P();
        } else {
            j3 = zzerVar2.j();
            j4 = zzerVar2.j();
        }
        long j5 = j4 + j2;
        long jU = zzfj.u(j3, 1000000L, jP, RoundingMode.DOWN);
        zzerVar2.G(2);
        int iL = zzerVar2.L();
        int[] iArr = new int[iL];
        long[] jArr = new long[iL];
        long[] jArr2 = new long[iL];
        long[] jArr3 = new long[iL];
        long j6 = j5;
        long j7 = jU;
        int i2 = 0;
        while (i2 < iL) {
            int iB = zzerVar2.b();
            if ((Integer.MIN_VALUE & iB) != 0) {
                throw zzat.a(null, "Unhandled indirect reference");
            }
            long jP2 = zzerVar2.P();
            iArr[i2] = iB & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            jArr[i2] = j6;
            jArr3[i2] = j7;
            j3 += jP2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            long jU2 = zzfj.u(j3, 1000000L, jP, RoundingMode.DOWN);
            jArr4[i2] = jU2 - jArr5[i2];
            zzerVar2.G(4);
            j6 += iArr[i2];
            i2++;
            iL = iL;
            zzerVar2 = zzerVar;
            j7 = jU2;
            jArr2 = jArr4;
            jArr3 = jArr5;
        }
        return Pair.create(Long.valueOf(jU), new zzaec(iArr, jArr, jArr2, jArr3));
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzq j(java.util.ArrayList r18) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakh.j(java.util.ArrayList):com.google.android.gms.internal.ads.zzq");
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void a(long j2, long j3) {
        SparseArray sparseArray = this.f23362d;
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((zzakg) sparseArray.valueAt(i2)).a();
        }
        this.f23371m.clear();
        this.w = 0;
        this.n.f33065d.clear();
        this.x = j3;
        this.f23370l.clear();
        e();
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void b(zzaer zzaerVar) {
        if ((this.f23360b & 32) == 0) {
            zzaerVar = new zzalz(zzaerVar, this.f23359a);
        }
        this.G = zzaerVar;
        e();
        zzaga[] zzagaVarArr = new zzaga[2];
        this.H = zzagaVarArr;
        int i2 = 0;
        zzaga[] zzagaVarArr2 = (zzaga[]) zzfj.m(zzagaVarArr, 0);
        this.H = zzagaVarArr2;
        for (zzaga zzagaVar : zzagaVarArr2) {
            zzagaVar.c(M);
        }
        List list = this.f23361c;
        this.I = new zzaga[list.size()];
        int i3 = 100;
        while (i2 < this.I.length) {
            int i4 = i3 + 1;
            zzaga zzagaVarE = this.G.e(i3, 3);
            zzagaVarE.c((zzv) list.get(i2));
            this.I[i2] = zzagaVarE;
            i2++;
            i3 = i4;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final boolean c(zzaep zzaepVar) {
        zzgtd zzgtdVarN;
        zzafv zzafvVarA = zzaku.a(zzaepVar, true, false);
        if (zzafvVarA != null) {
            zzgtdVarN = zzgtd.n(zzafvVarA);
        } else {
            zzgvs zzgvsVar = zzgtd.f33183b;
            zzgtdVarN = zzguy.f33232e;
        }
        this.p = zzgtdVarN;
        return zzafvVarA == null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01d9, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01db, code lost:
    
        r2 = com.google.android.gms.internal.ads.zzgm.b(r8);
        r19 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01ed, code lost:
    
        if ((r9 + r2) <= (r33.B - r33.C)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01f0, code lost:
    
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01f2, code lost:
    
        r22 = r9;
        r30 = r5;
        ((com.google.android.gms.internal.ads.zzaef) r34).v(r4, r10, r9 + r2, false);
        r15.E(0);
        r3 = r15.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0206, code lost:
    
        if (r3 < 0) goto L504;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0208, code lost:
    
        r33.D = r3 - r2;
        r3 = r33.f23363e;
        r3.E(0);
        r14.b(4, r3);
        r33.C += 4;
        r33.B += r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0221, code lost:
    
        if (r33.I.length <= 0) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0223, code lost:
    
        if (r2 <= 0) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0225, code lost:
    
        r3 = r4[4];
        r5 = com.google.android.gms.internal.ads.zzgm.l(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x022f, code lost:
    
        if (java.util.Objects.equals(r5, "video/avc") == false) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0231, code lost:
    
        r18 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0236, code lost:
    
        if ((r3 & 31) == 6) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0239, code lost:
    
        r18 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0240, code lost:
    
        if (java.util.Objects.equals(r5, "video/hevc") == false) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x024a, code lost:
    
        if (((r18 & 126) >> 1) != 39) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x024c, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x024e, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0252, code lost:
    
        r33.F = r5;
        r14.b(r2, r15);
        r33.C += r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x025c, code lost:
    
        if (r2 <= 0) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0260, code lost:
    
        if (r33.E != false) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0266, code lost:
    
        if (com.google.android.gms.internal.ads.zzgm.c(r4, r2, r8) == false) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0268, code lost:
    
        r33.E = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x026b, code lost:
    
        r2 = r17;
        r3 = r19;
        r9 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0271, code lost:
    
        r5 = r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x027c, code lost:
    
        throw com.google.android.gms.internal.ads.zzat.a(null, "Invalid NAL length");
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x027d, code lost:
    
        r19 = r3;
        r30 = r5;
        r22 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0286, code lost:
    
        if (r33.F == false) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0288, code lost:
    
        r5 = r33.f23365g;
        r5.y(r2);
        r23 = r4;
        ((com.google.android.gms.internal.ads.zzaef) r34).v(r5.f30144a, 0, r33.D, false);
        r14.b(r33.D, r5);
        r2 = r33.D;
        r3 = com.google.android.gms.internal.ads.zzgm.a(r5.f30146c, r5.f30144a);
        r5.E(0);
        r5.C(r3);
        r3 = r8.o;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x02b2, code lost:
    
        if (r3 != (-1)) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x02b6, code lost:
    
        if (r13.f33066e == 0) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x02b8, code lost:
    
        r13.a(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x02be, code lost:
    
        if (r13.f33066e == r3) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x02c0, code lost:
    
        r13.a(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x02c3, code lost:
    
        r13.b(r11, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x02cf, code lost:
    
        if ((r17.b() & 4) == 0) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02d1, code lost:
    
        r13.c(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x02d5, code lost:
    
        r23 = r4;
        r2 = r14.f(r34, r2, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02de, code lost:
    
        r33.C += r2;
        r33.D -= r2;
        r2 = r17;
        r3 = r19;
        r9 = r22;
        r4 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x02f1, code lost:
    
        r0 = r17.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x02f7, code lost:
    
        if (r33.E != false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x02f9, code lost:
    
        r0 = r0 | 67108864;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x02fc, code lost:
    
        r25 = r0;
        r0 = r17.e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0302, code lost:
    
        if (r0 == null) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0304, code lost:
    
        r28 = r0.f23423c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0309, code lost:
    
        r28 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x030b, code lost:
    
        r23 = r11;
        r14.e(r23, r25, r33.B, 0, r28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x031c, code lost:
    
        if (r30.isEmpty() != false) goto L499;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x031e, code lost:
    
        r0 = (com.google.android.gms.internal.ads.zzakf) r30.removeFirst();
        r2 = r33.w;
        r7 = r0.f23345c;
        r33.w = r2 - r7;
        r2 = r0.f23344b;
        r3 = r0.f23343a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x032f, code lost:
    
        if (r2 == false) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0331, code lost:
    
        r3 = r3 + r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0333, code lost:
    
        r4 = r3;
        r0 = r33.H;
        r2 = r0.length;
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0338, code lost:
    
        if (r10 >= r2) goto L502;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x033a, code lost:
    
        r0[r10].e(r4, 1, r7, r33.w, null);
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x034a, code lost:
    
        if (r17.c() != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x034c, code lost:
    
        r33.A = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0351, code lost:
    
        r33.q = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0355, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x06d0, code lost:
    
        throw com.google.android.gms.internal.ads.zzat.b("Atom size less than header length (unsupported).");
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ba, code lost:
    
        r3 = r33.q;
        r11 = r2.f23347b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c5, code lost:
    
        if (r3 != 3) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c9, code lost:
    
        if (r2.f23358m != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00cb, code lost:
    
        r3 = r2.f23349d.f23442d[r2.f23351f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d4, code lost:
    
        r3 = r11.f23433h[r2.f23351f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00da, code lost:
    
        r33.B = r3;
        r3 = r2.f23349d.f23439a.f23415g.f35691m;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e8, code lost:
    
        if (java.util.Objects.equals(r3, "video/avc") != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ea, code lost:
    
        java.util.Objects.equals(r3, "video/hevc");
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ed, code lost:
    
        r33.E = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f4, code lost:
    
        if (r2.f23351f >= r2.f23354i) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f6, code lost:
    
        ((com.google.android.gms.internal.ads.zzaef) r34).d(r33.B, false);
        r0 = r2.e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0101, code lost:
    
        if (r0 != null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0104, code lost:
    
        r3 = r11.n;
        r0 = r0.f23424d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0108, code lost:
    
        if (r0 == 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x010a, code lost:
    
        r3.G(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x010d, code lost:
    
        r0 = r2.f23351f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0111, code lost:
    
        if (r11.f23436k == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0117, code lost:
    
        if (r11.f23437l[r0] == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0119, code lost:
    
        r3.G(r3.L() * 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0125, code lost:
    
        if (r2.c() != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0127, code lost:
    
        r33.A = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0134, code lost:
    
        if (r2.f23349d.f23439a.f23416h != 1) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0136, code lost:
    
        r33.B -= 8;
        ((com.google.android.gms.internal.ads.zzaef) r34).d(8, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0152, code lost:
    
        if ("audio/ac4".equals(r2.f23349d.f23439a.f23415g.f35691m) == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0154, code lost:
    
        r33.C = r2.d(r33.B, 7);
        com.google.android.gms.internal.ads.zzads.b(r33.B, r9);
        r2.f23346a.b(7, r9);
        r3 = r33.C + 7;
        r33.C = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x016d, code lost:
    
        r3 = r2.d(r33.B, 0);
        r33.C = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0175, code lost:
    
        r33.B += r3;
        r33.q = 4;
        r33.D = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x017e, code lost:
    
        r3 = r2.f23349d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0182, code lost:
    
        if (r2.f23358m != false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0184, code lost:
    
        r11 = r3.f23444f[r2.f23351f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x018b, code lost:
    
        r11 = r11.f23434i[r2.f23351f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0192, code lost:
    
        r3 = r3.f23439a;
        r9 = r3.f23419k;
        r14 = r2.f23346a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0198, code lost:
    
        if (r9 != 0) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x019a, code lost:
    
        r3 = r33.C;
        r4 = r33.B;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x019e, code lost:
    
        if (r3 >= r4) goto L498;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01a0, code lost:
    
        r33.C += r14.f(r34, r4 - r3, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01ab, code lost:
    
        r17 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01ad, code lost:
    
        r30 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01b1, code lost:
    
        r15 = r33.f23364f;
        r4 = r15.f30144a;
        r4[0] = 0;
        r4[1] = 0;
        r4[r18] = 0;
        r10 = 4 - r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01bf, code lost:
    
        r17 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01c5, code lost:
    
        if (r33.C >= r33.B) goto L503;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01c7, code lost:
    
        r2 = r33.D;
        r8 = r3.f23415g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01cb, code lost:
    
        if (r2 != 0) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01d0, code lost:
    
        if (r33.I.length > 0) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01d4, code lost:
    
        if (r33.E != false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01d7, code lost:
    
        r19 = r3;
     */
    @Override // com.google.android.gms.internal.ads.zzaeo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int d(com.google.android.gms.internal.ads.zzaep r34, com.google.android.gms.internal.ads.zzafo r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakh.d(com.google.android.gms.internal.ads.zzaep, com.google.android.gms.internal.ads.zzafo):int");
    }

    public final void e() {
        this.q = 0;
        this.t = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:316:0x07f8, code lost:
    
        e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x07fb, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0328  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(long r58) throws com.google.android.gms.internal.ads.zzat {
        /*
            Method dump skipped, instructions count: 2044
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakh.f(long):void");
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final /* synthetic */ List zzb() {
        return this.p;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void zzf() {
    }

    public zzakh(zzalw zzalwVar, int i2, zzgtd zzgtdVar) {
        this.f23359a = zzalwVar;
        this.f23360b = i2;
        this.f23361c = Collections.unmodifiableList(zzgtdVar);
        this.f23368j = new zzahs();
        this.f23369k = new zzer(16);
        this.f23363e = new zzer(zzgm.f32888a);
        this.f23364f = new zzer(6);
        this.f23365g = new zzer();
        byte[] bArr = new byte[16];
        this.f23366h = bArr;
        this.f23367i = new zzer(bArr);
        this.f23370l = new ArrayDeque();
        this.f23371m = new ArrayDeque();
        this.f23362d = new SparseArray();
        zzgvs zzgvsVar = zzgtd.f33183b;
        this.p = zzguy.f33232e;
        this.y = -9223372036854775807L;
        this.x = -9223372036854775807L;
        this.z = -9223372036854775807L;
        this.G = zzaer.n0;
        this.H = new zzaga[0];
        this.I = new zzaga[0];
        this.n = new zzgq(new zzgp() { // from class: com.google.android.gms.internal.ads.zzake
            @Override // com.google.android.gms.internal.ads.zzgp
            public final /* synthetic */ void a(long j2, zzer zzerVar) {
                zzaeb.a(j2, zzerVar, this.f23342a.I);
            }
        });
        this.o = new zzaed();
        this.K = -1L;
    }
}
