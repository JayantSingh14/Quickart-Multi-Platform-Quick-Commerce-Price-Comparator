package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: classes.dex */
public interface SendChannel<E> {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    boolean d(Throwable th);

    void h(Function1 function1);

    Object i(Object obj);

    Object o(Object obj, Continuation continuation);

    boolean p();
}
