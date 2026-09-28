package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class zznv implements zzni {

    /* renamed from: a, reason: collision with root package name */
    public final zznl f37168a;

    /* renamed from: b, reason: collision with root package name */
    public final String f37169b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f37170c;

    /* renamed from: d, reason: collision with root package name */
    public final int f37171d;

    public zznv(zznl zznlVar, String str, Object[] objArr) {
        this.f37168a = zznlVar;
        this.f37169b = str;
        this.f37170c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f37171d = cCharAt;
            return;
        }
        int i2 = cCharAt & 8191;
        int i3 = 13;
        int i4 = 1;
        while (true) {
            int i5 = i4 + 1;
            char cCharAt2 = str.charAt(i4);
            if (cCharAt2 < 55296) {
                this.f37171d = i2 | (cCharAt2 << i3);
                return;
            } else {
                i2 |= (cCharAt2 & 8191) << i3;
                i3 += 13;
                i4 = i5;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzni
    public final boolean zza() {
        return (this.f37171d & 2) == 2;
    }

    @Override // com.google.android.gms.internal.measurement.zzni
    public final zznl zzb() {
        return this.f37168a;
    }

    @Override // com.google.android.gms.internal.measurement.zzni
    public final int zzc() {
        int i2 = this.f37171d;
        if ((i2 & 1) != 0) {
            return 1;
        }
        return (i2 & 4) == 4 ? 3 : 2;
    }
}
