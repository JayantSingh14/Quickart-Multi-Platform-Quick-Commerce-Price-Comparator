package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes3.dex */
final class SequenceBuilderIterator<T> extends SequenceScope<T> implements Iterator<T>, Continuation<Unit>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public int f53920a;

    /* renamed from: b, reason: collision with root package name */
    public Object f53921b;

    /* renamed from: c, reason: collision with root package name */
    public Iterator f53922c;

    /* renamed from: d, reason: collision with root package name */
    public Continuation f53923d;

    @Override // kotlin.sequences.SequenceScope
    public final void a(Object obj, Continuation frame) {
        this.f53921b = obj;
        this.f53920a = 3;
        this.f53923d = frame;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        Intrinsics.checkNotNullParameter(frame, "frame");
    }

    @Override // kotlin.sequences.SequenceScope
    public final Object b(Iterator it, RestrictedSuspendLambda frame) {
        if (!it.hasNext()) {
            return Unit.f53572a;
        }
        this.f53922c = it;
        this.f53920a = 2;
        this.f53923d = frame;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        Intrinsics.checkNotNullParameter(frame, "frame");
        return coroutineSingletons;
    }

    public final RuntimeException c() {
        int i2 = this.f53920a;
        if (i2 == 4) {
            return new NoSuchElementException();
        }
        if (i2 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f53920a);
    }

    public final void d(Continuation continuation) {
        this.f53923d = continuation;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return EmptyCoroutineContext.f53685a;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int i2 = this.f53920a;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2 || i2 == 3) {
                        return true;
                    }
                    if (i2 == 4) {
                        return false;
                    }
                    throw c();
                }
                Iterator it = this.f53922c;
                Intrinsics.c(it);
                if (it.hasNext()) {
                    this.f53920a = 2;
                    return true;
                }
                this.f53922c = null;
            }
            this.f53920a = 5;
            Continuation continuation = this.f53923d;
            Intrinsics.c(continuation);
            this.f53923d = null;
            Result.Companion companion = Result.f53538b;
            continuation.resumeWith(Unit.f53572a);
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i2 = this.f53920a;
        if (i2 == 0 || i2 == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        }
        if (i2 == 2) {
            this.f53920a = 1;
            Iterator it = this.f53922c;
            Intrinsics.c(it);
            return it.next();
        }
        if (i2 != 3) {
            throw c();
        }
        this.f53920a = 0;
        Object obj = this.f53921b;
        this.f53921b = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        ResultKt.b(obj);
        this.f53920a = 4;
    }
}
