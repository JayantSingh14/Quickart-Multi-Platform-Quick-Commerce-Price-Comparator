package com.amazon.android.apay.commonlibrary.browsinglib.role;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.amazon.android.apay.commonlibrary.browsinglib.manager.BrowsingManager;
import com.amazon.android.apay.commonlibrary.commonlib.utils.InstrumentUtil;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import com.amazon.android.apay.commonlibrary.interfaces.internal.SDKBrowsingRole;
import com.amazon.android.apay.commonlibrary.interfaces.model.AmazonPayError;
import com.amazon.android.apay.commonlibrary.interfaces.model.AmazonPayTransactionRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class SDKBrowsingRoleImpl implements SDKBrowsingRole {
    @Override // com.amazon.android.apay.commonlibrary.interfaces.internal.SDKBrowsingRole
    public Map<String, Object> getBrowsingIntent(@NonNull AmazonPayTransactionRequest amazonPayTransactionRequest, @NonNull Context context) throws Exception {
        BrowsingManager browsingManager = new BrowsingManager();
        HashMap map = new HashMap();
        try {
            Bundle bundle = null;
            Pair pairC = browsingManager.c(amazonPayTransactionRequest, context, (amazonPayTransactionRequest.getData() == null || !amazonPayTransactionRequest.getData().containsKey(MerchantConstants.MERCHANT_ID)) ? null : (String) amazonPayTransactionRequest.getData().get(MerchantConstants.MERCHANT_ID));
            map.put("Intent", pairC.second);
            if ("MSHOP".equals((String) pairC.first)) {
                bundle = new Bundle();
                bundle.putInt("android.activity.splashScreenStyle", 1);
            }
            map.put("Options", bundle);
            return map;
        } catch (Exception e2) {
            InstrumentUtil.addMetricEvent("Error", "BrowsingManager", "BrowsingIntentBuildError", Arrays.toString(e2.getStackTrace()), browsingManager.f14855a);
            if (e2 instanceof AmazonPayError) {
                throw e2;
            }
            throw new AmazonPayError(MerchantConstants.ERROR, "Something went wrong!!", e2);
        }
    }

    @Override // com.amazon.android.apay.commonlibrary.interfaces.internal.SDKBrowsingRole
    public void startBrowsing(@NonNull AmazonPayTransactionRequest amazonPayTransactionRequest, @NonNull Activity activity, int i2) throws Exception {
        BrowsingManager browsingManager = new BrowsingManager();
        String str = browsingManager.f14855a;
        try {
            InstrumentUtil.addMetricEvent("Initiate", "BrowsingManager", str);
            Bundle bundle = null;
            Pair pairC = browsingManager.c(amazonPayTransactionRequest, activity, (amazonPayTransactionRequest.getData() == null || !amazonPayTransactionRequest.getData().containsKey(MerchantConstants.MERCHANT_ID)) ? null : (String) amazonPayTransactionRequest.getData().get(MerchantConstants.MERCHANT_ID));
            try {
                Intent intent = (Intent) pairC.second;
                if ("MSHOP".equals((String) pairC.first)) {
                    bundle = new Bundle();
                    bundle.putInt("android.activity.splashScreenStyle", 1);
                }
                activity.startActivityForResult(intent, i2, bundle);
            } catch (Exception unused) {
                if ("MSHOP".equals(pairC.first)) {
                    InstrumentUtil.addMetricEvent("ViewTypeCCTFallbackMshopOpenError", "BrowsingManager", str);
                    activity.startActivityForResult(browsingManager.b(amazonPayTransactionRequest, activity), i2);
                }
            }
            InstrumentUtil.addMetricEvent("Completed", "BrowsingManager", str);
        } catch (Exception e2) {
            InstrumentUtil.addMetricEvent("Error", "BrowsingManager", "BrowsingError", Arrays.toString(e2.getStackTrace()), str);
            if (!(e2 instanceof AmazonPayError)) {
                throw new AmazonPayError(MerchantConstants.PAYMENT_ERROR, "Something went wrong!!", e2);
            }
            throw e2;
        }
    }
}
