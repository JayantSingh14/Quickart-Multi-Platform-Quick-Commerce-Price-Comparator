package androidx.transition;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.transition.Transition;

/* loaded from: classes3.dex */
public class Explode extends Visibility {
    public static final DecelerateInterpolator I = new DecelerateInterpolator();
    public static final AccelerateInterpolator J = new AccelerateInterpolator();
    public final int[] H;

    public Explode() {
        this.H = new int[2];
        this.v = new CircularPropagation();
    }

    @Override // androidx.transition.Visibility
    public final Animator R(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues2.f12163a.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        U(viewGroup, rect, this.H);
        return TranslationAnimationCreator.a(view, transitionValues2, rect.left, rect.top, translationX + r0[0], translationY + r0[1], translationX, translationY, I, this);
    }

    @Override // androidx.transition.Visibility
    public final Animator S(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f2;
        float f3;
        if (transitionValues == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues.f12163a.get("android:explode:screenBounds");
        int i2 = rect.left;
        int i3 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues.f12164b.getTag(R.id.transition_position);
        if (iArr != null) {
            f2 = (r7 - rect.left) + translationX;
            f3 = (r0 - rect.top) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
        } else {
            f2 = translationX;
            f3 = translationY;
        }
        U(viewGroup, rect, this.H);
        return TranslationAnimationCreator.a(view, transitionValues, i2, i3, translationX, translationY, f2 + r0[0], f3 + r0[1], J, this);
    }

    public final void U(ViewGroup viewGroup, Rect rect, int[] iArr) {
        int iCenterX;
        int iCenterY;
        int[] iArr2 = this.H;
        viewGroup.getLocationOnScreen(iArr2);
        int i2 = iArr2[0];
        int i3 = iArr2[1];
        Transition.EpicenterCallback epicenterCallback = this.w;
        Rect rectA = epicenterCallback == null ? null : epicenterCallback.a();
        if (rectA == null) {
            iCenterX = Math.round(viewGroup.getTranslationX()) + (viewGroup.getWidth() / 2) + i2;
            iCenterY = Math.round(viewGroup.getTranslationY()) + (viewGroup.getHeight() / 2) + i3;
        } else {
            iCenterX = rectA.centerX();
            iCenterY = rectA.centerY();
        }
        float fCenterX = rect.centerX() - iCenterX;
        float fCenterY = rect.centerY() - iCenterY;
        if (fCenterX == 0.0f && fCenterY == 0.0f) {
            fCenterX = ((float) (Math.random() * 2.0d)) - 1.0f;
            fCenterY = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float fSqrt = (float) Math.sqrt((fCenterY * fCenterY) + (fCenterX * fCenterX));
        int i4 = iCenterX - i2;
        int i5 = iCenterY - i3;
        float fMax = Math.max(i4, viewGroup.getWidth() - i4);
        float fMax2 = Math.max(i5, viewGroup.getHeight() - i5);
        float fSqrt2 = (float) Math.sqrt((fMax2 * fMax2) + (fMax * fMax));
        iArr[0] = Math.round((fCenterX / fSqrt) * fSqrt2);
        iArr[1] = Math.round(fSqrt2 * (fCenterY / fSqrt));
    }

    public final void V(TransitionValues transitionValues) {
        View view = transitionValues.f12164b;
        int[] iArr = this.H;
        view.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        transitionValues.f12163a.put("android:explode:screenBounds", new Rect(i2, i3, view.getWidth() + i2, view.getHeight() + i3));
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public final void d(TransitionValues transitionValues) {
        Visibility.P(transitionValues);
        V(transitionValues);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public final void g(TransitionValues transitionValues) {
        Visibility.P(transitionValues);
        V(transitionValues);
    }

    @Override // androidx.transition.Transition
    public final boolean v() {
        return true;
    }

    public Explode(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.H = new int[2];
        this.v = new CircularPropagation();
    }
}
