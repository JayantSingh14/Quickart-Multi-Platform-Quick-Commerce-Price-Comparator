package com.google.firebase.sessions;

import androidx.fragment.app.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class SessionInfo {

    /* renamed from: a, reason: collision with root package name */
    public final String f45094a;

    /* renamed from: b, reason: collision with root package name */
    public final String f45095b;

    /* renamed from: c, reason: collision with root package name */
    public final int f45096c;

    /* renamed from: d, reason: collision with root package name */
    public final long f45097d;

    /* renamed from: e, reason: collision with root package name */
    public final DataCollectionStatus f45098e;

    /* renamed from: f, reason: collision with root package name */
    public final String f45099f;

    /* renamed from: g, reason: collision with root package name */
    public final String f45100g;

    public SessionInfo(String sessionId, String firstSessionId, int i2, long j2, DataCollectionStatus dataCollectionStatus, String firebaseInstallationId, String firebaseAuthenticationToken) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(firstSessionId, "firstSessionId");
        Intrinsics.checkNotNullParameter(dataCollectionStatus, "dataCollectionStatus");
        Intrinsics.checkNotNullParameter(firebaseInstallationId, "firebaseInstallationId");
        Intrinsics.checkNotNullParameter(firebaseAuthenticationToken, "firebaseAuthenticationToken");
        this.f45094a = sessionId;
        this.f45095b = firstSessionId;
        this.f45096c = i2;
        this.f45097d = j2;
        this.f45098e = dataCollectionStatus;
        this.f45099f = firebaseInstallationId;
        this.f45100g = firebaseAuthenticationToken;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionInfo)) {
            return false;
        }
        SessionInfo sessionInfo = (SessionInfo) obj;
        return Intrinsics.b(this.f45094a, sessionInfo.f45094a) && Intrinsics.b(this.f45095b, sessionInfo.f45095b) && this.f45096c == sessionInfo.f45096c && this.f45097d == sessionInfo.f45097d && Intrinsics.b(this.f45098e, sessionInfo.f45098e) && Intrinsics.b(this.f45099f, sessionInfo.f45099f) && Intrinsics.b(this.f45100g, sessionInfo.f45100g);
    }

    public final int hashCode() {
        return this.f45100g.hashCode() + e.e((this.f45098e.hashCode() + android.support.v4.media.a.d(android.support.v4.media.a.b(this.f45096c, e.e(this.f45094a.hashCode() * 31, 31, this.f45095b), 31), 31, this.f45097d)) * 31, 31, this.f45099f);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SessionInfo(sessionId=");
        sb.append(this.f45094a);
        sb.append(", firstSessionId=");
        sb.append(this.f45095b);
        sb.append(", sessionIndex=");
        sb.append(this.f45096c);
        sb.append(", eventTimestampUs=");
        sb.append(this.f45097d);
        sb.append(", dataCollectionStatus=");
        sb.append(this.f45098e);
        sb.append(", firebaseInstallationId=");
        sb.append(this.f45099f);
        sb.append(", firebaseAuthenticationToken=");
        return e.t(sb, this.f45100g, ')');
    }
}
