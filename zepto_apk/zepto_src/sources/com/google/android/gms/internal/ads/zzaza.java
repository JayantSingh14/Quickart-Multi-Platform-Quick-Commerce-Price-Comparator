package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes4.dex */
final class zzaza implements zzazh {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f24525a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f24526b;

    public zzaza(zzazi zzaziVar, Activity activity, Bundle bundle) {
        this.f24525a = activity;
        this.f24526b = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzazh
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.f24525a, this.f24526b);
    }
}
