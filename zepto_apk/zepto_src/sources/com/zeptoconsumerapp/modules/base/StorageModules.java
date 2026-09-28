package com.zeptoconsumerapp.modules.base;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class StorageModules {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StorageModules[] f47628a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f47629b;

    static {
        StorageModules[] storageModulesArr = {new StorageModules("ZeptoAppConfig", 0)};
        f47628a = storageModulesArr;
        f47629b = EnumEntriesKt.a(storageModulesArr);
    }

    public static StorageModules valueOf(String str) {
        return (StorageModules) Enum.valueOf(StorageModules.class, str);
    }

    public static StorageModules[] values() {
        return (StorageModules[]) f47628a.clone();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "zepto_app_config";
    }
}
