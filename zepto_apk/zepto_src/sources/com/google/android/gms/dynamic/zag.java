package com.google.android.gms.dynamic;

/* loaded from: classes4.dex */
final class zag implements zah {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeferredLifecycleHelper f22317a;

    public zag(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.f22317a = deferredLifecycleHelper;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final int zaa() {
        return 5;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final void zab() {
        this.f22317a.f22295a.onResume();
    }
}
