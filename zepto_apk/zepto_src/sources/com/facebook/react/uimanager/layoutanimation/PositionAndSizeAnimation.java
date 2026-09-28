package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
class PositionAndSizeAnimation extends Animation implements LayoutHandlingAnimation {

    /* renamed from: a, reason: collision with root package name */
    public final View f19824a;

    /* renamed from: b, reason: collision with root package name */
    public float f19825b;

    /* renamed from: c, reason: collision with root package name */
    public float f19826c;

    /* renamed from: d, reason: collision with root package name */
    public float f19827d;

    /* renamed from: e, reason: collision with root package name */
    public float f19828e;

    /* renamed from: f, reason: collision with root package name */
    public int f19829f;

    /* renamed from: g, reason: collision with root package name */
    public int f19830g;

    /* renamed from: h, reason: collision with root package name */
    public int f19831h;

    /* renamed from: i, reason: collision with root package name */
    public int f19832i;

    public PositionAndSizeAnimation(View view, int i2, int i3, int i4, int i5) {
        this.f19824a = view;
        b(i2, i3, i4, i5);
    }

    @Override // com.facebook.react.uimanager.layoutanimation.LayoutHandlingAnimation
    public final void a(int i2, int i3, int i4, int i5) {
        b(i2, i3, i4, i5);
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f2, Transformation transformation) {
        float f3 = (this.f19827d * f2) + this.f19825b;
        float f4 = (this.f19828e * f2) + this.f19826c;
        this.f19824a.layout(Math.round(f3), Math.round(f4), Math.round(f3 + (this.f19831h * f2) + this.f19829f), Math.round(f4 + (this.f19832i * f2) + this.f19830g));
    }

    public final void b(int i2, int i3, int i4, int i5) {
        View view = this.f19824a;
        this.f19825b = view.getX() - view.getTranslationX();
        this.f19826c = view.getY() - view.getTranslationY();
        this.f19829f = view.getWidth();
        int height = view.getHeight();
        this.f19830g = height;
        this.f19827d = i2 - this.f19825b;
        this.f19828e = i3 - this.f19826c;
        this.f19831h = i4 - this.f19829f;
        this.f19832i = i5 - height;
    }

    @Override // android.view.animation.Animation
    public final boolean willChangeBounds() {
        return true;
    }
}
