package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import androidx.transition.GhostViewHolder;
import androidx.transition.PropertyValuesHolderUtils;
import androidx.transition.ViewGroupUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes3.dex */
public class ChangeTransform extends Transition {
    public static final String[] I = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
    public static final Property J = new AnonymousClass1(float[].class, "nonTranslations");
    public static final Property K = new AnonymousClass2(PointF.class, "translations");
    public static final boolean L = true;
    public final boolean F;
    public final boolean G;
    public final Matrix H;

    /* renamed from: androidx.transition.ChangeTransform$1, reason: invalid class name */
    public class AnonymousClass1 extends Property<PathAnimatorMatrix, float[]> {
        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ float[] get(PathAnimatorMatrix pathAnimatorMatrix) {
            return null;
        }

        @Override // android.util.Property
        public final void set(PathAnimatorMatrix pathAnimatorMatrix, float[] fArr) {
            PathAnimatorMatrix pathAnimatorMatrix2 = pathAnimatorMatrix;
            float[] fArr2 = fArr;
            pathAnimatorMatrix2.getClass();
            System.arraycopy(fArr2, 0, pathAnimatorMatrix2.f12055c, 0, fArr2.length);
            pathAnimatorMatrix2.a();
        }
    }

    /* renamed from: androidx.transition.ChangeTransform$2, reason: invalid class name */
    public class AnonymousClass2 extends Property<PathAnimatorMatrix, PointF> {
        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(PathAnimatorMatrix pathAnimatorMatrix) {
            return null;
        }

        @Override // android.util.Property
        public final void set(PathAnimatorMatrix pathAnimatorMatrix, PointF pointF) {
            PathAnimatorMatrix pathAnimatorMatrix2 = pathAnimatorMatrix;
            PointF pointF2 = pointF;
            pathAnimatorMatrix2.getClass();
            pathAnimatorMatrix2.f12056d = pointF2.x;
            pathAnimatorMatrix2.f12057e = pointF2.y;
            pathAnimatorMatrix2.a();
        }
    }

    public static class GhostListener extends TransitionListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public View f12043a;

        /* renamed from: b, reason: collision with root package name */
        public GhostView f12044b;

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public final void b() {
            this.f12044b.setVisibility(4);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public final void f() {
            this.f12044b.setVisibility(0);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public final void j(Transition transition) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            transition.B(this);
            int i2 = Build.VERSION.SDK_INT;
            View view = this.f12043a;
            if (i2 == 28) {
                if (!GhostViewPlatform.f12088g) {
                    try {
                        GhostViewPlatform.b();
                        Method declaredMethod = GhostViewPlatform.f12083b.getDeclaredMethod("removeGhost", View.class);
                        GhostViewPlatform.f12087f = declaredMethod;
                        declaredMethod.setAccessible(true);
                    } catch (NoSuchMethodException e2) {
                        Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", e2);
                    }
                    GhostViewPlatform.f12088g = true;
                }
                Method method = GhostViewPlatform.f12087f;
                if (method != null) {
                    try {
                        method.invoke(null, view);
                    } catch (IllegalAccessException unused) {
                    } catch (InvocationTargetException e3) {
                        throw new RuntimeException(e3.getCause());
                    }
                }
            } else {
                int i3 = GhostViewPort.f12090g;
                GhostViewPort ghostViewPort = (GhostViewPort) view.getTag(R.id.ghost_view);
                if (ghostViewPort != null) {
                    int i4 = ghostViewPort.f12094d - 1;
                    ghostViewPort.f12094d = i4;
                    if (i4 <= 0) {
                        ((GhostViewHolder) ghostViewPort.getParent()).removeView(ghostViewPort);
                    }
                }
            }
            view.setTag(R.id.transition_transform, null);
            view.setTag(R.id.parent_matrix, null);
        }
    }

    public static class Listener extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f12045a;

        /* renamed from: b, reason: collision with root package name */
        public final Matrix f12046b = new Matrix();

