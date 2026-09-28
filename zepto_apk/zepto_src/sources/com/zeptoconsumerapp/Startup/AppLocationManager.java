package com.zeptoconsumerapp.Startup;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.internal.ContextScope;

@Metadata
/* loaded from: classes.dex */
public final class AppLocationManager {

    @Metadata
    public static final class Companion {
        public static void a(Context context) {
            AppLocationManager$Companion$fetchUserLocation$1 block = new AppLocationManager$Companion$fetchUserLocation$1(context, null);
            Intrinsics.checkNotNullParameter(block, "block");
            ContextScope contextScope = AppCoroutineManager.f47545b;
            if (contextScope != null) {
                BuildersKt.c(contextScope, null, block, 3);
            }
        }
    }
}
