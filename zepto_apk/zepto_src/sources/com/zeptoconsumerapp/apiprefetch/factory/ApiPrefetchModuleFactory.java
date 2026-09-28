package com.zeptoconsumerapp.apiprefetch.factory;

import com.zeptoconsumerapp.Startup.AppSessionManager;
import com.zeptoconsumerapp.apiprefetch.homepage.HomePageOptions;
import com.zeptoconsumerapp.apiprefetch.homepage.HomepageApiPrefetch;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class ApiPrefetchModuleFactory {

    @Metadata
    public /* synthetic */ class WhenMappings {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f47588a;

        static {
            int[] iArr = new int[ApiPrefetchModule.values().length];
            try {
                ApiPrefetchModule apiPrefetchModule = ApiPrefetchModule.f47585a;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f47588a = iArr;
        }
    }

    public static String a() {
        ApiPrefetchModule module = ApiPrefetchModule.f47585a;
        Intrinsics.checkNotNullParameter(module, "module");
        return "HOME_".concat(AppSessionManager.f47556a.a());
    }

    public static HomepageApiPrefetch b(HomePageOptions options) {
        ApiPrefetchModule module = ApiPrefetchModule.f47585a;
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(options, "options");
        if (WhenMappings.f47588a[0] != 1) {
            throw new NoWhenBranchMatchedException();
        }
        Intrinsics.checkNotNullParameter(options, "options");
        return new HomepageApiPrefetch(options);
    }
}
