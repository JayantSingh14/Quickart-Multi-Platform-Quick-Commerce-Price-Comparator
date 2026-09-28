package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@RestrictTo
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    public abstract void e(SupportSQLiteStatement supportSQLiteStatement, Object obj);

    public final void f(Object obj) {
        SupportSQLiteStatement supportSQLiteStatementA = a();
        try {
            e(supportSQLiteStatementA, obj);
            supportSQLiteStatementA.F0();
        } finally {
            d(supportSQLiteStatementA);
        }
    }
}
