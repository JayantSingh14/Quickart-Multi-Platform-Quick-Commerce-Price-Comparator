package app.cash.sqldelight.driver.android;

import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
final class AndroidPreparedStatement implements AndroidStatement {

    /* renamed from: a, reason: collision with root package name */
    public final SupportSQLiteStatement f13146a;

    public AndroidPreparedStatement(SupportSQLiteStatement statement) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        this.f13146a = statement;
    }

    @Override // app.cash.sqldelight.db.SqlPreparedStatement
    public final void a(int i2, Long l2) {
        long jLongValue = l2.longValue();
        this.f13146a.e1(i2 + 1, jLongValue);
    }

    @Override // app.cash.sqldelight.driver.android.AndroidStatement
    public final Object b(Function1 mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        throw new UnsupportedOperationException();
    }

    @Override // app.cash.sqldelight.driver.android.AndroidStatement
    public final void close() throws IOException {
        this.f13146a.close();
    }

    @Override // app.cash.sqldelight.driver.android.AndroidStatement
    public final long d() {
        return this.f13146a.H();
    }

    @Override // app.cash.sqldelight.db.SqlPreparedStatement
    public final void m(int i2, String str) {
        SupportSQLiteStatement supportSQLiteStatement = this.f13146a;
        int i3 = i2 + 1;
        if (str == null) {
            supportSQLiteStatement.y1(i3);
        } else {
            supportSQLiteStatement.m(i3, str);
        }
    }
}
