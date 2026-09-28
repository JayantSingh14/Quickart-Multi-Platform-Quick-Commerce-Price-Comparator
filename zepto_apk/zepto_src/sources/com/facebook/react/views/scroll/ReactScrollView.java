package com.facebook.react.views.scroll;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Trace;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.e;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.R;
import com.facebook.react.animated.NativeAnimatedModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
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
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

@Nullsafe
/* loaded from: classes.dex */
public class ReactScrollView extends ScrollView implements ReactClippingViewGroup, ViewGroup.OnHierarchyChangeListener, View.OnLayoutChangeListener, ReactOverflowViewWithInset, ReactScrollViewHelper.HasScrollState, ReactScrollViewHelper.HasStateWrapper, ReactScrollViewHelper.HasFlingAnimator, ReactScrollViewHelper.HasScrollEventThrottle, ReactScrollViewHelper.HasSmoothScroll {
    public static Field J = null;
    public static boolean K = false;
    public int A;
    public int B;
    public StateWrapper C;
    public final ReactScrollViewHelper.ReactScrollViewScrollState D;
    public final ObjectAnimator E;
    public PointerEvents F;
    public long G;
    public int H;
    public MaintainVisibleScrollPositionHelper I;

    /* renamed from: a, reason: collision with root package name */
    public final OnScrollDispatchHelper f20037a;

    /* renamed from: b, reason: collision with root package name */
    public final OverScroller f20038b;

    /* renamed from: c, reason: collision with root package name */
    public final VelocityHelper f20039c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f20040d;

    /* renamed from: e, reason: collision with root package name */
    public final Rect f20041e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f20042f;

    /* renamed from: g, reason: collision with root package name */
    public Rect f20043g;

    /* renamed from: h, reason: collision with root package name */
    public Overflow f20044h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f20045i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f20046j;

    /* renamed from: k, reason: collision with root package name */
    public Runnable f20047k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f20048l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f20049m;
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
    public View y;
    public ReadableMap z;

