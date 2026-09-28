package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata
/* loaded from: classes3.dex */
public final class LifecycleOwnerKt {
    public static final LifecycleCoroutineScopeImpl a(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullParameter(lifecycle, "<this>");
        while (true) {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl = (LifecycleCoroutineScopeImpl) lifecycle.f4803a.get();
            if (lifecycleCoroutineScopeImpl != null) {
                return lifecycleCoroutineScopeImpl;
            }
            Job jobB = SupervisorKt.b();
            DefaultScheduler defaultScheduler = Dispatchers.f54091a;
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = new LifecycleCoroutineScopeImpl(lifecycle, CoroutineContext.Element.DefaultImpls.c((JobSupport) jobB, MainDispatcherLoader.f55099a.O1()));
            AtomicReference atomicReference = lifecycle.f4803a;
            while (!atomicReference.compareAndSet(null, lifecycleCoroutineScopeImpl2)) {
                if (atomicReference.get() != null) {
                    break;
                }
            }
            DefaultScheduler defaultScheduler2 = Dispatchers.f54091a;
            BuildersKt.c(lifecycleCoroutineScopeImpl2, MainDispatcherLoader.f55099a.O1(), new LifecycleCoroutineScopeImpl$register$1(lifecycleCoroutineScopeImpl2, null), 2);
            return lifecycleCoroutineScopeImpl2;
        }
    }
}
