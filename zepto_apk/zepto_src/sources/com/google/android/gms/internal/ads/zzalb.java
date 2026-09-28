package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzalb implements zzali {

    /* renamed from: a, reason: collision with root package name */
    public final zzalh f23454a;

    /* renamed from: b, reason: collision with root package name */
    public final long f23455b;

    /* renamed from: c, reason: collision with root package name */
    public final long f23456c;

    /* renamed from: d, reason: collision with root package name */
    public final zzalm f23457d;

    /* renamed from: e, reason: collision with root package name */
    public int f23458e;

    /* renamed from: f, reason: collision with root package name */
    public long f23459f;

    /* renamed from: g, reason: collision with root package name */
    public long f23460g;

    /* renamed from: h, reason: collision with root package name */
    public long f23461h;

    /* renamed from: i, reason: collision with root package name */
    public long f23462i;

    /* renamed from: j, reason: collision with root package name */
    public long f23463j;

    /* renamed from: k, reason: collision with root package name */
    public long f23464k;

    /* renamed from: l, reason: collision with root package name */
    public long f23465l;

    public zzalb(zzalm zzalmVar, long j2, long j3, long j4, long j5, boolean z) {
        zzgqa.a(j2 >= 0 && j3 > j2);
        this.f23457d = zzalmVar;
        this.f23455b = j2;
        this.f23456c = j3;
        if (j4 == j3 - j2 || z) {
            this.f23459f = j5;
            this.f23458e = 4;
        } else {
            this.f23458e = 0;
        }
        this.f23454a = new zzalh();
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void a(long j2) {
        long j3 = this.f23459f - 1;
        String str = zzfj.f31254a;
        this.f23461h = Math.max(0L, Math.min(j2, j3));
        this.f23458e = 2;
        this.f23462i = this.f23455b;
        this.f23463j = this.f23456c;
        this.f23464k = 0L;
        this.f23465l = this.f23459f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ba  */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v3 */
    @Override // com.google.android.gms.internal.ads.zzali
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long b(com.google.android.gms.internal.ads.zzaef r24) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalb.b(com.google.android.gms.internal.ads.zzaef):long");
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final /* bridge */ /* synthetic */ zzafr zzc() {
        if (this.f23459f != 0) {
            return new zzala(this);
        }
        return null;
    }
}
