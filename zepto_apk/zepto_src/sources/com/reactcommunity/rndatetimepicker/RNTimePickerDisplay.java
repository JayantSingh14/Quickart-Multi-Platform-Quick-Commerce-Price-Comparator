package com.reactcommunity.rndatetimepicker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class RNTimePickerDisplay {

    /* renamed from: a, reason: collision with root package name */
    public static final RNTimePickerDisplay f46154a;

    /* renamed from: b, reason: collision with root package name */
    public static final RNTimePickerDisplay f46155b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ RNTimePickerDisplay[] f46156c;

    static {
        RNTimePickerDisplay rNTimePickerDisplay = new RNTimePickerDisplay("SPINNER", 0);
        f46154a = rNTimePickerDisplay;
        RNTimePickerDisplay rNTimePickerDisplay2 = new RNTimePickerDisplay("DEFAULT", 1);
        f46155b = rNTimePickerDisplay2;
        f46156c = new RNTimePickerDisplay[]{rNTimePickerDisplay, rNTimePickerDisplay2};
    }

    public static RNTimePickerDisplay valueOf(String str) {
        return (RNTimePickerDisplay) Enum.valueOf(RNTimePickerDisplay.class, str);
    }

    public static RNTimePickerDisplay[] values() {
        return (RNTimePickerDisplay[]) f46156c.clone();
    }
}
