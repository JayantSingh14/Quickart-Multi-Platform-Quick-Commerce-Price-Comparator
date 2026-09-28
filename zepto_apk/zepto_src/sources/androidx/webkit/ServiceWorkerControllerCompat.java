package androidx.webkit;

import androidx.annotation.AnyThread;
import androidx.annotation.RestrictTo;
import androidx.webkit.internal.ServiceWorkerControllerImpl;

@AnyThread
/* loaded from: classes3.dex */
public abstract class ServiceWorkerControllerCompat {

    public static class LAZY_HOLDER {
        static {
            new ServiceWorkerControllerImpl();
        }
    }

    @RestrictTo
    public ServiceWorkerControllerCompat() {
    }
}
