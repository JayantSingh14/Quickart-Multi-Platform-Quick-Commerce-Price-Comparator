package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@J2ktIncompatible
@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes4.dex */
public class CycleDetectingLockFactory {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f43434a;

    /* renamed from: com.google.common.util.concurrent.CycleDetectingLockFactory$1, reason: invalid class name */
    public class AnonymousClass1 extends ThreadLocal<ArrayList<LockGraphNode>> {
        @Override // java.lang.ThreadLocal
        public final ArrayList<LockGraphNode> initialValue() {
            return Lists.c();
        }
    }

    public interface CycleDetectingLock {
    }

    public final class CycleDetectingReentrantReadWriteLock extends ReentrantReadWriteLock implements CycleDetectingLock {
        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public final /* bridge */ /* synthetic */ Lock readLock() {
            return null;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public final /* bridge */ /* synthetic */ Lock writeLock() {
            return null;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public final ReentrantReadWriteLock.ReadLock readLock() {
            return null;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public final ReentrantReadWriteLock.WriteLock writeLock() {
            return null;
        }
    }

    public static class ExampleStackTrace extends IllegalStateException {
        static {
            ImmutableSet.n(3, "com.google.common.util.concurrent.CycleDetectingLockFactory", "com.google.common.util.concurrent.CycleDetectingLockFactory$ExampleStackTrace", "com.google.common.util.concurrent.CycleDetectingLockFactory$LockGraphNode");
        }
    }

    public static class LockGraphNode {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class Policies implements Policy {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Policies[] f43435a = {new Policies() { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.1
        }, new Policies() { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.2
        }, new Policies() { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.3
        }};

        /* JADX INFO: Fake field, exist only in values array */
        Policies EF2;

        public static Policies valueOf(String str) {
            return (Policies) Enum.valueOf(Policies.class, str);
        }

        public static Policies[] values() {
            return (Policies[]) f43435a.clone();
        }
    }

    public interface Policy {
    }

    public static final class PotentialDeadlockException extends ExampleStackTrace {
        @Override // java.lang.Throwable
        public final String getMessage() {
            String message = super.getMessage();
            Objects.requireNonNull(message);
            StringBuilder sb = new StringBuilder(message);
            for (Throwable cause = null; cause != null; cause = cause.getCause()) {
                sb.append(", ");
                sb.append(cause.getMessage());
            }
            return sb.toString();
        }
    }

    public static final class WithExplicitOrdering<E extends Enum<E>> extends CycleDetectingLockFactory {
    }

    static {
        MapMaker mapMaker = new MapMaker();
        mapMaker.b();
        mapMaker.a();
        new LazyLogger(CycleDetectingLockFactory.class);
        f43434a = new AnonymousClass1();
    }

    public static void a(CycleDetectingReentrantLock cycleDetectingReentrantLock) {
        if (cycleDetectingReentrantLock.isHeldByCurrentThread()) {
            return;
        }
        ArrayList arrayList = (ArrayList) f43434a.get();
        Objects.requireNonNull(arrayList);
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
                return;
            }
        }
    }

    public final class CycleDetectingReentrantLock extends ReentrantLock implements CycleDetectingLock {
        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public final void lock() {
            ThreadLocal threadLocal = CycleDetectingLockFactory.f43434a;
            throw null;
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public final void lockInterruptibly() {
            ThreadLocal threadLocal = CycleDetectingLockFactory.f43434a;
            throw null;
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public final boolean tryLock() {
            ThreadLocal threadLocal = CycleDetectingLockFactory.f43434a;
            throw null;
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public final void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.a(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public final boolean tryLock(long j2, TimeUnit timeUnit) {
            ThreadLocal threadLocal = CycleDetectingLockFactory.f43434a;
            throw null;
        }
    }

    public class CycleDetectingReentrantReadLock extends ReentrantReadWriteLock.ReadLock {
        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public final void lock() {
            ThreadLocal threadLocal = CycleDetectingLockFactory.f43434a;
            throw null;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public final void lockInterruptibly() {
            ThreadLocal threadLocal = CycleDetectingLockFactory.f43434a;
            throw null;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public final boolean tryLock() {
            ThreadLocal threadLocal = CycleDetectingLockFactory.f43434a;
            throw null;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public final void unlock() {
            super.unlock();
            CycleDetectingLockFactory.a(null);
            throw null;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public final boolean tryLock(long j2, TimeUnit timeUnit) {
            ThreadLocal threadLocal = CycleDetectingLockFactory.f43434a;
            throw null;
        }
    }

    public class CycleDetectingReentrantWriteLock extends ReentrantReadWriteLock.WriteLock {
        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public final void lock() {
            ThreadLocal threadLocal = CycleDetectingLockFactory.f43434a;
            throw null;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public final void lockInterruptibly() {
            ThreadLocal threadLocal = CycleDetectingLockFactory.f43434a;
            throw null;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public final boolean tryLock() {
            ThreadLocal threadLocal = CycleDetectingLockFactory.f43434a;
            throw null;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public final void unlock() {
            super.unlock();
            CycleDetectingLockFactory.a(null);
            throw null;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public final boolean tryLock(long j2, TimeUnit timeUnit) {
            ThreadLocal threadLocal = CycleDetectingLockFactory.f43434a;
            throw null;
        }
    }
}
