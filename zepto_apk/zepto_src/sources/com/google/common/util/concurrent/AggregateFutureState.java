package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.j2objc.annotations.ReflectionSupport;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;

@ElementTypesAreNonnullByDefault
@GwtCompatible
@ReflectionSupport
/* loaded from: classes4.dex */
abstract class AggregateFutureState<OutputT> extends AbstractFuture.TrustedFuture<OutputT> {

    /* renamed from: j, reason: collision with root package name */
    public static final LazyLogger f43426j = new LazyLogger(AggregateFutureState.class);

    /* renamed from: h, reason: collision with root package name */
    public volatile Set f43427h;

    /* renamed from: i, reason: collision with root package name */
    public volatile int f43428i;

    public static abstract class AtomicHelper {
    }

    public static final class SafeAtomicHelper extends AtomicHelper {
    }

    public static final class SynchronizedAtomicHelper extends AtomicHelper {
    }

    static {
        try {
            AtomicReferenceFieldUpdater.newUpdater(AggregateFutureState.class, Set.class, "h");
            AtomicIntegerFieldUpdater.newUpdater(AggregateFutureState.class, "i");
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        if (th != null) {
            f43426j.a().log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }
}
