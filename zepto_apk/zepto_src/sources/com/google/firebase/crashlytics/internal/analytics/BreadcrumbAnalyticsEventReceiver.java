package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public class BreadcrumbAnalyticsEventReceiver implements AnalyticsEventReceiver, BreadcrumbSource {

    /* renamed from: a, reason: collision with root package name */
    public BreadcrumbHandler f43714a;

    public static String c(Bundle bundle, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put(CLConstants.FIELD_PAY_INFO_NAME, str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }

    @Override // com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource
    public final void a(BreadcrumbHandler breadcrumbHandler) {
        this.f43714a = breadcrumbHandler;
        Logger.f43705a.b("Registered Firebase Analytics event receiver for breadcrumbs", null);
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver
    public final void b(Bundle bundle, String str) {
        BreadcrumbHandler breadcrumbHandler = this.f43714a;
        if (breadcrumbHandler != null) {
            try {
                breadcrumbHandler.a("$A$:" + c(bundle, str));
            } catch (JSONException unused) {
                Logger.f43705a.f("Unable to serialize Firebase Analytics event to breadcrumb.", null);
            }
        }
    }
}
