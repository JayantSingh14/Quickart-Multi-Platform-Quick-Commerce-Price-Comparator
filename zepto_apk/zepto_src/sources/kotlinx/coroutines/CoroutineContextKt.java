package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata
/* loaded from: classes.dex */
public final class CoroutineContextKt {
    public static final CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, final boolean z) {
        Boolean bool = Boolean.FALSE;
        boolean zBooleanValue = ((Boolean) coroutineContext.fold(bool, new kotlin.coroutines.a(1))).booleanValue();
        boolean zBooleanValue2 = ((Boolean) coroutineContext2.fold(bool, new kotlin.coroutines.a(1))).booleanValue();
        if (!zBooleanValue && !zBooleanValue2) {
            return coroutineContext.plus(coroutineContext2);
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f53801a = coroutineContext2;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f53685a;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.fold(emptyCoroutineContext, new Function2() { // from class: kotlinx.coroutines.b
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                CoroutineContext coroutineContext4 = (CoroutineContext) obj;
                CoroutineContext.Element element = (CoroutineContext.Element) obj2;
                if (!(element instanceof CopyableThreadContextElement)) {
                    return coroutineContext4.plus(element);
                }
                Ref.ObjectRef objectRef2 = objectRef;
                if (((CoroutineContext) objectRef2.f53801a).get(element.getKey()) != null) {
                    objectRef2.f53801a = ((CoroutineContext) objectRef2.f53801a).minusKey(element.getKey());
                    return coroutineContext4.plus(((CopyableThreadContextElement) element).z0());
                }
                CopyableThreadContextElement copyableThreadContextElementK0 = (CopyableThreadContextElement) element;
                if (z) {
                    copyableThreadContextElementK0 = copyableThreadContextElementK0.k0();
                }
                return coroutineContext4.plus(copyableThreadContextElementK0);
            }
        });
        if (zBooleanValue2) {
            objectRef.f53801a = ((CoroutineContext) objectRef.f53801a).fold(emptyCoroutineContext, new kotlin.coroutines.a(2));
        }
        return coroutineContext3.plus((CoroutineContext) objectRef.f53801a);
    }

    public static final CoroutineContext b(CoroutineScope coroutineScope, CoroutineContext coroutineContext) {
        CoroutineContext coroutineContextA = a(coroutineScope.r(), coroutineContext, true);
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        return (coroutineContextA == defaultScheduler || coroutineContextA.get(ContinuationInterceptor.y0) != null) ? coroutineContextA : coroutineContextA.plus(defaultScheduler);
    }

    public static final UndispatchedCoroutine c(Continuation continuation, CoroutineContext coroutineContext, Object obj) {
        UndispatchedCoroutine undispatchedCoroutine = null;
        if ((continuation instanceof CoroutineStackFrame) && coroutineContext.get(UndispatchedMarker.f54172a) != null) {
            CoroutineStackFrame callerFrame = (CoroutineStackFrame) continuation;
            while (true) {
                if ((callerFrame instanceof DispatchedCoroutine) || (callerFrame = callerFrame.getCallerFrame()) == null) {
                    break;
                }
                if (callerFrame instanceof UndispatchedCoroutine) {
                    undispatchedCoroutine = (UndispatchedCoroutine) callerFrame;
                    break;
                }
            }
            if (undispatchedCoroutine != null) {
                undispatchedCoroutine.C0(coroutineContext, obj);
            }
        }
        return undispatchedCoroutine;
    }
}
