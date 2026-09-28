package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzheo extends zzhbf {

    /* renamed from: a, reason: collision with root package name */
    public final zzhen f33668a;

    /* renamed from: b, reason: collision with root package name */
    public final int f33669b;

    public zzheo(zzhen zzhenVar, int i2) {
        this.f33668a = zzhenVar;
        this.f33669b = i2;
    }

    public static zzheo b(zzhen zzhenVar, int i2) throws GeneralSecurityException {
        if (i2 < 8 || i2 > 12) {
            throw new GeneralSecurityException("Salt size must be between 8 and 12 bytes");
        }
        return new zzheo(zzhenVar, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhan
    public final boolean a() {
        return this.f33668a != zzhen.f33666c;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzheo)) {
            return false;
        }
        zzheo zzheoVar = (zzheo) obj;
        return zzheoVar.f33668a == this.f33668a && zzheoVar.f33669b == this.f33669b;
    }

    public final int hashCode() {
        return Objects.hash(zzheo.class, this.f33668a, Integer.valueOf(this.f33669b));
    }

    public final String toString() {
        String string = this.f33668a.toString();
        int length = string.length();
        int i2 = this.f33669b;
        StringBuilder sb = new StringBuilder(length + 48 + String.valueOf(i2).length() + 1);
        sb.append("X-AES-GCM Parameters (variant: ");
        sb.append(string);
        sb.append("salt_size_bytes: ");
        sb.append(i2);
        sb.append(")");
        return sb.toString();
    }
}
