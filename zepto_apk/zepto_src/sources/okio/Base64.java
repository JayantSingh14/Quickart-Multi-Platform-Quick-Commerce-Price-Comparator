package okio;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.ByteString;

@Metadata
@JvmName
/* renamed from: okio.-Base64, reason: invalid class name */
/* loaded from: classes3.dex */
public final class Base64 {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f56898a;

    static {
        ByteString byteString = ByteString.f56924d;
        f56898a = ByteString.Companion.c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").f56925a;
        ByteString.Companion.c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_");
    }

    public static final byte[] a(String str) {
        int i2;
        char cCharAt;
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        while (length > 0 && ((cCharAt = str.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == '\t')) {
            length--;
        }
        int i3 = (int) ((length * 6) / 8);
        byte[] bArr = new byte[i3];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt2 = str.charAt(i7);
            if ('A' <= cCharAt2 && cCharAt2 < '[') {
                i2 = cCharAt2 - 'A';
            } else if ('a' <= cCharAt2 && cCharAt2 < '{') {
                i2 = cCharAt2 - 'G';
            } else if ('0' <= cCharAt2 && cCharAt2 < ':') {
                i2 = cCharAt2 + 4;
            } else if (cCharAt2 == '+' || cCharAt2 == '-') {
                i2 = 62;
            } else if (cCharAt2 == '/' || cCharAt2 == '_') {
                i2 = 63;
            } else {
                if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                    return null;
                }
            }
            i5 = (i5 << 6) | i2;
            i4++;
            if (i4 % 4 == 0) {
                bArr[i6] = (byte) (i5 >> 16);
                int i8 = i6 + 2;
                bArr[i6 + 1] = (byte) (i5 >> 8);
                i6 += 3;
                bArr[i8] = (byte) i5;
            }
        }
        int i9 = i4 % 4;
        if (i9 == 1) {
            return null;
        }
        if (i9 == 2) {
            bArr[i6] = (byte) ((i5 << 12) >> 16);
            i6++;
        } else if (i9 == 3) {
            int i10 = i5 << 6;
            int i11 = i6 + 1;
            bArr[i6] = (byte) (i10 >> 16);
            i6 += 2;
            bArr[i11] = (byte) (i10 >> 8);
        }
        if (i6 == i3) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i6);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    public static String b(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        byte[] map = f56898a;
        Intrinsics.checkNotNullParameter(map, "map");
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            byte b2 = bArr[i2];
            int i4 = i2 + 2;
            byte b3 = bArr[i2 + 1];
            i2 += 3;
            byte b4 = bArr[i4];
            bArr2[i3] = map[(b2 & 255) >> 2];
            bArr2[i3 + 1] = map[((b2 & 3) << 4) | ((b3 & 255) >> 4)];
            int i5 = i3 + 3;
            bArr2[i3 + 2] = map[((b3 & 15) << 2) | ((b4 & 255) >> 6)];
            i3 += 4;
            bArr2[i5] = map[b4 & 63];
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b5 = bArr[i2];
            bArr2[i3] = map[(b5 & 255) >> 2];
            bArr2[i3 + 1] = map[(b5 & 3) << 4];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
        } else if (length2 == 2) {
            int i6 = i2 + 1;
            byte b6 = bArr[i2];
            byte b7 = bArr[i6];
            bArr2[i3] = map[(b6 & 255) >> 2];
            bArr2[i3 + 1] = map[((b6 & 3) << 4) | ((b7 & 255) >> 4)];
            bArr2[i3 + 2] = map[(b7 & 15) << 2];
            bArr2[i3 + 3] = 61;
        }
        Intrinsics.checkNotNullParameter(bArr2, "<this>");
        return new String(bArr2, Charsets.UTF_8);
    }
}
