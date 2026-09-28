package com.airbnb.lottie.configurations.reducemotion;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class ReducedMotionMode {

    /* renamed from: a, reason: collision with root package name */
    public static final ReducedMotionMode f14397a;

    /* renamed from: b, reason: collision with root package name */
    public static final ReducedMotionMode f14398b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ ReducedMotionMode[] f14399c;

    static {
        ReducedMotionMode reducedMotionMode = new ReducedMotionMode("STANDARD_MOTION", 0);
        f14397a = reducedMotionMode;
        ReducedMotionMode reducedMotionMode2 = new ReducedMotionMode("REDUCED_MOTION", 1);
        f14398b = reducedMotionMode2;
        f14399c = new ReducedMotionMode[]{reducedMotionMode, reducedMotionMode2};
    }

    public static ReducedMotionMode valueOf(String str) {
        return (ReducedMotionMode) Enum.valueOf(ReducedMotionMode.class, str);
    }

    public static ReducedMotionMode[] values() {
        return (ReducedMotionMode[]) f14399c.clone();
    }
}
