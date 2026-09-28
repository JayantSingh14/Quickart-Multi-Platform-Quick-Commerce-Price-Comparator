package androidx.work.impl.background.greedy;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.DefaultRunnableScheduler;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.Scheduler;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.ProcessUtils;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

@RestrictTo
/* loaded from: classes.dex */
public class GreedyScheduler implements Scheduler, OnConstraintsStateChangedListener, ExecutionListener {
    public static final String o = Logger.g("GreedyScheduler");

    /* renamed from: a, reason: collision with root package name */
    public final Context f12705a;

    /* renamed from: c, reason: collision with root package name */
    public final DelayedWorkTracker f12707c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12708d;

    /* renamed from: g, reason: collision with root package name */
    public final Processor f12711g;

    /* renamed from: h, reason: collision with root package name */
    public final WorkLauncherImpl f12712h;

    /* renamed from: i, reason: collision with root package name */
    public final Configuration f12713i;

    /* renamed from: k, reason: collision with root package name */
    public Boolean f12715k;

    /* renamed from: l, reason: collision with root package name */
    public final WorkConstraintsTracker f12716l;

    /* renamed from: m, reason: collision with root package name */
    public final TaskExecutor f12717m;
    public final TimeLimiter n;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f12706b = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final Object f12709e = new Object();

    /* renamed from: f, reason: collision with root package name */
    public final StartStopTokens f12710f = new StartStopTokens();

    /* renamed from: j, reason: collision with root package name */
    public final HashMap f12714j = new HashMap();

    public static class AttemptData {

        /* renamed from: a, reason: collision with root package name */
        public final int f12718a;

        /* renamed from: b, reason: collision with root package name */
        public final long f12719b;

        public AttemptData(int i2, long j2) {
            this.f12718a = i2;
            this.f12719b = j2;
        }
    }

    public GreedyScheduler(Context context, Configuration configuration, Trackers trackers, Processor processor, WorkLauncherImpl workLauncherImpl, TaskExecutor taskExecutor) {
        this.f12705a = context;
        DefaultRunnableScheduler defaultRunnableScheduler = configuration.f12479f;
        this.f12707c = new DelayedWorkTracker(this, defaultRunnableScheduler, configuration.f12476c);
        this.n = new TimeLimiter(defaultRunnableScheduler, workLauncherImpl);
        this.f12717m = taskExecutor;
        this.f12716l = new WorkConstraintsTracker(trackers);
        this.f12713i = configuration;
        this.f12711g = processor;
        this.f12712h = workLauncherImpl;
    }

    @Override // androidx.work.impl.Scheduler
    public final void a(String str) {
        Runnable runnable;
        if (this.f12715k == null) {
            this.f12715k = Boolean.valueOf(ProcessUtils.a(this.f12705a, this.f12713i));
        }
        boolean zBooleanValue = this.f12715k.booleanValue();
        String str2 = o;
        if (!zBooleanValue) {
            Logger.e().f(str2, "Ignoring schedule request in non-main process");
            return;
        }
        if (!this.f12708d) {
            this.f12711g.a(this);
            this.f12708d = true;
        }
        Logger.e().a(str2, "Cancelling work ID " + str);
        DelayedWorkTracker delayedWorkTracker = this.f12707c;
        if (delayedWorkTracker != null && (runnable = (Runnable) delayedWorkTracker.f12702d.remove(str)) != null) {
            delayedWorkTracker.f12700b.a(runnable);
        }
        for (StartStopToken startStopToken : this.f12710f.c(str)) {
            this.n.a(startStopToken);
            this.f12712h.d(startStopToken);
        }
    }

