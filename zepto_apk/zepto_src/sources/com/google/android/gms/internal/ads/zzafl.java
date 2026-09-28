package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzafl {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f22947a = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f22948b = {44100, 48000, 32000};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f22949c = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f22950d = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f22951e = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f22952f = {32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f22953g = {8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    public static int a(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (!((i2 & (-2097152)) == -2097152) || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
            return -1;
        }
        int i7 = i5 - 1;
        int i8 = f22948b[i6];
        if (i3 == 2) {
            i8 /= 2;
        } else if (i3 == 0) {
            i8 /= 4;
        }
        int i9 = (i2 >>> 9) & 1;
        if (i4 == 3) {
            return ((((i3 == 3 ? f22949c[i7] : f22950d[i7]) * 12) / i8) + i9) * 4;
        }
        int i10 = i3 == 3 ? i4 == 2 ? f22951e[i7] : f22952f[i7] : f22953g[i7];
        if (i3 == 3) {
            return android.support.v4.media.a.x(i10, 144, i8, i9);
        }
        return android.support.v4.media.a.x(i4 == 1 ? 72 : 144, i10, i8, i9);
    }
}
