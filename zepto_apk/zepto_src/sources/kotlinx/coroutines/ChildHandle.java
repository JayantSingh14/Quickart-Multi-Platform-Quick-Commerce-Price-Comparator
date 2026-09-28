package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.Metadata;

@Deprecated
@InternalCoroutinesApi
@Metadata
/* loaded from: classes.dex */
public interface ChildHandle extends DisposableHandle {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    boolean b(Throwable th);

    Job getParent();
}
