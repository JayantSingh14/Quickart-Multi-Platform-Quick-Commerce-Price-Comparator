package com.phoenix;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.phoenix.FileUtil;
import com.phoenix.PhoenixAnalyticsLogger;
import com.phoenix.PhoenixLogger;
import com.phoenix.PhoenixSharedPreference;
import com.phoenix.PhoenixUtils;
import com.zeptoconsumerapp.Startup.AppPhoenixManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

@Metadata
/* loaded from: classes.dex */
public final class Phoenix {

    /* renamed from: a, reason: collision with root package name */
    public static String f46111a;

    /* renamed from: b, reason: collision with root package name */
    public static AppPhoenixManager f46112b;

    /* renamed from: c, reason: collision with root package name */
    public static Gson f46113c;

    @Metadata
    public static final class Companion {
        public static void a() {
            BuildersKt.c(CoroutineScopeKt.a(Dispatchers.f54091a), null, new Phoenix$Companion$checkUpdate$1(2, null), 3);
        }

        public static Context b() {
            AppPhoenixManager appPhoenixManager = Phoenix.f46112b;
            if (appPhoenixManager != null) {
                return appPhoenixManager.f47554a;
            }
            Intrinsics.h("delegate");
            throw null;
        }

        public static Gson c() {
            if (Phoenix.f46113c == null) {
                Phoenix.f46113c = new Gson();
            }
            Gson gson = Phoenix.f46113c;
            if (gson != null) {
                return gson;
            }
            Intrinsics.h("gson");
            throw null;
        }

        public static boolean d() {
            Context context = b();
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter("is_internal_staging_user", "key");
            return PhoenixSharedPreference.Companion.b(context).getBoolean("is_internal_staging_user", false);
        }

        public static String e() {
            String strG = PhoenixUtils.Companion.g();
            CacheManifest cacheManifestB = PhoenixUtils.Companion.b(PhoenixSharedPreference.Companion.a("cache_manifest_data"));
            if (cacheManifestB == null || strG == null || !Intrinsics.b(cacheManifestB.a(), strG)) {
                String str = cacheManifestB == null ? "bundle_don't_exists" : "app_version_mismatched";
                PhoenixLogger.Companion.a("During getJsBundle returning default path as ".concat(str));
                PhoenixUtils.Companion.j(str);
                return "assets://index.android.bundle";
            }
            Intrinsics.checkNotNullParameter("App version matched with cache manifest app version in getJSBundlePath", "data");
            int iC = cacheManifestB.c();
            int iE = cacheManifestB.e();
            if (cacheManifestB.f() != BundleStates.f46108i) {
                String strB = FileUtil.Companion.b(iE, iC, "index.android.bundle");
                if (FileUtil.Companion.h(strB)) {
                    BuildersKt.c(CoroutineScopeKt.a(Dispatchers.f54091a), null, new PhoenixUpdateManager$Companion$getJSBundlePath$2(strG, cacheManifestB, iE, iC, null), 3);
                    return strB;
                }
                PhoenixLogger.Companion.a("During getJsBundle returning default path as  the bundle doesn't exists on path ".concat(strB));
                PhoenixUtils.Companion.j("no_phoenix_bundle_exists");
                return "assets://index.android.bundle";
            }
            PhoenixLogger.Companion.a("Rollback process started for current app version -> " + cacheManifestB.a() + " js Version -> " + cacheManifestB.e() + " bundle version -> " + cacheManifestB.c());
            JSONObject jSONObject = new JSONObject();
            PhoenixUtils.Companion.a(jSONObject, new Pair("bundle_version", Integer.valueOf(iC)), new Pair("js_version", Integer.valueOf(iE)), new Pair("js_bundle_version", iE + "-" + iC), new Pair("from", "same_app_version"));
            PhoenixAnalyticsLogger.Companion.a("ROLL_BACK_FROM_MANIFEST", jSONObject);
            BuildersKt.c(CoroutineScopeKt.a(Dispatchers.f54091a), null, new PhoenixUpdateManager$Companion$getJSBundlePath$1(cacheManifestB, iE, iC, null), 3);
            PhoenixLogger.Companion.a("During getJsBundle returning default path as rollback is happening for current app version -> " + cacheManifestB.a() + " js Version -> " + cacheManifestB.e() + " bundle version -> " + cacheManifestB.c());
            PhoenixUtils.Companion.j("rollback");
            return "assets://index.android.bundle";
        }

        public static String f() {
            JSONObject jSONObjectA = PhoenixSharedPreference.Companion.a("cache_manifest_data");
            String strG = PhoenixUtils.Companion.g();
            if (jSONObjectA == null || strG == null || !jSONObjectA.has("appVersion") || !Intrinsics.b(jSONObjectA.get("appVersion"), strG)) {
                jSONObjectA = null;
            }
            if (jSONObjectA == null) {
                String string = new JSONObject().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
            CacheManifest cacheManifestB = PhoenixUtils.Companion.b(jSONObjectA);
            if ((cacheManifestB != null ? cacheManifestB.f() : null) == BundleStates.f46108i) {
                String string2 = new JSONObject().toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                return string2;
            }
            String string3 = jSONObjectA.toString();
            Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
            return string3;
        }

        public static boolean g() {
            Context context = b();
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter("is_internal_user", "key");
            return PhoenixSharedPreference.Companion.b(context).getBoolean("is_internal_user", false);
        }

        public static void h(boolean z) {
            Intrinsics.checkNotNullParameter("is_internal_staging_user", "key");
            SharedPreferences.Editor editorEdit = PhoenixSharedPreference.Companion.b(b()).edit();
            Intrinsics.checkNotNullExpressionValue(editorEdit, "edit(...)");
            editorEdit.putBoolean("is_internal_staging_user", z);
            editorEdit.apply();
        }

        public static void i(boolean z) {
            Intrinsics.checkNotNullParameter("is_internal_user", "key");
            SharedPreferences.Editor editorEdit = PhoenixSharedPreference.Companion.b(b()).edit();
            Intrinsics.checkNotNullExpressionValue(editorEdit, "edit(...)");
            editorEdit.putBoolean("is_internal_user", z);
            editorEdit.apply();
        }
    }
}
