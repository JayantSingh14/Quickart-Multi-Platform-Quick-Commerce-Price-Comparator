package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.WeakHashMap;
import org.xbill.DNS.KEYRecord;

/* loaded from: classes3.dex */
public class ViewPager extends ViewGroup {
    public static final int[] J0 = {R.attr.layout_gravity};
    public static final Comparator K0 = new AnonymousClass1();
    public static final Interpolator L0 = new AnonymousClass2();
    public int A;
    public boolean A0;
    public final int B;
    public boolean B0;
    public float C;
    public int C0;
    public float D;
    public ArrayList D0;
    public float E;
    public OnPageChangeListener E0;
    public float F;
    public OnPageChangeListener F0;
    public int G;
    public ArrayList G0;
    public VelocityTracker H;
    public final Runnable H0;
    public final int I;
    public int I0;
    public final int J;
    public final int K;
    public final int L;
    public final EdgeEffect M;
    public final EdgeEffect Q;

    /* renamed from: a, reason: collision with root package name */
    public int f12342a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f12343b;

    /* renamed from: c, reason: collision with root package name */
    public final ItemInfo f12344c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f12345d;

    /* renamed from: e, reason: collision with root package name */
    public PagerAdapter f12346e;

    /* renamed from: f, reason: collision with root package name */
    public int f12347f;

    /* renamed from: g, reason: collision with root package name */
    public int f12348g;

    /* renamed from: h, reason: collision with root package name */
    public Parcelable f12349h;

    /* renamed from: i, reason: collision with root package name */
    public ClassLoader f12350i;

    /* renamed from: j, reason: collision with root package name */
    public final Scroller f12351j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f12352k;

    /* renamed from: l, reason: collision with root package name */
    public PagerObserver f12353l;

    /* renamed from: m, reason: collision with root package name */
    public int f12354m;
    public Drawable n;
    public int o;
    public int p;
    public float q;
    public float r;
    public int s;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public boolean x;
    public boolean y;
    public final int z;

    /* renamed from: androidx.viewpager.widget.ViewPager$1, reason: invalid class name */
    public static class AnonymousClass1 implements Comparator<ItemInfo> {
        @Override // java.util.Comparator
        public final int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.f12359b - itemInfo2.f12359b;
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$2, reason: invalid class name */
    public static class AnonymousClass2 implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$3, reason: invalid class name */
    public class AnonymousClass3 implements Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() throws Resources.NotFoundException {
            ViewPager viewPager = ViewPager.this;
            viewPager.setScrollState(0);
            viewPager.p();
        }
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DecorView {
    }

    public static class ItemInfo {

        /* renamed from: a, reason: collision with root package name */
        public Object f12358a;

        /* renamed from: b, reason: collision with root package name */
        public int f12359b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f12360c;

        /* renamed from: d, reason: collision with root package name */
        public float f12361d;

        /* renamed from: e, reason: collision with root package name */
        public float f12362e;
    }

    public class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        public MyAccessibilityDelegate() {
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
        @Override // androidx.core.view.AccessibilityDelegateCompat
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void onInitializeAccessibilityEvent(android.view.View r3, android.view.accessibility.AccessibilityEvent r4) {
            /*
                r2 = this;
                super.onInitializeAccessibilityEvent(r3, r4)
                java.lang.Class<androidx.viewpager.widget.ViewPager> r3 = androidx.viewpager.widget.ViewPager.class
                java.lang.String r3 = r3.getName()
                r4.setClassName(r3)
                androidx.viewpager.widget.ViewPager r3 = androidx.viewpager.widget.ViewPager.this
                androidx.viewpager.widget.PagerAdapter r0 = r3.f12346e
                if (r0 == 0) goto L1a
                int r0 = r0.c()
                r1 = 1
                if (r0 <= r1) goto L1a
                goto L1b
            L1a:
                r1 = 0
            L1b:
                r4.setScrollable(r1)
                int r0 = r4.getEventType()
                r1 = 4096(0x1000, float:5.74E-42)
                if (r0 != r1) goto L3b
                androidx.viewpager.widget.PagerAdapter r0 = r3.f12346e
                if (r0 == 0) goto L3b
                int r0 = r0.c()
                r4.setItemCount(r0)
                int r0 = r3.f12347f
                r4.setFromIndex(r0)
                int r3 = r3.f12347f
                r4.setToIndex(r3)
            L3b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.MyAccessibilityDelegate.onInitializeAccessibilityEvent(android.view.View, android.view.accessibility.AccessibilityEvent):void");
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.m(ViewPager.class.getName());
            ViewPager viewPager = ViewPager.this;
            PagerAdapter pagerAdapter = viewPager.f12346e;
            accessibilityNodeInfoCompat.u(pagerAdapter != null && pagerAdapter.c() > 1);
            if (viewPager.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.a(4096);
            }
            if (viewPager.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.a(KEYRecord.Flags.FLAG2);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) throws Resources.NotFoundException {
            if (super.performAccessibilityAction(view, i2, bundle)) {
                return true;
            }
            ViewPager viewPager = ViewPager.this;
            if (i2 == 4096) {
                if (!viewPager.canScrollHorizontally(1)) {
                    return false;
                }
                viewPager.setCurrentItem(viewPager.f12347f + 1);
                return true;
            }
            if (i2 != 8192 || !viewPager.canScrollHorizontally(-1)) {
                return false;
            }
            viewPager.setCurrentItem(viewPager.f12347f - 1);
            return true;
        }
    }

    public interface OnAdapterChangeListener {
        void b(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    public interface OnPageChangeListener {
        void a(float f2, int i2);

        void c(int i2);

        void d(int i2);
    }

    public interface PageTransformer {
    }

    public class PagerObserver extends DataSetObserver {
        public PagerObserver() {
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() throws Resources.NotFoundException {
            ViewPager.this.e();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() throws Resources.NotFoundException {
            ViewPager.this.e();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: c, reason: collision with root package name */
        public int f12370c;

        /* renamed from: d, reason: collision with root package name */
        public Parcelable f12371d;

        /* renamed from: e, reason: collision with root package name */
        public final ClassLoader f12372e;

        /* renamed from: androidx.viewpager.widget.ViewPager$SavedState$1, reason: invalid class name */
        public static class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
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
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f12370c = parcel.readInt();
            this.f12371d = parcel.readParcelable(classLoader);
            this.f12372e = classLoader;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("FragmentPager.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" position=");
            return b.o(sb, this.f12370c, "}");
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f12370c);
            parcel.writeParcelable(this.f12371d, i2);
        }
    }

