package io.ktor.util;

import android.support.v4.media.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class Base64Kt {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f50419a;

    static {
        int[] iArr = new int[256];
        for (int i2 = 0; i2 < 256; i2++) {
            iArr[i2] = StringsKt.w("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", (char) i2, 0, 6);
        }
        f50419a = iArr;
    }

    public static final String a(byte[] bArr) {
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int i4 = 3;
        char[] cArr = new char[a.x(bArr.length, 8, 6, 3)];
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = i5 + 3;
            if (i7 > bArr.length) {
                break;
            }
            int i8 = (bArr[i5 + 2] & 255) | ((bArr[i5] & 255) << 16) | ((bArr[i5 + 1] & 255) << 8);
            int i9 = 3;
            while (-1 < i9) {
                cArr[i6] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i8 >> (i9 * 6)) & 63);
                i9--;
                i6++;
            }
            i5 = i7;
        }
        int length = bArr.length - i5;
        if (length == 0) {
            return StringsKt.m(cArr, 0, i6);
        }
        if (length == 1) {
            i2 = (bArr[i5] & 255) << 16;
        } else {
            i2 = ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5] & 255) << 16);
        }
        int i10 = ((3 - length) * 8) / 6;
        if (i10 <= 3) {
            while (true) {
                i3 = i6 + 1;
                cArr[i6] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i2 >> (i4 * 6)) & 63);
                if (i4 == i10) {
                    break;
                }
                i4--;
                i6 = i3;
            }
            i6 = i3;
        }
        int i11 = 0;
        while (i11 < i10) {
            cArr[i6] = '=';
            i11++;
            i6++;
        }
        return StringsKt.m(cArr, 0, i6);
    }
}
