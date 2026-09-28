package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ViewTransition {

    /* renamed from: a, reason: collision with root package name */
    public int f2266a;

    /* renamed from: e, reason: collision with root package name */
    public int f2270e;

    /* renamed from: f, reason: collision with root package name */
    public final KeyFrames f2271f;

    /* renamed from: g, reason: collision with root package name */
    public final ConstraintSet.Constraint f2272g;

    /* renamed from: j, reason: collision with root package name */
    public int f2275j;

    /* renamed from: k, reason: collision with root package name */
    public String f2276k;
    public final Context o;

    /* renamed from: b, reason: collision with root package name */
    public int f2267b = -1;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2268c = false;

    /* renamed from: d, reason: collision with root package name */
    public int f2269d = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f2273h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f2274i = -1;

    /* renamed from: l, reason: collision with root package name */
    public int f2277l = 0;

    /* renamed from: m, reason: collision with root package name */
    public String f2278m = null;
    public int n = -1;
    public int p = -1;
    public int q = -1;
    public int r = -1;
    public int s = -1;
    public int t = -1;
    public int u = -1;

    public static class Animate {

        /* renamed from: a, reason: collision with root package name */
        public final int f2280a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2281b;

        /* renamed from: c, reason: collision with root package name */
        public final MotionController f2282c;

        /* renamed from: d, reason: collision with root package name */
        public final int f2283d;

        /* renamed from: f, reason: collision with root package name */
        public final ViewTransitionController f2285f;

        /* renamed from: g, reason: collision with root package name */
        public final Interpolator f2286g;

        /* renamed from: i, reason: collision with root package name */
        public float f2288i;

        /* renamed from: j, reason: collision with root package name */
        public float f2289j;

        /* renamed from: m, reason: collision with root package name */
        public final boolean f2292m;

        /* renamed from: e, reason: collision with root package name */
        public final KeyCache f2284e = new KeyCache();

        /* renamed from: h, reason: collision with root package name */
        public boolean f2287h = false;

        /* renamed from: l, reason: collision with root package name */
        public final Rect f2291l = new Rect();

        /* renamed from: k, reason: collision with root package name */
        public long f2290k = System.nanoTime();

        public Animate(ViewTransitionController viewTransitionController, MotionController motionController, int i2, int i3, int i4, Interpolator interpolator, int i5, int i6) {
            this.f2292m = false;
            this.f2285f = viewTransitionController;
            this.f2282c = motionController;
            this.f2283d = i3;
            if (viewTransitionController.f2297e == null) {
                viewTransitionController.f2297e = new ArrayList();
            }
            viewTransitionController.f2297e.add(this);
            this.f2286g = interpolator;
            this.f2280a = i5;
            this.f2281b = i6;
            if (i4 == 3) {
                this.f2292m = true;
            }
            this.f2289j = i2 == 0 ? Float.MAX_VALUE : 1.0f / i2;
            a();
        }

        public final void a() {
            boolean z = this.f2287h;
            ViewTransitionController viewTransitionController = this.f2285f;
            Interpolator interpolator = this.f2286g;
            MotionController motionController = this.f2282c;
            int i2 = this.f2281b;
            int i3 = this.f2280a;
            if (z) {
                long jNanoTime = System.nanoTime();
                long j2 = jNanoTime - this.f2290k;
                this.f2290k = jNanoTime;
                float f2 = this.f2288i - (((float) (j2 * 1.0E-6d)) * this.f2289j);
                this.f2288i = f2;
                if (f2 < 0.0f) {
                    this.f2288i = 0.0f;
                }
                boolean zI = motionController.i(interpolator == null ? this.f2288i : interpolator.getInterpolation(this.f2288i), jNanoTime, motionController.f2155b, this.f2284e);
                if (this.f2288i <= 0.0f) {
                    if (i3 != -1) {
                        motionController.f2155b.setTag(i3, Long.valueOf(System.nanoTime()));
                    }
                    if (i2 != -1) {
                        motionController.f2155b.setTag(i2, null);
                    }
                    viewTransitionController.f2298f.add(this);
                }
                if (this.f2288i > 0.0f || zI) {
                    viewTransitionController.f2293a.invalidate();
                    return;
                }
                return;
            }
            long jNanoTime2 = System.nanoTime();
            long j3 = jNanoTime2 - this.f2290k;
            this.f2290k = jNanoTime2;
            float f3 = (((float) (j3 * 1.0E-6d)) * this.f2289j) + this.f2288i;
            this.f2288i = f3;
            if (f3 >= 1.0f) {
                this.f2288i = 1.0f;
            }
            boolean zI2 = motionController.i(interpolator == null ? this.f2288i : interpolator.getInterpolation(this.f2288i), jNanoTime2, motionController.f2155b, this.f2284e);
            if (this.f2288i >= 1.0f) {
                if (i3 != -1) {
                    motionController.f2155b.setTag(i3, Long.valueOf(System.nanoTime()));
                }
                if (i2 != -1) {
                    motionController.f2155b.setTag(i2, null);
                }
                if (!this.f2292m) {
                    viewTransitionController.f2298f.add(this);
                }
            }
            if (this.f2288i < 1.0f || zI2) {
                viewTransitionController.f2293a.invalidate();
            }
        }

        public final void b() {
            this.f2287h = true;
            int i2 = this.f2283d;
            if (i2 != -1) {
                this.f2289j = i2 == 0 ? Float.MAX_VALUE : 1.0f / i2;
            }
            this.f2285f.f2293a.invalidate();
            this.f2290k = System.nanoTime();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ViewTransition(android.content.Context r11, android.content.res.XmlResourceParser r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.ViewTransition.<init>(android.content.Context, android.content.res.XmlResourceParser):void");
    }

    public final void a(ViewTransitionController viewTransitionController, MotionLayout motionLayout, int i2, ConstraintSet constraintSet, View... viewArr) {
        Interpolator interpolatorLoadInterpolator;
        Interpolator interpolator;
        if (this.f2268c) {
            return;
        }
        int i3 = this.f2270e;
        KeyFrames keyFrames = this.f2271f;
        if (i3 == 2) {
            View view = viewArr[0];
            MotionController motionController = new MotionController(view);
            MotionPaths motionPaths = motionController.f2159f;
            motionPaths.f2212c = 0.0f;
            motionPaths.f2213d = 0.0f;
            motionController.H = true;
            motionPaths.d(view.getX(), view.getY(), view.getWidth(), view.getHeight());
            motionController.f2160g.d(view.getX(), view.getY(), view.getWidth(), view.getHeight());
            MotionConstrainedPoint motionConstrainedPoint = motionController.f2161h;
            motionConstrainedPoint.getClass();
            view.getX();
            view.getY();
            view.getWidth();
            view.getHeight();
            motionConstrainedPoint.b(view);
            MotionConstrainedPoint motionConstrainedPoint2 = motionController.f2162i;
            motionConstrainedPoint2.getClass();
            view.getX();
            view.getY();
            view.getWidth();
            view.getHeight();
            motionConstrainedPoint2.b(view);
            ArrayList arrayList = (ArrayList) keyFrames.f2110a.get(-1);
            if (arrayList != null) {
                motionController.w.addAll(arrayList);
            }
            motionController.l(motionLayout.getWidth(), motionLayout.getHeight(), System.nanoTime());
            int i4 = this.f2273h;
            int i5 = this.f2274i;
            int i6 = this.f2267b;
            Context context = motionLayout.getContext();
            int i7 = this.f2277l;
            if (i7 == -2) {
                interpolatorLoadInterpolator = AnimationUtils.loadInterpolator(context, this.n);
            } else if (i7 == -1) {
                final Easing easingC = Easing.c(this.f2278m);
                interpolatorLoadInterpolator = new Interpolator() { // from class: androidx.constraintlayout.motion.widget.ViewTransition.1
                    @Override // android.animation.TimeInterpolator
                    public final float getInterpolation(float f2) {
                        return (float) easingC.a(f2);
                    }
                };
            } else if (i7 == 0) {
                interpolatorLoadInterpolator = new AccelerateDecelerateInterpolator();
            } else if (i7 == 1) {
                interpolatorLoadInterpolator = new AccelerateInterpolator();
            } else if (i7 == 2) {
                interpolatorLoadInterpolator = new DecelerateInterpolator();
            } else if (i7 == 4) {
                interpolatorLoadInterpolator = new BounceInterpolator();
            } else if (i7 == 5) {
                interpolatorLoadInterpolator = new OvershootInterpolator();
            } else {
                if (i7 != 6) {
                    interpolator = null;
                    new Animate(viewTransitionController, motionController, i4, i5, i6, interpolator, this.p, this.q);
                    return;
                }
                interpolatorLoadInterpolator = new AnticipateInterpolator();
            }
            interpolator = interpolatorLoadInterpolator;
            new Animate(viewTransitionController, motionController, i4, i5, i6, interpolator, this.p, this.q);
            return;
        }
        ConstraintSet.Constraint constraint = this.f2272g;
        if (i3 == 1) {
            for (int i8 : motionLayout.getConstraintSetIds()) {
                if (i8 != i2) {
                    MotionScene motionScene = motionLayout.q;
                    ConstraintSet constraintSetB = motionScene == null ? null : motionScene.b(i8);
                    for (View view2 : viewArr) {
                        ConstraintSet.Constraint constraintJ = constraintSetB.j(view2.getId());
                        if (constraint != null) {
                            constraint.a(constraintJ);
                            constraintJ.f2465g.putAll(constraint.f2465g);
                        }
                    }
                }
            }
        }
        ConstraintSet constraintSet2 = new ConstraintSet();
        HashMap map = constraintSet2.f2458g;
        map.clear();
        for (Integer num : constraintSet.f2458g.keySet()) {
            ConstraintSet.Constraint constraint2 = (ConstraintSet.Constraint) constraintSet.f2458g.get(num);
            if (constraint2 != null) {
                map.put(num, constraint2.clone());
            }
        }
        for (View view3 : viewArr) {
            ConstraintSet.Constraint constraintJ2 = constraintSet2.j(view3.getId());
            if (constraint != null) {
                constraint.a(constraintJ2);
                constraintJ2.f2465g.putAll(constraint.f2465g);
            }
        }
        motionLayout.J(i2, constraintSet2);
        motionLayout.J(R.id.view_transition, constraintSet);
        motionLayout.E(R.id.view_transition);
        MotionScene.Transition transition = new MotionScene.Transition(motionLayout.q, R.id.view_transition, i2);
        for (View view4 : viewArr) {
            int i9 = this.f2273h;
            if (i9 != -1) {
                transition.f2244h = Math.max(i9, 8);
            }
            transition.p = this.f2269d;
            int i10 = this.f2277l;
            String str = this.f2278m;
            int i11 = this.n;
            transition.f2241e = i10;
            transition.f2242f = str;
            transition.f2243g = i11;
            int id = view4.getId();
            if (keyFrames != null) {
                ArrayList arrayList2 = (ArrayList) keyFrames.f2110a.get(-1);
                KeyFrames keyFrames2 = new KeyFrames();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    Key keyClone = ((Key) it.next()).clone();
                    keyClone.f2086b = id;
                    keyFrames2.b(keyClone);
                }
                transition.f2247k.add(keyFrames2);
            }
        }
        motionLayout.setTransition(transition);
        a aVar = new a(0, this, viewArr);
        motionLayout.r(1.0f);
        motionLayout.e1 = aVar;
    }

    public final boolean b(View view) {
        int i2 = this.r;
        boolean z = i2 == -1 || view.getTag(i2) != null;
        int i3 = this.s;
        return z && (i3 == -1 || view.getTag(i3) == null);
    }

    public final boolean c(View view) {
        String str;
        if (view == null) {
            return false;
        }
        if ((this.f2275j == -1 && this.f2276k == null) || !b(view)) {
            return false;
        }
        if (view.getId() == this.f2275j) {
            return true;
        }
        return this.f2276k != null && (view.getLayoutParams() instanceof ConstraintLayout.LayoutParams) && (str = ((ConstraintLayout.LayoutParams) view.getLayoutParams()).Y) != null && str.matches(this.f2276k);
    }

    public final void d(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.ViewTransition);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.ViewTransition_android_id) {
                this.f2266a = typedArrayObtainStyledAttributes.getResourceId(index, this.f2266a);
            } else if (index == R.styleable.ViewTransition_motionTarget) {
                if (MotionLayout.o1) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f2275j);
                    this.f2275j = resourceId;
                    if (resourceId == -1) {
                        this.f2276k = typedArrayObtainStyledAttributes.getString(index);
                    }
                } else if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                    this.f2276k = typedArrayObtainStyledAttributes.getString(index);
                } else {
                    this.f2275j = typedArrayObtainStyledAttributes.getResourceId(index, this.f2275j);
                }
            } else if (index == R.styleable.ViewTransition_onStateTransition) {
                this.f2267b = typedArrayObtainStyledAttributes.getInt(index, this.f2267b);
            } else if (index == R.styleable.ViewTransition_transitionDisable) {
                this.f2268c = typedArrayObtainStyledAttributes.getBoolean(index, this.f2268c);
            } else if (index == R.styleable.ViewTransition_pathMotionArc) {
                this.f2269d = typedArrayObtainStyledAttributes.getInt(index, this.f2269d);
            } else if (index == R.styleable.ViewTransition_duration) {
                this.f2273h = typedArrayObtainStyledAttributes.getInt(index, this.f2273h);
            } else if (index == R.styleable.ViewTransition_upDuration) {
                this.f2274i = typedArrayObtainStyledAttributes.getInt(index, this.f2274i);
            } else if (index == R.styleable.ViewTransition_viewTransitionMode) {
                this.f2270e = typedArrayObtainStyledAttributes.getInt(index, this.f2270e);
            } else if (index == R.styleable.ViewTransition_motionInterpolator) {
                int i3 = typedArrayObtainStyledAttributes.peekValue(index).type;
                if (i3 == 1) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                    this.n = resourceId2;
                    if (resourceId2 != -1) {
                        this.f2277l = -2;
                    }
                } else if (i3 == 3) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f2278m = string;
                    if (string == null || string.indexOf("/") <= 0) {
                        this.f2277l = -1;
                    } else {
                        this.n = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                        this.f2277l = -2;
                    }
                } else {
                    this.f2277l = typedArrayObtainStyledAttributes.getInteger(index, this.f2277l);
                }
            } else if (index == R.styleable.ViewTransition_setsTag) {
                this.p = typedArrayObtainStyledAttributes.getResourceId(index, this.p);
            } else if (index == R.styleable.ViewTransition_clearsTag) {
                this.q = typedArrayObtainStyledAttributes.getResourceId(index, this.q);
            } else if (index == R.styleable.ViewTransition_ifTagSet) {
                this.r = typedArrayObtainStyledAttributes.getResourceId(index, this.r);
            } else if (index == R.styleable.ViewTransition_ifTagNotSet) {
                this.s = typedArrayObtainStyledAttributes.getResourceId(index, this.s);
            } else if (index == R.styleable.ViewTransition_SharedValueId) {
                this.u = typedArrayObtainStyledAttributes.getResourceId(index, this.u);
            } else if (index == R.styleable.ViewTransition_SharedValue) {
                this.t = typedArrayObtainStyledAttributes.getInteger(index, this.t);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final String toString() {
        return "ViewTransition(" + Debug.c(this.f2266a, this.o) + ")";
    }
}
