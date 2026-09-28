package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.MatrixDrawable;
import com.facebook.drawee.drawable.Rounded;
import com.facebook.drawee.drawable.RoundedBitmapDrawable;
import com.facebook.drawee.drawable.RoundedCornersDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.react.views.image.ReactImageView;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public class GenericDraweeHierarchy implements SettableDraweeHierarchy {

    /* renamed from: a, reason: collision with root package name */
    public final ColorDrawable f17406a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f17407b;

    /* renamed from: c, reason: collision with root package name */
    public RoundingParams f17408c;

    /* renamed from: d, reason: collision with root package name */
    public final RootDrawable f17409d;

    /* renamed from: e, reason: collision with root package name */
    public final FadeDrawable f17410e;

    /* renamed from: f, reason: collision with root package name */
    public final ForwardingDrawable f17411f;

    public GenericDraweeHierarchy(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder) {
        int i2;
        ColorDrawable colorDrawable = new ColorDrawable(0);
        this.f17406a = colorDrawable;
        FrescoSystrace.a();
        this.f17407b = genericDraweeHierarchyBuilder.f17412a;
        this.f17408c = genericDraweeHierarchyBuilder.p;
        ForwardingDrawable forwardingDrawable = new ForwardingDrawable(colorDrawable);
        this.f17411f = forwardingDrawable;
        List list = genericDraweeHierarchyBuilder.n;
        int size = list != null ? list.size() : 1;
        int i3 = (size == 0 ? 1 : size) + (genericDraweeHierarchyBuilder.o != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[i3 + 6];
        drawableArr[0] = f(genericDraweeHierarchyBuilder.f17424m, null);
        drawableArr[1] = f(genericDraweeHierarchyBuilder.f17415d, genericDraweeHierarchyBuilder.f17416e);
        ScalingUtils.AbstractScaleType abstractScaleType = genericDraweeHierarchyBuilder.f17423l;
        forwardingDrawable.setColorFilter(null);
        drawableArr[2] = WrappingUtils.e(forwardingDrawable, abstractScaleType);
        drawableArr[3] = f(genericDraweeHierarchyBuilder.f17421j, genericDraweeHierarchyBuilder.f17422k);
        drawableArr[4] = f(genericDraweeHierarchyBuilder.f17417f, genericDraweeHierarchyBuilder.f17418g);
        drawableArr[5] = f(genericDraweeHierarchyBuilder.f17419h, genericDraweeHierarchyBuilder.f17420i);
        if (i3 > 0) {
            List list2 = genericDraweeHierarchyBuilder.n;
            if (list2 != null) {
                Iterator it = list2.iterator();
                i2 = 0;
                while (it.hasNext()) {
                    drawableArr[i2 + 6] = f((Drawable) it.next(), null);
                    i2++;
                }
            } else {
                i2 = 1;
            }
            StateListDrawable stateListDrawable = genericDraweeHierarchyBuilder.o;
            if (stateListDrawable != null) {
                drawableArr[i2 + 6] = f(stateListDrawable, null);
            }
        }
        FadeDrawable fadeDrawable = new FadeDrawable(drawableArr);
        this.f17410e = fadeDrawable;
        fadeDrawable.f17318l = genericDraweeHierarchyBuilder.f17413b;
        if (fadeDrawable.f17317k == 1) {
            fadeDrawable.f17317k = 0;
        }
        RootDrawable rootDrawable = new RootDrawable(WrappingUtils.d(fadeDrawable, this.f17408c));
        rootDrawable.f17425d = null;
        this.f17409d = rootDrawable;
        rootDrawable.mutate();
        m();
        FrescoSystrace.a();
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public final void a(DebugControllerOverlayDrawable debugControllerOverlayDrawable) {
        RootDrawable rootDrawable = this.f17409d;
        rootDrawable.f17425d = debugControllerOverlayDrawable;
        rootDrawable.invalidateSelf();
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public final void b(float f2, boolean z) {
        FadeDrawable fadeDrawable = this.f17410e;
        if (fadeDrawable.a(3) == null) {
            return;
        }
        fadeDrawable.r++;
        q(f2);
        if (z) {
            fadeDrawable.f();
        }
        fadeDrawable.e();
    }

    @Override // com.facebook.drawee.interfaces.DraweeHierarchy
    public final RootDrawable c() {
        return this.f17409d;
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public final void d(Drawable drawable, float f2, boolean z) {
        Drawable drawableC = WrappingUtils.c(drawable, this.f17408c, this.f17407b);
        drawableC.mutate();
        this.f17411f.u(drawableC);
        FadeDrawable fadeDrawable = this.f17410e;
        fadeDrawable.r++;
        h();
        g(2);
        q(f2);
        if (z) {
            fadeDrawable.f();
        }
        fadeDrawable.e();
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public final void e() {
        FadeDrawable fadeDrawable = this.f17410e;
        fadeDrawable.r++;
        h();
        if (fadeDrawable.a(5) != null) {
            g(5);
        } else {
            g(1);
        }
        fadeDrawable.e();
    }

    public final Drawable f(Drawable drawable, ScalingUtils.AbstractScaleType abstractScaleType) {
        return WrappingUtils.e(WrappingUtils.c(drawable, this.f17408c, this.f17407b), abstractScaleType);
    }

    public final void g(int i2) {
        if (i2 >= 0) {
            FadeDrawable fadeDrawable = this.f17410e;
            fadeDrawable.f17317k = 0;
            fadeDrawable.q[i2] = true;
            fadeDrawable.invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.interfaces.DraweeHierarchy
    public final Rect getBounds() {
        return this.f17409d.getBounds();
    }

    public final void h() {
        i(1);
        i(2);
        i(3);
        i(4);
        i(5);
    }

    public final void i(int i2) {
        if (i2 >= 0) {
            FadeDrawable fadeDrawable = this.f17410e;
            fadeDrawable.f17317k = 0;
            fadeDrawable.q[i2] = false;
            fadeDrawable.invalidateSelf();
        }
    }

    public final DrawableParent j(int i2) {
        DrawableParent drawableParentB = this.f17410e.b(i2);
        if (drawableParentB.getDrawable() instanceof MatrixDrawable) {
            drawableParentB = (MatrixDrawable) drawableParentB.getDrawable();
        }
        return drawableParentB.getDrawable() instanceof ScaleTypeDrawable ? (ScaleTypeDrawable) drawableParentB.getDrawable() : drawableParentB;
    }

    public final RoundingParams k() {
        return this.f17408c;
    }

    public final ScaleTypeDrawable l(int i2) {
        DrawableParent drawableParentJ = j(i2);
        if (drawableParentJ instanceof ScaleTypeDrawable) {
            return (ScaleTypeDrawable) drawableParentJ;
        }
        Drawable drawableE = WrappingUtils.e(drawableParentJ.g(WrappingUtils.f17438a), (ScalingUtils.AbstractScaleType) ScalingUtils.ScaleType.f17384a);
        drawableParentJ.g(drawableE);
        Preconditions.d(drawableE, "Parent has no child drawable!");
        return (ScaleTypeDrawable) drawableE;
    }

    public final void m() {
        FadeDrawable fadeDrawable = this.f17410e;
        if (fadeDrawable != null) {
            fadeDrawable.r++;
            fadeDrawable.f17317k = 0;
            Arrays.fill(fadeDrawable.q, true);
            fadeDrawable.invalidateSelf();
            h();
            g(1);
            fadeDrawable.f();
            fadeDrawable.e();
        }
    }

    public final void n(ScalingUtils.ScaleType scaleType) {
        scaleType.getClass();
        ScaleTypeDrawable scaleTypeDrawableL = l(2);
        scaleTypeDrawableL.getClass();
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        if (Objects.a(scaleTypeDrawableL.f17377d, scaleType)) {
            return;
        }
        scaleTypeDrawableL.f17377d = scaleType;
        scaleTypeDrawableL.f17378e = null;
        scaleTypeDrawableL.v();
        scaleTypeDrawableL.invalidateSelf();
    }

    public final void o(int i2) {
        FadeDrawable fadeDrawable = this.f17410e;
        fadeDrawable.f17318l = i2;
        if (fadeDrawable.f17317k == 1) {
            fadeDrawable.f17317k = 0;
        }
    }

    public final void p(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        if (drawable == null) {
            this.f17410e.c(null, 1);
        } else {
            j(1).g(WrappingUtils.c(drawable, this.f17408c, this.f17407b));
        }
        ScaleTypeDrawable scaleTypeDrawableL = l(1);
        scaleTypeDrawableL.getClass();
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        if (Objects.a(scaleTypeDrawableL.f17377d, scaleType)) {
            return;
        }
        scaleTypeDrawableL.f17377d = scaleType;
        scaleTypeDrawableL.f17378e = null;
        scaleTypeDrawableL.v();
        scaleTypeDrawableL.invalidateSelf();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void q(float f2) {
        Drawable drawableA = this.f17410e.a(3);
        if (drawableA == 0) {
            return;
        }
        if (f2 >= 0.999f) {
            if (drawableA instanceof Animatable) {
                ((Animatable) drawableA).stop();
            }
            i(3);
        } else {
            if (drawableA instanceof Animatable) {
                ((Animatable) drawableA).start();
            }
            g(3);
        }
        drawableA.setLevel(Math.round(f2 * 10000.0f));
    }

    public final void r(ReactImageView.AnonymousClass1 anonymousClass1) {
        if (anonymousClass1 == null) {
            this.f17410e.c(null, 3);
        } else {
            j(3).g(WrappingUtils.c(anonymousClass1, this.f17408c, this.f17407b));
        }
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public final void reset() {
        this.f17411f.u(this.f17406a);
        m();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void s(RoundingParams roundingParams) {
        this.f17408c = roundingParams;
        ColorDrawable colorDrawable = WrappingUtils.f17438a;
        RootDrawable rootDrawable = this.f17409d;
        Drawable drawable = rootDrawable.f17320a;
        ColorDrawable colorDrawable2 = WrappingUtils.f17438a;
        if (roundingParams.f17427a == RoundingParams.RoundingMethod.f17435a) {
            if (drawable instanceof RoundedCornersDrawable) {
                RoundedCornersDrawable roundedCornersDrawable = (RoundedCornersDrawable) drawable;
                WrappingUtils.b(roundedCornersDrawable, roundingParams);
                roundedCornersDrawable.f17359l = roundingParams.f17430d;
                roundedCornersDrawable.invalidateSelf();
            } else {
                rootDrawable.u(WrappingUtils.d(rootDrawable.u(colorDrawable2), roundingParams));
            }
        } else if (drawable instanceof RoundedCornersDrawable) {
            rootDrawable.u(((RoundedCornersDrawable) drawable).u(colorDrawable2));
            colorDrawable2.setCallback(null);
        }
        for (int i2 = 0; i2 < this.f17410e.f17298c.length; i2++) {
            DrawableParent drawableParentJ = j(i2);
            RoundingParams roundingParams2 = this.f17408c;
            while (true) {
                Object drawable2 = drawableParentJ.getDrawable();
                if (drawable2 == drawableParentJ || !(drawable2 instanceof DrawableParent)) {
                    break;
                } else {
                    drawableParentJ = (DrawableParent) drawable2;
                }
            }
            Drawable drawable3 = drawableParentJ.getDrawable();
            if (roundingParams2 == null || roundingParams2.f17427a != RoundingParams.RoundingMethod.f17436b) {
                if (drawable3 instanceof Rounded) {
                    Rounded rounded = (Rounded) drawable3;
                    rounded.b(false);
                    rounded.k();
                    rounded.c(0.0f, 0);
                    rounded.h(0.0f);
                    rounded.r();
                    rounded.m(false);
                    int i3 = RoundedBitmapDrawable.D;
                    rounded.o();
                }
            } else if (drawable3 instanceof Rounded) {
                WrappingUtils.b((Rounded) drawable3, roundingParams2);
            } else if (drawable3 != 0) {
                drawableParentJ.g(WrappingUtils.f17438a);
                drawableParentJ.g(WrappingUtils.a(drawable3, roundingParams2, this.f17407b));
            }
        }
    }
}
