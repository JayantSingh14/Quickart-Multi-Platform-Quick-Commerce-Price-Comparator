package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
final class zzazi implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final Application f24534a;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f24535b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f24536c = false;

    public zzazi(Application application, zzbaa zzbaaVar) {
        this.f24535b = new WeakReference(zzbaaVar);
        this.f24534a = application;
    }

    public final void a(zzazh zzazhVar) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.f24535b.get();
            if (activityLifecycleCallbacks != null) {
                zzazhVar.zza(activityLifecycleCallbacks);
            } else {
                if (this.f24536c) {
                    return;
                }
                this.f24534a.unregisterActivityLifecycleCallbacks(this);
                this.f24536c = true;
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(new zzaza(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        a(new zzazg(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(new zzazd(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(new zzazc(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        a(new zzazf(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(new zzazb(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a(new zzaze(this, activity));
    }
}