    /* renamed from: com.facebook.react.views.scroll.ReactScrollView$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20053a;

        static {
            int[] iArr = new int[Overflow.values().length];
            f20053a = iArr;
            try {
                Overflow.Companion companion = Overflow.f19917a;
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f20053a;
                Overflow.Companion companion2 = Overflow.f19917a;
                iArr2[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f20053a;
                Overflow.Companion companion3 = Overflow.f19917a;
                iArr3[0] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ReactScrollView(ThemedReactContext themedReactContext, FpsListener fpsListener) {
        super(themedReactContext);
        this.f20037a = new OnScrollDispatchHelper();
        this.f20039c = new VelocityHelper();
        this.f20040d = new Rect();
        this.f20041e = new Rect();
        this.f20044h = Overflow.f19920d;
        this.f20046j = false;
        this.f20049m = true;
        this.o = null;
        this.r = 0;
        this.s = false;
        this.t = 0;
        this.v = true;
        this.w = true;
        this.x = 0;
        this.z = null;
        this.A = -1;
        this.B = -1;
        this.C = null;
        this.D = new ReactScrollViewHelper.ReactScrollViewScrollState();
        this.E = ObjectAnimator.ofInt(this, "scrollY", 0, 0);
        this.F = PointerEvents.f19428e;
        this.G = 0L;
        this.H = 0;
        this.I = null;
        this.o = fpsListener;
        this.f20038b = getOverScrollerFromParent();
        setOnHierarchyChangeListener(this);
        setScrollBarStyle(33554432);
        setClipChildren(false);
        ViewCompat.z(this, new ReactScrollViewAccessibilityDelegate());
    }

    private View getContentView() {
        return getChildAt(0);
    }

    private int getMaxScrollY() {
        View view = this.y;
        return Math.max(0, (view == null ? 0 : view.getHeight()) - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
    }

    @Nullable
    private OverScroller getOverScrollerFromParent() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (!K) {
            K = true;
            try {
                Field declaredField = ScrollView.class.getDeclaredField("mScroller");
                J = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                FLog.q("ReactNative", "Failed to get mScroller field for ScrollView! This app will exhibit the bounce-back scrolling bug :(");
            }
        }
        Field field = J;
        OverScroller overScroller = null;
        if (field != null) {
            try {
                Object obj = field.get(this);
                if (obj instanceof OverScroller) {
                    overScroller = (OverScroller) obj;
                } else {
                    FLog.q("ReactNative", "Failed to cast mScroller field in ScrollView (probably due to OEM changes to AOSP)! This app will exhibit the bounce-back scrolling bug :(");
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Failed to get mScroller from ScrollView!", e2);
            }
        }
        return overScroller;
    }

    private int getSnapInterval() {
        int i2 = this.t;
        return i2 != 0 ? i2 : getHeight();
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasSmoothScroll
    public final void a(int i2, int i3) {
        scrollTo(i2, i3);
        if (getFlingAnimator().isRunning()) {
            getFlingAnimator().cancel();
        }
        OverScroller overScroller = this.f20038b;
        if (overScroller == null || overScroller.isFinished()) {
            return;
        }
        int currY = overScroller.getCurrY();
        boolean zComputeScrollOffset = overScroller.computeScrollOffset();
        overScroller.forceFinished(true);
        if (!zComputeScrollOffset) {
            scrollTo(getScrollX(), (overScroller.getCurrX() - currY) + i3);
            return;
        }
        this.f20038b.fling(getScrollX(), i3, 0, (int) (overScroller.getCurrVelocity() * Math.signum(overScroller.getFinalY() - overScroller.getStartY())), 0, 0, 0, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasSmoothScroll
    public final void b(int i2, int i3) {
        ReactScrollViewHelper.j(this, i2, i3);
        if (h()) {
            this.A = -1;
            this.B = -1;
        } else {
            this.A = i2;
            this.B = i3;
        }
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasFlingAnimator
    public final void c(int i2, int i3) {
        ObjectAnimator objectAnimator = this.E;
        objectAnimator.cancel();
        int iE = ReactScrollViewHelper.e(getContext());
        objectAnimator.setDuration(iE).setIntValues(i2, i3);
        objectAnimator.start();
        if (this.n) {
            ReactScrollViewHelper.c(this, ScrollEventType.f20087e, 0, iE > 0 ? (i3 - i2) / iE : 0);
            getFlingAnimator().addListener(new ReactScrollViewHelper$dispatchMomentumEndOnAnimationEnd$1(this));
        }
    }

    public final void d() {
        awakenScrollBars();
    }

    @Override // android.view.View
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (PointerEvents.b(this.F)) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        return false;
    }

    @Override // android.widget.ScrollView, android.view.View
    public final void draw(Canvas canvas) {
        if (this.r != 0) {
            View contentView = getContentView();
            if (this.q != null && contentView != null && contentView.getBottom() < getHeight()) {
                this.q.setBounds(0, contentView.getBottom(), getWidth(), getHeight());
                this.q.draw(canvas);
            }
        }
        super.draw(canvas);
    }

    public final void e(int i2) {
        int iFloor;
        int iMin;
        int iIntValue;
        int iIntValue2;
        int top;
        int top2;
        int height;
        OverScroller overScroller;
        int scrollY = i2;
        if (getChildCount() <= 0) {
            return;
        }
        int i3 = 1;
        if (this.t == 0 && this.u == null && this.x == 0) {
            double snapInterval = getSnapInterval();
            double dF = ReactScrollViewHelper.f(this, getScrollY(), getReactScrollViewScrollState().f20064a.y, scrollY);
            double dJ = j(i2);
            double d2 = dF / snapInterval;
            int iFloor2 = (int) Math.floor(d2);
            int iCeil = (int) Math.ceil(d2);
            int iRound = (int) Math.round(d2);
            int iRound2 = (int) Math.round(dJ / snapInterval);
            if (scrollY > 0 && iCeil == iFloor2) {
                iCeil++;
            } else if (scrollY < 0 && iFloor2 == iCeil) {
                iFloor2--;
            }
            if (scrollY > 0 && iRound < iCeil && iRound2 > iFloor2) {
                iRound = iCeil;
            } else if (scrollY < 0 && iRound > iFloor2 && iRound2 < iCeil) {
                iRound = iFloor2;
            }
            double d3 = iRound * snapInterval;
            if (d3 != dF) {
                this.f20042f = true;
                b(getScrollX(), (int) d3);
                return;
            }
            return;
        }
        boolean z = getFlingAnimator() != this.E;
        int maxScrollY = getMaxScrollY();
        int iJ = j(i2);
        if (this.s) {
            iJ = getScrollY();
        }
        int height2 = (getHeight() - getPaddingBottom()) - getPaddingTop();
        List list = this.u;
        if (list != null) {
            iIntValue2 = ((Integer) list.get(0)).intValue();
            iIntValue = ((Integer) e.k(1, this.u)).intValue();
            iMin = maxScrollY;
            iFloor = 0;
            for (int i4 = 0; i4 < this.u.size(); i4++) {
                int iIntValue3 = ((Integer) this.u.get(i4)).intValue();
                if (iIntValue3 <= iJ && iJ - iIntValue3 < iJ - iFloor) {
                    iFloor = iIntValue3;
                }
                if (iIntValue3 >= iJ && iIntValue3 - iJ < iMin - iJ) {
                    iMin = iIntValue3;
                }
            }
        } else {
            int i5 = this.x;
            if (i5 != 0) {
                int i6 = this.t;
                if (i6 > 0) {
                    double d4 = iJ / i6;
                    double dFloor = Math.floor(d4);
                    int i7 = this.t;
                    iFloor = Math.max(f(i5, (int) (dFloor * i7), i7, height2), 0);
                    int i8 = this.x;
                    double dCeil = Math.ceil(d4);
                    int i9 = this.t;
                    iMin = Math.min(f(i8, (int) (dCeil * i9), i9, height2), maxScrollY);
                } else {
                    ViewGroup viewGroup = (ViewGroup) getContentView();
                    int iMin2 = maxScrollY;
                    int i10 = iMin2;
                    int i11 = 0;
                    int i12 = 0;
                    int iMax = 0;
                    while (i11 < viewGroup.getChildCount()) {
                        View childAt = viewGroup.getChildAt(i11);
                        int i13 = this.x;
                        if (i13 != i3) {
                            if (i13 == 2) {
                                top2 = childAt.getTop();
                                height = (height2 - childAt.getHeight()) / 2;
                            } else {
                                if (i13 != 3) {
                                    throw new IllegalStateException("Invalid SnapToAlignment value: " + this.x);
                                }
                                top2 = childAt.getTop();
                                height = height2 - childAt.getHeight();
                            }
                            top = top2 - height;
                        } else {
                            top = childAt.getTop();
                        }
                        if (top <= iJ && iJ - top < iJ - i12) {
                            i12 = top;
                        }
                        if (top >= iJ && top - iJ < i10 - iJ) {
                            i10 = top;
                        }
                        iMin2 = Math.min(iMin2, top);
                        iMax = Math.max(iMax, top);
                        i11++;
                        i3 = 1;
                    }
                    int iMax2 = Math.max(i12, iMin2);
                    iMin = Math.min(i10, iMax);
                    iFloor = iMax2;
                }
            } else {
                double snapInterval2 = getSnapInterval();
                double d5 = iJ / snapInterval2;
                iFloor = (int) (Math.floor(d5) * snapInterval2);
                iMin = Math.min((int) (Math.ceil(d5) * snapInterval2), maxScrollY);
            }
            iIntValue = maxScrollY;
            iIntValue2 = 0;
        }
        int i14 = iJ - iFloor;
        int i15 = iMin - iJ;
        int i16 = Math.abs(i14) < Math.abs(i15) ? iFloor : iMin;
        if (this.w || iJ < iIntValue) {
            if (this.v || iJ > iIntValue2) {
                if (scrollY > 0) {
                    if (!z) {
                        scrollY += (int) (i15 * 10.0d);
                    }
                    iJ = iMin;
                } else if (scrollY < 0) {
                    if (!z) {
                        scrollY -= (int) (i14 * 10.0d);
                    }
                    iJ = iFloor;
                } else {
                    iJ = i16;
                }
            } else if (getScrollY() > iIntValue2) {
                iJ = iIntValue2;
            }
        } else if (getScrollY() < iIntValue) {
            iJ = iIntValue;
        }
        int iMin3 = Math.min(Math.max(0, iJ), maxScrollY);
        if (z || (overScroller = this.f20038b) == null) {
            b(getScrollX(), iMin3);
            return;
        }
        this.f20042f = true;
        int scrollX = getScrollX();
        int scrollY2 = getScrollY();
        if (scrollY == 0) {
            scrollY = iMin3 - getScrollY();
        }
        overScroller.fling(scrollX, scrollY2, 0, scrollY, 0, 0, iMin3, iMin3, 0, (iMin3 == 0 || iMin3 == maxScrollY) ? height2 / 2 : 0);
        postInvalidateOnAnimation();
    }

    @Override // android.widget.ScrollView
    public final boolean executeKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (this.f20049m || !(keyCode == 19 || keyCode == 20)) {
            return super.executeKeyEvent(keyEvent);
        }
        return false;
    }

    public final int f(int i2, int i3, int i4, int i5) {
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

    @Override // android.widget.ScrollView
    public final void fling(int i2) {
        if (Build.VERSION.SDK_INT == 28) {
            float fSignum = Math.signum(this.f20037a.f20017d);
            if (fSignum == 0.0f) {
                fSignum = Math.signum(i2);
            }
            i2 = (int) (Math.abs(i2) * fSignum);
        }
        int i3 = i2;
        if (this.f20046j) {
            e(i3);
        } else if (this.f20038b != null) {
            this.f20038b.fling(getScrollX(), getScrollY(), 0, i3, 0, 0, 0, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0, ((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            postInvalidateOnAnimation();
        } else {
            super.fling(i3);
        }
        g(0, i3);
    }

    public final void g(int i2, int i3) {
        String str;
        FpsListener fpsListener = this.o;
        if (this.f20047k != null) {
            return;
        }
        if (this.n) {
            if (fpsListener != null && (str = this.p) != null && !str.isEmpty()) {
                Assertions.c(fpsListener);
                Assertions.c(this.p);
                fpsListener.enable();
            }
            CopyOnWriteArrayList copyOnWriteArrayList = ReactScrollViewHelper.f20059a;
            ReactScrollViewHelper.c(this, ScrollEventType.f20087e, i2, i3);
        }
        this.f20042f = false;
        Runnable runnable = new Runnable() { // from class: com.facebook.react.views.scroll.ReactScrollView.1

            /* renamed from: a, reason: collision with root package name */
            public boolean f20050a = false;

