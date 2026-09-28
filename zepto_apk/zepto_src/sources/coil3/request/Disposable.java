package coil3.request;

import kotlin.Metadata;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public interface Disposable {
    void dispose();

    @NotNull
    Deferred<ImageResult> getJob();

    boolean isDisposed();
}
