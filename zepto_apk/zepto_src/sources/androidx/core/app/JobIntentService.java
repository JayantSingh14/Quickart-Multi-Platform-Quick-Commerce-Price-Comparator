package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.v4.media.b;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.c;
import com.chuckerteam.chucker.internal.support.ClearDatabaseService;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang3.time.DateUtils;

@Deprecated
/* loaded from: classes3.dex */
public abstract class JobIntentService extends Service {

    /* renamed from: f, reason: collision with root package name */
    public static final Object f2620f = new Object();

    /* renamed from: g, reason: collision with root package name */
    public static final HashMap f2621g = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public JobServiceEngineImpl f2622a;

    /* renamed from: b, reason: collision with root package name */
    public WorkEnqueuer f2623b;

    /* renamed from: c, reason: collision with root package name */
    public CommandProcessor f2624c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2625d = false;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f2626e;

    public final class CommandProcessor extends AsyncTask<Void, Void, Void> {
        public CommandProcessor() {
        }

        @Override // android.os.AsyncTask
        public final Void doInBackground(Void[] voidArr) {
            GenericWorkItem wrapperWorkItem;
            while (true) {
                JobIntentService jobIntentService = JobIntentService.this;
                JobServiceEngineImpl jobServiceEngineImpl = jobIntentService.f2622a;
                if (jobServiceEngineImpl != null) {
                    synchronized (jobServiceEngineImpl.f2637b) {
                        try {
                            JobParameters jobParameters = jobServiceEngineImpl.f2638c;
                            if (jobParameters != null) {
                                JobWorkItem jobWorkItemDequeueWork = jobParameters.dequeueWork();
                                if (jobWorkItemDequeueWork != null) {
                                    jobWorkItemDequeueWork.getIntent().setExtrasClassLoader(jobServiceEngineImpl.f2636a.getClassLoader());
                                    wrapperWorkItem = jobServiceEngineImpl.new WrapperWorkItem(jobWorkItemDequeueWork);
                                }
                            }
                        } finally {
                        }
                    }
                } else {
                    synchronized (jobIntentService.f2626e) {
                        try {
                            wrapperWorkItem = jobIntentService.f2626e.size() > 0 ? (GenericWorkItem) jobIntentService.f2626e.remove(0) : null;
                        } finally {
                        }
                    }
                }
                if (wrapperWorkItem == null) {
                    return null;
                }
                JobIntentService.this.d(wrapperWorkItem.getIntent());
                wrapperWorkItem.complete();
            }
        }

        @Override // android.os.AsyncTask
        public final void onCancelled(Void r1) {
            JobIntentService.this.e();
        }

        @Override // android.os.AsyncTask
        public final void onPostExecute(Void r1) {
            JobIntentService.this.e();
        }
    }

    public interface CompatJobEngine {
    }

    public static final class CompatWorkEnqueuer extends WorkEnqueuer {

        /* renamed from: d, reason: collision with root package name */
        public final Context f2628d;

        /* renamed from: e, reason: collision with root package name */
        public final PowerManager.WakeLock f2629e;

        /* renamed from: f, reason: collision with root package name */
        public final PowerManager.WakeLock f2630f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f2631g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f2632h;

