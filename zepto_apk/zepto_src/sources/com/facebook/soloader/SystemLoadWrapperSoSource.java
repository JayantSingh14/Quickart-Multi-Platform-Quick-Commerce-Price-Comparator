package com.facebook.soloader;

import android.os.StrictMode;
import android.util.Log;

/* loaded from: classes3.dex */
public class SystemLoadWrapperSoSource extends SoSource {
    @Override // com.facebook.soloader.SoSource
    public final String c() {
        return "SystemLoadWrapperSoSource";
    }

    @Override // com.facebook.soloader.SoSource
    public final int d(String str, int i2, StrictMode.ThreadPolicy threadPolicy) {
        try {
            System.loadLibrary(str.substring(3, str.length() - 3));
            return 1;
        } catch (Exception e2) {
            Log.e("SoLoader", "Error loading library: " + str, e2);
            return 0;
        }
    }

    @Override // com.facebook.soloader.SoSource
    public final String toString() {
        return "SystemLoadWrapperSoSource[" + SysUtil.getClassLoaderLdLoadLibrary() + "]";
    }
}
