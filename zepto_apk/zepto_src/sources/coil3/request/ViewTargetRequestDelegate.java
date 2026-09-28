package coil3.request;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import coil3.ImageLoader;
import coil3.target.ViewTarget;
import coil3.util.LifecyclesKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class ViewTargetRequestDelegate implements RequestDelegate, DefaultLifecycleObserver {

    @NotNull
    private final ImageLoader imageLoader;

    @NotNull
    private final ImageRequest initialRequest;

    @NotNull
    private final Job job;

    @Nullable
    private final Lifecycle lifecycle;

    @NotNull
    private final ViewTarget<?> target;

    public ViewTargetRequestDelegate(@NotNull ImageLoader imageLoader, @NotNull ImageRequest imageRequest, @NotNull ViewTarget<?> viewTarget, @Nullable Lifecycle lifecycle, @NotNull Job job) {
        this.imageLoader = imageLoader;
        this.initialRequest = imageRequest;
        this.target = viewTarget;
        this.lifecycle = lifecycle;
        this.job = job;
    }

    @Override // coil3.request.RequestDelegate
    public void assertActive() {
        if (this.target.getView().isAttachedToWindow()) {
            return;
        }
        ViewTargetRequestManagerKt.getRequestManager(this.target.getView()).setRequest(this);
        throw new CancellationException("'ViewTarget.view' must be attached to a window.");
    }

    @Override // coil3.request.RequestDelegate
    @Nullable
    public Object awaitStarted(@NotNull Continuation<? super Unit> continuation) {
        Lifecycle lifecycle = this.lifecycle;
        if (lifecycle == null) {
            return Unit.f53572a;
        }
        Object objAwaitStarted = LifecyclesKt.awaitStarted(lifecycle, continuation);
        return objAwaitStarted == CoroutineSingletons.f53689a ? objAwaitStarted : Unit.f53572a;
    }

    @Override // coil3.request.RequestDelegate
    public void dispose() {
        Lifecycle lifecycle;
        this.job.e(null);
        ViewTarget<?> viewTarget = this.target;
        if ((viewTarget instanceof LifecycleObserver) && (lifecycle = this.lifecycle) != null) {
            lifecycle.c((LifecycleObserver) viewTarget);
        }
        Lifecycle lifecycle2 = this.lifecycle;
        if (lifecycle2 != null) {
            lifecycle2.c(this);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(@NotNull LifecycleOwner lifecycleOwner) {
        ViewTargetRequestManagerKt.getRequestManager(this.target.getView()).dispose();
    }

    public final void restart() {
        this.imageLoader.enqueue(this.initialRequest);
    }

    @Override // coil3.request.RequestDelegate
    public void start() {
        Lifecycle lifecycle;
        Lifecycle lifecycle2 = this.lifecycle;
        if (lifecycle2 != null) {
            lifecycle2.a(this);
        }
        ViewTarget<?> viewTarget = this.target;
        if ((viewTarget instanceof LifecycleObserver) && (lifecycle = this.lifecycle) != null) {
            LifecyclesKt.removeAndAddObserver(lifecycle, (LifecycleObserver) viewTarget);
        }
        ViewTargetRequestManagerKt.getRequestManager(this.target.getView()).setRequest(this);
    }
}
