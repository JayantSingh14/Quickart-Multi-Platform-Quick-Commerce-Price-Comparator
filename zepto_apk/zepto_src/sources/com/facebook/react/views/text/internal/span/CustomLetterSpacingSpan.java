package com.facebook.react.views.text.internal.span;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class CustomLetterSpacingSpan extends MetricAffectingSpan implements ReactSpan {

    /* renamed from: a, reason: collision with root package name */
    public final float f20157a;

    public CustomLetterSpacingSpan(float f2) {
        this.f20157a = f2;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        float f2 = this.f20157a;
        if (Float.isNaN(f2)) {
            return;
        }
        paint.setLetterSpacing(f2);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        float f2 = this.f20157a;
        if (Float.isNaN(f2)) {
            return;
        }
        paint.setLetterSpacing(f2);
    }
}
