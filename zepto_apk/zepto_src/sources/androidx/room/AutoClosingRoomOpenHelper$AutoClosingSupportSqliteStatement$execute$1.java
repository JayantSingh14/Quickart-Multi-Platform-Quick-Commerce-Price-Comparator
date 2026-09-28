package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$execute$1 extends Lambda implements Function1<SupportSQLiteStatement, Object> {
    static {
        new AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$execute$1(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        SupportSQLiteStatement statement = (SupportSQLiteStatement) obj;
        Intrinsics.checkNotNullParameter(statement, "statement");
        statement.d();
        return null;
    }
}
