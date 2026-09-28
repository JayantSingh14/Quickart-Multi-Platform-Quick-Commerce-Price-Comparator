package app.cash.sqldelight;

import app.cash.sqldelight.db.SqlDriver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class TransacterImpl extends BaseTransacterImpl implements Transacter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransacterImpl(SqlDriver driver) {
        super(driver);
        Intrinsics.checkNotNullParameter(driver, "driver");
    }
}
