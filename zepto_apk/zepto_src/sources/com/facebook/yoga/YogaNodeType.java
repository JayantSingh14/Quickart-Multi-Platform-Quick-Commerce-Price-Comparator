package com.facebook.yoga;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class YogaNodeType {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ YogaNodeType[] f20404a = {new YogaNodeType("DEFAULT", 0), new YogaNodeType("TEXT", 1)};

    /* JADX INFO: Fake field, exist only in values array */
    YogaNodeType EF5;

    public static YogaNodeType valueOf(String str) {
        return (YogaNodeType) Enum.valueOf(YogaNodeType.class, str);
    }

    public static YogaNodeType[] values() {
        return (YogaNodeType[]) f20404a.clone();
    }
}
