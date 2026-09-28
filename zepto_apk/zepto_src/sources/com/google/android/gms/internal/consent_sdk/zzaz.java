package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.os.Bundle;

/* loaded from: classes4.dex */
final class zzaz implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final Activity f36512a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbc f36513b;

    public zzaz(zzbc zzbcVar, Activity activity) {
        this.f36513b = zzbcVar;
        this.f36512a = activity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Dialog dialog = this.f36513b.f36517a;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (activity != this.f36512a) {
            return;
        }
        boolean zIsChangingConfigurations = activity.isChangingConfigurations();
        zzbc zzbcVar = this.f36513b;
        if (zIsChangingConfigurations) {
            zzbcVar.getClass();
        }
        new zzg(3, "Activity is destroyed.");
        Dialog dialog = zzbcVar.f36517a;
        if (dialog != null) {
            dialog.dismiss();
            zzbcVar.f36517a = null;
        }
        throw null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
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
