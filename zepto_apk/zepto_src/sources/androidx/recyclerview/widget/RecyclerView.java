package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.support.v4.media.a;
import android.support.v4.media.b;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.BaseInterpolator;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.TraceCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.customview.poolingcontainer.PoolingContainer;
import androidx.customview.view.AbsSavedState;
import androidx.preference.Preference;
import androidx.recyclerview.widget.AdapterHelper;
import androidx.recyclerview.widget.ChildHelper;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import androidx.recyclerview.widget.ViewBoundsCheck;
import androidx.recyclerview.widget.ViewInfoStore;
import com.google.android.gms.common.api.Api;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.KEYRecord;

/* loaded from: classes3.dex */
public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild2, NestedScrollingChild3 {
    public static boolean l1 = false;
    public static boolean m1 = false;
    public static final int[] n1 = {R.attr.nestedScrollingEnabled};
    public static final float o1 = (float) (Math.log(0.78d) / Math.log(0.9d));
    public static final boolean p1 = true;
    public static final boolean q1 = true;
    public static final boolean r1 = true;
    public static final Class[] s1;
    public static final Interpolator t1;
    public static final StretchEdgeEffectFactory u1;
    public int A;
    public int A0;
    public boolean B;
    public int B0;
    public final AccessibilityManager C;
    public VelocityTracker C0;
    public ArrayList D;
    public int D0;
    public boolean E;
    public int E0;
    public boolean F;
    public int F0;
    public int G;
    public int G0;
    public int H;
    public int H0;
    public EdgeEffectFactory I;
    public OnFlingListener I0;
    public EdgeEffect J;
    public final int J0;
    public EdgeEffect K;
    public final int K0;
    public EdgeEffect L;
    public final float L0;
    public EdgeEffect M;
    public final float M0;
    public boolean N0;
    public final ViewFlinger O0;
    public GapWorker P0;
    public ItemAnimator Q;
    public final GapWorker.LayoutPrefetchRegistryImpl Q0;
    public final State R0;
    public OnScrollListener S0;
    public ArrayList T0;
    public boolean U0;
    public boolean V0;
    public final ItemAnimatorRestoreListener W0;
    public boolean X0;
    public RecyclerViewAccessibilityDelegate Y0;
    public ChildDrawingOrderCallback Z0;

    /* renamed from: a, reason: collision with root package name */
    public final float f11544a;
    public final int[] a1;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerViewDataObserver f11545b;
    public NestedScrollingChildHelper b1;

    /* renamed from: c, reason: collision with root package name */
    public final Recycler f11546c;
    public final int[] c1;

    /* renamed from: d, reason: collision with root package name */
    public SavedState f11547d;
    public final int[] d1;

    /* renamed from: e, reason: collision with root package name */
    public final AdapterHelper f11548e;
    public final int[] e1;

    /* renamed from: f, reason: collision with root package name */
    public final ChildHelper f11549f;
    public final ArrayList f1;

    /* renamed from: g, reason: collision with root package name */
    public final ViewInfoStore f11550g;
    public final Runnable g1;

    /* renamed from: h, reason: collision with root package name */
    public boolean f11551h;
    public boolean h1;

    /* renamed from: i, reason: collision with root package name */
    public final Runnable f11552i;
    public int i1;

    /* renamed from: j, reason: collision with root package name */
    public final Rect f11553j;
    public int j1;

    /* renamed from: k, reason: collision with root package name */
    public final Rect f11554k;
    public final AnonymousClass4 k1;

    /* renamed from: l, reason: collision with root package name */
    public final RectF f11555l;

    /* renamed from: m, reason: collision with root package name */
    public Adapter f11556m;
    public LayoutManager n;
    public RecyclerListener o;
    public final ArrayList p;
    public final ArrayList q;
    public final ArrayList r;
    public OnItemTouchListener s;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* renamed from: androidx.recyclerview.widget.RecyclerView$3, reason: invalid class name */
    public class AnonymousClass3 implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$4, reason: invalid class name */
    public class AnonymousClass4 implements ViewInfoStore.ProcessCallback {
        public AnonymousClass4() {
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$5, reason: invalid class name */
    class AnonymousClass5 implements ChildHelper.Callback {
        public AnonymousClass5() {
        }

        public final void a(View view) {
            ViewHolder viewHolderN = RecyclerView.N(view);
            if (viewHolderN != null) {
                int i2 = viewHolderN.p;
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.S()) {
                    viewHolderN.q = i2;
                    recyclerView.f1.add(viewHolderN);
                } else {
                    WeakHashMap weakHashMap = ViewCompat.f3080a;
                    viewHolderN.f11653a.setImportantForAccessibility(i2);
                }
                viewHolderN.p = 0;
            }
        }

        public final void b(int i2) {
            RecyclerView recyclerView = RecyclerView.this;
            View childAt = recyclerView.getChildAt(i2);
            if (childAt != null) {
                recyclerView.s(childAt);
                childAt.clearAnimation();
            }
            recyclerView.removeViewAt(i2);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$6, reason: invalid class name */
    class AnonymousClass6 implements AdapterHelper.Callback {
        public AnonymousClass6() {
        }

        public final void a(AdapterHelper.UpdateOp updateOp) {
            int i2 = updateOp.f11344a;
            RecyclerView recyclerView = RecyclerView.this;
            if (i2 == 1) {
                recyclerView.n.c0(updateOp.f11345b, updateOp.f11347d);
                return;
            }
            if (i2 == 2) {
                recyclerView.n.f0(updateOp.f11345b, updateOp.f11347d);
            } else if (i2 == 4) {
                recyclerView.n.g0(updateOp.f11345b, updateOp.f11347d);
            } else {
                if (i2 != 8) {
                    return;
                }
                recyclerView.n.e0(updateOp.f11345b, updateOp.f11347d);
            }
        }

        public final ViewHolder b(int i2) {
            RecyclerView recyclerView = RecyclerView.this;
            int childCount = RecyclerView.this.getChildCount();
            int i3 = 0;
            ViewHolder viewHolder = null;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                ViewHolder viewHolderN = RecyclerView.N(RecyclerView.this.getChildAt(i3));
                if (viewHolderN != null && !viewHolderN.h() && viewHolderN.f11655c == i2) {
                    if (!recyclerView.f11549f.f11377c.contains(viewHolderN.f11653a)) {
                        viewHolder = viewHolderN;
                        break;
                    }
                    viewHolder = viewHolderN;
                }
                i3++;
            }
            if (viewHolder != null) {
                if (!recyclerView.f11549f.f11377c.contains(viewHolder.f11653a)) {
                    return viewHolder;
                }
                if (RecyclerView.m1) {
                    Log.d("RecyclerView", "assuming view holder cannot be find because it is hidden");
                }
            }
            return null;
        }

        public final void c(int i2, int i3, Object obj) {
            int i4;
            int i5;
            RecyclerView recyclerView = RecyclerView.this;
            int childCount = RecyclerView.this.getChildCount();
            int i6 = i3 + i2;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = RecyclerView.this.getChildAt(i7);
                ViewHolder viewHolderN = RecyclerView.N(childAt);
                if (viewHolderN != null && !viewHolderN.o() && (i5 = viewHolderN.f11655c) >= i2 && i5 < i6) {
                    viewHolderN.a(2);
                    if (obj == null) {
                        viewHolderN.a(1024);
                    } else if ((1024 & viewHolderN.f11662j) == 0) {
                        if (viewHolderN.f11663k == null) {
                            ArrayList arrayList = new ArrayList();
                            viewHolderN.f11663k = arrayList;
                            viewHolderN.f11664l = Collections.unmodifiableList(arrayList);
                        }
                        viewHolderN.f11663k.add(obj);
                    }
                    ((LayoutParams) childAt.getLayoutParams()).f11598c = true;
                }
            }
            Recycler recycler = recyclerView.f11546c;
            ArrayList arrayList2 = recycler.f11609c;
            for (int size = arrayList2.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = (ViewHolder) arrayList2.get(size);
                if (viewHolder != null && (i4 = viewHolder.f11655c) >= i2 && i4 < i6) {
                    viewHolder.a(2);
                    recycler.g(size);
                }
            }
            recyclerView.V0 = true;
        }

        public final void d(int i2, int i3) {
            RecyclerView recyclerView = RecyclerView.this;
            int childCount = RecyclerView.this.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                ViewHolder viewHolderN = RecyclerView.N(RecyclerView.this.getChildAt(i4));
                if (viewHolderN != null && !viewHolderN.o() && viewHolderN.f11655c >= i2) {
                    if (RecyclerView.m1) {
                        Log.d("RecyclerView", "offsetPositionRecordsForInsert attached child " + i4 + " holder " + viewHolderN + " now at position " + (viewHolderN.f11655c + i3));
                    }
                    viewHolderN.l(i3, false);
                    recyclerView.R0.f11638f = true;
                }
            }
            ArrayList arrayList = recyclerView.f11546c.f11609c;
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                ViewHolder viewHolder = (ViewHolder) arrayList.get(i5);
                if (viewHolder != null && viewHolder.f11655c >= i2) {
                    if (RecyclerView.m1) {
                        Log.d("RecyclerView", "offsetPositionRecordsForInsert cached " + i5 + " holder " + viewHolder + " now at position " + (viewHolder.f11655c + i3));
                    }
                    viewHolder.l(i3, false);
                }
            }
            recyclerView.requestLayout();
            recyclerView.U0 = true;
        }

        public final void e(int i2, int i3) {
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            int i11;
            RecyclerView recyclerView = RecyclerView.this;
            int childCount = RecyclerView.this.getChildCount();
            if (i2 < i3) {
                i5 = i2;
                i4 = i3;
                i6 = -1;
            } else {
                i4 = i2;
                i5 = i3;
                i6 = 1;
            }
            boolean z = false;
            for (int i12 = 0; i12 < childCount; i12++) {
                ViewHolder viewHolderN = RecyclerView.N(RecyclerView.this.getChildAt(i12));
                if (viewHolderN != null && (i11 = viewHolderN.f11655c) >= i5 && i11 <= i4) {
                    if (RecyclerView.m1) {
                        Log.d("RecyclerView", "offsetPositionRecordsForMove attached child " + i12 + " holder " + viewHolderN);
                    }
                    if (viewHolderN.f11655c == i2) {
                        viewHolderN.l(i3 - i2, false);
                    } else {
                        viewHolderN.l(i6, false);
                    }
                    recyclerView.R0.f11638f = true;
                }
            }
            Recycler recycler = recyclerView.f11546c;
            recycler.getClass();
            if (i2 < i3) {
                i8 = i2;
                i7 = i3;
                i9 = -1;
            } else {
                i7 = i2;
                i8 = i3;
                i9 = 1;
            }
            ArrayList arrayList = recycler.f11609c;
            int size = arrayList.size();
            int i13 = 0;
            while (i13 < size) {
                ViewHolder viewHolder = (ViewHolder) arrayList.get(i13);
                if (viewHolder != null && (i10 = viewHolder.f11655c) >= i8 && i10 <= i7) {
                    if (i10 == i2) {
                        viewHolder.l(i3 - i2, z);
                    } else {
                        viewHolder.l(i9, z);
                    }
                    if (RecyclerView.m1) {
                        Log.d("RecyclerView", "offsetPositionRecordsForMove cached child " + i13 + " holder " + viewHolder);
                    }
                }
                i13++;
                z = false;
            }
            recyclerView.requestLayout();
            recyclerView.U0 = true;
        }

        public final void f(int i2, int i3) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.V(i2, i3, true);
            recyclerView.U0 = true;
            recyclerView.R0.f11635c += i3;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$7, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass7 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11562a;

        static {
            int[] iArr = new int[Adapter.StateRestorationPolicy.values().length];
            f11562a = iArr;
            try {
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11562a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        public final boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public final void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).a();
            }
        }

        public final void c(int i2, int i3) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).e(i2, i3);
            }
        }

        public final void d(int i2, int i3, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).c(i2, i3, obj);
            }
        }

        public final void e(int i2, int i3) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).d(i2, i3);
            }
        }

        public final void f(int i2, int i3) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).f(i2, i3);
            }
        }
    }

    public interface ChildDrawingOrderCallback {
        int a(int i2, int i3);
    }

    public static class EdgeEffectFactory {

        @Retention(RetentionPolicy.SOURCE)
        public @interface EdgeDirection {
        }

        public EdgeEffect a(RecyclerView recyclerView) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class ItemAnimator {

        /* renamed from: a, reason: collision with root package name */
        public ItemAnimatorRestoreListener f11568a = null;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f11569b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public final long f11570c = 120;

        /* renamed from: d, reason: collision with root package name */
        public final long f11571d = 120;

        /* renamed from: e, reason: collision with root package name */
        public final long f11572e = 250;

        /* renamed from: f, reason: collision with root package name */
        public final long f11573f = 250;

        @Retention(RetentionPolicy.SOURCE)
        public @interface AdapterChanges {
        }

        public interface ItemAnimatorFinishedListener {
            void a();
        }

        public interface ItemAnimatorListener {
        }

        public static class ItemHolderInfo {

            /* renamed from: a, reason: collision with root package name */
            public int f11574a;

            /* renamed from: b, reason: collision with root package name */
            public int f11575b;
        }

        public static int e(ViewHolder viewHolder) {
            int i2 = viewHolder.f11662j;
            int i3 = i2 & 14;
            if (viewHolder.f()) {
                return 4;
            }
            if ((i2 & 4) == 0) {
                int i4 = viewHolder.f11656d;
                RecyclerView recyclerView = viewHolder.r;
                int iK = recyclerView == null ? -1 : recyclerView.K(viewHolder);
                if (i4 != -1 && iK != -1 && i4 != iK) {
                    return i3 | 2048;
                }
            }
            return i3;
        }

        public abstract boolean a(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract boolean b(ViewHolder viewHolder, ViewHolder viewHolder2, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract boolean c(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract boolean d(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public boolean f(ViewHolder viewHolder) {
            return true;
        }

        public boolean g(ViewHolder viewHolder, List list) {
            return f(viewHolder);
        }

        public final void h(ViewHolder viewHolder) {
            ItemAnimatorRestoreListener itemAnimatorRestoreListener = this.f11568a;
            if (itemAnimatorRestoreListener != null) {
                boolean z = true;
                viewHolder.n(true);
                if (viewHolder.f11660h != null && viewHolder.f11661i == null) {
                    viewHolder.f11660h = null;
                }
                viewHolder.f11661i = null;
                if ((viewHolder.f11662j & 16) != 0) {
                    return;
                }
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.n0();
                ChildHelper childHelper = recyclerView.f11549f;
                AnonymousClass5 anonymousClass5 = childHelper.f11375a;
                RecyclerView recyclerView2 = RecyclerView.this;
                View view = viewHolder.f11653a;
                int iIndexOfChild = recyclerView2.indexOfChild(view);
                if (iIndexOfChild == -1) {
                    childHelper.e(view);
                } else {
                    ChildHelper.Bucket bucket = childHelper.f11376b;
                    if (bucket.d(iIndexOfChild)) {
                        bucket.f(iIndexOfChild);
                        childHelper.e(view);
                        anonymousClass5.b(iIndexOfChild);
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    ViewHolder viewHolderN = RecyclerView.N(view);
                    Recycler recycler = recyclerView.f11546c;
                    recycler.l(viewHolderN);
                    recycler.i(viewHolderN);
                    if (RecyclerView.m1) {
                        Log.d("RecyclerView", "after removing animated view: " + view + ", " + recyclerView);
                    }
                }
                recyclerView.o0(!z);
                if (z || !viewHolder.j()) {
                    return;
                }
                recyclerView.removeDetachedView(view, false);
            }
        }

        public abstract void i(ViewHolder viewHolder);

        public abstract void j();

        public abstract boolean k();

        public abstract void l();
    }

    public class ItemAnimatorRestoreListener implements ItemAnimator.ItemAnimatorListener {
        public ItemAnimatorRestoreListener() {
        }
    }

    public interface OnChildAttachStateChangeListener {
        void b(View view);

        void c(View view);
    }

    public static abstract class OnFlingListener {
        public abstract boolean a(int i2, int i3);
    }

    public interface OnItemTouchListener {
        void a(MotionEvent motionEvent);

        void d(boolean z);

        boolean e(MotionEvent motionEvent);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface Orientation {
    }

    public static class RecycledViewPool {

        /* renamed from: a, reason: collision with root package name */
        public final SparseArray f11600a = new SparseArray();

        /* renamed from: b, reason: collision with root package name */
        public int f11601b = 0;

        /* renamed from: c, reason: collision with root package name */
        public final Set f11602c = Collections.newSetFromMap(new IdentityHashMap());

        public static class ScrapData {

            /* renamed from: a, reason: collision with root package name */
            public final ArrayList f11603a = new ArrayList();

            /* renamed from: b, reason: collision with root package name */
            public final int f11604b = 5;

            /* renamed from: c, reason: collision with root package name */
            public long f11605c = 0;

            /* renamed from: d, reason: collision with root package name */
            public long f11606d = 0;
        }

        public final ScrapData a(int i2) {
            SparseArray sparseArray = this.f11600a;
            ScrapData scrapData = (ScrapData) sparseArray.get(i2);
            if (scrapData != null) {
                return scrapData;
            }
            ScrapData scrapData2 = new ScrapData();
            sparseArray.put(i2, scrapData2);
            return scrapData2;
        }
    }

    public final class Recycler {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f11607a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList f11608b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f11609c;

        /* renamed from: d, reason: collision with root package name */
        public final List f11610d;

        /* renamed from: e, reason: collision with root package name */
        public int f11611e;

        /* renamed from: f, reason: collision with root package name */
        public int f11612f;

        /* renamed from: g, reason: collision with root package name */
        public RecycledViewPool f11613g;

        /* renamed from: h, reason: collision with root package name */
        public ViewCacheExtension f11614h;

        public Recycler() {
            ArrayList arrayList = new ArrayList();
            this.f11607a = arrayList;
            this.f11608b = null;
            this.f11609c = new ArrayList();
            this.f11610d = Collections.unmodifiableList(arrayList);
            this.f11611e = 2;
            this.f11612f = 2;
        }

        public final void a(ViewHolder viewHolder, boolean z) {
            RecyclerView.m(viewHolder);
            RecyclerView recyclerView = RecyclerView.this;
            RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = recyclerView.Y0;
            View view = viewHolder.f11653a;
            if (recyclerViewAccessibilityDelegate != null) {
                AccessibilityDelegateCompat accessibilityDelegateCompatA = recyclerViewAccessibilityDelegate.a();
                ViewCompat.z(view, accessibilityDelegateCompatA instanceof RecyclerViewAccessibilityDelegate.ItemDelegate ? (AccessibilityDelegateCompat) ((RecyclerViewAccessibilityDelegate.ItemDelegate) accessibilityDelegateCompatA).f11669b.remove(view) : null);
            }
            if (z) {
                RecyclerListener recyclerListener = recyclerView.o;
                if (recyclerListener != null) {
                    recyclerListener.a();
                }
                ArrayList arrayList = recyclerView.p;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((RecyclerListener) arrayList.get(i2)).a();
                }
                Adapter adapter = recyclerView.f11556m;
                if (adapter != null) {
                    adapter.u(viewHolder);
                }
                if (recyclerView.R0 != null) {
                    recyclerView.f11550g.d(viewHolder);
                }
                if (RecyclerView.m1) {
                    Log.d("RecyclerView", "dispatchViewRecycled: " + viewHolder);
                }
            }
            viewHolder.s = null;
            viewHolder.r = null;
            RecycledViewPool recycledViewPoolC = c();
            recycledViewPoolC.getClass();
            int i3 = viewHolder.f11658f;
            ArrayList arrayList2 = recycledViewPoolC.a(i3).f11603a;
            if (((RecycledViewPool.ScrapData) recycledViewPoolC.f11600a.get(i3)).f11604b <= arrayList2.size()) {
                PoolingContainer.a(view);
            } else {
                if (RecyclerView.l1 && arrayList2.contains(viewHolder)) {
                    throw new IllegalArgumentException("this scrap item already exists");
                }
                viewHolder.m();
                arrayList2.add(viewHolder);
            }
        }

        public final int b(int i2) {
            RecyclerView recyclerView = RecyclerView.this;
            if (i2 >= 0 && i2 < recyclerView.R0.b()) {
                return !recyclerView.R0.f11639g ? i2 : recyclerView.f11548e.f(i2, 0);
            }
            StringBuilder sbU = b.u(i2, "invalid position ", ". State item count is ");
            sbU.append(recyclerView.R0.b());
            sbU.append(recyclerView.D());
            throw new IndexOutOfBoundsException(sbU.toString());
        }

        public final RecycledViewPool c() {
            if (this.f11613g == null) {
                this.f11613g = new RecycledViewPool();
                d();
            }
            return this.f11613g;
        }

        public final void d() {
            RecyclerView recyclerView;
            Adapter adapter;
            RecycledViewPool recycledViewPool = this.f11613g;
            if (recycledViewPool == null || (adapter = (recyclerView = RecyclerView.this).f11556m) == null || !recyclerView.t) {
                return;
            }
            recycledViewPool.f11602c.add(adapter);
        }

        public final void e(Adapter adapter, boolean z) {
            RecycledViewPool recycledViewPool = this.f11613g;
            if (recycledViewPool == null) {
                return;
            }
            Set set = recycledViewPool.f11602c;
            set.remove(adapter);
            if (set.size() != 0 || z) {
                return;
            }
            int i2 = 0;
            while (true) {
                SparseArray sparseArray = recycledViewPool.f11600a;
                if (i2 >= sparseArray.size()) {
                    return;
                }
                ArrayList arrayList = ((RecycledViewPool.ScrapData) sparseArray.get(sparseArray.keyAt(i2))).f11603a;
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    PoolingContainer.a(((ViewHolder) arrayList.get(i3)).f11653a);
                }
                i2++;
            }
        }

        public final void f() {
            ArrayList arrayList = this.f11609c;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                g(size);
            }
            arrayList.clear();
            if (RecyclerView.r1) {
                GapWorker.LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = RecyclerView.this.Q0;
                int[] iArr = layoutPrefetchRegistryImpl.f11481c;
                if (iArr != null) {
                    Arrays.fill(iArr, -1);
                }
                layoutPrefetchRegistryImpl.f11482d = 0;
            }
        }

        public final void g(int i2) {
            if (RecyclerView.m1) {
                Log.d("RecyclerView", "Recycling cached view at index " + i2);
            }
            ArrayList arrayList = this.f11609c;
            ViewHolder viewHolder = (ViewHolder) arrayList.get(i2);
            if (RecyclerView.m1) {
                Log.d("RecyclerView", "CachedViewHolder to be recycled: " + viewHolder);
            }
            a(viewHolder, true);
            arrayList.remove(i2);
        }

        public final void h(View view) {
            ViewHolder viewHolderN = RecyclerView.N(view);
            boolean zJ = viewHolderN.j();
            RecyclerView recyclerView = RecyclerView.this;
            if (zJ) {
                recyclerView.removeDetachedView(view, false);
            }
            if (viewHolderN.i()) {
                viewHolderN.n.l(viewHolderN);
            } else if (viewHolderN.p()) {
                viewHolderN.f11662j &= -33;
            }
            i(viewHolderN);
            if (recyclerView.Q == null || viewHolderN.g()) {
                return;
            }
            recyclerView.Q.i(viewHolderN);
        }

        /* JADX WARN: Code restructure failed: missing block: B:67:0x00df, code lost:
        
            r5 = r5 - 1;
         */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x00c4  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void i(androidx.recyclerview.widget.RecyclerView.ViewHolder r13) {
            /*
                Method dump skipped, instructions count: 348
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Recycler.i(androidx.recyclerview.widget.RecyclerView$ViewHolder):void");
        }

        public final void j(View view) {
            ItemAnimator itemAnimator;
            ViewHolder viewHolderN = RecyclerView.N(view);
            boolean z = (viewHolderN.f11662j & 12) != 0;
            RecyclerView recyclerView = RecyclerView.this;
            if (!z && viewHolderN.k() && (itemAnimator = recyclerView.Q) != null && !itemAnimator.g(viewHolderN, viewHolderN.c())) {
                if (this.f11608b == null) {
                    this.f11608b = new ArrayList();
                }
                viewHolderN.n = this;
                viewHolderN.o = true;
                this.f11608b.add(viewHolderN);
                return;
            }
            if (viewHolderN.f() && !viewHolderN.h() && !recyclerView.f11556m.f11564b) {
                throw new IllegalArgumentException(a.m(recyclerView, new StringBuilder("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
            }
            viewHolderN.n = this;
            viewHolderN.o = false;
            this.f11607a.add(viewHolderN);
        }

        /* JADX WARN: Removed duplicated region for block: B:103:0x01b9  */
        /* JADX WARN: Removed duplicated region for block: B:142:0x027d  */
        /* JADX WARN: Removed duplicated region for block: B:228:0x042b  */
        /* JADX WARN: Removed duplicated region for block: B:230:0x042e  */
        /* JADX WARN: Removed duplicated region for block: B:313:0x059d  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:384:0x06db  */
        /* JADX WARN: Removed duplicated region for block: B:385:0x06e5  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:391:0x06fb A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:78:0x0129  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0132  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final androidx.recyclerview.widget.RecyclerView.ViewHolder k(int r31, long r32) {
            /*
                Method dump skipped, instructions count: 1827
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Recycler.k(int, long):androidx.recyclerview.widget.RecyclerView$ViewHolder");
        }

        public final void l(ViewHolder viewHolder) {
            if (viewHolder.o) {
                this.f11608b.remove(viewHolder);
            } else {
                this.f11607a.remove(viewHolder);
            }
            viewHolder.n = null;
            viewHolder.o = false;
            viewHolder.f11662j &= -33;
        }

        public final void m() {
            LayoutManager layoutManager = RecyclerView.this.n;
            this.f11612f = this.f11611e + (layoutManager != null ? layoutManager.f11586j : 0);
            ArrayList arrayList = this.f11609c;
            for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.f11612f; size--) {
                g(size);
            }
        }
    }

    public interface RecyclerListener {
        void a();
    }

    public class RecyclerViewDataObserver extends AdapterDataObserver {
        public RecyclerViewDataObserver() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void a() {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.l(null);
            recyclerView.R0.f11638f = true;
            recyclerView.b0(true);
            if (recyclerView.f11548e.g()) {
                return;
            }
            recyclerView.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void c(int i2, int i3, Object obj) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.l(null);
            AdapterHelper adapterHelper = recyclerView.f11548e;
            if (i3 < 1) {
                adapterHelper.getClass();
                return;
            }
            ArrayList arrayList = adapterHelper.f11339b;
            arrayList.add(adapterHelper.h(obj, 4, i2, i3));
            adapterHelper.f11343f |= 4;
            if (arrayList.size() == 1) {
                g();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void d(int i2, int i3) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.l(null);
            AdapterHelper adapterHelper = recyclerView.f11548e;
            if (i3 < 1) {
                adapterHelper.getClass();
                return;
            }
            ArrayList arrayList = adapterHelper.f11339b;
            arrayList.add(adapterHelper.h(null, 1, i2, i3));
            adapterHelper.f11343f |= 1;
            if (arrayList.size() == 1) {
                g();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void e(int i2, int i3) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.l(null);
            AdapterHelper adapterHelper = recyclerView.f11548e;
            adapterHelper.getClass();
            if (i2 == i3) {
                return;
            }
            ArrayList arrayList = adapterHelper.f11339b;
            arrayList.add(adapterHelper.h(null, 8, i2, i3));
            adapterHelper.f11343f |= 8;
            if (arrayList.size() == 1) {
                g();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void f(int i2, int i3) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.l(null);
            AdapterHelper adapterHelper = recyclerView.f11548e;
            if (i3 < 1) {
                adapterHelper.getClass();
                return;
            }
            ArrayList arrayList = adapterHelper.f11339b;
            arrayList.add(adapterHelper.h(null, 2, i2, i3));
            adapterHelper.f11343f |= 2;
            if (arrayList.size() == 1) {
                g();
            }
        }

        public final void g() {
            boolean z = RecyclerView.q1;
            RecyclerView recyclerView = RecyclerView.this;
            if (!z || !recyclerView.u || !recyclerView.t) {
                recyclerView.B = true;
                recyclerView.requestLayout();
            } else {
                Runnable runnable = recyclerView.f11552i;
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                recyclerView.postOnAnimation(runnable);
            }
        }
    }

    @RestrictTo
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: c, reason: collision with root package name */
        public Parcelable f11617c;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$SavedState$1, reason: invalid class name */
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
            this.f11617c = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeParcelable(this.f11617c, 0);
        }
    }

    public static abstract class SmoothScroller {

        /* renamed from: a, reason: collision with root package name */
        public int f11618a = -1;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView f11619b;

        /* renamed from: c, reason: collision with root package name */
        public LayoutManager f11620c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f11621d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f11622e;

        /* renamed from: f, reason: collision with root package name */
        public View f11623f;

        /* renamed from: g, reason: collision with root package name */
        public final Action f11624g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f11625h;

        public static class Action {

            /* renamed from: a, reason: collision with root package name */
            public int f11626a;

            /* renamed from: b, reason: collision with root package name */
            public int f11627b;

            /* renamed from: c, reason: collision with root package name */
            public int f11628c;

            /* renamed from: d, reason: collision with root package name */
            public int f11629d;

            /* renamed from: e, reason: collision with root package name */
            public BaseInterpolator f11630e;

            /* renamed from: f, reason: collision with root package name */
            public boolean f11631f;

            /* renamed from: g, reason: collision with root package name */
            public int f11632g;

            public final void a(RecyclerView recyclerView) {
                int i2 = this.f11629d;
                if (i2 >= 0) {
                    this.f11629d = -1;
                    recyclerView.T(i2);
                    this.f11631f = false;
                    return;
                }
                if (!this.f11631f) {
                    this.f11632g = 0;
                    return;
                }
                BaseInterpolator baseInterpolator = this.f11630e;
                if (baseInterpolator != null && this.f11628c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                int i3 = this.f11628c;
                if (i3 < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
                recyclerView.O0.c(this.f11626a, this.f11627b, i3, baseInterpolator);
                int i4 = this.f11632g + 1;
                this.f11632g = i4;
                if (i4 > 10) {
                    Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                }
                this.f11631f = false;
            }
        }

        public interface ScrollVectorProvider {
            PointF a(int i2);
        }

        public SmoothScroller() {
            Action action = new Action();
            action.f11629d = -1;
            action.f11631f = false;
            action.f11632g = 0;
            action.f11626a = 0;
            action.f11627b = 0;
            action.f11628c = Integer.MIN_VALUE;
            action.f11630e = null;
            this.f11624g = action;
        }

        public PointF a(int i2) {
            Object obj = this.f11620c;
            if (obj instanceof ScrollVectorProvider) {
                return ((ScrollVectorProvider) obj).a(i2);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + ScrollVectorProvider.class.getCanonicalName());
            return null;
        }

        public final void b(int i2, int i3) {
            PointF pointFA;
            RecyclerView recyclerView = this.f11619b;
            if (this.f11618a == -1 || recyclerView == null) {
                f();
            }
            if (this.f11621d && this.f11623f == null && this.f11620c != null && (pointFA = a(this.f11618a)) != null) {
                float f2 = pointFA.x;
                if (f2 != 0.0f || pointFA.y != 0.0f) {
                    recyclerView.i0((int) Math.signum(f2), (int) Math.signum(pointFA.y), null);
                }
            }
            this.f11621d = false;
            View view = this.f11623f;
            Action action = this.f11624g;
            if (view != null) {
                this.f11619b.getClass();
                ViewHolder viewHolderN = RecyclerView.N(view);
                if ((viewHolderN != null ? viewHolderN.b() : -1) == this.f11618a) {
                    View view2 = this.f11623f;
                    State state = recyclerView.R0;
                    e(view2, action);
                    action.a(recyclerView);
                    f();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f11623f = null;
                }
            }
            if (this.f11622e) {
                State state2 = recyclerView.R0;
                c(i2, i3, action);
                boolean z = action.f11629d >= 0;
                action.a(recyclerView);
                if (z && this.f11622e) {
                    this.f11621d = true;
                    recyclerView.O0.b();
                }
            }
        }

        public abstract void c(int i2, int i3, Action action);

        public abstract void d();

        public abstract void e(View view, Action action);

        public final void f() {
            if (this.f11622e) {
                this.f11622e = false;
                d();
                this.f11619b.R0.f11633a = -1;
                this.f11623f = null;
                this.f11618a = -1;
                this.f11621d = false;
                LayoutManager layoutManager = this.f11620c;
                if (layoutManager.f11581e == this) {
                    layoutManager.f11581e = null;
                }
                this.f11620c = null;
                this.f11619b = null;
            }
        }
    }

    public static class State {

        /* renamed from: a, reason: collision with root package name */
        public int f11633a = -1;

        /* renamed from: b, reason: collision with root package name */
        public int f11634b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f11635c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f11636d = 1;

        /* renamed from: e, reason: collision with root package name */
        public int f11637e = 0;

        /* renamed from: f, reason: collision with root package name */
        public boolean f11638f = false;

        /* renamed from: g, reason: collision with root package name */
        public boolean f11639g = false;

        /* renamed from: h, reason: collision with root package name */
        public boolean f11640h = false;

        /* renamed from: i, reason: collision with root package name */
        public boolean f11641i = false;

        /* renamed from: j, reason: collision with root package name */
        public boolean f11642j = false;

        /* renamed from: k, reason: collision with root package name */
        public boolean f11643k = false;

        /* renamed from: l, reason: collision with root package name */
        public int f11644l;

        /* renamed from: m, reason: collision with root package name */
        public long f11645m;
        public int n;

        public final void a(int i2) {
            if ((this.f11636d & i2) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i2) + " but it is " + Integer.toBinaryString(this.f11636d));
        }

        public final int b() {
            return this.f11639g ? this.f11634b - this.f11635c : this.f11637e;
        }

        public final String toString() {
            return "State{mTargetPosition=" + this.f11633a + ", mData=null, mItemCount=" + this.f11637e + ", mIsMeasuring=" + this.f11641i + ", mPreviousLayoutItemCount=" + this.f11634b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f11635c + ", mStructureChanged=" + this.f11638f + ", mInPreLayout=" + this.f11639g + ", mRunSimpleAnimations=" + this.f11642j + ", mRunPredictiveAnimations=" + this.f11643k + '}';
        }
    }

    public static class StretchEdgeEffectFactory extends EdgeEffectFactory {
        @Override // androidx.recyclerview.widget.RecyclerView.EdgeEffectFactory
        public final EdgeEffect a(RecyclerView recyclerView) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class ViewCacheExtension {
        public abstract View a();
    }

    public class ViewFlinger implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public int f11646a;

        /* renamed from: b, reason: collision with root package name */
        public int f11647b;

        /* renamed from: c, reason: collision with root package name */
        public OverScroller f11648c;

        /* renamed from: d, reason: collision with root package name */
        public Interpolator f11649d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f11650e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f11651f;

        public ViewFlinger() {
            Interpolator interpolator = RecyclerView.t1;
            this.f11649d = interpolator;
            this.f11650e = false;
            this.f11651f = false;
            this.f11648c = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        public final void a(int i2, int i3) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.setScrollState(2);
            this.f11647b = 0;
            this.f11646a = 0;
            Interpolator interpolator = this.f11649d;
            Interpolator interpolator2 = RecyclerView.t1;
            if (interpolator != interpolator2) {
                this.f11649d = interpolator2;
                this.f11648c = new OverScroller(recyclerView.getContext(), interpolator2);
            }
            this.f11648c.fling(0, 0, i2, i3, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER);
            b();
        }

        public final void b() {
            if (this.f11650e) {
                this.f11651f = true;
                return;
            }
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.removeCallbacks(this);
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            recyclerView.postOnAnimation(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v2, types: [android.view.animation.Interpolator] */
        public final void c(int i2, int i3, int i4, BaseInterpolator baseInterpolator) {
            RecyclerView recyclerView = RecyclerView.this;
            if (i4 == Integer.MIN_VALUE) {
                int iAbs = Math.abs(i2);
                int iAbs2 = Math.abs(i3);
                boolean z = iAbs > iAbs2;
                int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
                if (!z) {
                    iAbs = iAbs2;
                }
                i4 = Math.min((int) (((iAbs / width) + 1.0f) * 300.0f), 2000);
            }
            int i5 = i4;
            BaseInterpolator baseInterpolator2 = baseInterpolator;
            if (baseInterpolator == null) {
                baseInterpolator2 = RecyclerView.t1;
            }
            if (this.f11649d != baseInterpolator2) {
                this.f11649d = baseInterpolator2;
                this.f11648c = new OverScroller(recyclerView.getContext(), baseInterpolator2);
            }
            this.f11647b = 0;
            this.f11646a = 0;
            recyclerView.setScrollState(2);
            this.f11648c.startScroll(0, 0, i2, i3, i5);
            b();
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i2;
            int i3;
            int i4;
            int i5;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.n == null) {
                recyclerView.removeCallbacks(this);
                this.f11648c.abortAnimation();
                return;
            }
            this.f11651f = false;
            this.f11650e = true;
            recyclerView.q();
            OverScroller overScroller = this.f11648c;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i6 = currX - this.f11646a;
                int i7 = currY - this.f11647b;
                this.f11646a = currX;
                this.f11647b = currY;
                int iP = RecyclerView.p(i6, recyclerView.J, recyclerView.L, recyclerView.getWidth());
                int iP2 = RecyclerView.p(i7, recyclerView.K, recyclerView.M, recyclerView.getHeight());
                int[] iArr = recyclerView.e1;
                iArr[0] = 0;
                iArr[1] = 0;
                boolean zW = recyclerView.w(iP, iP2, 1, iArr, null);
                int[] iArr2 = recyclerView.e1;
                if (zW) {
                    iP -= iArr2[0];
                    iP2 -= iArr2[1];
                }
                if (recyclerView.getOverScrollMode() != 2) {
                    recyclerView.o(iP, iP2);
                }
                if (recyclerView.f11556m != null) {
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    recyclerView.i0(iP, iP2, iArr2);
                    int i8 = iArr2[0];
                    int i9 = iArr2[1];
                    int i10 = iP - i8;
                    int i11 = iP2 - i9;
                    SmoothScroller smoothScroller = recyclerView.n.f11581e;
                    if (smoothScroller != null && !smoothScroller.f11621d && smoothScroller.f11622e) {
                        int iB = recyclerView.R0.b();
                        if (iB == 0) {
                            smoothScroller.f();
                        } else if (smoothScroller.f11618a >= iB) {
                            smoothScroller.f11618a = iB - 1;
                            smoothScroller.b(i8, i9);
                        } else {
                            smoothScroller.b(i8, i9);
                        }
                    }
                    i2 = i10;
                    i4 = i8;
                    i3 = i11;
                    i5 = i9;
                } else {
                    i2 = iP;
                    i3 = iP2;
                    i4 = 0;
                    i5 = 0;
                }
                if (!recyclerView.q.isEmpty()) {
                    recyclerView.invalidate();
                }
                int[] iArr3 = recyclerView.e1;
                iArr3[0] = 0;
                iArr3[1] = 0;
                recyclerView.x(i4, i5, i2, i3, null, 1, iArr3);
                int i12 = i2 - iArr2[0];
                int i13 = i3 - iArr2[1];
                if (i4 != 0 || i5 != 0) {
                    recyclerView.y(i4, i5);
                }
                if (!recyclerView.awakenScrollBars()) {
                    recyclerView.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i12 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i13 != 0));
                SmoothScroller smoothScroller2 = recyclerView.n.f11581e;
                if ((smoothScroller2 == null || !smoothScroller2.f11621d) && z) {
                    if (recyclerView.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i14 = i12 < 0 ? -currVelocity : i12 > 0 ? currVelocity : 0;
                        if (i13 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i13 <= 0) {
                            currVelocity = 0;
                        }
                        if (i14 < 0) {
                            recyclerView.A();
                            if (recyclerView.J.isFinished()) {
                                recyclerView.J.onAbsorb(-i14);
                            }
                        } else if (i14 > 0) {
                            recyclerView.B();
                            if (recyclerView.L.isFinished()) {
                                recyclerView.L.onAbsorb(i14);
                            }
                        }
                        if (currVelocity < 0) {
                            recyclerView.C();
                            if (recyclerView.K.isFinished()) {
                                recyclerView.K.onAbsorb(-currVelocity);
                            }
                        } else if (currVelocity > 0) {
                            recyclerView.z();
                            if (recyclerView.M.isFinished()) {
                                recyclerView.M.onAbsorb(currVelocity);
                            }
                        }
                        if (i14 != 0 || currVelocity != 0) {
                            WeakHashMap weakHashMap = ViewCompat.f3080a;
                            recyclerView.postInvalidateOnAnimation();
                        }
                    }
                    if (RecyclerView.r1) {
                        GapWorker.LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.Q0;
                        int[] iArr4 = layoutPrefetchRegistryImpl.f11481c;
                        if (iArr4 != null) {
                            Arrays.fill(iArr4, -1);
                        }
                        layoutPrefetchRegistryImpl.f11482d = 0;
                    }
                } else {
                    b();
                    GapWorker gapWorker = recyclerView.P0;
                    if (gapWorker != null) {
                        gapWorker.a(recyclerView, i4, i5);
                    }
                }
            }
            SmoothScroller smoothScroller3 = recyclerView.n.f11581e;
            if (smoothScroller3 != null && smoothScroller3.f11621d) {
                smoothScroller3.b(0, 0);
            }
            this.f11650e = false;
            if (!this.f11651f) {
                recyclerView.setScrollState(0);
                recyclerView.p0(1);
            } else {
                recyclerView.removeCallbacks(this);
                WeakHashMap weakHashMap2 = ViewCompat.f3080a;
                recyclerView.postOnAnimation(this);
            }
        }
    }

    public static abstract class ViewHolder {
        public static final List t = Collections.EMPTY_LIST;

        /* renamed from: a, reason: collision with root package name */
        public final View f11653a;

        /* renamed from: b, reason: collision with root package name */
        public WeakReference f11654b;

        /* renamed from: j, reason: collision with root package name */
        public int f11662j;
        public RecyclerView r;
        public Adapter s;

        /* renamed from: c, reason: collision with root package name */
        public int f11655c = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f11656d = -1;

        /* renamed from: e, reason: collision with root package name */
        public long f11657e = -1;

        /* renamed from: f, reason: collision with root package name */
        public int f11658f = -1;

        /* renamed from: g, reason: collision with root package name */
        public int f11659g = -1;

        /* renamed from: h, reason: collision with root package name */
        public ViewHolder f11660h = null;

        /* renamed from: i, reason: collision with root package name */
        public ViewHolder f11661i = null;

        /* renamed from: k, reason: collision with root package name */
        public ArrayList f11663k = null;

        /* renamed from: l, reason: collision with root package name */
        public List f11664l = null;

        /* renamed from: m, reason: collision with root package name */
        public int f11665m = 0;
        public Recycler n = null;
        public boolean o = false;
        public int p = 0;
        public int q = -1;

        public ViewHolder(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f11653a = view;
        }

        public final void a(int i2) {
            this.f11662j = i2 | this.f11662j;
        }

        public final int b() {
            int i2 = this.f11659g;
            return i2 == -1 ? this.f11655c : i2;
        }

        public final List c() {
            ArrayList arrayList;
            return ((this.f11662j & 1024) != 0 || (arrayList = this.f11663k) == null || arrayList.size() == 0) ? t : this.f11664l;
        }

        public final boolean d() {
            View view = this.f11653a;
            return (view.getParent() == null || view.getParent() == this.r) ? false : true;
        }

        public final boolean e() {
            return (this.f11662j & 1) != 0;
        }

        public final boolean f() {
            return (this.f11662j & 4) != 0;
        }

        public final boolean g() {
            if ((this.f11662j & 16) != 0) {
                return false;
            }
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            return !this.f11653a.hasTransientState();
        }

        public final boolean h() {
            return (this.f11662j & 8) != 0;
        }

        public final boolean i() {
            return this.n != null;
        }

        public final boolean j() {
            return (this.f11662j & 256) != 0;
        }

        public final boolean k() {
            return (this.f11662j & 2) != 0;
        }

        public final void l(int i2, boolean z) {
            if (this.f11656d == -1) {
                this.f11656d = this.f11655c;
            }
            if (this.f11659g == -1) {
                this.f11659g = this.f11655c;
            }
            if (z) {
                this.f11659g += i2;
            }
            this.f11655c += i2;
            View view = this.f11653a;
            if (view.getLayoutParams() != null) {
                ((LayoutParams) view.getLayoutParams()).f11598c = true;
            }
        }

        public final void m() {
            if (RecyclerView.l1 && j()) {
                throw new IllegalStateException("Attempting to reset temp-detached ViewHolder: " + this + ". ViewHolders should be fully detached before resetting.");
            }
            this.f11662j = 0;
            this.f11655c = -1;
            this.f11656d = -1;
            this.f11657e = -1L;
            this.f11659g = -1;
            this.f11665m = 0;
            this.f11660h = null;
            this.f11661i = null;
            ArrayList arrayList = this.f11663k;
            if (arrayList != null) {
                arrayList.clear();
            }
            this.f11662j &= -1025;
            this.p = 0;
            this.q = -1;
            RecyclerView.m(this);
        }

        public final void n(boolean z) {
            int i2 = this.f11665m;
            int i3 = z ? i2 - 1 : i2 + 1;
            this.f11665m = i3;
            if (i3 < 0) {
                this.f11665m = 0;
                if (RecyclerView.l1) {
                    throw new RuntimeException("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                }
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && i3 == 1) {
                this.f11662j |= 16;
            } else if (z && i3 == 0) {
                this.f11662j &= -17;
            }
            if (RecyclerView.m1) {
                Log.d("RecyclerView", "setIsRecyclable val:" + z + ":" + this);
            }
        }

        public final boolean o() {
            return (this.f11662j & 128) != 0;
        }

        public final boolean p() {
            return (this.f11662j & 32) != 0;
        }

        public final String toString() {
            StringBuilder sbX = b.x(getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName(), "{");
            sbX.append(Integer.toHexString(hashCode()));
            sbX.append(" position=");
            sbX.append(this.f11655c);
            sbX.append(" id=");
            sbX.append(this.f11657e);
            sbX.append(", oldPos=");
            sbX.append(this.f11656d);
            sbX.append(", pLpos:");
            sbX.append(this.f11659g);
            StringBuilder sb = new StringBuilder(sbX.toString());
            if (i()) {
                sb.append(" scrap ");
                sb.append(this.o ? "[changeScrap]" : "[attachedScrap]");
            }
            if (f()) {
                sb.append(" invalid");
            }
            if (!e()) {
                sb.append(" unbound");
            }
            if ((this.f11662j & 2) != 0) {
                sb.append(" update");
            }
            if (h()) {
                sb.append(" removed");
            }
            if (o()) {
                sb.append(" ignored");
            }
            if (j()) {
                sb.append(" tmpDetached");
            }
            if (!g()) {
                sb.append(" not recyclable(" + this.f11665m + ")");
            }
            if ((this.f11662j & 512) != 0 || f()) {
                sb.append(" undefined adapter position");
            }
            if (this.f11653a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    static {
        Class cls = Integer.TYPE;
        s1 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        t1 = new AnonymousClass3();
        u1 = new StretchEdgeEffectFactory();
    }

    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, androidx.recyclerview.R.attr.recyclerViewStyle);
    }

    public static RecyclerView I(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView recyclerViewI = I(viewGroup.getChildAt(i2));
            if (recyclerViewI != null) {
                return recyclerViewI;
            }
        }
        return null;
    }

    public static ViewHolder N(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f11596a;
    }

    public static void O(Rect rect, View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.f11597b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.b1 == null) {
            this.b1 = new NestedScrollingChildHelper(this);
        }
        return this.b1;
    }

    public static void m(ViewHolder viewHolder) {
        WeakReference weakReference = viewHolder.f11654b;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view == viewHolder.f11653a) {
                    return;
                }
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            viewHolder.f11654b = null;
        }
    }

    public static int p(int i2, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i3) {
        if (i2 > 0 && edgeEffect != null && EdgeEffectCompat.a(edgeEffect) != 0.0f) {
            int iRound = Math.round(EdgeEffectCompat.b(edgeEffect, ((-i2) * 4.0f) / i3, 0.5f) * ((-i3) / 4.0f));
            if (iRound != i2) {
                edgeEffect.finish();
            }
            return i2 - iRound;
        }
        if (i2 >= 0 || edgeEffect2 == null || EdgeEffectCompat.a(edgeEffect2) == 0.0f) {
            return i2;
        }
        float f2 = i3;
        int iRound2 = Math.round(EdgeEffectCompat.b(edgeEffect2, (i2 * 4.0f) / f2, 0.5f) * (f2 / 4.0f));
        if (iRound2 != i2) {
            edgeEffect2.finish();
        }
        return i2 - iRound2;
    }

    public static void setDebugAssertionsEnabled(boolean z) {
        l1 = z;
    }

    public static void setVerboseLoggingEnabled(boolean z) {
        m1 = z;
    }

    public final void A() {
        if (this.J != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.I.a(this);
        this.J = edgeEffectA;
        if (this.f11551h) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void B() {
        if (this.L != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.I.a(this);
        this.L = edgeEffectA;
        if (this.f11551h) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void C() {
        if (this.K != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.I.a(this);
        this.K = edgeEffectA;
        if (this.f11551h) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final String D() {
        return StringUtils.SPACE + super.toString() + ", adapter:" + this.f11556m + ", layout:" + this.n + ", context:" + getContext();
    }

    public final void E(State state) {
        if (getScrollState() != 2) {
            state.getClass();
            return;
        }
        OverScroller overScroller = this.O0.f11648c;
        overScroller.getFinalX();
        overScroller.getCurrX();
        state.getClass();
        overScroller.getFinalY();
        overScroller.getCurrY();
    }

    public final View F(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public final boolean G(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        ArrayList arrayList = this.r;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            OnItemTouchListener onItemTouchListener = (OnItemTouchListener) arrayList.get(i2);
            if (onItemTouchListener.e(motionEvent) && action != 3) {
                this.s = onItemTouchListener;
                return true;
            }
        }
        return false;
    }

    public final void H(int[] iArr) {
        int iC = this.f11549f.c();
        if (iC == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < iC; i4++) {
            ViewHolder viewHolderN = N(this.f11549f.b(i4));
            if (!viewHolderN.o()) {
                int iB = viewHolderN.b();
                if (iB < i2) {
                    i2 = iB;
                }
                if (iB > i3) {
                    i3 = iB;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    public final ViewHolder J(int i2) {
        ViewHolder viewHolder = null;
        if (this.E) {
            return null;
        }
        int childCount = RecyclerView.this.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            ViewHolder viewHolderN = N(RecyclerView.this.getChildAt(i3));
            if (viewHolderN != null && !viewHolderN.h() && K(viewHolderN) == i2) {
                if (!this.f11549f.f11377c.contains(viewHolderN.f11653a)) {
                    return viewHolderN;
                }
                viewHolder = viewHolderN;
            }
        }
        return viewHolder;
    }

    public final int K(ViewHolder viewHolder) {
        if (((viewHolder.f11662j & 524) != 0) || !viewHolder.e()) {
            return -1;
        }
        AdapterHelper adapterHelper = this.f11548e;
        int i2 = viewHolder.f11655c;
        ArrayList arrayList = adapterHelper.f11339b;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            AdapterHelper.UpdateOp updateOp = (AdapterHelper.UpdateOp) arrayList.get(i3);
            int i4 = updateOp.f11344a;
            if (i4 != 1) {
                if (i4 == 2) {
                    int i5 = updateOp.f11345b;
                    if (i5 <= i2) {
                        int i6 = updateOp.f11347d;
                        if (i5 + i6 > i2) {
                            return -1;
                        }
                        i2 -= i6;
                    } else {
                        continue;
                    }
                } else if (i4 == 8) {
                    int i7 = updateOp.f11345b;
                    if (i7 == i2) {
                        i2 = updateOp.f11347d;
                    } else {
                        if (i7 < i2) {
                            i2--;
                        }
                        if (updateOp.f11347d <= i2) {
                            i2++;
                        }
                    }
                }
            } else if (updateOp.f11345b <= i2) {
                i2 += updateOp.f11347d;
            }
        }
        return i2;
    }

    public final long L(ViewHolder viewHolder) {
        return this.f11556m.f11564b ? viewHolder.f11657e : viewHolder.f11655c;
    }

    public final ViewHolder M(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return N(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public final Rect P(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        boolean z = layoutParams.f11598c;
        Rect rect = layoutParams.f11597b;
        if (!z || (this.R0.f11639g && (layoutParams.f11596a.k() || layoutParams.f11596a.f()))) {
            return rect;
        }
        rect.set(0, 0, 0, 0);
        ArrayList arrayList = this.q;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Rect rect2 = this.f11553j;
            rect2.set(0, 0, 0, 0);
            ((ItemDecoration) arrayList.get(i2)).f(rect2, view, this);
            rect.left += rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.f11598c = false;
        return rect;
    }

    public final boolean Q() {
        return !this.v || this.E || this.f11548e.g();
    }

    public final void R() {
        if (this.q.size() == 0) {
            return;
        }
        LayoutManager layoutManager = this.n;
        if (layoutManager != null) {
            layoutManager.c("Cannot invalidate item decorations during a scroll or layout");
        }
        U();
        requestLayout();
    }

    public final boolean S() {
        return this.G > 0;
    }

    public final void T(int i2) {
        if (this.n == null) {
            return;
        }
        setScrollState(2);
        this.n.u0(i2);
        awakenScrollBars();
    }

    public final void U() {
        int childCount = RecyclerView.this.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ((LayoutParams) RecyclerView.this.getChildAt(i2).getLayoutParams()).f11598c = true;
        }
        ArrayList arrayList = this.f11546c.f11609c;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            LayoutParams layoutParams = (LayoutParams) ((ViewHolder) arrayList.get(i3)).f11653a.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.f11598c = true;
            }
        }
    }

    public final void V(int i2, int i3, boolean z) {
        int i4 = i2 + i3;
        int childCount = RecyclerView.this.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            ViewHolder viewHolderN = N(RecyclerView.this.getChildAt(i5));
            if (viewHolderN != null && !viewHolderN.o()) {
                int i6 = viewHolderN.f11655c;
                State state = this.R0;
                if (i6 >= i4) {
                    if (m1) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + i5 + " holder " + viewHolderN + " now at position " + (viewHolderN.f11655c - i3));
                    }
                    viewHolderN.l(-i3, z);
                    state.f11638f = true;
                } else if (i6 >= i2) {
                    if (m1) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + i5 + " holder " + viewHolderN + " now REMOVED");
                    }
                    viewHolderN.a(8);
                    viewHolderN.l(-i3, z);
                    viewHolderN.f11655c = i2 - 1;
                    state.f11638f = true;
                }
            }
        }
        Recycler recycler = this.f11546c;
        ArrayList arrayList = recycler.f11609c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = (ViewHolder) arrayList.get(size);
            if (viewHolder != null) {
                int i7 = viewHolder.f11655c;
                if (i7 >= i4) {
                    if (m1) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove cached " + size + " holder " + viewHolder + " now at position " + (viewHolder.f11655c - i3));
                    }
                    viewHolder.l(-i3, z);
                } else if (i7 >= i2) {
                    viewHolder.a(8);
                    recycler.g(size);
                }
            }
        }
        requestLayout();
    }

    public final void W() {
        this.G++;
    }

    public final void X(boolean z) {
        int i2;
        AccessibilityManager accessibilityManager;
        int i3 = this.G - 1;
        this.G = i3;
        if (i3 < 1) {
            if (l1 && i3 < 0) {
                throw new IllegalStateException(a.m(this, new StringBuilder("layout or scroll counter cannot go below zero.Some calls are not matching")));
            }
            this.G = 0;
            if (z) {
                int i4 = this.A;
                this.A = 0;
                if (i4 != 0 && (accessibilityManager = this.C) != null && accessibilityManager.isEnabled()) {
                    AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                    accessibilityEventObtain.setEventType(2048);
                    accessibilityEventObtain.setContentChangeTypes(i4);
                    sendAccessibilityEventUnchecked(accessibilityEventObtain);
                }
                ArrayList arrayList = this.f1;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ViewHolder viewHolder = (ViewHolder) arrayList.get(size);
                    if (viewHolder.f11653a.getParent() == this && !viewHolder.o() && (i2 = viewHolder.q) != -1) {
                        WeakHashMap weakHashMap = ViewCompat.f3080a;
                        viewHolder.f11653a.setImportantForAccessibility(i2);
                        viewHolder.q = -1;
                    }
                }
                arrayList.clear();
            }
        }
    }

    public final void Y(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.B0) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.B0 = motionEvent.getPointerId(i2);
            int x = (int) (motionEvent.getX(i2) + 0.5f);
            this.F0 = x;
            this.D0 = x;
            int y = (int) (motionEvent.getY(i2) + 0.5f);
            this.G0 = y;
            this.E0 = y;
        }
    }

    public final void Z() {
        if (this.X0 || !this.t) {
            return;
        }
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        postOnAnimation(this.g1);
        this.X0 = true;
    }

    public final void a0() {
        boolean z;
        boolean z2 = false;
        if (this.E) {
            AdapterHelper adapterHelper = this.f11548e;
            adapterHelper.k(adapterHelper.f11339b);
            adapterHelper.k(adapterHelper.f11340c);
            adapterHelper.f11343f = 0;
            if (this.F) {
                this.n.d0();
            }
        }
        if (this.Q == null || !this.n.G0()) {
            this.f11548e.c();
        } else {
            this.f11548e.j();
        }
        boolean z3 = this.U0 || this.V0;
        boolean z4 = this.v && this.Q != null && ((z = this.E) || z3 || this.n.f11582f) && (!z || this.f11556m.f11564b);
        State state = this.R0;
        state.f11642j = z4;
        if (z4 && z3 && !this.E && this.Q != null && this.n.G0()) {
            z2 = true;
        }
        state.f11643k = z2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i2, int i3) {
        LayoutManager layoutManager = this.n;
        if (layoutManager != null) {
            layoutManager.getClass();
        }
        super.addFocusables(arrayList, i2, i3);
    }

    public final void b0(boolean z) {
        this.F = z | this.F;
        this.E = true;
        int childCount = RecyclerView.this.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ViewHolder viewHolderN = N(RecyclerView.this.getChildAt(i2));
            if (viewHolderN != null && !viewHolderN.o()) {
                viewHolderN.a(6);
            }
        }
        U();
        Recycler recycler = this.f11546c;
        ArrayList arrayList = recycler.f11609c;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ViewHolder viewHolder = (ViewHolder) arrayList.get(i3);
            if (viewHolder != null) {
                viewHolder.a(6);
                viewHolder.a(1024);
            }
        }
        Adapter adapter = RecyclerView.this.f11556m;
        if (adapter == null || !adapter.f11564b) {
            recycler.f();
        }
    }

    public final void c0(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo) {
        viewHolder.f11662j &= -8193;
        boolean z = this.R0.f11640h;
        ViewInfoStore viewInfoStore = this.f11550g;
        if (z && viewHolder.k() && !viewHolder.h() && !viewHolder.o()) {
            viewInfoStore.f11715b.g(L(viewHolder), viewHolder);
        }
        SimpleArrayMap simpleArrayMap = viewInfoStore.f11714a;
        ViewInfoStore.InfoRecord infoRecordA = (ViewInfoStore.InfoRecord) simpleArrayMap.get(viewHolder);
        if (infoRecordA == null) {
            infoRecordA = ViewInfoStore.InfoRecord.a();
            simpleArrayMap.put(viewHolder, infoRecordA);
        }
        infoRecordA.f11718b = itemHolderInfo;
        infoRecordA.f11717a |= 4;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.n.f((LayoutParams) layoutParams);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.n;
        if (layoutManager != null && layoutManager.d()) {
            return this.n.j(this.R0);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.n;
        if (layoutManager != null && layoutManager.d()) {
            return this.n.k(this.R0);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.n;
        if (layoutManager != null && layoutManager.d()) {
            return this.n.l(this.R0);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.n;
        if (layoutManager != null && layoutManager.e()) {
            return this.n.m(this.R0);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.n;
        if (layoutManager != null && layoutManager.e()) {
            return this.n.n(this.R0);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.n;
        if (layoutManager != null && layoutManager.e()) {
            return this.n.o(this.R0);
        }
        return 0;
    }

    public final int d0(float f2, int i2) {
        float height = f2 / getHeight();
        float width = i2 / getWidth();
        EdgeEffect edgeEffect = this.J;
        float f3 = 0.0f;
        if (edgeEffect == null || EdgeEffectCompat.a(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.L;
            if (edgeEffect2 != null && EdgeEffectCompat.a(edgeEffect2) != 0.0f) {
                if (canScrollHorizontally(1)) {
                    this.L.onRelease();
                } else {
                    float fB = EdgeEffectCompat.b(this.L, width, height);
                    if (EdgeEffectCompat.a(this.L) == 0.0f) {
                        this.L.onRelease();
                    }
                    f3 = fB;
                }
                invalidate();
            }
        } else {
            if (canScrollHorizontally(-1)) {
                this.J.onRelease();
            } else {
                float f4 = -EdgeEffectCompat.b(this.J, -width, 1.0f - height);
                if (EdgeEffectCompat.a(this.J) == 0.0f) {
                    this.J.onRelease();
                }
                f3 = f4;
            }
            invalidate();
        }
        return Math.round(f3 * getWidth());
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return getScrollingChildHelper().a(f2, f3, z);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().b(f2, f3);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i2, i3, 0, iArr, iArr2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().g(i2, i3, i4, i5, iArr, 0, null);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        boolean z;
        super.draw(canvas);
        ArrayList arrayList = this.q;
        int size = arrayList.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            ((ItemDecoration) arrayList.get(i2)).h(canvas, this);
        }
        EdgeEffect edgeEffect = this.J;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.f11551h ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.J;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.K;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.f11551h) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.K;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.L;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f11551h ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.L;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.M;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f11551h) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.M;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(iSave4);
        }
        if ((z || this.Q == null || arrayList.size() <= 0 || !this.Q.k()) ? z : true) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public final int e0(float f2, int i2) {
        float width = f2 / getWidth();
        float height = i2 / getHeight();
        EdgeEffect edgeEffect = this.K;
        float f3 = 0.0f;
        if (edgeEffect == null || EdgeEffectCompat.a(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.M;
            if (edgeEffect2 != null && EdgeEffectCompat.a(edgeEffect2) != 0.0f) {
                if (canScrollVertically(1)) {
                    this.M.onRelease();
                } else {
                    float fB = EdgeEffectCompat.b(this.M, height, 1.0f - width);
                    if (EdgeEffectCompat.a(this.M) == 0.0f) {
                        this.M.onRelease();
                    }
                    f3 = fB;
                }
                invalidate();
            }
        } else {
            if (canScrollVertically(-1)) {
                this.K.onRelease();
            } else {
                float f4 = -EdgeEffectCompat.b(this.K, -height, width);
                if (EdgeEffectCompat.a(this.K) == 0.0f) {
                    this.K.onRelease();
                }
                f3 = f4;
            }
            invalidate();
        }
        return Math.round(f3 * getHeight());
    }

    public final void f0(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        int width = view3.getWidth();
        int height = view3.getHeight();
        Rect rect = this.f11553j;
        rect.set(0, 0, width, height);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.f11598c) {
                int i2 = rect.left;
                Rect rect2 = layoutParams2.f11597b;
                rect.left = i2 - rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, rect);
            offsetRectIntoDescendantCoords(view, rect);
        }
        this.n.r0(this, view, this.f11553j, !this.v, view2 == null);
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0193 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cc A[ADDED_TO_REGION] */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View focusSearch(android.view.View r17, int r18) {
        /*
            Method dump skipped, instructions count: 409
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.focusSearch(android.view.View, int):android.view.View");
    }

    public final void g0() {
        VelocityTracker velocityTracker = this.C0;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean zIsFinished = false;
        p0(0);
        EdgeEffect edgeEffect = this.J;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.J.isFinished();
        }
        EdgeEffect edgeEffect2 = this.K;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.K.isFinished();
        }
        EdgeEffect edgeEffect3 = this.L;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.L.isFinished();
        }
        EdgeEffect edgeEffect4 = this.M;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.M.isFinished();
        }
        if (zIsFinished) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager layoutManager = this.n;
        if (layoutManager != null) {
            return layoutManager.r();
        }
        throw new IllegalStateException(a.m(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LayoutManager layoutManager = this.n;
        if (layoutManager != null) {
            return layoutManager.s(getContext(), attributeSet);
        }
        throw new IllegalStateException(a.m(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    @Nullable
    public Adapter getAdapter() {
        return this.f11556m;
    }

    @Override // android.view.View
    public int getBaseline() {
        LayoutManager layoutManager = this.n;
        if (layoutManager == null) {
            return super.getBaseline();
        }
        layoutManager.getClass();
        return -1;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i2, int i3) {
        ChildDrawingOrderCallback childDrawingOrderCallback = this.Z0;
        return childDrawingOrderCallback == null ? super.getChildDrawingOrder(i2, i3) : childDrawingOrderCallback.a(i2, i3);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f11551h;
    }

    @Nullable
    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.Y0;
    }

    @NonNull
    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.I;
    }

    @Nullable
    public ItemAnimator getItemAnimator() {
        return this.Q;
    }

    public int getItemDecorationCount() {
        return this.q.size();
    }

    @Nullable
    public LayoutManager getLayoutManager() {
        return this.n;
    }

    public int getMaxFlingVelocity() {
        return this.K0;
    }

    public int getMinFlingVelocity() {
        return this.J0;
    }

    public long getNanoTime() {
        if (r1) {
            return System.nanoTime();
        }
        return 0L;
    }

    @Nullable
    public OnFlingListener getOnFlingListener() {
        return this.I0;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.N0;
    }

    @NonNull
    public RecycledViewPool getRecycledViewPool() {
        return this.f11546c.c();
    }

    public int getScrollState() {
        return this.A0;
    }

    public final void h(ViewHolder viewHolder) {
        ChildHelper childHelper = this.f11549f;
        View view = viewHolder.f11653a;
        boolean z = view.getParent() == this;
        this.f11546c.l(M(view));
        if (viewHolder.j()) {
            childHelper.a(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (z) {
            int iIndexOfChild = RecyclerView.this.indexOfChild(view);
            if (iIndexOfChild < 0) {
                throw new IllegalArgumentException("view is not a child, cannot hide " + view);
            }
            childHelper.f11376b.h(iIndexOfChild);
            childHelper.f11377c.add(view);
            AnonymousClass5 anonymousClass5 = childHelper.f11375a;
            ViewHolder viewHolderN = N(view);
            if (viewHolderN != null) {
                int i2 = viewHolderN.q;
                View view2 = viewHolderN.f11653a;
                if (i2 != -1) {
                    viewHolderN.p = i2;
                } else {
                    WeakHashMap weakHashMap = ViewCompat.f3080a;
                    viewHolderN.p = view2.getImportantForAccessibility();
                }
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.S()) {
                    viewHolderN.q = 4;
                    recyclerView.f1.add(viewHolderN);
                    return;
                } else {
                    WeakHashMap weakHashMap2 = ViewCompat.f3080a;
                    view2.setImportantForAccessibility(4);
                    return;
                }
            }
            return;
        }
        RecyclerView recyclerView2 = RecyclerView.this;
        int childCount = recyclerView2.getChildCount();
        childHelper.f11376b.e(childCount, true);
        childHelper.f11377c.add(view);
        ViewHolder viewHolderN2 = N(view);
        if (viewHolderN2 != null) {
            int i3 = viewHolderN2.q;
            View view3 = viewHolderN2.f11653a;
            if (i3 != -1) {
                viewHolderN2.p = i3;
            } else {
                WeakHashMap weakHashMap3 = ViewCompat.f3080a;
                viewHolderN2.p = view3.getImportantForAccessibility();
            }
            if (recyclerView2.S()) {
                viewHolderN2.q = 4;
                recyclerView2.f1.add(viewHolderN2);
            } else {
                WeakHashMap weakHashMap4 = ViewCompat.f3080a;
                view3.setImportantForAccessibility(4);
            }
        }
        recyclerView2.addView(view, childCount);
        ViewHolder viewHolderN3 = N(view);
        Adapter adapter = recyclerView2.f11556m;
        if (adapter != null && viewHolderN3 != null) {
            adapter.s(viewHolderN3);
        }
        ArrayList arrayList = recyclerView2.D;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((OnChildAttachStateChangeListener) recyclerView2.D.get(size)).c(view);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h0(int r18, int r19, android.view.MotionEvent r20, int r21) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.h0(int, int, android.view.MotionEvent, int):boolean");
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().j(0);
    }

    public final void i(ItemDecoration itemDecoration) {
        LayoutManager layoutManager = this.n;
        if (layoutManager != null) {
            layoutManager.c("Cannot add item decoration during a scroll  or layout");
        }
        ArrayList arrayList = this.q;
        if (arrayList.isEmpty()) {
            setWillNotDraw(false);
        }
        arrayList.add(itemDecoration);
        U();
        requestLayout();
    }

    public final void i0(int i2, int i3, int[] iArr) {
        ViewHolder viewHolder;
        ChildHelper childHelper = this.f11549f;
        n0();
        W();
        int i4 = TraceCompat.f2887a;
        Trace.beginSection("RV Scroll");
        State state = this.R0;
        E(state);
        Recycler recycler = this.f11546c;
        int iT0 = i2 != 0 ? this.n.t0(i2, recycler, state) : 0;
        int iV0 = i3 != 0 ? this.n.v0(i3, recycler, state) : 0;
        Trace.endSection();
        int iC = childHelper.c();
        for (int i5 = 0; i5 < iC; i5++) {
            View viewB = childHelper.b(i5);
            ViewHolder viewHolderM = M(viewB);
            if (viewHolderM != null && (viewHolder = viewHolderM.f11661i) != null) {
                int left = viewB.getLeft();
                int top = viewB.getTop();
                View view = viewHolder.f11653a;
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        X(true);
        o0(false);
        if (iArr != null) {
            iArr[0] = iT0;
            iArr[1] = iV0;
        }
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.t;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.y;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f3057d;
    }

    public final void j(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.D == null) {
            this.D = new ArrayList();
        }
        this.D.add(onChildAttachStateChangeListener);
    }

    public final void j0(int i2) {
        SmoothScroller smoothScroller;
        if (this.y) {
            return;
        }
        setScrollState(0);
        ViewFlinger viewFlinger = this.O0;
        RecyclerView.this.removeCallbacks(viewFlinger);
        viewFlinger.f11648c.abortAnimation();
        LayoutManager layoutManager = this.n;
        if (layoutManager != null && (smoothScroller = layoutManager.f11581e) != null) {
            smoothScroller.f();
        }
        LayoutManager layoutManager2 = this.n;
        if (layoutManager2 == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            layoutManager2.u0(i2);
            awakenScrollBars();
        }
    }

    public final void k(OnScrollListener onScrollListener) {
        if (this.T0 == null) {
            this.T0 = new ArrayList();
        }
        this.T0.add(onScrollListener);
    }

    public final boolean k0(EdgeEffect edgeEffect, int i2, int i3) {
        if (i2 > 0) {
            return true;
        }
        float fA = EdgeEffectCompat.a(edgeEffect) * i3;
        float fAbs = Math.abs(-i2) * 0.35f;
        float f2 = this.f11544a * 0.015f;
        double dLog = Math.log(fAbs / f2);
        double d2 = o1;
        return ((float) (Math.exp((d2 / (d2 - 1.0d)) * dLog) * ((double) f2))) < fA;
    }

    public final void l(String str) {
        if (S()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException(a.m(this, new StringBuilder("Cannot call this method while RecyclerView is computing a layout or scrolling")));
        }
        if (this.H > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(a.m(this, new StringBuilder(""))));
        }
    }

    public final void l0(int i2, int i3, boolean z) {
        LayoutManager layoutManager = this.n;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.y) {
            return;
        }
        if (!layoutManager.d()) {
            i2 = 0;
        }
        if (!this.n.e()) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        if (z) {
            int i4 = i2 != 0 ? 1 : 0;
            if (i3 != 0) {
                i4 |= 2;
            }
            getScrollingChildHelper().n(i4, 1);
        }
        this.O0.c(i2, i3, Integer.MIN_VALUE, null);
    }

    public final void m0(int i2) {
        if (this.y) {
            return;
        }
        LayoutManager layoutManager = this.n;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            layoutManager.E0(i2, this);
        }
    }

    public final void n() {
        int childCount = RecyclerView.this.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ViewHolder viewHolderN = N(RecyclerView.this.getChildAt(i2));
            if (!viewHolderN.o()) {
                viewHolderN.f11656d = -1;
                viewHolderN.f11659g = -1;
            }
        }
        Recycler recycler = this.f11546c;
        ArrayList arrayList = recycler.f11609c;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ViewHolder viewHolder = (ViewHolder) arrayList.get(i3);
            viewHolder.f11656d = -1;
            viewHolder.f11659g = -1;
        }
        ArrayList arrayList2 = recycler.f11607a;
        int size2 = arrayList2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            ViewHolder viewHolder2 = (ViewHolder) arrayList2.get(i4);
            viewHolder2.f11656d = -1;
            viewHolder2.f11659g = -1;
        }
        ArrayList arrayList3 = recycler.f11608b;
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            for (int i5 = 0; i5 < size3; i5++) {
                ViewHolder viewHolder3 = (ViewHolder) recycler.f11608b.get(i5);
                viewHolder3.f11656d = -1;
                viewHolder3.f11659g = -1;
            }
        }
    }

    public final void n0() {
        int i2 = this.w + 1;
        this.w = i2;
        if (i2 != 1 || this.y) {
            return;
        }
        this.x = false;
    }

    public final void o(int i2, int i3) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.J;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            zIsFinished = false;
        } else {
            this.J.onRelease();
            zIsFinished = this.J.isFinished();
        }
        EdgeEffect edgeEffect2 = this.L;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.L.onRelease();
            zIsFinished |= this.L.isFinished();
        }
        EdgeEffect edgeEffect3 = this.K;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.K.onRelease();
            zIsFinished |= this.K.isFinished();
        }
        EdgeEffect edgeEffect4 = this.M;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.M.onRelease();
            zIsFinished |= this.M.isFinished();
        }
        if (zIsFinished) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            postInvalidateOnAnimation();
        }
    }

    public final void o0(boolean z) {
        if (this.w < 1) {
            if (l1) {
                throw new IllegalStateException(a.m(this, new StringBuilder("stopInterceptRequestLayout was called more times than startInterceptRequestLayout.")));
            }
            this.w = 1;
        }
        if (!z && !this.y) {
            this.x = false;
        }
        if (this.w == 1) {
            if (z && this.x && !this.y && this.n != null && this.f11556m != null) {
                t();
            }
            if (!this.y) {
                this.x = false;
            }
        }
        this.w--;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0066  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.G = r0
            r1 = 1
            r5.t = r1
            boolean r2 = r5.v
            if (r2 == 0) goto L15
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L15
            r2 = r1
            goto L16
        L15:
            r2 = r0
        L16:
            r5.v = r2
            androidx.recyclerview.widget.RecyclerView$Recycler r2 = r5.f11546c
            r2.d()
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = r5.n
            if (r2 == 0) goto L26
            r2.f11583g = r1
            r2.V(r5)
        L26:
            r5.X0 = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.r1
            if (r0 == 0) goto L91
            java.lang.ThreadLocal r0 = androidx.recyclerview.widget.GapWorker.f11473e
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.GapWorker r1 = (androidx.recyclerview.widget.GapWorker) r1
            r5.P0 = r1
            if (r1 != 0) goto L74
            androidx.recyclerview.widget.GapWorker r1 = new androidx.recyclerview.widget.GapWorker
            r1.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f11475a = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f11478d = r2
            r5.P0 = r1
            java.util.WeakHashMap r1 = androidx.core.view.ViewCompat.f3080a
            android.view.Display r1 = r5.getDisplay()
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L66
            if (r1 == 0) goto L66
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L66
            goto L68
        L66:
            r1 = 1114636288(0x42700000, float:60.0)
        L68:
            androidx.recyclerview.widget.GapWorker r2 = r5.P0
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f11477c = r3
            r0.set(r2)
        L74:
            androidx.recyclerview.widget.GapWorker r0 = r5.P0
            r0.getClass()
            boolean r1 = androidx.recyclerview.widget.RecyclerView.l1
            java.util.ArrayList r0 = r0.f11475a
            if (r1 == 0) goto L8e
            boolean r1 = r0.contains(r5)
            if (r1 != 0) goto L86
            goto L8e
        L86:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "RecyclerView already present in worker list!"
            r0.<init>(r1)
            throw r0
        L8e:
            r0.add(r5)
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Recycler recycler;
        GapWorker gapWorker;
        SmoothScroller smoothScroller;
        super.onDetachedFromWindow();
        ItemAnimator itemAnimator = this.Q;
        if (itemAnimator != null) {
            itemAnimator.j();
        }
        setScrollState(0);
        ViewFlinger viewFlinger = this.O0;
        RecyclerView.this.removeCallbacks(viewFlinger);
        viewFlinger.f11648c.abortAnimation();
        LayoutManager layoutManager = this.n;
        if (layoutManager != null && (smoothScroller = layoutManager.f11581e) != null) {
            smoothScroller.f();
        }
        this.t = false;
        LayoutManager layoutManager2 = this.n;
        if (layoutManager2 != null) {
            layoutManager2.f11583g = false;
            layoutManager2.W(this);
        }
        this.f1.clear();
        removeCallbacks(this.g1);
        this.f11550g.getClass();
        while (ViewInfoStore.InfoRecord.f11716d.b() != null) {
        }
        int i2 = 0;
        while (true) {
            recycler = this.f11546c;
            ArrayList arrayList = recycler.f11609c;
            if (i2 >= arrayList.size()) {
                break;
            }
            PoolingContainer.a(((ViewHolder) arrayList.get(i2)).f11653a);
            i2++;
        }
        recycler.e(RecyclerView.this.f11556m, false);
        PoolingContainer.b(this);
        if (!r1 || (gapWorker = this.P0) == null) {
            return;
        }
        boolean zRemove = gapWorker.f11475a.remove(this);
        if (l1 && !zRemove) {
            throw new IllegalStateException("RecyclerView removal failed!");
        }
        this.P0 = null;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList arrayList = this.q;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((ItemDecoration) arrayList.get(i2)).g(canvas, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0082  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onGenericMotionEvent(android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        if (!this.y) {
            this.s = null;
            if (G(motionEvent)) {
                g0();
                setScrollState(0);
                return true;
            }
            LayoutManager layoutManager = this.n;
            if (layoutManager != null) {
                boolean zD = layoutManager.d();
                boolean zE = this.n.e();
                if (this.C0 == null) {
                    this.C0 = VelocityTracker.obtain();
                }
                this.C0.addMovement(motionEvent);
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                if (actionMasked == 0) {
                    if (this.z) {
                        this.z = false;
                    }
                    this.B0 = motionEvent.getPointerId(0);
                    int x = (int) (motionEvent.getX() + 0.5f);
                    this.F0 = x;
                    this.D0 = x;
                    int y = (int) (motionEvent.getY() + 0.5f);
                    this.G0 = y;
                    this.E0 = y;
                    EdgeEffect edgeEffect = this.J;
                    if (edgeEffect == null || EdgeEffectCompat.a(edgeEffect) == 0.0f || canScrollHorizontally(-1)) {
                        z = false;
                    } else {
                        EdgeEffectCompat.b(this.J, 0.0f, 1.0f - (motionEvent.getY() / getHeight()));
                        z = true;
                    }
                    EdgeEffect edgeEffect2 = this.L;
                    boolean z3 = z;
                    if (edgeEffect2 != null) {
                        z3 = z;
                        if (EdgeEffectCompat.a(edgeEffect2) != 0.0f) {
                            z3 = z;
                            if (!canScrollHorizontally(1)) {
                                EdgeEffectCompat.b(this.L, 0.0f, motionEvent.getY() / getHeight());
                                z3 = true;
                            }
                        }
                    }
                    EdgeEffect edgeEffect3 = this.K;
                    boolean z4 = z3;
                    if (edgeEffect3 != null) {
                        z4 = z3;
                        if (EdgeEffectCompat.a(edgeEffect3) != 0.0f) {
                            z4 = z3;
                            if (!canScrollVertically(-1)) {
                                EdgeEffectCompat.b(this.K, 0.0f, motionEvent.getX() / getWidth());
                                z4 = true;
                            }
                        }
                    }
                    EdgeEffect edgeEffect4 = this.M;
                    boolean z5 = z4;
                    if (edgeEffect4 != null) {
                        z5 = z4;
                        if (EdgeEffectCompat.a(edgeEffect4) != 0.0f) {
                            z5 = z4;
                            if (!canScrollVertically(1)) {
                                EdgeEffectCompat.b(this.M, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
                                z5 = true;
                            }
                        }
                    }
                    if (z5 || this.A0 == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                        p0(1);
                    }
                    int[] iArr = this.d1;
                    iArr[1] = 0;
                    iArr[0] = 0;
                    int i2 = zD;
                    if (zE) {
                        i2 = (zD ? 1 : 0) | 2;
                    }
                    getScrollingChildHelper().n(i2, 0);
                } else if (actionMasked == 1) {
                    this.C0.clear();
                    p0(0);
                } else if (actionMasked == 2) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.B0);
                    if (iFindPointerIndex < 0) {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.B0 + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x2 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                    int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                    if (this.A0 != 1) {
                        int i3 = x2 - this.D0;
                        int i4 = y2 - this.E0;
                        if (zD == 0 || Math.abs(i3) <= this.H0) {
                            z2 = false;
                        } else {
                            this.F0 = x2;
                            z2 = true;
                        }
                        if (zE && Math.abs(i4) > this.H0) {
                            this.G0 = y2;
                            z2 = true;
                        }
                        if (z2) {
                            setScrollState(1);
                        }
                    }
                } else if (actionMasked == 3) {
                    g0();
                    setScrollState(0);
                } else if (actionMasked == 5) {
                    this.B0 = motionEvent.getPointerId(actionIndex);
                    int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.F0 = x3;
                    this.D0 = x3;
                    int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.G0 = y3;
                    this.E0 = y3;
                } else if (actionMasked == 6) {
                    Y(motionEvent);
                }
                if (this.A0 == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6 = TraceCompat.f2887a;
        Trace.beginSection("RV OnLayout");
        t();
        Trace.endSection();
        this.v = true;
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        LayoutManager layoutManager = this.n;
        if (layoutManager == null) {
            r(i2, i3);
            return;
        }
        boolean zP = layoutManager.P();
        boolean z = false;
        State state = this.R0;
        if (zP) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.n.f11578b.r(i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.h1 = z;
            if (z || this.f11556m == null) {
                return;
            }
            if (state.f11636d == 1) {
                u();
            }
            this.n.x0(i2, i3);
            state.f11641i = true;
            v();
            this.n.z0(i2, i3);
            if (this.n.C0()) {
                this.n.x0(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                state.f11641i = true;
                v();
                this.n.z0(i2, i3);
            }
            this.i1 = getMeasuredWidth();
            this.j1 = getMeasuredHeight();
            return;
        }
        if (this.u) {
            this.n.f11578b.r(i2, i3);
            return;
        }
        if (this.B) {
            n0();
            W();
            a0();
            X(true);
            if (state.f11643k) {
                state.f11639g = true;
            } else {
                this.f11548e.c();
                state.f11639g = false;
            }
            this.B = false;
            o0(false);
        } else if (state.f11643k) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        Adapter adapter = this.f11556m;
        if (adapter != null) {
            state.f11637e = adapter.d();
        } else {
            state.f11637e = 0;
        }
        n0();
        this.n.f11578b.r(i2, i3);
        o0(false);
        state.f11639g = false;
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (S()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.f11547d = savedState;
        super.onRestoreInstanceState(savedState.f3321a);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.f11547d;
        if (savedState2 != null) {
            savedState.f11617c = savedState2.f11617c;
            return savedState;
        }
        LayoutManager layoutManager = this.n;
        if (layoutManager != null) {
            savedState.f11617c = layoutManager.k0();
            return savedState;
        }
        savedState.f11617c = null;
        return savedState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        this.M = null;
        this.K = null;
        this.L = null;
        this.J = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:141:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0292 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00fd A[PHI: r1
      0x00fd: PHI (r1v57 int) = (r1v41 int), (r1v61 int) binds: [B:51:0x00e6, B:55:0x00f9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0116  */
    /* JADX WARN: Type inference failed for: r5v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v6 */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r19) {
        /*
            Method dump skipped, instructions count: 807
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p0(int i2) {
        getScrollingChildHelper().p(i2);
    }

    public final void q() {
        ChildHelper childHelper = this.f11549f;
        AdapterHelper adapterHelper = this.f11548e;
        if (!this.v || this.E) {
            int i2 = TraceCompat.f2887a;
            Trace.beginSection("RV FullInvalidate");
            t();
            Trace.endSection();
            return;
        }
        if (adapterHelper.g()) {
            int i3 = adapterHelper.f11343f;
            if ((i3 & 4) == 0 || (i3 & 11) != 0) {
                if (adapterHelper.g()) {
                    int i4 = TraceCompat.f2887a;
                    Trace.beginSection("RV FullInvalidate");
                    t();
                    Trace.endSection();
                    return;
                }
                return;
            }
            int i5 = TraceCompat.f2887a;
            Trace.beginSection("RV PartialInvalidate");
            n0();
            W();
            adapterHelper.j();
            if (!this.x) {
                int iC = childHelper.c();
                int i6 = 0;
                while (true) {
                    if (i6 < iC) {
                        ViewHolder viewHolderN = N(childHelper.b(i6));
                        if (viewHolderN != null && !viewHolderN.o() && viewHolderN.k()) {
                            t();
                            break;
                        }
                        i6++;
                    } else {
                        adapterHelper.b();
                        break;
                    }
                }
            }
            o0(true);
            X(true);
            Trace.endSection();
        }
    }

    public final void r(int i2, int i3) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        setMeasuredDimension(LayoutManager.g(i2, paddingRight, getMinimumWidth()), LayoutManager.g(i3, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z) {
        ViewHolder viewHolderN = N(view);
        if (viewHolderN != null) {
            if (viewHolderN.j()) {
                viewHolderN.f11662j &= -257;
            } else if (!viewHolderN.o()) {
                StringBuilder sb = new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(viewHolderN);
                throw new IllegalArgumentException(a.m(this, sb));
            }
        } else if (l1) {
            StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
            sb2.append(view);
            throw new IllegalArgumentException(a.m(this, sb2));
        }
        view.clearAnimation();
        s(view);
        super.removeDetachedView(view, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        SmoothScroller smoothScroller = this.n.f11581e;
        if ((smoothScroller == null || !smoothScroller.f11622e) && !S() && view2 != null) {
            f0(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.n.r0(this, view, rect, z, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        ArrayList arrayList = this.r;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((OnItemTouchListener) arrayList.get(i2)).d(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.w != 0 || this.y) {
            this.x = true;
        } else {
            super.requestLayout();
        }
    }

    public final void s(View view) {
        ViewHolder viewHolderN = N(view);
        Adapter adapter = this.f11556m;
        if (adapter != null && viewHolderN != null) {
            adapter.t();
        }
        ArrayList arrayList = this.D;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((OnChildAttachStateChangeListener) this.D.get(size)).b(view);
            }
        }
    }

    @Override // android.view.View
    public final void scrollBy(int i2, int i3) {
        LayoutManager layoutManager = this.n;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.y) {
            return;
        }
        boolean zD = layoutManager.d();
        boolean zE = this.n.e();
        if (zD || zE) {
            if (!zD) {
                i2 = 0;
            }
            if (!zE) {
                i3 = 0;
            }
            h0(i2, i3, null, 0);
        }
    }

    @Override // android.view.View
    public final void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!S()) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        } else {
            int contentChangeTypes = accessibilityEvent != null ? accessibilityEvent.getContentChangeTypes() : 0;
            this.A |= contentChangeTypes != 0 ? contentChangeTypes : 0;
        }
    }

    public void setAccessibilityDelegateCompat(@Nullable RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.Y0 = recyclerViewAccessibilityDelegate;
        ViewCompat.z(this, recyclerViewAccessibilityDelegate);
    }

    public void setAdapter(@Nullable Adapter adapter) {
        setLayoutFrozen(false);
        Adapter adapter2 = this.f11556m;
        RecyclerViewDataObserver recyclerViewDataObserver = this.f11545b;
        if (adapter2 != null) {
            adapter2.x(recyclerViewDataObserver);
            this.f11556m.q(this);
        }
        ItemAnimator itemAnimator = this.Q;
        if (itemAnimator != null) {
            itemAnimator.j();
        }
        LayoutManager layoutManager = this.n;
        Recycler recycler = this.f11546c;
        if (layoutManager != null) {
            layoutManager.n0(recycler);
            this.n.o0(recycler);
        }
        recycler.f11607a.clear();
        recycler.f();
        AdapterHelper adapterHelper = this.f11548e;
        adapterHelper.k(adapterHelper.f11339b);
        adapterHelper.k(adapterHelper.f11340c);
        adapterHelper.f11343f = 0;
        Adapter adapter3 = this.f11556m;
        this.f11556m = adapter;
        if (adapter != null) {
            adapter.v(recyclerViewDataObserver);
            adapter.n(this);
        }
        LayoutManager layoutManager2 = this.n;
        if (layoutManager2 != null) {
            layoutManager2.U();
        }
        Adapter adapter4 = this.f11556m;
        recycler.f11607a.clear();
        recycler.f();
        recycler.e(adapter3, true);
        RecycledViewPool recycledViewPoolC = recycler.c();
        if (adapter3 != null) {
            recycledViewPoolC.f11601b--;
        }
        if (recycledViewPoolC.f11601b == 0) {
            int i2 = 0;
            while (true) {
                SparseArray sparseArray = recycledViewPoolC.f11600a;
                if (i2 >= sparseArray.size()) {
                    break;
                }
                RecycledViewPool.ScrapData scrapData = (RecycledViewPool.ScrapData) sparseArray.valueAt(i2);
                Iterator it = scrapData.f11603a.iterator();
                while (it.hasNext()) {
                    PoolingContainer.a(((ViewHolder) it.next()).f11653a);
                }
                scrapData.f11603a.clear();
                i2++;
            }
        }
        if (adapter4 != null) {
            recycledViewPoolC.f11601b++;
        }
        recycler.d();
        this.R0.f11638f = true;
        b0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(@Nullable ChildDrawingOrderCallback childDrawingOrderCallback) {
        if (childDrawingOrderCallback == this.Z0) {
            return;
        }
        this.Z0 = childDrawingOrderCallback;
        setChildrenDrawingOrderEnabled(childDrawingOrderCallback != null);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.f11551h) {
            this.M = null;
            this.K = null;
            this.L = null;
            this.J = null;
        }
        this.f11551h = z;
        super.setClipToPadding(z);
        if (this.v) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(@NonNull EdgeEffectFactory edgeEffectFactory) {
        edgeEffectFactory.getClass();
        this.I = edgeEffectFactory;
        this.M = null;
        this.K = null;
        this.L = null;
        this.J = null;
    }

    public void setHasFixedSize(boolean z) {
        this.u = z;
    }

    public void setItemAnimator(@Nullable ItemAnimator itemAnimator) {
        ItemAnimator itemAnimator2 = this.Q;
        if (itemAnimator2 != null) {
            itemAnimator2.j();
            this.Q.f11568a = null;
        }
        this.Q = itemAnimator;
        if (itemAnimator != null) {
            itemAnimator.f11568a = this.W0;
        }
    }

    public void setItemViewCacheSize(int i2) {
        Recycler recycler = this.f11546c;
        recycler.f11611e = i2;
        recycler.m();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    public void setLayoutManager(@Nullable LayoutManager layoutManager) {
        AnonymousClass5 anonymousClass5;
        SmoothScroller smoothScroller;
        if (layoutManager == this.n) {
            return;
        }
        setScrollState(0);
        ViewFlinger viewFlinger = this.O0;
        RecyclerView.this.removeCallbacks(viewFlinger);
        viewFlinger.f11648c.abortAnimation();
        LayoutManager layoutManager2 = this.n;
        if (layoutManager2 != null && (smoothScroller = layoutManager2.f11581e) != null) {
            smoothScroller.f();
        }
        LayoutManager layoutManager3 = this.n;
        Recycler recycler = this.f11546c;
        if (layoutManager3 != null) {
            ItemAnimator itemAnimator = this.Q;
            if (itemAnimator != null) {
                itemAnimator.j();
            }
            this.n.n0(recycler);
            this.n.o0(recycler);
            recycler.f11607a.clear();
            recycler.f();
            if (this.t) {
                LayoutManager layoutManager4 = this.n;
                layoutManager4.f11583g = false;
                layoutManager4.W(this);
            }
            this.n.A0(null);
            this.n = null;
        } else {
            recycler.f11607a.clear();
            recycler.f();
        }
        ChildHelper childHelper = this.f11549f;
        childHelper.f11376b.g();
        ArrayList arrayList = childHelper.f11377c;
        int size = arrayList.size() - 1;
        while (true) {
            anonymousClass5 = childHelper.f11375a;
            if (size < 0) {
                break;
            }
            anonymousClass5.a((View) arrayList.get(size));
            arrayList.remove(size);
            size--;
        }
        RecyclerView recyclerView = RecyclerView.this;
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            recyclerView.s(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeAllViews();
        this.n = layoutManager;
        if (layoutManager != null) {
            if (layoutManager.f11578b != null) {
                StringBuilder sb = new StringBuilder("LayoutManager ");
                sb.append(layoutManager);
                sb.append(" is already attached to a RecyclerView:");
                throw new IllegalArgumentException(a.m(layoutManager.f11578b, sb));
            }
            layoutManager.A0(this);
            if (this.t) {
                LayoutManager layoutManager5 = this.n;
                layoutManager5.f11583g = true;
                layoutManager5.V(this);
            }
        }
        recycler.m();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().l(z);
    }

    public void setOnFlingListener(@Nullable OnFlingListener onFlingListener) {
        this.I0 = onFlingListener;
    }

    @Deprecated
    public void setOnScrollListener(@Nullable OnScrollListener onScrollListener) {
        this.S0 = onScrollListener;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.N0 = z;
    }

    public void setRecycledViewPool(@Nullable RecycledViewPool recycledViewPool) {
        Recycler recycler = this.f11546c;
        RecyclerView recyclerView = RecyclerView.this;
        recycler.e(recyclerView.f11556m, false);
        if (recycler.f11613g != null) {
            r2.f11601b--;
        }
        recycler.f11613g = recycledViewPool;
        if (recycledViewPool != null && recyclerView.getAdapter() != null) {
            recycler.f11613g.f11601b++;
        }
        recycler.d();
    }

    @Deprecated
    public void setRecyclerListener(@Nullable RecyclerListener recyclerListener) {
        this.o = recyclerListener;
    }

    public void setScrollState(int i2) {
        SmoothScroller smoothScroller;
        if (i2 == this.A0) {
            return;
        }
        if (m1) {
            StringBuilder sbU = b.u(i2, "setting scroll state to ", " from ");
            sbU.append(this.A0);
            Log.d("RecyclerView", sbU.toString(), new Exception());
        }
        this.A0 = i2;
        if (i2 != 2) {
            ViewFlinger viewFlinger = this.O0;
            RecyclerView.this.removeCallbacks(viewFlinger);
            viewFlinger.f11648c.abortAnimation();
            LayoutManager layoutManager = this.n;
            if (layoutManager != null && (smoothScroller = layoutManager.f11581e) != null) {
                smoothScroller.f();
            }
        }
        LayoutManager layoutManager2 = this.n;
        if (layoutManager2 != null) {
            layoutManager2.l0(i2);
        }
        OnScrollListener onScrollListener = this.S0;
        if (onScrollListener != null) {
            onScrollListener.a(i2, this);
        }
        ArrayList arrayList = this.T0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((OnScrollListener) this.T0.get(size)).a(i2, this);
            }
        }
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 == 1) {
                this.H0 = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
        }
        this.H0 = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(@Nullable ViewCacheExtension viewCacheExtension) {
        this.f11546c.f11614h = viewCacheExtension;
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().n(i2, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        getScrollingChildHelper().p(0);
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z) {
        SmoothScroller smoothScroller;
        if (z != this.y) {
            l("Do not suppressLayout in layout or scroll");
            if (!z) {
                this.y = false;
                if (this.x && this.n != null && this.f11556m != null) {
                    requestLayout();
                }
                this.x = false;
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
            this.y = true;
            this.z = true;
            setScrollState(0);
            ViewFlinger viewFlinger = this.O0;
            RecyclerView.this.removeCallbacks(viewFlinger);
            viewFlinger.f11648c.abortAnimation();
            LayoutManager layoutManager = this.n;
            if (layoutManager == null || (smoothScroller = layoutManager.f11581e) == null) {
                return;
            }
            smoothScroller.f();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t() {
        /*
            Method dump skipped, instructions count: 1065
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.t():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u() {
        /*
            Method dump skipped, instructions count: 559
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.u():void");
    }

    public final void v() {
        n0();
        W();
        State state = this.R0;
        state.a(6);
        this.f11548e.c();
        state.f11637e = this.f11556m.d();
        state.f11635c = 0;
        if (this.f11547d != null) {
            Adapter adapter = this.f11556m;
            int iOrdinal = adapter.f11565c.ordinal();
            if (iOrdinal == 1 ? adapter.d() > 0 : iOrdinal != 2) {
                Parcelable parcelable = this.f11547d.f11617c;
                if (parcelable != null) {
                    this.n.j0(parcelable);
                }
                this.f11547d = null;
            }
        }
        state.f11639g = false;
        this.n.h0(this.f11546c, state);
        state.f11638f = false;
        state.f11642j = state.f11642j && this.Q != null;
        state.f11636d = 4;
        X(true);
        o0(false);
    }

    public final boolean w(int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i2, i3, i4, iArr, iArr2);
    }

    public final void x(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        getScrollingChildHelper().g(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public final void y(int i2, int i3) {
        this.H++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        OnScrollListener onScrollListener = this.S0;
        if (onScrollListener != null) {
            onScrollListener.b(this, i2, i3);
        }
        ArrayList arrayList = this.T0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((OnScrollListener) this.T0.get(size)).b(this, i2, i3);
            }
        }
        this.H--;
    }

    public final void z() {
        if (this.M != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.I.a(this);
        this.M = edgeEffectA;
        if (this.f11551h) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v2 */
    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) throws NoSuchMethodException, SecurityException {
        boolean z;
        char c2;
        TypedArray typedArray;
        Constructor constructor;
        super(context, attributeSet, i2);
        this.f11545b = new RecyclerViewDataObserver();
        this.f11546c = new Recycler();
        this.f11550g = new ViewInfoStore();
        this.f11552i = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.1
            @Override // java.lang.Runnable
            public final void run() {
                RecyclerView recyclerView = RecyclerView.this;
                if (!recyclerView.v || recyclerView.isLayoutRequested()) {
                    return;
                }
                if (!recyclerView.t) {
                    recyclerView.requestLayout();
                } else if (recyclerView.y) {
                    recyclerView.x = true;
                } else {
                    recyclerView.q();
                }
            }
        };
        this.f11553j = new Rect();
        this.f11554k = new Rect();
        this.f11555l = new RectF();
        this.p = new ArrayList();
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.w = 0;
        this.E = false;
        this.F = false;
        this.G = 0;
        this.H = 0;
        this.I = u1;
        this.Q = new DefaultItemAnimator();
        this.A0 = 0;
        this.B0 = -1;
        this.L0 = Float.MIN_VALUE;
        this.M0 = Float.MIN_VALUE;
        this.N0 = true;
        this.O0 = new ViewFlinger();
        Object[] objArr = null;
        this.Q0 = r1 ? new GapWorker.LayoutPrefetchRegistryImpl() : null;
        this.R0 = new State();
        this.U0 = false;
        this.V0 = false;
        ItemAnimatorRestoreListener itemAnimatorRestoreListener = new ItemAnimatorRestoreListener();
        this.W0 = itemAnimatorRestoreListener;
        this.X0 = false;
        this.a1 = new int[2];
        this.c1 = new int[2];
        this.d1 = new int[2];
        this.e1 = new int[2];
        this.f1 = new ArrayList();
        this.g1 = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.2
            @Override // java.lang.Runnable
            public final void run() {
                RecyclerView recyclerView = RecyclerView.this;
                ItemAnimator itemAnimator = recyclerView.Q;
                if (itemAnimator != null) {
                    itemAnimator.l();
                }
                recyclerView.X0 = false;
            }
        };
        this.i1 = 0;
        this.j1 = 0;
        this.k1 = new AnonymousClass4();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.H0 = viewConfiguration.getScaledTouchSlop();
        this.L0 = ViewConfigurationCompat.b(viewConfiguration, context);
        this.M0 = ViewConfigurationCompat.d(viewConfiguration, context);
        this.J0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.K0 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f11544a = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setWillNotDraw(getOverScrollMode() == 2);
        this.Q.f11568a = itemAnimatorRestoreListener;
        this.f11548e = new AdapterHelper(new AnonymousClass6());
        this.f11549f = new ChildHelper(new AnonymousClass5());
        if (ViewCompat.k(this) == 0) {
            ViewCompat.F(this, 8);
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.C = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.recyclerview.R.styleable.RecyclerView, i2, 0);
        ViewCompat.y(this, context, androidx.recyclerview.R.styleable.RecyclerView, attributeSet, typedArrayObtainStyledAttributes, i2, 0);
        String string = typedArrayObtainStyledAttributes.getString(androidx.recyclerview.R.styleable.RecyclerView_layoutManager);
        if (typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f11551h = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_android_clipToPadding, true);
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_fastScrollEnabled, false)) {
            StateListDrawable stateListDrawable = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollVerticalThumbDrawable);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollVerticalTrackDrawable);
            StateListDrawable stateListDrawable2 = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable);
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable);
            if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
                throw new IllegalArgumentException(a.m(this, new StringBuilder("Trying to set fast scroller without both required drawables.")));
            }
            Resources resources = getContext().getResources();
            c2 = 2;
            z = 1;
            typedArray = typedArrayObtainStyledAttributes;
            new FastScroller(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(androidx.recyclerview.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(androidx.recyclerview.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(androidx.recyclerview.R.dimen.fastscroll_margin));
        } else {
            z = 1;
            c2 = 2;
            typedArray = typedArrayObtainStyledAttributes;
        }
        typedArray.recycle();
        if (string != null) {
            String strTrim = string.trim();
            if (!strTrim.isEmpty()) {
                if (strTrim.charAt(0) == '.') {
                    strTrim = context.getPackageName() + strTrim;
                } else if (!strTrim.contains(CLConstants.DOT_SALT_DELIMETER)) {
                    strTrim = RecyclerView.class.getPackage().getName() + ClassUtils.PACKAGE_SEPARATOR_CHAR + strTrim;
                }
                String str = strTrim;
                try {
                    Class clsAsSubclass = Class.forName(str, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(LayoutManager.class);
                    try {
                        constructor = clsAsSubclass.getConstructor(s1);
                        Object[] objArr2 = new Object[4];
                        objArr2[0] = context;
                        objArr2[z] = attributeSet;
                        objArr2[c2] = Integer.valueOf(i2);
                        objArr2[3] = 0;
                        objArr = objArr2;
                    } catch (NoSuchMethodException e2) {
                        try {
                            constructor = clsAsSubclass.getConstructor(null);
                        } catch (NoSuchMethodException e3) {
                            e3.initCause(e2);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + str, e3);
                        }
                    }
                    constructor.setAccessible(z);
                    setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                } catch (ClassCastException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + str, e4);
                } catch (ClassNotFoundException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + str, e5);
                } catch (IllegalAccessException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + str, e6);
                } catch (InstantiationException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e7);
                } catch (InvocationTargetException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e8);
                }
            }
        }
        int[] iArr = n1;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        ViewCompat.y(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes2, i2, 0);
        boolean z2 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z2);
        int i3 = PoolingContainer.f3317a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        setTag(PoolingContainer.f3318b, Boolean.TRUE);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public ViewHolder f11596a;

        /* renamed from: b, reason: collision with root package name */
        public final Rect f11597b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f11598c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f11599d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f11597b = new Rect();
            this.f11598c = true;
            this.f11599d = false;
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.f11597b = new Rect();
            this.f11598c = true;
            this.f11599d = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f11597b = new Rect();
            this.f11598c = true;
            this.f11599d = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f11597b = new Rect();
            this.f11598c = true;
            this.f11599d = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.f11597b = new Rect();
            this.f11598c = true;
            this.f11599d = false;
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutManager layoutManager = this.n;
        if (layoutManager != null) {
            return layoutManager.t(layoutParams);
        }
        throw new IllegalStateException(a.m(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    public static abstract class Adapter<VH extends ViewHolder> {

        /* renamed from: a, reason: collision with root package name */
        public final AdapterDataObservable f11563a = new AdapterDataObservable();

        /* renamed from: b, reason: collision with root package name */
        public boolean f11564b = false;

        /* renamed from: c, reason: collision with root package name */
        public final StateRestorationPolicy f11565c = StateRestorationPolicy.f11566a;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        public static final class StateRestorationPolicy {

            /* renamed from: a, reason: collision with root package name */
            public static final StateRestorationPolicy f11566a;

            /* renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ StateRestorationPolicy[] f11567b;

            static {
                StateRestorationPolicy stateRestorationPolicy = new StateRestorationPolicy("ALLOW", 0);
                f11566a = stateRestorationPolicy;
                f11567b = new StateRestorationPolicy[]{stateRestorationPolicy, new StateRestorationPolicy("PREVENT_WHEN_EMPTY", 1), new StateRestorationPolicy("PREVENT", 2)};
            }

            public static StateRestorationPolicy valueOf(String str) {
                return (StateRestorationPolicy) Enum.valueOf(StateRestorationPolicy.class, str);
            }

            public static StateRestorationPolicy[] values() {
                return (StateRestorationPolicy[]) f11567b.clone();
            }
        }

        public int c(Adapter adapter, int i2) {
            if (adapter == this) {
                return i2;
            }
            return -1;
        }

        public abstract int d();

        public long e(int i2) {
            return -1L;
        }

        public int f(int i2) {
            return 0;
        }

        public final void g() {
            this.f11563a.b();
        }

        public final void h(int i2) {
            this.f11563a.d(i2, 1, null);
        }

        public final void i(int i2, Preference preference) {
            this.f11563a.d(i2, 1, preference);
        }

        public final void j(int i2) {
            this.f11563a.e(i2, 1);
        }

        public final void k(int i2, int i3) {
            this.f11563a.e(i2, i3);
        }

        public final void l(int i2, int i3) {
            this.f11563a.f(i2, i3);
        }

        public final void m(int i2) {
            this.f11563a.f(i2, 1);
        }

        public void n(RecyclerView recyclerView) {
        }

        public abstract void o(ViewHolder viewHolder, int i2);

        public abstract ViewHolder p(ViewGroup viewGroup, int i2);

        public void q(RecyclerView recyclerView) {
        }

        public boolean r(ViewHolder viewHolder) {
            return false;
        }

        public void s(ViewHolder viewHolder) {
        }

        public void u(ViewHolder viewHolder) {
        }

        public final void v(AdapterDataObserver adapterDataObserver) {
            this.f11563a.registerObserver(adapterDataObserver);
        }

        public final void w(boolean z) {
            if (this.f11563a.a()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.f11564b = z;
        }

        public final void x(AdapterDataObserver adapterDataObserver) {
            this.f11563a.unregisterObserver(adapterDataObserver);
        }

        public void t() {
        }
    }

    public static abstract class AdapterDataObserver {
        public void a() {
        }

        public void c(int i2, int i3, Object obj) {
            b();
        }

        public void d(int i2, int i3) {
        }

        public void f(int i2, int i3) {
        }

        public void b() {
        }

        public void e(int i2, int i3) {
        }
    }

    public static abstract class LayoutManager {

        /* renamed from: a, reason: collision with root package name */
        public ChildHelper f11577a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView f11578b;

        /* renamed from: c, reason: collision with root package name */
        public final ViewBoundsCheck f11579c;

        /* renamed from: d, reason: collision with root package name */
        public final ViewBoundsCheck f11580d;

        /* renamed from: e, reason: collision with root package name */
        public SmoothScroller f11581e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f11582f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f11583g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f11584h;

        /* renamed from: i, reason: collision with root package name */
        public final boolean f11585i;

        /* renamed from: j, reason: collision with root package name */
        public int f11586j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f11587k;

        /* renamed from: l, reason: collision with root package name */
        public int f11588l;

        /* renamed from: m, reason: collision with root package name */
        public int f11589m;
        public int n;
        public int o;

        public interface LayoutPrefetchRegistry {
        }

        public static class Properties {

            /* renamed from: a, reason: collision with root package name */
            public int f11592a;

            /* renamed from: b, reason: collision with root package name */
            public int f11593b;

            /* renamed from: c, reason: collision with root package name */
            public boolean f11594c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f11595d;
        }

        public LayoutManager() {
            ViewBoundsCheck.Callback callback = new ViewBoundsCheck.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.LayoutManager.1
                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final View a(int i2) {
                    return LayoutManager.this.u(i2);
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final int b(View view) {
                    return LayoutManager.A(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).leftMargin;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final int c() {
                    return LayoutManager.this.I();
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final int d() {
                    LayoutManager layoutManager = LayoutManager.this;
                    return layoutManager.n - layoutManager.J();
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final int e(View view) {
                    return LayoutManager.D(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).rightMargin;
                }
            };
            ViewBoundsCheck.Callback callback2 = new ViewBoundsCheck.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.LayoutManager.2
                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final View a(int i2) {
                    return LayoutManager.this.u(i2);
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final int b(View view) {
                    return LayoutManager.E(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).topMargin;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final int c() {
                    return LayoutManager.this.K();
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final int d() {
                    LayoutManager layoutManager = LayoutManager.this;
                    return layoutManager.o - layoutManager.H();
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public final int e(View view) {
                    return LayoutManager.y(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
                }
            };
            this.f11579c = new ViewBoundsCheck(callback);
            this.f11580d = new ViewBoundsCheck(callback2);
            this.f11582f = false;
            this.f11583g = false;
            this.f11584h = true;
            this.f11585i = true;
        }

        public static int A(View view) {
            return view.getLeft() - ((LayoutParams) view.getLayoutParams()).f11597b.left;
        }

        public static int B(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f11597b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public static int C(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f11597b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public static int D(View view) {
            return view.getRight() + ((LayoutParams) view.getLayoutParams()).f11597b.right;
        }

        public static int E(View view) {
            return view.getTop() - ((LayoutParams) view.getLayoutParams()).f11597b.top;
        }

        public static int L(View view) {
            return ((LayoutParams) view.getLayoutParams()).f11596a.b();
        }

        public static Properties M(Context context, AttributeSet attributeSet, int i2, int i3) {
            Properties properties = new Properties();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.recyclerview.R.styleable.RecyclerView, i2, i3);
            properties.f11592a = typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_orientation, 1);
            properties.f11593b = typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_spanCount, 1);
            properties.f11594c = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_reverseLayout, false);
            properties.f11595d = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_stackFromEnd, false);
            typedArrayObtainStyledAttributes.recycle();
            return properties;
        }

        public static boolean Q(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (i4 > 0 && i2 != i4) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i2;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i2;
            }
            return true;
        }

        public static void R(View view, int i2, int i3, int i4, int i5) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.f11597b;
            view.layout(i2 + rect.left + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i3 + rect.top + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (i4 - rect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (i5 - rect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        }

        public static int g(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i3, i4) : size : Math.min(size, Math.max(i3, i4));
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int w(boolean r4, int r5, int r6, int r7, int r8) {
            /*
                int r5 = r5 - r7
                r7 = 0
                int r5 = java.lang.Math.max(r7, r5)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r4 == 0) goto L1d
                if (r8 < 0) goto L12
            L10:
                r6 = r3
                goto L30
            L12:
                if (r8 != r1) goto L1a
                if (r6 == r2) goto L22
                if (r6 == 0) goto L1a
                if (r6 == r3) goto L22
            L1a:
                r6 = r7
                r8 = r6
                goto L30
            L1d:
                if (r8 < 0) goto L20
                goto L10
            L20:
                if (r8 != r1) goto L24
            L22:
                r8 = r5
                goto L30
            L24:
                if (r8 != r0) goto L1a
                if (r6 == r2) goto L2e
                if (r6 != r3) goto L2b
                goto L2e
            L2b:
                r8 = r5
                r6 = r7
                goto L30
            L2e:
                r8 = r5
                r6 = r2
            L30:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r6)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.w(boolean, int, int, int, int):int");
        }

        public static int y(View view) {
            return view.getBottom() + ((LayoutParams) view.getLayoutParams()).f11597b.bottom;
        }

        public final void A0(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f11578b = null;
                this.f11577a = null;
                this.n = 0;
                this.o = 0;
            } else {
                this.f11578b = recyclerView;
                this.f11577a = recyclerView.f11549f;
                this.n = recyclerView.getWidth();
                this.o = recyclerView.getHeight();
            }
            this.f11588l = 1073741824;
            this.f11589m = 1073741824;
        }

        public final boolean B0(View view, int i2, int i3, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.f11584h && Q(view.getWidth(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).width) && Q(view.getHeight(), i3, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
        }

        public boolean C0() {
            return false;
        }

        public final boolean D0(View view, int i2, int i3, LayoutParams layoutParams) {
            return (this.f11584h && Q(view.getMeasuredWidth(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).width) && Q(view.getMeasuredHeight(), i3, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
        }

        public void E0(int i2, RecyclerView recyclerView) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public final int F() {
            RecyclerView recyclerView = this.f11578b;
            Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.d();
            }
            return 0;
        }

        public final void F0(SmoothScroller smoothScroller) {
            SmoothScroller smoothScroller2 = this.f11581e;
            if (smoothScroller2 != null && smoothScroller != smoothScroller2 && smoothScroller2.f11622e) {
                smoothScroller2.f();
            }
            this.f11581e = smoothScroller;
            RecyclerView recyclerView = this.f11578b;
            ViewFlinger viewFlinger = recyclerView.O0;
            RecyclerView.this.removeCallbacks(viewFlinger);
            viewFlinger.f11648c.abortAnimation();
            if (smoothScroller.f11625h) {
                Log.w("RecyclerView", "An instance of " + smoothScroller.getClass().getSimpleName() + " was started more than once. Each instance of" + smoothScroller.getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            smoothScroller.f11619b = recyclerView;
            smoothScroller.f11620c = this;
            int i2 = smoothScroller.f11618a;
            if (i2 == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.R0.f11633a = i2;
            smoothScroller.f11622e = true;
            smoothScroller.f11621d = true;
            smoothScroller.f11623f = recyclerView.n.q(i2);
            smoothScroller.f11619b.O0.b();
            smoothScroller.f11625h = true;
        }

        public final int G() {
            RecyclerView recyclerView = this.f11578b;
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            return recyclerView.getLayoutDirection();
        }

        public boolean G0() {
            return false;
        }

        public final int H() {
            RecyclerView recyclerView = this.f11578b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public final int I() {
            RecyclerView recyclerView = this.f11578b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public final int J() {
            RecyclerView recyclerView = this.f11578b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public final int K() {
            RecyclerView recyclerView = this.f11578b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int N(Recycler recycler, State state) {
            return -1;
        }

        public final void O(Rect rect, View view) {
            Matrix matrix;
            Rect rect2 = ((LayoutParams) view.getLayoutParams()).f11597b;
            rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            if (this.f11578b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f11578b.f11555l;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public boolean P() {
            return false;
        }

        public void S(int i2) {
            RecyclerView recyclerView = this.f11578b;
            if (recyclerView != null) {
                int iC = recyclerView.f11549f.c();
                for (int i3 = 0; i3 < iC; i3++) {
                    recyclerView.f11549f.b(i3).offsetLeftAndRight(i2);
                }
            }
        }

        public void T(int i2) {
            RecyclerView recyclerView = this.f11578b;
            if (recyclerView != null) {
                int iC = recyclerView.f11549f.c();
                for (int i3 = 0; i3 < iC; i3++) {
                    recyclerView.f11549f.b(i3).offsetTopAndBottom(i2);
                }
            }
        }

        public void V(RecyclerView recyclerView) {
        }

        public View X(View view, int i2, Recycler recycler, State state) {
            return null;
        }

        public void Y(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f11578b;
            Recycler recycler = recyclerView.f11546c;
            if (accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.f11578b.canScrollVertically(-1) && !this.f11578b.canScrollHorizontally(-1) && !this.f11578b.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            Adapter adapter = this.f11578b.f11556m;
            if (adapter != null) {
                accessibilityEvent.setItemCount(adapter.d());
            }
        }

        public void Z(Recycler recycler, State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.f11578b.canScrollVertically(-1) || this.f11578b.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.a(KEYRecord.Flags.FLAG2);
                accessibilityNodeInfoCompat.u(true);
            }
            if (this.f11578b.canScrollVertically(1) || this.f11578b.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.a(4096);
                accessibilityNodeInfoCompat.u(true);
            }
            accessibilityNodeInfoCompat.o(AccessibilityNodeInfoCompat.CollectionInfoCompat.a(N(recycler, state), x(recycler, state), 0));
        }

        public final void a0(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder viewHolderN = RecyclerView.N(view);
            if (viewHolderN == null || viewHolderN.h() || this.f11577a.f11377c.contains(viewHolderN.f11653a)) {
                return;
            }
            RecyclerView recyclerView = this.f11578b;
            b0(recyclerView.f11546c, recyclerView.R0, view, accessibilityNodeInfoCompat);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0076  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0151  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void b(int r11, android.view.View r12, boolean r13) {
            /*
                Method dump skipped, instructions count: 531
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.b(int, android.view.View, boolean):void");
        }

        public void b0(Recycler recycler, State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        public void c(String str) {
            RecyclerView recyclerView = this.f11578b;
            if (recyclerView != null) {
                recyclerView.l(str);
            }
        }

        public boolean d() {
            return false;
        }

        public boolean e() {
            return false;
        }

        public boolean f(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public void h(int i2, int i3, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public void h0(Recycler recycler, State state) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void i(int i2, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public void i0(State state) {
        }

        public int j(State state) {
            return 0;
        }

        public void j0(Parcelable parcelable) {
        }

        public int k(State state) {
            return 0;
        }

        public Parcelable k0() {
            return null;
        }

        public int l(State state) {
            return 0;
        }

        public void l0(int i2) {
        }

        public int m(State state) {
            return 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0062 A[PHI: r3
          0x0062: PHI (r3v8 int) = (r3v5 int), (r3v11 int) binds: [B:28:0x007e, B:20:0x0054] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean m0(androidx.recyclerview.widget.RecyclerView.Recycler r3, androidx.recyclerview.widget.RecyclerView.State r4, int r5, android.os.Bundle r6) {
            /*
                r2 = this;
                androidx.recyclerview.widget.RecyclerView r3 = r2.f11578b
                r4 = 0
                if (r3 != 0) goto L7
                goto L8f
            L7:
                int r3 = r2.o
                int r6 = r2.n
                android.graphics.Rect r0 = new android.graphics.Rect
                r0.<init>()
                androidx.recyclerview.widget.RecyclerView r1 = r2.f11578b
                android.graphics.Matrix r1 = r1.getMatrix()
                boolean r1 = r1.isIdentity()
                if (r1 == 0) goto L2c
                androidx.recyclerview.widget.RecyclerView r1 = r2.f11578b
                boolean r1 = r1.getGlobalVisibleRect(r0)
                if (r1 == 0) goto L2c
                int r3 = r0.height()
                int r6 = r0.width()
            L2c:
                r0 = 4096(0x1000, float:5.74E-42)
                r1 = 1
                if (r5 == r0) goto L64
                r0 = 8192(0x2000, float:1.14794E-41)
                if (r5 == r0) goto L38
                r3 = r4
                r5 = r3
                goto L8b
            L38:
                androidx.recyclerview.widget.RecyclerView r5 = r2.f11578b
                r0 = -1
                boolean r5 = r5.canScrollVertically(r0)
                if (r5 == 0) goto L4d
                int r5 = r2.K()
                int r3 = r3 - r5
                int r5 = r2.H()
                int r3 = r3 - r5
                int r3 = -r3
                goto L4e
            L4d:
                r3 = r4
            L4e:
                androidx.recyclerview.widget.RecyclerView r5 = r2.f11578b
                boolean r5 = r5.canScrollHorizontally(r0)
                if (r5 == 0) goto L62
                int r5 = r2.I()
                int r6 = r6 - r5
                int r5 = r2.J()
                int r6 = r6 - r5
                int r5 = -r6
                goto L8b
            L62:
                r5 = r4
                goto L8b
            L64:
                androidx.recyclerview.widget.RecyclerView r5 = r2.f11578b
                boolean r5 = r5.canScrollVertically(r1)
                if (r5 == 0) goto L77
                int r5 = r2.K()
                int r3 = r3 - r5
                int r5 = r2.H()
                int r3 = r3 - r5
                goto L78
            L77:
                r3 = r4
            L78:
                androidx.recyclerview.widget.RecyclerView r5 = r2.f11578b
                boolean r5 = r5.canScrollHorizontally(r1)
                if (r5 == 0) goto L62
                int r5 = r2.I()
                int r6 = r6 - r5
                int r5 = r2.J()
                int r5 = r6 - r5
            L8b:
                if (r3 != 0) goto L90
                if (r5 != 0) goto L90
            L8f:
                return r4
            L90:
                androidx.recyclerview.widget.RecyclerView r4 = r2.f11578b
                r4.l0(r5, r3, r1)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.m0(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, int, android.os.Bundle):boolean");
        }

        public int n(State state) {
            return 0;
        }

        public final void n0(Recycler recycler) {
            for (int iV = v() - 1; iV >= 0; iV--) {
                if (!RecyclerView.N(u(iV)).o()) {
                    View viewU = u(iV);
                    q0(iV);
                    recycler.h(viewU);
                }
            }
        }

        public int o(State state) {
            return 0;
        }

        public final void o0(Recycler recycler) {
            ArrayList arrayList;
            int size = recycler.f11607a.size();
            int i2 = size - 1;
            while (true) {
                arrayList = recycler.f11607a;
                if (i2 < 0) {
                    break;
                }
                View view = ((ViewHolder) arrayList.get(i2)).f11653a;
                ViewHolder viewHolderN = RecyclerView.N(view);
                if (!viewHolderN.o()) {
                    viewHolderN.n(false);
                    if (viewHolderN.j()) {
                        this.f11578b.removeDetachedView(view, false);
                    }
                    ItemAnimator itemAnimator = this.f11578b.Q;
                    if (itemAnimator != null) {
                        itemAnimator.i(viewHolderN);
                    }
                    viewHolderN.n(true);
                    ViewHolder viewHolderN2 = RecyclerView.N(view);
                    viewHolderN2.n = null;
                    viewHolderN2.o = false;
                    viewHolderN2.f11662j &= -33;
                    recycler.i(viewHolderN2);
                }
                i2--;
            }
            arrayList.clear();
            ArrayList arrayList2 = recycler.f11608b;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            if (size > 0) {
                this.f11578b.invalidate();
            }
        }

        public final void p(Recycler recycler) {
            for (int iV = v() - 1; iV >= 0; iV--) {
                View viewU = u(iV);
                ViewHolder viewHolderN = RecyclerView.N(viewU);
                if (viewHolderN.o()) {
                    if (RecyclerView.m1) {
                        Log.d("RecyclerView", "ignoring view " + viewHolderN);
                    }
                } else if (!viewHolderN.f() || viewHolderN.h() || this.f11578b.f11556m.f11564b) {
                    u(iV);
                    ChildHelper childHelper = this.f11577a;
                    int iD = childHelper.d(iV);
                    childHelper.f11376b.f(iD);
                    RecyclerView recyclerView = RecyclerView.this;
                    View childAt = recyclerView.getChildAt(iD);
                    if (childAt != null) {
                        ViewHolder viewHolderN2 = RecyclerView.N(childAt);
                        if (viewHolderN2 != null) {
                            if (viewHolderN2.j() && !viewHolderN2.o()) {
                                StringBuilder sb = new StringBuilder("called detach on an already detached child ");
                                sb.append(viewHolderN2);
                                throw new IllegalArgumentException(a.m(recyclerView, sb));
                            }
                            if (RecyclerView.m1) {
                                Log.d("RecyclerView", "tmpDetach " + viewHolderN2);
                            }
                            viewHolderN2.a(256);
                        }
                    } else if (RecyclerView.l1) {
                        StringBuilder sb2 = new StringBuilder("No view at offset ");
                        sb2.append(iD);
                        throw new IllegalArgumentException(a.m(recyclerView, sb2));
                    }
                    recyclerView.detachViewFromParent(iD);
                    recycler.j(viewU);
                    this.f11578b.f11550g.c(viewHolderN);
                } else {
                    q0(iV);
                    recycler.i(viewHolderN);
                }
            }
        }

        public final void p0(View view, Recycler recycler) {
            ChildHelper childHelper = this.f11577a;
            AnonymousClass5 anonymousClass5 = childHelper.f11375a;
            int iIndexOfChild = RecyclerView.this.indexOfChild(view);
            if (iIndexOfChild >= 0) {
                if (childHelper.f11376b.f(iIndexOfChild)) {
                    childHelper.e(view);
                }
                anonymousClass5.b(iIndexOfChild);
            }
            recycler.h(view);
        }

        public View q(int i2) {
            int iV = v();
            for (int i3 = 0; i3 < iV; i3++) {
                View viewU = u(i3);
                ViewHolder viewHolderN = RecyclerView.N(viewU);
                if (viewHolderN != null && viewHolderN.b() == i2 && !viewHolderN.o() && (this.f11578b.R0.f11639g || !viewHolderN.h())) {
                    return viewU;
                }
            }
            return null;
        }

        public final void q0(int i2) {
            if (u(i2) != null) {
                ChildHelper childHelper = this.f11577a;
                int iD = childHelper.d(i2);
                AnonymousClass5 anonymousClass5 = childHelper.f11375a;
                View childAt = RecyclerView.this.getChildAt(iD);
                if (childAt == null) {
                    return;
                }
                if (childHelper.f11376b.f(iD)) {
                    childHelper.e(childAt);
                }
                anonymousClass5.b(iD);
            }
        }

        public abstract LayoutParams r();

        /* JADX WARN: Removed duplicated region for block: B:28:0x00ae  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean r0(androidx.recyclerview.widget.RecyclerView r9, android.view.View r10, android.graphics.Rect r11, boolean r12, boolean r13) {
            /*
                r8 = this;
                int r0 = r8.I()
                int r1 = r8.K()
                int r2 = r8.n
                int r3 = r8.J()
                int r2 = r2 - r3
                int r3 = r8.o
                int r4 = r8.H()
                int r3 = r3 - r4
                int r4 = r10.getLeft()
                int r5 = r11.left
                int r4 = r4 + r5
                int r5 = r10.getScrollX()
                int r4 = r4 - r5
                int r5 = r10.getTop()
                int r6 = r11.top
                int r5 = r5 + r6
                int r10 = r10.getScrollY()
                int r5 = r5 - r10
                int r10 = r11.width()
                int r10 = r10 + r4
                int r11 = r11.height()
                int r11 = r11 + r5
                int r4 = r4 - r0
                r0 = 0
                int r6 = java.lang.Math.min(r0, r4)
                int r5 = r5 - r1
                int r1 = java.lang.Math.min(r0, r5)
                int r10 = r10 - r2
                int r2 = java.lang.Math.max(r0, r10)
                int r11 = r11 - r3
                int r11 = java.lang.Math.max(r0, r11)
                int r3 = r8.G()
                r7 = 1
                if (r3 != r7) goto L5c
                if (r2 == 0) goto L57
                goto L64
            L57:
                int r2 = java.lang.Math.max(r6, r10)
                goto L64
            L5c:
                if (r6 == 0) goto L5f
                goto L63
            L5f:
                int r6 = java.lang.Math.min(r4, r2)
            L63:
                r2 = r6
            L64:
                if (r1 == 0) goto L67
                goto L6b
            L67:
                int r1 = java.lang.Math.min(r5, r11)
            L6b:
                int[] r10 = new int[]{r2, r1}
                r11 = r10[r0]
                r10 = r10[r7]
                if (r13 == 0) goto Lae
                android.view.View r13 = r9.getFocusedChild()
                if (r13 != 0) goto L7c
                goto Lb3
            L7c:
                int r1 = r8.I()
                int r2 = r8.K()
                int r3 = r8.n
                int r4 = r8.J()
                int r3 = r3 - r4
                int r4 = r8.o
                int r5 = r8.H()
                int r4 = r4 - r5
                androidx.recyclerview.widget.RecyclerView r5 = r8.f11578b
                android.graphics.Rect r5 = r5.f11553j
                r8.z(r5, r13)
                int r13 = r5.left
                int r13 = r13 - r11
                if (r13 >= r3) goto Lb3
                int r13 = r5.right
                int r13 = r13 - r11
                if (r13 <= r1) goto Lb3
                int r13 = r5.top
                int r13 = r13 - r10
                if (r13 >= r4) goto Lb3
                int r13 = r5.bottom
                int r13 = r13 - r10
                if (r13 > r2) goto Lae
                goto Lb3
            Lae:
                if (r11 != 0) goto Lb4
                if (r10 == 0) goto Lb3
                goto Lb4
            Lb3:
                return r0
            Lb4:
                if (r12 == 0) goto Lba
                r9.scrollBy(r11, r10)
                return r7
            Lba:
                r9.l0(r11, r10, r0)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.r0(androidx.recyclerview.widget.RecyclerView, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
        }

        public LayoutParams s(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public final void s0() {
            RecyclerView recyclerView = this.f11578b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public LayoutParams t(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
        }

        public int t0(int i2, Recycler recycler, State state) {
            return 0;
        }

        public final View u(int i2) {
            ChildHelper childHelper = this.f11577a;
            if (childHelper != null) {
                return childHelper.b(i2);
            }
            return null;
        }

        public void u0(int i2) {
            if (RecyclerView.m1) {
                Log.e("RecyclerView", "You MUST implement scrollToPosition. It will soon become abstract");
            }
        }

        public final int v() {
            ChildHelper childHelper = this.f11577a;
            if (childHelper != null) {
                return childHelper.c();
            }
            return 0;
        }

        public int v0(int i2, Recycler recycler, State state) {
            return 0;
        }

        public final void w0(RecyclerView recyclerView) {
            x0(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public int x(Recycler recycler, State state) {
            return -1;
        }

        public final void x0(int i2, int i3) {
            this.n = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            this.f11588l = mode;
            if (mode == 0 && !RecyclerView.p1) {
                this.n = 0;
            }
            this.o = View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.f11589m = mode2;
            if (mode2 != 0 || RecyclerView.p1) {
                return;
            }
            this.o = 0;
        }

        public void y0(Rect rect, int i2, int i3) {
            int iJ = J() + I() + rect.width();
            int iH = H() + K() + rect.height();
            RecyclerView recyclerView = this.f11578b;
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            this.f11578b.setMeasuredDimension(g(i2, iJ, recyclerView.getMinimumWidth()), g(i3, iH, this.f11578b.getMinimumHeight()));
        }

        public void z(Rect rect, View view) {
            RecyclerView.O(rect, view);
        }

        public final void z0(int i2, int i3) {
            int iV = v();
            if (iV == 0) {
                this.f11578b.r(i2, i3);
                return;
            }
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MAX_VALUE;
            for (int i8 = 0; i8 < iV; i8++) {
                View viewU = u(i8);
                Rect rect = this.f11578b.f11553j;
                z(rect, viewU);
                int i9 = rect.left;
                if (i9 < i7) {
                    i7 = i9;
                }
                int i10 = rect.right;
                if (i10 > i4) {
                    i4 = i10;
                }
                int i11 = rect.top;
                if (i11 < i5) {
                    i5 = i11;
                }
                int i12 = rect.bottom;
                if (i12 > i6) {
                    i6 = i12;
                }
            }
            this.f11578b.f11553j.set(i7, i5, i4, i6);
            y0(this.f11578b.f11553j, i2, i3);
        }

        public void U() {
        }

        public void d0() {
        }

        public void W(RecyclerView recyclerView) {
        }

        public void c0(int i2, int i3) {
        }

        public void e0(int i2, int i3) {
        }

        public void f0(int i2, int i3) {
        }

        public void g0(int i2, int i3) {
        }
    }

    public static class SimpleOnItemTouchListener implements OnItemTouchListener {
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public final void d(boolean z) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public final boolean e(MotionEvent motionEvent) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public final void a(MotionEvent motionEvent) {
        }
    }

    public static abstract class ItemDecoration {
        public void f(Rect rect, View view, RecyclerView recyclerView) {
            ((LayoutParams) view.getLayoutParams()).f11596a.getClass();
            rect.set(0, 0, 0, 0);
        }

        public void g(Canvas canvas, RecyclerView recyclerView) {
        }

        public void h(Canvas canvas, RecyclerView recyclerView) {
        }
    }

    public static abstract class OnScrollListener {
        public void b(RecyclerView recyclerView, int i2, int i3) {
        }

        public void a(int i2, RecyclerView recyclerView) {
        }
    }
}
