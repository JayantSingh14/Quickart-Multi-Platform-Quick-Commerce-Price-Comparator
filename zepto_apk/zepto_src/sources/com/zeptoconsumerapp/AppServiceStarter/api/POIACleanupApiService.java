package com.zeptoconsumerapp.AppServiceStarter.api;

import com.zeptoconsumerapp.AppServiceStarter.model.POIARequestBody;
import in.juspay.hypersdk.core.PaymentConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata
/* loaded from: classes4.dex */
public interface POIACleanupApiService {
    @POST("/post-order-service/api/v1/orders/{orderId}/poia")
    @NotNull
    Call<Object> a(@Path(PaymentConstants.ORDER_ID_CAMEL) @NotNull String str, @Body @NotNull POIARequestBody pOIARequestBody);
}
