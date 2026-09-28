package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.impl.WorkDatabase_Impl;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class SystemIdInfoDao_Impl implements SystemIdInfoDao {

    /* renamed from: a, reason: collision with root package name */
    public final WorkDatabase_Impl f12889a;

    /* renamed from: b, reason: collision with root package name */
    public final EntityInsertionAdapter f12890b;

    /* renamed from: c, reason: collision with root package name */
    public final SharedSQLiteStatement f12891c;

    /* renamed from: d, reason: collision with root package name */
    public final SharedSQLiteStatement f12892d;

    /* renamed from: androidx.work.impl.model.SystemIdInfoDao_Impl$1, reason: invalid class name */
    class AnonymousClass1 extends EntityInsertionAdapter<SystemIdInfo> {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`generation`,`system_id`) VALUES (?,?,?)";
        }

        @Override // androidx.room.EntityInsertionAdapter
        public final void e(SupportSQLiteStatement supportSQLiteStatement, Object obj) {
            String str = ((SystemIdInfo) obj).f12886a;
            if (str == null) {
                supportSQLiteStatement.y1(1);
            } else {
                supportSQLiteStatement.m(1, str);
            }
            supportSQLiteStatement.e1(2, r5.f12887b);
            supportSQLiteStatement.e1(3, r5.f12888c);
        }
    }

    /* renamed from: androidx.work.impl.model.SystemIdInfoDao_Impl$2, reason: invalid class name */
    class AnonymousClass2 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "DELETE FROM SystemIdInfo where work_spec_id=? AND generation=?";
        }
    }

    /* renamed from: androidx.work.impl.model.SystemIdInfoDao_Impl$3, reason: invalid class name */
    class AnonymousClass3 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "DELETE FROM SystemIdInfo where work_spec_id=?";
        }
    }

    public SystemIdInfoDao_Impl(WorkDatabase_Impl database) {
        this.f12889a = database;
        Intrinsics.checkNotNullParameter(database, "database");
        this.f12890b = new AnonymousClass1(database);
        this.f12891c = new AnonymousClass2(database);
        this.f12892d = new AnonymousClass3(database);
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public final SystemIdInfo b(int i2, String str) {
        RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(2, "SELECT * FROM SystemIdInfo WHERE work_spec_id=? AND generation=?");
        if (str == null) {
            roomSQLiteQueryA.y1(1);
        } else {
            roomSQLiteQueryA.m(1, str);
        }
        roomSQLiteQueryA.e1(2, i2);
        WorkDatabase_Impl workDatabase_Impl = this.f12889a;
        workDatabase_Impl.b();
        Cursor cursorB = DBUtil.b(workDatabase_Impl, roomSQLiteQueryA, false);
        try {
            int iB = CursorUtil.b(cursorB, "work_spec_id");
            int iB2 = CursorUtil.b(cursorB, "generation");
            int iB3 = CursorUtil.b(cursorB, "system_id");
            SystemIdInfo systemIdInfo = null;
            String string = null;
            if (cursorB.moveToFirst()) {
                if (!cursorB.isNull(iB)) {
                    string = cursorB.getString(iB);
                }
                systemIdInfo = new SystemIdInfo(string, cursorB.getInt(iB2), cursorB.getInt(iB3));
            }
            return systemIdInfo;
        } finally {
            cursorB.close();
            roomSQLiteQueryA.release();
        }
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public final SystemIdInfo c(WorkGenerationalId id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return super.c(id);
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public final void e(WorkGenerationalId id) {
        Intrinsics.checkNotNullParameter(id, "id");
        super.e(id);
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public final ArrayList f() {
        RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(0, "SELECT DISTINCT work_spec_id FROM SystemIdInfo");
        WorkDatabase_Impl workDatabase_Impl = this.f12889a;
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

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public final void g(SystemIdInfo systemIdInfo) {
        WorkDatabase_Impl workDatabase_Impl = this.f12889a;
        workDatabase_Impl.b();
        workDatabase_Impl.c();
        try {
            this.f12890b.f(systemIdInfo);
            workDatabase_Impl.o();
        } finally {
            workDatabase_Impl.j();
        }
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public final void h(int i2, String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f12889a;
        workDatabase_Impl.b();
        SharedSQLiteStatement sharedSQLiteStatement = this.f12891c;
        SupportSQLiteStatement supportSQLiteStatementA = sharedSQLiteStatement.a();
        if (str == null) {
            supportSQLiteStatementA.y1(1);
        } else {
            supportSQLiteStatementA.m(1, str);
        }
        supportSQLiteStatementA.e1(2, i2);
        workDatabase_Impl.c();
        try {
            supportSQLiteStatementA.H();
            workDatabase_Impl.o();
        } finally {
            workDatabase_Impl.j();
            sharedSQLiteStatement.d(supportSQLiteStatementA);
        }
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public final void i(String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f12889a;
        workDatabase_Impl.b();
        SharedSQLiteStatement sharedSQLiteStatement = this.f12892d;
        SupportSQLiteStatement supportSQLiteStatementA = sharedSQLiteStatement.a();
        if (str == null) {
            supportSQLiteStatementA.y1(1);
        } else {
            supportSQLiteStatementA.m(1, str);
        }
        workDatabase_Impl.c();
        try {
            supportSQLiteStatementA.H();
            workDatabase_Impl.o();
        } finally {
            workDatabase_Impl.j();
            sharedSQLiteStatement.d(supportSQLiteStatementA);
        }
    }
}
