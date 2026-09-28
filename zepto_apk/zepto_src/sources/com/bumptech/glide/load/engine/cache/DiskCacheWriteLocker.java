package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.util.Preconditions;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
final class DiskCacheWriteLocker {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f16087a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final WriteLockPool f16088b = new WriteLockPool();

    public static class WriteLock {

        /* renamed from: a, reason: collision with root package name */
        public final ReentrantLock f16089a = new ReentrantLock();

        /* renamed from: b, reason: collision with root package name */
        public int f16090b;
    }

    public static class WriteLockPool {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayDeque f16091a = new ArrayDeque();
    }

    public final void a(String str) {
        WriteLock writeLock;
        synchronized (this) {
            try {
                Object obj = this.f16087a.get(str);
                Preconditions.c(obj, "Argument must not be null");
                writeLock = (WriteLock) obj;
                int i2 = writeLock.f16090b;
                if (i2 < 1) {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + writeLock.f16090b);
                }
                int i3 = i2 - 1;
                writeLock.f16090b = i3;
                if (i3 == 0) {
                    WriteLock writeLock2 = (WriteLock) this.f16087a.remove(str);
                    if (!writeLock2.equals(writeLock)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + writeLock + ", but actually removed: " + writeLock2 + ", safeKey: " + str);
                    }
                    WriteLockPool writeLockPool = this.f16088b;
                    synchronized (writeLockPool.f16091a) {
                        try {
                            if (writeLockPool.f16091a.size() < 10) {
                                writeLockPool.f16091a.offer(writeLock2);
                            }
                        } finally {
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        writeLock.f16089a.unlock();
    }
}
