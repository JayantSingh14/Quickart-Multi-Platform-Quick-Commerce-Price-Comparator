package com.zeptonow.horizon.entity;

import androidx.fragment.app.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata
@Serializable
/* loaded from: classes.dex */
public final class Event {

    @NotNull
    public static final Companion Companion = new Companion();

    /* renamed from: d, reason: collision with root package name */
    public static final KSerializer[] f48062d;

    /* renamed from: a, reason: collision with root package name */
    public final String f48063a;

    /* renamed from: b, reason: collision with root package name */
    public final String f48064b;

    /* renamed from: c, reason: collision with root package name */
    public final EventType f48065c;

    @Metadata
    public static final class Companion {
        @NotNull
        public final KSerializer<Event> serializer() {
            return Event$$serializer.f48066a;
        }
    }

    static {
        EventType[] values = EventType.values();
        Intrinsics.checkNotNullParameter("com.zeptonow.horizon.entity.EventType", "serialName");
        Intrinsics.checkNotNullParameter(values, "values");
        f48062d = new KSerializer[]{null, null, new EnumSerializer("com.zeptonow.horizon.entity.EventType", values)};
    }

    public /* synthetic */ Event(int i2, String str, String str2, EventType eventType) {
        if (1 != (i2 & 1)) {
            PluginExceptionsKt.a(i2, 1, (PluginGeneratedSerialDescriptor) Event$$serializer.f48066a.a());
            throw null;
        }
        this.f48063a = str;
        if ((i2 & 2) == 0) {
            this.f48064b = "{}";
        } else {
            this.f48064b = str2;
        }
        if ((i2 & 4) == 0) {
            this.f48065c = EventType.f48076a;
        } else {
            this.f48065c = eventType;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        return Intrinsics.b(this.f48063a, event.f48063a) && Intrinsics.b(this.f48064b, event.f48064b) && this.f48065c == event.f48065c;
    }

    public final int hashCode() {
        return this.f48065c.hashCode() + e.e(this.f48063a.hashCode() * 31, 31, this.f48064b);
    }

    public final String toString() {
        return "Event(name=" + this.f48063a + ", properties=" + this.f48064b + ", type=" + this.f48065c + ')';
    }

    public Event(String name, String properties, EventType type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(type, "type");
        this.f48063a = name;
        this.f48064b = properties;
        this.f48065c = type;
    }
}
