package com.google.android.material.shadow;

import android.graphics.Canvas;
import android.graphics.Rect;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;

@Deprecated
/* loaded from: classes4.dex */
public class ShadowDrawableWrapper extends DrawableWrapperCompat {
    static {
        Math.cos(Math.toRadians(45.0d));
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i2 = getBounds().left;
        throw null;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        int iCeil = (int) Math.ceil(0.0f);
        int iCeil2 = (int) Math.ceil(0.0f);
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        super.setAlpha(i2);
        throw null;
    }
}
