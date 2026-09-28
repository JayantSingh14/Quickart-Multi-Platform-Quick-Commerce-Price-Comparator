package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzaii extends zzaig {

    /* renamed from: b, reason: collision with root package name */
    public final String f23186b;

    /* renamed from: c, reason: collision with root package name */
    public final String f23187c;

    /* renamed from: d, reason: collision with root package name */
    public final String f23188d;

    public zzaii(String str, String str2, String str3) {
        super("----");
        this.f23186b = str;
        this.f23187c = str2;
        this.f23188d = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaii.class == obj.getClass()) {
            zzaii zzaiiVar = (zzaii) obj;
            if (Objects.equals(this.f23187c, zzaiiVar.f23187c) && Objects.equals(this.f23186b, zzaiiVar.f23186b) && Objects.equals(this.f23188d, zzaiiVar.f23188d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f23188d.hashCode() + ((this.f23187c.hashCode() + ((this.f23186b.hashCode() + 527) * 31)) * 31);
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final String toString() {
        String str = this.f23184a;
        int length = String.valueOf(str).length() + 9;
        String str2 = this.f23186b;
        int iC = androidx.fragment.app.e.C(length, 14, str2);
        String str3 = this.f23187c;
        StringBuilder sb = new StringBuilder(str3.length() + iC);
        android.support.v4.media.b.B(sb, str, ": domain=", str2, ", description=");
        sb.append(str3);
        return sb.toString();
    }
}
