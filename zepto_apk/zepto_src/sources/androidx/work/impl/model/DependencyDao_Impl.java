package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.impl.WorkDatabase_Impl;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class DependencyDao_Impl implements DependencyDao {

    /* renamed from: a, reason: collision with root package name */
    public final WorkDatabase_Impl f12880a;

    /* renamed from: b, reason: collision with root package name */
    public final EntityInsertionAdapter f12881b;

    /* renamed from: androidx.work.impl.model.DependencyDao_Impl$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 extends EntityInsertionAdapter<Dependency> {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
        }

        @Override // androidx.room.EntityInsertionAdapter
        public final void e(SupportSQLiteStatement supportSQLiteStatement, Object obj) {
            Dependency dependency = (Dependency) obj;
            if (dependency.b() == null) {
                supportSQLiteStatement.y1(1);
            } else {
                supportSQLiteStatement.m(1, dependency.b());
            }
            if (dependency.a() == null) {
                supportSQLiteStatement.y1(2);
            } else {
                supportSQLiteStatement.m(2, dependency.a());
            }
        }
    }

    public DependencyDao_Impl(WorkDatabase_Impl database) {
        this.f12880a = database;
        Intrinsics.checkNotNullParameter(database, "database");
        this.f12881b = new AnonymousClass1(database);
    }

    @Override // androidx.work.impl.model.DependencyDao
    public final void a(Dependency dependency) {
        WorkDatabase_Impl workDatabase_Impl = this.f12880a;
        workDatabase_Impl.b();
        workDatabase_Impl.c();
        try {
            this.f12881b.f(dependency);
            workDatabase_Impl.o();
        } finally {
            workDatabase_Impl.j();
        }
    }

    @Override // androidx.work.impl.model.DependencyDao
    public final ArrayList b(String str) {
        RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(1, "SELECT work_spec_id FROM dependency WHERE prerequisite_id=?");
        if (str == null) {
            roomSQLiteQueryA.y1(1);
        } else {
            roomSQLiteQueryA.m(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = this.f12880a;
        workDatabase_Impl.b();
        Cursor cursorB = DBUtil.b(workDatabase_Impl, roomSQLiteQueryA, false);
        try {
            ArrayList arrayList = new ArrayList(cursorB.getCount());
            while (cursorB.moveToNext()) {
                arrayList.add(cursorB.isNull(0) ? null : cursorB.getString(0));
            }
            return arrayList;
        } finally {
            cursorB.close();
            roomSQLiteQueryA.release();
        }
    }

    @Override // androidx.work.impl.model.DependencyDao
    public final boolean c(String str) {
        RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(1, "SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)");
        if (str == null) {
            roomSQLiteQueryA.y1(1);
        } else {
            roomSQLiteQueryA.m(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = this.f12880a;
        workDatabase_Impl.b();
        boolean z = false;
        Cursor cursorB = DBUtil.b(workDatabase_Impl, roomSQLiteQueryA, false);
        try {
            if (cursorB.moveToFirst()) {
                z = cursorB.getInt(0) != 0;
            }
            return z;
        } finally {
            cursorB.close();
            roomSQLiteQueryA.release();
        }
    }

    @Override // androidx.work.impl.model.DependencyDao
    public final boolean d(String str) {
        RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(1, "SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?");
        if (str == null) {
            roomSQLiteQueryA.y1(1);
        } else {
            roomSQLiteQueryA.m(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = this.f12880a;
        workDatabase_Impl.b();
        boolean z = false;
        Cursor cursorB = DBUtil.b(workDatabase_Impl, roomSQLiteQueryA, false);
        try {
            if (cursorB.moveToFirst()) {
                z = cursorB.getInt(0) != 0;
            }
            return z;
        } finally {
            cursorB.close();
            roomSQLiteQueryA.release();
        }
    }
}
