package androidx.transition;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes3.dex */
public class Slide extends Visibility {
    public static final DecelerateInterpolator I = new DecelerateInterpolator();
    public static final AccelerateInterpolator J = new AccelerateInterpolator();
    public static final AnonymousClass1 K = new AnonymousClass1();
    public static final AnonymousClass2 L = new AnonymousClass2();
    public static final AnonymousClass3 M = new AnonymousClass3();
    public static final AnonymousClass4 Q = new AnonymousClass4();
    public static final AnonymousClass5 X = new AnonymousClass5();
    public static final AnonymousClass6 Y = new AnonymousClass6();
    public CalculateSlide H;

    /* renamed from: androidx.transition.Slide$1, reason: invalid class name */
    public class AnonymousClass1 extends CalculateSlideHorizontal {
        @Override // androidx.transition.Slide.CalculateSlide
        public final float a(View view, ViewGroup viewGroup) {
            return view.getTranslationX() - viewGroup.getWidth();
        }
    }

    /* renamed from: androidx.transition.Slide$2, reason: invalid class name */
    public class AnonymousClass2 extends CalculateSlideHorizontal {
        @Override // androidx.transition.Slide.CalculateSlide
        public final float a(View view, ViewGroup viewGroup) {
            return viewGroup.getLayoutDirection() == 1 ? view.getTranslationX() + viewGroup.getWidth() : view.getTranslationX() - viewGroup.getWidth();
        }
    }

    /* renamed from: androidx.transition.Slide$3, reason: invalid class name */
    public class AnonymousClass3 extends CalculateSlideVertical {
        @Override // androidx.transition.Slide.CalculateSlide
        public final float b(View view, ViewGroup viewGroup) {
            return view.getTranslationY() - viewGroup.getHeight();
        }
    }

    /* renamed from: androidx.transition.Slide$4, reason: invalid class name */
    public class AnonymousClass4 extends CalculateSlideHorizontal {
        @Override // androidx.transition.Slide.CalculateSlide
        public final float a(View view, ViewGroup viewGroup) {
            return view.getTranslationX() + viewGroup.getWidth();
        }
    }

    /* renamed from: androidx.transition.Slide$5, reason: invalid class name */
    public class AnonymousClass5 extends CalculateSlideHorizontal {
        @Override // androidx.transition.Slide.CalculateSlide
        public final float a(View view, ViewGroup viewGroup) {
            return viewGroup.getLayoutDirection() == 1 ? view.getTranslationX() - viewGroup.getWidth() : view.getTranslationX() + viewGroup.getWidth();
        }
    }

    /* renamed from: androidx.transition.Slide$6, reason: invalid class name */
    public class AnonymousClass6 extends CalculateSlideVertical {
        @Override // androidx.transition.Slide.CalculateSlide
        public final float b(View view, ViewGroup viewGroup) {
            return view.getTranslationY() + viewGroup.getHeight();
        }
    }

    public interface CalculateSlide {
        float a(View view, ViewGroup viewGroup);

        float b(View view, ViewGroup viewGroup);
    }

    public static abstract class CalculateSlideHorizontal implements CalculateSlide {
        @Override // androidx.transition.Slide.CalculateSlide
        public final float b(View view, ViewGroup viewGroup) {
            return view.getTranslationY();
        }
    }

    public static abstract class CalculateSlideVertical implements CalculateSlide {
        @Override // androidx.transition.Slide.CalculateSlide
        public final float a(View view, ViewGroup viewGroup) {
            return view.getTranslationX();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface GravityFlag {
    }

    public Slide() {
        this.H = Y;
        U(80);
    }

    @Override // androidx.transition.Visibility
    public final Animator R(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        int[] iArr = (int[]) transitionValues2.f12163a.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return TranslationAnimationCreator.a(view, transitionValues2, iArr[0], iArr[1], this.H.a(view, viewGroup), this.H.b(view, viewGroup), translationX, translationY, I, this);
    }

    @Override // androidx.transition.Visibility
    public final Animator S(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null) {
            return null;
        }
        int[] iArr = (int[]) transitionValues.f12163a.get("android:slide:screenPosition");
        return TranslationAnimationCreator.a(view, transitionValues, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.H.a(view, viewGroup), this.H.b(view, viewGroup), J, this);
    }

    public final void U(int i2) {
        if (i2 == 3) {
            this.H = K;
        } else if (i2 == 5) {
            this.H = Q;
        } else if (i2 == 48) {
            this.H = M;
        } else if (i2 == 80) {
            this.H = Y;
        } else if (i2 == 8388611) {
            this.H = L;
        } else {
            if (i2 != 8388613) {
                throw new IllegalArgumentException("Invalid slide direction");
            }
            this.H = X;
        }
        SidePropagation sidePropagation = new SidePropagation();
        sidePropagation.f12105c = i2;
        this.v = sidePropagation;
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public final void d(TransitionValues transitionValues) {
        Visibility.P(transitionValues);
        int[] iArr = new int[2];
        transitionValues.f12164b.getLocationOnScreen(iArr);
        transitionValues.f12163a.put("android:slide:screenPosition", iArr);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public final void g(TransitionValues transitionValues) {
        Visibility.P(transitionValues);
        int[] iArr = new int[2];
        transitionValues.f12164b.getLocationOnScreen(iArr);
        transitionValues.f12163a.put("android:slide:screenPosition", iArr);
    }

    @Override // androidx.transition.Transition
    public final boolean v() {
        return true;
    }

    public Slide(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.H = Y;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f12111f);
        int iF = TypedArrayUtils.f(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        typedArrayObtainStyledAttributes.recycle();
        U(iF);
    }
}
