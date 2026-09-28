package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzhti extends zzhts {

    /* renamed from: g, reason: collision with root package name */
    public static final BigInteger f34245g = BigInteger.valueOf(65537);

    /* renamed from: a, reason: collision with root package name */
    public final int f34246a;

    /* renamed from: b, reason: collision with root package name */
    public final BigInteger f34247b;

    /* renamed from: c, reason: collision with root package name */
    public final zzhth f34248c;

    /* renamed from: d, reason: collision with root package name */
    public final zzhtg f34249d;

    /* renamed from: e, reason: collision with root package name */
    public final zzhtg f34250e;

    /* renamed from: f, reason: collision with root package name */
    public final int f34251f;

    public /* synthetic */ zzhti(int i2, BigInteger bigInteger, zzhth zzhthVar, zzhtg zzhtgVar, zzhtg zzhtgVar2, int i3) {
        this.f34246a = i2;
        this.f34247b = bigInteger;
        this.f34248c = zzhthVar;
        this.f34249d = zzhtgVar;
        this.f34250e = zzhtgVar2;
        this.f34251f = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzhan
    public final boolean a() {
        return this.f34248c != zzhth.f34243e;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhti)) {
            return false;
        }
        zzhti zzhtiVar = (zzhti) obj;
        return zzhtiVar.f34246a == this.f34246a && Objects.equals(zzhtiVar.f34247b, this.f34247b) && Objects.equals(zzhtiVar.f34248c, this.f34248c) && Objects.equals(zzhtiVar.f34249d, this.f34249d) && Objects.equals(zzhtiVar.f34250e, this.f34250e) && zzhtiVar.f34251f == this.f34251f;
    }

    public final int hashCode() {
        return Objects.hash(zzhti.class, Integer.valueOf(this.f34246a), this.f34247b, this.f34248c, this.f34249d, this.f34250e, Integer.valueOf(this.f34251f));
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f34248c);
        String strValueOf2 = String.valueOf(this.f34249d);
        String strValueOf3 = String.valueOf(this.f34250e);
        String strValueOf4 = String.valueOf(this.f34247b);
        int length = strValueOf.length();
        int length2 = strValueOf2.length();
        int length3 = strValueOf3.length();
        int i2 = this.f34251f;
        int length4 = String.valueOf(i2).length();
        int length5 = strValueOf4.length();
        int i3 = this.f34246a;
        StringBuilder sb = new StringBuilder(length + 55 + length2 + 17 + length3 + 19 + length4 + 18 + length5 + 6 + String.valueOf(i3).length() + 13);
        android.support.v4.media.b.B(sb, "RSA SSA PSS Parameters (variant: ", strValueOf, ", signature hashType: ", strValueOf2);
        sb.append(", mgf1 hashType: ");
        sb.append(strValueOf3);
        sb.append(", saltLengthBytes: ");
        sb.append(i2);
        sb.append(", publicExponent: ");
        sb.append(strValueOf4);
        sb.append(", and ");
        sb.append(i3);
        sb.append("-bit modulus)");
        return sb.toString();
    }
}
