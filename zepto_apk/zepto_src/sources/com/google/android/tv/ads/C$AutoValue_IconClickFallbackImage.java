package com.google.android.tv.ads;

import android.support.v4.media.b;

/* renamed from: com.google.android.tv.ads.$AutoValue_IconClickFallbackImage, reason: invalid class name */
/* loaded from: classes4.dex */
abstract class C$AutoValue_IconClickFallbackImage extends IconClickFallbackImage {

    /* renamed from: a, reason: collision with root package name */
    public final int f42203a;

    /* renamed from: b, reason: collision with root package name */
    public final int f42204b;

    /* renamed from: c, reason: collision with root package name */
    public final String f42205c;

    /* renamed from: d, reason: collision with root package name */
    public final String f42206d;

    /* renamed from: e, reason: collision with root package name */
    public final String f42207e;

    public C$AutoValue_IconClickFallbackImage(int i2, int i3, String str, String str2, String str3) {
        this.f42203a = i2;
        this.f42204b = i3;
        this.f42205c = str;
        this.f42206d = str2;
        this.f42207e = str3;
    }

    @Override // com.google.android.tv.ads.IconClickFallbackImage
    public final String b() {
        return this.f42205c;
    }

    @Override // com.google.android.tv.ads.IconClickFallbackImage
    public final String c() {
        return this.f42206d;
    }

    @Override // com.google.android.tv.ads.IconClickFallbackImage
    public final int d() {
        return this.f42204b;
    }

    @Override // com.google.android.tv.ads.IconClickFallbackImage
    public final String e() {
        return this.f42207e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IconClickFallbackImage)) {
            return false;
        }
        IconClickFallbackImage iconClickFallbackImage = (IconClickFallbackImage) obj;
        if (this.f42203a != iconClickFallbackImage.f() || this.f42204b != iconClickFallbackImage.d()) {
            return false;
        }
        String str = this.f42205c;
        if (str == null) {
            if (iconClickFallbackImage.b() != null) {
                return false;
            }
        } else if (!str.equals(iconClickFallbackImage.b())) {
            return false;
        }
        String str2 = this.f42206d;
        if (str2 == null) {
            if (iconClickFallbackImage.c() != null) {
                return false;
            }
        } else if (!str2.equals(iconClickFallbackImage.c())) {
            return false;
        }
        String str3 = this.f42207e;
        return str3 == null ? iconClickFallbackImage.e() == null : str3.equals(iconClickFallbackImage.e());
    }

    @Override // com.google.android.tv.ads.IconClickFallbackImage
    public final int f() {
        return this.f42203a;
    }

    public final int hashCode() {
        int i2 = ((this.f42203a ^ 1000003) * 1000003) ^ this.f42204b;
        String str = this.f42205c;
        int iHashCode = ((i2 * 1000003) ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f42206d;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f42207e;
        return iHashCode2 ^ (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("IconClickFallbackImage{width=");
        sb.append(this.f42203a);
        sb.append(", height=");
        sb.append(this.f42204b);
        sb.append(", altText=");
        sb.append(this.f42205c);
        sb.append(", creativeType=");
        sb.append(this.f42206d);
        sb.append(", staticResourceUri=");
        return b.r(sb, this.f42207e, "}");
    }
}
