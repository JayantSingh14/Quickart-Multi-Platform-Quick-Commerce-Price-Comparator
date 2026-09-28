package com.google.android.gms.internal.ads;

import android.app.Activity;

/* loaded from: classes4.dex */
final class zzehl extends zzeih {

    /* renamed from: a, reason: collision with root package name */
    public final Activity f29349a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.overlay.zzm f29350b;

    /* renamed from: c, reason: collision with root package name */
    public final String f29351c;

    /* renamed from: d, reason: collision with root package name */
    public final String f29352d;

    public /* synthetic */ zzehl(Activity activity, com.google.android.gms.ads.internal.overlay.zzm zzmVar, String str, String str2) {
        this.f29349a = activity;
        this.f29350b = zzmVar;
        this.f29351c = str;
        this.f29352d = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzeih
    public final Activity a() {
        return this.f29349a;
    }

    @Override // com.google.android.gms.internal.ads.zzeih
    public final com.google.android.gms.ads.internal.overlay.zzm b() {
        return this.f29350b;
    }

    @Override // com.google.android.gms.internal.ads.zzeih
    public final String c() {
        return this.f29351c;
    }

    @Override // com.google.android.gms.internal.ads.zzeih
    public final String d() {
        return this.f29352d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeih)) {
            return false;
        }
        zzeih zzeihVar = (zzeih) obj;
        if (!this.f29349a.equals(zzeihVar.a())) {
            return false;
        }
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.f29350b;
        if (zzmVar == null) {
            if (zzeihVar.b() != null) {
                return false;
            }
        } else if (!zzmVar.equals(zzeihVar.b())) {
            return false;
        }
        String str = this.f29351c;
        if (str == null) {
            if (zzeihVar.c() != null) {
                return false;
            }
        } else if (!str.equals(zzeihVar.c())) {
            return false;
        }
        String str2 = this.f29352d;
        return str2 == null ? zzeihVar.d() == null : str2.equals(zzeihVar.d());
    }

    public final int hashCode() {
        int iHashCode = this.f29349a.hashCode() ^ 1000003;
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.f29350b;
        int iHashCode2 = ((iHashCode * 1000003) ^ (zzmVar == null ? 0 : zzmVar.hashCode())) * 1000003;
        String str = this.f29351c;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f29352d;
        return iHashCode3 ^ (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        String string = this.f29349a.toString();
        int length = string.length();
        String strValueOf = String.valueOf(this.f29350b);
        int length2 = strValueOf.length();
        String str = this.f29351c;
        int length3 = String.valueOf(str).length();
        String str2 = this.f29352d;
        StringBuilder sb = new StringBuilder(length + 40 + length2 + 13 + length3 + 6 + String.valueOf(str2).length() + 1);
        android.support.v4.media.b.B(sb, "OfflineUtilsParams{activity=", string, ", adOverlay=", strValueOf);
        android.support.v4.media.b.B(sb, ", gwsQueryId=", str, ", uri=", str2);
        sb.append("}");
        return sb.toString();
    }
}
