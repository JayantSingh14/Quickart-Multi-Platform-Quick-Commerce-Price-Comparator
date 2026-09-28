package org.brotli.dec;

import org.apache.commons.lang3.StringUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes5.dex */
final class Transform {

    /* renamed from: d, reason: collision with root package name */
    public static final Transform[] f57443d = {new Transform("", 0, ""), new Transform("", 0, StringUtils.SPACE), new Transform(StringUtils.SPACE, 0, StringUtils.SPACE), new Transform("", 12, ""), new Transform("", 10, StringUtils.SPACE), new Transform("", 0, " the "), new Transform(StringUtils.SPACE, 0, ""), new Transform("s ", 0, StringUtils.SPACE), new Transform("", 0, " of "), new Transform("", 10, ""), new Transform("", 0, " and "), new Transform("", 13, ""), new Transform("", 1, ""), new Transform(", ", 0, StringUtils.SPACE), new Transform("", 0, ", "), new Transform(StringUtils.SPACE, 10, StringUtils.SPACE), new Transform("", 0, " in "), new Transform("", 0, " to "), new Transform("e ", 0, StringUtils.SPACE), new Transform("", 0, "\""), new Transform("", 0, CLConstants.DOT_SALT_DELIMETER), new Transform("", 0, "\">"), new Transform("", 0, StringUtils.LF), new Transform("", 3, ""), new Transform("", 0, "]"), new Transform("", 0, " for "), new Transform("", 14, ""), new Transform("", 2, ""), new Transform("", 0, " a "), new Transform("", 0, " that "), new Transform(StringUtils.SPACE, 10, ""), new Transform("", 0, ". "), new Transform(CLConstants.DOT_SALT_DELIMETER, 0, ""), new Transform(StringUtils.SPACE, 0, ", "), new Transform("", 15, ""), new Transform("", 0, " with "), new Transform("", 0, "'"), new Transform("", 0, " from "), new Transform("", 0, " by "), new Transform("", 16, ""), new Transform("", 17, ""), new Transform(" the ", 0, ""), new Transform("", 4, ""), new Transform("", 0, ". The "), new Transform("", 11, ""), new Transform("", 0, " on "), new Transform("", 0, " as "), new Transform("", 0, " is "), new Transform("", 7, ""), new Transform("", 1, "ing "), new Transform("", 0, "\n\t"), new Transform("", 0, ":"), new Transform(StringUtils.SPACE, 0, ". "), new Transform("", 0, "ed "), new Transform("", 20, ""), new Transform("", 18, ""), new Transform("", 6, ""), new Transform("", 0, "("), new Transform("", 10, ", "), new Transform("", 8, ""), new Transform("", 0, " at "), new Transform("", 0, "ly "), new Transform(" the ", 0, " of "), new Transform("", 5, ""), new Transform("", 9, ""), new Transform(StringUtils.SPACE, 10, ", "), new Transform("", 10, "\""), new Transform(CLConstants.DOT_SALT_DELIMETER, 0, "("), new Transform("", 11, StringUtils.SPACE), new Transform("", 10, "\">"), new Transform("", 0, "=\""), new Transform(StringUtils.SPACE, 0, CLConstants.DOT_SALT_DELIMETER), new Transform(".com/", 0, ""), new Transform(" the ", 0, " of the "), new Transform("", 10, "'"), new Transform("", 0, ". This "), new Transform("", 0, ","), new Transform(CLConstants.DOT_SALT_DELIMETER, 0, StringUtils.SPACE), new Transform("", 10, "("), new Transform("", 10, CLConstants.DOT_SALT_DELIMETER), new Transform("", 0, " not "), new Transform(StringUtils.SPACE, 0, "=\""), new Transform("", 0, "er "), new Transform(StringUtils.SPACE, 11, StringUtils.SPACE), new Transform("", 0, "al "), new Transform(StringUtils.SPACE, 11, ""), new Transform("", 0, "='"), new Transform("", 11, "\""), new Transform("", 10, ". "), new Transform(StringUtils.SPACE, 0, "("), new Transform("", 0, "ful "), new Transform(StringUtils.SPACE, 10, ". "), new Transform("", 0, "ive "), new Transform("", 0, "less "), new Transform("", 11, "'"), new Transform("", 0, "est "), new Transform(StringUtils.SPACE, 10, CLConstants.DOT_SALT_DELIMETER), new Transform("", 11, "\">"), new Transform(StringUtils.SPACE, 0, "='"), new Transform("", 10, ","), new Transform("", 0, "ize "), new Transform("", 11, CLConstants.DOT_SALT_DELIMETER), new Transform("Â ", 0, ""), new Transform(StringUtils.SPACE, 0, ","), new Transform("", 10, "=\""), new Transform("", 11, "=\""), new Transform("", 0, "ous "), new Transform("", 11, ", "), new Transform("", 10, "='"), new Transform(StringUtils.SPACE, 10, ","), new Transform(StringUtils.SPACE, 11, "=\""), new Transform(StringUtils.SPACE, 11, ", "), new Transform("", 11, ","), new Transform("", 11, "("), new Transform("", 11, ". "), new Transform(StringUtils.SPACE, 11, CLConstants.DOT_SALT_DELIMETER), new Transform("", 11, "='"), new Transform(StringUtils.SPACE, 11, ". "), new Transform(StringUtils.SPACE, 10, "=\""), new Transform(StringUtils.SPACE, 11, "='"), new Transform(StringUtils.SPACE, 10, "='")};

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f57444a;

    /* renamed from: b, reason: collision with root package name */
    public final int f57445b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f57446c;

    public Transform(String str, int i2, String str2) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            bArr[i3] = (byte) str.charAt(i3);
        }
        this.f57444a = bArr;
        this.f57445b = i2;
        int length2 = str2.length();
        byte[] bArr2 = new byte[length2];
        for (int i4 = 0; i4 < length2; i4++) {
            bArr2[i4] = (byte) str2.charAt(i4);
        }
        this.f57446c = bArr2;
    }
}
