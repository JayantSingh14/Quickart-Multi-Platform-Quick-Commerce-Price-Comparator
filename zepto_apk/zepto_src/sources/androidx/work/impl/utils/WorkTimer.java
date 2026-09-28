package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.DefaultRunnableScheduler;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.HashMap;

@RestrictTo
/* loaded from: classes3.dex */
public class WorkTimer {

    /* renamed from: e, reason: collision with root package name */
    public static final String f13023e = Logger.g("WorkTimer");

    /* renamed from: a, reason: collision with root package name */
    public final DefaultRunnableScheduler f13024a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f13025b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f13026c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final Object f13027d = new Object();

    @RestrictTo
    public interface TimeLimitExceededListener {
        void a(WorkGenerationalId workGenerationalId);
    }

    @RestrictTo
    public static class WorkTimerRunnable implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final WorkTimer f13028a;

        /* renamed from: b, reason: collision with root package name */
        public final WorkGenerationalId f13029b;

        public WorkTimerRunnable(WorkTimer workTimer, WorkGenerationalId workGenerationalId) {
            this.f13028a = workTimer;
            this.f13029b = workGenerationalId;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (this.f13028a.f13027d) {
                try {
                    if (((WorkTimerRunnable) this.f13028a.f13025b.remove(this.f13029b)) != null) {
                        TimeLimitExceededListener timeLimitExceededListener = (TimeLimitExceededListener) this.f13028a.f13026c.remove(this.f13029b);
                        if (timeLimitExceededListener != null) {
                            timeLimitExceededListener.a(this.f13029b);
                        }
                    } else {
                        Logger.e().a("WrkTimerRunnable", "Timer with " + this.f13029b + " is already marked as complete.");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public WorkTimer(DefaultRunnableScheduler defaultRunnableScheduler) {
        this.f13024a = defaultRunnableScheduler;
    }

    public final void a(WorkGenerationalId workGenerationalId) {
        synchronized (this.f13027d) {
            try {
                if (((WorkTimerRunnable) this.f13025b.remove(workGenerationalId)) != null) {
                    Logger.e().a(f13023e, "Stopping timer for " + workGenerationalId);
                    this.f13026c.remove(workGenerationalId);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
