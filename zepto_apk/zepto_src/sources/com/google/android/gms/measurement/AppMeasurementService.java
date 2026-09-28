package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzjc;
import com.google.android.gms.measurement.internal.zzno;
import com.google.android.gms.measurement.internal.zzns;
import com.google.android.gms.measurement.internal.zzpf;

/* loaded from: classes.dex */
public final class AppMeasurementService extends Service implements zzno {

    /* renamed from: a, reason: collision with root package name */
    public zzns f38651a;

    @Override // com.google.android.gms.measurement.internal.zzno
    public final void a(Intent intent) {
        WakefulBroadcastReceiver.a(intent);
    }

    @Override // com.google.android.gms.measurement.internal.zzno
    public final void b(JobParameters jobParameters) {
        throw new UnsupportedOperationException();
    }

    public final zzns c() {
        if (this.f38651a == null) {
            this.f38651a = new zzns(this);
        }
        return this.f38651a;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        zzns zznsVarC = c();
        zznsVarC.getClass();
        if (intent == null) {
            Log.e("FA", "onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzjc(zzpf.B(zznsVarC.f39513a));
        }
        Log.w("FA", "onBind received unknown action: ".concat(String.valueOf(action)));
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        Log.v("FA", c().f39513a.getClass().getSimpleName().concat(" is starting up."));
    }

    @Override // android.app.Service
    public final void onDestroy() {
        Log.v("FA", c().f39513a.getClass().getSimpleName().concat(" is shutting down."));
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        c();
        if (intent == null) {
            Log.e("FA", "onRebind called with null intent");
        } else {
            Log.v("FA", "onRebind called. action: ".concat(String.valueOf(intent.getAction())));
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        c().a(intent, i3);
        return 2;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        c();
        if (intent == null) {
            Log.e("FA", "onUnbind called with null intent");
            return true;
        }
        Log.v("FA", "onUnbind called for intent. action: ".concat(String.valueOf(intent.getAction())));
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzno
    public final boolean zza(int i2) {
        return stopSelfResult(i2);
    }
}
