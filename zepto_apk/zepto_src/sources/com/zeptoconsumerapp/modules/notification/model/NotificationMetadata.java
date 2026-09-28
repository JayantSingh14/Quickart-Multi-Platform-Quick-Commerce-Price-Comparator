package com.zeptoconsumerapp.modules.notification.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class NotificationMetadata {

    /* renamed from: a, reason: collision with root package name */
    public final int f47686a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f47687b;

    /* renamed from: c, reason: collision with root package name */
    public final Long f47688c;

    public NotificationMetadata(int i2, boolean z, Long l2) {
        this.f47686a = i2;
        this.f47687b = z;
        this.f47688c = l2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotificationMetadata)) {
            return false;
        }
        NotificationMetadata notificationMetadata = (NotificationMetadata) obj;
        return this.f47686a == notificationMetadata.f47686a && this.f47687b == notificationMetadata.f47687b && Intrinsics.b(this.f47688c, notificationMetadata.f47688c);
    }

    public final int hashCode() {
        int iHashCode = (Boolean.hashCode(this.f47687b) + (Integer.hashCode(this.f47686a) * 31)) * 31;
        Long l2 = this.f47688c;
        return iHashCode + (l2 == null ? 0 : l2.hashCode());
    }

    public final String toString() {
        return "NotificationMetadata(id=" + this.f47686a + ", isOngoing=" + this.f47687b + ", endTime=" + this.f47688c + ")";
    }
}
