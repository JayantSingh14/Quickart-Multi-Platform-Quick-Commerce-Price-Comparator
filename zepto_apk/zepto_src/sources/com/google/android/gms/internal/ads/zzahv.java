package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzahv implements zzao {

    /* renamed from: a, reason: collision with root package name */
    public final int f23149a;

    /* renamed from: b, reason: collision with root package name */
    public final String f23150b;

    /* renamed from: c, reason: collision with root package name */
    public final String f23151c;

    /* renamed from: d, reason: collision with root package name */
    public final String f23152d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f23153e;

    /* renamed from: f, reason: collision with root package name */
    public final int f23154f;

    public zzahv(int i2, int i3, String str, String str2, String str3, boolean z) {
        boolean z2 = true;
        if (i3 != -1 && i3 <= 0) {
            z2 = false;
        }
        zzgqa.a(z2);
        this.f23149a = i2;
        this.f23150b = str;
        this.f23151c = str2;
        this.f23152d = str3;
        this.f23153e = z;
        this.f23154f = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzao
    public final void a(zzam zzamVar) {
        String str = this.f23151c;
        if (str != null) {
            zzamVar.x = str;
        }
        String str2 = this.f23150b;
        if (str2 != null) {
            zzamVar.w = str2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzahv.class == obj.getClass()) {
            zzahv zzahvVar = (zzahv) obj;
            if (this.f23149a == zzahvVar.f23149a && Objects.equals(this.f23150b, zzahvVar.f23150b) && Objects.equals(this.f23151c, zzahvVar.f23151c) && Objects.equals(this.f23152d, zzahvVar.f23152d) && this.f23153e == zzahvVar.f23153e && this.f23154f == zzahvVar.f23154f) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f23150b;
        int iHashCode = str != null ? str.hashCode() : 0;
        String str2 = this.f23151c;
        int iHashCode2 = str2 != null ? str2.hashCode() : 0;
        int i2 = ((this.f23149a + 527) * 31) + iHashCode;
        String str3 = this.f23152d;
        return (((((((i2 * 31) + iHashCode2) * 31) + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.f23153e ? 1 : 0)) * 31) + this.f23154f;
    }

    public final String toString() {
        String str = this.f23151c;
        int length = String.valueOf(str).length();
        String str2 = this.f23150b;
        int length2 = String.valueOf(str2).length();
        int i2 = this.f23149a;
        int length3 = String.valueOf(i2).length();
        int i3 = this.f23154f;
        StringBuilder sb = new StringBuilder(length + 28 + length2 + 11 + length3 + 19 + String.valueOf(i3).length());
        android.support.v4.media.b.B(sb, "IcyHeaders: name=\"", str, "\", genre=\"", str2);
        return androidx.fragment.app.e.n(i2, i3, "\", bitrate=", ", metadataInterval=", sb);
    }
}
