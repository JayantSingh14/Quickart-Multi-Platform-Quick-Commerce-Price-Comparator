package com.google.firebase.crashlytics.internal.settings;

import android.support.v4.media.b;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.network.HttpResponse;
import in.juspay.hyper.constants.LogSubCategory;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
class DefaultSettingsSpiCall implements SettingsSpiCall {

    /* renamed from: a, reason: collision with root package name */
    public final String f44420a;

    public DefaultSettingsSpiCall(String str, HttpRequestFactory httpRequestFactory) {
        this.f44420a = str;
    }

    public static void a(HttpGetRequest httpGetRequest, SettingsRequest settingsRequest) {
        String str = settingsRequest.f44447a;
        if (str != null) {
            httpGetRequest.c("X-CRASHLYTICS-GOOGLE-APP-ID", str);
        }
        httpGetRequest.c("X-CRASHLYTICS-API-CLIENT-TYPE", LogSubCategory.LifeCycle.ANDROID);
        httpGetRequest.c("X-CRASHLYTICS-API-CLIENT-VERSION", "19.4.4");
        httpGetRequest.c("Accept", "application/json");
        httpGetRequest.c("X-CRASHLYTICS-DEVICE-MODEL", settingsRequest.f44448b);
        String str2 = settingsRequest.f44449c;
        if (str2 != null) {
            httpGetRequest.c("X-CRASHLYTICS-OS-BUILD-VERSION", str2);
        }
        String str3 = settingsRequest.f44450d;
        if (str3 != null) {
            httpGetRequest.c("X-CRASHLYTICS-OS-DISPLAY-VERSION", str3);
        }
        String strA = settingsRequest.f44451e.c().a();
        if (strA != null) {
            httpGetRequest.c("X-CRASHLYTICS-INSTALLATION-ID", strA);
        }
    }

    public static HashMap b(SettingsRequest settingsRequest) {
        HashMap map = new HashMap();
        map.put("build_version", settingsRequest.f44454h);
        map.put("display_version", settingsRequest.f44453g);
        map.put("source", Integer.toString(settingsRequest.f44455i));
        String str = settingsRequest.f44452f;
        if (!TextUtils.isEmpty(str)) {
            map.put("instance", str);
        }
        return map;
    }

    public final JSONObject c(HttpResponse httpResponse) {
        StringBuilder sb = new StringBuilder("Settings response code was: ");
        int i2 = httpResponse.f44373a;
        sb.append(i2);
        String string = sb.toString();
        Logger logger = Logger.f43705a;
        logger.e(string);
        String str = this.f44420a;
        if (i2 != 200 && i2 != 201 && i2 != 202 && i2 != 203) {
            logger.c(b.h(i2, "Settings request failed; (status: ", ") from ", str), null);
            return null;
        }
        String str2 = httpResponse.f44374b;
        try {
            return new JSONObject(str2);
        } catch (Exception e2) {
            logger.f("Failed to parse settings JSON from ".concat(str), e2);
            logger.f("Settings response " + str2, null);
            return null;
        }
    }
}
