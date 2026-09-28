package com.phoenix;

import android.content.Context;
import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.phoenix.FileUtil;
import com.phoenix.Phoenix;
import com.phoenix.PhoenixAnalyticsLogger;
import com.phoenix.PhoenixLogger;
import com.phoenix.PhoenixSharedPreference;
import com.phoenix.PhoenixUpdateManager;
import com.smart.library.util.bspatch.BSPatchUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes.dex */
public final class PhoenixUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f46133a = new Companion();

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        public static void a(JSONObject jsonObject, Pair... params) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            Intrinsics.checkNotNullParameter(params, "params");
            for (Pair pair : params) {
                jsonObject.put((String) pair.f53533a, pair.f53534b);
            }
        }

        public static CacheManifest b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            Object objD = Phoenix.Companion.c().d(CacheManifest.class, jSONObject.toString());
            Intrinsics.checkNotNullExpressionValue(objD, "fromJson(...)");
            return (CacheManifest) objD;
        }

        public static void c(int i2, int i3) {
            try {
                e(i2, i3, "unzip");
                PhoenixLogger.Companion.a(" Delete bundle related directories success for jsVersion -> " + i2 + " bundleVersion -> " + i3);
            } catch (Exception e2) {
                StringBuilder sbT = b.t(i2, i3, " Delete bundle related directories failed for jsVersion -> ", " bundleVersion -> ", " with exception ");
                sbT.append(e2);
                PhoenixLogger.Companion.a(sbT.toString());
            }
        }

        public static void e(int i2, int i3, String str) {
            if (str != null) {
                FileUtil.Companion.g(FileUtil.Companion.b(i2, i3, str));
            } else {
                FileUtil.Companion.g(FileUtil.Companion.b(i2, i3, null));
            }
        }

        public static void f(int i2, int i3) {
            try {
                e(i2, i3, "temp/index.android.bundle");
                e(i2, i3, "unzip");
                PhoenixLogger.Companion.a("Delete patch related directories success for jsVersion -> " + i2 + " bundleVersion -> " + i3);
            } catch (Exception e2) {
                StringBuilder sbT = b.t(i2, i3, "Delete patch related directories failed for jsVersion -> ", " bundleVersion -> ", " with exception ");
                sbT.append(e2);
                PhoenixLogger.Companion.a(sbT.toString());
            }
        }

        public static String g() {
            Context contextB = Phoenix.Companion.b();
            try {
                return contextB.getPackageManager().getPackageInfo(contextB.getPackageName(), 0).versionName;
            } catch (Exception unused) {
                return null;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x00e1  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00eb A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00ec A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int h(java.lang.Integer r7, java.lang.Integer r8) {
            /*
                Method dump skipped, instructions count: 237
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.phoenix.PhoenixUtils.Companion.h(java.lang.Integer, java.lang.Integer):int");
        }

        public static String i(int i2, int i3, int i4) {
            String str = Phoenix.f46111a;
            if (str == null) {
                Intrinsics.h(CLConstants.SALT_FIELD_APP_ID);
                throw null;
            }
            boolean zG = Phoenix.Companion.g();
            boolean zD = Phoenix.Companion.d();
            StringBuilder sb = new StringBuilder();
            sb.append("https://api-gateway.zepto.co.in/Prod");
            sb.append("/api/v1/check_update?appId=");
            sb.append(str);
            sb.append("&jsVersion=");
            sb.append(i2);
            e.w(i3, i4, "&bundleVersion=", "&bucket=", sb);
            sb.append("&iu=");
            sb.append(zG);
            sb.append("&is=");
            sb.append(zD);
            return sb.toString();
        }

        public static void j(String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            JSONObject jSONObject = new JSONObject();
            a(jSONObject, new Pair("reason", reason));
            PhoenixAnalyticsLogger.Companion.a("SHARED_DEFAULT_BUNDLE", jSONObject);
        }

        public static JSONObject k() throws IOException {
            try {
                InputStream inputStreamOpen = Phoenix.Companion.b().getAssets().open("manifest.json");
                Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
                return new JSONObject(FileUtil.Companion.k(inputStreamOpen).toString());
            } catch (IOException e2) {
                e2.printStackTrace();
                Unit.f53572a.getClass();
                Intrinsics.checkNotNullParameter("kotlin.Unit", "data");
                return null;
            }
        }

        public static boolean l(String str, Integer num, String hash, Integer num2, BundleStates bundleStates, String source) {
            String str2;
            Intrinsics.checkNotNullParameter(hash, "hash");
            Intrinsics.checkNotNullParameter(source, "source");
            String strG = g();
            if (strG == null) {
                Intrinsics.checkNotNullParameter("Could not get app version", "data");
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            a(jSONObject, new Pair("app_version", strG), new Pair("js_version", num), new Pair("bundle_version", num2), new Pair("js_bundle_version", num + "-" + num2));
            try {
                JSONObject jSONObject2 = new JSONObject();
                a(jSONObject2, new Pair("appVersion", strG), new Pair("jsVersion", num), new Pair("hash", hash), new Pair("bundleVersion", num2));
                if (str != null) {
                    a(jSONObject2, new Pair("bundleUrl", str));
                }
                a(jSONObject2, new Pair(CLConstants.OTP_STATUS, bundleStates));
                a(jSONObject, new Pair(CLConstants.OTP_STATUS, bundleStates));
                a(jSONObject, new Pair("update_status", APayConstants.SUCCESS));
                PhoenixSharedPreference.Companion.c(source, jSONObject2);
                str2 = "UPDATE_CACHE_DATA";
                try {
                    PhoenixAnalyticsLogger.Companion.a(str2, jSONObject);
                    return true;
                } catch (Exception e2) {
                    e = e2;
                    a(jSONObject, new Pair("update_status", "failed"));
                    a(jSONObject, new Pair(CLConstants.OTP_STATUS, bundleStates));
                    PhoenixAnalyticsLogger.Companion.a(str2, jSONObject);
                    PhoenixLogger.Companion.a("failed to update user data with exception " + e);
                    return false;
                }
            } catch (Exception e3) {
                e = e3;
                str2 = "UPDATE_CACHE_DATA";
            }
        }

        public final boolean d(int i2, int i3, BundleStates bundleStates, String reason, String cacheManifestAppVersion) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            Intrinsics.checkNotNullParameter(cacheManifestAppVersion, "cacheManifestAppVersion");
            JSONObject jSONObject = new JSONObject();
            a(jSONObject, new Pair("app_version", cacheManifestAppVersion), new Pair("js_version", Integer.valueOf(i2)), new Pair("bundle_version", Integer.valueOf(i3)), new Pair(CLConstants.OTP_STATUS, bundleStates), new Pair("reason", reason), new Pair("js_bundle_version", i2 + "-" + i3));
            try {
                a(jSONObject, new Pair("delete_status", Boolean.TRUE));
                e(i2, i3, null);
                PhoenixAnalyticsLogger.Companion.a("DELETE_BUNDLE_STATUS", jSONObject);
                PhoenixLogger.Companion.a("Deleting current bundle success for jsVersion-> " + i2 + " bundleVersion -> " + i3 + " appVersion " + cacheManifestAppVersion);
                return true;
            } catch (Exception e2) {
                StringBuilder sbT = b.t(i2, i3, "Deleting current bundle failed for jsVersion-> ", " bundleVersion -> ", " appVersion ");
                sbT.append(cacheManifestAppVersion);
                sbT.append(" with exception ");
                sbT.append(e2);
                PhoenixLogger.Companion.a(sbT.toString());
                a(jSONObject, new Pair("delete_status", Boolean.FALSE));
                PhoenixAnalyticsLogger.Companion.a("DELETE_BUNDLE_STATUS", jSONObject);
                return false;
            }
        }

        public final void m(String finalPatchFile, Integer num, String hash, String bundleUrl, Integer num2) throws NoSuchAlgorithmException, IOException {
            Intrinsics.checkNotNullParameter(finalPatchFile, "finalPatchFile");
            Intrinsics.checkNotNullParameter(hash, "hash");
            Intrinsics.checkNotNullParameter(bundleUrl, "bundleUrl");
            String strD = FileUtil.Companion.d(new FileInputStream(new File(finalPatchFile)));
            JSONObject jSONObject = new JSONObject();
            a(jSONObject, new Pair("js_version", num), new Pair("bundle_version", num2), new Pair("md5", strD), new Pair("hash", hash), new Pair("js_bundle_version", num + "-" + num2));
            PhoenixLogger.Companion.a("md5 for patch is " + strD + " and for the bundle is " + hash);
            if (!Intrinsics.b(strD, hash)) {
                a(jSONObject, new Pair(CLConstants.OTP_STATUS, "md5_not_matched"));
                PhoenixAnalyticsLogger.Companion.a("PATCH_MD5_STATUS", jSONObject);
                Intrinsics.checkNotNullParameter("Md5 mismatched for patch", "data");
                l(bundleUrl, num, hash, num2, BundleStates.f46103d, "cache_temp_manifest_data");
                e(num.intValue(), num2.intValue(), null);
                PhoenixUpdateManager.Companion.b(bundleUrl, hash, num, num2);
                return;
            }
            a(jSONObject, new Pair(CLConstants.OTP_STATUS, "md5_matched"));
            Intrinsics.checkNotNullParameter("Md5 matched for patch", "data");
            PhoenixAnalyticsLogger.Companion.a("PATCH_MD5_STATUS", jSONObject);
            if (!FileUtil.Companion.e(new File(FileUtil.Companion.b(num.intValue(), num2.intValue(), "unzip")), new File(FileUtil.Companion.b(num.intValue(), num2.intValue(), null)))) {
                e(num.intValue(), num2.intValue(), null);
                a(jSONObject, new Pair("is_copied", Boolean.FALSE));
                PhoenixAnalyticsLogger.Companion.a("PATCH_COPY_STATUS", jSONObject);
                Intrinsics.checkNotNullParameter("Patch copy failed", "data");
                return;
            }
            a(jSONObject, new Pair("is_copied", Boolean.TRUE));
            Intrinsics.checkNotNullParameter("Patch copying success", "data");
            PhoenixAnalyticsLogger.Companion.a("PATCH_COPY_STATUS", jSONObject);
            String strB = FileUtil.Companion.b(num.intValue(), num2.intValue(), "index.android.bundle");
            if (!FileUtil.Companion.h(strB)) {
                PhoenixAnalyticsLogger.Companion.a("PATCH_FILE_NOT_FOUND", new JSONObject());
                l(bundleUrl, num, hash, num2, BundleStates.f46103d, "cache_temp_manifest_data");
                e(num.intValue(), num2.intValue(), null);
                PhoenixUpdateManager.Companion.b(bundleUrl, hash, num, num2);
                return;
            }
            String strD2 = FileUtil.Companion.d(new FileInputStream(new File(strB)));
            Intrinsics.checkNotNullParameter("md5HashOfFinalFile calculation done", "data");
            if (!Intrinsics.b(strD2, hash)) {
                a(jSONObject, new Pair(CLConstants.OTP_STATUS, "md5_not_matched"));
                PhoenixAnalyticsLogger.Companion.a("FINAL_PATCH_MD5_STATUS", jSONObject);
                l(bundleUrl, num, hash, num2, BundleStates.f46103d, "cache_temp_manifest_data");
                e(num.intValue(), num2.intValue(), null);
                PhoenixUpdateManager.Companion.b(bundleUrl, hash, num, num2);
                return;
            }
            a(jSONObject, new Pair(CLConstants.OTP_STATUS, "md5_matched"));
            PhoenixAnalyticsLogger.Companion.a("FINAL_PATCH_MD5_STATUS", jSONObject);
            if (l(null, num, hash, num2, BundleStates.f46106g, "cache_manifest_data")) {
                f(num.intValue(), num2.intValue());
                PhoenixSharedPreference.Companion.c("cache_temp_manifest_data", null);
            }
        }

        public final void n(File unzipBundleFile, Integer num, String hash, Integer num2) throws NoSuchAlgorithmException, IOException {
            Intrinsics.checkNotNullParameter(unzipBundleFile, "unzipBundleFile");
            Intrinsics.checkNotNullParameter(hash, "hash");
            String strD = FileUtil.Companion.d(new FileInputStream(unzipBundleFile));
            JSONObject jSONObject = new JSONObject();
            a(jSONObject, new Pair("js_version", num), new Pair("bundle_version", num2), new Pair("md5", strD), new Pair("hash", hash));
            if (!Intrinsics.b(strD, hash)) {
                a(jSONObject, new Pair(CLConstants.OTP_STATUS, "md5_not_matched"));
                PhoenixAnalyticsLogger.Companion.a("BUNDLE_MD5_STATUS", jSONObject);
                int iIntValue = num.intValue();
                Intrinsics.d(num2, "null cannot be cast to non-null type kotlin.Int");
                e(iIntValue, num2.intValue(), null);
                Intrinsics.checkNotNullParameter("Md5 hash doesn't matches for bundle applying", "data");
                return;
            }
            a(jSONObject, new Pair(CLConstants.OTP_STATUS, "md5_matched"));
            PhoenixAnalyticsLogger.Companion.a("BUNDLE_MD5_STATUS", jSONObject);
            int iIntValue2 = num.intValue();
            Intrinsics.d(num2, "null cannot be cast to non-null type kotlin.Int");
            if (!FileUtil.Companion.e(new File(FileUtil.Companion.b(iIntValue2, num2.intValue(), "unzip")), new File(FileUtil.Companion.b(num.intValue(), num2.intValue(), null)))) {
                a(jSONObject, new Pair("is_copied", Boolean.FALSE));
                PhoenixAnalyticsLogger.Companion.a("BUNDLE_COPY_STATUS", jSONObject);
                return;
            }
            a(jSONObject, new Pair("is_copied", Boolean.TRUE));
            PhoenixAnalyticsLogger.Companion.a("BUNDLE_COPY_STATUS", jSONObject);
            String strB = FileUtil.Companion.b(num.intValue(), num2.intValue(), "index.android.bundle");
            if (!FileUtil.Companion.h(strB)) {
                PhoenixAnalyticsLogger.Companion.a("BUNDLE_FILE_NOT_FOUND", new JSONObject());
                e(num.intValue(), num2.intValue(), null);
                return;
            }
            if (!Intrinsics.b(FileUtil.Companion.d(new FileInputStream(new File(strB))), hash)) {
                a(jSONObject, new Pair(CLConstants.OTP_STATUS, "md5_not_matched"));
                PhoenixAnalyticsLogger.Companion.a("FINAL_BUNDLE_MD5_STATUS", jSONObject);
                e(num.intValue(), num2.intValue(), null);
            } else {
                a(jSONObject, new Pair(CLConstants.OTP_STATUS, "md5_matched"));
                PhoenixAnalyticsLogger.Companion.a("FINAL_BUNDLE_MD5_STATUS", jSONObject);
                if (l(null, num, hash, num2, BundleStates.f46106g, "cache_manifest_data")) {
                    c(num.intValue(), num2.intValue());
                    PhoenixSharedPreference.Companion.c("cache_temp_manifest_data", null);
                }
            }
        }

        public final void o(String unzipPatchFilePath, Integer num, BundleStates statusParam, String hash, String bundleUrl, Integer num2, Integer num3) throws NoSuchAlgorithmException, IOException {
            String str;
            Intrinsics.checkNotNullParameter(unzipPatchFilePath, "unzipPatchFilePath");
            Intrinsics.checkNotNullParameter(statusParam, "statusParam");
            Intrinsics.checkNotNullParameter(hash, "hash");
            Intrinsics.checkNotNullParameter(bundleUrl, "bundleUrl");
            long jCurrentTimeMillis = System.currentTimeMillis();
            int iIntValue = num.intValue();
            int iIntValue2 = num2.intValue();
            try {
                String strB = FileUtil.Companion.b(iIntValue, num3.intValue(), "index.android.bundle");
                String strB2 = FileUtil.Companion.b(iIntValue, iIntValue2, "temp/index.android.bundle");
                if (FileUtil.Companion.h(strB)) {
                    FileUtil.Companion.m(strB2, FileUtil.Companion.j(new FileInputStream(new File(strB))));
                    PhoenixAnalyticsLogger.Companion.a("COPY_BUNDLE_INTO_TEMP_SUCCESS", new JSONObject());
                    str = "phoenix_bundle";
                } else {
                    InputStream inputStreamOpen = Phoenix.Companion.b().getAssets().open("index.android.bundle");
                    Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
                    FileUtil.Companion.m(strB2, FileUtil.Companion.j(inputStreamOpen));
                    PhoenixAnalyticsLogger.Companion.a("COPY_BUNDLE_INTO_TEMP_SUCCESS", new JSONObject());
                    str = "default_bundle";
                }
            } catch (Exception e2) {
                PhoenixAnalyticsLogger.Companion.a("COPY_BUNDLE_INTO_TEMP_FAILED", new JSONObject());
                PhoenixLogger.Companion.a("failed to copy to temp folder with exception " + e2);
                str = "failed";
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            String strB3 = FileUtil.Companion.b(num.intValue(), num2.intValue(), "temp/index.android.bundle");
            String strA = FileUtil.Companion.a(FileUtil.Companion.b(num.intValue(), num2.intValue(), "unzip"), "index.android.bundle");
            long jCurrentTimeMillis3 = System.currentTimeMillis();
            int iBspatch = BSPatchUtil.bspatch(strB3, strA, unzipPatchFilePath);
            long jCurrentTimeMillis4 = System.currentTimeMillis() - jCurrentTimeMillis3;
            PhoenixLogger.Companion.a("Result is " + iBspatch);
            JSONObject jSONObject = new JSONObject();
            a(jSONObject, new Pair("js_version", num), new Pair("bundle_version", num2), new Pair("bundle_into_temp_copy_duration", Long.valueOf(jCurrentTimeMillis2)), new Pair("copy_from_source_into_temp", str), new Pair("patch_apply_duration", Long.valueOf(jCurrentTimeMillis4)), new Pair(CLConstants.OTP_STATUS, statusParam), new Pair("js_bundle_version", num + "-" + num2));
            if (iBspatch != -1) {
                BundleStates bundleStates = BundleStates.f46102c;
                a(jSONObject, new Pair(CLConstants.OTP_STATUS, bundleStates));
                PhoenixAnalyticsLogger.Companion.a("PATCH_APPLICATION_STATUS", jSONObject);
                l(bundleUrl, num, hash, num2, bundleStates, "cache_temp_manifest_data");
                m(strA, num, hash, bundleUrl, num2);
                return;
            }
            BundleStates bundleStates2 = BundleStates.f46103d;
            a(jSONObject, new Pair(CLConstants.OTP_STATUS, bundleStates2));
            PhoenixAnalyticsLogger.Companion.a("PATCH_APPLICATION_STATUS", jSONObject);
            l(bundleUrl, num, hash, num2, bundleStates2, "cache_temp_manifest_data");
            e(num.intValue(), num2.intValue(), null);
            PhoenixUpdateManager.Companion.b(bundleUrl, hash, num, num2);
        }
    }
}
