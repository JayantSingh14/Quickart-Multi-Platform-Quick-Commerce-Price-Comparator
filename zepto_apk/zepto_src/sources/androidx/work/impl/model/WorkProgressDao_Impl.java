package androidx.work.impl.model;

import androidx.room.EntityInsertionAdapter;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.Data;
import androidx.work.impl.WorkDatabase_Impl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class WorkProgressDao_Impl implements WorkProgressDao {

    /* renamed from: a, reason: collision with root package name */
    public final WorkDatabase_Impl f12901a;

    /* renamed from: b, reason: collision with root package name */
    public final EntityInsertionAdapter f12902b;

    /* renamed from: c, reason: collision with root package name */
    public final SharedSQLiteStatement f12903c;

    /* renamed from: d, reason: collision with root package name */
    public final SharedSQLiteStatement f12904d;

    /* renamed from: androidx.work.impl.model.WorkProgressDao_Impl$1, reason: invalid class name */
    class AnonymousClass1 extends EntityInsertionAdapter<WorkProgress> {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
        }

        @Override // androidx.room.EntityInsertionAdapter
        public final void e(SupportSQLiteStatement supportSQLiteStatement, Object obj) throws Throwable {
            WorkProgress workProgress = (WorkProgress) obj;
            if (workProgress.b() == null) {
                supportSQLiteStatement.y1(1);
            } else {
                supportSQLiteStatement.m(1, workProgress.b());
            }
            byte[] bArrC = Data.c(workProgress.a());
            if (bArrC == null) {
                supportSQLiteStatement.y1(2);
            } else {
                supportSQLiteStatement.i1(2, bArrC);
            }
        }
    }

    /* renamed from: androidx.work.impl.model.WorkProgressDao_Impl$2, reason: invalid class name */
    class AnonymousClass2 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "DELETE from WorkProgress where work_spec_id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkProgressDao_Impl$3, reason: invalid class name */
    class AnonymousClass3 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String c() {
            return "DELETE FROM WorkProgress";
        }
    }

    public WorkProgressDao_Impl(WorkDatabase_Impl database) {
        this.f12901a = database;
        Intrinsics.checkNotNullParameter(database, "database");
        this.f12902b = new AnonymousClass1(database);
        this.f12903c = new AnonymousClass2(database);
        this.f12904d = new AnonymousClass3(database);
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public final void a(String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f12901a;
        workDatabase_Impl.b();
        SharedSQLiteStatement sharedSQLiteStatement = this.f12903c;
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

    @Override // androidx.work.impl.model.WorkProgressDao
    public final void b() {
        WorkDatabase_Impl workDatabase_Impl = this.f12901a;
        workDatabase_Impl.b();
        SharedSQLiteStatement sharedSQLiteStatement = this.f12904d;
        SupportSQLiteStatement supportSQLiteStatementA = sharedSQLiteStatement.a();
        workDatabase_Impl.c();
        try {
            supportSQLiteStatementA.H();
            workDatabase_Impl.o();
        } finally {
            workDatabase_Impl.j();
            sharedSQLiteStatement.d(supportSQLiteStatementA);
        }
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public final void c(WorkProgress workProgress) {
        WorkDatabase_Impl workDatabase_Impl = this.f12901a;
        workDatabase_Impl.b();
        workDatabase_Impl.c();
        try {
            this.f12902b.f(workProgress);
            workDatabase_Impl.o();
        } finally {
            workDatabase_Impl.j();
        }
    }
}
