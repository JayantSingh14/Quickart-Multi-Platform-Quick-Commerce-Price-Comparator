package com.zeptoconsumerapp.AppServiceStarter.cleanup;

import android.content.Context;
import com.zeptoconsumerapp.AppServiceStarter.api.POIACleanupApiService;
import com.zeptoconsumerapp.AppServiceStarter.model.POIARequestBody;
import com.zeptoconsumerapp.AppServiceStarter.network.POIACleanupRetrofitClient;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;

@Metadata
/* loaded from: classes4.dex */
public final class POIACleanupAction implements CleanupAction {

    @Metadata
    public static final class Companion {
    }

    @Override // com.zeptoconsumerapp.AppServiceStarter.cleanup.CleanupAction
    public final Call a(Context context, String token, Map extras) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(token, "accessToken");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Object obj = extras.get(PaymentConstants.ORDER_ID_CAMEL);
        String str = obj instanceof String ? (String) obj : null;
        if (str == null || str.length() == 0) {
            return null;
        }
        String str2 = POIACleanupRetrofitClient.f47331a;
        Intrinsics.checkNotNullParameter(token, "token");
        POIACleanupRetrofitClient.f47331a = token;
        POIARequestBody pOIARequestBody = new POIARequestBody();
        Object value = POIACleanupRetrofitClient.f47332b.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return ((POIACleanupApiService) value).a(str, pOIARequestBody);
    }
}
