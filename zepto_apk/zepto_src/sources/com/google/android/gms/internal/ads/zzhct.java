package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzhct extends zzhbf {

    /* renamed from: a, reason: collision with root package name */
    public final int f33558a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhcs f33559b;

    public /* synthetic */ zzhct(int i2, zzhcs zzhcsVar) {
        this.f33558a = i2;
        this.f33559b = zzhcsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhan
    public final boolean a() {
        return this.f33559b != zzhcs.f33556d;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhct)) {
            return false;
        }
        zzhct zzhctVar = (zzhct) obj;
        return zzhctVar.f33558a == this.f33558a && zzhctVar.f33559b == this.f33559b;
    }

    public final int hashCode() {
        return Objects.hash(zzhct.class, Integer.valueOf(this.f33558a), this.f33559b);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f33559b);
        int length = strValueOf.length();
        int i2 = this.f33558a;
        StringBuilder sb = new StringBuilder(length + 33 + String.valueOf(i2).length() + 10);
        sb.append("AesGcmSiv Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", ");
        sb.append(i2);
        sb.append("-byte key)");
        return sb.toString();
    }
}
