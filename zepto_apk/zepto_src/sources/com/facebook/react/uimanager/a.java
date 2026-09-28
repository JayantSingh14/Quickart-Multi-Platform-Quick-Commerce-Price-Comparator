package com.facebook.react.uimanager;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.drawable.ColorStateListDrawable;
import android.graphics.drawable.Drawable;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ BlendModeColorFilter e(int i2) {
        return new BlendModeColorFilter(i2, BlendMode.SRC_IN);
    }

    public static /* bridge */ /* synthetic */ ColorStateListDrawable f(Drawable drawable) {
        return (ColorStateListDrawable) drawable;
    }

    public static /* synthetic */ void h() {
    }

    public static /* bridge */ /* synthetic */ boolean l(Drawable drawable) {
        return drawable instanceof ColorStateListDrawable;
    }
}
