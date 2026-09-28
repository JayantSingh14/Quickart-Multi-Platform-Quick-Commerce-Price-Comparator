package com.google.android.gms.dynamic;

import java.util.Iterator;

/* loaded from: classes4.dex */
final class zaa implements OnDelegateCreatedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeferredLifecycleHelper f22302a;

    public zaa(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.f22302a = deferredLifecycleHelper;
    }

    @Override // com.google.android.gms.dynamic.OnDelegateCreatedListener
    public final void a(LifecycleDelegate lifecycleDelegate) {
        DeferredLifecycleHelper deferredLifecycleHelper = this.f22302a;
        deferredLifecycleHelper.f22295a = lifecycleDelegate;
        Iterator it = deferredLifecycleHelper.f22297c.iterator();
        while (it.hasNext()) {
            ((zah) it.next()).zab();
        }
        deferredLifecycleHelper.f22297c.clear();
        deferredLifecycleHelper.f22296b = null;
    }
}
