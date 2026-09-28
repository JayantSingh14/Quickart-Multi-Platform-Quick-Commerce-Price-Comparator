package com.falcon.notification.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class NotificationMetadata {

    /* renamed from: a, reason: collision with root package name */
    public final int f20485a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f20486b;

    /* renamed from: c, reason: collision with root package name */
    public final Long f20487c;

    public NotificationMetadata(int i2, boolean z, Long l2) {
        this.f20485a = i2;
        this.f20486b = z;
        this.f20487c = l2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotificationMetadata)) {
            return false;
        }
        NotificationMetadata notificationMetadata = (NotificationMetadata) obj;
        return this.f20485a == notificationMetadata.f20485a && this.f20486b == notificationMetadata.f20486b && Intrinsics.b(this.f20487c, notificationMetadata.f20487c);
    }

    public final int hashCode() {
        int iHashCode = (Boolean.hashCode(this.f20486b) + (Integer.hashCode(this.f20485a) * 31)) * 31;
        Long l2 = this.f20487c;
        return iHashCode + (l2 == null ? 0 : l2.hashCode());
    }

    public final String toString() {
        return "NotificationMetadata(id=" + this.f20485a + ", isOngoing=" + this.f20486b + ", endTime=" + this.f20487c + ")";
    }
}
