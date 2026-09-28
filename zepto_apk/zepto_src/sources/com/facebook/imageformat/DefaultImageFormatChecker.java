package com.facebook.imageformat;

import com.facebook.imageformat.ImageFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes3.dex */
public final class DefaultImageFormatChecker implements ImageFormat.FormatChecker {

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f17668b = {-1, -40, -1};

    /* renamed from: c, reason: collision with root package name */
    public static final int f17669c = 3;

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f17670d = {-119, 80, 78, 71, 13, 10, 26, 10};

    /* renamed from: e, reason: collision with root package name */
    public static final int f17671e = 8;

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f17672f = ImageFormatCheckerUtils.a("GIF87a");

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f17673g = ImageFormatCheckerUtils.a("GIF89a");

    /* renamed from: h, reason: collision with root package name */
    public static final byte[] f17674h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f17675i;

    /* renamed from: j, reason: collision with root package name */
    public static final byte[] f17676j;

    /* renamed from: k, reason: collision with root package name */
    public static final int f17677k;

    /* renamed from: l, reason: collision with root package name */
    public static final byte[] f17678l;

    /* renamed from: m, reason: collision with root package name */
    public static final byte[][] f17679m;
    public static final byte[] n;
    public static final byte[] o;
    public static final int p;
    public static final byte[] q;
    public static final byte[] r;
    public static final byte[] s;

    /* renamed from: a, reason: collision with root package name */
    public final int f17680a;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
    }

    static {
        byte[] bArrA = ImageFormatCheckerUtils.a("BM");
        f17674h = bArrA;
        f17675i = bArrA.length;
        f17676j = new byte[]{0, 0, 1, 0};
        f17677k = 4;
        f17678l = ImageFormatCheckerUtils.a("ftyp");
        f17679m = new byte[][]{ImageFormatCheckerUtils.a("heic"), ImageFormatCheckerUtils.a("heix"), ImageFormatCheckerUtils.a("hevc"), ImageFormatCheckerUtils.a("hevx"), ImageFormatCheckerUtils.a("mif1"), ImageFormatCheckerUtils.a("msf1")};
        n = new byte[]{73, 73, 42, 0};
        o = new byte[]{77, 77, 0, 42};
        p = 4;
        q = new byte[]{3, 0, 8, 0};
        r = ImageFormatCheckerUtils.a("ftyp");
        s = ImageFormatCheckerUtils.a("avif");
    }

    public DefaultImageFormatChecker() {
        Integer num;
        Integer[] numArr = {21, 20, Integer.valueOf(f17669c), Integer.valueOf(f17671e), 6, Integer.valueOf(f17675i), Integer.valueOf(f17677k), 12, 4, 12};
        Intrinsics.checkNotNullParameter(numArr, "<this>");
        if (numArr.length == 0) {
            num = null;
        } else {
            Integer num2 = numArr[0];
            Intrinsics.checkNotNullParameter(numArr, "<this>");
            int i2 = 1;
            int length = numArr.length - 1;
            if (1 <= length) {
                while (true) {
                    Integer num3 = numArr[i2];
                    num2 = num2.compareTo(num3) < 0 ? num3 : num2;
                    if (i2 == length) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            num = num2;
        }
        if (num == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.f17680a = num.intValue();
    }
}
