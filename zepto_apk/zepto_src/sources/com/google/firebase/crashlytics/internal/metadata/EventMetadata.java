package com.google.firebase.crashlytics.internal.metadata;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class EventMetadata {

    /* renamed from: a, reason: collision with root package name */
    public final String f43894a;

    /* renamed from: b, reason: collision with root package name */
    public final long f43895b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f43896c;

    public EventMetadata(String sessionId, long j2, Map additionalCustomKeys) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(additionalCustomKeys, "additionalCustomKeys");
        this.f43894a = sessionId;
        this.f43895b = j2;
        this.f43896c = additionalCustomKeys;
    }

    public final Map a() {
        return this.f43896c;
    }

    public final String b() {
        return this.f43894a;
    }

    public final long c() {
        return this.f43895b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EventMetadata)) {
            return false;
        }
        EventMetadata eventMetadata = (EventMetadata) obj;
        return Intrinsics.b(this.f43894a, eventMetadata.f43894a) && this.f43895b == eventMetadata.f43895b && Intrinsics.b(this.f43896c, eventMetadata.f43896c);
    }

    public final int hashCode() {
        return this.f43896c.hashCode() + android.support.v4.media.a.d(this.f43894a.hashCode() * 31, 31, this.f43895b);
    }

    public final String toString() {
        return "EventMetadata(sessionId=" + this.f43894a + ", timestamp=" + this.f43895b + ", additionalCustomKeys=" + this.f43896c + ')';
    }
}
