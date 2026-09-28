package com.google.android.gms.internal.ads;

import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzfjm {
    public static com.google.android.gms.ads.internal.client.zze a(Throwable th) {
        if (th instanceof zzejk) {
            zzejk zzejkVar = (zzejk) th;
            return c(zzejkVar.f29026a, zzejkVar.f29465b);
        }
        if (th instanceof zzebr) {
            return th.getMessage() == null ? d(((zzebr) th).f29026a, null, null) : d(((zzebr) th).f29026a, th.getMessage(), null);
        }
        if (!(th instanceof com.google.android.gms.ads.internal.util.zzaz)) {
            return d(1, null, null);
        }
        com.google.android.gms.ads.internal.util.zzaz zzazVar = (com.google.android.gms.ads.internal.util.zzaz) th;
        int i2 = zzazVar.f21513a;
        String message = zzazVar.getMessage();
        if (message == null) {
            message = "";
        }
        return new com.google.android.gms.ads.internal.client.zze(i2, message, "com.google.android.gms.ads", null, null);
    }

    public static com.google.android.gms.ads.internal.client.zze b(Throwable th, zzejl zzejlVar) {
        com.google.android.gms.ads.internal.client.zze zzeVar;
        com.google.android.gms.ads.internal.client.zze zzeVarA = a(th);
        int i2 = zzeVarA.f21161a;
        if ((i2 == 3 || i2 == 0) && (zzeVar = zzeVarA.f21164d) != null && !zzeVar.f21163c.equals("com.google.android.gms.ads")) {
            zzeVarA.f21164d = null;
        }
        if (zzejlVar != null) {
            zzeVarA.f21165e = new zzdad(zzejlVar.f29470e, "", zzejlVar, zzejlVar.f29469d, zzejlVar.f29468c);
        }
        return zzeVarA;
    }

    public static com.google.android.gms.ads.internal.client.zze c(int i2, com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (i2 == 0) {
            throw null;
        }
        if (i2 == 8) {
            if (((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.m9)).intValue() > 0) {
                return zzeVar;
            }
            i2 = 8;
        }
        return d(i2, null, zzeVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static com.google.android.gms.ads.internal.client.zze d(int i2, String str, com.google.android.gms.ads.internal.client.zze zzeVar) {
        String str2;
        int i3 = i2 - 1;
        if (str == null) {
            if (i2 == 0) {
                throw null;
            }
            str = "No fill.";
            switch (i3) {
                case 1:
                    str = "Invalid request.";
                    break;
                case 2:
                    break;
                case 3:
                    str = "App ID missing.";
                    break;
                case 4:
                    str = "Network error.";
                    break;
                case 5:
                    str = "Invalid request: Invalid ad unit ID.";
                    break;
                case 6:
                    str = "Invalid request: Invalid ad size.";
                    break;
                case 7:
                    str = "A mediation adapter failed to show the ad.";
                    break;
                case 8:
                    str = "The ad is not ready.";
                    break;
                case 9:
                    str = "The ad has already been shown.";
                    break;
                case 10:
                    str = "The ad can not be shown when app is not in foreground.";
                    break;
                case 11:
                default:
                    str = "Internal error.";
                    break;
                case 12:
                    if (((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.p9)).intValue() <= 0) {
                        str = "The mediation adapter did not return an ad.";
                        break;
                    }
                    break;
                case 13:
                    str = "Mismatch request IDs.";
                    break;
                case 14:
                    str = "Invalid ad string.";
                    break;
                case 15:
                    str = "Ad inspector had an internal error.";
                    break;
                case 16:
                    str = "Ad inspector failed to load.";
                    break;
                case 17:
                    str = "Ad inspector cannot be opened because the device is not in test mode. See https://developers.google.com/admob/android/test-ads#enable_test_devices for more information.";
                    break;
                case 18:
                    str = "Ad inspector cannot be opened because it is already open.";
                    break;
            }
        }
        String str3 = str;
        if (i2 == 0) {
            throw null;
        }
        int i4 = 0;
        int i5 = 2;
        switch (i3) {
            case 0:
            case 11:
            case 15:
                i5 = i4;
                return new com.google.android.gms.ads.internal.client.zze(i5, str3, "com.google.android.gms.ads", zzeVar, null);
            case 1:
            case 5:
            case 6:
            case 9:
            case 16:
                i5 = 1;
                return new com.google.android.gms.ads.internal.client.zze(i5, str3, "com.google.android.gms.ads", zzeVar, null);
            case 2:
            case 10:
            case 18:
                i5 = 3;
                return new com.google.android.gms.ads.internal.client.zze(i5, str3, "com.google.android.gms.ads", zzeVar, null);
            case 3:
                i4 = 8;
                i5 = i4;
                return new com.google.android.gms.ads.internal.client.zze(i5, str3, "com.google.android.gms.ads", zzeVar, null);
            case 4:
            case 8:
            case 17:
                return new com.google.android.gms.ads.internal.client.zze(i5, str3, "com.google.android.gms.ads", zzeVar, null);
            case 7:
                i4 = 4;
                i5 = i4;
                return new com.google.android.gms.ads.internal.client.zze(i5, str3, "com.google.android.gms.ads", zzeVar, null);
            case 12:
                if (((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.p9)).intValue() <= 0) {
                    i4 = 9;
                    i5 = i4;
                    return new com.google.android.gms.ads.internal.client.zze(i5, str3, "com.google.android.gms.ads", zzeVar, null);
                }
                i5 = 3;
                return new com.google.android.gms.ads.internal.client.zze(i5, str3, "com.google.android.gms.ads", zzeVar, null);
            case 13:
                i4 = 10;
                i5 = i4;
                return new com.google.android.gms.ads.internal.client.zze(i5, str3, "com.google.android.gms.ads", zzeVar, null);
            case 14:
                i4 = 11;
                i5 = i4;
                return new com.google.android.gms.ads.internal.client.zze(i5, str3, "com.google.android.gms.ads", zzeVar, null);
            default:
                switch (i2) {
                    case 1:
                        str2 = "INTERNAL_ERROR";
                        break;
                    case 2:
                        str2 = CLConstants.ERROR_INVALID_REQUEST;
                        break;
                    case 3:
                        str2 = "NO_FILL";
                        break;
                    case 4:
                        str2 = "APP_ID_MISSING";
                        break;
                    case 5:
                        str2 = "NETWORK_ERROR";
                        break;
                    case 6:
                        str2 = "INVALID_AD_UNIT_ID";
                        break;
                    case 7:
                        str2 = "INVALID_AD_SIZE";
                        break;
                    case 8:
                        str2 = "MEDIATION_SHOW_ERROR";
                        break;
                    case 9:
                        str2 = "NOT_READY";
                        break;
                    case 10:
                        str2 = "AD_REUSED";
                        break;
                    case 11:
                        str2 = "APP_NOT_FOREGROUND";
                        break;
                    case 12:
                        str2 = "INTERNAL_SHOW_ERROR";
                        break;
                    case 13:
                        str2 = "MEDIATION_NO_FILL";
                        break;
                    case 14:
                        str2 = "REQUEST_ID_MISMATCH";
                        break;
                    case 15:
                        str2 = "INVALID_AD_STRING";
                        break;
                    case 16:
                        str2 = "AD_INSPECTOR_INTERNAL_ERROR";
                        break;
                    case 17:
                        str2 = "AD_INSPECTOR_FAILED_TO_LOAD";
                        break;
                    case 18:
                        str2 = "AD_INSPECTOR_NOT_IN_TEST_MODE";
                        break;
                    default:
                        str2 = "AD_INSPECTOR_ALREADY_OPEN";
                        break;
                }
                throw new AssertionError("Unknown SdkError: ".concat(str2));
        }
    }
}
