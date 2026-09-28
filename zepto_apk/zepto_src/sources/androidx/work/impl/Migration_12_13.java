package androidx.work.impl;

import android.database.SQLException;
import androidx.room.migration.Migration;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class Migration_12_13 extends Migration {

    /* renamed from: c, reason: collision with root package name */
    public static final Migration_12_13 f12604c = new Migration_12_13(12, 13);

    @Override // androidx.room.migration.Migration
    public final void a(FrameworkSQLiteDatabase db) throws SQLException {
        Intrinsics.checkNotNullParameter(db, "db");
        db.C("UPDATE workspec SET required_network_type = 0 WHERE required_network_type IS NULL ");
        db.C("UPDATE workspec SET content_uri_triggers = x'' WHERE content_uri_triggers is NULL");
    }
}
