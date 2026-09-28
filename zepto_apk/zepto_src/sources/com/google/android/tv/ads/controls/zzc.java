package com.google.android.tv.ads.controls;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* loaded from: classes4.dex */
final class zzc extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SideDrawerFragment f42212a;

    public zzc(SideDrawerFragment sideDrawerFragment) {
        this.f42212a = sideDrawerFragment;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f42212a.requireActivity().finish();
    }
}
