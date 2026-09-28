package org.apache.commons.lang3.concurrent;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.Validate;

/* loaded from: classes5.dex */
public class TimedSemaphore {
    public static final int NO_LIMIT = 0;
    private static final int THREAD_POOL_SIZE = 1;
    private int acquireCount;
    private final ScheduledExecutorService executorService;
    private int lastCallsPerPeriod;
    private int limit;
    private final boolean ownExecutor;
    private final long period;
    private long periodCount;
    private boolean shutdown;
    private ScheduledFuture<?> task;
    private long totalAcquireCount;
    private final TimeUnit unit;

    public TimedSemaphore(long j2, TimeUnit timeUnit, int i2) {
        this(null, j2, timeUnit, i2);
    }

    private boolean acquirePermit() {
        if (getLimit() > 0 && this.acquireCount >= getLimit()) {
            return false;
        }
        this.acquireCount++;
        return true;
    }

    private void prepareAcquire() {
        if (isShutdown()) {
            throw new IllegalStateException("TimedSemaphore is shut down!");
        }
        if (this.task == null) {
            this.task = startTimer();
        }
    }

    public synchronized void acquire() throws InterruptedException {
        boolean zAcquirePermit;
        prepareAcquire();
        do {
            zAcquirePermit = acquirePermit();
            if (!zAcquirePermit) {
                wait();
            }
        } while (!zAcquirePermit);
    }

    public synchronized void endOfPeriod() {
        int i2 = this.acquireCount;
        this.lastCallsPerPeriod = i2;
        this.totalAcquireCount += i2;
        this.periodCount++;
        this.acquireCount = 0;
        notifyAll();
    }

    public synchronized int getAcquireCount() {
        return this.acquireCount;
    }

    public synchronized int getAvailablePermits() {
        return getLimit() - getAcquireCount();
    }

    public synchronized double getAverageCallsPerPeriod() {
        long j2;
        j2 = this.periodCount;
        return j2 == 0 ? 0.0d : this.totalAcquireCount / j2;
    }

    public ScheduledExecutorService getExecutorService() {
        return this.executorService;
    }

    public synchronized int getLastAcquiresPerPeriod() {
        return this.lastCallsPerPeriod;
    }

    public final synchronized int getLimit() {
        return this.limit;
    }

    public long getPeriod() {
        return this.period;
    }

    public TimeUnit getUnit() {
        return this.unit;
    }

    public synchronized boolean isShutdown() {
        return this.shutdown;
    }

    public final synchronized void setLimit(int i2) {
        this.limit = i2;
    }

    public synchronized void shutdown() {
        try {
            if (!this.shutdown) {
                if (this.ownExecutor) {
                    getExecutorService().shutdownNow();
                }
                ScheduledFuture<?> scheduledFuture = this.task;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.shutdown = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public ScheduledFuture<?> startTimer() {
        return getExecutorService().scheduleAtFixedRate(new Runnable() { // from class: org.apache.commons.lang3.concurrent.TimedSemaphore.1
            @Override // java.lang.Runnable
            public void run() {
                TimedSemaphore.this.endOfPeriod();
            }
        }, getPeriod(), getPeriod(), getUnit());
    }

    public synchronized boolean tryAcquire() {
        prepareAcquire();
        return acquirePermit();
    }

    public TimedSemaphore(ScheduledExecutorService scheduledExecutorService, long j2, TimeUnit timeUnit, int i2) {
        Validate.inclusiveBetween(1L, Long.MAX_VALUE, j2, "Time period must be greater than 0!");
        this.period = j2;
        this.unit = timeUnit;
        if (scheduledExecutorService != null) {
            this.executorService = scheduledExecutorService;
            this.ownExecutor = false;
        } else {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
            scheduledThreadPoolExecutor.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
            scheduledThreadPoolExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
            this.executorService = scheduledThreadPoolExecutor;
            this.ownExecutor = true;
        }
        setLimit(i2);
    }
}
