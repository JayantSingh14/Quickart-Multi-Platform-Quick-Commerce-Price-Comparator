package com.zeptoconsumerapp.modules.base;

import com.tencent.mmkv.MMKV;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class StorageManager {
    public static MMKV a() throws RuntimeException {
        if (MMKV.getRootDir() == null) {
            MMKV.initialize(ContextProvider.f47615b.a().a());
        }
        StorageModules[] storageModulesArr = StorageModules.f47628a;
        MMKV mmkvMmkvWithID = MMKV.mmkvWithID("zepto_app_config");
        Intrinsics.checkNotNullExpressionValue(mmkvMmkvWithID, "mmkvWithID(...)");
        return mmkvMmkvWithID;
    }
}
