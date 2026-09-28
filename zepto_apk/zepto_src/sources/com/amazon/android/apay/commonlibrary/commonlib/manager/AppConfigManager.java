package com.amazon.android.apay.commonlibrary.commonlib.manager;

import android.content.Context;
import androidx.media3.common.util.e;
import com.amazon.android.apay.commonlibrary.commonlib.arcus.a;
import com.amazon.android.apay.commonlibrary.commonlib.utils.c;
import com.amazon.android.apay.commonlibrary.interfaces.model.b;
import com.amazonaws.mobileconnectors.remoteconfiguration.Configuration;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata
/* loaded from: classes3.dex */
public final class AppConfigManager {
    public static final void a(AppConfigManager this$0, Context context, String merchantId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(merchantId, "$merchantId");
        try {
            this$0.getClass();
            c.f14881a.getClass();
            c.a(context, merchantId).sync(new a(context));
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public final void createArcusConnection(@NotNull Context context, @NotNull String merchantId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(merchantId, "merchantId");
        Executors.newSingleThreadExecutor().submit(new e(this, context, merchantId, 7));
    }

    @NotNull
    public final JSONObject getConfigData(@NotNull Context context, @Nullable String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        b bVar = new b();
        c.f14881a.getClass();
        Configuration configurationOpenConfiguration = c.a(context, str).openConfiguration();
        JSONObject asJsonObject = configurationOpenConfiguration != null ? configurationOpenConfiguration.getAsJsonObject() : null;
        return asJsonObject != null ? asJsonObject : c.b(context, bVar);
    }
}
