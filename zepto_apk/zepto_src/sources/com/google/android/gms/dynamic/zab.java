package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;

/* loaded from: classes4.dex */
final class zab implements zah {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f22303a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f22304b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bundle f22305c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DeferredLifecycleHelper f22306d;

    public zab(DeferredLifecycleHelper deferredLifecycleHelper, Activity activity, Bundle bundle, Bundle bundle2) {
        this.f22306d = deferredLifecycleHelper;
        this.f22303a = activity;
        this.f22304b = bundle;
        this.f22305c = bundle2;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final int zaa() {
        return 0;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final void zab() {
        this.f22306d.f22295a.U(this.f22303a, this.f22304b, this.f22305c);
    }
}
