package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.transition.Transition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public abstract class Transition implements Cloneable {
    public static final Animator[] B = new Animator[0];
    public static final int[] C = {2, 1, 3, 4};
    public static final PathMotion D = new AnonymousClass1();
    public static final ThreadLocal E = new ThreadLocal();
    public long A;

    /* renamed from: a, reason: collision with root package name */
    public final String f12115a;

    /* renamed from: b, reason: collision with root package name */
    public long f12116b;

    /* renamed from: c, reason: collision with root package name */
    public long f12117c;

    /* renamed from: d, reason: collision with root package name */
    public TimeInterpolator f12118d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f12119e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f12120f;

    /* renamed from: g, reason: collision with root package name */
    public TransitionValuesMaps f12121g;

    /* renamed from: h, reason: collision with root package name */
    public TransitionValuesMaps f12122h;

    /* renamed from: i, reason: collision with root package name */
    public TransitionSet f12123i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f12124j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f12125k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f12126l;

    /* renamed from: m, reason: collision with root package name */
    public TransitionListener[] f12127m;
    public final ArrayList n;
    public Animator[] o;
    public int p;
    public boolean q;
    public boolean r;
    public Transition s;
    public ArrayList t;
    public ArrayList u;
    public VisibilityPropagation v;
    public EpicenterCallback w;
    public PathMotion x;
    public long y;
    public SeekController z;

    /* renamed from: androidx.transition.Transition$1, reason: invalid class name */
    public class AnonymousClass1 extends PathMotion {
        @Override // androidx.transition.PathMotion
        public final Path a(float f2, float f3, float f4, float f5) {
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f4, f5);
            return path;
        }
    }

    public static class AnimationInfo {

        /* renamed from: a, reason: collision with root package name */
        public View f12131a;

        /* renamed from: b, reason: collision with root package name */
        public String f12132b;

        /* renamed from: c, reason: collision with root package name */
        public TransitionValues f12133c;

        /* renamed from: d, reason: collision with root package name */
        public WindowId f12134d;

        /* renamed from: e, reason: collision with root package name */
        public Transition f12135e;

        /* renamed from: f, reason: collision with root package name */
        public Animator f12136f;
    }

    public static class ArrayListManager {
    }

    public static abstract class EpicenterCallback {
        public abstract Rect a();
    }

    @RequiresApi
    public static class Impl26 {
        @DoNotInline
        public static long a(Animator animator) {
            return animator.getTotalDuration();
        }

        @DoNotInline
        public static void b(Animator animator, long j2) {
            ((AnimatorSet) animator).setCurrentPlayTime(j2);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface MatchOrder {
    }

    @RequiresApi
    public class SeekController extends TransitionListenerAdapter implements TransitionSeekController, DynamicAnimation.OnAnimationUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public long f12137a = -1;

        /* renamed from: b, reason: collision with root package name */
        public boolean f12138b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f12139c;

        /* renamed from: d, reason: collision with root package name */
        public SpringAnimation f12140d;

        /* renamed from: e, reason: collision with root package name */
        public final VelocityTracker1D f12141e;

        /* renamed from: f, reason: collision with root package name */
        public androidx.fragment.app.b f12142f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ TransitionSet f12143g;

        public SeekController(TransitionSet transitionSet) {
            this.f12143g = transitionSet;
            VelocityTracker1D velocityTracker1D = new VelocityTracker1D();
            long[] jArr = new long[20];
            velocityTracker1D.f12178a = jArr;
            velocityTracker1D.f12179b = new float[20];
            velocityTracker1D.f12180c = 0;
            Arrays.fill(jArr, Long.MIN_VALUE);
            this.f12141e = velocityTracker1D;
        }

        @Override // androidx.transition.TransitionSeekController
        public final boolean a() {
            return this.f12138b;
        }

        @Override // androidx.transition.TransitionSeekController
        public final void d() {
            n();
            this.f12140d.d(this.f12143g.y + 1);
        }

        @Override // androidx.transition.TransitionSeekController
        public final long g() {
            return this.f12143g.y;
        }

        @Override // androidx.transition.TransitionSeekController
        public final void i(long j2) {
            if (this.f12140d != null) {
                throw new IllegalStateException("setCurrentPlayTimeMillis() called after animation has been started");
            }
            long j3 = this.f12137a;
            if (j2 == j3 || !this.f12138b) {
                return;
            }
            if (!this.f12139c) {
                TransitionSet transitionSet = this.f12143g;
                if (j2 != 0 || j3 <= 0) {
                    long j4 = transitionSet.y;
                    if (j2 == j4 && j3 < j4) {
                        j2 = 1 + j4;
                    }
                } else {
                    j2 = -1;
                }
                if (j2 != j3) {
                    transitionSet.F(j2, j3);
                    this.f12137a = j2;
                }
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            VelocityTracker1D velocityTracker1D = this.f12141e;
            int i2 = (velocityTracker1D.f12180c + 1) % 20;
            velocityTracker1D.f12180c = i2;
            velocityTracker1D.f12178a[i2] = jCurrentAnimationTimeMillis;
            velocityTracker1D.f12179b[i2] = j2;
        }

        @Override // androidx.transition.TransitionSeekController
        public final void k(androidx.fragment.app.b bVar) {
            this.f12142f = bVar;
            n();
            this.f12140d.d(0.0f);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public final void l(Transition transition) {
            this.f12139c = true;
        }

        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
        public final void m(float f2) {
            TransitionSet transitionSet = this.f12143g;
            long jMax = Math.max(-1L, Math.min(transitionSet.y + 1, Math.round(f2)));
            transitionSet.F(jMax, this.f12137a);
            this.f12137a = jMax;
        }

        public final void n() {
            float f2;
            if (this.f12140d != null) {
                return;
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float f3 = this.f12137a;
            VelocityTracker1D velocityTracker1D = this.f12141e;
            char c2 = 20;
            int i2 = (velocityTracker1D.f12180c + 1) % 20;
            velocityTracker1D.f12180c = i2;
            velocityTracker1D.f12178a[i2] = jCurrentAnimationTimeMillis;
            velocityTracker1D.f12179b[i2] = f3;
            SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder());
            springAnimation.s = null;
            springAnimation.t = Float.MAX_VALUE;
            int i3 = 0;
            springAnimation.u = false;
            this.f12140d = springAnimation;
            SpringForce springForce = new SpringForce();
            springForce.f4281b = 1.0f;
            springForce.f4282c = false;
            springForce.a(200.0f);
            SpringAnimation springAnimation2 = this.f12140d;
            springAnimation2.s = springForce;
            springAnimation2.f4265b = this.f12137a;
            springAnimation2.f4266c = true;
            if (springAnimation2.f4269f) {
                throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
            }
            ArrayList arrayList = springAnimation2.f4275l;
            if (!arrayList.contains(this)) {
                arrayList.add(this);
            }
            SpringAnimation springAnimation3 = this.f12140d;
            int i4 = velocityTracker1D.f12180c;
            long[] jArr = velocityTracker1D.f12178a;
            long j2 = Long.MIN_VALUE;
            float fSqrt = 0.0f;
            if (i4 != 0 || jArr[i4] != Long.MIN_VALUE) {
                long j3 = jArr[i4];
                long j4 = j3;
                while (true) {
                    long j5 = jArr[i4];
                    if (j5 == j2) {
                        break;
                    }
                    float f4 = j3 - j5;
                    float fAbs = Math.abs(j5 - j4);
                    if (f4 > 100.0f || fAbs > 40.0f) {
                        break;
                    }
                    if (i4 == 0) {
                        i4 = 20;
                    }
                    i4--;
                    i3++;
                    if (i3 >= 20) {
                        break;
                    }
                    j4 = j5;
                    j2 = Long.MIN_VALUE;
                }
                if (i3 >= 2) {
                    float[] fArr = velocityTracker1D.f12179b;
                    float f5 = 1000.0f;
                    if (i3 == 2) {
                        int i5 = velocityTracker1D.f12180c;
                        int i6 = i5 == 0 ? 19 : i5 - 1;
                        float f6 = jArr[i5] - jArr[i6];
                        if (f6 != 0.0f) {
                            fSqrt = ((fArr[i5] - fArr[i6]) / f6) * 1000.0f;
                        }
                    } else {
                        int i7 = velocityTracker1D.f12180c;
                        int i8 = ((i7 - i3) + 21) % 20;
                        int i9 = (i7 + 21) % 20;
                        long j6 = jArr[i8];
                        float f7 = fArr[i8];
                        int i10 = i8 + 1;
                        int i11 = i10 % 20;
                        float f8 = 0.0f;
                        while (i11 != i9) {
                            long j7 = jArr[i11];
                            char c3 = c2;
                            float[] fArr2 = fArr;
                            float f9 = j7 - j6;
                            if (f9 == fSqrt) {
                                f2 = f5;
                            } else {
                                float f10 = fArr2[i11];
                                f2 = f5;
                                float f11 = (f10 - f7) / f9;
                                float fAbs2 = (Math.abs(f11) * (f11 - ((float) (Math.sqrt(2.0f * Math.abs(f8)) * Math.signum(f8))))) + f8;
                                if (i11 == i10) {
                                    fAbs2 *= 0.5f;
                                }
                                f8 = fAbs2;
                                f7 = f10;
                                j6 = j7;
                            }
                            i11 = (i11 + 1) % 20;
                            c2 = c3;
                            fArr = fArr2;
                            f5 = f2;
                            fSqrt = 0.0f;
                        }
                        fSqrt = ((float) (Math.sqrt(Math.abs(f8) * 2.0f) * Math.signum(f8))) * f5;
                    }
                }
            }
            springAnimation3.f4264a = fSqrt;
            SpringAnimation springAnimation4 = this.f12140d;
            springAnimation4.f4270g = this.f12143g.y + 1;
            springAnimation4.f4271h = -1.0f;
            springAnimation4.f4273j = 4.0f;
            DynamicAnimation.OnAnimationEndListener onAnimationEndListener = new DynamicAnimation.OnAnimationEndListener() { // from class: androidx.transition.a
                @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
                public final void a(float f12) {
                    Transition.TransitionNotification transitionNotification = Transition.TransitionNotification.f12145b;
                    Transition.SeekController seekController = this.f12213a;
                    TransitionSet transitionSet = seekController.f12143g;
                    if (f12 >= 1.0f) {
                        transitionSet.y(transitionSet, transitionNotification, false);
                        return;
                    }
                    long j8 = transitionSet.y;
                    Transition transitionQ = transitionSet.Q(0);
                    Transition transition = transitionQ.s;
                    transitionQ.s = null;
                    transitionSet.F(-1L, seekController.f12137a);
                    transitionSet.F(j8, -1L);
                    seekController.f12137a = j8;
                    androidx.fragment.app.b bVar = seekController.f12142f;
                    if (bVar != null) {
                        bVar.run();
                    }
                    transitionSet.u.clear();
                    if (transition != null) {
                        transition.y(transition, transitionNotification, true);
                    }
                }
            };
            ArrayList arrayList2 = springAnimation4.f4274k;
            if (arrayList2.contains(onAnimationEndListener)) {
                return;
            }
            arrayList2.add(onAnimationEndListener);
        }
    }

    public interface TransitionListener {
        void b();

        default void c(Transition transition) {
            h(transition);
        }

        default void e(Transition transition) {
            j(transition);
        }

        void f();

        void h(Transition transition);

        void j(Transition transition);

        void l(Transition transition);
    }

    public interface TransitionNotification {

        /* renamed from: a, reason: collision with root package name */
        public static final b f12144a;

        /* renamed from: b, reason: collision with root package name */
        public static final b f12145b;

        /* renamed from: c, reason: collision with root package name */
        public static final b f12146c;

        /* renamed from: d, reason: collision with root package name */
        public static final b f12147d;

        /* renamed from: e, reason: collision with root package name */
        public static final b f12148e;

        /* JADX WARN: Type inference failed for: r0v0, types: [androidx.transition.b] */
        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.transition.b] */
        /* JADX WARN: Type inference failed for: r0v2, types: [androidx.transition.b] */
        /* JADX WARN: Type inference failed for: r0v3, types: [androidx.transition.b] */
        /* JADX WARN: Type inference failed for: r0v4, types: [androidx.transition.b] */
        static {
            final int i2 = 0;
            f12144a = new TransitionNotification() { // from class: androidx.transition.b
                @Override // androidx.transition.Transition.TransitionNotification
                public final void a(Transition.TransitionListener transitionListener, Transition transition, boolean z) {
                    switch (i2) {
                        case 0:
                            transitionListener.c(transition);
                            break;
                        case 1:
                            transitionListener.e(transition);
                            break;
                        case 2:
                            transitionListener.l(transition);
                            break;
                        case 3:
                            transitionListener.b();
                            break;
                        default:
                            transitionListener.f();
                            break;
                    }
                }
            };
            final int i3 = 1;
            f12145b = new TransitionNotification() { // from class: androidx.transition.b
                @Override // androidx.transition.Transition.TransitionNotification
                public final void a(Transition.TransitionListener transitionListener, Transition transition, boolean z) {
                    switch (i3) {
                        case 0:
                            transitionListener.c(transition);
                            break;
                        case 1:
                            transitionListener.e(transition);
                            break;
                        case 2:
                            transitionListener.l(transition);
                            break;
                        case 3:
                            transitionListener.b();
                            break;
                        default:
                            transitionListener.f();
                            break;
                    }
                }
            };
            final int i4 = 2;
            f12146c = new TransitionNotification() { // from class: androidx.transition.b
                @Override // androidx.transition.Transition.TransitionNotification
                public final void a(Transition.TransitionListener transitionListener, Transition transition, boolean z) {
                    switch (i4) {
                        case 0:
                            transitionListener.c(transition);
                            break;
                        case 1:
                            transitionListener.e(transition);
                            break;
                        case 2:
                            transitionListener.l(transition);
                            break;
                        case 3:
                            transitionListener.b();
                            break;
                        default:
                            transitionListener.f();
                            break;
                    }
                }
            };
            final int i5 = 3;
            f12147d = new TransitionNotification() { // from class: androidx.transition.b
                @Override // androidx.transition.Transition.TransitionNotification
                public final void a(Transition.TransitionListener transitionListener, Transition transition, boolean z) {
                    switch (i5) {
                        case 0:
                            transitionListener.c(transition);
                            break;
                        case 1:
                            transitionListener.e(transition);
                            break;
                        case 2:
                            transitionListener.l(transition);
                            break;
                        case 3:
                            transitionListener.b();
                            break;
                        default:
                            transitionListener.f();
                            break;
                    }
                }
            };
            final int i6 = 4;
            f12148e = new TransitionNotification() { // from class: androidx.transition.b
                @Override // androidx.transition.Transition.TransitionNotification
                public final void a(Transition.TransitionListener transitionListener, Transition transition, boolean z) {
                    switch (i6) {
                        case 0:
                            transitionListener.c(transition);
                            break;
                        case 1:
                            transitionListener.e(transition);
                            break;
                        case 2:
                            transitionListener.l(transition);
                            break;
                        case 3:
                            transitionListener.b();
                            break;
                        default:
                            transitionListener.f();
                            break;
                    }
                }
            };
        }

        void a(TransitionListener transitionListener, Transition transition, boolean z);
    }

    public Transition() {
        this.f12115a = getClass().getName();
        this.f12116b = -1L;
        this.f12117c = -1L;
        this.f12118d = null;
        this.f12119e = new ArrayList();
        this.f12120f = new ArrayList();
        this.f12121g = new TransitionValuesMaps();
        this.f12122h = new TransitionValuesMaps();
        this.f12123i = null;
        this.f12124j = C;
        this.n = new ArrayList();
        this.o = B;
        this.p = 0;
        this.q = false;
        this.r = false;
        this.s = null;
        this.t = null;
        this.u = new ArrayList();
        this.x = D;
    }

    public static void c(TransitionValuesMaps transitionValuesMaps, View view, TransitionValues transitionValues) {
        transitionValuesMaps.f12166a.put(view, transitionValues);
        int id = view.getId();
        if (id >= 0) {
            SparseArray sparseArray = transitionValuesMaps.f12167b;
            if (sparseArray.indexOfKey(id) >= 0) {
                sparseArray.put(id, null);
            } else {
                sparseArray.put(id, view);
            }
        }
        String strN = ViewCompat.n(view);
        if (strN != null) {
            ArrayMap arrayMap = transitionValuesMaps.f12169d;
            if (arrayMap.containsKey(strN)) {
                arrayMap.put(strN, null);
            } else {
                arrayMap.put(strN, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                LongSparseArray longSparseArray = transitionValuesMaps.f12168c;
                if (longSparseArray.e(itemIdAtPosition) < 0) {
                    view.setHasTransientState(true);
                    longSparseArray.g(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) longSparseArray.c(itemIdAtPosition);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                    longSparseArray.g(itemIdAtPosition, null);
                }
            }
        }
    }

    public static ArrayMap p() {
        ThreadLocal threadLocal = E;
        ArrayMap arrayMap = (ArrayMap) threadLocal.get();
        if (arrayMap != null) {
            return arrayMap;
        }
        ArrayMap arrayMap2 = new ArrayMap();
        threadLocal.set(arrayMap2);
        return arrayMap2;
    }

    public void A() {
        ArrayMap arrayMapP = p();
        this.y = 0L;
        for (int i2 = 0; i2 < this.u.size(); i2++) {
            Animator animator = (Animator) this.u.get(i2);
            AnimationInfo animationInfo = (AnimationInfo) arrayMapP.get(animator);
            if (animator != null && animationInfo != null) {
                long j2 = this.f12117c;
                Animator animator2 = animationInfo.f12136f;
                if (j2 >= 0) {
                    animator2.setDuration(j2);
                }
                long j3 = this.f12116b;
                if (j3 >= 0) {
                    animator2.setStartDelay(animator2.getStartDelay() + j3);
                }
                TimeInterpolator timeInterpolator = this.f12118d;
                if (timeInterpolator != null) {
                    animator2.setInterpolator(timeInterpolator);
                }
                this.n.add(animator);
                this.y = Math.max(this.y, Impl26.a(animator));
            }
        }
        this.u.clear();
    }

    public Transition B(TransitionListener transitionListener) {
        Transition transition;
        ArrayList arrayList = this.t;
        if (arrayList != null) {
            if (!arrayList.remove(transitionListener) && (transition = this.s) != null) {
                transition.B(transitionListener);
            }
            if (this.t.size() == 0) {
                this.t = null;
            }
        }
        return this;
    }

    public void C(View view) {
        this.f12120f.remove(view);
    }

    public void D(View view) {
        if (this.q) {
            if (!this.r) {
                ArrayList arrayList = this.n;
                int size = arrayList.size();
                Animator[] animatorArr = (Animator[]) arrayList.toArray(this.o);
                this.o = B;
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    Animator animator = animatorArr[i2];
                    animatorArr[i2] = null;
                    animator.resume();
                }
                this.o = animatorArr;
                y(this, TransitionNotification.f12148e, false);
            }
            this.q = false;
        }
    }

    public void E() {
        M();
        final ArrayMap arrayMapP = p();
        Iterator it = this.u.iterator();
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            if (arrayMapP.containsKey(animator)) {
                M();
                if (animator != null) {
                    animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.Transition.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator2) {
                            arrayMapP.remove(animator2);
                            Transition.this.n.remove(animator2);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationStart(Animator animator2) {
                            Transition.this.n.add(animator2);
                        }
                    });
                    long j2 = this.f12117c;
                    if (j2 >= 0) {
                        animator.setDuration(j2);
                    }
                    long j3 = this.f12116b;
                    if (j3 >= 0) {
                        animator.setStartDelay(animator.getStartDelay() + j3);
                    }
                    TimeInterpolator timeInterpolator = this.f12118d;
                    if (timeInterpolator != null) {
                        animator.setInterpolator(timeInterpolator);
                    }
                    animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.Transition.3
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator2) {
                            Transition.this.m();
                            animator2.removeListener(this);
                        }
                    });
                    animator.start();
                }
            }
        }
        this.u.clear();
        m();
    }

    public void F(long j2, long j3) {
        long j4 = this.y;
        boolean z = j2 < j3;
        if ((j3 < 0 && j2 >= 0) || (j3 > j4 && j2 <= j4)) {
            this.r = false;
            y(this, TransitionNotification.f12144a, z);
        }
        ArrayList arrayList = this.n;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.o);
        this.o = B;
        for (int i2 = 0; i2 < size; i2++) {
            Animator animator = animatorArr[i2];
            animatorArr[i2] = null;
            Impl26.b(animator, Math.min(Math.max(0L, j2), Impl26.a(animator)));
        }
        this.o = animatorArr;
        if ((j2 <= j4 || j3 > j4) && (j2 >= 0 || j3 < 0)) {
            return;
        }
        if (j2 > j4) {
            this.r = true;
        }
        y(this, TransitionNotification.f12145b, z);
    }

    public void G(long j2) {
        this.f12117c = j2;
    }

    public void H(EpicenterCallback epicenterCallback) {
        this.w = epicenterCallback;
    }

    public void I(TimeInterpolator timeInterpolator) {
        this.f12118d = timeInterpolator;
    }

    public void J(PathMotion pathMotion) {
        if (pathMotion == null) {
            this.x = D;
        } else {
            this.x = pathMotion;
        }
    }

    public void K(VisibilityPropagation visibilityPropagation) {
        this.v = visibilityPropagation;
    }

    public void L(long j2) {
        this.f12116b = j2;
    }

    public final void M() {
        if (this.p == 0) {
            y(this, TransitionNotification.f12144a, false);
            this.r = false;
        }
        this.p++;
    }

    public String O(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(": ");
        if (this.f12117c != -1) {
            sb.append("dur(");
            sb.append(this.f12117c);
            sb.append(") ");
        }
        if (this.f12116b != -1) {
            sb.append("dly(");
            sb.append(this.f12116b);
            sb.append(") ");
        }
        if (this.f12118d != null) {
            sb.append("interp(");
            sb.append(this.f12118d);
            sb.append(") ");
        }
        ArrayList arrayList = this.f12119e;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f12120f;
        if (size > 0 || arrayList2.size() > 0) {
            sb.append("tgts(");
            if (arrayList.size() > 0) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    if (i2 > 0) {
                        sb.append(", ");
                    }
                    sb.append(arrayList.get(i2));
                }
            }
            if (arrayList2.size() > 0) {
                for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append(arrayList2.get(i3));
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }

    public void a(TransitionListener transitionListener) {
        if (this.t == null) {
            this.t = new ArrayList();
        }
        this.t.add(transitionListener);
    }

    public void b(View view) {
        this.f12120f.add(view);
    }

    public void cancel() {
        ArrayList arrayList = this.n;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.o);
        this.o = B;
        for (int i2 = size - 1; i2 >= 0; i2--) {
            Animator animator = animatorArr[i2];
            animatorArr[i2] = null;
            animator.cancel();
        }
        this.o = animatorArr;
        y(this, TransitionNotification.f12146c, false);
    }

    public abstract void d(TransitionValues transitionValues);

    public final void e(View view, boolean z) {
        if (view == null) {
            return;
        }
        view.getId();
        if (view.getParent() instanceof ViewGroup) {
            TransitionValues transitionValues = new TransitionValues(view);
            if (z) {
                g(transitionValues);
            } else {
                d(transitionValues);
            }
            transitionValues.f12165c.add(this);
            f(transitionValues);
            if (z) {
                c(this.f12121g, view, transitionValues);
            } else {
                c(this.f12122h, view, transitionValues);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                e(viewGroup.getChildAt(i2), z);
            }
        }
    }

    public void f(TransitionValues transitionValues) {
        if (this.v != null) {
            HashMap map = transitionValues.f12163a;
            if (map.isEmpty()) {
                return;
            }
            this.v.getClass();
            String[] strArr = VisibilityPropagation.f12212a;
            for (int i2 = 0; i2 < 2; i2++) {
                if (!map.containsKey(strArr[i2])) {
                    this.v.getClass();
                    View view = transitionValues.f12164b;
                    Integer numValueOf = (Integer) map.get("android:visibility:visibility");
                    if (numValueOf == null) {
                        numValueOf = Integer.valueOf(view.getVisibility());
                    }
                    map.put("android:visibilityPropagation:visibility", numValueOf);
                    int[] iArr = {iRound, 0};
                    view.getLocationOnScreen(iArr);
                    int iRound = Math.round(view.getTranslationX()) + iArr[0];
                    iArr[0] = (view.getWidth() / 2) + iRound;
                    int iRound2 = Math.round(view.getTranslationY()) + iArr[1];
                    iArr[1] = iRound2;
                    iArr[1] = (view.getHeight() / 2) + iRound2;
                    map.put("android:visibilityPropagation:center", iArr);
                    return;
                }
            }
        }
    }

    public abstract void g(TransitionValues transitionValues);

    public final void h(ViewGroup viewGroup, boolean z) {
        i(z);
        ArrayList arrayList = this.f12119e;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f12120f;
        if (size <= 0 && arrayList2.size() <= 0) {
            e(viewGroup, z);
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            View viewFindViewById = viewGroup.findViewById(((Integer) arrayList.get(i2)).intValue());
            if (viewFindViewById != null) {
                TransitionValues transitionValues = new TransitionValues(viewFindViewById);
                if (z) {
                    g(transitionValues);
                } else {
                    d(transitionValues);
                }
                transitionValues.f12165c.add(this);
                f(transitionValues);
                if (z) {
                    c(this.f12121g, viewFindViewById, transitionValues);
                } else {
                    c(this.f12122h, viewFindViewById, transitionValues);
                }
            }
        }
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            View view = (View) arrayList2.get(i3);
            TransitionValues transitionValues2 = new TransitionValues(view);
            if (z) {
                g(transitionValues2);
            } else {
                d(transitionValues2);
            }
            transitionValues2.f12165c.add(this);
            f(transitionValues2);
            if (z) {
                c(this.f12121g, view, transitionValues2);
            } else {
                c(this.f12122h, view, transitionValues2);
            }
        }
    }

    public final void i(boolean z) {
        if (z) {
            this.f12121g.f12166a.clear();
            this.f12121g.f12167b.clear();
            this.f12121g.f12168c.a();
        } else {
            this.f12122h.f12166a.clear();
            this.f12122h.f12167b.clear();
            this.f12122h.f12168c.a();
        }
    }

    @Override // 
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.u = new ArrayList();
            transition.f12121g = new TransitionValuesMaps();
            transition.f12122h = new TransitionValuesMaps();
            transition.f12125k = null;
            transition.f12126l = null;
            transition.z = null;
            transition.s = this;
            transition.t = null;
            return transition;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public Animator k(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0120 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void l(android.view.ViewGroup r22, androidx.transition.TransitionValuesMaps r23, androidx.transition.TransitionValuesMaps r24, java.util.ArrayList r25, java.util.ArrayList r26) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Transition.l(android.view.ViewGroup, androidx.transition.TransitionValuesMaps, androidx.transition.TransitionValuesMaps, java.util.ArrayList, java.util.ArrayList):void");
    }

    public final void m() {
        int i2 = this.p - 1;
        this.p = i2;
        if (i2 == 0) {
            y(this, TransitionNotification.f12145b, false);
            for (int i3 = 0; i3 < this.f12121g.f12168c.h(); i3++) {
                View view = (View) this.f12121g.f12168c.i(i3);
                if (view != null) {
                    view.setHasTransientState(false);
                }
            }
            for (int i4 = 0; i4 < this.f12122h.f12168c.h(); i4++) {
                View view2 = (View) this.f12122h.f12168c.i(i4);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                }
            }
            this.r = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002c, code lost:
    
        if (r2 < 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002e, code lost:
    
        if (r6 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0030, code lost:
    
        r5 = r4.f12126l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0033, code lost:
    
        r5 = r4.f12125k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003b, code lost:
    
        return (androidx.transition.TransitionValues) r5.get(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003c, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.transition.TransitionValues n(android.view.View r5, boolean r6) {
        /*
            r4 = this;
            androidx.transition.TransitionSet r0 = r4.f12123i
            if (r0 == 0) goto L9
            androidx.transition.TransitionValues r5 = r0.n(r5, r6)
            return r5
        L9:
            if (r6 == 0) goto Le
            java.util.ArrayList r0 = r4.f12125k
            goto L10
        Le:
            java.util.ArrayList r0 = r4.f12126l
        L10:
            if (r0 != 0) goto L13
            goto L3c
        L13:
            int r1 = r0.size()
            r2 = 0
        L18:
            if (r2 >= r1) goto L2b
            java.lang.Object r3 = r0.get(r2)
            androidx.transition.TransitionValues r3 = (androidx.transition.TransitionValues) r3
            if (r3 != 0) goto L23
            goto L3c
        L23:
            android.view.View r3 = r3.f12164b
            if (r3 != r5) goto L28
            goto L2c
        L28:
            int r2 = r2 + 1
            goto L18
        L2b:
            r2 = -1
        L2c:
            if (r2 < 0) goto L3c
            if (r6 == 0) goto L33
            java.util.ArrayList r5 = r4.f12126l
            goto L35
        L33:
            java.util.ArrayList r5 = r4.f12125k
        L35:
            java.lang.Object r5 = r5.get(r2)
            androidx.transition.TransitionValues r5 = (androidx.transition.TransitionValues) r5
            return r5
        L3c:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Transition.n(android.view.View, boolean):androidx.transition.TransitionValues");
    }

    public final Transition o() {
        TransitionSet transitionSet = this.f12123i;
        return transitionSet != null ? transitionSet.o() : this;
    }

    public String[] q() {
        return null;
    }

    public final TransitionValues t(View view, boolean z) {
        TransitionSet transitionSet = this.f12123i;
        if (transitionSet != null) {
            return transitionSet.t(view, z);
        }
        return (TransitionValues) (z ? this.f12121g : this.f12122h).f12166a.get(view);
    }

    public final String toString() {
        return O("");
    }

    public boolean u() {
        return !this.n.isEmpty();
    }

    public boolean v() {
        return this instanceof ChangeBounds;
    }

    public boolean w(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues != null && transitionValues2 != null) {
            String[] strArrQ = q();
            HashMap map = transitionValues.f12163a;
            HashMap map2 = transitionValues2.f12163a;
            if (strArrQ != null) {
                for (String str : strArrQ) {
                    Object obj = map.get(str);
                    Object obj2 = map2.get(str);
                    if ((obj == null && obj2 == null) ? false : (obj == null || obj2 == null) ? true : !obj.equals(obj2)) {
                        return true;
                    }
                }
            } else {
                for (String str2 : map.keySet()) {
                    Object obj3 = map.get(str2);
                    Object obj4 = map2.get(str2);
                    if ((obj3 == null && obj4 == null) ? false : (obj3 == null || obj4 == null) ? true : !obj3.equals(obj4)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean x(View view) {
        int id = view.getId();
        ArrayList arrayList = this.f12119e;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f12120f;
        return (size == 0 && arrayList2.size() == 0) || arrayList.contains(Integer.valueOf(id)) || arrayList2.contains(view);
    }

    public final void y(Transition transition, TransitionNotification transitionNotification, boolean z) {
        Transition transition2 = this.s;
        if (transition2 != null) {
            transition2.y(transition, transitionNotification, z);
        }
        ArrayList arrayList = this.t;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = this.t.size();
        TransitionListener[] transitionListenerArr = this.f12127m;
        if (transitionListenerArr == null) {
            transitionListenerArr = new TransitionListener[size];
        }
        this.f12127m = null;
        TransitionListener[] transitionListenerArr2 = (TransitionListener[]) this.t.toArray(transitionListenerArr);
        for (int i2 = 0; i2 < size; i2++) {
            transitionNotification.a(transitionListenerArr2[i2], transition, z);
            transitionListenerArr2[i2] = null;
        }
        this.f12127m = transitionListenerArr2;
    }

    public void z(ViewGroup viewGroup) {
        if (this.r) {
            return;
        }
        ArrayList arrayList = this.n;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.o);
        this.o = B;
        for (int i2 = size - 1; i2 >= 0; i2--) {
            Animator animator = animatorArr[i2];
            animatorArr[i2] = null;
            animator.pause();
        }
        this.o = animatorArr;
        y(this, TransitionNotification.f12147d, false);
        this.q = true;
    }

    public Transition(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        this.f12115a = getClass().getName();
        this.f12116b = -1L;
        this.f12117c = -1L;
        this.f12118d = null;
        this.f12119e = new ArrayList();
        this.f12120f = new ArrayList();
        this.f12121g = new TransitionValuesMaps();
        this.f12122h = new TransitionValuesMaps();
        this.f12123i = null;
        int[] iArr = C;
        this.f12124j = iArr;
        this.n = new ArrayList();
        this.o = B;
        this.p = 0;
        this.q = false;
        this.r = false;
        this.s = null;
        this.t = null;
        this.u = new ArrayList();
        this.x = D;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f12106a);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long jF = TypedArrayUtils.f(typedArrayObtainStyledAttributes, xmlResourceParser, "duration", 1, -1);
        if (jF >= 0) {
            G(jF);
        }
        long j2 = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "startDelay") != null ? typedArrayObtainStyledAttributes.getInt(2, -1) : -1;
        if (j2 > 0) {
            L(j2);
        }
        int resourceId = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "interpolator") != null ? typedArrayObtainStyledAttributes.getResourceId(0, 0) : 0;
        if (resourceId > 0) {
            I(AnimationUtils.loadInterpolator(context, resourceId));
        }
        String strG = TypedArrayUtils.g(typedArrayObtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (strG != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(strG, ",");
            int[] iArr2 = new int[stringTokenizer.countTokens()];
            int i2 = 0;
            while (stringTokenizer.hasMoreTokens()) {
                String strTrim = stringTokenizer.nextToken().trim();
                if (CLConstants.SHARED_PREFERENCE_ITEM_ID.equalsIgnoreCase(strTrim)) {
                    iArr2[i2] = 3;
                } else if ("instance".equalsIgnoreCase(strTrim)) {
                    iArr2[i2] = 1;
                } else if (CLConstants.FIELD_PAY_INFO_NAME.equalsIgnoreCase(strTrim)) {
                    iArr2[i2] = 2;
                } else if ("itemId".equalsIgnoreCase(strTrim)) {
                    iArr2[i2] = 4;
                } else if (strTrim.isEmpty()) {
                    int[] iArr3 = new int[iArr2.length - 1];
                    System.arraycopy(iArr2, 0, iArr3, 0, i2);
                    i2--;
                    iArr2 = iArr3;
                } else {
                    throw new InflateException(android.support.v4.media.b.D("Unknown match type in matchOrder: '", strTrim, "'"));
                }
                i2++;
            }
            if (iArr2.length == 0) {
                this.f12124j = iArr;
            } else {
                for (int i3 = 0; i3 < iArr2.length; i3++) {
                    int i4 = iArr2[i3];
                    if (i4 < 1 || i4 > 4) {
                        throw new IllegalArgumentException("matches contains invalid value");
                    }
                    for (int i5 = 0; i5 < i3; i5++) {
                        if (iArr2[i5] == i4) {
                            throw new IllegalArgumentException("matches contains a duplicate value");
                        }
                    }
                }
                this.f12124j = (int[]) iArr2.clone();
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
