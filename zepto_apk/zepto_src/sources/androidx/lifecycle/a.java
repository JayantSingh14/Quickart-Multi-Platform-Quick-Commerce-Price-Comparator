package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.media3.exoplayer.analytics.l;
import com.appsflyer.AFLogger;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.queue.MessageQueueThreadImpl;
import com.facebook.react.common.futures.SimpleSettableFuture;
import com.facebook.react.internal.ChoreographerProvider;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ReactChoreographer;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.reactnativecommunity.netinfo.NetworkCallbackConnectivityReceiver;
import com.swmansion.gesturehandler.core.PanGestureHandler;
import com.swmansion.reanimated.AndroidUIScheduler;
import com.swmansion.rnscreens.ScreenContainer;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import io.sentry.react.RNSentryModuleImpl;
import io.sentry.react.RNSentryTimeToDisplay;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4959a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4960b;

    public /* synthetic */ a(Object obj, int i2) {
        this.f4959a = i2;
        this.f4960b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        switch (this.f4959a) {
            case 0:
                ProcessLifecycleOwner processLifecycleOwner = ProcessLifecycleOwner.f4856i;
                ProcessLifecycleOwner this$0 = (ProcessLifecycleOwner) this.f4960b;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                int i2 = this$0.f4858b;
                LifecycleRegistry lifecycleRegistry = this$0.f4862f;
                if (i2 == 0) {
                    this$0.f4859c = true;
                    lifecycleRegistry.f(Lifecycle.Event.ON_PAUSE);
                }
                if (this$0.f4857a == 0 && this$0.f4859c) {
                    lifecycleRegistry.f(Lifecycle.Event.ON_STOP);
                    this$0.f4860d = true;
                    return;
                }
                return;
            case 1:
                AFLogger.getMediationNetwork((Function1) this.f4960b);
                return;
            case 2:
                MessageQueueThreadImpl.lambda$startNewBackgroundThread$2((SimpleSettableFuture) this.f4960b);
                return;
            case 3:
                DeviceEventManagerModule.invokeDefaultBackPressRunnable$lambda$0((DefaultHardwareBackBtnHandler) this.f4960b);
                return;
            case 4:
                ReactChoreographer reactChoreographer = (ReactChoreographer) this.f4960b;
                synchronized (reactChoreographer.f19065b) {
                    if (!reactChoreographer.f19067d) {
                        ChoreographerProvider.Choreographer choreographer = reactChoreographer.f19064a;
                        if (choreographer == null) {
                            UiThreadUtil.runOnUiThread(new a(reactChoreographer, 4));
                        } else {
                            choreographer.b(reactChoreographer.f19068e);
                            reactChoreographer.f19067d = true;
                        }
                    }
                    Unit unit = Unit.f53572a;
                }
                return;
            case 5:
                WorkInitializer workInitializer = (WorkInitializer) this.f4960b;
                workInitializer.getClass();
                workInitializer.f20896d.b(new l(workInitializer, 10));
                return;
            case 6:
                NetworkCallbackConnectivityReceiver networkCallbackConnectivityReceiver = (NetworkCallbackConnectivityReceiver) this.f4960b;
                networkCallbackConnectivityReceiver.f46191l = networkCallbackConnectivityReceiver.f46180a.getNetworkCapabilities(networkCallbackConnectivityReceiver.f46190k);
                networkCallbackConnectivityReceiver.g();
                return;
            case 7:
                ((PanGestureHandler) this.f4960b).a(false);
                return;
            case 8:
                ((AndroidUIScheduler) this.f4960b).lambda$new$0();
                return;
            case 9:
                int i3 = ScreenContainer.f46989h;
                ((ScreenContainer) this.f4960b).g();
                return;
            case 10:
                ReactNativeFirebaseEventEmitter reactNativeFirebaseEventEmitter = ReactNativeFirebaseEventEmitter.f49230g;
                ((ReactNativeFirebaseEventEmitter) this.f4960b).c();
                return;
            default:
                RNSentryTimeToDisplay.d(Double.valueOf(((RNSentryModuleImpl) this.f4960b).f52998k.now().d() / 1.0E9d));
                return;
        }
    }
}
