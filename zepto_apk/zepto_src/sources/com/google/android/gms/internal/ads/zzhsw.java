package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzhsw extends zzhts {

    /* renamed from: e, reason: collision with root package name */
    public static final BigInteger f34191e = BigInteger.valueOf(65537);

    /* renamed from: a, reason: collision with root package name */
    public final int f34192a;

    /* renamed from: b, reason: collision with root package name */
    public final BigInteger f34193b;

    /* renamed from: c, reason: collision with root package name */
    public final zzhsv f34194c;

    /* renamed from: d, reason: collision with root package name */
    public final zzhsu f34195d;

    public /* synthetic */ zzhsw(int i2, BigInteger bigInteger, zzhsv zzhsvVar, zzhsu zzhsuVar) {
        this.f34192a = i2;
        this.f34193b = bigInteger;
        this.f34194c = zzhsvVar;
        this.f34195d = zzhsuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhan
    public final boolean a() {
        return this.f34194c != zzhsv.f34189e;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhsw)) {
            return false;
        }
        zzhsw zzhswVar = (zzhsw) obj;
        return zzhswVar.f34192a == this.f34192a && Objects.equals(zzhswVar.f34193b, this.f34193b) && zzhswVar.f34194c == this.f34194c && zzhswVar.f34195d == this.f34195d;
    }

    public final int hashCode() {
        return Objects.hash(zzhsw.class, Integer.valueOf(this.f34192a), this.f34193b, this.f34194c, this.f34195d);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f34194c);
        String strValueOf2 = String.valueOf(this.f34195d);
        String strValueOf3 = String.valueOf(this.f34193b);
        int length = strValueOf.length();
        int length2 = strValueOf2.length();
        int length3 = strValueOf3.length();
        int i2 = this.f34192a;
        StringBuilder sb = new StringBuilder(length + 47 + length2 + 18 + length3 + 6 + String.valueOf(i2).length() + 13);
        android.support.v4.media.b.B(sb, "RSA SSA PKCS1 Parameters (variant: ", strValueOf, ", hashType: ", strValueOf2);
        sb.append(", publicExponent: ");
        sb.append(strValueOf3);
        sb.append(", and ");
        sb.append(i2);
        sb.append("-bit modulus)");
        return sb.toString();
    }
}
