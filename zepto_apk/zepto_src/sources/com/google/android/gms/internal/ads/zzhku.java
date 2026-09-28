package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzhku extends zzhll {

    /* renamed from: a, reason: collision with root package name */
    public final int f33955a;

    /* renamed from: b, reason: collision with root package name */
    public final int f33956b;

    /* renamed from: c, reason: collision with root package name */
    public final zzhkt f33957c;

    public /* synthetic */ zzhku(int i2, int i3, zzhkt zzhktVar) {
        this.f33955a = i2;
        this.f33956b = i3;
        this.f33957c = zzhktVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhan
    public final boolean a() {
        return this.f33957c != zzhkt.f33953e;
    }

    public final int b() {
        zzhkt zzhktVar = zzhkt.f33953e;
        int i2 = this.f33956b;
        zzhkt zzhktVar2 = this.f33957c;
        if (zzhktVar2 == zzhktVar) {
            return i2;
        }
        if (zzhktVar2 == zzhkt.f33950b || zzhktVar2 == zzhkt.f33951c || zzhktVar2 == zzhkt.f33952d) {
            return i2 + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhku)) {
            return false;
        }
        zzhku zzhkuVar = (zzhku) obj;
        return zzhkuVar.f33955a == this.f33955a && zzhkuVar.b() == b() && zzhkuVar.f33957c == this.f33957c;
    }

    public final int hashCode() {
        return Objects.hash(zzhku.class, Integer.valueOf(this.f33955a), Integer.valueOf(this.f33956b), this.f33957c);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f33957c);
        int length = strValueOf.length();
        int i2 = this.f33956b;
        int length2 = String.valueOf(i2).length();
        int i3 = this.f33955a;
        StringBuilder sb = new StringBuilder(length + 32 + length2 + 16 + String.valueOf(i3).length() + 10);
        sb.append("AES-CMAC Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", ");
        sb.append(i2);
        return androidx.fragment.app.e.u(sb, "-byte tags, and ", i3, "-byte key)");
    }
}
