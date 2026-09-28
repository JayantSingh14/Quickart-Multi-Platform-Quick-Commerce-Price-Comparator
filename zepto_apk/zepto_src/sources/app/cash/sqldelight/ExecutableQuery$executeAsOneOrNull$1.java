package app.cash.sqldelight;

import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlCursor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class ExecutableQuery$executeAsOneOrNull$1 extends Lambda implements Function1<SqlCursor, QueryResult<Object>> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        SqlCursor cursor = (SqlCursor) obj;
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        if (((Boolean) cursor.next().f13144b).booleanValue()) {
            throw null;
        }
        return new QueryResult.Value(null);
    }
}
