package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.install.InstallException;
import com.sudoplz.rninappupdates.SpReactNativeInAppUpdatesModule;

/* loaded from: classes.dex */
final class zzg implements AppUpdateManager {

    /* renamed from: a, reason: collision with root package name */
    public final zzr f41716a;

    /* renamed from: b, reason: collision with root package name */
    public final zzc f41717b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f41718c;

    public zzg(zzr zzrVar, zzc zzcVar, Context context) {
        new Handler(Looper.getMainLooper());
        this.f41716a = zzrVar;
        this.f41717b = zzcVar;
        this.f41718c = context;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final synchronized void a(SpReactNativeInAppUpdatesModule spReactNativeInAppUpdatesModule) {
        zzc zzcVar = this.f41717b;
        synchronized (zzcVar) {
            zzcVar.f41682a.c("registerListener", new Object[0]);
            zzcVar.f41685d.add(spReactNativeInAppUpdatesModule);
            zzcVar.b();
        }
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final Task b() {
        String packageName = this.f41718c.getPackageName();
        zzr zzrVar = this.f41716a;
        com.google.android.play.core.appupdate.internal.zzx zzxVar = zzrVar.f41738a;
        if (zzxVar != null) {
            zzr.f41736e.c("completeUpdate(%s)", packageName);
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            zzxVar.c(new zzn(taskCompletionSource, taskCompletionSource, zzrVar, packageName), taskCompletionSource);
            return taskCompletionSource.f39750a;
        }
        Object[] objArr = {-9};
        com.google.android.play.core.appupdate.internal.zzm zzmVar = zzr.f41736e;
        zzmVar.getClass();
        if (Log.isLoggable("PlayCore", 6)) {
            Log.e("PlayCore", com.google.android.play.core.appupdate.internal.zzm.d(zzmVar.f41687a, "onError(%d)", objArr));
        }
        return Tasks.d(new InstallException(-9));
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final Task c() {
        String packageName = this.f41718c.getPackageName();
        zzr zzrVar = this.f41716a;
        com.google.android.play.core.appupdate.internal.zzx zzxVar = zzrVar.f41738a;
        if (zzxVar != null) {
            zzr.f41736e.c("requestUpdateInfo(%s)", packageName);
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            zzxVar.c(new zzm(taskCompletionSource, taskCompletionSource, zzrVar, packageName), taskCompletionSource);
            return taskCompletionSource.f39750a;
        }
        Object[] objArr = {-9};
        com.google.android.play.core.appupdate.internal.zzm zzmVar = zzr.f41736e;
        zzmVar.getClass();
        if (Log.isLoggable("PlayCore", 6)) {
            Log.e("PlayCore", com.google.android.play.core.appupdate.internal.zzm.d(zzmVar.f41687a, "onError(%d)", objArr));
        }
        return Tasks.d(new InstallException(-9));
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final boolean d(AppUpdateInfo appUpdateInfo, int i2, Activity activity, int i3) throws IntentSender.SendIntentException {
        AppUpdateOptions appUpdateOptionsC = AppUpdateOptions.c(i2);
        if (activity == null) {
            return false;
        }
        zzf zzfVar = new zzf(activity);
        if (appUpdateInfo.a(appUpdateOptionsC) == null || appUpdateInfo.f41672m) {
            return false;
        }
        appUpdateInfo.f41672m = true;
        zzfVar.a(appUpdateInfo.a(appUpdateOptionsC).getIntentSender(), i3);
        return true;
    }
}
