package com.google.android.material.animation;

import android.graphics.drawable.Drawable;
import android.util.Property;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public class DrawableAlphaProperty extends Property<Drawable, Integer> {

    /* renamed from: a, reason: collision with root package name */
    public static final DrawableAlphaProperty f39823a;

    static {
        DrawableAlphaProperty drawableAlphaProperty = new DrawableAlphaProperty(Integer.class, "drawableAlphaCompat");
        new WeakHashMap();
        f39823a = drawableAlphaProperty;
    }

    @Override // android.util.Property
    public final Integer get(Drawable drawable) {
        return Integer.valueOf(drawable.getAlpha());
    }

    @Override // android.util.Property
    public final void set(Drawable drawable, Integer num) {
        drawable.setAlpha(num.intValue());
    }
}
