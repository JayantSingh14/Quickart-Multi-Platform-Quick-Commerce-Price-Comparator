package androidx.autofill.inline.common;

import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.autofill.inline.common.BundledStyle;

@RequiresApi
/* loaded from: classes3.dex */
public class ViewStyle extends BundledStyle {

    @RestrictTo
    public static abstract class BaseBuilder<T extends ViewStyle, B extends BaseBuilder<T, B>> extends BundledStyle.Builder<T> {
    }

    public static final class Builder extends BaseBuilder<ViewStyle, Builder> {
        public Builder() {
            super("view_style");
        }
    }
}
