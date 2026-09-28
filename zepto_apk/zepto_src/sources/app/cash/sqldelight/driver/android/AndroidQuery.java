package app.cash.sqldelight.driver.android;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import app.cash.sqldelight.db.QueryResult;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
final class AndroidQuery implements SupportSQLiteQuery, AndroidStatement {

    /* renamed from: a, reason: collision with root package name */
    public final String f13147a;

    /* renamed from: b, reason: collision with root package name */
    public final SupportSQLiteDatabase f13148b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f13149c;

    public AndroidQuery(String sql, SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        Intrinsics.checkNotNullParameter(database, "database");
        this.f13147a = sql;
        this.f13148b = database;
        ArrayList arrayList = new ArrayList(2);
        for (int i2 = 0; i2 < 2; i2++) {
            arrayList.add(null);
        }
        this.f13149c = arrayList;
    }

    @Override // app.cash.sqldelight.db.SqlPreparedStatement
    public final void a(final int i2, final Long l2) {
        this.f13149c.set(i2, new Function1<SupportSQLiteProgram, Unit>() { // from class: app.cash.sqldelight.driver.android.AndroidQuery$bindLong$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SupportSQLiteProgram it = (SupportSQLiteProgram) obj;
                Intrinsics.checkNotNullParameter(it, "it");
                it.e1(i2 + 1, l2.longValue());
                return Unit.f53572a;
            }
        });
    }

    @Override // app.cash.sqldelight.driver.android.AndroidStatement
    public final Object b(Function1 mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        Cursor cursorM0 = this.f13148b.m0(this);
        try {
            Object value = ((QueryResult) mapper.invoke(new AndroidCursor(cursorM0))).getValue();
            CloseableKt.a(cursorM0, null);
            return value;
        } finally {
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final String c() {
        return this.f13147a;
    }

    @Override // app.cash.sqldelight.driver.android.AndroidStatement
    public final void close() {
    }

    @Override // app.cash.sqldelight.driver.android.AndroidStatement
    public final long d() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final void e(SupportSQLiteProgram statement) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        Iterator it = this.f13149c.iterator();
        while (it.hasNext()) {
            Function1 function1 = (Function1) it.next();
            Intrinsics.c(function1);
            function1.invoke(statement);
        }
    }

    @Override // app.cash.sqldelight.db.SqlPreparedStatement
    public final void m(final int i2, final String str) {
        this.f13149c.set(i2, new Function1<SupportSQLiteProgram, Unit>() { // from class: app.cash.sqldelight.driver.android.AndroidQuery$bindString$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SupportSQLiteProgram it = (SupportSQLiteProgram) obj;
                Intrinsics.checkNotNullParameter(it, "it");
                int i3 = i2;
                String str2 = str;
                int i4 = i3 + 1;
                if (str2 == null) {
                    it.y1(i4);
                } else {
                    it.m(i4, str2);
                }
                return Unit.f53572a;
            }
        });
    }

    public final String toString() {
        return this.f13147a;
    }
}
