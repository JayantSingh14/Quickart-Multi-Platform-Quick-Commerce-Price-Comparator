package io.sentry.transport;

import io.sentry.DataCategory;
import io.sentry.SentryOptions;
import java.io.Closeable;
import java.util.Date;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class RateLimiter implements Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final CurrentDateProvider f53107a;

    /* renamed from: b, reason: collision with root package name */
    public final SentryOptions f53108b;

    /* renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f53109c;

    /* renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList f53110d;

    /* renamed from: e, reason: collision with root package name */
    public Timer f53111e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f53112f;

    public interface IRateLimitObserver {
        void e(RateLimiter rateLimiter);
    }

    public RateLimiter(SentryOptions sentryOptions) {
        CurrentDateProvider currentDateProvider = CurrentDateProvider.f53091a;
        this.f53109c = new ConcurrentHashMap();
        this.f53110d = new CopyOnWriteArrayList();
        this.f53111e = null;
        this.f53112f = new Object();
        this.f53107a = currentDateProvider;
        this.f53108b = sentryOptions;
    }

    public final void a(DataCategory dataCategory, Date date) {
        Date date2 = (Date) this.f53109c.get(dataCategory);
        if (date2 == null || date.after(date2)) {
            this.f53109c.put(dataCategory, date);
            Iterator it = this.f53110d.iterator();
            while (it.hasNext()) {
                ((IRateLimitObserver) it.next()).e(this);
            }
            synchronized (this.f53112f) {
                try {
                    if (this.f53111e == null) {
                        this.f53111e = new Timer(true);
                    }
                    this.f53111e.schedule(new TimerTask() { // from class: io.sentry.transport.RateLimiter.1
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public final void run() {
                            RateLimiter rateLimiter = RateLimiter.this;
                            Iterator it2 = rateLimiter.f53110d.iterator();
                            while (it2.hasNext()) {
                                ((IRateLimitObserver) it2.next()).e(rateLimiter);
                            }
                        }
                    }, date);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final boolean b(DataCategory dataCategory) {
        Date date;
        this.f53107a.getClass();
        Date date2 = new Date(System.currentTimeMillis());
        ConcurrentHashMap concurrentHashMap = this.f53109c;
        Date date3 = (Date) concurrentHashMap.get(DataCategory.All);
        if (date3 != null && !date2.after(date3)) {
            return true;
        }
        if (DataCategory.Unknown.equals(dataCategory) || (date = (Date) concurrentHashMap.get(dataCategory)) == null) {
            return false;
        }
        return !date2.after(date);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f53112f) {
            try {
                Timer timer = this.f53111e;
                if (timer != null) {
                    timer.cancel();
                    this.f53111e = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f53110d.clear();
    }
}
