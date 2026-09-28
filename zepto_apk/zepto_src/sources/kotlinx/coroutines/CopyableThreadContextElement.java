package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata
@DelicateCoroutinesApi
@ExperimentalCoroutinesApi
/* loaded from: classes.dex */
public interface CopyableThreadContextElement<S> extends ThreadContextElement<S> {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    CopyableThreadContextElement k0();

    CoroutineContext z0();
}
