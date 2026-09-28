package com.google.common.util.concurrent;

import com.google.errorprone.annotations.DoNotMock;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

@DoNotMock
@ElementTypesAreNonnullByDefault
/* loaded from: classes.dex */
public interface ListenableFuture<V> extends Future<V> {
    void q(Runnable runnable, Executor executor);
}
