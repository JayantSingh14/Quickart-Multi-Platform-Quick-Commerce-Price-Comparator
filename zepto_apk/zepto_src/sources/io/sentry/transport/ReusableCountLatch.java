package io.sentry.transport;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/* loaded from: classes.dex */
public final class ReusableCountLatch {

    /* renamed from: a, reason: collision with root package name */
    public final Sync f53114a = new Sync();

    public static final class Sync extends AbstractQueuedSynchronizer {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f53115a = 0;

        public Sync() {
            setState(0);
        }

        public static int a(Sync sync) {
            return sync.getState();
        }

        public static void b(Sync sync) {
            int state;
            do {
                state = sync.getState();
            } while (!sync.compareAndSetState(state, state + 1));
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        public final int tryAcquireShared(int i2) {
            return getState() == 0 ? 1 : -1;
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        public final boolean tryReleaseShared(int i2) {
            int state;
            int i3;
            do {
                state = getState();
                if (state == 0) {
                    return false;
                }
                i3 = state - 1;
            } while (!compareAndSetState(state, i3));
            return i3 == 0;
        }
    }
}
