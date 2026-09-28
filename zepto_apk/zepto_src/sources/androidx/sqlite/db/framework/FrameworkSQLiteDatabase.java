package androidx.sqlite.db.framework;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class FrameworkSQLiteDatabase implements SupportSQLiteDatabase {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f11906b = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f11907c = new String[0];

    /* renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f11908a;

    @RequiresApi
    @Metadata
    /* loaded from: classes3.dex */
    public static final class Api30Impl {
        @DoNotInline
        public final void a(@NotNull SQLiteDatabase sQLiteDatabase, @NotNull String sql, @Nullable Object[] objArr) throws SQLException {
            Intrinsics.checkNotNullParameter(sQLiteDatabase, "sQLiteDatabase");
            Intrinsics.checkNotNullParameter(sql, "sql");
            sQLiteDatabase.execPerConnectionSQL(sql, objArr);
        }
    }

    @Metadata
    public static final class Companion {
    }

    public FrameworkSQLiteDatabase(SQLiteDatabase delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f11908a = delegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void C(String sql) throws SQLException {
        Intrinsics.checkNotNullParameter(sql, "sql");
        this.f11908a.execSQL(sql);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean E1() {
        SQLiteDatabase sQLiteDatabase = this.f11908a;
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "sQLiteDatabase");
        return sQLiteDatabase.isWriteAheadLoggingEnabled();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean F() {
        return this.f11908a.isDatabaseIntegrityOk();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void H1(long j2) {
        this.f11908a.setPageSize(j2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void L0(int i2) {
        this.f11908a.setVersion(i2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final SupportSQLiteStatement N0(String sql) throws SQLException {
        Intrinsics.checkNotNullParameter(sql, "sql");
        SQLiteStatement sQLiteStatementCompileStatement = this.f11908a.compileStatement(sql);
        Intrinsics.checkNotNullExpressionValue(sQLiteStatementCompileStatement, "delegate.compileStatement(sql)");
        return new FrameworkSQLiteStatement(sQLiteStatementCompileStatement);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final int N1(ContentValues values, Object[] objArr) throws SQLException {
        Intrinsics.checkNotNullParameter("WorkSpec", "table");
        Intrinsics.checkNotNullParameter(values, "values");
        if (values.size() == 0) {
            throw new IllegalArgumentException("Empty values");
        }
        int size = values.size();
        int length = objArr.length + size;
        Object[] objArr2 = new Object[length];
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(f11906b[3]);
        sb.append("WorkSpec SET ");
        int i2 = 0;
        for (String str : values.keySet()) {
            sb.append(i2 > 0 ? "," : "");
            sb.append(str);
            objArr2[i2] = values.get(str);
            sb.append("=?");
            i2++;
        }
        for (int i3 = size; i3 < length; i3++) {
            objArr2[i3] = objArr[i3 - size];
        }
        if (!TextUtils.isEmpty("last_enqueue_time = 0 AND interval_duration <> 0 ")) {
            sb.append(" WHERE last_enqueue_time = 0 AND interval_duration <> 0 ");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        SupportSQLiteStatement statement = N0(string);
        Intrinsics.checkNotNullParameter(statement, "statement");
        int length2 = objArr2.length;
        int i4 = 0;
        while (i4 < length2) {
            Object obj = objArr2[i4];
            i4++;
            if (obj == null) {
                statement.y1(i4);
            } else if (obj instanceof byte[]) {
                statement.i1(i4, (byte[]) obj);
            } else if (obj instanceof Float) {
                statement.J(i4, ((Number) obj).floatValue());
            } else if (obj instanceof Double) {
                statement.J(i4, ((Number) obj).doubleValue());
            } else if (obj instanceof Long) {
                statement.e1(i4, ((Number) obj).longValue());
            } else if (obj instanceof Integer) {
                statement.e1(i4, ((Number) obj).intValue());
            } else if (obj instanceof Short) {
                statement.e1(i4, ((Number) obj).shortValue());
            } else if (obj instanceof Byte) {
                statement.e1(i4, ((Number) obj).byteValue());
            } else if (obj instanceof String) {
                statement.m(i4, (String) obj);
            } else {
                if (!(obj instanceof Boolean)) {
                    throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i4 + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
                }
                statement.e1(i4, ((Boolean) obj).booleanValue() ? 1L : 0L);
            }
        }
        return ((FrameworkSQLiteStatement) statement).f11936b.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final long P() {
        return this.f11908a.getPageSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void S() {
        this.f11908a.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void U() {
        this.f11908a.beginTransactionNonExclusive();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean Y0() {
        return this.f11908a.isReadOnly();
    }

    public final Cursor a(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        return m0(new SimpleSQLiteQuery(query));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f11908a.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean d0() {
        return this.f11908a.isDbLockedByCurrentThread();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void e0() {
        this.f11908a.endTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void f1(Object[] bindArgs) throws SQLException {
        Intrinsics.checkNotNullParameter("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", "sql");
        Intrinsics.checkNotNullParameter(bindArgs, "bindArgs");
        this.f11908a.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", bindArgs);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final int getVersion() {
        return this.f11908a.getVersion();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final long h1() {
        return this.f11908a.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final String j() {
        return this.f11908a.getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final Cursor m0(SupportSQLiteQuery query) {
        Intrinsics.checkNotNullParameter(query, "query");
        final FrameworkSQLiteDatabase$query$cursorFactory$1 frameworkSQLiteDatabase$query$cursorFactory$1 = new FrameworkSQLiteDatabase$query$cursorFactory$1(query);
        Cursor cursorRawQueryWithFactory = this.f11908a.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: androidx.sqlite.db.framework.a
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                Function4 tmp0 = frameworkSQLiteDatabase$query$cursorFactory$1;
                Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
                return (Cursor) ((FrameworkSQLiteDatabase$query$cursorFactory$1) tmp0).d(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, query.c(), f11907c, null);
        Intrinsics.checkNotNullExpressionValue(cursorRawQueryWithFactory, "delegate.rawQueryWithFac…EMPTY_STRING_ARRAY, null)");
        return cursorRawQueryWithFactory;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean n1() {
        return this.f11908a.yieldIfContendedSafely();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void w() {
        this.f11908a.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final List z() {
        return this.f11908a.getAttachedDbs();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean z1() {
        return this.f11908a.inTransaction();
    }
}
