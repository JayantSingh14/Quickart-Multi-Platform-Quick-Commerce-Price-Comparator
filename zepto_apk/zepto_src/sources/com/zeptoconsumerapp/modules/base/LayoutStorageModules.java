package com.zeptoconsumerapp.modules.base;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes4.dex */
public final class LayoutStorageModules {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LayoutStorageModules[] f47621a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f47622b;

    static {
        LayoutStorageModules[] layoutStorageModulesArr = {new LayoutStorageModules("ZeptoLayoutManager", 0)};
        f47621a = layoutStorageModulesArr;
        f47622b = EnumEntriesKt.a(layoutStorageModulesArr);
    }

    public static LayoutStorageModules valueOf(String str) {
        return (LayoutStorageModules) Enum.valueOf(LayoutStorageModules.class, str);
    }

    public static LayoutStorageModules[] values() {
        return (LayoutStorageModules[]) f47621a.clone();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "zepto_layout_manager";
    }
}
