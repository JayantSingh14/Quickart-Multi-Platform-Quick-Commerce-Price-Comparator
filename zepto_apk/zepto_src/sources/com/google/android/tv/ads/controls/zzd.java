package com.google.android.tv.ads.controls;

import android.animation.AnimatorSet;
import androidx.activity.OnBackPressedCallback;

/* loaded from: classes4.dex */
final class zzd extends OnBackPressedCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnimatorSet f42213a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzd(AnimatorSet animatorSet) {
        super(true);
        this.f42213a = animatorSet;
    }

    @Override // androidx.activity.OnBackPressedCallback
    public final void handleOnBackPressed() {
        this.f42213a.start();
    }
}
