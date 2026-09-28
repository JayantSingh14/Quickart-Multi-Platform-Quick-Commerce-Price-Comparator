package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzico implements zzibz {

    /* renamed from: a, reason: collision with root package name */
    public final zzicc f34729a;

    /* renamed from: b, reason: collision with root package name */
    public final String f34730b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f34731c;

    /* renamed from: d, reason: collision with root package name */
    public final int f34732d;

    public zzico(zzicc zziccVar, String str, Object[] objArr) {
        this.f34729a = zziccVar;
        this.f34730b = str;
        this.f34731c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f34732d = cCharAt;
            return;
        }
        int i2 = cCharAt & 8191;
        int i3 = 13;
        int i4 = 1;
        while (true) {
            int i5 = i4 + 1;
            char cCharAt2 = str.charAt(i4);
            if (cCharAt2 < 55296) {
                this.f34732d = i2 | (cCharAt2 << i3);
                return;
            } else {
                i2 |= (cCharAt2 & 8191) << i3;
                i3 += 13;
                i4 = i5;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzibz
    public final boolean zza() {
        return (this.f34732d & 2) == 2;
    }

    @Override // com.google.android.gms.internal.ads.zzibz
    public final zzicc zzb() {
        return this.f34729a;
    }

    @Override // com.google.android.gms.internal.ads.zzibz
    public final int zzc() {
        int i2 = this.f34732d;
        if ((i2 & 1) != 0) {
            return 1;
        }
        return (i2 & 4) == 4 ? 3 : 2;
    }
}
