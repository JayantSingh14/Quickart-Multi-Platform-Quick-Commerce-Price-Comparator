package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes4.dex */
final class zzbcq implements zzbcx {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f24724a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f24725b;

    public zzbcq(zzbcy zzbcyVar, Activity activity, Bundle bundle) {
        this.f24724a = activity;
        this.f24725b = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzbcx
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.f24724a, this.f24725b);
    }
}
