package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* loaded from: classes4.dex */
final class zzazd implements zzazh {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f24529a;

    public zzazd(zzazi zzaziVar, Activity activity) {
        this.f24529a = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzazh
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityPaused(this.f24529a);
    }
}
