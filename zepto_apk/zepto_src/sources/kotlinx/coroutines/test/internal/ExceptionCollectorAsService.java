package kotlinx.coroutines.test.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Metadata
/* loaded from: classes3.dex */
public final class ExceptionCollectorAsService implements CoroutineExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExceptionCollector f55331a = ExceptionCollector.f55329a;

    public final boolean equals(Object obj) {
        return (obj instanceof ExceptionCollectorAsService) || (obj instanceof ExceptionCollector);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        return this.f55331a.fold(obj, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        return this.f55331a.get(key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return this.f55331a.getKey();
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(CoroutineContext coroutineContext, Throwable th) {
        this.f55331a.getClass();
        synchronized (ExceptionCollector.f55330b) {
        }
    }

    public final int hashCode() {
        return ExceptionCollector.f55329a.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        return this.f55331a.minusKey(key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return this.f55331a.plus(coroutineContext);
    }
}
