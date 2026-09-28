package com.zeptoconsumerapp.Haptics;

import android.media.AudioManager;
import android.os.Vibrator;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.zeptoconsumerapp.Haptics.vibrateFactory.Vibrate;
import com.zeptoconsumerapp.Haptics.vibrateFactory.VibrateFactory;
import com.zeptoconsumerapp.Utils;

/* loaded from: classes4.dex */
public class RNReactNativeHapticFeedbackModuleImpl {
    public static void a(ReactApplicationContext reactApplicationContext, ReadableMap readableMap, String str) {
        try {
            boolean z = readableMap.getBoolean("ignoreAndroidSystemSettings");
            boolean z2 = false;
            try {
                Vibrator vibrator = (Vibrator) reactApplicationContext.getSystemService("vibrator");
                AudioManager audioManager = (AudioManager) reactApplicationContext.getSystemService("audio");
                boolean z3 = vibrator != null && vibrator.hasVibrator();
                boolean z4 = audioManager.getRingerMode() != 0;
                boolean z5 = audioManager.getRingerMode() == 1;
                if (z3 && (z4 || z5)) {
                    z2 = true;
                }
            } catch (Exception e2) {
                Utils.i(e2);
            }
            if (z || z2) {
                Vibrator vibrator2 = (Vibrator) reactApplicationContext.getSystemService("vibrator");
                Vibrate vibrate = (Vibrate) VibrateFactory.f47515a.get(str);
                if (vibrator2 != null && vibrate != null) {
                    vibrate.a(vibrator2);
                }
            }
        } catch (Exception e3) {
            Utils.i(e3);
        }
    }
}
