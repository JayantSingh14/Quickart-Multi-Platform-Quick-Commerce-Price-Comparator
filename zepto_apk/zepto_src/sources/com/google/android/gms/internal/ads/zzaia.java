package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzaia extends zzaig {

    /* renamed from: b, reason: collision with root package name */
    public final String f23172b;

    /* renamed from: c, reason: collision with root package name */
    public final String f23173c;

    /* renamed from: d, reason: collision with root package name */
    public final String f23174d;

    public zzaia(String str, String str2, String str3) {
        super("COMM");
        this.f23172b = str;
        this.f23173c = str2;
        this.f23174d = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaia.class == obj.getClass()) {
            zzaia zzaiaVar = (zzaia) obj;
            if (Objects.equals(this.f23173c, zzaiaVar.f23173c) && Objects.equals(this.f23172b, zzaiaVar.f23172b) && Objects.equals(this.f23174d, zzaiaVar.f23174d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f23173c.hashCode() + ((this.f23172b.hashCode() + 527) * 31);
        String str = this.f23174d;
        return (iHashCode * 31) + (str != null ? str.hashCode() : 0);
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final String toString() {
        String str = this.f23184a;
        int length = String.valueOf(str).length();
        String str2 = this.f23174d;
        int length2 = String.valueOf(str2).length();
        String str3 = this.f23172b;
        int iC = androidx.fragment.app.e.C(length + 11, 14, str3);
        String str4 = this.f23173c;
        StringBuilder sb = new StringBuilder(str4.length() + iC + 7 + length2);
        android.support.v4.media.b.B(sb, str, ": language=", str3, ", description=");
        return android.support.v4.media.b.s(sb, str4, ", text=", str2);
    }
}
