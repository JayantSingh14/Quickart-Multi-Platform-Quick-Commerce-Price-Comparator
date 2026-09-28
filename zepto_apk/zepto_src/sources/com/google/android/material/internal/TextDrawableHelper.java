package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.RestrictTo;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import java.lang.ref.WeakReference;

@RestrictTo
/* loaded from: classes4.dex */
public class TextDrawableHelper {

    /* renamed from: c, reason: collision with root package name */
    public float f40642c;

    /* renamed from: d, reason: collision with root package name */
    public float f40643d;

    /* renamed from: f, reason: collision with root package name */
    public final WeakReference f40645f;

    /* renamed from: g, reason: collision with root package name */
    public TextAppearance f40646g;

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f40640a = new TextPaint(1);

    /* renamed from: b, reason: collision with root package name */
    public final TextAppearanceFontCallback f40641b = new TextAppearanceFontCallback() { // from class: com.google.android.material.internal.TextDrawableHelper.1
        @Override // com.google.android.material.resources.TextAppearanceFontCallback
        public final void a(int i2) {
            TextDrawableHelper textDrawableHelper = TextDrawableHelper.this;
            textDrawableHelper.f40644e = true;
            TextDrawableDelegate textDrawableDelegate = (TextDrawableDelegate) textDrawableHelper.f40645f.get();
            if (textDrawableDelegate != null) {
                textDrawableDelegate.a();
            }
        }

        @Override // com.google.android.material.resources.TextAppearanceFontCallback
        public final void b(Typeface typeface, boolean z) {
            if (z) {
                return;
            }
            TextDrawableHelper textDrawableHelper = TextDrawableHelper.this;
            textDrawableHelper.f40644e = true;
            TextDrawableDelegate textDrawableDelegate = (TextDrawableDelegate) textDrawableHelper.f40645f.get();
            if (textDrawableDelegate != null) {
                textDrawableDelegate.a();
            }
        }
    };

    /* renamed from: e, reason: collision with root package name */
    public boolean f40644e = true;

    public interface TextDrawableDelegate {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public TextDrawableHelper(TextDrawableDelegate textDrawableDelegate) {
        this.f40645f = new WeakReference(null);
        this.f40645f = new WeakReference(textDrawableDelegate);
    }

    public final float a(String str) {
        if (!this.f40644e) {
            return this.f40642c;
        }
        b(str);
        return this.f40642c;
    }

    public final void b(String str) {
        TextPaint textPaint = this.f40640a;
        this.f40642c = str == null ? 0.0f : textPaint.measureText((CharSequence) str, 0, str.length());
        this.f40643d = str != null ? Math.abs(textPaint.getFontMetrics().ascent) : 0.0f;
        this.f40644e = false;
    }

    public final void c(TextAppearance textAppearance, Context context) {
        if (this.f40646g != textAppearance) {
            this.f40646g = textAppearance;
            if (textAppearance != null) {
                TextPaint textPaint = this.f40640a;
                TextAppearanceFontCallback textAppearanceFontCallback = this.f40641b;
                textAppearance.f(context, textPaint, textAppearanceFontCallback);
                TextDrawableDelegate textDrawableDelegate = (TextDrawableDelegate) this.f40645f.get();
                if (textDrawableDelegate != null) {
                    textPaint.drawableState = textDrawableDelegate.getState();
                }
                textAppearance.e(context, textPaint, textAppearanceFontCallback);
                this.f40644e = true;
            }
            TextDrawableDelegate textDrawableDelegate2 = (TextDrawableDelegate) this.f40645f.get();
            if (textDrawableDelegate2 != null) {
                textDrawableDelegate2.a();
                textDrawableDelegate2.onStateChange(textDrawableDelegate2.getState());
            }
        }
    }
}
