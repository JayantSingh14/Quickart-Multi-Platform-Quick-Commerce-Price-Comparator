package com.facebook.react.views.image;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ScaleTypeStartInside extends ScalingUtils.AbstractScaleType {

    /* renamed from: l, reason: collision with root package name */
    public static final ScaleTypeStartInside f19962l = new ScaleTypeStartInside();

    @Metadata
    public static final class Companion {
    }

    @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
    public final void b(Matrix outTransform, Rect parentRect, int i2, int i3, float f2, float f3, float f4, float f5) {
        Intrinsics.checkNotNullParameter(outTransform, "outTransform");
        Intrinsics.checkNotNullParameter(parentRect, "parentRect");
        float fMin = Math.min(f4, f5);
        if (fMin > 1.0f) {
            fMin = 1.0f;
        }
        float f6 = parentRect.left;
        float f7 = parentRect.top;
        outTransform.setScale(fMin, fMin);
        outTransform.postTranslate(Math.round(f6), Math.round(f7));
    }

    public final String toString() {
        return "start_inside";
    }
}
