package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.transition.Transition;
import androidx.transition.TransitionUtils;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class ChangeImageTransform extends Transition {
    public static final String[] F = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};
    public static final TypeEvaluator G = new AnonymousClass1();
    public static final Property H = new AnonymousClass2(Matrix.class, "animatedTransform");

    /* renamed from: androidx.transition.ChangeImageTransform$1, reason: invalid class name */
    public class AnonymousClass1 implements TypeEvaluator<Matrix> {
        @Override // android.animation.TypeEvaluator
        public final /* bridge */ /* synthetic */ Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
            return null;
        }
    }

    /* renamed from: androidx.transition.ChangeImageTransform$2, reason: invalid class name */
    public class AnonymousClass2 extends Property<ImageView, Matrix> {
        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ Matrix get(ImageView imageView) {
            return null;
        }

        @Override // android.util.Property
        public final void set(ImageView imageView, Matrix matrix) {
            ImageViewUtils.a(imageView, matrix);
        }
    }

    /* renamed from: androidx.transition.ChangeImageTransform$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12038a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f12038a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12038a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class Listener extends AnimatorListenerAdapter implements Transition.TransitionListener {

        /* renamed from: a, reason: collision with root package name */
        public final ImageView f12039a;

        /* renamed from: b, reason: collision with root package name */
        public final Matrix f12040b;

        /* renamed from: c, reason: collision with root package name */
        public final Matrix f12041c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f12042d = true;

        public Listener(ImageView imageView, Matrix matrix, Matrix matrix2) {
            this.f12039a = imageView;
            this.f12040b = matrix;
            this.f12041c = matrix2;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void b() {
            if (this.f12042d) {
                int i2 = R.id.transition_image_transform;
                ImageView imageView = this.f12039a;
                imageView.setTag(i2, this.f12040b);
                ImageViewUtils.a(imageView, this.f12041c);
            }
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void f() {
            int i2 = R.id.transition_image_transform;
            ImageView imageView = this.f12039a;
            Matrix matrix = (Matrix) imageView.getTag(i2);
            if (matrix != null) {
                ImageViewUtils.a(imageView, matrix);
                imageView.setTag(R.id.transition_image_transform, null);
            }
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void h(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void j(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void l(Transition transition) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator, boolean z) {
            this.f12042d = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public final void onAnimationPause(Animator animator) {
            Matrix matrix = (Matrix) ((ObjectAnimator) animator).getAnimatedValue();
            int i2 = R.id.transition_image_transform;
            ImageView imageView = this.f12039a;
            imageView.setTag(i2, matrix);
            ImageViewUtils.a(imageView, this.f12041c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public final void onAnimationResume(Animator animator) {
            int i2 = R.id.transition_image_transform;
            ImageView imageView = this.f12039a;
            Matrix matrix = (Matrix) imageView.getTag(i2);
            if (matrix != null) {
                ImageViewUtils.a(imageView, matrix);
                imageView.setTag(R.id.transition_image_transform, null);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator, boolean z) {
            this.f12042d = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            this.f12042d = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            this.f12042d = false;
        }
    }

    public ChangeImageTransform() {
    }

    public static void P(TransitionValues transitionValues, boolean z) {
        Matrix matrix;
        View view = transitionValues.f12164b;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() == null) {
                return;
            }
            HashMap map = transitionValues.f12163a;
            map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            Matrix matrix2 = z ? (Matrix) imageView.getTag(R.id.transition_image_transform) : null;
            if (matrix2 == null) {
                Drawable drawable = imageView.getDrawable();
                if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
                    matrix2 = new Matrix(imageView.getImageMatrix());
                } else {
                    int i2 = AnonymousClass3.f12038a[imageView.getScaleType().ordinal()];
                    if (i2 == 1) {
                        Drawable drawable2 = imageView.getDrawable();
                        matrix = new Matrix();
                        matrix.postScale(imageView.getWidth() / drawable2.getIntrinsicWidth(), imageView.getHeight() / drawable2.getIntrinsicHeight());
                    } else if (i2 != 2) {
                        matrix2 = new Matrix(imageView.getImageMatrix());
                    } else {
                        Drawable drawable3 = imageView.getDrawable();
                        int intrinsicWidth = drawable3.getIntrinsicWidth();
                        float width = imageView.getWidth();
                        float f2 = intrinsicWidth;
                        int intrinsicHeight = drawable3.getIntrinsicHeight();
                        float height = imageView.getHeight();
                        float f3 = intrinsicHeight;
                        float fMax = Math.max(width / f2, height / f3);
                        int iRound = Math.round((width - (f2 * fMax)) / 2.0f);
                        int iRound2 = Math.round((height - (f3 * fMax)) / 2.0f);
                        matrix = new Matrix();
                        matrix.postScale(fMax, fMax);
                        matrix.postTranslate(iRound, iRound2);
                    }
                    matrix2 = matrix;
                }
            }
            map.put("android:changeImageTransform:matrix", matrix2);
        }
    }

    @Override // androidx.transition.Transition
    public final void d(TransitionValues transitionValues) {
        P(transitionValues, false);
    }

    @Override // androidx.transition.Transition
    public final void g(TransitionValues transitionValues) {
        P(transitionValues, true);
    }

    @Override // androidx.transition.Transition
    public final Animator k(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        HashMap map = transitionValues.f12163a;
        Rect rect = (Rect) map.get("android:changeImageTransform:bounds");
        HashMap map2 = transitionValues2.f12163a;
        Rect rect2 = (Rect) map2.get("android:changeImageTransform:bounds");
        if (rect == null || rect2 == null) {
            return null;
        }
        Matrix matrix = (Matrix) map.get("android:changeImageTransform:matrix");
        Matrix matrix2 = (Matrix) map2.get("android:changeImageTransform:matrix");
        boolean z = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
        if (rect.equals(rect2) && z) {
            return null;
        }
        ImageView imageView = (ImageView) transitionValues2.f12164b;
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Property property = H;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            TypeEvaluator typeEvaluator = G;
            Matrix matrix3 = MatrixUtils.f12099a;
            return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) property, typeEvaluator, matrix3, matrix3);
        }
        if (matrix == null) {
            matrix = MatrixUtils.f12099a;
        }
        if (matrix2 == null) {
            matrix2 = MatrixUtils.f12099a;
        }
        ((AnonymousClass2) property).getClass();
        ImageViewUtils.a(imageView, matrix);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) property, new TransitionUtils.MatrixEvaluator(), matrix, matrix2);
        Listener listener = new Listener(imageView, matrix, matrix2);
        objectAnimatorOfObject.addListener(listener);
        objectAnimatorOfObject.addPauseListener(listener);
        a(listener);
        return objectAnimatorOfObject;
    }

    @Override // androidx.transition.Transition
    public final String[] q() {
        return F;
    }

    @Override // androidx.transition.Transition
    public final boolean v() {
        return true;
    }

    public ChangeImageTransform(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
