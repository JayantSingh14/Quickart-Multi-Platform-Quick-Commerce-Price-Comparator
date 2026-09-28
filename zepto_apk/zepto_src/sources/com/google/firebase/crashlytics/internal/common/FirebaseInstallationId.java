package com.google.firebase.crashlytics.internal.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class FirebaseInstallationId {

    /* renamed from: a, reason: collision with root package name */
    public final String f43822a;

    /* renamed from: b, reason: collision with root package name */
    public final String f43823b;

    public FirebaseInstallationId(String str, String str2) {
        this.f43822a = str;
        this.f43823b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FirebaseInstallationId)) {
            return false;
        }
        FirebaseInstallationId firebaseInstallationId = (FirebaseInstallationId) obj;
        return Intrinsics.b(this.f43822a, firebaseInstallationId.f43822a) && Intrinsics.b(this.f43823b, firebaseInstallationId.f43823b);
    }

    public final int hashCode() {
        String str = this.f43822a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f43823b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FirebaseInstallationId(fid=");
        sb.append(this.f43822a);
        sb.append(", authToken=");
        return androidx.fragment.app.e.t(sb, this.f43823b, ')');
    }
}
