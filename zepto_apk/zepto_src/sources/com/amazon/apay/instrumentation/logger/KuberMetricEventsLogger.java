package com.amazon.apay.instrumentation.logger;

import androidx.media3.common.util.e;
import androidx.media3.exoplayer.audio.i;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkRequest;
import com.amazon.apay.instrumentation.model.ClientSdkData;
import com.amazon.apay.instrumentation.utils.SingletonHolder;
import com.amazon.apay.instrumentation.utils.b;
import com.amazon.apay.instrumentation.writer.a;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata
/* loaded from: classes3.dex */
public final class KuberMetricEventsLogger {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f15038a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final ExecutorService f15039b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final String f15040c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final a f15041d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final com.amazon.apay.instrumentation.publisher.a f15042e;

    @Metadata
    public static final class Companion extends SingletonHolder<KuberMetricEventsLogger, ClientSdkData> {

        @Metadata
        public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<ClientSdkData, KuberMetricEventsLogger> {

            /* renamed from: a, reason: collision with root package name */
            public static final a f15043a = new a();

            public a() {
                super(1, KuberMetricEventsLogger.class, "<init>", "<init>(Lcom/amazon/apay/instrumentation/model/ClientSdkData;)V", 0);
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
            super(a.f15043a);
        }
    }

    public KuberMetricEventsLogger(@NotNull ClientSdkData clientSdkData) {
        Intrinsics.checkNotNullParameter(clientSdkData, "clientSdkData");
        this.f15038a = "KuberMetricEventsLogger";
        this.f15040c = com.amazon.apay.instrumentation.utils.a.f15053b.getInstance(clientSdkData).f15054a;
        this.f15041d = new a(clientSdkData.getContext());
        this.f15042e = new com.amazon.apay.instrumentation.publisher.a(clientSdkData);
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor()");
        this.f15039b = executorServiceNewSingleThreadExecutor;
    }

    public static final void a(String event, String operationName, KuberMetricEventsLogger this$0) {
        Intrinsics.checkNotNullParameter(event, "$event");
        Intrinsics.checkNotNullParameter(operationName, "$operationName");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", event);
            jSONObject.put("operation", operationName);
            jSONObject.put("sessionId", this$0.f15040c);
            jSONObject.put("timestamp", new Timestamp(System.currentTimeMillis()).toString());
            this$0.a(jSONObject.toString() + '\n');
        } catch (Exception e2) {
            String str = this$0.f15038a;
            e2.toString();
            Objects.toString(e2.getCause());
        }
    }

    public final void addMetricEvent(@NotNull String event, @NotNull String operationName) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        this.f15039b.execute(new e(event, operationName, this, 8));
    }

    public final void addMetricEvent(@NotNull String event, @NotNull String operationName, @NotNull String reasonCode, @NotNull String stackTrace) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        Intrinsics.checkNotNullParameter(reasonCode, "reasonCode");
        Intrinsics.checkNotNullParameter(stackTrace, "stackTrace");
        this.f15039b.execute(new i(event, operationName, this, reasonCode, stackTrace, 1));
    }

    public static final void a(String event, String operationName, KuberMetricEventsLogger this$0, String reasonCode, String stackTrace) throws JSONException {
        Intrinsics.checkNotNullParameter(event, "$event");
        Intrinsics.checkNotNullParameter(operationName, "$operationName");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reasonCode, "$reasonCode");
        Intrinsics.checkNotNullParameter(stackTrace, "$stackTrace");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", event);
            jSONObject.put("operation", operationName);
            jSONObject.put("sessionId", this$0.f15040c);
            jSONObject.put("timestamp", new Timestamp(System.currentTimeMillis()).toString());
            jSONObject.put("reasonCode", reasonCode);
            jSONObject.put("stackTrace", stackTrace);
            this$0.a(jSONObject.toString() + '\n');
        } catch (Exception e2) {
            String str = this$0.f15038a;
            e2.toString();
            Objects.toString(e2.getCause());
        }
    }

    public final void a(String str) {
        synchronized (this) {
            ArrayList arrayListA = this.f15041d.a("MetricEvent");
            b bVar = b.f15056a;
            a aVar = this.f15041d;
            bVar.getClass();
            b.b(arrayListA, aVar, "MetricEvent");
            a(a(arrayListA), str);
        }
    }

    public final void a(String fileName, String str) throws Exception {
        this.f15041d.e(fileName, str, "MetricEvent");
        a aVar = this.f15041d;
        aVar.getClass();
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter("MetricEvent", "eventType");
        if (new File(aVar.f15065a, fileName).length() >= 2000) {
            b bVar = b.f15056a;
            a aVar2 = this.f15041d;
            bVar.getClass();
            b.a(aVar2, fileName, "MetricEvent");
        }
        com.amazon.apay.instrumentation.publisher.a aVar3 = this.f15042e;
        TimeUnit unit = TimeUnit.MINUTES;
        aVar3.getClass();
        Intrinsics.checkNotNullParameter(unit, "unit");
        WorkRequest workRequestB = ((OneTimeWorkRequest.Builder) aVar3.a("MetricEvent").f(5L, unit)).b();
        Intrinsics.checkNotNullExpressionValue(workRequestB, "createOneTimeWorkRequest…\n                .build()");
        ExistingWorkPolicy existingWorkPolicy = ExistingWorkPolicy.f12516a;
        Intrinsics.checkNotNullExpressionValue(aVar3.f15049a.c("MetricEventsRecordsPublisherWorker", existingWorkPolicy, (OneTimeWorkRequest) workRequestB), "workManager.enqueueUniqu…TimeWorkRequest\n        )");
    }

    public final String a(List<String> list) {
        long time = new Timestamp(System.currentTimeMillis()).getTime();
        for (String str : list) {
            long jD = this.f15041d.d(str);
            if (StringsKt.n(str, ".tmp", false) && time - jD < 240000) {
                return str;
            }
        }
        return "MetricEvent-" + new Timestamp(System.currentTimeMillis()) + ".tmp";
    }
}
