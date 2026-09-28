package com.zeptoconsumerapp.modules.base;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class ExperimentKeys {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ExperimentKeys[] f47618b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f47619c;

    /* renamed from: a, reason: collision with root package name */
    public final String f47620a;

    static {
        ExperimentKeys[] experimentKeysArr = {new ExperimentKeys("AlternateDns", 0, "alternate_dns"), new ExperimentKeys("EdgePerformanceMode", 1, "edge_performance_mode")};
        f47618b = experimentKeysArr;
        f47619c = EnumEntriesKt.a(experimentKeysArr);
    }

    public ExperimentKeys(String str, int i2, String str2) {
        this.f47620a = str2;
    }

    public static ExperimentKeys valueOf(String str) {
        return (ExperimentKeys) Enum.valueOf(ExperimentKeys.class, str);
    }

    public static ExperimentKeys[] values() {
        return (ExperimentKeys[]) f47618b.clone();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f47620a;
    }
}
