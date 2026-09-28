package com.facebook.react.views.text.internal.span;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata
/* loaded from: classes3.dex */
public final class ReactOpacitySpan extends CharacterStyle implements UpdateAppearance, ReactSpan {

    /* renamed from: a, reason: collision with root package name */
    public final float f20165a;

    public ReactOpacitySpan(float f2) {
        this.f20165a = f2;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        float fAlpha = Color.alpha(paint.getColor());
        float f2 = this.f20165a;
        paint.setAlpha(MathKt.b(fAlpha * f2));
        if (paint.bgColor != 0) {
            paint.bgColor = Color.argb(MathKt.b(Color.alpha(r0) * f2), Color.red(paint.bgColor), Color.green(paint.bgColor), Color.blue(paint.bgColor));
        }
    }
}
