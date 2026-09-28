package androidx.constraintlayout.core.motion.utils;

import android.support.v4.media.b;
import java.text.DecimalFormat;
import java.util.Arrays;

/* loaded from: classes3.dex */
public abstract class SplineSet {

    /* renamed from: a, reason: collision with root package name */
    public CurveFit f1854a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f1855b = new int[10];

    /* renamed from: c, reason: collision with root package name */
    public float[] f1856c = new float[10];

    /* renamed from: d, reason: collision with root package name */
    public int f1857d;

    /* renamed from: e, reason: collision with root package name */
    public String f1858e;

    public static class CoreSpline extends SplineSet {
    }

    public static class CustomSet extends SplineSet {
        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public final void b(float f2, int i2) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public final void c(int i2) {
            throw null;
        }
    }

    public static class CustomSpline extends SplineSet {
        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public final void b(float f2, int i2) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public final void c(int i2) {
            throw null;
        }
    }

    public static class Sort {
    }

    public final float a(float f2) {
        return (float) this.f1854a.b(f2);
    }

    public void b(float f2, int i2) {
        int[] iArr = this.f1855b;
        if (iArr.length < this.f1857d + 1) {
            this.f1855b = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f1856c;
            this.f1856c = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f1855b;
        int i3 = this.f1857d;
        iArr2[i3] = i2;
        this.f1856c[i3] = f2;
        this.f1857d = i3 + 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(int r18) {
        /*
            Method dump skipped, instructions count: 193
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.SplineSet.c(int):void");
    }

    public final String toString() {
        String string = this.f1858e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i2 = 0; i2 < this.f1857d; i2++) {
            StringBuilder sbX = b.x(string, "[");
            sbX.append(this.f1855b[i2]);
            sbX.append(" , ");
            sbX.append(decimalFormat.format(this.f1856c[i2]));
            sbX.append("] ");
            string = sbX.toString();
        }
        return string;
    }
}
