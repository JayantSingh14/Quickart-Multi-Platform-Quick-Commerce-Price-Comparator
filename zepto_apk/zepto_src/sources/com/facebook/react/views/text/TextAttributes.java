package com.facebook.react.views.text;

import com.facebook.react.uimanager.PixelUtil;

/* loaded from: classes.dex */
public class TextAttributes {

    /* renamed from: a, reason: collision with root package name */
    public boolean f20128a = true;

    /* renamed from: b, reason: collision with root package name */
    public float f20129b = Float.NaN;

    /* renamed from: c, reason: collision with root package name */
    public float f20130c = Float.NaN;

    /* renamed from: d, reason: collision with root package name */
    public float f20131d = Float.NaN;

    /* renamed from: e, reason: collision with root package name */
    public float f20132e = Float.NaN;

    /* renamed from: f, reason: collision with root package name */
    public float f20133f = Float.NaN;

    /* renamed from: g, reason: collision with root package name */
    public TextTransform f20134g = TextTransform.f20142f;

    public final int a() {
        float f2 = !Float.isNaN(this.f20129b) ? this.f20129b : 14.0f;
        return (int) (this.f20128a ? Math.ceil(PixelUtil.c(f2, d())) : Math.ceil(PixelUtil.b(f2)));
    }

    public final float b() {
        if (Float.isNaN(this.f20131d)) {
            return Float.NaN;
        }
        return (this.f20128a ? PixelUtil.c(this.f20131d, d()) : PixelUtil.b(this.f20131d)) / a();
    }

    public final float c() {
        if (Float.isNaN(this.f20130c)) {
            return Float.NaN;
        }
        float fC = this.f20128a ? PixelUtil.c(this.f20130c, d()) : PixelUtil.b(this.f20130c);
        if (!Float.isNaN(this.f20133f)) {
            float f2 = this.f20133f;
            if (f2 > fC) {
                return f2;
            }
        }
        return fC;
    }

    public final float d() {
        if (Float.isNaN(this.f20132e)) {
            return 0.0f;
        }
        return this.f20132e;
    }

    public final String toString() {
        return "TextAttributes {\n  getAllowFontScaling(): " + this.f20128a + "\n  getFontSize(): " + this.f20129b + "\n  getEffectiveFontSize(): " + a() + "\n  getHeightOfTallestInlineViewOrImage(): " + this.f20133f + "\n  getLetterSpacing(): " + this.f20131d + "\n  getEffectiveLetterSpacing(): " + b() + "\n  getLineHeight(): " + this.f20130c + "\n  getEffectiveLineHeight(): " + c() + "\n  getTextTransform(): " + this.f20134g + "\n  getMaxFontSizeMultiplier(): " + this.f20132e + "\n  getEffectiveMaxFontSizeMultiplier(): " + d() + "\n}";
    }
}
