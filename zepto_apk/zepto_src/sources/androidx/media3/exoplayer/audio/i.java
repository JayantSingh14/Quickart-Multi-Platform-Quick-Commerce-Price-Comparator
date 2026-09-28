package androidx.media3.exoplayer.audio;

import android.app.Activity;
import android.media.AudioTrack;
import android.os.Handler;
import android.view.View;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.exoplayer.audio.AudioSink;
import com.amazon.apay.instrumentation.logger.KuberMetricEventsLogger;
import com.unistyles.Dimensions;
import com.unistyles.Insets;
import com.unistyles.Screen;
import com.unistyles.UnistylesModule;
import in.juspay.hypersdk.safe.Godel;
import in.juspay.hyperupi.UPIBridge;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.android.core.ViewHierarchyEventProcessor;
import io.sentry.protocol.ViewHierarchy;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function1;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6658a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6659b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f6660c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f6661d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f6662e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f6663f;

    public /* synthetic */ i(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i2) {
        this.f6658a = i2;
        this.f6659b = obj;
        this.f6660c = obj2;
        this.f6661d = obj3;
        this.f6662e = obj4;
        this.f6663f = obj5;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException {
        switch (this.f6658a) {
            case 0:
                AudioTrack audioTrack = (AudioTrack) this.f6659b;
                AudioSink.Listener listener = (AudioSink.Listener) this.f6660c;
                Handler handler = (Handler) this.f6661d;
                AudioSink.AudioTrackConfig audioTrackConfig = (AudioSink.AudioTrackConfig) this.f6662e;
                ConditionVariable conditionVariable = (ConditionVariable) this.f6663f;
                try {
                    audioTrack.flush();
                    audioTrack.release();
                    if (listener != null && handler.getLooper().getThread().isAlive()) {
                        handler.post(new androidx.constraintlayout.motion.widget.a(5, listener, audioTrackConfig));
                    }
                    conditionVariable.e();
                    synchronized (DefaultAudioSink.m0) {
                        try {
                            int i2 = DefaultAudioSink.o0 - 1;
                            DefaultAudioSink.o0 = i2;
                            if (i2 == 0) {
                                DefaultAudioSink.n0.shutdown();
                                DefaultAudioSink.n0 = null;
                            }
                        } finally {
                        }
                    }
                    return;
                } catch (Throwable th) {
                    if (listener != null && handler.getLooper().getThread().isAlive()) {
                        handler.post(new androidx.constraintlayout.motion.widget.a(5, listener, audioTrackConfig));
                    }
                    conditionVariable.e();
                    synchronized (DefaultAudioSink.m0) {
                        try {
                            int i3 = DefaultAudioSink.o0 - 1;
                            DefaultAudioSink.o0 = i3;
                            if (i3 == 0) {
                                DefaultAudioSink.n0.shutdown();
                                DefaultAudioSink.n0 = null;
                            }
                            throw th;
                        } finally {
                        }
                    }
                }
            case 1:
                KuberMetricEventsLogger.a((String) this.f6659b, (String) this.f6660c, (KuberMetricEventsLogger) this.f6661d, (String) this.f6662e, (String) this.f6663f);
                return;
            case 2:
                ((UnistylesModule) this.f6659b).nativeOnOrientationChange((Screen) this.f6660c, (Insets) this.f6661d, (Dimensions) this.f6662e, (Dimensions) this.f6663f);
                return;
            case 3:
                ((Godel) this.f6659b).lambda$onBrowserReady$0((Activity) this.f6660c, (String) this.f6661d, (String) this.f6662e, (String) this.f6663f);
                return;
            case 4:
                UPIBridge.process$lambda$5((UPIBridge) this.f6659b, (String) this.f6660c, (String) this.f6661d, (JSONObject) this.f6662e, (Function1) this.f6663f);
                return;
            default:
                AtomicReference atomicReference = (AtomicReference) this.f6659b;
                View view = (View) this.f6660c;
                List list = (List) this.f6661d;
                CountDownLatch countDownLatch = (CountDownLatch) this.f6662e;
                try {
                    ArrayList arrayList = new ArrayList(1);
                    ViewHierarchy viewHierarchy = new ViewHierarchy("android_view_system", arrayList);
                    ViewHierarchyNode viewHierarchyNodeF = ViewHierarchyEventProcessor.f(view);
                    arrayList.add(viewHierarchyNodeF);
                    ViewHierarchyEventProcessor.d(view, viewHierarchyNodeF, list);
                    atomicReference.set(viewHierarchy);
                    countDownLatch.countDown();
                    return;
                } catch (Throwable th2) {
                    ((ILogger) this.f6663f).b(SentryLevel.ERROR, "Failed to process view hierarchy.", th2);
                    return;
                }
        }
    }
}
