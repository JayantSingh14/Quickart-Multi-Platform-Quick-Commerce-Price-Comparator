package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class WindowInsetsAnimationCompat {

    /* renamed from: a, reason: collision with root package name */
    public Impl f3120a;

    public static abstract class Callback {
        public static final int DISPATCH_MODE_CONTINUE_ON_SUBTREE = 1;
        public static final int DISPATCH_MODE_STOP = 0;
        WindowInsetsCompat mDispachedInsets;
        private final int mDispatchMode;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo
        /* loaded from: classes3.dex */
        public @interface DispatchMode {
        }

        public Callback(int i2) {
            this.mDispatchMode = i2;
        }

        public final int getDispatchMode() {
            return this.mDispatchMode;
        }

        public void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        public void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        public abstract WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List list);

        public BoundsCompat onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, BoundsCompat boundsCompat) {
            return boundsCompat;
        }
    }

    public static class Impl {

        /* renamed from: a, reason: collision with root package name */
        public final int f3123a;

        /* renamed from: b, reason: collision with root package name */
        public float f3124b;

        /* renamed from: c, reason: collision with root package name */
        public final Interpolator f3125c;

        /* renamed from: d, reason: collision with root package name */
        public final long f3126d;

        public Impl(int i2, Interpolator interpolator, long j2) {
            this.f3123a = i2;
            this.f3125c = interpolator;
            this.f3126d = j2;
        }

        public float a() {
            return 1.0f;
        }

        public long b() {
            return this.f3126d;
        }

        public float c() {
            return this.f3124b;
        }

        public float d() {
            Interpolator interpolator = this.f3125c;
            return interpolator != null ? interpolator.getInterpolation(this.f3124b) : this.f3124b;
        }

        public int e() {
            return this.f3123a;
        }

        public void f(float f2) {
            this.f3124b = f2;
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Impl21 extends Impl {

        /* renamed from: e, reason: collision with root package name */
        public static final PathInterpolator f3127e = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);

        /* renamed from: f, reason: collision with root package name */
        public static final FastOutLinearInInterpolator f3128f = new FastOutLinearInInterpolator();

        /* renamed from: g, reason: collision with root package name */
        public static final DecelerateInterpolator f3129g = new DecelerateInterpolator(1.5f);

        /* renamed from: h, reason: collision with root package name */
        public static final AccelerateInterpolator f3130h = new AccelerateInterpolator(1.5f);

        @RequiresApi
        public static class Impl21OnApplyWindowInsetsListener implements View.OnApplyWindowInsetsListener {

            /* renamed from: a, reason: collision with root package name */
            public final Callback f3131a;

            /* renamed from: b, reason: collision with root package name */
            public WindowInsetsCompat f3132b;

            public Impl21OnApplyWindowInsetsListener(View view, Callback callback) {
                this.f3131a = callback;
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                WindowInsetsCompat windowInsetsCompatA = ViewCompat.Api23Impl.a(view);
                this.f3132b = windowInsetsCompatA != null ? new WindowInsetsCompat.Builder(windowInsetsCompatA).f3151a.b() : null;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(final View view, WindowInsets windowInsets) {
                WindowInsetsCompat.Impl impl;
                boolean z = true;
                if (!view.isLaidOut()) {
                    this.f3132b = WindowInsetsCompat.r(view, windowInsets);
                    return Impl21.k(view, windowInsets);
                }
                final WindowInsetsCompat windowInsetsCompatR = WindowInsetsCompat.r(view, windowInsets);
                if (this.f3132b == null) {
                    WeakHashMap weakHashMap = ViewCompat.f3080a;
                    this.f3132b = ViewCompat.Api23Impl.a(view);
                }
                if (this.f3132b == null) {
                    this.f3132b = windowInsetsCompatR;
                    return Impl21.k(view, windowInsets);
                }
                Callback callbackL = Impl21.l(view);
                if (callbackL != null && Objects.equals(callbackL.mDispachedInsets, windowInsetsCompatR)) {
                    return Impl21.k(view, windowInsets);
                }
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                WindowInsetsCompat windowInsetsCompat = this.f3132b;
                int i2 = 1;
                while (true) {
                    impl = windowInsetsCompatR.f3150a;
                    if (i2 > 512) {
                        break;
                    }
                    Insets insetsG = impl.g(i2);
                    Insets insetsG2 = windowInsetsCompat.f3150a.g(i2);
                    int i3 = insetsG.f2808a;
                    int i4 = insetsG2.f2808a;
                    int i5 = insetsG.f2811d;
                    int i6 = insetsG.f2810c;
                    int i7 = insetsG.f2809b;
                    int i8 = insetsG2.f2811d;
                    boolean z2 = z;
                    int i9 = insetsG2.f2810c;
                    int i10 = insetsG2.f2809b;
                    boolean z3 = (i3 > i4 || i7 > i10 || i6 > i9 || i5 > i8) ? z2 : false;
                    if (z3 != ((i3 < i4 || i7 < i10 || i6 < i9 || i5 < i8) ? z2 : false)) {
                        if (z3) {
                            iArr[0] = iArr[0] | i2;
                        } else {
                            iArr2[0] = iArr2[0] | i2;
                        }
                    }
                    i2 <<= 1;
                    z = z2;
                }
                int i11 = iArr[0];
                int i12 = iArr2[0];
                final int i13 = i11 | i12;
                if (i13 == 0) {
                    this.f3132b = windowInsetsCompatR;
                    return Impl21.k(view, windowInsets);
                }
                final WindowInsetsCompat windowInsetsCompat2 = this.f3132b;
                final WindowInsetsAnimationCompat windowInsetsAnimationCompat = new WindowInsetsAnimationCompat(i13, (i11 & 8) != 0 ? Impl21.f3127e : (i12 & 8) != 0 ? Impl21.f3128f : (i11 & 519) != 0 ? Impl21.f3129g : (i12 & 519) != 0 ? Impl21.f3130h : null, (i13 & 8) != 0 ? 160L : 250L);
                windowInsetsAnimationCompat.f3120a.f(0.0f);
                final ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(windowInsetsAnimationCompat.f3120a.b());
                Insets insetsG3 = impl.g(i13);
                Insets insetsG4 = windowInsetsCompat2.f3150a.g(i13);
                int iMin = Math.min(insetsG3.f2808a, insetsG4.f2808a);
                int i14 = insetsG3.f2809b;
                int i15 = insetsG4.f2809b;
                int iMin2 = Math.min(i14, i15);
                int i16 = insetsG3.f2810c;
                int i17 = insetsG4.f2810c;
                int iMin3 = Math.min(i16, i17);
                int i18 = insetsG3.f2811d;
                int i19 = insetsG4.f2811d;
                final BoundsCompat boundsCompat = new BoundsCompat(Insets.c(iMin, iMin2, iMin3, Math.min(i18, i19)), Insets.c(Math.max(insetsG3.f2808a, insetsG4.f2808a), Math.max(i14, i15), Math.max(i16, i17), Math.max(i18, i19)));
                Impl21.h(view, windowInsetsAnimationCompat, windowInsetsCompatR, false);
                duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float f2;
                        int i20;
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        WindowInsetsAnimationCompat windowInsetsAnimationCompat2 = windowInsetsAnimationCompat;
                        windowInsetsAnimationCompat2.f3120a.f(animatedFraction);
                        float fD = windowInsetsAnimationCompat2.f3120a.d();
                        PathInterpolator pathInterpolator = Impl21.f3127e;
                        WindowInsetsCompat windowInsetsCompat3 = windowInsetsCompatR;
                        WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder(windowInsetsCompat3);
                        int i21 = 1;
                        while (i21 <= 512) {
                            int i22 = i13 & i21;
                            WindowInsetsCompat.Impl impl2 = windowInsetsCompat3.f3150a;
                            if (i22 == 0) {
                                builder.b(i21, impl2.g(i21));
                                f2 = fD;
                                i20 = 1;
                            } else {
                                Insets insetsG5 = impl2.g(i21);
                                Insets insetsG6 = windowInsetsCompat2.f3150a.g(i21);
                                float f3 = 1.0f - fD;
                                f2 = fD;
                                i20 = 1;
                                builder.b(i21, WindowInsetsCompat.m(insetsG5, (int) (((insetsG5.f2808a - insetsG6.f2808a) * f3) + 0.5d), (int) (((insetsG5.f2809b - insetsG6.f2809b) * f3) + 0.5d), (int) (((insetsG5.f2810c - insetsG6.f2810c) * f3) + 0.5d), (int) (((insetsG5.f2811d - insetsG6.f2811d) * f3) + 0.5d)));
                            }
                            i21 <<= i20;
                            fD = f2;
                        }
                        Impl21.i(view, builder.f3151a.b(), Collections.singletonList(windowInsetsAnimationCompat2));
                    }
                });
                duration.addListener(new AnimatorListenerAdapter() { // from class: androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        WindowInsetsAnimationCompat windowInsetsAnimationCompat2 = windowInsetsAnimationCompat;
                        windowInsetsAnimationCompat2.f3120a.f(1.0f);
                        Impl21.g(view, windowInsetsAnimationCompat2);
                    }
                });
                OneShotPreDrawListener.a(view, new Runnable() { // from class: androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        Impl21.j(view, windowInsetsAnimationCompat, boundsCompat);
                        duration.start();
                    }
                });
                this.f3132b = windowInsetsCompatR;
                return Impl21.k(view, windowInsets);
            }
        }

        public Impl21(int i2, Interpolator interpolator, long j2) {
            super(i2, interpolator, j2);
        }

        public static void g(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            Callback callbackL = l(view);
            if (callbackL != null) {
                callbackL.onEnd(windowInsetsAnimationCompat);
                if (callbackL.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    g(viewGroup.getChildAt(i2), windowInsetsAnimationCompat);
                }
            }
        }

        public static void h(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsCompat windowInsetsCompat, boolean z) {
            Callback callbackL = l(view);
            if (callbackL != null) {
                callbackL.mDispachedInsets = windowInsetsCompat;
                if (!z) {
                    callbackL.onPrepare(windowInsetsAnimationCompat);
                    z = callbackL.getDispatchMode() == 0;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    h(viewGroup.getChildAt(i2), windowInsetsAnimationCompat, windowInsetsCompat, z);
                }
            }
        }

        public static void i(View view, WindowInsetsCompat windowInsetsCompat, List list) {
            Callback callbackL = l(view);
            if (callbackL != null) {
                windowInsetsCompat = callbackL.onProgress(windowInsetsCompat, list);
                if (callbackL.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    i(viewGroup.getChildAt(i2), windowInsetsCompat, list);
                }
            }
        }

        public static void j(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, BoundsCompat boundsCompat) {
            Callback callbackL = l(view);
            if (callbackL != null) {
                callbackL.onStart(windowInsetsAnimationCompat, boundsCompat);
                if (callbackL.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    j(viewGroup.getChildAt(i2), windowInsetsAnimationCompat, boundsCompat);
                }
            }
        }

        public static WindowInsets k(View view, WindowInsets windowInsets) {
            return view.getTag(R.id.tag_on_apply_window_listener) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
        }

        public static Callback l(View view) {
            Object tag = view.getTag(R.id.tag_window_insets_animation_callback);
            if (tag instanceof Impl21OnApplyWindowInsetsListener) {
                return ((Impl21OnApplyWindowInsetsListener) tag).f3131a;
            }
            return null;
        }

        public static void m(View view, Callback callback) {
            View.OnApplyWindowInsetsListener impl21OnApplyWindowInsetsListener = callback != null ? new Impl21OnApplyWindowInsetsListener(view, callback) : null;
            view.setTag(R.id.tag_window_insets_animation_callback, impl21OnApplyWindowInsetsListener);
            if (view.getTag(R.id.tag_compat_insets_dispatch) == null && view.getTag(R.id.tag_on_apply_window_listener) == null) {
                view.setOnApplyWindowInsetsListener(impl21OnApplyWindowInsetsListener);
            }
        }
    }

    @RequiresApi
    public static class Impl30 extends Impl {

        /* renamed from: e, reason: collision with root package name */
        public final WindowInsetsAnimation f3144e;

        @RequiresApi
        public static class ProxyCallback extends WindowInsetsAnimation$Callback {

            /* renamed from: a, reason: collision with root package name */
            public final Callback f3145a;

            /* renamed from: b, reason: collision with root package name */
            public List f3146b;

            /* renamed from: c, reason: collision with root package name */
            public ArrayList f3147c;

            /* renamed from: d, reason: collision with root package name */
            public final HashMap f3148d;

            public ProxyCallback(Callback callback) {
                super(callback.getDispatchMode());
                this.f3148d = new HashMap();
                this.f3145a = callback;
            }

            public final WindowInsetsAnimationCompat a(WindowInsetsAnimation windowInsetsAnimation) {
                WindowInsetsAnimationCompat windowInsetsAnimationCompat = (WindowInsetsAnimationCompat) this.f3148d.get(windowInsetsAnimation);
                if (windowInsetsAnimationCompat == null) {
                    windowInsetsAnimationCompat = new WindowInsetsAnimationCompat(0, null, 0L);
                    if (Build.VERSION.SDK_INT >= 30) {
                        windowInsetsAnimationCompat.f3120a = new Impl30(windowInsetsAnimation);
                    }
                    this.f3148d.put(windowInsetsAnimation, windowInsetsAnimationCompat);
                }
                return windowInsetsAnimationCompat;
            }

            public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
                this.f3145a.onEnd(a(windowInsetsAnimation));
                this.f3148d.remove(windowInsetsAnimation);
            }

            public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
                this.f3145a.onPrepare(a(windowInsetsAnimation));
            }

            public final WindowInsets onProgress(WindowInsets windowInsets, List list) {
                ArrayList arrayList = this.f3147c;
                if (arrayList == null) {
                    ArrayList arrayList2 = new ArrayList(list.size());
                    this.f3147c = arrayList2;
                    this.f3146b = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimation windowInsetsAnimationK = e.k(list.get(size));
                    WindowInsetsAnimationCompat windowInsetsAnimationCompatA = a(windowInsetsAnimationK);
                    windowInsetsAnimationCompatA.f3120a.f(windowInsetsAnimationK.getFraction());
                    this.f3147c.add(windowInsetsAnimationCompatA);
                }
                return this.f3145a.onProgress(WindowInsetsCompat.r(null, windowInsets), this.f3146b).q();
            }

            public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
                return this.f3145a.onStart(a(windowInsetsAnimation), BoundsCompat.b(bounds)).a();
            }
        }

        public Impl30(WindowInsetsAnimation windowInsetsAnimation) {
            super(0, null, 0L);
            this.f3144e = windowInsetsAnimation;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public final float a() {
            return this.f3144e.getAlpha();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public final long b() {
            return this.f3144e.getDurationMillis();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public final float c() {
            return this.f3144e.getFraction();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public final float d() {
            return this.f3144e.getInterpolatedFraction();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public final int e() {
            return this.f3144e.getTypeMask();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public final void f(float f2) {
            this.f3144e.setFraction(f2);
        }
    }

    public WindowInsetsAnimationCompat(int i2, Interpolator interpolator, long j2) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f3120a = new Impl30(e.j(i2, interpolator, j2));
        } else {
            this.f3120a = new Impl21(i2, interpolator, j2);
        }
    }

    public final float a() {
        return this.f3120a.a();
    }

    public final float b() {
        return this.f3120a.c();
    }

    public final float c() {
        return this.f3120a.d();
    }

    public final int d() {
        return this.f3120a.e();
    }

    /* loaded from: classes3.dex */
    public static final class BoundsCompat {

        /* renamed from: a, reason: collision with root package name */
        public final Insets f3121a;

        /* renamed from: b, reason: collision with root package name */
        public final Insets f3122b;

        public BoundsCompat(Insets insets, Insets insets2) {
            this.f3121a = insets;
            this.f3122b = insets2;
        }

        public static BoundsCompat b(WindowInsetsAnimation.Bounds bounds) {
            return new BoundsCompat(bounds);
        }

        public final WindowInsetsAnimation.Bounds a() {
            e.n();
            return e.i(this.f3121a.e(), this.f3122b.e());
        }

        public final String toString() {
            return "Bounds{lower=" + this.f3121a + " upper=" + this.f3122b + "}";
        }

        public BoundsCompat(WindowInsetsAnimation.Bounds bounds) {
            this.f3121a = Insets.d(bounds.getLowerBound());
            this.f3122b = Insets.d(bounds.getUpperBound());
        }
    }
}
