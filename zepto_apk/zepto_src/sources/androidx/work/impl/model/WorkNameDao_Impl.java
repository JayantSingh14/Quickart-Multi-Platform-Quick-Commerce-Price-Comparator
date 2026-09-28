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
public final class WorkNameDao_Impl implements WorkNameDao {

    /* renamed from: a, reason: collision with root package name */
    public final WorkDatabase_Impl f12897a;

    /* renamed from: b, reason: collision with root package name */
    public final EntityInsertionAdapter f12898b;

    /* renamed from: androidx.work.impl.model.WorkNameDao_Impl$1, reason: invalid class name */
    class AnonymousClass1 extends EntityInsertionAdapter<WorkName> {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
        }

        @Override // androidx.room.EntityInsertionAdapter
        public final void e(SupportSQLiteStatement supportSQLiteStatement, Object obj) {
            WorkName workName = (WorkName) obj;
            String str = workName.f12895a;
            if (str == null) {
                supportSQLiteStatement.y1(1);
            } else {
                supportSQLiteStatement.m(1, str);
            }
            String str2 = workName.f12896b;
            if (str2 == null) {
                supportSQLiteStatement.y1(2);
            } else {
                supportSQLiteStatement.m(2, str2);
            }
        }
    }

    public WorkNameDao_Impl(WorkDatabase_Impl database) {
        this.f12897a = database;
        Intrinsics.checkNotNullParameter(database, "database");
        this.f12898b = new AnonymousClass1(database);
    }

    @Override // androidx.work.impl.model.WorkNameDao
    public final void a(WorkName workName) {
        WorkDatabase_Impl workDatabase_Impl = this.f12897a;
        workDatabase_Impl.b();
        workDatabase_Impl.c();
        try {
            this.f12898b.f(workName);
            workDatabase_Impl.o();
        } finally {
            workDatabase_Impl.j();
        }
    }

    @Override // androidx.work.impl.model.WorkNameDao
    public final ArrayList b(String str) {
        RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(1, "SELECT name FROM workname WHERE work_spec_id=?");
        if (str == null) {
            roomSQLiteQueryA.y1(1);
        } else {
            roomSQLiteQueryA.m(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = this.f12897a;
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
}
