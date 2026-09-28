package com.facebook.drawee.drawable;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class DrawableUtils {
    public static final void a(Drawable drawable, Drawable drawable2) {
        if (drawable == null || drawable == drawable2) {
            return;
        }
        drawable.setBounds(drawable2.getBounds());
        drawable.setChangingConfigurations(drawable2.getChangingConfigurations());
        drawable.setLevel(drawable2.getLevel());
        drawable.setVisible(drawable2.isVisible(), false);
        drawable.setState(drawable2.getState());
    }

    public static final int b(int i2, int i3) {
        if (i3 == 255) {
            return i2;
        }
        if (i3 == 0) {
            return i2 & 16777215;
        }
        return (i2 & 16777215) | ((((i2 >>> 24) * (i3 + (i3 >> 7))) >> 8) << 24);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void c(Drawable drawable, Drawable.Callback callback, TransformCallback transformCallback) {
        if (drawable == 0) {
            return;
        }
        drawable.setCallback(callback);
        TransformAwareDrawable transformAwareDrawable = drawable instanceof TransformAwareDrawable ? (TransformAwareDrawable) drawable : null;
        if (transformAwareDrawable != null) {
            transformAwareDrawable.i(transformCallback);
        }
    }

    public static final void d(Drawable drawable, DrawableProperties drawableProperties) {
        if (drawable == null || drawableProperties == null) {
            return;
        }
        int i2 = drawableProperties.f17310a;
        if (i2 != -1) {
            drawable.setAlpha(i2);
        }
        if (drawableProperties.f17311b) {
            drawable.setColorFilter(drawableProperties.f17312c);
        }
        int i3 = drawableProperties.f17313d;
        if (i3 != -1) {
            drawable.setDither(i3 != 0);
        }
        int i4 = drawableProperties.f17314e;
        if (i4 != -1) {
            drawable.setFilterBitmap(i4 != 0);
        }
    }
}
