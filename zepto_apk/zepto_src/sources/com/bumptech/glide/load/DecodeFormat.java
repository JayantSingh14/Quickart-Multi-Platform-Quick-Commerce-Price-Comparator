package com.bumptech.glide.load;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class DecodeFormat {

    /* renamed from: a, reason: collision with root package name */
    public static final DecodeFormat f15794a;

    /* renamed from: b, reason: collision with root package name */
    public static final DecodeFormat f15795b;

    /* renamed from: c, reason: collision with root package name */
    public static final DecodeFormat f15796c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ DecodeFormat[] f15797d;

    static {
        DecodeFormat decodeFormat = new DecodeFormat("PREFER_ARGB_8888", 0);
        f15794a = decodeFormat;
        DecodeFormat decodeFormat2 = new DecodeFormat("PREFER_RGB_565", 1);
        f15795b = decodeFormat2;
        f15797d = new DecodeFormat[]{decodeFormat, decodeFormat2};
        f15796c = decodeFormat;
    }

    public static DecodeFormat valueOf(String str) {
        return (DecodeFormat) Enum.valueOf(DecodeFormat.class, str);
    }

    public static DecodeFormat[] values() {
        return (DecodeFormat[]) f15797d.clone();
    }
}