        /* renamed from: c, reason: collision with root package name */
        public final boolean f12047c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f12048d;

        /* renamed from: e, reason: collision with root package name */
        public final View f12049e;

        /* renamed from: f, reason: collision with root package name */
        public final Transforms f12050f;

        /* renamed from: g, reason: collision with root package name */
        public final PathAnimatorMatrix f12051g;

        /* renamed from: h, reason: collision with root package name */
        public final Matrix f12052h;

        public Listener(View view, Transforms transforms, PathAnimatorMatrix pathAnimatorMatrix, Matrix matrix, boolean z, boolean z2) {
            this.f12047c = z;
            this.f12048d = z2;
            this.f12049e = view;
            this.f12050f = transforms;
            this.f12051g = pathAnimatorMatrix;
            this.f12052h = matrix;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            this.f12045a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            boolean z = this.f12045a;
            Transforms transforms = this.f12050f;
            View view = this.f12049e;
            if (!z) {
                if (this.f12047c && this.f12048d) {
                    Matrix matrix = this.f12046b;
                    matrix.set(this.f12052h);
                    view.setTag(R.id.transition_transform, matrix);
                    transforms.getClass();
                    String[] strArr = ChangeTransform.I;
                    view.setTranslationX(transforms.f12058a);
                    view.setTranslationY(transforms.f12059b);
                    ViewCompat.N(view, transforms.f12060c);
                    view.setScaleX(transforms.f12061d);
                    view.setScaleY(transforms.f12062e);
                    view.setRotationX(transforms.f12063f);
                    view.setRotationY(transforms.f12064g);
                    view.setRotation(transforms.f12065h);
                } else {
                    view.setTag(R.id.transition_transform, null);
                    view.setTag(R.id.parent_matrix, null);
                }
            }
            ViewUtils.f12184a.d(view, null);
            transforms.getClass();
            String[] strArr2 = ChangeTransform.I;
            view.setTranslationX(transforms.f12058a);
            view.setTranslationY(transforms.f12059b);
            ViewCompat.N(view, transforms.f12060c);
            view.setScaleX(transforms.f12061d);
            view.setScaleY(transforms.f12062e);
            view.setRotationX(transforms.f12063f);
            view.setRotationY(transforms.f12064g);
            view.setRotation(transforms.f12065h);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public final void onAnimationPause(Animator animator) {
            Matrix matrix = this.f12051g.f12053a;
            Matrix matrix2 = this.f12046b;
            matrix2.set(matrix);
            int i2 = R.id.transition_transform;
            View view = this.f12049e;
            view.setTag(i2, matrix2);
            Transforms transforms = this.f12050f;
            transforms.getClass();
            String[] strArr = ChangeTransform.I;
            view.setTranslationX(transforms.f12058a);
            view.setTranslationY(transforms.f12059b);
            ViewCompat.N(view, transforms.f12060c);
            view.setScaleX(transforms.f12061d);
            view.setScaleY(transforms.f12062e);
            view.setRotationX(transforms.f12063f);
            view.setRotationY(transforms.f12064g);
            view.setRotation(transforms.f12065h);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public final void onAnimationResume(Animator animator) {
            String[] strArr = ChangeTransform.I;
            View view = this.f12049e;
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            ViewCompat.N(view, 0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setRotationX(0.0f);
            view.setRotationY(0.0f);
            view.setRotation(0.0f);
        }
    }

    public static class PathAnimatorMatrix {

        /* renamed from: a, reason: collision with root package name */
        public final Matrix f12053a = new Matrix();

        /* renamed from: b, reason: collision with root package name */
        public final View f12054b;

        /* renamed from: c, reason: collision with root package name */
        public final float[] f12055c;

        /* renamed from: d, reason: collision with root package name */
        public float f12056d;

        /* renamed from: e, reason: collision with root package name */
        public float f12057e;

        public PathAnimatorMatrix(View view, float[] fArr) {
            this.f12054b = view;
            float[] fArr2 = (float[]) fArr.clone();
            this.f12055c = fArr2;
            this.f12056d = fArr2[2];
            this.f12057e = fArr2[5];
            a();
        }

        public final void a() {
            float f2 = this.f12056d;
            float[] fArr = this.f12055c;
            fArr[2] = f2;
            fArr[5] = this.f12057e;
            Matrix matrix = this.f12053a;
            matrix.setValues(fArr);
            ViewUtils.f12184a.d(this.f12054b, matrix);
        }
    }

    public static class Transforms {

        /* renamed from: a, reason: collision with root package name */
        public final float f12058a;

        /* renamed from: b, reason: collision with root package name */
        public final float f12059b;

        /* renamed from: c, reason: collision with root package name */
        public final float f12060c;

        /* renamed from: d, reason: collision with root package name */
        public final float f12061d;

        /* renamed from: e, reason: collision with root package name */
        public final float f12062e;

        /* renamed from: f, reason: collision with root package name */
        public final float f12063f;

        /* renamed from: g, reason: collision with root package name */
        public final float f12064g;

        /* renamed from: h, reason: collision with root package name */
        public final float f12065h;

        public Transforms(View view) {
            this.f12058a = view.getTranslationX();
            this.f12059b = view.getTranslationY();
            this.f12060c = ViewCompat.o(view);
            this.f12061d = view.getScaleX();
            this.f12062e = view.getScaleY();
            this.f12063f = view.getRotationX();
            this.f12064g = view.getRotationY();
            this.f12065h = view.getRotation();
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Transforms)) {
                return false;
            }
            Transforms transforms = (Transforms) obj;
            return transforms.f12058a == this.f12058a && transforms.f12059b == this.f12059b && transforms.f12060c == this.f12060c && transforms.f12061d == this.f12061d && transforms.f12062e == this.f12062e && transforms.f12063f == this.f12063f && transforms.f12064g == this.f12064g && transforms.f12065h == this.f12065h;
        }

        public final int hashCode() {
            float f2 = this.f12058a;
            int iFloatToIntBits = (f2 != 0.0f ? Float.floatToIntBits(f2) : 0) * 31;
            float f3 = this.f12059b;
            int iFloatToIntBits2 = (iFloatToIntBits + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
            float f4 = this.f12060c;
            int iFloatToIntBits3 = (iFloatToIntBits2 + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0)) * 31;
            float f5 = this.f12061d;
            int iFloatToIntBits4 = (iFloatToIntBits3 + (f5 != 0.0f ? Float.floatToIntBits(f5) : 0)) * 31;
            float f6 = this.f12062e;
            int iFloatToIntBits5 = (iFloatToIntBits4 + (f6 != 0.0f ? Float.floatToIntBits(f6) : 0)) * 31;
            float f7 = this.f12063f;
            int iFloatToIntBits6 = (iFloatToIntBits5 + (f7 != 0.0f ? Float.floatToIntBits(f7) : 0)) * 31;
            float f8 = this.f12064g;
            int iFloatToIntBits7 = (iFloatToIntBits6 + (f8 != 0.0f ? Float.floatToIntBits(f8) : 0)) * 31;
            float f9 = this.f12065h;
            return iFloatToIntBits7 + (f9 != 0.0f ? Float.floatToIntBits(f9) : 0);
        }
    }

