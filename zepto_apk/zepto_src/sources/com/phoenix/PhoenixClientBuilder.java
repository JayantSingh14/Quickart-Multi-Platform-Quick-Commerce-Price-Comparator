package com.phoenix;

import com.zeptoconsumerapp.Startup.AppPhoenixManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

@Metadata
/* loaded from: classes4.dex */
public final class PhoenixClientBuilder {

    @Metadata
    public static final class Companion {
        public static OkHttpClient a() {
            AppPhoenixManager appPhoenixManager = Phoenix.f46112b;
            if (appPhoenixManager == null) {
                Intrinsics.h("delegate");
                throw null;
            }
            if (appPhoenixManager.b() == null) {
                return new OkHttpClient();
            }
            AppPhoenixManager appPhoenixManager2 = Phoenix.f46112b;
            if (appPhoenixManager2 != null) {
                return appPhoenixManager2.b();
            }
            Intrinsics.h("delegate");
            throw null;
        }
    }
}
