package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.AbstractCoroutineContextKey;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.LimitedDispatcher;
import kotlinx.coroutines.internal.LimitedDispatcherKt;

@Metadata
/* loaded from: classes.dex */
public abstract class CoroutineDispatcher extends AbstractCoroutineContextElement implements ContinuationInterceptor {

    /* renamed from: a, reason: collision with root package name */
    public static final Key f54074a = new Key(ContinuationInterceptor.y0, new com.zeptoconsumerapp.AutoLogin.a(4));

    @Metadata
    @ExperimentalStdlibApi
    public static final class Key extends AbstractCoroutineContextKey<ContinuationInterceptor, CoroutineDispatcher> {
    }

    public CoroutineDispatcher() {
        super(ContinuationInterceptor.y0);
    }

    public abstract void c1(CoroutineContext coroutineContext, Runnable runnable);

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (!(key instanceof AbstractCoroutineContextKey)) {
            if (ContinuationInterceptor.y0 == key) {
                return this;
            }
            return null;
        }
        AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
        CoroutineContext.Key key2 = getKey();
        abstractCoroutineContextKey.getClass();
        Intrinsics.checkNotNullParameter(key2, "key");
        if (key2 != abstractCoroutineContextKey && abstractCoroutineContextKey.f53680b != key2) {
            return null;
        }
        Intrinsics.checkNotNullParameter(this, "element");
        CoroutineContext.Element element = (CoroutineContext.Element) abstractCoroutineContextKey.f53679a.invoke(this);
        if (element != null) {
            return element;
        }
        return null;
    }

    public void l1(CoroutineContext coroutineContext, Runnable runnable) {
        c1(coroutineContext, runnable);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (key instanceof AbstractCoroutineContextKey) {
            AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
            CoroutineContext.Key key2 = getKey();
            abstractCoroutineContextKey.getClass();
            Intrinsics.checkNotNullParameter(key2, "key");
            if (key2 != abstractCoroutineContextKey && abstractCoroutineContextKey.f53680b != key2) {
                return this;
            }
            Intrinsics.checkNotNullParameter(this, "element");
            if (((CoroutineContext.Element) abstractCoroutineContextKey.f53679a.invoke(this)) != null) {
                return EmptyCoroutineContext.f53685a;
            }
        } else if (ContinuationInterceptor.y0 == key) {
            return EmptyCoroutineContext.f53685a;
        }
        return this;
    }

    public boolean o1(CoroutineContext coroutineContext) {
        return !(this instanceof Unconfined);
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    public final void s(Continuation continuation) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Intrinsics.d(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        do {
            atomicReferenceFieldUpdater = DispatchedContinuation.f55068h;
        } while (atomicReferenceFieldUpdater.get(dispatchedContinuation) == DispatchedContinuationKt.f55074b);
        Object obj = atomicReferenceFieldUpdater.get(dispatchedContinuation);
        CancellableContinuationImpl cancellableContinuationImpl = obj instanceof CancellableContinuationImpl ? (CancellableContinuationImpl) obj : null;
        if (cancellableContinuationImpl != null) {
            cancellableContinuationImpl.m();
        }
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    public final DispatchedContinuation s0(ContinuationImpl continuationImpl) {
        return new DispatchedContinuation(this, continuationImpl);
    }

    public CoroutineDispatcher s1(int i2) {
        LimitedDispatcherKt.a(i2);
        return new LimitedDispatcher(this, i2);
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + DebugStringsKt.a(this);
    }
}
