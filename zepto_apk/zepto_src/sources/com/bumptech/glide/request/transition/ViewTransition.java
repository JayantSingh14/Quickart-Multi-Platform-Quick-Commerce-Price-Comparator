package com.bumptech.glide.request.transition;

import com.bumptech.glide.request.target.ImageViewTarget;

/* loaded from: classes3.dex */
public class ViewTransition<R> implements Transition<R> {

    public interface ViewTransitionAnimationFactory {
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public final boolean a(Object obj, ImageViewTarget imageViewTarget) {
        return false;
    }
}
