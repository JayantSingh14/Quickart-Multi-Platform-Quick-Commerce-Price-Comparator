package com.falcon.notification.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.media.b;
import androidx.core.graphics.ColorUtils;
import com.brentvatne.react.c;
import com.falcon.R;
import com.falcon.falconModule.StorageHelper;
import com.falcon.notification.constants.NotificationConfig;
import com.falcon.notification.constants.NotificationLayoutMode;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.Map;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexKt;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes.dex */
public final class NotificationUtils {

    /* renamed from: a, reason: collision with root package name */
    public static Gson f20488a;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {

        @Metadata
        /* loaded from: classes3.dex */
        public /* synthetic */ class WhenMappings {
            static {
                int[] iArr = new int[NotificationLayoutMode.values().length];
                try {
                    iArr[0] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    NotificationLayoutMode.Companion companion = NotificationLayoutMode.f20462b;
                    iArr[1] = 2;
                } catch (NoSuchFieldError unused2) {
                }
            }
        }

        public static String a(String input) {
            String str;
            int i2 = 2;
            Intrinsics.checkNotNullParameter(input, "originalUrl");
            if (!StringsKt.z(input) && StringsKt.n(input, "ik.imagekit.io", true)) {
                try {
                    String query = Uri.parse(input).getQuery();
                    String input2 = "";
                    if (query == null) {
                        query = "";
                    }
                    if (!StringsKt.n(query, "tr=", true)) {
                        return input + (query.length() > 0 ? "&" : "?") + "tr=f-webp,q-50";
                    }
                    RegexOption regexOption = RegexOption.f53995b;
                    Regex regex = new Regex("([?&])tr=([^&]*)", regexOption);
                    Intrinsics.checkNotNullParameter(input, "input");
                    Matcher matcher = regex.f53992a.matcher(input);
                    Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
                    MatchResult matchResultA = RegexKt.a(matcher, 0, input);
                    if (matchResultA != null && (str = (String) matchResultA.a().get(2)) != null) {
                        input2 = str;
                    }
                    boolean zN = StringsKt.n(input2, "f-webp", true);
                    Regex regex2 = new Regex("q[-_=]?(\\d+)", regexOption);
                    Intrinsics.checkNotNullParameter(input2, "input");
                    boolean zFind = regex2.f53992a.matcher(input2).find();
                    if (!zN || !zFind) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(input2);
                        if (input2.length() > 0 && !StringsKt.r(input2, ",", false)) {
                            sb.append(",");
                        }
                        if (!zN) {
                            sb.append("f-webp,");
                        }
                        if (!zFind) {
                            sb.append("q-50");
                        }
                        String string = sb.toString();
                        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                        return regex.d(input, new c(StringsKt.d0(string, ','), i2));
                    }
                } catch (Exception e2) {
                    b.A("Failed to update transform param: ", e2.getMessage(), "appendTransformIfMissing");
                }
            }
            return input;
        }

        public static int b(Context context, String hexColor) {
            float f2;
            float f3;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(hexColor, "hexColor");
            try {
                if (StringsKt.z(hexColor)) {
                    return (context.getResources().getConfiguration().uiMode & 48) == 32 ? -1 : -16777216;
                }
                int color = Color.parseColor(hexColor);
                float[] fArr = new float[3];
                ThreadLocal threadLocal = ColorUtils.f2804a;
                ColorUtils.b(fArr, Color.red(color), Color.green(color), Color.blue(color));
                if ((context.getResources().getConfiguration().uiMode & 48) == 32) {
                    f2 = fArr[2] + 0.3f;
                    f3 = 1.0f;
                    if (f2 > 1.0f) {
                        f2 = f3;
                    }
                } else {
                    f2 = fArr[2] - 0.2f;
                    f3 = 0.0f;
                    if (f2 < 0.0f) {
                        f2 = f3;
                    }
                }
                fArr[2] = f2;
                return ColorUtils.a(fArr);
            } catch (Exception unused) {
                return (context.getResources().getConfiguration().uiMode & 48) == 32 ? -1 : -16777216;
            }
        }

        public static Gson c() {
            if (NotificationUtils.f20488a == null) {
                NotificationUtils.f20488a = new Gson();
            }
            Gson gson = NotificationUtils.f20488a;
            if (gson != null) {
                return gson;
            }
            Intrinsics.h("gson");
            throw null;
        }

        public static boolean d(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            String stringExtra = intent.getStringExtra("android.intent.extra.INTENT");
            NotificationConfig[] notificationConfigArr = NotificationConfig.f20458a;
            return Intrinsics.b(stringExtra, "launched_from_notification_service");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v6, types: [com.google.gson.Gson] */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v8 */
        /* JADX WARN: Type inference failed for: r4v9, types: [java.lang.Object] */
        public static int e(Context context) {
            Object objC;
            Intrinsics.checkNotNullParameter(context, "context");
            String strA = NotificationLayoutMode.f20463c.a();
            try {
                StorageHelper.f20452a.a();
                try {
                    objC = c().e(StorageHelper.a("experimentData"), new TypeToken<Map<String, ? extends Object>>() { // from class: com.falcon.notification.utils.NotificationUtils$Companion$getExperimentDataByKey$$inlined$get$1
                    }.f45460b);
                } catch (Exception unused) {
                    objC = MapsKt.c();
                }
                Map map = (Map) objC;
                String strE = null;
                ?? r4 = map != null ? map.get("notification_layout") : null;
                if (r4 != null) {
                    strE = r4 instanceof String ? r4 : c().e(c().j(r4), new TypeToken<String>() { // from class: com.falcon.notification.utils.NotificationUtils$Companion$resolveCollapsedImageLayout$$inlined$getExperimentDataByKey$1
                    }.f45460b);
                }
                if (strE != null) {
                    strA = strE;
                }
            } catch (Exception unused2) {
            }
            NotificationLayoutMode.f20462b.getClass();
            int iOrdinal = NotificationLayoutMode.Companion.a(strA).ordinal();
            if (iOrdinal == 0) {
                return R.layout.image_layout_normal;
            }
            if (iOrdinal == 1) {
                return R.layout.image_layout_truncated;
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
