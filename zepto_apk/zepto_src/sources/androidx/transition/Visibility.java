package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Transition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;

/* loaded from: classes3.dex */
public abstract class Visibility extends Transition {
    public static final String[] G = {"android:visibility:visibility", "android:visibility:parent"};
    public int F;

    public static class DisappearListener extends AnimatorListenerAdapter implements Transition.TransitionListener {

        /* renamed from: a, reason: collision with root package name */
        public final View f12195a;

        /* renamed from: b, reason: collision with root package name */
        public final int f12196b;

        /* renamed from: c, reason: collision with root package name */
        public final ViewGroup f12197c;

        /* renamed from: e, reason: collision with root package name */
        public boolean f12199e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f12200f = false;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f12198d = true;

        public DisappearListener(int i2, View view) {
            this.f12195a = view;
            this.f12196b = i2;
            this.f12197c = (ViewGroup) view.getParent();
            a(true);
        }

        public final void a(boolean z) {
            ViewGroup viewGroup;
            if (!this.f12198d || this.f12199e == z || (viewGroup = this.f12197c) == null) {
                return;
            }
            this.f12199e = z;
            ViewGroupUtils.a(viewGroup, z);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void b() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            a(false);
            if (this.f12200f) {
                return;
            }
            ViewUtils.c(this.f12195a, this.f12196b);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void f() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            a(true);
            if (this.f12200f) {
                return;
            }
            ViewUtils.c(this.f12195a, 0);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void h(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void j(Transition transition) {
            transition.B(this);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void l(Transition transition) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            this.f12200f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            if (!this.f12200f) {
                ViewUtils.c(this.f12195a, this.f12196b);
                ViewGroup viewGroup = this.f12197c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            a(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator, boolean z) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            if (z) {
                ViewUtils.c(this.f12195a, 0);
                ViewGroup viewGroup = this.f12197c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator, boolean z) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            if (z) {
                return;
            }
            if (!this.f12200f) {
                ViewUtils.c(this.f12195a, this.f12196b);
                ViewGroup viewGroup = this.f12197c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            a(false);
        }
    }

    @SuppressLint({"UniqueConstants"})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface Mode {
    }

    public class OverlayListener extends AnimatorListenerAdapter implements Transition.TransitionListener {

        /* renamed from: a, reason: collision with root package name */
        public final ViewGroup f12201a;

        /* renamed from: b, reason: collision with root package name */
        public final View f12202b;

        /* renamed from: c, reason: collision with root package name */
        public final View f12203c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f12204d = true;

        public OverlayListener(ViewGroup viewGroup, View view, View view2) {
            this.f12201a = viewGroup;
            this.f12202b = view;
            this.f12203c = view2;
        }

        public final void a() {
            this.f12203c.setTag(R.id.save_overlay_view, null);
            this.f12201a.getOverlay().remove(this.f12202b);
            this.f12204d = false;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void h(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void j(Transition transition) {
            transition.B(this);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void l(Transition transition) {
            if (this.f12204d) {
                a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public final void onAnimationPause(Animator animator) {
            this.f12201a.getOverlay().remove(this.f12202b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public final void onAnimationResume(Animator animator) {
            View view = this.f12202b;
            if (view.getParent() == null) {
                this.f12201a.getOverlay().add(view);
            } else {
                Visibility.this.cancel();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator, boolean z) {
            if (z) {
                View view = this.f12203c;
                int i2 = R.id.save_overlay_view;
                View view2 = this.f12202b;
                view.setTag(i2, view2);
                this.f12201a.getOverlay().add(view2);
                this.f12204d = true;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator, boolean z) {
            if (z) {
                return;
            }
            a();
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void b() {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void f() {
        }
    }

    public static class VisibilityInfo {

        /* renamed from: a, reason: collision with root package name */
        public boolean f12206a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f12207b;

        /* renamed from: c, reason: collision with root package name */
        public int f12208c;

        /* renamed from: d, reason: collision with root package name */
        public int f12209d;

        /* renamed from: e, reason: collision with root package name */
        public ViewGroup f12210e;

        /* renamed from: f, reason: collision with root package name */
        public ViewGroup f12211f;
    }

    public Visibility() {
        this.F = 3;
    }

    public static void P(TransitionValues transitionValues) {
        Integer numValueOf = Integer.valueOf(transitionValues.f12164b.getVisibility());
        HashMap map = transitionValues.f12163a;
        map.put("android:visibility:visibility", numValueOf);
        map.put("android:visibility:parent", transitionValues.f12164b.getParent());
        int[] iArr = new int[2];
        transitionValues.f12164b.getLocationOnScreen(iArr);
        map.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.transition.Visibility.VisibilityInfo Q(androidx.transition.TransitionValues r8, androidx.transition.TransitionValues r9) {
        /*
            androidx.transition.Visibility$VisibilityInfo r0 = new androidx.transition.Visibility$VisibilityInfo
            r0.<init>()
            r1 = 0
            r0.f12206a = r1
            r0.f12207b = r1
            r2 = 0
            r3 = -1
            java.lang.String r4 = "android:visibility:parent"
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L2f
            java.util.HashMap r6 = r8.f12163a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L2f
            java.lang.Object r7 = r6.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r0.f12208c = r7
            java.lang.Object r6 = r6.get(r4)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f12210e = r6
            goto L33
        L2f:
            r0.f12208c = r3
            r0.f12210e = r2
        L33:
            if (r9 == 0) goto L52
            java.util.HashMap r6 = r9.f12163a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L52
            java.lang.Object r2 = r6.get(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r0.f12209d = r2
            java.lang.Object r2 = r6.get(r4)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f12211f = r2
            goto L56
        L52:
            r0.f12209d = r3
            r0.f12211f = r2
        L56:
            r2 = 1
            if (r8 == 0) goto L8a
            if (r9 == 0) goto L8a
            int r8 = r0.f12208c
            int r9 = r0.f12209d
            if (r8 != r9) goto L68
            android.view.ViewGroup r3 = r0.f12210e
            android.view.ViewGroup r4 = r0.f12211f
            if (r3 != r4) goto L68
            goto L9f
        L68:
            if (r8 == r9) goto L78
            if (r8 != 0) goto L71
            r0.f12207b = r1
            r0.f12206a = r2
            return r0
        L71:
            if (r9 != 0) goto L9f
            r0.f12207b = r2
            r0.f12206a = r2
            return r0
        L78:
            android.view.ViewGroup r8 = r0.f12211f
            if (r8 != 0) goto L81
            r0.f12207b = r1
            r0.f12206a = r2
            return r0
        L81:
            android.view.ViewGroup r8 = r0.f12210e
            if (r8 != 0) goto L9f
            r0.f12207b = r2
            r0.f12206a = r2
            return r0
        L8a:
            if (r8 != 0) goto L95
            int r8 = r0.f12209d
            if (r8 != 0) goto L95
            r0.f12207b = r2
            r0.f12206a = r2
            return r0
        L95:
            if (r9 != 0) goto L9f
            int r8 = r0.f12208c
            if (r8 != 0) goto L9f
            r0.f12207b = r1
            r0.f12206a = r2
        L9f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.Q(androidx.transition.TransitionValues, androidx.transition.TransitionValues):androidx.transition.Visibility$VisibilityInfo");
    }

    public Animator R(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public Animator S(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public final void T(int i2) {
        if ((i2 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.F = i2;
    }

    @Override // androidx.transition.Transition
    public void d(TransitionValues transitionValues) {
        P(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void g(TransitionValues transitionValues) {
        P(transitionValues);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
    
        if (Q(n(r4, false), t(r4, false)).f12206a != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x020e  */
    @Override // androidx.transition.Transition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.animation.Animator k(android.view.ViewGroup r24, androidx.transition.TransitionValues r25, androidx.transition.TransitionValues r26) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 679
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.k(android.view.ViewGroup, androidx.transition.TransitionValues, androidx.transition.TransitionValues):android.animation.Animator");
    }

    @Override // androidx.transition.Transition
    public final String[] q() {
        return G;
    }

    @Override // androidx.transition.Transition
    public final boolean w(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null && transitionValues2 == null) {
            return false;
        }
        if (transitionValues != null && transitionValues2 != null && transitionValues2.f12163a.containsKey("android:visibility:visibility") != transitionValues.f12163a.containsKey("android:visibility:visibility")) {
            return false;
        }
        VisibilityInfo visibilityInfoQ = Q(transitionValues, transitionValues2);
        if (visibilityInfoQ.f12206a) {
            return visibilityInfoQ.f12208c == 0 || visibilityInfoQ.f12209d == 0;
        }
        return false;
    }

    public Visibility(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = 3;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f12108c);
        int iF = TypedArrayUtils.f(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        typedArrayObtainStyledAttributes.recycle();
        if (iF != 0) {
            T(iF);
        }
    }
}
