package com.google.firebase.sessions;

import com.google.firebase.encoders.annotations.Encodable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@Encodable
/* loaded from: classes.dex */
public final class SessionEvent {

    /* renamed from: a, reason: collision with root package name */
    public final SessionInfo f45058a;

    /* renamed from: b, reason: collision with root package name */
    public final ApplicationInfo f45059b;

    public SessionEvent(SessionInfo sessionData, ApplicationInfo applicationInfo) {
        EventType eventType = EventType.SESSION_START;
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(sessionData, "sessionData");
        Intrinsics.checkNotNullParameter(applicationInfo, "applicationInfo");
        this.f45058a = sessionData;
        this.f45059b = applicationInfo;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionEvent)) {
            return false;
        }
        SessionEvent sessionEvent = (SessionEvent) obj;
        sessionEvent.getClass();
        return this.f45058a.equals(sessionEvent.f45058a) && this.f45059b.equals(sessionEvent.f45059b);
    }

    public final int hashCode() {
        return this.f45059b.hashCode() + ((this.f45058a.hashCode() + (EventType.SESSION_START.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "SessionEvent(eventType=" + EventType.SESSION_START + ", sessionData=" + this.f45058a + ", applicationInfo=" + this.f45059b + ')';
    }
}
