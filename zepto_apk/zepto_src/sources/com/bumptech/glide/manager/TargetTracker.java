package com.bumptech.glide.manager;

import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public final class TargetTracker implements LifecycleListener {

    /* renamed from: a, reason: collision with root package name */
    public final Set f16423a = Collections.newSetFromMap(new WeakHashMap());

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final void e() {
        Iterator it = Util.d(this.f16423a).iterator();
        while (it.hasNext()) {
            ((Target) it.next()).e();
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final void i() {
        Iterator it = Util.d(this.f16423a).iterator();
        while (it.hasNext()) {
            ((Target) it.next()).i();
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final void onDestroy() {
        Iterator it = Util.d(this.f16423a).iterator();
        while (it.hasNext()) {
            ((Target) it.next()).onDestroy();
        }
    }
}
