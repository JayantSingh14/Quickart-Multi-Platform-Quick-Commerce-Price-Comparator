package coil3.util;

import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import coil3.size.Size;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public interface HardwareBitmapService {
    @MainThread
    boolean allowHardwareMainThread(@NotNull Size size);

    @WorkerThread
    boolean allowHardwareWorkerThread();
}
