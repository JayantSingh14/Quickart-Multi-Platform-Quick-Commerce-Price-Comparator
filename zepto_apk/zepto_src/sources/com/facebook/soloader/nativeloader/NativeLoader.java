package com.facebook.soloader.nativeloader;

/* loaded from: classes.dex */
public class NativeLoader {

    /* renamed from: a, reason: collision with root package name */
    public static NativeLoaderDelegate f20308a;

    public static void a(NativeLoaderDelegate nativeLoaderDelegate) {
        boolean z;
        synchronized (NativeLoader.class) {
            z = f20308a != null;
        }
        if (z) {
            return;
        }
        synchronized (NativeLoader.class) {
            try {
                if (f20308a != null) {
                    throw new IllegalStateException("Cannot re-initialize NativeLoader.");
                }
                f20308a = nativeLoaderDelegate;
            } finally {
            }
        }
    }

    public static boolean b(String str) {
        NativeLoaderDelegate nativeLoaderDelegate;
        synchronized (NativeLoader.class) {
            nativeLoaderDelegate = f20308a;
            if (nativeLoaderDelegate == null) {
                throw new IllegalStateException("NativeLoader has not been initialized.  To use standard native library loading, call NativeLoader.init(new SystemDelegate()).");
            }
        }
        return nativeLoaderDelegate.loadLibrary(str);
    }
}
