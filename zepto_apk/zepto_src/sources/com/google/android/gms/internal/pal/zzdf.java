package com.google.android.gms.internal.pal;

import android.app.Activity;
import android.app.Application;

/* loaded from: classes4.dex */
final class zzdf implements zzdk {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f37613a;

    public zzdf(Activity activity) {
        this.f37613a = activity;
    }

    @Override // com.google.android.gms.internal.pal.zzdk
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityResumed(this.f37613a);
    }
}
