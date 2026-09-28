package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LimitedDispatcherKt;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata
/* loaded from: classes.dex */
public abstract class MainCoroutineDispatcher extends CoroutineDispatcher {
    public abstract MainCoroutineDispatcher O1();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher s1(int i2) {
        LimitedDispatcherKt.a(i2);
        return this;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        MainCoroutineDispatcher mainCoroutineDispatcherO1;
        String str;
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        MainCoroutineDispatcher mainCoroutineDispatcher = MainDispatcherLoader.f55099a;
        if (this == mainCoroutineDispatcher) {
            str = "Dispatchers.Main";
        } else {
            try {
                mainCoroutineDispatcherO1 = mainCoroutineDispatcher.O1();
            } catch (UnsupportedOperationException unused) {
                mainCoroutineDispatcherO1 = null;
            }
            str = this == mainCoroutineDispatcherO1 ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        return getClass().getSimpleName() + '@' + DebugStringsKt.a(this);
    }
}
