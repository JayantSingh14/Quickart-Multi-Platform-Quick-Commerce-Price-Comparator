package androidx.media3.exoplayer.analytics;

import android.net.Uri;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.extractor.BinarySearchSeeker;
import androidx.media3.extractor.FlacStreamMetadata;
import androidx.media3.extractor.mp4.FragmentedMp4Extractor;
import androidx.media3.extractor.mp4.Track;
import coil3.EventListener;
import coil3.ImageLoader;
import coil3.request.ImageRequest;
import com.appsflyer.internal.AFb1cSDK;
import com.chuckerteam.chucker.internal.support.CacheDirectoryProvider;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Predicate;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import com.google.common.base.Function;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.Network;
import com.google.common.graph.ValueGraph;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator;
import com.google.firebase.crashlytics.internal.common.Utils;
import com.google.firebase.sessions.EventGDTLogger;
import com.google.firebase.sessions.SessionEvent;
import com.google.firebase.sessions.SessionEvents;
import com.ibits.react_native_in_app_review.AppReviewModule;
import com.swmansion.rnscreens.CustomSearchView;
import com.swmansion.rnscreens.FragmentBackPressOverrider;
import com.swmansion.rnscreens.SearchBarView;
import com.truecaller.android.sdk.common.TrueException;
import com.zeptoconsumerapp.DynamicFeatures.DynamicFeatures;
import com.zeptoconsumerapp.GoogleAdsManager.GAMView;
import com.zeptoconsumerapp.PhoneNumberHint.PhoneNumberHintModule;
import in.juspay.hypersmshandler.SmsConsentHandler;
import in.juspay.hypersmshandler.SmsRetriever;
import in.juspay.hypersmshandler.Tracker;
import io.sentry.IScope;
import io.sentry.ScopeCallback;
import io.sentry.android.replay.capture.BufferCaptureStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;

