package com.google.common.util.concurrent;

import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Closeable;
import java.io.IOException;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

@ElementTypesAreNonnullByDefault
@DoNotMock
@J2ktIncompatible
/* loaded from: classes4.dex */
public final class ClosingFuture<V> {

    /* renamed from: a, reason: collision with root package name */
    public static final LazyLogger f43430a = new LazyLogger(ClosingFuture.class);

    /* renamed from: com.google.common.util.concurrent.ClosingFuture$1, reason: invalid class name */
    class AnonymousClass1 implements FutureCallback<Closeable> {
        @Override // com.google.common.util.concurrent.FutureCallback
        public final void onFailure(Throwable th) {
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public final void onSuccess(Object obj) {
            throw null;
        }
    }

    /* renamed from: com.google.common.util.concurrent.ClosingFuture$10, reason: invalid class name */
    class AnonymousClass10 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            LazyLogger lazyLogger = ClosingFuture.f43430a;
            throw null;
        }
    }

    /* renamed from: com.google.common.util.concurrent.ClosingFuture$11, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass11 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f43431a;

        static {
            int[] iArr = new int[State.values().length];
            f43431a = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43431a[5] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43431a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f43431a[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f43431a[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f43431a[0] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: com.google.common.util.concurrent.ClosingFuture$2, reason: invalid class name */
    class AnonymousClass2 implements Callable<Object> {
        @Override // java.util.concurrent.Callable
        public final Object call() {
            throw null;
        }

        public final String toString() {
            throw null;
        }
    }

    /* renamed from: com.google.common.util.concurrent.ClosingFuture$3, reason: invalid class name */
    class AnonymousClass3 implements AsyncCallable<Object> {
        public final String toString() {
            throw null;
        }
    }

    /* renamed from: com.google.common.util.concurrent.ClosingFuture$4, reason: invalid class name */
    class AnonymousClass4 implements AsyncFunction<Object, Object> {
        @Override // com.google.common.util.concurrent.AsyncFunction
        public final ListenableFuture apply(Object obj) {
            throw null;
        }

        public final String toString() {
            throw null;
        }
    }

    /* renamed from: com.google.common.util.concurrent.ClosingFuture$5, reason: invalid class name */
    class AnonymousClass5 implements AsyncFunction<Object, Object> {
        @Override // com.google.common.util.concurrent.AsyncFunction
        public final ListenableFuture apply(Object obj) {
            throw null;
        }

        public final String toString() {
            throw null;
        }
    }

    /* renamed from: com.google.common.util.concurrent.ClosingFuture$6, reason: invalid class name */
    class AnonymousClass6 implements AsyncClosingFunction<Object, Object> {
    }

    /* renamed from: com.google.common.util.concurrent.ClosingFuture$7, reason: invalid class name */
    class AnonymousClass7 implements AsyncFunction<Throwable, Object> {
        @Override // com.google.common.util.concurrent.AsyncFunction
        public final ListenableFuture apply(Object obj) {
            throw null;
        }

        public final String toString() {
            throw null;
        }
    }

    /* renamed from: com.google.common.util.concurrent.ClosingFuture$8, reason: invalid class name */
    class AnonymousClass8 implements AsyncFunction<Throwable, Object> {
        @Override // com.google.common.util.concurrent.AsyncFunction
        public final ListenableFuture apply(Object obj) {
            throw null;
        }

        public final String toString() {
            throw null;
        }
    }

    /* renamed from: com.google.common.util.concurrent.ClosingFuture$9, reason: invalid class name */
    class AnonymousClass9 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            LazyLogger lazyLogger = ClosingFuture.f43430a;
            throw null;
        }
    }

    public interface AsyncClosingCallable<V> {
    }

    public interface AsyncClosingFunction<T, U> {
    }

    public static final class CloseableList extends IdentityHashMap<Closeable, Executor> implements Closeable, AutoCloseable {

        /* renamed from: a, reason: collision with root package name */
        public volatile boolean f43432a;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.f43432a) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.f43432a) {
                        return;
                    }
                    this.f43432a = true;
                    for (Map.Entry<Closeable, Executor> entry : entrySet()) {
                        ClosingFuture.a(entry.getKey(), entry.getValue());
                    }
                    clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public interface ClosingCallable<V> {
    }

    public interface ClosingFunction<T, U> {
    }

    @DoNotMock
    public static class Combiner {

        /* renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner$1, reason: invalid class name */
        class AnonymousClass1 implements Callable<Object> {
            @Override // java.util.concurrent.Callable
            public final Object call() {
                throw null;
            }

            public final String toString() {
                throw null;
            }
        }

        /* renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner$2, reason: invalid class name */
        class AnonymousClass2 implements AsyncCallable<Object> {
            public final String toString() {
                throw null;
            }
        }

        public interface AsyncCombiningCallable<V> {
        }

        public interface CombiningCallable<V> {
        }
    }

    public static final class Combiner2<V1, V2> extends Combiner {

        /* renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner2$1, reason: invalid class name */
        class AnonymousClass1 implements Combiner.CombiningCallable<Object> {
            public final String toString() {
                throw null;
            }
        }

        /* renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner2$2, reason: invalid class name */
        class AnonymousClass2 implements Combiner.AsyncCombiningCallable<Object> {
            public final String toString() {
                throw null;
            }
        }

        public interface AsyncClosingFunction2<V1, V2, U> {
        }

        public interface ClosingFunction2<V1, V2, U> {
        }
    }

    public static final class Combiner3<V1, V2, V3> extends Combiner {

        /* renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner3$1, reason: invalid class name */
        class AnonymousClass1 implements Combiner.CombiningCallable<Object> {
            public final String toString() {
                throw null;
            }
        }

        /* renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner3$2, reason: invalid class name */
        class AnonymousClass2 implements Combiner.AsyncCombiningCallable<Object> {
            public final String toString() {
                throw null;
            }
        }

        public interface AsyncClosingFunction3<V1, V2, V3, U> {
        }

        public interface ClosingFunction3<V1, V2, V3, U> {
        }
    }

    public static final class Combiner4<V1, V2, V3, V4> extends Combiner {

        /* renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner4$1, reason: invalid class name */
        class AnonymousClass1 implements Combiner.CombiningCallable<Object> {
            public final String toString() {
                throw null;
            }
        }

        /* renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner4$2, reason: invalid class name */
        class AnonymousClass2 implements Combiner.AsyncCombiningCallable<Object> {
            public final String toString() {
                throw null;
            }
        }

        public interface AsyncClosingFunction4<V1, V2, V3, V4, U> {
        }

        public interface ClosingFunction4<V1, V2, V3, V4, U> {
        }
    }

    public static final class Combiner5<V1, V2, V3, V4, V5> extends Combiner {

        /* renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner5$1, reason: invalid class name */
        class AnonymousClass1 implements Combiner.CombiningCallable<Object> {
            public final String toString() {
                throw null;
            }
        }

        /* renamed from: com.google.common.util.concurrent.ClosingFuture$Combiner5$2, reason: invalid class name */
        class AnonymousClass2 implements Combiner.AsyncCombiningCallable<Object> {
            public final String toString() {
                throw null;
            }
        }

        public interface AsyncClosingFunction5<V1, V2, V3, V4, V5, U> {
        }

        public interface ClosingFunction5<V1, V2, V3, V4, V5, U> {
        }
    }

    public static final class DeferredCloser {
    }

    public static final class Peeker {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class State {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f43433a = {new State("OPEN", 0), new State("SUBSUMED", 1), new State("WILL_CLOSE", 2), new State("CLOSING", 3), new State("CLOSED", 4), new State("WILL_CREATE_VALUE_AND_CLOSER", 5)};

        /* JADX INFO: Fake field, exist only in values array */
        State EF5;

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) f43433a.clone();
        }
    }

    public static final class ValueAndCloser<V> {
    }

    public interface ValueAndCloserConsumer<V> {
    }

    public static void a(final Closeable closeable, Executor executor) {
        if (closeable == null) {
            return;
        }
        try {
            executor.execute(new Runnable() { // from class: com.google.common.util.concurrent.b
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    Closeable closeable2 = closeable;
                    LazyLogger lazyLogger = ClosingFuture.f43430a;
                    try {
                        closeable2.close();
                    } catch (Exception e2) {
                        Platform.a(e2);
                        ClosingFuture.f43430a.a().log(Level.WARNING, "thrown by close()", (Throwable) e2);
                    }
                }
            });
        } catch (RejectedExecutionException e2) {
            LazyLogger lazyLogger = f43430a;
            Logger loggerA = lazyLogger.a();
            Level level = Level.WARNING;
            if (loggerA.isLoggable(level)) {
                lazyLogger.a().log(level, String.format("while submitting close to %s; will close inline", executor), (Throwable) e2);
            }
            a(closeable, DirectExecutor.f43436a);
        }
    }

    public final void finalize() {
        throw null;
    }

    public final String toString() {
        MoreObjects.b(this);
        throw null;
    }
}
