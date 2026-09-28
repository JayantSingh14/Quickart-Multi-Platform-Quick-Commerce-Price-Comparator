package com.amazon.apay.instrumentation.logger;

import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkRequest;
import com.amazon.apay.instrumentation.model.ClientSdkData;
import com.amazon.apay.instrumentation.utils.SingletonHolder;
import com.amazon.apay.instrumentation.utils.b;
import com.amazon.apay.instrumentation.writer.a;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata
/* loaded from: classes3.dex */
public final class CrashEventsLogger {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f15033a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final a f15034b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.amazon.apay.instrumentation.publisher.a f15035c;

    /* renamed from: d, reason: collision with root package name */
    public final String f15036d;

    @Metadata
    public static final class Companion extends SingletonHolder<CrashEventsLogger, ClientSdkData> {

        @Metadata
        public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<ClientSdkData, CrashEventsLogger> {

            /* renamed from: a, reason: collision with root package name */
            public static final a f15037a = new a();

            public a() {
                super(1, CrashEventsLogger.class, "<init>", "<init>(Lcom/amazon/apay/instrumentation/model/ClientSdkData;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                ClientSdkData p0 = (ClientSdkData) obj;
                Intrinsics.checkNotNullParameter(p0, "p0");
                return new CrashEventsLogger(p0);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
            super(a.f15037a);
        }
    }

    public CrashEventsLogger(@NotNull ClientSdkData clientSdkData) {
        Intrinsics.checkNotNullParameter(clientSdkData, "clientSdkData");
        this.f15036d = "CrashEventsLogger";
        this.f15033a = com.amazon.apay.instrumentation.utils.a.f15053b.getInstance(clientSdkData).f15054a;
        this.f15034b = new a(clientSdkData.getContext());
        this.f15035c = new com.amazon.apay.instrumentation.publisher.a(clientSdkData);
    }

    public final void logCrashEvent(@NotNull Throwable throwable) throws JSONException {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        try {
            String string = new Timestamp(System.currentTimeMillis()).toString();
            Intrinsics.checkNotNullExpressionValue(string, "Timestamp(System.currentTimeMillis()).toString()");
            String strB = ExceptionsKt.b(throwable);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sessionId", this.f15033a);
            jSONObject.put("timestamp", string);
            jSONObject.put("stackTrace", strB);
            String string2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string2, "crashEvent.toString()");
            ArrayList arrayListA = this.f15034b.a("CrashEvent");
            b bVar = b.f15056a;
            a aVar = this.f15034b;
            bVar.getClass();
            b.b(arrayListA, aVar, "CrashEvent");
            this.f15034b.e("CrashEvent-" + this.f15033a + ".log", string2, "CrashEvent");
            com.amazon.apay.instrumentation.publisher.a aVar2 = this.f15035c;
            aVar2.getClass();
            WorkRequest workRequestB = aVar2.a("CrashEvent").b();
            Intrinsics.checkNotNullExpressionValue(workRequestB, "createOneTimeWorkRequest…H_EVENT\n        ).build()");
            Intrinsics.checkNotNullExpressionValue(aVar2.f15049a.c("CrashEventsRecordsPublisherWorker", ExistingWorkPolicy.f12516a, (OneTimeWorkRequest) workRequestB), "workManager.enqueueUniqu…TimeWorkRequest\n        )");
        } catch (Exception e2) {
            Objects.toString(throwable);
            e2.toString();
            Objects.toString(e2.getCause());
        }
    }
}
