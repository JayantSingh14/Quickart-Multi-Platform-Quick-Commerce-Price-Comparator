package com.zeptonow.horizon.storage.shared;

import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlSchema;
import app.cash.sqldelight.driver.android.AndroidSqliteDriver;
import com.zeptonow.horizon.storage.EventDatabase;
import com.zeptonow.horizon.storage.EventDatabaseQueries;
import com.zeptonow.horizon.storage.EventEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: classes.dex */
public final class EventDatabaseImpl extends TransacterImpl implements EventDatabase {

    /* renamed from: b, reason: collision with root package name */
    public final EventDatabaseQueries f48225b;

    @Metadata
    @SourceDebugExtension
    public static final class Schema implements SqlSchema<QueryResult.Value<Unit>> {

        /* renamed from: a, reason: collision with root package name */
        public static final Schema f48226a = new Schema();

        public static void a(AndroidSqliteDriver androidSqliteDriver, long j2, long j3) {
            if (j2 <= 1 && j3 > 1) {
                androidSqliteDriver.b0(null, "ALTER TABLE EventEntity ADD COLUMN eventType TEXT NOT NULL DEFAULT \"EVENTS_V1\"", null);
            }
            QueryResult.f13140a.getClass();
            QueryResult.Companion companion = QueryResult.Companion.f13142a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventDatabaseImpl(SqlDriver driver, EventEntity.Adapter EventEntityAdapter) {
        super(driver);
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(EventEntityAdapter, "EventEntityAdapter");
        this.f48225b = new EventDatabaseQueries(driver, EventEntityAdapter);
    }

    @Override // com.zeptonow.horizon.storage.EventDatabase
    public final EventDatabaseQueries a() {
        return this.f48225b;
    }
}
