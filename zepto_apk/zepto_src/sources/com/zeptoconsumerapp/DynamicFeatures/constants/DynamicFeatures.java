package com.zeptoconsumerapp.DynamicFeatures.constants;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes4.dex */
public final class DynamicFeatures {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DynamicFeatures[] f47410a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f47411b;

    static {
        DynamicFeatures[] dynamicFeaturesArr = {new DynamicFeatures("MODULE_NAME", 0), new DynamicFeatures("MODULE_CLASS", 1), new DynamicFeatures("PENDING", 2), new DynamicFeatures("DOWNLOADING", 3), new DynamicFeatures("INSTALLING", 4), new DynamicFeatures("INSTALLED", 5), new DynamicFeatures("FAILED", 6), new DynamicFeatures("CANCELED", 7), new DynamicFeatures("REQUIRES_USER_CONFIRMATION", 8), new DynamicFeatures("STATUS_ALREADY_INSTALLED", 9), new DynamicFeatures("DOWNLOADED", 10), new DynamicFeatures("INSTALL_FAILED", 11)};
        f47410a = dynamicFeaturesArr;
        f47411b = EnumEntriesKt.a(dynamicFeaturesArr);
    }

    public static DynamicFeatures valueOf(String str) {
        return (DynamicFeatures) Enum.valueOf(DynamicFeatures.class, str);
    }

    public static DynamicFeatures[] values() {
        return (DynamicFeatures[]) f47410a.clone();
    }
}
