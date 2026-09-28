package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzcq implements zzcr {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f26879a;

    /* renamed from: b, reason: collision with root package name */
    public float[] f26880b;

    /* renamed from: c, reason: collision with root package name */
    public float[] f26881c;

    /* renamed from: d, reason: collision with root package name */
    public float[] f26882d;

    /* renamed from: e, reason: collision with root package name */
    public double f26883e;

    /* renamed from: f, reason: collision with root package name */
    public double f26884f;

    /* renamed from: g, reason: collision with root package name */
    public double f26885g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ zzct f26886h;

    public zzcq(zzct zzctVar) {
        Objects.requireNonNull(zzctVar);
        this.f26886h = zzctVar;
        int i2 = zzctVar.f27089h;
        this.f26879a = new float[i2];
        int i3 = zzctVar.f27083b;
        this.f26880b = new float[i2 * i3];
        this.f26881c = new float[i2 * i3];
        this.f26882d = new float[i2 * i3];
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void A(int i2) {
        this.f26880b = k(this.f26880b, this.f26886h.f27091j, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void a(int i2, int i3) {
        int i4;
        int i5 = 0;
        while (true) {
            zzct zzctVar = this.f26886h;
            if (i5 >= zzctVar.f27089h / i3) {
                return;
            }
            double d2 = 0.0d;
            int i6 = 0;
            while (true) {
                i4 = zzctVar.f27083b * i3;
                if (i6 < i4) {
                    d2 += this.f26880b[(i4 * i5) + (r6 * i2) + i6];
                    i6++;
                }
            }
            this.f26879a[i5] = (float) (d2 / i4);
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void b(long j2, long j3, int i2) {
        int i3 = 0;
        while (true) {
            zzct zzctVar = this.f26886h;
            int i4 = zzctVar.f27083b;
            if (i3 >= i4) {
                return;
            }
            float[] fArr = this.f26881c;
            int i5 = zzctVar.f27092k;
            float[] fArr2 = this.f26882d;
            int i6 = (i2 * i4) + i3;
            float f2 = fArr2[i6];
            float f3 = fArr2[i6 + i4];
            long j4 = zzctVar.n * j2;
            long j5 = (r1 + 1) * j3;
            long j6 = j5 - j4;
            fArr[(i5 * i4) + i3] = ((j6 * f2) + ((r12 - j6) * f3)) / (j5 - (zzctVar.f27094m * j3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final int c(int i2, int i3) {
        return j(this.f26879a, 0, i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final int d(int i2, int i3, int i4) {
        return j(this.f26880b, i2, i3, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void e(int i2) {
        this.f26882d = k(this.f26882d, this.f26886h.f27093l, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void f(int i2, int i3, int i4, int i5, int i6) {
        float[] fArr = this.f26881c;
        float[] fArr2 = this.f26880b;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = (i5 * i3) + i7;
            int i9 = (i6 * i3) + i7;
            int i10 = (i4 * i3) + i7;
            for (int i11 = 0; i11 < i2; i11++) {
                fArr[i10] = ((fArr2[i9] * i11) + (fArr2[i8] * (i2 - i11))) / i2;
                i10 += i3;
                i8 += i3;
                i9 += i3;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void g(int i2, ByteBuffer byteBuffer) {
        zzct zzctVar = this.f26886h;
        byteBuffer.asFloatBuffer().get(this.f26880b, zzctVar.f27091j * zzctVar.f27083b, i2 / 4);
        byteBuffer.position(byteBuffer.position() + i2);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void h(int i2, int i3) {
        for (int i4 = 0; i4 < this.f26886h.f27083b * i3; i4++) {
            this.f26880b[i2 + i4] = 0.0f;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void i(int i2, ByteBuffer byteBuffer) {
        zzct zzctVar = this.f26886h;
        byteBuffer.asFloatBuffer().put(this.f26881c, 0, zzctVar.f27083b * i2);
        byteBuffer.position((i2 * 4 * zzctVar.f27083b) + byteBuffer.position());
    }

    public final int j(float[] fArr, int i2, int i3, int i4) {
        int i5 = 255;
        int i6 = 0;
        double d2 = 0.0d;
        double d3 = 1.0d;
        int i7 = i3;
        while (true) {
            double d4 = i5;
            double d5 = i6;
            if (i7 > i4) {
                this.f26883e = d3 / d5;
                this.f26884f = d2 / d4;
                return i6;
            }
            int i8 = 0;
            double dAbs = 0.0d;
            while (i8 < i7) {
                int i9 = this.f26886h.f27083b * i2;
                dAbs += Math.abs(fArr[i9 + i8] - fArr[(i9 + i7) + i8]);
                i8++;
                i5 = i5;
            }
            int i10 = i5;
            double d6 = d5 * dAbs;
            double d7 = i7;
            double d8 = d3 * d7;
            if (d6 < d8) {
                d3 = dAbs;
            }
            if (d6 < d8) {
                i6 = i7;
            }
            double d9 = d4 * dAbs;
            double d10 = d7 * d2;
            if (d9 > d10) {
                d2 = dAbs;
            }
            i5 = d9 > d10 ? i7 : i10;
            i7++;
        }
    }

    public final float[] k(float[] fArr, int i2, int i3) {
        int length = fArr.length;
        int i4 = this.f26886h.f27083b;
        int i5 = length / i4;
        return i2 + i3 <= i5 ? fArr : Arrays.copyOf(fArr, (((i5 * 3) / 2) + i3) * i4);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void r(int i2) {
        this.f26881c = k(this.f26881c, this.f26886h.f27092k, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final int zza() {
        return 4;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final boolean zzc() {
        double d2 = this.f26883e;
        return d2 != 0.0d && this.f26886h.p != 0 && this.f26884f <= d2 * 3.0d && d2 + d2 > this.f26885g * 3.0d;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzg() {
        this.f26885g = 0.0d;
        this.f26883e = 0.0d;
        this.f26884f = 0.0d;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzi() {
        this.f26885g = this.f26883e;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final /* synthetic */ Object zzp() {
        return this.f26882d;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final /* synthetic */ Object zzq() {
        return this.f26881c;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final /* synthetic */ Object zzr() {
        return this.f26880b;
    }
}
