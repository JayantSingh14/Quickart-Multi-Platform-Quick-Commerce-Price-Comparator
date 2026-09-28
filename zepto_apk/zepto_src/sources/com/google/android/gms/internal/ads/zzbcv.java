package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes4.dex */
final class zzbcv implements zzbcx {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f24730a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f24731b;

    public zzbcv(zzbcy zzbcyVar, Activity activity, Bundle bundle) {
        this.f24730a = activity;
        this.f24731b = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzbcx
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.f24730a, this.f24731b);
    }
}
