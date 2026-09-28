package com.facebook.yoga;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class YogaBoxSizing {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ YogaBoxSizing[] f20340a = {new YogaBoxSizing("BORDER_BOX", 0), new YogaBoxSizing("CONTENT_BOX", 1)};

    /* JADX INFO: Fake field, exist only in values array */
    YogaBoxSizing EF5;

    public static YogaBoxSizing valueOf(String str) {
        return (YogaBoxSizing) Enum.valueOf(YogaBoxSizing.class, str);
    }

    public static YogaBoxSizing[] values() {
        return (YogaBoxSizing[]) f20340a.clone();
    }
}
