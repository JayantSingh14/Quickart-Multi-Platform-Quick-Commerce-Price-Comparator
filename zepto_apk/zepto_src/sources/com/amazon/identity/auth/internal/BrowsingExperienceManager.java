package com.amazon.identity.auth.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import com.amazon.android.apay.commonlibrary.commonlib.utils.InstrumentUtil;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.api.workflow.RequestContext;
import java.util.List;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class BrowsingExperienceManager {

    /* renamed from: b, reason: collision with root package name */
    public static BrowsingExperienceManager f15247b;

    /* renamed from: a, reason: collision with root package name */
    public a f15248a;

    public interface a {
        void a(RequestContext requestContext, String str);
    }

    public static class b implements a {
        public static boolean b(Context context) {
            Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
            intent.setPackage("com.android.chrome");
            List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            return (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) ? false : true;
        }

        @Override // com.amazon.identity.auth.internal.BrowsingExperienceManager.a
        public final void a(RequestContext requestContext, String str) throws JSONException, AuthError {
            InstrumentUtil.addMetricEvent("CustomTabInvoked", "LWA_LITE_SDK.BROWSING_MANAGER_OPERATION", requestContext.getContext(), (String) null, (String) null);
            try {
                Context context = requestContext.getContext();
                CustomTabsIntent customTabsIntent = requestContext.getCustomTabsIntent();
                customTabsIntent.f1341a.setPackage("com.android.chrome");
                customTabsIntent.a(context, Uri.parse(str));
            } catch (Exception e2) {
                throw new AuthError("Unable to Launch custom tab.", e2, AuthError.ERROR_TYPE.ERROR_UNKNOWN);
            } catch (NoSuchMethodError e3) {
                throw new AuthError("The current version of chrome custom tabs being used by your application is not compatible with the sdk. Please use version 25+.", e3, AuthError.ERROR_TYPE.ERROR_UNKNOWN);
            }
        }
    }

    public static class c implements a {
        public static Intent b(Context context, String str) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            intent.addFlags(1073741824);
            intent.putExtra("com.android.browser.application_id", context.getPackageName() + ".amazon.auth");
            return intent;
        }

        @Override // com.amazon.identity.auth.internal.BrowsingExperienceManager.a
        public final void a(RequestContext requestContext, String str) throws JSONException, AuthError {
            InstrumentUtil.addMetricEvent("ExternalBrowserInvoked", "LWA_LITE_SDK.BROWSING_MANAGER_OPERATION", requestContext.getContext(), (String) null, (String) null);
            try {
                Context context = requestContext.getContext();
                context.startActivity(b(context, str));
            } catch (Exception e2) {
                e2.getMessage();
                InstrumentUtil.addMetricEvent("ExternalBrowserLaunchFailed", "LWA_LITE_SDK.BROWSING_MANAGER_OPERATION", requestContext.getContext(), "LaunchBrowserException", ExceptionUtils.getStackTrace(e2));
                throw new AuthError("Unable to launch browser. Make sure a browser installed/enabled in your device", e2, AuthError.ERROR_TYPE.ERROR_UNKNOWN);
            }
        }
    }

    public BrowsingExperienceManager(a aVar) {
        this.f15248a = aVar;
    }

    public static synchronized BrowsingExperienceManager getInstance(Context context) {
        try {
            if (f15247b == null) {
                if (b.b(context)) {
                    f15247b = new BrowsingExperienceManager(new b());
                    InstrumentUtil.addMetricEvent("SSOCustomTabsSupported", "LWA_LITE_SDK.BROWSING_MANAGER_OPERATION", context, (String) null, (String) null);
                } else {
                    f15247b = new BrowsingExperienceManager(new c());
                    InstrumentUtil.addMetricEvent("SSOCustomTabsUnSupported", "LWA_LITE_SDK.BROWSING_MANAGER_OPERATION", context, (String) null, (String) null);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return f15247b;
    }

    public void openUrl(RequestContext requestContext, String str) throws JSONException, AuthError {
        if (requestContext.getCustomTabsIntent() == null || requestContext.getInvokingIntent() == null || !b.b(requestContext.getContext())) {
            this.f15248a = new c();
        } else if (!(this.f15248a instanceof b)) {
            this.f15248a = new b();
        }
        try {
            this.f15248a.a(requestContext, str);
            InstrumentUtil.addMetricEvent("OpenUrlSuccess", "LWA_LITE_SDK.BROWSING_MANAGER_OPERATION", requestContext.getContext(), (String) null, (String) null);
        } catch (AuthError e2) {
            if (!(this.f15248a instanceof b)) {
                throw e2;
            }
            this.f15248a = new c();
            InstrumentUtil.addMetricEvent("ExternalBrowserFallback", "LWA_LITE_SDK.BROWSING_MANAGER_OPERATION", requestContext.getContext(), "", e2.toString());
            this.f15248a.a(requestContext, str);
        }
    }
}
