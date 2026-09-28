package androidx.room;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class QueryInterceptorDatabase implements SupportSQLiteDatabase {
    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void C(String sql) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean E1() {
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean F() {
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void H1(long j2) {
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void L0(int i2) {
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final SupportSQLiteStatement N0(String sql) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final int N1(ContentValues values, Object[] objArr) {
        Intrinsics.checkNotNullParameter("WorkSpec", "table");
        Intrinsics.checkNotNullParameter(values, "values");
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final long P() {
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void S() {
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void U() {
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean Y0() {
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean d0() {
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void e0() {
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void f1(Object[] bindArgs) {
        Intrinsics.checkNotNullParameter("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", "sql");
        Intrinsics.checkNotNullParameter(bindArgs, "bindArgs");
        ListBuilder builder = CollectionsKt.u();
        CollectionsKt.j(builder, bindArgs);
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.j();
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final int getVersion() {
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final long h1() {
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final String j() {
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final Cursor m0(SupportSQLiteQuery query) {
        Intrinsics.checkNotNullParameter(query, "query");
        query.e(new QueryInterceptorProgram());
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean n1() {
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void w() {
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final List z() {
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean z1() {
        throw null;
    }
}
