package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.Adler32;

@RequiresApi
/* loaded from: classes.dex */
public class JobInfoScheduler implements WorkScheduler {

    /* renamed from: a, reason: collision with root package name */
    public final Context f20865a;

    /* renamed from: b, reason: collision with root package name */
    public final EventStore f20866b;

    /* renamed from: c, reason: collision with root package name */
    public final SchedulerConfig f20867c;

    public JobInfoScheduler(Context context, EventStore eventStore, SchedulerConfig schedulerConfig) {
        this.f20865a = context;
        this.f20866b = eventStore;
        this.f20867c = schedulerConfig;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler
    public final void a(TransportContext transportContext, int i2) {
        b(transportContext, i2, false);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler
    public final void b(TransportContext transportContext, int i2, boolean z) {
        Context context = this.f20865a;
        ComponentName componentName = new ComponentName(context, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(context.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(transportContext.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(PriorityMapping.a(transportContext.d())).array());
        if (transportContext.c() != null) {
            adler32.update(transportContext.c());
        }
        int value = (int) adler32.getValue();
        if (!z) {
            Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                JobInfo next = it.next();
                int i3 = next.getExtras().getInt("attemptNumber");
                if (next.getId() == value) {
                    if (i3 >= i2) {
                        Logging.a("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", transportContext);
                        return;
                    }
                }
            }
        }
        long jW0 = this.f20866b.w0(transportContext);
        JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
        Priority priorityD = transportContext.d();
        SchedulerConfig schedulerConfig = this.f20867c;
        builder.setMinimumLatency(schedulerConfig.c(priorityD, jW0, i2));
        Set setB = ((SchedulerConfig.ConfigValue) schedulerConfig.d().get(priorityD)).b();
        if (setB.contains(SchedulerConfig.Flag.f20871a)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (setB.contains(SchedulerConfig.Flag.f20873c)) {
            builder.setRequiresCharging(true);
        }
        if (setB.contains(SchedulerConfig.Flag.f20872b)) {
            builder.setRequiresDeviceIdle(true);
        }
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i2);
        persistableBundle.putString("backendName", transportContext.b());
        persistableBundle.putInt("priority", PriorityMapping.a(transportContext.d()));
        if (transportContext.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(transportContext.c(), 0));
        }
        builder.setExtras(persistableBundle);
        Logging.b("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", transportContext, Integer.valueOf(value), Long.valueOf(schedulerConfig.c(transportContext.d(), jW0, i2)), Long.valueOf(jW0), Integer.valueOf(i2));
        jobScheduler.schedule(builder.build());
    }
}
