package androidx.media3.exoplayer.scheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import androidx.annotation.RequiresApi;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@RequiresApi
@UnstableApi
/* loaded from: classes3.dex */
public final class PlatformScheduler implements Scheduler {

    public static final class PlatformSchedulerService extends JobService {
        /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
        @Override // android.app.job.JobService
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean onStartJob(android.app.job.JobParameters r12) {
            /*
                Method dump skipped, instructions count: 273
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.scheduler.PlatformScheduler.PlatformSchedulerService.onStartJob(android.app.job.JobParameters):boolean");
        }

        @Override // android.app.job.JobService
        public final boolean onStopJob(JobParameters jobParameters) {
            return false;
        }
    }

    static {
        int i2 = Util.f5744a;
    }
}
