package com.google.maps.android.heatmaps;

/* loaded from: classes4.dex */
public class Gradient {

    /* renamed from: a, reason: collision with root package name */
    public final int f45598a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f45599b;

    /* renamed from: c, reason: collision with root package name */
    public final float[] f45600c;

    public class ColorInterval {

        /* renamed from: a, reason: collision with root package name */
        public final int f45601a;

        /* renamed from: b, reason: collision with root package name */
        public final int f45602b;

        /* renamed from: c, reason: collision with root package name */
        public final float f45603c;

        public ColorInterval(float f2, int i2, int i3) {
            this.f45601a = i2;
            this.f45602b = i3;
            this.f45603c = f2;
        }
    }

    public Gradient(float[] fArr, int[] iArr) {
        this(iArr, fArr, 1000);
    }

    public Gradient(int[] iArr, float[] fArr, int i2) {
        if (iArr.length != fArr.length) {
            throw new IllegalArgumentException("colors and startPoints should be same length");
        }
        if (iArr.length == 0) {
            throw new IllegalArgumentException("No colors have been defined");
        }
        for (int i3 = 1; i3 < fArr.length; i3++) {
            if (fArr[i3] <= fArr[i3 - 1]) {
                throw new IllegalArgumentException("startPoints should be in increasing order");
            }
        }
        this.f45598a = i2;
        int[] iArr2 = new int[iArr.length];
        this.f45599b = iArr2;
        float[] fArr2 = new float[fArr.length];
        this.f45600c = fArr2;
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
    }
}
