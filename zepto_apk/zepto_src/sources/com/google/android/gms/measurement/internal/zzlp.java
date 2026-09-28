package com.google.android.gms.measurement.internal;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.PersistableBundle;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class zzlp extends zzg {

    /* renamed from: c, reason: collision with root package name */
    public JobScheduler f39337c;

    @Override // com.google.android.gms.measurement.internal.zzg
    public final boolean j() {
        return true;
    }

    public final void k(long j2) {
        h();
        g();
        JobScheduler jobScheduler = this.f39337c;
        zzib zzibVar = this.f39180a;
        if (jobScheduler != null && jobScheduler.getPendingJob("measurement-client".concat(String.valueOf(zzibVar.f39084a.getPackageName())).hashCode()) != null) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.n.a("[sgtm] There's an existing pending job, skip this schedule.");
            return;
        }
        com.google.android.gms.internal.measurement.zzin zzinVarL = l();
        if (zzinVarL != com.google.android.gms.internal.measurement.zzin.CLIENT_UPLOAD_ELIGIBLE) {
            zzgt zzgtVar2 = zzibVar.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.n.b(zzinVarL.name(), "[sgtm] Not eligible for Scion upload");
            return;
        }
        zzgt zzgtVar3 = zzibVar.f39089f;
        zzib.l(zzgtVar3);
        zzgtVar3.n.b(Long.valueOf(j2), "[sgtm] Scheduling Scion upload, millis");
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.SCION_UPLOAD");
        int iSchedule = ((JobScheduler) Preconditions.checkNotNull(this.f39337c)).schedule(new JobInfo.Builder("measurement-client".concat(String.valueOf(zzibVar.f39084a.getPackageName())).hashCode(), new ComponentName(zzibVar.f39084a, "com.google.android.gms.measurement.AppMeasurementJobService")).setRequiredNetworkType(1).setMinimumLatency(j2).setOverrideDeadline(j2 + j2).setExtras(persistableBundle).build());
        zzgt zzgtVar4 = zzibVar.f39089f;
        zzib.l(zzgtVar4);
        zzgtVar4.n.b(iSchedule == 1 ? MerchantConstants.SUCCESS : "FAILURE", "[sgtm] Scion upload job scheduled with result");
    }

    public final com.google.android.gms.internal.measurement.zzin l() {
        h();
        g();
        if (this.f39337c == null) {
            return com.google.android.gms.internal.measurement.zzin.MISSING_JOB_SCHEDULER;
        }
        zzib zzibVar = this.f39180a;
        Boolean boolS = zzibVar.f39087d.s("google_analytics_sgtm_upload_enabled");
        return boolS == null ? false : boolS.booleanValue() ? zzibVar.q().f38923j >= 119000 ? !zzpo.z(zzibVar.f39084a) ? com.google.android.gms.internal.measurement.zzin.MEASUREMENT_SERVICE_NOT_ENABLED : !zzibVar.o().n() ? com.google.android.gms.internal.measurement.zzin.NON_PLAY_MODE : com.google.android.gms.internal.measurement.zzin.CLIENT_UPLOAD_ELIGIBLE : com.google.android.gms.internal.measurement.zzin.SDK_TOO_OLD : com.google.android.gms.internal.measurement.zzin.NOT_ENABLED_IN_MANIFEST;
    }
}
