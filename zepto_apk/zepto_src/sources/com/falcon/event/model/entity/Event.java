package com.falcon.event.model.entity;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class Event {

    @SerializedName("data")
    @NotNull
    private final Map<String, Object> data;

    @SerializedName("event_type")
    @NotNull
    private final String eventType;

    public Event(String eventType, Map data) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(data, "data");
        this.eventType = eventType;
        this.data = data;
    }

    public final Map a() {
        return this.data;
    }

    public final String b() {
        return this.eventType;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        return Intrinsics.b(this.eventType, event.eventType) && Intrinsics.b(this.data, event.data);
    }

    public final int hashCode() {
        return this.data.hashCode() + (this.eventType.hashCode() * 31);
    }

    public final String toString() {
        return "Event(eventType=" + this.eventType + ", data=" + this.data + ")";
    }
}
