package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
/* loaded from: classes4.dex */
public abstract class Striped<L> {

    public static class CompactStriped<L> extends PowerOfTwoStriped<L> {
    }

    @VisibleForTesting
    public static class LargeLazyStriped<L> extends PowerOfTwoStriped<L> {
    }

    public static class PaddedLock extends ReentrantLock {
    }

    public static class PaddedSemaphore extends Semaphore {
    }

    public static abstract class PowerOfTwoStriped<L> extends Striped<L> {
    }

    @VisibleForTesting
    public static class SmallLazyStriped<L> extends PowerOfTwoStriped<L> {

        public static final class ArrayReference<L> extends WeakReference<L> {
        }
    }

    public static final class WeakSafeCondition extends ForwardingCondition {
        @Override // com.google.common.util.concurrent.ForwardingCondition
        public final Condition a() {
            return null;
        }
    }

    public static final class WeakSafeLock extends ForwardingLock {
        @Override // com.google.common.util.concurrent.ForwardingLock
        public final Lock a() {
            throw null;
        }

        @Override // com.google.common.util.concurrent.ForwardingLock, java.util.concurrent.locks.Lock
        public final Condition newCondition() {
            throw null;
        }
    }

    public static final class WeakSafeReadWriteLock implements ReadWriteLock {
        @Override // java.util.concurrent.locks.ReadWriteLock
        public final Lock readLock() {
            throw null;
        }

        @Override // java.util.concurrent.locks.ReadWriteLock
        public final Lock writeLock() {
            throw null;
        }
    }
}
