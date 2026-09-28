package com.google.android.material.motion;

import android.animation.ValueAnimator;
import android.view.Window;
import androidx.core.graphics.ColorUtils;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.navigation.DrawerLayoutUtils;
import com.zeptoconsumerapp.gamification.scratchcard.ScratchRevealView;
import com.zeptoconsumerapp.slotmachine.SlotMachineView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f40695a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f40696b;

    public /* synthetic */ b(Object obj, int i2) {
        this.f40695a = i2;
        this.f40696b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator animator) {
        Object obj = this.f40696b;
        switch (this.f40695a) {
            case 0:
                ((ClippableRoundedCornerLayout) obj).a(r3.getLeft(), r3.getTop(), r3.getRight(), r3.getBottom(), ((Float) animator.getAnimatedValue()).floatValue());
                break;
            case 1:
                int i2 = DrawerLayoutUtils.f40697a;
                ((DrawerLayout) obj).setScrimColor(ColorUtils.k(-1728053248, AnimationUtils.c(animator.getAnimatedFraction(), DrawerLayoutUtils.f40697a, 0)));
                break;
            case 2:
                Intrinsics.checkNotNullParameter(animator, "animator");
                Object animatedValue = animator.getAnimatedValue();
                Intrinsics.d(animatedValue, "null cannot be cast to non-null type kotlin.Int");
                ((Window) obj).setStatusBarColor(((Integer) animatedValue).intValue());
                break;
            case 3:
                int i3 = ScratchRevealView.f47600l;
                Intrinsics.checkNotNullParameter(animator, "animator");
                Object animatedValue2 = animator.getAnimatedValue();
                Intrinsics.d(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
                ScratchRevealView scratchRevealView = (ScratchRevealView) obj;
                scratchRevealView.f47605e = ((Float) animatedValue2).floatValue();
                scratchRevealView.invalidate();
                break;
            default:
                int i4 = SlotMachineView.x;
                Intrinsics.checkNotNullParameter(animator, "animation");
                Object animatedValue3 = animator.getAnimatedValue();
                Intrinsics.d(animatedValue3, "null cannot be cast to non-null type kotlin.Float");
                SlotMachineView slotMachineView = (SlotMachineView) obj;
                slotMachineView.f47820e = ((Float) animatedValue3).floatValue();
                slotMachineView.invalidate();
                break;
        }
    }
}
