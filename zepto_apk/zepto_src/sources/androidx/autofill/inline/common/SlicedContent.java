package androidx.autofill.inline.common;

import android.net.Uri;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.autofill.inline.UiVersions;

@RequiresApi
@RestrictTo
/* loaded from: classes3.dex */
public abstract class SlicedContent implements UiVersions.Content {

    @RestrictTo
    public static abstract class Builder<T extends SlicedContent> {
    }

    static {
        Uri.parse("inline.slice");
    }
}
