package com.facebook.yoga;

import android.support.v4.media.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class YogaMeasureMode {

    /* renamed from: a, reason: collision with root package name */
    public static final YogaMeasureMode f20391a;

    /* renamed from: b, reason: collision with root package name */
    public static final YogaMeasureMode f20392b;

    /* renamed from: c, reason: collision with root package name */
    public static final YogaMeasureMode f20393c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ YogaMeasureMode[] f20394d;

    static {
        YogaMeasureMode yogaMeasureMode = new YogaMeasureMode("UNDEFINED", 0);
        f20391a = yogaMeasureMode;
        YogaMeasureMode yogaMeasureMode2 = new YogaMeasureMode("EXACTLY", 1);
        f20392b = yogaMeasureMode2;
        YogaMeasureMode yogaMeasureMode3 = new YogaMeasureMode("AT_MOST", 2);
        f20393c = yogaMeasureMode3;
        f20394d = new YogaMeasureMode[]{yogaMeasureMode, yogaMeasureMode2, yogaMeasureMode3};
    }

    public static YogaMeasureMode a(int i2) {
        if (i2 == 0) {
            return f20391a;
        }
        if (i2 == 1) {
            return f20392b;
        }
        if (i2 == 2) {
            return f20393c;
        }
        throw new IllegalArgumentException(b.f(i2, "Unknown enum value: "));
    }

    public static YogaMeasureMode valueOf(String str) {
        return (YogaMeasureMode) Enum.valueOf(YogaMeasureMode.class, str);
    }

    public static YogaMeasureMode[] values() {
        return (YogaMeasureMode[]) f20394d.clone();
    }
}
