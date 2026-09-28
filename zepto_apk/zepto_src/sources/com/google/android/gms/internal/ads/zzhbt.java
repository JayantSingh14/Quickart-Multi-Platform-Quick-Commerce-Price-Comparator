package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzhbt extends zzhbf {

    /* renamed from: a, reason: collision with root package name */
    public final int f33483a;

    /* renamed from: b, reason: collision with root package name */
    public final int f33484b;

    /* renamed from: c, reason: collision with root package name */
    public final int f33485c;

    /* renamed from: d, reason: collision with root package name */
    public final int f33486d;

    /* renamed from: e, reason: collision with root package name */
    public final zzhbs f33487e;

    /* renamed from: f, reason: collision with root package name */
    public final zzhbr f33488f;

    public /* synthetic */ zzhbt(int i2, int i3, int i4, int i5, zzhbs zzhbsVar, zzhbr zzhbrVar) {
        this.f33483a = i2;
        this.f33484b = i3;
        this.f33485c = i4;
        this.f33486d = i5;
        this.f33487e = zzhbsVar;
        this.f33488f = zzhbrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhan
    public final boolean a() {
        return this.f33487e != zzhbs.f33481d;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhbt)) {
            return false;
        }
        zzhbt zzhbtVar = (zzhbt) obj;
        return zzhbtVar.f33483a == this.f33483a && zzhbtVar.f33484b == this.f33484b && zzhbtVar.f33485c == this.f33485c && zzhbtVar.f33486d == this.f33486d && zzhbtVar.f33487e == this.f33487e && zzhbtVar.f33488f == this.f33488f;
    }

    public final int hashCode() {
        return Objects.hash(zzhbt.class, Integer.valueOf(this.f33483a), Integer.valueOf(this.f33484b), Integer.valueOf(this.f33485c), Integer.valueOf(this.f33486d), this.f33487e, this.f33488f);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f33487e);
        String strValueOf2 = String.valueOf(this.f33488f);
        int length = strValueOf.length();
        int length2 = strValueOf2.length();
        int i2 = this.f33485c;
        int length3 = String.valueOf(i2).length();
        int i3 = this.f33486d;
        int length4 = String.valueOf(i3).length();
        int i4 = this.f33483a;
        int length5 = String.valueOf(i4).length();
        int i5 = this.f33484b;
        StringBuilder sb = new StringBuilder(length + 48 + length2 + 2 + length3 + 14 + length4 + 16 + length5 + 19 + String.valueOf(i5).length() + 15);
        android.support.v4.media.b.B(sb, "AesCtrHmacAead Parameters (variant: ", strValueOf, ", hashType: ", strValueOf2);
        androidx.fragment.app.e.w(i2, i3, ", ", "-byte IV, and ", sb);
        androidx.fragment.app.e.w(i4, i5, "-byte tags, and ", "-byte AES key, and ", sb);
        sb.append("-byte HMAC key)");
        return sb.toString();
    }
}
