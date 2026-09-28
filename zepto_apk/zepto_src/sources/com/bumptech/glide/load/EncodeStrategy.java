package com.bumptech.glide.load;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class EncodeStrategy {

    /* renamed from: a, reason: collision with root package name */
    public static final EncodeStrategy f15798a;

    /* renamed from: b, reason: collision with root package name */
    public static final EncodeStrategy f15799b;

    /* renamed from: c, reason: collision with root package name */
    public static final EncodeStrategy f15800c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EncodeStrategy[] f15801d;

    static {
        EncodeStrategy encodeStrategy = new EncodeStrategy("SOURCE", 0);
        f15798a = encodeStrategy;
        EncodeStrategy encodeStrategy2 = new EncodeStrategy("TRANSFORMED", 1);
        f15799b = encodeStrategy2;
        EncodeStrategy encodeStrategy3 = new EncodeStrategy("NONE", 2);
        f15800c = encodeStrategy3;
        f15801d = new EncodeStrategy[]{encodeStrategy, encodeStrategy2, encodeStrategy3};
    }

    public static EncodeStrategy valueOf(String str) {
        return (EncodeStrategy) Enum.valueOf(EncodeStrategy.class, str);
    }

    public static EncodeStrategy[] values() {
        return (EncodeStrategy[]) f15801d.clone();
    }
}
