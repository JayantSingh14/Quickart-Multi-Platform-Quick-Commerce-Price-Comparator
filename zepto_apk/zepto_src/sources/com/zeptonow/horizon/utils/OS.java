package com.zeptonow.horizon.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class OS {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OS[] f48272a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f48273b;

    static {
        OS[] osArr = {new OS("ANDROID", 0), new OS("IOS", 1)};
        f48272a = osArr;
        f48273b = EnumEntriesKt.a(osArr);
    }

    public static OS valueOf(String str) {
        return (OS) Enum.valueOf(OS.class, str);
    }

    public static OS[] values() {
        return (OS[]) f48272a.clone();
    }
}
