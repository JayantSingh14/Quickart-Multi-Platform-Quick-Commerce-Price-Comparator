package com.facebook.react.uimanager;

import com.facebook.yoga.YogaConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class Spacing {

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f19474e = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048};

    /* renamed from: a, reason: collision with root package name */
    public final float f19475a;

    /* renamed from: b, reason: collision with root package name */
    public final float[] f19476b;

    /* renamed from: c, reason: collision with root package name */
    public int f19477c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f19478d;

    @Metadata
    public static final class Companion {
    }

    public Spacing(float[] spacing, float f2) {
        Intrinsics.checkNotNullParameter(spacing, "spacing");
        this.f19475a = f2;
        this.f19476b = spacing;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float a(int r6) {
        /*
            r5 = this;
            r0 = 4
            if (r6 == r0) goto Lc
            r0 = 5
            if (r6 == r0) goto Lc
            switch(r6) {
                case 9: goto Lc;
                case 10: goto Lc;
                case 11: goto Lc;
                default: goto L9;
            }
        L9:
            float r0 = r5.f19475a
            goto Le
        Lc:
            r0 = 2143289344(0x7fc00000, float:NaN)
        Le:
            int r1 = r5.f19477c
            if (r1 != 0) goto L13
            goto L3e
        L13:
            int[] r2 = com.facebook.react.uimanager.Spacing.f19474e
            r3 = r2[r6]
            r3 = r3 & r1
            float[] r4 = r5.f19476b
            if (r3 == 0) goto L1f
            r6 = r4[r6]
            return r6
        L1f:
            boolean r3 = r5.f19478d
            if (r3 == 0) goto L3e
            r3 = 1
            if (r6 == r3) goto L2b
            r3 = 3
            if (r6 == r3) goto L2b
            r6 = 6
            goto L2c
        L2b:
            r6 = 7
        L2c:
            r3 = r2[r6]
            r3 = r3 & r1
            if (r3 == 0) goto L34
            r6 = r4[r6]
            return r6
        L34:
            r6 = 8
            r2 = r2[r6]
            r1 = r1 & r2
            if (r1 == 0) goto L3e
            r6 = r4[r6]
            return r6
        L3e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.Spacing.a(int):float");
    }

    public final void b(float f2, int i2) {
        float[] fArr = this.f19476b;
        if (FloatUtil.a(fArr[i2], f2)) {
            return;
        }
        fArr[i2] = f2;
        boolean zA = YogaConstants.a(f2);
        int[] iArr = f19474e;
        int i3 = zA ? this.f19477c & (~iArr[i2]) : this.f19477c | iArr[i2];
        this.f19477c = i3;
        this.f19478d = ((iArr[8] & i3) == 0 && (iArr[7] & i3) == 0 && (iArr[6] & i3) == 0 && (i3 & iArr[9]) == 0) ? false : true;
    }

    public Spacing() {
        this(new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN}, 0.0f);
    }

    public Spacing(float f2) {
        this(new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN}, f2);
    }
}
