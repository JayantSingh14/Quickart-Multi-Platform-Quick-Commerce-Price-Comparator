package com.bumptech.glide.load;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class PreferredColorSpace {

    /* renamed from: a, reason: collision with root package name */
    public static final PreferredColorSpace f15818a;

    /* renamed from: b, reason: collision with root package name */
    public static final PreferredColorSpace f15819b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ PreferredColorSpace[] f15820c;

    static {
        PreferredColorSpace preferredColorSpace = new PreferredColorSpace("SRGB", 0);
        f15818a = preferredColorSpace;
        PreferredColorSpace preferredColorSpace2 = new PreferredColorSpace("DISPLAY_P3", 1);
        f15819b = preferredColorSpace2;
        f15820c = new PreferredColorSpace[]{preferredColorSpace, preferredColorSpace2};
    }

    public static PreferredColorSpace valueOf(String str) {
        return (PreferredColorSpace) Enum.valueOf(PreferredColorSpace.class, str);
    }

    public static PreferredColorSpace[] values() {
        return (PreferredColorSpace[]) f15820c.clone();
    }
}
