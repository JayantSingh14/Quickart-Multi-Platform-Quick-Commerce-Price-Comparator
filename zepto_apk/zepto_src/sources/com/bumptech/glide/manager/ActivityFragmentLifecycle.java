package com.bumptech.glide.manager;

import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ActivityFragmentLifecycle implements Lifecycle {

    /* renamed from: a, reason: collision with root package name */
    public final Set f16398a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    public boolean f16399b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16400c;

    @Override // com.bumptech.glide.manager.Lifecycle
    public final void a(LifecycleListener lifecycleListener) {
        this.f16398a.remove(lifecycleListener);
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public final void b(LifecycleListener lifecycleListener) {
        this.f16398a.add(lifecycleListener);
        if (this.f16400c) {
            lifecycleListener.onDestroy();
        } else if (this.f16399b) {
            lifecycleListener.i();
        } else {
            lifecycleListener.e();
        }
    }

    public final void c() {
        this.f16399b = true;
        Iterator it = Util.d(this.f16398a).iterator();
        while (it.hasNext()) {
            ((LifecycleListener) it.next()).i();
        }
    }
}
