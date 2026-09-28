package com.appsflyer.internal;

import android.media.AudioTrack;
import android.view.View;
import com.appsflyer.AFLogger;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.xbill.DNS.WKSRecord;

@Metadata
/* loaded from: classes3.dex */
public final class AFf1wSDK extends AFf1uSDK {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int AFKeystoreWrapper = 1;
    private static int registerClient;

    @NotNull
    private final AFc1pSDK equals;

    @NotNull
    private final AFi1fSDK hashCode;
    private static char[] AFInAppEventParameterName = {10791, 10809, 10763, 10805, 10784, 10788, 10801, 10813, 10802};
    private static char AFLogger = 8141;

    public /* synthetic */ AFf1wSDK(AFi1fSDK aFi1fSDK, AFc1pSDK aFc1pSDK, AFc1dSDK aFc1dSDK, AFh1eSDK aFh1eSDK, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(aFi1fSDK, aFc1pSDK, aFc1dSDK, (i2 & 8) != 0 ? new AFh1eSDK() : aFh1eSDK);
    }

    private static void a(byte b2, String str, int i2, Object[] objArr) {
        int i3;
        char[] charArray = str != null ? str.toCharArray() : str;
        AFk1mSDK aFk1mSDK = new AFk1mSDK();
        char[] cArr = AFInAppEventParameterName;
        if (cArr != null) {
            $11 = ($10 + WKSRecord.Service.ERPC) % 128;
            int length = cArr.length;
            char[] cArr2 = new char[length];
            for (int i4 = 0; i4 < length; i4++) {
                cArr2[i4] = (char) (cArr[i4] ^ (-374623853307093042L));
            }
            cArr = cArr2;
        }
        char c2 = (char) ((-374623853307093042L) ^ AFLogger);
        char[] cArr3 = new char[i2];
        if (i2 % 2 != 0) {
            $10 = ($11 + 109) % 128;
            i3 = i2 - 1;
            cArr3[i3] = (char) (charArray[i3] - b2);
        } else {
            i3 = i2;
        }
        if (i3 > 1) {
            int i5 = $11 + 67;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            aFk1mSDK.AFAdRevenueData = 0;
            while (true) {
                int i7 = aFk1mSDK.AFAdRevenueData;
                if (i7 >= i3) {
                    break;
                }
                int i8 = $11;
                int i9 = (i8 + 57) % 128;
                $10 = i9;
                char c3 = charArray[i7];
                aFk1mSDK.getMonetizationNetwork = c3;
                char c4 = charArray[i7 + 1];
                aFk1mSDK.getCurrencyIso4217Code = c4;
                if (c3 == c4) {
                    int i10 = i8 + 81;
                    $10 = i10 % 128;
                    if (i10 % 2 != 0) {
                        cArr3[i7] = (char) (c3 >>> b2);
                        cArr3[i7 >> 1] = (char) (c4 << b2);
                    } else {
                        cArr3[i7] = (char) (c3 - b2);
                        cArr3[i7 + 1] = (char) (c4 - b2);
                    }
                } else {
                    int i11 = c3 / c2;
                    aFk1mSDK.getMediationNetwork = i11;
                    int i12 = c3 % c2;
                    aFk1mSDK.component1 = i12;
                    int i13 = c4 / c2;
                    aFk1mSDK.getRevenue = i13;
                    int i14 = c4 % c2;
                    aFk1mSDK.component2 = i14;
                    if (i12 == i14) {
                        int i15 = (i9 + 3) % 128;
                        $11 = i15;
                        int i16 = ((i11 + c2) - 1) % c2;
                        aFk1mSDK.getMediationNetwork = i16;
                        int i17 = ((i13 + c2) - 1) % c2;
                        aFk1mSDK.getRevenue = i17;
                        cArr3[i7] = cArr[(i16 * c2) + i12];
                        cArr3[i7 + 1] = cArr[(i17 * c2) + i14];
                        $10 = (i15 + 19) % 128;
                    } else if (i11 == i13) {
                        int i18 = ((i12 + c2) - 1) % c2;
                        aFk1mSDK.component1 = i18;
                        int i19 = ((i14 + c2) - 1) % c2;
                        aFk1mSDK.component2 = i19;
                        cArr3[i7] = cArr[(i11 * c2) + i18];
                        cArr3[i7 + 1] = cArr[(i13 * c2) + i19];
                    } else {
                        cArr3[i7] = cArr[(i11 * c2) + i14];
                        cArr3[i7 + 1] = cArr[(i13 * c2) + i12];
                    }
                }
                aFk1mSDK.AFAdRevenueData = i7 + 2;
            }
        }
        for (int i20 = 0; i20 < i2; i20++) {
            cArr3[i20] = (char) (cArr3[i20] ^ 13722);
        }
        objArr[0] = new String(cArr3);
    }

