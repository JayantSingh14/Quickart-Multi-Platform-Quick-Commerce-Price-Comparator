package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.NonDisposableHandle;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class HandlerContext extends HandlerDispatcher implements Delay {

    /* renamed from: b, reason: collision with root package name */
    public final Handler f54176b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f54177c;

    /* renamed from: d, reason: collision with root package name */
    public final HandlerContext f54178d;

    public HandlerContext(Handler handler, boolean z) {
        this.f54176b = handler;
        this.f54177c = z;
        this.f54178d = z ? this : new HandlerContext(handler, true);
    }

    @Override // kotlinx.coroutines.Delay
    public final void A(long j2, final CancellableContinuationImpl cancellableContinuationImpl) {
        Runnable runnable = new Runnable() { // from class: kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                cancellableContinuationImpl.B(this, Unit.f53572a);
            }
        };
        if (j2 > 4611686018427387903L) {
            j2 = 4611686018427387903L;
        }
        if (this.f54176b.postDelayed(runnable, j2)) {
            cancellableContinuationImpl.u(new com.brentvatne.react.a(5, this, runnable));
        } else {
            S1(cancellableContinuationImpl.f54062e, runnable);
        }
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public final MainCoroutineDispatcher O1() {
        return this.f54178d;
    }

    public final void S1(CoroutineContext coroutineContext, Runnable runnable) {
        JobKt.b(coroutineContext, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        DefaultIoScheduler.f55150b.c1(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.Delay
    public final DisposableHandle b(long j2, final Runnable runnable, CoroutineContext coroutineContext) {
        if (j2 > 4611686018427387903L) {
            j2 = 4611686018427387903L;
        }
        if (this.f54176b.postDelayed(runnable, j2)) {
            return new DisposableHandle() { // from class: kotlinx.coroutines.android.a
                @Override // kotlinx.coroutines.DisposableHandle
                public final void dispose() {
                    this.f54182a.f54176b.removeCallbacks(runnable);
                }
            };
        }
        S1(coroutineContext, runnable);
        return NonDisposableHandle.f54155a;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void c1(CoroutineContext coroutineContext, Runnable runnable) {
        if (this.f54176b.post(runnable)) {
            return;
        }
        S1(coroutineContext, runnable);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof HandlerContext)) {
            return false;
        }
        HandlerContext handlerContext = (HandlerContext) obj;
        return handlerContext.f54176b == this.f54176b && handlerContext.f54177c == this.f54177c;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f54176b) ^ (this.f54177c ? 1231 : 1237);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean o1(CoroutineContext coroutineContext) {
        return (this.f54177c && Intrinsics.b(Looper.myLooper(), this.f54176b.getLooper())) ? false : true;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        MainCoroutineDispatcher mainCoroutineDispatcherO1;
        String str;
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        MainCoroutineDispatcher mainCoroutineDispatcher = MainDispatcherLoader.f55099a;
        if (this == mainCoroutineDispatcher) {
            str = "Dispatchers.Main";
        } else {
            try {
                mainCoroutineDispatcherO1 = mainCoroutineDispatcher.O1();
            } catch (UnsupportedOperationException unused) {
                mainCoroutineDispatcherO1 = null;
            }
            str = this == mainCoroutineDispatcherO1 ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.f54176b.toString();
        return this.f54177c ? android.support.v4.media.b.k(string, ".immediate") : string;
    }
}
