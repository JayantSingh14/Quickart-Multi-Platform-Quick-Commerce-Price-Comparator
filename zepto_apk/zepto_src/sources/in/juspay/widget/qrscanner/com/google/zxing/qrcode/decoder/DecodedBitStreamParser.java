package in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder;

import in.juspay.widget.qrscanner.com.google.zxing.DecodeHintType;
import in.juspay.widget.qrscanner.com.google.zxing.FormatException;
import in.juspay.widget.qrscanner.com.google.zxing.common.BitSource;
import in.juspay.widget.qrscanner.com.google.zxing.common.CharacterSetECI;
import in.juspay.widget.qrscanner.com.google.zxing.common.DecoderResult;
import in.juspay.widget.qrscanner.com.google.zxing.common.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
final class DecodedBitStreamParser {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f48927a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* renamed from: in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.DecodedBitStreamParser$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f48928a;

        static {
            int[] iArr = new int[Mode.values().length];
            f48928a = iArr;
            try {
                iArr[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f48928a[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f48928a[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f48928a[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f48928a[Mode.TERMINATOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f48928a[Mode.FNC1_FIRST_POSITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f48928a[Mode.FNC1_SECOND_POSITION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f48928a[Mode.STRUCTURED_APPEND.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f48928a[Mode.ECI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f48928a[Mode.HANZI.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private DecodedBitStreamParser() {
    }

    private static char a(int i2) throws FormatException {
        char[] cArr = f48927a;
        if (i2 < cArr.length) {
            return cArr[i2];
        }
        throw FormatException.getFormatInstance();
    }

    private static void b(BitSource bitSource, StringBuilder sb, int i2) throws FormatException {
        if (i2 * 13 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i2 * 2];
        int i3 = 0;
        while (i2 > 0) {
            int bits = bitSource.readBits(13);
            int i4 = (bits % 192) | ((bits / 192) << 8);
            int i5 = i4 + (i4 < 7936 ? 33088 : 49472);
            bArr[i3] = (byte) (i5 >> 8);
            bArr[i3 + 1] = (byte) i5;
            i3 += 2;
            i2--;
        }
        try {
            sb.append(new String(bArr, StringUtils.SHIFT_JIS));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void c(BitSource bitSource, StringBuilder sb, int i2) throws FormatException {
        int bits;
        while (i2 >= 3) {
            if (bitSource.available() < 10) {
                throw FormatException.getFormatInstance();
            }
            int bits2 = bitSource.readBits(10);
            if (bits2 >= 1000) {
                throw FormatException.getFormatInstance();
            }
            sb.append(a(bits2 / 100));
            sb.append(a((bits2 / 10) % 10));
            sb.append(a(bits2 % 10));
            i2 -= 3;
        }
        if (i2 == 2) {
            if (bitSource.available() < 7) {
                throw FormatException.getFormatInstance();
            }
            int bits3 = bitSource.readBits(7);
            if (bits3 >= 100) {
                throw FormatException.getFormatInstance();
            }
            sb.append(a(bits3 / 10));
            bits = bits3 % 10;
        } else {
            if (i2 != 1) {
                return;
            }
            if (bitSource.available() < 4) {
                throw FormatException.getFormatInstance();
            }
            bits = bitSource.readBits(4);
            if (bits >= 10) {
                throw FormatException.getFormatInstance();
            }
        }
        sb.append(a(bits));
    }

    private static int a(BitSource bitSource) throws FormatException {
        int bits = bitSource.readBits(8);
        if ((bits & 128) == 0) {
            return bits & WKSRecord.Service.LOCUS_CON;
        }
        if ((bits & 192) == 128) {
            return bitSource.readBits(8) | ((bits & 63) << 8);
        }
        if ((bits & 224) == 192) {
            return bitSource.readBits(16) | ((bits & 31) << 16);
        }
        throw FormatException.getFormatInstance();
    }

    public static DecoderResult a(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel, Map<DecodeHintType, ?> map) throws FormatException {
        byte[] bArr2 = bArr;
        BitSource bitSource = new BitSource(bArr2);
        StringBuilder sb = new StringBuilder(50);
        ArrayList arrayList = new ArrayList(1);
        int bits = -1;
        int bits2 = -1;
        boolean z = false;
        CharacterSetECI characterSetECIByValue = null;
        while (true) {
            try {
                Mode modeForBits = bitSource.available() < 4 ? Mode.TERMINATOR : Mode.forBits(bitSource.readBits(4));
                int[] iArr = AnonymousClass1.f48928a;
                switch (iArr[modeForBits.ordinal()]) {
                    case 5:
                        break;
                    case 6:
                    case 7:
                        z = true;
                        break;
                    case 8:
                        if (bitSource.available() < 16) {
                            throw FormatException.getFormatInstance();
                        }
                        bits = bitSource.readBits(8);
                        bits2 = bitSource.readBits(8);
                        break;
                    case 9:
                        characterSetECIByValue = CharacterSetECI.getCharacterSetECIByValue(a(bitSource));
                        if (characterSetECIByValue == null) {
                            throw FormatException.getFormatInstance();
                        }
                        break;
                    case 10:
                        int bits3 = bitSource.readBits(4);
                        int bits4 = bitSource.readBits(modeForBits.getCharacterCountBits(version));
                        if (bits3 == 1) {
                            a(bitSource, sb, bits4);
                            break;
                        }
                        break;
                    default:
                        int bits5 = bitSource.readBits(modeForBits.getCharacterCountBits(version));
                        int i2 = iArr[modeForBits.ordinal()];
                        if (i2 == 1) {
                            c(bitSource, sb, bits5);
                            break;
                        } else if (i2 == 2) {
                            a(bitSource, sb, bits5, z);
                            break;
                        } else if (i2 == 3) {
                            a(bitSource, sb, bits5, characterSetECIByValue, arrayList, map);
                            break;
                        } else {
                            if (i2 != 4) {
                                throw FormatException.getFormatInstance();
                            }
                            b(bitSource, sb, bits5);
                            break;
                        }
                }
                if (modeForBits == Mode.TERMINATOR) {
                    String string = sb.toString();
                    if (arrayList.isEmpty()) {
                        arrayList = null;
                    }
                    return new DecoderResult(bArr2, string, arrayList, errorCorrectionLevel != null ? errorCorrectionLevel.toString() : null, bits, bits2);
                }
                bArr2 = bArr;
            } catch (IllegalArgumentException unused) {
                throw FormatException.getFormatInstance();
            }
        }
    }

    private static void a(BitSource bitSource, StringBuilder sb, int i2) throws FormatException {
        if (i2 * 13 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i2 * 2];
        int i3 = 0;
        while (i2 > 0) {
            int bits = bitSource.readBits(13);
            int i4 = (bits % 96) | ((bits / 96) << 8);
            int i5 = i4 + (i4 < 959 ? 41377 : 42657);
            bArr[i3] = (byte) ((i5 >> 8) & 255);
            bArr[i3 + 1] = (byte) (i5 & 255);
            i3 += 2;
            i2--;
        }
        try {
            sb.append(new String(bArr, StringUtils.GB2312));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void a(BitSource bitSource, StringBuilder sb, int i2, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) throws FormatException {
        if (i2 * 8 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) bitSource.readBits(8);
        }
        try {
            sb.append(new String(bArr, characterSetECI == null ? StringUtils.guessEncoding(bArr, map) : characterSetECI.name()));
            collection.add(bArr);
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(in.juspay.widget.qrscanner.com.google.zxing.common.BitSource r3, java.lang.StringBuilder r4, int r5, boolean r6) throws in.juspay.widget.qrscanner.com.google.zxing.FormatException {
        /*
            int r0 = r4.length()
        L4:
            r1 = 1
            if (r5 <= r1) goto L2d
            int r1 = r3.available()
            r2 = 11
            if (r1 < r2) goto L28
            int r1 = r3.readBits(r2)
            int r2 = r1 / 45
            char r2 = a(r2)
            r4.append(r2)
            int r1 = r1 % 45
            char r1 = a(r1)
            r4.append(r1)
            int r5 = r5 + (-2)
            goto L4
        L28:
            in.juspay.widget.qrscanner.com.google.zxing.FormatException r3 = in.juspay.widget.qrscanner.com.google.zxing.FormatException.getFormatInstance()
            throw r3
        L2d:
            if (r5 != r1) goto L47
            int r5 = r3.available()
            r2 = 6
            if (r5 < r2) goto L42
            int r3 = r3.readBits(r2)
            char r3 = a(r3)
            r4.append(r3)
            goto L47
        L42:
            in.juspay.widget.qrscanner.com.google.zxing.FormatException r3 = in.juspay.widget.qrscanner.com.google.zxing.FormatException.getFormatInstance()
            throw r3
        L47:
            if (r6 == 0) goto L72
        L49:
            int r3 = r4.length()
            if (r0 >= r3) goto L72
            char r3 = r4.charAt(r0)
            r5 = 37
            if (r3 != r5) goto L6f
            int r3 = r4.length()
            int r3 = r3 - r1
            if (r0 >= r3) goto L6a
            int r3 = r0 + 1
            char r6 = r4.charAt(r3)
            if (r6 != r5) goto L6a
            r4.deleteCharAt(r3)
            goto L6f
        L6a:
            r3 = 29
            r4.setCharAt(r0, r3)
        L6f:
            int r0 = r0 + 1
            goto L49
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.DecodedBitStreamParser.a(in.juspay.widget.qrscanner.com.google.zxing.common.BitSource, java.lang.StringBuilder, int, boolean):void");
    }
}
