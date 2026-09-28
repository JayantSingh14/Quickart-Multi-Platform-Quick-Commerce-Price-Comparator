package androidx.browser.browseractions;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
/* loaded from: classes3.dex */
public class BrowserActionsIntent {

    @RestrictTo
    @VisibleForTesting
    public interface BrowserActionsFallDialogListener {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface BrowserActionsItemId {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface BrowserActionsUrlType {
    }

    public static final class Builder {
    }
}
