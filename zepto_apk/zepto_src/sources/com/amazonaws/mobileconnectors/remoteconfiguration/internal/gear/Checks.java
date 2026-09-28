package com.amazonaws.mobileconnectors.remoteconfiguration.internal.gear;

/* loaded from: classes3.dex */
public final class Checks {
    public static void checkArgument(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }
}
