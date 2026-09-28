package app.cash.sqldelight;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.coroutines.a;
import app.cash.sqldelight.db.QueryResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
final class SimpleQuery<RowType> extends Query<RowType> {
    @Override // app.cash.sqldelight.ExecutableQuery
    public final QueryResult a(Function1 mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        throw null;
    }

    @Override // app.cash.sqldelight.Query
    public final void c(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        throw null;
    }

    @Override // app.cash.sqldelight.Query
    public final void d(Query.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        throw null;
    }

    public final String toString() {
        return "null:null";
    }
}
