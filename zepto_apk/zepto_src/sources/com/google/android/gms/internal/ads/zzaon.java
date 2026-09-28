package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzaon implements zzaog {

    /* renamed from: a, reason: collision with root package name */
    public final zzapj f23926a;

    /* renamed from: e, reason: collision with root package name */
    public long f23930e;

    /* renamed from: g, reason: collision with root package name */
    public String f23932g;

    /* renamed from: h, reason: collision with root package name */
    public zzaga f23933h;

    /* renamed from: i, reason: collision with root package name */
    public zzaom f23934i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f23935j;

    /* renamed from: l, reason: collision with root package name */
    public boolean f23937l;

    /* renamed from: f, reason: collision with root package name */
    public final boolean[] f23931f = new boolean[3];

    /* renamed from: b, reason: collision with root package name */
    public final zzaox f23927b = new zzaox(7);

    /* renamed from: c, reason: collision with root package name */
    public final zzaox f23928c = new zzaox(8);

    /* renamed from: d, reason: collision with root package name */
    public final zzaox f23929d = new zzaox(6);

    /* renamed from: k, reason: collision with root package name */
    public long f23936k = -9223372036854775807L;

    /* renamed from: m, reason: collision with root package name */
    public final zzer f23938m = new zzer();

    public zzaon(zzapj zzapjVar) {
        this.f23926a = zzapjVar;
    }

    public final void a(long j2, long j3, int i2) {
        if (!this.f23935j) {
            this.f23927b.b(i2);
            this.f23928c.b(i2);
        }
        this.f23929d.b(i2);
        zzaom zzaomVar = this.f23934i;
        boolean z = this.f23937l;
        zzaomVar.f23918d = i2;
        zzaomVar.f23920f = j3;
        zzaomVar.f23919e = j2;
        zzaomVar.f23925k = z;
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void b(int i2, long j2) {
        this.f23936k = j2;
        int i3 = i2 & 2;
        this.f23937l = (i3 != 0) | this.f23937l;
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void c(boolean z) {
        this.f23933h.getClass();
        String str = zzfj.f31254a;
        if (z) {
            this.f23926a.f24070c.c(0);
            f(0, 0, this.f23930e, this.f23936k);
            a(this.f23930e, this.f23936k, 9);
            f(0, 0, this.f23930e, this.f23936k);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    @Override // com.google.android.gms.internal.ads.zzaog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(com.google.android.gms.internal.ads.zzer r14) {
        /*
            r13 = this;
            r7 = 3
            com.google.android.gms.internal.ads.zzaga r2 = r13.f23933h
            r2.getClass()
            java.lang.String r2 = com.google.android.gms.internal.ads.zzfj.f31254a
            int r2 = r14.f30145b
            int r8 = r14.f30146c
            byte[] r9 = r14.f30144a
            long r3 = r13.f23930e
            int r5 = r14.B()
            long r5 = (long) r5
            long r3 = r3 + r5
            r13.f23930e = r3
            com.google.android.gms.internal.ads.zzaga r3 = r13.f23933h
            int r4 = r14.B()
            r3.b(r4, r14)
        L21:
            boolean[] r1 = r13.f23931f
            int r1 = com.google.android.gms.internal.ads.zzgm.g(r9, r2, r8, r1)
            com.google.android.gms.internal.ads.zzaox r3 = r13.f23929d
            com.google.android.gms.internal.ads.zzaox r4 = r13.f23928c
            com.google.android.gms.internal.ads.zzaox r5 = r13.f23927b
            if (r1 == r8) goto L72
            int r6 = r1 + 3
            r6 = r9[r6]
            r10 = r6 & 31
            if (r1 <= 0) goto L41
            int r6 = r1 + (-1)
            r11 = r9[r6]
            if (r11 != 0) goto L41
            r1 = 4
            r12 = r1
            r11 = r6
            goto L43
        L41:
            r11 = r1
            r12 = r7
        L43:
            int r1 = r11 - r2
            if (r1 <= 0) goto L54
            boolean r6 = r13.f23935j
            if (r6 != 0) goto L51
            r5.c(r2, r9, r11)
            r4.c(r2, r9, r11)
        L51:
            r3.c(r2, r9, r11)
        L54:
            int r2 = r8 - r11
            long r3 = r13.f23930e
            long r5 = (long) r2
            long r3 = r3 - r5
            if (r1 >= 0) goto L5e
            int r1 = -r1
            goto L5f
        L5e:
            r1 = 0
        L5f:
            long r5 = r13.f23936k
            r0 = r2
            r2 = r1
            r1 = r0
            r0 = r13
            r0.f(r1, r2, r3, r5)
            r1 = r3
            long r3 = r13.f23936k
            r5 = r10
            r0.a(r1, r3, r5)
            int r2 = r11 + r12
            goto L21
        L72:
            boolean r1 = r13.f23935j
            if (r1 != 0) goto L7c
            r5.c(r2, r9, r8)
            r4.c(r2, r9, r8)
        L7c:
            r3.c(r2, r9, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaon.d(com.google.android.gms.internal.ads.zzer):void");
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void e(zzaer zzaerVar, zzapu zzapuVar) {
        zzapuVar.a();
        zzapuVar.b();
        this.f23932g = zzapuVar.f24112e;
        zzapuVar.b();
        zzaga zzagaVarE = zzaerVar.e(zzapuVar.f24111d, 2);
        this.f23933h = zzagaVarE;
        this.f23934i = new zzaom(zzagaVarE);
        this.f23926a.a(zzaerVar, zzapuVar);
    }

    public final void f(int i2, int i3, long j2, long j3) {
        boolean z = this.f23935j;
        boolean z2 = true;
        zzgq zzgqVar = this.f23926a.f24070c;
        if (!z) {
            zzaox zzaoxVar = this.f23927b;
            zzaoxVar.d(i3);
            zzaox zzaoxVar2 = this.f23928c;
            zzaoxVar2.d(i3);
            if (this.f23935j) {
                if (zzaoxVar.f24015c) {
                    zzgl zzglVarD = zzgm.d(4, zzaoxVar.f24016d, zzaoxVar.f24017e);
                    zzgqVar.a(zzglVarD.f32833m);
                    this.f23934i.f23916b.append(zzglVarD.f32824d, zzglVarD);
                    zzaoxVar.a();
                } else if (zzaoxVar2.f24015c) {
                    zzgn zzgnVar = new zzgn(zzaoxVar2.f24016d, 4, zzaoxVar2.f24017e);
                    int iG = zzgnVar.g();
                    zzgnVar.g();
                    zzgnVar.a();
                    zzgnVar.d();
                    this.f23934i.f23917c.append(iG, new zzgk(iG));
                    zzaoxVar2.a();
                }
            } else if (zzaoxVar.f24015c && zzaoxVar2.f24015c) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Arrays.copyOf(zzaoxVar.f24016d, zzaoxVar.f24017e));
                arrayList.add(Arrays.copyOf(zzaoxVar2.f24016d, zzaoxVar2.f24017e));
                zzgl zzglVarD2 = zzgm.d(4, zzaoxVar.f24016d, zzaoxVar.f24017e);
                zzgn zzgnVar2 = new zzgn(zzaoxVar2.f24016d, 4, zzaoxVar2.f24017e);
                int iG2 = zzgnVar2.g();
                zzgnVar2.g();
                zzgnVar2.a();
                zzgnVar2.d();
                zzgk zzgkVar = new zzgk(iG2);
                byte[] bArr = zzdo.f28067a;
                String str = String.format("avc1.%02X%02X%02X", Integer.valueOf(zzglVarD2.f32821a), Integer.valueOf(zzglVarD2.f32822b), Integer.valueOf(zzglVarD2.f32823c));
                zzaga zzagaVar = this.f23933h;
                zzt zztVar = new zzt();
                zztVar.f35564a = this.f23932g;
                zztVar.d("video/mp2t");
                zztVar.e("video/avc");
                zztVar.f35572i = str;
                zztVar.s = zzglVarD2.f32825e;
                zztVar.t = zzglVarD2.f32826f;
                zzh zzhVar = new zzh();
                zzhVar.f33411a = zzglVarD2.f32830j;
                zzhVar.f33412b = zzglVarD2.f32831k;
                zzhVar.f33413c = zzglVarD2.f32832l;
                zzhVar.f33415e = zzglVarD2.f32828h + 8;
                zzhVar.f33416f = zzglVarD2.f32829i + 8;
                zztVar.B = zzhVar.a();
                zztVar.y = zzglVarD2.f32827g;
                zztVar.o = arrayList;
                int i4 = zzglVarD2.f32833m;
                zztVar.n = i4;
                zzagaVar.c(new zzv(zztVar));
                this.f23935j = true;
                zzgqVar.a(i4);
                this.f23934i.f23916b.append(zzglVarD2.f32824d, zzglVarD2);
                this.f23934i.f23917c.append(iG2, zzgkVar);
                zzaoxVar.a();
                zzaoxVar2.a();
            }
        }
        zzaox zzaoxVar3 = this.f23929d;
        if (zzaoxVar3.d(i3)) {
            int iA = zzgm.a(zzaoxVar3.f24017e, zzaoxVar3.f24016d);
            byte[] bArr2 = zzaoxVar3.f24016d;
            zzer zzerVar = this.f23938m;
            zzerVar.z(iA, bArr2);
            zzerVar.E(4);
            zzgqVar.b(j3, zzerVar);
        }
        zzaom zzaomVar = this.f23934i;
        boolean z3 = this.f23935j;
        if (zzaomVar.f23918d == 9) {
            if (z3 && zzaomVar.f23921g) {
                long j4 = zzaomVar.f23919e;
                int i5 = i2 + ((int) (j2 - j4));
                long j5 = zzaomVar.f23923i;
                if (j5 != -9223372036854775807L) {
                    long j6 = zzaomVar.f23922h;
                    if (j4 != j6) {
                        zzaomVar.f23915a.e(j5, zzaomVar.f23924j ? 1 : 0, (int) (j4 - j6), i5, null);
                    }
                }
            }
            zzaomVar.f23922h = zzaomVar.f23919e;
            zzaomVar.f23923i = zzaomVar.f23920f;
            zzaomVar.f23924j = false;
            zzaomVar.f23921g = true;
        }
        boolean z4 = zzaomVar.f23925k;
        boolean z5 = zzaomVar.f23924j;
        int i6 = zzaomVar.f23918d;
        if (i6 != 5 && (!z4 || i6 != 1)) {
            z2 = false;
        }
        boolean z6 = z5 | z2;
        zzaomVar.f23924j = z6;
        zzaomVar.f23918d = 24;
        if (z6) {
            this.f23937l = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void zza() {
        this.f23930e = 0L;
        this.f23937l = false;
        this.f23936k = -9223372036854775807L;
        zzgm.h(this.f23931f);
        this.f23927b.a();
        this.f23928c.a();
        this.f23929d.a();
        this.f23926a.f24070c.c(0);
        zzaom zzaomVar = this.f23934i;
        if (zzaomVar != null) {
            zzaomVar.f23921g = false;
        }
    }
}
