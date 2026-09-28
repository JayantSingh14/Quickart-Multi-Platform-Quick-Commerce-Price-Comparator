package com.zeptoconsumerapp.modules.event.model.api;

import com.google.gson.annotations.SerializedName;
import com.zeptoconsumerapp.modules.event.model.entity.Event;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class EventRequestType {

    @SerializedName("events")
    @NotNull
    private final List<Event> events;

    public EventRequestType(List events) {
        Intrinsics.checkNotNullParameter(events, "events");
        this.events = events;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EventRequestType) && Intrinsics.b(this.events, ((EventRequestType) obj).events);
    }

    public final int hashCode() {
        return this.events.hashCode();
    }

    public final String toString() {
        return "EventRequestType(events=" + this.events + ")";
    }
}
