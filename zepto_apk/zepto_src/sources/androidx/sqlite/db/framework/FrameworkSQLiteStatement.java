package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class FrameworkSQLiteStatement extends FrameworkSQLiteProgram implements SupportSQLiteStatement {

    /* renamed from: b, reason: collision with root package name */
    public final SQLiteStatement f11936b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrameworkSQLiteStatement(SQLiteStatement delegate) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f11936b = delegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final long F0() {
        return this.f11936b.executeInsert();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final int H() {
        return this.f11936b.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final long J0() {
        return this.f11936b.simpleQueryForLong();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final String a0() {
        return this.f11936b.simpleQueryForString();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final void d() {
        this.f11936b.execute();
    }
}
