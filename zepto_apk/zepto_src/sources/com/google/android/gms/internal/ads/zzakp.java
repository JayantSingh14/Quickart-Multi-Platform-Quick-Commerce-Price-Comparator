package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzakp implements zzaeo {
    public static final /* synthetic */ int z = 0;

    /* renamed from: a, reason: collision with root package name */
    public final zzalw f23386a;

    /* renamed from: b, reason: collision with root package name */
    public final int f23387b;

    /* renamed from: c, reason: collision with root package name */
    public final zzer f23388c;

    /* renamed from: d, reason: collision with root package name */
    public final zzer f23389d;

    /* renamed from: e, reason: collision with root package name */
    public final zzer f23390e;

    /* renamed from: f, reason: collision with root package name */
    public final zzer f23391f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayDeque f23392g;

    /* renamed from: h, reason: collision with root package name */
    public final zzakt f23393h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f23394i;

    /* renamed from: j, reason: collision with root package name */
    public zzgtd f23395j;

    /* renamed from: k, reason: collision with root package name */
    public int f23396k;

    /* renamed from: l, reason: collision with root package name */
    public int f23397l;

    /* renamed from: m, reason: collision with root package name */
    public long f23398m;
    public int n;
    public zzer o;
    public int p;
    public int q;
    public int r;
    public int s;
    public boolean t;
    public boolean u;
    public zzaer v;
    public zzako[] w;
    public long[][] x;
    public int y;

    @Deprecated
    public zzakp() {
        this(16, zzalw.f23510a);
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void a(long j2, long j3) {
        this.f23392g.clear();
        this.n = 0;
        this.p = -1;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = false;
        if (j2 == 0) {
            if (this.f23396k != 3) {
                this.f23396k = 0;
                this.n = 0;
                return;
            } else {
                zzakt zzaktVar = this.f23393h;
                zzaktVar.f23405a.clear();
                zzaktVar.f23406b = 0;
                this.f23394i.clear();
                return;
            }
        }
        for (zzako zzakoVar : this.w) {
            zzaky zzakyVar = zzakoVar.f23381b;
            int iA = zzakyVar.a(j3);
            if (iA == -1) {
                iA = zzakyVar.b(j3);
            }
            zzakoVar.f23384e = iA;
            zzagb zzagbVar = zzakoVar.f23383d;
            if (zzagbVar != null) {
                zzagbVar.f22982b = false;
                zzagbVar.f22983c = 0;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void b(zzaer zzaerVar) {
        if ((this.f23387b & 16) == 0) {
            zzaerVar = new zzalz(zzaerVar, this.f23386a);
        }
        this.v = zzaerVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final boolean c(zzaep zzaepVar) {
        zzgtd zzgtdVarN;
        zzafv zzafvVarA = zzaku.a(zzaepVar, false, false);
        if (zzafvVarA != null) {
            zzgtdVarN = zzgtd.n(zzafvVarA);
        } else {
            zzgvs zzgvsVar = zzgtd.f33183b;
            zzgtdVarN = zzguy.f33232e;
        }
        this.f23395j = zzgtdVarN;
        return zzafvVarA == null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:438:0x02c7 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzaeo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int d(com.google.android.gms.internal.ads.zzaep r40, com.google.android.gms.internal.ads.zzafo r41) throws com.google.android.gms.internal.ads.zzat {
        /*
            Method dump skipped, instructions count: 1804
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakp.d(com.google.android.gms.internal.ads.zzaep, com.google.android.gms.internal.ads.zzafo):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(long j2) {
        int i2;
        zzap zzapVarC;
        long j3;
        ArrayDeque arrayDeque;
        ArrayList arrayList;
        int i3;
        ArrayList arrayList2;
        zzaga zzagaVar;
        zzv zzvVar;
        long[] jArr;
        long j4;
        int i4;
        int i5;
        zzap zzapVar;
        zzap zzapVar2;
        zzako zzakoVar;
        ArrayList arrayList3;
        int i6;
        int i7;
        int i8 = 0;
        int i9 = 1;
        while (true) {
            ArrayDeque arrayDeque2 = this.f23392g;
            if (arrayDeque2.isEmpty() || ((zzfu) arrayDeque2.peek()).f31859b != j2) {
                break;
            }
            zzfu zzfuVar = (zzfu) arrayDeque2.pop();
            if (zzfuVar.f31964a == 1836019574) {
                zzfu zzfuVarC = zzfuVar.c(1835365473);
                new ArrayList();
                zzap zzapVarE = zzfuVarC != null ? zzaka.e(zzfuVarC) : null;
                ArrayList arrayList4 = new ArrayList();
                boolean z2 = this.y == i9 ? i9 : i8;
                zzafg zzafgVar = new zzafg();
                zzfv zzfvVarB = zzfuVar.b(1969517665);
                if (zzfvVarB != null) {
                    zzapVarC = zzaka.c(zzfvVarB);
                    zzafgVar.a(zzapVarC);
                } else {
                    zzapVarC = null;
                }
                zzfv zzfvVarB2 = zzfuVar.b(1836476516);
                zzfvVarB2.getClass();
                zzao[] zzaoVarArr = new zzao[i9];
                zzaoVarArr[i8] = zzaka.d(zzfvVarB2.f31916b);
                zzap zzapVar3 = new zzap(zzaoVarArr);
                zzap zzapVar4 = zzapVarC;
                int i10 = i8;
                ArrayList arrayListB = zzaka.b(zzfuVar, zzafgVar, -9223372036854775807L, null, false, z2, zzakm.f23376a);
                String strA = zzakk.a(arrayListB);
                int i11 = i9;
                int i12 = i10;
                int i13 = i12;
                int size = -1;
                long j5 = -9223372036854775807L;
                while (true) {
                    j3 = 0;
                    if (i12 >= arrayListB.size()) {
                        break;
                    }
                    zzaky zzakyVar = (zzaky) arrayListB.get(i12);
                    int i14 = zzakyVar.f23440b;
                    if (i14 == 0) {
                        arrayDeque = arrayDeque2;
                        zzapVar2 = zzapVarE;
                        arrayList = arrayListB;
                        i3 = i12;
                        arrayList3 = arrayList4;
                    } else {
                        arrayDeque = arrayDeque2;
                        zzaer zzaerVar = this.v;
                        int i15 = i13 + 1;
                        arrayList = arrayListB;
                        zzakv zzakvVar = zzakyVar.f23439a;
                        i3 = i12;
                        int i16 = zzakvVar.f23410b;
                        zzaga zzagaVarE = zzaerVar.e(i13, i16);
                        zzako zzakoVar2 = new zzako(zzakvVar, zzakyVar, zzagaVarE);
                        zzap zzapVar5 = zzapVarE;
                        long j6 = zzakvVar.f23413e;
                        if (j6 == -9223372036854775807L) {
                            j6 = zzakyVar.f23447i;
                        }
                        long jMax = Math.max(j5, j6);
                        zzv zzvVar2 = zzakvVar.f23415g;
                        String str = zzvVar2.f35691m;
                        boolean zEquals = "audio/true-hd".equals(str);
                        int i17 = zzakyVar.f23443e;
                        int i18 = zEquals ? i17 * 16 : i17 + 30;
                        zzt zztVar = new zzt(zzvVar2);
                        zztVar.f35576m = i18;
                        if (i16 == 2) {
                            int i19 = this.f23387b & 8;
                            int i20 = zzvVar2.f35684f;
                            if (i19 != 0) {
                                i20 |= size == -1 ? i11 : 2;
                            }
                            zztVar.f35569f = i20;
                            i16 = 2;
                        }
                        if (zzas.b(str)) {
                            int[] iArr = zzakyVar.f23446h;
                            arrayList2 = arrayList4;
                            boolean z3 = zzakyVar.f23448j;
                            int iMin = Math.min(!z3 ? iArr.length : i14, 20);
                            zzgqa.f(j6 != -9223372036854775807L ? i11 : i10);
                            zzagaVar = zzagaVarE;
                            zzvVar = zzvVar2;
                            long jMin = Math.min(j6, 10000000L);
                            int i21 = i10;
                            int i22 = i21;
                            int i23 = -1;
                            while (true) {
                                jArr = zzakyVar.f23444f;
                                if (i21 >= iMin) {
                                    break;
                                }
                                int i24 = z3 ? i21 : iArr[i21];
                                long j7 = jArr[i24];
                                if (j7 > jMin) {
                                    break;
                                }
                                if (j7 >= 0 && (i4 = zzakyVar.f23442d[i24]) > i22) {
                                    i22 = i4;
                                    i23 = i24;
                                }
                                i21++;
                            }
                            j4 = i23 == -1 ? -9223372036854775807L : jArr[i23];
                        } else {
                            zzvVar = zzvVar2;
                            arrayList2 = arrayList4;
                            j4 = -9223372036854775807L;
                            zzagaVar = zzagaVarE;
                        }
                        if (j4 != -9223372036854775807L) {
                            zzahq zzahqVar = new zzahq(j4);
                            i5 = i11;
                            zzao[] zzaoVarArr2 = new zzao[i5];
                            zzaoVarArr2[i10] = zzahqVar;
                            zzapVar = new zzap(zzaoVarArr2);
                        } else {
                            i5 = i11;
                            zzapVar = null;
                        }
                        if (i16 == i5 && (i6 = zzafgVar.f22921a) != -1 && (i7 = zzafgVar.f22922b) != -1) {
                            zztVar.G = i6;
                            zztVar.H = i7;
                        }
                        ArrayList arrayList5 = this.f23394i;
                        zzap[] zzapVarArr = {arrayList5.isEmpty() ? null : new zzap(arrayList5), zzapVar4, zzapVar3, zzapVar};
                        zzapVar2 = zzapVar5;
                        zzakj.a(i16, zzapVar2, zztVar, zzvVar.f35689k, zzapVarArr);
                        zztVar.d(strA);
                        if (Objects.equals(str, "audio/mpeg")) {
                            zzakoVar = zzakoVar2;
                            zzakoVar.f23385f = new zzv(zztVar);
                        } else {
                            zzakoVar = zzakoVar2;
                            zzagaVar.c(new zzv(zztVar));
                        }
                        if (i16 == 2 && size == -1) {
                            size = arrayList2.size();
                        }
                        arrayList3 = arrayList2;
                        arrayList3.add(zzakoVar);
                        i13 = i15;
                        j5 = jMax;
                    }
                    i12 = i3 + 1;
                    zzapVarE = zzapVar2;
                    arrayList4 = arrayList3;
                    arrayDeque2 = arrayDeque;
                    arrayListB = arrayList;
                    i11 = 1;
                }
                ArrayDeque arrayDeque3 = arrayDeque2;
                int i25 = -1;
                zzako[] zzakoVarArr = (zzako[]) arrayList4.toArray(new zzako[i10]);
                this.w = zzakoVarArr;
                int length = zzakoVarArr.length;
                long[][] jArr2 = new long[length][];
                int[] iArr2 = new int[length];
                long[] jArr3 = new long[length];
                boolean[] zArr = new boolean[length];
                for (int i26 = 0; i26 < zzakoVarArr.length; i26++) {
                    jArr2[i26] = new long[zzakoVarArr[i26].f23381b.f23440b];
                    jArr3[i26] = zzakoVarArr[i26].f23381b.f23444f[0];
                }
                int i27 = 0;
                while (i27 < zzakoVarArr.length) {
                    long j8 = Long.MAX_VALUE;
                    int i28 = i25;
                    for (int i29 = 0; i29 < zzakoVarArr.length; i29++) {
                        if (!zArr[i29]) {
                            long j9 = jArr3[i29];
                            if (j9 <= j8) {
                                i28 = i29;
                                j8 = j9;
                            }
                        }
                    }
                    int i30 = iArr2[i28];
                    long[] jArr4 = jArr2[i28];
                    jArr4[i30] = j3;
                    zzaky zzakyVar2 = zzakoVarArr[i28].f23381b;
                    boolean[] zArr2 = zArr;
                    j3 += zzakyVar2.f23442d[i30];
                    int i31 = i30 + 1;
                    iArr2[i28] = i31;
                    if (i31 < jArr4.length) {
                        jArr3[i28] = zzakyVar2.f23444f[i31];
                    } else {
                        zArr2[i28] = true;
                        i27++;
                    }
                    zArr = zArr2;
                    i25 = -1;
                }
                i2 = 1;
                this.x = jArr2;
                this.v.h();
                this.v.d(new zzakn(j5, this.w, size));
                arrayDeque3.clear();
                this.f23396k = 2;
            } else {
                i2 = i9;
                if (!arrayDeque2.isEmpty()) {
                    ((zzfu) arrayDeque2.peek()).f31861d.add(zzfuVar);
                }
            }
            i9 = i2;
            i8 = 0;
        }
        if (this.f23396k != 2) {
            this.f23396k = 0;
            this.n = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final /* synthetic */ List zzb() {
        return this.f23395j;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void zzf() {
    }

    public zzakp(int i2, zzalw zzalwVar) {
        this.f23386a = zzalwVar;
        this.f23387b = i2;
        zzgvs zzgvsVar = zzgtd.f33183b;
        this.f23395j = zzguy.f33232e;
        this.f23396k = 0;
        this.f23393h = new zzakt();
        this.f23394i = new ArrayList();
        this.f23391f = new zzer(16);
        this.f23392g = new ArrayDeque();
        this.f23388c = new zzer(zzgm.f32888a);
        this.f23389d = new zzer(6);
        this.f23390e = new zzer();
        this.p = -1;
        this.v = zzaer.n0;
        this.w = new zzako[0];
    }
}
