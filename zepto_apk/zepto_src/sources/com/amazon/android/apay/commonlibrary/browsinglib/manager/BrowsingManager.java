package com.amazon.android.apay.commonlibrary.browsinglib.manager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.amazon.android.apay.commonlibrary.browsinglib.activity.BrowsingActivity;
import com.amazon.android.apay.commonlibrary.browsinglib.model.BrowsingRequest;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import com.amazon.android.apay.commonlibrary.interfaces.model.AmazonPayTransactionRequest;
import java.util.UUID;

/* loaded from: classes3.dex */
public class BrowsingManager {

    /* renamed from: a, reason: collision with root package name */
    public final String f14855a = UUID.randomUUID().toString();

    public final Intent a(AmazonPayTransactionRequest amazonPayTransactionRequest) {
        Intent intent = new Intent("com.amazon.mShop.kuber.rendering.activity.PaymentRenderingService");
        intent.putExtra("url", amazonPayTransactionRequest.getPaymentUrl());
        intent.putExtra("stitchingId", this.f14855a);
        if (amazonPayTransactionRequest.getData() != null && amazonPayTransactionRequest.getData().containsKey(MerchantConstants.MERCHANT_ID)) {
            intent.putExtra("CLIENT_ID", (String) amazonPayTransactionRequest.getData().get(MerchantConstants.MERCHANT_ID));
        }
        intent.setData(Uri.parse("apay_wallet_intent://pay"));
        return intent;
    }

    public final Intent b(AmazonPayTransactionRequest amazonPayTransactionRequest, Context context) {
        String paymentUrl = amazonPayTransactionRequest.getPaymentUrl();
        String str = this.f14855a;
        try {
            Uri uri = Uri.parse(paymentUrl);
            if (uri.getQueryParameterNames().isEmpty()) {
                paymentUrl = uri.toString();
            } else {
                paymentUrl = Uri.parse(paymentUrl + "&stitchingId=" + str).toString();
            }
        } catch (Exception unused) {
        }
        BrowsingRequest browsingRequest = new BrowsingRequest(paymentUrl, str, (amazonPayTransactionRequest.getData() == null || !amazonPayTransactionRequest.getData().containsKey(MerchantConstants.MERCHANT_ID)) ? context.getPackageName() == null ? "UNKNOWN" : context.getPackageName() : (String) amazonPayTransactionRequest.getData().get(MerchantConstants.MERCHANT_ID), (amazonPayTransactionRequest.getData() == null || !amazonPayTransactionRequest.getData().containsKey(MerchantConstants.CUSTOM_TAB_TOOLBAR_COLOR)) ? "#FFFFFF" : (String) amazonPayTransactionRequest.getData().get(MerchantConstants.CUSTOM_TAB_TOOLBAR_COLOR));
        Intent intent = new Intent(context, (Class<?>) BrowsingActivity.class);
        intent.putExtra("BrowsingActivityRequest", browsingRequest);
        return intent;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
    
        if (java.lang.Boolean.parseBoolean(r1.getQueryParameter("browserRedirect")) != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Pair c(com.amazon.android.apay.commonlibrary.interfaces.model.AmazonPayTransactionRequest r9, android.content.Context r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazon.android.apay.commonlibrary.browsinglib.manager.BrowsingManager.c(com.amazon.android.apay.commonlibrary.interfaces.model.AmazonPayTransactionRequest, android.content.Context, java.lang.String):android.util.Pair");
    }
}
