package com.zeptonow.horizon.storage;

import app.cash.sqldelight.db.SqlCursor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes.dex */
final class EventDatabaseQueries$getCountByStatus$1 extends Lambda implements Function1<SqlCursor, Long> {

    /* renamed from: c, reason: collision with root package name */
    public static final EventDatabaseQueries$getCountByStatus$1 f48142c = new EventDatabaseQueries$getCountByStatus$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        SqlCursor cursor = (SqlCursor) obj;
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        Long l2 = cursor.getLong(0);
        Intrinsics.c(l2);
        return l2;
    }
}
