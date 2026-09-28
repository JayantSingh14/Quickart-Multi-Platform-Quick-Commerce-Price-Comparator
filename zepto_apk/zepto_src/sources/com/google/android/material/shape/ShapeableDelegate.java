package com.google.android.material.shape;

import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import com.google.android.material.shape.ShapeAppearancePathProvider;

@RestrictTo
/* loaded from: classes4.dex */
public abstract class ShapeableDelegate {

    /* renamed from: c, reason: collision with root package name */
    public ShapeAppearanceModel f41081c;

    /* renamed from: a, reason: collision with root package name */
    public boolean f41079a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f41080b = false;

    /* renamed from: d, reason: collision with root package name */
    public RectF f41082d = new RectF();

    /* renamed from: e, reason: collision with root package name */
    public final Path f41083e = new Path();

    public static ShapeableDelegate a(FrameLayout frameLayout) {
        return Build.VERSION.SDK_INT >= 33 ? new ShapeableDelegateV33(frameLayout) : new ShapeableDelegateV22(frameLayout);
    }

    public abstract void b(FrameLayout frameLayout);

    public abstract boolean c();

    public final void d() {
        ShapeAppearanceModel shapeAppearanceModel;
        RectF rectF = this.f41082d;
        if (rectF.left > rectF.right || rectF.top > rectF.bottom || (shapeAppearanceModel = this.f41081c) == null) {
            return;
        }
        ShapeAppearancePathProvider.Lazy.f41043a.a(shapeAppearanceModel, 1.0f, rectF, null, this.f41083e);
    }
}
