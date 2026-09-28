package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes3.dex */
public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements Transition.ViewAdapter {

    /* renamed from: b, reason: collision with root package name */
    public Animatable f16496b;

    public abstract void b(Object obj);

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public final void d() {
        b(null);
        throw null;
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    public final void e() {
        Animatable animatable = this.f16496b;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public final void f(Drawable drawable) {
        throw null;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void g(Object obj, Transition transition) {
        if (transition == null || !transition.a(obj, this)) {
            b(obj);
            throw null;
        }
        if (!(obj instanceof Animatable)) {
            this.f16496b = null;
            return;
        }
        Animatable animatable = (Animatable) obj;
        this.f16496b = animatable;
        animatable.start();
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    public final void i() {
        Animatable animatable = this.f16496b;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public final void k() {
        b(null);
        throw null;
    }
}
