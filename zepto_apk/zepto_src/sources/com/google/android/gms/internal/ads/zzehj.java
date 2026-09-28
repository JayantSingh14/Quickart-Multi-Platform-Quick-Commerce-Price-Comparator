package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;

/* loaded from: classes4.dex */
final class zzehj extends zzehm {

    /* renamed from: a, reason: collision with root package name */
    public final String f29342a;

    /* renamed from: b, reason: collision with root package name */
    public final String f29343b;

    /* renamed from: c, reason: collision with root package name */
    public final Drawable f29344c;

    public zzehj(String str, String str2, Drawable drawable) {
        this.f29342a = str;
        if (str2 == null) {
            throw new NullPointerException("Null imageUrl");
        }
        this.f29343b = str2;
        this.f29344c = drawable;
    }

    @Override // com.google.android.gms.internal.ads.zzehm
    public final String a() {
        return this.f29342a;
    }

    @Override // com.google.android.gms.internal.ads.zzehm
    public final String b() {
        return this.f29343b;
    }

    @Override // com.google.android.gms.internal.ads.zzehm
    public final Drawable c() {
        return this.f29344c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzehm)) {
            return false;
        }
        zzehm zzehmVar = (zzehm) obj;
        String str = this.f29342a;
        if (str == null) {
            if (zzehmVar.a() != null) {
                return false;
            }
        } else if (!str.equals(zzehmVar.a())) {
            return false;
        }
        if (!this.f29343b.equals(zzehmVar.b())) {
            return false;
        }
        Drawable drawable = this.f29344c;
        return drawable == null ? zzehmVar.c() == null : drawable.equals(zzehmVar.c());
    }

    public final int hashCode() {
        String str = this.f29342a;
        int iHashCode = (((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f29343b.hashCode();
        Drawable drawable = this.f29344c;
        return (drawable != null ? drawable.hashCode() : 0) ^ (iHashCode * 1000003);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f29344c);
        String str = this.f29342a;
        int length = String.valueOf(str).length();
        int length2 = strValueOf.length();
        String str2 = this.f29343b;
        StringBuilder sb = new StringBuilder(str2.length() + length + 42 + 7 + length2 + 1);
        android.support.v4.media.b.B(sb, "OfflineAdAssets{advertiserName=", str, ", imageUrl=", str2);
        return android.support.v4.media.b.s(sb, ", icon=", strValueOf, "}");
    }
}
