package com.zeptonow.horizon.storage.shared;

import app.cash.sqldelight.db.SqlDriver;
import com.zeptonow.horizon.storage.EventDatabase;
import com.zeptonow.horizon.storage.EventEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class EventDatabaseImplKt {
    public static final EventDatabase a(ClassReference classReference, SqlDriver driver, EventEntity.Adapter EventEntityAdapter) {
        Intrinsics.checkNotNullParameter(classReference, "<this>");
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(EventEntityAdapter, "EventEntityAdapter");
        return new EventDatabaseImpl(driver, EventEntityAdapter);
    }
}