    public ChangeTransform() {
        this.F = true;
        this.G = true;
        this.H = new Matrix();
    }

    public final void P(TransitionValues transitionValues) {
        View view = transitionValues.f12164b;
        if (view.getVisibility() == 8) {
            return;
        }
        HashMap map = transitionValues.f12163a;
        map.put("android:changeTransform:parent", view.getParent());
        map.put("android:changeTransform:transforms", new Transforms(view));
        Matrix matrix = view.getMatrix();
        map.put("android:changeTransform:matrix", (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
        if (this.G) {
            Matrix matrix2 = new Matrix();
            ViewUtils.f12184a.e((ViewGroup) view.getParent(), matrix2);
            matrix2.preTranslate(-r2.getScrollX(), -r2.getScrollY());
            map.put("android:changeTransform:parentMatrix", matrix2);
            map.put("android:changeTransform:intermediateMatrix", view.getTag(R.id.transition_transform));
            map.put("android:changeTransform:intermediateParentMatrix", view.getTag(R.id.parent_matrix));
        }
    }

    @Override // androidx.transition.Transition
    public final void d(TransitionValues transitionValues) {
        P(transitionValues);
    }

    @Override // androidx.transition.Transition
    public final void g(TransitionValues transitionValues) {
        P(transitionValues);
        if (L) {
            return;
        }
        ((ViewGroup) transitionValues.f12164b.getParent()).startViewTransition(transitionValues.f12164b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v15, types: [androidx.transition.GhostViewPlatform] */
    /* JADX WARN: Type inference failed for: r27v0, types: [androidx.transition.ChangeTransform, androidx.transition.Transition] */
    /* JADX WARN: Type inference failed for: r28v0, types: [android.view.View, android.view.ViewGroup, java.lang.Object] */
    @Override // androidx.transition.Transition
    public final Animator k(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) throws NoSuchMethodException, SecurityException {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder;
        Object obj;
        ObjectAnimator objectAnimator;
        int i2;
        boolean z;
        GhostViewPort ghostViewPlatform;
        ArrayList arrayList;
        ArrayList arrayList2;
        int i3;
        boolean z2;
        int i4;
        boolean z3;
        int i5;
        int iIntValue;
        GhostViewHolder ghostViewHolder;
        TransitionValues transitionValuesN;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        HashMap map = transitionValues.f12163a;
        if (!map.containsKey("android:changeTransform:parent")) {
            return null;
        }
        HashMap map2 = transitionValues2.f12163a;
        if (!map2.containsKey("android:changeTransform:parent")) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeTransform:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeTransform:parent");
        boolean z4 = this.G && (!(x(viewGroup2) && x(viewGroup3)) ? viewGroup2 == viewGroup3 : !((transitionValuesN = n(viewGroup2, true)) == null || viewGroup3 != transitionValuesN.f12164b));
        Matrix matrix = (Matrix) map.get("android:changeTransform:intermediateMatrix");
        if (matrix != null) {
            map.put("android:changeTransform:matrix", matrix);
        }
        Matrix matrix2 = (Matrix) map.get("android:changeTransform:intermediateParentMatrix");
        if (matrix2 != null) {
            map.put("android:changeTransform:parentMatrix", matrix2);
        }
        if (z4) {
            Matrix matrix3 = (Matrix) map2.get("android:changeTransform:parentMatrix");
            transitionValues2.f12164b.setTag(R.id.parent_matrix, matrix3);
            Matrix matrix4 = this.H;
            matrix4.reset();
            matrix3.invert(matrix4);
            Matrix matrix5 = (Matrix) map.get("android:changeTransform:matrix");
            if (matrix5 == null) {
                matrix5 = new Matrix();
                map.put("android:changeTransform:matrix", matrix5);
            }
            matrix5.postConcat((Matrix) map.get("android:changeTransform:parentMatrix"));
            matrix5.postConcat(matrix4);
        }
        Matrix matrix6 = (Matrix) map.get("android:changeTransform:matrix");
        Matrix matrix7 = (Matrix) map2.get("android:changeTransform:matrix");
        if (matrix6 == null) {
            matrix6 = MatrixUtils.f12099a;
        }
        if (matrix7 == null) {
            matrix7 = MatrixUtils.f12099a;
        }
        if (matrix6.equals(matrix7)) {
            obj = "android:changeTransform:parentMatrix";
            objectAnimatorOfPropertyValuesHolder = null;
        } else {
            Transforms transforms = (Transforms) map2.get("android:changeTransform:transforms");
            View view = transitionValues2.f12164b;
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            ViewCompat.N(view, 0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setRotationX(0.0f);
            view.setRotationY(0.0f);
            view.setRotation(0.0f);
            float[] fArr = new float[9];
            matrix6.getValues(fArr);
            float[] fArr2 = new float[9];
            matrix7.getValues(fArr2);
            PathAnimatorMatrix pathAnimatorMatrix = new PathAnimatorMatrix(view, fArr);
            Property property = J;
            Matrix matrix8 = matrix7;
            FloatArrayEvaluator floatArrayEvaluator = new FloatArrayEvaluator();
            floatArrayEvaluator.f12069a = new float[9];
            objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(pathAnimatorMatrix, PropertyValuesHolder.ofObject(property, floatArrayEvaluator, fArr, fArr2), PropertyValuesHolderUtils.Api21Impl.a(K, this.x.a(fArr[2], fArr[5], fArr2[2], fArr2[5])));
            obj = "android:changeTransform:parentMatrix";
            Listener listener = new Listener(view, transforms, pathAnimatorMatrix, matrix8, z4, this.F);
            objectAnimatorOfPropertyValuesHolder.addListener(listener);
            objectAnimatorOfPropertyValuesHolder.addPauseListener(listener);
        }
        boolean z5 = L;
        if (z4 && objectAnimatorOfPropertyValuesHolder != null && this.F) {
            View view2 = transitionValues2.f12164b;
            Matrix matrix9 = new Matrix((Matrix) map2.get(obj));
            ViewUtils.f12184a.f(viewGroup, matrix9);
            if (Build.VERSION.SDK_INT == 28) {
                if (!GhostViewPlatform.f12086e) {
                    try {
                        GhostViewPlatform.b();
                        Method declaredMethod = GhostViewPlatform.f12083b.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
                        GhostViewPlatform.f12085d = declaredMethod;
                        declaredMethod.setAccessible(true);
                    } catch (NoSuchMethodException e2) {
                        Log.i("GhostViewApi21", "Failed to retrieve addGhost method", e2);
                    }
                    GhostViewPlatform.f12086e = true;
                }
                Method method = GhostViewPlatform.f12085d;
                if (method != null) {
                    try {
                        ghostViewPlatform = new GhostViewPlatform((View) method.invoke(null, view2, viewGroup, matrix9));
                    } catch (IllegalAccessException unused) {
                    } catch (InvocationTargetException e3) {
                        throw new RuntimeException(e3.getCause());
                    }
                    objectAnimator = objectAnimatorOfPropertyValuesHolder;
                    z = z5;
                } else {
                    ghostViewPlatform = null;
                    objectAnimator = objectAnimatorOfPropertyValuesHolder;
                    z = z5;
                }
            } else {
                int i6 = GhostViewPort.f12090g;
                if (!(view2.getParent() instanceof ViewGroup)) {
                    throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
                }
                int i7 = GhostViewHolder.f12080c;
                GhostViewHolder ghostViewHolder2 = (GhostViewHolder) viewGroup.getTag(R.id.ghost_view_holder);
                GhostViewPort ghostViewPort = (GhostViewPort) view2.getTag(R.id.ghost_view);
                if (ghostViewPort == null || (ghostViewHolder = (GhostViewHolder) ghostViewPort.getParent()) == ghostViewHolder2) {
                    i2 = 0;
                } else {
                    i2 = ghostViewPort.f12094d;
                    ghostViewHolder.removeView(ghostViewPort);
                    ghostViewPort = null;
                }
                if (ghostViewPort == null) {
                    ghostViewPort = new GhostViewPort(view2);
                    ghostViewPort.f12095e = matrix9;
                    if (ghostViewHolder2 == null) {
                        ghostViewHolder2 = new GhostViewHolder(viewGroup.getContext());
                        ghostViewHolder2.setClipChildren(false);
                        ghostViewHolder2.f12081a = viewGroup;
                        viewGroup.setTag(R.id.ghost_view_holder, ghostViewHolder2);
                        viewGroup.getOverlay().add(ghostViewHolder2);
                        ghostViewHolder2.f12082b = true;
                    } else {
                        if (!ghostViewHolder2.f12082b) {
                            throw new IllegalStateException("This GhostViewHolder is detached!");
                        }
                        ViewGroup viewGroup4 = ghostViewHolder2.f12081a;
                        viewGroup4.getOverlay().remove(ghostViewHolder2);
                        viewGroup4.getOverlay().add(ghostViewHolder2);
                    }
                    ViewUtils.a(ghostViewHolder2, ghostViewHolder2.getLeft(), ghostViewHolder2.getTop(), viewGroup.getWidth() + ghostViewHolder2.getLeft(), viewGroup.getHeight() + ghostViewHolder2.getTop());
                    ViewUtils.a(ghostViewPort, ghostViewPort.getLeft(), ghostViewPort.getTop(), viewGroup.getWidth() + ghostViewPort.getLeft(), viewGroup.getHeight() + ghostViewPort.getTop());
                    ArrayList arrayList3 = new ArrayList();
                    GhostViewHolder.a(ghostViewPort.f12093c, arrayList3);
                    ArrayList arrayList4 = new ArrayList();
                    int childCount = ghostViewHolder2.getChildCount() - 1;
                    int i8 = 0;
                    while (i8 <= childCount) {
                        int i9 = (i8 + childCount) / 2;
                        ObjectAnimator objectAnimator2 = objectAnimatorOfPropertyValuesHolder;
                        GhostViewHolder.a(((GhostViewPort) ghostViewHolder2.getChildAt(i9)).f12093c, arrayList4);
                        if (arrayList3.isEmpty() || arrayList4.isEmpty()) {
                            arrayList = arrayList3;
                            arrayList2 = arrayList4;
                            i3 = childCount;
                            z2 = z5;
                        } else {
                            i3 = childCount;
                            z2 = z5;
                            if (arrayList3.get(0) != arrayList4.get(0)) {
                                arrayList = arrayList3;
                            } else {
                                int iMin = Math.min(arrayList3.size(), arrayList4.size());
                                int i10 = 1;
                                while (true) {
                                    if (i10 < iMin) {
                                        View view3 = (View) arrayList3.get(i10);
                                        arrayList = arrayList3;
                                        View view4 = (View) arrayList4.get(i10);
                                        if (view3 != view4) {
                                            ViewGroup viewGroup5 = (ViewGroup) view3.getParent();
                                            int childCount2 = viewGroup5.getChildCount();
                                            if (GhostViewHolder.Api21Impl.a(view3) == GhostViewHolder.Api21Impl.a(view4)) {
                                                arrayList2 = arrayList4;
                                                int i11 = 0;
                                                while (i11 < childCount2) {
                                                    int i12 = childCount2;
                                                    i4 = i9;
                                                    if (Build.VERSION.SDK_INT >= 29) {
                                                        iIntValue = ViewGroupUtils.Api29Impl.a(viewGroup5, i11);
                                                        i5 = i11;
                                                    } else {
                                                        if (!ViewGroupUtils.f12183c) {
                                                            try {
                                                                Class cls = Integer.TYPE;
                                                                Method declaredMethod2 = ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", cls, cls);
                                                                ViewGroupUtils.f12182b = declaredMethod2;
                                                                z3 = true;
                                                                try {
                                                                    declaredMethod2.setAccessible(true);
                                                                } catch (NoSuchMethodException unused2) {
                                                                }
                                                            } catch (NoSuchMethodException unused3) {
                                                                z3 = true;
                                                            }
                                                            ViewGroupUtils.f12183c = z3;
                                                        }
                                                        Method method2 = ViewGroupUtils.f12182b;
                                                        if (method2 != null) {
                                                            try {
                                                                i5 = i11;
                                                                try {
                                                                    iIntValue = ((Integer) method2.invoke(viewGroup5, Integer.valueOf(viewGroup5.getChildCount()), Integer.valueOf(i5))).intValue();
                                                                } catch (IllegalAccessException | InvocationTargetException unused4) {
                                                                }
                                                            } catch (IllegalAccessException | InvocationTargetException unused5) {
                                                            }
                                                        } else {
                                                            i5 = i11;
                                                            iIntValue = i5;
                                                        }
                                                    }
                                                    View childAt = viewGroup5.getChildAt(iIntValue);
                                                    if (childAt != view3) {
                                                        if (childAt == view4) {
                                                            break;
                                                        }
                                                        i11 = i5 + 1;
                                                        childCount2 = i12;
                                                        i9 = i4;
                                                    }
                                                }
                                            } else if (GhostViewHolder.Api21Impl.a(view3) <= GhostViewHolder.Api21Impl.a(view4)) {
                                                arrayList2 = arrayList4;
                                                i4 = i9;
                                            }
                                        } else {
                                            i10++;
                                            arrayList3 = arrayList;
                                        }
                                    } else {
                                        arrayList = arrayList3;
                                        arrayList2 = arrayList4;
                                        i4 = i9;
                                        if (arrayList2.size() == iMin) {
                                        }
                                        arrayList2.clear();
                                        arrayList3 = arrayList;
                                        objectAnimatorOfPropertyValuesHolder = objectAnimator2;
                                        z5 = z2;
                                        arrayList4 = arrayList2;
                                    }
                                }
                                childCount = i4 - 1;
                                arrayList2.clear();
                                arrayList3 = arrayList;
                                objectAnimatorOfPropertyValuesHolder = objectAnimator2;
                                z5 = z2;
                                arrayList4 = arrayList2;
                            }
                            arrayList2 = arrayList4;
                        }
                        i4 = i9;
                        i8 = i4 + 1;
                        childCount = i3;
                        arrayList2.clear();
                        arrayList3 = arrayList;
                        objectAnimatorOfPropertyValuesHolder = objectAnimator2;
                        z5 = z2;
                        arrayList4 = arrayList2;
                    }
                    objectAnimator = objectAnimatorOfPropertyValuesHolder;
                    z = z5;
                    if (i8 < 0 || i8 >= ghostViewHolder2.getChildCount()) {
                        ghostViewHolder2.addView(ghostViewPort);
                    } else {
                        ghostViewHolder2.addView(ghostViewPort, i8);
                    }
                    ghostViewPort.f12094d = i2;
                } else {
                    objectAnimator = objectAnimatorOfPropertyValuesHolder;
                    z = z5;
                    ghostViewPort.f12095e = matrix9;
                }
                ghostViewPlatform = ghostViewPort;
                ghostViewPlatform.f12094d++;
            }
            if (ghostViewPlatform != null) {
                ghostViewPlatform.a(transitionValues.f12164b, (ViewGroup) map.get("android:changeTransform:parent"));
                Transition transition = this;
                while (true) {
                    TransitionSet transitionSet = transition.f12123i;
                    if (transitionSet == null) {
                        break;
                    }
                    transition = transitionSet;
                }
                GhostListener ghostListener = new GhostListener();
                ghostListener.f12043a = view2;
                ghostListener.f12044b = ghostViewPlatform;
                transition.a(ghostListener);
                if (z) {
                    View view5 = transitionValues.f12164b;
                    if (view5 != transitionValues2.f12164b) {
                        ViewUtils.b(view5, 0.0f);
                    }
                    ViewUtils.b(view2, 1.0f);
                }
            }
        } else {
            objectAnimator = objectAnimatorOfPropertyValuesHolder;
            if (!z5) {
                viewGroup2.endViewTransition(transitionValues.f12164b);
            }
        }
        return objectAnimator;
    }

    @Override // androidx.transition.Transition
    public final String[] q() {
        return I;
    }

    public ChangeTransform(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = true;
        this.G = true;
        this.H = new Matrix();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f12110e);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.F = TypedArrayUtils.b(typedArrayObtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.G = TypedArrayUtils.b(typedArrayObtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        typedArrayObtainStyledAttributes.recycle();
    }
}
