package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzhck extends zzhbf {

    /* renamed from: a, reason: collision with root package name */
    public final int f33536a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhcj f33537b;

    public /* synthetic */ zzhck(int i2, zzhcj zzhcjVar) {
        this.f33536a = i2;
        this.f33537b = zzhcjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhan
    public final boolean a() {
        return this.f33537b != zzhcj.f33534d;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhck)) {
            return false;
        }
        zzhck zzhckVar = (zzhck) obj;
        return zzhckVar.f33536a == this.f33536a && zzhckVar.f33537b == this.f33537b;
    }

    public final int hashCode() {
        return Objects.hash(zzhck.class, Integer.valueOf(this.f33536a), 12, 16, this.f33537b);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f33537b);
        int length = strValueOf.length();
        int length2 = String.valueOf(12).length();
        int length3 = String.valueOf(16).length();
        int i2 = this.f33536a;
        StringBuilder sb = new StringBuilder(android.support.v4.media.b.b(length + 30 + length2 + 10 + length3, 15, String.valueOf(i2).length(), 10));
        sb.append("AesGcm Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", 12-byte IV, 16-byte tag, and ");
        sb.append(i2);
        sb.append("-byte key)");
        return sb.toString();
    }
}
