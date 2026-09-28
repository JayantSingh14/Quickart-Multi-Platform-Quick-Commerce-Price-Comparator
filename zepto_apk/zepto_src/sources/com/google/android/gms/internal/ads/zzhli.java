package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzhli extends zzhll {

    /* renamed from: a, reason: collision with root package name */
    public final int f33992a;

    /* renamed from: b, reason: collision with root package name */
    public final int f33993b;

    /* renamed from: c, reason: collision with root package name */
    public final zzhlh f33994c;

    /* renamed from: d, reason: collision with root package name */
    public final zzhlg f33995d;

    public /* synthetic */ zzhli(int i2, int i3, zzhlh zzhlhVar, zzhlg zzhlgVar) {
        this.f33992a = i2;
        this.f33993b = i3;
        this.f33994c = zzhlhVar;
        this.f33995d = zzhlgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhan
    public final boolean a() {
        return this.f33994c != zzhlh.f33990e;
    }

    public final int b() {
        zzhlh zzhlhVar = zzhlh.f33990e;
        int i2 = this.f33993b;
        zzhlh zzhlhVar2 = this.f33994c;
        if (zzhlhVar2 == zzhlhVar) {
            return i2;
        }
        if (zzhlhVar2 == zzhlh.f33987b || zzhlhVar2 == zzhlh.f33988c || zzhlhVar2 == zzhlh.f33989d) {
            return i2 + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhli)) {
            return false;
        }
        zzhli zzhliVar = (zzhli) obj;
        return zzhliVar.f33992a == this.f33992a && zzhliVar.b() == b() && zzhliVar.f33994c == this.f33994c && zzhliVar.f33995d == this.f33995d;
    }

    public final int hashCode() {
        return Objects.hash(zzhli.class, Integer.valueOf(this.f33992a), Integer.valueOf(this.f33993b), this.f33994c, this.f33995d);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f33994c);
        String strValueOf2 = String.valueOf(this.f33995d);
        int length = strValueOf.length();
        int length2 = strValueOf2.length();
        int i2 = this.f33993b;
        int length3 = String.valueOf(i2).length();
        int i3 = this.f33992a;
        StringBuilder sb = new StringBuilder(length + 38 + length2 + 2 + length3 + 16 + String.valueOf(i3).length() + 10);
        android.support.v4.media.b.B(sb, "HMAC Parameters (variant: ", strValueOf, ", hashType: ", strValueOf2);
        androidx.fragment.app.e.w(i2, i3, ", ", "-byte tags, and ", sb);
        sb.append("-byte key)");
        return sb.toString();
    }
}
