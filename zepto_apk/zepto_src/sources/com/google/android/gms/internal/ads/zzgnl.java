package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzgnl extends zzgnt {

    /* renamed from: a, reason: collision with root package name */
    public final String f32975a;

    /* renamed from: b, reason: collision with root package name */
    public final String f32976b;

    public /* synthetic */ zzgnl(String str, String str2) {
        this.f32975a = str;
        this.f32976b = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzgnt
    public final String a() {
        return this.f32975a;
    }

    @Override // com.google.android.gms.internal.ads.zzgnt
    public final String b() {
        return this.f32976b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgnt)) {
            return false;
        }
        zzgnt zzgntVar = (zzgnt) obj;
        String str = this.f32975a;
        if (str == null) {
            if (zzgntVar.a() != null) {
                return false;
            }
        } else if (!str.equals(zzgntVar.a())) {
            return false;
        }
        String str2 = this.f32976b;
        return str2 == null ? zzgntVar.b() == null : str2.equals(zzgntVar.b());
    }

    public final int hashCode() {
        String str = this.f32975a;
        int iHashCode = str == null ? 0 : str.hashCode();
        String str2 = this.f32976b;
        return (str2 != null ? str2.hashCode() : 0) ^ ((iHashCode ^ 1000003) * 1000003);
    }

    public final String toString() {
        String str = this.f32975a;
        int length = String.valueOf(str).length();
        String str2 = this.f32976b;
        StringBuilder sb = new StringBuilder(length + 50 + String.valueOf(str2).length() + 1);
        android.support.v4.media.b.B(sb, "OverlayDisplayDismissRequest{sessionToken=", str, ", appId=", str2);
        sb.append("}");
        return sb.toString();
    }
}
