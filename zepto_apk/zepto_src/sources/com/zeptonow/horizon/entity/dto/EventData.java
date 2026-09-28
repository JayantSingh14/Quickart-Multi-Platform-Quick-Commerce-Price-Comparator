package com.zeptonow.horizon.entity.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import org.jetbrains.annotations.NotNull;

@Metadata
@Serializable
/* loaded from: classes.dex */
public final class EventData {

    @NotNull
    public static final Companion Companion = new Companion();

    /* renamed from: a, reason: collision with root package name */
    public final String f48093a;

    /* renamed from: b, reason: collision with root package name */
    public final JsonElement f48094b;

    @Metadata
    @SourceDebugExtension
    /* loaded from: classes4.dex */
    public static final class Companion {
        @NotNull
        public final KSerializer<EventData> serializer() {
            return EventData$$serializer.f48095a;
        }
    }

    public EventData(int i2, String str, JsonElement jsonElement) {
        if (3 != (i2 & 3)) {
            PluginExceptionsKt.a(i2, 3, EventData$$serializer.f48096b);
            throw null;
        }
        this.f48093a = str;
        this.f48094b = jsonElement;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EventData)) {
            return false;
        }
        EventData eventData = (EventData) obj;
        return Intrinsics.b(this.f48093a, eventData.f48093a) && Intrinsics.b(this.f48094b, eventData.f48094b);
    }

    public final int hashCode() {
        return this.f48094b.hashCode() + (this.f48093a.hashCode() * 31);
    }

    public final String toString() {
        return "EventData(eventType=" + this.f48093a + ", data=" + this.f48094b + ')';
    }

    public EventData(String eventType, JsonObject data) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(data, "data");
        this.f48093a = eventType;
        this.f48094b = data;
    }
}
