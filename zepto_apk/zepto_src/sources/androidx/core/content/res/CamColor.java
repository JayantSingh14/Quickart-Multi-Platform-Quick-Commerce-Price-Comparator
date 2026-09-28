package androidx.core.content.res;

import android.graphics.Color;
import androidx.annotation.RestrictTo;

@RestrictTo
/* loaded from: classes3.dex */
public class CamColor {

    /* renamed from: a, reason: collision with root package name */
    public final float f2736a;

    /* renamed from: b, reason: collision with root package name */
    public final float f2737b;

    /* renamed from: c, reason: collision with root package name */
    public final float f2738c;

    /* renamed from: d, reason: collision with root package name */
    public final float f2739d;

    /* renamed from: e, reason: collision with root package name */
    public final float f2740e;

    /* renamed from: f, reason: collision with root package name */
    public final float f2741f;

    public CamColor(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.f2736a = f2;
        this.f2737b = f3;
        this.f2738c = f4;
        this.f2739d = f5;
        this.f2740e = f6;
        this.f2741f = f7;
    }

    public static CamColor a(int i2) {
        ViewingConditions viewingConditions = ViewingConditions.f2776k;
        float fB = CamUtils.b(Color.red(i2));
        float fB2 = CamUtils.b(Color.green(i2));
        float fB3 = CamUtils.b(Color.blue(i2));
        float[][] fArr = CamUtils.f2745d;
        float[] fArr2 = fArr[0];
        float f2 = (fArr2[2] * fB3) + (fArr2[1] * fB2) + (fArr2[0] * fB);
        float[] fArr3 = fArr[1];
        float f3 = (fArr3[2] * fB3) + (fArr3[1] * fB2) + (fArr3[0] * fB);
        float[] fArr4 = fArr[2];
        float f4 = (fB3 * fArr4[2]) + (fB2 * fArr4[1]) + (fB * fArr4[0]);
        float[][] fArr5 = CamUtils.f2742a;
        float[] fArr6 = fArr5[0];
        float f5 = (fArr6[2] * f4) + (fArr6[1] * f3) + (fArr6[0] * f2);
        float[] fArr7 = fArr5[1];
        float f6 = (fArr7[2] * f4) + (fArr7[1] * f3) + (fArr7[0] * f2);
        float[] fArr8 = fArr5[2];
        float f7 = (f4 * fArr8[2]) + (f3 * fArr8[1]) + (f2 * fArr8[0]);
        float[] fArr9 = viewingConditions.f2783g;
        float f8 = fArr9[0] * f5;
        float f9 = fArr9[1] * f6;
        float f10 = fArr9[2] * f7;
        float fAbs = Math.abs(f8);
        float f11 = viewingConditions.f2784h;
        float fPow = (float) Math.pow((fAbs * f11) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow((Math.abs(f9) * f11) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow((Math.abs(f10) * f11) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f8) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f9) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f10) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d2 = fSignum3;
        float f12 = ((float) (((fSignum2 * (-12.0d)) + (fSignum * 11.0d)) + d2)) / 11.0f;
        float f13 = ((float) ((fSignum + fSignum2) - (d2 * 2.0d))) / 9.0f;
        float f14 = fSignum2 * 20.0f;
        float f15 = ((21.0f * fSignum3) + ((fSignum * 20.0f) + f14)) / 20.0f;
        float f16 = (((fSignum * 40.0f) + f14) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f13, f12)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f17 = fAtan2;
        float f18 = (3.1415927f * f17) / 180.0f;
        float f19 = f16 * viewingConditions.f2778b;
        float f20 = viewingConditions.f2777a;
        float f21 = viewingConditions.f2780d;
        float fPow4 = ((float) Math.pow(f19 / f20, viewingConditions.f2786j * f21)) * 100.0f;
        Math.sqrt(fPow4 / 100.0f);
        float f22 = f20 + 4.0f;
        float fPow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, viewingConditions.f2782f), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos((((((double) f17) < 20.14d ? f17 + 360.0f : f17) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * viewingConditions.f2781e) * viewingConditions.f2779c) * ((float) Math.sqrt((f13 * f13) + (f12 * f12)))) / (f15 + 0.305f), 0.9d)) * ((float) Math.sqrt(fPow4 / 100.0d));
        float f23 = viewingConditions.f2785i * fPow5;
        Math.sqrt((r3 * f21) / f22);
        float f24 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((f23 * 0.0228f) + 1.0f)) * 43.85965f;
        double d3 = f18;
        return new CamColor(f17, fPow5, fPow4, f24, fLog * ((float) Math.cos(d3)), fLog * ((float) Math.sin(d3)));
    }

    public static CamColor b(float f2, float f3, float f4) {
        ViewingConditions viewingConditions = ViewingConditions.f2776k;
        float f5 = viewingConditions.f2780d;
        Math.sqrt(f2 / 100.0d);
        float f6 = viewingConditions.f2777a + 4.0f;
        float f7 = viewingConditions.f2785i * f3;
        Math.sqrt(((f3 / ((float) Math.sqrt(r1))) * viewingConditions.f2780d) / f6);
        float f8 = (1.7f * f2) / ((0.007f * f2) + 1.0f);
        float fLog = ((float) Math.log((f7 * 0.0228d) + 1.0d)) * 43.85965f;
        double d2 = (3.1415927f * f4) / 180.0f;
        return new CamColor(f4, f3, f2, f8, fLog * ((float) Math.cos(d2)), fLog * ((float) Math.sin(d2)));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c(androidx.core.content.res.ViewingConditions r21) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.CamColor.c(androidx.core.content.res.ViewingConditions):int");
    }
}
