package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzhcb extends zzhbf {

    /* renamed from: a, reason: collision with root package name */
    public final int f33510a;

    /* renamed from: b, reason: collision with root package name */
    public final int f33511b;

    /* renamed from: c, reason: collision with root package name */
    public final zzhca f33512c;

    public /* synthetic */ zzhcb(int i2, int i3, zzhca zzhcaVar) {
        this.f33510a = i2;
        this.f33511b = i3;
        this.f33512c = zzhcaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhan
    public final boolean a() {
        return this.f33512c != zzhca.f33508d;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhcb)) {
            return false;
        }
        zzhcb zzhcbVar = (zzhcb) obj;
        return zzhcbVar.f33510a == this.f33510a && zzhcbVar.f33511b == this.f33511b && zzhcbVar.f33512c == this.f33512c;
    }

    public final int hashCode() {
        return Objects.hash(zzhcb.class, Integer.valueOf(this.f33510a), Integer.valueOf(this.f33511b), 16, this.f33512c);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f33512c);
        int length = strValueOf.length();
        int i2 = this.f33511b;
        int length2 = String.valueOf(i2).length();
        int length3 = String.valueOf(16).length();
        int i3 = this.f33510a;
        StringBuilder sb = new StringBuilder(android.support.v4.media.b.b(length + 30 + length2 + 10 + length3, 15, String.valueOf(i3).length(), 10));
        sb.append("AesEax Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", ");
        sb.append(i2);
        return androidx.fragment.app.e.u(sb, "-byte IV, 16-byte tag, and ", i3, "-byte key)");
    }
}
