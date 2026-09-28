package com.bumptech.glide.request.transition;

import com.bumptech.glide.request.target.ImageViewTarget;

/* loaded from: classes3.dex */
public class NoTransition<R> implements Transition<R> {

    /* renamed from: a, reason: collision with root package name */
    public static final NoTransition f16500a = new NoTransition();

    /* renamed from: b, reason: collision with root package name */
    public static final NoAnimationFactory f16501b = new NoAnimationFactory();

    public static class NoAnimationFactory<R> implements TransitionFactory<R> {
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public final boolean a(Object obj, ImageViewTarget imageViewTarget) {
        return false;
    }
}
