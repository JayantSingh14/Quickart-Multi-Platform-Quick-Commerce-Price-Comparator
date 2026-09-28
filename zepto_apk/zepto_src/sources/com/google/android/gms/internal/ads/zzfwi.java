package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzfwi extends zzfwo {

    /* renamed from: b, reason: collision with root package name */
    public final String f31975b;

    /* renamed from: c, reason: collision with root package name */
    public final int f31976c;

    /* renamed from: d, reason: collision with root package name */
    public final int f31977d;

    public /* synthetic */ zzfwi(String str, int i2, int i3) {
        this.f31975b = str;
        this.f31976c = i2;
        this.f31977d = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzfwo
    public final String a() {
        return this.f31975b;
    }

    @Override // com.google.android.gms.internal.ads.zzfwo
    public final int b() {
        return this.f31976c;
    }

    @Override // com.google.android.gms.internal.ads.zzfwo
    public final int c() {
        return this.f31977d;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof zzfwo)) {
                return false;
            }
            zzfwo zzfwoVar = (zzfwo) obj;
            if (!this.f31975b.equals(zzfwoVar.a())) {
                return false;
            }
            int iB = zzfwoVar.b();
            int i2 = this.f31976c;
            if (i2 == 0) {
                throw null;
            }
            if (i2 != iB) {
                return false;
            }
            int iC = zzfwoVar.c();
            if (this.f31977d == 0) {
                throw null;
            }
            if (iC != 1) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int iHashCode = this.f31975b.hashCode() ^ 1000003;
        int i2 = this.f31976c;
        if (i2 == 0) {
            throw null;
        }
        int i3 = (((iHashCode * 1000003) ^ 1237) * 1000003) ^ i2;
        if (this.f31977d != 0) {
            return (i3 * (-721379959)) ^ 1;
        }
        throw null;
    }

    public final String toString() {
        int i2 = this.f31976c;
        String str = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "null" : "NO_CHECKS" : "SKIP_SECURITY_CHECK" : "SKIP_COMPLIANCE_CHECK" : "ALL_CHECKS";
        String str2 = this.f31977d == 1 ? "READ_AND_WRITE" : "null";
        String str3 = this.f31975b;
        StringBuilder sb = new StringBuilder(str2.length() + androidx.fragment.app.e.C(androidx.fragment.app.e.g(73, str3), 52, str) + 1);
        android.support.v4.media.b.B(sb, "FileComplianceOptions{fileOwner=", str3, ", hasDifferentDmaOwner=false, fileChecks=", str);
        return android.support.v4.media.b.s(sb, ", multipleProductIdGroupsResolver=null, filePurpose=", str2, "}");
    }
}
