package androidx.webkit;

import androidx.annotation.AnyThread;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@AnyThread
/* loaded from: classes3.dex */
public abstract class ServiceWorkerWebSettingsCompat {

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface CacheMode {
    }

    @RestrictTo
    public ServiceWorkerWebSettingsCompat() {
    }
}
