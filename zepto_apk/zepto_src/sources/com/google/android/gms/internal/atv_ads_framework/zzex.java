package com.google.android.gms.internal.atv_ads_framework;

/* loaded from: classes4.dex */
final class zzex implements zzel {

    /* renamed from: a, reason: collision with root package name */
    public final zzdh f36174a;

    /* renamed from: b, reason: collision with root package name */
    public final String f36175b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f36176c;

    /* renamed from: d, reason: collision with root package name */
    public final int f36177d;

    public zzex(zzdh zzdhVar, String str, Object[] objArr) {
        this.f36174a = zzdhVar;
        this.f36175b = str;
        this.f36176c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f36177d = cCharAt;
            return;
        }
        int i2 = cCharAt & 8191;
        int i3 = 13;
        int i4 = 1;
        while (true) {
            int i5 = i4 + 1;
            char cCharAt2 = str.charAt(i4);
            if (cCharAt2 < 55296) {
                this.f36177d = i2 | (cCharAt2 << i3);
                return;
            } else {
                i2 |= (cCharAt2 & 8191) << i3;
                i3 += 13;
                i4 = i5;
            }
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzel
    public final zzeo zza() {
        return this.f36174a;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzel
    public final boolean zzb() {
        return (this.f36177d & 2) == 2;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzel
    public final int zzc() {
        return (this.f36177d & 1) == 1 ? 1 : 2;
    }
}
