package com.airbnb.lottie.model.content;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class GradientType {

    /* renamed from: a, reason: collision with root package name */
    public static final GradientType f14530a;

    /* renamed from: b, reason: collision with root package name */
    public static final GradientType f14531b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ GradientType[] f14532c;

    static {
        GradientType gradientType = new GradientType("LINEAR", 0);
        f14530a = gradientType;
        GradientType gradientType2 = new GradientType("RADIAL", 1);
        f14531b = gradientType2;
        f14532c = new GradientType[]{gradientType, gradientType2};
    }

    public static GradientType valueOf(String str) {
        return (GradientType) Enum.valueOf(GradientType.class, str);
    }

    public static GradientType[] values() {
        return (GradientType[]) f14532c.clone();
    }
}
