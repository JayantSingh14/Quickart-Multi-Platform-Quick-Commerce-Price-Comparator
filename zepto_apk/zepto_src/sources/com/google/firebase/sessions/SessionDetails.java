package com.google.firebase.sessions;

import androidx.fragment.app.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class SessionDetails {

    /* renamed from: a, reason: collision with root package name */
    public final String f45054a;

    /* renamed from: b, reason: collision with root package name */
    public final String f45055b;

    /* renamed from: c, reason: collision with root package name */
    public final int f45056c;

    /* renamed from: d, reason: collision with root package name */
    public final long f45057d;

    public SessionDetails(long j2, String sessionId, String firstSessionId, int i2) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(firstSessionId, "firstSessionId");
        this.f45054a = sessionId;
        this.f45055b = firstSessionId;
        this.f45056c = i2;
        this.f45057d = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionDetails)) {
            return false;
        }
        SessionDetails sessionDetails = (SessionDetails) obj;
        return Intrinsics.b(this.f45054a, sessionDetails.f45054a) && Intrinsics.b(this.f45055b, sessionDetails.f45055b) && this.f45056c == sessionDetails.f45056c && this.f45057d == sessionDetails.f45057d;
    }

    public final int hashCode() {
        return Long.hashCode(this.f45057d) + android.support.v4.media.a.b(this.f45056c, e.e(this.f45054a.hashCode() * 31, 31, this.f45055b), 31);
    }

    public final String toString() {
        return "SessionDetails(sessionId=" + this.f45054a + ", firstSessionId=" + this.f45055b + ", sessionIndex=" + this.f45056c + ", sessionStartTimestampUs=" + this.f45057d + ')';
    }
}
