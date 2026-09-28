package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

@Metadata
/* loaded from: classes.dex */
public final class DownstreamExceptionContext implements CoroutineContext {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoroutineContext f55032a;

    /* renamed from: b, reason: collision with root package name */
    public final Throwable f55033b;

    public DownstreamExceptionContext(CoroutineContext coroutineContext, Throwable th) {
        this.f55032a = coroutineContext;
        this.f55033b = th;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        return this.f55032a.fold(obj, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        return this.f55032a.get(key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        return this.f55032a.minusKey(key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return this.f55032a.plus(coroutineContext);
    }
}
