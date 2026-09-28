package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.transition.Transition;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class ChangeClipBounds extends Transition {
    public static final String[] F = {"android:clipBounds:clip"};
    public static final Rect G = new Rect();

    public static class Listener extends AnimatorListenerAdapter implements Transition.TransitionListener {

        /* renamed from: a, reason: collision with root package name */
        public final Rect f12035a;

        /* renamed from: b, reason: collision with root package name */
        public final Rect f12036b;

        /* renamed from: c, reason: collision with root package name */
        public final View f12037c;

        public Listener(View view, Rect rect, Rect rect2) {
            this.f12037c = view;
            this.f12035a = rect;
            this.f12036b = rect2;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void b() {
            View view = this.f12037c;
            Rect clipBounds = view.getClipBounds();
            if (clipBounds == null) {
                clipBounds = ChangeClipBounds.G;
            }
            view.setTag(R.id.transition_clip, clipBounds);
            view.setClipBounds(this.f12036b);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void f() {
            int i2 = R.id.transition_clip;
            View view = this.f12037c;
            view.setClipBounds((Rect) view.getTag(i2));
            view.setTag(R.id.transition_clip, null);
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

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator, boolean z) {
            View view = this.f12037c;
            if (z) {
                view.setClipBounds(this.f12035a);
            } else {
                view.setClipBounds(this.f12036b);
            }
        }
    }

    public ChangeClipBounds() {
    }

    public static void P(TransitionValues transitionValues, boolean z) {
        View view = transitionValues.f12164b;
        if (view.getVisibility() == 8) {
            return;
        }
        Rect clipBounds = z ? (Rect) view.getTag(R.id.transition_clip) : null;
        if (clipBounds == null) {
            clipBounds = view.getClipBounds();
        }
        Rect rect = clipBounds != G ? clipBounds : null;
        HashMap map = transitionValues.f12163a;
        map.put("android:clipBounds:clip", rect);
        if (rect == null) {
            map.put("android:clipBounds:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
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
        if (!map.containsKey("android:clipBounds:clip")) {
            return null;
        }
        HashMap map2 = transitionValues2.f12163a;
        if (!map2.containsKey("android:clipBounds:clip")) {
            return null;
        }
        Rect rect = (Rect) map.get("android:clipBounds:clip");
        Rect rect2 = (Rect) map2.get("android:clipBounds:clip");
        if (rect == null && rect2 == null) {
            return null;
        }
        Rect rect3 = rect == null ? (Rect) map.get("android:clipBounds:bounds") : rect;
        Rect rect4 = rect2 == null ? (Rect) map2.get("android:clipBounds:bounds") : rect2;
        if (rect3.equals(rect4)) {
            return null;
        }
        transitionValues2.f12164b.setClipBounds(rect);
        Rect rect5 = new Rect();
        RectEvaluator rectEvaluator = new RectEvaluator();
        rectEvaluator.f12103a = rect5;
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(transitionValues2.f12164b, (Property<View, V>) ViewUtils.f12186c, rectEvaluator, rect3, rect4);
        Listener listener = new Listener(transitionValues2.f12164b, rect, rect2);
        objectAnimatorOfObject.addListener(listener);
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

    public ChangeClipBounds(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
