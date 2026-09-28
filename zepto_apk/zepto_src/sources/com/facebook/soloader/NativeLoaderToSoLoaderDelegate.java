package com.facebook.soloader;

import com.facebook.soloader.nativeloader.NativeLoaderDelegate;

/* loaded from: classes.dex */
public class NativeLoaderToSoLoaderDelegate implements NativeLoaderDelegate {
    @Override // com.facebook.soloader.nativeloader.NativeLoaderDelegate
    public final boolean loadLibrary(String str) {
        return SoLoader.n(0, str);
    }
}
