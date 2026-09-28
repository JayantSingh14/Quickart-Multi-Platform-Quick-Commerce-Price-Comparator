package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.SubclassOptInRequired;
import kotlin.coroutines.Continuation;

@Metadata
@SubclassOptInRequired
/* loaded from: classes.dex */
public interface Deferred<T> extends Job {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    Object V(Continuation continuation);

    Object x();
}
