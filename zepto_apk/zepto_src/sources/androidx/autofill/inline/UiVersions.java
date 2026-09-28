package androidx.autofill.inline;

import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.HashSet;

@RequiresApi
/* loaded from: classes3.dex */
public final class UiVersions {

    public interface Content {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface InlineUiVersion {
    }

    public interface Style {
    }

    public static final class StylesBuilder {
    }

    static {
        new HashSet(Arrays.asList("androidx.autofill.inline.ui.version:v1"));
    }
}
