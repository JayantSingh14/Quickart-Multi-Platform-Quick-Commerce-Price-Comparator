package com.phoenix;

import android.content.Context;
import android.content.SharedPreferences;
import com.phoenix.Phoenix;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata
/* loaded from: classes.dex */
public final class PhoenixSharedPreference {

    @Metadata
    public static final class Companion {
        public static JSONObject a(String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            String string = b(Phoenix.Companion.b()).getString(key, null);
            if (string == null) {
                return null;
            }
            return new JSONObject(string);
        }

        public static SharedPreferences b(Context context) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("phoenix_shared_preference", 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
            return sharedPreferences;
        }

        public static void c(String key, JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(key, "key");
            SharedPreferences.Editor editorEdit = b(Phoenix.Companion.b()).edit();
            Intrinsics.checkNotNullExpressionValue(editorEdit, "edit(...)");
            if (jSONObject == null) {
                editorEdit.putString(key, null);
            } else {
                editorEdit.putString(key, jSONObject.toString());
            }
            editorEdit.apply();
        }
    }
}
