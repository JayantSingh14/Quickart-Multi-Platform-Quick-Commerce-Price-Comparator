package com.facebook.react.bridge;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class MemoryPressure {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MemoryPressure[] $VALUES;
    public static final MemoryPressure UI_HIDDEN = new MemoryPressure("UI_HIDDEN", 0);
    public static final MemoryPressure MODERATE = new MemoryPressure("MODERATE", 1);
    public static final MemoryPressure CRITICAL = new MemoryPressure("CRITICAL", 2);

    private static final /* synthetic */ MemoryPressure[] $values() {
        return new MemoryPressure[]{UI_HIDDEN, MODERATE, CRITICAL};
    }

    static {
        MemoryPressure[] memoryPressureArr$values = $values();
        $VALUES = memoryPressureArr$values;
        $ENTRIES = EnumEntriesKt.a(memoryPressureArr$values);
    }

    private MemoryPressure(String str, int i2) {
    }

    @NotNull
    public static EnumEntries<MemoryPressure> getEntries() {
        return $ENTRIES;
    }

    public static MemoryPressure valueOf(String str) {
        return (MemoryPressure) Enum.valueOf(MemoryPressure.class, str);
    }

    public static MemoryPressure[] values() {
        return (MemoryPressure[]) $VALUES.clone();
    }
}
