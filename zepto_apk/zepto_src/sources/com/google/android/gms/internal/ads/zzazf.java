package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes4.dex */
final class zzazf implements zzazh {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f24531a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f24532b;

    public zzazf(zzazi zzaziVar, Activity activity, Bundle bundle) {
        this.f24531a = activity;
        this.f24532b = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzazh
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.f24531a, this.f24532b);
    }
}
