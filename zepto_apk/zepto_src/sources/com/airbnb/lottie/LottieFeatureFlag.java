package com.airbnb.lottie;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class LottieFeatureFlag {

    /* renamed from: a, reason: collision with root package name */
    public static final LottieFeatureFlag f14169a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ LottieFeatureFlag[] f14170b;

    static {
        LottieFeatureFlag lottieFeatureFlag = new LottieFeatureFlag("MergePathsApi19", 0);
        f14169a = lottieFeatureFlag;
        f14170b = new LottieFeatureFlag[]{lottieFeatureFlag};
    }

    public static LottieFeatureFlag valueOf(String str) {
        return (LottieFeatureFlag) Enum.valueOf(LottieFeatureFlag.class, str);
    }

    public static LottieFeatureFlag[] values() {
        return (LottieFeatureFlag[]) f14170b.clone();
    }
}
