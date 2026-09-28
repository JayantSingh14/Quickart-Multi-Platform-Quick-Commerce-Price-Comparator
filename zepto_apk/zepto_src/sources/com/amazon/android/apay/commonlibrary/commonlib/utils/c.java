package com.amazon.android.apay.commonlibrary.commonlib.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import com.amazonaws.mobileconnectors.remoteconfiguration.RemoteConfigurationManager;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.Scanner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.language.bm.Rule;
import org.json.JSONObject;

@Metadata
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f14881a = new c();

    public static RemoteConfigurationManager a(Context context, String merchantId) throws PackageManager.NameNotFoundException {
        Intrinsics.checkNotNullParameter(context, "context");
        RemoteConfigurationManager remoteConfigurationManager = RemoteConfigurationManager.getInstance("arn:aws:remote-config:us-west-2:377838819204:appConfig:a0dfwasf");
        if (remoteConfigurationManager != null) {
            return remoteConfigurationManager;
        }
        if (merchantId == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("lpaconfig", 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…EY, Context.MODE_PRIVATE)");
            merchantId = sharedPreferences.getString(PaymentConstants.MERCHANT_ID, Rule.ALL);
            Intrinsics.c(merchantId);
        }
        com.amazon.android.apay.commonlibrary.interfaces.model.c cVarA = b.a(context);
        String str = Build.VERSION.RELEASE;
        Integer numValueOf = Integer.valueOf(Build.VERSION.SDK_INT);
        Intrinsics.checkNotNullParameter(merchantId, "merchantId");
        Intrinsics.checkNotNullParameter("Android", "os");
        com.amazon.android.apay.commonlibrary.interfaces.model.b bVar = new com.amazon.android.apay.commonlibrary.interfaces.model.b();
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("lpaconfig", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "context.getSharedPrefere…EY, Context.MODE_PRIVATE)");
        SharedPreferences.Editor editorEdit = sharedPreferences2.edit();
        editorEdit.putString(PaymentConstants.MERCHANT_ID, merchantId);
        editorEdit.apply();
        RemoteConfigurationManager currentManager = RemoteConfigurationManager.forAppId(context, "arn:aws:remote-config:us-west-2:377838819204:appConfig:a0dfwasf").withDefaultConfiguration(b(context, bVar)).createOrGet();
        Intrinsics.checkNotNullExpressionValue(currentManager, "currentManager");
        currentManager.openAttributes().addAttribute("is_mshop", Boolean.valueOf(cVarA.f14956a));
        currentManager.openAttributes().addAttribute(PaymentConstants.MERCHANT_ID, merchantId);
        currentManager.openAttributes().addAttribute("os", "Android");
        currentManager.openAttributes().addAttribute("os_release_version", str);
        currentManager.openAttributes().addAttribute("os_sdk_version", numValueOf);
        currentManager.openAttributes().addAttribute("mshop_major_version", cVarA.f14957b);
        currentManager.openAttributes().addAttribute("mshop_release_version", cVarA.f14958c);
        currentManager.openAttributes().addAttribute("mshop_patch_version", cVarA.f14959d);
        currentManager.openAttributes().addAttribute("mshop_flavor_version", cVarA.f14960e);
        currentManager.openAttributes().addAttribute("super_sdk_version", "L.1.3.8");
        return currentManager;
    }

    public static JSONObject b(Context context, com.amazon.android.apay.commonlibrary.interfaces.model.b appConfigRequestMetaData) {
        String next;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appConfigRequestMetaData, "appConfigRequestMetaData");
        AssetManager assetManager = context.getApplicationContext().getAssets();
        Intrinsics.checkNotNullExpressionValue(assetManager, "context.applicationContext.assets");
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        Intrinsics.checkNotNullParameter("defaultArcusConfig.json", "filename");
        Intrinsics.checkNotNullParameter("UTF-8", "encoding");
        Scanner scannerUseDelimiter = new Scanner(assetManager.open("defaultArcusConfig.json"), "UTF-8").useDelimiter("\\A");
        try {
            if (scannerUseDelimiter.hasNext()) {
                next = scannerUseDelimiter.next();
                Intrinsics.checkNotNullExpressionValue(next, "scanner.next()");
            } else {
                next = "";
            }
            scannerUseDelimiter.close();
            return new JSONObject(next);
        } finally {
        }
    }
}
