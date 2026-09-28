package com.phoenix;

import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.react.bridge.Promise;
import com.phoenix.FileUtil;
import com.phoenix.Phoenix;
import com.phoenix.PhoenixAnalyticsLogger;
import com.phoenix.PhoenixClientBuilder;
import com.phoenix.PhoenixLogger;
import com.phoenix.PhoenixRequestBuilder;
import com.phoenix.PhoenixSharedPreference;
import com.phoenix.PhoenixUtils;
import in.juspay.hyperutil.constants.LogLevel;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes.dex */
public final class PhoenixUpdateManager {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f46124a = new Companion();

    @Metadata
    public static final class Companion {

        @Metadata
        /* loaded from: classes4.dex */
        public /* synthetic */ class WhenMappings {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f46125a;

            static {
                int[] iArr = new int[BundleStates.values().length];
                try {
                    BundleStates bundleStates = BundleStates.f46100a;
                    iArr[5] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    BundleStates bundleStates2 = BundleStates.f46100a;
                    iArr[0] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    BundleStates bundleStates3 = BundleStates.f46100a;
                    iArr[2] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    BundleStates bundleStates4 = BundleStates.f46100a;
                    iArr[3] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    BundleStates bundleStates5 = BundleStates.f46100a;
                    iArr[1] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    BundleStates bundleStates6 = BundleStates.f46100a;
                    iArr[4] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    BundleStates bundleStates7 = BundleStates.f46100a;
                    iArr[6] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    BundleStates bundleStates8 = BundleStates.f46100a;
                    iArr[7] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    BundleStates bundleStates9 = BundleStates.f46100a;
                    iArr[8] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                f46125a = iArr;
            }
        }

        public static void b(String url, String hash, Integer num, Integer num2) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(hash, "hash");
            OkHttpClient okHttpClientA = PhoenixClientBuilder.Companion.a();
            Request requestA = PhoenixRequestBuilder.Companion.a(url);
            JSONObject jSONObject = new JSONObject();
            PhoenixUtils.Companion.a(jSONObject, new Pair("js_version", num), new Pair("bundle_version", num2), new Pair("js_bundle_version", num + "-" + num2));
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                Response responseD = okHttpClientA.a(requestA).d();
                try {
                    PhoenixUtils.Companion.a(jSONObject, new Pair("duration", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
                    g(responseD, jSONObject, num, hash, num2);
                    Unit unit = Unit.f53572a;
                    responseD.close();
                } finally {
                }
            } catch (Exception unused) {
                PhoenixUtils.Companion.a(jSONObject, new Pair("reason", "api_request_failed"));
                PhoenixAnalyticsLogger.Companion.a("DOWNLOAD_BUNDLE_FROM_SERVER_FAILED", jSONObject);
                Intrinsics.checkNotNullParameter("Bundle api request failed", "data");
            }
        }

        public static void c(PhoenixAppUpdateModel phoenixAppUpdateModel, int i2, int i3, JSONObject jSONObject) {
            Integer numB = phoenixAppUpdateModel.a().b();
            String strC = phoenixAppUpdateModel.a().c();
            String strE = phoenixAppUpdateModel.a().e();
            String strA = phoenixAppUpdateModel.a().a();
            if (strA == null || strE == null || strC == null) {
                if (strA == null || strC == null) {
                    PhoenixUtils.Companion.a(jSONObject, new Pair(CLConstants.OTP_STATUS, "url_not_found"));
                    PhoenixAnalyticsLogger.Companion.a("DOWNLOADING_START", jSONObject);
                    return;
                } else {
                    PhoenixUtils.Companion.a(jSONObject, new Pair(CLConstants.OTP_STATUS, "download_bundle"));
                    PhoenixAnalyticsLogger.Companion.a("DOWNLOADING_START", jSONObject);
                    b(strA, strC, Integer.valueOf(i2), numB);
                    return;
                }
            }
            PhoenixUtils.Companion.a(jSONObject, new Pair(CLConstants.OTP_STATUS, "download_patch"));
            PhoenixAnalyticsLogger.Companion.a("DOWNLOADING_START", jSONObject);
            Integer numValueOf = Integer.valueOf(i2);
            Integer numValueOf2 = Integer.valueOf(i3);
            OkHttpClient okHttpClientA = PhoenixClientBuilder.Companion.a();
            Request requestA = PhoenixRequestBuilder.Companion.a(strE);
            JSONObject jSONObject2 = new JSONObject();
            PhoenixUtils.Companion.a(jSONObject2, new Pair("js_version", numValueOf), new Pair("bundle_version", numB), new Pair("js_bundle_version", numValueOf + "-" + numB));
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                Response responseD = okHttpClientA.a(requestA).d();
                try {
                    PhoenixUtils.Companion.a(jSONObject2, new Pair("duration", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
                    Intrinsics.d(numB, "null cannot be cast to non-null type kotlin.Int");
                    h(responseD, jSONObject2, strC, i2, numB.intValue(), strA, numValueOf2);
                    Unit unit = Unit.f53572a;
                    responseD.close();
                } finally {
                }
            } catch (Exception unused) {
                PhoenixUtils.Companion.a(jSONObject2, new Pair("reason", "api_request_failed"));
                PhoenixAnalyticsLogger.Companion.a("DOWNLOAD_PATCH_FROM_SERVER_FAILED", jSONObject2);
                Intrinsics.checkNotNullParameter("function execution failed", "data");
            }
        }

        public static void d(String bundleUrl, String hash, int i2, int i3, Integer num, Promise promise) throws JSONException {
            Intrinsics.checkNotNullParameter(bundleUrl, "bundleUrl");
            Intrinsics.checkNotNullParameter(hash, "hash");
            Intrinsics.checkNotNullParameter(promise, "promise");
            UpdateData updateData = new UpdateData(bundleUrl, hash, Integer.valueOf(i2), Integer.valueOf(i3));
            PhoenixAppUpdateModel phoenixAppUpdateModel = new PhoenixAppUpdateModel(updateData);
            JSONObject jSONObject = new JSONObject();
            String strA = updateData.a();
            if (strA == null) {
                strA = "";
            }
            jSONObject.put("bundleUrl", strA);
            String strC = updateData.c();
            jSONObject.put("hash", strC != null ? strC : "");
            Integer numB = updateData.b();
            jSONObject.put("bundleVersion", numB != null ? numB.intValue() : 0);
            Integer numD = updateData.d();
            jSONObject.put("jsVersion", numD != null ? numD.intValue() : 0);
            if (updateData.d() == null || num == null) {
                promise.reject("PHOENIX_ERROR", "Failed to download bundle");
            } else {
                c(phoenixAppUpdateModel, updateData.d().intValue(), num.intValue(), jSONObject);
                promise.resolve("Bundle downloaded successfully");
            }
        }

        public static void e(String str, CacheManifest cacheManifest) {
            String strA = cacheManifest.a();
            if (Intrinsics.b(strA, str)) {
                return;
            }
            BundleStates bundleStatesF = cacheManifest.f();
            int iE = cacheManifest.e();
            int iC = cacheManifest.c();
            JSONObject params = new JSONObject();
            PhoenixUtils.Companion.a(params, new Pair("app_version", strA), new Pair(CLConstants.OTP_STATUS, bundleStatesF), new Pair("bundle_version", Integer.valueOf(iC)), new Pair("js_version", Integer.valueOf(iE)), new Pair("js_bundle_version", iE + "-" + iC));
            Intrinsics.checkNotNullParameter(params, "params");
            try {
                PhoenixUtils.Companion.a(params, new Pair("delete_status", Boolean.TRUE));
                PhoenixUtils.Companion.e(iE, iC, "unzip");
                PhoenixAnalyticsLogger.Companion.a("DELETE_UNZIP_OPERATION_STATUS", params);
                PhoenixLogger.Companion.a("Deleting unzip directories success for jsVersion -> " + iE + " bundleVersion -> " + iC);
            } catch (Exception unused) {
                PhoenixLogger.Companion.a("Deleting unzip directories failed for jsVersion -> " + iE + " bundleVersion -> " + iC);
                PhoenixUtils.Companion.a(params, new Pair("delete_status", Boolean.FALSE));
                PhoenixAnalyticsLogger.Companion.a("DELETE_UNZIP_OPERATION_STATUS", params);
            }
            PhoenixSharedPreference.Companion.c("cache_temp_manifest_data", null);
        }

        public static void f(CacheManifest cacheManifest) {
            JSONObject jSONObject = new JSONObject();
            PhoenixUtils.Companion.a(jSONObject, new Pair("app_version", cacheManifest.a()), new Pair(CLConstants.OTP_STATUS, cacheManifest.f()), new Pair("js_version", Integer.valueOf(cacheManifest.e())), new Pair("bundle_version", Integer.valueOf(cacheManifest.c())), new Pair("js_bundle_version", cacheManifest.e() + "-" + cacheManifest.c()));
            PhoenixAnalyticsLogger.Companion.a("ALREADY_UPDATE_IN_PROGRESS_EXIST", jSONObject);
        }

        public static void g(Response response, JSONObject jSONObject, Integer num, String str, Integer num2) throws NoSuchAlgorithmException, IOException {
            boolean zC = response.c();
            PhoenixUtils.Companion companion = PhoenixUtils.f46133a;
            if (!zC) {
                Pair pair = new Pair("reason", "response_not_success");
                String str2 = response.f56352c;
                PhoenixUtils.Companion.a(jSONObject, pair, new Pair(APayConstants.Error.MESSAGE, str2));
                PhoenixAnalyticsLogger.Companion.a("DOWNLOAD_BUNDLE_FROM_SERVER_FAILED", jSONObject);
                PhoenixLogger.Companion.a("Failed to download bundle file" + str2);
                return;
            }
            ResponseBody responseBody = response.f56356g;
            if (responseBody == null) {
                PhoenixUtils.Companion.a(jSONObject, new Pair("reason", "body_empty"));
                PhoenixAnalyticsLogger.Companion.a("DOWNLOAD_BUNDLE_FROM_SERVER_FAILED", jSONObject);
                Intrinsics.checkNotNullParameter("Failed to download bundle file body is null", "data");
                return;
            }
            PhoenixAnalyticsLogger.Companion.a("DOWNLOAD_BUNDLE_REQUEST_SUCCESS", jSONObject);
            int iIntValue = num.intValue();
            Intrinsics.d(num2, "null cannot be cast to non-null type kotlin.Int");
            String strB = FileUtil.Companion.b(iIntValue, num2.intValue(), "unzip");
            if (!FileUtil.Companion.l(FileUtil.Companion.f(strB), responseBody.a())) {
                PhoenixUtils.Companion.a(jSONObject, new Pair(CLConstants.OTP_STATUS, BundleStates.f46104e));
                PhoenixAnalyticsLogger.Companion.a("UNZIPPED_BUNDLE_STATUS", jSONObject);
                Intrinsics.checkNotNullParameter("Bundle not unzipped", "data");
                return;
            }
            BundleStates bundleStates = BundleStates.f46105f;
            PhoenixUtils.Companion.a(jSONObject, new Pair(CLConstants.OTP_STATUS, bundleStates));
            PhoenixAnalyticsLogger.Companion.a("UNZIPPED_BUNDLE_STATUS", jSONObject);
            PhoenixUtils.Companion.l(null, num, str, num2, bundleStates, "cache_temp_manifest_data");
            String strA = FileUtil.Companion.a(strB, "index.android.bundle");
            if (FileUtil.Companion.h(strA)) {
                PhoenixUtils.Companion.a(jSONObject, new Pair("exists", Boolean.TRUE));
                PhoenixAnalyticsLogger.Companion.a("DOWNLOAD_BUNDLE_EXISTENCE_STATUS", jSONObject);
                companion.n(new File(strA), num, str, num2);
            } else {
                PhoenixUtils.Companion.a(jSONObject, new Pair("exists", Boolean.FALSE));
                PhoenixAnalyticsLogger.Companion.a("DOWNLOAD_BUNDLE_EXISTENCE_STATUS", jSONObject);
                Intrinsics.checkNotNullParameter("Bundle unzip file doesn't exists", "data");
            }
        }

        public static void h(Response response, JSONObject jSONObject, String str, int i2, int i3, String str2, Integer num) throws NoSuchAlgorithmException, IOException {
            boolean zC = response.c();
            PhoenixUtils.Companion companion = PhoenixUtils.f46133a;
            if (!zC) {
                Pair pair = new Pair("reason", "response_not_success");
                String str3 = response.f56352c;
                PhoenixUtils.Companion.a(jSONObject, pair, new Pair(APayConstants.Error.MESSAGE, str3));
                PhoenixAnalyticsLogger.Companion.a("DOWNLOAD_PATCH_FROM_SERVER_FAILED", jSONObject);
                PhoenixLogger.Companion.a("Failed to download patch file" + str3);
                return;
            }
            ResponseBody responseBody = response.f56356g;
            if (responseBody == null) {
                PhoenixUtils.Companion.a(jSONObject, new Pair("reason", "body_empty"));
                PhoenixAnalyticsLogger.Companion.a("DOWNLOAD_PATCH_FROM_SERVER_FAILED", jSONObject);
                Intrinsics.checkNotNullParameter("Failed to download patch file body is null", "data");
                return;
            }
            PhoenixAnalyticsLogger.Companion.a("DOWNLOAD_PATCH_REQUEST_SUCCESS", jSONObject);
            String strB = FileUtil.Companion.b(i2, i3, "unzip");
            if (!FileUtil.Companion.l(FileUtil.Companion.f(strB), responseBody.a())) {
                PhoenixUtils.Companion.a(jSONObject, new Pair(CLConstants.OTP_STATUS, BundleStates.f46101b));
                PhoenixAnalyticsLogger.Companion.a("UNZIPPED_PATCH_STATUS", jSONObject);
                return;
            }
            BundleStates bundleStates = BundleStates.f46100a;
            PhoenixUtils.Companion.a(jSONObject, new Pair(CLConstants.OTP_STATUS, bundleStates));
            PhoenixAnalyticsLogger.Companion.a("UNZIPPED_PATCH_STATUS", jSONObject);
            PhoenixUtils.Companion.l(str2, Integer.valueOf(i2), str, Integer.valueOf(i3), bundleStates, "cache_temp_manifest_data");
            String strA = FileUtil.Companion.a(strB, "index.patch");
            if (FileUtil.Companion.h(strA)) {
                PhoenixUtils.Companion.a(jSONObject, new Pair("exists", Boolean.TRUE));
                PhoenixAnalyticsLogger.Companion.a("DOWNLOAD_PATCH_EXISTENCE_STATUS", jSONObject);
                companion.o(strA, Integer.valueOf(i2), bundleStates, str, str2, Integer.valueOf(i3), num);
            } else {
                PhoenixUtils.Companion.a(jSONObject, new Pair("exists", Boolean.FALSE));
                PhoenixAnalyticsLogger.Companion.a("DOWNLOAD_PATCH_EXISTENCE_STATUS", jSONObject);
                Intrinsics.checkNotNullParameter("Patch unzip file doesn't exists", "data");
            }
            Intrinsics.checkNotNullParameter("Function execution success", "data");
        }

        public static void i(Response response, Integer num, CacheManifest cacheManifest, JSONObject jSONObject) {
            UpdateData updateDataA;
            int iC = cacheManifest.c();
            if (!response.c()) {
                Pair pair = new Pair("reason", "response_not_success");
                String str = response.f56352c;
                PhoenixUtils.Companion.a(jSONObject, pair, new Pair(APayConstants.Error.MESSAGE, str));
                PhoenixAnalyticsLogger.Companion.a("UPDATE_API_FAILED", jSONObject);
                PhoenixLogger.Companion.a("File download failed" + str);
                return;
            }
            ResponseBody responseBody = response.f56356g;
            if (responseBody == null) {
                PhoenixUtils.Companion.a(jSONObject, new Pair("reason", "body_empty"));
                PhoenixAnalyticsLogger.Companion.a("UPDATE_API_FAILED", jSONObject);
                return;
            }
            PhoenixAnalyticsLogger.Companion.a("GET_UPDATE_REQUEST_SUCCESS", jSONObject);
            PhoenixAppUpdateModel phoenixAppUpdateModel = (PhoenixAppUpdateModel) Phoenix.Companion.c().d(PhoenixAppUpdateModel.class, responseBody.r());
            boolean z = false;
            if ((phoenixAppUpdateModel == null || (updateDataA = phoenixAppUpdateModel.a()) == null) ? false : Intrinsics.b(updateDataA.f(), Boolean.TRUE)) {
                PhoenixAnalyticsLogger.Companion.a("ROLL_BACK_INITIATED", jSONObject);
                String strD = cacheManifest.d();
                Intrinsics.d(strD, "null cannot be cast to non-null type kotlin.String");
                PhoenixUtils.Companion.l(null, num, strD, Integer.valueOf(iC), BundleStates.f46108i, "cache_manifest_data");
                return;
            }
            PhoenixUtils.Companion.a(jSONObject, new Pair("is_update_available", Boolean.valueOf(phoenixAppUpdateModel.a().g())));
            UpdateData updateDataA2 = phoenixAppUpdateModel.a();
            if (updateDataA2 != null && updateDataA2.g()) {
                z = true;
            }
            if (!z) {
                PhoenixAnalyticsLogger.Companion.a("UPDATE_STATUS", jSONObject);
            } else {
                PhoenixAnalyticsLogger.Companion.a("UPDATE_STATUS", jSONObject);
                c(phoenixAppUpdateModel, num.intValue(), iC, jSONObject);
            }
        }

        public static boolean j(CacheManifest cacheManifest, Integer num) throws NoSuchAlgorithmException, IOException {
            BundleStates bundleStatesF = cacheManifest.f();
            String strD = cacheManifest.d();
            int iE = cacheManifest.e();
            int iC = cacheManifest.c();
            String strB = cacheManifest.b();
            int i2 = bundleStatesF == null ? -1 : WhenMappings.f46125a[bundleStatesF.ordinal()];
            PhoenixUtils.Companion companion = PhoenixUtils.f46133a;
            switch (i2) {
                case -1:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    return false;
                case 0:
                default:
                    throw new NoWhenBranchMatchedException();
                case 1:
                    Intrinsics.d(strD, "null cannot be cast to non-null type kotlin.String");
                    Integer numValueOf = Integer.valueOf(iE);
                    String strA = FileUtil.Companion.a(FileUtil.Companion.b(iE, iC, "unzip"), "index.android.bundle");
                    if (FileUtil.Companion.h(strA)) {
                        companion.n(new File(strA), numValueOf, strD, Integer.valueOf(iC));
                        return true;
                    }
                    PhoenixSharedPreference.Companion.c("cache_temp_manifest_data", null);
                    PhoenixUtils.Companion.c(iE, iC);
                    Intrinsics.checkNotNullParameter("Unzip bundle doesn't exists", "data");
                    return true;
                case 2:
                    Integer numValueOf2 = Integer.valueOf(iE);
                    Intrinsics.d(strD, "null cannot be cast to non-null type kotlin.String");
                    Intrinsics.d(strB, "null cannot be cast to non-null type kotlin.String");
                    String strA2 = FileUtil.Companion.a(FileUtil.Companion.b(iE, iC, "unzip"), "index.patch");
                    if (FileUtil.Companion.h(strA2)) {
                        companion.o(strA2, numValueOf2, bundleStatesF, strD, strB, Integer.valueOf(iC), num);
                        return true;
                    }
                    PhoenixSharedPreference.Companion.c("cache_temp_manifest_data", null);
                    PhoenixUtils.Companion.f(iE, iC);
                    Intrinsics.checkNotNullParameter("Unzip patch doesn't exists", "data");
                    return true;
                case 3:
                    Intrinsics.d(strD, "null cannot be cast to non-null type kotlin.String");
                    Integer numValueOf3 = Integer.valueOf(iE);
                    Intrinsics.d(strB, "null cannot be cast to non-null type kotlin.String");
                    Integer numValueOf4 = Integer.valueOf(iC);
                    String strA3 = FileUtil.Companion.a(FileUtil.Companion.b(iE, iC, "unzip"), "index.android.bundle");
                    if (FileUtil.Companion.h(strA3)) {
                        companion.m(strA3, numValueOf3, strD, strB, numValueOf4);
                        return true;
                    }
                    PhoenixSharedPreference.Companion.c("cache_temp_manifest_data", null);
                    PhoenixUtils.Companion.f(iE, iC);
                    Intrinsics.checkNotNullParameter("Applied patch file doesn't exists", "data");
                    return true;
                case 4:
                    Intrinsics.d(strD, "null cannot be cast to non-null type kotlin.String");
                    Integer numValueOf5 = Integer.valueOf(iE);
                    Intrinsics.d(strB, "null cannot be cast to non-null type kotlin.String");
                    b(strB, strD, numValueOf5, Integer.valueOf(iC));
                    return true;
            }
        }

        public final synchronized void a() {
            PhoenixUtils.Companion companion = PhoenixUtils.f46133a;
            String strG = PhoenixUtils.Companion.g();
            CacheManifest cacheManifestB = PhoenixUtils.Companion.b(PhoenixSharedPreference.Companion.a("cache_temp_manifest_data"));
            JSONObject jSONObjectA = PhoenixSharedPreference.Companion.a("cache_manifest_data");
            if (jSONObjectA == null) {
                jSONObjectA = PhoenixUtils.Companion.k();
            }
            CacheManifest userData = PhoenixUtils.Companion.b(jSONObjectA);
            if (userData == null) {
                Intrinsics.checkNotNullParameter("Manifest not found during check update", "data");
                PhoenixAnalyticsLogger.Companion.a("MANIFEST_NOT_FOUND", new JSONObject());
                return;
            }
            if (strG == null) {
                Intrinsics.checkNotNullParameter("Current app version not found", "data");
                return;
            }
            if (cacheManifestB != null) {
                String strA = cacheManifestB.a();
                int iC = userData.c();
                if (!Intrinsics.b(strA, strG)) {
                    e(strG, cacheManifestB);
                } else if (j(cacheManifestB, Integer.valueOf(iC))) {
                    f(cacheManifestB);
                    return;
                }
            }
            int iE = userData.e();
            int iC2 = userData.c();
            String strA2 = userData.a();
            if (userData.f() == BundleStates.f46108i) {
                PhoenixLogger.Companion.a("Already a roll back is in progress for app version ".concat(strG));
                PhoenixAnalyticsLogger.Companion.a("ROLL_BACK_IN_PROGRESS", new JSONObject());
                if (!strG.equals(strA2)) {
                    JSONObject jSONObject = new JSONObject();
                    PhoenixUtils.Companion.a(jSONObject, new Pair("bundle_version", Integer.valueOf(userData.c())), new Pair("js_version", Integer.valueOf(userData.e())), new Pair("js_bundle_version", userData.e() + "-" + userData.c()), new Pair("from", "different_app_version"));
                    int iE2 = userData.e();
                    int iC3 = userData.c();
                    Intrinsics.checkNotNullParameter(userData, "userData");
                    PhoenixSharedPreference.Companion.c("cache_manifest_data", null);
                    companion.d(iE2, iC3, userData.f(), "roll_back", userData.a());
                    PhoenixAnalyticsLogger.Companion.a("ROLL_BACK_FROM_MANIFEST", jSONObject);
                }
                return;
            }
            if (!strG.equals(strA2)) {
                PhoenixLogger.Companion.a("Deleting old bundles as current app version -> " + strG + " and cache manifest app version -> " + strA2 + " not same");
                if (!companion.d(iE, iC2, userData.f(), "app_version_mismatch", strA2)) {
                    PhoenixSharedPreference.Companion.c("cache_manifest_data", null);
                    return;
                }
                CacheManifest cacheManifestB2 = PhoenixUtils.Companion.b(PhoenixUtils.Companion.k());
                if (cacheManifestB2 != null) {
                    iE = cacheManifestB2.e();
                    iC2 = cacheManifestB2.c();
                    JSONObject jSONObject2 = new JSONObject();
                    PhoenixUtils.Companion.a(jSONObject2, new Pair("bundle_version", Integer.valueOf(iC2)), new Pair("js_version", Integer.valueOf(iE)), new Pair("js_bundle_version", iE + "-" + iC2));
                    PhoenixAnalyticsLogger.Companion.a("APP_MANIFEST_FOUND", jSONObject2);
                } else {
                    JSONObject jSONObject3 = new JSONObject();
                    PhoenixUtils.Companion.a(jSONObject3, new Pair("bundle_version", Integer.valueOf(iC2)), new Pair("js_version", Integer.valueOf(iE)), new Pair("js_bundle_version", iE + "-" + iC2));
                    PhoenixAnalyticsLogger.Companion.a("APP_MANIFEST_NOT_FOUND", jSONObject3);
                }
            }
            int iH = PhoenixUtils.Companion.h(Integer.valueOf(iE), Integer.valueOf(iC2));
            String strI = PhoenixUtils.Companion.i(iE, iC2, iH);
            OkHttpClient okHttpClientA = PhoenixClientBuilder.Companion.a();
            JSONObject jSONObject4 = new JSONObject();
            PhoenixUtils.Companion.a(jSONObject4, new Pair("device_hash", Integer.valueOf(iH)), new Pair("app_version", strG), new Pair("bundle_version", Integer.valueOf(iC2)), new Pair("js_version", Integer.valueOf(iE)), new Pair("fetch_url", strI), new Pair("js_bundle_version", iE + "-" + iC2));
            Request requestA = PhoenixRequestBuilder.Companion.a(strI);
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                Response responseD = okHttpClientA.a(requestA).d();
                try {
                    PhoenixUtils.Companion.a(jSONObject4, new Pair("response_code", String.valueOf(responseD.f56353d)));
                    PhoenixUtils.Companion.a(jSONObject4, new Pair("duration", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
                    i(responseD, Integer.valueOf(iE), userData, jSONObject4);
                    responseD.close();
                } finally {
                }
            } catch (Exception e2) {
                PhoenixLogger.Companion.a("exception is " + e2);
                PhoenixUtils.Companion.a(jSONObject4, new Pair(LogLevel.EXCEPTION, String.valueOf(e2.getMessage())), new Pair("reason", "api_request_failed"));
                PhoenixAnalyticsLogger.Companion.a("UPDATE_API_FAILED", jSONObject4);
                Intrinsics.checkNotNullParameter("Failed to get data from api", "data");
            }
        }
    }
}
