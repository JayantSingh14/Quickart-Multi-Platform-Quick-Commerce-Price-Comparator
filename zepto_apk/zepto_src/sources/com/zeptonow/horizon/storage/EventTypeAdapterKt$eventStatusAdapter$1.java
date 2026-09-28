package com.zeptonow.horizon.storage;

import app.cash.sqldelight.ColumnAdapter;
import com.zeptonow.horizon.entity.EventStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class EventTypeAdapterKt$eventStatusAdapter$1 implements ColumnAdapter<EventStatus, String> {
    public final Object a(String databaseValue) {
        Intrinsics.checkNotNullParameter(databaseValue, "databaseValue");
        return EventStatus.valueOf(databaseValue);
    }

    public final String b(Object obj) {
        EventStatus value = (EventStatus) obj;
        Intrinsics.checkNotNullParameter(value, "value");
        return value.name();
    }
}
