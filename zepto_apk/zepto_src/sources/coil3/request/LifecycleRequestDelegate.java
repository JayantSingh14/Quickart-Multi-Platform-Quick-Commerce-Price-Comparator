package coil3.request;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import coil3.util.LifecyclesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class LifecycleRequestDelegate implements RequestDelegate, DefaultLifecycleObserver {

    @NotNull
    private final Job job;

    @NotNull
    private final Lifecycle lifecycle;

    public LifecycleRequestDelegate(@NotNull Lifecycle lifecycle, @NotNull Job job) {
        this.lifecycle = lifecycle;
        this.job = job;
    }

    @Override // coil3.request.RequestDelegate
    @Nullable
    public Object awaitStarted(@NotNull Continuation<? super Unit> continuation) {
        Object objAwaitStarted = LifecyclesKt.awaitStarted(this.lifecycle, continuation);
        return objAwaitStarted == CoroutineSingletons.f53689a ? objAwaitStarted : Unit.f53572a;
    }

    @Override // coil3.request.RequestDelegate
    public void complete() {
        this.lifecycle.c(this);
    }

    @Override // coil3.request.RequestDelegate
    public void dispose() {
        this.job.e(null);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(@NotNull LifecycleOwner lifecycleOwner) {
        dispose();
    }

    @Override // coil3.request.RequestDelegate
    public void start() {
        this.lifecycle.a(this);
    }
}
