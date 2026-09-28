package coil3.request;

import android.view.View;
import kotlin.Metadata;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class ViewTargetDisposable implements Disposable {

    @NotNull
    private volatile Deferred<? extends ImageResult> job;

    @NotNull
    private final View view;

    public ViewTargetDisposable(@NotNull View view, @NotNull Deferred<? extends ImageResult> deferred) {
        this.view = view;
        this.job = deferred;
    }

    @Override // coil3.request.Disposable
    public void dispose() {
        if (isDisposed()) {
            return;
        }
        ViewTargetRequestManagerKt.getRequestManager(this.view).dispose();
    }

    @Override // coil3.request.Disposable
    @NotNull
    public Deferred<ImageResult> getJob() {
        return this.job;
    }

    @Override // coil3.request.Disposable
    public boolean isDisposed() {
        return ViewTargetRequestManagerKt.getRequestManager(this.view).isDisposed(this);
    }

    public void setJob(@NotNull Deferred<? extends ImageResult> deferred) {
        this.job = deferred;
    }
}
