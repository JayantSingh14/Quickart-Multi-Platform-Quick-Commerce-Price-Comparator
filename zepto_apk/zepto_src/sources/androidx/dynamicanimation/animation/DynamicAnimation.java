package androidx.dynamicanimation.animation;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.AnimationHandler;
import androidx.dynamicanimation.animation.DynamicAnimation;
import com.google.android.material.progressindicator.DeterminateDrawable;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public abstract class DynamicAnimation<T extends DynamicAnimation<T>> implements AnimationHandler.AnimationFrameCallback {

    /* renamed from: m, reason: collision with root package name */
    public static final ViewProperty f4263m = new AnonymousClass4();
    public static final ViewProperty n = new AnonymousClass5();
    public static final ViewProperty o = new AnonymousClass6();
    public static final ViewProperty p = new AnonymousClass7();
    public static final ViewProperty q = new AnonymousClass8();
    public static final ViewProperty r = new AnonymousClass12();

    /* renamed from: a, reason: collision with root package name */
    public float f4264a;

    /* renamed from: b, reason: collision with root package name */
    public float f4265b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4266c;

    /* renamed from: d, reason: collision with root package name */
    public final DeterminateDrawable f4267d;

    /* renamed from: e, reason: collision with root package name */
    public final FloatPropertyCompat f4268e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4269f;

    /* renamed from: g, reason: collision with root package name */
    public float f4270g;

    /* renamed from: h, reason: collision with root package name */
    public float f4271h;

    /* renamed from: i, reason: collision with root package name */
    public long f4272i;

    /* renamed from: j, reason: collision with root package name */
    public float f4273j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f4274k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f4275l;

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$1, reason: invalid class name */
    public static class AnonymousClass1 extends ViewProperty {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final float a(DeterminateDrawable determinateDrawable) {
            return ((View) determinateDrawable).getTranslationX();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final void b(DeterminateDrawable determinateDrawable, float f2) {
            ((View) determinateDrawable).setTranslationX(f2);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$10, reason: invalid class name */
    public static class AnonymousClass10 extends ViewProperty {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final float a(DeterminateDrawable determinateDrawable) {
            return ((View) determinateDrawable).getY();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final void b(DeterminateDrawable determinateDrawable, float f2) {
            ((View) determinateDrawable).setY(f2);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$11, reason: invalid class name */
    public static class AnonymousClass11 extends ViewProperty {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final float a(DeterminateDrawable determinateDrawable) {
            return ViewCompat.q((View) determinateDrawable);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final void b(DeterminateDrawable determinateDrawable, float f2) {
            ViewCompat.P((View) determinateDrawable, f2);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$12, reason: invalid class name */
    public static class AnonymousClass12 extends ViewProperty {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final float a(DeterminateDrawable determinateDrawable) {
            return ((View) determinateDrawable).getAlpha();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final void b(DeterminateDrawable determinateDrawable, float f2) {
            ((View) determinateDrawable).setAlpha(f2);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$13, reason: invalid class name */
    public static class AnonymousClass13 extends ViewProperty {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final float a(DeterminateDrawable determinateDrawable) {
            return ((View) determinateDrawable).getScrollX();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final void b(DeterminateDrawable determinateDrawable, float f2) {
            ((View) determinateDrawable).setScrollX((int) f2);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$14, reason: invalid class name */
    public static class AnonymousClass14 extends ViewProperty {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final float a(DeterminateDrawable determinateDrawable) {
            return ((View) determinateDrawable).getScrollY();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final void b(DeterminateDrawable determinateDrawable, float f2) {
            ((View) determinateDrawable).setScrollY((int) f2);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$2, reason: invalid class name */
    public static class AnonymousClass2 extends ViewProperty {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final float a(DeterminateDrawable determinateDrawable) {
            return ((View) determinateDrawable).getTranslationY();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final void b(DeterminateDrawable determinateDrawable, float f2) {
            ((View) determinateDrawable).setTranslationY(f2);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$3, reason: invalid class name */
    public static class AnonymousClass3 extends ViewProperty {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final float a(DeterminateDrawable determinateDrawable) {
            return ViewCompat.o((View) determinateDrawable);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final void b(DeterminateDrawable determinateDrawable, float f2) {
            ViewCompat.N((View) determinateDrawable, f2);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$4, reason: invalid class name */
    public static class AnonymousClass4 extends ViewProperty {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final float a(DeterminateDrawable determinateDrawable) {
            return ((View) determinateDrawable).getScaleX();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final void b(DeterminateDrawable determinateDrawable, float f2) {
            ((View) determinateDrawable).setScaleX(f2);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$5, reason: invalid class name */
    public static class AnonymousClass5 extends ViewProperty {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final float a(DeterminateDrawable determinateDrawable) {
            return ((View) determinateDrawable).getScaleY();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final void b(DeterminateDrawable determinateDrawable, float f2) {
            ((View) determinateDrawable).setScaleY(f2);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$6, reason: invalid class name */
    public static class AnonymousClass6 extends ViewProperty {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final float a(DeterminateDrawable determinateDrawable) {
            return ((View) determinateDrawable).getRotation();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final void b(DeterminateDrawable determinateDrawable, float f2) {
            ((View) determinateDrawable).setRotation(f2);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$7, reason: invalid class name */
    public static class AnonymousClass7 extends ViewProperty {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final float a(DeterminateDrawable determinateDrawable) {
            return ((View) determinateDrawable).getRotationX();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final void b(DeterminateDrawable determinateDrawable, float f2) {
            ((View) determinateDrawable).setRotationX(f2);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$8, reason: invalid class name */
    public static class AnonymousClass8 extends ViewProperty {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final float a(DeterminateDrawable determinateDrawable) {
            return ((View) determinateDrawable).getRotationY();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final void b(DeterminateDrawable determinateDrawable, float f2) {
            ((View) determinateDrawable).setRotationY(f2);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$9, reason: invalid class name */
    public static class AnonymousClass9 extends ViewProperty {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final float a(DeterminateDrawable determinateDrawable) {
            return ((View) determinateDrawable).getX();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public final void b(DeterminateDrawable determinateDrawable, float f2) {
            ((View) determinateDrawable).setX(f2);
        }
    }

    public static class MassState {

        /* renamed from: a, reason: collision with root package name */
        public float f4277a;

        /* renamed from: b, reason: collision with root package name */
        public float f4278b;
    }

    public interface OnAnimationEndListener {
        void a(float f2);
    }

    public interface OnAnimationUpdateListener {
        void m(float f2);
    }

    public static abstract class ViewProperty extends FloatPropertyCompat<View> {
    }

    public DynamicAnimation(final FloatValueHolder floatValueHolder) {
        this.f4264a = 0.0f;
        this.f4265b = Float.MAX_VALUE;
        this.f4266c = false;
        this.f4269f = false;
        this.f4270g = Float.MAX_VALUE;
        this.f4271h = -3.4028235E38f;
        this.f4272i = 0L;
        this.f4274k = new ArrayList();
        this.f4275l = new ArrayList();
        this.f4267d = null;
        this.f4268e = new FloatPropertyCompat() { // from class: androidx.dynamicanimation.animation.DynamicAnimation.15
            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public final float a(DeterminateDrawable determinateDrawable) {
                return floatValueHolder.f4279a;
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public final void b(DeterminateDrawable determinateDrawable, float f2) {
                floatValueHolder.f4279a = f2;
            }
        };
        this.f4273j = 1.0f;
    }

    @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallback
    public final boolean a(long j2) {
        ArrayList arrayList;
        long j3 = this.f4272i;
        int i2 = 0;
        if (j3 == 0) {
            this.f4272i = j2;
            b(this.f4265b);
            return false;
        }
        this.f4272i = j2;
        boolean zC = c(j2 - j3);
        float fMin = Math.min(this.f4265b, this.f4270g);
        this.f4265b = fMin;
        float fMax = Math.max(fMin, this.f4271h);
        this.f4265b = fMax;
        b(fMax);
        if (zC) {
            this.f4269f = false;
            ThreadLocal threadLocal = AnimationHandler.f4252f;
            if (threadLocal.get() == null) {
                threadLocal.set(new AnimationHandler());
            }
            AnimationHandler animationHandler = (AnimationHandler) threadLocal.get();
            animationHandler.f4253a.remove(this);
            ArrayList arrayList2 = animationHandler.f4254b;
            int iIndexOf = arrayList2.indexOf(this);
            if (iIndexOf >= 0) {
                arrayList2.set(iIndexOf, null);
                animationHandler.f4257e = true;
            }
            this.f4272i = 0L;
            this.f4266c = false;
            while (true) {
                arrayList = this.f4274k;
                if (i2 >= arrayList.size()) {
                    break;
                }
                if (arrayList.get(i2) != null) {
                    ((OnAnimationEndListener) arrayList.get(i2)).a(this.f4265b);
                }
                i2++;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size) == null) {
                    arrayList.remove(size);
                }
            }
        }
        return zC;
    }

    public final void b(float f2) {
        ArrayList arrayList;
        this.f4268e.b(this.f4267d, f2);
        int i2 = 0;
        while (true) {
            arrayList = this.f4275l;
            if (i2 >= arrayList.size()) {
                break;
            }
            if (arrayList.get(i2) != null) {
                ((OnAnimationUpdateListener) arrayList.get(i2)).m(this.f4265b);
            }
            i2++;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    public abstract boolean c(long j2);

    public DynamicAnimation(DeterminateDrawable determinateDrawable) {
        FloatPropertyCompat floatPropertyCompat = DeterminateDrawable.q;
        this.f4264a = 0.0f;
        this.f4265b = Float.MAX_VALUE;
        this.f4266c = false;
        this.f4269f = false;
        this.f4270g = Float.MAX_VALUE;
        this.f4271h = -3.4028235E38f;
        this.f4272i = 0L;
        this.f4274k = new ArrayList();
        this.f4275l = new ArrayList();
        this.f4267d = determinateDrawable;
        this.f4268e = floatPropertyCompat;
        if (floatPropertyCompat != o && floatPropertyCompat != p && floatPropertyCompat != q) {
            if (floatPropertyCompat == r) {
                this.f4273j = 0.00390625f;
                return;
            } else if (floatPropertyCompat != f4263m && floatPropertyCompat != n) {
                this.f4273j = 1.0f;
                return;
            } else {
                this.f4273j = 0.00390625f;
                return;
            }
        }
        this.f4273j = 0.1f;
    }
}
