package com.google.android.gms.dynamic;

import android.os.Bundle;

/* loaded from: classes4.dex */
final class zac implements zah {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bundle f22307a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DeferredLifecycleHelper f22308b;

    public zac(DeferredLifecycleHelper deferredLifecycleHelper, Bundle bundle) {
        this.f22308b = deferredLifecycleHelper;
        this.f22307a = bundle;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final int zaa() {
        return 1;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final void zab() {
        this.f22308b.f22295a.n(this.f22307a);
    }
}
