package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* loaded from: classes4.dex */
final class zzaze implements zzazh {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f24530a;

    public zzaze(zzazi zzaziVar, Activity activity) {
        this.f24530a = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzazh
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStopped(this.f24530a);
    }
}
