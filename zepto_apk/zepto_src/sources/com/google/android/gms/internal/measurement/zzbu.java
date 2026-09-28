package com.google.android.gms.internal.measurement;

import android.support.v4.media.b;
import androidx.fragment.app.e;

/* loaded from: classes.dex */
final class zzbu extends zzca {

    /* renamed from: b, reason: collision with root package name */
    public final String f36809b;

    /* renamed from: c, reason: collision with root package name */
    public final int f36810c;

    /* renamed from: d, reason: collision with root package name */
    public final int f36811d;

    public /* synthetic */ zzbu(String str, int i2, int i3) {
        this.f36809b = str;
        this.f36810c = i2;
        this.f36811d = i3;
    }

    @Override // com.google.android.gms.internal.measurement.zzca
    public final String a() {
        return this.f36809b;
    }

    @Override // com.google.android.gms.internal.measurement.zzca
    public final int b() {
        return this.f36810c;
    }

    @Override // com.google.android.gms.internal.measurement.zzca
    public final int c() {
        return this.f36811d;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof zzca)) {
                return false;
            }
            zzca zzcaVar = (zzca) obj;
            if (!this.f36809b.equals(zzcaVar.a())) {
                return false;
            }
            int iB = zzcaVar.b();
            int i2 = this.f36810c;
            if (i2 == 0) {
                throw null;
            }
            if (i2 != iB) {
                return false;
            }
            int iC = zzcaVar.c();
            if (this.f36811d == 0) {
                throw null;
            }
            if (iC != 1) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int iHashCode = this.f36809b.hashCode() ^ 1000003;
        int i2 = this.f36810c;
        if (i2 == 0) {
            throw null;
        }
        int i3 = (((iHashCode * 1000003) ^ 1237) * 1000003) ^ i2;
        if (this.f36811d != 0) {
            return (i3 * 583896283) ^ 1;
        }
        throw null;
    }

    public final String toString() {
        int i2 = this.f36810c;
        String str = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "null" : "NO_CHECKS" : "SKIP_SECURITY_CHECK" : "SKIP_COMPLIANCE_CHECK" : "ALL_CHECKS";
        String str2 = this.f36811d == 1 ? "READ_AND_WRITE" : "null";
        String str3 = this.f36809b;
        StringBuilder sb = new StringBuilder(str2.length() + e.C(e.g(73, str3), 91, str) + 1);
        b.B(sb, "FileComplianceOptions{fileOwner=", str3, ", hasDifferentDmaOwner=false, fileChecks=", str);
        return b.s(sb, ", dataForwardingNotAllowedResolver=null, multipleProductIdGroupsResolver=null, filePurpose=", str2, "}");
    }
}
