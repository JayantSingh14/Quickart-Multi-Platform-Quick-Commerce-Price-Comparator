package app.cash.sqldelight;

import app.cash.sqldelight.coroutines.a;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public abstract class Query<RowType> extends ExecutableQuery<RowType> {

    @Metadata
    public interface Listener {
        void a();
    }

    public abstract void c(a aVar);

    public abstract void d(Listener listener);
}
