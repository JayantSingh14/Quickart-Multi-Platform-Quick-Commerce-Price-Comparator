package com.google.android.material.resources;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;

@RestrictTo
/* loaded from: classes4.dex */
public final class CancelableFontCallback extends TextAppearanceFontCallback {

    /* renamed from: a, reason: collision with root package name */
    public final Typeface f40865a;

    /* renamed from: b, reason: collision with root package name */
    public final ApplyFont f40866b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f40867c;

    public interface ApplyFont {
        void a(Typeface typeface);
    }

    public CancelableFontCallback(ApplyFont applyFont, Typeface typeface) {
        this.f40865a = typeface;
        this.f40866b = applyFont;
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public final void a(int i2) {
        if (this.f40867c) {
            return;
        }
        this.f40866b.a(this.f40865a);
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public final void b(Typeface typeface, boolean z) {
        if (this.f40867c) {
            return;
        }
        this.f40866b.a(typeface);
    }
}
