package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.util.concurrent.FluentFuture;
import java.lang.Throwable;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
abstract class AbstractCatchingFuture<V, X extends Throwable, F, T> extends FluentFuture.TrustedFuture<V> implements Runnable {

    public static final class AsyncCatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, AsyncFunction<? super X, ? extends V>, ListenableFuture<? extends V>> {
    }

    public static final class CatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, Function<? super X, ? extends V>, V> {
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void c() {
        k(null);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final String l() {
        String strL = super.l();
        if (strL != null) {
            return android.support.v4.media.b.k("", strL);
        }
        return null;
    }

    @Override // java.lang.Runnable
    public final void run() {
    }
}
