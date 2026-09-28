package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzcs implements zzcr {

    /* renamed from: a, reason: collision with root package name */
    public final short[] f27028a;

    /* renamed from: b, reason: collision with root package name */
    public short[] f27029b;

    /* renamed from: c, reason: collision with root package name */
    public short[] f27030c;

    /* renamed from: d, reason: collision with root package name */
    public short[] f27031d;

    /* renamed from: e, reason: collision with root package name */
    public int f27032e;

    /* renamed from: f, reason: collision with root package name */
    public int f27033f;

    /* renamed from: g, reason: collision with root package name */
    public int f27034g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ zzct f27035h;

    public zzcs(zzct zzctVar) {
        Objects.requireNonNull(zzctVar);
        this.f27035h = zzctVar;
        int i2 = zzctVar.f27089h;
        this.f27028a = new short[i2];
        int i3 = zzctVar.f27083b;
        this.f27029b = new short[i2 * i3];
        this.f27030c = new short[i2 * i3];
        this.f27031d = new short[i2 * i3];
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void A(int i2) {
        this.f27029b = k(this.f27029b, this.f27035h.f27091j, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void a(int i2, int i3) {
        int i4;
        short[] sArr = this.f27029b;
        int i5 = 0;
        while (true) {
            zzct zzctVar = this.f27035h;
            if (i5 >= zzctVar.f27089h / i3) {
                return;
            }
            int i6 = 0;
            int i7 = 0;
            while (true) {
                int i8 = zzctVar.f27083b;
                i4 = i8 * i3;
                if (i6 < i4) {
                    i7 += sArr[(i4 * i5) + (i8 * i2) + i6];
                    i6++;
                }
            }
            this.f27028a[i5] = (short) (i7 / i4);
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void b(long j2, long j3, int i2) {
        int i3 = 0;
        while (true) {
            zzct zzctVar = this.f27035h;
            int i4 = zzctVar.f27083b;
            if (i3 >= i4) {
                return;
            }
            short[] sArr = this.f27030c;
            int i5 = zzctVar.f27092k;
            short[] sArr2 = this.f27031d;
            int i6 = (i2 * i4) + i3;
            short s = sArr2[i6];
            short s2 = sArr2[i6 + i4];
            long j4 = zzctVar.n * j2;
            long j5 = zzctVar.f27094m * j3;
            long j6 = (r2 + 1) * j3;
            int i7 = i3;
            long j7 = j6 - j5;
            long j8 = j6 - j4;
            sArr[(i5 * i4) + i7] = (short) ((((j7 - j8) * s2) + (j8 * s)) / j7);
            i3 = i7 + 1;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final int c(int i2, int i3) {
        return j(this.f27028a, 0, i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final int d(int i2, int i3, int i4) {
        return j(this.f27029b, i2, i3, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void e(int i2) {
        this.f27031d = k(this.f27031d, this.f27035h.f27093l, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void f(int i2, int i3, int i4, int i5, int i6) {
        short[] sArr = this.f27030c;
        short[] sArr2 = this.f27029b;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = (i5 * i3) + i7;
            int i9 = (i6 * i3) + i7;
            int i10 = (i4 * i3) + i7;
            for (int i11 = 0; i11 < i2; i11++) {
                sArr[i10] = (short) (((sArr2[i9] * i11) + ((i2 - i11) * sArr2[i8])) / i2);
                i10 += i3;
                i8 += i3;
                i9 += i3;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void g(int i2, ByteBuffer byteBuffer) {
        zzct zzctVar = this.f27035h;
        byteBuffer.asShortBuffer().get(this.f27029b, zzctVar.f27091j * zzctVar.f27083b, i2 / 2);
        byteBuffer.position(byteBuffer.position() + i2);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void h(int i2, int i3) {
        for (int i4 = 0; i4 < this.f27035h.f27083b * i3; i4++) {
            this.f27029b[i2 + i4] = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void i(int i2, ByteBuffer byteBuffer) {
        zzct zzctVar = this.f27035h;
        byteBuffer.asShortBuffer().put(this.f27030c, 0, zzctVar.f27083b * i2);
        byteBuffer.position(((i2 + i2) * zzctVar.f27083b) + byteBuffer.position());
    }

    public final int j(short[] sArr, int i2, int i3, int i4) {
        int i5 = 1;
        int i6 = 255;
        int i7 = 0;
        int i8 = 0;
        while (i3 <= i4) {
            int iAbs = 0;
            for (int i9 = 0; i9 < i3; i9++) {
                int i10 = this.f27035h.f27083b * i2;
                iAbs += Math.abs(sArr[i10 + i9] - sArr[(i10 + i3) + i9]);
            }
            int i11 = iAbs * i7;
            int i12 = i5 * i3;
            if (i11 < i12) {
                i5 = iAbs;
            }
            if (i11 < i12) {
                i7 = i3;
            }
            int i13 = iAbs * i6;
            int i14 = i8 * i3;
            if (i13 > i14) {
                i8 = iAbs;
            }
            if (i13 > i14) {
                i6 = i3;
            }
            i3++;
        }
        this.f27032e = i5 / i7;
        this.f27033f = i8 / i6;
        return i7;
    }

    public final short[] k(short[] sArr, int i2, int i3) {
        int length = sArr.length;
        int i4 = this.f27035h.f27083b;
        int i5 = length / i4;
        return i2 + i3 <= i5 ? sArr : Arrays.copyOf(sArr, (((i5 * 3) / 2) + i3) * i4);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void r(int i2) {
        this.f27030c = k(this.f27030c, this.f27035h.f27092k, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final int zza() {
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final boolean zzc() {
        int i2 = this.f27032e;
        return i2 != 0 && this.f27035h.p != 0 && this.f27033f <= i2 * 3 && i2 + i2 > this.f27034g * 3;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzg() {
        this.f27034g = 0;
        this.f27032e = 0;
        this.f27033f = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final void zzi() {
        this.f27034g = this.f27032e;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final /* synthetic */ Object zzp() {
        return this.f27031d;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final /* synthetic */ Object zzq() {
        return this.f27030c;
    }

    @Override // com.google.android.gms.internal.ads.zzcr
    public final /* synthetic */ Object zzr() {
        return this.f27029b;
    }
}
