package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import com.chuckerteam.chucker.internal.ui.transaction.TransactionPayloadFragment$onQueryTextChange$1$invokeSuspend$$inlined$withResumed$1;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class WithLifecycleStateKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.lifecycle.LifecycleObserver, androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1] */
    public static final Object a(final Lifecycle lifecycle, boolean z, final MainCoroutineDispatcher mainCoroutineDispatcher, final TransactionPayloadFragment$onQueryTextChange$1$invokeSuspend$$inlined$withResumed$1 transactionPayloadFragment$onQueryTextChange$1$invokeSuspend$$inlined$withResumed$1, Continuation frame) throws Throwable {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(frame));
        cancellableContinuationImpl.s();
        final ?? r1 = new LifecycleEventObserver() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void a(LifecycleOwner source, Lifecycle.Event event) {
                Object objA;
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                Lifecycle.Event.Companion companion = Lifecycle.Event.Companion;
                Lifecycle.State state = Lifecycle.State.f4809e;
                companion.getClass();
                Lifecycle.Event eventB = Lifecycle.Event.Companion.b(state);
                CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
                Lifecycle lifecycle2 = lifecycle;
                if (event != eventB) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        lifecycle2.c(this);
                        Result.Companion companion2 = Result.f53538b;
                        cancellableContinuationImpl2.resumeWith(ResultKt.a(new LifecycleDestroyedException()));
                        return;
                    }
                    return;
                }
                lifecycle2.c(this);
                TransactionPayloadFragment$onQueryTextChange$1$invokeSuspend$$inlined$withResumed$1 transactionPayloadFragment$onQueryTextChange$1$invokeSuspend$$inlined$withResumed$12 = transactionPayloadFragment$onQueryTextChange$1$invokeSuspend$$inlined$withResumed$1;
                try {
                    Result.Companion companion3 = Result.f53538b;
                    objA = transactionPayloadFragment$onQueryTextChange$1$invokeSuspend$$inlined$withResumed$12.invoke();
                } catch (Throwable th) {
                    Result.Companion companion4 = Result.f53538b;
                    objA = ResultKt.a(th);
                }
                cancellableContinuationImpl2.resumeWith(objA);
            }
        };
        if (z) {
            mainCoroutineDispatcher.c1(EmptyCoroutineContext.f53685a, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$lambda$2$$inlined$Runnable$1
                @Override // java.lang.Runnable
                public final void run() {
                    lifecycle.a(r1);
                }
            });
        } else {
            lifecycle.a(r1);
        }
        cancellableContinuationImpl.u(new Function1<Throwable, Unit>() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f53685a;
                MainCoroutineDispatcher mainCoroutineDispatcher2 = mainCoroutineDispatcher;
                boolean zO1 = mainCoroutineDispatcher2.o1(emptyCoroutineContext);
                final WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 = r1;
                final Lifecycle lifecycle2 = lifecycle;
                if (zO1) {
                    mainCoroutineDispatcher2.c1(emptyCoroutineContext, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2$invoke$$inlined$Runnable$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            lifecycle2.c(withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1);
                        }
                    });
                } else {
                    lifecycle2.c(withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1);
                }
                return Unit.f53572a;
            }
        });
        Object objR = cancellableContinuationImpl.r();
        if (objR == CoroutineSingletons.f53689a) {
            Intrinsics.checkNotNullParameter(frame, "frame");
        }
        return objR;
    }
}
