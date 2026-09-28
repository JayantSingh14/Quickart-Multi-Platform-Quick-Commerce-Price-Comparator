package androidx.webkit;

import androidx.annotation.AnyThread;
import androidx.annotation.RestrictTo;
import androidx.webkit.internal.ProxyControllerImpl;

@AnyThread
/* loaded from: classes3.dex */
public abstract class ProxyController {

    public static class LAZY_HOLDER {
        static {
            new ProxyControllerImpl();
        }
    }

    @RestrictTo
    public ProxyController() {
    }
}
