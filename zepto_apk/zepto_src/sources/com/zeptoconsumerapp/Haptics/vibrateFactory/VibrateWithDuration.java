package com.zeptoconsumerapp.Haptics.vibrateFactory;

import android.os.Vibrator;

/* loaded from: classes4.dex */
public class VibrateWithDuration implements Vibrate {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f47517a;

    public VibrateWithDuration(long[] jArr) {
        this.f47517a = jArr;
    }

    @Override // com.zeptoconsumerapp.Haptics.vibrateFactory.Vibrate
    public final void a(Vibrator vibrator) {
        try {
            if (vibrator.hasVibrator()) {
                vibrator.vibrate(this.f47517a, -1);
            }
        } catch (Exception unused) {
        }
    }
}
