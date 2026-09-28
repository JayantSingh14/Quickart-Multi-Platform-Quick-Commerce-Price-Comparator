package io.sentry.react;

import android.app.Activity;
import android.view.View;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import io.sentry.SentryLevel;
import io.sentry.android.core.AndroidLogger;
import io.sentry.android.core.BuildInfoProvider;
import io.sentry.android.core.SentryAndroidDateProvider;
import io.sentry.android.core.internal.util.FirstDrawDoneListener;
import io.sentry.react.utils.RNSentryActivityUtils;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes.dex */
public class RNSentryOnDrawReporterManager extends SimpleViewManager<RNSentryOnDrawReporterView> {
    public static final String REACT_CLASS = "RNSentryOnDrawReporter";
    public static final String TTFD_PREFIX = "ttfd-";
    public static final String TTID_PREFIX = "ttid-";

    @NotNull
    private final ReactApplicationContext mCallerContext;

    public static class RNSentryOnDrawReporterView extends View {

        /* renamed from: h, reason: collision with root package name */
        public static final AndroidLogger f52999h = new AndroidLogger("RNSentryOnDrawReporterView");

        /* renamed from: a, reason: collision with root package name */
        public final ReactApplicationContext f53000a;

        /* renamed from: b, reason: collision with root package name */
        public final SentryAndroidDateProvider f53001b;

        /* renamed from: c, reason: collision with root package name */
        public final BuildInfoProvider f53002c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f53003d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f53004e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f53005f;

        /* renamed from: g, reason: collision with root package name */
        public String f53006g;

        public RNSentryOnDrawReporterView(ReactApplicationContext reactApplicationContext, BuildInfoProvider buildInfoProvider) {
            super(reactApplicationContext);
            this.f53001b = new SentryAndroidDateProvider();
            this.f53003d = false;
            this.f53004e = false;
            this.f53005f = false;
            this.f53006g = null;
            this.f53000a = reactApplicationContext;
            this.f53002c = buildInfoProvider;
        }

        public final void a() {
            if (this.f53006g == null) {
                return;
            }
            boolean z = this.f53005f;
            AndroidLogger androidLogger = f52999h;
            if (z) {
                androidLogger.c(SentryLevel.DEBUG, "[TimeToDisplay] Already recorded time to display for spanId: " + this.f53006g, new Object[0]);
                return;
            }
            if (this.f53003d) {
                androidLogger.c(SentryLevel.DEBUG, "[TimeToDisplay] Register initial display event emitter.", new Object[0]);
            } else {
                if (!this.f53004e) {
                    androidLogger.c(SentryLevel.DEBUG, "[TimeToDisplay] Not ready, missing displayType prop.", new Object[0]);
                    return;
                }
                androidLogger.c(SentryLevel.DEBUG, "[TimeToDisplay] Register full display event emitter.", new Object[0]);
            }
            BuildInfoProvider buildInfoProvider = this.f53002c;
            if (buildInfoProvider == null) {
                androidLogger.c(SentryLevel.ERROR, "[TimeToDisplay] Won't emit next frame drawn event, buildInfo is null.", new Object[0]);
                return;
            }
            ReactApplicationContext reactApplicationContext = this.f53000a;
            if (reactApplicationContext == null) {
                androidLogger.c(SentryLevel.ERROR, "[TimeToDisplay] Won't emit next frame drawn event, reactContext is null.", new Object[0]);
                return;
            }
            Activity activityA = RNSentryActivityUtils.a(reactApplicationContext);
            if (activityA == null) {
                androidLogger.c(SentryLevel.ERROR, "[TimeToDisplay] Won't emit next frame drawn event, activity is null.", new Object[0]);
            } else {
                this.f53005f = true;
                FirstDrawDoneListener.a(activityA, new com.swmansion.gesturehandler.react.b(this, 11), buildInfoProvider);
            }
        }

        public void setFullDisplay(boolean z) {
            if (z != this.f53004e) {
                this.f53004e = z;
                a();
            }
        }

        public void setInitialDisplay(boolean z) {
            if (z != this.f53003d) {
                this.f53003d = z;
                a();
            }
        }

        public void setParentSpanId(@Nullable String str) {
            if (Objects.equals(str, this.f53006g)) {
                return;
            }
            this.f53006g = str;
            this.f53005f = false;
            a();
        }
    }

    public RNSentryOnDrawReporterManager(ReactApplicationContext reactApplicationContext) {
        this.mCallerContext = reactApplicationContext;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return REACT_CLASS;
    }

    @ReactProp(defaultBoolean = false, name = "fullDisplay")
    public void setFullDisplay(RNSentryOnDrawReporterView rNSentryOnDrawReporterView, boolean z) {
        rNSentryOnDrawReporterView.setFullDisplay(z);
    }

    @ReactProp(defaultBoolean = false, name = "initialDisplay")
    public void setInitialDisplay(RNSentryOnDrawReporterView rNSentryOnDrawReporterView, boolean z) {
        rNSentryOnDrawReporterView.setInitialDisplay(z);
    }

    @ReactProp(name = "parentSpanId")
    public void setParentSpanId(RNSentryOnDrawReporterView rNSentryOnDrawReporterView, String str) {
        rNSentryOnDrawReporterView.setParentSpanId(str);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public RNSentryOnDrawReporterView createViewInstance(@NotNull ThemedReactContext themedReactContext) {
        return new RNSentryOnDrawReporterView(this.mCallerContext, new BuildInfoProvider(new AndroidLogger()));
    }
}
