package com.facebook.common.memory;

import com.facebook.infer.annotation.Nullsafe;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Nullsafe
/* loaded from: classes3.dex */
public final class MemoryTrimType {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MemoryTrimType[] f17094a = {new MemoryTrimType("OnCloseToDalvikHeapLimit", 0), new MemoryTrimType("OnSystemMemoryCriticallyLowWhileAppInForeground", 1), new MemoryTrimType("OnSystemLowMemoryWhileAppInForeground", 2), new MemoryTrimType("OnSystemLowMemoryWhileAppInBackgroundLowSeverity", 3), new MemoryTrimType("OnSystemModerateMemory", 4), new MemoryTrimType("OnAppBackgrounded", 5), new MemoryTrimType("OnJavaMemoryRed", 6), new MemoryTrimType("OnJavaMemoryYellow", 7), new MemoryTrimType("OnSystemMemoryRed", 8), new MemoryTrimType("OnSystemMemoryYellow", 9)};

    /* JADX INFO: Fake field, exist only in values array */
    MemoryTrimType EF5;

    public static MemoryTrimType valueOf(String str) {
        return (MemoryTrimType) Enum.valueOf(MemoryTrimType.class, str);
    }

    public static MemoryTrimType[] values() {
        return (MemoryTrimType[]) f17094a.clone();
    }
}
