package in.juspay.hypernfc;

import android.content.Context;
import android.view.Choreographer;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.facebook.react.bridge.Promise;
import com.google.common.util.concurrent.ListenableFuture;
import in.juspay.hyperqr.CameraStreamScanner;
import in.juspay.hyperqr.QrBridge;
import in.juspay.hypersdk.analytics.LogManager;
import in.juspay.hypersdk.analytics.LogPusher;
import in.juspay.hypersdk.analytics.LogPusherExp;
import in.juspay.hypersdk.analytics.LogSessioniser;
import in.juspay.hypersdk.analytics.LogSessioniserExp;
import in.juspay.hypersdk.safe.JuspayWebView;
import in.juspay.hypersdk.services.HyperPaymentsServices;
import in.juspay.hypersdkreact.HyperSdkReactModule;
import in.juspay.hyperupi.UPIBridge;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import io.invertase.firebase.interfaces.NativeEvent;
import io.sentry.DefaultTransactionPerformanceCollector;
import io.sentry.Hub;
import io.sentry.ISentryExecutorService;
import io.sentry.SendCachedEnvelopeFireAndForgetIntegration;
import io.sentry.SentryEnvelope;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.SentryTracer;
import io.sentry.SpotlightIntegration;
import io.sentry.android.core.AnrIntegration;
import io.sentry.android.core.SentryAndroidDateProvider;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.cache.PersistingScopeObserver;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import io.sentry.react.RNSentryTimeToDisplay;
import io.sentry.util.Platform;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.zip.GZIPOutputStream;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import org.xbill.DNS.tools.jnamed;

