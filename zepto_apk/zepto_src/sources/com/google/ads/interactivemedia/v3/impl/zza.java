package com.google.ads.interactivemedia.v3.impl;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.ads.interactivemedia.v3.impl.JavaScriptMessage;

@VisibleForTesting
/* loaded from: classes3.dex */
final class zza implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ zzb zza;

    public zza(zzb zzbVar) {
        this.zza = zzbVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, @Nullable Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzb zzbVar = this.zza;
        if (zzbVar.zze == activity) {
            zzbVar.zze = null;
            this.zza.zzk();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zzb zzbVar = this.zza;
        if (zzbVar.zze == null || zzbVar.zze == activity) {
            zzbVar.zze = activity;
            zzb zzbVar2 = this.zza;
            zzbVar2.zza.zzp(new JavaScriptMessage(JavaScriptMessage.MsgChannel.activityMonitor, JavaScriptMessage.MsgType.appStateChanged, zzbVar2.zzb, zzbVar2.zzc("", "", "inactive")));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zzb zzbVar = this.zza;
        if (zzbVar.zze == activity) {
            zzbVar.zza.zzp(new JavaScriptMessage(JavaScriptMessage.MsgChannel.activityMonitor, JavaScriptMessage.MsgType.appStateChanged, zzbVar.zzb, zzbVar.zzc("", "", AppStateModule.APP_STATE_ACTIVE)));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
