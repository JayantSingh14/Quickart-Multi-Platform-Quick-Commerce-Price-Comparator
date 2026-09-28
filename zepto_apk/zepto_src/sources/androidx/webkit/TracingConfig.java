package androidx.webkit;

import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class TracingConfig {

    public static class Builder {
        public Builder() {
            new ArrayList();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface PredefinedCategories {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface TracingMode {
    }
}
