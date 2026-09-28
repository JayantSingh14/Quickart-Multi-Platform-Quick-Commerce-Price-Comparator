package com.google.android.gms.internal.pal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes4.dex */
final class zzdd implements zzdk {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f37610a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f37611b;

    public zzdd(Activity activity, Bundle bundle) {
        this.f37610a = activity;
        this.f37611b = bundle;
    }

    @Override // com.google.android.gms.internal.pal.zzdk
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.f37610a, this.f37611b);
    }
}
