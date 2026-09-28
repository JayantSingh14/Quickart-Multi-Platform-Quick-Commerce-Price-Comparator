package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzaib extends zzaig {

    /* renamed from: b, reason: collision with root package name */
    public final String f23175b;

    /* renamed from: c, reason: collision with root package name */
    public final String f23176c;

    /* renamed from: d, reason: collision with root package name */
    public final String f23177d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f23178e;

    public zzaib(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f23175b = str;
        this.f23176c = str2;
        this.f23177d = str3;
        this.f23178e = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaib.class == obj.getClass()) {
            zzaib zzaibVar = (zzaib) obj;
            if (Objects.equals(this.f23175b, zzaibVar.f23175b) && Objects.equals(this.f23176c, zzaibVar.f23176c) && Objects.equals(this.f23177d, zzaibVar.f23177d) && Arrays.equals(this.f23178e, zzaibVar.f23178e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f23175b;
        return Arrays.hashCode(this.f23178e) + ((this.f23177d.hashCode() + ((this.f23176c.hashCode() + (((str != null ? str.hashCode() : 0) + 527) * 31)) * 31)) * 31);
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final String toString() {
        String str = this.f23184a;
        int length = String.valueOf(str).length();
        String str2 = this.f23175b;
        int iB = android.support.v4.media.b.b(length, 11, String.valueOf(str2).length(), 11);
        String str3 = this.f23176c;
        int iC = androidx.fragment.app.e.C(iB, 14, str3);
        String str4 = this.f23177d;
        StringBuilder sb = new StringBuilder(str4.length() + iC);
        android.support.v4.media.b.B(sb, str, ": mimeType=", str2, ", filename=");
        return android.support.v4.media.b.s(sb, str3, ", description=", str4);
    }
}
