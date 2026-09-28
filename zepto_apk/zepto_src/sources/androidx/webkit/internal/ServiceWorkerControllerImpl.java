package androidx.webkit.internal;

import android.webkit.ServiceWorkerController;
import androidx.webkit.ServiceWorkerControllerCompat;

/* loaded from: classes3.dex */
public class ServiceWorkerControllerImpl extends ServiceWorkerControllerCompat {

    /* renamed from: a, reason: collision with root package name */
    public final ServiceWorkerController f12439a;

    public ServiceWorkerControllerImpl() {
        WebViewFeatureInternal.f12447a.getClass();
        ServiceWorkerController serviceWorkerController = ServiceWorkerController.getInstance();
        this.f12439a = serviceWorkerController;
        if (serviceWorkerController == null) {
            this.f12439a = ServiceWorkerController.getInstance();
        }
        this.f12439a.getServiceWorkerWebSettings();
        new ServiceWorkerWebSettingsImpl();
    }
}
