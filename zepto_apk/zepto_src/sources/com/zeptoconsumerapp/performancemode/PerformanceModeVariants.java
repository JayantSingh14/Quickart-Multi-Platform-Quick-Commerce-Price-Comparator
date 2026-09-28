package com.zeptoconsumerapp.performancemode;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class PerformanceModeVariants {

    /* renamed from: c, reason: collision with root package name */
    public static final Companion f47741c;

    /* renamed from: d, reason: collision with root package name */
    public static final PerformanceModeVariants f47742d;

    /* renamed from: e, reason: collision with root package name */
    public static final PerformanceModeVariants f47743e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ PerformanceModeVariants[] f47744f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f47745g;

    /* renamed from: a, reason: collision with root package name */
    public final String f47746a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f47747b;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
    }

    static {
        PerformanceModeVariants performanceModeVariants = new PerformanceModeVariants("NORMAL", 0, "NORMAL", false);
        f47742d = performanceModeVariants;
        PerformanceModeVariants performanceModeVariants2 = new PerformanceModeVariants("LITE", 1, "LITE", false);
        PerformanceModeVariants performanceModeVariants3 = new PerformanceModeVariants("EDGE", 2, "EDGE", true);
        f47743e = performanceModeVariants3;
        PerformanceModeVariants[] performanceModeVariantsArr = {performanceModeVariants, performanceModeVariants2, performanceModeVariants3};
        f47744f = performanceModeVariantsArr;
        f47745g = EnumEntriesKt.a(performanceModeVariantsArr);
        f47741c = new Companion();
    }

    public PerformanceModeVariants(String str, int i2, String str2, boolean z) {
        this.f47746a = str2;
        this.f47747b = z;
    }

    public static PerformanceModeVariants valueOf(String str) {
        return (PerformanceModeVariants) Enum.valueOf(PerformanceModeVariants.class, str);
    }

    public static PerformanceModeVariants[] values() {
        return (PerformanceModeVariants[]) f47744f.clone();
    }
}