    @Override // androidx.work.impl.Scheduler
    public final void b(WorkSpec... workSpecArr) {
        long jMax;
        if (this.f12715k == null) {
            this.f12715k = Boolean.valueOf(ProcessUtils.a(this.f12705a, this.f12713i));
        }
        if (!this.f12715k.booleanValue()) {
            Logger.e().f(o, "Ignoring schedule request in a secondary process");
            return;
        }
        if (!this.f12708d) {
            this.f12711g.a(this);
            this.f12708d = true;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (final WorkSpec spec : workSpecArr) {
            if (!this.f12710f.a(WorkSpecKt.a(spec))) {
                synchronized (this.f12709e) {
                    try {
                        WorkGenerationalId workGenerationalIdA = WorkSpecKt.a(spec);
                        AttemptData attemptData = (AttemptData) this.f12714j.get(workGenerationalIdA);
                        if (attemptData == null) {
                            int i2 = spec.f12915k;
                            this.f12713i.f12476c.getClass();
                            attemptData = new AttemptData(i2, System.currentTimeMillis());
                            this.f12714j.put(workGenerationalIdA, attemptData);
                        }
                        jMax = (Math.max((spec.f12915k - attemptData.f12718a) - 5, 0) * 30000) + attemptData.f12719b;
                    } finally {
                    }
                }
                long jMax2 = Math.max(spec.a(), jMax);
                this.f12713i.f12476c.getClass();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (spec.f12906b == WorkInfo.State.f12566a) {
                    if (jCurrentTimeMillis < jMax2) {
                        final DelayedWorkTracker delayedWorkTracker = this.f12707c;
                        if (delayedWorkTracker != null) {
                            HashMap map = delayedWorkTracker.f12702d;
                            Runnable runnable = (Runnable) map.remove(spec.f12905a);
                            DefaultRunnableScheduler defaultRunnableScheduler = delayedWorkTracker.f12700b;
                            if (runnable != null) {
                                defaultRunnableScheduler.a(runnable);
                            }
                            Runnable runnable2 = new Runnable() { // from class: androidx.work.impl.background.greedy.DelayedWorkTracker.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    Logger loggerE = Logger.e();
                                    String str = DelayedWorkTracker.f12698e;
                                    StringBuilder sb = new StringBuilder("Scheduling work ");
                                    WorkSpec workSpec = spec;
                                    sb.append(workSpec.f12905a);
                                    loggerE.a(str, sb.toString());
                                    DelayedWorkTracker.this.f12699a.b(workSpec);
                                }
                            };
                            map.put(spec.f12905a, runnable2);
                            delayedWorkTracker.f12701c.getClass();
                            defaultRunnableScheduler.b(jMax2 - System.currentTimeMillis(), runnable2);
                        }
                    } else if (spec.b()) {
                        Constraints constraints = spec.f12914j;
                        if (constraints.f12489c) {
                            Logger.e().a(o, "Ignoring " + spec + ". Requires device idle.");
                        } else if (constraints.f12494h.isEmpty()) {
                            hashSet.add(spec);
                            hashSet2.add(spec.f12905a);
                        } else {
                            Logger.e().a(o, "Ignoring " + spec + ". Requires ContentUri triggers.");
                        }
                    } else if (!this.f12710f.a(WorkSpecKt.a(spec))) {
                        Logger.e().a(o, "Starting work for " + spec.f12905a);
                        StartStopTokens startStopTokens = this.f12710f;
                        startStopTokens.getClass();
                        Intrinsics.checkNotNullParameter(spec, "spec");
                        StartStopToken startStopTokenD = startStopTokens.d(WorkSpecKt.a(spec));
                        this.n.b(startStopTokenD);
                        this.f12712h.b(startStopTokenD);
                    }
                }
            }
        }
        synchronized (this.f12709e) {
            try {
                if (!hashSet.isEmpty()) {
                    Logger.e().a(o, "Starting tracking for " + TextUtils.join(",", hashSet2));
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        WorkSpec workSpec = (WorkSpec) it.next();
                        WorkGenerationalId workGenerationalIdA2 = WorkSpecKt.a(workSpec);
                        if (!this.f12706b.containsKey(workGenerationalIdA2)) {
                            this.f12706b.put(workGenerationalIdA2, WorkConstraintsTrackerKt.b(this.f12716l, workSpec, this.f12717m.a(), this));
                        }
                    }
                }
            } finally {
            }
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public final void c(WorkGenerationalId workGenerationalId, boolean z) {
        Job job;
        StartStopToken startStopTokenB = this.f12710f.b(workGenerationalId);
        if (startStopTokenB != null) {
            this.n.a(startStopTokenB);
        }
        synchronized (this.f12709e) {
            job = (Job) this.f12706b.remove(workGenerationalId);
        }
        if (job != null) {
            Logger.e().a(o, "Stopping tracking for " + workGenerationalId);
            job.e(null);
        }
        if (z) {
            return;
        }
        synchronized (this.f12709e) {
            this.f12714j.remove(workGenerationalId);
        }
    }

    @Override // androidx.work.impl.Scheduler
    public final boolean d() {
        return false;
    }

    @Override // androidx.work.impl.constraints.OnConstraintsStateChangedListener
    public final void e(WorkSpec workSpec, ConstraintsState constraintsState) {
        WorkGenerationalId workGenerationalIdA = WorkSpecKt.a(workSpec);
        boolean z = constraintsState instanceof ConstraintsState.ConstraintsMet;
        WorkLauncherImpl workLauncherImpl = this.f12712h;
        TimeLimiter timeLimiter = this.n;
        String str = o;
        StartStopTokens startStopTokens = this.f12710f;
        if (z) {
            if (startStopTokens.a(workGenerationalIdA)) {
                return;
            }
            Logger.e().a(str, "Constraints met: Scheduling work ID " + workGenerationalIdA);
            StartStopToken startStopTokenD = startStopTokens.d(workGenerationalIdA);
            timeLimiter.b(startStopTokenD);
            workLauncherImpl.b(startStopTokenD);
            return;
        }
        Logger.e().a(str, "Constraints not met: Cancelling work ID " + workGenerationalIdA);
        StartStopToken workSpecId = startStopTokens.b(workGenerationalIdA);
        if (workSpecId != null) {
            timeLimiter.a(workSpecId);
            int iA = ((ConstraintsState.ConstraintsNotMet) constraintsState).a();
            workLauncherImpl.getClass();
            Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
            workLauncherImpl.c(workSpecId, iA);
        }
    }
}