        public CompatWorkEnqueuer(Context context, ComponentName componentName) {
            super(componentName);
            this.f2628d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f2629e = wakeLockNewWakeLock;
            wakeLockNewWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock wakeLockNewWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f2630f = wakeLockNewWakeLock2;
            wakeLockNewWakeLock2.setReferenceCounted(false);
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public final void a(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.f2643a);
            if (this.f2628d.startService(intent2) != null) {
                synchronized (this) {
                    try {
                        if (!this.f2631g) {
                            this.f2631g = true;
                            if (!this.f2632h) {
                                this.f2629e.acquire(DateUtils.MILLIS_PER_MINUTE);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public final void c() {
            synchronized (this) {
                try {
                    if (this.f2632h) {
                        if (this.f2631g) {
                            this.f2629e.acquire(DateUtils.MILLIS_PER_MINUTE);
                        }
                        this.f2632h = false;
                        this.f2630f.release();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public final void d() {
            synchronized (this) {
                try {
                    if (!this.f2632h) {
                        this.f2632h = true;
                        this.f2630f.acquire(600000L);
                        this.f2629e.release();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public final void e() {
            synchronized (this) {
                this.f2631g = false;
            }
        }
    }

    public final class CompatWorkItem implements GenericWorkItem {

        /* renamed from: a, reason: collision with root package name */
        public final Intent f2633a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2634b;

        public CompatWorkItem(Intent intent, int i2) {
            this.f2633a = intent;
            this.f2634b = i2;
        }

        @Override // androidx.core.app.JobIntentService.GenericWorkItem
        public final void complete() {
            JobIntentService.this.stopSelf(this.f2634b);
        }

        @Override // androidx.core.app.JobIntentService.GenericWorkItem
        public final Intent getIntent() {
            return this.f2633a;
        }
    }

    public interface GenericWorkItem {
        void complete();

        Intent getIntent();
    }

    @RequiresApi
    public static final class JobServiceEngineImpl extends JobServiceEngine implements CompatJobEngine {

        /* renamed from: a, reason: collision with root package name */
        public final JobIntentService f2636a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f2637b;

        /* renamed from: c, reason: collision with root package name */
        public JobParameters f2638c;

        public final class WrapperWorkItem implements GenericWorkItem {

            /* renamed from: a, reason: collision with root package name */
            public final JobWorkItem f2639a;

            public WrapperWorkItem(JobWorkItem jobWorkItem) {
                this.f2639a = jobWorkItem;
            }

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public final void complete() {
                synchronized (JobServiceEngineImpl.this.f2637b) {
                    try {
                        JobParameters jobParameters = JobServiceEngineImpl.this.f2638c;
                        if (jobParameters != null) {
                            jobParameters.completeWork(this.f2639a);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public final Intent getIntent() {
                return this.f2639a.getIntent();
            }
        }

        public JobServiceEngineImpl(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f2637b = new Object();
            this.f2636a = jobIntentService;
        }

        public final boolean onStartJob(JobParameters jobParameters) {
            this.f2638c = jobParameters;
            this.f2636a.b(false);
            return true;
        }

        public final boolean onStopJob(JobParameters jobParameters) {
            CommandProcessor commandProcessor = this.f2636a.f2624c;
            if (commandProcessor != null) {
                commandProcessor.cancel(false);
            }
            synchronized (this.f2637b) {
                this.f2638c = null;
            }
            return true;
        }
    }

    @RequiresApi
    public static final class JobWorkEnqueuer extends WorkEnqueuer {

        /* renamed from: d, reason: collision with root package name */
        public final JobInfo f2641d;

        /* renamed from: e, reason: collision with root package name */
        public final JobScheduler f2642e;

        public JobWorkEnqueuer(Context context, ComponentName componentName, int i2) {
            super(componentName);
            b(i2);
            this.f2641d = new JobInfo.Builder(i2, componentName).setOverrideDeadline(0L).build();
            this.f2642e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public final void a(Intent intent) {
            this.f2642e.enqueue(this.f2641d, c.g(intent));
        }
    }

    public static abstract class WorkEnqueuer {

        /* renamed from: a, reason: collision with root package name */
        public final ComponentName f2643a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f2644b;

        /* renamed from: c, reason: collision with root package name */
        public int f2645c;

        public WorkEnqueuer(ComponentName componentName) {
            this.f2643a = componentName;
        }

        public abstract void a(Intent intent);

        public final void b(int i2) {
            if (!this.f2644b) {
                this.f2644b = true;
                this.f2645c = i2;
            } else {
                if (this.f2645c == i2) {
                    return;
                }
                StringBuilder sbU = b.u(i2, "Given job ID ", " is different than previous ");
                sbU.append(this.f2645c);
                throw new IllegalArgumentException(sbU.toString());
            }
        }

        public void c() {
        }

        public void d() {
        }

        public void e() {
        }
    }

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2626e = null;
        } else {
            this.f2626e = new ArrayList();
        }
    }

    public static void a(Context context, Intent intent) {
        ComponentName componentName = new ComponentName(context, (Class<?>) ClearDatabaseService.class);
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        synchronized (f2620f) {
            WorkEnqueuer workEnqueuerC = c(context, componentName, true, 123321);
            workEnqueuerC.b(123321);
            workEnqueuerC.a(intent);
        }
    }

    public static WorkEnqueuer c(Context context, ComponentName componentName, boolean z, int i2) {
        WorkEnqueuer compatWorkEnqueuer;
        HashMap map = f2621g;
        WorkEnqueuer workEnqueuer = (WorkEnqueuer) map.get(componentName);
        if (workEnqueuer != null) {
            return workEnqueuer;
        }
        if (Build.VERSION.SDK_INT < 26) {
            compatWorkEnqueuer = new CompatWorkEnqueuer(context, componentName);
        } else {
            if (!z) {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
            compatWorkEnqueuer = new JobWorkEnqueuer(context, componentName, i2);
        }
        map.put(componentName, compatWorkEnqueuer);
        return compatWorkEnqueuer;
    }

    public final void b(boolean z) {
        if (this.f2624c == null) {
            this.f2624c = new CommandProcessor();
            WorkEnqueuer workEnqueuer = this.f2623b;
            if (workEnqueuer != null && z) {
                workEnqueuer.d();
            }
            this.f2624c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public abstract void d(Intent intent);

    public final void e() {
        ArrayList arrayList = this.f2626e;
        if (arrayList != null) {
            synchronized (arrayList) {
                try {
                    this.f2624c = null;
                    ArrayList arrayList2 = this.f2626e;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        b(false);
                    } else if (!this.f2625d) {
                        this.f2623b.c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        JobServiceEngineImpl jobServiceEngineImpl = this.f2622a;
        if (jobServiceEngineImpl != null) {
            return jobServiceEngineImpl.getBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2622a = new JobServiceEngineImpl(this);
            this.f2623b = null;
        } else {
            this.f2622a = null;
            this.f2623b = c(this, new ComponentName(this, getClass()), false, 0);
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        ArrayList arrayList = this.f2626e;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f2625d = true;
                this.f2623b.c();
            }
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        if (this.f2626e == null) {
            return 2;
        }
        this.f2623b.e();
        synchronized (this.f2626e) {
            ArrayList arrayList = this.f2626e;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new CompatWorkItem(intent, i3));
            b(true);
        }
        return 3;
    }
}
