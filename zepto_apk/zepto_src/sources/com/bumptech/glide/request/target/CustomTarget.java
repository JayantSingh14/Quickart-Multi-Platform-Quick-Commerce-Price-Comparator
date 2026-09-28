package com.bumptech.glide.request.target;

import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.util.Util;

/* loaded from: classes3.dex */
public abstract class CustomTarget<T> implements Target<T> {

    /* renamed from: a, reason: collision with root package name */
    public final int f16478a;

    /* renamed from: b, reason: collision with root package name */
    public final int f16479b;

    /* renamed from: c, reason: collision with root package name */
    public SingleRequest f16480c;

    public CustomTarget() {
        if (!Util.h(Integer.MIN_VALUE, Integer.MIN_VALUE)) {
            throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: -2147483648 and height: -2147483648");
        }
        this.f16478a = Integer.MIN_VALUE;
        this.f16479b = Integer.MIN_VALUE;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void c(SingleRequest singleRequest) throws Throwable {
        singleRequest.a(this.f16478a, this.f16479b);
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final void e() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final Request getRequest() {
        return this.f16480c;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final void i() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void j(SingleRequest singleRequest) {
        this.f16480c = singleRequest;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void d() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void k() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void a(SingleRequest singleRequest) {
    }
}
