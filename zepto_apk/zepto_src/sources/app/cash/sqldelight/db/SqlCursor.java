package app.cash.sqldelight.db;

import app.cash.sqldelight.db.QueryResult;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface SqlCursor {
    Long getLong(int i2);

    String getString(int i2);

    QueryResult.Value next();
}
