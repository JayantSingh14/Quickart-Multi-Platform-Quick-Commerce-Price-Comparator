package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class AsyncTimeout extends Timeout {

    /* renamed from: h, reason: collision with root package name */
    public static final ReentrantLock f56901h;

    /* renamed from: i, reason: collision with root package name */
    public static final Condition f56902i;

    /* renamed from: j, reason: collision with root package name */
    public static final long f56903j;

    /* renamed from: k, reason: collision with root package name */
    public static final long f56904k;

    /* renamed from: l, reason: collision with root package name */
    public static AsyncTimeout f56905l;

    /* renamed from: e, reason: collision with root package name */
    public int f56906e;

    /* renamed from: f, reason: collision with root package name */
    public AsyncTimeout f56907f;

    /* renamed from: g, reason: collision with root package name */
    public long f56908g;

    @Metadata
    public static final class Companion {
        public static final void a(AsyncTimeout asyncTimeout, long j2, boolean z) {
            AsyncTimeout asyncTimeout2;
            ReentrantLock reentrantLock = AsyncTimeout.f56901h;
            if (AsyncTimeout.f56905l == null) {
                AsyncTimeout.f56905l = new AsyncTimeout();
                new Watchdog().start();
            }
            long jNanoTime = System.nanoTime();
            if (j2 != 0 && z) {
                asyncTimeout.f56908g = Math.min(j2, asyncTimeout.c() - jNanoTime) + jNanoTime;
            } else if (j2 != 0) {
                asyncTimeout.f56908g = j2 + jNanoTime;
            } else {
                if (!z) {
                    throw new AssertionError();
                }
                asyncTimeout.f56908g = asyncTimeout.c();
            }
            long j3 = asyncTimeout.f56908g - jNanoTime;
            AsyncTimeout asyncTimeout3 = AsyncTimeout.f56905l;
            Intrinsics.c(asyncTimeout3);
            while (true) {
                asyncTimeout2 = asyncTimeout3.f56907f;
                if (asyncTimeout2 == null || j3 < asyncTimeout2.f56908g - jNanoTime) {
                    break;
                }
                Intrinsics.c(asyncTimeout2);
                asyncTimeout3 = asyncTimeout2;
            }
            asyncTimeout.f56907f = asyncTimeout2;
            asyncTimeout3.f56907f = asyncTimeout;
            if (asyncTimeout3 == AsyncTimeout.f56905l) {
                AsyncTimeout.f56902i.signal();
            }
        }

        public static AsyncTimeout b() throws InterruptedException {
            AsyncTimeout asyncTimeout = AsyncTimeout.f56905l;
            Intrinsics.c(asyncTimeout);
            AsyncTimeout asyncTimeout2 = asyncTimeout.f56907f;
            if (asyncTimeout2 == null) {
                long jNanoTime = System.nanoTime();
                AsyncTimeout.f56902i.await(AsyncTimeout.f56903j, TimeUnit.MILLISECONDS);
                AsyncTimeout asyncTimeout3 = AsyncTimeout.f56905l;
                Intrinsics.c(asyncTimeout3);
                if (asyncTimeout3.f56907f != null || System.nanoTime() - jNanoTime < AsyncTimeout.f56904k) {
                    return null;
                }
                return AsyncTimeout.f56905l;
            }
            long jNanoTime2 = asyncTimeout2.f56908g - System.nanoTime();
            if (jNanoTime2 > 0) {
                AsyncTimeout.f56902i.await(jNanoTime2, TimeUnit.NANOSECONDS);
                return null;
            }
            AsyncTimeout asyncTimeout4 = AsyncTimeout.f56905l;
            Intrinsics.c(asyncTimeout4);
            asyncTimeout4.f56907f = asyncTimeout2.f56907f;
            asyncTimeout2.f56907f = null;
            asyncTimeout2.f56906e = 2;
            return asyncTimeout2;
        }
    }

    @Metadata
    public static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            ReentrantLock reentrantLock;
            AsyncTimeout asyncTimeoutB;
            while (true) {
                try {
                    ReentrantLock reentrantLock2 = AsyncTimeout.f56901h;
                    reentrantLock = AsyncTimeout.f56901h;
                    reentrantLock.lock();
                    try {
                        asyncTimeoutB = Companion.b();
                    } finally {
                        reentrantLock.unlock();
                    }
                } catch (InterruptedException unused) {
                    continue;
                }
                if (asyncTimeoutB == AsyncTimeout.f56905l) {
                    AsyncTimeout.f56905l = null;
                    return;
                }
                Unit unit = Unit.f53572a;
                reentrantLock.unlock();
                if (asyncTimeoutB != null) {
                    asyncTimeoutB.l();
                }
            }
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        f56901h = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        Intrinsics.checkNotNullExpressionValue(conditionNewCondition, "newCondition(...)");
        f56902i = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f56903j = millis;
        f56904k = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void i() {
        long j2 = this.f57004c;
        boolean z = this.f57002a;
        if (j2 != 0 || z) {
            ReentrantLock reentrantLock = f56901h;
            reentrantLock.lock();
            try {
                if (this.f56906e != 0) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                this.f56906e = 1;
                Companion.a(this, j2, z);
                Unit unit = Unit.f53572a;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final boolean j() {
        ReentrantLock reentrantLock = f56901h;
        reentrantLock.lock();
        try {
            int i2 = this.f56906e;
            this.f56906e = 0;
            if (i2 != 1) {
                return i2 == 2;
            }
            AsyncTimeout asyncTimeout = f56905l;
            while (asyncTimeout != null) {
                AsyncTimeout asyncTimeout2 = asyncTimeout.f56907f;
                if (asyncTimeout2 == this) {
                    asyncTimeout.f56907f = this.f56907f;
                    this.f56907f = null;
                    return false;
                }
                asyncTimeout = asyncTimeout2;
            }
            throw new IllegalStateException("node was not found in the queue");
        } finally {
            reentrantLock.unlock();
        }
    }

    public IOException k(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public void l() {
    }
}