/* loaded from: classes4.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48480a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f48481b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f48482c;

    public /* synthetic */ b(int i2, Object obj, Object obj2) {
        this.f48480a = i2;
        this.f48481b = obj;
        this.f48482c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() throws ExecutionException, JSONException, InterruptedException, IOException {
        OutputStream outputStream;
        switch (this.f48480a) {
            case 0:
                NfcActivity.onCreate$lambda$2((NfcActivity) this.f48481b, (ImageView) this.f48482c);
                return;
            case 1:
                CameraStreamScanner.startCamera$lambda$4((CameraStreamScanner) this.f48481b, (ListenableFuture) this.f48482c);
                return;
            case 2:
                QrBridge.toggleFlash$lambda$12((QrBridge) this.f48481b, (String) this.f48482c);
                return;
            case 3:
                LogManager.Companion.registerWorkspace$lambda$2((Context) this.f48481b, (String) this.f48482c);
                return;
            case 4:
                ((LogPusher) this.f48481b).lambda$addLogsToPersistedQueue$0((JSONObject) this.f48482c);
                return;
            case 5:
                ((LogPusher) this.f48481b).lambda$addLogsFromSessioniser$1((Queue) this.f48482c);
                return;
            case 6:
                ((LogPusher) this.f48481b).lambda$addLogLines$2((Iterable) this.f48482c);
                return;
            case 7:
                ((LogPusherExp) this.f48481b).lambda$addLogsToPersistedQueue$2((JSONObject) this.f48482c);
                return;
            case 8:
                ((LogSessioniser) this.f48481b).lambda$sessioniseLogs$5((JSONObject) this.f48482c);
                return;
            case 9:
                ((LogSessioniserExp) this.f48481b).lambda$addLogLine$1((JSONObject) this.f48482c);
                return;
            case 10:
                ((JuspayWebView) this.f48481b).lambda$addJsToWebView$0((String) this.f48482c);
                return;
            case 11:
                ((HyperPaymentsServices) this.f48481b).lambda$uncaughtException$13((Throwable) this.f48482c);
                return;
            case 12:
                ((HyperPaymentsServices) this.f48481b).lambda$process$10((FragmentActivity) this.f48482c);
                return;
            case 13:
                ((HyperPaymentsServices) this.f48481b).lambda$setupJuspayServices$2((JSONObject) this.f48482c);
                return;
            case 14:
                ((HyperSdkReactModule) this.f48481b).lambda$sendEventToJS$0((JSONObject) this.f48482c);
                return;
            case 15:
                UPIBridge.getLocationDetails$lambda$13((UPIBridge) this.f48481b, (String) this.f48482c);
                return;
            case 16:
                ReactNativeFirebaseEventEmitter reactNativeFirebaseEventEmitter = (ReactNativeFirebaseEventEmitter) this.f48481b;
                NativeEvent nativeEvent = (NativeEvent) this.f48482c;
                synchronized (reactNativeFirebaseEventEmitter.f49233c) {
                    try {
                        if (!reactNativeFirebaseEventEmitter.f49233c.containsKey(nativeEvent.b()) || !reactNativeFirebaseEventEmitter.a(nativeEvent)) {
                            reactNativeFirebaseEventEmitter.f49231a.add(nativeEvent);
                        }
                    } finally {
                    }
                }
                return;
            case 17:
                ((DefaultTransactionPerformanceCollector) this.f48481b).d((SentryTracer) this.f48482c);
                return;
            case 18:
                ((ISentryExecutorService) this.f48482c).b(((Hub) this.f48481b).f51652a.getShutdownTimeoutMillis());
                return;
            case 19:
                ((SendCachedEnvelopeFireAndForgetIntegration) this.f48481b).getClass();
                try {
                    throw null;
                } catch (Throwable th) {
                    ((SentryOptions) this.f48482c).getLogger().b(SentryLevel.ERROR, "Failed trying to send cached events.", th);
                    return;
                }
            case 20:
                SentryEnvelope sentryEnvelope = (SentryEnvelope) this.f48482c;
                SpotlightIntegration spotlightIntegration = (SpotlightIntegration) this.f48481b;
                spotlightIntegration.getClass();
                try {
                    SentryOptions sentryOptions = spotlightIntegration.f51934a;
                    if (sentryOptions == null) {
                        throw new IllegalArgumentException("SentryOptions are required to send envelopes.");
                    }
                    HttpURLConnection httpURLConnectionC = SpotlightIntegration.c(sentryOptions.getSpotlightConnectionUrl() != null ? spotlightIntegration.f51934a.getSpotlightConnectionUrl() : Platform.f53129a ? "http://10.0.2.2:8969/stream" : "http://localhost:8969/stream");
                    try {
                        outputStream = httpURLConnectionC.getOutputStream();
                    } catch (Throwable th2) {
                        try {
                            spotlightIntegration.f51935b.b(SentryLevel.ERROR, "An exception occurred while submitting the envelope to the Sentry server.", th2);
                            spotlightIntegration.f51935b.c(SentryLevel.DEBUG, "Envelope sent to spotlight: %d", Integer.valueOf(httpURLConnectionC.getResponseCode()));
                        } catch (Throwable th3) {
                            spotlightIntegration.f51935b.c(SentryLevel.DEBUG, "Envelope sent to spotlight: %d", Integer.valueOf(httpURLConnectionC.getResponseCode()));
                            SpotlightIntegration.b(httpURLConnectionC);
                            throw th3;
                        }
                    }
                    try {
                        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                        try {
                            spotlightIntegration.f51934a.getSerializer().c(sentryEnvelope, gZIPOutputStream);
                            gZIPOutputStream.close();
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            spotlightIntegration.f51935b.c(SentryLevel.DEBUG, "Envelope sent to spotlight: %d", Integer.valueOf(httpURLConnectionC.getResponseCode()));
                            SpotlightIntegration.b(httpURLConnectionC);
                            return;
                        } finally {
                        }
                    } finally {
                    }
                } catch (Exception e2) {
                    spotlightIntegration.f51935b.b(SentryLevel.ERROR, "An exception occurred while creating the connection to spotlight.", e2);
                    return;
                }
            case 21:
                AnrIntegration anrIntegration = (AnrIntegration) this.f48481b;
                SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.f48482c;
                synchronized (anrIntegration.f52072c) {
                    try {
                        if (!anrIntegration.f52071b) {
                            anrIntegration.a(sentryAndroidOptions);
                        }
                    } finally {
                    }
                }
                return;
            case 22:
                io.sentry.android.replay.c task = (io.sentry.android.replay.c) this.f48481b;
                Intrinsics.checkNotNullParameter(task, "$task");
                SentryOptions options = (SentryOptions) this.f48482c;
                Intrinsics.checkNotNullParameter(options, "$options");
                Intrinsics.checkNotNullParameter("WindowRecorder.capture", "$taskName");
                try {
                    task.run();
                    return;
                } catch (Throwable th4) {
                    options.getLogger().b(SentryLevel.ERROR, "Failed to execute task WindowRecorder.capture", th4);
                    return;
                }
            case 23:
                io.sentry.android.replay.c task2 = (io.sentry.android.replay.c) this.f48481b;
                Intrinsics.checkNotNullParameter(task2, "$task");
                SentryOptions options2 = (SentryOptions) this.f48482c;
                Intrinsics.checkNotNullParameter(options2, "$options");
                Intrinsics.checkNotNullParameter("ReplayIntegration.finalize_previous_replay", "$taskName");
                try {
                    task2.run();
                    return;
                } catch (Throwable th5) {
                    options2.getLogger().b(SentryLevel.ERROR, "Failed to execute task ReplayIntegration.finalize_previous_replay", th5);
                    return;
                }
            case 24:
                Charset charset = PersistingScopeObserver.f52680c;
                PersistingScopeObserver persistingScopeObserver = (PersistingScopeObserver) this.f48481b;
                User user = (User) this.f48482c;
                if (user == null) {
                    persistingScopeObserver.l("user.json");
                    return;
                } else {
                    persistingScopeObserver.p(user, "user.json");
                    return;
                }
            case 25:
                Charset charset2 = PersistingScopeObserver.f52680c;
                ((PersistingScopeObserver) this.f48481b).p((SentryId) this.f48482c, "replay.json");
                return;
            case 26:
                Charset charset3 = PersistingScopeObserver.f52680c;
                ((PersistingScopeObserver) this.f48481b).p((ConcurrentHashMap) this.f48482c, "extras.json");
                return;
            case 27:
                final SentryAndroidDateProvider sentryAndroidDateProvider = (SentryAndroidDateProvider) this.f48481b;
                final Promise promise = (Promise) this.f48482c;
                Map map = RNSentryTimeToDisplay.f53014a;
                try {
                    Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: io.sentry.react.b
                        @Override // android.view.Choreographer.FrameCallback
                        public final void doFrame(long j2) {
                            Map map2 = RNSentryTimeToDisplay.f53014a;
                            promise.resolve(Double.valueOf(sentryAndroidDateProvider.now().d() / 1.0E9d));
                        }
                    });
                    return;
                } catch (Exception e3) {
                    promise.reject("Failed to receive the instance of Choreographer", e3);
                    return;
                }
            default:
                ((jnamed) this.f48481b).lambda$serveTCP$0((Socket) this.f48482c);
                return;
        }
    }
}
