package androidx.webkit;

import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class ProxyConfig {

    public static final class Builder {
        public Builder() {
            new ArrayList();
            new ArrayList();
        }
    }

    public static final class ProxyRule {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface ProxyScheme {
    }
}
