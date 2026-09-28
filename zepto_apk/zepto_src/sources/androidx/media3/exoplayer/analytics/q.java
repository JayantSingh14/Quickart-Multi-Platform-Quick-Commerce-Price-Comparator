package androidx.media3.exoplayer.analytics;

import android.content.DialogInterface;
import androidx.core.os.CancellationSignal;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.transition.Transition;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.modal.ReactModalHostManager;
import com.facebook.react.views.modal.ReactModalHostView;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import io.sentry.IScope;
import io.sentry.ITransaction;
import io.sentry.Scope;
import io.sentry.SentryLevel;
import io.sentry.android.core.ActivityLifecycleIntegration;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.internal.gestures.SentryGestureListener;
import java.io.IOException;

/* loaded from: classes3.dex */
public final /* synthetic */ class q implements ListenerSet.Event, CancellationSignal.OnCancelListener, ReactModalHostView.OnRequestCloseListener, SynchronizationGuard.CriticalSection, Scope.IWithTransaction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6487a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6488b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f6489c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f6490d;

    public /* synthetic */ q(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        this.f6487a = 0;
        this.f6488b = eventTime;
        this.f6489c = mediaLoadData;
        this.f6490d = iOException;
    }

    @Override // com.facebook.react.views.modal.ReactModalHostView.OnRequestCloseListener
    public void a(DialogInterface dialogInterface) {
        ReactModalHostManager.addEventEmitters$lambda$0((EventDispatcher) this.f6488b, (ThemedReactContext) this.f6489c, (ReactModalHostView) this.f6490d, dialogInterface);
    }

    public void b() {
        androidx.fragment.app.c cVar = (androidx.fragment.app.c) this.f6488b;
        if (cVar != null) {
            cVar.run();
        } else {
            ((Transition) this.f6489c).cancel();
            ((Runnable) this.f6490d).run();
        }
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object d() {
        DefaultScheduler defaultScheduler = (DefaultScheduler) this.f6488b;
        EventStore eventStore = defaultScheduler.f20844d;
        EventInternal eventInternal = (EventInternal) this.f6490d;
        TransportContext transportContext = (TransportContext) this.f6489c;
        eventStore.C1(transportContext, eventInternal);
        defaultScheduler.f20841a.a(transportContext, 1);
        return null;
    }

    @Override // io.sentry.Scope.IWithTransaction
    public void e(ITransaction iTransaction) {
        switch (this.f6487a) {
            case 4:
                ITransaction iTransaction2 = (ITransaction) this.f6490d;
                ActivityLifecycleIntegration activityLifecycleIntegration = (ActivityLifecycleIntegration) this.f6488b;
                if (iTransaction != null) {
                    SentryAndroidOptions sentryAndroidOptions = activityLifecycleIntegration.f52007d;
                    if (sentryAndroidOptions != null) {
                        sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "Transaction '%s' won't be bound to the Scope since there's one already in there.", iTransaction2.getName());
                        break;
                    }
                } else {
                    activityLifecycleIntegration.getClass();
                    ((IScope) this.f6489c).r(iTransaction2);
                    break;
                }
                break;
            default:
                ITransaction iTransaction3 = (ITransaction) this.f6490d;
                SentryGestureListener sentryGestureListener = (SentryGestureListener) this.f6488b;
                if (iTransaction != null) {
                    sentryGestureListener.f52265c.getLogger().c(SentryLevel.DEBUG, "Transaction '%s' won't be bound to the Scope since there's one already in there.", iTransaction3.getName());
                    break;
                } else {
                    sentryGestureListener.getClass();
                    ((IScope) this.f6489c).r(iTransaction3);
                    break;
                }
        }
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        ((AnalyticsListener) obj).o((AnalyticsListener.EventTime) this.f6488b, (MediaLoadData) this.f6489c, (IOException) this.f6490d);
    }

    public /* synthetic */ q(Object obj, Object obj2, Object obj3, int i2) {
        this.f6487a = i2;
        this.f6488b = obj;
        this.f6489c = obj2;
        this.f6490d = obj3;
    }
}
