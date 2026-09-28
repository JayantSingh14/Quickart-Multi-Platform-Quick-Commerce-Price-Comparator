package com.facebook.react.fabric;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class SynchronousEvent {

    @NotNull
    private final String eventName;
    private final int surfaceId;
    private final int viewTag;

    public SynchronousEvent(int i2, int i3, @NotNull String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.surfaceId = i2;
        this.viewTag = i3;
        this.eventName = eventName;
    }

    public static /* synthetic */ SynchronousEvent copy$default(SynchronousEvent synchronousEvent, int i2, int i3, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = synchronousEvent.surfaceId;
        }
        if ((i4 & 2) != 0) {
            i3 = synchronousEvent.viewTag;
        }
        if ((i4 & 4) != 0) {
            str = synchronousEvent.eventName;
        }
        return synchronousEvent.copy(i2, i3, str);
    }

    public final int component1() {
        return this.surfaceId;
    }

    public final int component2() {
        return this.viewTag;
    }

    @NotNull
    public final String component3() {
        return this.eventName;
    }

    @NotNull
    public final SynchronousEvent copy(int i2, int i3, @NotNull String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        return new SynchronousEvent(i2, i3, eventName);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SynchronousEvent)) {
            return false;
        }
        SynchronousEvent synchronousEvent = (SynchronousEvent) obj;
        return this.surfaceId == synchronousEvent.surfaceId && this.viewTag == synchronousEvent.viewTag && Intrinsics.b(this.eventName, synchronousEvent.eventName);
    }

    @NotNull
    public final String getEventName() {
        return this.eventName;
    }

    public final int getSurfaceId() {
        return this.surfaceId;
    }

    public final int getViewTag() {
        return this.viewTag;
    }

    public int hashCode() {
        return this.eventName.hashCode() + android.support.v4.media.a.b(this.viewTag, Integer.hashCode(this.surfaceId) * 31, 31);
    }

    @NotNull
    public String toString() {
        int i2 = this.surfaceId;
        int i3 = this.viewTag;
        return b.r(b.t(i2, i3, "SynchronousEvent(surfaceId=", ", viewTag=", ", eventName="), this.eventName, ")");
    }
}
