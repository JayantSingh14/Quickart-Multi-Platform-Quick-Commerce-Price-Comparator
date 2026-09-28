package com.zeptoconsumerapp.modules.base;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class StorageKeys {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ StorageKeys[] f47625b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f47626c;

    /* renamed from: a, reason: collision with root package name */
    public final String f47627a;

    static {
        StorageKeys[] storageKeysArr = {new StorageKeys("AppConfig", 0, "app_config"), new StorageKeys("AppConfigOverride", 1, "app_config_override"), new StorageKeys("ConfigTrace", 2, "configTrace"), new StorageKeys("FeaturesConfig", 3, "FeaturesConfig"), new StorageKeys("PrefetchedHomeLayout", 4, "PREFETCHED_HOME_LAYOUT")};
        f47625b = storageKeysArr;
        f47626c = EnumEntriesKt.a(storageKeysArr);
    }

    public StorageKeys(String str, int i2, String str2) {
        this.f47627a = str2;
    }

    public static StorageKeys valueOf(String str) {
        return (StorageKeys) Enum.valueOf(StorageKeys.class, str);
    }

    public static StorageKeys[] values() {
        return (StorageKeys[]) f47625b.clone();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f47627a;
    }
}
