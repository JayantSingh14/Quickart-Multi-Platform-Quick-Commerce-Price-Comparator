package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.impl.WorkDatabase_Impl;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class PreferenceDao_Impl implements PreferenceDao {

    /* renamed from: a, reason: collision with root package name */
    public final WorkDatabase_Impl f12884a;

    /* renamed from: b, reason: collision with root package name */
    public final EntityInsertionAdapter f12885b;

    /* renamed from: androidx.work.impl.model.PreferenceDao_Impl$1, reason: invalid class name */
    class AnonymousClass1 extends EntityInsertionAdapter<Preference> {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
        }

        @Override // androidx.room.EntityInsertionAdapter
        public final void e(SupportSQLiteStatement supportSQLiteStatement, Object obj) {
            Preference preference = (Preference) obj;
            supportSQLiteStatement.m(1, preference.f12882a);
            supportSQLiteStatement.e1(2, preference.f12883b.longValue());
        }
    }

    /* renamed from: androidx.work.impl.model.PreferenceDao_Impl$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass2 implements Callable<Long> {
        @Override // java.util.concurrent.Callable
        public final Long call() {
            throw null;
        }

        public final void finalize() {
            throw null;
        }
    }

    public PreferenceDao_Impl(WorkDatabase_Impl database) {
        this.f12884a = database;
        Intrinsics.checkNotNullParameter(database, "database");
        this.f12885b = new AnonymousClass1(database);
    }

    @Override // androidx.work.impl.model.PreferenceDao
    public final void a(Preference preference) {
        WorkDatabase_Impl workDatabase_Impl = this.f12884a;
        workDatabase_Impl.b();
        workDatabase_Impl.c();
        try {
            this.f12885b.f(preference);
            workDatabase_Impl.o();
        } finally {
            workDatabase_Impl.j();
        }
    }

    @Override // androidx.work.impl.model.PreferenceDao
    public final Long b(String str) {
        RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(1, "SELECT long_value FROM Preference where `key`=?");
        roomSQLiteQueryA.m(1, str);
        WorkDatabase_Impl workDatabase_Impl = this.f12884a;
        workDatabase_Impl.b();
        Cursor cursorB = DBUtil.b(workDatabase_Impl, roomSQLiteQueryA, false);
        try {
            Long lValueOf = null;
            if (cursorB.moveToFirst() && !cursorB.isNull(0)) {
                lValueOf = Long.valueOf(cursorB.getLong(0));
            }
            return lValueOf;
        } finally {
            cursorB.close();
            roomSQLiteQueryA.release();
        }
    }
}
