package com.google.android.gms.internal.pal;

import android.app.Activity;
import android.app.Application;

/* loaded from: classes4.dex */
final class zzdh implements zzdk {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f37615a;

    public zzdh(Activity activity) {
        this.f37615a = activity;
    }

    @Override // com.google.android.gms.internal.pal.zzdk
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStopped(this.f37615a);
    }
}
