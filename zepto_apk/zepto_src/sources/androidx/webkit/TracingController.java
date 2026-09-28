package androidx.webkit;

import androidx.annotation.AnyThread;
import androidx.annotation.RestrictTo;
import androidx.webkit.internal.TracingControllerImpl;

@AnyThread
/* loaded from: classes3.dex */
public abstract class TracingController {

    public static class LAZY_HOLDER {
        static {
            new TracingControllerImpl();
        }
    }

    @RestrictTo
    public TracingController() {
    }
}
