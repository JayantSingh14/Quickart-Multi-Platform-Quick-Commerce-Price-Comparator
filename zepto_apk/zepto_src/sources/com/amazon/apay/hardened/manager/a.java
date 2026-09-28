package com.amazon.apay.hardened.manager;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsIntent;
import com.amazon.apay.hardened.external.model.APayError;
import com.amazon.apay.hardened.external.model.APayRequestContext;
import com.amazon.apay.instrumentation.logger.KuberMetricEventsLogger;
import java.util.List;
import timber.log.Timber;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static a f15002b;

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC0015a f15003a;

    /* renamed from: com.amazon.apay.hardened.manager.a$a, reason: collision with other inner class name */
    public interface InterfaceC0015a {
        void a(APayRequestContext aPayRequestContext, String str);
    }

    public static class b implements InterfaceC0015a {
        public static boolean b(Context context) {
            Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
            intent.setPackage("com.android.chrome");
            List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            return listQueryIntentServices != null && listQueryIntentServices.size() > 0;
        }

        @Override // com.amazon.apay.hardened.manager.a.InterfaceC0015a
        public final void a(APayRequestContext aPayRequestContext, String str) throws APayError {
            com.amazon.apay.hardened.manager.b.a("CHARGE_OPERATION.CustomTabInvoked", "KUBER_HARDENED_SDK.BROWSING_MANAGER_OPERATION");
            try {
                Context context = aPayRequestContext.getContext();
                CustomTabsIntent customTabsIntent = aPayRequestContext.getCustomTabsIntent();
                customTabsIntent.f1341a.setPackage("com.android.chrome");
                a.b(customTabsIntent.f1341a, aPayRequestContext.getClientId(), aPayRequestContext.getId());
                customTabsIntent.a(context, Uri.parse(str));
            } catch (Exception e2) {
                Timber.b(e2, "Unable to launch url on custom tab: %s", e2.getMessage());
                throw new APayError(APayError.ErrorType.BROWSING_EXPERIENCE, "CustomTabError", "Unable to launch url on custom tab.", e2);
            } catch (NoSuchMethodError e3) {
                throw new APayError(APayError.ErrorType.BROWSING_EXPERIENCE, "CustomTabNoSuchMethodError", "The current version of chrome custom tabs being used by your application is not compatible with the sdk. Please use version 25+.", e3);
            }
        }
    }

    public static class c implements InterfaceC0015a {
        @Override // com.amazon.apay.hardened.manager.a.InterfaceC0015a
        public final void a(APayRequestContext aPayRequestContext, String str) throws APayError {
            com.amazon.apay.hardened.manager.b.a("CHARGE_OPERATION.ExternalBrowserInvoked", "KUBER_HARDENED_SDK.BROWSING_MANAGER_OPERATION");
            try {
                Context context = aPayRequestContext.getContext();
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addFlags(268435456);
                intent.addFlags(1073741824);
                intent.putExtra("com.android.browser.application_id", context.getPackageName() + ".amazon.apay");
                a.b(intent, aPayRequestContext.getClientId(), aPayRequestContext.getId());
                context.startActivity(intent);
            } catch (Exception e2) {
                Timber.b(e2, "Unable to launch url on browser: %s", e2.getMessage());
                throw new APayError(APayError.ErrorType.BROWSING_EXPERIENCE, "ExternalBrowserError", "Unable to launch url on browser.", e2);
            }
        }
    }

    public a(InterfaceC0015a interfaceC0015a) {
        this.f15003a = interfaceC0015a;
    }

    public static synchronized a a(Context context) {
        try {
            if (f15002b == null) {
                if (b.b(context)) {
                    f15002b = new a(new b());
                    com.amazon.apay.hardened.manager.b.a("CustomTabsSupported", "KUBER_HARDENED_SDK.BROWSING_MANAGER_OPERATION");
                } else {
                    f15002b = new a(new c());
                    com.amazon.apay.hardened.manager.b.a("CustomTabsUnSupported", "KUBER_HARDENED_SDK.BROWSING_MANAGER_OPERATION");
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return f15002b;
    }

    public static void b(Intent intent, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("x-amz-sdk-version", "H.1.1.13");
        bundle.putString("x-amz-sdk-request-id", str2);
        bundle.putString("x-amz-sdk-client-id", str);
        intent.putExtra("com.android.browser.headers", bundle);
    }

    public final void c(APayRequestContext aPayRequestContext, String str) {
        if (aPayRequestContext.getCustomTabsIntent() == null || !b.b(aPayRequestContext.getContext())) {
            this.f15003a = new c();
        } else if (!(this.f15003a instanceof b)) {
            this.f15003a = new b();
        }
        try {
            this.f15003a.a(aPayRequestContext, str);
            com.amazon.apay.hardened.manager.b.a("CHARGE_OPERATION.OpenUrlSuccess", "KUBER_HARDENED_SDK.BROWSING_MANAGER_OPERATION");
            boolean z = this.f15003a instanceof b;
        } catch (APayError e2) {
            if (!(this.f15003a instanceof b)) {
                throw e2;
            }
            Timber.f58263c.w(e2, "Error while opening chrome custom tab, proceeding in device browser.", new Object[0]);
            String string = e2.toString();
            KuberMetricEventsLogger kuberMetricEventsLogger = com.amazon.apay.hardened.manager.b.f15004a;
            if (kuberMetricEventsLogger != null) {
                kuberMetricEventsLogger.addMetricEvent("CHARGE_OPERATION.ExternalBrowserFallback", "KUBER_HARDENED_SDK.BROWSING_MANAGER_OPERATION", "", string);
            }
            com.amazon.apay.hardened.manager.b.a("CHARGE_OPERATION.ExternalBrowserInvoked", "KUBER_HARDENED_SDK.BROWSING_MANAGER_OPERATION");
            try {
                Context context = aPayRequestContext.getContext();
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addFlags(268435456);
                intent.addFlags(1073741824);
                intent.putExtra("com.android.browser.application_id", context.getPackageName() + ".amazon.apay");
                b(intent, aPayRequestContext.getClientId(), aPayRequestContext.getId());
                context.startActivity(intent);
            } catch (Exception e3) {
                Timber.b(e3, "Unable to launch url on browser: %s", e3.getMessage());
                throw new APayError(APayError.ErrorType.BROWSING_EXPERIENCE, "ExternalBrowserError", "Unable to launch url on browser.", e3);
            }
        }
    }
}
