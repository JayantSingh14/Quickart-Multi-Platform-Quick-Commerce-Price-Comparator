package app.cash.sqldelight;

import app.cash.sqldelight.db.QueryResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
final class SimpleExecutableQuery<RowType> extends ExecutableQuery<RowType> {
    @Override // app.cash.sqldelight.ExecutableQuery
    public final QueryResult a(Function1 mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        throw null;
    }

    public final String toString() {
        return "null:null";
    }
}
