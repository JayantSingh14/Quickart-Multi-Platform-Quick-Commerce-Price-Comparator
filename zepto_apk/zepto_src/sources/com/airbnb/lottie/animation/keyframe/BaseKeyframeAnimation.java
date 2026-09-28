package com.airbnb.lottie.animation.keyframe;

import android.view.animation.BaseInterpolator;
import androidx.fragment.app.e;
import com.airbnb.lottie.L;
import com.airbnb.lottie.network.NetworkFetcher;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class BaseKeyframeAnimation<K, A> {

    /* renamed from: c, reason: collision with root package name */
    public final KeyframesWrapper f14331c;

    /* renamed from: e, reason: collision with root package name */
    public LottieValueCallback f14333e;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f14329a = new ArrayList(1);

    /* renamed from: b, reason: collision with root package name */
    public boolean f14330b = false;

    /* renamed from: d, reason: collision with root package name */
    public float f14332d = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    public Object f14334f = null;

    /* renamed from: g, reason: collision with root package name */
    public float f14335g = -1.0f;

    /* renamed from: h, reason: collision with root package name */
    public float f14336h = -1.0f;

    public interface AnimationListener {
        void a();
    }

    public static final class EmptyKeyframeWrapper<T> implements KeyframesWrapper<T> {
        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final boolean a(float f2) {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final Keyframe b() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final boolean c(float f2) {
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final float d() {
            return 0.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final float e() {
            return 1.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final boolean isEmpty() {
            return true;
        }
    }

    public interface KeyframesWrapper<T> {
        boolean a(float f2);

        Keyframe b();

        boolean c(float f2);

        float d();

        float e();

        boolean isEmpty();
    }

    public static final class KeyframesWrapperImpl<T> implements KeyframesWrapper<T> {

        /* renamed from: a, reason: collision with root package name */
        public final List f14337a;

        /* renamed from: c, reason: collision with root package name */
        public Keyframe f14339c = null;

        /* renamed from: d, reason: collision with root package name */
        public float f14340d = -1.0f;

        /* renamed from: b, reason: collision with root package name */
        public Keyframe f14338b = f(0.0f);

        public KeyframesWrapperImpl(List list) {
            this.f14337a = list;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final boolean a(float f2) {
            Keyframe keyframe = this.f14339c;
            Keyframe keyframe2 = this.f14338b;
            if (keyframe == keyframe2 && this.f14340d == f2) {
                return true;
            }
            this.f14339c = keyframe2;
            this.f14340d = f2;
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final Keyframe b() {
            return this.f14338b;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final boolean c(float f2) {
            Keyframe keyframe = this.f14338b;
            if (f2 >= keyframe.b() && f2 < keyframe.a()) {
                return !this.f14338b.c();
            }
            this.f14338b = f(f2);
            return true;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final float d() {
            return ((Keyframe) this.f14337a.get(0)).b();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final float e() {
            return ((Keyframe) e.k(1, this.f14337a)).a();
        }

        public final Keyframe f(float f2) {
            List list = this.f14337a;
            Keyframe keyframe = (Keyframe) e.k(1, list);
            if (f2 >= keyframe.b()) {
                return keyframe;
            }
            for (int size = list.size() - 2; size >= 1; size--) {
                Keyframe keyframe2 = (Keyframe) list.get(size);
                if (this.f14338b != keyframe2 && f2 >= keyframe2.b() && f2 < keyframe2.a()) {
                    return keyframe2;
                }
            }
            return (Keyframe) list.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final boolean isEmpty() {
            return false;
        }
    }

    public static final class SingleKeyframeWrapper<T> implements KeyframesWrapper<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Keyframe f14341a;

        /* renamed from: b, reason: collision with root package name */
        public float f14342b = -1.0f;

        public SingleKeyframeWrapper(List list) {
            this.f14341a = (Keyframe) list.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final boolean a(float f2) {
            if (this.f14342b == f2) {
                return true;
            }
            this.f14342b = f2;
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final Keyframe b() {
            return this.f14341a;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final boolean c(float f2) {
            return !this.f14341a.c();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final float d() {
            return this.f14341a.b();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final float e() {
            return this.f14341a.a();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.KeyframesWrapper
        public final boolean isEmpty() {
            return false;
        }
    }

    public BaseKeyframeAnimation(List list) {
        KeyframesWrapper singleKeyframeWrapper;
        if (list.isEmpty()) {
            singleKeyframeWrapper = new EmptyKeyframeWrapper();
        } else {
            singleKeyframeWrapper = list.size() == 1 ? new SingleKeyframeWrapper(list) : new KeyframesWrapperImpl(list);
        }
        this.f14331c = singleKeyframeWrapper;
    }

    public final void a(AnimationListener animationListener) {
        this.f14329a.add(animationListener);
    }

    public final Keyframe b() {
        NetworkFetcher networkFetcher = L.f14106a;
        return this.f14331c.b();
    }

    public float c() {
        if (this.f14336h == -1.0f) {
            this.f14336h = this.f14331c.e();
        }
        return this.f14336h;
    }

    public final float d() {
        BaseInterpolator baseInterpolator;
        Keyframe keyframeB = b();
        if (keyframeB == null || keyframeB.c() || (baseInterpolator = keyframeB.f14818d) == null) {
            return 0.0f;
        }
        return baseInterpolator.getInterpolation(e());
    }

    public final float e() {
        if (this.f14330b) {
            return 0.0f;
        }
        Keyframe keyframeB = b();
        if (keyframeB.c()) {
            return 0.0f;
        }
        return (this.f14332d - keyframeB.b()) / (keyframeB.a() - keyframeB.b());
    }

    public Object f() {
        BaseInterpolator baseInterpolator;
        float fE = e();
        if (this.f14333e == null && this.f14331c.a(fE)) {
            return this.f14334f;
        }
        Keyframe keyframeB = b();
        BaseInterpolator baseInterpolator2 = keyframeB.f14819e;
        Object objG = (baseInterpolator2 == null || (baseInterpolator = keyframeB.f14820f) == null) ? g(keyframeB, d()) : h(keyframeB, fE, baseInterpolator2.getInterpolation(fE), baseInterpolator.getInterpolation(fE));
        this.f14334f = objG;
        return objG;
    }

    public abstract Object g(Keyframe keyframe, float f2);

    public Object h(Keyframe keyframe, float f2, float f3, float f4) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public void i() {
        NetworkFetcher networkFetcher = L.f14106a;
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f14329a;
            if (i2 >= arrayList.size()) {
                NetworkFetcher networkFetcher2 = L.f14106a;
                return;
            } else {
                ((AnimationListener) arrayList.get(i2)).a();
                i2++;
            }
        }
    }

    public void j(float f2) {
        NetworkFetcher networkFetcher = L.f14106a;
        KeyframesWrapper keyframesWrapper = this.f14331c;
        if (keyframesWrapper.isEmpty()) {
            return;
        }
        if (this.f14335g == -1.0f) {
            this.f14335g = keyframesWrapper.d();
        }
        float f3 = this.f14335g;
        if (f2 < f3) {
            if (f3 == -1.0f) {
                this.f14335g = keyframesWrapper.d();
            }
            f2 = this.f14335g;
        } else if (f2 > c()) {
            f2 = c();
        }
        if (f2 == this.f14332d) {
            return;
        }
        this.f14332d = f2;
        if (keyframesWrapper.c(f2)) {
            i();
        }
    }

    public final void k(LottieValueCallback lottieValueCallback) {
        LottieValueCallback lottieValueCallback2 = this.f14333e;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.getClass();
        }
        this.f14333e = lottieValueCallback;
    }
}
