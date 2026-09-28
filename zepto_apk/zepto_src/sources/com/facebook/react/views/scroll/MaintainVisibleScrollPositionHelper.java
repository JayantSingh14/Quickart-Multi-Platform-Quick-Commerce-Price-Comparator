package com.facebook.react.views.scroll;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.facebook.react.views.scroll.ReactScrollViewHelper.HasSmoothScroll;
import com.facebook.react.views.view.ReactViewGroup;
import java.lang.ref.WeakReference;

@Nullsafe
/* loaded from: classes3.dex */
class MaintainVisibleScrollPositionHelper<ScrollViewT extends ViewGroup & ReactScrollViewHelper.HasSmoothScroll> implements UIManagerListener {

    /* renamed from: a, reason: collision with root package name */
    public final FrameLayout f20005a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f20006b;

    /* renamed from: c, reason: collision with root package name */
    public Config f20007c;

    /* renamed from: d, reason: collision with root package name */
    public WeakReference f20008d = null;

    /* renamed from: e, reason: collision with root package name */
    public Rect f20009e = null;

    /* renamed from: f, reason: collision with root package name */
    public boolean f20010f = false;

    public static class Config {

        /* renamed from: a, reason: collision with root package name */
        public final int f20012a;

        /* renamed from: b, reason: collision with root package name */
        public final Integer f20013b;

        public Config(int i2, Integer num) {
            this.f20012a = i2;
            this.f20013b = num;
        }

        public static Config a(ReadableMap readableMap) {
            return new Config(readableMap.getInt("minIndexForVisible"), readableMap.hasKey("autoscrollToTopThreshold") ? Integer.valueOf(readableMap.getInt("autoscrollToTopThreshold")) : null);
        }
    }

    public MaintainVisibleScrollPositionHelper(FrameLayout frameLayout, boolean z) {
        this.f20005a = frameLayout;
        this.f20006b = z;
    }

    public final void a() {
        float y;
        int height;
        if (this.f20007c == null) {
            return;
        }
        FrameLayout frameLayout = this.f20005a;
        ReactViewGroup reactViewGroup = (ReactViewGroup) frameLayout.getChildAt(0);
        if (reactViewGroup == null) {
            return;
        }
        boolean z = this.f20006b;
        int scrollX = z ? frameLayout.getScrollX() : frameLayout.getScrollY();
        for (int i2 = this.f20007c.f20012a; i2 < reactViewGroup.getChildCount(); i2++) {
            View childAt = reactViewGroup.getChildAt(i2);
            if (z) {
                y = childAt.getX();
                height = childAt.getWidth();
            } else {
                y = childAt.getY();
                height = childAt.getHeight();
            }
            if (y + height > scrollX || i2 == reactViewGroup.getChildCount() - 1) {
                this.f20008d = new WeakReference(childAt);
                Rect rect = new Rect();
                childAt.getHitRect(rect);
                this.f20009e = rect;
                return;
            }
        }
    }

    public final void b(Config config) {
        this.f20007c = config;
    }

    public final void c() {
        if (this.f20010f) {
            return;
        }
        this.f20010f = true;
        FrameLayout frameLayout = this.f20005a;
        UIManager uIManagerF = UIManagerHelper.f((ReactContext) frameLayout.getContext(), ViewUtil.a(frameLayout.getId()), true);
        Assertions.c(uIManagerF);
        uIManagerF.addUIManagerEventListener(this);
    }

    public final void d() {
        if (this.f20010f) {
            this.f20010f = false;
            FrameLayout frameLayout = this.f20005a;
            UIManager uIManagerF = UIManagerHelper.f((ReactContext) frameLayout.getContext(), ViewUtil.a(frameLayout.getId()), true);
            Assertions.c(uIManagerF);
            uIManagerF.removeUIManagerEventListener(this);
        }
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public final void didDispatchMountItems(UIManager uIManager) {
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public final void didMountItems(UIManager uIManager) {
        f();
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public final void didScheduleMountItems(UIManager uIManager) {
    }

    public final void e() {
        if (ViewUtil.a(this.f20005a.getId()) == 2) {
            return;
        }
        f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f() {
        WeakReference weakReference;
        View view;
        if (this.f20007c == null || (weakReference = this.f20008d) == null || this.f20009e == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        Rect rect = new Rect();
        view.getHitRect(rect);
        FrameLayout frameLayout = this.f20005a;
        if (this.f20006b) {
            int i2 = rect.left - this.f20009e.left;
            if (i2 != 0) {
                int scrollX = frameLayout.getScrollX();
                ReactScrollViewHelper.HasSmoothScroll hasSmoothScroll = (ReactScrollViewHelper.HasSmoothScroll) frameLayout;
                hasSmoothScroll.a(i2 + scrollX, frameLayout.getScrollY());
                this.f20009e = rect;
                Integer num = this.f20007c.f20013b;
                if (num == null || scrollX > num.intValue()) {
                    return;
                }
                hasSmoothScroll.b(0, frameLayout.getScrollY());
                return;
            }
            return;
        }
        int i3 = rect.top - this.f20009e.top;
        if (i3 != 0) {
            int scrollY = frameLayout.getScrollY();
            ReactScrollViewHelper.HasSmoothScroll hasSmoothScroll2 = (ReactScrollViewHelper.HasSmoothScroll) frameLayout;
            hasSmoothScroll2.a(frameLayout.getScrollX(), i3 + scrollY);
            this.f20009e = rect;
            Integer num2 = this.f20007c.f20013b;
            if (num2 == null || scrollY > num2.intValue()) {
                return;
            }
            hasSmoothScroll2.b(frameLayout.getScrollX(), 0);
        }
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public final void willDispatchViewUpdates(UIManager uIManager) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.views.scroll.MaintainVisibleScrollPositionHelper.1
            @Override // java.lang.Runnable
            public final void run() {
                MaintainVisibleScrollPositionHelper.this.a();
            }
        });
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public final void willMountItems(UIManager uIManager) {
        a();
    }
}
