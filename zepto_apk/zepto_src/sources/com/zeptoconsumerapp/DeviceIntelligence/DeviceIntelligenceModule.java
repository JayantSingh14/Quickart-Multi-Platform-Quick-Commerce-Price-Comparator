package com.zeptoconsumerapp.DeviceIntelligence;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.support.v4.media.b;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.android.gms.common.internal.AccountType;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.tencent.mmkv.MMKV;
import com.zeptoconsumerapp.Utils;
import com.zeptoconsumerapp.modules.base.StorageKeys;
import com.zeptoconsumerapp.modules.base.StorageManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.time.DateUtils;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class DeviceIntelligenceModule extends ReactContextBaseJavaModule {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    private static final String TAG = "DeviceIntelligence";

    @NotNull
    private final List<String> DEFAULT_PACKAGE_NAME_FILTER_EXCLUSIONS;
    private final long MIN_INSTALL_TIME_THRESHOLD;

    @NotNull
    private final String PLAY_STORE_PACKAGE;
    private final long TWENTY_FOUR_HOURS_MS;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceIntelligenceModule(@NotNull ReactApplicationContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.MIN_INSTALL_TIME_THRESHOLD = 1230768000000L;
        this.PLAY_STORE_PACKAGE = "com.android.vending";
        this.TWENTY_FOUR_HOURS_MS = DateUtils.MILLIS_PER_DAY;
        this.DEFAULT_PACKAGE_NAME_FILTER_EXCLUSIONS = CollectionsKt.I("com.miui", AccountType.GOOGLE);
    }

    private final double calculatePercentile(List<Double> list, double d2) {
        if (list.isEmpty()) {
            return 0.0d;
        }
        double size = d2 * (list.size() - 1);
        int iFloor = (int) Math.floor(size);
        int iCeil = (int) Math.ceil(size);
        if (iFloor == iCeil) {
            return list.get(iFloor).doubleValue();
        }
        return ((list.get(iCeil).doubleValue() - list.get(iFloor).doubleValue()) * (size - iFloor)) + list.get(iFloor).doubleValue();
    }

    private final List<String> getPackageNameFilterExclusions() {
        ArrayList arrayList = new ArrayList();
        try {
            MMKV mmkvA = StorageManager.a();
            StorageKeys[] storageKeysArr = StorageKeys.f47625b;
            String string = mmkvA.getString("app_config_override", "");
            if (string == null || string.length() == 0) {
                string = mmkvA.getString("FeaturesConfig", "");
            }
            if (string != null && string.length() != 0) {
                Object objD = Utils.c().d(JsonElement.class, string);
                Intrinsics.checkNotNullExpressionValue(objD, "fromJson(...)");
                JsonElement jsonElement = (JsonElement) objD;
                jsonElement.getClass();
                if (!(jsonElement instanceof JsonObject)) {
                    return this.DEFAULT_PACKAGE_NAME_FILTER_EXCLUSIONS;
                }
                JsonObject jsonObjectF = jsonElement.f();
                if (jsonObjectF.f45256a.containsKey("fraudChecks")) {
                    JsonElement jsonElementK = jsonObjectF.k("fraudChecks");
                    jsonElementK.getClass();
                    if (jsonElementK instanceof JsonObject) {
                        JsonObject jsonObjectM = jsonObjectF.m("fraudChecks");
                        if (jsonObjectM.f45256a.containsKey("packageNameFilterExclusions")) {
                            JsonElement jsonElementK2 = jsonObjectM.k("packageNameFilterExclusions");
                            jsonElementK2.getClass();
                            if (jsonElementK2 instanceof JsonArray) {
                                JsonArray jsonArray = (JsonArray) jsonObjectM.f45256a.get("packageNameFilterExclusions");
                                Intrinsics.c(jsonArray);
                                ArrayList arrayList2 = new ArrayList();
                                Iterator it = jsonArray.f45254a.iterator();
                                while (it.hasNext()) {
                                    Object next = it.next();
                                    JsonElement jsonElement2 = (JsonElement) next;
                                    jsonElement2.getClass();
                                    if ((jsonElement2 instanceof JsonPrimitive) && (jsonElement2.g().f45257a instanceof String)) {
                                        arrayList2.add(next);
                                    }
                                }
                                ArrayList arrayList3 = new ArrayList(CollectionsKt.r(arrayList2, 10));
                                Iterator it2 = arrayList2.iterator();
                                while (it2.hasNext()) {
                                    arrayList3.add(((JsonElement) it2.next()).g().n());
                                }
                                arrayList.addAll(arrayList3);
                                return arrayList;
                            }
                        }
                    }
                }
                return this.DEFAULT_PACKAGE_NAME_FILTER_EXCLUSIONS;
            }
            return this.DEFAULT_PACKAGE_NAME_FILTER_EXCLUSIONS;
        } catch (Exception e2) {
            Timber.d(TAG).e(e2, b.C("Error reading packageNameFilterExclusions from config: ", e2.getMessage()), new Object[0]);
            return this.DEFAULT_PACKAGE_NAME_FILTER_EXCLUSIONS;
        }
    }

    @ReactMethod
    public final void getInstalledApps(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            List<PackageInfo> installedPackages = getReactApplicationContext().getPackageManager().getInstalledPackages(0);
            Intrinsics.checkNotNullExpressionValue(installedPackages, "getInstalledPackages(...)");
            WritableNativeArray writableNativeArray = new WritableNativeArray();
            for (PackageInfo packageInfo : installedPackages) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if (applicationInfo == null || (applicationInfo.flags & 1) == 0 || Intrinsics.b(packageInfo.packageName, this.PLAY_STORE_PACKAGE)) {
                    writableNativeMap.putString("packageName", packageInfo.packageName);
                    writableNativeMap.putDouble("firstInstallTime", packageInfo.firstInstallTime);
                    if ((applicationInfo != null ? applicationInfo.sourceDir : null) != null) {
                        String sourceDir = applicationInfo.sourceDir;
                        Intrinsics.checkNotNullExpressionValue(sourceDir, "sourceDir");
                        writableNativeMap.putString("sourceDir", StringsKt.W(12, sourceDir));
                    }
                    writableNativeArray.pushMap(writableNativeMap);
                }
            }
            promise.resolve(writableNativeArray);
        } catch (Exception e2) {
            promise.reject(MerchantConstants.ERROR, e2.getMessage(), e2);
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return TAG;
    }

    @ReactMethod
    public final void getNonSystemAppMinInstallData(@NotNull Promise promise) {
        String str;
        Object next;
        long j2;
        String str2;
        String installerPackageName;
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            PackageManager packageManager = getReactApplicationContext().getPackageManager();
            List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
            Intrinsics.checkNotNullExpressionValue(installedPackages, "getInstalledPackages(...)");
            Iterator<T> it = installedPackages.iterator();
            while (true) {
                str = null;
                if (it.hasNext()) {
                    next = it.next();
                    if (Intrinsics.b(((PackageInfo) next).packageName, this.PLAY_STORE_PACKAGE)) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            PackageInfo packageInfo = (PackageInfo) next;
            long j3 = 0;
            long j4 = packageInfo != null ? packageInfo.firstInstallTime : 0L;
            ArrayList arrayList = new ArrayList();
            for (PackageInfo packageInfo2 : installedPackages) {
                ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
                if (applicationInfo != null && (1 & applicationInfo.flags) == 0) {
                    try {
                        installerPackageName = packageManager.getInstallerPackageName(packageInfo2.packageName);
                    } catch (Exception unused) {
                        installerPackageName = null;
                    }
                    if (Intrinsics.b(installerPackageName, this.PLAY_STORE_PACKAGE) && (j4 <= 0 || Math.abs(packageInfo2.firstInstallTime - j4) >= this.TWENTY_FOUR_HOURS_MS)) {
                        arrayList.add(packageInfo2);
                    }
                }
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            long j5 = Long.MAX_VALUE;
            if (arrayList.isEmpty()) {
                j2 = Long.MAX_VALUE;
                str2 = null;
            } else {
                if (arrayList.size() > 1) {
                    CollectionsKt.W(arrayList, new Comparator() { // from class: com.zeptoconsumerapp.DeviceIntelligence.DeviceIntelligenceModule$getNonSystemAppMinInstallData$$inlined$sortBy$1
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            return ComparisonsKt.a(Long.valueOf(((PackageInfo) obj).firstInstallTime), Long.valueOf(((PackageInfo) obj2).firstInstallTime));
                        }
                    });
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt.r(arrayList, 10));
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(Double.valueOf(((PackageInfo) it2.next()).firstInstallTime));
                }
                double dCalculatePercentile = calculatePercentile(arrayList2, 0.25d);
                double dCalculatePercentile2 = calculatePercentile(arrayList2, 0.75d);
                double d2 = (dCalculatePercentile2 - dCalculatePercentile) * 1.5d;
                double d3 = dCalculatePercentile - d2;
                double d4 = dCalculatePercentile2 + d2;
                Iterator it3 = arrayList.iterator();
                j2 = Long.MAX_VALUE;
                str2 = null;
                while (it3.hasNext()) {
                    long j6 = j3;
                    PackageInfo packageInfo3 = (PackageInfo) it3.next();
                    Iterator it4 = it3;
                    long j7 = j5;
                    long j8 = packageInfo3.firstInstallTime;
                    String str3 = str;
                    double d5 = j8;
                    if (d5 < d3 || d5 > d4) {
                        it3 = it4;
                        str = str3;
                    } else {
                        if (j8 < j7) {
                            j7 = j8;
                            str = packageInfo3.packageName;
                        } else {
                            str = str3;
                        }
                        long j9 = packageInfo3.lastUpdateTime;
                        if (j9 < j2 && j9 != j6) {
                            str2 = packageInfo3.packageName;
                            j2 = j9;
                        }
                        it3 = it4;
                    }
                    j3 = j6;
                    j5 = j7;
                }
            }
            if (str != null) {
                writableNativeMap.putDouble("minInstallTime", j5);
                writableNativeMap.putString("minInstallTimePackageName", str);
            }
            if (str2 != null) {
                writableNativeMap.putDouble("minLastUpdateTime", j2);
                writableNativeMap.putString("minLastUpdateTimePackageName", str2);
            }
            promise.resolve(writableNativeMap);
        } catch (Exception e2) {
            promise.reject(MerchantConstants.ERROR, e2.getMessage(), e2);
        }
    }

    @ReactMethod
    public final void isVpnActive(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Object systemService = getReactApplicationContext().getSystemService("connectivity");
            ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
            if (connectivityManager == null) {
                promise.resolve(Boolean.FALSE);
            } else {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                promise.resolve(Boolean.valueOf(networkCapabilities != null ? networkCapabilities.hasTransport(4) : false));
            }
        } catch (Exception e2) {
            promise.reject("VPN_DETECTION_FAILED", e2);
        }
    }
}
