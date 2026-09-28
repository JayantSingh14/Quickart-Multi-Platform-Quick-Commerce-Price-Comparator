package com.facebook.yoga;

import android.support.v4.media.b;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import com.facebook.yoga.annotations.DoNotStrip;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@DoNotStrip
/* loaded from: classes3.dex */
public final class YogaLogLevel {

    /* renamed from: a, reason: collision with root package name */
    public static final YogaLogLevel f20384a;

    /* renamed from: b, reason: collision with root package name */
    public static final YogaLogLevel f20385b;

    /* renamed from: c, reason: collision with root package name */
    public static final YogaLogLevel f20386c;

    /* renamed from: d, reason: collision with root package name */
    public static final YogaLogLevel f20387d;

    /* renamed from: e, reason: collision with root package name */
    public static final YogaLogLevel f20388e;

    /* renamed from: f, reason: collision with root package name */
    public static final YogaLogLevel f20389f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ YogaLogLevel[] f20390g;

    static {
        YogaLogLevel yogaLogLevel = new YogaLogLevel(MerchantConstants.ERROR, 0);
        f20384a = yogaLogLevel;
        YogaLogLevel yogaLogLevel2 = new YogaLogLevel("WARN", 1);
        f20385b = yogaLogLevel2;
        YogaLogLevel yogaLogLevel3 = new YogaLogLevel("INFO", 2);
        f20386c = yogaLogLevel3;
        YogaLogLevel yogaLogLevel4 = new YogaLogLevel("DEBUG", 3);
        f20387d = yogaLogLevel4;
        YogaLogLevel yogaLogLevel5 = new YogaLogLevel("VERBOSE", 4);
        f20388e = yogaLogLevel5;
        YogaLogLevel yogaLogLevel6 = new YogaLogLevel("FATAL", 5);
        f20389f = yogaLogLevel6;
        f20390g = new YogaLogLevel[]{yogaLogLevel, yogaLogLevel2, yogaLogLevel3, yogaLogLevel4, yogaLogLevel5, yogaLogLevel6};
    }

    @DoNotStrip
    public static YogaLogLevel fromInt(int i2) {
        if (i2 == 0) {
            return f20384a;
        }
        if (i2 == 1) {
            return f20385b;
        }
        if (i2 == 2) {
            return f20386c;
        }
        if (i2 == 3) {
            return f20387d;
        }
        if (i2 == 4) {
            return f20388e;
        }
        if (i2 == 5) {
            return f20389f;
        }
        throw new IllegalArgumentException(b.f(i2, "Unknown enum value: "));
    }

    public static YogaLogLevel valueOf(String str) {
        return (YogaLogLevel) Enum.valueOf(YogaLogLevel.class, str);
    }

    public static YogaLogLevel[] values() {
        return (YogaLogLevel[]) f20390g.clone();
    }
}
