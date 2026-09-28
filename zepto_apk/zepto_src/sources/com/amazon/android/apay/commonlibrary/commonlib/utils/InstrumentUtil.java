package com.amazon.android.apay.commonlibrary.commonlib.utils;

import android.content.Context;
import com.amazon.android.apay.commonlibrary.instrumentationlib.logger.CrashEventsLogger;
import com.amazon.android.apay.commonlibrary.instrumentationlib.logger.KuberMetricEventsLogger;
import com.amazon.android.apay.commonlibrary.interfaces.model.ClientSdkData;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata
/* loaded from: classes3.dex */
public final class InstrumentUtil {

    @NotNull
    public static final InstrumentUtil INSTANCE = new InstrumentUtil();

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public static KuberMetricEventsLogger f14876a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static CrashEventsLogger f14877b;

    @JvmStatic
    public static final void addMetricEvent(@NotNull String event, @NotNull String operationName, @NotNull Context context, @Nullable String str, @Nullable String str2) throws JSONException {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        Intrinsics.checkNotNullParameter(context, "context");
        KuberMetricEventsLogger singletonHolder = KuberMetricEventsLogger.Companion.getInstance(INSTANCE.a(context, null));
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            KuberMetricEventsLogger.addMetricEvent$default(singletonHolder, event, operationName, null, 4, null);
        } else {
            KuberMetricEventsLogger.addMetricEvent$default(singletonHolder, event, operationName, str, str2, null, 16, null);
        }
    }

    public static /* synthetic */ void addMetricEvent$default(String str, String str2, Context context, String str3, String str4, int i2, Object obj) throws JSONException {
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        if ((i2 & 16) != 0) {
            str4 = null;
        }
        addMetricEvent(str, str2, context, str3, str4);
    }

    @JvmStatic
    public static final void init(@NotNull Context context, @NotNull String merchantId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(merchantId, "merchantId");
        InstrumentUtil instrumentUtil = INSTANCE;
        f14876a = KuberMetricEventsLogger.Companion.getInstance(instrumentUtil.a(context, merchantId));
        f14877b = new CrashEventsLogger(instrumentUtil.a(context, merchantId));
    }

    @JvmStatic
    public static final void initWithReset(@NotNull Context context, @NotNull String merchantId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(merchantId, "merchantId");
        KuberMetricEventsLogger.Companion.clear();
        CrashEventsLogger.Companion.clear();
        init(context, merchantId);
    }

    public static /* synthetic */ void logCrashEvents$default(InstrumentUtil instrumentUtil, Throwable th, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        instrumentUtil.logCrashEvents(th, str);
    }

    public final ClientSdkData a(Context context, String str) throws JSONException {
        String string;
        if (str != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("MerchantId", str);
            string = jSONObject.toString();
        } else {
            string = null;
        }
        return new ClientSdkData("5a19174c-d4dc-436e-867c-866e396b4904", context, "com.amazon.android.apay.commonlibrary", "L.1.3.8", string);
    }

    public final void logCrashEvents(@NotNull Throwable throwable, @Nullable String str) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        CrashEventsLogger crashEventsLogger = f14877b;
        if (crashEventsLogger != null) {
            crashEventsLogger.logCrashEvent(throwable, str);
        }
    }

    public static /* synthetic */ void addMetricEvent$default(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = null;
        }
        addMetricEvent(str, str2, str3);
    }

    public static /* synthetic */ void addMetricEvent$default(String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            str5 = null;
        }
        addMetricEvent(str, str2, str3, str4, str5);
    }

    @JvmStatic
    public static final void addMetricEvent(@NotNull String event, @NotNull String operationName, @Nullable String str) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        KuberMetricEventsLogger kuberMetricEventsLogger = f14876a;
        if (kuberMetricEventsLogger != null) {
            kuberMetricEventsLogger.addMetricEvent(event, operationName, str);
        }
    }

    @JvmStatic
    public static final void addMetricEvent(@NotNull String event, @NotNull String operationName, @NotNull String reasonCode, @NotNull String stackTrace, @Nullable String str) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        Intrinsics.checkNotNullParameter(reasonCode, "reasonCode");
        Intrinsics.checkNotNullParameter(stackTrace, "stackTrace");
        KuberMetricEventsLogger kuberMetricEventsLogger = f14876a;
        if (kuberMetricEventsLogger != null) {
            kuberMetricEventsLogger.addMetricEvent(event, operationName, reasonCode, stackTrace, str);
        }
    }
}
