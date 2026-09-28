package com.google.maps.android.ui;

import android.os.SystemClock;

/* loaded from: classes4.dex */
public class AnimationUtil {

    /* renamed from: com.google.maps.android.ui.AnimationUtil$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            SystemClock.uptimeMillis();
            throw null;
        }
    }

    public interface LatLngInterpolator {

        public static class Linear implements LatLngInterpolator {
        }
    }
}
