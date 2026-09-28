package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.util.PriorityMapping;

@RequiresApi
/* loaded from: classes3.dex */
public class JobInfoSchedulerService extends JobService {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f20868a = 0;

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i2 = jobParameters.getExtras().getInt("priority");
        int i3 = jobParameters.getExtras().getInt("attemptNumber");
        TransportRuntime.b(getApplicationContext());
        TransportContext.Builder builderA = TransportContext.a();
        builderA.b(string);
        builderA.d(PriorityMapping.b(i2));
        if (string2 != null) {
            builderA.c(Base64.decode(string2, 0));
        }
        Uploader uploader = TransportRuntime.a().f20763d;
        TransportContext transportContextA = builderA.a();
        androidx.constraintlayout.motion.widget.a aVar = new androidx.constraintlayout.motion.widget.a(24, this, jobParameters);
        uploader.getClass();
        uploader.f20879e.execute(new a(i3, 0, uploader, transportContextA, aVar));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
