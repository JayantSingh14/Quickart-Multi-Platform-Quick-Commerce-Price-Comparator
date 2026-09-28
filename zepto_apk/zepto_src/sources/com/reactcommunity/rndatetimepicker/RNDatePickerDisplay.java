package com.reactcommunity.rndatetimepicker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class RNDatePickerDisplay {

    /* renamed from: a, reason: collision with root package name */
    public static final RNDatePickerDisplay f46151a;

    /* renamed from: b, reason: collision with root package name */
    public static final RNDatePickerDisplay f46152b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ RNDatePickerDisplay[] f46153c;

    static {
        RNDatePickerDisplay rNDatePickerDisplay = new RNDatePickerDisplay("SPINNER", 0);
        f46151a = rNDatePickerDisplay;
        RNDatePickerDisplay rNDatePickerDisplay2 = new RNDatePickerDisplay("DEFAULT", 1);
        f46152b = rNDatePickerDisplay2;
        f46153c = new RNDatePickerDisplay[]{rNDatePickerDisplay, rNDatePickerDisplay2};
    }

    public static RNDatePickerDisplay valueOf(String str) {
        return (RNDatePickerDisplay) Enum.valueOf(RNDatePickerDisplay.class, str);
    }

    public static RNDatePickerDisplay[] values() {
        return (RNDatePickerDisplay[]) f46153c.clone();
    }
}
