package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.internal.MainDispatchersKt;
import kotlinx.coroutines.internal.SystemPropsKt;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata
/* loaded from: classes.dex */
public final class DefaultExecutorKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Delay f54086a;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Delay delay;
        String strC = SystemPropsKt.c("kotlinx.coroutines.main.delay");
        if (strC != null ? Boolean.parseBoolean(strC) : false) {
            DefaultScheduler defaultScheduler = Dispatchers.f54091a;
            MainCoroutineDispatcher mainCoroutineDispatcher = MainDispatcherLoader.f55099a;
            delay = (MainDispatchersKt.a(mainCoroutineDispatcher) || !(mainCoroutineDispatcher instanceof Delay)) ? DefaultExecutor.f54084i : (Delay) mainCoroutineDispatcher;
        } else {
            delay = DefaultExecutor.f54084i;
        }
        f54086a = delay;
    }
}
