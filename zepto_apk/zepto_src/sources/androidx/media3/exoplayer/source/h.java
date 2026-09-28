package androidx.media3.exoplayer.source;

import android.graphics.Canvas;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MediatorLiveData;
import androidx.media3.exoplayer.analytics.q;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.work.Configuration;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkGenerationalId;
import com.amazon.android.apay.commonlibrary.instrumentationlib.logger.KuberMetricEventsLogger;
import com.chuckerteam.chucker.internal.support.LiveDataUtilsKt;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.camera.ImageStoreManager;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.reactcommunity.rndatetimepicker.DatePickerModule;
import com.reactcommunity.rndatetimepicker.TimePickerModule;
import com.rt2zz.reactnativecontacts.impl.ContactsManagerImpl;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.utils.LogType;
import in.juspay.hypersdk.utils.TrackerFallback;
import in.juspay.hyperupi.CLUtils;
import in.juspay.hyperupi.UPIBridge;
import io.sentry.ILogger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7910a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7911b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f7912c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f7913d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f7914e;

    public /* synthetic */ h(Object obj, Object obj2, Object obj3, Object obj4, int i2) {
        this.f7910a = i2;
        this.f7911b = obj;
        this.f7912c = obj2;
        this.f7913d = obj3;
        this.f7914e = obj4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.media3.exoplayer.source.MediaSourceEventListener, java.lang.Object] */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        Object obj = this.f7914e;
        Object obj2 = this.f7913d;
        ?? r2 = this.f7912c;
        Object obj3 = this.f7911b;
        switch (this.f7910a) {
            case 0:
                r2.h(((MediaSourceEventListener.EventDispatcher) obj3).f7614a, (MediaSource.MediaPeriodId) obj2, (MediaLoadData) obj);
                return;
            case 1:
                String str = Schedulers.f12628a;
                List list = (List) obj3;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((Scheduler) it.next()).a(((WorkGenerationalId) r2).f12893a);
                }
                Schedulers.b((Configuration) obj2, (WorkDatabase) obj, list);
                return;
            case 2:
                KuberMetricEventsLogger.a((String) obj3, (String) r2, (KuberMetricEventsLogger) obj2, (String) obj);
                return;
            case 3:
                Ref.ObjectRef objectRef = (Ref.ObjectRef) obj3;
                Object obj4 = objectRef.f53801a;
                if (obj4 == LiveDataUtilsKt.f16776a || !((Boolean) ((com.chuckerteam.chucker.internal.data.repository.a) obj2).invoke(obj4, r2)).booleanValue()) {
                    objectRef.f53801a = r2;
                    ((MediatorLiveData) obj).i(r2);
                    return;
                }
                return;
            case 4:
                ImageStoreManager.getBase64ForTag$lambda$0((ImageStoreManager) obj3, (String) r2, (Callback) obj2, (Callback) obj);
                return;
            case 5:
                TransportContext transportContext = (TransportContext) r2;
                TransportScheduleCallback transportScheduleCallback = (TransportScheduleCallback) obj2;
                EventInternal eventInternal = (EventInternal) obj;
                Logger logger = DefaultScheduler.f20840f;
                DefaultScheduler defaultScheduler = (DefaultScheduler) obj3;
                defaultScheduler.getClass();
                Logger logger2 = DefaultScheduler.f20840f;
                try {
                    TransportBackend transportBackendB = defaultScheduler.f20843c.b(transportContext.b());
                    if (transportBackendB == null) {
                        String str2 = "Transport backend '" + transportContext.b() + "' is not registered";
                        logger2.warning(str2);
                        transportScheduleCallback.f(new IllegalArgumentException(str2));
                    } else {
                        defaultScheduler.f20845e.b(new q(defaultScheduler, transportContext, transportBackendB.a(eventInternal), 3));
                        transportScheduleCallback.f(null);
                    }
                    return;
                } catch (Exception e2) {
                    logger2.warning("Error scheduling event " + e2.getMessage());
                    transportScheduleCallback.f(e2);
                    return;
                }
            case 6:
                ((DatePickerModule) obj3).lambda$open$0((FragmentManager) r2, (ReadableMap) obj2, (Promise) obj);
                return;
            case 7:
                ((TimePickerModule) obj3).lambda$open$0((FragmentManager) r2, (ReadableMap) obj2, (Promise) obj);
                return;
            case 8:
                ((ContactsManagerImpl) obj3).lambda$writePhotoToPath$6((String) r2, (String) obj2, (Promise) obj);
                return;
            case 9:
                ((TrackerFallback) obj3).lambda$log$0((JuspayServices) r2, (JSONObject) obj2, (LogType) obj);
                return;
            case 10:
                CLUtils.getChallenge$lambda$6((CLUtils) obj3, (String) r2, (String) obj2, (String) obj);
                return;
            case 11:
                UPIBridge.process$lambda$5$lambda$4((UPIBridge) obj3, (JSONObject) r2, (JSONObject) obj2, (Function1) obj);
                return;
            default:
                ILogger iLogger = (ILogger) obj2;
                CountDownLatch countDownLatch = (CountDownLatch) obj;
                try {
                    ((View) obj3).draw((Canvas) r2);
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
                return;
        }
    }

    public /* synthetic */ h(Ref.ObjectRef objectRef, com.chuckerteam.chucker.internal.data.repository.a aVar, Object obj, MediatorLiveData mediatorLiveData) {
        this.f7910a = 3;
        this.f7911b = objectRef;
        this.f7913d = aVar;
        this.f7912c = obj;
        this.f7914e = mediatorLiveData;
    }
}
