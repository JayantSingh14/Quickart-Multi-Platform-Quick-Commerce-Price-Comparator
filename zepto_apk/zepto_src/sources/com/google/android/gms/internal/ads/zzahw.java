package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzahw extends zzaig {

    /* renamed from: b, reason: collision with root package name */
    public final String f23155b;

    /* renamed from: c, reason: collision with root package name */
    public final String f23156c;

    /* renamed from: d, reason: collision with root package name */
    public final int f23157d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f23158e;

    public zzahw(int i2, String str, String str2, byte[] bArr) {
        super("APIC");
        this.f23155b = str;
        this.f23156c = str2;
        this.f23157d = i2;
        this.f23158e = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzao
    public final void a(zzam zzamVar) {
        zzamVar.a(this.f23157d, this.f23158e);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzahw.class == obj.getClass()) {
            zzahw zzahwVar = (zzahw) obj;
            if (this.f23157d == zzahwVar.f23157d && Objects.equals(this.f23155b, zzahwVar.f23155b) && Objects.equals(this.f23156c, zzahwVar.f23156c) && Arrays.equals(this.f23158e, zzahwVar.f23158e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f23155b;
        int iHashCode = str != null ? str.hashCode() : 0;
        String str2 = this.f23156c;
        return Arrays.hashCode(this.f23158e) + ((((((this.f23157d + 527) * 31) + iHashCode) * 31) + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final String toString() {
        String str = this.f23184a;
        int length = String.valueOf(str).length();
        String str2 = this.f23155b;
        int length2 = String.valueOf(str2).length();
        String str3 = this.f23156c;
        StringBuilder sb = new StringBuilder(length + 11 + length2 + 14 + String.valueOf(str3).length());
        android.support.v4.media.b.B(sb, str, ": mimeType=", str2, ", description=");
        sb.append(str3);
        return sb.toString();
    }
}
