package com.facebook.yoga;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class YogaDimension {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ YogaDimension[] f20342a = {new YogaDimension("WIDTH", 0), new YogaDimension("HEIGHT", 1)};

    /* JADX INFO: Fake field, exist only in values array */
    YogaDimension EF5;

    public static YogaDimension valueOf(String str) {
        return (YogaDimension) Enum.valueOf(YogaDimension.class, str);
    }

    public static YogaDimension[] values() {
        return (YogaDimension[]) f20342a.clone();
    }
}
