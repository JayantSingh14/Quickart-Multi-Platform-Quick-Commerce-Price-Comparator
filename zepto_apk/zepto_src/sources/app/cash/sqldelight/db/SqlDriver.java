package app.cash.sqldelight.db;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.Transacter;
import app.cash.sqldelight.coroutines.a;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: classes.dex */
public interface SqlDriver extends Closeable {

    @Metadata
    public static final class DefaultImpls {
    }

    void I0(String[] strArr, Query.Listener listener);

    void O0(String[] strArr, a aVar);

    Transacter.Transaction V0();

    QueryResult b0(Integer num, String str, Function1 function1);

    void g1(String... strArr);

    QueryResult r1(Integer num, String str, Function1 function1, Function1 function12);
}
