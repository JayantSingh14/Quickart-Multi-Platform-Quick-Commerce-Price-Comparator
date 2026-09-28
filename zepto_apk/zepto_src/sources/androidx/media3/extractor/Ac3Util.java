package androidx.media3.extractor;

import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.xbill.DNS.WKSRecord;

@UnstableApi
/* loaded from: classes3.dex */
public final class Ac3Util {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f8459a = {1, 2, 3, 6};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f8460b = {48000, 44100, 32000};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f8461c = {24000, 22050, 16000};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f8462d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f8463e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f8464f = {69, 87, 104, WKSRecord.Service.ERPC, WKSRecord.Service.NETBIOS_SSN, 174, 208, WKSRecord.Service.SUR_MEAS, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static final class SyncFrameInfo {

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface StreamType {
        }
    }

    public static int a(int i2, int i3) {
        int i4 = i3 / 2;
        if (i2 < 0 || i2 >= 3 || i3 < 0 || i4 >= 19) {
            return -1;
        }
        int i5 = f8460b[i2];
        if (i5 == 44100) {
            return ((i3 % 2) + f8464f[i4]) * 2;
        }
        int i6 = f8463e[i4];
        return i5 == 32000 ? i6 * 6 : i6 * 4;
    }
}
