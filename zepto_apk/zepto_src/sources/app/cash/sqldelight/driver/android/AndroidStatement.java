package app.cash.sqldelight.driver.android;

import app.cash.sqldelight.db.SqlPreparedStatement;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: classes.dex */
public interface AndroidStatement extends SqlPreparedStatement {
    Object b(Function1 function1);

    void close();

    long d();
}
