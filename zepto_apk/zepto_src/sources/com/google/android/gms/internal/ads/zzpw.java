package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzpw {

    /* renamed from: d, reason: collision with root package name */
    public static final zzpw f35355d = new zzpv().a();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f35356a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f35357b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f35358c;

    public /* synthetic */ zzpw(zzpv zzpvVar) {
        this.f35356a = zzpvVar.f35352a;
        this.f35357b = zzpvVar.f35353b;
        this.f35358c = zzpvVar.f35354c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzpw.class != obj.getClass()) {
            return false;
        }
        zzpw zzpwVar = (zzpw) obj;
        return this.f35356a == zzpwVar.f35356a && this.f35357b == zzpwVar.f35357b && this.f35358c == zzpwVar.f35358c;
    }

    public final int hashCode() {
        int i2 = (this.f35356a ? 1 : 0) << 2;
        boolean z = this.f35357b;
        return (z ? 1 : 0) + (z ? 1 : 0) + i2 + (this.f35358c ? 1 : 0);
    }
}
