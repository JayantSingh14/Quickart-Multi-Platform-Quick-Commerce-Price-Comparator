package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class QueryInterceptorStatement implements SupportSQLiteStatement {
    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final long F0() {
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final int H() {
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void J(int i2, double d2) {
        a(i2, Double.valueOf(d2));
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final long J0() {
        throw null;
    }

    public final void a(int i2, Object obj) {
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final String a0() {
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final void d() {
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void e1(int i2, long j2) {
        a(i2, Long.valueOf(j2));
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void i1(int i2, byte[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        a(i2, value);
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void m(int i2, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        a(i2, value);
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void y1(int i2) {
        a(i2, null);
        throw null;
    }
}
