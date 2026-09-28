package com.google.android.material.card;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.WeakHashMap;

@RestrictTo
/* loaded from: classes4.dex */
class MaterialCardViewHelper {
    public static final double y = Math.cos(Math.toRadians(45.0d));
    public static final ColorDrawable z;

    /* renamed from: a, reason: collision with root package name */
    public final MaterialCardView f40124a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f40125b;

    /* renamed from: c, reason: collision with root package name */
    public final MaterialShapeDrawable f40126c;

    /* renamed from: d, reason: collision with root package name */
    public final MaterialShapeDrawable f40127d;

    /* renamed from: e, reason: collision with root package name */
    public int f40128e;

    /* renamed from: f, reason: collision with root package name */
    public int f40129f;

    /* renamed from: g, reason: collision with root package name */
    public int f40130g;

    /* renamed from: h, reason: collision with root package name */
    public int f40131h;

    /* renamed from: i, reason: collision with root package name */
    public Drawable f40132i;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f40133j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f40134k;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f40135l;

    /* renamed from: m, reason: collision with root package name */
    public ShapeAppearanceModel f40136m;
    public ColorStateList n;
    public RippleDrawable o;
    public LayerDrawable p;
    public MaterialShapeDrawable q;
    public boolean r;
    public boolean s;
    public ValueAnimator t;
    public final TimeInterpolator u;
    public final int v;
    public final int w;
    public float x;

    /* renamed from: com.google.android.material.card.MaterialCardViewHelper$1, reason: invalid class name */
    class AnonymousClass1 extends InsetDrawable {
        @Override // android.graphics.drawable.Drawable
        public final int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public final int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public final boolean getPadding(Rect rect) {
            return false;
        }
    }

    static {
        z = Build.VERSION.SDK_INT <= 28 ? new ColorDrawable() : null;
    }

