package com.google.android.gms.internal.pal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes4.dex */
final class zzdi implements zzdk {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f37616a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f37617b;

    public zzdi(Activity activity, Bundle bundle) {
        this.f37616a = activity;
        this.f37617b = bundle;
    }

    @Override // com.google.android.gms.internal.pal.zzdk
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.f37616a, this.f37617b);
    }
}
