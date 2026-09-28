package com.facebook.react.devsupport;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.common.logging.FLog;
import com.facebook.react.R;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.modules.debug.DidJSUpdateUiDuringFrameDetector;
import com.facebook.react.modules.debug.FpsDebugFrameCallback;
import com.facebook.react.uimanager.UIManagerModule;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class FpsView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f18843a;

    /* renamed from: b, reason: collision with root package name */
    public final FpsDebugFrameCallback f18844b;

    /* renamed from: c, reason: collision with root package name */
    public final FPSMonitorRunnable f18845c;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public final class FPSMonitorRunnable implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public boolean f18846a;

        /* renamed from: b, reason: collision with root package name */
        public int f18847b;

        /* renamed from: c, reason: collision with root package name */
        public int f18848c;

        public FPSMonitorRunnable() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i2;
            double d2;
            if (this.f18846a) {
                return;
            }
            int i3 = this.f18847b;
            FpsView fpsView = FpsView.this;
            FpsDebugFrameCallback fpsDebugFrameCallback = fpsView.f18844b;
            long j2 = fpsDebugFrameCallback.f19090f;
            long j3 = fpsDebugFrameCallback.f19089e;
            int i4 = (((int) (((fpsDebugFrameCallback.f19095k * ((int) ((j2 - j3) / 1000000.0d))) / 1000) + 1)) - (fpsDebugFrameCallback.f19091g - 1)) + i3;
            this.f18847b = i4;
            int i5 = this.f18848c + fpsDebugFrameCallback.f19093i;
            this.f18848c = i5;
            if (j2 == j3) {
                i2 = i4;
                d2 = 0.0d;
            } else {
                i2 = i4;
                d2 = ((r10 - 1) * 1.0E9d) / (j2 - j3);
            }
            fpsView.a(d2, j2 != j3 ? ((fpsDebugFrameCallback.f19094j - 1) * 1.0E9d) / (j2 - j3) : 0.0d, i2, i5);
            FpsDebugFrameCallback fpsDebugFrameCallback2 = fpsView.f18844b;
            fpsDebugFrameCallback2.f19089e = -1L;
            fpsDebugFrameCallback2.f19090f = -1L;
            fpsDebugFrameCallback2.f19091g = 0;
            fpsDebugFrameCallback2.f19093i = 0;
            fpsDebugFrameCallback2.f19094j = 0;
            fpsView.postDelayed(this, 500L);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FpsView(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        Intrinsics.c(reactApplicationContext);
        View.inflate(reactApplicationContext, R.layout.fps_view, this);
        View viewFindViewById = findViewById(R.id.fps_text);
        Intrinsics.d(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.f18843a = (TextView) viewFindViewById;
        this.f18844b = new FpsDebugFrameCallback(reactApplicationContext);
        this.f18845c = new FPSMonitorRunnable();
        a(0.0d, 0.0d, 0, 0);
    }

    public final void a(double d2, double d3, int i2, int i3) {
        String str = String.format(Locale.US, "UI: %.1f fps\n%d dropped so far\n%d stutters (4+) so far\nJS: %.1f fps", Arrays.copyOf(new Object[]{Double.valueOf(d2), Integer.valueOf(i2), Integer.valueOf(i3), Double.valueOf(d3)}, 4));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        this.f18843a.setText(str);
        FLog.a("ReactNative", str);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        FpsDebugFrameCallback fpsDebugFrameCallback = this.f18844b;
        fpsDebugFrameCallback.f19089e = -1L;
        fpsDebugFrameCallback.f19090f = -1L;
        fpsDebugFrameCallback.f19091g = 0;
        fpsDebugFrameCallback.f19093i = 0;
        fpsDebugFrameCallback.f19094j = 0;
        double d2 = fpsDebugFrameCallback.f19095k;
        ReactApplicationContext reactApplicationContext = fpsDebugFrameCallback.f19085a;
        boolean zIsBridgeless = reactApplicationContext.isBridgeless();
        DidJSUpdateUiDuringFrameDetector didJSUpdateUiDuringFrameDetector = fpsDebugFrameCallback.f19088d;
        if (!zIsBridgeless) {
            reactApplicationContext.getCatalystInstance().addBridgeIdleDebugListener(didJSUpdateUiDuringFrameDetector);
        }
        UIManagerModule uIManagerModule = fpsDebugFrameCallback.f19087c;
        if (uIManagerModule != null) {
            uIManagerModule.setViewHierarchyUpdateDebugListener(didJSUpdateUiDuringFrameDetector);
        }
        fpsDebugFrameCallback.f19095k = d2;
        UiThreadUtil.runOnUiThread(new com.facebook.react.modules.debug.b(fpsDebugFrameCallback, 0));
        FPSMonitorRunnable fPSMonitorRunnable = this.f18845c;
        fPSMonitorRunnable.f18846a = false;
        FpsView.this.post(fPSMonitorRunnable);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FpsDebugFrameCallback fpsDebugFrameCallback = this.f18844b;
        ReactApplicationContext reactApplicationContext = fpsDebugFrameCallback.f19085a;
        if (!reactApplicationContext.isBridgeless()) {
            reactApplicationContext.getCatalystInstance().removeBridgeIdleDebugListener(fpsDebugFrameCallback.f19088d);
        }
        UIManagerModule uIManagerModule = fpsDebugFrameCallback.f19087c;
        if (uIManagerModule != null) {
            uIManagerModule.setViewHierarchyUpdateDebugListener(null);
        }
        UiThreadUtil.runOnUiThread(new com.facebook.react.modules.debug.b(fpsDebugFrameCallback, 1));
        this.f18845c.f18846a = true;
    }
}
