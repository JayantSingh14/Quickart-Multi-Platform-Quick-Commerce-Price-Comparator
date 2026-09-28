package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: classes.dex */
public final class ThrowingCollector implements FlowCollector<Object> {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f54935a;

    public ThrowingCollector(Throwable th) {
        this.f54935a = th;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object a(Object obj, Continuation continuation) throws Throwable {
        throw this.f54935a;
    }
}
