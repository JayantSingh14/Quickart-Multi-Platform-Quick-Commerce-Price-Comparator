package com.google.android.gms.internal.ads;

import java.util.Collections;

/* loaded from: classes4.dex */
public final class zzaop implements zzaog {

    /* renamed from: a, reason: collision with root package name */
    public final zzapj f23952a;

    /* renamed from: b, reason: collision with root package name */
    public String f23953b;

    /* renamed from: c, reason: collision with root package name */
    public zzaga f23954c;

    /* renamed from: d, reason: collision with root package name */
    public zzaoo f23955d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f23956e;

    /* renamed from: l, reason: collision with root package name */
    public long f23963l;

    /* renamed from: f, reason: collision with root package name */
    public final boolean[] f23957f = new boolean[3];

    /* renamed from: g, reason: collision with root package name */
    public final zzaox f23958g = new zzaox(32);

    /* renamed from: h, reason: collision with root package name */
    public final zzaox f23959h = new zzaox(33);

    /* renamed from: i, reason: collision with root package name */
    public final zzaox f23960i = new zzaox(34);

    /* renamed from: j, reason: collision with root package name */
    public final zzaox f23961j = new zzaox(39);

    /* renamed from: k, reason: collision with root package name */
    public final zzaox f23962k = new zzaox(40);

    /* renamed from: m, reason: collision with root package name */
    public long f23964m = -9223372036854775807L;
    public final zzer n = new zzer();

    public zzaop(zzapj zzapjVar) {
        this.f23952a = zzapjVar;
    }

