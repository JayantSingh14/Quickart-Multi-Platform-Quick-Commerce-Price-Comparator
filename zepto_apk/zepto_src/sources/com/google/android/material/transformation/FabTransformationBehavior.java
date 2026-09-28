package com.google.android.material.transformation;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.animation.Positioning;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

@Deprecated
/* loaded from: classes4.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c, reason: collision with root package name */
    public final Rect f41466c;

    /* renamed from: d, reason: collision with root package name */
    public final RectF f41467d;

    /* renamed from: e, reason: collision with root package name */
    public final RectF f41468e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f41469f;

    /* renamed from: g, reason: collision with root package name */
    public float f41470g;

    /* renamed from: h, reason: collision with root package name */
    public float f41471h;

    public static class FabTransformationSpec {

        /* renamed from: a, reason: collision with root package name */
        public MotionSpec f41479a;

        /* renamed from: b, reason: collision with root package name */
        public Positioning f41480b;
    }

    public FabTransformationBehavior() {
        this.f41466c = new Rect();
        this.f41467d = new RectF();
        this.f41468e = new RectF();
        this.f41469f = new int[2];
    }

    public static Pair A(float f2, float f3, boolean z, FabTransformationSpec fabTransformationSpec) {
        MotionTiming motionTimingF;
        MotionTiming motionTimingF2;
        if (f2 == 0.0f || f3 == 0.0f) {
            motionTimingF = fabTransformationSpec.f41479a.f("translationXLinear");
            motionTimingF2 = fabTransformationSpec.f41479a.f("translationYLinear");
        } else if ((!z || f3 >= 0.0f) && (z || f3 <= 0.0f)) {
            motionTimingF = fabTransformationSpec.f41479a.f("translationXCurveDownwards");
            motionTimingF2 = fabTransformationSpec.f41479a.f("translationYCurveDownwards");
        } else {
            motionTimingF = fabTransformationSpec.f41479a.f("translationXCurveUpwards");
            motionTimingF2 = fabTransformationSpec.f41479a.f("translationYCurveUpwards");
        }
        return new Pair(motionTimingF, motionTimingF2);
    }

    public static float D(FabTransformationSpec fabTransformationSpec, MotionTiming motionTiming, float f2) {
        long j2 = motionTiming.f39830a;
        MotionTiming motionTimingF = fabTransformationSpec.f41479a.f("expansion");
        return AnimationUtils.a(f2, 0.0f, motionTiming.b().getInterpolation((((motionTimingF.f39830a + motionTimingF.f39831b) + 17) - j2) / motionTiming.f39831b));
    }

    public final float B(View view, View view2, Positioning positioning) {
        RectF rectF = this.f41467d;
        RectF rectF2 = this.f41468e;
        E(view, rectF);
        rectF.offset(this.f41470g, this.f41471h);
        E(view2, rectF2);
        positioning.getClass();
        return (rectF2.centerX() - rectF.centerX()) + 0.0f;
    }

    public final float C(View view, View view2, Positioning positioning) {
        RectF rectF = this.f41467d;
        RectF rectF2 = this.f41468e;
        E(view, rectF);
        rectF.offset(this.f41470g, this.f41471h);
        E(view2, rectF2);
        positioning.getClass();
        return (rectF2.centerY() - rectF.centerY()) + 0.0f;
    }

    public final void E(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f41469f);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    public abstract FabTransformationSpec F(Context context, boolean z);

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean h(View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void i(CoordinatorLayout.LayoutParams layoutParams) {
        if (layoutParams.f2567h == 0) {
            layoutParams.f2567h = 80;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x033d  */
    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.animation.AnimatorSet z(final android.view.View r25, final android.view.View r26, final boolean r27, boolean r28) {
        /*
            Method dump skipped, instructions count: 935
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.transformation.FabTransformationBehavior.z(android.view.View, android.view.View, boolean, boolean):android.animation.AnimatorSet");
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41466c = new Rect();
        this.f41467d = new RectF();
        this.f41468e = new RectF();
        this.f41469f = new int[2];
    }
}
