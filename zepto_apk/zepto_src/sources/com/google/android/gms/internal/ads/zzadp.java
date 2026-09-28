package com.google.android.gms.internal.ads;

import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
public final class zzadp {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f22805a = {1, 2, 3, 6};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f22806b = {48000, 44100, 32000};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f22807c = {24000, 22050, 16000};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f22808d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f22809e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f22810f = {69, 87, 104, WKSRecord.Service.ERPC, WKSRecord.Service.NETBIOS_SSN, 174, 208, WKSRecord.Service.SUR_MEAS, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int a(int i2, int i3) {
        int i4;
        if (i2 < 0 || i2 >= 3 || i3 < 0 || (i4 = i3 >> 1) >= 19) {
            return -1;
        }
        int i5 = f22806b[i2];
        if (i5 == 44100) {
            int i6 = f22810f[i4] + (i3 & 1);
            return i6 + i6;
        }
        int i7 = f22809e[i4];
        return i5 == 32000 ? i7 * 6 : i7 * 4;
    }
}
