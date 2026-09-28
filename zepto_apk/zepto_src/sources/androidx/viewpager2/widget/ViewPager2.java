package androidx.viewpager2.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.StatefulAdapter;
import com.facebook.react.uimanager.ThemedReactContext;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.xbill.DNS.KEYRecord;

/* loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f12394a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f12395b;

    /* renamed from: c, reason: collision with root package name */
    public final CompositeOnPageChangeCallback f12396c;

    /* renamed from: d, reason: collision with root package name */
    public int f12397d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f12398e;

    /* renamed from: f, reason: collision with root package name */
    public final RecyclerView.AdapterDataObserver f12399f;

    /* renamed from: g, reason: collision with root package name */
    public LinearLayoutManager f12400g;

    /* renamed from: h, reason: collision with root package name */
    public int f12401h;

    /* renamed from: i, reason: collision with root package name */
    public Parcelable f12402i;

    /* renamed from: j, reason: collision with root package name */
    public RecyclerView f12403j;

    /* renamed from: k, reason: collision with root package name */
    public PagerSnapHelper f12404k;

    /* renamed from: l, reason: collision with root package name */
    public ScrollEventAdapter f12405l;

    /* renamed from: m, reason: collision with root package name */
    public CompositeOnPageChangeCallback f12406m;
    public FakeDrag n;
    public PageTransformerAdapter o;
    public RecyclerView.ItemAnimator p;
    public boolean q;
    public boolean r;
    public int s;
    public PageAwareAccessibilityProvider t;

    /* loaded from: classes3.dex */
    public abstract class AccessibilityProvider {
        public boolean a() {
            return this instanceof PageAwareAccessibilityProvider;
        }
    }

    /* loaded from: classes3.dex */
    public class BasicAccessibilityProvider extends AccessibilityProvider {
    }

    /* loaded from: classes3.dex */
    public static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void a();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void b() {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void c(int i2, int i3, Object obj) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void d(int i2, int i3) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void e(int i2, int i3) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void f(int i2, int i3) {
            a();
        }
    }

    /* loaded from: classes3.dex */
    public class LinearLayoutManagerImpl extends LinearLayoutManager {
        public LinearLayoutManagerImpl() {
            super(1);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public final void H0(RecyclerView.State state, int[] iArr) {
            ViewPager2 viewPager2 = ViewPager2.this;
            int offscreenPageLimit = viewPager2.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.H0(state, iArr);
                return;
            }
            int pageSize = viewPager2.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public final void Z(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.Z(recycler, state, accessibilityNodeInfoCompat);
            ViewPager2.this.t.getClass();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public final void b0(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int iL;
            ViewPager2 viewPager2 = ViewPager2.this;
            int iL2 = 0;
            if (viewPager2.getOrientation() == 1) {
                viewPager2.f12400g.getClass();
                iL = RecyclerView.LayoutManager.L(view);
            } else {
                iL = 0;
            }
            if (viewPager2.getOrientation() == 0) {
                viewPager2.f12400g.getClass();
                iL2 = RecyclerView.LayoutManager.L(view);
            }
            accessibilityNodeInfoCompat.p(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(iL, 1, iL2, 1, false, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public final boolean m0(RecyclerView.Recycler recycler, RecyclerView.State state, int i2, Bundle bundle) {
            ViewPager2.this.t.getClass();
            return super.m0(recycler, state, i2, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public final boolean r0(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            return false;
        }
    }

    @IntRange
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes3.dex */
    public @interface OffscreenPageLimit {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes3.dex */
    public @interface Orientation {
    }

    /* loaded from: classes3.dex */
    public class PageAwareAccessibilityProvider extends AccessibilityProvider {

        /* renamed from: a, reason: collision with root package name */
        public final AccessibilityViewCommand f12410a = new AccessibilityViewCommand() { // from class: androidx.viewpager2.widget.ViewPager2.PageAwareAccessibilityProvider.1
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public final boolean c(View view) {
                int currentItem = ((ViewPager2) view).getCurrentItem() + 1;
                ViewPager2 viewPager2 = ViewPager2.this;
                if (viewPager2.r) {
                    viewPager2.e(currentItem, true);
                }
                return true;
            }
        };

        /* renamed from: b, reason: collision with root package name */
        public final AccessibilityViewCommand f12411b = new AccessibilityViewCommand() { // from class: androidx.viewpager2.widget.ViewPager2.PageAwareAccessibilityProvider.2
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public final boolean c(View view) {
                int currentItem = ((ViewPager2) view).getCurrentItem() - 1;
                ViewPager2 viewPager2 = ViewPager2.this;
                if (viewPager2.r) {
                    viewPager2.e(currentItem, true);
                }
                return true;
            }
        };

        /* renamed from: c, reason: collision with root package name */
        public RecyclerView.AdapterDataObserver f12412c;

        public PageAwareAccessibilityProvider() {
        }

        public final boolean b(int i2) {
            return i2 == 8192 || i2 == 4096;
        }

        public final void c(RecyclerView.Adapter adapter) {
            m();
            if (adapter != null) {
                adapter.v(this.f12412c);
            }
        }

        public final void d(RecyclerView.Adapter adapter) {
            if (adapter != null) {
                adapter.x(this.f12412c);
            }
        }

        public final void e(RecyclerView recyclerView) {
            recyclerView.setImportantForAccessibility(2);
            this.f12412c = new DataSetChangeObserver() { // from class: androidx.viewpager2.widget.ViewPager2.PageAwareAccessibilityProvider.3
                @Override // androidx.viewpager2.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public final void a() {
                    PageAwareAccessibilityProvider.this.m();
                }
            };
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.getImportantForAccessibility() == 0) {
                viewPager2.setImportantForAccessibility(1);
            }
        }

        public final void f(AccessibilityNodeInfo accessibilityNodeInfo) {
            int iD;
            int iD2;
            int iD3;
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.getAdapter() == null) {
                iD = 0;
                iD2 = 0;
            } else if (viewPager2.getOrientation() == 1) {
                iD = viewPager2.getAdapter().d();
                iD2 = 1;
            } else {
                iD2 = viewPager2.getAdapter().d();
                iD = 1;
            }
            accessibilityNodeInfoCompat.o(AccessibilityNodeInfoCompat.CollectionInfoCompat.a(iD, iD2, 0));
            RecyclerView.Adapter adapter = viewPager2.getAdapter();
            if (adapter == null || (iD3 = adapter.d()) == 0 || !viewPager2.r) {
                return;
            }
            if (viewPager2.f12397d > 0) {
                accessibilityNodeInfoCompat.a(KEYRecord.Flags.FLAG2);
            }
            if (viewPager2.f12397d < iD3 - 1) {
                accessibilityNodeInfoCompat.a(4096);
            }
            accessibilityNodeInfoCompat.u(true);
        }

        public final void g(int i2, Bundle bundle) {
            if (!b(i2)) {
                throw new IllegalStateException();
            }
            ViewPager2 viewPager2 = ViewPager2.this;
            int currentItem = i2 == 8192 ? viewPager2.getCurrentItem() - 1 : viewPager2.getCurrentItem() + 1;
            if (viewPager2.r) {
                viewPager2.e(currentItem, true);
            }
        }

        public final void h() {
            m();
        }

        public final void i() {
            m();
        }

        public final void j() {
            m();
        }

        public final void k() {
            m();
        }

        public final void l() {
            m();
        }

        public final void m() {
            int iD;
            int i2 = R.id.accessibilityActionPageLeft;
            ViewPager2 viewPager2 = ViewPager2.this;
            ViewCompat.v(R.id.accessibilityActionPageLeft, viewPager2);
            ViewCompat.s(0, viewPager2);
            ViewCompat.v(R.id.accessibilityActionPageRight, viewPager2);
            ViewCompat.s(0, viewPager2);
            ViewCompat.v(R.id.accessibilityActionPageUp, viewPager2);
            ViewCompat.s(0, viewPager2);
            ViewCompat.v(R.id.accessibilityActionPageDown, viewPager2);
            ViewCompat.s(0, viewPager2);
            if (viewPager2.getAdapter() == null || (iD = viewPager2.getAdapter().d()) == 0 || !viewPager2.r) {
                return;
            }
            int orientation = viewPager2.getOrientation();
            AccessibilityViewCommand accessibilityViewCommand = this.f12411b;
            AccessibilityViewCommand accessibilityViewCommand2 = this.f12410a;
            if (orientation != 0) {
                if (viewPager2.f12397d < iD - 1) {
                    ViewCompat.w(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionPageDown, (String) null), null, accessibilityViewCommand2);
                }
                if (viewPager2.f12397d > 0) {
                    ViewCompat.w(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.accessibilityActionPageUp, (String) null), null, accessibilityViewCommand);
                    return;
                }
                return;
            }
            boolean z = viewPager2.f12400g.G() == 1;
            int i3 = z ? 16908360 : 16908361;
            if (z) {
                i2 = 16908361;
            }
            if (viewPager2.f12397d < iD - 1) {
                ViewCompat.w(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i3, (String) null), null, accessibilityViewCommand2);
            }
            if (viewPager2.f12397d > 0) {
                ViewCompat.w(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i2, (String) null), null, accessibilityViewCommand);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface PageTransformer {
        void a(View view, float f2);
    }

    /* loaded from: classes3.dex */
    public class PagerSnapHelperImpl extends PagerSnapHelper {
        public PagerSnapHelperImpl() {
        }

        @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        public final View e(RecyclerView.LayoutManager layoutManager) {
            ViewPager2.this.n.getClass();
            return super.e(layoutManager);
        }
    }

    /* loaded from: classes3.dex */
    public class RecyclerViewImpl extends RecyclerView {
        public RecyclerViewImpl(Context context) {
            super(context, null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public final CharSequence getAccessibilityClassName() {
            ViewPager2.this.t.getClass();
            return super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            ViewPager2 viewPager2 = ViewPager2.this;
            accessibilityEvent.setFromIndex(viewPager2.f12397d);
            accessibilityEvent.setToIndex(viewPager2.f12397d);
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName("androidx.viewpager.widget.ViewPager");
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.r && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.r && super.onTouchEvent(motionEvent);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes3.dex */
    public @interface ScrollState {
    }

    /* loaded from: classes3.dex */
    public static class SmoothScrollToPosition implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final int f12421a;

        /* renamed from: b, reason: collision with root package name */
        public final RecyclerView f12422b;

        public SmoothScrollToPosition(int i2, RecyclerView recyclerView) {
            this.f12421a = i2;
            this.f12422b = recyclerView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f12422b.m0(this.f12421a);
        }
    }

    public ViewPager2(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        this.f12394a = new Rect();
        this.f12395b = new Rect();
        this.f12396c = new CompositeOnPageChangeCallback();
        this.f12398e = false;
        this.f12399f = new DataSetChangeObserver() { // from class: androidx.viewpager2.widget.ViewPager2.1
            @Override // androidx.viewpager2.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public final void a() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f12398e = true;
                viewPager2.f12405l.f12390l = true;
            }
        };
        this.f12401h = -1;
        this.p = null;
        this.q = false;
        this.r = true;
        this.s = -1;
        a(themedReactContext, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        this.t = new PageAwareAccessibilityProvider();
        RecyclerViewImpl recyclerViewImpl = new RecyclerViewImpl(context);
        this.f12403j = recyclerViewImpl;
        recyclerViewImpl.setId(View.generateViewId());
        this.f12403j.setDescendantFocusability(131072);
        LinearLayoutManagerImpl linearLayoutManagerImpl = new LinearLayoutManagerImpl();
        this.f12400g = linearLayoutManagerImpl;
        this.f12403j.setLayoutManager(linearLayoutManagerImpl);
        this.f12403j.setScrollingTouchSlop(1);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.viewpager2.R.styleable.ViewPager2);
        ViewCompat.y(this, context, androidx.viewpager2.R.styleable.ViewPager2, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        try {
            setOrientation(typedArrayObtainStyledAttributes.getInt(androidx.viewpager2.R.styleable.ViewPager2_android_orientation, 0));
            typedArrayObtainStyledAttributes.recycle();
            this.f12403j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.f12403j.j(new RecyclerView.OnChildAttachStateChangeListener() { // from class: androidx.viewpager2.widget.ViewPager2.4
                @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
                public final void b(View view) {
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
                public final void c(View view) {
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                    if (((ViewGroup.MarginLayoutParams) layoutParams).width != -1 || ((ViewGroup.MarginLayoutParams) layoutParams).height != -1) {
                        throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                    }
                }
            });
            ScrollEventAdapter scrollEventAdapter = new ScrollEventAdapter(this);
            this.f12405l = scrollEventAdapter;
            this.n = new FakeDrag(scrollEventAdapter);
            PagerSnapHelperImpl pagerSnapHelperImpl = new PagerSnapHelperImpl();
            this.f12404k = pagerSnapHelperImpl;
            pagerSnapHelperImpl.b(this.f12403j);
            this.f12403j.k(this.f12405l);
            CompositeOnPageChangeCallback compositeOnPageChangeCallback = new CompositeOnPageChangeCallback();
            this.f12406m = compositeOnPageChangeCallback;
            this.f12405l.j(compositeOnPageChangeCallback);
            OnPageChangeCallback onPageChangeCallback = new OnPageChangeCallback() { // from class: androidx.viewpager2.widget.ViewPager2.2
                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public final void a(int i2) {
                    if (i2 == 0) {
                        ViewPager2.this.g();
                    }
                }

                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public final void c(int i2) {
                    ViewPager2 viewPager2 = ViewPager2.this;
                    if (viewPager2.f12397d != i2) {
                        viewPager2.f12397d = i2;
                        viewPager2.t.m();
                    }
                }
            };
            OnPageChangeCallback onPageChangeCallback2 = new OnPageChangeCallback() { // from class: androidx.viewpager2.widget.ViewPager2.3
                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public final void c(int i2) {
                    ViewPager2 viewPager2 = ViewPager2.this;
                    viewPager2.clearFocus();
                    if (viewPager2.hasFocus()) {
                        viewPager2.f12403j.requestFocus(2);
                    }
                }
            };
            this.f12406m.d(onPageChangeCallback);
            this.f12406m.d(onPageChangeCallback2);
            this.t.e(this.f12403j);
            this.f12406m.d(this.f12396c);
            PageTransformerAdapter pageTransformerAdapter = new PageTransformerAdapter(this.f12400g);
            this.o = pageTransformerAdapter;
            this.f12406m.d(pageTransformerAdapter);
            RecyclerView recyclerView = this.f12403j;
            attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void b(OnPageChangeCallback onPageChangeCallback) {
        this.f12396c.d(onPageChangeCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        RecyclerView.Adapter adapter;
        if (this.f12401h == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        if (this.f12402i != null) {
            if (adapter instanceof StatefulAdapter) {
                ((StatefulAdapter) adapter).b();
                throw null;
            }
            this.f12402i = null;
        }
        int iMax = Math.max(0, Math.min(this.f12401h, adapter.d() - 1));
        this.f12397d = iMax;
        this.f12401h = -1;
        this.f12403j.j0(iMax);
        this.t.h();
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i2) {
        return this.f12403j.canScrollHorizontally(i2);
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int i2) {
        return this.f12403j.canScrollVertically(i2);
    }

    public final void d(int i2, boolean z) {
        this.n.getClass();
        e(i2, z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        Parcelable parcelable = (Parcelable) sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i2 = ((SavedState) parcelable).f12418a;
            sparseArray.put(this.f12403j.getId(), (Parcelable) sparseArray.get(i2));
            sparseArray.remove(i2);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        c();
    }

    public final void e(int i2, boolean z) {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.f12401h != -1) {
                this.f12401h = Math.max(i2, 0);
                return;
            }
            return;
        }
        if (adapter.d() <= 0) {
            return;
        }
        int iMin = Math.min(Math.max(i2, 0), adapter.d() - 1);
        if (iMin == this.f12397d && this.f12405l.g()) {
            return;
        }
        int i3 = this.f12397d;
        if (iMin == i3 && z) {
            return;
        }
        double dE = i3;
        this.f12397d = iMin;
        this.t.j();
        if (!this.f12405l.g()) {
            dE = this.f12405l.e();
        }
        this.f12405l.h(iMin, z);
        if (!z) {
            this.f12403j.j0(iMin);
            return;
        }
        double d2 = iMin;
        if (Math.abs(d2 - dE) <= 3.0d) {
            this.f12403j.m0(iMin);
            return;
        }
        this.f12403j.j0(d2 > dE ? iMin - 3 : iMin + 3);
        RecyclerView recyclerView = this.f12403j;
        recyclerView.post(new SmoothScrollToPosition(iMin, recyclerView));
    }

    public final void f(OnPageChangeCallback onPageChangeCallback) {
        this.f12396c.e(onPageChangeCallback);
    }

    public final void g() {
        PagerSnapHelper pagerSnapHelper = this.f12404k;
        if (pagerSnapHelper == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View viewE = pagerSnapHelper.e(this.f12400g);
        if (viewE == null) {
            return;
        }
        this.f12400g.getClass();
        int iL = RecyclerView.LayoutManager.L(viewE);
        if (iL != this.f12397d && getScrollState() == 0) {
            this.f12406m.c(iL);
        }
        this.f12398e = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    @RequiresApi
    public CharSequence getAccessibilityClassName() {
        if (!this.t.a()) {
            return super.getAccessibilityClassName();
        }
        this.t.getClass();
        return "androidx.viewpager.widget.ViewPager";
    }

    @Nullable
    public RecyclerView.Adapter getAdapter() {
        return this.f12403j.getAdapter();
    }

    public int getCurrentItem() {
        return this.f12397d;
    }

    public int getItemDecorationCount() {
        return this.f12403j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.s;
    }

    public int getOrientation() {
        return this.f12400g.a1() == 1 ? 1 : 0;
    }

    public int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.f12403j;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.f12405l.f();
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.t.f(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = this.f12403j.getMeasuredWidth();
        int measuredHeight = this.f12403j.getMeasuredHeight();
        int paddingLeft = getPaddingLeft();
        Rect rect = this.f12394a;
        rect.left = paddingLeft;
        rect.right = (i4 - i2) - getPaddingRight();
        rect.top = getPaddingTop();
        rect.bottom = (i5 - i3) - getPaddingBottom();
        Rect rect2 = this.f12395b;
        Gravity.apply(8388659, measuredWidth, measuredHeight, rect, rect2);
        this.f12403j.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
        if (this.f12398e) {
            g();
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        measureChild(this.f12403j, i2, i3);
        int measuredWidth = this.f12403j.getMeasuredWidth();
        int measuredHeight = this.f12403j.getMeasuredHeight();
        int measuredState = this.f12403j.getMeasuredState();
        int paddingRight = getPaddingRight() + getPaddingLeft() + measuredWidth;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + measuredHeight;
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i2, measuredState), View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i3, measuredState << 16));
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f12401h = savedState.f12419b;
        this.f12402i = savedState.f12420c;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f12418a = this.f12403j.getId();
        int i2 = this.f12401h;
        if (i2 == -1) {
            i2 = this.f12397d;
        }
        savedState.f12419b = i2;
        Parcelable parcelable = this.f12402i;
        if (parcelable != null) {
            savedState.f12420c = parcelable;
            return savedState;
        }
        Object adapter = this.f12403j.getAdapter();
        if (!(adapter instanceof StatefulAdapter)) {
            return savedState;
        }
        ((StatefulAdapter) adapter).a();
        throw null;
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        throw new IllegalStateException("ViewPager2 does not support direct child views");
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int i2, Bundle bundle) {
        if (!this.t.b(i2)) {
            return super.performAccessibilityAction(i2, bundle);
        }
        this.t.g(i2, bundle);
        return true;
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.f12403j.getAdapter();
        this.t.d(adapter2);
        RecyclerView.AdapterDataObserver adapterDataObserver = this.f12399f;
        if (adapter2 != null) {
            adapter2.x(adapterDataObserver);
        }
        this.f12403j.setAdapter(adapter);
        this.f12397d = 0;
        c();
        this.t.c(adapter);
        if (adapter != null) {
            adapter.v(adapterDataObserver);
        }
    }

    public void setCurrentItem(int i2) {
        d(i2, true);
    }

    @Override // android.view.View
    public void setLayoutDirection(int i2) {
        super.setLayoutDirection(i2);
        this.t.i();
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1 && i2 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.s = i2;
        this.f12403j.requestLayout();
    }

    public void setOrientation(int i2) {
        this.f12400g.i1(i2);
        this.t.k();
    }

    public void setPageTransformer(@Nullable PageTransformer pageTransformer) {
        if (pageTransformer != null) {
            if (!this.q) {
                this.p = this.f12403j.getItemAnimator();
                this.q = true;
            }
            this.f12403j.setItemAnimator(null);
        } else if (this.q) {
            this.f12403j.setItemAnimator(this.p);
            this.p = null;
            this.q = false;
        }
        if (pageTransformer == this.o.d()) {
            return;
        }
        this.o.e(pageTransformer);
        if (this.o.d() == null) {
            return;
        }
        double dE = this.f12405l.e();
        int i2 = (int) dE;
        float f2 = (float) (dE - i2);
        this.o.b(f2, i2, Math.round(getPageSize() * f2));
    }

    public void setUserInputEnabled(boolean z) {
        this.r = z;
        this.t.l();
    }

    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public int f12418a;

        /* renamed from: b, reason: collision with root package name */
        public int f12419b;

        /* renamed from: c, reason: collision with root package name */
        public Parcelable f12420c;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f12418a);
            parcel.writeInt(this.f12419b);
            parcel.writeParcelable(this.f12420c, i2);
        }

        /* renamed from: androidx.viewpager2.widget.ViewPager2$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                SavedState savedState = new SavedState(parcel, null);
                savedState.f12418a = parcel.readInt();
                savedState.f12419b = parcel.readInt();
                savedState.f12420c = parcel.readParcelable(null);
                return savedState;
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState(parcel, classLoader);
                savedState.f12418a = parcel.readInt();
                savedState.f12419b = parcel.readInt();
                savedState.f12420c = parcel.readParcelable(classLoader);
                return savedState;
            }
        }
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12394a = new Rect();
        this.f12395b = new Rect();
        this.f12396c = new CompositeOnPageChangeCallback();
        this.f12398e = false;
        this.f12399f = new DataSetChangeObserver() { // from class: androidx.viewpager2.widget.ViewPager2.1
            @Override // androidx.viewpager2.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public final void a() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f12398e = true;
                viewPager2.f12405l.f12390l = true;
            }
        };
        this.f12401h = -1;
        this.p = null;
        this.q = false;
        this.r = true;
        this.s = -1;
        a(context, attributeSet);
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12394a = new Rect();
        this.f12395b = new Rect();
        this.f12396c = new CompositeOnPageChangeCallback();
        this.f12398e = false;
        this.f12399f = new DataSetChangeObserver() { // from class: androidx.viewpager2.widget.ViewPager2.1
            @Override // androidx.viewpager2.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public final void a() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f12398e = true;
                viewPager2.f12405l.f12390l = true;
            }
        };
        this.f12401h = -1;
        this.p = null;
        this.q = false;
        this.r = true;
        this.s = -1;
        a(context, attributeSet);
    }

    /* loaded from: classes3.dex */
    public static abstract class OnPageChangeCallback {
        public void a(int i2) {
        }

        public void c(int i2) {
        }

        public void b(float f2, int i2, int i3) {
        }
    }
}
