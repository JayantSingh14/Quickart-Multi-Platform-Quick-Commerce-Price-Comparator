package com.facebook.react.views.scroll;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Trace;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.HorizontalScrollView;
import android.widget.OverScroller;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.e;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.R;
import com.facebook.react.animated.NativeAnimatedModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.ReactOverflowViewWithInset;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.Overflow;
import com.facebook.react.views.scroll.MaintainVisibleScrollPositionHelper;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.google.android.gms.common.api.Api;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

@Nullsafe
/* loaded from: classes.dex */
public class ReactHorizontalScrollView extends HorizontalScrollView implements ReactClippingViewGroup, ViewGroup.OnHierarchyChangeListener, View.OnLayoutChangeListener, ReactOverflowViewWithInset, ReactScrollViewHelper.HasScrollState, ReactScrollViewHelper.HasStateWrapper, ReactScrollViewHelper.HasFlingAnimator, ReactScrollViewHelper.HasScrollEventThrottle, ReactScrollViewHelper.HasSmoothScroll {
    public static Field K = null;
    public static boolean L = false;
    public int A;
    public StateWrapper B;
    public final ReactScrollViewHelper.ReactScrollViewScrollState C;
    public final ObjectAnimator D;
    public PointerEvents E;
    public long F;
    public int G;
    public View H;
    public MaintainVisibleScrollPositionHelper I;
    public final Rect J;

    /* renamed from: a, reason: collision with root package name */
    public int f20020a;

    /* renamed from: b, reason: collision with root package name */
    public final OnScrollDispatchHelper f20021b;

    /* renamed from: c, reason: collision with root package name */
    public final OverScroller f20022c;

    /* renamed from: d, reason: collision with root package name */
    public final VelocityHelper f20023d;

    /* renamed from: e, reason: collision with root package name */
    public final Rect f20024e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f20025f;

    /* renamed from: g, reason: collision with root package name */
    public Rect f20026g;

    /* renamed from: h, reason: collision with root package name */
    public Overflow f20027h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f20028i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f20029j;

    /* renamed from: k, reason: collision with root package name */
    public Runnable f20030k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f20031l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f20032m;
    public boolean n;
    public final FpsListener o;
    public String p;
    public ColorDrawable q;
    public int r;
    public boolean s;
    public int t;
    public List u;
    public boolean v;
    public boolean w;
    public int x;
    public boolean y;
    public int z;

