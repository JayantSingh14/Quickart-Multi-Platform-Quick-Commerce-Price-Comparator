package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.support.v4.media.b;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.concurrent.Executor;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.JobImpl;

@RestrictTo
/* loaded from: classes3.dex */
public class DelayMetCommandHandler implements OnConstraintsStateChangedListener, WorkTimer.TimeLimitExceededListener {
    public static final String o = Logger.g("DelayMetCommandHandler");

    /* renamed from: a, reason: collision with root package name */
    public final Context f12742a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12743b;

    /* renamed from: c, reason: collision with root package name */
    public final WorkGenerationalId f12744c;

    /* renamed from: d, reason: collision with root package name */
    public final SystemAlarmDispatcher f12745d;

    /* renamed from: e, reason: collision with root package name */
    public final WorkConstraintsTracker f12746e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f12747f;

    /* renamed from: g, reason: collision with root package name */
    public int f12748g;

    /* renamed from: h, reason: collision with root package name */
    public final SerialExecutor f12749h;

    /* renamed from: i, reason: collision with root package name */
    public final Executor f12750i;

    /* renamed from: j, reason: collision with root package name */
    public PowerManager.WakeLock f12751j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f12752k;

    /* renamed from: l, reason: collision with root package name */
    public final StartStopToken f12753l;

    /* renamed from: m, reason: collision with root package name */
    public final CoroutineDispatcher f12754m;
    public volatile JobImpl n;

    public DelayMetCommandHandler(Context context, int i2, SystemAlarmDispatcher systemAlarmDispatcher, StartStopToken startStopToken) {
        this.f12742a = context;
        this.f12743b = i2;
        this.f12745d = systemAlarmDispatcher;
        this.f12744c = startStopToken.f12629a;
        this.f12753l = startStopToken;
        Trackers trackers = systemAlarmDispatcher.f12761e.f12662j;
        WorkManagerTaskExecutor workManagerTaskExecutor = systemAlarmDispatcher.f12758b;
        this.f12749h = workManagerTaskExecutor.f13061a;
        this.f12750i = workManagerTaskExecutor.f13064d;
        this.f12754m = workManagerTaskExecutor.f13062b;
        this.f12746e = new WorkConstraintsTracker(trackers);
        this.f12752k = false;
        this.f12748g = 0;
        this.f12747f = new Object();
    }

    public static void b(DelayMetCommandHandler delayMetCommandHandler) {
        WorkGenerationalId workGenerationalId = delayMetCommandHandler.f12744c;
        int i2 = delayMetCommandHandler.f12748g;
        String str = workGenerationalId.f12893a;
        String str2 = o;
        if (i2 >= 2) {
            Logger.e().a(str2, "Already stopped work for " + str);
            return;
        }
        delayMetCommandHandler.f12748g = 2;
        Logger.e().a(str2, "Stopping work for WorkSpec " + str);
        String str3 = CommandHandler.f12726f;
        Context context = delayMetCommandHandler.f12742a;
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        CommandHandler.d(intent, workGenerationalId);
        SystemAlarmDispatcher systemAlarmDispatcher = delayMetCommandHandler.f12745d;
        int i3 = delayMetCommandHandler.f12743b;
        SystemAlarmDispatcher.AddRunnable addRunnable = new SystemAlarmDispatcher.AddRunnable(i3, intent, systemAlarmDispatcher);
        Executor executor = delayMetCommandHandler.f12750i;
        executor.execute(addRunnable);
        if (!systemAlarmDispatcher.f12760d.e(str)) {
            Logger.e().a(str2, "Processor does not have WorkSpec " + str + ". No need to reschedule");
            return;
        }
        Logger.e().a(str2, "WorkSpec " + str + " needs to be rescheduled");
        Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent2.setAction("ACTION_SCHEDULE_WORK");
        CommandHandler.d(intent2, workGenerationalId);
        executor.execute(new SystemAlarmDispatcher.AddRunnable(i3, intent2, systemAlarmDispatcher));
    }

