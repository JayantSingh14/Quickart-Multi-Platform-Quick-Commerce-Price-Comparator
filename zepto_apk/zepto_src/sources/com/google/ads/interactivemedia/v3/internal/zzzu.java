package com.google.ads.interactivemedia.v3.internal;

import j$.util.DesugarTimeZone;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public final class zzzu {
    private static final TimeZone zza = DesugarTimeZone.getTimeZone("UTC");

    /* JADX WARN: Removed duplicated region for block: B:101:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f8 A[Catch: IllegalArgumentException -> 0x004e, IndexOutOfBoundsException -> 0x0051, TryCatch #2 {IllegalArgumentException -> 0x004e, IndexOutOfBoundsException -> 0x0051, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0036, B:13:0x003c, B:21:0x005c, B:23:0x006c, B:24:0x006e, B:26:0x007a, B:27:0x007d, B:29:0x0083, B:33:0x008d, B:38:0x009d, B:40:0x00a5, B:41:0x00a9, B:43:0x00af, B:48:0x00bc, B:51:0x00c7, B:62:0x00f2, B:64:0x00f8, B:66:0x00fe, B:90:0x01ad, B:71:0x010a, B:72:0x0125, B:73:0x0126, B:75:0x0131, B:76:0x0142, B:78:0x014f, B:81:0x0158, B:83:0x0177, B:86:0x0186, B:87:0x01a8, B:89:0x01ab, B:92:0x01df, B:93:0x01e6, B:55:0x00d7, B:56:0x00da, B:50:0x00c3), top: B:104:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01df A[Catch: IllegalArgumentException -> 0x004e, IndexOutOfBoundsException -> 0x0051, TryCatch #2 {IllegalArgumentException -> 0x004e, IndexOutOfBoundsException -> 0x0051, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0036, B:13:0x003c, B:21:0x005c, B:23:0x006c, B:24:0x006e, B:26:0x007a, B:27:0x007d, B:29:0x0083, B:33:0x008d, B:38:0x009d, B:40:0x00a5, B:41:0x00a9, B:43:0x00af, B:48:0x00bc, B:51:0x00c7, B:62:0x00f2, B:64:0x00f8, B:66:0x00fe, B:90:0x01ad, B:71:0x010a, B:72:0x0125, B:73:0x0126, B:75:0x0131, B:76:0x0142, B:78:0x014f, B:81:0x0158, B:83:0x0177, B:86:0x0186, B:87:0x01a8, B:89:0x01ab, B:92:0x01df, B:93:0x01e6, B:55:0x00d7, B:56:0x00da, B:50:0x00c3), top: B:104:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Date zza(java.lang.String r17, java.text.ParsePosition r18) throws java.text.ParseException {
        /*
            Method dump skipped, instructions count: 546
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzzu.zza(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static int zzb(String str, int i2, int i3) throws NumberFormatException {
        int i4;
        int i5;
        if (i2 < 0 || i3 > str.length() || i2 > i3) {
            throw new NumberFormatException(str);
        }
        if (i2 < i3) {
            i5 = i2 + 1;
            int iDigit = Character.digit(str.charAt(i2), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: ".concat(String.valueOf(str.substring(i2, i3))));
            }
            i4 = -iDigit;
        } else {
            i4 = 0;
            i5 = i2;
        }
        while (i5 < i3) {
            int i6 = i5 + 1;
            int iDigit2 = Character.digit(str.charAt(i5), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: ".concat(String.valueOf(str.substring(i2, i3))));
            }
            i4 = (i4 * 10) - iDigit2;
            i5 = i6;
        }
        return -i4;
    }

    private static boolean zzc(String str, int i2, char c2) {
        return i2 < str.length() && str.charAt(i2) == c2;
    }
}