    public MaterialCardViewHelper(MaterialCardView materialCardView, AttributeSet attributeSet, int i2) {
        int i3 = MaterialCardView.p;
        this.f40125b = new Rect();
        this.r = false;
        this.x = 0.0f;
        this.f40124a = materialCardView;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(materialCardView.getContext(), attributeSet, i2, i3);
        this.f40126c = materialShapeDrawable;
        materialShapeDrawable.k(materialCardView.getContext());
        materialShapeDrawable.p(-12303292);
        ShapeAppearanceModel.Builder builderG = materialShapeDrawable.f40974a.f40989a.g();
        TypedArray typedArrayObtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R.styleable.CardView, i2, R.style.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CardView_cardCornerRadius)) {
            builderG.c(typedArrayObtainStyledAttributes.getDimension(R.styleable.CardView_cardCornerRadius, 0.0f));
        }
        this.f40127d = new MaterialShapeDrawable();
        h(builderG.a());
        this.u = MotionUtils.d(materialCardView.getContext(), R.attr.motionEasingLinearInterpolator, AnimationUtils.f39816a);
        this.v = MotionUtils.c(materialCardView.getContext(), R.attr.motionDurationShort2, 300);
        this.w = MotionUtils.c(materialCardView.getContext(), R.attr.motionDurationShort1, 300);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static float b(CornerTreatment cornerTreatment, float f2) {
        if (cornerTreatment instanceof RoundedCornerTreatment) {
            return (float) ((1.0d - y) * f2);
        }
        if (cornerTreatment instanceof CutCornerTreatment) {
            return f2 / 2.0f;
        }
        return 0.0f;
    }

    public final float a() {
        CornerTreatment cornerTreatment = this.f40136m.f41007a;
        MaterialShapeDrawable materialShapeDrawable = this.f40126c;
        return Math.max(Math.max(b(cornerTreatment, materialShapeDrawable.i()), b(this.f40136m.f41008b, materialShapeDrawable.f40974a.f40989a.f41012f.a(materialShapeDrawable.g()))), Math.max(b(this.f40136m.f41009c, materialShapeDrawable.f40974a.f40989a.f41013g.a(materialShapeDrawable.g())), b(this.f40136m.f41010d, materialShapeDrawable.f40974a.f40989a.f41014h.a(materialShapeDrawable.g()))));
    }

    public final LayerDrawable c() {
        if (this.o == null) {
            this.q = new MaterialShapeDrawable(this.f40136m);
            this.o = new RippleDrawable(this.f40134k, null, this.q);
        }
        if (this.p == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.o, this.f40127d, this.f40133j});
            this.p = layerDrawable;
            layerDrawable.setId(2, R.id.mtrl_card_checked_layer_id);
        }
        return this.p;
    }

    public final Drawable d(Drawable drawable) {
        int iCeil;
        int i2;
        if (this.f40124a.getUseCompatPadding()) {
            int iCeil2 = (int) Math.ceil((r0.getMaxCardElevation() * 1.5f) + (i() ? a() : 0.0f));
            iCeil = (int) Math.ceil(r0.getMaxCardElevation() + (i() ? a() : 0.0f));
            i2 = iCeil2;
        } else {
            iCeil = 0;
            i2 = 0;
        }
        return new AnonymousClass1(drawable, iCeil, i2, iCeil, i2);
    }

    public final void e(int i2, int i3) {
        int iCeil;
        int iCeil2;
        int i4;
        int i5;
        if (this.p != null) {
            MaterialCardView materialCardView = this.f40124a;
            if (materialCardView.getUseCompatPadding()) {
                iCeil = (int) Math.ceil(((materialCardView.getMaxCardElevation() * 1.5f) + (i() ? a() : 0.0f)) * 2.0f);
                iCeil2 = (int) Math.ceil((materialCardView.getMaxCardElevation() + (i() ? a() : 0.0f)) * 2.0f);
            } else {
                iCeil = 0;
                iCeil2 = 0;
            }
            int i6 = this.f40130g;
            int i7 = (i6 & 8388613) == 8388613 ? ((i2 - this.f40128e) - this.f40129f) - iCeil2 : this.f40128e;
            int i8 = (i6 & 80) == 80 ? this.f40128e : ((i3 - this.f40128e) - this.f40129f) - iCeil;
            int i9 = (i6 & 8388613) == 8388613 ? this.f40128e : ((i2 - this.f40128e) - this.f40129f) - iCeil2;
            int i10 = (i6 & 80) == 80 ? ((i3 - this.f40128e) - this.f40129f) - iCeil : this.f40128e;
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            if (materialCardView.getLayoutDirection() == 1) {
                i5 = i9;
                i4 = i7;
            } else {
                i4 = i9;
                i5 = i7;
            }
            this.p.setLayerInset(2, i5, i10, i4, i8);
        }
    }

    public final void f(boolean z2, boolean z3) {
        Drawable drawable = this.f40133j;
        if (drawable != null) {
            if (!z3) {
                drawable.setAlpha(z2 ? 255 : 0);
                this.x = z2 ? 1.0f : 0.0f;
                return;
            }
            float f2 = z2 ? 1.0f : 0.0f;
            float f3 = z2 ? 1.0f - this.x : this.x;
            ValueAnimator valueAnimator = this.t;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.t = null;
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.x, f2);
            this.t = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.card.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    ColorDrawable colorDrawable = MaterialCardViewHelper.z;
                    MaterialCardViewHelper materialCardViewHelper = this.f40137a;
                    materialCardViewHelper.getClass();
                    float fFloatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    materialCardViewHelper.f40133j.setAlpha((int) (255.0f * fFloatValue));
                    materialCardViewHelper.x = fFloatValue;
                }
            });
            this.t.setInterpolator(this.u);
            this.t.setDuration((long) ((z2 ? this.v : this.w) * f3));
            this.t.start();
        }
    }

    public final void g(Drawable drawable) {
        if (drawable != null) {
            Drawable drawableMutate = drawable.mutate();
            this.f40133j = drawableMutate;
            drawableMutate.setTintList(this.f40135l);
            f(this.f40124a.f40121j, false);
        } else {
            this.f40133j = z;
        }
        LayerDrawable layerDrawable = this.p;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(R.id.mtrl_card_checked_layer_id, this.f40133j);
        }
    }

    public final void h(ShapeAppearanceModel shapeAppearanceModel) {
        this.f40136m = shapeAppearanceModel;
        MaterialShapeDrawable materialShapeDrawable = this.f40126c;
        materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        materialShapeDrawable.w = !materialShapeDrawable.f40974a.f40989a.f(materialShapeDrawable.g());
        MaterialShapeDrawable materialShapeDrawable2 = this.f40127d;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setShapeAppearanceModel(shapeAppearanceModel);
        }
        MaterialShapeDrawable materialShapeDrawable3 = this.q;
        if (materialShapeDrawable3 != null) {
            materialShapeDrawable3.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    public final boolean i() {
        MaterialCardView materialCardView = this.f40124a;
        if (!materialCardView.getPreventCornerOverlap()) {
            return false;
        }
        MaterialShapeDrawable materialShapeDrawable = this.f40126c;
        return materialShapeDrawable.f40974a.f40989a.f(materialShapeDrawable.g()) && materialCardView.getUseCompatPadding();
    }

    public final boolean j() {
        View view = this.f40124a;
        if (view.isClickable()) {
            return true;
        }
        while (view.isDuplicateParentStateEnabled() && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        return view.isClickable();
    }

    public final void k() {
        Drawable drawable = this.f40132i;
        Drawable drawableC = j() ? c() : this.f40127d;
        this.f40132i = drawableC;
        if (drawable != drawableC) {
            MaterialCardView materialCardView = this.f40124a;
            if (materialCardView.getForeground() instanceof InsetDrawable) {
                ((InsetDrawable) materialCardView.getForeground()).setDrawable(drawableC);
            } else {
                materialCardView.setForeground(d(drawableC));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l() {
        /*
            r6 = this;
            com.google.android.material.card.MaterialCardView r0 = r6.f40124a
            boolean r1 = r0.getPreventCornerOverlap()
            if (r1 == 0) goto L1a
            com.google.android.material.shape.MaterialShapeDrawable r1 = r6.f40126c
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r2 = r1.f40974a
            com.google.android.material.shape.ShapeAppearanceModel r2 = r2.f40989a
            android.graphics.RectF r1 = r1.g()
            boolean r1 = r2.f(r1)
            if (r1 != 0) goto L1a
            r1 = 1
            goto L1b
        L1a:
            r1 = 0
        L1b:
            r2 = 0
            if (r1 != 0) goto L27
            boolean r1 = r6.i()
            if (r1 == 0) goto L25
            goto L27
        L25:
            r1 = r2
            goto L2b
        L27:
            float r1 = r6.a()
        L2b:
            boolean r3 = r0.getPreventCornerOverlap()
            if (r3 == 0) goto L43
            boolean r3 = r0.getUseCompatPadding()
            if (r3 == 0) goto L43
            r2 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r4 = com.google.android.material.card.MaterialCardViewHelper.y
            double r2 = r2 - r4
            float r4 = r0.getCardViewRadius()
            double r4 = (double) r4
            double r2 = r2 * r4
            float r2 = (float) r2
        L43:
            float r1 = r1 - r2
            int r1 = (int) r1
            android.graphics.Rect r2 = r6.f40125b
            int r3 = r2.left
            int r3 = r3 + r1
            int r4 = r2.top
            int r4 = r4 + r1
            int r5 = r2.right
            int r5 = r5 + r1
            int r2 = r2.bottom
            int r2 = r2 + r1
            r0.f(r3, r4, r5, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.card.MaterialCardViewHelper.l():void");
    }

    public final void m() {
        boolean z2 = this.r;
        MaterialCardView materialCardView = this.f40124a;
        if (!z2) {
            materialCardView.setBackgroundInternal(d(this.f40126c));
        }
        materialCardView.setForeground(d(this.f40132i));
    }
}
