package com.facebook.react.views.text.internal.span;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ShadowStyleSpan extends CharacterStyle implements ReactSpan {

    /* renamed from: a, reason: collision with root package name */
    public final float f20171a;

    /* renamed from: b, reason: collision with root package name */
    public final float f20172b;

    /* renamed from: c, reason: collision with root package name */
    public final float f20173c;

    /* renamed from: d, reason: collision with root package name */
    public final int f20174d;

    public ShadowStyleSpan(float f2, float f3, float f4, int i2) {
        this.f20171a = f2;
        this.f20172b = f3;
        this.f20173c = f4;
        this.f20174d = i2;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        textPaint.setShadowLayer(this.f20173c, this.f20171a, this.f20172b, this.f20174d);
    }
}
