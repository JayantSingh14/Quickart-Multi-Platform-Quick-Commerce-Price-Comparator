package in.juspay.widget.qrscanner.com.google.zxing.common;

import in.juspay.widget.qrscanner.com.google.zxing.FormatException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public enum CharacterSetECI {
    Cp437(new int[]{0, 2}, new String[0]),
    ISO8859_1(new int[]{1, 3}, "ISO-8859-1"),
    ISO8859_2(4, "ISO-8859-2"),
    ISO8859_3(5, "ISO-8859-3"),
    ISO8859_4(6, "ISO-8859-4"),
    ISO8859_5(7, "ISO-8859-5"),
    ISO8859_6(8, "ISO-8859-6"),
    ISO8859_7(9, "ISO-8859-7"),
    ISO8859_8(10, "ISO-8859-8"),
    ISO8859_9(11, "ISO-8859-9"),
    ISO8859_10(12, "ISO-8859-10"),
    ISO8859_11(13, "ISO-8859-11"),
    ISO8859_13(15, "ISO-8859-13"),
    ISO8859_14(16, "ISO-8859-14"),
    ISO8859_15(17, "ISO-8859-15"),
    ISO8859_16(18, "ISO-8859-16"),
    SJIS(20, "Shift_JIS"),
    Cp1250(21, "windows-1250"),
    Cp1251(22, "windows-1251"),
    Cp1252(23, "windows-1252"),
    Cp1256(24, "windows-1256"),
    UnicodeBigUnmarked(25, "UTF-16BE", "UnicodeBig"),
    UTF8(26, "UTF-8"),
    ASCII(new int[]{27, 170}, "US-ASCII"),
    Big5(28),
    GB18030(29, StringUtils.GB2312, "EUC_CN", "GBK"),
    EUC_KR(30, "EUC-KR");


    /* renamed from: c, reason: collision with root package name */
    private static final Map<Integer, CharacterSetECI> f48872c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private static final Map<String, CharacterSetECI> f48873d = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private final int[] f48875a;

    /* renamed from: b, reason: collision with root package name */
    private final String[] f48876b;

    static {
        for (CharacterSetECI characterSetECI : values()) {
            for (int i2 : characterSetECI.f48875a) {
                f48872c.put(Integer.valueOf(i2), characterSetECI);
            }
            f48873d.put(characterSetECI.name(), characterSetECI);
            for (String str : characterSetECI.f48876b) {
                f48873d.put(str, characterSetECI);
            }
        }
    }

    CharacterSetECI(int i2) {
        this(new int[]{i2}, new String[0]);
    }

    public static CharacterSetECI getCharacterSetECIByName(String str) {
        return f48873d.get(str);
    }

    public static CharacterSetECI getCharacterSetECIByValue(int i2) throws FormatException {
        if (i2 < 0 || i2 >= 900) {
            throw FormatException.getFormatInstance();
        }
        return f48872c.get(Integer.valueOf(i2));
    }

    public int getValue() {
        return this.f48875a[0];
    }

    CharacterSetECI(int i2, String... strArr) {
        this.f48875a = new int[]{i2};
        this.f48876b = strArr;
    }

    CharacterSetECI(int[] iArr, String... strArr) {
        this.f48875a = iArr;
        this.f48876b = strArr;
    }
}
