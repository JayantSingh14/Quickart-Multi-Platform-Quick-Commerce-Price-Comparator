package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.common.InstallIdProvider;

/* loaded from: classes.dex */
final class AutoValue_InstallIdProvider_InstallIds extends InstallIdProvider.InstallIds {

    /* renamed from: a, reason: collision with root package name */
    public final String f43727a;

    /* renamed from: b, reason: collision with root package name */
    public final String f43728b;

    /* renamed from: c, reason: collision with root package name */
    public final String f43729c;

    public AutoValue_InstallIdProvider_InstallIds(String str, String str2, String str3) {
        if (str == null) {
            throw new NullPointerException("Null crashlyticsInstallId");
        }
        this.f43727a = str;
        this.f43728b = str2;
        this.f43729c = str3;
    }

    @Override // com.google.firebase.crashlytics.internal.common.InstallIdProvider.InstallIds
    public final String a() {
        return this.f43727a;
    }

    @Override // com.google.firebase.crashlytics.internal.common.InstallIdProvider.InstallIds
    public final String b() {
        return this.f43729c;
    }

    @Override // com.google.firebase.crashlytics.internal.common.InstallIdProvider.InstallIds
    public final String c() {
        return this.f43728b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallIdProvider.InstallIds)) {
            return false;
        }
        InstallIdProvider.InstallIds installIds = (InstallIdProvider.InstallIds) obj;
        if (!this.f43727a.equals(installIds.a())) {
            return false;
        }
        String str = this.f43728b;
        if (str == null) {
            if (installIds.c() != null) {
                return false;
            }
        } else if (!str.equals(installIds.c())) {
            return false;
        }
        String str2 = this.f43729c;
        return str2 == null ? installIds.b() == null : str2.equals(installIds.b());
    }

    public final int hashCode() {
        int iHashCode = (this.f43727a.hashCode() ^ 1000003) * 1000003;
        String str = this.f43728b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f43729c;
        return iHashCode2 ^ (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("InstallIds{crashlyticsInstallId=");
        sb.append(this.f43727a);
        sb.append(", firebaseInstallationId=");
        sb.append(this.f43728b);
        sb.append(", firebaseAuthenticationToken=");
        return android.support.v4.media.b.r(sb, this.f43729c, "}");
    }
}
