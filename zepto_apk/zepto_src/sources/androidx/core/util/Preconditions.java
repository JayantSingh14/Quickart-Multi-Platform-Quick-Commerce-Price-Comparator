package androidx.core.util;

import androidx.annotation.RestrictTo;

@RestrictTo
/* loaded from: classes.dex */
public final class Preconditions {
    public static void a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void b(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void c(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }
}
