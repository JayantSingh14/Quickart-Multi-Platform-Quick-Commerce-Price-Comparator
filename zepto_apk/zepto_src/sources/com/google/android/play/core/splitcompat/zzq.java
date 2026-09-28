package com.google.android.play.core.splitcompat;

import android.util.Log;

/* loaded from: classes.dex */
final class zzq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SplitCompat f41928a;

    public zzq(SplitCompat splitCompat) {
        this.f41928a = splitCompat;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f41928a.f41900a.b();
        } catch (Exception e2) {
            Log.e("SplitCompat", "Failed to cleanup splitcompat storage", e2);
        }
    }
}