    /* renamed from: com.facebook.react.views.scroll.ReactHorizontalScrollView$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20036a;

        static {
            int[] iArr = new int[Overflow.values().length];
            f20036a = iArr;
            try {
                Overflow.Companion companion = Overflow.f19917a;
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f20036a;
                Overflow.Companion companion2 = Overflow.f19917a;
                iArr2[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f20036a;
                Overflow.Companion companion3 = Overflow.f19917a;
                iArr3[0] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ReactHorizontalScrollView(ThemedReactContext themedReactContext, FpsListener fpsListener) {
        super(themedReactContext);
        this.f20020a = Integer.MIN_VALUE;
        this.f20021b = new OnScrollDispatchHelper();
        this.f20023d = new VelocityHelper();
        this.f20024e = new Rect();
        this.f20027h = Overflow.f19920d;
        this.f20029j = false;
        this.f20032m = true;
        this.o = null;
        this.r = 0;
        this.s = false;
        this.t = 0;
        this.v = true;
        this.w = true;
        this.x = 0;
        this.y = false;
        this.z = -1;
        this.A = -1;
        this.B = null;
        this.D = ObjectAnimator.ofInt(this, "scrollX", 0, 0);
        this.E = PointerEvents.f19428e;
        this.F = 0L;
        this.G = 0;
        this.J = new Rect();
        this.o = fpsListener;
        ViewCompat.z(this, new ReactScrollViewAccessibilityDelegate());
        this.f20022c = getOverScrollerFromParent();
        this.C = new ReactScrollViewHelper.ReactScrollViewScrollState();
        setOnHierarchyChangeListener(this);
        setClipChildren(false);
    }

    public static HorizontalScrollView d(View view, MotionEvent motionEvent, boolean z) {
        if (view == null) {
            return null;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            return null;
        }
        if (!z && (view instanceof HorizontalScrollView) && ViewCompat.r(view) && (view instanceof ReactHorizontalScrollView) && ((ReactHorizontalScrollView) view).f20032m) {
            return (HorizontalScrollView) view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        int i2 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i2 >= viewGroup.getChildCount()) {
                return null;
            }
            HorizontalScrollView horizontalScrollViewD = d(viewGroup.getChildAt(i2), motionEvent, false);
            if (horizontalScrollViewD != null) {
                return horizontalScrollViewD;
            }
            i2++;
        }
    }

    private View getContentView() {
        return getChildAt(0);
    }

    @Nullable
    private OverScroller getOverScrollerFromParent() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (!L) {
            L = true;
            try {
                Field declaredField = HorizontalScrollView.class.getDeclaredField("mScroller");
                K = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                FLog.q("ReactHorizontalScrollView", "Failed to get mScroller field for HorizontalScrollView! This app will exhibit the bounce-back scrolling bug :(");
            }
        }
        Field field = K;
        OverScroller overScroller = null;
        if (field != null) {
            try {
                Object obj = field.get(this);
                if (obj instanceof OverScroller) {
                    overScroller = (OverScroller) obj;
                } else {
                    FLog.q("ReactHorizontalScrollView", "Failed to cast mScroller field in HorizontalScrollView (probably due to OEM changes to AOSP)! This app will exhibit the bounce-back scrolling bug :(");
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Failed to get mScroller from HorizontalScrollView!", e2);
            }
        }
        return overScroller;
    }

    private int getSnapInterval() {
        int i2 = this.t;
        return i2 != 0 ? i2 : getWidth();
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasSmoothScroll
    public final void a(int i2, int i3) {
        scrollTo(i2, i3);
        k(i2, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i2, int i3) {
        if (!this.f20029j || this.y) {
            super.addFocusables(arrayList, i2, i3);
            return;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        super.addFocusables(arrayList2, i2, i3);
        Iterator<View> it = arrayList2.iterator();
        while (it.hasNext()) {
            View next = it.next();
            if (h(next) != 0) {
                int iH = h(next);
                Rect rect = this.J;
                next.getDrawingRect(rect);
                if ((iH == 0 || Math.abs(iH) >= rect.width()) && !next.isFocused()) {
                }
            }
            arrayList.add(next);
        }
    }

    @Override // android.widget.HorizontalScrollView
    public final boolean arrowScroll(int i2) {
        if (!this.f20029j) {
            return super.arrowScroll(i2);
        }
        boolean z = true;
        this.y = true;
        if (getChildCount() > 0) {
            View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus(), i2);
            View contentView = getContentView();
            if (contentView == null || viewFindNextFocus == null || viewFindNextFocus.getParent() != contentView) {
                l(i2);
            } else {
                if (h(viewFindNextFocus) != 0) {
                    int iH = h(viewFindNextFocus);
                    Rect rect = this.J;
                    viewFindNextFocus.getDrawingRect(rect);
                    if (iH == 0 || Math.abs(iH) >= rect.width() / 2) {
                        l(i2);
                    }
                }
                viewFindNextFocus.requestFocus();
            }
        } else {
            z = false;
        }
        this.y = false;
        return z;
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasSmoothScroll
    public final void b(int i2, int i3) {
        ReactScrollViewHelper.j(this, i2, i3);
        View contentView = getContentView();
        if (contentView == null || contentView.getWidth() == 0 || contentView.getHeight() == 0) {
            this.z = i2;
            this.A = i3;
        } else {
            this.z = -1;
            this.A = -1;
        }
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasFlingAnimator
    public final void c(int i2, int i3) {
        ObjectAnimator objectAnimator = this.D;
        objectAnimator.cancel();
        int iE = ReactScrollViewHelper.e(getContext());
        objectAnimator.setDuration(iE).setIntValues(i2, i3);
        objectAnimator.start();
        if (this.n) {
            ReactScrollViewHelper.c(this, ScrollEventType.f20087e, iE > 0 ? (i3 - i2) / iE : 0, 0);
            getFlingAnimator().addListener(new ReactScrollViewHelper$dispatchMomentumEndOnAnimationEnd$1(this));
        }
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i2) {
        return this.f20032m && super.canScrollHorizontally(i2);
    }

    @Override // android.view.View
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (PointerEvents.b(this.E)) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final void draw(Canvas canvas) {
        if (this.r != 0) {
            View contentView = getContentView();
            if (this.q != null && contentView != null && contentView.getRight() < getWidth()) {
                this.q.setBounds(contentView.getRight(), 0, getWidth(), getHeight());
                this.q.draw(canvas);
            }
        }
        super.draw(canvas);
    }

    public final void e() {
        awakenScrollBars();
    }

    @Override // android.widget.HorizontalScrollView
    public final boolean executeKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (this.f20032m || !(keyCode == 21 || keyCode == 22)) {
            return super.executeKeyEvent(keyEvent);
        }
        return false;
    }

    public final void f(int i2) {
        int iMin;
        int iIntValue;
        int iMax;
        int iIntValue2;
        OverScroller overScroller;
        int scrollX = i2;
        if (getChildCount() <= 0) {
            return;
        }
        if (this.t == 0 && this.u == null && this.x == 0) {
            double snapInterval = getSnapInterval();
            double dF = ReactScrollViewHelper.f(this, getScrollX(), getReactScrollViewScrollState().f20064a.x, scrollX);
            double dJ = j(i2);
            double d2 = dF / snapInterval;
            int iFloor = (int) Math.floor(d2);
            int iCeil = (int) Math.ceil(d2);
            int iRound = (int) Math.round(d2);
            int iRound2 = (int) Math.round(dJ / snapInterval);
            if (scrollX > 0 && iCeil == iFloor) {
                iCeil++;
            } else if (scrollX < 0 && iFloor == iCeil) {
                iFloor--;
            }
            if (scrollX > 0 && iRound < iCeil && iRound2 > iFloor) {
                iRound = iCeil;
            } else if (scrollX < 0 && iRound > iFloor && iRound2 < iCeil) {
                iRound = iFloor;
            }
            double d3 = iRound * snapInterval;
            if (d3 != dF) {
                this.f20025f = true;
                b((int) d3, getScrollY());
                return;
            }
            return;
        }
        boolean z = getFlingAnimator() != this.D;
        int iMax2 = Math.max(0, computeHorizontalScrollRange() - getWidth());
        int iJ = j(i2);
        if (this.s) {
            iJ = getScrollX();
        }
        int width = getWidth();
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        int paddingStart = (width - getPaddingStart()) - getPaddingEnd();
        if (getLayoutDirection() == 1) {
            iJ = iMax2 - iJ;
            scrollX = -scrollX;
        }
        List list = this.u;
        if (list == null || list.isEmpty()) {
            int i3 = this.x;
            if (i3 != 0) {
                int i4 = this.t;
                if (i4 > 0) {
                    double d4 = iJ / i4;
                    double dFloor = Math.floor(d4);
                    int i5 = this.t;
                    int iMax3 = Math.max(g(i3, (int) (dFloor * i5), i5, paddingStart), 0);
                    int i6 = this.x;
                    double dCeil = Math.ceil(d4);
                    int i7 = this.t;
                    iMin = Math.min(g(i6, (int) (dCeil * i7), i7, paddingStart), iMax2);
                    iIntValue = iMax2;
                    iMax = iMax3;
                    iIntValue2 = 0;
                } else {
                    ViewGroup viewGroup = (ViewGroup) getContentView();
                    int iMin2 = iMax2;
                    int i8 = iMin2;
                    int i9 = 0;
                    int iMax4 = 0;
                    for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                        View childAt = viewGroup.getChildAt(i10);
                        int iG = g(this.x, childAt.getLeft(), childAt.getWidth(), paddingStart);
                        if (iG <= iJ && iJ - iG < iJ - i9) {
                            i9 = iG;
                        }
                        if (iG >= iJ && iG - iJ < i8 - iJ) {
                            i8 = iG;
                        }
                        iMin2 = Math.min(iMin2, iG);
                        iMax4 = Math.max(iMax4, iG);
                    }
                    iMax = Math.max(i9, iMin2);
                    iMin = Math.min(i8, iMax4);
                    iIntValue = iMax2;
                }
            } else {
                double snapInterval2 = getSnapInterval();
                double d5 = iJ / snapInterval2;
                int iFloor2 = (int) (Math.floor(d5) * snapInterval2);
                iMin = Math.min((int) (Math.ceil(d5) * snapInterval2), iMax2);
                iIntValue = iMax2;
                iMax = iFloor2;
            }
            iIntValue2 = 0;
        } else {
            iIntValue2 = ((Integer) this.u.get(0)).intValue();
            iIntValue = ((Integer) e.k(1, this.u)).intValue();
            iMin = iMax2;
            iMax = 0;
            for (int i11 = 0; i11 < this.u.size(); i11++) {
                int iIntValue3 = ((Integer) this.u.get(i11)).intValue();
                if (iIntValue3 <= iJ && iJ - iIntValue3 < iJ - iMax) {
                    iMax = iIntValue3;
                }
                if (iIntValue3 >= iJ && iIntValue3 - iJ < iMin - iJ) {
                    iMin = iIntValue3;
                }
            }
        }
        int i12 = iJ - iMax;
        int i13 = iMin - iJ;
        int i14 = Math.abs(i12) < Math.abs(i13) ? iMax : iMin;
        int scrollX2 = getScrollX();
        if (getLayoutDirection() == 1) {
            scrollX2 = iMax2 - scrollX2;
        }
        if (this.w || iJ < iIntValue) {
            if (this.v || iJ > iIntValue2) {
                if (scrollX > 0) {
                    if (!z) {
                        scrollX += (int) (i13 * 10.0d);
                    }
                    iJ = iMin;
                } else if (scrollX < 0) {
                    if (!z) {
                        scrollX -= (int) (i12 * 10.0d);
                    }
                    iJ = iMax;
                } else {
                    iJ = i14;
                }
            } else if (scrollX2 > iIntValue2) {
                iJ = iIntValue2;
            }
        } else if (scrollX2 < iIntValue) {
            iJ = iIntValue;
        }
        int iMin3 = Math.min(Math.max(0, iJ), iMax2);
        if (getLayoutDirection() == 1) {
            iMin3 = iMax2 - iMin3;
            scrollX = -scrollX;
        }
        int i15 = iMin3;
        if (z || (overScroller = this.f20022c) == null) {
            b(i15, getScrollY());
            return;
        }
        this.f20025f = true;
        int scrollX3 = getScrollX();
        int scrollY = getScrollY();
        if (scrollX == 0) {
            scrollX = i15 - getScrollX();
        }
        overScroller.fling(scrollX3, scrollY, scrollX, 0, i15, i15, 0, 0, (i15 == 0 || i15 == iMax2) ? paddingStart / 2 : 0, 0);
        postInvalidateOnAnimation();
    }

    @Override // android.widget.HorizontalScrollView
    public final void fling(int i2) {
        if (Build.VERSION.SDK_INT == 28) {
            i2 = (int) (Math.signum(this.f20021b.f20016c) * Math.abs(i2));
        }
        int i3 = i2;
        if (this.f20029j) {
            f(i3);
        } else if (this.f20022c != null) {
            int width = getWidth();
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            this.f20022c.fling(getScrollX(), getScrollY(), i3, 0, 0, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0, 0, ((width - getPaddingStart()) - getPaddingEnd()) / 2, 0);
            postInvalidateOnAnimation();
        } else {
            super.fling(i3);
        }
        i(i3, 0);
    }

    public final int g(int i2, int i3, int i4, int i5) {
        int i6;
        if (i2 == 1) {
            return i3;
        }
        if (i2 == 2) {
            i6 = (i5 - i4) / 2;
        } else {
            if (i2 != 3) {
                throw new IllegalStateException("Invalid SnapToAlignment value: " + this.x);
            }
            i6 = i5 - i4;
        }
        return i3 - i6;
    }

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    public final void getClippingRect(Rect rect) {
        Rect rect2 = this.f20026g;
        Assertions.c(rect2);
        rect.set(rect2);
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasFlingAnimator
    public ValueAnimator getFlingAnimator() {
        return this.D;
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasScrollEventThrottle
    public long getLastScrollDispatchTime() {
        return this.F;
    }

    @Override // com.facebook.react.uimanager.ReactOverflowView
    @Nullable
    public String getOverflow() {
        int iOrdinal = this.f20027h.ordinal();
        if (iOrdinal == 0) {
            return "visible";
        }
        if (iOrdinal == 1) {
            return "hidden";
        }
        if (iOrdinal != 2) {
            return null;
        }
        return "scroll";
    }

    @Override // com.facebook.react.uimanager.ReactOverflowViewWithInset
    public Rect getOverflowInset() {
        return this.f20024e;
    }

    public PointerEvents getPointerEvents() {
        return this.E;
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasScrollState
    public ReactScrollViewHelper.ReactScrollViewScrollState getReactScrollViewScrollState() {
        return this.C;
    }

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    public boolean getRemoveClippedSubviews() {
        return this.f20031l;
    }

    public boolean getScrollEnabled() {
        return this.f20032m;
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasScrollEventThrottle
    public int getScrollEventThrottle() {
        return this.G;
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasStateWrapper
    @Nullable
    public StateWrapper getStateWrapper() {
        return this.B;
    }

    public final int h(View view) {
        Rect rect = this.J;
        view.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(view, rect);
        return computeScrollDeltaToGetChildRectOnScreen(rect);
    }

    public final void i(int i2, int i3) {
        if (this.f20030k != null) {
            return;
        }
        if (this.n) {
            CopyOnWriteArrayList copyOnWriteArrayList = ReactScrollViewHelper.f20059a;
            ReactScrollViewHelper.c(this, ScrollEventType.f20087e, i2, i3);
        }
        this.f20025f = false;
        Runnable runnable = new Runnable() { // from class: com.facebook.react.views.scroll.ReactHorizontalScrollView.1

            /* renamed from: a, reason: collision with root package name */
            public boolean f20033a = false;

