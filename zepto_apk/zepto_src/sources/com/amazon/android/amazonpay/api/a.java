package com.amazon.android.amazonpay.api;

import android.content.Context;
import com.amazon.android.apay.commonlibrary.commonlib.manager.BoundServiceManager;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.tencent.mmkv.MMKV;
import com.zeptoconsumerapp.Startup.AppPhoenixManager;
import com.zeptoconsumerapp.Utils;
import com.zeptoconsumerapp.modules.base.StorageKeys;
import com.zeptoconsumerapp.modules.base.StorageManager;
import com.zeptoconsumerapp.modules.event.domain.LogEventUseCase;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14842a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f14843b;

    public /* synthetic */ a(Context context, int i2) {
        this.f14842a = i2;
        this.f14843b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        int i2;
        Response responseD;
        Context context = this.f14843b;
        switch (this.f14842a) {
            case 0:
                ExecutorService executorService = AmazonPay.f14840a;
                Intrinsics.checkNotNullParameter(context, "$context");
                new BoundServiceManager().createBoundServiceConnection(context);
                break;
            default:
                String str2 = Utils.f47559a;
                try {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    OkHttpClient okHttpClientB = OkHttpClientProvider.b();
                    Request.Builder builder = new Request.Builder();
                    builder.i("https://ik.imagekit.io/jupdt2k6txi/production/app/config/customer_app_android_config_data.json");
                    Request requestB = builder.b();
                    int i3 = -1;
                    try {
                        responseD = okHttpClientB.a(requestB).d();
                        try {
                            boolean zC = responseD.c();
                            ResponseBody responseBody = responseD.f56356g;
                            i2 = responseD.f56353d;
                            if (zC && i2 == 200 && responseBody != null) {
                                String strTrim = responseBody.r().trim();
                                if (!strTrim.isEmpty()) {
                                    JsonParser.b(strTrim);
                                    MMKV mmkvA = StorageManager.a();
                                    StorageKeys[] storageKeysArr = StorageKeys.f47625b;
                                    mmkvA.encode("app_config", strTrim);
                                }
                                str = APayConstants.SUCCESS;
                            } else {
                                str = responseBody == null ? "empty response" : "failure";
                            }
                        } catch (Throwable th) {
                            try {
                                responseD.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (JsonSyntaxException e2) {
                        e = e2;
                    } catch (Exception unused) {
                    }
                    try {
                        responseD.close();
                    } catch (JsonSyntaxException e3) {
                        e = e3;
                        i3 = i2;
                        FirebaseCrashlytics.getInstance().recordException(e);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("native_error", "json exception");
                        MixpanelAPI.l(context, com.zeptoconsumerapp.BuildConfig.MIXPANEL_KEY, null, false).y("app_config_not_found", jSONObject);
                        str = "api_failed_json_exception";
                        i2 = i3;
                        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                        Map mapH = com.google.android.gms.internal.pal.a.h(str, String.valueOf(i2), String.valueOf(jCurrentTimeMillis2));
                        MMKV mmkvA2 = StorageManager.a();
                        StorageKeys[] storageKeysArr2 = StorageKeys.f47625b;
                        mmkvA2.encode("configTrace", Utils.c().j(mapH));
                        HashMap map = new HashMap();
                        String strF = Utils.f(context);
                        map.put("is_anonymous", Utils.g(context));
                        map.put("userId", strF);
                        map.put(APayConstants.Error.MESSAGE, str);
                        map.put("event_name", "app_config_fetch");
                        map.put("duration", Long.valueOf(jCurrentTimeMillis2));
                        map.put("is_from_silent_push", Boolean.valueOf(AppPhoenixManager.f47553b.f47555a));
                        Object obj = LogEventUseCase.f47644a;
                        LogEventUseCase.Companion.a("app_generic_events_v1", map);
                        return;
                    } catch (Exception unused2) {
                        i3 = i2;
                        str = "api_failed_exception";
                        i2 = i3;
                        long jCurrentTimeMillis22 = System.currentTimeMillis() - jCurrentTimeMillis;
                        Map mapH2 = com.google.android.gms.internal.pal.a.h(str, String.valueOf(i2), String.valueOf(jCurrentTimeMillis22));
                        MMKV mmkvA22 = StorageManager.a();
                        StorageKeys[] storageKeysArr22 = StorageKeys.f47625b;
                        mmkvA22.encode("configTrace", Utils.c().j(mapH2));
                        HashMap map2 = new HashMap();
                        String strF2 = Utils.f(context);
                        map2.put("is_anonymous", Utils.g(context));
                        map2.put("userId", strF2);
                        map2.put(APayConstants.Error.MESSAGE, str);
                        map2.put("event_name", "app_config_fetch");
                        map2.put("duration", Long.valueOf(jCurrentTimeMillis22));
                        map2.put("is_from_silent_push", Boolean.valueOf(AppPhoenixManager.f47553b.f47555a));
                        Object obj2 = LogEventUseCase.f47644a;
                        LogEventUseCase.Companion.a("app_generic_events_v1", map2);
                        return;
                    }
                    long jCurrentTimeMillis222 = System.currentTimeMillis() - jCurrentTimeMillis;
                    Map mapH22 = com.google.android.gms.internal.pal.a.h(str, String.valueOf(i2), String.valueOf(jCurrentTimeMillis222));
                    MMKV mmkvA222 = StorageManager.a();
                    StorageKeys[] storageKeysArr222 = StorageKeys.f47625b;
                    mmkvA222.encode("configTrace", Utils.c().j(mapH22));
                    HashMap map22 = new HashMap();
                    String strF22 = Utils.f(context);
                    map22.put("is_anonymous", Utils.g(context));
                    map22.put("userId", strF22);
                    map22.put(APayConstants.Error.MESSAGE, str);
                    map22.put("event_name", "app_config_fetch");
                    map22.put("duration", Long.valueOf(jCurrentTimeMillis222));
                    map22.put("is_from_silent_push", Boolean.valueOf(AppPhoenixManager.f47553b.f47555a));
                    Object obj22 = LogEventUseCase.f47644a;
                    LogEventUseCase.Companion.a("app_generic_events_v1", map22);
                } catch (Throwable th3) {
                    Utils.i(th3);
                }
                break;
        }
    }
}
