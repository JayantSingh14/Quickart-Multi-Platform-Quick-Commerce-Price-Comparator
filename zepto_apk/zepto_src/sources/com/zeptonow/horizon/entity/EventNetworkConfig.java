package com.zeptonow.horizon.entity;

import androidx.fragment.app.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.PluginExceptionsKt;
import org.jetbrains.annotations.NotNull;

@Metadata
@Serializable
/* loaded from: classes.dex */
public final class EventNetworkConfig {

    @NotNull
    public static final Companion Companion = new Companion();

    /* renamed from: a, reason: collision with root package name */
    public final String f48068a;

    @Metadata
    public static final class Companion {
        @NotNull
        public final KSerializer<EventNetworkConfig> serializer() {
            return EventNetworkConfig$$serializer.f48069a;
        }
    }

    public EventNetworkConfig(int i2, String str) {
        if (1 == (i2 & 1)) {
            this.f48068a = str;
        } else {
            PluginExceptionsKt.a(i2, 1, EventNetworkConfig$$serializer.f48070b);
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EventNetworkConfig) && Intrinsics.b(this.f48068a, ((EventNetworkConfig) obj).f48068a);
    }

    public final int hashCode() {
        return this.f48068a.hashCode();
    }

    public final String toString() {
        return e.t(new StringBuilder("EventNetworkConfig(url="), this.f48068a, ')');
    }
}
