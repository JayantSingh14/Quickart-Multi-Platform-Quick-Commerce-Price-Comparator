package com.facebook.soloader;

import android.os.StrictMode;

/* loaded from: classes.dex */
public abstract class SoSource {
    public abstract String c();

    public abstract int d(String str, int i2, StrictMode.ThreadPolicy threadPolicy);

    public void e(int i2) {
    }

    public String toString() {
        return c();
    }
}
