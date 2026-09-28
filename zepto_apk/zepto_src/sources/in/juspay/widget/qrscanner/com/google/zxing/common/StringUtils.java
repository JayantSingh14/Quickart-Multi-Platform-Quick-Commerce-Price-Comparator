package in.juspay.widget.qrscanner.com.google.zxing.common;

import java.nio.charset.Charset;

/* loaded from: classes4.dex */
public final class StringUtils {
    public static final String GB2312 = "GB2312";
    public static final String SHIFT_JIS = "SJIS";

    /* renamed from: a, reason: collision with root package name */
    private static final String f48904a;

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f48905b;

    static {
        String strName = Charset.defaultCharset().name();
        f48904a = strName;
        f48905b = SHIFT_JIS.equalsIgnoreCase(strName) || "EUC_JP".equalsIgnoreCase(strName);
    }

    private StringUtils() {
    }

    /* JADX WARN: Removed duplicated region for block: B:95:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String guessEncoding(byte[] r21, java.util.Map<in.juspay.widget.qrscanner.com.google.zxing.DecodeHintType, ?> r22) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.widget.qrscanner.com.google.zxing.common.StringUtils.guessEncoding(byte[], java.util.Map):java.lang.String");
    }
}
