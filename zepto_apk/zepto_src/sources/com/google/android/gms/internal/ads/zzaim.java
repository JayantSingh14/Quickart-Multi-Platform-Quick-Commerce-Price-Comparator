package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzaim extends zzaig {

    /* renamed from: b, reason: collision with root package name */
    public final String f23198b;

    /* renamed from: c, reason: collision with root package name */
    public final String f23199c;

    public zzaim(String str, String str2, String str3) {
        super(str);
        this.f23198b = str2;
        this.f23199c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaim.class == obj.getClass()) {
            zzaim zzaimVar = (zzaim) obj;
            if (this.f23184a.equals(zzaimVar.f23184a) && Objects.equals(this.f23198b, zzaimVar.f23198b) && Objects.equals(this.f23199c, zzaimVar.f23199c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f23184a.hashCode() + 527;
        String str = this.f23198b;
        return this.f23199c.hashCode() + (((iHashCode * 31) + (str != null ? str.hashCode() : 0)) * 31);
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final String toString() {
        String str = this.f23184a;
        int length = String.valueOf(str).length() + 6;
        String str2 = this.f23199c;
        return android.support.v4.media.b.s(new StringBuilder(str2.length() + length), str, ": url=", str2);
    }
}
