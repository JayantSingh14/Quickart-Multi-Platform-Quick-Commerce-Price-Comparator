package com.facebook.react.modules.i18nmanager;

import android.content.Context;
import android.text.TextUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes.dex */
public final class I18nUtil {

    @Metadata
    public static final class Companion {
    }

    public static boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getSharedPreferences("com.facebook.react.modules.i18nmanager.I18nUtil", 0).getBoolean("RCTI18nUtil_makeRTLFlipLeftAndRightStyles", true);
    }

    public static boolean b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (context.getApplicationInfo().flags & 4194304) != 0 && (context.getSharedPreferences("com.facebook.react.modules.i18nmanager.I18nUtil", 0).getBoolean("RCTI18nUtil_forceRTL", false) || StringsKt.t(System.getProperty("FORCE_RTL_FOR_TESTING", "false"), "true", true) || (context.getSharedPreferences("com.facebook.react.modules.i18nmanager.I18nUtil", 0).getBoolean("RCTI18nUtil_allowRTL", true) && TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1));
    }
}