    private final void areAllFieldsValid(AFh1rSDK aFh1rSDK) {
        try {
            Map<String, ?> map = (Map) getRevenue(new Object[]{this}, -846475554, 846475554, System.identityHashCode(this));
            if (map != null) {
                int i2 = AFKeystoreWrapper + 97;
                registerClient = i2 % 128;
                if (i2 % 2 != 0) {
                    aFh1rSDK.getMediationNetwork(map);
                    throw null;
                }
                aFh1rSDK.getMediationNetwork(map);
            }
            if (this.hashCode.AFAdRevenueData()) {
                return;
            }
            registerClient = (AFKeystoreWrapper + 3) % 128;
            Map<String, Object> mapComponent1 = AFf1rSDK.component1(aFh1rSDK);
            Intrinsics.checkNotNullExpressionValue(mapComponent1, "");
            mapComponent1.put("pia_disabled", Boolean.TRUE);
        } catch (Throwable th) {
            AFg1gSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.PLAY_INTEGRITY_API, "Error while adding PIA data to payload", th, true, false, false, false, 96, null);
        }
    }

    private final Map<String, Object> copy() {
        return (Map) getRevenue(new Object[]{this}, -846475554, 846475554, System.identityHashCode(this));
    }

    private static /* synthetic */ Object getCurrencyIso4217Code(Object[] objArr) {
        AFf1wSDK aFf1wSDK = (AFf1wSDK) objArr[0];
        registerClient = (AFKeystoreWrapper + 75) % 128;
        AFi1hSDK currencyIso4217Code = aFf1wSDK.hashCode.getCurrencyIso4217Code();
        if (currencyIso4217Code == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("pia_timestamp", Long.valueOf(currencyIso4217Code.AFAdRevenueData));
        linkedHashMap2.put("ttr_millis", Long.valueOf(currencyIso4217Code.getRevenue));
        String str = currencyIso4217Code.getCurrencyIso4217Code;
        if (str != null) {
            int i2 = AFKeystoreWrapper + WKSRecord.Service.UUCP_PATH;
            registerClient = i2 % 128;
            if (i2 % 2 != 0) {
                linkedHashMap2.put("pia_token", str);
                throw null;
            }
            linkedHashMap2.put("pia_token", str);
        }
        String str2 = currencyIso4217Code.getMonetizationNetwork;
        if (str2 != null) {
            registerClient = (AFKeystoreWrapper + 55) % 128;
            linkedHashMap2.put("error_code", str2);
            registerClient = (AFKeystoreWrapper + 19) % 128;
        }
        linkedHashMap.put("pia", linkedHashMap2);
        return linkedHashMap;
    }

    public static /* synthetic */ Object getRevenue(Object[] objArr, int i2, int i3, int i4) {
        return getCurrencyIso4217Code(objArr);
    }

    @Override // com.appsflyer.internal.AFf1uSDK
    public final void AFAdRevenueData(int i2) {
        int i3 = registerClient + 69;
        AFKeystoreWrapper = i3 % 128;
        if (i3 % 2 == 0) {
            throw null;
        }
    }

    @Override // com.appsflyer.internal.AFf1rSDK, com.appsflyer.internal.AFe1dSDK
    public final boolean copydefault() {
        int i2 = (registerClient + 31) % 128;
        AFKeystoreWrapper = i2;
        registerClient = (i2 + 67) % 128;
        return false;
    }

    @Override // com.appsflyer.internal.AFf1uSDK, com.appsflyer.internal.AFe1dSDK, com.appsflyer.internal.AFe1sSDK
    public final boolean getMediationNetwork() {
        registerClient = (AFKeystoreWrapper + 97) % 128;
        return false;
    }

    @Override // com.appsflyer.internal.AFe1dSDK, com.appsflyer.internal.AFe1sSDK
    public final long getMonetizationNetwork() {
        AFKeystoreWrapper = (registerClient + 63) % 128;
        long millis = TimeUnit.MINUTES.toMillis(1L);
        AFKeystoreWrapper = (registerClient + 85) % 128;
        return millis;
    }

    @Override // com.appsflyer.internal.AFf1uSDK, com.appsflyer.internal.AFf1rSDK
    public final void AFAdRevenueData(@NotNull AFh1rSDK aFh1rSDK) {
        Intrinsics.checkNotNullParameter(aFh1rSDK, "");
        Map<String, Object> map = aFh1rSDK.AFAdRevenueData;
        Intrinsics.checkNotNullExpressionValue(map, "");
        Object[] objArr = new Object[1];
        a((byte) (View.resolveSize(0, 0) + 107), "\u0005\u0006\u0001\u0005\u0001\u0004\u0000\u0003\u0005\u0004\u0002\u0004", 13 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), objArr);
        map.put(((String) objArr[0]).intern(), String.valueOf(new Date().getTime()));
        super.AFAdRevenueData(aFh1rSDK);
        areAllFieldsValid(aFh1rSDK);
        AFg1qSDK aFg1qSDK = this.toString;
        Map<String, Object> map2 = aFh1rSDK.AFAdRevenueData;
        Intrinsics.checkNotNullExpressionValue(map2, "");
        aFg1qSDK.getRevenue(map2, this.equals.getMonetizationNetwork.AFAdRevenueData("appsFlyerCount", 0), this.equals.getMonetizationNetwork.AFAdRevenueData("appsFlyerInAppEventCount", 0));
        int i2 = registerClient + WKSRecord.Service.SUNRPC;
        AFKeystoreWrapper = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    private AFf1wSDK(@NotNull AFi1fSDK aFi1fSDK, @NotNull AFc1pSDK aFc1pSDK, @NotNull AFc1dSDK aFc1dSDK, @NotNull AFh1eSDK aFh1eSDK) {
        super(aFh1eSDK, aFc1dSDK);
        Intrinsics.checkNotNullParameter(aFi1fSDK, "");
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Intrinsics.checkNotNullParameter(aFc1dSDK, "");
        Intrinsics.checkNotNullParameter(aFh1eSDK, "");
        this.hashCode = aFi1fSDK;
        this.equals = aFc1pSDK;
        this.getCurrencyIso4217Code.add(AFe1mSDK.CONVERSION);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AFf1wSDK(@NotNull AFi1fSDK aFi1fSDK, @NotNull AFc1pSDK aFc1pSDK, @NotNull AFc1dSDK aFc1dSDK) {
        this(aFi1fSDK, aFc1pSDK, aFc1dSDK, null, 8, null);
        Intrinsics.checkNotNullParameter(aFi1fSDK, "");
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Intrinsics.checkNotNullParameter(aFc1dSDK, "");
    }
}
