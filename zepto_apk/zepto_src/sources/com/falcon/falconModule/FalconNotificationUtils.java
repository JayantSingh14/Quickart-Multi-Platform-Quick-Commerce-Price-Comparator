package com.falcon.falconModule;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.RemoteViews;
import com.falcon.R;
import com.falcon.notification.utils.NotificationUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class FalconNotificationUtils {

    /* renamed from: a, reason: collision with root package name */
    public static Gson f20447a;

    public static Gson a() {
        if (f20447a == null) {
            f20447a = new Gson();
        }
        Gson gson = f20447a;
        if (gson != null) {
            return gson;
        }
        Intrinsics.h("gson");
        throw null;
    }

    public static Integer b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter("ic_thumbnail_icon", CLConstants.FIELD_PAY_INFO_NAME);
        Intrinsics.checkNotNullParameter("drawable", "type");
        int identifier = context.getResources().getIdentifier("ic_thumbnail_icon", "drawable", context.getPackageName());
        if (identifier != 0) {
            return Integer.valueOf(identifier);
        }
        Log.w("FalconNotificationUtils", "Resource not found: drawable/ic_thumbnail_icon. Please define it in the app.");
        return null;
    }

    public static Bitmap c(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            String strA = NotificationUtils.Companion.a(url);
            if (StringsKt.z(strA)) {
                return null;
            }
            return BitmapFactory.decodeStream(new URL(strA).openConnection().getInputStream());
        } catch (IOException e2) {
            Log.e("FalconNotificationUtils", "Error loading bitmap from URL: " + e2.getMessage());
            return null;
        }
    }

    public static JsonObject d(JsonObject original, JsonObject update) {
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
                        d(jsonObjectF, jsonObjectF2);
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

    public static void e(RemoteViews remoteViews, Bitmap bitmap, String str) {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        int i2 = R.id.thumbnailImage64;
        int i3 = R.id.thumbnailImage48;
        int i4 = R.id.thumbnailImage40;
        remoteViews.setViewVisibility(i2, 8);
        remoteViews.setViewVisibility(i3, 8);
        remoteViews.setViewVisibility(i4, 8);
        if (bitmap == null) {
            Log.d("FalconNotificationUtils", "populateThumbnailViews: No thumbnail bitmap found.");
            return;
        }
        if (Intrinsics.b(str, "large")) {
            remoteViews.setImageViewBitmap(i2, bitmap);
            remoteViews.setViewVisibility(i2, 0);
        } else if (Intrinsics.b(str, "small")) {
            remoteViews.setImageViewBitmap(i4, bitmap);
            remoteViews.setViewVisibility(i4, 0);
        } else {
            remoteViews.setImageViewBitmap(i3, bitmap);
            remoteViews.setViewVisibility(i3, 0);
        }
        Log.d("FalconNotificationUtils", "populateThumbnailViews: Applied circular thumbnail (size=" + str + ").");
    }
}
