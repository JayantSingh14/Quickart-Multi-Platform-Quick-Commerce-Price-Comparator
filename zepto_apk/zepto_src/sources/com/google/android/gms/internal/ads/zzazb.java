package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* loaded from: classes4.dex */
final class zzazb implements zzazh {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f24527a;

    public zzazb(zzazi zzaziVar, Activity activity) {
        this.f24527a = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzazh
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStarted(this.f24527a);
    }
}
