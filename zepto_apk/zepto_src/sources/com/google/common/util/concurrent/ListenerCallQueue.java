package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
/* loaded from: classes4.dex */
final class ListenerCallQueue<L> {

    public interface Event<L> {
    }

    public static final class PerListenerQueue<L> implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public boolean f43463a;

        @Override // java.lang.Runnable
        public final void run() {
            try {
                synchronized (this) {
                    Preconditions.n(this.f43463a);
                    throw null;
                }
            } catch (Throwable th) {
                synchronized (this) {
                    this.f43463a = false;
                    throw th;
                }
            }
        }
    }

    static {
        new LazyLogger(ListenerCallQueue.class);
    }
}
