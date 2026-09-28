package com.facebook.react.views.scroll;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.util.Pools;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.facebook.react.views.scroll.ScrollEvent;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xbill.DNS.Type;

@Metadata
/* loaded from: classes.dex */
public final class ReactScrollViewHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList f20059a = new CopyOnWriteArrayList();

    /* renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList f20060b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    public static int f20061c = Type.TSIG;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f20062d;

    @Metadata
    public interface HasFlingAnimator {
        void c(int i2, int i3);

        ValueAnimator getFlingAnimator();
    }

    @Metadata
    public interface HasScrollEventThrottle {
        long getLastScrollDispatchTime();

        int getScrollEventThrottle();

        void setLastScrollDispatchTime(long j2);
    }

    @Metadata
    public interface HasScrollState {
        ReactScrollViewScrollState getReactScrollViewScrollState();
    }

    @Metadata
    public interface HasSmoothScroll {
        void a(int i2, int i3);

        void b(int i2, int i3);
    }

    @Metadata
    public interface HasStateWrapper {
        StateWrapper getStateWrapper();
    }

    @Metadata
    /* loaded from: classes3.dex */
    public interface LayoutChangeListener {
        void a();
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class OverScrollerDurationGetter extends OverScroller {

        /* renamed from: a, reason: collision with root package name */
        public int f20063a;

        public OverScrollerDurationGetter(Context context) {
            super(context);
            this.f20063a = Type.TSIG;
        }

        public final int a() {
            startScroll(0, 0, 0, 0);
            return this.f20063a;
        }

        @Override // android.widget.OverScroller
        public final void startScroll(int i2, int i3, int i4, int i5, int i6) {
            this.f20063a = i6;
        }
    }

    @Metadata
    public static final class ReactScrollViewScrollState {

        /* renamed from: b, reason: collision with root package name */
        public int f20065b;

        /* renamed from: d, reason: collision with root package name */
        public boolean f20067d;

        /* renamed from: a, reason: collision with root package name */
        public final Point f20064a = new Point();

        /* renamed from: c, reason: collision with root package name */
        public final Point f20066c = new Point(-1, -1);

        /* renamed from: e, reason: collision with root package name */
        public boolean f20068e = true;

        /* renamed from: f, reason: collision with root package name */
        public float f20069f = 0.985f;
    }

    @Metadata
    /* loaded from: classes3.dex */
    public interface ScrollListener {
        void a();

        void b();
    }

    public static final void a(FrameLayout scrollView) {
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        Iterator it = f20060b.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            LayoutChangeListener layoutChangeListener = (LayoutChangeListener) ((WeakReference) it.next()).get();
            if (layoutChangeListener != null) {
                layoutChangeListener.a();
            }
        }
    }

    public static final void b(FrameLayout scrollView) {
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        Iterator it = f20059a.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            ScrollListener scrollListener = (ScrollListener) ((WeakReference) it.next()).get();
            if (scrollListener != null) {
                scrollListener.a();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(ViewGroup viewGroup, ScrollEventType scrollEventType, float f2, float f3) {
        View childAt;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (r3.getScrollEventThrottle() < Math.max(17L, jCurrentTimeMillis - ((HasScrollEventThrottle) viewGroup).getLastScrollDispatchTime()) && (childAt = viewGroup.getChildAt(0)) != null) {
            Iterator it = f20059a.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                ScrollListener scrollListener = (ScrollListener) ((WeakReference) it.next()).get();
                if (scrollListener != null) {
                    scrollListener.b();
                }
            }
            Context context = viewGroup.getContext();
            Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            ReactContext reactContext = (ReactContext) context;
            int iD = UIManagerHelper.d(reactContext);
            EventDispatcher eventDispatcherB = UIManagerHelper.b(reactContext, viewGroup.getId());
            if (eventDispatcherB != null) {
                Pools.SynchronizedPool synchronizedPool = ScrollEvent.f20072k;
                eventDispatcherB.g(ScrollEvent.Companion.a(iD, viewGroup.getId(), scrollEventType, viewGroup.getScrollX(), viewGroup.getScrollY(), f2, f3, childAt.getWidth(), childAt.getHeight(), viewGroup.getWidth(), viewGroup.getHeight()));
                ((HasScrollEventThrottle) viewGroup).setLastScrollDispatchTime(jCurrentTimeMillis);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void d(ViewGroup viewGroup) {
        ReactScrollViewScrollState reactScrollViewScrollState = ((HasScrollState) viewGroup).getReactScrollViewScrollState();
        int i2 = reactScrollViewScrollState.f20065b;
        Point point = reactScrollViewScrollState.f20066c;
        int i3 = point.x;
        int i4 = point.y;
        StateWrapper stateWrapper = ((HasStateWrapper) viewGroup).getStateWrapper();
        if (stateWrapper != null) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putDouble("contentOffsetLeft", PixelUtil.a(i3));
            writableNativeMap.putDouble("contentOffsetTop", PixelUtil.a(i4));
            writableNativeMap.putDouble("scrollAwayPaddingTop", PixelUtil.a(i2));
            stateWrapper.updateState(writableNativeMap);
        }
    }

    public static final int e(Context context) {
        if (!f20062d) {
            f20062d = true;
            try {
                f20061c = new OverScrollerDurationGetter(context).a();
            } catch (Throwable unused) {
            }
        }
        return f20061c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final int f(FrameLayout frameLayout, int i2, int i3, int i4) {
        ReactScrollViewScrollState reactScrollViewScrollState = ((HasScrollState) frameLayout).getReactScrollViewScrollState();
        return (!reactScrollViewScrollState.f20068e || (reactScrollViewScrollState.f20067d && ((i3 - i2) * (i4 != 0 ? i4 / Math.abs(i4) : 0) > 0))) ? i3 : i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
    
        if (r3.equals("auto") != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int g(java.lang.String r3) {
        /*
            r0 = 1
            if (r3 == 0) goto L41
            int r1 = r3.hashCode()
            r2 = -1414557169(0xffffffffabaf920f, float:-1.2475037E-12)
            if (r1 == r2) goto L2b
            r2 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r1 == r2) goto L22
            r2 = 104712844(0x63dca8c, float:3.5695757E-35)
            if (r1 == r2) goto L17
            goto L33
        L17:
            java.lang.String r1 = "never"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L20
            goto L33
        L20:
            r3 = 2
            return r3
        L22:
            java.lang.String r1 = "auto"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L33
            goto L41
        L2b:
            java.lang.String r1 = "always"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L3f
        L33:
            java.lang.String r1 = "wrong overScrollMode: "
            java.lang.String r3 = r1.concat(r3)
            java.lang.String r1 = "ReactNative"
            com.facebook.common.logging.FLog.q(r1, r3)
            return r0
        L3f:
            r3 = 0
            return r3
        L41:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.scroll.ReactScrollViewHelper.g(java.lang.String):int");
    }

    public static final int h(String str) {
        if (str == null) {
            return 0;
        }
        if ("start".equalsIgnoreCase(str)) {
            return 1;
        }
        if ("center".equalsIgnoreCase(str)) {
            return 2;
        }
        if ("end".equals(str)) {
            return 3;
        }
        FLog.q("ReactNative", "wrong snap alignment value: ".concat(str));
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Point i(FrameLayout frameLayout, int i2, int i3, int i4, int i5) {
        ReactScrollViewScrollState reactScrollViewScrollState = ((HasScrollState) frameLayout).getReactScrollViewScrollState();
        OverScroller overScroller = new OverScroller(frameLayout.getContext());
        overScroller.setFriction(1.0f - reactScrollViewScrollState.f20069f);
        int width = (frameLayout.getWidth() - frameLayout.getPaddingStart()) - frameLayout.getPaddingEnd();
        int height = (frameLayout.getHeight() - frameLayout.getPaddingBottom()) - frameLayout.getPaddingTop();
        Point point = reactScrollViewScrollState.f20064a;
        overScroller.fling(f(frameLayout, frameLayout.getScrollX(), point.x, i2), f(frameLayout, frameLayout.getScrollY(), point.y, i3), i2, i3, 0, i4, 0, i5, width / 2, height / 2);
        return new Point(overScroller.getFinalX(), overScroller.getFinalY());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void j(final FrameLayout frameLayout, int i2, int i3) {
        HasFlingAnimator hasFlingAnimator = (HasFlingAnimator) frameLayout;
        ValueAnimator flingAnimator = hasFlingAnimator.getFlingAnimator();
        if (flingAnimator.getListeners() == null || flingAnimator.getListeners().size() == 0) {
            hasFlingAnimator.getFlingAnimator().addListener(new Animator.AnimatorListener() { // from class: com.facebook.react.views.scroll.ReactScrollViewHelper$registerFlingAnimator$1
                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                    ((ReactScrollViewHelper.HasScrollState) frameLayout).getReactScrollViewScrollState().f20067d = true;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                    FrameLayout frameLayout2 = frameLayout;
                    ((ReactScrollViewHelper.HasScrollState) frameLayout2).getReactScrollViewScrollState().f20068e = true;
                    ReactScrollViewHelper.k(frameLayout2);
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationRepeat(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                    ReactScrollViewHelper.ReactScrollViewScrollState reactScrollViewScrollState = ((ReactScrollViewHelper.HasScrollState) frameLayout).getReactScrollViewScrollState();
                    reactScrollViewScrollState.f20067d = false;
                    reactScrollViewScrollState.f20068e = false;
                }
            });
        }
        ((HasScrollState) frameLayout).getReactScrollViewScrollState().f20064a.set(i2, i3);
        int scrollX = frameLayout.getScrollX();
        int scrollY = frameLayout.getScrollY();
        if (scrollX != i2) {
            hasFlingAnimator.c(scrollX, i2);
        }
        if (scrollY != i3) {
            hasFlingAnimator.c(scrollY, i3);
        }
    }

    public static final void k(ViewGroup viewGroup) {
        l(viewGroup, viewGroup.getScrollX(), viewGroup.getScrollY());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void l(ViewGroup viewGroup, int i2, int i3) {
        if (ViewUtil.a(viewGroup.getId()) == 1) {
            return;
        }
        ReactScrollViewScrollState reactScrollViewScrollState = ((HasScrollState) viewGroup).getReactScrollViewScrollState();
        if (reactScrollViewScrollState.f20066c.equals(i2, i3)) {
            return;
        }
        reactScrollViewScrollState.f20066c.set(i2, i3);
        d(viewGroup);
    }
}
