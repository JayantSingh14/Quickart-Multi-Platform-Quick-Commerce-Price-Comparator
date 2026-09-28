package com.swmansion.gesturehandler.core;

import android.content.Context;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.facebook.react.views.scroll.ReactHorizontalScrollView;
import com.facebook.react.views.scroll.ReactScrollView;
import com.facebook.react.views.swiperefresh.ReactSwipeRefreshLayout;
import com.facebook.react.views.text.ReactTextView;
import com.facebook.react.views.textinput.ReactEditText;
import com.facebook.react.views.view.ReactViewGroup;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import com.swmansion.gesturehandler.react.ExtensionsKt;
import com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes.dex */
public final class NativeViewGestureHandler extends GestureHandler<NativeViewGestureHandler> {
    public static final NativeViewGestureHandler$Companion$defaultHook$1 P = new NativeViewGestureHandlerHook() { // from class: com.swmansion.gesturehandler.core.NativeViewGestureHandler$Companion$defaultHook$1
        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean a() {
            return false;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean b(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return true;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean c() {
            return false;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean d(View view) {
            return NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.a(view);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final Boolean e(View view, MotionEvent motionEvent) {
            return NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.c(view, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final void f(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final Boolean g(GestureHandler gestureHandler) {
            NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.d(gestureHandler);
            return null;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final void h(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
        }
    };
    public boolean M;
    public boolean N;
    public NativeViewGestureHandlerHook O = P;

    @Metadata
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final boolean a(View view, MotionEvent motionEvent) {
            return (view instanceof ViewGroup) && ((ViewGroup) view).onInterceptTouchEvent(motionEvent);
        }
    }

    @Metadata
    /* loaded from: classes4.dex */
    public static final class EditTextHook implements NativeViewGestureHandlerHook {

        /* renamed from: a, reason: collision with root package name */
        public final NativeViewGestureHandler f46745a;

        /* renamed from: b, reason: collision with root package name */
        public final ReactEditText f46746b;

        /* renamed from: c, reason: collision with root package name */
        public float f46747c;

        /* renamed from: d, reason: collision with root package name */
        public float f46748d;

        /* renamed from: e, reason: collision with root package name */
        public final int f46749e;

        public EditTextHook(NativeViewGestureHandler handler, ReactEditText editText) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(editText, "editText");
            this.f46745a = handler;
            this.f46746b = editText;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(editText.getContext());
            this.f46749e = viewConfiguration.getScaledTouchSlop() * viewConfiguration.getScaledTouchSlop();
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean a() {
            return true;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean b(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return true;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean c() {
            return true;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean d(View view) {
            return NativeViewGestureHandlerHook.DefaultImpls.a(view);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final Boolean e(View view, MotionEvent motionEvent) {
            return NativeViewGestureHandlerHook.DefaultImpls.c(view, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final void f(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            this.f46745a.a(false);
            this.f46746b.onTouchEvent(event);
            this.f46747c = event.getX();
            this.f46748d = event.getY();
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final Boolean g(GestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return Boolean.valueOf(handler.f46717d > 0 && !(handler instanceof NativeViewGestureHandler));
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final void h(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (android.support.v4.media.a.a(event.getY(), this.f46748d, event.getY() - this.f46748d, (event.getX() - this.f46747c) * (event.getX() - this.f46747c)) < this.f46749e) {
                this.f46746b.i();
            }
        }
    }

    @Metadata
    public interface NativeViewGestureHandlerHook {

        @Metadata
        /* loaded from: classes4.dex */
        public static final class DefaultImpls {
            public static boolean a(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                return view.isPressed();
            }

            public static void b(MotionEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
            }

            public static Boolean c(View view, MotionEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (view != null) {
                    return Boolean.valueOf(view.onTouchEvent(event));
                }
                return null;
            }

            public static void d(GestureHandler handler) {
                Intrinsics.checkNotNullParameter(handler, "handler");
            }
        }

        boolean a();

        boolean b(MotionEvent motionEvent);

        boolean c();

        boolean d(View view);

        Boolean e(View view, MotionEvent motionEvent);

        void f(MotionEvent motionEvent);

        Boolean g(GestureHandler gestureHandler);

        void h(MotionEvent motionEvent);
    }

    @Metadata
    /* loaded from: classes4.dex */
    public static final class ReactViewGroupHook implements NativeViewGestureHandlerHook {
        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean a() {
            return false;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean b(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return true;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean c() {
            return false;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean d(View view) {
            return NativeViewGestureHandlerHook.DefaultImpls.a(view);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final Boolean e(View view, MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (view != null) {
                return Boolean.valueOf(view.dispatchTouchEvent(event));
            }
            return null;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final void f(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final Boolean g(GestureHandler gestureHandler) {
            NativeViewGestureHandlerHook.DefaultImpls.d(gestureHandler);
            return null;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final void h(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
        }
    }

    @Metadata
    /* loaded from: classes4.dex */
    public static final class ScrollViewHook implements NativeViewGestureHandlerHook {
        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean a() {
            return true;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean b(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return true;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean c() {
            return false;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean d(View view) {
            return NativeViewGestureHandlerHook.DefaultImpls.a(view);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final Boolean e(View view, MotionEvent motionEvent) {
            return NativeViewGestureHandlerHook.DefaultImpls.c(view, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final void f(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final Boolean g(GestureHandler gestureHandler) {
            NativeViewGestureHandlerHook.DefaultImpls.d(gestureHandler);
            return null;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final void h(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
        }
    }

    @Metadata
    @SourceDebugExtension
    /* loaded from: classes4.dex */
    public static final class SwipeRefreshLayoutHook implements NativeViewGestureHandlerHook {

        /* renamed from: a, reason: collision with root package name */
        public final NativeViewGestureHandler f46750a;

        /* renamed from: b, reason: collision with root package name */
        public final ReactSwipeRefreshLayout f46751b;

        public SwipeRefreshLayoutHook(NativeViewGestureHandler handler, ReactSwipeRefreshLayout swipeRefreshLayout) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(swipeRefreshLayout, "swipeRefreshLayout");
            this.f46750a = handler;
            this.f46751b = swipeRefreshLayout;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean a() {
            return false;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean b(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return true;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean c() {
            return true;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean d(View view) {
            return NativeViewGestureHandlerHook.DefaultImpls.a(view);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final Boolean e(View view, MotionEvent motionEvent) {
            return NativeViewGestureHandlerHook.DefaultImpls.c(view, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final void f(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            View childAt = this.f46751b.getChildAt(0);
            GestureHandler gestureHandler = null;
            ScrollView view = childAt instanceof ScrollView ? (ScrollView) childAt : null;
            if (view == null) {
                return;
            }
            NativeViewGestureHandler nativeViewGestureHandler = this.f46750a;
            GestureHandlerOrchestrator gestureHandlerOrchestrator = nativeViewGestureHandler.A;
            if (gestureHandlerOrchestrator != null) {
                Intrinsics.checkNotNullParameter(view, "view");
                ArrayList<GestureHandler> arrayListE = gestureHandlerOrchestrator.f46734b.e(view);
                if (arrayListE != null) {
                    for (GestureHandler gestureHandler2 : arrayListE) {
                        if (gestureHandler2 instanceof NativeViewGestureHandler) {
                            gestureHandler = gestureHandler2;
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
            }
            if (gestureHandler == null || gestureHandler.f46719f != 4 || view.getScrollY() <= 0) {
                return;
            }
            nativeViewGestureHandler.l();
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final Boolean g(GestureHandler gestureHandler) {
            NativeViewGestureHandlerHook.DefaultImpls.d(gestureHandler);
            return null;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final void h(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
        }
    }

    @Metadata
    /* loaded from: classes4.dex */
    public static final class TextViewHook implements NativeViewGestureHandlerHook {
        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean a() {
            return false;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean b(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return true;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean c() {
            return false;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final boolean d(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            return view instanceof ReactTextView;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final Boolean e(View view, MotionEvent motionEvent) {
            return NativeViewGestureHandlerHook.DefaultImpls.c(view, motionEvent);
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final void f(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final Boolean g(GestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return Boolean.FALSE;
        }

        @Override // com.swmansion.gesturehandler.core.NativeViewGestureHandler.NativeViewGestureHandlerHook
        public final void h(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
        }
    }

    public NativeViewGestureHandler() {
        this.y = true;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final boolean C(GestureHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        return !this.N;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final boolean D(GestureHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Boolean boolG = this.O.g(handler);
        if (boolG != null) {
            return boolG.booleanValue();
        }
        if (super.D(handler)) {
            return true;
        }
        if (handler instanceof NativeViewGestureHandler) {
            NativeViewGestureHandler nativeViewGestureHandler = (NativeViewGestureHandler) handler;
            if (nativeViewGestureHandler.f46719f == 4 && nativeViewGestureHandler.N) {
                return false;
            }
        }
        boolean z = this.N;
        int i2 = handler.f46719f;
        int i3 = this.f46719f;
        if ((i3 == 4 && i2 == 4 && !z) || i3 != 4 || z) {
            return false;
        }
        return !this.O.a() || handler.f46717d > 0;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void s() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        motionEventObtain.setAction(3);
        this.O.e(this.f46718e, motionEventObtain);
        motionEventObtain.recycle();
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void t(MotionEvent event, MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        View view = this.f46718e;
        Intrinsics.c(view);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        boolean zC = ExtensionsKt.c(context);
        if ((view instanceof RNGestureHandlerButtonViewManager.ButtonViewGroup) && zC) {
            return;
        }
        if (event.getActionMasked() == 1) {
            if (this.f46719f != 0 || this.O.b(event)) {
                this.O.e(view, event);
                int i2 = this.f46719f;
                if ((i2 == 0 || i2 == 2) && this.O.d(view)) {
                    a(false);
                }
                if (this.f46719f == 0) {
                    e();
                } else {
                    j();
                }
            } else {
                e();
            }
            this.O.h(event);
            return;
        }
        int i3 = this.f46719f;
        if (i3 != 0 && i3 != 2) {
            if (i3 == 4) {
                this.O.e(view, event);
                return;
            }
            return;
        }
        if (this.M) {
            Companion.a(view, event);
            this.O.e(view, event);
            a(false);
        } else if (Companion.a(view, event)) {
            this.O.e(view, event);
            a(false);
        } else if (this.O.c()) {
            this.O.f(event);
        } else {
            if (this.f46719f == 2 || !this.O.b(event)) {
                return;
            }
            d();
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void v() {
        KeyEvent.Callback callback = this.f46718e;
        if (callback instanceof NativeViewGestureHandlerHook) {
            this.O = (NativeViewGestureHandlerHook) callback;
            return;
        }
        if (callback instanceof ReactEditText) {
            this.O = new EditTextHook(this, (ReactEditText) callback);
            return;
        }
        if (callback instanceof ReactSwipeRefreshLayout) {
            this.O = new SwipeRefreshLayoutHook(this, (ReactSwipeRefreshLayout) callback);
            return;
        }
        if (callback instanceof ReactScrollView) {
            this.O = new ScrollViewHook();
            return;
        }
        if (callback instanceof ReactHorizontalScrollView) {
            this.O = new ScrollViewHook();
        } else if (callback instanceof ReactTextView) {
            this.O = new TextViewHook();
        } else if (callback instanceof ReactViewGroup) {
            this.O = new ReactViewGroupHook();
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void w() {
        this.O = P;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void y() {
        super.y();
        this.M = false;
        this.N = false;
    }
}
