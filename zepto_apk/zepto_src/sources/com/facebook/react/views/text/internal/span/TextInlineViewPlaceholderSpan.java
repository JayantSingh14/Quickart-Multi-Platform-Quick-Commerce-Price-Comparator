package com.facebook.react.views.text.internal.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class TextInlineViewPlaceholderSpan extends ReplacementSpan implements ReactSpan {

    /* renamed from: a, reason: collision with root package name */
    public final int f20176a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20177b;

    /* renamed from: c, reason: collision with root package name */
    public final int f20178c;

    public TextInlineViewPlaceholderSpan(int i2, int i3, int i4) {
        this.f20176a = i2;
        this.f20177b = i3;
        this.f20178c = i4;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (fontMetricsInt != null) {
            int i4 = -this.f20178c;
            fontMetricsInt.ascent = i4;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = i4;
            fontMetricsInt.bottom = 0;
        }
        return this.f20177b;
    }
}
