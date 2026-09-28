package com.google.android.gms.internal.pal;

import android.app.Activity;
import android.app.Application;

/* loaded from: classes4.dex */
final class zzdg implements zzdk {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f37614a;

    public zzdg(Activity activity) {
        this.f37614a = activity;
    }

    @Override // com.google.android.gms.internal.pal.zzdk
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityPaused(this.f37614a);
    }
}
