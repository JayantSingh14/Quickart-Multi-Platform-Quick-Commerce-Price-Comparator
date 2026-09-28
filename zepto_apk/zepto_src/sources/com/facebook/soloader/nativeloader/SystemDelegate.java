package com.facebook.soloader.nativeloader;

/* loaded from: classes3.dex */
public class SystemDelegate implements NativeLoaderDelegate {
    @Override // com.facebook.soloader.nativeloader.NativeLoaderDelegate
    public final boolean loadLibrary(String str) {
        System.loadLibrary(str);
        return true;
    }
}
