package com.google.android.tv.ads;

import com.google.android.tv.ads.IconClickFallbackImage;

/* loaded from: classes4.dex */
final class zza extends IconClickFallbackImage.Builder {

    /* renamed from: a, reason: collision with root package name */
    public int f42215a;

    /* renamed from: b, reason: collision with root package name */
    public int f42216b;

    /* renamed from: c, reason: collision with root package name */
    public String f42217c;

    /* renamed from: d, reason: collision with root package name */
    public String f42218d;

    /* renamed from: e, reason: collision with root package name */
    public String f42219e;

    /* renamed from: f, reason: collision with root package name */
    public byte f42220f;

    @Override // com.google.android.tv.ads.IconClickFallbackImage.Builder
    public final IconClickFallbackImage a() {
        if (this.f42220f == 3) {
            return new zzd(this.f42215a, this.f42216b, this.f42217c, this.f42218d, this.f42219e);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f42220f & 1) == 0) {
            sb.append(" width");
        }
        if ((this.f42220f & 2) == 0) {
            sb.append(" height");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.tv.ads.IconClickFallbackImage.Builder
    public final IconClickFallbackImage.Builder b(String str) {
        this.f42217c = str;
        return this;
    }

    @Override // com.google.android.tv.ads.IconClickFallbackImage.Builder
    public final IconClickFallbackImage.Builder c(String str) {
        this.f42218d = str;
        return this;
    }

    @Override // com.google.android.tv.ads.IconClickFallbackImage.Builder
    public final IconClickFallbackImage.Builder d(int i2) {
        this.f42216b = i2;
        this.f42220f = (byte) (this.f42220f | 2);
        return this;
    }

    @Override // com.google.android.tv.ads.IconClickFallbackImage.Builder
    public final IconClickFallbackImage.Builder e(String str) {
        this.f42219e = str;
        return this;
    }

    @Override // com.google.android.tv.ads.IconClickFallbackImage.Builder
    public final IconClickFallbackImage.Builder f(int i2) {
        this.f42215a = i2;
        this.f42220f = (byte) (this.f42220f | 1);
        return this;
    }
}
