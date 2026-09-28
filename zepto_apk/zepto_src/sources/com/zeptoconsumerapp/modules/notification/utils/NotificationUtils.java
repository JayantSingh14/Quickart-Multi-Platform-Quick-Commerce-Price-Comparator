package com.zeptoconsumerapp.modules.notification.utils;

import android.content.Context;
import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.zeptoconsumerapp.R;
import com.zeptoconsumerapp.Utils;
import com.zeptoconsumerapp.modules.helper.StorageHelper;
import com.zeptoconsumerapp.modules.notification.constants.NotificationLayoutMode;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes.dex */
public final class NotificationUtils {

    @Metadata
    @SourceDebugExtension
    public static final class Companion {

        @Metadata
        /* loaded from: classes4.dex */
        public /* synthetic */ class WhenMappings {
            static {
                int[] iArr = new int[NotificationLayoutMode.values().length];
                try {
                    iArr[0] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    NotificationLayoutMode.Companion companion = NotificationLayoutMode.f47666b;
                    iArr[1] = 2;
                } catch (NoSuchFieldError unused2) {
                }
            }
        }

        public static int a(Context context, String hexColor) {
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

        public static JsonObject b(JsonObject original, JsonObject update) {
            Intrinsics.checkNotNullParameter(original, "original");
            Intrinsics.checkNotNullParameter(update, "update");
            for (Map.Entry entry : update.f45256a.entrySet()) {
                Intrinsics.c(entry);
                String str = (String) entry.getKey();
                JsonElement jsonElement = (JsonElement) entry.getValue();
                if (original.f45256a.containsKey(str)) {
                    JsonElement jsonElementK = original.k(str);
                    jsonElementK.getClass();
                    if (jsonElementK instanceof JsonObject) {
                        jsonElement.getClass();
                        if (jsonElement instanceof JsonObject) {
                            JsonObject jsonObjectF = jsonElementK.f();
                            Intrinsics.checkNotNullExpressionValue(jsonObjectF, "getAsJsonObject(...)");
                            JsonObject jsonObjectF2 = jsonElement.f();
                            Intrinsics.checkNotNullExpressionValue(jsonObjectF2, "getAsJsonObject(...)");
                            b(jsonObjectF, jsonObjectF2);
                            original.j(str, jsonObjectF);
                        }
                    }
                    original.j(str, jsonElement);
                } else {
                    original.j(str, jsonElement);
                }
            }
            return original;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v6, types: [com.google.gson.Gson] */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v8 */
        /* JADX WARN: Type inference failed for: r4v9, types: [java.lang.Object] */
        public static int c(Context context) {
            Object objC;
            Intrinsics.checkNotNullParameter(context, "context");
            String strA = NotificationLayoutMode.f47667c.a();
            try {
                StorageHelper.f47656a.a();
                try {
                    objC = Utils.c().e(StorageHelper.a("experimentData"), new TypeToken<Map<String, ? extends Object>>() { // from class: com.zeptoconsumerapp.modules.notification.utils.NotificationUtils$Companion$getExperimentDataByKey$$inlined$get$1
                    }.f45460b);
                } catch (Exception unused) {
                    objC = MapsKt.c();
                }
                Map map = (Map) objC;
                String strE = null;
                ?? r4 = map != null ? map.get("notification_layout") : null;
                if (r4 != null) {
                    strE = r4 instanceof String ? r4 : Utils.c().e(Utils.c().j(r4), new TypeToken<String>() { // from class: com.zeptoconsumerapp.modules.notification.utils.NotificationUtils$Companion$resolveCollapsedImageLayout$$inlined$getExperimentDataByKey$1
                    }.f45460b);
                }
                if (strE != null) {
                    strA = strE;
                }
            } catch (Exception unused2) {
            }
            NotificationLayoutMode.f47666b.getClass();
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
