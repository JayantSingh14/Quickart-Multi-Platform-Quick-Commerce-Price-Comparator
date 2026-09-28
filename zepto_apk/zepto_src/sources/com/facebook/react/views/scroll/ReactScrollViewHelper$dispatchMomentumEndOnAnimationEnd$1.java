package com.facebook.react.views.scroll;

import android.animation.Animator;
import android.widget.FrameLayout;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ReactScrollViewHelper$dispatchMomentumEndOnAnimationEnd$1 implements Animator.AnimatorListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f20070a;

    public ReactScrollViewHelper$dispatchMomentumEndOnAnimationEnd$1(FrameLayout frameLayout) {
        this.f20070a = frameLayout;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        FrameLayout frameLayout = this.f20070a;
        CopyOnWriteArrayList copyOnWriteArrayList = ReactScrollViewHelper.f20059a;
        ReactScrollViewHelper.c(frameLayout, ScrollEventType.f20088f, 0.0f, 0.0f);
        animator.removeListener(this);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        FrameLayout frameLayout = this.f20070a;
        CopyOnWriteArrayList copyOnWriteArrayList = ReactScrollViewHelper.f20059a;
        ReactScrollViewHelper.c(frameLayout, ScrollEventType.f20088f, 0.0f, 0.0f);
        animator.removeListener(this);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
    }
}
