package com.zeptoconsumerapp.apiprefetch.factory;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes4.dex */
public final class ApiPrefetchModule {

    /* renamed from: a, reason: collision with root package name */
    public static final ApiPrefetchModule f47585a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ApiPrefetchModule[] f47586b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f47587c;

    static {
        ApiPrefetchModule apiPrefetchModule = new ApiPrefetchModule("HOME", 0);
        f47585a = apiPrefetchModule;
        ApiPrefetchModule[] apiPrefetchModuleArr = {apiPrefetchModule};
        f47586b = apiPrefetchModuleArr;
        f47587c = EnumEntriesKt.a(apiPrefetchModuleArr);
    }

    public static ApiPrefetchModule valueOf(String str) {
        return (ApiPrefetchModule) Enum.valueOf(ApiPrefetchModule.class, str);
    }

    public static ApiPrefetchModule[] values() {
        return (ApiPrefetchModule[]) f47586b.clone();
    }
}
