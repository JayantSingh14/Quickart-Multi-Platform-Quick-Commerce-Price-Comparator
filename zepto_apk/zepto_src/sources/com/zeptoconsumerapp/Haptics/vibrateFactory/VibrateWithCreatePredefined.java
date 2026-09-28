package com.zeptoconsumerapp.Haptics.vibrateFactory;

import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

/* loaded from: classes4.dex */
public class VibrateWithCreatePredefined implements Vibrate {

    /* renamed from: a, reason: collision with root package name */
    public final int f47516a;

    public VibrateWithCreatePredefined(int i2) {
        this.f47516a = i2;
    }

    @Override // com.zeptoconsumerapp.Haptics.vibrateFactory.Vibrate
    public final void a(Vibrator vibrator) {
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        try {
            if (vibrator.hasVibrator()) {
                vibrator.vibrate(VibrationEffect.createPredefined(this.f47516a));
            }
        } catch (Exception unused) {
        }
    }
}
