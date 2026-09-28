package androidx.autofill.inline.common;

import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

@RequiresApi
@RestrictTo
/* loaded from: classes3.dex */
public abstract class BundledStyle {

    public static abstract class Builder<T extends BundledStyle> {
        public Builder(String str) {
            new Bundle().putBoolean(str, true);
        }
    }
}
