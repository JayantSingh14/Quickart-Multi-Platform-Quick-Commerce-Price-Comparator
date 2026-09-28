package com.amazon.android.apay.commonlibrary.instrumentationlib.worker;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.amazon.android.apay.commonlibrary.instrumentationlib.clients.HttpsClient;
import com.amazon.android.apay.commonlibrary.instrumentationlib.utils.b;
import com.amazon.android.apay.commonlibrary.instrumentationlib.writer.a;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hypersdk.core.PaymentConstants;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes3.dex */
public final class EventsPublisherWorker extends Worker {

    /* renamed from: f, reason: collision with root package name */
    public final Context f14923f;

    /* renamed from: g, reason: collision with root package name */
    public final WorkerParameters f14924g;

    /* renamed from: h, reason: collision with root package name */
    public final HttpsClient f14925h;

    /* renamed from: i, reason: collision with root package name */
    public final String f14926i;

    /* renamed from: j, reason: collision with root package name */
    public final a f14927j;

    /* renamed from: k, reason: collision with root package name */
    public final com.amazon.android.apay.commonlibrary.instrumentationlib.encryptor.a f14928k;

    /* renamed from: l, reason: collision with root package name */
    public final String f14929l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventsPublisherWorker(@NotNull Context context, @NotNull WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        this.f14923f = context;
        this.f14924g = workerParams;
        this.f14925h = new HttpsClient();
        this.f14927j = new a(context);
        String strValueOf = String.valueOf(workerParams.f12588b.b("clientId"));
        this.f14929l = strValueOf;
        this.f14928k = new com.amazon.android.apay.commonlibrary.instrumentationlib.encryptor.a(strValueOf);
        this.f14926i = String.valueOf(workerParams.f12588b.b("event"));
    }

    public final String a(WorkerParameters workerParameters) throws JSONException {
        String str;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sessionId", (Object) null);
        Context context = this.f14923f;
        jSONObject.put(CLConstants.SALT_FIELD_APP_ID, context.getPackageName());
        jSONObject.put("brand", Build.BRAND);
        jSONObject.put(LogSubCategory.Context.DEVICE, Build.DEVICE);
        jSONObject.put("buildId", Build.ID);
        jSONObject.put("clientId", this.f14929l);
        jSONObject.put("clientSdkVersion", workerParameters.f12588b.b("clientSdkVersion"));
        Data data = workerParameters.f12588b;
        jSONObject.put("clientSdkName", data.b("clientSdkName"));
        jSONObject.put("clientAdditionalMetadata", data.b("clientAdditionalMetadata"));
        jSONObject.put("instrumentationSdkVersion", "L.1.3.8");
        try {
            str = context.getPackageManager().getPackageInfo("in.amazon.mShop.android.shopping", 0).versionName;
            Intrinsics.checkNotNullExpressionValue(str, "context.packageManager.g…            ).versionName");
        } catch (PackageManager.NameNotFoundException unused) {
            str = "mshopNotInstalled";
        }
        jSONObject.put("mshopVersion", str);
        jSONObject.put("product", Build.PRODUCT);
        jSONObject.put("releaseVersion", Build.VERSION.RELEASE);
        jSONObject.put(PaymentConstants.SDK_VERSION, Build.VERSION.SDK_INT);
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "payload.toString()");
        return string;
    }

    public final String b(Map map) {
        StringBuilder sb = new StringBuilder();
        sb.append(((String) map.get("iv")) + '\n');
        sb.append(((String) map.get("encryptedSessionKey")) + '\n');
        sb.append(((String) map.get("encryptedData")) + '\n');
        sb.append(((String) map.get("clientId")) + '\n');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "stringBuilder.toString()");
        return string;
    }

    @Override // androidx.work.Worker
    public final ListenableWorker.Result doWork() throws InterruptedException {
        HttpsClient httpsClient;
        long time;
        long jD;
        a aVar = this.f14927j;
        String str = this.f14926i;
        Iterator it = aVar.a(str).iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            httpsClient = this.f14925h;
            if (!zHasNext) {
                break;
            }
            String strA = (String) it.next();
            try {
                time = new Timestamp(System.currentTimeMillis()).getTime();
                jD = aVar.d(strA);
            } catch (Exception e2) {
                e2.toString();
                Objects.toString(e2.getCause());
            }
            if (StringsKt.n(strA, ".log", false) || time - jD > 240000) {
                if (StringsKt.n(strA, ".tmp", false)) {
                    b.f14922a.getClass();
                    strA = b.a(aVar, strA, str);
                }
                Integer numA = httpsClient.a(str.equals("MetricEvent") ? "https://amazonpay.amazon.in/v3/sdk/metric-events" : "https://amazonpay.amazon.in/v3/sdk/crash-events", strA, b(this.f14928k.a(a(this.f14924g) + '\n' + aVar.f(strA, str))));
                if (numA != null && (numA.intValue() / 100 == 2 || numA.intValue() / 100 == 4)) {
                    aVar.b(strA, str);
                }
                Thread.sleep(1000L);
            }
        }
        HttpsURLConnection httpsURLConnection = httpsClient.f14894a;
        if (httpsURLConnection != null) {
            httpsURLConnection.disconnect();
        }
        ListenableWorker.Result.Success success = new ListenableWorker.Result.Success();
        Intrinsics.checkNotNullExpressionValue(success, "success()");
        return success;
    }
}
