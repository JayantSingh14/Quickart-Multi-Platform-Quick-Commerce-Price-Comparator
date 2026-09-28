package com.google.android.material.internal;

import android.animation.TypeEvaluator;
import android.graphics.Rect;
import androidx.annotation.RestrictTo;

@RestrictTo
/* loaded from: classes4.dex */
public class RectEvaluator implements TypeEvaluator<Rect> {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f40610a;

    public RectEvaluator(Rect rect) {
        this.f40610a = rect;
    }

    @Override // android.animation.TypeEvaluator
    public final Rect evaluate(float f2, Rect rect, Rect rect2) {
        Rect rect3 = rect;
        Rect rect4 = rect2;
        int i2 = rect3.left + ((int) ((rect4.left - r0) * f2));
        int i3 = rect3.top + ((int) ((rect4.top - r1) * f2));
        int i4 = rect3.right + ((int) ((rect4.right - r2) * f2));
        int i5 = rect3.bottom + ((int) ((rect4.bottom - r6) * f2));
        Rect rect5 = this.f40610a;
        rect5.set(i2, i3, i4, i5);
        return rect5;
    }
}