/* loaded from: classes3.dex */
public final /* synthetic */ class l implements ListenerSet.Event, BinarySearchSeeker.SeekTimestampConverter, Function, EventListener.Factory, OnSuccessListener, CacheDirectoryProvider, Predicate, SynchronizationGuard.CriticalSection, AccessibilityViewCommand, Continuation, Transformer, OnCompleteListener, SearchView.OnCloseListener, OnFailureListener, OnPaidEventListener, ScopeCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6474a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6475b;

    public /* synthetic */ l(AnalyticsListener.EventTime eventTime, List list) {
        this.f6474a = 0;
        this.f6475b = list;
    }

    @Override // androidx.media3.extractor.BinarySearchSeeker.SeekTimestampConverter
    public long a(long j2) {
        return Util.l((j2 * r0.f8555e) / 1000000, 0L, ((FlacStreamMetadata) this.f6475b).f8560j - 1);
    }

    @Override // com.facebook.common.internal.Predicate
    /* renamed from: apply, reason: collision with other method in class */
    public boolean mo0apply(Object obj) {
        CacheKey key = (CacheKey) obj;
        CancellationException cancellationException = ImagePipeline.n;
        Uri uri = (Uri) this.f6475b;
        Intrinsics.checkNotNullParameter(uri, "$uri");
        Intrinsics.checkNotNullParameter(key, "key");
        return key.b(uri);
    }

    @Override // androidx.appcompat.widget.SearchView.OnCloseListener
    public boolean b() {
        switch (this.f6474a) {
            case 19:
                CustomSearchView customSearchView = (CustomSearchView) this.f6475b;
                SearchView.OnCloseListener onCloseListener = customSearchView.V0;
                boolean zB = onCloseListener != null ? onCloseListener.b() : false;
                FragmentBackPressOverrider fragmentBackPressOverrider = customSearchView.X0;
                if (fragmentBackPressOverrider.f46925c) {
                    fragmentBackPressOverrider.f46924b.remove();
                    fragmentBackPressOverrider.f46925c = false;
                }
                return zB;
            default:
                SearchBarView.k((SearchBarView) this.f6475b);
                return false;
        }
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean c(View view) {
        int i2 = BottomSheetDragHandleView.f40057m;
        return ((BottomSheetDragHandleView) this.f6475b).c();
    }

    @Override // coil3.EventListener.Factory
    public EventListener create(ImageRequest imageRequest) {
        return ImageLoader.Builder.eventListener$lambda$6((EventListener) this.f6475b, imageRequest);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object d() {
        switch (this.f6474a) {
            case 7:
                return ((ClientHealthMetricsStore) this.f6475b).c();
            case 8:
                return Integer.valueOf(((EventStore) this.f6475b).f());
            case 9:
                ((Uploader) this.f6475b).f20883i.a();
                return null;
            default:
                WorkInitializer workInitializer = (WorkInitializer) this.f6475b;
                Iterator it = workInitializer.f20894b.L().iterator();
                while (it.hasNext()) {
                    workInitializer.f20895c.a((TransportContext) it.next(), 1);
                }
                return null;
        }
    }

    @Override // com.google.android.gms.ads.OnPaidEventListener
    public void f(AdValue adValue) {
        int i2 = GAMView.r;
        Intrinsics.checkNotNullParameter(adValue, "adValue");
        GAMView gAMView = (GAMView) this.f6475b;
        gAMView.f47495m = adValue.f21013c;
        String str = adValue.f21012b;
        if (str == null) {
            str = "";
        }
        gAMView.n = str;
        gAMView.o = adValue.f21011a;
    }

    @Override // io.sentry.ScopeCallback
    public void h(IScope it) {
        Object obj = this.f6475b;
        switch (this.f6474a) {
            case 28:
                int i2 = BufferCaptureStrategy.w;
                BufferCaptureStrategy this$0 = (BufferCaptureStrategy) obj;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(it, "it");
                it.g(this$0.d());
                break;
            default:
                Ref.ObjectRef crumbs = (Ref.ObjectRef) obj;
                Intrinsics.checkNotNullParameter(crumbs, "$crumbs");
                Intrinsics.checkNotNullParameter(it, "scope");
                crumbs.f53801a = new ArrayList(it.i());
                break;
        }
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        ((AnalyticsListener) obj).getClass();
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        ((AppReviewModule) this.f6475b).lambda$show$0(task);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exception) {
        ?? r0 = this.f6475b;
        switch (this.f6474a) {
            case 21:
                com.zeptoconsumerapp.DynamicFeatures.a aVar = DynamicFeatures.f47403a;
                Intrinsics.checkNotNullParameter(exception, "exception");
                com.zeptoconsumerapp.DynamicFeatures.constants.DynamicFeatures[] dynamicFeaturesArr = com.zeptoconsumerapp.DynamicFeatures.constants.DynamicFeatures.f47410a;
                String message = exception.getMessage();
                if (message == null) {
                    message = TrueException.TYPE_UNKNOWN_MESSAGE;
                }
                DynamicFeatures.c("INSTALL_FAILED", MapsKt.j(r0, MapsKt.g(new Pair("error_message", message))));
                DynamicFeatures.a();
                break;
            case 24:
                PhoneNumberHintModule.requestHint$lambda$2((PhoneNumberHintModule) r0, exception);
                break;
            case 26:
                SmsConsentHandler.a((Tracker) r0, exception);
                break;
            default:
                SmsRetriever.a((SmsRetriever) r0, exception);
                break;
        }
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        switch (this.f6474a) {
            case 4:
                AFb1cSDK.AFAdRevenueData((AFb1cSDK) this.f6475b, (AppSetIdInfo) obj);
                break;
            case 23:
                ((com.brentvatne.react.a) this.f6475b).invoke(obj);
                break;
            default:
                ((com.brentvatne.react.b) this.f6475b).invoke(obj);
                break;
        }
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        boolean z;
        Object obj = this.f6475b;
        switch (this.f6474a) {
            case 14:
                ((SessionReportingCoordinator) obj).getClass();
                boolean zP = task.p();
                Logger logger = Logger.f43705a;
                if (zP) {
                    CrashlyticsReportWithSessionId crashlyticsReportWithSessionId = (CrashlyticsReportWithSessionId) task.l();
                    logger.b("Crashlytics report successfully enqueued to DataTransport: " + crashlyticsReportWithSessionId.d(), null);
                    File fileC = crashlyticsReportWithSessionId.c();
                    if (fileC.delete()) {
                        logger.b("Deleted report file: " + fileC.getPath(), null);
                    } else {
                        logger.f("Crashlytics could not delete report file: " + fileC.getPath(), null);
                    }
                    z = true;
                } else {
                    logger.f("Crashlytics report could not be enqueued to DataTransport", task.k());
                    z = false;
                }
                return Boolean.valueOf(z);
            case 15:
                ExecutorService executorService = Utils.f43842a;
                ((CountDownLatch) obj).countDown();
                return null;
            default:
                return (Task) ((Callable) obj).call();
        }
    }

    public /* synthetic */ l(Object obj, int i2) {
        this.f6474a = i2;
        this.f6475b = obj;
    }

    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        switch (this.f6474a) {
            case 2:
                Track track = (Track) obj;
                ((FragmentedMp4Extractor) this.f6475b).getClass();
                return track;
            case 12:
                return ((Network) this.f6475b).j(obj);
            case 13:
                EndpointPair endpointPair = (EndpointPair) obj;
                Object objH = ((ValueGraph) this.f6475b).h(endpointPair.f43189a, endpointPair.f43190b);
                Objects.requireNonNull(objH);
                return objH;
            default:
                SessionEvent sessionEvent = (SessionEvent) obj;
                ((EventGDTLogger) this.f6475b).getClass();
                String strEncode = SessionEvents.f45061b.encode(sessionEvent);
                Intrinsics.checkNotNullExpressionValue(strEncode, "SessionEvents.SESSION_EVENT_ENCODER.encode(value)");
                sessionEvent.getClass();
                Log.d("EventGDTLogger", "Session Event Type: SESSION_START");
                byte[] bytes = strEncode.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                return bytes;
        }
    }
}
