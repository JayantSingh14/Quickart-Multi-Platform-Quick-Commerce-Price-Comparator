package androidx.work.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.SQLException;
import androidx.room.migration.Migration;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class WorkMigration9To10 extends Migration {

    /* renamed from: c, reason: collision with root package name */
    public final Context f12664c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkMigration9To10(Context context) {
        super(9, 10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f12664c = context;
    }

    @Override // androidx.room.migration.Migration
    public final void a(FrameworkSQLiteDatabase sqLiteDatabase) throws SQLException {
        Intrinsics.checkNotNullParameter(sqLiteDatabase, "db");
        sqLiteDatabase.C("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
        Context context = this.f12664c;
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
        if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
            long j2 = sharedPreferences.getLong("last_cancel_all_time_ms", 0L);
            long j3 = sharedPreferences.getBoolean("reschedule_needed", false) ? 1L : 0L;
            sqLiteDatabase.w();
            try {
                sqLiteDatabase.f1(new Object[]{"last_cancel_all_time_ms", Long.valueOf(j2)});
                sqLiteDatabase.f1(new Object[]{"reschedule_needed", Long.valueOf(j3)});
                sharedPreferences.edit().clear().apply();
                sqLiteDatabase.S();
            } finally {
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("androidx.work.util.id", 0);
        if (sharedPreferences2.contains("next_job_scheduler_id") || sharedPreferences2.contains("next_job_scheduler_id")) {
            int i2 = sharedPreferences2.getInt("next_job_scheduler_id", 0);
            int i3 = sharedPreferences2.getInt("next_alarm_manager_id", 0);
            sqLiteDatabase.w();
            try {
                sqLiteDatabase.f1(new Object[]{"next_job_scheduler_id", Integer.valueOf(i2)});
                sqLiteDatabase.f1(new Object[]{"next_alarm_manager_id", Integer.valueOf(i3)});
                sharedPreferences2.edit().clear().apply();
                sqLiteDatabase.S();
            } finally {
            }
        }
    }
}
