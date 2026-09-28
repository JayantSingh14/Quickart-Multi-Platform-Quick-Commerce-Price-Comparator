package org.xbill.DNS;

import java.util.concurrent.ThreadFactory;
import org.xbill.DNS.TimeoutCompletableFuture;

/* loaded from: classes5.dex */
public final /* synthetic */ class b0 implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return TimeoutCompletableFuture.TimeoutScheduler.lambda$static$0(runnable);
    }
}
