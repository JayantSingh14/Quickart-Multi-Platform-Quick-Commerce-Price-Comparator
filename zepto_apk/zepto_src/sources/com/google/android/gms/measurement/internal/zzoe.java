package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

/* loaded from: classes.dex */
public final class zzoe {

    /* renamed from: a, reason: collision with root package name */
    public static final ImmutableList f39541a = ImmutableList.v("Version", "GoogleConsent", "VendorConsent", "VendorLegitimateInterest", "gdprApplies", "EnableAdvertiserConsentMode", "PolicyVersion", "PurposeConsents", "PurposeOneTreatment", "Purpose1", "Purpose3", "Purpose4", "Purpose7", "CmpSdkID", "PublisherCC", "PublisherRestrictions1", "PublisherRestrictions3", "PublisherRestrictions4", "PublisherRestrictions7", "AuthorizePurpose1", "AuthorizePurpose3", "AuthorizePurpose4", "AuthorizePurpose7", "PurposeDiagnostics");

    public static String a(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getString(str, "");
        } catch (ClassCastException unused) {
            return "";
        }
    }

    public static int b(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getInt(str, -1);
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    public static final boolean c(com.google.android.gms.internal.measurement.zzko zzkoVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i2, int i3, int i4, String str, String str2, String str3, boolean z, boolean z2) {
        zzod zzodVar;
        char c2;
        int iD = d(zzkoVar);
        if (iD > 0 && (i3 != 1 || i2 != 1)) {
            cArr[iD] = '2';
        }
        if (h(zzkoVar, immutableMap2) == com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_NOT_ALLOWED) {
            c2 = '3';
        } else {
            if (zzkoVar == com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE && i4 == 1 && immutableSet.contains(str)) {
                if (iD > 0 && cArr[iD] != '2') {
                    cArr[iD] = '1';
                }
                return true;
            }
            if (immutableMap.containsKey(zzkoVar) && (zzodVar = (zzod) immutableMap.get(zzkoVar)) != null) {
                int iOrdinal = zzodVar.ordinal();
                com.google.android.gms.internal.measurement.zzkp zzkpVar = com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST;
                if (iOrdinal != 0) {
                    com.google.android.gms.internal.measurement.zzkp zzkpVar2 = com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_REQUIRE_CONSENT;
                    if (iOrdinal != 1) {
                        if (iOrdinal == 2) {
                            return h(zzkoVar, immutableMap2) == zzkpVar ? g(zzkoVar, cArr, str3, z2) : f(zzkoVar, cArr, str2, z);
                        }
                        if (iOrdinal == 3) {
                            return h(zzkoVar, immutableMap2) == zzkpVar2 ? f(zzkoVar, cArr, str2, z) : g(zzkoVar, cArr, str3, z2);
                        }
                        c2 = '0';
                    } else if (h(zzkoVar, immutableMap2) != zzkpVar2) {
                        return g(zzkoVar, cArr, str3, z2);
                    }
                } else if (h(zzkoVar, immutableMap2) != zzkpVar) {
                    return f(zzkoVar, cArr, str2, z);
                }
                c2 = '8';
            } else {
                c2 = '0';
            }
        }
        if (iD <= 0 || cArr[iD] == '2') {
            return false;
        }
        cArr[iD] = c2;
        return false;
    }

    public static final int d(com.google.android.gms.internal.measurement.zzko zzkoVar) {
        if (zzkoVar == com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
            return 1;
        }
        if (zzkoVar == com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE) {
            return 2;
        }
        if (zzkoVar == com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS) {
            return 3;
        }
        return zzkoVar == com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE ? 4 : -1;
    }

    public static final String e(com.google.android.gms.internal.measurement.zzko zzkoVar, String str, String str2) {
        String strValueOf = "0";
        String strValueOf2 = (TextUtils.isEmpty(str) || str.length() < zzkoVar.zza()) ? "0" : String.valueOf(str.charAt(zzkoVar.zza() - 1));
        if (!TextUtils.isEmpty(str2) && str2.length() >= zzkoVar.zza()) {
            strValueOf = String.valueOf(str2.charAt(zzkoVar.zza() - 1));
        }
        return String.valueOf(strValueOf2).concat(String.valueOf(strValueOf));
    }

    public static final boolean f(com.google.android.gms.internal.measurement.zzko zzkoVar, char[] cArr, String str, boolean z) {
        char c2;
        int iD = d(zzkoVar);
        if (!z) {
            c2 = '4';
        } else {
            if (str.length() >= zzkoVar.zza()) {
                char cCharAt = str.charAt(zzkoVar.zza() - 1);
                boolean z2 = cCharAt == '1';
                if (iD > 0 && cArr[iD] != '2') {
                    cArr[iD] = cCharAt != '1' ? '6' : '1';
                }
                return z2;
            }
            c2 = '0';
        }
        if (iD > 0 && cArr[iD] != '2') {
            cArr[iD] = c2;
        }
        return false;
    }

    public static final boolean g(com.google.android.gms.internal.measurement.zzko zzkoVar, char[] cArr, String str, boolean z) {
        char c2;
        int iD = d(zzkoVar);
        if (!z) {
            c2 = '5';
        } else {
            if (str.length() >= zzkoVar.zza()) {
                char cCharAt = str.charAt(zzkoVar.zza() - 1);
                boolean z2 = cCharAt == '1';
                if (iD > 0 && cArr[iD] != '2') {
                    cArr[iD] = cCharAt != '1' ? '7' : '1';
                }
                return z2;
            }
            c2 = '0';
        }
        if (iD > 0 && cArr[iD] != '2') {
            cArr[iD] = c2;
        }
        return false;
    }

    public static final com.google.android.gms.internal.measurement.zzkp h(com.google.android.gms.internal.measurement.zzko zzkoVar, ImmutableMap immutableMap) {
        Object obj = com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_UNDEFINED;
        Object obj2 = immutableMap.get(zzkoVar);
        if (obj2 != null) {
            obj = obj2;
        }
        return (com.google.android.gms.internal.measurement.zzkp) obj;
    }
}