    public static class ViewPositionComparator implements Comparator<View> {
        @Override // java.util.Comparator
        public final int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z = layoutParams.f12363a;
            return z != layoutParams2.f12363a ? z ? 1 : -1 : layoutParams.f12367e - layoutParams2.f12367e;
        }
    }

    public ViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12343b = new ArrayList();
        this.f12344c = new ItemInfo();
        this.f12345d = new Rect();
        this.f12348g = -1;
        this.f12349h = null;
        this.f12350i = null;
        this.q = -3.4028235E38f;
        this.r = Float.MAX_VALUE;
        this.w = 1;
        this.G = -1;
        this.A0 = true;
        this.H0 = new AnonymousClass3();
        this.I0 = 0;
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context2 = getContext();
        this.f12351j = new Scroller(context2, L0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
        float f2 = context2.getResources().getDisplayMetrics().density;
        this.B = viewConfiguration.getScaledPagingTouchSlop();
        this.I = (int) (400.0f * f2);
        this.J = viewConfiguration.getScaledMaximumFlingVelocity();
        this.M = new EdgeEffect(context2);
        this.Q = new EdgeEffect(context2);
        this.K = (int) (25.0f * f2);
        this.L = (int) (2.0f * f2);
        this.z = (int) (f2 * 16.0f);
        ViewCompat.z(this, new MyAccessibilityDelegate());
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        ViewCompat.H(this, new OnApplyWindowInsetsListener() { // from class: androidx.viewpager.widget.ViewPager.4

            /* renamed from: a, reason: collision with root package name */
            public final Rect f12356a = new Rect();

            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat b(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat windowInsetsCompatT = ViewCompat.t(view, windowInsetsCompat);
                if (windowInsetsCompatT.n()) {
                    return windowInsetsCompatT;
                }
                int iH = windowInsetsCompatT.h();
                Rect rect = this.f12356a;
                rect.left = iH;
                rect.top = windowInsetsCompatT.j();
                rect.right = windowInsetsCompatT.i();
                rect.bottom = windowInsetsCompatT.g();
                ViewPager viewPager = ViewPager.this;
                int childCount = viewPager.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    WindowInsetsCompat windowInsetsCompatC = ViewCompat.c(viewPager.getChildAt(i2), windowInsetsCompatT);
                    rect.left = Math.min(windowInsetsCompatC.h(), rect.left);
                    rect.top = Math.min(windowInsetsCompatC.j(), rect.top);
                    rect.right = Math.min(windowInsetsCompatC.i(), rect.right);
                    rect.bottom = Math.min(windowInsetsCompatC.g(), rect.bottom);
                }
                return windowInsetsCompatT.p(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    public static boolean c(int i2, int i3, int i4, View view, boolean z) {
        int i5;
        if (!(view instanceof ViewGroup)) {
            return z ? false : false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int scrollX = view.getScrollX();
        int scrollY = view.getScrollY();
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            int i6 = i3 + scrollX;
            if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && c(i2, i6 - childAt.getLeft(), i5 - childAt.getTop(), childAt, true)) {
                break;
            }
        }
        if (z || !view.canScrollHorizontally(-i2)) {
        }
        return true;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.u != z) {
            this.u = z;
        }
    }

    public final ItemInfo a(int i2, int i3) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.f12359b = i2;
        itemInfo.f12358a = this.f12346e.e(this, i2);
        this.f12346e.getClass();
        itemInfo.f12361d = 1.0f;
        ArrayList arrayList = this.f12343b;
        if (i3 < 0 || i3 >= arrayList.size()) {
            arrayList.add(itemInfo);
            return itemInfo;
        }
        arrayList.add(i3, itemInfo);
        return itemInfo;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i2, int i3) {
        ItemInfo itemInfoH;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (itemInfoH = h(childAt)) != null && itemInfoH.f12359b == this.f12347f) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i3 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addTouchables(ArrayList arrayList) {
        ItemInfo itemInfoH;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (itemInfoH = h(childAt)) != null && itemInfoH.f12359b == this.f12347f) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = new LayoutParams();
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean z = layoutParams2.f12363a | (view.getClass().getAnnotation(DecorView.class) != null);
        layoutParams2.f12363a = z;
        if (!this.t) {
            super.addView(view, i2, layoutParams);
        } else {
            if (z) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            layoutParams2.f12366d = true;
            addViewInLayout(view, i2, layoutParams);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(int r8) throws android.content.res.Resources.NotFoundException {
        /*
            r7 = this;
            android.view.View r0 = r7.findFocus()
            r1 = 0
            if (r0 != r7) goto L9
        L7:
            r0 = r1
            goto L60
        L9:
            if (r0 == 0) goto L60
            android.view.ViewParent r2 = r0.getParent()
        Lf:
            boolean r3 = r2 instanceof android.view.ViewGroup
            if (r3 == 0) goto L1b
            if (r2 != r7) goto L16
            goto L60
        L16:
            android.view.ViewParent r2 = r2.getParent()
            goto Lf
        L1b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
        L2f:
            boolean r3 = r0 instanceof android.view.ViewGroup
            if (r3 == 0) goto L48
            java.lang.String r3 = " => "
            r2.append(r3)
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
            goto L2f
        L48:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.<init>(r3)
            java.lang.String r2 = r2.toString()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "ViewPager"
            android.util.Log.e(r2, r0)
            goto L7
        L60:
            android.view.FocusFinder r1 = android.view.FocusFinder.getInstance()
            android.view.View r1 = r1.findNextFocus(r7, r0, r8)
            r2 = 1
            r3 = 0
            r4 = 66
            r5 = 17
            if (r1 == 0) goto Lb3
            if (r1 == r0) goto Lb3
            android.graphics.Rect r6 = r7.f12345d
            if (r8 != r5) goto L97
            android.graphics.Rect r4 = r7.g(r6, r1)
            int r4 = r4.left
            android.graphics.Rect r5 = r7.g(r6, r0)
            int r5 = r5.left
            if (r0 == 0) goto L91
            if (r4 < r5) goto L91
            int r0 = r7.f12347f
            if (r0 <= 0) goto Lcd
            int r0 = r0 - r2
            r7.v = r3
            r7.u(r0, r3, r2, r3)
            goto Lce
        L91:
            boolean r0 = r1.requestFocus()
        L95:
            r3 = r0
            goto Lcf
        L97:
            if (r8 != r4) goto Lcf
            android.graphics.Rect r2 = r7.g(r6, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r7.g(r6, r0)
            int r3 = r3.left
            if (r0 == 0) goto Lae
            if (r2 > r3) goto Lae
            boolean r0 = r7.m()
            goto L95
        Lae:
            boolean r0 = r1.requestFocus()
            goto L95
        Lb3:
            if (r8 == r5) goto Lc2
            if (r8 != r2) goto Lb8
            goto Lc2
        Lb8:
            if (r8 == r4) goto Lbd
            r0 = 2
            if (r8 != r0) goto Lcf
        Lbd:
            boolean r3 = r7.m()
            goto Lcf
        Lc2:
            int r0 = r7.f12347f
            if (r0 <= 0) goto Lcd
            int r0 = r0 - r2
            r7.v = r3
            r7.u(r0, r3, r2, r3)
            goto Lce
        Lcd:
            r2 = r3
        Lce:
            r3 = r2
        Lcf:
            if (r3 == 0) goto Ld8
            int r8 = android.view.SoundEffectConstants.getContantForFocusDirection(r8)
            r7.playSoundEffect(r8)
        Ld8:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.b(int):boolean");
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i2) {
        if (this.f12346e == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i2 < 0 ? scrollX > ((int) (((float) clientWidth) * this.q)) : i2 > 0 && scrollX < ((int) (((float) clientWidth) * this.r));
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public final void computeScroll() throws Resources.NotFoundException {
        this.f12352k = true;
        Scroller scroller = this.f12351j;
        if (scroller.isFinished() || !scroller.computeScrollOffset()) {
            d(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = scroller.getCurrX();
        int currY = scroller.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!n(currX)) {
                scroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        postInvalidateOnAnimation();
    }

    public final void d(boolean z) throws Resources.NotFoundException {
        Scroller scroller = this.f12351j;
        boolean z2 = this.I0 == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!scroller.isFinished()) {
                scroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = scroller.getCurrX();
                int currY = scroller.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        n(currX);
                    }
                }
            }
        }
        this.v = false;
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f12343b;
            if (i2 >= arrayList.size()) {
                break;
            }
            ItemInfo itemInfo = (ItemInfo) arrayList.get(i2);
            if (itemInfo.f12360c) {
                itemInfo.f12360c = false;
                z2 = true;
            }
            i2++;
        }
        if (z2) {
            Runnable runnable = this.H0;
            if (!z) {
                ((AnonymousClass3) runnable).run();
            } else {
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                postOnAnimation(runnable);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0065 A[RETURN] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r6) throws android.content.res.Resources.NotFoundException {
        /*
            r5 = this;
            boolean r0 = super.dispatchKeyEvent(r6)
            r1 = 1
            if (r0 != 0) goto L66
            int r0 = r6.getAction()
            r2 = 0
            if (r0 != 0) goto L61
            int r0 = r6.getKeyCode()
            r3 = 21
            r4 = 2
            if (r0 == r3) goto L48
            r3 = 22
            if (r0 == r3) goto L36
            r3 = 61
            if (r0 == r3) goto L20
            goto L61
        L20:
            boolean r0 = r6.hasNoModifiers()
            if (r0 == 0) goto L2b
            boolean r6 = r5.b(r4)
            goto L62
        L2b:
            boolean r6 = r6.hasModifiers(r1)
            if (r6 == 0) goto L61
            boolean r6 = r5.b(r1)
            goto L62
        L36:
            boolean r6 = r6.hasModifiers(r4)
            if (r6 == 0) goto L41
            boolean r6 = r5.m()
            goto L62
        L41:
            r6 = 66
            boolean r6 = r5.b(r6)
            goto L62
        L48:
            boolean r6 = r6.hasModifiers(r4)
            if (r6 == 0) goto L5a
            int r6 = r5.f12347f
            if (r6 <= 0) goto L61
            int r6 = r6 - r1
            r5.v = r2
            r5.u(r6, r2, r1, r2)
            r6 = r1
            goto L62
        L5a:
            r6 = 17
            boolean r6 = r5.b(r6)
            goto L62
        L61:
            r6 = r2
        L62:
            if (r6 == 0) goto L65
            goto L66
        L65:
            return r2
        L66:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ItemInfo itemInfoH;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (itemInfoH = h(childAt)) != null && itemInfoH.f12359b == this.f12347f && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        EdgeEffect edgeEffect = this.Q;
        EdgeEffect edgeEffect2 = this.M;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (pagerAdapter = this.f12346e) != null && pagerAdapter.c() > 1)) {
            if (!edgeEffect2.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate(getPaddingTop() + (-height), this.q * width);
                edgeEffect2.setSize(height, width);
                zDraw = edgeEffect2.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!edgeEffect.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.r + 1.0f)) * width2);
                edgeEffect.setSize(height2, width2);
                zDraw |= edgeEffect.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            edgeEffect2.finish();
            edgeEffect.finish();
        }
        if (zDraw) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.n;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public final void e() throws Resources.NotFoundException {
        int iC = this.f12346e.c();
        this.f12342a = iC;
        ArrayList arrayList = this.f12343b;
        boolean z = arrayList.size() < (this.w * 2) + 1 && arrayList.size() < iC;
        int i2 = this.f12347f;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            ItemInfo itemInfo = (ItemInfo) arrayList.get(i3);
            PagerAdapter pagerAdapter = this.f12346e;
            Object obj = itemInfo.f12358a;
            pagerAdapter.getClass();
        }
        Collections.sort(arrayList, K0);
        if (z) {
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i4).getLayoutParams();
                if (!layoutParams.f12363a) {
                    layoutParams.f12365c = 0.0f;
                }
            }
            u(i2, 0, false, true);
            requestLayout();
        }
    }

    public final void f(int i2) {
        OnPageChangeListener onPageChangeListener = this.E0;
        if (onPageChangeListener != null) {
            onPageChangeListener.d(i2);
        }
        ArrayList arrayList = this.D0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                OnPageChangeListener onPageChangeListener2 = (OnPageChangeListener) this.D0.get(i3);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.d(i2);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.F0;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.d(i2);
        }
    }

    public final Rect g(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left = viewGroup.getLeft() + rect.left;
            rect.right = viewGroup.getRight() + rect.right;
            rect.top = viewGroup.getTop() + rect.top;
            rect.bottom = viewGroup.getBottom() + rect.bottom;
            parent = viewGroup.getParent();
        }
        return rect;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams();
    }

    @Nullable
    public PagerAdapter getAdapter() {
        return this.f12346e;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i2, int i3) {
        throw null;
    }

    public int getCurrentItem() {
        return this.f12347f;
    }

    public int getOffscreenPageLimit() {
        return this.w;
    }

    public int getPageMargin() {
        return this.f12354m;
    }

    public final ItemInfo h(View view) {
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f12343b;
            if (i2 >= arrayList.size()) {
                return null;
            }
            ItemInfo itemInfo = (ItemInfo) arrayList.get(i2);
            if (this.f12346e.f(view, itemInfo.f12358a)) {
                return itemInfo;
            }
            i2++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0072, code lost:
    
        return r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.viewpager.widget.ViewPager.ItemInfo i() {
        /*
            r13 = this;
            int r0 = r13.getClientWidth()
            r1 = 0
            if (r0 <= 0) goto Lf
            int r2 = r13.getScrollX()
            float r2 = (float) r2
            float r3 = (float) r0
            float r2 = r2 / r3
            goto L10
        Lf:
            r2 = r1
        L10:
            if (r0 <= 0) goto L18
            int r3 = r13.f12354m
            float r3 = (float) r3
            float r0 = (float) r0
            float r3 = r3 / r0
            goto L19
        L18:
            r3 = r1
        L19:
            r0 = 0
            r4 = -1
            r5 = 1
            r6 = 0
            r8 = r0
            r9 = r5
            r7 = r6
            r6 = r4
            r4 = r1
        L22:
            java.util.ArrayList r10 = r13.f12343b
            int r11 = r10.size()
            if (r8 >= r11) goto L72
            java.lang.Object r11 = r10.get(r8)
            androidx.viewpager.widget.ViewPager$ItemInfo r11 = (androidx.viewpager.widget.ViewPager.ItemInfo) r11
            if (r9 != 0) goto L4c
            int r12 = r11.f12359b
            int r6 = r6 + r5
            if (r12 == r6) goto L4c
            float r1 = r1 + r4
            float r1 = r1 + r3
            androidx.viewpager.widget.ViewPager$ItemInfo r4 = r13.f12344c
            r4.f12362e = r1
            r4.f12359b = r6
            androidx.viewpager.widget.PagerAdapter r1 = r13.f12346e
            r1.getClass()
            r1 = 1065353216(0x3f800000, float:1.0)
            r4.f12361d = r1
            int r8 = r8 + (-1)
            r6 = r4
            goto L4d
        L4c:
            r6 = r11
        L4d:
            float r1 = r6.f12362e
            float r4 = r6.f12361d
            float r4 = r4 + r1
            float r4 = r4 + r3
            if (r9 != 0) goto L59
            int r9 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r9 < 0) goto L72
        L59:
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 < 0) goto L71
            int r4 = r10.size()
            int r4 = r4 - r5
            if (r8 != r4) goto L65
            goto L71
        L65:
            int r4 = r6.f12359b
            float r7 = r6.f12361d
            int r8 = r8 + 1
            r9 = r6
            r6 = r4
            r4 = r7
            r7 = r9
            r9 = r0
            goto L22
        L71:
            return r6
        L72:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.i():androidx.viewpager.widget.ViewPager$ItemInfo");
    }

    public final ItemInfo j(int i2) {
        int i3 = 0;
        while (true) {
            ArrayList arrayList = this.f12343b;
            if (i3 >= arrayList.size()) {
                return null;
            }
            ItemInfo itemInfo = (ItemInfo) arrayList.get(i3);
            if (itemInfo.f12359b == i2) {
                return itemInfo;
            }
            i3++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(float r12, int r13, int r14) {
        /*
            r11 = this;
            int r14 = r11.C0
            r0 = 0
            r1 = 1
            if (r14 <= 0) goto L6c
            int r14 = r11.getScrollX()
            int r2 = r11.getPaddingLeft()
            int r3 = r11.getPaddingRight()
            int r4 = r11.getWidth()
            int r5 = r11.getChildCount()
            r6 = r0
        L1b:
            if (r6 >= r5) goto L6c
            android.view.View r7 = r11.getChildAt(r6)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r8 = (androidx.viewpager.widget.ViewPager.LayoutParams) r8
            boolean r9 = r8.f12363a
            if (r9 != 0) goto L2c
            goto L69
        L2c:
            int r8 = r8.f12364b
            r8 = r8 & 7
            if (r8 == r1) goto L50
            r9 = 3
            if (r8 == r9) goto L4a
            r9 = 5
            if (r8 == r9) goto L3a
            r8 = r2
            goto L5d
        L3a:
            int r8 = r4 - r3
            int r9 = r7.getMeasuredWidth()
            int r8 = r8 - r9
            int r9 = r7.getMeasuredWidth()
            int r3 = r3 + r9
        L46:
            r10 = r8
            r8 = r2
            r2 = r10
            goto L5d
        L4a:
            int r8 = r7.getWidth()
            int r8 = r8 + r2
            goto L5d
        L50:
            int r8 = r7.getMeasuredWidth()
            int r8 = r4 - r8
            int r8 = r8 / 2
            int r8 = java.lang.Math.max(r8, r2)
            goto L46
        L5d:
            int r2 = r2 + r14
            int r9 = r7.getLeft()
            int r2 = r2 - r9
            if (r2 == 0) goto L68
            r7.offsetLeftAndRight(r2)
        L68:
            r2 = r8
        L69:
            int r6 = r6 + 1
            goto L1b
        L6c:
            androidx.viewpager.widget.ViewPager$OnPageChangeListener r14 = r11.E0
            if (r14 == 0) goto L73
            r14.a(r12, r13)
        L73:
            java.util.ArrayList r14 = r11.D0
            if (r14 == 0) goto L8d
            int r14 = r14.size()
        L7b:
            if (r0 >= r14) goto L8d
            java.util.ArrayList r2 = r11.D0
            java.lang.Object r2 = r2.get(r0)
            androidx.viewpager.widget.ViewPager$OnPageChangeListener r2 = (androidx.viewpager.widget.ViewPager.OnPageChangeListener) r2
            if (r2 == 0) goto L8a
            r2.a(r12, r13)
        L8a:
            int r0 = r0 + 1
            goto L7b
        L8d:
            androidx.viewpager.widget.ViewPager$OnPageChangeListener r14 = r11.F0
            if (r14 == 0) goto L94
            r14.a(r12, r13)
        L94:
            r11.B0 = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.k(float, int, int):void");
    }

    public final void l(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.G) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.C = motionEvent.getX(i2);
            this.G = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.H;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public final boolean m() throws Resources.NotFoundException {
        PagerAdapter pagerAdapter = this.f12346e;
        if (pagerAdapter == null || this.f12347f >= pagerAdapter.c() - 1) {
            return false;
        }
        int i2 = this.f12347f + 1;
        this.v = false;
        u(i2, 0, true, false);
        return true;
    }

    public final boolean n(int i2) {
        if (this.f12343b.size() == 0) {
            if (!this.A0) {
                this.B0 = false;
                k(0.0f, 0, 0);
                if (!this.B0) {
                    throw new IllegalStateException("onPageScrolled did not call superclass implementation");
                }
            }
            return false;
        }
        ItemInfo itemInfoI = i();
        int clientWidth = getClientWidth();
        int i3 = this.f12354m;
        int i4 = clientWidth + i3;
        float f2 = clientWidth;
        int i5 = itemInfoI.f12359b;
        float f3 = ((i2 / f2) - itemInfoI.f12362e) / (itemInfoI.f12361d + (i3 / f2));
        this.B0 = false;
        k(f3, i5, (int) (i4 * f3));
        if (this.B0) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    public final boolean o(float f2) {
        boolean z;
        boolean z2;
        float f3 = this.C - f2;
        this.C = f2;
        float scrollX = getScrollX() + f3;
        float clientWidth = getClientWidth();
        float f4 = this.q * clientWidth;
        float f5 = this.r * clientWidth;
        ArrayList arrayList = this.f12343b;
        boolean z3 = false;
        ItemInfo itemInfo = (ItemInfo) arrayList.get(0);
        ItemInfo itemInfo2 = (ItemInfo) b.c(1, arrayList);
        if (itemInfo.f12359b != 0) {
            f4 = itemInfo.f12362e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (itemInfo2.f12359b != this.f12346e.c() - 1) {
            f5 = itemInfo2.f12362e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f4) {
            if (z) {
                this.M.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z2) {
                this.Q.onPull(Math.abs(scrollX - f5) / clientWidth);
                z3 = true;
            }
            scrollX = f5;
        }
        int i2 = (int) scrollX;
        this.C = (scrollX - i2) + this.C;
        scrollTo(i2, getScrollY());
        n(i2);
        return z3;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A0 = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.H0);
        Scroller scroller = this.f12351j;
        if (scroller != null && !scroller.isFinished()) {
            this.f12351j.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int i2;
        float f2;
        ArrayList arrayList;
        int i3;
        super.onDraw(canvas);
        if (this.f12354m <= 0 || this.n == null) {
            return;
        }
        ArrayList arrayList2 = this.f12343b;
        if (arrayList2.size() <= 0 || this.f12346e == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f3 = this.f12354m / width;
        int i4 = 0;
        ItemInfo itemInfo = (ItemInfo) arrayList2.get(0);
        float f4 = itemInfo.f12362e;
        int size = arrayList2.size();
        int i5 = itemInfo.f12359b;
        int i6 = ((ItemInfo) arrayList2.get(size - 1)).f12359b;
        while (i5 < i6) {
            while (true) {
                i2 = itemInfo.f12359b;
                if (i5 <= i2 || i4 >= size) {
                    break;
                }
                i4++;
                itemInfo = (ItemInfo) arrayList2.get(i4);
            }
            if (i5 == i2) {
                float f5 = itemInfo.f12362e;
                float f6 = itemInfo.f12361d;
                f2 = (f5 + f6) * width;
                f4 = f5 + f6 + f3;
            } else {
                this.f12346e.getClass();
                f2 = (f4 + 1.0f) * width;
                f4 = 1.0f + f3 + f4;
            }
            if (this.f12354m + f2 > scrollX) {
                arrayList = arrayList2;
                i3 = scrollX;
                this.n.setBounds(Math.round(f2), this.o, Math.round(this.f12354m + f2), this.p);
                this.n.draw(canvas);
            } else {
                arrayList = arrayList2;
                i3 = scrollX;
            }
            if (f2 > i3 + r3) {
                return;
            }
            i5++;
            arrayList2 = arrayList;
            scrollX = i3;
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        int i2 = this.B;
        Scroller scroller = this.f12351j;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            s();
            return false;
        }
        if (action != 0) {
            if (this.x) {
                return true;
            }
            if (this.y) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.E = x;
            this.C = x;
            float y = motionEvent.getY();
            this.F = y;
            this.D = y;
            this.G = motionEvent.getPointerId(0);
            this.y = false;
            this.f12352k = true;
            scroller.computeScrollOffset();
            if (this.I0 != 2 || Math.abs(scroller.getFinalX() - scroller.getCurrX()) <= this.L) {
                d(false);
                this.x = false;
            } else {
                scroller.abortAnimation();
                this.v = false;
                p();
                this.x = true;
                ViewParent parent = getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                setScrollState(1);
            }
        } else if (action == 2) {
            int i3 = this.G;
            if (i3 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i3);
                float x2 = motionEvent.getX(iFindPointerIndex);
                float f2 = x2 - this.C;
                float fAbs = Math.abs(f2);
                float y2 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y2 - this.F);
                if (f2 != 0.0f) {
                    float f3 = this.C;
                    if ((f3 >= this.A || f2 <= 0.0f) && ((f3 <= getWidth() - this.A || f2 >= 0.0f) && c((int) f2, (int) x2, (int) y2, this, false))) {
                        this.C = x2;
                        this.D = y2;
                        this.y = true;
                        return false;
                    }
                }
                float f4 = i2;
                if (fAbs > f4 && fAbs * 0.5f > fAbs2) {
                    this.x = true;
                    ViewParent parent2 = getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(true);
                    }
                    setScrollState(1);
                    float f5 = this.E;
                    float f6 = i2;
                    this.C = f2 > 0.0f ? f5 + f6 : f5 - f6;
                    this.D = y2;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > f4) {
                    this.y = true;
                }
                if (this.x && o(x2)) {
                    WeakHashMap weakHashMap = ViewCompat.f3080a;
                    postInvalidateOnAnimation();
                }
            }
        } else if (action == 6) {
            l(motionEvent);
        }
        if (this.H == null) {
            this.H = VelocityTracker.obtain();
        }
        this.H.addMovement(motionEvent);
        return this.x;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0094  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r19, int r20, int r21, int r22, int r23) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) throws Resources.NotFoundException {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        int i4;
        setMeasuredDimension(View.getDefaultSize(0, i2), View.getDefaultSize(0, i3));
        int measuredWidth = getMeasuredWidth();
        this.A = Math.min(measuredWidth / 10, this.z);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            boolean z = true;
            int i6 = 1073741824;
            if (i5 >= childCount) {
                break;
            }
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8 && (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) != null && layoutParams2.f12363a) {
                int i7 = layoutParams2.f12364b;
                int i8 = i7 & 7;
                int i9 = i7 & 112;
                boolean z2 = i9 == 48 || i9 == 80;
                if (i8 != 3 && i8 != 5) {
                    z = false;
                }
                int i10 = Integer.MIN_VALUE;
                if (z2) {
                    i4 = Integer.MIN_VALUE;
                    i10 = 1073741824;
                } else {
                    i4 = z ? 1073741824 : Integer.MIN_VALUE;
                }
                int i11 = ((ViewGroup.LayoutParams) layoutParams2).width;
                if (i11 != -2) {
                    if (i11 == -1) {
                        i11 = paddingLeft;
                    }
                    i10 = 1073741824;
                } else {
                    i11 = paddingLeft;
                }
                int i12 = ((ViewGroup.LayoutParams) layoutParams2).height;
                if (i12 == -2) {
                    i12 = measuredHeight;
                    i6 = i4;
                } else if (i12 == -1) {
                    i12 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i11, i10), View.MeasureSpec.makeMeasureSpec(i12, i6));
                if (z2) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i5++;
        }
        View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.s = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.t = true;
        p();
        this.t = false;
        int childCount2 = getChildCount();
        for (int i13 = 0; i13 < childCount2; i13++) {
            View childAt2 = getChildAt(i13);
            if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.f12363a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * layoutParams.f12365c), 1073741824), this.s);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        int i5;
        ItemInfo itemInfoH;
        int childCount = getChildCount();
        if ((i2 & 2) != 0) {
            i4 = childCount;
            i3 = 0;
            i5 = 1;
        } else {
            i3 = childCount - 1;
            i4 = -1;
            i5 = -1;
        }
        while (i3 != i4) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (itemInfoH = h(childAt)) != null && itemInfoH.f12359b == this.f12347f && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i3 += i5;
        }
        return false;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) throws Resources.NotFoundException {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f3321a);
        PagerAdapter pagerAdapter = this.f12346e;
        ClassLoader classLoader = savedState.f12372e;
        if (pagerAdapter != null) {
            pagerAdapter.g(savedState.f12371d, classLoader);
            u(savedState.f12370c, 0, false, true);
        } else {
            this.f12348g = savedState.f12370c;
            this.f12349h = savedState.f12371d;
            this.f12350i = classLoader;
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f12370c = this.f12347f;
        PagerAdapter pagerAdapter = this.f12346e;
        if (pagerAdapter != null) {
            savedState.f12371d = pagerAdapter.h();
        }
        return savedState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) throws Resources.NotFoundException {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.f12354m;
            r(i2, i4, i6, i6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00d9  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r9) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 414
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() throws Resources.NotFoundException {
        q(this.f12347f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0061, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c3 A[PHI: r7 r11 r15
      0x00c3: PHI (r7v16 int) = (r7v15 int), (r7v5 int), (r7v19 int) binds: [B:62:0x00e7, B:59:0x00d3, B:50:0x00ba] A[DONT_GENERATE, DONT_INLINE]
      0x00c3: PHI (r11v32 int) = (r11v1 int), (r11v31 int), (r11v35 int) binds: [B:62:0x00e7, B:59:0x00d3, B:50:0x00ba] A[DONT_GENERATE, DONT_INLINE]
      0x00c3: PHI (r15v6 float) = (r15v4 float), (r15v5 float), (r15v3 float) binds: [B:62:0x00e7, B:59:0x00d3, B:50:0x00ba] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0145 A[PHI: r3 r12
      0x0145: PHI (r3v20 float) = (r3v18 float), (r3v19 float), (r3v17 float) binds: [B:96:0x016c, B:93:0x0156, B:86:0x013c] A[DONT_GENERATE, DONT_INLINE]
      0x0145: PHI (r12v25 int) = (r12v23 int), (r12v24 int), (r12v22 int) binds: [B:96:0x016c, B:93:0x0156, B:86:0x013c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(int r18) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 877
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.q(int):void");
    }

    public final void r(int i2, int i3, int i4, int i5) throws Resources.NotFoundException {
        if (i3 > 0 && !this.f12343b.isEmpty()) {
            if (!this.f12351j.isFinished()) {
                this.f12351j.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i3 - getPaddingLeft()) - getPaddingRight()) + i5)) * (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)), getScrollY());
                return;
            }
        }
        ItemInfo itemInfoJ = j(this.f12347f);
        int iMin = (int) ((itemInfoJ != null ? Math.min(itemInfoJ.f12362e, this.r) : 0.0f) * ((i2 - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            d(false);
            scrollTo(iMin, getScrollY());
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.t) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public final boolean s() {
        this.G = -1;
        this.x = false;
        this.y = false;
        VelocityTracker velocityTracker = this.H;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.H = null;
        }
        this.M.onRelease();
        this.Q.onRelease();
        return this.M.isFinished() || this.Q.isFinished();
    }

    public void setAdapter(@Nullable PagerAdapter pagerAdapter) throws Resources.NotFoundException {
        ArrayList arrayList;
        PagerAdapter pagerAdapter2 = this.f12346e;
        if (pagerAdapter2 != null) {
            synchronized (pagerAdapter2) {
            }
            this.f12346e.j(this);
            int i2 = 0;
            while (true) {
                arrayList = this.f12343b;
                if (i2 >= arrayList.size()) {
                    break;
                }
                ItemInfo itemInfo = (ItemInfo) arrayList.get(i2);
                this.f12346e.a(itemInfo.f12359b, itemInfo.f12358a);
                i2++;
            }
            this.f12346e.b();
            arrayList.clear();
            int i3 = 0;
            while (i3 < getChildCount()) {
                if (!((LayoutParams) getChildAt(i3).getLayoutParams()).f12363a) {
                    removeViewAt(i3);
                    i3--;
                }
                i3++;
            }
            this.f12347f = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter3 = this.f12346e;
        this.f12346e = pagerAdapter;
        this.f12342a = 0;
        if (pagerAdapter != null) {
            if (this.f12353l == null) {
                this.f12353l = new PagerObserver();
            }
            synchronized (this.f12346e) {
            }
            this.v = false;
            boolean z = this.A0;
            this.A0 = true;
            this.f12342a = this.f12346e.c();
            if (this.f12348g >= 0) {
                this.f12346e.g(this.f12349h, this.f12350i);
                u(this.f12348g, 0, false, true);
                this.f12348g = -1;
                this.f12349h = null;
                this.f12350i = null;
            } else if (z) {
                requestLayout();
            } else {
                p();
            }
        }
        ArrayList arrayList2 = this.G0;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            return;
        }
        int size = this.G0.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((OnAdapterChangeListener) this.G0.get(i4)).b(this, pagerAdapter3, pagerAdapter);
        }
    }

    public void setCurrentItem(int i2) throws Resources.NotFoundException {
        this.v = false;
        u(i2, 0, !this.A0, false);
    }

    public void setOffscreenPageLimit(int i2) throws Resources.NotFoundException {
        if (i2 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i2 + " too small; defaulting to 1");
            i2 = 1;
        }
        if (i2 != this.w) {
            this.w = i2;
            p();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.E0 = onPageChangeListener;
    }

    public void setPageMargin(int i2) throws Resources.NotFoundException {
        int i3 = this.f12354m;
        this.f12354m = i2;
        int width = getWidth();
        r(width, width, i2, i3);
        requestLayout();
    }

    public void setPageMarginDrawable(@Nullable Drawable drawable) {
        this.n = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i2) {
        if (this.I0 == i2) {
            return;
        }
        this.I0 = i2;
        OnPageChangeListener onPageChangeListener = this.E0;
        if (onPageChangeListener != null) {
            onPageChangeListener.c(i2);
        }
        ArrayList arrayList = this.D0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                OnPageChangeListener onPageChangeListener2 = (OnPageChangeListener) this.D0.get(i3);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.c(i2);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.F0;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.c(i2);
        }
    }

    public final void t(int i2, int i3, boolean z, boolean z2) throws Resources.NotFoundException {
        int scrollX;
        int iAbs;
        Scroller scroller = this.f12351j;
        ItemInfo itemInfoJ = j(i2);
        int iMax = itemInfoJ != null ? (int) (Math.max(this.q, Math.min(itemInfoJ.f12362e, this.r)) * getClientWidth()) : 0;
        if (!z) {
            if (z2) {
                f(i2);
            }
            d(false);
            scrollTo(iMax, 0);
            n(iMax);
            return;
        }
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
        } else {
            if (scroller == null || scroller.isFinished()) {
                scrollX = getScrollX();
            } else {
                scrollX = this.f12352k ? scroller.getCurrX() : scroller.getStartX();
                scroller.abortAnimation();
                setScrollingCacheEnabled(false);
            }
            int i4 = scrollX;
            int scrollY = getScrollY();
            int i5 = iMax - i4;
            int i6 = 0 - scrollY;
            if (i5 == 0 && i6 == 0) {
                d(false);
                p();
                setScrollState(0);
            } else {
                setScrollingCacheEnabled(true);
                setScrollState(2);
                int clientWidth = getClientWidth();
                int i7 = clientWidth / 2;
                float f2 = clientWidth;
                float f3 = i7;
                float fSin = (((float) Math.sin((Math.min(1.0f, (Math.abs(i5) * 1.0f) / f2) - 0.5f) * 0.47123894f)) * f3) + f3;
                int iAbs2 = Math.abs(i3);
                if (iAbs2 > 0) {
                    iAbs = Math.round(Math.abs(fSin / iAbs2) * 1000.0f) * 4;
                } else {
                    this.f12346e.getClass();
                    iAbs = (int) (((Math.abs(i5) / ((f2 * 1.0f) + this.f12354m)) + 1.0f) * 100.0f);
                }
                int iMin = Math.min(iAbs, 600);
                this.f12352k = false;
                this.f12351j.startScroll(i4, scrollY, i5, i6, iMin);
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                postInvalidateOnAnimation();
            }
        }
        if (z2) {
            f(i2);
        }
    }

    public final void u(int i2, int i3, boolean z, boolean z2) throws Resources.NotFoundException {
        PagerAdapter pagerAdapter = this.f12346e;
        if (pagerAdapter == null || pagerAdapter.c() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        ArrayList arrayList = this.f12343b;
        if (!z2 && this.f12347f == i2 && arrayList.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 >= this.f12346e.c()) {
            i2 = this.f12346e.c() - 1;
        }
        int i4 = this.w;
        int i5 = this.f12347f;
        if (i2 > i5 + i4 || i2 < i5 - i4) {
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                ((ItemInfo) arrayList.get(i6)).f12360c = true;
            }
        }
        boolean z3 = this.f12347f != i2;
        if (!this.A0) {
            q(i2);
            t(i2, i3, z, z3);
        } else {
            this.f12347f = i2;
            if (z3) {
                f(i2);
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.n;
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public boolean f12363a;

        /* renamed from: b, reason: collision with root package name */
        public final int f12364b;

        /* renamed from: c, reason: collision with root package name */
        public float f12365c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f12366d;

        /* renamed from: e, reason: collision with root package name */
        public int f12367e;

        public LayoutParams() {
            super(-1, -1);
            this.f12365c = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f12365c = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.J0);
            this.f12364b = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setPageMarginDrawable(@DrawableRes int i2) {
        setPageMarginDrawable(getContext().getDrawable(i2));
    }

    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void c(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void d(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void a(float f2, int i2) {
        }
    }
}
