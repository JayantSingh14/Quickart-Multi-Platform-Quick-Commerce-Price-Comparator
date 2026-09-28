package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes3.dex */
public class VelocityMatrix {

    /* renamed from: a, reason: collision with root package name */
    public float f1894a;

    /* renamed from: b, reason: collision with root package name */
    public float f1895b;

    /* renamed from: c, reason: collision with root package name */
    public float f1896c;

    /* renamed from: d, reason: collision with root package name */
    public float f1897d;

    /* renamed from: e, reason: collision with root package name */
    public float f1898e;

    /* renamed from: f, reason: collision with root package name */
    public float f1899f;

    public final void a(float f2, float f3, int i2, int i3, float[] fArr) {
        float f4 = fArr[0];
        float f5 = fArr[1];
        float f6 = (f3 - 0.5f) * 2.0f;
        float f7 = f4 + this.f1896c;
        float f8 = f5 + this.f1897d;
        float f9 = (this.f1894a * (f2 - 0.5f) * 2.0f) + f7;
        float f10 = (this.f1895b * f6) + f8;
        float radians = (float) Math.toRadians(this.f1899f);
        float radians2 = (float) Math.toRadians(this.f1898e);
        double d2 = radians;
        double d3 = i3 * f6;
        float fSin = (((float) ((Math.sin(d2) * ((-i2) * r7)) - (Math.cos(d2) * d3))) * radians2) + f9;
        float fCos = (radians2 * ((float) ((Math.cos(d2) * (i2 * r7)) - (Math.sin(d2) * d3)))) + f10;
        fArr[0] = fSin;
        fArr[1] = fCos;
    }
}
