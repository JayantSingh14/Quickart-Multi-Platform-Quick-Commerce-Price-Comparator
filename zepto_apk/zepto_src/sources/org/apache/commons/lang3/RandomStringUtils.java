package org.apache.commons.lang3;

import android.support.v4.media.b;
import java.util.Random;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes5.dex */
public class RandomStringUtils {
    private static final Random RANDOM = new Random();

    public static String random(int i2) {
        return random(i2, false, false);
    }

    public static String randomAlphabetic(int i2) {
        return random(i2, true, false);
    }

    public static String randomAlphanumeric(int i2) {
        return random(i2, true, true);
    }

    public static String randomAscii(int i2) {
        return random(i2, 32, WKSRecord.Service.LOCUS_CON, false, false);
    }

    public static String randomGraph(int i2) {
        return random(i2, 33, 126, false, false);
    }

    public static String randomNumeric(int i2) {
        return random(i2, false, true);
    }

    public static String randomPrint(int i2) {
        return random(i2, 32, 126, false, false);
    }

    public static String random(int i2, boolean z, boolean z2) {
        return random(i2, 0, 0, z, z2);
    }

    public static String randomAlphabetic(int i2, int i3) {
        return randomAlphabetic(RandomUtils.nextInt(i2, i3));
    }

    public static String randomAlphanumeric(int i2, int i3) {
        return randomAlphanumeric(RandomUtils.nextInt(i2, i3));
    }

    public static String randomAscii(int i2, int i3) {
        return randomAscii(RandomUtils.nextInt(i2, i3));
    }

    public static String randomGraph(int i2, int i3) {
        return randomGraph(RandomUtils.nextInt(i2, i3));
    }

    public static String randomNumeric(int i2, int i3) {
        return randomNumeric(RandomUtils.nextInt(i2, i3));
    }

    public static String randomPrint(int i2, int i3) {
        return randomPrint(RandomUtils.nextInt(i2, i3));
    }

    public static String random(int i2, int i3, int i4, boolean z, boolean z2) {
        return random(i2, i3, i4, z, z2, null, RANDOM);
    }

    public static String random(int i2, int i3, int i4, boolean z, boolean z2, char... cArr) {
        return random(i2, i3, i4, z, z2, cArr, RANDOM);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String random(int i2, int i3, int i4, boolean z, boolean z2, char[] cArr, Random random) {
        char cNextInt;
        if (i2 == 0) {
            return "";
        }
        if (i2 >= 0) {
            if (cArr != 0 && cArr.length == 0) {
                throw new IllegalArgumentException("The chars array must not be empty");
            }
            if (i3 == 0 && i4 == 0) {
                if (cArr != 0) {
                    i4 = cArr.length;
                } else if (z || z2) {
                    i4 = WKSRecord.Service.NTP;
                    i3 = 32;
                } else {
                    i4 = 1114111;
                }
            } else if (i4 <= i3) {
                throw new IllegalArgumentException(b.e(i4, i3, "Parameter end (", ") must be greater than start (", ")"));
            }
            if (cArr == 0 && ((z2 && i4 <= 48) || (z && i4 <= 65))) {
                throw new IllegalArgumentException(b.g(i4, "Parameter end (", ") must be greater then (48) for generating digits or greater then (65) for generating letters."));
            }
            StringBuilder sb = new StringBuilder(i2);
            int i5 = i4 - i3;
            while (true) {
                int i6 = i2 - 1;
                if (i2 != 0) {
                    if (cArr == 0) {
                        cNextInt = random.nextInt(i5) + i3;
                        int type = Character.getType(cNextInt);
                        if (type == 0 || type == 18 || type == 19) {
                        }
                    } else {
                        cNextInt = cArr[random.nextInt(i5) + i3];
                    }
                    int iCharCount = Character.charCount(cNextInt);
                    if (i6 != 0 || iCharCount <= 1) {
                        if ((z && Character.isLetter(cNextInt)) || ((z2 && Character.isDigit(cNextInt)) || (!z && !z2))) {
                            sb.appendCodePoint(cNextInt);
                            i2 = iCharCount == 2 ? i2 - 2 : i6;
                        }
                    }
                } else {
                    return sb.toString();
                }
            }
        } else {
            throw new IllegalArgumentException(b.g(i2, "Requested random string length ", " is less than 0."));
        }
    }

    public static String random(int i2, String str) {
        if (str == null) {
            return random(i2, 0, 0, false, false, null, RANDOM);
        }
        return random(i2, str.toCharArray());
    }

    public static String random(int i2, char... cArr) {
        if (cArr == null) {
            return random(i2, 0, 0, false, false, null, RANDOM);
        }
        return random(i2, 0, cArr.length, false, false, cArr, RANDOM);
    }
}
