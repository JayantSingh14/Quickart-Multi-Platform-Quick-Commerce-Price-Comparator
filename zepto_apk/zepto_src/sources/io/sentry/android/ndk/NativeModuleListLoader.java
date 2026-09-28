package io.sentry.android.ndk;

import io.sentry.protocol.DebugImage;

/* loaded from: classes.dex */
final class NativeModuleListLoader {
    public static native void nativeClearModuleList();

    public static native DebugImage[] nativeLoadModuleList();
}
