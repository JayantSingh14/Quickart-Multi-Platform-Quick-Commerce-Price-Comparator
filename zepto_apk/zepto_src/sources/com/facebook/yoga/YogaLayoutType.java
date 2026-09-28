package com.facebook.yoga;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class YogaLayoutType {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ YogaLayoutType[] f20383a = {new YogaLayoutType("LAYOUT", 0), new YogaLayoutType("MEASURE", 1), new YogaLayoutType("CACHED_LAYOUT", 2), new YogaLayoutType("CACHED_MEASURE", 3)};

    /* JADX INFO: Fake field, exist only in values array */
    YogaLayoutType EF5;

    public static YogaLayoutType valueOf(String str) {
        return (YogaLayoutType) Enum.valueOf(YogaLayoutType.class, str);
    }

    public static YogaLayoutType[] values() {
        return (YogaLayoutType[]) f20383a.clone();
    }
}
