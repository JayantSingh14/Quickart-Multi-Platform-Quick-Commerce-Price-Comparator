package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.net.Network;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

@RequiresApi
@RestrictTo
/* loaded from: classes.dex */
public class SystemJobService extends JobService implements ExecutionListener {

    /* renamed from: e, reason: collision with root package name */
    public static final String f12788e = Logger.g("SystemJobService");

    /* renamed from: a, reason: collision with root package name */
    public WorkManagerImpl f12789a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f12790b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final StartStopTokens f12791c = new StartStopTokens();

    /* renamed from: d, reason: collision with root package name */
    public WorkLauncherImpl f12792d;

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api24Impl {
        @DoNotInline
        public static String[] a(JobParameters jobParameters) {
            return jobParameters.getTriggeredContentAuthorities();
        }

        @DoNotInline
        public static Uri[] b(JobParameters jobParameters) {
            return jobParameters.getTriggeredContentUris();
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api28Impl {
        @DoNotInline
        public static Network a(JobParameters jobParameters) {
            return jobParameters.getNetwork();
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api31Impl {
        @DoNotInline
        public static int a(JobParameters jobParameters) {
            int stopReason = jobParameters.getStopReason();
            String str = SystemJobService.f12788e;
            switch (stopReason) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    return stopReason;
                default:
                    return -512;
            }
        }
    }

    public static WorkGenerationalId a(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new WorkGenerationalId(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION"));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public final void c(WorkGenerationalId workGenerationalId, boolean z) {
        JobParameters jobParameters;
        Logger.e().a(f12788e, workGenerationalId.f12893a + " executed on JobScheduler");
        synchronized (this.f12790b) {
            jobParameters = (JobParameters) this.f12790b.remove(workGenerationalId);
        }
        this.f12791c.b(workGenerationalId);
        if (jobParameters != null) {
            jobFinished(jobParameters, z);
        }
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        try {
            WorkManagerImpl workManagerImplF = WorkManagerImpl.f(getApplicationContext());
            this.f12789a = workManagerImplF;
            Processor processor = workManagerImplF.f12658f;
            this.f12792d = new WorkLauncherImpl(processor, workManagerImplF.f12656d);
            processor.a(this);
        } catch (IllegalStateException e2) {
            if (!Application.class.equals(getApplication().getClass())) {
                throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e2);
            }
            Logger.e().h(f12788e, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.");
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        WorkManagerImpl workManagerImpl = this.f12789a;
        if (workManagerImpl != null) {
            workManagerImpl.f12658f.f(this);
        }
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        if (this.f12789a == null) {
            Logger.e().a(f12788e, "WorkManager is not initialized; requesting retry.");
            jobFinished(jobParameters, true);
            return false;
        }
        WorkGenerationalId workGenerationalIdA = a(jobParameters);
        if (workGenerationalIdA == null) {
            Logger.e().c(f12788e, "WorkSpec id not found!");
            return false;
        }
        synchronized (this.f12790b) {
            try {
                if (this.f12790b.containsKey(workGenerationalIdA)) {
                    Logger.e().a(f12788e, "Job is already being executed by SystemJobService: " + workGenerationalIdA);
                    return false;
                }
                Logger.e().a(f12788e, "onStartJob for " + workGenerationalIdA);
                this.f12790b.put(workGenerationalIdA, jobParameters);
                int i2 = Build.VERSION.SDK_INT;
                WorkerParameters.RuntimeExtras runtimeExtras = new WorkerParameters.RuntimeExtras();
                if (Api24Impl.b(jobParameters) != null) {
                    runtimeExtras.f12598b = Arrays.asList(Api24Impl.b(jobParameters));
                }
                if (Api24Impl.a(jobParameters) != null) {
                    runtimeExtras.f12597a = Arrays.asList(Api24Impl.a(jobParameters));
                }
                if (i2 >= 28) {
                    runtimeExtras.f12599c = Api28Impl.a(jobParameters);
                }
                this.f12792d.a(this.f12791c.d(workGenerationalIdA), runtimeExtras);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        boolean zContains;
        if (this.f12789a == null) {
            Logger.e().a(f12788e, "WorkManager is not initialized; requesting retry.");
            return true;
        }
        WorkGenerationalId workGenerationalIdA = a(jobParameters);
        if (workGenerationalIdA == null) {
            Logger.e().c(f12788e, "WorkSpec id not found!");
            return false;
        }
        Logger.e().a(f12788e, "onStopJob for " + workGenerationalIdA);
        synchronized (this.f12790b) {
            this.f12790b.remove(workGenerationalIdA);
        }
        StartStopToken workSpecId = this.f12791c.b(workGenerationalIdA);
        if (workSpecId != null) {
            int iA = Build.VERSION.SDK_INT >= 31 ? Api31Impl.a(jobParameters) : -512;
            WorkLauncherImpl workLauncherImpl = this.f12792d;
            workLauncherImpl.getClass();
            Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
            workLauncherImpl.c(workSpecId, iA);
        }
        Processor processor = this.f12789a.f12658f;
        String str = workGenerationalIdA.f12893a;
        synchronized (processor.f12626k) {
            zContains = processor.f12624i.contains(str);
        }
        return !zContains;
    }
}
