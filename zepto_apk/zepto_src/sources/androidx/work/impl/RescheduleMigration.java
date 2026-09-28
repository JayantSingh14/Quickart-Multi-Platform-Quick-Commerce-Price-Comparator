package androidx.work.impl;

import android.content.Context;
import android.database.SQLException;
import androidx.room.migration.Migration;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class RescheduleMigration extends Migration {

    /* renamed from: c, reason: collision with root package name */
    public final Context f12627c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RescheduleMigration(Context mContext, int i2, int i3) {
        super(i2, i3);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.f12627c = mContext;
    }

    @Override // androidx.room.migration.Migration
    public final void a(FrameworkSQLiteDatabase db) throws SQLException {
        Intrinsics.checkNotNullParameter(db, "db");
        if (this.f11858b >= 10) {
            db.f1(new Object[]{"reschedule_needed", 1});
        } else {
            this.f12627c.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
        }
    }
}
