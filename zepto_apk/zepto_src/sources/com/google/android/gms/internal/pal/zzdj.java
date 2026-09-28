package com.google.android.gms.internal.pal;

import android.app.Activity;
import android.app.Application;

/* loaded from: classes4.dex */
final class zzdj implements zzdk {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f37618a;

    public zzdj(Activity activity) {
        this.f37618a = activity;
    }

    @Override // com.google.android.gms.internal.pal.zzdk
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityDestroyed(this.f37618a);
    }
}
