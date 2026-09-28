package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: classes4.dex */
final class zad implements zah {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f22309a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LayoutInflater f22310b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f22311c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Bundle f22312d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ DeferredLifecycleHelper f22313e;

    public zad(DeferredLifecycleHelper deferredLifecycleHelper, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f22313e = deferredLifecycleHelper;
        this.f22309a = frameLayout;
        this.f22310b = layoutInflater;
        this.f22311c = viewGroup;
        this.f22312d = bundle;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final int zaa() {
        return 2;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final void zab() {
        FrameLayout frameLayout = this.f22309a;
        frameLayout.removeAllViews();
        frameLayout.addView(this.f22313e.f22295a.V(this.f22310b, this.f22311c, this.f22312d));
    }
}
