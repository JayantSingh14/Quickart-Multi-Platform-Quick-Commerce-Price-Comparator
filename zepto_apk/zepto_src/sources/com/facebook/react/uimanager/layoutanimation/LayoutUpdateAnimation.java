package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class LayoutUpdateAnimation extends AbstractLayoutAnimation {

    @Metadata
    public static final class Companion {
    }

    @Override // com.facebook.react.uimanager.layoutanimation.AbstractLayoutAnimation
    public final Animation b(View view, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(view, "view");
        boolean z = true;
        boolean z2 = (((int) view.getX()) == i2 && ((int) view.getY()) == i3) ? false : true;
        if (view.getWidth() == i4 && view.getHeight() == i5) {
            z = false;
        }
        if (z2 || z) {
            return new PositionAndSizeAnimation(view, i2, i3, i4, i5);
        }
        return null;
    }

    @Override // com.facebook.react.uimanager.layoutanimation.AbstractLayoutAnimation
    public final boolean d() {
        return this.f19792d > 0;
    }
}
