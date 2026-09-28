package com.amazon.android.apay.commonlibrary.instrumentationlib.logger;

import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkRequest;
import com.amazon.android.apay.commonlibrary.instrumentationlib.utils.SingletonHolder;
import com.amazon.android.apay.commonlibrary.instrumentationlib.utils.b;
import com.amazon.android.apay.commonlibrary.interfaces.model.ClientSdkData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class CrashEventsLogger {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f14897a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.amazon.android.apay.commonlibrary.instrumentationlib.writer.a f14898b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.amazon.android.apay.commonlibrary.instrumentationlib.publisher.a f14899c;

    /* renamed from: d, reason: collision with root package name */
    public final String f14900d;

    @Metadata
    public static final class Companion extends SingletonHolder<CrashEventsLogger, ClientSdkData> {

        @Metadata
        public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<ClientSdkData, CrashEventsLogger> {

            /* renamed from: a, reason: collision with root package name */
            public static final a f14901a = new a();

            public a() {
                super(1, CrashEventsLogger.class, "<init>", "<init>(Lcom/amazon/android/apay/commonlibrary/interfaces/model/ClientSdkData;)V", 0);
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
            super(a.f14901a);
        }
    }

    public CrashEventsLogger(@NotNull ClientSdkData clientSdkData) {
        Intrinsics.checkNotNullParameter(clientSdkData, "clientSdkData");
        this.f14900d = "CrashEventsLogger";
        this.f14897a = com.amazon.android.apay.commonlibrary.instrumentationlib.utils.a.f14919b.getInstance(clientSdkData).f14920a;
        this.f14898b = new com.amazon.android.apay.commonlibrary.instrumentationlib.writer.a(clientSdkData.getContext());
        this.f14899c = new com.amazon.android.apay.commonlibrary.instrumentationlib.publisher.a(clientSdkData);
    }

    public static /* synthetic */ void logCrashEvent$default(CrashEventsLogger crashEventsLogger, Throwable th, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        crashEventsLogger.logCrashEvent(th, str);
    }

    public final void logCrashEvent(@NotNull Throwable throwable, @Nullable String str) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        try {
            String currentTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US).format(new Date());
            String strB = ExceptionsKt.b(throwable);
            Intrinsics.checkNotNullExpressionValue(currentTime, "currentTime");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sessionId", this.f14897a);
            if (str != null) {
                jSONObject.put("stitchingId", str);
            }
            jSONObject.put("timestamp", currentTime);
            jSONObject.put("stackTrace", strB);
            String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "crashEvent.toString()");
            ArrayList arrayListA = this.f14898b.a("CrashEvent");
            b bVar = b.f14922a;
            com.amazon.android.apay.commonlibrary.instrumentationlib.writer.a aVar = this.f14898b;
            bVar.getClass();
            b.b(arrayListA, aVar, "CrashEvent");
            this.f14898b.e("CrashEvent-" + this.f14897a + ".log", string, "CrashEvent");
            com.amazon.android.apay.commonlibrary.instrumentationlib.publisher.a aVar2 = this.f14899c;
            aVar2.getClass();
            WorkRequest workRequestB = aVar2.a("CrashEvent").b();
            Intrinsics.checkNotNullExpressionValue(workRequestB, "createOneTimeWorkRequest…H_EVENT\n        ).build()");
            Intrinsics.checkNotNullExpressionValue(aVar2.f14915a.c("CrashEventsRecordsPublisherWorker", ExistingWorkPolicy.f12516a, (OneTimeWorkRequest) workRequestB), "workManager.enqueueUniqu…TimeWorkRequest\n        )");
        } catch (Exception e2) {
            Objects.toString(throwable);
            e2.toString();
            Objects.toString(e2.getCause());
        }
    }
}
