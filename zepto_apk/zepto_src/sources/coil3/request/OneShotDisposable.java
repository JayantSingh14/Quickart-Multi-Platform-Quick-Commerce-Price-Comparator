package coil3.request;

import kotlin.Metadata;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class OneShotDisposable implements Disposable {

    @NotNull
    private final Deferred<ImageResult> job;

    /* JADX WARN: Multi-variable type inference failed */
    public OneShotDisposable(@NotNull Deferred<? extends ImageResult> deferred) {
        this.job = deferred;
    }

    @Override // coil3.request.Disposable
    public void dispose() {
        if (isDisposed()) {
            return;
        }
        getJob().e(null);
    }

    @Override // coil3.request.Disposable
    @NotNull
    public Deferred<ImageResult> getJob() {
        return this.job;
    }

    @Override // coil3.request.Disposable
    public boolean isDisposed() {
        return !getJob().a();
    }
}
