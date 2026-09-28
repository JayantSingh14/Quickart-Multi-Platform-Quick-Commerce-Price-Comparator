package com.google.android.gms.internal.ads;

import android.os.Looper;

/* loaded from: classes4.dex */
final class zzcff implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        Looper.myLooper().quit();
    }
}
