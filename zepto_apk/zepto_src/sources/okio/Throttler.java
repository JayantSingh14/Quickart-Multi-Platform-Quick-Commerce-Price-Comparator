package okio;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class Throttler {
    public Throttler() {
        System.nanoTime();
        Intrinsics.checkNotNullExpressionValue(new ReentrantLock().newCondition(), "newCondition(...)");
    }
}
