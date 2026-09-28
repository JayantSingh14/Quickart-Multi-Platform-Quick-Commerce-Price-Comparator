package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes.dex */
public final class AFf1tSDK extends AFf1rSDK {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int AFKeystoreWrapper = 1;
    private static int AFLogger;
    private final AFg1qSDK AFInAppEventType;
    private final AFc1pSDK copydefault;
    private final String equals;
    private final AFc1iSDK hashCode;
    private static char[] AFInAppEventParameterName = {10790, 10789, 10800, 10806, 10786, 10791, 10805, 10788, 10810};
    private static char registerClient = 8141;

    public AFf1tSDK(@NonNull String str, @NonNull AFc1dSDK aFc1dSDK) {
        super(new AFg1wSDK(), aFc1dSDK, str);
        this.copydefault = aFc1dSDK.getRevenue();
        this.hashCode = aFc1dSDK.AFInAppEventType();
        this.equals = str;
        this.AFInAppEventType = aFc1dSDK.component3();
    }

    public static /* synthetic */ Object AFAdRevenueData(Object[] objArr, int i2, int i3, int i4) {
        return getRevenue(objArr);
    }

    private static void a(byte b2, String str, int i2, Object[] objArr) {
        int i3;
        char[] charArray = str != null ? str.toCharArray() : str;
        AFk1mSDK aFk1mSDK = new AFk1mSDK();
        char[] cArr = AFInAppEventParameterName;
        if (cArr != null) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            for (int i4 = 0; i4 < length; i4++) {
                cArr2[i4] = (char) (cArr[i4] ^ (-374623853307093042L));
            }
            cArr = cArr2;
        }
        char c2 = (char) ((-374623853307093042L) ^ registerClient);
        char[] cArr3 = new char[i2];
        if (i2 % 2 != 0) {
            int i5 = $10 + 67;
            $11 = i5 % 128;
            if (i5 % 2 == 0) {
                i3 = i2 + WKSRecord.Service.NTP;
                cArr3[i3] = (char) (charArray[i3] - b2);
            } else {
                i3 = i2 - 1;
                cArr3[i3] = (char) (charArray[i3] - b2);
            }
        } else {
            i3 = i2;
        }
        if (i3 > 1) {
            aFk1mSDK.AFAdRevenueData = 0;
            $11 = ($10 + WKSRecord.Service.AUTH) % 128;
            while (true) {
                int i6 = aFk1mSDK.AFAdRevenueData;
                if (i6 >= i3) {
                    break;
                }
                char c3 = charArray[i6];
                aFk1mSDK.getMonetizationNetwork = c3;
                char c4 = charArray[i6 + 1];
                aFk1mSDK.getCurrencyIso4217Code = c4;
                if (c3 == c4) {
                    cArr3[i6] = (char) (c3 - b2);
                    cArr3[i6 + 1] = (char) (c4 - b2);
                } else {
                    int i7 = c3 / c2;
                    aFk1mSDK.getMediationNetwork = i7;
                    int i8 = c3 % c2;
                    aFk1mSDK.component1 = i8;
                    int i9 = c4 / c2;
                    aFk1mSDK.getRevenue = i9;
                    int i10 = c4 % c2;
                    aFk1mSDK.component2 = i10;
                    if (i8 == i10) {
                        $11 = ($10 + 83) % 128;
                        int i11 = ((i7 + c2) - 1) % c2;
                        aFk1mSDK.getMediationNetwork = i11;
                        int i12 = ((i9 + c2) - 1) % c2;
                        aFk1mSDK.getRevenue = i12;
                        cArr3[i6] = cArr[(i11 * c2) + i8];
                        cArr3[i6 + 1] = cArr[(i12 * c2) + i10];
                    } else if (i7 == i9) {
                        int i13 = ((i8 + c2) - 1) % c2;
                        aFk1mSDK.component1 = i13;
                        int i14 = ((i10 + c2) - 1) % c2;
                        aFk1mSDK.component2 = i14;
                        cArr3[i6] = cArr[(i7 * c2) + i13];
                        cArr3[i6 + 1] = cArr[(i9 * c2) + i14];
                        $11 = ($10 + 69) % 128;
                    } else {
                        cArr3[i6] = cArr[(i7 * c2) + i10];
                        cArr3[i6 + 1] = cArr[(i9 * c2) + i8];
                    }
                }
                aFk1mSDK.AFAdRevenueData = i6 + 2;
            }
        }
        $10 = ($11 + 33) % 128;
        int i15 = 0;
        while (i15 < i2) {
            int i16 = $11 + 67;
            $10 = i16 % 128;
            if (i16 % 2 != 0) {
                cArr3[i15] = (char) (cArr3[i15] ^ 31812);
                i15 += 84;
            } else {
                cArr3[i15] = (char) (cArr3[i15] ^ 13722);
                i15++;
            }
        }
        objArr[0] = new String(cArr3);
    }

    private void copy() {
        AFc1qSDK aFc1qSDK;
        boolean z;
        int i2 = AFLogger + 101;
        AFKeystoreWrapper = i2 % 128;
        if (i2 % 2 == 0) {
            aFc1qSDK = this.copy;
            z = false;
        } else {
            aFc1qSDK = this.copy;
            z = true;
        }
        aFc1qSDK.getCurrencyIso4217Code("sentRegisterRequestToAF", z);
        AFLogger.afDebugLog("[register] Successfully registered for Uninstall Tracking");
        AFLogger = (AFKeystoreWrapper + 81) % 128;
    }

    @Override // com.appsflyer.internal.AFf1rSDK
    public final void component3(AFh1rSDK aFh1rSDK) {
        int i2 = AFKeystoreWrapper + WKSRecord.Service.SUNRPC;
        AFLogger = i2 % 128;
        if (i2 % 2 != 0) {
            this.copydefault.AFAdRevenueData();
            throw null;
        }
        String strAFAdRevenueData = this.copydefault.AFAdRevenueData();
        if (strAFAdRevenueData != null) {
            AFLogger = (AFKeystoreWrapper + 103) % 128;
            aFh1rSDK.getMediationNetwork("advertiserId", strAFAdRevenueData);
        }
    }

    @Override // com.appsflyer.internal.AFf1rSDK, com.appsflyer.internal.AFe1dSDK
    public final boolean copydefault() {
        int i2 = AFKeystoreWrapper + 95;
        int i3 = i2 % 128;
        AFLogger = i3;
        boolean z = !(i2 % 2 == 0);
        int i4 = i3 + 73;
        AFKeystoreWrapper = i4 % 128;
        if (i4 % 2 != 0) {
            return z;
        }
        throw null;
    }

    @Override // com.appsflyer.internal.AFf1rSDK
    public final void getCurrencyIso4217Code(AFh1rSDK aFh1rSDK) {
        AFLogger = (AFKeystoreWrapper + 1) % 128;
    }

    @Override // com.appsflyer.internal.AFf1rSDK
    public final void getMediationNetwork(AFh1rSDK aFh1rSDK) {
        AFKeystoreWrapper = (AFLogger + 103) % 128;
    }

    @Override // com.appsflyer.internal.AFf1rSDK
    public final void getMonetizationNetwork(AFh1rSDK aFh1rSDK) {
        int i2 = AFLogger + 21;
        AFKeystoreWrapper = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    @Override // com.appsflyer.internal.AFe1dSDK, com.appsflyer.internal.AFe1sSDK
    public final void getRevenue() {
        super.getRevenue();
        ResponseNetwork responseNetwork = ((AFe1dSDK) this).component1;
        if (responseNetwork != null) {
            AFKeystoreWrapper = (AFLogger + 11) % 128;
            if (responseNetwork.isSuccessful()) {
                int i2 = AFLogger + WKSRecord.Service.UUCP_PATH;
                AFKeystoreWrapper = i2 % 128;
                if (i2 % 2 != 0) {
                    copy();
                } else {
                    copy();
                    throw null;
                }
            }
        }
    }

    @Override // com.appsflyer.internal.AFf1rSDK
    public final void AFAdRevenueData(AFh1rSDK aFh1rSDK) {
        int i2 = AFKeystoreWrapper + 57;
        AFLogger = i2 % 128;
        if (i2 % 2 != 0) {
            super.AFAdRevenueData(aFh1rSDK);
            Context context = this.hashCode.getMonetizationNetwork;
            throw null;
        }
        super.AFAdRevenueData(aFh1rSDK);
        Context context2 = this.hashCode.getMonetizationNetwork;
        AFa1tSDK aFa1tSDK = (AFa1tSDK) AFa1tSDK.getMonetizationNetwork(new Object[0], -631580017, 631580017, (int) System.currentTimeMillis());
        if (context2 == null) {
            throw new IllegalStateException("Context is not provided, can't send register request");
        }
        if (aFa1tSDK.getMediationNetwork()) {
            AFLogger.afInfoLog("CustomerUserId not set, Tracking is disabled", true);
            throw new IllegalStateException("CustomerUserId not set, register is not sent");
        }
        PackageManager packageManager = context2.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context2.getPackageName(), 0);
            aFh1rSDK.getMediationNetwork("app_version_code", Integer.toString(packageInfo.versionCode));
            aFh1rSDK.getMediationNetwork("app_version_name", packageInfo.versionName);
            aFh1rSDK.getMediationNetwork("app_name", packageManager.getApplicationLabel(packageInfo.applicationInfo).toString());
            aFh1rSDK.getMediationNetwork("installDate", AFa1tSDK.getRevenue(new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US), packageInfo.firstInstallTime));
            AFKeystoreWrapper = (AFLogger + 37) % 128;
        } catch (Throwable th) {
            AFLogger.afErrorLog("Exception while collecting application version info.", th);
        }
        this.AFInAppEventType.AFAdRevenueData(aFh1rSDK.AFAdRevenueData);
        aFh1rSDK.AFAdRevenueData.remove("ivc");
        String revenue = AFa1tSDK.getRevenue();
        if (revenue != null) {
            aFh1rSDK.getMediationNetwork("appUserId", revenue);
        }
        try {
            aFh1rSDK.getMediationNetwork("model", Build.MODEL);
            Object[] objArr = new Object[1];
            a((byte) (124 - TextUtils.lastIndexOf("", '0', 0)), "\u0006\u0003\u0007\u0006㙻", 5 - TextUtils.indexOf("", "", 0), objArr);
            aFh1rSDK.getMediationNetwork(((String) objArr[0]).intern(), Build.BRAND);
        } catch (Throwable th2) {
            AFLogger.afErrorLog("Exception while collecting device brand and model.", th2);
        }
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
            int i3 = AFKeystoreWrapper + 75;
            AFLogger = i3 % 128;
            if (i3 % 2 != 0) {
                aFh1rSDK.getMediationNetwork(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, "true");
                int i4 = 86 / 0;
            } else {
                aFh1rSDK.getMediationNetwork(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, "true");
            }
        }
        AFb1mSDK aFb1mSDKK_ = AFb1jSDK.k_(context2.getContentResolver());
        if (aFb1mSDKK_ != null) {
            int i5 = AFLogger + WKSRecord.Service.AUTH;
            AFKeystoreWrapper = i5 % 128;
            if (i5 % 2 == 0) {
                aFh1rSDK.getMediationNetwork("amazon_aid", aFb1mSDKK_.getMonetizationNetwork);
                aFh1rSDK.getMediationNetwork("amazon_aid_limit", String.valueOf(aFb1mSDKK_.getMediationNetwork));
                throw null;
            }
            aFh1rSDK.getMediationNetwork("amazon_aid", aFb1mSDKK_.getMonetizationNetwork);
            aFh1rSDK.getMediationNetwork("amazon_aid_limit", String.valueOf(aFb1mSDKK_.getMediationNetwork));
        }
        aFh1rSDK.getMediationNetwork("devkey", ((AFe1dSDK) this).component3.getMediationNetwork());
        aFh1rSDK.getMediationNetwork("uid", AFb1iSDK.getRevenue(this.copydefault.getMonetizationNetwork));
        aFh1rSDK.getMediationNetwork("af_gcm_token", this.equals);
        aFh1rSDK.getMediationNetwork("launch_counter", Integer.toString(this.copy.AFAdRevenueData("appsFlyerCount", 0)));
        aFh1rSDK.getMediationNetwork("sdk", Integer.toString(Build.VERSION.SDK_INT));
        String strComponent2 = this.copydefault.component2();
        if (strComponent2 != null) {
            AFKeystoreWrapper = (AFLogger + 19) % 128;
            aFh1rSDK.getMediationNetwork(AppsFlyerProperties.CHANNEL, strComponent2);
        }
    }

    private static /* synthetic */ Object getRevenue(Object[] objArr) {
        int i2 = AFLogger + 53;
        AFKeystoreWrapper = i2 % 128;
        if (i2 % 2 != 0) {
            return null;
        }
        throw null;
    }

    @Override // com.appsflyer.internal.AFf1rSDK
    public final void getRevenue(AFh1rSDK aFh1rSDK) {
        AFAdRevenueData(new Object[]{this, aFh1rSDK}, 2011239149, -2011239149, System.identityHashCode(this));
    }
}
