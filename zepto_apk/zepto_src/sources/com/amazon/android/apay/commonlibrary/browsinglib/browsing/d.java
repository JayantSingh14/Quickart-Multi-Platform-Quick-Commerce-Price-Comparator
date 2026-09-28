package com.amazon.android.apay.commonlibrary.browsinglib.browsing;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.amazon.android.apay.commonlibrary.browsinglib.model.BrowsingRequest;
import com.amazon.android.apay.commonlibrary.commonlib.utils.InstrumentUtil;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import com.amazon.android.apay.commonlibrary.interfaces.model.AmazonPayError;

/* loaded from: classes3.dex */
public class d implements a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f14854a;

    public d(Context context) {
        this.f14854a = context;
    }

    @Override // com.amazon.android.apay.commonlibrary.browsinglib.browsing.a
    public final void a(BrowsingRequest browsingRequest) {
        Context context = this.f14854a;
        InstrumentUtil.addMetricEvent("ExternalBrowserInvoked", "BrowsingManager", browsingRequest.getStitchingId());
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(browsingRequest.getPayUrl()));
            intent.addFlags(268435456);
            intent.putExtra("com.android.browser.application_id", context.getPackageName() + ".amazon.apay");
            intent.putExtra("com.android.browser.headers", b.a(browsingRequest));
            context.startActivity(intent);
        } catch (Exception e2) {
            InstrumentUtil.addMetricEvent("ExternalBrowserInvokedError", "BrowsingManager", browsingRequest.getStitchingId());
            throw new AmazonPayError(MerchantConstants.BROWSING_EXPERIENCE_ERROR, "Unable to launch url on external browser", e2);
        }
    }
}
