package com.facebook.soloader;

import android.os.StrictMode;

/* loaded from: classes3.dex */
public class NoopSoSource extends SoSource {
    @Override // com.facebook.soloader.SoSource
    public final String c() {
        return "NoopSoSource";
    }

    @Override // com.facebook.soloader.SoSource
    public final int d(String str, int i2, StrictMode.ThreadPolicy threadPolicy) {
        return 1;
    }
}
