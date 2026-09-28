package androidx.media3.exoplayer.analytics;

import androidx.media3.common.AudioAttributes;
import androidx.media3.common.FlagSet;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.facebook.cache.common.WriterCallback;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.swiperefresh.ReactSwipeRefreshLayout;
import com.facebook.react.views.swiperefresh.SwipeRefreshLayoutManager;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.zzd;
import com.ibits.react_native_in_app_review.AppReviewModule;
import in.juspay.hyperupi.UPIBridge;
import io.sentry.Baggage;
import io.sentry.IScope;
import io.sentry.ITransaction;
import io.sentry.PropagationContext;
import io.sentry.Scope;
import io.sentry.ScopeCallback;
import io.sentry.SentryOptions;
import io.sentry.SentryTracer;
import io.sentry.android.core.ANRWatchDog;
import io.sentry.android.core.ActivityLifecycleIntegration;
import io.sentry.android.core.AndroidLogger;
import io.sentry.android.core.internal.gestures.SentryGestureListener;
import io.sentry.protocol.User;
import io.sentry.react.RNSentryModuleImpl;
import io.sentry.util.CollectionUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements ListenerSet.Event, ListenerSet.IterationFinishedEvent, WriterCallback, SwipeRefreshLayout.OnRefreshListener, SynchronizationGuard.CriticalSection, OnCompleteListener, OnFailureListener, ScopeCallback, Scope.IWithTransaction, ANRWatchDog.ANRListener, Scope.IWithPropagationContext {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6450a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6451b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f6452c;

    public /* synthetic */ d(int i2, Object obj, Object obj2) {
        this.f6450a = i2;
        this.f6451b = obj;
        this.f6452c = obj2;
    }

    @Override // io.sentry.Scope.IWithPropagationContext
    public void a(PropagationContext propagationContext) {
        Baggage baggage = propagationContext.f51750c;
        SentryOptions sentryOptions = (SentryOptions) this.f6451b;
        if (baggage == null) {
            baggage = new Baggage(sentryOptions.getLogger());
            propagationContext.f51750c = baggage;
        }
        if (baggage.f51552b) {
            baggage.e((IScope) this.f6452c, sentryOptions);
            baggage.f51552b = false;
        }
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void b() {
        SwipeRefreshLayoutManager.addEventEmitters$lambda$0((ThemedReactContext) this.f6451b, (ReactSwipeRefreshLayout) this.f6452c);
    }

    @Override // androidx.media3.common.util.ListenerSet.IterationFinishedEvent
    public void c(Object obj, FlagSet flagSet) {
        ((AnalyticsListener) obj).P((Player) this.f6452c, new AnalyticsListener.Events(flagSet, ((DefaultAnalyticsCollector) this.f6451b).f6385e));
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object d() {
        switch (this.f6450a) {
            case 12:
                ((Uploader) this.f6451b).f20877c.y((Iterable) this.f6452c);
                break;
            default:
                Uploader uploader = (Uploader) this.f6451b;
                uploader.getClass();
                Iterator it = ((HashMap) this.f6452c).entrySet().iterator();
                while (it.hasNext()) {
                    uploader.f20883i.e(((Integer) r2.getValue()).intValue(), LogEventDropped.Reason.INVALID_PAYLOD, (String) ((Map.Entry) it.next()).getKey());
                }
                break;
        }
        return null;
    }

    @Override // io.sentry.Scope.IWithTransaction
    public void e(ITransaction iTransaction) {
        switch (this.f6450a) {
            case 17:
                SentryTracer sentryTracer = (SentryTracer) this.f6451b;
                sentryTracer.getClass();
                if (iTransaction == sentryTracer) {
                    ((IScope) this.f6452c).w();
                    break;
                }
                break;
            default:
                if (iTransaction == ((ITransaction) this.f6451b)) {
                    ((IScope) this.f6452c).w();
                    break;
                }
                break;
        }
    }

    @Override // io.sentry.ScopeCallback
    public void h(IScope iScope) {
        Object obj = this.f6451b;
        Object obj2 = this.f6452c;
        switch (this.f6450a) {
            case 16:
                ((AtomicReference) obj).set(iScope.t());
                ((AtomicReference) obj2).set(iScope.z());
                break;
            case 17:
            case 19:
            case 20:
            default:
                AndroidLogger androidLogger = RNSentryModuleImpl.f52986l;
                String str = (String) obj2;
                ReadableMap readableMap = (ReadableMap) obj;
                if (readableMap != null) {
                    iScope.u(str, readableMap.toHashMap());
                    break;
                } else {
                    iScope.x(str);
                    break;
                }
            case 18:
                ((ActivityLifecycleIntegration) obj).getClass();
                iScope.F(new d(19, (ITransaction) obj2, iScope));
                break;
            case 21:
                SentryGestureListener sentryGestureListener = (SentryGestureListener) obj;
                sentryGestureListener.getClass();
                iScope.F(new q(sentryGestureListener, iScope, (ITransaction) obj2, 5));
                break;
            case 22:
                AndroidLogger androidLogger2 = RNSentryModuleImpl.f52986l;
                ReadableMap readableMap2 = (ReadableMap) obj;
                ReadableMap readableMap3 = (ReadableMap) obj2;
                if (readableMap2 != null || readableMap3 != null) {
                    User user = new User();
                    if (readableMap2 != null) {
                        if (readableMap2.hasKey(Scopes.EMAIL)) {
                            user.f52959a = readableMap2.getString(Scopes.EMAIL);
                        }
                        if (readableMap2.hasKey(CLConstants.SHARED_PREFERENCE_ITEM_ID)) {
                            user.f52960b = readableMap2.getString(CLConstants.SHARED_PREFERENCE_ITEM_ID);
                        }
                        if (readableMap2.hasKey("username")) {
                            user.f52961c = readableMap2.getString("username");
                        }
                        if (readableMap2.hasKey("ip_address")) {
                            user.f52963e = readableMap2.getString("ip_address");
                        }
                        if (readableMap2.hasKey("segment")) {
                            user.f52962d = readableMap2.getString("segment");
                        }
                    }
                    if (readableMap3 != null) {
                        HashMap map = new HashMap();
                        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap3.keySetIterator();
                        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                            String string = readableMap3.getString(strNextKey);
                            if (string != null) {
                                map.put(strNextKey, string);
                            }
                        }
                        user.f52966h = CollectionUtils.c(map);
                    }
                    iScope.c(user);
                    break;
                } else {
                    iScope.c(null);
                    break;
                }
            case 23:
                AndroidLogger androidLogger3 = RNSentryModuleImpl.f52986l;
                iScope.f((String) obj, (String) obj2);
                break;
        }
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f6450a) {
            case 0:
                analyticsListener.r((AnalyticsListener.EventTime) this.f6451b, (Exception) this.f6452c);
                break;
            case 1:
                analyticsListener.A((AnalyticsListener.EventTime) this.f6451b, (PlaybackParameters) this.f6452c);
                break;
            case 2:
                analyticsListener.L((AnalyticsListener.EventTime) this.f6451b, (Tracks) this.f6452c);
                break;
            case 3:
                analyticsListener.i((AnalyticsListener.EventTime) this.f6451b, (DecoderCounters) this.f6452c);
                break;
            case 4:
                analyticsListener.p((AnalyticsListener.EventTime) this.f6451b, (AudioAttributes) this.f6452c);
                break;
            case 5:
                analyticsListener.e((AnalyticsListener.EventTime) this.f6451b, (Metadata) this.f6452c);
                break;
            case 6:
                analyticsListener.g((AnalyticsListener.EventTime) this.f6451b, (PlaybackException) this.f6452c);
                break;
            case 7:
                AnalyticsListener.EventTime eventTime = (AnalyticsListener.EventTime) this.f6451b;
                VideoSize videoSize = (VideoSize) this.f6452c;
                analyticsListener.N(eventTime, videoSize);
                int i2 = videoSize.f5564a;
                break;
            default:
                analyticsListener.b((AnalyticsListener.EventTime) this.f6451b, this.f6452c);
                break;
        }
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        ((AppReviewModule) this.f6451b).lambda$show$1((zzd) this.f6452c, task);
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        UPIBridge.getPhoneNumber$lambda$9((UPIBridge) this.f6451b, (UPIBridge.PhoneNumberRetrievedCallback) this.f6452c, exc);
    }

    public /* synthetic */ d(AnalyticsListener.EventTime eventTime, Object obj, long j2) {
        this.f6450a = 8;
        this.f6451b = eventTime;
        this.f6452c = obj;
    }
}
