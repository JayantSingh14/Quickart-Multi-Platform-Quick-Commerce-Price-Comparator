package com.swmansion.gesturehandler.react;

import android.view.View;
import androidx.activity.OnBackPressedCallback;
import com.facebook.react.uimanager.UIManagerModule;
import com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.ScreenFragmentWrapper;
import com.swmansion.rnscreens.ScreenStack;
import com.th3rdwave.safeareacontext.SafeAreaView;
import com.truecaller.android.sdk.common.callbacks.MissedCallInstallationCallback;
import com.unistyles.UnistylesModule;
import com.zeptoconsumerapp.GoogleAdsManager.GAMView;
import in.juspay.hyperapay.APayBridge;
import in.juspay.hypersdk.safe.Godel;
import in.juspay.hypersmshandler.SmsRetriever;
import io.sentry.SentryLevel;
import io.sentry.android.core.AndroidLogger;
import io.sentry.android.replay.capture.BufferCaptureStrategy;
import io.sentry.react.RNSentryOnDrawReporterManager;
import io.sentry.react.RNSentryTimeToDisplay;
import io.sentry.util.FileUtils;
import java.io.File;

/* loaded from: classes4.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f46860a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f46861b;

    public /* synthetic */ b(Object obj, int i2) {
        this.f46860a = i2;
        this.f46861b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Screen screenK;
        Object obj = this.f46861b;
        switch (this.f46860a) {
            case 0:
                RNGestureHandlerRootHelper.RootViewGestureHandler rootViewGestureHandler = ((RNGestureHandlerRootHelper) obj).f46847c;
                if (rootViewGestureHandler != null && rootViewGestureHandler.f46719f == 2) {
                    rootViewGestureHandler.a(false);
                    rootViewGestureHandler.j();
                    break;
                }
                break;
            case 1:
                int i2 = ScreenStack.r;
                ScreenFragmentWrapper screenFragmentWrapper = (ScreenFragmentWrapper) obj;
                if (screenFragmentWrapper != null && (screenK = screenFragmentWrapper.k()) != null) {
                    screenK.bringToFront();
                    break;
                }
                break;
            case 2:
                int i3 = SafeAreaView.f47168f;
                ((UIManagerModule) obj).getUIImplementation().e(-1);
                break;
            case 3:
                ((MissedCallInstallationCallback) obj).f(true);
                break;
            case 4:
                UnistylesModule.access$onConfigChange((UnistylesModule) obj);
                break;
            case 5:
                int i4 = GAMView.r;
                GAMView gAMView = (GAMView) obj;
                gAMView.measure(View.MeasureSpec.makeMeasureSpec(gAMView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(gAMView.getHeight(), 1073741824));
                gAMView.layout(gAMView.getLeft(), gAMView.getTop(), gAMView.getRight(), gAMView.getBottom());
                break;
            case 6:
                APayBridge.amazonPayInit$lambda$0((APayBridge) obj);
                break;
            case 7:
                ((Godel) obj).resetWebView();
                break;
            case 8:
                ((OnBackPressedCallback) obj).remove();
                break;
            case 9:
                SmsRetriever.a((SmsRetriever) obj);
                break;
            case 10:
                int i5 = BufferCaptureStrategy.w;
                FileUtils.a((File) obj);
                break;
            default:
                RNSentryOnDrawReporterManager.RNSentryOnDrawReporterView rNSentryOnDrawReporterView = (RNSentryOnDrawReporterManager.RNSentryOnDrawReporterView) obj;
                Double dValueOf = Double.valueOf(rNSentryOnDrawReporterView.f53001b.now().d() / 1.0E9d);
                String str = rNSentryOnDrawReporterView.f53006g;
                AndroidLogger androidLogger = RNSentryOnDrawReporterManager.RNSentryOnDrawReporterView.f52999h;
                if (str != null) {
                    if (!rNSentryOnDrawReporterView.f53003d) {
                        if (!rNSentryOnDrawReporterView.f53004e) {
                            androidLogger.c(SentryLevel.DEBUG, "[TimeToDisplay] display type removed before frame was rendered.", new Object[0]);
                            break;
                        } else {
                            RNSentryTimeToDisplay.c(RNSentryOnDrawReporterManager.TTFD_PREFIX + rNSentryOnDrawReporterView.f53006g, dValueOf);
                            break;
                        }
                    } else {
                        RNSentryTimeToDisplay.c(RNSentryOnDrawReporterManager.TTID_PREFIX + rNSentryOnDrawReporterView.f53006g, dValueOf);
                        break;
                    }
                } else {
                    androidLogger.c(SentryLevel.ERROR, "[TimeToDisplay] parentSpanId removed before frame was rendered.", new Object[0]);
                    break;
                }
        }
    }
}
