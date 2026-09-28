package com.google.android.gms.internal.pal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
final class zzdl implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final Application f37619a;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f37620b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f37621c = false;

    public zzdl(Application application, zzeb zzebVar) {
        this.f37620b = new WeakReference(zzebVar);
        this.f37619a = application;
    }

    public final void a(zzdk zzdkVar) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.f37620b.get();
            if (activityLifecycleCallbacks != null) {
                zzdkVar.zza(activityLifecycleCallbacks);
            } else {
                if (this.f37621c) {
                    return;
                }
                this.f37619a.unregisterActivityLifecycleCallbacks(this);
                this.f37621c = true;
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(new zzdd(activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        a(new zzdj(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(new zzdg(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(new zzdf(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        a(new zzdi(activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(new zzde(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a(new zzdh(activity));
    }
}
