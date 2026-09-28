package com.th3rdwave.safeareacontext;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class SafeAreaViewMode {

    /* renamed from: a, reason: collision with root package name */
    public static final SafeAreaViewMode f47186a;

    /* renamed from: b, reason: collision with root package name */
    public static final SafeAreaViewMode f47187b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ SafeAreaViewMode[] f47188c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f47189d;

    static {
        SafeAreaViewMode safeAreaViewMode = new SafeAreaViewMode("PADDING", 0);
        f47186a = safeAreaViewMode;
        SafeAreaViewMode safeAreaViewMode2 = new SafeAreaViewMode("MARGIN", 1);
        f47187b = safeAreaViewMode2;
        SafeAreaViewMode[] safeAreaViewModeArr = {safeAreaViewMode, safeAreaViewMode2};
        f47188c = safeAreaViewModeArr;
        f47189d = EnumEntriesKt.a(safeAreaViewModeArr);
    }

    public static SafeAreaViewMode valueOf(String str) {
        return (SafeAreaViewMode) Enum.valueOf(SafeAreaViewMode.class, str);
    }

    public static SafeAreaViewMode[] values() {
        return (SafeAreaViewMode[]) f47188c.clone();
    }
}
