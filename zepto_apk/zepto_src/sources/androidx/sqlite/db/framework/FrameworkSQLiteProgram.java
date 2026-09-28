package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public class FrameworkSQLiteProgram implements SupportSQLiteProgram {

    /* renamed from: a, reason: collision with root package name */
    public final SQLiteProgram f11935a;

    public FrameworkSQLiteProgram(SQLiteProgram delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f11935a = delegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void J(int i2, double d2) {
        this.f11935a.bindDouble(i2, d2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f11935a.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void e1(int i2, long j2) {
        this.f11935a.bindLong(i2, j2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void i1(int i2, byte[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f11935a.bindBlob(i2, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void m(int i2, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f11935a.bindString(i2, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void y1(int i2) {
        this.f11935a.bindNull(i2);
    }
}
