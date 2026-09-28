package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobScheduler;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public final class zzoj extends zzor {

    /* renamed from: d, reason: collision with root package name */
    public final AlarmManager f39548d;

    /* renamed from: e, reason: collision with root package name */
    public zzoi f39549e;

    /* renamed from: f, reason: collision with root package name */
    public Integer f39550f;

    public zzoj(zzpf zzpfVar) {
        super(zzpfVar);
        this.f39548d = (AlarmManager) this.f39180a.f39084a.getSystemService("alarm");
    }

    @Override // com.google.android.gms.measurement.internal.zzor
    public final void j() {
        AlarmManager alarmManager = this.f39548d;
        if (alarmManager != null) {
            Context context = this.f39180a.f39084a;
            alarmManager.cancel(PendingIntent.getBroadcast(context, 0, new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), com.google.android.gms.internal.measurement.zzcg.f36824a));
        }
        m();
    }

    public final void k() {
        h();
        zzib zzibVar = this.f39180a;
        zzgt zzgtVar = zzibVar.f39089f;
        zzib.l(zzgtVar);
        zzgtVar.n.a("Unscheduling upload");
        AlarmManager alarmManager = this.f39548d;
        if (alarmManager != null) {
            Context context = zzibVar.f39084a;
            alarmManager.cancel(PendingIntent.getBroadcast(context, 0, new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), com.google.android.gms.internal.measurement.zzcg.f36824a));
        }
        l().c();
        m();
    }

    public final zzay l() {
        if (this.f39549e == null) {
            this.f39549e = new zzoi(this, this.f39551b.f39605l);
        }
        return this.f39549e;
    }

    public final void m() {
        JobScheduler jobScheduler = (JobScheduler) this.f39180a.f39084a.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(n());
        }
    }

    public final int n() {
        if (this.f39550f == null) {
            this.f39550f = Integer.valueOf("measurement".concat(String.valueOf(this.f39180a.f39084a.getPackageName())).hashCode());
        }
        return this.f39550f.intValue();
    }
}
