package com.facebook.hermes.intl;

import android.icu.text.DateFormat;
import com.facebook.hermes.intl.IPlatformDateTimeFormatter;

/* loaded from: classes3.dex */
public class PlatformDateTimeFormatterICU implements IPlatformDateTimeFormatter {

    /* renamed from: a, reason: collision with root package name */
    public DateFormat f17651a;

    /* renamed from: com.facebook.hermes.intl.PlatformDateTimeFormatterICU$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17652a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f17653b;

        static {
            int[] iArr = new int[IPlatformDateTimeFormatter.TimeStyle.values().length];
            f17653b = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17653b[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17653b[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17653b[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17653b[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[IPlatformDateTimeFormatter.DateStyle.values().length];
            f17652a = iArr2;
            try {
                iArr2[0] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17652a[1] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f17652a[2] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f17652a[3] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f17652a[4] = 5;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public static class PatternUtils {
    }

    public static void a(StringBuilder sb, char[] cArr, char c2) {
        for (int i2 = 0; i2 < sb.length(); i2++) {
            int length = cArr.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    if (sb.charAt(i2) == cArr[i3]) {
                        sb.setCharAt(i2, c2);
                        break;
                    }
                    i3++;
                }
            }
        }
    }

    public static int b(IPlatformDateTimeFormatter.DateStyle dateStyle) throws JSRangeErrorException {
        int iOrdinal = dateStyle.ordinal();
        if (iOrdinal == 0) {
            return 0;
        }
        int i2 = 1;
        if (iOrdinal != 1) {
            i2 = 2;
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    return 3;
                }
                throw new JSRangeErrorException("Invalid DateStyle: ".concat(dateStyle.toString()));
            }
        }
        return i2;
    }

    public static int c(IPlatformDateTimeFormatter.TimeStyle timeStyle) throws JSRangeErrorException {
        int iOrdinal = timeStyle.ordinal();
        if (iOrdinal == 0) {
            return 0;
        }
        int i2 = 1;
        if (iOrdinal != 1) {
            i2 = 2;
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    return 3;
                }
                throw new JSRangeErrorException("Invalid DateStyle: ".concat(timeStyle.toString()));
            }
        }
        return i2;
    }
}
