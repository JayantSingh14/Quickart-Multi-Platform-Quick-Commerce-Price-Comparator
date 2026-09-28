package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzane {

    /* renamed from: b, reason: collision with root package name */
    public boolean f23730b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f23731c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f23732d;

    /* renamed from: e, reason: collision with root package name */
    public int f23733e;

    /* renamed from: f, reason: collision with root package name */
    public int f23734f;

    /* renamed from: g, reason: collision with root package name */
    public Rect f23735g;

    /* renamed from: a, reason: collision with root package name */
    public final int[] f23729a = new int[4];

    /* renamed from: h, reason: collision with root package name */
    public int f23736h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f23737i = -1;

    public static int a(int i2, int i3) {
        return (i2 & 16777215) | ((i3 * 17) << 24);
    }

    public final void b(zzeq zzeqVar, boolean z, Rect rect, int[] iArr) {
        int i2;
        int i3;
        int i4 = !z ? 1 : 0;
        int iWidth = rect.width();
        int i5 = i4 * iWidth;
        int iHeight = rect.height();
        while (true) {
            int i6 = 0;
            do {
                int iH = 0;
                for (int i7 = 1; iH < i7 && i7 <= 64; i7 <<= 2) {
                    if (zzeqVar.b() < 4) {
                        i2 = -1;
                        i3 = 0;
                        break;
                    }
                    iH = (iH << 4) | zzeqVar.h(4);
                }
                i2 = iH & 3;
                i3 = iH < 4 ? iWidth : iH >> 2;
                int iMin = Math.min(i3, iWidth - i6);
                if (iMin > 0) {
                    int i8 = i5 + iMin;
                    Arrays.fill(iArr, i5, i8, this.f23729a[i2]);
                    i6 += iMin;
                    i5 = i8;
                }
            } while (i6 < iWidth);
            i4 += 2;
            if (i4 >= iHeight) {
                return;
            }
            i5 = i4 * iWidth;
            zzeqVar.k();
        }
    }
}
