package com.facebook.yoga;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class LayoutPassReason {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LayoutPassReason[] f20328a = {new LayoutPassReason("INITIAL", 0), new LayoutPassReason("ABS_LAYOUT", 1), new LayoutPassReason("STRETCH", 2), new LayoutPassReason("MULTILINE_STRETCH", 3), new LayoutPassReason("FLEX_LAYOUT", 4), new LayoutPassReason("MEASURE", 5), new LayoutPassReason("ABS_MEASURE", 6), new LayoutPassReason("FLEX_MEASURE", 7)};

    /* JADX INFO: Fake field, exist only in values array */
    LayoutPassReason EF5;

    public static LayoutPassReason valueOf(String str) {
        return (LayoutPassReason) Enum.valueOf(LayoutPassReason.class, str);
    }

    public static LayoutPassReason[] values() {
        return (LayoutPassReason[]) f20328a.clone();
    }
}
