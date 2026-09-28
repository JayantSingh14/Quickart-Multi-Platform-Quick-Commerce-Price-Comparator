package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzaoc implements zzaog {
    public static final byte[] x = {73, 68, 51};

    /* renamed from: a, reason: collision with root package name */
    public final boolean f23838a;

    /* renamed from: d, reason: collision with root package name */
    public final String f23841d;

    /* renamed from: e, reason: collision with root package name */
    public final int f23842e;

    /* renamed from: f, reason: collision with root package name */
    public final String f23843f;

    /* renamed from: g, reason: collision with root package name */
    public String f23844g;

    /* renamed from: h, reason: collision with root package name */
    public zzaga f23845h;

    /* renamed from: i, reason: collision with root package name */
    public zzaga f23846i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f23850m;
    public boolean n;
    public int q;
    public boolean r;
    public int t;
    public zzaga v;
    public long w;

    /* renamed from: b, reason: collision with root package name */
    public final zzeq f23839b = new zzeq(new byte[7], 7);

    /* renamed from: c, reason: collision with root package name */
    public final zzer f23840c = new zzer(Arrays.copyOf(x, 10));
    public int o = -1;
    public int p = -1;
    public long s = -9223372036854775807L;
    public long u = -9223372036854775807L;

    /* renamed from: j, reason: collision with root package name */
    public int f23847j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f23848k = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f23849l = 256;

    public zzaoc(String str, int i2, String str2, boolean z) {
        this.f23838a = z;
        this.f23841d = str;
        this.f23842e = i2;
        this.f23843f = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void b(int i2, long j2) {
        this.u = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void c(boolean z) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x02aa, code lost:
    
        r22.q = (r8 & 8) >> 3;
        r4 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x02b6, code lost:
    
        if (r4 == ((r8 & 1) ^ 1)) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02b8, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x02ba, code lost:
    
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x02bb, code lost:
    
        r22.f23850m = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x02bf, code lost:
    
        if (r22.n != false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x02c1, code lost:
    
        r22.f23847j = r4;
        r22.f23848k = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x02c7, code lost:
    
        r22.f23847j = r17;
        r22.f23848k = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x02ce, code lost:
    
        r23.E(r15);
        r3 = r2;
        r5 = r4;
        r2 = 0;
        r4 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0229, code lost:
    
        r2 = -1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r23v0, types: [com.google.android.gms.internal.ads.zzer] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // com.google.android.gms.internal.ads.zzaog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(com.google.android.gms.internal.ads.zzer r23) {
        /*
            Method dump skipped, instructions count: 843
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaoc.d(com.google.android.gms.internal.ads.zzer):void");
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void e(zzaer zzaerVar, zzapu zzapuVar) {
        zzapuVar.a();
        zzapuVar.b();
        this.f23844g = zzapuVar.f24112e;
        zzapuVar.b();
        zzaga zzagaVarE = zzaerVar.e(zzapuVar.f24111d, 1);
        this.f23845h = zzagaVarE;
        this.v = zzagaVarE;
        if (!this.f23838a) {
            this.f23846i = new zzael();
            return;
        }
        zzapuVar.a();
        zzapuVar.b();
        zzaga zzagaVarE2 = zzaerVar.e(zzapuVar.f24111d, 5);
        this.f23846i = zzagaVarE2;
        zzt zztVar = new zzt();
        zzapuVar.b();
        zztVar.f35564a = zzapuVar.f24112e;
        zztVar.d(this.f23843f);
        zztVar.e("application/id3");
        zzagaVarE2.c(new zzv(zztVar));
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void zza() {
        this.u = -9223372036854775807L;
        this.n = false;
        this.f23847j = 0;
        this.f23848k = 0;
        this.f23849l = 256;
    }
}
