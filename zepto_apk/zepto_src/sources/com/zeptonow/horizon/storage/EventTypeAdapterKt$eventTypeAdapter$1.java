package com.zeptonow.horizon.storage;

import app.cash.sqldelight.ColumnAdapter;
import com.zeptonow.horizon.entity.EventType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class EventTypeAdapterKt$eventTypeAdapter$1 implements ColumnAdapter<EventType, String> {
    public final Object a(String databaseValue) {
        Intrinsics.checkNotNullParameter(databaseValue, "databaseValue");
        return EventType.valueOf(databaseValue);
    }

    public final String b(Object obj) {
        EventType value = (EventType) obj;
        Intrinsics.checkNotNullParameter(value, "value");
        return value.name();
    }
}
