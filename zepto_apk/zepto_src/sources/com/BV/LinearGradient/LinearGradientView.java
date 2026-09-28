package com.BV.LinearGradient;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;

/* loaded from: classes.dex */
public class LinearGradientView extends View {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f13877a;

    /* renamed from: b, reason: collision with root package name */
    public Path f13878b;

    /* renamed from: c, reason: collision with root package name */
    public RectF f13879c;

    /* renamed from: d, reason: collision with root package name */
    public float[] f13880d;

    /* renamed from: e, reason: collision with root package name */
    public float[] f13881e;

    /* renamed from: f, reason: collision with root package name */
    public float[] f13882f;

    /* renamed from: g, reason: collision with root package name */
    public int[] f13883g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f13884h;

    /* renamed from: i, reason: collision with root package name */
    public float[] f13885i;

    /* renamed from: j, reason: collision with root package name */
    public float f13886j;

    /* renamed from: k, reason: collision with root package name */
    public int[] f13887k;

    /* renamed from: l, reason: collision with root package name */
    public float[] f13888l;

    public LinearGradientView(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        this.f13877a = new Paint(1);
        this.f13881e = new float[]{0.0f, 0.0f};
        this.f13882f = new float[]{0.0f, 1.0f};
        this.f13884h = false;
        this.f13885i = new float[]{0.5f, 0.5f};
        this.f13886j = 45.0f;
        this.f13887k = new int[]{0, 0};
        this.f13888l = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public final void a() {
        float[] fArr;
        float[] fArr2;
        float[] fArr3;
        int[] iArr = this.f13883g;
        if (iArr != null) {
            float[] fArr4 = this.f13880d;
            if (fArr4 == null || iArr.length == fArr4.length) {
                if (!this.f13884h || this.f13885i == null) {
                    float[] fArr5 = this.f13881e;
                    float f2 = fArr5[0];
                    int[] iArr2 = this.f13887k;
                    float f3 = iArr2[0];
                    float f4 = fArr5[1];
                    float f5 = iArr2[1];
                    fArr = new float[]{f2 * f3, f4 * f5};
                    float[] fArr6 = this.f13882f;
                    fArr2 = new float[]{fArr6[0] * f3, fArr6[1] * f5};
                } else {
                    float f6 = 90.0f - this.f13886j;
                    int[] iArr3 = this.f13887k;
                    float f7 = f6 % 360.0f;
                    if (f7 < 0.0f) {
                        f7 += 360.0f;
                    }
                    if (f7 % 90.0f == 0.0f) {
                        float f8 = iArr3[0] / 2.0f;
                        float f9 = iArr3[1] / 2.0f;
                        fArr3 = f7 == 0.0f ? new float[]{-f8, 0.0f} : f7 == 90.0f ? new float[]{0.0f, -f9} : f7 == 180.0f ? new float[]{f8, 0.0f} : new float[]{0.0f, f9};
                    } else {
                        float fTan = (float) Math.tan((f7 * 3.141592653589793d) / 180.0d);
                        float f10 = (-1.0f) / fTan;
                        float f11 = iArr3[0] / 2.0f;
                        float f12 = iArr3[1] / 2.0f;
                        float[] fArr7 = f7 < 90.0f ? new float[]{-f11, -f12} : f7 < 180.0f ? new float[]{f11, -f12} : f7 < 270.0f ? new float[]{f11, f12} : new float[]{-f11, f12};
                        float f13 = (fArr7[1] - (fArr7[0] * f10)) / (fTan - f10);
                        fArr3 = new float[]{f13, fTan * f13};
                    }
                    float[] fArr8 = this.f13885i;
                    float f14 = fArr8[0];
                    int[] iArr4 = this.f13887k;
                    float[] fArr9 = {f14 * iArr4[0], fArr8[1] * iArr4[1]};
                    fArr = new float[]{fArr9[0] + fArr3[0], fArr9[1] - fArr3[1]};
                    fArr2 = new float[]{fArr9[0] - fArr3[0], fArr9[1] + fArr3[1]};
                }
                this.f13877a.setShader(new LinearGradient(fArr[0], fArr[1], fArr2[0], fArr2[1], this.f13883g, this.f13880d, Shader.TileMode.CLAMP));
                invalidate();
            }
        }
    }

    public final void b() {
        if (this.f13878b == null) {
            this.f13878b = new Path();
            this.f13879c = new RectF();
        }
        this.f13878b.reset();
        RectF rectF = this.f13879c;
        int[] iArr = this.f13887k;
        rectF.set(0.0f, 0.0f, iArr[0], iArr[1]);
        this.f13878b.addRoundRect(this.f13879c, this.f13888l, Path.Direction.CW);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = this.f13878b;
        Paint paint = this.f13877a;
        if (path == null) {
            canvas.drawPaint(paint);
        } else {
            canvas.drawPath(path, paint);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.f13887k = new int[]{i2, i3};
        b();
        a();
    }

    public void setAngle(float f2) {
        this.f13886j = f2;
        a();
    }

    public void setAngleCenter(ReadableArray readableArray) {
        this.f13885i = new float[]{(float) readableArray.getDouble(0), (float) readableArray.getDouble(1)};
        a();
    }

    public void setBorderRadii(ReadableArray readableArray) {
        int size = readableArray.size();
        float[] fArr = new float[size];
        for (int i2 = 0; i2 < size; i2++) {
            fArr[i2] = PixelUtil.b((float) readableArray.getDouble(i2));
        }
        this.f13888l = fArr;
        b();
        a();
    }

    public void setColors(ReadableArray readableArray) {
        int size = readableArray.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = readableArray.getType(i2) == ReadableType.Map ? ColorPropConverter.getColor(readableArray.getMap(i2), getContext()).intValue() : readableArray.getInt(i2);
        }
        this.f13883g = iArr;
        a();
    }

    public void setEndPoint(ReadableArray readableArray) {
        this.f13882f = new float[]{(float) readableArray.getDouble(0), (float) readableArray.getDouble(1)};
        a();
    }

    public void setLocations(ReadableArray readableArray) {
        int size = readableArray.size();
        float[] fArr = new float[size];
        for (int i2 = 0; i2 < size; i2++) {
            fArr[i2] = (float) readableArray.getDouble(i2);
        }
        this.f13880d = fArr;
        a();
    }

    public void setStartPoint(ReadableArray readableArray) {
        this.f13881e = new float[]{(float) readableArray.getDouble(0), (float) readableArray.getDouble(1)};
        a();
    }

    public void setUseAngle(boolean z) {
        this.f13884h = z;
        a();
    }
}
