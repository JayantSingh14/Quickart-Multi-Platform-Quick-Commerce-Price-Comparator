package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;

@Metadata
/* loaded from: classes3.dex */
public final class OnUndeliveredElementKt {
    public static final void a(Function1 function1, Object obj, CoroutineContext coroutineContext) {
        UndeliveredElementException undeliveredElementException = null;
        try {
            function1.invoke(obj);
        } catch (Throwable th) {
            undeliveredElementException = new UndeliveredElementException(android.support.v4.media.b.j(obj, "Exception in undelivered element handler for "), th);
        }
        if (undeliveredElementException != null) {
            CoroutineExceptionHandlerKt.a(coroutineContext, undeliveredElementException);
        }
    }
}
