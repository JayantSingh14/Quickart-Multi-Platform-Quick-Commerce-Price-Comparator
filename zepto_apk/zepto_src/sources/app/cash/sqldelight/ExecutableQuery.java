package app.cash.sqldelight;

import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlCursor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes.dex */
public abstract class ExecutableQuery<RowType> {

    /* renamed from: a, reason: collision with root package name */
    public final Lambda f13077a;

    /* JADX WARN: Multi-variable type inference failed */
    public ExecutableQuery(Function1 mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        this.f13077a = (Lambda) mapper;
    }

    public abstract QueryResult a(Function1 function1);

    public final List b() {
        final Query query = (Query) this;
        return (List) a(new Function1<SqlCursor, QueryResult<List<Object>>>() { // from class: app.cash.sqldelight.ExecutableQuery$executeAsList$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v5, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SqlCursor cursor = (SqlCursor) obj;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                ArrayList arrayList = new ArrayList();
                while (((Boolean) cursor.next().f13144b).booleanValue()) {
                    arrayList.add(query.f13077a.invoke(cursor));
                }
                return new QueryResult.Value(arrayList);
            }
        }).getValue();
    }
}
