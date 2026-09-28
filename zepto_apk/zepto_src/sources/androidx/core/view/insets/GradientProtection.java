package androidx.core.view.insets;

import android.view.animation.PathInterpolator;

/* loaded from: classes3.dex */
public class GradientProtection extends Protection {

    /* renamed from: c, reason: collision with root package name */
    public static final float[] f3227c;

    /* renamed from: b, reason: collision with root package name */
    public int f3228b;

    static {
        float[] fArr = new float[100];
        f3227c = fArr;
        PathInterpolator pathInterpolator = new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f);
        int length = fArr.length - 1;
        for (int i2 = length; i2 >= 0; i2--) {
            f3227c[i2] = pathInterpolator.getInterpolation((length - i2) / length);
        }
    }

    @Override // androidx.core.view.insets.Protection
    public final void a(int i2) {
        if (this.f3228b == i2) {
            return;
        }
        this.f3228b = i2;
        throw null;
    }
}
