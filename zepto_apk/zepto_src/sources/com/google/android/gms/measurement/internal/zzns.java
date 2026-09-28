package com.google.android.gms.measurement.internal;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes.dex */
public final class zzns {

    /* renamed from: a, reason: collision with root package name */
    public final Service f39513a;

    public zzns(Service service) {
        Preconditions.checkNotNull(service);
        this.f39513a = service;
    }

    public final void a(final Intent intent, final int i2) {
        if (intent == null) {
            Log.w("FA", "AppMeasurementService started with null intent");
            return;
        }
        Service service = this.f39513a;
        final zzgt zzgtVar = zzib.r(service, null, null).f39089f;
        zzib.l(zzgtVar);
        String action = intent.getAction();
        zzgtVar.n.c("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Runnable runnable = new Runnable() { // from class: com.google.android.gms.measurement.internal.zznr
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public final void run() {
                    Service service2 = this.f39509a.f39513a;
                    zzno zznoVar = (zzno) service2;
                    int i3 = i2;
                    if (zznoVar.zza(i3)) {
                        zzgtVar.n.b(Integer.valueOf(i3), "Local AppMeasurementService processed last upload request. StartId");
                        zzgt zzgtVar2 = zzib.r(service2, null, null).f39089f;
                        zzib.l(zzgtVar2);
                        zzgtVar2.n.a("Completed wakeful intent.");
                        zznoVar.a(intent);
                    }
                }
            };
            zzpf zzpfVarB = zzpf.B(service);
            zzpfVarB.c().p(new zznn(this, zzpfVarB, runnable));
        }
    }

    public final void b(final JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("action");
        Log.v("FA", "onStartJob received action: ".concat(String.valueOf(string)));
        boolean zEquals = Objects.equals(string, "com.google.android.gms.measurement.UPLOAD");
        Service service = this.f39513a;
        if (zEquals) {
            String str = (String) Preconditions.checkNotNull(string);
            zzpf zzpfVarB = zzpf.B(service);
            final zzgt zzgtVarB = zzpfVarB.b();
            zzae zzaeVar = zzpfVarB.f39605l.f39086c;
            zzgtVarB.n.b(str, "Local AppMeasurementJobService called. action");
            zzpfVarB.c().p(new zznn(this, zzpfVarB, new Runnable() { // from class: com.google.android.gms.measurement.internal.zznp
                @Override // java.lang.Runnable
                public final void run() {
                    zzns zznsVar = this.f39504a;
                    zznsVar.getClass();
                    zzgtVarB.n.a("AppMeasurementJobService processed last upload request.");
                    ((zzno) zznsVar.f39513a).b(jobParameters);
                }
            }));
        }
        if (Objects.equals(string, "com.google.android.gms.measurement.SCION_UPLOAD")) {
            com.google.android.gms.internal.measurement.zzfb.m(service, null).B(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznq
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzns zznsVar = this.f39507a;
                    zznsVar.getClass();
                    Log.v("FA", "[sgtm] AppMeasurementJobService processed last Scion upload request.");
                    ((zzno) zznsVar.f39513a).b(jobParameters);
                }
            });
        }
    }
}
