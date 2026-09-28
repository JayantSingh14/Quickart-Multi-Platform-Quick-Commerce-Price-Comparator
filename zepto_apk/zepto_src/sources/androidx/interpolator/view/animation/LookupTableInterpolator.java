package androidx.interpolator.view.animation;

import android.support.v4.media.a;
import android.view.animation.Interpolator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class LookupTableInterpolator implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f4757a;

    /* renamed from: b, reason: collision with root package name */
    public final float f4758b;

    public LookupTableInterpolator(float[] fArr) {
        this.f4757a = fArr;
        this.f4758b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f4757a;
        int iMin = Math.min((int) ((fArr.length - 1) * f2), fArr.length - 2);
        float f3 = this.f4758b;
        float f4 = (f2 - (iMin * f3)) / f3;
        float f5 = fArr[iMin];
        return a.a(fArr[iMin + 1], f5, f4, f5);
    }
}
