package kotlinx.coroutines.test;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
final class AtomicBoolean {
    private volatile /* synthetic */ int container$volatile;

    static {
        AtomicIntegerFieldUpdater.newUpdater(AtomicBoolean.class, "container$volatile");
    }
}
