package com.swmansion.rnscreens.stack.anim;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.swmansion.rnscreens.ScreenFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class ScreensAnimation extends Animation {

    /* renamed from: a, reason: collision with root package name */
    public final ScreenFragment f47138a;

    public ScreensAnimation(ScreenFragment mFragment) {
        Intrinsics.checkNotNullParameter(mFragment, "mFragment");
        this.f47138a = mFragment;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f2, Transformation t) {
        Intrinsics.checkNotNullParameter(t, "t");
        super.applyTransformation(f2, t);
        this.f47138a.A(f2, !r3.isResumed());
    }
}
