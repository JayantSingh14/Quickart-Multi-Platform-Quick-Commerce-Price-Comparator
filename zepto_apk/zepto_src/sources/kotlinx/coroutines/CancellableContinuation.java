package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.SubclassOptInRequired;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.internal.Symbol;

@Metadata
@SubclassOptInRequired
/* loaded from: classes.dex */
public interface CancellableContinuation<T> extends Continuation<T> {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    Symbol f(Object obj, Function3 function3);

    void n(Object obj, Function3 function3);

    void q(Object obj);
}
