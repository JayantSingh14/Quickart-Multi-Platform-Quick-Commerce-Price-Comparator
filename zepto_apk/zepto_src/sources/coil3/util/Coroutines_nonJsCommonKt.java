package coil3.util;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class Coroutines_nonJsCommonKt {
    @NotNull
    public static final CoroutineDispatcher ioCoroutineDispatcher() {
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        return DefaultIoScheduler.f55150b;
    }
}