    public final void a(int i2, int i3, long j2, long j3) {
        zzaoo zzaooVar = this.f23955d;
        boolean z = this.f23956e;
        zzaooVar.f23945g = false;
        zzaooVar.f23946h = false;
        zzaooVar.f23943e = j3;
        zzaooVar.f23942d = 0;
        zzaooVar.f23940b = j2;
        if (i3 >= 32 && i3 != 40) {
            if (zzaooVar.f23947i && !zzaooVar.f23948j) {
                if (z) {
                    zzaooVar.a(i2);
                }
                zzaooVar.f23947i = false;
            }
            if (i3 <= 35 || i3 == 39) {
                zzaooVar.f23946h = !zzaooVar.f23948j;
                zzaooVar.f23948j = true;
            }
        }
        boolean z2 = i3 >= 16 && i3 <= 21;
        zzaooVar.f23941c = z2;
        zzaooVar.f23944f = z2 || i3 <= 9;
        if (!this.f23956e) {
            this.f23958g.b(i3);
            this.f23959h.b(i3);
            this.f23960i.b(i3);
        }
        this.f23961j.b(i3);
        this.f23962k.b(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void b(int i2, long j2) {
        this.f23964m = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void c(boolean z) {
        this.f23954c.getClass();
        String str = zzfj.f31254a;
        if (z) {
            this.f23952a.f24070c.c(0);
            g(0, 0, this.f23963l, this.f23964m);
            a(0, 48, this.f23963l, this.f23964m);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    @Override // com.google.android.gms.internal.ads.zzaog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(com.google.android.gms.internal.ads.zzer r16) {
        /*
            r15 = this;
            r7 = r16
            r8 = 3
            com.google.android.gms.internal.ads.zzaga r1 = r15.f23954c
            r1.getClass()
            java.lang.String r1 = com.google.android.gms.internal.ads.zzfj.f31254a
        La:
            int r1 = r7.B()
            if (r1 <= 0) goto L6e
            int r1 = r7.f30145b
            int r9 = r7.f30146c
            byte[] r10 = r7.f30144a
            long r2 = r15.f23963l
            int r4 = r7.B()
            long r4 = (long) r4
            long r2 = r2 + r4
            r15.f23963l = r2
            com.google.android.gms.internal.ads.zzaga r2 = r15.f23954c
            int r3 = r7.B()
            r2.b(r3, r7)
        L29:
            if (r1 >= r9) goto La
            boolean[] r2 = r15.f23957f
            int r2 = com.google.android.gms.internal.ads.zzgm.g(r10, r1, r9, r2)
            if (r2 == r9) goto L6b
            int r3 = r2 + 3
            r3 = r10[r3]
            r3 = r3 & 126(0x7e, float:1.77E-43)
            if (r2 <= 0) goto L45
            int r4 = r2 + (-1)
            r5 = r10[r4]
            if (r5 != 0) goto L45
            r2 = 4
            r12 = r2
            r11 = r4
            goto L47
        L45:
            r11 = r2
            r12 = r8
        L47:
            int r2 = r11 - r1
            if (r2 <= 0) goto L4e
            r15.f(r1, r10, r11)
        L4e:
            int r1 = r9 - r11
            long r4 = r15.f23963l
            long r13 = (long) r1
            long r4 = r4 - r13
            if (r2 >= 0) goto L58
            int r2 = -r2
            goto L59
        L58:
            r2 = 0
        L59:
            int r13 = r3 >> 1
            r3 = r4
            long r5 = r15.f23964m
            r0 = r15
            r0.g(r1, r2, r3, r5)
            long r5 = r15.f23964m
            r2 = r13
            r0.a(r1, r2, r3, r5)
            int r1 = r11 + r12
            goto L29
        L6b:
            r15.f(r1, r10, r9)
        L6e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaop.d(com.google.android.gms.internal.ads.zzer):void");
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void e(zzaer zzaerVar, zzapu zzapuVar) {
        zzapuVar.a();
        zzapuVar.b();
        this.f23953b = zzapuVar.f24112e;
        zzapuVar.b();
        zzaga zzagaVarE = zzaerVar.e(zzapuVar.f24111d, 2);
        this.f23954c = zzagaVarE;
        this.f23955d = new zzaoo(zzagaVarE);
        this.f23952a.a(zzaerVar, zzapuVar);
    }

    public final void f(int i2, byte[] bArr, int i3) {
        zzaoo zzaooVar = this.f23955d;
        if (zzaooVar.f23944f) {
            int i4 = zzaooVar.f23942d;
            int i5 = (i2 + 2) - i4;
            if (i5 < i3) {
                zzaooVar.f23945g = (bArr[i5] & 128) != 0;
                zzaooVar.f23944f = false;
            } else {
                zzaooVar.f23942d = (i3 - i2) + i4;
            }
        }
        if (!this.f23956e) {
            this.f23958g.c(i2, bArr, i3);
            this.f23959h.c(i2, bArr, i3);
            this.f23960i.c(i2, bArr, i3);
        }
        this.f23961j.c(i2, bArr, i3);
        this.f23962k.c(i2, bArr, i3);
    }

    public final void g(int i2, int i3, long j2, long j3) {
        zzaoo zzaooVar = this.f23955d;
        boolean z = this.f23956e;
        if (zzaooVar.f23948j && zzaooVar.f23945g) {
            zzaooVar.f23951m = zzaooVar.f23941c;
            zzaooVar.f23948j = false;
        } else if (zzaooVar.f23946h || zzaooVar.f23945g) {
            if (z && zzaooVar.f23947i) {
                zzaooVar.a(i2 + ((int) (j2 - zzaooVar.f23940b)));
            }
            zzaooVar.f23949k = zzaooVar.f23940b;
            zzaooVar.f23950l = zzaooVar.f23943e;
            zzaooVar.f23951m = zzaooVar.f23941c;
            zzaooVar.f23947i = true;
        }
        boolean z2 = this.f23956e;
        zzgq zzgqVar = this.f23952a.f24070c;
        if (!z2) {
            zzaox zzaoxVar = this.f23958g;
            zzaoxVar.d(i3);
            zzaox zzaoxVar2 = this.f23959h;
            zzaoxVar2.d(i3);
            zzaox zzaoxVar3 = this.f23960i;
            zzaoxVar3.d(i3);
            if (zzaoxVar.f24015c && zzaoxVar2.f24015c && zzaoxVar3.f24015c) {
                String str = this.f23953b;
                int i4 = zzaoxVar.f24017e;
                byte[] bArr = new byte[zzaoxVar2.f24017e + i4 + zzaoxVar3.f24017e];
                System.arraycopy(zzaoxVar.f24016d, 0, bArr, 0, i4);
                System.arraycopy(zzaoxVar2.f24016d, 0, bArr, zzaoxVar.f24017e, zzaoxVar2.f24017e);
                System.arraycopy(zzaoxVar3.f24016d, 0, bArr, zzaoxVar.f24017e + zzaoxVar2.f24017e, zzaoxVar3.f24017e);
                zzgg zzggVarF = zzgm.f(zzaoxVar2.f24016d, 3, zzaoxVar2.f24017e, null);
                zzgb zzgbVar = zzggVarF.f32508b;
                String strA = zzgbVar != null ? zzdo.a(zzgbVar.f32191a, zzgbVar.f32192b, zzgbVar.f32193c, zzgbVar.f32194d, zzgbVar.f32195e, zzgbVar.f32196f) : null;
                zzt zztVar = new zzt();
                zztVar.f35564a = str;
                zztVar.d("video/mp2t");
                zztVar.e("video/hevc");
                zztVar.f35572i = strA;
                zztVar.s = zzggVarF.f32511e;
                zztVar.t = zzggVarF.f32512f;
                zztVar.u = zzggVarF.f32513g;
                zztVar.v = zzggVarF.f32514h;
                zzh zzhVar = new zzh();
                zzhVar.f33411a = zzggVarF.f32517k;
                zzhVar.f33412b = zzggVarF.f32518l;
                zzhVar.f33413c = zzggVarF.f32519m;
                zzhVar.f33415e = zzggVarF.f32509c + 8;
                zzhVar.f33416f = zzggVarF.f32510d + 8;
                zztVar.B = zzhVar.a();
                zztVar.y = zzggVarF.f32515i;
                zztVar.n = zzggVarF.f32516j;
                zztVar.C = zzggVarF.f32507a + 1;
                zztVar.o = Collections.singletonList(bArr);
                zzv zzvVar = new zzv(zztVar);
                this.f23954c.c(zzvVar);
                int i5 = zzvVar.o;
                zzgqa.f(i5 != -1);
                zzgqVar.a(i5);
                this.f23956e = true;
            }
        }
        zzaox zzaoxVar4 = this.f23961j;
        boolean zD = zzaoxVar4.d(i3);
        zzer zzerVar = this.n;
        if (zD) {
            zzerVar.z(zzgm.a(zzaoxVar4.f24017e, zzaoxVar4.f24016d), zzaoxVar4.f24016d);
            zzerVar.G(5);
            zzgqVar.b(j3, zzerVar);
        }
        zzaox zzaoxVar5 = this.f23962k;
        if (zzaoxVar5.d(i3)) {
            zzerVar.z(zzgm.a(zzaoxVar5.f24017e, zzaoxVar5.f24016d), zzaoxVar5.f24016d);
            zzerVar.G(5);
            zzgqVar.b(j3, zzerVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void zza() {
        this.f23963l = 0L;
        this.f23964m = -9223372036854775807L;
        zzgm.h(this.f23957f);
        this.f23958g.a();
        this.f23959h.a();
        this.f23960i.a();
        this.f23961j.a();
        this.f23962k.a();
        this.f23952a.f24070c.c(0);
        zzaoo zzaooVar = this.f23955d;
        if (zzaooVar != null) {
            zzaooVar.f23944f = false;
            zzaooVar.f23945g = false;
            zzaooVar.f23946h = false;
            zzaooVar.f23947i = false;
            zzaooVar.f23948j = false;
        }
    }
}
