package com.scottyab.rootbeer;

import com.scottyab.rootbeer.util.QLog;

/* loaded from: classes.dex */
public class RootBeerNative {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f46707a;

    static {
        try {
            System.loadLibrary("tool-checker");
            f46707a = true;
        } catch (UnsatisfiedLinkError e2) {
            QLog.a(e2);
        }
    }

    public native int checkForRoot(Object[] objArr);

    public native int setLogDebugMessages(boolean z);
}
