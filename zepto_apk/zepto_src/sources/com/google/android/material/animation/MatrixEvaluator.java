package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import android.support.v4.media.a;

/* loaded from: classes4.dex */
public class MatrixEvaluator implements TypeEvaluator<Matrix> {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f39825a = new float[9];

    /* renamed from: b, reason: collision with root package name */
    public final float[] f39826b = new float[9];

    /* renamed from: c, reason: collision with root package name */
    public final Matrix f39827c = new Matrix();

    @Override // android.animation.TypeEvaluator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
        float[] fArr = this.f39825a;
        matrix.getValues(fArr);
        float[] fArr2 = this.f39826b;
        matrix2.getValues(fArr2);
        for (int i2 = 0; i2 < 9; i2++) {
            float f3 = fArr2[i2];
            float f4 = fArr[i2];
            fArr2[i2] = a.a(f3, f4, f2, f4);
        }
        Matrix matrix3 = this.f39827c;
        matrix3.setValues(fArr2);
        return matrix3;
    }
}
