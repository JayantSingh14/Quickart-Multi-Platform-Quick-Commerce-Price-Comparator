package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.SingleRequest;

@Deprecated
/* loaded from: classes3.dex */
public abstract class BaseTarget<Z> implements Target<Z> {

    /* renamed from: a, reason: collision with root package name */
    public SingleRequest f16477a;

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void e() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void f(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public Request getRequest() {
        return this.f16477a;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void i() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void j(SingleRequest singleRequest) {
        this.f16477a = singleRequest;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void d() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void k() {
    }
}
