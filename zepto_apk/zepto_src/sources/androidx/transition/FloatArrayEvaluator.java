package androidx.transition;

import android.animation.TypeEvaluator;

/* loaded from: classes3.dex */
class FloatArrayEvaluator implements TypeEvaluator<float[]> {

    /* renamed from: a, reason: collision with root package name */
    public float[] f12069a;

    @Override // android.animation.TypeEvaluator
    public final float[] evaluate(float f2, float[] fArr, float[] fArr2) {
        float[] fArr3 = fArr;
        float[] fArr4 = fArr2;
        float[] fArr5 = this.f12069a;
        if (fArr5 == null) {
            fArr5 = new float[fArr3.length];
        }
        for (int i2 = 0; i2 < fArr5.length; i2++) {
            float f3 = fArr3[i2];
            fArr5[i2] = android.support.v4.media.a.a(fArr4[i2], f3, f2, f3);
        }
        return fArr5;
    }
}
