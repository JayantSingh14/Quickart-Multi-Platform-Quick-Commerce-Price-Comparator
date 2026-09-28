package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.impl.WorkDatabase_Impl;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class WorkTagDao_Impl implements WorkTagDao {

    /* renamed from: a, reason: collision with root package name */
    public final WorkDatabase_Impl f12954a;

    /* renamed from: b, reason: collision with root package name */
    public final EntityInsertionAdapter f12955b;

    /* renamed from: androidx.work.impl.model.WorkTagDao_Impl$1, reason: invalid class name */
    class AnonymousClass1 extends EntityInsertionAdapter<WorkTag> {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }

        @Override // androidx.room.EntityInsertionAdapter
        public final void e(SupportSQLiteStatement supportSQLiteStatement, Object obj) {
            WorkTag workTag = (WorkTag) obj;
            String str = workTag.f12952a;
            if (str == null) {
                supportSQLiteStatement.y1(1);
            } else {
                supportSQLiteStatement.m(1, str);
            }
            String str2 = workTag.f12953b;
            if (str2 == null) {
                supportSQLiteStatement.y1(2);
            } else {
                supportSQLiteStatement.m(2, str2);
            }
        }
    }

    /* renamed from: androidx.work.impl.model.WorkTagDao_Impl$2, reason: invalid class name */
    class AnonymousClass2 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "DELETE FROM worktag WHERE work_spec_id=?";
        }
    }

    public WorkTagDao_Impl(WorkDatabase_Impl database) {
        this.f12954a = database;
        Intrinsics.checkNotNullParameter(database, "database");
        this.f12955b = new AnonymousClass1(database);
        new AnonymousClass2(database);
    }

    @Override // androidx.work.impl.model.WorkTagDao
    public final ArrayList a(String str) {
        RoomSQLiteQuery roomSQLiteQueryA = RoomSQLiteQuery.a(1, "SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?");
        if (str == null) {
            roomSQLiteQueryA.y1(1);
        } else {
            roomSQLiteQueryA.m(1, str);
        }
        WorkDatabase_Impl workDatabase_Impl = this.f12954a;
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

    @Override // androidx.work.impl.model.WorkTagDao
    public final void b(WorkTag workTag) {
        WorkDatabase_Impl workDatabase_Impl = this.f12954a;
        workDatabase_Impl.b();
        workDatabase_Impl.c();
        try {
            this.f12955b.f(workTag);
            workDatabase_Impl.o();
        } finally {
            workDatabase_Impl.j();
        }
    }

    @Override // androidx.work.impl.model.WorkTagDao
    public final void c(String id, LinkedHashSet tags) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(tags, "tags");
        super.c(id, tags);
    }
}
