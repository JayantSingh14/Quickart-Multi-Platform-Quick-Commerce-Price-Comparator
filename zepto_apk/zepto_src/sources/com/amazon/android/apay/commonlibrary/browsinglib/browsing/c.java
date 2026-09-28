package com.amazon.android.apay.commonlibrary.browsinglib.browsing;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsIntent;
import com.amazon.android.apay.commonlibrary.browsinglib.model.BrowsingRequest;
import com.amazon.android.apay.commonlibrary.commonlib.utils.InstrumentUtil;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import com.amazon.android.apay.commonlibrary.interfaces.model.AmazonPayError;

/* loaded from: classes3.dex */
public class c implements a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f14853a;

    public c(Context context) {
        this.f14853a = context;
    }

    public static CustomTabsIntent b(BrowsingRequest browsingRequest) {
        CustomTabColorSchemeParams customTabColorSchemeParams;
        try {
            CustomTabColorSchemeParams.Builder builder = new CustomTabColorSchemeParams.Builder();
            Integer numValueOf = Integer.valueOf(Color.parseColor(browsingRequest.getCustomTabToolbarColor()) | (-16777216));
            builder.f1303a = numValueOf;
            customTabColorSchemeParams = new CustomTabColorSchemeParams(numValueOf);
        } catch (Exception unused) {
            CustomTabColorSchemeParams.Builder builder2 = new CustomTabColorSchemeParams.Builder();
            Integer numValueOf2 = Integer.valueOf((-16777216) | Color.parseColor("#FFFFFF"));
            builder2.f1303a = numValueOf2;
            customTabColorSchemeParams = new CustomTabColorSchemeParams(numValueOf2);
        }
        CustomTabsIntent.Builder builder3 = new CustomTabsIntent.Builder();
        builder3.f1343a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", 1);
        builder3.f1346d = customTabColorSchemeParams.a();
        CustomTabsIntent customTabsIntentA = builder3.a();
        Intent intent = customTabsIntentA.f1341a;
        intent.setPackage("com.android.chrome");
        intent.putExtra("com.android.browser.headers", b.a(browsingRequest));
        return customTabsIntentA;
    }

    @Override // com.amazon.android.apay.commonlibrary.browsinglib.browsing.a
    public final void a(BrowsingRequest browsingRequest) {
        InstrumentUtil.addMetricEvent("CustomTabInvoked", "BrowsingExperience", browsingRequest.getStitchingId());
        try {
            b(browsingRequest).a(this.f14853a, Uri.parse(browsingRequest.getPayUrl()));
        } catch (Exception unused) {
            InstrumentUtil.addMetricEvent("CustomTabInvokedError", "BrowsingExperience", browsingRequest.getStitchingId());
            throw new AmazonPayError(MerchantConstants.BROWSING_EXPERIENCE_ERROR, "Unable to launch url on custom tabs");
        } catch (NoSuchMethodError unused2) {
            InstrumentUtil.addMetricEvent("CustomTabInvokedIncompatible", "BrowsingExperience", browsingRequest.getStitchingId());
            throw new AmazonPayError(MerchantConstants.BROWSING_EXPERIENCE_ERROR, "The current version of chrome custom tabs being used by your application is not compatible with the sdk. Please use version 25+.");
        }
    }
}
