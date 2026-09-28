package com.facebook.react.views.text.internal.span;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class CustomLineHeightSpan implements LineHeightSpan, ReactSpan {

    /* renamed from: a, reason: collision with root package name */
    public final int f20158a;

    public CustomLineHeightSpan(float f2) {
        this.f20158a = (int) Math.ceil(f2);
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence text, int i2, int i3, int i4, int i5, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(fm, "fm");
        double d2 = (this.f20158a - ((-r8) + fm.descent)) / 2.0f;
        fm.ascent = fm.ascent - ((int) Math.ceil(d2));
        fm.descent += (int) Math.floor(d2);
        if (i2 == 0) {
            fm.top = fm.ascent;
        }
        if (i3 == text.length()) {
            fm.bottom = fm.descent;
        }
    }
}
