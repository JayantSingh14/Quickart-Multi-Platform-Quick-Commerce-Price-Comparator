package com.swmansion.gesturehandler.core;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.swmansion.gesturehandler.core.StylusData;
import com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper;
import com.swmansion.gesturehandler.react.RNViewConfigurationHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class HoverGestureHandler extends GestureHandler<HoverGestureHandler> {
    public static final RNViewConfigurationHelper P = new RNViewConfigurationHelper();
    public Handler M;
    public final androidx.constraintlayout.helper.widget.a N = new androidx.constraintlayout.helper.widget.a(this, 26);
    public StylusData O = new StylusData(0);

    @Metadata
    /* loaded from: classes4.dex */
    public static final class Companion {
    }

    public static Boolean J(View view, View view2, View view3) {
        if (Intrinsics.b(view3, view2)) {
            return Boolean.TRUE;
        }
        if (Intrinsics.b(view3, view)) {
            return Boolean.FALSE;
        }
        if (!(view3 instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view3;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            Boolean boolJ = J(view, view2, P.a(viewGroup, i2));
            if (boolJ != null) {
                return boolJ;
            }
        }
        return null;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final boolean C(GestureHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (handler instanceof HoverGestureHandler) {
            HoverGestureHandler hoverGestureHandler = (HoverGestureHandler) handler;
            if (!hoverGestureHandler.I(this)) {
                View view = hoverGestureHandler.f46718e;
                Intrinsics.c(view);
                View view2 = this.f46718e;
                Intrinsics.c(view2);
                Boolean boolJ = J(view, view2, view.getRootView());
                Intrinsics.c(boolJ);
                return boolJ.booleanValue();
            }
        }
        return super.C(handler);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final boolean D(GestureHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (((handler instanceof HoverGestureHandler) && (I(handler) || ((HoverGestureHandler) handler).I(this))) || (handler instanceof RNGestureHandlerRootHelper.RootViewGestureHandler)) {
            return true;
        }
        return super.D(handler);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final boolean E(GestureHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if ((handler instanceof HoverGestureHandler) && !I(handler)) {
            HoverGestureHandler hoverGestureHandler = (HoverGestureHandler) handler;
            if (!hoverGestureHandler.I(this)) {
                View view = this.f46718e;
                Intrinsics.c(view);
                View view2 = hoverGestureHandler.f46718e;
                Intrinsics.c(view2);
                Boolean boolJ = J(view, view2, view.getRootView());
                if (boolJ != null) {
                    return boolJ.booleanValue();
                }
            }
        }
        return super.E(handler);
    }

    public final void H() {
        int i2 = this.f46719f;
        if (i2 == 0) {
            e();
        } else if (i2 == 2) {
            l();
        } else {
            if (i2 != 4) {
                return;
            }
            j();
        }
    }

    public final boolean I(GestureHandler gestureHandler) {
        View view = gestureHandler.f46718e;
        while (view != null) {
            if (view.equals(this.f46718e)) {
                return true;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return false;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void t(MotionEvent event, MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (event.getAction() == 0) {
            Handler handler = this.M;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.M = null;
            return;
        }
        if (event.getAction() != 1 || this.f46722i) {
            return;
        }
        H();
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void u(MotionEvent event, MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (event.getAction() == 10) {
            if (this.M == null) {
                this.M = new Handler(Looper.getMainLooper());
            }
            Handler handler = this.M;
            Intrinsics.c(handler);
            handler.postDelayed(this.N, 4L);
            return;
        }
        if (!this.f46722i) {
            H();
            return;
        }
        if (this.f46719f == 4 && event.getToolType(0) == 2) {
            this.O = StylusData.Companion.a(event);
            return;
        }
        if (this.f46719f == 0) {
            if (event.getAction() == 7 || event.getAction() == 9) {
                d();
                a(false);
            }
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void w() {
        this.O = new StylusData(0);
    }
}
