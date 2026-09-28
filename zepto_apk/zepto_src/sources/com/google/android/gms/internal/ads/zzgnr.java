package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzgnr extends zzgot {

    /* renamed from: a, reason: collision with root package name */
    public final String f32999a;

    /* renamed from: b, reason: collision with root package name */
    public final String f33000b;

    public /* synthetic */ zzgnr(String str, String str2) {
        this.f32999a = str;
        this.f33000b = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final String a() {
        return this.f32999a;
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final String b() {
        return this.f33000b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgot)) {
            return false;
        }
        zzgot zzgotVar = (zzgot) obj;
        String str = this.f32999a;
        if (str == null) {
            if (zzgotVar.a() != null) {
                return false;
            }
        } else if (!str.equals(zzgotVar.a())) {
            return false;
        }
        String str2 = this.f33000b;
        return str2 == null ? zzgotVar.b() == null : str2.equals(zzgotVar.b());
    }

    public final int hashCode() {
        String str = this.f32999a;
        int iHashCode = str == null ? 0 : str.hashCode();
        String str2 = this.f33000b;
        return (str2 != null ? str2.hashCode() : 0) ^ ((iHashCode ^ 1000003) * 1000003);
    }

    public final String toString() {
        String str = this.f32999a;
        int length = String.valueOf(str).length();
        String str2 = this.f33000b;
        StringBuilder sb = new StringBuilder(length + 49 + String.valueOf(str2).length() + 1);
        android.support.v4.media.b.B(sb, "OverlayDisplayUpdateRequest{sessionToken=", str, ", appId=", str2);
        sb.append("}");
        return sb.toString();
    }
}
