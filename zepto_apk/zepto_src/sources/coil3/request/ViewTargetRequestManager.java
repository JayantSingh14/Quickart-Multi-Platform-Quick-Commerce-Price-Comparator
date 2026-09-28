package coil3.request;

import android.view.View;
import androidx.annotation.MainThread;
import coil3.util.CoroutinesKt;
import coil3.util.Utils_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ViewTargetRequestManager implements View.OnAttachStateChangeListener {

    @Nullable
    private ViewTargetDisposable currentDisposable;

    @Nullable
    private ViewTargetRequestDelegate currentRequest;
    private boolean isRestart;

    @Nullable
    private Job pendingClear;

    @NotNull
    private final View view;

    @Metadata
    @DebugMetadata(c = "coil3.request.ViewTargetRequestManager$dispose$1", f = "ViewTargetRequestManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: coil3.request.ViewTargetRequestManager$dispose$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ViewTargetRequestManager.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            ViewTargetRequestManager.this.setRequest(null);
            return Unit.f53572a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f53572a);
        }
    }

    public ViewTargetRequestManager(@NotNull View view) {
        this.view = view;
    }

    public final synchronized void dispose() {
        Job job = this.pendingClear;
        if (job != null) {
            job.e(null);
        }
        GlobalScope globalScope = GlobalScope.f54113a;
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        this.pendingClear = BuildersKt.c(globalScope, MainDispatcherLoader.f55099a.O1(), new AnonymousClass1(null), 2);
        this.currentDisposable = null;
    }

    @NotNull
    public final synchronized ViewTargetDisposable getDisposable(@NotNull Deferred<? extends ImageResult> deferred) {
        ViewTargetDisposable viewTargetDisposable = this.currentDisposable;
        if (viewTargetDisposable != null && Utils_androidKt.isMainThread() && this.isRestart) {
            this.isRestart = false;
            viewTargetDisposable.setJob(deferred);
            return viewTargetDisposable;
        }
        Job job = this.pendingClear;
        if (job != null) {
            job.e(null);
        }
        this.pendingClear = null;
        ViewTargetDisposable viewTargetDisposable2 = new ViewTargetDisposable(this.view, deferred);
        this.currentDisposable = viewTargetDisposable2;
        return viewTargetDisposable2;
    }

    @Nullable
    public final synchronized ImageResult getResult() {
        ViewTargetDisposable viewTargetDisposable;
        Deferred<ImageResult> job;
        viewTargetDisposable = this.currentDisposable;
        return (viewTargetDisposable == null || (job = viewTargetDisposable.getJob()) == null) ? null : (ImageResult) CoroutinesKt.getCompletedOrNull(job);
    }

    public final synchronized boolean isDisposed(@NotNull ViewTargetDisposable viewTargetDisposable) {
        return viewTargetDisposable != this.currentDisposable;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    @MainThread
    public void onViewAttachedToWindow(@NotNull View view) {
        ViewTargetRequestDelegate viewTargetRequestDelegate = this.currentRequest;
        if (viewTargetRequestDelegate == null) {
            return;
        }
        this.isRestart = true;
        viewTargetRequestDelegate.restart();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    @MainThread
    public void onViewDetachedFromWindow(@NotNull View view) {
        ViewTargetRequestDelegate viewTargetRequestDelegate = this.currentRequest;
        if (viewTargetRequestDelegate != null) {
            viewTargetRequestDelegate.dispose();
        }
    }

    @MainThread
    public final void setRequest(@Nullable ViewTargetRequestDelegate viewTargetRequestDelegate) {
        ViewTargetRequestDelegate viewTargetRequestDelegate2 = this.currentRequest;
        if (viewTargetRequestDelegate2 != null) {
            viewTargetRequestDelegate2.dispose();
        }
        this.currentRequest = viewTargetRequestDelegate;
    }
}
