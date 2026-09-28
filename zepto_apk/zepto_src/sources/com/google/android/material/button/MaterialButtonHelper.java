package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.WeakHashMap;

@RestrictTo
/* loaded from: classes4.dex */
class MaterialButtonHelper {

    /* renamed from: a, reason: collision with root package name */
    public final MaterialButton f40086a;

    /* renamed from: b, reason: collision with root package name */
    public ShapeAppearanceModel f40087b;

    /* renamed from: c, reason: collision with root package name */
    public int f40088c;

    /* renamed from: d, reason: collision with root package name */
    public int f40089d;

    /* renamed from: e, reason: collision with root package name */
    public int f40090e;

    /* renamed from: f, reason: collision with root package name */
    public int f40091f;

    /* renamed from: g, reason: collision with root package name */
    public int f40092g;

    /* renamed from: h, reason: collision with root package name */
    public int f40093h;

    /* renamed from: i, reason: collision with root package name */
    public PorterDuff.Mode f40094i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f40095j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f40096k;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f40097l;

    /* renamed from: m, reason: collision with root package name */
    public MaterialShapeDrawable f40098m;
    public boolean q;
    public RippleDrawable s;
    public int t;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public boolean r = true;

    public MaterialButtonHelper(MaterialButton materialButton, ShapeAppearanceModel shapeAppearanceModel) {
        this.f40086a = materialButton;
        this.f40087b = shapeAppearanceModel;
    }

    public final Shapeable a() {
        RippleDrawable rippleDrawable = this.s;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.s.getNumberOfLayers() > 2 ? (Shapeable) this.s.getDrawable(2) : (Shapeable) this.s.getDrawable(1);
    }

    public final MaterialShapeDrawable b(boolean z) {
        RippleDrawable rippleDrawable = this.s;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (MaterialShapeDrawable) ((LayerDrawable) ((InsetDrawable) this.s.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
    }

    public final void c(ShapeAppearanceModel shapeAppearanceModel) {
        this.f40087b = shapeAppearanceModel;
        if (b(false) != null) {
            b(false).setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (b(true) != null) {
            b(true).setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (a() != null) {
            a().setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    public final void d(int i2, int i3) {
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        MaterialButton materialButton = this.f40086a;
        int paddingStart = materialButton.getPaddingStart();
        int paddingTop = materialButton.getPaddingTop();
        int paddingEnd = materialButton.getPaddingEnd();
        int paddingBottom = materialButton.getPaddingBottom();
        int i4 = this.f40090e;
        int i5 = this.f40091f;
        this.f40091f = i3;
        this.f40090e = i2;
        if (!this.o) {
            e();
        }
        materialButton.setPaddingRelative(paddingStart, (paddingTop + i2) - i4, paddingEnd, (paddingBottom + i3) - i5);
    }

    public final void e() {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.f40087b);
        MaterialButton materialButton = this.f40086a;
        materialShapeDrawable.k(materialButton.getContext());
        materialShapeDrawable.setTintList(this.f40095j);
        PorterDuff.Mode mode = this.f40094i;
        if (mode != null) {
            materialShapeDrawable.setTintMode(mode);
        }
        float f2 = this.f40093h;
        ColorStateList colorStateList = this.f40096k;
        materialShapeDrawable.u(f2);
        materialShapeDrawable.t(colorStateList);
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.f40087b);
        materialShapeDrawable2.setTint(0);
        float f3 = this.f40093h;
        int iB = this.n ? MaterialColors.b(R.attr.colorSurface, materialButton) : 0;
        materialShapeDrawable2.u(f3);
        materialShapeDrawable2.t(ColorStateList.valueOf(iB));
        MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(this.f40087b);
        this.f40098m = materialShapeDrawable3;
        materialShapeDrawable3.setTint(-1);
        RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.c(this.f40097l), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable}), this.f40088c, this.f40090e, this.f40089d, this.f40091f), this.f40098m);
        this.s = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        MaterialShapeDrawable materialShapeDrawableB = b(false);
        if (materialShapeDrawableB != null) {
            materialShapeDrawableB.l(this.t);
            materialShapeDrawableB.setState(materialButton.getDrawableState());
        }
    }

    public final void f() {
        int iB = 0;
        MaterialShapeDrawable materialShapeDrawableB = b(false);
        MaterialShapeDrawable materialShapeDrawableB2 = b(true);
        if (materialShapeDrawableB != null) {
            float f2 = this.f40093h;
            ColorStateList colorStateList = this.f40096k;
            materialShapeDrawableB.u(f2);
            materialShapeDrawableB.t(colorStateList);
            if (materialShapeDrawableB2 != null) {
                float f3 = this.f40093h;
                if (this.n) {
                    iB = MaterialColors.b(R.attr.colorSurface, this.f40086a);
                }
                materialShapeDrawableB2.u(f3);
                materialShapeDrawableB2.t(ColorStateList.valueOf(iB));
            }
        }
    }
}
