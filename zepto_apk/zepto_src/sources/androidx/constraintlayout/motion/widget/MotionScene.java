package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.media.b;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
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
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionLayout.StateCache;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public class MotionScene {

    /* renamed from: a, reason: collision with root package name */
    public final MotionLayout f2223a;

    /* renamed from: b, reason: collision with root package name */
    public final StateSet f2224b;

    /* renamed from: c, reason: collision with root package name */
    public Transition f2225c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f2226d;

    /* renamed from: e, reason: collision with root package name */
    public final Transition f2227e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f2228f;

    /* renamed from: g, reason: collision with root package name */
    public final SparseArray f2229g;

    /* renamed from: h, reason: collision with root package name */
    public final HashMap f2230h;

    /* renamed from: i, reason: collision with root package name */
    public final SparseIntArray f2231i;

    /* renamed from: j, reason: collision with root package name */
    public int f2232j;

    /* renamed from: k, reason: collision with root package name */
    public int f2233k;

    /* renamed from: l, reason: collision with root package name */
    public MotionEvent f2234l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2235m;
    public boolean n;
    public MotionLayout.MotionTracker o;
    public boolean p;
    public final ViewTransitionController q;
    public float r;
    public float s;

    /* JADX WARN: Removed duplicated region for block: B:46:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MotionScene(android.content.Context r17, androidx.constraintlayout.motion.widget.MotionLayout r18, int r19) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 570
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.<init>(android.content.Context, androidx.constraintlayout.motion.widget.MotionLayout, int):void");
    }

    public static int d(Context context, String str) {
        int identifier;
        if (str.contains("/")) {
            identifier = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), CLConstants.SHARED_PREFERENCE_ITEM_ID, context.getPackageName());
        } else {
            identifier = -1;
        }
        if (identifier == -1) {
            if (str.length() > 1) {
                return Integer.parseInt(str.substring(1));
            }
            Log.e("MotionScene", "error in parsing id");
        }
        return identifier;
    }

    public final boolean a(int i2, MotionLayout motionLayout) {
        Transition transition;
        if (this.o != null) {
            return false;
        }
        Iterator it = this.f2226d.iterator();
        while (it.hasNext()) {
            Transition transition2 = (Transition) it.next();
            int i3 = transition2.n;
            if (i3 != 0 && ((transition = this.f2225c) != transition2 || (transition.r & 2) == 0)) {
                int i4 = transition2.f2240d;
                MotionLayout.TransitionState transitionState = MotionLayout.TransitionState.f2208d;
                MotionLayout.TransitionState transitionState2 = MotionLayout.TransitionState.f2207c;
                MotionLayout.TransitionState transitionState3 = MotionLayout.TransitionState.f2206b;
                if (i2 == i4 && (i3 == 4 || i3 == 2)) {
                    motionLayout.setState(transitionState);
                    motionLayout.setTransition(transition2);
                    if (transition2.n == 4) {
                        motionLayout.r(1.0f);
                        motionLayout.e1 = null;
                        motionLayout.setState(transitionState3);
                        motionLayout.setState(transitionState2);
                        return true;
                    }
                    motionLayout.setProgress(1.0f);
                    motionLayout.t(true);
                    motionLayout.setState(transitionState3);
                    motionLayout.setState(transitionState2);
                    motionLayout.setState(transitionState);
                    motionLayout.B();
                    return true;
                }
                if (i2 == transition2.f2239c && (i3 == 3 || i3 == 1)) {
                    motionLayout.setState(transitionState);
                    motionLayout.setTransition(transition2);
                    if (transition2.n == 3) {
                        motionLayout.r(0.0f);
                        motionLayout.setState(transitionState3);
                        motionLayout.setState(transitionState2);
                        return true;
                    }
                    motionLayout.setProgress(0.0f);
                    motionLayout.t(true);
                    motionLayout.setState(transitionState3);
                    motionLayout.setState(transitionState2);
                    motionLayout.setState(transitionState);
                    motionLayout.B();
                    return true;
                }
            }
        }
        return false;
    }

    public final ConstraintSet b(int i2) {
        int iB;
        StateSet stateSet = this.f2224b;
        if (stateSet != null && (iB = stateSet.b(i2)) != -1) {
            i2 = iB;
        }
        SparseArray sparseArray = this.f2229g;
        if (sparseArray.get(i2) != null) {
            return (ConstraintSet) sparseArray.get(i2);
        }
        Log.e("MotionScene", "Warning could not find ConstraintSet id/" + Debug.c(i2, this.f2223a.getContext()) + " In MotionScene");
        return (ConstraintSet) sparseArray.get(sparseArray.keyAt(0));
    }

    public final int c() {
        Transition transition = this.f2225c;
        return transition != null ? transition.f2244h : this.f2232j;
    }

    public final Interpolator e() {
        Transition transition = this.f2225c;
        int i2 = transition.f2241e;
        if (i2 == -2) {
            return AnimationUtils.loadInterpolator(this.f2223a.getContext(), this.f2225c.f2243g);
        }
        if (i2 == -1) {
            final Easing easingC = Easing.c(transition.f2242f);
            return new Interpolator() { // from class: androidx.constraintlayout.motion.widget.MotionScene.1
                @Override // android.animation.TimeInterpolator
                public final float getInterpolation(float f2) {
                    return (float) easingC.a(f2);
                }
            };
        }
        if (i2 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i2 == 1) {
            return new AccelerateInterpolator();
        }
        if (i2 == 2) {
            return new DecelerateInterpolator();
        }
        if (i2 == 4) {
            return new BounceInterpolator();
        }
        if (i2 == 5) {
            return new OvershootInterpolator();
        }
        if (i2 != 6) {
            return null;
        }
        return new AnticipateInterpolator();
    }

    public final void f(MotionController motionController) {
        Transition transition = this.f2225c;
        if (transition != null) {
            Iterator it = transition.f2247k.iterator();
            while (it.hasNext()) {
                ((KeyFrames) it.next()).a(motionController);
            }
        } else {
            Transition transition2 = this.f2227e;
            if (transition2 != null) {
                Iterator it2 = transition2.f2247k.iterator();
                while (it2.hasNext()) {
                    ((KeyFrames) it2.next()).a(motionController);
                }
            }
        }
    }

    public final float g() {
        TouchResponse touchResponse;
        Transition transition = this.f2225c;
        if (transition == null || (touchResponse = transition.f2248l) == null) {
            return 0.0f;
        }
        return touchResponse.t;
    }

    public final int h() {
        Transition transition = this.f2225c;
        if (transition == null) {
            return -1;
        }
        return transition.f2240d;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i(android.content.Context r18, android.content.res.XmlResourceParser r19) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.i(android.content.Context, android.content.res.XmlResourceParser):int");
    }

    public final int j(int i2, Context context) throws XmlPullParserException, Resources.NotFoundException, IOException {
        XmlResourceParser xml = context.getResources().getXml(i2);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && "ConstraintSet".equals(name)) {
                    i2 = i(context, xml);
                    return i2;
                }
            }
            return -1;
        } catch (IOException e2) {
            Log.e("MotionScene", "Error parsing resource: " + i2, e2);
            return -1;
        } catch (XmlPullParserException e3) {
            Log.e("MotionScene", "Error parsing resource: " + i2, e3);
            return -1;
        }
    }

    public final void k(Context context, XmlResourceParser xmlResourceParser) throws XmlPullParserException, Resources.NotFoundException, IOException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.include);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.include_constraintSet) {
                j(typedArrayObtainStyledAttributes.getResourceId(index, -1), context);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void l(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.MotionScene);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.MotionScene_defaultDuration) {
                int i3 = typedArrayObtainStyledAttributes.getInt(index, this.f2232j);
                this.f2232j = i3;
                if (i3 < 8) {
                    this.f2232j = 8;
                }
            } else if (index == R.styleable.MotionScene_layoutDuringTransition) {
                this.f2233k = typedArrayObtainStyledAttributes.getInteger(index, 0);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void m(int i2, MotionLayout motionLayout) {
        SparseArray sparseArray = this.f2229g;
        ConstraintSet constraintSet = (ConstraintSet) sparseArray.get(i2);
        constraintSet.f2453b = constraintSet.f2452a;
        int i3 = this.f2231i.get(i2);
        HashMap map = constraintSet.f2458g;
        if (i3 > 0) {
            m(i3, motionLayout);
            ConstraintSet constraintSet2 = (ConstraintSet) sparseArray.get(i3);
            if (constraintSet2 == null) {
                Log.e("MotionScene", "ERROR! invalid deriveConstraintsFrom: @id/" + Debug.c(i3, this.f2223a.getContext()));
                return;
            }
            constraintSet.f2453b += "/" + constraintSet2.f2453b;
            HashMap map2 = constraintSet2.f2458g;
            for (Integer num : map2.keySet()) {
                num.getClass();
                ConstraintSet.Constraint constraint = (ConstraintSet.Constraint) map2.get(num);
                if (!map.containsKey(num)) {
                    map.put(num, new ConstraintSet.Constraint());
                }
                ConstraintSet.Constraint constraint2 = (ConstraintSet.Constraint) map.get(num);
                if (constraint2 != null) {
                    ConstraintSet.Layout layout = constraint2.f2463e;
                    if (!layout.f2480b) {
                        layout.a(constraint.f2463e);
                    }
                    ConstraintSet.PropertySet propertySet = constraint2.f2461c;
                    if (!propertySet.f2505a) {
                        ConstraintSet.PropertySet propertySet2 = constraint.f2461c;
                        propertySet.f2505a = propertySet2.f2505a;
                        propertySet.f2506b = propertySet2.f2506b;
                        propertySet.f2508d = propertySet2.f2508d;
                        propertySet.f2509e = propertySet2.f2509e;
                        propertySet.f2507c = propertySet2.f2507c;
                    }
                    ConstraintSet.Transform transform = constraint2.f2464f;
                    if (!transform.f2510a) {
                        transform.a(constraint.f2464f);
                    }
                    ConstraintSet.Motion motion = constraint2.f2462d;
                    if (!motion.f2492a) {
                        motion.a(constraint.f2462d);
                    }
                    for (String str : constraint.f2465g.keySet()) {
                        if (!constraint2.f2465g.containsKey(str)) {
                            constraint2.f2465g.put(str, (ConstraintAttribute) constraint.f2465g.get(str));
                        }
                    }
                }
            }
        } else {
            constraintSet.f2453b = b.r(new StringBuilder(), constraintSet.f2453b, "  layout");
            int childCount = motionLayout.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = motionLayout.getChildAt(i4);
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                int id = childAt.getId();
                if (constraintSet.f2457f && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (!map.containsKey(Integer.valueOf(id))) {
                    map.put(Integer.valueOf(id), new ConstraintSet.Constraint());
                }
                ConstraintSet.Constraint constraint3 = (ConstraintSet.Constraint) map.get(Integer.valueOf(id));
                if (constraint3 != null) {
                    ConstraintSet.Layout layout2 = constraint3.f2463e;
                    if (!layout2.f2480b) {
                        constraint3.d(id, layoutParams);
                        if (childAt instanceof ConstraintHelper) {
                            layout2.j0 = ((ConstraintHelper) childAt).getReferencedIds();
                            if (childAt instanceof Barrier) {
                                Barrier barrier = (Barrier) childAt;
                                layout2.o0 = barrier.getAllowsGoneWidget();
                                layout2.g0 = barrier.getType();
                                layout2.h0 = barrier.getMargin();
                            }
                        }
                        layout2.f2480b = true;
                    }
                    ConstraintSet.PropertySet propertySet3 = constraint3.f2461c;
                    if (!propertySet3.f2505a) {
                        propertySet3.f2506b = childAt.getVisibility();
                        propertySet3.f2508d = childAt.getAlpha();
                        propertySet3.f2505a = true;
                    }
                    ConstraintSet.Transform transform2 = constraint3.f2464f;
                    if (!transform2.f2510a) {
                        transform2.f2510a = true;
                        transform2.f2511b = childAt.getRotation();
                        transform2.f2512c = childAt.getRotationX();
                        transform2.f2513d = childAt.getRotationY();
                        transform2.f2514e = childAt.getScaleX();
                        transform2.f2515f = childAt.getScaleY();
                        float pivotX = childAt.getPivotX();
                        float pivotY = childAt.getPivotY();
                        if (pivotX != 0.0d || pivotY != 0.0d) {
                            transform2.f2516g = pivotX;
                            transform2.f2517h = pivotY;
                        }
                        transform2.f2519j = childAt.getTranslationX();
                        transform2.f2520k = childAt.getTranslationY();
                        transform2.f2521l = childAt.getTranslationZ();
                        if (transform2.f2522m) {
                            transform2.n = childAt.getElevation();
                        }
                    }
                }
            }
        }
        constraintSet.b(constraintSet);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(int r9, int r10) {
        /*
            r8 = this;
            androidx.constraintlayout.widget.StateSet r0 = r8.f2224b
            r1 = -1
            if (r0 == 0) goto L18
            int r0 = r0.b(r9)
            if (r0 == r1) goto Lc
            goto Ld
        Lc:
            r0 = r9
        Ld:
            androidx.constraintlayout.widget.StateSet r2 = r8.f2224b
            int r2 = r2.b(r10)
            if (r2 == r1) goto L16
            goto L1a
        L16:
            r2 = r10
            goto L1a
        L18:
            r0 = r9
            goto L16
        L1a:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r8.f2225c
            if (r3 == 0) goto L27
            int r4 = r3.f2239c
            if (r4 != r10) goto L27
            int r3 = r3.f2240d
            if (r3 != r9) goto L27
            goto L52
        L27:
            java.util.ArrayList r3 = r8.f2226d
            java.util.Iterator r4 = r3.iterator()
        L2d:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L53
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.motion.widget.MotionScene$Transition r5 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r5
            int r6 = r5.f2239c
            if (r6 != r2) goto L41
            int r7 = r5.f2240d
            if (r7 == r0) goto L47
        L41:
            if (r6 != r10) goto L2d
            int r6 = r5.f2240d
            if (r6 != r9) goto L2d
        L47:
            r8.f2225c = r5
            androidx.constraintlayout.motion.widget.TouchResponse r9 = r5.f2248l
            if (r9 == 0) goto L52
            boolean r10 = r8.p
            r9.c(r10)
        L52:
            return
        L53:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r9 = r8.f2227e
            java.util.ArrayList r4 = r8.f2228f
            java.util.Iterator r4 = r4.iterator()
        L5b:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L6d
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.motion.widget.MotionScene$Transition r5 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r5
            int r6 = r5.f2239c
            if (r6 != r10) goto L5b
            r9 = r5
            goto L5b
        L6d:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r10 = new androidx.constraintlayout.motion.widget.MotionScene$Transition
            r10.<init>(r8, r9)
            r10.f2240d = r0
            r10.f2239c = r2
            if (r0 == r1) goto L7b
            r3.add(r10)
        L7b:
            r8.f2225c = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.n(int, int):void");
    }

    public final boolean o() {
        Iterator it = this.f2226d.iterator();
        while (it.hasNext()) {
            if (((Transition) it.next()).f2248l != null) {
                return true;
            }
        }
        Transition transition = this.f2225c;
        return (transition == null || transition.f2248l == null) ? false : true;
    }

    public static class Transition {

        /* renamed from: a, reason: collision with root package name */
        public final int f2237a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f2238b;

        /* renamed from: c, reason: collision with root package name */
        public int f2239c;

        /* renamed from: d, reason: collision with root package name */
        public int f2240d;

        /* renamed from: e, reason: collision with root package name */
        public int f2241e;

        /* renamed from: f, reason: collision with root package name */
        public String f2242f;

        /* renamed from: g, reason: collision with root package name */
        public int f2243g;

        /* renamed from: h, reason: collision with root package name */
        public int f2244h;

        /* renamed from: i, reason: collision with root package name */
        public final float f2245i;

        /* renamed from: j, reason: collision with root package name */
        public final MotionScene f2246j;

        /* renamed from: k, reason: collision with root package name */
        public final ArrayList f2247k;

        /* renamed from: l, reason: collision with root package name */
        public TouchResponse f2248l;

        /* renamed from: m, reason: collision with root package name */
        public final ArrayList f2249m;
        public final int n;
        public boolean o;
        public int p;
        public final int q;
        public final int r;

        public static class TransitionOnClick implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final Transition f2250a;

            /* renamed from: b, reason: collision with root package name */
            public final int f2251b;

            /* renamed from: c, reason: collision with root package name */
            public final int f2252c;

            public TransitionOnClick(Context context, Transition transition, XmlResourceParser xmlResourceParser) {
                this.f2251b = -1;
                this.f2252c = 17;
                this.f2250a = transition;
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.OnClick);
                int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
                for (int i2 = 0; i2 < indexCount; i2++) {
                    int index = typedArrayObtainStyledAttributes.getIndex(i2);
                    if (index == R.styleable.OnClick_targetId) {
                        this.f2251b = typedArrayObtainStyledAttributes.getResourceId(index, this.f2251b);
                    } else if (index == R.styleable.OnClick_clickAction) {
                        this.f2252c = typedArrayObtainStyledAttributes.getInt(index, this.f2252c);
                    }
                }
                typedArrayObtainStyledAttributes.recycle();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r8v4, types: [android.view.View] */
            public final void a(MotionLayout motionLayout, int i2, Transition transition) {
                int i3 = this.f2251b;
                MotionLayout motionLayoutFindViewById = motionLayout;
                if (i3 != -1) {
                    motionLayoutFindViewById = motionLayout.findViewById(i3);
                }
                if (motionLayoutFindViewById == null) {
                    Log.e("MotionScene", "OnClick could not find id " + i3);
                    return;
                }
                int i4 = transition.f2240d;
                int i5 = transition.f2239c;
                if (i4 == -1) {
                    motionLayoutFindViewById.setOnClickListener(this);
                    return;
                }
                int i6 = this.f2252c;
                int i7 = i6 & 1;
                if (((i7 != 0 && i2 == i4) | (i7 != 0 && i2 == i4) | ((i6 & 256) != 0 && i2 == i4) | ((i6 & 16) != 0 && i2 == i5)) || ((i6 & 4096) != 0 && i2 == i5)) {
                    motionLayoutFindViewById.setOnClickListener(this);
                }
            }

            public final void b(MotionLayout motionLayout) {
                int i2 = this.f2251b;
                if (i2 == -1) {
                    return;
                }
                View viewFindViewById = motionLayout.findViewById(i2);
                if (viewFindViewById != null) {
                    viewFindViewById.setOnClickListener(null);
                    return;
                }
                Log.e("MotionScene", " (*)  could not find id " + i2);
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Exception {
                Transition transition = this.f2250a;
                MotionScene motionScene = transition.f2246j;
                MotionLayout motionLayout = motionScene.f2223a;
                if (motionLayout.z) {
                    if (transition.f2240d == -1) {
                        int currentState = motionLayout.getCurrentState();
                        if (currentState != -1) {
                            Transition transition2 = new Transition(motionScene, transition);
                            transition2.f2240d = currentState;
                            transition2.f2239c = transition.f2239c;
                            motionLayout.setTransition(transition2);
                            motionLayout.r(1.0f);
                            motionLayout.e1 = null;
                            return;
                        }
                        int i2 = transition.f2239c;
                        if (motionLayout.isAttachedToWindow()) {
                            motionLayout.I(i2, -1);
                            return;
                        }
                        if (motionLayout.d1 == null) {
                            motionLayout.d1 = motionLayout.new StateCache();
                        }
                        motionLayout.d1.f2203d = i2;
                        return;
                    }
                    Transition transition3 = motionScene.f2225c;
                    int i3 = this.f2252c;
                    int i4 = i3 & 1;
                    boolean z = true;
                    boolean z2 = false;
                    boolean z3 = (i4 == 0 && (i3 & 256) == 0) ? false : true;
                    int i5 = i3 & 16;
                    if (i5 == 0 && (i3 & 4096) == 0) {
                        z = false;
                    }
                    if (z3 && z) {
                        if (transition3 != transition) {
                            motionLayout.setTransition(transition);
                        }
                        if (motionLayout.getCurrentState() != motionLayout.getEndState() && motionLayout.getProgress() <= 0.5f) {
                            z = false;
                            z2 = z3;
                        }
                    } else {
                        z2 = z3;
                    }
                    if (transition != transition3) {
                        int i6 = transition.f2239c;
                        int i7 = transition.f2240d;
                        if (i7 != -1) {
                            int i8 = motionLayout.v;
                            if (i8 != i7 && i8 != i6) {
                                return;
                            }
                        } else if (motionLayout.v == i6) {
                            return;
                        }
                    }
                    if (z2 && i4 != 0) {
                        motionLayout.setTransition(transition);
                        motionLayout.r(1.0f);
                        motionLayout.e1 = null;
                        return;
                    }
                    if (z && i5 != 0) {
                        motionLayout.setTransition(transition);
                        motionLayout.r(0.0f);
                    } else if (z2 && (i3 & 256) != 0) {
                        motionLayout.setTransition(transition);
                        motionLayout.setProgress(1.0f);
                    } else {
                        if (!z || (i3 & 4096) == 0) {
                            return;
                        }
                        motionLayout.setTransition(transition);
                        motionLayout.setProgress(0.0f);
                    }
                }
            }
        }

        public Transition(MotionScene motionScene, Transition transition) {
            this.f2237a = -1;
            this.f2238b = false;
            this.f2239c = -1;
            this.f2240d = -1;
            this.f2241e = 0;
            this.f2242f = null;
            this.f2243g = -1;
            this.f2244h = 400;
            this.f2245i = 0.0f;
            this.f2247k = new ArrayList();
            this.f2248l = null;
            this.f2249m = new ArrayList();
            this.n = 0;
            this.o = false;
            this.p = -1;
            this.q = 0;
            this.r = 0;
            this.f2246j = motionScene;
            this.f2244h = motionScene.f2232j;
            if (transition != null) {
                this.p = transition.p;
                this.f2241e = transition.f2241e;
                this.f2242f = transition.f2242f;
                this.f2243g = transition.f2243g;
                this.f2244h = transition.f2244h;
                this.f2247k = transition.f2247k;
                this.f2245i = transition.f2245i;
                this.q = transition.q;
            }
        }

        public final void a() {
            TouchResponse touchResponse = this.f2248l;
            if (touchResponse != null) {
                touchResponse.f2255c = 5;
            }
        }

        public Transition(MotionScene motionScene, int i2, int i3) {
            this.f2237a = -1;
            this.f2238b = false;
            this.f2239c = -1;
            this.f2240d = -1;
            this.f2241e = 0;
            this.f2242f = null;
            this.f2243g = -1;
            this.f2244h = 400;
            this.f2245i = 0.0f;
            this.f2247k = new ArrayList();
            this.f2248l = null;
            this.f2249m = new ArrayList();
            this.n = 0;
            this.o = false;
            this.p = -1;
            this.q = 0;
            this.r = 0;
            this.f2237a = -1;
            this.f2246j = motionScene;
            this.f2240d = i2;
            this.f2239c = i3;
            this.f2244h = motionScene.f2232j;
            this.q = motionScene.f2233k;
        }

        public Transition(MotionScene motionScene, Context context, XmlResourceParser xmlResourceParser) throws Resources.NotFoundException {
            this.f2237a = -1;
            this.f2238b = false;
            this.f2239c = -1;
            this.f2240d = -1;
            this.f2241e = 0;
            this.f2242f = null;
            this.f2243g = -1;
            this.f2244h = 400;
            this.f2245i = 0.0f;
            this.f2247k = new ArrayList();
            this.f2248l = null;
            this.f2249m = new ArrayList();
            this.n = 0;
            this.o = false;
            this.p = -1;
            this.q = 0;
            this.r = 0;
            this.f2244h = motionScene.f2232j;
            this.q = motionScene.f2233k;
            this.f2246j = motionScene;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.Transition);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                int i3 = R.styleable.Transition_constraintSetEnd;
                SparseArray sparseArray = motionScene.f2229g;
                if (index == i3) {
                    this.f2239c = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f2239c);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.k(this.f2239c, context);
                        sparseArray.append(this.f2239c, constraintSet);
                    } else if ("xml".equals(resourceTypeName)) {
                        this.f2239c = motionScene.j(this.f2239c, context);
                    }
                } else if (index == R.styleable.Transition_constraintSetStart) {
                    this.f2240d = typedArrayObtainStyledAttributes.getResourceId(index, this.f2240d);
                    String resourceTypeName2 = context.getResources().getResourceTypeName(this.f2240d);
                    if ("layout".equals(resourceTypeName2)) {
                        ConstraintSet constraintSet2 = new ConstraintSet();
                        constraintSet2.k(this.f2240d, context);
                        sparseArray.append(this.f2240d, constraintSet2);
                    } else if ("xml".equals(resourceTypeName2)) {
                        this.f2240d = motionScene.j(this.f2240d, context);
                    }
                } else if (index == R.styleable.Transition_motionInterpolator) {
                    int i4 = typedArrayObtainStyledAttributes.peekValue(index).type;
                    if (i4 == 1) {
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                        this.f2243g = resourceId;
                        if (resourceId != -1) {
                            this.f2241e = -2;
                        }
                    } else if (i4 == 3) {
                        String string = typedArrayObtainStyledAttributes.getString(index);
                        this.f2242f = string;
                        if (string != null) {
                            if (string.indexOf("/") > 0) {
                                this.f2243g = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                this.f2241e = -2;
                            } else {
                                this.f2241e = -1;
                            }
                        }
                    } else {
                        this.f2241e = typedArrayObtainStyledAttributes.getInteger(index, this.f2241e);
                    }
                } else if (index == R.styleable.Transition_duration) {
                    int i5 = typedArrayObtainStyledAttributes.getInt(index, this.f2244h);
                    this.f2244h = i5;
                    if (i5 < 8) {
                        this.f2244h = 8;
                    }
                } else if (index == R.styleable.Transition_staggered) {
                    this.f2245i = typedArrayObtainStyledAttributes.getFloat(index, this.f2245i);
                } else if (index == R.styleable.Transition_autoTransition) {
                    this.n = typedArrayObtainStyledAttributes.getInteger(index, this.n);
                } else if (index == R.styleable.Transition_android_id) {
                    this.f2237a = typedArrayObtainStyledAttributes.getResourceId(index, this.f2237a);
                } else if (index == R.styleable.Transition_transitionDisable) {
                    this.o = typedArrayObtainStyledAttributes.getBoolean(index, this.o);
                } else if (index == R.styleable.Transition_pathMotionArc) {
                    this.p = typedArrayObtainStyledAttributes.getInteger(index, -1);
                } else if (index == R.styleable.Transition_layoutDuringTransition) {
                    this.q = typedArrayObtainStyledAttributes.getInteger(index, 0);
                } else if (index == R.styleable.Transition_transitionFlags) {
                    this.r = typedArrayObtainStyledAttributes.getInteger(index, 0);
                }
            }
            if (this.f2240d == -1) {
                this.f2238b = true;
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