    public static void c(DelayMetCommandHandler delayMetCommandHandler) {
        if (delayMetCommandHandler.f12748g != 0) {
            Logger.e().a(o, "Already started work for " + delayMetCommandHandler.f12744c);
            return;
        }
        delayMetCommandHandler.f12748g = 1;
        Logger.e().a(o, "onAllConstraintsMet for " + delayMetCommandHandler.f12744c);
        if (!delayMetCommandHandler.f12745d.f12760d.h(delayMetCommandHandler.f12753l, null)) {
            delayMetCommandHandler.d();
            return;
        }
        WorkTimer workTimer = delayMetCommandHandler.f12745d.f12759c;
        WorkGenerationalId workGenerationalId = delayMetCommandHandler.f12744c;
        synchronized (workTimer.f13027d) {
            Logger.e().a(WorkTimer.f13023e, "Starting timer for " + workGenerationalId);
            workTimer.a(workGenerationalId);
            WorkTimer.WorkTimerRunnable workTimerRunnable = new WorkTimer.WorkTimerRunnable(workTimer, workGenerationalId);
            workTimer.f13025b.put(workGenerationalId, workTimerRunnable);
            workTimer.f13026c.put(workGenerationalId, delayMetCommandHandler);
            workTimer.f13024a.b(600000L, workTimerRunnable);
        }
    }

    @Override // androidx.work.impl.utils.WorkTimer.TimeLimitExceededListener
    public final void a(WorkGenerationalId workGenerationalId) {
        Logger.e().a(o, "Exceeded time limits on execution for " + workGenerationalId);
        this.f12749h.execute(new a(this, 0));
    }

    public final void d() {
        synchronized (this.f12747f) {
            try {
                if (this.n != null) {
                    this.n.e(null);
                }
                this.f12745d.f12759c.a(this.f12744c);
                PowerManager.WakeLock wakeLock = this.f12751j;
                if (wakeLock != null && wakeLock.isHeld()) {
                    Logger.e().a(o, "Releasing wakelock " + this.f12751j + "for WorkSpec " + this.f12744c);
                    this.f12751j.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.work.impl.constraints.OnConstraintsStateChangedListener
    public final void e(WorkSpec workSpec, ConstraintsState constraintsState) {
        boolean z = constraintsState instanceof ConstraintsState.ConstraintsMet;
        SerialExecutor serialExecutor = this.f12749h;
        if (z) {
            serialExecutor.execute(new a(this, 1));
        } else {
            serialExecutor.execute(new a(this, 0));
        }
    }

    public final void f() {
        String str = this.f12744c.f12893a;
        Context context = this.f12742a;
        StringBuilder sbX = b.x(str, " (");
        sbX.append(this.f12743b);
        sbX.append(")");
        this.f12751j = WakeLocks.b(context, sbX.toString());
        Logger loggerE = Logger.e();
        String str2 = o;
        loggerE.a(str2, "Acquiring wakelock " + this.f12751j + "for WorkSpec " + str);
        this.f12751j.acquire();
        WorkSpec workSpecJ = this.f12745d.f12761e.f12655c.v().j(str);
        if (workSpecJ == null) {
            this.f12749h.execute(new a(this, 0));
            return;
        }
        boolean zB = workSpecJ.b();
        this.f12752k = zB;
        if (zB) {
            this.n = WorkConstraintsTrackerKt.b(this.f12746e, workSpecJ, this.f12754m, this);
            return;
        }
        Logger.e().a(str2, "No constraints for " + str);
        this.f12749h.execute(new a(this, 1));
    }

    public final void g(boolean z) {
        Logger loggerE = Logger.e();
        StringBuilder sb = new StringBuilder("onExecuted ");
        WorkGenerationalId workGenerationalId = this.f12744c;
        sb.append(workGenerationalId);
        sb.append(", ");
        sb.append(z);
        loggerE.a(o, sb.toString());
        d();
        int i2 = this.f12743b;
        SystemAlarmDispatcher systemAlarmDispatcher = this.f12745d;
        Executor executor = this.f12750i;
        Context context = this.f12742a;
        if (z) {
            String str = CommandHandler.f12726f;
            Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent.setAction("ACTION_SCHEDULE_WORK");
            CommandHandler.d(intent, workGenerationalId);
            executor.execute(new SystemAlarmDispatcher.AddRunnable(i2, intent, systemAlarmDispatcher));
        }
        if (this.f12752k) {
            String str2 = CommandHandler.f12726f;
            Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent2.setAction("ACTION_CONSTRAINTS_CHANGED");
            executor.execute(new SystemAlarmDispatcher.AddRunnable(i2, intent2, systemAlarmDispatcher));
        }
    }
}
