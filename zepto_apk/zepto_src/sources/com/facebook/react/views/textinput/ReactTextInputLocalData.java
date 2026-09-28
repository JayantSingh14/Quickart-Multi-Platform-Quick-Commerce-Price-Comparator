package com.facebook.react.views.textinput;

import android.text.SpannableStringBuilder;

/* loaded from: classes.dex */
public final class ReactTextInputLocalData {

    /* renamed from: a, reason: collision with root package name */
    public final SpannableStringBuilder f20199a;

    /* renamed from: b, reason: collision with root package name */
    public final float f20200b;

    /* renamed from: c, reason: collision with root package name */
    public final int f20201c;

    /* renamed from: d, reason: collision with root package name */
    public final int f20202d;

    /* renamed from: e, reason: collision with root package name */
    public final int f20203e;

    /* renamed from: f, reason: collision with root package name */
    public final int f20204f;

    /* renamed from: g, reason: collision with root package name */
    public final CharSequence f20205g;

    public ReactTextInputLocalData(ReactEditText reactEditText) {
        this.f20199a = new SpannableStringBuilder(reactEditText.getText());
        this.f20200b = reactEditText.getTextSize();
        this.f20203e = reactEditText.getInputType();
        this.f20205g = reactEditText.getHint();
        this.f20201c = reactEditText.getMinLines();
        this.f20202d = reactEditText.getMaxLines();
        this.f20204f = reactEditText.getBreakStrategy();
    }
}
