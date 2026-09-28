package com.zeptoconsumerapp.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import bridges.CommsModule;
import com.zeptoconsumerapp.AppServiceStarter.api.OrderCleanupApiService;
import com.zeptoconsumerapp.AppServiceStarter.model.OrderCleanupResponse;
import com.zeptoconsumerapp.AppServiceStarter.network.OrderCleanupRetrofitClient;
import com.zeptoconsumerapp.services.OrderCleanupService;
import in.juspay.hypersdk.core.PaymentConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okhttp3.ResponseBody$Companion$asResponseBody$1;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

@Metadata
/* loaded from: classes4.dex */
public final class OrderCleanupService extends Service {

    /* renamed from: b, reason: collision with root package name */
    public static final String f47811b = Reflection.a(OrderCleanupService.class).i();

    /* renamed from: a, reason: collision with root package name */
    public String f47812a;

    @Metadata
    public static final class Companion {
        public static final void a(String str) {
            String str2 = OrderCleanupService.f47811b;
            Timber.d(OrderCleanupService.f47811b).w(str, new Object[0]);
        }

        public static void b(String str, Throwable th) {
            if (th != null) {
                Timber.d(OrderCleanupService.f47811b).w(th, str, new Object[0]);
            } else {
                Timber.d(OrderCleanupService.f47811b).w(str, new Object[0]);
            }
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        if (intent == null) {
            stopSelf(i3);
            return 2;
        }
        this.f47812a = intent.getStringExtra(PaymentConstants.ORDER_ID_CAMEL);
        return 3;
    }

    @Override // android.app.Service
    public final void onTaskRemoved(Intent rootIntent) {
        Intrinsics.checkNotNullParameter(rootIntent, "rootIntent");
        Companion.a("App was killed - performing cleanup");
        String token = "";
        try {
            Companion.a("Starting doCleanupWork");
            String string = getApplicationContext().getSharedPreferences(CommsModule.SHARED_PREFERENCE_NAME, 0).getString("accessToken", "");
            if (string != null) {
                token = string;
            }
            Companion.a("Access token length: " + token.length());
            String str = OrderCleanupRetrofitClient.f47329a;
            Intrinsics.checkNotNullParameter(token, "token");
            OrderCleanupRetrofitClient.f47329a = token;
            String str2 = this.f47812a;
            if (str2 != null) {
                Companion.a("Making API call for orderId: ".concat(str2));
                Object value = OrderCleanupRetrofitClient.f47330b.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                Call<OrderCleanupResponse> callA = ((OrderCleanupApiService) value).a(str2);
                Companion.a("Call object created, enqueueing...");
                callA.N(new Callback<OrderCleanupResponse>() { // from class: com.zeptoconsumerapp.services.OrderCleanupService$doCleanupWork$1$1
                    @Override // retrofit2.Callback
                    public final void a(Call call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        String str3 = OrderCleanupService.f47811b;
                        OrderCleanupService.Companion.b("onFailure called: " + t.getMessage(), t);
                        this.f47813a.stopSelf();
                    }

                    @Override // retrofit2.Callback
                    public final void b(Call call, Response response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        String str3 = OrderCleanupService.f47811b;
                        okhttp3.Response response2 = response.f58224a;
                        OrderCleanupService.Companion.a("onResponse called - Code: " + response2.f56353d);
                        if (response2.c()) {
                            OrderCleanupService.Companion.a("Cleanup API success: " + response.f58225b);
                        } else {
                            OrderCleanupService.Companion.a("Cleanup API failed: " + response2.f56353d + " - " + response2.f56352c);
                            ResponseBody$Companion$asResponseBody$1 responseBody$Companion$asResponseBody$1 = response.f58226c;
                            if (responseBody$Companion$asResponseBody$1 != null) {
                                OrderCleanupService.Companion.b("Error body: ".concat(responseBody$Companion$asResponseBody$1.r()), null);
                            }
                        }
                        this.f47813a.stopSelf();
                    }
                });
                Companion.a("Call enqueued successfully");
            } else {
                stopSelf();
            }
            Companion.a("doCleanupWork: after api call");
        } catch (Exception e2) {
            stopSelf();
            Companion.b("Exception in doCleanupWork: " + e2.getMessage(), e2);
        }
        super.onTaskRemoved(rootIntent);
    }
}
