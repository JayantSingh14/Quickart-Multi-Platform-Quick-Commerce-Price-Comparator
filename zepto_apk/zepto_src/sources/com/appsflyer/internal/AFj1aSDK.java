package com.appsflyer.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension
/* loaded from: classes.dex */
public final class AFj1aSDK {
    public static final String getMonetizationNetwork(String str, String str2) throws NoSuchAlgorithmException {
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

    public static final int getMonetizationNetwork(@NotNull String str) {
        String strA;
        Integer intOrNull;
        String strA2;
        Integer intOrNull2;
        String strA3;
        Integer intOrNull3;
        Intrinsics.checkNotNullParameter(str, "");
        MatchResult matchResultB = new Regex("(\\d+).(\\d+).(\\d+).*").b(str);
        if (matchResultB == null) {
            return -1;
        }
        MatchGroup matchGroupD = matchResultB.c().d(1);
        int iIntValue = 0;
        int iIntValue2 = ((matchGroupD == null || (strA3 = matchGroupD.a()) == null || (intOrNull3 = StringsKt.toIntOrNull(strA3)) == null) ? 0 : intOrNull3.intValue()) * 1000000;
        MatchGroup matchGroupD2 = matchResultB.c().d(2);
        int iIntValue3 = (((matchGroupD2 == null || (strA2 = matchGroupD2.a()) == null || (intOrNull2 = StringsKt.toIntOrNull(strA2)) == null) ? 0 : intOrNull2.intValue()) * 1000) + iIntValue2;
        MatchGroup matchGroupD3 = matchResultB.c().d(3);
        if (matchGroupD3 != null && (strA = matchGroupD3.a()) != null && (intOrNull = StringsKt.toIntOrNull(strA)) != null) {
            iIntValue = intOrNull.intValue();
        }
        return iIntValue3 + iIntValue;
    }
}
