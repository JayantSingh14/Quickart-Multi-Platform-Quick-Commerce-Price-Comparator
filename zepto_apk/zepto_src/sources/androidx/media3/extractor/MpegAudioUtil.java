package androidx.media3.extractor;

import android.support.v4.media.a;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public final class MpegAudioUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f8585a = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f8586b = {44100, 48000, 32000};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f8587c = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f8588d = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f8589e = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f8590f = {32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f8591g = {8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    public static final class Header {

        /* renamed from: a, reason: collision with root package name */
        public int f8592a;

        /* renamed from: b, reason: collision with root package name */
        public String f8593b;

        /* renamed from: c, reason: collision with root package name */
        public int f8594c;

        /* renamed from: d, reason: collision with root package name */
        public int f8595d;

        /* renamed from: e, reason: collision with root package name */
        public int f8596e;

        /* renamed from: f, reason: collision with root package name */
        public int f8597f;

        /* renamed from: g, reason: collision with root package name */
        public int f8598g;

        public final boolean a(int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            if (!((i2 & (-2097152)) == -2097152) || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
                return false;
            }
            this.f8592a = i3;
            this.f8593b = MpegAudioUtil.f8585a[3 - i4];
            int i7 = MpegAudioUtil.f8586b[i6];
            this.f8595d = i7;
            if (i3 == 2) {
                this.f8595d = i7 / 2;
            } else if (i3 == 0) {
                this.f8595d = i7 / 4;
            }
            int i8 = (i2 >>> 9) & 1;
            int i9 = 1152;
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        throw new IllegalArgumentException();
                    }
                    i9 = 384;
                }
            } else if (i3 != 3) {
                i9 = 576;
            }
            this.f8598g = i9;
            if (i4 == 3) {
                int i10 = i3 == 3 ? MpegAudioUtil.f8587c[i5 - 1] : MpegAudioUtil.f8588d[i5 - 1];
                this.f8597f = i10;
                this.f8594c = (((i10 * 12) / this.f8595d) + i8) * 4;
            } else {
                if (i3 == 3) {
                    int i11 = i4 == 2 ? MpegAudioUtil.f8589e[i5 - 1] : MpegAudioUtil.f8590f[i5 - 1];
                    this.f8597f = i11;
                    this.f8594c = ((i11 * 144) / this.f8595d) + i8;
                } else {
                    int i12 = MpegAudioUtil.f8591g[i5 - 1];
                    this.f8597f = i12;
                    this.f8594c = (((i4 == 1 ? 72 : 144) * i12) / this.f8595d) + i8;
                }
            }
            this.f8596e = ((i2 >> 6) & 3) == 3 ? 1 : 2;
            return true;
        }
    }

    public static int a(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (!((i2 & (-2097152)) == -2097152) || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
            return -1;
        }
        int i7 = f8586b[i6];
        if (i3 == 2) {
            i7 /= 2;
        } else if (i3 == 0) {
            i7 /= 4;
        }
        int i8 = (i2 >>> 9) & 1;
        if (i4 == 3) {
            return ((((i3 == 3 ? f8587c[i5 - 1] : f8588d[i5 - 1]) * 12) / i7) + i8) * 4;
        }
        int i9 = i3 == 3 ? i4 == 2 ? f8589e[i5 - 1] : f8590f[i5 - 1] : f8591g[i5 - 1];
        if (i3 == 3) {
            return a.x(i9, 144, i7, i8);
        }
        return a.x(i4 == 1 ? 72 : 144, i9, i7, i8);
    }
}