            /* renamed from: b, reason: collision with root package name */
            public int f20034b = 0;

            @Override // java.lang.Runnable
            public final void run() {
                String str;
                NativeAnimatedModule nativeAnimatedModule;
                ReactHorizontalScrollView reactHorizontalScrollView = ReactHorizontalScrollView.this;
                if (reactHorizontalScrollView.f20025f) {
                    reactHorizontalScrollView.f20025f = false;
                    this.f20034b = 0;
                    WeakHashMap weakHashMap = ViewCompat.f3080a;
                    reactHorizontalScrollView.postOnAnimationDelayed(this, 20L);
                    return;
                }
                ReactScrollViewHelper.k(reactHorizontalScrollView);
                int i4 = this.f20034b + 1;
                this.f20034b = i4;
                if (i4 < 3) {
                    if (reactHorizontalScrollView.f20029j && !this.f20033a) {
                        this.f20033a = true;
                        reactHorizontalScrollView.f(0);
                    }
                    WeakHashMap weakHashMap2 = ViewCompat.f3080a;
                    reactHorizontalScrollView.postOnAnimationDelayed(this, 20L);
                    return;
                }
                reactHorizontalScrollView.f20030k = null;
                if (reactHorizontalScrollView.n) {
                    ReactScrollViewHelper.c(reactHorizontalScrollView, ScrollEventType.f20088f, 0.0f, 0.0f);
                }
                ReactContext reactContext = (ReactContext) reactHorizontalScrollView.getContext();
                if (reactContext != null && (nativeAnimatedModule = (NativeAnimatedModule) reactContext.getNativeModule(NativeAnimatedModule.class)) != null) {
                    nativeAnimatedModule.userDrivenScrollEnded(reactHorizontalScrollView.getId());
                }
                if (reactHorizontalScrollView.o == null || (str = reactHorizontalScrollView.p) == null || str.isEmpty()) {
                    return;
                }
                FpsListener fpsListener = reactHorizontalScrollView.o;
                Assertions.c(fpsListener);
                Assertions.c(reactHorizontalScrollView.p);
                fpsListener.disable();
            }
        };
        this.f20030k = runnable;
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        postOnAnimationDelayed(runnable, 20L);
    }

    public final int j(int i2) {
        return getFlingAnimator() == this.D ? ReactScrollViewHelper.i(this, i2, 0, Math.max(0, computeHorizontalScrollRange() - getWidth()), 0).x : ReactScrollViewHelper.f(this, getScrollX(), getReactScrollViewScrollState().f20064a.x, i2) + ReactScrollViewHelper.i(this, i2, 0, Math.max(0, computeHorizontalScrollRange() - getWidth()), 0).x;
    }

    public final void k(int i2, int i3) {
        if (getFlingAnimator().isRunning()) {
            getFlingAnimator().cancel();
        }
        OverScroller overScroller = this.f20022c;
        if (overScroller == null || overScroller.isFinished()) {
            return;
        }
        int currX = overScroller.getCurrX();
        boolean zComputeScrollOffset = overScroller.computeScrollOffset();
        overScroller.forceFinished(true);
        if (!zComputeScrollOffset) {
            scrollTo((overScroller.getCurrX() - currX) + i2, getScrollY());
            return;
        }
        this.f20022c.fling(i2, getScrollY(), (int) (overScroller.getCurrVelocity() * Math.signum(overScroller.getFinalX() - overScroller.getStartX())), 0, 0, i3, 0, 0);
    }

    public final void l(int i2) {
        int width = getWidth();
        int scrollX = getScrollX();
        int i3 = scrollX / width;
        if (scrollX % width != 0) {
            i3++;
        }
        int i4 = i2 == 17 ? i3 - 1 : i3 + 1;
        if (i4 < 0) {
            i4 = 0;
        }
        b(i4 * width, getScrollY());
        i(0, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f20031l) {
            updateClippingRect();
        }
        MaintainVisibleScrollPositionHelper maintainVisibleScrollPositionHelper = this.I;
        if (maintainVisibleScrollPositionHelper != null) {
            maintainVisibleScrollPositionHelper.c();
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewAdded(View view, View view2) {
        this.H = view2;
        view2.addOnLayoutChangeListener(this);
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewRemoved(View view, View view2) {
        View view3 = this.H;
        if (view3 != null) {
            view3.removeOnLayoutChangeListener(this);
        }
        this.H = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MaintainVisibleScrollPositionHelper maintainVisibleScrollPositionHelper = this.I;
        if (maintainVisibleScrollPositionHelper != null) {
            maintainVisibleScrollPositionHelper.d();
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.f20027h != Overflow.f19918b) {
            BackgroundStyleApplicator.a(this, canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        String str = (String) getTag(R.id.react_test_id);
        if (str != null) {
            accessibilityNodeInfo.setViewIdResourceName(str);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        String str;
        FpsListener fpsListener = this.o;
        if (this.f20032m && (motionEvent.getAction() != 0 || d(this, motionEvent, true) == null)) {
            if (!PointerEvents.b(this.E)) {
                return true;
            }
            try {
                if (super.onInterceptTouchEvent(motionEvent)) {
                    NativeGestureUtil.b(this, motionEvent);
                    CopyOnWriteArrayList copyOnWriteArrayList = ReactScrollViewHelper.f20059a;
                    ReactScrollViewHelper.c(this, ScrollEventType.f20084b, 0.0f, 0.0f);
                    this.f20028i = true;
                    if ((fpsListener == null || (str = this.p) == null || str.isEmpty()) ? false : true) {
                        Assertions.c(fpsListener);
                        Assertions.c(this.p);
                        fpsListener.enable();
                    }
                    getFlingAnimator().cancel();
                    return true;
                }
            } catch (IllegalArgumentException e2) {
                FLog.r("ReactNative", "Error intercepting touch event.", e2);
            }
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        OverScroller overScroller;
        int i6 = this.f20020a;
        if (i6 != Integer.MIN_VALUE && (overScroller = this.f20022c) != null && i6 != overScroller.getFinalX() && !overScroller.isFinished()) {
            overScroller.startScroll(this.f20020a, overScroller.getFinalY(), 0, 0);
            overScroller.forceFinished(true);
            this.f20020a = Integer.MIN_VALUE;
        }
        View contentView = getContentView();
        if (contentView != null && contentView.getWidth() != 0 && contentView.getHeight() != 0) {
            int scrollX = this.z;
            if (scrollX == -1) {
                scrollX = getScrollX();
            }
            int scrollY = this.A;
            if (scrollY == -1) {
                scrollY = getScrollY();
            }
            scrollTo(scrollX, scrollY);
        }
        ReactScrollViewHelper.b(this);
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (this.H == null) {
            return;
        }
        if (view.getLayoutDirection() == 1) {
            if (getFlingAnimator().isRunning()) {
                getFlingAnimator().end();
            }
            int i10 = i4 - i2;
            int scrollX = i10 - (i8 - getScrollX());
            scrollTo(scrollX, getScrollY());
            k(scrollX, i10 - getWidth());
        } else {
            MaintainVisibleScrollPositionHelper maintainVisibleScrollPositionHelper = this.I;
            if (maintainVisibleScrollPositionHelper != null) {
                maintainVisibleScrollPositionHelper.e();
            }
        }
        ReactScrollViewHelper.a(this);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i2, int i3) {
        OverScroller overScroller;
        MeasureSpecAssertions.a(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        boolean z = getMeasuredHeight() != size2;
        setMeasuredDimension(size, size2);
        if (!z || (overScroller = this.f20022c) == null) {
            return;
        }
        this.f20020a = overScroller.getCurrX();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        int iMax;
        OverScroller overScroller = this.f20022c;
        if (overScroller != null && !overScroller.isFinished() && overScroller.getCurrX() != overScroller.getFinalX() && i2 >= (iMax = Math.max(computeHorizontalScrollRange() - getWidth(), 0))) {
            overScroller.abortAnimation();
            i2 = iMax;
        }
        super.onOverScrolled(i2, i3, z, z2);
    }

    @Override // android.view.View
    public final void onScrollChanged(int i2, int i3, int i4, int i5) {
        OnScrollDispatchHelper onScrollDispatchHelper = this.f20021b;
        Intrinsics.checkNotNullParameter("ReactHorizontalScrollView.onScrollChanged", "sectionName");
        Trace.beginSection(androidx.tracing.Trace.g("ReactHorizontalScrollView.onScrollChanged"));
        try {
            super.onScrollChanged(i2, i3, i4, i5);
            this.f20025f = true;
            if (onScrollDispatchHelper.a(i2, i3)) {
                if (this.f20031l) {
                    updateClippingRect();
                }
                float f2 = onScrollDispatchHelper.f20016c;
                float f3 = onScrollDispatchHelper.f20017d;
                CopyOnWriteArrayList copyOnWriteArrayList = ReactScrollViewHelper.f20059a;
                ReactScrollViewHelper.l(this, getScrollX(), getScrollY());
                ReactScrollViewHelper.c(this, ScrollEventType.f20086d, f2, f3);
            }
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (this.f20031l) {
            updateClippingRect();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        Runnable runnable;
        if (!this.f20032m || !PointerEvents.a(this.E)) {
            return false;
        }
        VelocityHelper velocityHelper = this.f20023d;
        velocityHelper.a(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 && this.f20028i) {
            ReactScrollViewHelper.k(this);
            float f2 = velocityHelper.f20092b;
            float f3 = velocityHelper.f20093c;
            ReactScrollViewHelper.c(this, ScrollEventType.f20085c, f2, f3);
            NativeGestureUtil.a(this, motionEvent);
            this.f20028i = false;
            i(Math.round(f2), Math.round(f3));
        }
        if (actionMasked == 0 && (runnable = this.f20030k) != null) {
            removeCallbacks(runnable);
            this.f20030k = null;
            getFlingAnimator().cancel();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.HorizontalScrollView
    public final boolean pageScroll(int i2) {
        boolean zPageScroll = super.pageScroll(i2);
        if (this.f20029j && zPageScroll) {
            i(0, 0);
        }
        return zPageScroll;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        int iH;
        if (view2 != null && !this.f20029j && (iH = h(view2)) != 0) {
            scrollBy(iH, 0);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final void scrollTo(int i2, int i3) {
        super.scrollTo(i2, i3);
        ReactScrollViewHelper.k(this);
        View contentView = getContentView();
        if (contentView == null || contentView.getWidth() == 0 || contentView.getHeight() == 0) {
            this.z = i2;
            this.A = i3;
        } else {
            this.z = -1;
            this.A = -1;
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        BackgroundStyleApplicator.i(this, Integer.valueOf(i2));
    }

    public void setBorderRadius(float f2) {
        BorderRadiusProp borderRadiusProp = BorderRadiusProp.f19836a;
        BackgroundStyleApplicator.l(this, BorderRadiusProp.values()[0], Float.isNaN(f2) ? null : new LengthPercentage(PixelUtil.a(f2), LengthPercentageType.f19394a));
    }

    public void setBorderStyle(@Nullable String str) {
        BackgroundStyleApplicator.m(this, str == null ? null : BorderStyle.a(str));
    }

    public void setDecelerationRate(float f2) {
        getReactScrollViewScrollState().f20069f = f2;
        OverScroller overScroller = this.f20022c;
        if (overScroller != null) {
            overScroller.setFriction(1.0f - f2);
        }
    }

    public void setDisableIntervalMomentum(boolean z) {
        this.s = z;
    }

    public void setEndFillColor(int i2) {
        if (i2 != this.r) {
            this.r = i2;
            this.q = new ColorDrawable(this.r);
        }
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasScrollEventThrottle
    public void setLastScrollDispatchTime(long j2) {
        this.F = j2;
    }

    public void setMaintainVisibleContentPosition(@Nullable MaintainVisibleScrollPositionHelper.Config config) {
        MaintainVisibleScrollPositionHelper maintainVisibleScrollPositionHelper;
        if (config != null && this.I == null) {
            MaintainVisibleScrollPositionHelper maintainVisibleScrollPositionHelper2 = new MaintainVisibleScrollPositionHelper(this, true);
            this.I = maintainVisibleScrollPositionHelper2;
            maintainVisibleScrollPositionHelper2.c();
        } else if (config == null && (maintainVisibleScrollPositionHelper = this.I) != null) {
            maintainVisibleScrollPositionHelper.d();
            this.I = null;
        }
        MaintainVisibleScrollPositionHelper maintainVisibleScrollPositionHelper3 = this.I;
        if (maintainVisibleScrollPositionHelper3 != null) {
            maintainVisibleScrollPositionHelper3.b(config);
        }
    }

    public void setOverflow(@Nullable String str) {
        if (str == null) {
            this.f20027h = Overflow.f19920d;
        } else {
            Overflow overflowA = Overflow.a(str);
            if (overflowA == null) {
                overflowA = Overflow.f19920d;
            }
            this.f20027h = overflowA;
        }
        invalidate();
    }

    @Override // com.facebook.react.uimanager.ReactOverflowViewWithInset
    public final void setOverflowInset(int i2, int i3, int i4, int i5) {
        this.f20024e.set(i2, i3, i4, i5);
    }

    public void setPagingEnabled(boolean z) {
        this.f20029j = z;
    }

    public void setPointerEvents(PointerEvents pointerEvents) {
        this.E = pointerEvents;
    }

    public void setRemoveClippedSubviews(boolean z) {
        if (z && this.f20026g == null) {
            this.f20026g = new Rect();
        }
        this.f20031l = z;
        updateClippingRect();
    }

    public void setScrollEnabled(boolean z) {
        this.f20032m = z;
    }

    public void setScrollEventThrottle(int i2) {
        this.G = i2;
    }

    public void setScrollPerfTag(@Nullable String str) {
        this.p = str;
    }

    public void setSendMomentumEvents(boolean z) {
        this.n = z;
    }

    public void setSnapInterval(int i2) {
        this.t = i2;
    }

    public void setSnapOffsets(@Nullable List<Integer> list) {
        this.u = list;
    }

    public void setSnapToAlignment(int i2) {
        this.x = i2;
    }

    public void setSnapToEnd(boolean z) {
        this.w = z;
    }

    public void setSnapToStart(boolean z) {
        this.v = z;
    }

    public void setStateWrapper(StateWrapper stateWrapper) {
        this.B = stateWrapper;
    }

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    public final void updateClippingRect() {
        if (this.f20031l) {
            Intrinsics.checkNotNullParameter("ReactHorizontalScrollView.updateClippingRect", "sectionName");
            Trace.beginSection(androidx.tracing.Trace.g("ReactHorizontalScrollView.updateClippingRect"));
            try {
                Assertions.c(this.f20026g);
                ReactClippingViewGroupHelper.a(this, this.f20026g);
                KeyEvent.Callback contentView = getContentView();
                if (contentView instanceof ReactClippingViewGroup) {
                    ((ReactClippingViewGroup) contentView).updateClippingRect();
                }
            } finally {
                Trace.endSection();
            }
        }
    }
}
