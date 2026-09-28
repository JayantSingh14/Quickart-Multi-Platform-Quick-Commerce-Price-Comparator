package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;

/* loaded from: classes3.dex */
final class AutoValue_PersistedEvent extends PersistedEvent {

    /* renamed from: a, reason: collision with root package name */
    public final long f20929a;

    /* renamed from: b, reason: collision with root package name */
    public final TransportContext f20930b;

    /* renamed from: c, reason: collision with root package name */
    public final EventInternal f20931c;

    public AutoValue_PersistedEvent(long j2, TransportContext transportContext, EventInternal eventInternal) {
        this.f20929a = j2;
        if (transportContext == null) {
            throw new NullPointerException("Null transportContext");
        }
        this.f20930b = transportContext;
        if (eventInternal == null) {
            throw new NullPointerException("Null event");
        }
        this.f20931c = eventInternal;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent
    public final EventInternal b() {
        return this.f20931c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent
    public final long c() {
        return this.f20929a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent
    public final TransportContext d() {
        return this.f20930b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedEvent)) {
            return false;
        }
        PersistedEvent persistedEvent = (PersistedEvent) obj;
        return this.f20929a == persistedEvent.c() && this.f20930b.equals(persistedEvent.d()) && this.f20931c.equals(persistedEvent.b());
    }

    public final int hashCode() {
        long j2 = this.f20929a;
        return ((((((int) ((j2 >>> 32) ^ j2)) ^ 1000003) * 1000003) ^ this.f20930b.hashCode()) * 1000003) ^ this.f20931c.hashCode();
    }

    public final String toString() {
        return "PersistedEvent{id=" + this.f20929a + ", transportContext=" + this.f20930b + ", event=" + this.f20931c + "}";
    }
}
