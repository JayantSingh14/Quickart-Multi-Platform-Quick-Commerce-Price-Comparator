package com.zeptoconsumerapp.AppServiceStarter.api;

import com.zeptoconsumerapp.AppServiceStarter.model.OrderCleanupResponse;
import in.juspay.hypersdk.core.PaymentConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata
/* loaded from: classes4.dex */
public interface OrderCleanupApiService {
    @POST("order-creation-service/api/v1/order/{orderId}/cancel")
    @NotNull
    Call<OrderCleanupResponse> a(@Path(PaymentConstants.ORDER_ID_CAMEL) @NotNull String str);
}
