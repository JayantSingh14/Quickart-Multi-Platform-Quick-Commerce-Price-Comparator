package androidx.work.impl;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.media3.exoplayer.source.h;
import androidx.work.Configuration;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.PreferenceUtils;
import androidx.work.impl.utils.SerialExecutorImpl;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@RestrictTo
/* loaded from: classes.dex */
public class WorkManagerImpl extends WorkManager {

    /* renamed from: k, reason: collision with root package name */
    public static WorkManagerImpl f12650k;

    /* renamed from: l, reason: collision with root package name */
    public static WorkManagerImpl f12651l;

    /* renamed from: m, reason: collision with root package name */
    public static final Object f12652m;

    /* renamed from: a, reason: collision with root package name */
    public final Context f12653a;

    /* renamed from: b, reason: collision with root package name */
    public final Configuration f12654b;

    /* renamed from: c, reason: collision with root package name */
    public final WorkDatabase f12655c;

    /* renamed from: d, reason: collision with root package name */
    public final WorkManagerTaskExecutor f12656d;

    /* renamed from: e, reason: collision with root package name */
    public final List f12657e;

    /* renamed from: f, reason: collision with root package name */
    public final Processor f12658f;

    /* renamed from: g, reason: collision with root package name */
    public final PreferenceUtils f12659g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f12660h = false;

    /* renamed from: i, reason: collision with root package name */
    public BroadcastReceiver.PendingResult f12661i;

    /* renamed from: j, reason: collision with root package name */
    public final Trackers f12662j;

    /* renamed from: androidx.work.impl.WorkManagerImpl$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements Runnable {
        /* JADX WARN: Code restructure failed: missing block: B:7:?, code lost:
        
            throw null;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void run() {
            /*
                r1 = this;
                r0 = 0
                throw r0     // Catch: java.lang.Throwable -> L2
            L2:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.WorkManagerImpl.AnonymousClass1.run():void");
        }
    }

    /* renamed from: androidx.work.impl.WorkManagerImpl$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass2 implements Function<List<WorkSpec.WorkInfoPojo>, WorkInfo> {
        @Override // androidx.arch.core.util.Function
        public final Object apply(Object obj) {
            return null;
        }
    }

    @RequiresApi
    public static class Api24Impl {
        @DoNotInline
        public static boolean a(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    static {
        Logger.g("WorkManagerImpl");
        f12650k = null;
        f12651l = null;
        f12652m = new Object();
    }

    public WorkManagerImpl(Context context, final Configuration configuration, WorkManagerTaskExecutor workManagerTaskExecutor, final WorkDatabase workDatabase, final List list, Processor processor, Trackers trackers) {
        Context applicationContext = context.getApplicationContext();
        if (Api24Impl.a(applicationContext)) {
            throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
        }
        Logger.LogcatLogger logcatLogger = new Logger.LogcatLogger(configuration.f12480g);
        synchronized (Logger.f12533a) {
            Logger.f12534b = logcatLogger;
        }
        this.f12653a = applicationContext;
        this.f12656d = workManagerTaskExecutor;
        this.f12655c = workDatabase;
        this.f12658f = processor;
        this.f12662j = trackers;
        this.f12654b = configuration;
        this.f12657e = list;
        this.f12659g = new PreferenceUtils(workDatabase);
        final SerialExecutorImpl serialExecutorImpl = workManagerTaskExecutor.f13061a;
        String str = Schedulers.f12628a;
        processor.a(new ExecutionListener() { // from class: androidx.work.impl.b
            @Override // androidx.work.impl.ExecutionListener
            public final void c(WorkGenerationalId workGenerationalId, boolean z) {
                String str2 = Schedulers.f12628a;
                serialExecutorImpl.execute(new h(list, workGenerationalId, configuration, workDatabase, 1));
            }
        });
        workManagerTaskExecutor.c(new ForceStopRunnable(applicationContext, this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static WorkManagerImpl f(Context context) {
        WorkManagerImpl workManagerImplF;
        Object obj = f12652m;
        synchronized (obj) {
            try {
                synchronized (obj) {
                    workManagerImplF = f12650k;
                    if (workManagerImplF == null) {
                        workManagerImplF = f12651l;
                    }
                }
                return workManagerImplF;
            } catch (Throwable th) {
                throw th;
            } finally {
            }
        }
        if (workManagerImplF == null) {
            Context applicationContext = context.getApplicationContext();
            if (!(applicationContext instanceof Configuration.Provider)) {
                throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
            }
            g(applicationContext, ((Configuration.Provider) applicationContext).a());
            workManagerImplF = f(applicationContext);
        }
        return workManagerImplF;
    }

    public static void g(Context context, Configuration configuration) {
        synchronized (f12652m) {
            try {
                WorkManagerImpl workManagerImpl = f12650k;
                if (workManagerImpl != null && f12651l != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
                if (workManagerImpl == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (f12651l == null) {
                        f12651l = WorkManagerImplExtKt.a(applicationContext, configuration);
                    }
                    f12650k = f12651l;
                }
            } finally {
            }
        }
    }

    @Override // androidx.work.WorkManager
    public final Operation a(List list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
        }
        return new WorkContinuationImpl(this, null, ExistingWorkPolicy.f12517b, list).a();
    }

    @Override // androidx.work.WorkManager
    public final Operation d(String str, ExistingWorkPolicy existingWorkPolicy, List list) {
        return new WorkContinuationImpl(this, str, existingWorkPolicy, list).a();
    }

    public final Operation e(String str, PeriodicWorkRequest periodicWorkRequest) {
        return new WorkContinuationImpl(this, str, ExistingWorkPolicy.f12516a, Collections.singletonList(periodicWorkRequest)).a();
    }

    public final void h() {
        synchronized (f12652m) {
            try {
                this.f12660h = true;
                BroadcastReceiver.PendingResult pendingResult = this.f12661i;
                if (pendingResult != null) {
                    pendingResult.finish();
                    this.f12661i = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void i() {
        ArrayList arrayListE;
        String str = SystemJobScheduler.f12782f;
        Context context = this.f12653a;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null && (arrayListE = SystemJobScheduler.e(context, jobScheduler)) != null && !arrayListE.isEmpty()) {
            Iterator it = arrayListE.iterator();
            while (it.hasNext()) {
                SystemJobScheduler.c(jobScheduler, ((JobInfo) it.next()).getId());
            }
        }
        WorkDatabase workDatabase = this.f12655c;
        workDatabase.v().n();
        Schedulers.b(this.f12654b, workDatabase, this.f12657e);
    }
}
