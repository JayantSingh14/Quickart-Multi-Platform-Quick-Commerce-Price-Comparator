package com.zeptonow.horizon.storage;

import android.support.v4.media.a;
import androidx.fragment.app.e;
import com.zeptonow.horizon.entity.EventStatus;
import com.zeptonow.horizon.entity.EventType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class EventEntity {

    /* renamed from: a, reason: collision with root package name */
    public final String f48164a;

    /* renamed from: b, reason: collision with root package name */
    public final String f48165b;

    /* renamed from: c, reason: collision with root package name */
    public final String f48166c;

    /* renamed from: d, reason: collision with root package name */
    public final long f48167d;

    /* renamed from: e, reason: collision with root package name */
    public final long f48168e;

    /* renamed from: f, reason: collision with root package name */
    public final EventStatus f48169f;

    /* renamed from: g, reason: collision with root package name */
    public final String f48170g;

    /* renamed from: h, reason: collision with root package name */
    public final EventType f48171h;

    @Metadata
    public static final class Adapter {
    }

    public EventEntity(String eventId, String name, String properties, long j2, long j3, EventStatus status, String str, EventType eventType) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        this.f48164a = eventId;
        this.f48165b = name;
        this.f48166c = properties;
        this.f48167d = j2;
        this.f48168e = j3;
        this.f48169f = status;
        this.f48170g = str;
        this.f48171h = eventType;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EventEntity)) {
            return false;
        }
        EventEntity eventEntity = (EventEntity) obj;
        return Intrinsics.b(this.f48164a, eventEntity.f48164a) && Intrinsics.b(this.f48165b, eventEntity.f48165b) && Intrinsics.b(this.f48166c, eventEntity.f48166c) && this.f48167d == eventEntity.f48167d && this.f48168e == eventEntity.f48168e && this.f48169f == eventEntity.f48169f && Intrinsics.b(this.f48170g, eventEntity.f48170g) && this.f48171h == eventEntity.f48171h;
    }

    public final int hashCode() {
        int iHashCode = (this.f48169f.hashCode() + a.d(a.d(e.e(e.e(this.f48164a.hashCode() * 31, 31, this.f48165b), 31, this.f48166c), 31, this.f48167d), 31, this.f48168e)) * 31;
        String str = this.f48170g;
        return this.f48171h.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
    }

    public final String toString() {
        return "EventEntity(eventId=" + this.f48164a + ", name=" + this.f48165b + ", properties=" + this.f48166c + ", timestamp=" + this.f48167d + ", failureCount=" + this.f48168e + ", status=" + this.f48169f + ", lastFailureReason=" + this.f48170g + ", eventType=" + this.f48171h + ')';
    }
}