            /* renamed from: b, reason: collision with root package name */
            public int f20051b = 0;

            @Override // java.lang.Runnable
            public final void run() {
                String str2;
                NativeAnimatedModule nativeAnimatedModule;
                ReactScrollView reactScrollView = ReactScrollView.this;
                if (reactScrollView.f20042f) {
                    reactScrollView.f20042f = false;
                    this.f20051b = 0;
                    WeakHashMap weakHashMap = ViewCompat.f3080a;
                    reactScrollView.postOnAnimationDelayed(this, 20L);
                    return;
                }
                ReactScrollViewHelper.k(reactScrollView);
                int i4 = this.f20051b + 1;
                this.f20051b = i4;
                if (i4 < 3) {
                    if (reactScrollView.f20046j && !this.f20050a) {
                        this.f20050a = true;
                        reactScrollView.e(0);
                    }
                    WeakHashMap weakHashMap2 = ViewCompat.f3080a;
                    reactScrollView.postOnAnimationDelayed(this, 20L);
                    return;
                }
                reactScrollView.f20047k = null;
                if (reactScrollView.n) {
                    ReactScrollViewHelper.c(reactScrollView, ScrollEventType.f20088f, 0.0f, 0.0f);
                }
                ReactContext reactContext = (ReactContext) reactScrollView.getContext();
                if (reactContext != null && (nativeAnimatedModule = (NativeAnimatedModule) reactContext.getNativeModule(NativeAnimatedModule.class)) != null) {
                    nativeAnimatedModule.userDrivenScrollEnded(reactScrollView.getId());
                }
                if (reactScrollView.o == null || (str2 = reactScrollView.p) == null || str2.isEmpty()) {
                    return;
                }
                FpsListener fpsListener2 = reactScrollView.o;
                Assertions.c(fpsListener2);
                Assertions.c(reactScrollView.p);
                fpsListener2.disable();
            }
        };
        this.f20047k = runnable;
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        postOnAnimationDelayed(runnable, 20L);
    }

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    public final void getClippingRect(Rect rect) {
        Rect rect2 = this.f20043g;
        Assertions.c(rect2);
        rect.set(rect2);
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasFlingAnimator
    @NonNull
    public ValueAnimator getFlingAnimator() {
        return this.E;
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasScrollEventThrottle
    public long getLastScrollDispatchTime() {
        return this.G;
    }

    @Override // com.facebook.react.uimanager.ReactOverflowView
    @Nullable
    public String getOverflow() {
        int iOrdinal = this.f20044h.ordinal();
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
        return this.f20041e;
    }

    public PointerEvents getPointerEvents() {
        return this.F;
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasScrollState
    public ReactScrollViewHelper.ReactScrollViewScrollState getReactScrollViewScrollState() {
        return this.D;
    }

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    public boolean getRemoveClippedSubviews() {
        return this.f20048l;
    }

    public boolean getScrollEnabled() {
        return this.f20049m;
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasScrollEventThrottle
    public int getScrollEventThrottle() {
        return this.H;
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewHelper.HasStateWrapper
    @Nullable
    public StateWrapper getStateWrapper() {
        return this.C;
    }

    public final boolean h() {
        View contentView = getContentView();
        return (contentView == null || contentView.getWidth() == 0 || contentView.getHeight() == 0) ? false : true;
    }

    public final boolean i(View view) {
        Rect rect = this.f20040d;
        view.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(view, rect);
        int iComputeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        view.getDrawingRect(rect);
        return iComputeScrollDeltaToGetChildRectOnScreen != 0 && Math.abs(iComputeScrollDeltaToGetChildRectOnScreen) < rect.width();
    }

    public final int j(int i2) {
        return getFlingAnimator() == this.E ? ReactScrollViewHelper.i(this, 0, i2, 0, getMaxScrollY()).y : ReactScrollViewHelper.f(this, getScrollY(), getReactScrollViewScrollState().f20064a.y, i2) + ReactScrollViewHelper.i(this, 0, i2, 0, getMaxScrollY()).y;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f20048l) {
            updateClippingRect();
        }
        MaintainVisibleScrollPositionHelper maintainVisibleScrollPositionHelper = this.I;
        if (maintainVisibleScrollPositionHelper != null) {
            maintainVisibleScrollPositionHelper.c();
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewAdded(View view, View view2) {
        this.y = view2;
        view2.addOnLayoutChangeListener(this);
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewRemoved(View view, View view2) {
        View view3 = this.y;
        if (view3 != null) {
            view3.removeOnLayoutChangeListener(this);
            this.y = null;
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MaintainVisibleScrollPositionHelper maintainVisibleScrollPositionHelper = this.I;
        if (maintainVisibleScrollPositionHelper != null) {
            maintainVisibleScrollPositionHelper.d();
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.f20044h != Overflow.f19918b) {
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

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        String str;
        FpsListener fpsListener = this.o;
        if (!this.f20049m) {
            return false;
        }
        if (!PointerEvents.b(this.F)) {
            return true;
        }
        try {
            if (!super.onInterceptTouchEvent(motionEvent)) {
                return false;
            }
            NativeGestureUtil.b(this, motionEvent);
            CopyOnWriteArrayList copyOnWriteArrayList = ReactScrollViewHelper.f20059a;
            ReactScrollViewHelper.c(this, ScrollEventType.f20084b, 0.0f, 0.0f);
            this.f20045i = true;
            if (fpsListener != null && (str = this.p) != null && !str.isEmpty()) {
                Assertions.c(fpsListener);
                Assertions.c(this.p);
                fpsListener.enable();
            }
            getFlingAnimator().cancel();
            return true;
        } catch (IllegalArgumentException e2) {
            FLog.r("ReactNative", "Error intercepting touch event.", e2);
            return false;
        }
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (h()) {
            int scrollX = this.A;
            if (scrollX == -1) {
                scrollX = getScrollX();
            }
            int scrollY = this.B;
            if (scrollY == -1) {
                scrollY = getScrollY();
            }
            scrollTo(scrollX, scrollY);
        }
        ReactScrollViewHelper.b(this);
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (this.y == null) {
            return;
        }
        MaintainVisibleScrollPositionHelper maintainVisibleScrollPositionHelper = this.I;
        if (maintainVisibleScrollPositionHelper != null) {
            maintainVisibleScrollPositionHelper.e();
        }
        if (isShown() && h()) {
            int scrollY = getScrollY();
            int maxScrollY = getMaxScrollY();
            if (scrollY > maxScrollY) {
                scrollTo(getScrollX(), maxScrollY);
            }
        }
        ReactScrollViewHelper.a(this);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i2, int i3) {
        MeasureSpecAssertions.a(i2, i3);
        setMeasuredDimension(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
    }

    @Override // android.widget.ScrollView, android.view.View
    public final void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        int maxScrollY;
        OverScroller overScroller = this.f20038b;
        if (overScroller != null && this.y != null && !overScroller.isFinished() && overScroller.getCurrY() != overScroller.getFinalY() && i3 >= (maxScrollY = getMaxScrollY())) {
            overScroller.abortAnimation();
            i3 = maxScrollY;
        }
        super.onOverScrolled(i2, i3, z, z2);
    }

    @Override // android.view.View
    public final void onScrollChanged(int i2, int i3, int i4, int i5) {
        OnScrollDispatchHelper onScrollDispatchHelper = this.f20037a;
        Intrinsics.checkNotNullParameter("ReactScrollView.onScrollChanged", "sectionName");
        Trace.beginSection(androidx.tracing.Trace.g("ReactScrollView.onScrollChanged"));
        try {
            super.onScrollChanged(i2, i3, i4, i5);
            this.f20042f = true;
            if (onScrollDispatchHelper.a(i2, i3)) {
                if (this.f20048l) {
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

    @Override // android.widget.ScrollView, android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (this.f20048l) {
            updateClippingRect();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        Runnable runnable;
        if (!this.f20049m || !PointerEvents.a(this.F)) {
            return false;
        }
        VelocityHelper velocityHelper = this.f20039c;
        velocityHelper.a(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 && this.f20045i) {
            ReactScrollViewHelper.k(this);
            float f2 = velocityHelper.f20092b;
            float f3 = velocityHelper.f20093c;
            ReactScrollViewHelper.c(this, ScrollEventType.f20085c, f2, f3);
            NativeGestureUtil.a(this, motionEvent);
            this.f20045i = false;
            g(Math.round(f2), Math.round(f3));
        }
        if (actionMasked == 0 && (runnable = this.f20047k) != null) {
            removeCallbacks(runnable);
            this.f20047k = null;
            getFlingAnimator().cancel();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        if (view2 != null) {
            Rect rect = new Rect();
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int iComputeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
            if (iComputeScrollDeltaToGetChildRectOnScreen != 0) {
                scrollBy(0, iComputeScrollDeltaToGetChildRectOnScreen);
            }
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.widget.ScrollView, android.view.View
    public final void scrollTo(int i2, int i3) {
        super.scrollTo(i2, i3);
        ReactScrollViewHelper.k(this);
        if (h()) {
            this.A = -1;
            this.B = -1;
        } else {
            this.A = i2;
            this.B = i3;
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

    public void setContentOffset(ReadableMap readableMap) {
        ReadableMap readableMap2 = this.z;
        if (readableMap2 == null || !readableMap2.equals(readableMap)) {
            this.z = readableMap;
            if (readableMap != null) {
                scrollTo((int) PixelUtil.b((float) (readableMap.hasKey("x") ? readableMap.getDouble("x") : 0.0d)), (int) PixelUtil.b((float) (readableMap.hasKey("y") ? readableMap.getDouble("y") : 0.0d)));
            } else {
                scrollTo(0, 0);
            }
        }
    }

    public void setDecelerationRate(float f2) {
        getReactScrollViewScrollState().f20069f = f2;
        OverScroller overScroller = this.f20038b;
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
        this.G = j2;
    }

    public void setMaintainVisibleContentPosition(@Nullable MaintainVisibleScrollPositionHelper.Config config) {
        MaintainVisibleScrollPositionHelper maintainVisibleScrollPositionHelper;
        if (config != null && this.I == null) {
            MaintainVisibleScrollPositionHelper maintainVisibleScrollPositionHelper2 = new MaintainVisibleScrollPositionHelper(this, false);
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
            this.f20044h = Overflow.f19920d;
        } else {
            Overflow overflowA = Overflow.a(str);
            if (overflowA == null) {
                overflowA = Overflow.f19920d;
            }
            this.f20044h = overflowA;
        }
        invalidate();
    }

    @Override // com.facebook.react.uimanager.ReactOverflowViewWithInset
    public final void setOverflowInset(int i2, int i3, int i4, int i5) {
        this.f20041e.set(i2, i3, i4, i5);
    }

    public void setPagingEnabled(boolean z) {
        this.f20046j = z;
    }

    public void setPointerEvents(PointerEvents pointerEvents) {
        this.F = pointerEvents;
    }

    public void setRemoveClippedSubviews(boolean z) {
        if (z && this.f20043g == null) {
            this.f20043g = new Rect();
        }
        this.f20048l = z;
        updateClippingRect();
    }

    public void setScrollAwayTopPaddingEnabledUnstable(int i2) {
        int childCount = getChildCount();
        Assertions.b(childCount <= 1, "React Native ScrollView should not have more than one child, it should have exactly 1 child; a content View");
        if (childCount > 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).setTranslationY(i2);
            }
            setPadding(0, 0, 0, i2);
        }
        getReactScrollViewScrollState().f20065b = i2;
        ReactScrollViewHelper.d(this);
        setRemoveClippedSubviews(this.f20048l);
    }

    public void setScrollEnabled(boolean z) {
        this.f20049m = z;
    }

    public void setScrollEventThrottle(int i2) {
        this.H = i2;
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
        this.C = stateWrapper;
    }

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    public final void updateClippingRect() {
        if (this.f20048l) {
            Intrinsics.checkNotNullParameter("ReactScrollView.updateClippingRect", "sectionName");
            Trace.beginSection(androidx.tracing.Trace.g("ReactScrollView.updateClippingRect"));
            try {
                Assertions.c(this.f20043g);
                ReactClippingViewGroupHelper.a(this, this.f20043g);
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
