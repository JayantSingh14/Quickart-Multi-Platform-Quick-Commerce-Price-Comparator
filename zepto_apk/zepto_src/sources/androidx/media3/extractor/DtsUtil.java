package androidx.media3.extractor;

import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import org.xbill.DNS.SimpleResolver;
import org.xbill.DNS.dnssec.ValidatingResolver;

@UnstableApi
/* loaded from: classes3.dex */
public final class DtsUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f8534a = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f8535b = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f8536c = {64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f8537d = {8000, 16000, 32000, 64000, 128000, 22050, 44100, 88200, 176400, 352800, 12000, 24000, 48000, 96000, 192000, 384000};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f8538e = {5, 8, 10, 12};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f8539f = {6, 9, 12, 15};

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f8540g = {2, 4, 6, 8};

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f8541h = {9, 11, 13, 16};

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f8542i = {5, 8, 10, 12};

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DtsAudioMimeType {
    }

    public static final class DtsHeader {

        /* renamed from: a, reason: collision with root package name */
        public final String f8543a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8544b;

        /* renamed from: c, reason: collision with root package name */
        public final int f8545c;

        public DtsHeader(long j2, int i2, String str, int i3, int i4) {
            this.f8543a = str;
            this.f8545c = i2;
            this.f8544b = i3;
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FrameType {
    }

    public static ParsableBitArray a(byte[] bArr) {
        byte b2 = bArr[0];
        if (b2 == 127 || b2 == 100 || b2 == 64 || b2 == 113) {
            return new ParsableBitArray(bArr, bArr.length);
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        byte b3 = bArrCopyOf[0];
        if (b3 == -2 || b3 == -1 || b3 == 37 || b3 == -14 || b3 == -24) {
            for (int i2 = 0; i2 < bArrCopyOf.length - 1; i2 += 2) {
                byte b4 = bArrCopyOf[i2];
                int i3 = i2 + 1;
                bArrCopyOf[i2] = bArrCopyOf[i3];
                bArrCopyOf[i3] = b4;
            }
        }
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArrCopyOf, bArrCopyOf.length);
        if (bArrCopyOf[0] == 31) {
            ParsableBitArray parsableBitArray2 = new ParsableBitArray(bArrCopyOf, bArrCopyOf.length);
            while (parsableBitArray2.b() >= 16) {
                parsableBitArray2.o(2);
                int iG = parsableBitArray2.g(14) & 16383;
                int iMin = Math.min(8 - parsableBitArray.f5718c, 14);
                int i4 = parsableBitArray.f5718c;
                int i5 = (8 - i4) - iMin;
                int i6 = (ValidatingResolver.VALIDATION_REASON_QCLASS >> i4) | ((1 << i5) - 1);
                byte[] bArr2 = parsableBitArray.f5716a;
                int i7 = parsableBitArray.f5717b;
                byte b5 = (byte) (i6 & bArr2[i7]);
                bArr2[i7] = b5;
                int i8 = 14 - iMin;
                bArr2[i7] = (byte) (b5 | ((iG >>> i8) << i5));
                int i9 = i7 + 1;
                while (i8 > 8) {
                    parsableBitArray.f5716a[i9] = (byte) (iG >>> (i8 - 8));
                    i8 -= 8;
                    i9++;
                }
                int i10 = 8 - i8;
                byte[] bArr3 = parsableBitArray.f5716a;
                byte b6 = (byte) (bArr3[i9] & ((1 << i10) - 1));
                bArr3[i9] = b6;
                bArr3[i9] = (byte) (((iG & ((1 << i8) - 1)) << i10) | b6);
                parsableBitArray.o(14);
                parsableBitArray.a();
            }
        }
        parsableBitArray.k(bArrCopyOf.length, bArrCopyOf);
        return parsableBitArray;
    }

    public static int b(ParsableBitArray parsableBitArray, int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 3 && parsableBitArray.f(); i3++) {
            i2++;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            i4 += 1 << iArr[i5];
        }
        return parsableBitArray.g(iArr[i2]) + i4;
    }
}
