package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.media.b;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.SimpleArrayMap;
import androidx.coordinatorlayout.R;
import androidx.core.util.Pools;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import org.apache.commons.lang3.ClassUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.SimpleResolver;

/* loaded from: classes3.dex */
public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2, NestedScrollingParent3 {
    public static final String s;
    public static final Class[] t;
    public static final ThreadLocal u;
    public static final Comparator v;
    public static final Pools.SynchronizedPool w;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2545a;

    /* renamed from: b, reason: collision with root package name */
    public final DirectedAcyclicGraph f2546b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f2547c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f2548d;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f2549e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2550f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2551g;

    /* renamed from: h, reason: collision with root package name */
    public final int[] f2552h;

    /* renamed from: i, reason: collision with root package name */
    public View f2553i;

    /* renamed from: j, reason: collision with root package name */
    public View f2554j;

    /* renamed from: k, reason: collision with root package name */
    public OnPreDrawListener f2555k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f2556l;

    /* renamed from: m, reason: collision with root package name */
    public WindowInsetsCompat f2557m;
    public boolean n;
    public Drawable o;
    public ViewGroup.OnHierarchyChangeListener p;
    public OnApplyWindowInsetsListener q;
    public final NestedScrollingParentHelper r;

    public interface AttachedBehavior {
        Behavior getBehavior();
    }

    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        public boolean g(Rect rect, View view) {
            return false;
        }

        public boolean h(View view, View view2) {
            return false;
        }

        public void i(LayoutParams layoutParams) {
        }

        public boolean j(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public void l() {
        }

        public boolean m(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public boolean n(CoordinatorLayout coordinatorLayout, View view, int i2) {
            return false;
        }

        public boolean o(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4) {
            return false;
        }

        public boolean p(View view) {
            return false;
        }

        public void q(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i3, int[] iArr, int i4) {
        }

        public void r(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int[] iArr) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
        }

        public boolean s(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            return false;
        }

        public Parcelable u(View view) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        public boolean v(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i2, int i3) {
            return false;
        }

        public void w(CoordinatorLayout coordinatorLayout, View view, View view2, int i2) {
        }

        public boolean x(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public void k(CoordinatorLayout coordinatorLayout, View view) {
        }

        public void t(View view, Parcelable parcelable) {
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    public @interface DefaultBehavior {
        Class value();
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface DispatchChangeEvent {
    }

    public class HierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        public HierarchyChangeListener() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.p;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout coordinatorLayout = CoordinatorLayout.this;
            coordinatorLayout.u(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = coordinatorLayout.p;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public class OnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
        public OnPreDrawListener() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            CoordinatorLayout.this.u(0);
            return true;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: c, reason: collision with root package name */
        public SparseArray f2574c;

        /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int i2 = parcel.readInt();
            int[] iArr = new int[i2];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.f2574c = new SparseArray(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                this.f2574c.append(iArr[i3], parcelableArray[i3]);
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            SparseArray sparseArray = this.f2574c;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i3 = 0; i3 < size; i3++) {
                iArr[i3] = this.f2574c.keyAt(i3);
                parcelableArr[i3] = (Parcelable) this.f2574c.valueAt(i3);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i2);
        }
    }

    public static class ViewElevationComparator implements Comparator<View> {
        @Override // java.util.Comparator
        public final int compare(View view, View view2) {
            float fQ = ViewCompat.q(view);
            float fQ2 = ViewCompat.q(view2);
            if (fQ > fQ2) {
                return -1;
            }
            return fQ < fQ2 ? 1 : 0;
        }
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        s = r0 != null ? r0.getName() : null;
        v = new ViewElevationComparator();
        t = new Class[]{Context.class, AttributeSet.class};
        u = new ThreadLocal();
        w = new Pools.SynchronizedPool(12);
    }

    public CoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.coordinatorLayoutStyle);
    }

    public static void B(int i2, View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.f2568i;
        if (i3 != i2) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            view.offsetLeftAndRight(i2 - i3);
            layoutParams.f2568i = i2;
        }
    }

    public static void C(int i2, View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.f2569j;
        if (i3 != i2) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            view.offsetTopAndBottom(i2 - i3);
            layoutParams.f2569j = i2;
        }
    }

    public static Rect e() {
        Rect rect = (Rect) w.b();
        return rect == null ? new Rect() : rect;
    }

    public static void q(int i2, Rect rect, Rect rect2, LayoutParams layoutParams, int i3, int i4) {
        int i5 = layoutParams.f2562c;
        if (i5 == 0) {
            i5 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i5, i2);
        int i6 = layoutParams.f2563d;
        if ((i6 & 7) == 0) {
            i6 |= 8388611;
        }
        if ((i6 & 112) == 0) {
            i6 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i6, i2);
        int i7 = absoluteGravity & 7;
        int i8 = absoluteGravity & 112;
        int i9 = absoluteGravity2 & 7;
        int i10 = absoluteGravity2 & 112;
        int iWidth = i9 != 1 ? i9 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int iHeight = i10 != 16 ? i10 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i7 == 1) {
            iWidth -= i3 / 2;
        } else if (i7 != 5) {
            iWidth -= i3;
        }
        if (i8 == 16) {
            iHeight -= i4 / 2;
        } else if (i8 != 80) {
            iHeight -= i4;
        }
        rect2.set(iWidth, iHeight, i3 + iWidth, i4 + iHeight);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static LayoutParams s(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f2561b) {
            if (view instanceof AttachedBehavior) {
                Behavior behavior = ((AttachedBehavior) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                layoutParams.c(behavior);
                layoutParams.f2561b = true;
                return layoutParams;
            }
            DefaultBehavior defaultBehavior = null;
            for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                defaultBehavior = (DefaultBehavior) superclass.getAnnotation(DefaultBehavior.class);
                if (defaultBehavior != null) {
                    break;
                }
            }
            if (defaultBehavior != null) {
                try {
                    layoutParams.c((Behavior) defaultBehavior.value().getDeclaredConstructor(null).newInstance(null));
                } catch (Exception e2) {
                    Log.e("CoordinatorLayout", "Default behavior class " + defaultBehavior.value().getName() + " could not be instantiated. Did you forget a default constructor?", e2);
                }
            }
            layoutParams.f2561b = true;
        }
        return layoutParams;
    }

    public final void A() {
        View view = this.f2553i;
        if (view != null) {
            Behavior behavior = ((LayoutParams) view.getLayoutParams()).f2560a;
            if (behavior != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                behavior.x(this, this.f2553i, motionEventObtain);
                motionEventObtain.recycle();
            }
            this.f2553i = null;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ((LayoutParams) getChildAt(i2).getLayoutParams()).getClass();
        }
        this.f2550f = false;
    }

    public final void D() {
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        if (!getFitsSystemWindows()) {
            ViewCompat.H(this, null);
            return;
        }
        if (this.q == null) {
            this.q = new OnApplyWindowInsetsListener() { // from class: androidx.coordinatorlayout.widget.CoordinatorLayout.1
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat b(View view, WindowInsetsCompat windowInsetsCompat) {
                    CoordinatorLayout coordinatorLayout = CoordinatorLayout.this;
                    if (!Objects.equals(coordinatorLayout.f2557m, windowInsetsCompat)) {
                        coordinatorLayout.f2557m = windowInsetsCompat;
                        boolean z = windowInsetsCompat.j() > 0;
                        coordinatorLayout.n = z;
                        coordinatorLayout.setWillNotDraw(!z && coordinatorLayout.getBackground() == null);
                        if (!windowInsetsCompat.n()) {
                            int childCount = coordinatorLayout.getChildCount();
                            for (int i2 = 0; i2 < childCount; i2++) {
                                View childAt = coordinatorLayout.getChildAt(i2);
                                WeakHashMap weakHashMap2 = ViewCompat.f3080a;
                                if (childAt.getFitsSystemWindows() && ((LayoutParams) childAt.getLayoutParams()).f2560a != null && windowInsetsCompat.n()) {
                                    break;
                                }
                            }
                        }
                        coordinatorLayout.requestLayout();
                    }
                    return windowInsetsCompat;
                }
            };
        }
        ViewCompat.H(this, this.q);
        setSystemUiVisibility(SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j2) {
        Behavior behavior = ((LayoutParams) view.getLayoutParams()).f2560a;
        if (behavior != null) {
            behavior.getClass();
        }
        return super.drawChild(canvas, view, j2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.o;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    public final void f(LayoutParams layoutParams, Rect rect, int i2, int i3) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i2) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i3) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
        rect.set(iMax, iMax2, i2 + iMax, i3 + iMax2);
    }

    public final void g(View view) {
        ArrayList arrayList = (ArrayList) this.f2546b.f2576b.get(view);
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            View view2 = (View) arrayList.get(i2);
            Behavior behavior = ((LayoutParams) view2.getLayoutParams()).f2560a;
            if (behavior != null) {
                behavior.j(this, view2, view);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @VisibleForTesting
    public final List<View> getDependencySortedChildren() {
        z();
        return Collections.unmodifiableList(this.f2545a);
    }

    @RestrictTo
    public final WindowInsetsCompat getLastWindowInsets() {
        return this.f2557m;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.r.a();
    }

    @Nullable
    public Drawable getStatusBarBackground() {
        return this.o;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    public final void h(View view, Rect rect, boolean z) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            p(rect, view);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void i(int i2, View view) {
        NestedScrollingParentHelper nestedScrollingParentHelper = this.r;
        if (i2 == 1) {
            nestedScrollingParentHelper.f3060b = 0;
        } else {
            nestedScrollingParentHelper.f3059a = 0;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.b(i2)) {
                Behavior behavior = layoutParams.f2560a;
                if (behavior != null) {
                    behavior.w(this, childAt, view, i2);
                }
                if (i2 == 0) {
                    layoutParams.f2572m = false;
                } else if (i2 == 1) {
                    layoutParams.n = false;
                }
                layoutParams.o = false;
            }
        }
        this.f2554j = null;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void j(View view, View view2, int i2, int i3) {
        NestedScrollingParentHelper nestedScrollingParentHelper = this.r;
        if (i3 == 1) {
            nestedScrollingParentHelper.f3060b = i2;
        } else {
            nestedScrollingParentHelper.f3059a = i2;
        }
        this.f2554j = view2;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            ((LayoutParams) getChildAt(i4).getLayoutParams()).getClass();
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void k(View view, int i2, int i3, int[] iArr, int i4) {
        Behavior behavior;
        int childCount = getChildCount();
        boolean z = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.b(i4) && (behavior = layoutParams.f2560a) != null) {
                    int[] iArr2 = this.f2548d;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behavior.q(this, childAt, view, i2, i3, iArr2, i4);
                    iMax = i2 > 0 ? Math.max(iMax, iArr2[0]) : Math.min(iMax, iArr2[0]);
                    iMax2 = i3 > 0 ? Math.max(iMax2, iArr2[1]) : Math.min(iMax2, iArr2[1]);
                    z = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z) {
            u(1);
        }
    }

    public final List l(View view) {
        SimpleArrayMap simpleArrayMap = this.f2546b.f2576b;
        int i2 = simpleArrayMap.f1605c;
        ArrayList arrayList = null;
        for (int i3 = 0; i3 < i2; i3++) {
            ArrayList arrayList2 = (ArrayList) simpleArrayMap.j(i3);
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(simpleArrayMap.f(i3));
            }
        }
        return arrayList == null ? Collections.EMPTY_LIST : arrayList;
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public final void m(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        Behavior behavior;
        int childCount = getChildCount();
        int iMax = 0;
        int iMax2 = 0;
        boolean z = false;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.b(i6) && (behavior = layoutParams.f2560a) != null) {
                    int[] iArr2 = this.f2548d;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behavior.r(this, childAt, i3, i4, i5, iArr2);
                    iMax = i4 > 0 ? Math.max(iMax, iArr2[0]) : Math.min(iMax, iArr2[0]);
                    iMax2 = i5 > 0 ? Math.max(iMax2, iArr2[1]) : Math.min(iMax2, iArr2[1]);
                    z = true;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + iMax2;
        if (z) {
            u(1);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void n(View view, int i2, int i3, int i4, int i5, int i6) {
        m(view, i2, i3, i4, i5, 0, this.f2549e);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean o(View view, View view2, int i2, int i3) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Behavior behavior = layoutParams.f2560a;
                if (behavior != null) {
                    boolean zV = behavior.v(this, childAt, view, view2, i2, i3);
                    z |= zV;
                    if (i3 == 0) {
                        layoutParams.f2572m = zV;
                    } else if (i3 == 1) {
                        layoutParams.n = zV;
                    }
                } else if (i3 == 0) {
                    layoutParams.f2572m = false;
                } else if (i3 == 1) {
                    layoutParams.n = false;
                }
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        A();
        if (this.f2556l) {
            if (this.f2555k == null) {
                this.f2555k = new OnPreDrawListener();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f2555k);
        }
        if (this.f2557m == null) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            if (getFitsSystemWindows()) {
                ViewCompat.x(this);
            }
        }
        this.f2551g = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        A();
        if (this.f2556l && this.f2555k != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f2555k);
        }
        View view = this.f2554j;
        if (view != null) {
            i(0, view);
        }
        this.f2551g = false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.n || this.o == null) {
            return;
        }
        WindowInsetsCompat windowInsetsCompat = this.f2557m;
        int iJ = windowInsetsCompat != null ? windowInsetsCompat.j() : 0;
        if (iJ > 0) {
            this.o.setBounds(0, 0, getWidth(), iJ);
            this.o.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            A();
        }
        boolean zY = y(motionEvent, 0);
        if (actionMasked != 1 && actionMasked != 3) {
            return zY;
        }
        this.f2553i = null;
        A();
        return zY;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Behavior behavior;
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        int layoutDirection = getLayoutDirection();
        ArrayList arrayList = this.f2545a;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view = (View) arrayList.get(i6);
            if (view.getVisibility() != 8 && ((behavior = ((LayoutParams) view.getLayoutParams()).f2560a) == null || !behavior.n(this, view, layoutDirection))) {
                v(layoutDirection, view);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x018a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r28, int r29) {
        /*
            Method dump skipped, instructions count: 500
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f2, float f3, boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.b(0)) {
                    Behavior behavior = layoutParams.f2560a;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f2, float f3) {
        Behavior behavior;
        int childCount = getChildCount();
        boolean zP = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.b(0) && (behavior = layoutParams.f2560a) != null) {
                    zP |= behavior.p(view);
                }
            }
        }
        return zP;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        k(view, i2, i3, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        n(view, i2, i3, i4, i5, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i2) {
        j(view, view2, i2, 0);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f3321a);
        SparseArray sparseArray = savedState.f2574c;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            Behavior behavior = s(childAt).f2560a;
            if (id != -1 && behavior != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                behavior.t(childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableU;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).f2560a;
            if (id != -1 && behavior != null && (parcelableU = behavior.u(childAt)) != null) {
                sparseArray.append(id, parcelableU);
            }
        }
        savedState.f2574c = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i2) {
        return o(view, view2, i2, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        i(0, view);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zY;
        int actionMasked = motionEvent.getActionMasked();
        View view = this.f2553i;
        boolean z = false;
        if (view != null) {
            Behavior behavior = ((LayoutParams) view.getLayoutParams()).f2560a;
            zY = behavior != null ? behavior.x(this, this.f2553i, motionEvent) : false;
        } else {
            zY = y(motionEvent, 1);
            if (actionMasked != 0 && zY) {
                z = true;
            }
        }
        if (this.f2553i == null || actionMasked == 3) {
            zY |= super.onTouchEvent(motionEvent);
        } else if (z) {
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            motionEventObtain.setAction(3);
            super.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return zY;
        }
        this.f2553i = null;
        A();
        return zY;
    }

    public final void p(Rect rect, View view) {
        ThreadLocal threadLocal = ViewGroupUtils.f2579a;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ThreadLocal threadLocal2 = ViewGroupUtils.f2579a;
        Matrix matrix = (Matrix) threadLocal2.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal2.set(matrix);
        } else {
            matrix.reset();
        }
        ViewGroupUtils.a(this, view, matrix);
        ThreadLocal threadLocal3 = ViewGroupUtils.f2580b;
        RectF rectF = (RectF) threadLocal3.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal3.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public final int r(int i2) {
        int[] iArr = this.f2552h;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i2);
            return 0;
        }
        if (i2 >= 0 && i2 < iArr.length) {
            return iArr[i2];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i2 + " out of range for " + this);
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Behavior behavior = ((LayoutParams) view.getLayoutParams()).f2560a;
        if (behavior == null || !behavior.s(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.f2550f) {
            return;
        }
        if (this.f2553i == null) {
            int childCount = getChildCount();
            MotionEvent motionEventObtain = null;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).f2560a;
                if (behavior != null) {
                    if (motionEventObtain == null) {
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    behavior.m(this, childAt, motionEventObtain);
                }
            }
            if (motionEventObtain != null) {
                motionEventObtain.recycle();
            }
        }
        A();
        this.f2550f = true;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        D();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.p = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.o;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.o = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.o.setState(getDrawableState());
                }
                Drawable drawable3 = this.o;
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                drawable3.setLayoutDirection(getLayoutDirection());
                this.o.setVisible(getVisibility() == 0, false);
                this.o.setCallback(this);
            }
            WeakHashMap weakHashMap2 = ViewCompat.f3080a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarBackgroundColor(@ColorInt int i2) {
        setStatusBarBackground(new ColorDrawable(i2));
    }

    public void setStatusBarBackgroundResource(@DrawableRes int i2) {
        setStatusBarBackground(i2 != 0 ? getContext().getDrawable(i2) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.o;
        if (drawable == null || drawable.isVisible() == z) {
            return;
        }
        this.o.setVisible(z, false);
    }

    public final boolean t(View view, int i2, int i3) {
        Pools.SynchronizedPool synchronizedPool = w;
        Rect rectE = e();
        p(rectE, view);
        try {
            return rectE.contains(i2, i3);
        } finally {
            rectE.setEmpty();
            synchronizedPool.a(rectE);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0291 A[EDGE_INSN: B:147:0x0291->B:113:0x0291 BREAK  A[LOOP:2: B:118:0x02a9->B:136:0x02e5], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(int r26) {
        /*
            Method dump skipped, instructions count: 781
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.u(int):void");
    }

    public final void v(int i2, View view) {
        Rect rectE;
        Rect rectE2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        View view2 = layoutParams.f2570k;
        if (view2 == null && layoutParams.f2565f != -1) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        Pools.SynchronizedPool synchronizedPool = w;
        if (view2 != null) {
            rectE = e();
            rectE2 = e();
            try {
                p(rectE, view2);
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                q(i2, rectE, rectE2, layoutParams2, measuredWidth, measuredHeight);
                f(layoutParams2, rectE2, measuredWidth, measuredHeight);
                view.layout(rectE2.left, rectE2.top, rectE2.right, rectE2.bottom);
                return;
            } finally {
                rectE.setEmpty();
                synchronizedPool.a(rectE);
                rectE2.setEmpty();
                synchronizedPool.a(rectE2);
            }
        }
        int i3 = layoutParams.f2564e;
        if (i3 < 0) {
            LayoutParams layoutParams3 = (LayoutParams) view.getLayoutParams();
            rectE = e();
            rectE.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin);
            if (this.f2557m != null) {
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                if (getFitsSystemWindows() && !view.getFitsSystemWindows()) {
                    rectE.left = this.f2557m.h() + rectE.left;
                    rectE.top = this.f2557m.j() + rectE.top;
                    rectE.right -= this.f2557m.i();
                    rectE.bottom -= this.f2557m.g();
                }
            }
            rectE2 = e();
            int i4 = layoutParams3.f2562c;
            if ((i4 & 7) == 0) {
                i4 |= 8388611;
            }
            if ((i4 & 112) == 0) {
                i4 |= 48;
            }
            Gravity.apply(i4, view.getMeasuredWidth(), view.getMeasuredHeight(), rectE, rectE2, i2);
            view.layout(rectE2.left, rectE2.top, rectE2.right, rectE2.bottom);
            return;
        }
        LayoutParams layoutParams4 = (LayoutParams) view.getLayoutParams();
        int i5 = layoutParams4.f2562c;
        if (i5 == 0) {
            i5 = 8388661;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i5, i2);
        int i6 = absoluteGravity & 7;
        int i7 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth2 = view.getMeasuredWidth();
        int measuredHeight2 = view.getMeasuredHeight();
        if (i2 == 1) {
            i3 = width - i3;
        }
        int iR = r(i3) - measuredWidth2;
        if (i6 == 1) {
            iR += measuredWidth2 / 2;
        } else if (i6 == 5) {
            iR += measuredWidth2;
        }
        int i8 = i7 != 16 ? i7 != 80 ? 0 : measuredHeight2 : measuredHeight2 / 2;
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin, Math.min(iR, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin, Math.min(i8, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth2 + iMax, measuredHeight2 + iMax2);
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.o;
    }

    public final void w(int i2, int i3, int i4, View view) {
        measureChildWithMargins(view, i2, i3, i4, 0);
    }

    public final boolean x(Behavior behavior, View view, MotionEvent motionEvent, int i2) {
        if (i2 == 0) {
            return behavior.m(this, view, motionEvent);
        }
        if (i2 == 1) {
            return behavior.x(this, view, motionEvent);
        }
        throw new IllegalArgumentException();
    }

    public final boolean y(MotionEvent motionEvent, int i2) {
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.f2547c;
        arrayList.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            arrayList.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i3) : i3));
        }
        Comparator comparator = v;
        if (comparator != null) {
            Collections.sort(arrayList, comparator);
        }
        int size = arrayList.size();
        MotionEvent motionEventObtain = null;
        boolean zX = false;
        for (int i4 = 0; i4 < size; i4++) {
            View view = (View) arrayList.get(i4);
            Behavior behavior = ((LayoutParams) view.getLayoutParams()).f2560a;
            if (zX && actionMasked != 0) {
                if (behavior != null) {
                    if (motionEventObtain == null) {
                        motionEventObtain = MotionEvent.obtain(motionEvent);
                        motionEventObtain.setAction(3);
                    }
                    x(behavior, view, motionEventObtain, i2);
                }
            } else if (!zX && behavior != null && (zX = x(behavior, view, motionEvent, i2))) {
                this.f2553i = view;
                if (actionMasked != 3 && actionMasked != 1) {
                    for (int i5 = 0; i5 < i4; i5++) {
                        View view2 = (View) arrayList.get(i5);
                        Behavior behavior2 = ((LayoutParams) view2.getLayoutParams()).f2560a;
                        if (behavior2 != null) {
                            if (motionEventObtain == null) {
                                motionEventObtain = MotionEvent.obtain(motionEvent);
                                motionEventObtain.setAction(3);
                            }
                            x(behavior2, view2, motionEventObtain, i2);
                        }
                    }
                }
            }
        }
        arrayList.clear();
        if (motionEventObtain != null) {
            motionEventObtain.recycle();
        }
        return zX;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z() {
        /*
            Method dump skipped, instructions count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.z():void");
    }

    public CoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) throws Resources.NotFoundException {
        Context context2;
        CoordinatorLayout coordinatorLayout;
        super(context, attributeSet, i2);
        this.f2545a = new ArrayList();
        this.f2546b = new DirectedAcyclicGraph();
        this.f2547c = new ArrayList();
        this.f2548d = new int[2];
        this.f2549e = new int[2];
        this.r = new NestedScrollingParentHelper();
        TypedArray typedArrayObtainStyledAttributes = i2 == 0 ? context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, 0, R.style.Widget_Support_CoordinatorLayout) : context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, i2, 0);
        if (i2 == 0) {
            coordinatorLayout = this;
            context2 = context;
            ViewCompat.y(coordinatorLayout, context2, R.styleable.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, 0, R.style.Widget_Support_CoordinatorLayout);
        } else {
            context2 = context;
            coordinatorLayout = this;
            ViewCompat.y(coordinatorLayout, context2, R.styleable.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, i2, 0);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context2.getResources();
            int[] intArray = resources.getIntArray(resourceId);
            coordinatorLayout.f2552h = intArray;
            float f2 = resources.getDisplayMetrics().density;
            int length = intArray.length;
            for (int i3 = 0; i3 < length; i3++) {
                coordinatorLayout.f2552h[i3] = (int) (r13[i3] * f2);
            }
        }
        coordinatorLayout.o = typedArrayObtainStyledAttributes.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
        typedArrayObtainStyledAttributes.recycle();
        D();
        super.setOnHierarchyChangeListener(new HierarchyChangeListener());
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public Behavior f2560a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f2561b;

        /* renamed from: c, reason: collision with root package name */
        public final int f2562c;

        /* renamed from: d, reason: collision with root package name */
        public int f2563d;

        /* renamed from: e, reason: collision with root package name */
        public final int f2564e;

        /* renamed from: f, reason: collision with root package name */
        public final int f2565f;

        /* renamed from: g, reason: collision with root package name */
        public int f2566g;

        /* renamed from: h, reason: collision with root package name */
        public int f2567h;

        /* renamed from: i, reason: collision with root package name */
        public int f2568i;

        /* renamed from: j, reason: collision with root package name */
        public int f2569j;

        /* renamed from: k, reason: collision with root package name */
        public View f2570k;

        /* renamed from: l, reason: collision with root package name */
        public View f2571l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f2572m;
        public boolean n;
        public boolean o;
        public final Rect p;

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.f2561b = false;
            this.f2562c = 0;
            this.f2563d = 0;
            this.f2564e = -1;
            this.f2565f = -1;
            this.f2566g = 0;
            this.f2567h = 0;
            this.p = new Rect();
        }

        public final Behavior a() {
            return this.f2560a;
        }

        public final boolean b(int i2) {
            if (i2 == 0) {
                return this.f2572m;
            }
            if (i2 != 1) {
                return false;
            }
            return this.n;
        }

        public final void c(Behavior behavior) {
            Behavior behavior2 = this.f2560a;
            if (behavior2 != behavior) {
                if (behavior2 != null) {
                    behavior2.l();
                }
                this.f2560a = behavior;
                this.f2561b = true;
                if (behavior != null) {
                    behavior.i(this);
                }
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) throws NoSuchMethodException, SecurityException {
            Behavior behavior;
            super(context, attributeSet);
            this.f2561b = false;
            this.f2562c = 0;
            this.f2563d = 0;
            this.f2564e = -1;
            this.f2565f = -1;
            this.f2566g = 0;
            this.f2567h = 0;
            this.p = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout_Layout);
            this.f2562c = typedArrayObtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f2565f = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f2563d = typedArrayObtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f2564e = typedArrayObtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f2566g = typedArrayObtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f2567h = typedArrayObtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R.styleable.CoordinatorLayout_Layout_layout_behavior);
            this.f2561b = zHasValue;
            if (zHasValue) {
                String string = typedArrayObtainStyledAttributes.getString(R.styleable.CoordinatorLayout_Layout_layout_behavior);
                String str = CoordinatorLayout.s;
                if (TextUtils.isEmpty(string)) {
                    behavior = null;
                } else {
                    if (string.startsWith(CLConstants.DOT_SALT_DELIMETER)) {
                        string = context.getPackageName() + string;
                    } else if (string.indexOf(46) < 0) {
                        String str2 = CoordinatorLayout.s;
                        if (!TextUtils.isEmpty(str2)) {
                            string = str2 + ClassUtils.PACKAGE_SEPARATOR_CHAR + string;
                        }
                    }
                    try {
                        ThreadLocal threadLocal = CoordinatorLayout.u;
                        Map map = (Map) threadLocal.get();
                        if (map == null) {
                            map = new HashMap();
                            threadLocal.set(map);
                        }
                        Constructor<?> constructor = (Constructor) map.get(string);
                        if (constructor == null) {
                            constructor = Class.forName(string, false, context.getClassLoader()).getConstructor(CoordinatorLayout.t);
                            constructor.setAccessible(true);
                            map.put(string, constructor);
                        }
                        behavior = (Behavior) constructor.newInstance(context, attributeSet);
                    } catch (Exception e2) {
                        throw new RuntimeException(b.C("Could not inflate Behavior subclass ", string), e2);
                    }
                }
                this.f2560a = behavior;
            }
            typedArrayObtainStyledAttributes.recycle();
            Behavior behavior2 = this.f2560a;
            if (behavior2 != null) {
                behavior2.i(this);
            }
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f2561b = false;
            this.f2562c = 0;
            this.f2563d = 0;
            this.f2564e = -1;
            this.f2565f = -1;
            this.f2566g = 0;
            this.f2567h = 0;
            this.p = new Rect();
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2561b = false;
            this.f2562c = 0;
            this.f2563d = 0;
            this.f2564e = -1;
            this.f2565f = -1;
            this.f2566g = 0;
            this.f2567h = 0;
            this.p = new Rect();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2561b = false;
            this.f2562c = 0;
            this.f2563d = 0;
            this.f2564e = -1;
            this.f2565f = -1;
            this.f2566g = 0;
            this.f2567h = 0;
            this.p = new Rect();
        }
    }
}
