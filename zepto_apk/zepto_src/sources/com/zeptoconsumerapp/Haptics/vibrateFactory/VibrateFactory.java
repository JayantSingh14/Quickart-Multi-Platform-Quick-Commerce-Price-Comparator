package com.zeptoconsumerapp.Haptics.vibrateFactory;

import java.util.HashMap;

/* loaded from: classes4.dex */
public class VibrateFactory {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f47515a;

    static {
        HashMap map = new HashMap();
        f47515a = map;
        map.put("impactLight", new VibrateWithDuration(new long[]{0, 20}));
        map.put("impactMedium", new VibrateWithDuration(new long[]{0, 40}));
        map.put("impactHeavy", new VibrateWithDuration(new long[]{0, 60}));
        map.put("notificationSuccess", new VibrateWithDuration(new long[]{0, 40, 60, 20}));
        map.put("notificationWarning", new VibrateWithDuration(new long[]{0, 20, 60, 40}));
        map.put("notificationError", new VibrateWithDuration(new long[]{0, 20, 40, 30, 40, 40}));
        map.put("rigid", new VibrateWithDuration(new long[]{0, 30}));
        map.put("soft", new VibrateWithDuration(new long[]{0, 10}));
        map.put("clockTick", new VibrateWithHapticConstant(4));
        map.put("contextClick", new VibrateWithHapticConstant(6));
        map.put("keyboardPress", new VibrateWithHapticConstant(3));
        map.put("keyboardRelease", new VibrateWithHapticConstant(7));
        map.put("keyboardTap", new VibrateWithHapticConstant(3));
        map.put("longPress", new VibrateWithHapticConstant(0));
        map.put("textHandleMove", new VibrateWithHapticConstant(9));
        map.put("virtualKey", new VibrateWithHapticConstant(1));
        map.put("virtualKeyRelease", new VibrateWithHapticConstant(8));
        map.put("effectClick", new VibrateWithCreatePredefined(0));
        map.put("effectDoubleClick", new VibrateWithCreatePredefined(1));
        map.put("effectHeavyClick", new VibrateWithCreatePredefined(5));
        map.put("effectTick", new VibrateWithCreatePredefined(2));
    }
}
