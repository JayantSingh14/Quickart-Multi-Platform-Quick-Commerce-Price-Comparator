package com.zeptoconsumerapp.Haptics.vibrateFactory;

import android.os.Vibrator;

/* loaded from: classes4.dex */
public class VibrateWithHapticConstant implements Vibrate {

    /* renamed from: a, reason: collision with root package name */
    public final int f47518a;

    public VibrateWithHapticConstant(int i2) {
        this.f47518a = i2;
    }

    @Override // com.zeptoconsumerapp.Haptics.vibrateFactory.Vibrate
    public final void a(Vibrator vibrator) {
        try {
            if (vibrator.hasVibrator()) {
                vibrator.vibrate(this.f47518a);
            }
        } catch (Exception unused) {
        }
    }
}
