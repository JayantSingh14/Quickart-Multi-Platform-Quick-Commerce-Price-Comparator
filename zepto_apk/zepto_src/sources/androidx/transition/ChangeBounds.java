package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.ObjectAnimatorUtils;
import androidx.transition.Transition;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class ChangeBounds extends Transition {
    public static final String[] G = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final Property H = new AnonymousClass1(PointF.class, "topLeft");
    public static final Property I = new AnonymousClass2(PointF.class, "bottomRight");
    public static final Property J = new AnonymousClass3(PointF.class, "bottomRight");
    public static final Property K = new AnonymousClass4(PointF.class, "topLeft");
    public static final Property L = new AnonymousClass5(PointF.class, "position");
    public static final RectEvaluator M = new RectEvaluator();
    public final boolean F;

    /* renamed from: androidx.transition.ChangeBounds$1, reason: invalid class name */
    public class AnonymousClass1 extends Property<ViewBounds, PointF> {
        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(ViewBounds viewBounds) {
            return null;
        }

        @Override // android.util.Property
        public final void set(ViewBounds viewBounds, PointF pointF) {
            ViewBounds viewBounds2 = viewBounds;
            PointF pointF2 = pointF;
            viewBounds2.getClass();
            viewBounds2.f12028a = Math.round(pointF2.x);
            int iRound = Math.round(pointF2.y);
            viewBounds2.f12029b = iRound;
            int i2 = viewBounds2.f12033f + 1;
            viewBounds2.f12033f = i2;
            if (i2 == viewBounds2.f12034g) {
                ViewUtils.a(viewBounds2.f12032e, viewBounds2.f12028a, iRound, viewBounds2.f12030c, viewBounds2.f12031d);
                viewBounds2.f12033f = 0;
                viewBounds2.f12034g = 0;
            }
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$2, reason: invalid class name */
    public class AnonymousClass2 extends Property<ViewBounds, PointF> {
        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(ViewBounds viewBounds) {
            return null;
        }

        @Override // android.util.Property
        public final void set(ViewBounds viewBounds, PointF pointF) {
            ViewBounds viewBounds2 = viewBounds;
            PointF pointF2 = pointF;
            viewBounds2.getClass();
            viewBounds2.f12030c = Math.round(pointF2.x);
            int iRound = Math.round(pointF2.y);
            viewBounds2.f12031d = iRound;
            int i2 = viewBounds2.f12034g + 1;
            viewBounds2.f12034g = i2;
            if (viewBounds2.f12033f == i2) {
                ViewUtils.a(viewBounds2.f12032e, viewBounds2.f12028a, viewBounds2.f12029b, viewBounds2.f12030c, iRound);
                viewBounds2.f12033f = 0;
                viewBounds2.f12034g = 0;
            }
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$3, reason: invalid class name */
    public class AnonymousClass3 extends Property<View, PointF> {
        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public final void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            ViewUtils.a(view2, view2.getLeft(), view2.getTop(), Math.round(pointF2.x), Math.round(pointF2.y));
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$4, reason: invalid class name */
    public class AnonymousClass4 extends Property<View, PointF> {
        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public final void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            ViewUtils.a(view2, Math.round(pointF2.x), Math.round(pointF2.y), view2.getRight(), view2.getBottom());
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$5, reason: invalid class name */
    public class AnonymousClass5 extends Property<View, PointF> {
        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public final void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            int iRound = Math.round(pointF2.x);
            int iRound2 = Math.round(pointF2.y);
            ViewUtils.a(view2, iRound, iRound2, view2.getWidth() + iRound, view2.getHeight() + iRound2);
        }
    }

    public static class ClipListener extends AnimatorListenerAdapter implements Transition.TransitionListener {

        /* renamed from: a, reason: collision with root package name */
        public final View f12013a;

        /* renamed from: b, reason: collision with root package name */
        public final Rect f12014b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f12015c;

        /* renamed from: d, reason: collision with root package name */
        public final Rect f12016d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f12017e;

        /* renamed from: f, reason: collision with root package name */
        public final int f12018f;

        /* renamed from: g, reason: collision with root package name */
        public final int f12019g;

        /* renamed from: h, reason: collision with root package name */
        public final int f12020h;

        /* renamed from: i, reason: collision with root package name */
        public final int f12021i;

        /* renamed from: j, reason: collision with root package name */
        public final int f12022j;

        /* renamed from: k, reason: collision with root package name */
        public final int f12023k;

        /* renamed from: l, reason: collision with root package name */
        public final int f12024l;

        /* renamed from: m, reason: collision with root package name */
        public final int f12025m;
        public boolean n;

        public ClipListener(View view, Rect rect, boolean z, Rect rect2, boolean z2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this.f12013a = view;
            this.f12014b = rect;
            this.f12015c = z;
            this.f12016d = rect2;
            this.f12017e = z2;
            this.f12018f = i2;
            this.f12019g = i3;
            this.f12020h = i4;
            this.f12021i = i5;
            this.f12022j = i6;
            this.f12023k = i7;
            this.f12024l = i8;
            this.f12025m = i9;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void b() {
            View view = this.f12013a;
            view.setTag(R.id.transition_clip, view.getClipBounds());
            view.setClipBounds(this.f12017e ? null : this.f12016d);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void f() {
            int i2 = R.id.transition_clip;
            View view = this.f12013a;
            Rect rect = (Rect) view.getTag(i2);
            view.setTag(R.id.transition_clip, null);
            view.setClipBounds(rect);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void h(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void j(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void l(Transition transition) {
            this.n = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            onAnimationStart(animator, false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator, boolean z) {
            if (this.n) {
                return;
            }
            Rect rect = null;
            if (z) {
                if (!this.f12015c) {
                    rect = this.f12014b;
                }
            } else if (!this.f12017e) {
                rect = this.f12016d;
            }
            View view = this.f12013a;
            view.setClipBounds(rect);
            if (z) {
                ViewUtils.a(view, this.f12018f, this.f12019g, this.f12020h, this.f12021i);
            } else {
                ViewUtils.a(view, this.f12022j, this.f12023k, this.f12024l, this.f12025m);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator, boolean z) {
            int i2 = this.f12020h;
            int i3 = this.f12018f;
            int i4 = this.f12024l;
            int i5 = this.f12022j;
            int iMax = Math.max(i2 - i3, i4 - i5);
            int i6 = this.f12021i;
            int i7 = this.f12019g;
            int i8 = this.f12025m;
            int i9 = this.f12023k;
            int iMax2 = Math.max(i6 - i7, i8 - i9);
            if (z) {
                i3 = i5;
            }
            if (z) {
                i7 = i9;
            }
            View view = this.f12013a;
            ViewUtils.a(view, i3, i7, iMax + i3, iMax2 + i7);
            view.setClipBounds(z ? this.f12016d : this.f12014b);
        }
    }

    public static class SuppressLayoutListener extends TransitionListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f12026a = false;

        /* renamed from: b, reason: collision with root package name */
        public final ViewGroup f12027b;

        public SuppressLayoutListener(ViewGroup viewGroup) {
            this.f12027b = viewGroup;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public final void b() {
            ViewGroupUtils.a(this.f12027b, false);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public final void f() {
            ViewGroupUtils.a(this.f12027b, true);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public final void j(Transition transition) {
            if (!this.f12026a) {
                ViewGroupUtils.a(this.f12027b, false);
            }
            transition.B(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public final void l(Transition transition) {
            ViewGroupUtils.a(this.f12027b, false);
            this.f12026a = true;
        }
    }

    public static class ViewBounds {

        /* renamed from: a, reason: collision with root package name */
        public int f12028a;

        /* renamed from: b, reason: collision with root package name */
        public int f12029b;

        /* renamed from: c, reason: collision with root package name */
        public int f12030c;

        /* renamed from: d, reason: collision with root package name */
        public int f12031d;

        /* renamed from: e, reason: collision with root package name */
        public final View f12032e;

        /* renamed from: f, reason: collision with root package name */
        public int f12033f;

        /* renamed from: g, reason: collision with root package name */
        public int f12034g;

        public ViewBounds(View view) {
            this.f12032e = view;
        }
    }

    public ChangeBounds() {
        this.F = false;
    }

    public final void P(TransitionValues transitionValues) {
        View view = transitionValues.f12164b;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        Rect rect = new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        HashMap map = transitionValues.f12163a;
        map.put("android:changeBounds:bounds", rect);
        map.put("android:changeBounds:parent", transitionValues.f12164b.getParent());
        if (this.F) {
            map.put("android:changeBounds:clip", view.getClipBounds());
        }
    }

    @Override // androidx.transition.Transition
    public final void d(TransitionValues transitionValues) {
        P(transitionValues);
    }

    @Override // androidx.transition.Transition
    public final void g(TransitionValues transitionValues) {
        Rect rect;
        P(transitionValues);
        if (!this.F || (rect = (Rect) transitionValues.f12164b.getTag(R.id.transition_clip)) == null) {
            return;
        }
        transitionValues.f12163a.put("android:changeBounds:clip", rect);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.transition.Transition
    public final Animator k(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i2;
        int i3;
        int i4;
        int i5;
        Animator animatorA;
        int i6;
        Rect rect;
        Animator animatorOfObject;
        if (transitionValues != null && transitionValues2 != null) {
            HashMap map = transitionValues.f12163a;
            HashMap map2 = transitionValues2.f12163a;
            ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
            ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
            if (viewGroup2 != null && viewGroup3 != null) {
                View view = transitionValues2.f12164b;
                Rect rect2 = (Rect) map.get("android:changeBounds:bounds");
                Rect rect3 = (Rect) map2.get("android:changeBounds:bounds");
                int i7 = rect2.left;
                int i8 = rect3.left;
                int i9 = rect2.top;
                int i10 = rect3.top;
                int i11 = rect2.right;
                int i12 = rect3.right;
                int i13 = rect2.bottom;
                int i14 = rect3.bottom;
                int i15 = i11 - i7;
                int i16 = i13 - i9;
                int i17 = i12 - i8;
                int i18 = i14 - i10;
                Rect rect4 = (Rect) map.get("android:changeBounds:clip");
                Rect rect5 = (Rect) map2.get("android:changeBounds:clip");
                if ((i15 == 0 || i16 == 0) && (i17 == 0 || i18 == 0)) {
                    i2 = 0;
                } else {
                    i2 = (i7 == i8 && i9 == i10) ? 0 : 1;
                    if (i11 != i12 || i13 != i14) {
                        i2++;
                    }
                }
                if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                    i2++;
                }
                if (i2 <= 0) {
                    return null;
                }
                boolean z = this.F;
                Property property = L;
                if (z) {
                    ViewUtils.a(view, i7, i9, i7 + Math.max(i15, i17), i9 + Math.max(i16, i18));
                    if (i7 == i8 && i9 == i10) {
                        animatorA = null;
                        i3 = i13;
                        i4 = i7;
                        i5 = i8;
                    } else {
                        i3 = i13;
                        i4 = i7;
                        i5 = i8;
                        animatorA = ObjectAnimatorUtils.Api21Impl.a(view, property, this.x.a(i7, i9, i8, i10));
                    }
                    boolean z2 = rect4 == null;
                    if (z2) {
                        i6 = 0;
                        rect = new Rect(0, 0, i15, i16);
                    } else {
                        i6 = 0;
                        rect = rect4;
                    }
                    boolean z3 = rect5 == null ? 1 : i6;
                    Rect rect6 = z3 != 0 ? new Rect(i6, i6, i17, i18) : rect5;
                    if (rect.equals(rect6)) {
                        animatorOfObject = null;
                    } else {
                        view.setClipBounds(rect);
                        animatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", M, rect, rect6);
                        ClipListener clipListener = new ClipListener(view, rect, z2, rect6, z3, i4, i9, i11, i3, i5, i10, i12, i14);
                        animatorOfObject.addListener(clipListener);
                        a(clipListener);
                    }
                    boolean z4 = TransitionUtils.f12159a;
                    if (animatorA == null) {
                        animatorA = animatorOfObject;
                    } else if (animatorOfObject != null) {
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(animatorA, animatorOfObject);
                        animatorA = animatorSet;
                    }
                } else {
                    ViewUtils.a(view, i7, i9, i11, i13);
                    if (i2 != 2) {
                        animatorA = (i7 == i8 && i9 == i10) ? ObjectAnimatorUtils.Api21Impl.a(view, J, this.x.a(i11, i13, i12, i14)) : ObjectAnimatorUtils.Api21Impl.a(view, K, this.x.a(i7, i9, i8, i10));
                    } else if (i15 == i17 && i16 == i18) {
                        animatorA = ObjectAnimatorUtils.Api21Impl.a(view, property, this.x.a(i7, i9, i8, i10));
                    } else {
                        ViewBounds viewBounds = new ViewBounds(view);
                        Animator animatorA2 = ObjectAnimatorUtils.Api21Impl.a(viewBounds, H, this.x.a(i7, i9, i8, i10));
                        Animator animatorA3 = ObjectAnimatorUtils.Api21Impl.a(viewBounds, I, this.x.a(i11, i13, i12, i14));
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        animatorSet2.playTogether(animatorA2, animatorA3);
                        animatorSet2.addListener(new AnimatorListenerAdapter(viewBounds) { // from class: androidx.transition.ChangeBounds.6
                            private final ViewBounds mViewBounds;

                            {
                                this.mViewBounds = viewBounds;
                            }
                        });
                        animatorA = animatorSet2;
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                    ViewGroupUtils.a(viewGroup4, true);
                    o().a(new SuppressLayoutListener(viewGroup4));
                }
                return animatorA;
            }
        }
        return null;
    }

    @Override // androidx.transition.Transition
    public final String[] q() {
        return G;
    }

    public ChangeBounds(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f12107b);
        boolean zB = TypedArrayUtils.b(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        typedArrayObtainStyledAttributes.recycle();
        this.F = zB;
    }
}
