package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.work.BackoffPolicy;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.IdGenerator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

@RequiresApi
@RestrictTo
/* loaded from: classes.dex */
public class SystemJobScheduler implements Scheduler {

    /* renamed from: f, reason: collision with root package name */
    public static final String f12782f = Logger.g("SystemJobScheduler");

    /* renamed from: a, reason: collision with root package name */
    public final Context f12783a;

    /* renamed from: b, reason: collision with root package name */
    public final JobScheduler f12784b;

    /* renamed from: c, reason: collision with root package name */
    public final SystemJobInfoConverter f12785c;

    /* renamed from: d, reason: collision with root package name */
    public final WorkDatabase f12786d;

    /* renamed from: e, reason: collision with root package name */
    public final Configuration f12787e;

    public SystemJobScheduler(Context context, WorkDatabase workDatabase, Configuration configuration) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        SystemJobInfoConverter systemJobInfoConverter = new SystemJobInfoConverter(context, configuration.f12476c);
        this.f12783a = context;
        this.f12784b = jobScheduler;
        this.f12785c = systemJobInfoConverter;
        this.f12786d = workDatabase;
        this.f12787e = configuration;
    }

    public static void c(JobScheduler jobScheduler, int i2) {
        try {
            jobScheduler.cancel(i2);
        } catch (Throwable th) {
            Logger.e().d(f12782f, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i2)), th);
        }
    }

    public static ArrayList e(Context context, JobScheduler jobScheduler) {
        List<JobInfo> allPendingJobs;
        try {
            allPendingJobs = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            Logger.e().d(f12782f, "getAllPendingJobs() is not reliable on this device.", th);
            allPendingJobs = null;
        }
        if (allPendingJobs == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(allPendingJobs.size());
        ComponentName componentName = new ComponentName(context, (Class<?>) SystemJobService.class);
        for (JobInfo jobInfo : allPendingJobs) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    public static WorkGenerationalId f(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (!extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new WorkGenerationalId(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION", 0));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // androidx.work.impl.Scheduler
    public final void a(String str) {
        ArrayList arrayList;
        Context context = this.f12783a;
        JobScheduler jobScheduler = this.f12784b;
        ArrayList arrayListE = e(context, jobScheduler);
        if (arrayListE == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(2);
            Iterator it = arrayListE.iterator();
            while (it.hasNext()) {
                JobInfo jobInfo = (JobInfo) it.next();
                WorkGenerationalId workGenerationalIdF = f(jobInfo);
                if (workGenerationalIdF != null && str.equals(workGenerationalIdF.f12893a)) {
                    arrayList2.add(Integer.valueOf(jobInfo.getId()));
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            c(jobScheduler, ((Integer) it2.next()).intValue());
        }
        this.f12786d.s().i(str);
    }

    @Override // androidx.work.impl.Scheduler
    public final void b(WorkSpec... workSpecArr) {
        int iIntValue;
        Configuration configuration = this.f12787e;
        WorkDatabase workDatabase = this.f12786d;
        final IdGenerator idGenerator = new IdGenerator(workDatabase);
        for (WorkSpec workSpec : workSpecArr) {
            workDatabase.c();
            try {
                WorkSpec workSpecJ = workDatabase.v().j(workSpec.f12905a);
                String str = f12782f;
                String str2 = workSpec.f12905a;
                if (workSpecJ == null) {
                    Logger.e().h(str, "Skipping scheduling " + str2 + " because it's no longer in the DB");
                    workDatabase.o();
                } else if (workSpecJ.f12906b != WorkInfo.State.f12566a) {
                    Logger.e().h(str, "Skipping scheduling " + str2 + " because it is no longer enqueued");
                    workDatabase.o();
                } else {
                    WorkGenerationalId generationalId = WorkSpecKt.a(workSpec);
                    SystemIdInfo systemIdInfoC = workDatabase.s().c(generationalId);
                    if (systemIdInfoC != null) {
                        iIntValue = systemIdInfoC.f12888c;
                    } else {
                        configuration.getClass();
                        final int i2 = configuration.f12481h;
                        Object objN = idGenerator.f12976a.n(new Callable() { // from class: androidx.work.impl.utils.a
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                IdGenerator this$0 = idGenerator;
                                Intrinsics.checkNotNullParameter(this$0, "this$0");
                                WorkDatabase workDatabase2 = this$0.f12976a;
                                Long lB = workDatabase2.r().b("next_job_scheduler_id");
                                int i3 = 0;
                                int iLongValue = lB != null ? (int) lB.longValue() : 0;
                                workDatabase2.r().a(new Preference("next_job_scheduler_id", Long.valueOf(iLongValue == Integer.MAX_VALUE ? 0 : iLongValue + 1)));
                                if (iLongValue < 0 || iLongValue > i2) {
                                    this$0.f12976a.r().a(new Preference("next_job_scheduler_id", Long.valueOf(1)));
                                } else {
                                    i3 = iLongValue;
                                }
                                return Integer.valueOf(i3);
                            }
                        });
                        Intrinsics.checkNotNullExpressionValue(objN, "workDatabase.runInTransa…            id\n        })");
                        iIntValue = ((Number) objN).intValue();
                    }
                    if (systemIdInfoC == null) {
                        Intrinsics.checkNotNullParameter(generationalId, "generationalId");
                        workDatabase.s().g(new SystemIdInfo(generationalId.f12893a, generationalId.f12894b, iIntValue));
                    }
                    g(workSpec, iIntValue);
                    workDatabase.o();
                }
            } finally {
                workDatabase.j();
            }
        }
    }

    @Override // androidx.work.impl.Scheduler
    public final boolean d() {
        return true;
    }

    public final void g(WorkSpec workSpec, int i2) {
        int i3;
        long j2;
        int i4;
        JobScheduler jobScheduler = this.f12784b;
        SystemJobInfoConverter systemJobInfoConverter = this.f12785c;
        systemJobInfoConverter.getClass();
        Constraints constraints = workSpec.f12914j;
        PersistableBundle persistableBundle = new PersistableBundle();
        String str = workSpec.f12905a;
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", str);
        persistableBundle.putInt("EXTRA_WORK_SPEC_GENERATION", workSpec.t);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", workSpec.c());
        JobInfo.Builder requiresCharging = new JobInfo.Builder(i2, systemJobInfoConverter.f12779a).setRequiresCharging(constraints.f12488b);
        boolean z = constraints.f12489c;
        JobInfo.Builder extras = requiresCharging.setRequiresDeviceIdle(z).setExtras(persistableBundle);
        int i5 = Build.VERSION.SDK_INT;
        NetworkType networkType = constraints.f12487a;
        if (i5 < 30 || networkType != NetworkType.f12541f) {
            int iOrdinal = networkType.ordinal();
            if (iOrdinal == 0) {
                i3 = 0;
            } else if (iOrdinal != 1) {
                i3 = 2;
                if (iOrdinal != 2) {
                    i3 = 3;
                    if (iOrdinal != 3) {
                        i3 = 4;
                        if (iOrdinal != 4 || i5 < 26) {
                            Logger.e().a(SystemJobInfoConverter.f12778c, "API version too low. Cannot convert network type value " + networkType);
                            i3 = 1;
                        }
                    }
                }
            } else {
                i3 = 1;
            }
            extras.setRequiredNetworkType(i3);
        } else {
            extras.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        }
        if (!z) {
            extras.setBackoffCriteria(workSpec.f12917m, workSpec.f12916l == BackoffPolicy.f12472b ? 0 : 1);
        }
        long jA = workSpec.a();
        systemJobInfoConverter.f12780b.getClass();
        long jMax = Math.max(jA - System.currentTimeMillis(), 0L);
        if (i5 <= 28 || jMax > 0) {
            extras.setMinimumLatency(jMax);
        } else if (!workSpec.q) {
            extras.setImportantWhileForeground(true);
        }
        Set<Constraints.ContentUriTrigger> set = constraints.f12494h;
        if (set.isEmpty()) {
            j2 = 0;
        } else {
            for (Constraints.ContentUriTrigger contentUriTrigger : set) {
                extras.addTriggerContentUri(new JobInfo.TriggerContentUri(contentUriTrigger.a(), contentUriTrigger.b() ? 1 : 0));
            }
            j2 = 0;
            extras.setTriggerContentUpdateDelay(constraints.f12492f);
            extras.setTriggerContentMaxDelay(constraints.f12493g);
        }
        extras.setPersisted(false);
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 26) {
            extras.setRequiresBatteryNotLow(constraints.f12490d);
            extras.setRequiresStorageNotLow(constraints.f12491e);
        }
        boolean z2 = workSpec.f12915k > 0;
        boolean z3 = jMax > j2;
        if (i6 >= 31 && workSpec.q && !z2 && !z3) {
            extras.setExpedited(true);
        }
        JobInfo jobInfoBuild = extras.build();
        String str2 = f12782f;
        Logger.e().a(str2, "Scheduling work ID " + str + "Job ID " + i2);
        try {
            try {
                if (jobScheduler.schedule(jobInfoBuild) == 0) {
                    Logger.e().h(str2, "Unable to schedule work ID " + str);
                    if (workSpec.q) {
                        if (workSpec.r == OutOfQuotaPolicy.f12549a) {
                            i4 = 0;
                            try {
                                workSpec.q = false;
                                Logger.e().a(str2, "Scheduling a non-expedited job (work ID " + str + ")");
                                g(workSpec, i2);
                            } catch (IllegalStateException e2) {
                                e = e2;
                                ArrayList arrayListE = e(this.f12783a, jobScheduler);
                                String str3 = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", Integer.valueOf(arrayListE != null ? arrayListE.size() : i4), Integer.valueOf(this.f12786d.v().g().size()), Integer.valueOf(this.f12787e.f12483j));
                                Logger.e().c(str2, str3);
                                throw new IllegalStateException(str3, e);
                            }
                        }
                    }
                }
            } catch (IllegalStateException e3) {
                e = e3;
                i4 = 0;
            }
        } catch (Throwable th) {
            Logger.e().d(str2, "Unable to schedule " + workSpec, th);
        }
    }
}
