package androidx.work.impl;

import android.database.SQLException;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.DependencyDao_Impl;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.PreferenceDao_Impl;
import androidx.work.impl.model.RawWorkInfoDao;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.SystemIdInfoDao_Impl;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkNameDao_Impl;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkProgressDao_Impl;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.model.WorkTagDao_Impl;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public final class WorkDatabase_Impl extends WorkDatabase {

    /* renamed from: m, reason: collision with root package name */
    public volatile WorkSpecDao_Impl f12646m;
    public volatile DependencyDao_Impl n;
    public volatile WorkTagDao_Impl o;
    public volatile SystemIdInfoDao_Impl p;
    public volatile WorkNameDao_Impl q;
    public volatile WorkProgressDao_Impl r;
    public volatile PreferenceDao_Impl s;

    @Override // androidx.room.RoomDatabase
    public final InvalidationTracker d() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    @Override // androidx.room.RoomDatabase
    public final SupportSQLiteOpenHelper e(DatabaseConfiguration databaseConfiguration) {
        RoomOpenHelper callback = new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate() { // from class: androidx.work.impl.WorkDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public final void a(FrameworkSQLiteDatabase frameworkSQLiteDatabase) throws SQLException {
                frameworkSQLiteDatabase.C("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                frameworkSQLiteDatabase.C("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
                frameworkSQLiteDatabase.C("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
                frameworkSQLiteDatabase.C("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT NOT NULL, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `last_enqueue_time` INTEGER NOT NULL DEFAULT -1, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `period_count` INTEGER NOT NULL DEFAULT 0, `generation` INTEGER NOT NULL DEFAULT 0, `next_schedule_time_override` INTEGER NOT NULL DEFAULT 9223372036854775807, `next_schedule_time_override_generation` INTEGER NOT NULL DEFAULT 0, `stop_reason` INTEGER NOT NULL DEFAULT -256, `required_network_type` INTEGER NOT NULL, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB NOT NULL, PRIMARY KEY(`id`))");
                frameworkSQLiteDatabase.C("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
                frameworkSQLiteDatabase.C("CREATE INDEX IF NOT EXISTS `index_WorkSpec_last_enqueue_time` ON `WorkSpec` (`last_enqueue_time`)");
                frameworkSQLiteDatabase.C("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                frameworkSQLiteDatabase.C("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
                frameworkSQLiteDatabase.C("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `generation` INTEGER NOT NULL DEFAULT 0, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`, `generation`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                frameworkSQLiteDatabase.C("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                frameworkSQLiteDatabase.C("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
                frameworkSQLiteDatabase.C("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                frameworkSQLiteDatabase.C("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
                frameworkSQLiteDatabase.C("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                frameworkSQLiteDatabase.C("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7d73d21f1bd82c9e5268b6dcf9fde2cb')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public final void b(FrameworkSQLiteDatabase db) throws SQLException {
                db.C("DROP TABLE IF EXISTS `Dependency`");
                db.C("DROP TABLE IF EXISTS `WorkSpec`");
                db.C("DROP TABLE IF EXISTS `WorkTag`");
                db.C("DROP TABLE IF EXISTS `SystemIdInfo`");
                db.C("DROP TABLE IF EXISTS `WorkName`");
                db.C("DROP TABLE IF EXISTS `WorkProgress`");
                db.C("DROP TABLE IF EXISTS `Preference`");
                WorkDatabase_Impl workDatabase_Impl = WorkDatabase_Impl.this;
                ArrayList arrayList = workDatabase_Impl.f11803g;
                if (arrayList != null) {
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((RoomDatabase.Callback) workDatabase_Impl.f11803g.get(i2)).getClass();
                        Intrinsics.checkNotNullParameter(db, "db");
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public final void c(FrameworkSQLiteDatabase db) {
                WorkDatabase_Impl workDatabase_Impl = WorkDatabase_Impl.this;
                ArrayList arrayList = workDatabase_Impl.f11803g;
                if (arrayList != null) {
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((RoomDatabase.Callback) workDatabase_Impl.f11803g.get(i2)).getClass();
                        Intrinsics.checkNotNullParameter(db, "db");
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public final void d(FrameworkSQLiteDatabase frameworkSQLiteDatabase) throws SQLException {
                WorkDatabase_Impl.this.f11797a = frameworkSQLiteDatabase;
                frameworkSQLiteDatabase.C("PRAGMA foreign_keys = ON");
                WorkDatabase_Impl.this.k(frameworkSQLiteDatabase);
                ArrayList arrayList = WorkDatabase_Impl.this.f11803g;
                if (arrayList != null) {
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((RoomDatabase.Callback) WorkDatabase_Impl.this.f11803g.get(i2)).a(frameworkSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public final void f(FrameworkSQLiteDatabase frameworkSQLiteDatabase) throws SQLException {
                DBUtil.a(frameworkSQLiteDatabase);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public final RoomOpenHelper.ValidationResult g(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
                HashMap map = new HashMap(2);
                map.put("work_spec_id", new TableInfo.Column(1, 1, "work_spec_id", "TEXT", null, true));
                map.put("prerequisite_id", new TableInfo.Column(2, 1, "prerequisite_id", "TEXT", null, true));
                HashSet hashSet = new HashSet(2);
                hashSet.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList(CLConstants.SHARED_PREFERENCE_ITEM_ID)));
                hashSet.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList(CLConstants.SHARED_PREFERENCE_ITEM_ID)));
                HashSet hashSet2 = new HashSet(2);
                hashSet2.add(new TableInfo.Index("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
                hashSet2.add(new TableInfo.Index("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id"), Arrays.asList("ASC")));
                TableInfo tableInfo = new TableInfo("Dependency", map, hashSet, hashSet2);
                TableInfo tableInfoA = TableInfo.a(frameworkSQLiteDatabase, "Dependency");
                if (!tableInfo.equals(tableInfoA)) {
                    return new RoomOpenHelper.ValidationResult("Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfoA, false);
                }
                HashMap map2 = new HashMap(30);
                map2.put(CLConstants.SHARED_PREFERENCE_ITEM_ID, new TableInfo.Column(1, 1, CLConstants.SHARED_PREFERENCE_ITEM_ID, "TEXT", null, true));
                map2.put("state", new TableInfo.Column(0, 1, "state", "INTEGER", null, true));
                map2.put("worker_class_name", new TableInfo.Column(0, 1, "worker_class_name", "TEXT", null, true));
                map2.put("input_merger_class_name", new TableInfo.Column(0, 1, "input_merger_class_name", "TEXT", null, true));
                map2.put("input", new TableInfo.Column(0, 1, "input", "BLOB", null, true));
                map2.put("output", new TableInfo.Column(0, 1, "output", "BLOB", null, true));
                map2.put("initial_delay", new TableInfo.Column(0, 1, "initial_delay", "INTEGER", null, true));
                map2.put("interval_duration", new TableInfo.Column(0, 1, "interval_duration", "INTEGER", null, true));
                map2.put("flex_duration", new TableInfo.Column(0, 1, "flex_duration", "INTEGER", null, true));
                map2.put("run_attempt_count", new TableInfo.Column(0, 1, "run_attempt_count", "INTEGER", null, true));
                map2.put("backoff_policy", new TableInfo.Column(0, 1, "backoff_policy", "INTEGER", null, true));
                map2.put("backoff_delay_duration", new TableInfo.Column(0, 1, "backoff_delay_duration", "INTEGER", null, true));
                map2.put("last_enqueue_time", new TableInfo.Column(0, 1, "last_enqueue_time", "INTEGER", "-1", true));
                map2.put("minimum_retention_duration", new TableInfo.Column(0, 1, "minimum_retention_duration", "INTEGER", null, true));
                map2.put("schedule_requested_at", new TableInfo.Column(0, 1, "schedule_requested_at", "INTEGER", null, true));
                map2.put("run_in_foreground", new TableInfo.Column(0, 1, "run_in_foreground", "INTEGER", null, true));
                map2.put("out_of_quota_policy", new TableInfo.Column(0, 1, "out_of_quota_policy", "INTEGER", null, true));
                map2.put("period_count", new TableInfo.Column(0, 1, "period_count", "INTEGER", "0", true));
                map2.put("generation", new TableInfo.Column(0, 1, "generation", "INTEGER", "0", true));
                map2.put("next_schedule_time_override", new TableInfo.Column(0, 1, "next_schedule_time_override", "INTEGER", "9223372036854775807", true));
                map2.put("next_schedule_time_override_generation", new TableInfo.Column(0, 1, "next_schedule_time_override_generation", "INTEGER", "0", true));
                map2.put("stop_reason", new TableInfo.Column(0, 1, "stop_reason", "INTEGER", "-256", true));
                map2.put("required_network_type", new TableInfo.Column(0, 1, "required_network_type", "INTEGER", null, true));
                map2.put("requires_charging", new TableInfo.Column(0, 1, "requires_charging", "INTEGER", null, true));
                map2.put("requires_device_idle", new TableInfo.Column(0, 1, "requires_device_idle", "INTEGER", null, true));
                map2.put("requires_battery_not_low", new TableInfo.Column(0, 1, "requires_battery_not_low", "INTEGER", null, true));
                map2.put("requires_storage_not_low", new TableInfo.Column(0, 1, "requires_storage_not_low", "INTEGER", null, true));
                map2.put("trigger_content_update_delay", new TableInfo.Column(0, 1, "trigger_content_update_delay", "INTEGER", null, true));
                map2.put("trigger_max_content_delay", new TableInfo.Column(0, 1, "trigger_max_content_delay", "INTEGER", null, true));
                map2.put("content_uri_triggers", new TableInfo.Column(0, 1, "content_uri_triggers", "BLOB", null, true));
                HashSet hashSet3 = new HashSet(0);
                HashSet hashSet4 = new HashSet(2);
                hashSet4.add(new TableInfo.Index("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at"), Arrays.asList("ASC")));
                hashSet4.add(new TableInfo.Index("index_WorkSpec_last_enqueue_time", false, Arrays.asList("last_enqueue_time"), Arrays.asList("ASC")));
                TableInfo tableInfo2 = new TableInfo("WorkSpec", map2, hashSet3, hashSet4);
                TableInfo tableInfoA2 = TableInfo.a(frameworkSQLiteDatabase, "WorkSpec");
                if (!tableInfo2.equals(tableInfoA2)) {
                    return new RoomOpenHelper.ValidationResult("WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + tableInfo2 + "\n Found:\n" + tableInfoA2, false);
                }
                HashMap map3 = new HashMap(2);
                map3.put("tag", new TableInfo.Column(1, 1, "tag", "TEXT", null, true));
                map3.put("work_spec_id", new TableInfo.Column(2, 1, "work_spec_id", "TEXT", null, true));
                HashSet hashSet5 = new HashSet(1);
                hashSet5.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList(CLConstants.SHARED_PREFERENCE_ITEM_ID)));
                HashSet hashSet6 = new HashSet(1);
                hashSet6.add(new TableInfo.Index("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
                TableInfo tableInfo3 = new TableInfo("WorkTag", map3, hashSet5, hashSet6);
                TableInfo tableInfoA3 = TableInfo.a(frameworkSQLiteDatabase, "WorkTag");
                if (!tableInfo3.equals(tableInfoA3)) {
                    return new RoomOpenHelper.ValidationResult("WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfoA3, false);
                }
                HashMap map4 = new HashMap(3);
                map4.put("work_spec_id", new TableInfo.Column(1, 1, "work_spec_id", "TEXT", null, true));
                map4.put("generation", new TableInfo.Column(2, 1, "generation", "INTEGER", "0", true));
                map4.put("system_id", new TableInfo.Column(0, 1, "system_id", "INTEGER", null, true));
                HashSet hashSet7 = new HashSet(1);
                hashSet7.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList(CLConstants.SHARED_PREFERENCE_ITEM_ID)));
                TableInfo tableInfo4 = new TableInfo("SystemIdInfo", map4, hashSet7, new HashSet(0));
                TableInfo tableInfoA4 = TableInfo.a(frameworkSQLiteDatabase, "SystemIdInfo");
                if (!tableInfo4.equals(tableInfoA4)) {
                    return new RoomOpenHelper.ValidationResult("SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + tableInfo4 + "\n Found:\n" + tableInfoA4, false);
                }
                HashMap map5 = new HashMap(2);
                map5.put(CLConstants.FIELD_PAY_INFO_NAME, new TableInfo.Column(1, 1, CLConstants.FIELD_PAY_INFO_NAME, "TEXT", null, true));
                map5.put("work_spec_id", new TableInfo.Column(2, 1, "work_spec_id", "TEXT", null, true));
                HashSet hashSet8 = new HashSet(1);
                hashSet8.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList(CLConstants.SHARED_PREFERENCE_ITEM_ID)));
                HashSet hashSet9 = new HashSet(1);
                hashSet9.add(new TableInfo.Index("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
                TableInfo tableInfo5 = new TableInfo("WorkName", map5, hashSet8, hashSet9);
                TableInfo tableInfoA5 = TableInfo.a(frameworkSQLiteDatabase, "WorkName");
                if (!tableInfo5.equals(tableInfoA5)) {
                    return new RoomOpenHelper.ValidationResult("WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfoA5, false);
                }
                HashMap map6 = new HashMap(2);
                map6.put("work_spec_id", new TableInfo.Column(1, 1, "work_spec_id", "TEXT", null, true));
                map6.put(ReactProgressBarViewManager.PROP_PROGRESS, new TableInfo.Column(0, 1, ReactProgressBarViewManager.PROP_PROGRESS, "BLOB", null, true));
                HashSet hashSet10 = new HashSet(1);
                hashSet10.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList(CLConstants.SHARED_PREFERENCE_ITEM_ID)));
                TableInfo tableInfo6 = new TableInfo("WorkProgress", map6, hashSet10, new HashSet(0));
                TableInfo tableInfoA6 = TableInfo.a(frameworkSQLiteDatabase, "WorkProgress");
                if (!tableInfo6.equals(tableInfoA6)) {
                    return new RoomOpenHelper.ValidationResult("WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + tableInfo6 + "\n Found:\n" + tableInfoA6, false);
                }
                HashMap map7 = new HashMap(2);
                map7.put("key", new TableInfo.Column(1, 1, "key", "TEXT", null, true));
                map7.put("long_value", new TableInfo.Column(0, 1, "long_value", "INTEGER", null, false));
                TableInfo tableInfo7 = new TableInfo("Preference", map7, new HashSet(0), new HashSet(0));
                TableInfo tableInfoA7 = TableInfo.a(frameworkSQLiteDatabase, "Preference");
                if (tableInfo7.equals(tableInfoA7)) {
                    return new RoomOpenHelper.ValidationResult(null, true);
                }
                return new RoomOpenHelper.ValidationResult("Preference(androidx.work.impl.model.Preference).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfoA7, false);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public final void e(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            }
        }, "7d73d21f1bd82c9e5268b6dcf9fde2cb", "3071c8717539de5d5353f4c8cd59a032");
        SupportSQLiteOpenHelper.Configuration.Builder builderA = SupportSQLiteOpenHelper.Configuration.Companion.a(databaseConfiguration.f11740a);
        builderA.f11902b = databaseConfiguration.f11741b;
        Intrinsics.checkNotNullParameter(callback, "callback");
        builderA.f11903c = callback;
        return databaseConfiguration.f11742c.g(builderA.a());
    }

    @Override // androidx.room.RoomDatabase
    public final List f(LinkedHashMap linkedHashMap) {
        return Arrays.asList(new WorkDatabase_AutoMigration_13_14_Impl(), new WorkDatabase_AutoMigration_14_15_Impl(), new WorkDatabase_AutoMigration_16_17_Impl(), new WorkDatabase_AutoMigration_17_18_Impl(), new WorkDatabase_AutoMigration_18_19_Impl(), new WorkDatabase_AutoMigration_19_20_Impl());
    }

    @Override // androidx.room.RoomDatabase
    public final Set h() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public final Map i() {
        HashMap map = new HashMap();
        List list = Collections.EMPTY_LIST;
        map.put(WorkSpecDao.class, list);
        map.put(DependencyDao.class, list);
        map.put(WorkTagDao.class, list);
        map.put(SystemIdInfoDao.class, list);
        map.put(WorkNameDao.class, list);
        map.put(WorkProgressDao.class, list);
        map.put(PreferenceDao.class, list);
        map.put(RawWorkInfoDao.class, list);
        return map;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final DependencyDao q() {
        DependencyDao_Impl dependencyDao_Impl;
        if (this.n != null) {
            return this.n;
        }
        synchronized (this) {
            try {
                if (this.n == null) {
                    this.n = new DependencyDao_Impl(this);
                }
                dependencyDao_Impl = this.n;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dependencyDao_Impl;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final PreferenceDao r() {
        PreferenceDao_Impl preferenceDao_Impl;
        if (this.s != null) {
            return this.s;
        }
        synchronized (this) {
            try {
                if (this.s == null) {
                    this.s = new PreferenceDao_Impl(this);
                }
                preferenceDao_Impl = this.s;
            } catch (Throwable th) {
                throw th;
            }
        }
        return preferenceDao_Impl;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final SystemIdInfoDao s() {
        SystemIdInfoDao_Impl systemIdInfoDao_Impl;
        if (this.p != null) {
            return this.p;
        }
        synchronized (this) {
            try {
                if (this.p == null) {
                    this.p = new SystemIdInfoDao_Impl(this);
                }
                systemIdInfoDao_Impl = this.p;
            } catch (Throwable th) {
                throw th;
            }
        }
        return systemIdInfoDao_Impl;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final WorkNameDao t() {
        WorkNameDao_Impl workNameDao_Impl;
        if (this.q != null) {
            return this.q;
        }
        synchronized (this) {
            try {
                if (this.q == null) {
                    this.q = new WorkNameDao_Impl(this);
                }
                workNameDao_Impl = this.q;
            } catch (Throwable th) {
                throw th;
            }
        }
        return workNameDao_Impl;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final WorkProgressDao u() {
        WorkProgressDao_Impl workProgressDao_Impl;
        if (this.r != null) {
            return this.r;
        }
        synchronized (this) {
            try {
                if (this.r == null) {
                    this.r = new WorkProgressDao_Impl(this);
                }
                workProgressDao_Impl = this.r;
            } catch (Throwable th) {
                throw th;
            }
        }
        return workProgressDao_Impl;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final WorkSpecDao v() {
        WorkSpecDao_Impl workSpecDao_Impl;
        if (this.f12646m != null) {
            return this.f12646m;
        }
        synchronized (this) {
            try {
                if (this.f12646m == null) {
                    this.f12646m = new WorkSpecDao_Impl(this);
                }
                workSpecDao_Impl = this.f12646m;
            } catch (Throwable th) {
                throw th;
            }
        }
        return workSpecDao_Impl;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final WorkTagDao w() {
        WorkTagDao_Impl workTagDao_Impl;
        if (this.o != null) {
            return this.o;
        }
        synchronized (this) {
            try {
                if (this.o == null) {
                    this.o = new WorkTagDao_Impl(this);
                }
                workTagDao_Impl = this.o;
            } catch (Throwable th) {
                throw th;
            }
        }
        return workTagDao_Impl;
    }
}
