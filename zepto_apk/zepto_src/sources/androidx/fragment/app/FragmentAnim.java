package androidx.fragment.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import androidx.core.view.OneShotPreDrawListener;

/* loaded from: classes.dex */
class FragmentAnim {
    public static int a(int i2, Context context) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i2});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    /* loaded from: classes3.dex */
    public static class AnimationOrAnimator {

        /* renamed from: a, reason: collision with root package name */
        public final Animation f4541a;

        /* renamed from: b, reason: collision with root package name */
        public final AnimatorSet f4542b;

        public AnimationOrAnimator(Animation animation) {
            this.f4541a = animation;
            this.f4542b = null;
        }

        public AnimationOrAnimator(Animator animator) {
            this.f4541a = null;
            AnimatorSet animatorSet = new AnimatorSet();
            this.f4542b = animatorSet;
            animatorSet.play(animator);
        }
    }

    /* loaded from: classes3.dex */
    public static class EndViewTransitionAnimation extends AnimationSet implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final ViewGroup f4543a;

        /* renamed from: b, reason: collision with root package name */
        public final View f4544b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f4545c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f4546d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f4547e;

        public EndViewTransitionAnimation(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f4547e = true;
            this.f4543a = viewGroup;
            this.f4544b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public final boolean getTransformation(long j2, Transformation transformation) {
            this.f4547e = true;
            if (this.f4545c) {
                return !this.f4546d;
            }
            if (!super.getTransformation(j2, transformation)) {
                this.f4545c = true;
                OneShotPreDrawListener.a(this.f4543a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z = this.f4545c;
            ViewGroup viewGroup = this.f4543a;
            if (z || !this.f4547e) {
                viewGroup.endViewTransition(this.f4544b);
                this.f4546d = true;
            } else {
                this.f4547e = false;
                viewGroup.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public final boolean getTransformation(long j2, Transformation transformation, float f2) {
            this.f4547e = true;
            if (this.f4545c) {
                return !this.f4546d;
            }
            if (!super.getTransformation(j2, transformation, f2)) {
                this.f4545c = true;
                OneShotPreDrawListener.a(this.f4543a, this);
            }
            return true;
        }
    }
}
