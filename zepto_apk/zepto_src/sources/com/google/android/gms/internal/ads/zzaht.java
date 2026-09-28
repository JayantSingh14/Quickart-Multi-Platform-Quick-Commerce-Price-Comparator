package com.google.android.gms.internal.ads;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzaht implements zzao {

    /* renamed from: a, reason: collision with root package name */
    public final int f23139a;

    /* renamed from: b, reason: collision with root package name */
    public final String f23140b;

    /* renamed from: c, reason: collision with root package name */
    public final String f23141c;

    /* renamed from: d, reason: collision with root package name */
    public final int f23142d;

    /* renamed from: e, reason: collision with root package name */
    public final int f23143e;

    /* renamed from: f, reason: collision with root package name */
    public final int f23144f;

    /* renamed from: g, reason: collision with root package name */
    public final int f23145g;

    /* renamed from: h, reason: collision with root package name */
    public final byte[] f23146h;

    public zzaht(int i2, String str, String str2, int i3, int i4, int i5, int i6, byte[] bArr) {
        this.f23139a = i2;
        this.f23140b = str;
        this.f23141c = str2;
        this.f23142d = i3;
        this.f23143e = i4;
        this.f23144f = i5;
        this.f23145g = i6;
        this.f23146h = bArr;
    }

    public static zzaht b(zzer zzerVar) {
        int iB = zzerVar.b();
        String strH = zzas.h(zzerVar.k(zzerVar.b(), StandardCharsets.US_ASCII));
        String strK = zzerVar.k(zzerVar.b(), StandardCharsets.UTF_8);
        int iB2 = zzerVar.b();
        int iB3 = zzerVar.b();
        int iB4 = zzerVar.b();
        int iB5 = zzerVar.b();
        int iB6 = zzerVar.b();
        byte[] bArr = new byte[iB6];
        zzerVar.H(0, bArr, iB6);
        return new zzaht(iB, strH, strK, iB2, iB3, iB4, iB5, bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzao
    public final void a(zzam zzamVar) {
        zzamVar.a(this.f23139a, this.f23146h);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaht.class == obj.getClass()) {
            zzaht zzahtVar = (zzaht) obj;
            if (this.f23139a == zzahtVar.f23139a && this.f23140b.equals(zzahtVar.f23140b) && this.f23141c.equals(zzahtVar.f23141c) && this.f23142d == zzahtVar.f23142d && this.f23143e == zzahtVar.f23143e && this.f23144f == zzahtVar.f23144f && this.f23145g == zzahtVar.f23145g && Arrays.equals(this.f23146h, zzahtVar.f23146h)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f23146h) + ((((((((((this.f23141c.hashCode() + ((this.f23140b.hashCode() + ((this.f23139a + 527) * 31)) * 31)) * 31) + this.f23142d) * 31) + this.f23143e) * 31) + this.f23144f) * 31) + this.f23145g) * 31);
    }

    public final String toString() {
        String str = this.f23140b;
        int length = String.valueOf(str).length() + 32;
        String str2 = this.f23141c;
        return android.support.v4.media.a.n(new StringBuilder(str2.length() + length), "Picture: mimeType=", str, ", description=", str2);
    }
}
