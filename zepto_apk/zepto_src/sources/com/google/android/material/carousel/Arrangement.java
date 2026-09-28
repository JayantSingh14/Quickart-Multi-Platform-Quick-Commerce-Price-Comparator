package com.google.android.material.carousel;

/* loaded from: classes4.dex */
final class Arrangement {

    /* renamed from: a, reason: collision with root package name */
    public final int f40138a;

    /* renamed from: b, reason: collision with root package name */
    public final float f40139b;

    /* renamed from: c, reason: collision with root package name */
    public int f40140c;

    /* renamed from: d, reason: collision with root package name */
    public int f40141d;

    /* renamed from: e, reason: collision with root package name */
    public final float f40142e;

    /* renamed from: f, reason: collision with root package name */
    public final float f40143f;

    /* renamed from: g, reason: collision with root package name */
    public final int f40144g;

    /* renamed from: h, reason: collision with root package name */
    public final float f40145h;

    /* JADX WARN: Removed duplicated region for block: B:43:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Arrangement(int r4, float r5, float r6, float r7, int r8, float r9, int r10, float r11, int r12, float r13) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.carousel.Arrangement.<init>(int, float, float, float, int, float, int, float, int, float):void");
    }

    public static Arrangement a(float f2, float f3, float f4, float f5, int[] iArr, float f6, int[] iArr2, float f7, int[] iArr3) {
        Arrangement arrangement = null;
        int i2 = 1;
        for (int i3 : iArr3) {
            int length = iArr2.length;
            int i4 = 0;
            while (i4 < length) {
                int i5 = iArr2[i4];
                int length2 = iArr.length;
                int i6 = 0;
                while (i6 < length2) {
                    int i7 = length;
                    int i8 = i4;
                    int i9 = i2;
                    int i10 = length2;
                    int i11 = i6;
                    Arrangement arrangement2 = new Arrangement(i9, f3, f4, f5, iArr[i6], f6, i5, f7, i3, f2);
                    float f8 = arrangement2.f40145h;
                    if (arrangement == null || f8 < arrangement.f40145h) {
                        if (f8 == 0.0f) {
                            return arrangement2;
                        }
                        arrangement = arrangement2;
                    }
                    int i12 = i9 + 1;
                    i6 = i11 + 1;
                    i4 = i8;
                    i2 = i12;
                    length = i7;
                    length2 = i10;
                }
                i4++;
                i2 = i2;
                length = length;
            }
        }
        return arrangement;
    }

    public final String toString() {
        return "Arrangement [priority=" + this.f40138a + ", smallCount=" + this.f40140c + ", smallSize=" + this.f40139b + ", mediumCount=" + this.f40141d + ", mediumSize=" + this.f40142e + ", largeCount=" + this.f40144g + ", largeSize=" + this.f40143f + ", cost=" + this.f40145h + "]";
    }
}
