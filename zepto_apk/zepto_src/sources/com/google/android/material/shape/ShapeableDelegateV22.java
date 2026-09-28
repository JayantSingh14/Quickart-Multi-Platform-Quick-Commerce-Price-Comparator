package com.google.android.material.shape;

import android.graphics.Outline;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

@RequiresApi
/* loaded from: classes4.dex */
class ShapeableDelegateV22 extends ShapeableDelegate {

    /* renamed from: f, reason: collision with root package name */
    public boolean f41084f = false;

    /* renamed from: g, reason: collision with root package name */
    public float f41085g = 0.0f;

    public ShapeableDelegateV22(FrameLayout frameLayout) {
        e(frameLayout);
    }

    @DoNotInline
    private void e(View view) {
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.google.android.material.shape.ShapeableDelegateV22.1
            @Override // android.view.ViewOutlineProvider
            public final void getOutline(View view2, Outline outline) {
                ShapeableDelegateV22 shapeableDelegateV22 = ShapeableDelegateV22.this;
                if (shapeableDelegateV22.f41081c == null || shapeableDelegateV22.f41082d.isEmpty()) {
                    return;
                }
                RectF rectF = shapeableDelegateV22.f41082d;
                outline.setRoundRect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom, shapeableDelegateV22.f41085g);
            }
        });
    }

    @Override // com.google.android.material.shape.ShapeableDelegate
    public final void b(FrameLayout frameLayout) {
        ShapeAppearanceModel shapeAppearanceModel;
        ShapeAppearanceModel shapeAppearanceModel2;
        RectF rectF;
        ShapeAppearanceModel shapeAppearanceModel3 = this.f41081c;
        this.f41085g = (shapeAppearanceModel3 == null || (rectF = this.f41082d) == null) ? 0.0f : shapeAppearanceModel3.f41012f.a(rectF);
        boolean z = false;
        if ((this.f41082d.isEmpty() || (shapeAppearanceModel2 = this.f41081c) == null) ? false : shapeAppearanceModel2.f(this.f41082d)) {
            z = true;
        } else if (!this.f41082d.isEmpty() && (shapeAppearanceModel = this.f41081c) != null && this.f41080b && !shapeAppearanceModel.f(this.f41082d)) {
            ShapeAppearanceModel shapeAppearanceModel4 = this.f41081c;
            if ((shapeAppearanceModel4.f41007a instanceof RoundedCornerTreatment) && (shapeAppearanceModel4.f41008b instanceof RoundedCornerTreatment) && (shapeAppearanceModel4.f41010d instanceof RoundedCornerTreatment) && (shapeAppearanceModel4.f41009c instanceof RoundedCornerTreatment)) {
                float fA = shapeAppearanceModel4.f41011e.a(this.f41082d);
                float fA2 = this.f41081c.f41012f.a(this.f41082d);
                float fA3 = this.f41081c.f41014h.a(this.f41082d);
                float fA4 = this.f41081c.f41013g.a(this.f41082d);
                if (fA == 0.0f && fA3 == 0.0f && fA2 == fA4) {
                    RectF rectF2 = this.f41082d;
                    rectF2.set(rectF2.left - fA2, rectF2.top, rectF2.right, rectF2.bottom);
                    this.f41085g = fA2;
                } else if (fA == 0.0f && fA2 == 0.0f && fA3 == fA4) {
                    RectF rectF3 = this.f41082d;
                    rectF3.set(rectF3.left, rectF3.top - fA3, rectF3.right, rectF3.bottom);
                    this.f41085g = fA3;
                } else if (fA2 == 0.0f && fA4 == 0.0f && fA == fA3) {
                    RectF rectF4 = this.f41082d;
                    rectF4.set(rectF4.left, rectF4.top, rectF4.right + fA, rectF4.bottom);
                    this.f41085g = fA;
                } else if (fA3 == 0.0f && fA4 == 0.0f && fA == fA2) {
                    RectF rectF5 = this.f41082d;
                    rectF5.set(rectF5.left, rectF5.top, rectF5.right, rectF5.bottom + fA);
                    this.f41085g = fA;
                }
                z = true;
            }
        }
        this.f41084f = z;
        frameLayout.setClipToOutline(!c());
        if (c()) {
            frameLayout.invalidate();
        } else {
            frameLayout.invalidateOutline();
        }
    }

    @Override // com.google.android.material.shape.ShapeableDelegate
    public final boolean c() {
        return !this.f41084f || this.f41079a;
    }
}
