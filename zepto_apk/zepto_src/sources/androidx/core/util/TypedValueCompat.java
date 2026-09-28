package androidx.core.util;

import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class TypedValueCompat {

    @RequiresApi
    public static class Api34Impl {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface ComplexDimensionUnit {
    }

    public static int a(int i2) {
        return i2 & 15;
    }
}
