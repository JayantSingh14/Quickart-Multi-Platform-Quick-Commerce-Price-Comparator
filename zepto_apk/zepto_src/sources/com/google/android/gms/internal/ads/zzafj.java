package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzafj implements zzafr {

    /* renamed from: a, reason: collision with root package name */
    public final zzef f22937a;

    /* renamed from: b, reason: collision with root package name */
    public final zzef f22938b;

    /* renamed from: c, reason: collision with root package name */
    public final long f22939c;

    public zzafj(long j2, long[] jArr, long[] jArr2) {
        int length = jArr.length;
        int length2 = jArr2.length;
        zzgqa.a(length == length2);
        if (length2 <= 0 || jArr2[0] <= 0) {
            this.f22937a = new zzef(length2);
            this.f22938b = new zzef(length2);
        } else {
            int i2 = length2 + 1;
            zzef zzefVar = new zzef(i2);
            this.f22937a = zzefVar;
            zzef zzefVar2 = new zzef(i2);
            this.f22938b = zzefVar2;
            zzefVar.a();
            zzefVar2.a();
        }
        this.f22937a.b(jArr);
        this.f22938b.b(jArr2);
        this.f22939c = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final zzafp b(long j2) {
        zzef zzefVar = this.f22938b;
        int i2 = zzefVar.f29201a;
        if (i2 == 0) {
            zzafs zzafsVar = zzafs.f22959c;
            return new zzafp(zzafsVar, zzafsVar);
        }
        String str = zzfj.f31254a;
        int i3 = i2 - 1;
        int i4 = 0;
        int i5 = 0;
        while (i5 <= i3) {
            int i6 = (i5 + i3) >>> 1;
            if (zzefVar.c(i6) < j2) {
                i5 = i6 + 1;
            } else {
                i3 = i6 - 1;
            }
        }
        int i7 = i3 + 1;
        if (i7 < zzefVar.f29201a && zzefVar.c(i7) == j2) {
            i4 = i7;
        } else if (i3 != -1) {
            i4 = i3;
        }
        long jC = zzefVar.c(i4);
        zzef zzefVar2 = this.f22937a;
        zzafs zzafsVar2 = new zzafs(jC, zzefVar2.c(i4));
        if (jC == j2 || i4 == zzefVar.f29201a - 1) {
            return new zzafp(zzafsVar2, zzafsVar2);
        }
        int i8 = i4 + 1;
        return new zzafp(zzafsVar2, new zzafs(zzefVar.c(i8), zzefVar2.c(i8)));
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final long zza() {
        return this.f22939c;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final boolean zzb() {
        return this.f22938b.f29201a > 0;
    }
}
