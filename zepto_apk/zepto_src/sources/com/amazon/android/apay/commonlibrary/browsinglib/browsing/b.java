package com.amazon.android.apay.commonlibrary.browsinglib.browsing;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.fragment.app.e;
import com.amazon.android.apay.commonlibrary.browsinglib.model.BrowsingRequest;
import com.amazon.android.apay.commonlibrary.commonlib.utils.InstrumentUtil;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import com.amazon.android.apay.commonlibrary.interfaces.model.AmazonPayError;
import java.util.Collections;

/* loaded from: classes3.dex */
public class b {
    public static Bundle a(BrowsingRequest browsingRequest) {
        Bundle bundleI = e.i("x-amz-sdk-version", "L.1.3.8");
        bundleI.putString("x-amz-sdk-stitching-id", browsingRequest.getStitchingId());
        bundleI.putString("x-amz-sdk-request-id", browsingRequest.getStitchingId());
        bundleI.putString("x-amz-sdk-client-id", browsingRequest.getMerchantId());
        return bundleI;
    }

    public static void b(BrowsingRequest browsingRequest, Context context) {
        a cVar = CustomTabsClient.a(context, Collections.singletonList("com.android.chrome")) != null ? new c(context) : new d(context);
        try {
            cVar.a(browsingRequest);
        } catch (AmazonPayError e2) {
            if (!(cVar instanceof c)) {
                throw e2;
            }
            InstrumentUtil.addMetricEvent("ExternalBrowserFallback", "BrowsingExperience", browsingRequest.getStitchingId());
            InstrumentUtil.addMetricEvent("ExternalBrowserInvoked", "BrowsingManager", browsingRequest.getStitchingId());
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(browsingRequest.getPayUrl()));
                intent.addFlags(268435456);
                intent.putExtra("com.android.browser.application_id", context.getPackageName() + ".amazon.apay");
                intent.putExtra("com.android.browser.headers", a(browsingRequest));
                context.startActivity(intent);
            } catch (Exception e3) {
                InstrumentUtil.addMetricEvent("ExternalBrowserInvokedError", "BrowsingManager", browsingRequest.getStitchingId());
                throw new AmazonPayError(MerchantConstants.BROWSING_EXPERIENCE_ERROR, "Unable to launch url on external browser", e3);
            }
        }
    }
}
