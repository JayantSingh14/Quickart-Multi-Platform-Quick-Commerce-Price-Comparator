package com.amazon.android.apay.commonlibrary.instrumentationlib.logger;

import androidx.media3.exoplayer.source.h;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkRequest;
import com.amazon.android.apay.commonlibrary.instrumentationlib.utils.SingletonHolder;
import com.amazon.android.apay.commonlibrary.instrumentationlib.utils.b;
import com.amazon.android.apay.commonlibrary.interfaces.model.ClientSdkData;
import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class KuberMetricEventsLogger {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f14902a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final ExecutorService f14903b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final String f14904c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final com.amazon.android.apay.commonlibrary.instrumentationlib.writer.a f14905d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final com.amazon.android.apay.commonlibrary.instrumentationlib.publisher.a f14906e;

    @Metadata
    public static final class Companion extends SingletonHolder<KuberMetricEventsLogger, ClientSdkData> {

        @Metadata
        public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<ClientSdkData, KuberMetricEventsLogger> {

            /* renamed from: a, reason: collision with root package name */
            public static final a f14907a = new a();

            public a() {
                super(1, KuberMetricEventsLogger.class, "<init>", "<init>(Lcom/amazon/android/apay/commonlibrary/interfaces/model/ClientSdkData;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                ClientSdkData p0 = (ClientSdkData) obj;
                Intrinsics.checkNotNullParameter(p0, "p0");
                return new KuberMetricEventsLogger(p0);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
            super(a.f14907a);
        }
    }

    public KuberMetricEventsLogger(@NotNull ClientSdkData clientSdkData) {
        Intrinsics.checkNotNullParameter(clientSdkData, "clientSdkData");
        this.f14902a = "KuberMetricEventsLogger";
        this.f14904c = com.amazon.android.apay.commonlibrary.instrumentationlib.utils.a.f14919b.getInstance(clientSdkData).f14920a;
        this.f14905d = new com.amazon.android.apay.commonlibrary.instrumentationlib.writer.a(clientSdkData.getContext());
        this.f14906e = new com.amazon.android.apay.commonlibrary.instrumentationlib.publisher.a(clientSdkData);
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor()");
        this.f14903b = executorServiceNewSingleThreadExecutor;
        Runtime.getRuntime().addShutdownHook(new Thread(new androidx.constraintlayout.helper.widget.a(this, 8)));
    }

    public static final void a(KuberMetricEventsLogger this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f14903b.shutdown();
    }

    public static /* synthetic */ void addMetricEvent$default(KuberMetricEventsLogger kuberMetricEventsLogger, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = null;
        }
        kuberMetricEventsLogger.addMetricEvent(str, str2, str3);
    }

    public final void addMetricEvent(@NotNull String event, @NotNull String operationName, @Nullable String str) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        this.f14903b.execute(new h(event, operationName, this, str, 2));
    }

    public static final void a(String event, String operationName, KuberMetricEventsLogger this$0, String str) throws JSONException {
        Intrinsics.checkNotNullParameter(event, "$event");
        Intrinsics.checkNotNullParameter(operationName, "$operationName");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", event);
            jSONObject.put("operation", operationName);
            jSONObject.put("sessionId", this$0.f14904c);
            if (str != null) {
                jSONObject.put("stitchingId", str);
            }
            jSONObject.put("timestamp", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US).format(new Date()));
            this$0.a(jSONObject.toString() + '\n');
        } catch (Exception e2) {
            String str2 = this$0.f14902a;
            e2.toString();
            Objects.toString(e2.getCause());
        }
    }

    public static /* synthetic */ void addMetricEvent$default(KuberMetricEventsLogger kuberMetricEventsLogger, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            str5 = null;
        }
        kuberMetricEventsLogger.addMetricEvent(str, str2, str3, str4, str5);
    }

    public final void addMetricEvent(@NotNull String event, @NotNull String operationName, @NotNull String reasonCode, @NotNull String stackTrace, @Nullable String str) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        Intrinsics.checkNotNullParameter(reasonCode, "reasonCode");
        Intrinsics.checkNotNullParameter(stackTrace, "stackTrace");
        this.f14903b.execute(new a(event, operationName, str, reasonCode, stackTrace, 0, this));
    }

    public static final void a(String event, String operationName, KuberMetricEventsLogger this$0, String str, String reasonCode, String stackTrace) {
        Intrinsics.checkNotNullParameter(event, "$event");
        Intrinsics.checkNotNullParameter(operationName, "$operationName");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reasonCode, "$reasonCode");
        Intrinsics.checkNotNullParameter(stackTrace, "$stackTrace");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", event);
            jSONObject.put("operation", operationName);
            jSONObject.put("sessionId", this$0.f14904c);
            if (str != null) {
                jSONObject.put("stitchingId", str);
            }
            jSONObject.put("timestamp", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US).format(new Date()));
            jSONObject.put("reasonCode", reasonCode);
            jSONObject.put("stackTrace", stackTrace);
            this$0.a(jSONObject.toString() + '\n');
        } catch (Exception e2) {
            String str2 = this$0.f14902a;
            e2.toString();
            Objects.toString(e2.getCause());
        }
    }

    public final void a(String str) {
        synchronized (this) {
            ArrayList arrayListA = this.f14905d.a("MetricEvent");
            b bVar = b.f14922a;
            com.amazon.android.apay.commonlibrary.instrumentationlib.writer.a aVar = this.f14905d;
            bVar.getClass();
            b.b(arrayListA, aVar, "MetricEvent");
            a(a(arrayListA), str);
        }
    }

    public final void a(String fileName, String str) {
        this.f14905d.e(fileName, str, "MetricEvent");
        com.amazon.android.apay.commonlibrary.instrumentationlib.writer.a aVar = this.f14905d;
        aVar.getClass();
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter("MetricEvent", "eventType");
        if (new File(aVar.f14931a, fileName).length() >= 2000) {
            b bVar = b.f14922a;
            com.amazon.android.apay.commonlibrary.instrumentationlib.writer.a aVar2 = this.f14905d;
            bVar.getClass();
            b.a(aVar2, fileName, "MetricEvent");
        }
        com.amazon.android.apay.commonlibrary.instrumentationlib.publisher.a aVar3 = this.f14906e;
        TimeUnit unit = TimeUnit.MINUTES;
        aVar3.getClass();
        Intrinsics.checkNotNullParameter(unit, "unit");
        WorkRequest workRequestB = ((OneTimeWorkRequest.Builder) aVar3.a("MetricEvent").f(5L, unit)).b();
        Intrinsics.checkNotNullExpressionValue(workRequestB, "createOneTimeWorkRequest…\n                .build()");
        ExistingWorkPolicy existingWorkPolicy = ExistingWorkPolicy.f12516a;
        Intrinsics.checkNotNullExpressionValue(aVar3.f14915a.c("MetricEventsRecordsPublisherWorker", existingWorkPolicy, (OneTimeWorkRequest) workRequestB), "workManager.enqueueUniqu…TimeWorkRequest\n        )");
    }

    public final String a(List<String> list) {
        long time = new Timestamp(System.currentTimeMillis()).getTime();
        for (String str : list) {
            long jD = this.f14905d.d(str);
            if (StringsKt.n(str, ".tmp", false) && time - jD < 240000) {
                return str;
            }
        }
        return "MetricEvent-" + new Timestamp(System.currentTimeMillis()) + ".tmp";
    }
}
