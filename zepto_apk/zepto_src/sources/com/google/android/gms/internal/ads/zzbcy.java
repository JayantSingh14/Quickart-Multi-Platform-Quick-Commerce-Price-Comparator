package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
final class zzbcy implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final Application f24733a;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f24734b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f24735c = false;

    public zzbcy(Application application, zzbcm zzbcmVar) {
        this.f24734b = new WeakReference(zzbcmVar);
        this.f24733a = application;
    }

    public final void a(zzbcx zzbcxVar) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.f24734b.get();
            if (activityLifecycleCallbacks != null) {
                zzbcxVar.zza(activityLifecycleCallbacks);
            } else {
                if (this.f24735c) {
                    return;
                }
                this.f24733a.unregisterActivityLifecycleCallbacks(this);
                this.f24735c = true;
            }
        } catch (Exception e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error while dispatching lifecycle callback.", e2);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(new zzbcq(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        a(new zzbcw(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(new zzbct(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(new zzbcs(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        a(new zzbcv(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(new zzbcr(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a(new zzbcu(this, activity));
    }
}
