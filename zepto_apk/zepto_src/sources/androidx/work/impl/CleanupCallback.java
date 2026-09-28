package androidx.work.impl;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.work.SystemClock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class CleanupCallback extends RoomDatabase.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final SystemClock f12601a;

    public CleanupCallback(SystemClock clock) {
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.f12601a = clock;
    }

    @Override // androidx.room.RoomDatabase.Callback
    public final void a(FrameworkSQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        super.a(db);
        db.w();
        try {
            StringBuilder sb = new StringBuilder("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (last_enqueue_time + minimum_retention_duration) < ");
            this.f12601a.getClass();
            sb.append(System.currentTimeMillis() - WorkDatabaseKt.f12641a);
            sb.append(" AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))");
            db.C(sb.toString());
            db.S();
        } finally {
            db.e0();
        }
    }
}
