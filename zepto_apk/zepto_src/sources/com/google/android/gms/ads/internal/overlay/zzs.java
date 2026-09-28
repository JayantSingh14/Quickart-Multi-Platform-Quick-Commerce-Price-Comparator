package com.google.android.gms.ads.internal.overlay;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzs extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzu f21383a;

    public zzs(zzu zzuVar) {
        Objects.requireNonNull(zzuVar);
        this.f21383a = zzuVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        zzu zzuVar = this.f21383a;
        zzuVar.setEnabled(true);
        zzuVar.f21388a.setEnabled(true);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        zzu zzuVar = this.f21383a;
        zzuVar.setEnabled(true);
        zzuVar.f21388a.setEnabled(true);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        zzu zzuVar = this.f21383a;
        zzuVar.setEnabled(false);
        zzuVar.f21388a.setEnabled(false);
    }
}
