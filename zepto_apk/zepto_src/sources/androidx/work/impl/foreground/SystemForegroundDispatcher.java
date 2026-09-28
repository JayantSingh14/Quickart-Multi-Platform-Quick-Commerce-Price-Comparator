package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.media.b;
import androidx.annotation.RestrictTo;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

@RestrictTo
/* loaded from: classes3.dex */
public class SystemForegroundDispatcher implements OnConstraintsStateChangedListener, ExecutionListener {

    /* renamed from: j, reason: collision with root package name */
    public static final String f12852j = Logger.g("SystemFgDispatcher");

    /* renamed from: a, reason: collision with root package name */
    public final WorkManagerImpl f12853a;

    /* renamed from: b, reason: collision with root package name */
    public final WorkManagerTaskExecutor f12854b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f12855c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public WorkGenerationalId f12856d;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashMap f12857e;

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f12858f;

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f12859g;

    /* renamed from: h, reason: collision with root package name */
    public final WorkConstraintsTracker f12860h;

    /* renamed from: i, reason: collision with root package name */
    public SystemForegroundService f12861i;

    public interface Callback {
    }

    public SystemForegroundDispatcher(Context context) {
        WorkManagerImpl workManagerImplF = WorkManagerImpl.f(context);
        this.f12853a = workManagerImplF;
        this.f12854b = workManagerImplF.f12656d;
        this.f12856d = null;
        this.f12857e = new LinkedHashMap();
        this.f12859g = new HashMap();
        this.f12858f = new HashMap();
        this.f12860h = new WorkConstraintsTracker(workManagerImplF.f12662j);
        workManagerImplF.f12658f.a(this);
    }

    public static Intent a(Context context, WorkGenerationalId workGenerationalId, ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", foregroundInfo.f12521a);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", foregroundInfo.f12522b);
        intent.putExtra("KEY_NOTIFICATION", foregroundInfo.f12523c);
        intent.putExtra("KEY_WORKSPEC_ID", workGenerationalId.f12893a);
        intent.putExtra("KEY_GENERATION", workGenerationalId.f12894b);
        return intent;
    }

    public static Intent b(Context context, WorkGenerationalId workGenerationalId, ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", workGenerationalId.f12893a);
        intent.putExtra("KEY_GENERATION", workGenerationalId.f12894b);
        intent.putExtra("KEY_NOTIFICATION_ID", foregroundInfo.f12521a);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", foregroundInfo.f12522b);
        intent.putExtra("KEY_NOTIFICATION", foregroundInfo.f12523c);
        return intent;
    }

    public static Intent d(Context context) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_STOP_FOREGROUND");
        return intent;
    }

    @Override // androidx.work.impl.ExecutionListener
    public final void c(WorkGenerationalId workGenerationalId, boolean z) {
        Map.Entry entry;
        synchronized (this.f12855c) {
            try {
                Job job = ((WorkSpec) this.f12858f.remove(workGenerationalId)) != null ? (Job) this.f12859g.remove(workGenerationalId) : null;
                if (job != null) {
                    job.e(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ForegroundInfo foregroundInfo = (ForegroundInfo) this.f12857e.remove(workGenerationalId);
        if (workGenerationalId.equals(this.f12856d)) {
            if (this.f12857e.size() > 0) {
                Iterator it = this.f12857e.entrySet().iterator();
                Object next = it.next();
                while (true) {
                    entry = (Map.Entry) next;
                    if (!it.hasNext()) {
                        break;
                    } else {
                        next = it.next();
                    }
                }
                this.f12856d = (WorkGenerationalId) entry.getKey();
                if (this.f12861i != null) {
                    ForegroundInfo foregroundInfo2 = (ForegroundInfo) entry.getValue();
                    this.f12861i.c(foregroundInfo2.f12521a, foregroundInfo2.f12522b, foregroundInfo2.f12523c);
                    this.f12861i.a(foregroundInfo2.f12521a);
                }
            } else {
                this.f12856d = null;
            }
        }
        SystemForegroundService systemForegroundService = this.f12861i;
        if (foregroundInfo == null || systemForegroundService == null) {
            return;
        }
        Logger.e().a(f12852j, "Removing Notification (id: " + foregroundInfo.f12521a + ", workSpecId: " + workGenerationalId + ", notificationType: " + foregroundInfo.f12522b);
        systemForegroundService.a(foregroundInfo.f12521a);
    }

    @Override // androidx.work.impl.constraints.OnConstraintsStateChangedListener
    public final void e(WorkSpec workSpec, ConstraintsState constraintsState) {
        if (constraintsState instanceof ConstraintsState.ConstraintsNotMet) {
            Logger.e().a(f12852j, "Constraints unmet for WorkSpec " + workSpec.f12905a);
            WorkGenerationalId workGenerationalIdA = WorkSpecKt.a(workSpec);
            WorkManagerImpl workManagerImpl = this.f12853a;
            workManagerImpl.getClass();
            StartStopToken token = new StartStopToken(workGenerationalIdA);
            Processor processor = workManagerImpl.f12658f;
            Intrinsics.checkNotNullParameter(processor, "processor");
            Intrinsics.checkNotNullParameter(token, "token");
            workManagerImpl.f12656d.c(new StopWorkRunnable(processor, token, true, -512));
        }
    }

    public final void f(Intent intent) {
        int i2 = 0;
        final int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        WorkGenerationalId workGenerationalId = new WorkGenerationalId(stringExtra, intent.getIntExtra("KEY_GENERATION", 0));
        final Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        Logger loggerE = Logger.e();
        StringBuilder sb = new StringBuilder("Notifying with (id:");
        sb.append(intExtra);
        sb.append(", workSpecId: ");
        sb.append(stringExtra);
        sb.append(", notificationType :");
        loggerE.a(f12852j, b.o(sb, intExtra2, ")"));
        if (notification == null || this.f12861i == null) {
            return;
        }
        ForegroundInfo foregroundInfo = new ForegroundInfo(intExtra, intExtra2, notification);
        LinkedHashMap linkedHashMap = this.f12857e;
        linkedHashMap.put(workGenerationalId, foregroundInfo);
        if (this.f12856d == null) {
            this.f12856d = workGenerationalId;
            this.f12861i.c(intExtra, intExtra2, notification);
            return;
        }
        final SystemForegroundService systemForegroundService = this.f12861i;
        systemForegroundService.f12865b.post(new Runnable() { // from class: androidx.work.impl.foreground.SystemForegroundService.2
            @Override // java.lang.Runnable
            public final void run() {
                SystemForegroundService.this.f12868e.notify(intExtra, notification);
            }
        });
        if (intExtra2 == 0 || Build.VERSION.SDK_INT < 29) {
            return;
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            i2 |= ((ForegroundInfo) ((Map.Entry) it.next()).getValue()).f12522b;
        }
        ForegroundInfo foregroundInfo2 = (ForegroundInfo) linkedHashMap.get(this.f12856d);
        if (foregroundInfo2 != null) {
            this.f12861i.c(foregroundInfo2.f12521a, i2, foregroundInfo2.f12523c);
        }
    }

    public final void g() {
        this.f12861i = null;
        synchronized (this.f12855c) {
            try {
                Iterator it = this.f12859g.values().iterator();
                while (it.hasNext()) {
                    ((Job) it.next()).e(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f12853a.f12658f.f(this);
    }
}
