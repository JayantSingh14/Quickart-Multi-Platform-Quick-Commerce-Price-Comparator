package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.R;

@RestrictTo
/* loaded from: classes4.dex */
public class TextAppearance {

    /* renamed from: a, reason: collision with root package name */
    public final ColorStateList f40868a;

    /* renamed from: b, reason: collision with root package name */
    public final String f40869b;

    /* renamed from: c, reason: collision with root package name */
    public final int f40870c;

    /* renamed from: d, reason: collision with root package name */
    public final int f40871d;

    /* renamed from: e, reason: collision with root package name */
    public final float f40872e;

    /* renamed from: f, reason: collision with root package name */
    public final float f40873f;

    /* renamed from: g, reason: collision with root package name */
    public final float f40874g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f40875h;

    /* renamed from: i, reason: collision with root package name */
    public final float f40876i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f40877j;

    /* renamed from: k, reason: collision with root package name */
    public float f40878k;

    /* renamed from: l, reason: collision with root package name */
    public final int f40879l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f40880m = false;
    public Typeface n;

    public TextAppearance(Context context, int i2) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i2, R.styleable.TextAppearance);
        this.f40878k = typedArrayObtainStyledAttributes.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f);
        this.f40877j = MaterialResources.a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_textColor);
        MaterialResources.a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_textColorHint);
        MaterialResources.a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_textColorLink);
        this.f40870c = typedArrayObtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.f40871d = typedArrayObtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int i3 = R.styleable.TextAppearance_fontFamily;
        i3 = typedArrayObtainStyledAttributes.hasValue(i3) ? i3 : R.styleable.TextAppearance_android_fontFamily;
        this.f40879l = typedArrayObtainStyledAttributes.getResourceId(i3, 0);
        this.f40869b = typedArrayObtainStyledAttributes.getString(i3);
        typedArrayObtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.f40868a = MaterialResources.a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_shadowColor);
        this.f40872e = typedArrayObtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f40873f = typedArrayObtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f40874g = typedArrayObtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i2, R.styleable.MaterialTextAppearance);
        this.f40875h = typedArrayObtainStyledAttributes2.hasValue(R.styleable.MaterialTextAppearance_android_letterSpacing);
        this.f40876i = typedArrayObtainStyledAttributes2.getFloat(R.styleable.MaterialTextAppearance_android_letterSpacing, 0.0f);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final void a() {
        String str;
        Typeface typeface = this.n;
        int i2 = this.f40870c;
        if (typeface == null && (str = this.f40869b) != null) {
            this.n = Typeface.create(str, i2);
        }
        if (this.n == null) {
            int i3 = this.f40871d;
            if (i3 == 1) {
                this.n = Typeface.SANS_SERIF;
            } else if (i3 == 2) {
                this.n = Typeface.SERIF;
            } else if (i3 != 3) {
                this.n = Typeface.DEFAULT;
            } else {
                this.n = Typeface.MONOSPACE;
            }
            this.n = Typeface.create(this.n, i2);
        }
    }

    public final Typeface b(Context context) {
        if (this.f40880m) {
            return this.n;
        }
        if (!context.isRestricted()) {
            try {
                Typeface typefaceE = ResourcesCompat.e(this.f40879l, context);
                this.n = typefaceE;
                if (typefaceE != null) {
                    this.n = Typeface.create(typefaceE, this.f40870c);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e2) {
                Log.d("TextAppearance", "Error loading font " + this.f40869b, e2);
            }
        }
        a();
        this.f40880m = true;
        return this.n;
    }

    public final void c(Context context, final TextAppearanceFontCallback textAppearanceFontCallback) {
        if (d(context)) {
            b(context);
        } else {
            a();
        }
        int i2 = this.f40879l;
        if (i2 == 0) {
            this.f40880m = true;
        }
        if (this.f40880m) {
            textAppearanceFontCallback.b(this.n, true);
            return;
        }
        try {
            ResourcesCompat.FontCallback fontCallback = new ResourcesCompat.FontCallback() { // from class: com.google.android.material.resources.TextAppearance.1
                @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                public final void b(int i3) {
                    TextAppearance.this.f40880m = true;
                    textAppearanceFontCallback.a(i3);
                }

                @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                public final void c(Typeface typeface) {
                    TextAppearance textAppearance = TextAppearance.this;
                    textAppearance.n = Typeface.create(typeface, textAppearance.f40870c);
                    textAppearance.f40880m = true;
                    textAppearanceFontCallback.b(textAppearance.n, false);
                }
            };
            ThreadLocal threadLocal = ResourcesCompat.f2764a;
            if (context.isRestricted()) {
                fontCallback.a(-4);
            } else {
                ResourcesCompat.f(context, i2, new TypedValue(), 0, fontCallback, false, false);
            }
        } catch (Resources.NotFoundException unused) {
            this.f40880m = true;
            textAppearanceFontCallback.a(1);
        } catch (Exception e2) {
            Log.d("TextAppearance", "Error loading font " + this.f40869b, e2);
            this.f40880m = true;
            textAppearanceFontCallback.a(-3);
        }
    }

    public final boolean d(Context context) throws Resources.NotFoundException {
        Typeface typefaceF = null;
        int i2 = this.f40879l;
        if (i2 != 0) {
            ThreadLocal threadLocal = ResourcesCompat.f2764a;
            if (!context.isRestricted()) {
                typefaceF = ResourcesCompat.f(context, i2, new TypedValue(), 0, null, false, true);
            }
        }
        return typefaceF != null;
    }

    public final void e(Context context, TextPaint textPaint, TextAppearanceFontCallback textAppearanceFontCallback) {
        f(context, textPaint, textAppearanceFontCallback);
        ColorStateList colorStateList = this.f40877j;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        ColorStateList colorStateList2 = this.f40868a;
        textPaint.setShadowLayer(this.f40874g, this.f40872e, this.f40873f, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public final void f(final Context context, final TextPaint textPaint, final TextAppearanceFontCallback textAppearanceFontCallback) {
        if (d(context)) {
            g(context, textPaint, b(context));
            return;
        }
        a();
        g(context, textPaint, this.n);
        c(context, new TextAppearanceFontCallback() { // from class: com.google.android.material.resources.TextAppearance.2
            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public final void a(int i2) {
                textAppearanceFontCallback.a(i2);
            }

            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public final void b(Typeface typeface, boolean z) {
                TextAppearance.this.g(context, textPaint, typeface);
                textAppearanceFontCallback.b(typeface, z);
            }
        });
    }

    public final void g(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceA = TypefaceUtils.a(context.getResources().getConfiguration(), typeface);
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        textPaint.setTypeface(typeface);
        int i2 = (~typeface.getStyle()) & this.f40870c;
        textPaint.setFakeBoldText((i2 & 1) != 0);
        textPaint.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f40878k);
        if (this.f40875h) {
            textPaint.setLetterSpacing(this.f40876i);
        }
    }
}
