package com.zeptoconsumerapp.modules.configservice;

import com.zeptoconsumerapp.Startup.AppCoroutineManager;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class ConfigManager {
    public static void a() {
        AppCoroutineManager.a(new ConfigService$fetchAndStoreConfig$1(new ConfigService(), null));
    }
}
