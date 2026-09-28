package com.zeptonow.horizon.entity.dto;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import org.jetbrains.annotations.NotNull;

@Metadata
@Serializable
/* loaded from: classes.dex */
public final class EventRequestBody {

    @NotNull
    public static final Companion Companion = new Companion();

    /* renamed from: b, reason: collision with root package name */
    public static final KSerializer[] f48097b = {new ArrayListSerializer(EventData$$serializer.f48095a)};

    /* renamed from: a, reason: collision with root package name */
    public final List f48098a;

    @Metadata
    public static final class Companion {
        @NotNull
        public final KSerializer<EventRequestBody> serializer() {
            return EventRequestBody$$serializer.f48099a;
        }
    }

    public EventRequestBody(int i2, List list) {
        if (1 == (i2 & 1)) {
            this.f48098a = list;
        } else {
            PluginExceptionsKt.a(i2, 1, EventRequestBody$$serializer.f48100b);
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EventRequestBody) && Intrinsics.b(this.f48098a, ((EventRequestBody) obj).f48098a);
    }

    public final int hashCode() {
        return this.f48098a.hashCode();
    }

    public final String toString() {
        return "EventRequestBody(events=" + this.f48098a + ')';
    }

    public EventRequestBody(ArrayList events) {
        Intrinsics.checkNotNullParameter(events, "events");
        this.f48098a = events;
    }
}
