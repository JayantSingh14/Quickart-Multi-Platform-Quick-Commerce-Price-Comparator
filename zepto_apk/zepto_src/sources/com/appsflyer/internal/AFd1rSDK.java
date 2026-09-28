package com.appsflyer.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class AFd1rSDK {
    @NotNull
    public static final String AFAdRevenueData(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return "[Exception Manager]: " + str;
    }

    public static final String getCurrencyIso4217Code(String str, String str2) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str2);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        byte[] bArrDigest = messageDigest.digest(bytes);
        Intrinsics.checkNotNullExpressionValue(bArrDigest, "");
        String strK = "";
        for (byte b2 : bArrDigest) {
            String str3 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b2)}, 1));
            Intrinsics.checkNotNullExpressionValue(str3, "");
            strK = android.support.v4.media.b.k(strK, str3);
        }
        return strK;
    }

    @Nullable
    public static final Pair<Integer, Integer> getMediationNetwork(@NotNull String str) {
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(str, "");
        MatchResult matchResultB = new Regex("^(\\d+).(\\+)$|^(\\d+).(\\d+).(\\+)$").b(str);
        if (matchResultB != null) {
            MatchGroup matchGroupD = matchResultB.c().d(1);
            Integer intOrNull = (matchGroupD == null || (str4 = matchGroupD.f53983a) == null) ? null : StringsKt.toIntOrNull(str4);
            MatchGroup matchGroupD2 = matchResultB.c().d(3);
            Integer intOrNull2 = (matchGroupD2 == null || (str3 = matchGroupD2.f53983a) == null) ? null : StringsKt.toIntOrNull(str3);
            MatchGroup matchGroupD3 = matchResultB.c().d(4);
            Integer intOrNull3 = (matchGroupD3 == null || (str2 = matchGroupD3.f53983a) == null) ? null : StringsKt.toIntOrNull(str2);
            if (intOrNull != null) {
                return new Pair<>(Integer.valueOf(intOrNull.intValue() * 1000000), Integer.valueOf(((intOrNull.intValue() + 1) * 1000000) - 1));
            }
            if (intOrNull2 != null && intOrNull3 != null) {
                return new Pair<>(Integer.valueOf((intOrNull3.intValue() * 1000) + (intOrNull2.intValue() * 1000000)), Integer.valueOf((((intOrNull3.intValue() + 1) * 1000) + (intOrNull2.intValue() * 1000000)) - 1));
            }
        }
        return null;
    }

    @Nullable
    public static final Pair<Integer, Integer> getRevenue(@NotNull String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Intrinsics.checkNotNullParameter(str, "");
        MatchResult matchResultB = new Regex("(\\d+).(\\d+).(\\d+)-(\\d+).(\\d+).(\\d+)").b(str);
        if (matchResultB != null) {
            MatchGroup matchGroupD = matchResultB.c().d(1);
            Integer intOrNull = (matchGroupD == null || (str7 = matchGroupD.f53983a) == null) ? null : StringsKt.toIntOrNull(str7);
            MatchGroup matchGroupD2 = matchResultB.c().d(2);
            Integer intOrNull2 = (matchGroupD2 == null || (str6 = matchGroupD2.f53983a) == null) ? null : StringsKt.toIntOrNull(str6);
            MatchGroup matchGroupD3 = matchResultB.c().d(3);
            Integer intOrNull3 = (matchGroupD3 == null || (str5 = matchGroupD3.f53983a) == null) ? null : StringsKt.toIntOrNull(str5);
            MatchGroup matchGroupD4 = matchResultB.c().d(4);
            Integer intOrNull4 = (matchGroupD4 == null || (str4 = matchGroupD4.f53983a) == null) ? null : StringsKt.toIntOrNull(str4);
            MatchGroup matchGroupD5 = matchResultB.c().d(5);
            Integer intOrNull5 = (matchGroupD5 == null || (str3 = matchGroupD5.f53983a) == null) ? null : StringsKt.toIntOrNull(str3);
            MatchGroup matchGroupD6 = matchResultB.c().d(6);
            Integer intOrNull6 = (matchGroupD6 == null || (str2 = matchGroupD6.f53983a) == null) ? null : StringsKt.toIntOrNull(str2);
            Integer num = intOrNull6;
            if (getRevenue(intOrNull, intOrNull2, intOrNull3, intOrNull4, intOrNull5, intOrNull6)) {
                Intrinsics.c(intOrNull);
                int iIntValue = intOrNull.intValue() * 1000000;
                Intrinsics.c(intOrNull2);
                int iIntValue2 = (intOrNull2.intValue() * 1000) + iIntValue;
                Intrinsics.c(intOrNull3);
                Integer numValueOf = Integer.valueOf(intOrNull3.intValue() + iIntValue2);
                Intrinsics.c(intOrNull4);
                int iIntValue3 = intOrNull4.intValue() * 1000000;
                Intrinsics.c(intOrNull5);
                int iIntValue4 = (intOrNull5.intValue() * 1000) + iIntValue3;
                Intrinsics.c(num);
                return new Pair<>(numValueOf, Integer.valueOf(num.intValue() + iIntValue4));
            }
        }
        return null;
    }

    private static boolean getRevenue(@NotNull Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "");
        return !ArraysKt.h(objArr, null);
    }
}
