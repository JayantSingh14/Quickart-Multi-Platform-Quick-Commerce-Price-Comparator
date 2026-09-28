package com.google.android.gms.internal.ads;

import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes4.dex */
public final class zzcu implements zzco {

    /* renamed from: b, reason: collision with root package name */
    public int f27142b;

    /* renamed from: c, reason: collision with root package name */
    public float f27143c = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    public float f27144d = 1.0f;

    /* renamed from: e, reason: collision with root package name */
    public zzcl f27145e;

    /* renamed from: f, reason: collision with root package name */
    public zzcl f27146f;

    /* renamed from: g, reason: collision with root package name */
    public zzcl f27147g;

    /* renamed from: h, reason: collision with root package name */
    public zzcl f27148h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f27149i;

    /* renamed from: j, reason: collision with root package name */
    public zzct f27150j;

    /* renamed from: k, reason: collision with root package name */
    public ByteBuffer f27151k;

    /* renamed from: l, reason: collision with root package name */
    public ByteBuffer f27152l;

    /* renamed from: m, reason: collision with root package name */
    public long f27153m;
    public long n;
    public boolean o;

    public zzcu() {
        zzcl zzclVar = zzcl.f26484e;
        this.f27145e = zzclVar;
        this.f27146f = zzclVar;
        this.f27147g = zzclVar;
        this.f27148h = zzclVar;
        ByteBuffer byteBuffer = zzco.f26781a;
        this.f27151k = byteBuffer;
        this.f27152l = byteBuffer;
        this.f27142b = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final long a(long j2) {
        if (this.n < 1024) {
            return (long) (j2 / this.f27143c);
        }
        long j3 = this.f27153m;
        this.f27150j.getClass();
        long jZza = j3 - ((r2.f27091j * r2.f27083b) * r2.f27090i.zza());
        int i2 = this.f27148h.f26485a;
        int i3 = this.f27147g.f26485a;
        return i2 == i3 ? zzfj.u(j2, this.n, jZza, RoundingMode.DOWN) : zzfj.u(j2, this.n * i3, jZza * i2, RoundingMode.DOWN);
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void b(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            zzct zzctVar = this.f27150j;
            zzctVar.getClass();
            this.f27153m += byteBuffer.remaining();
            int iRemaining = byteBuffer.remaining();
            zzcr zzcrVar = zzctVar.f27090i;
            int iZza = iRemaining / (zzctVar.f27083b * zzcrVar.zza());
            zzcrVar.A(iZza);
            zzcrVar.g(iRemaining, byteBuffer);
            zzctVar.f27091j += iZza;
            zzctVar.b();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final zzcl c(zzcl zzclVar) throws zzcn {
        int i2 = zzclVar.f26487c;
        if (i2 != 2 && i2 != 4) {
            throw new zzcn("Unhandled input format:", zzclVar);
        }
        int i3 = this.f27142b;
        if (i3 == -1) {
            i3 = zzclVar.f26485a;
        }
        this.f27145e = zzclVar;
        zzcl zzclVar2 = new zzcl(i3, zzclVar.f26486b, i2);
        this.f27146f = zzclVar2;
        this.f27149i = true;
        return zzclVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final boolean zzc() {
        if (this.f27146f.f26485a != -1) {
            return Math.abs(this.f27143c + (-1.0f)) >= 1.0E-4f || Math.abs(this.f27144d + (-1.0f)) >= 1.0E-4f || this.f27146f.f26485a != this.f27145e.f26485a;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zze() {
        zzct zzctVar = this.f27150j;
        if (zzctVar != null) {
            int i2 = zzctVar.f27091j;
            int i3 = zzctVar.o;
            int i4 = zzctVar.f27092k;
            float f2 = zzctVar.f27084c;
            float f3 = zzctVar.f27085d;
            int i5 = i4 + ((int) (((((((i2 - i3) / (f2 / f3)) + i3) + zzctVar.q) + zzctVar.f27093l) / (zzctVar.f27086e * f3)) + 0.5d));
            zzctVar.q = 0.0d;
            int i6 = zzctVar.f27089h;
            int i7 = i6 + i6;
            zzcr zzcrVar = zzctVar.f27090i;
            zzcrVar.A(i2 + i7);
            zzcrVar.h(i2 * zzctVar.f27083b, i7);
            zzctVar.f27091j += i7;
            zzctVar.b();
            if (zzctVar.f27092k > i5) {
                zzctVar.f27092k = Math.max(i5, 0);
            }
            zzctVar.f27091j = 0;
            zzctVar.o = 0;
            zzctVar.f27093l = 0;
        }
        this.o = true;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final ByteBuffer zzf() {
        zzct zzctVar = this.f27150j;
        if (zzctVar != null) {
            zzgqa.f(zzctVar.f27092k >= 0);
            int i2 = zzctVar.f27092k;
            int i3 = zzctVar.f27083b;
            zzcr zzcrVar = zzctVar.f27090i;
            int iZza = i2 * i3 * zzcrVar.zza();
            if (iZza > 0) {
                if (this.f27151k.capacity() < iZza) {
                    this.f27151k = ByteBuffer.allocateDirect(iZza).order(ByteOrder.nativeOrder());
                } else {
                    this.f27151k.clear();
                }
                ByteBuffer byteBuffer = this.f27151k;
                zzgqa.f(zzctVar.f27092k >= 0);
                int iMin = Math.min(byteBuffer.remaining() / (zzcrVar.zza() * i3), zzctVar.f27092k);
                zzcrVar.i(iMin, byteBuffer);
                zzctVar.f27092k -= iMin;
                System.arraycopy(zzcrVar.zzq(), iMin * i3, zzcrVar.zzq(), 0, zzctVar.f27092k * i3);
                this.f27151k.flip();
                this.n += iZza;
                this.f27152l = this.f27151k;
            }
        }
        ByteBuffer byteBuffer2 = this.f27152l;
        this.f27152l = zzco.f26781a;
        return byteBuffer2;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final boolean zzg() {
        if (this.o) {
            zzct zzctVar = this.f27150j;
            if (zzctVar != null) {
                zzgqa.f(zzctVar.f27092k >= 0);
                if (zzctVar.f27092k * zzctVar.f27083b * zzctVar.f27090i.zza() != 0) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzi() {
        if (zzc()) {
            zzcl zzclVar = this.f27145e;
            this.f27147g = zzclVar;
            zzcl zzclVar2 = this.f27146f;
            this.f27148h = zzclVar2;
            if (this.f27149i) {
                this.f27150j = new zzct(zzclVar.f26485a, zzclVar.f26486b, this.f27143c, this.f27144d, zzclVar2.f26485a, zzclVar.f26487c == 4);
            } else {
                zzct zzctVar = this.f27150j;
                if (zzctVar != null) {
                    zzctVar.f27091j = 0;
                    zzctVar.f27092k = 0;
                    zzctVar.f27093l = 0;
                    zzctVar.f27094m = 0;
                    zzctVar.n = 0;
                    zzctVar.o = 0;
                    zzctVar.p = 0;
                    zzctVar.q = 0.0d;
                    zzctVar.f27090i.zzg();
                }
            }
        }
        this.f27152l = zzco.f26781a;
        this.f27153m = 0L;
        this.n = 0L;
        this.o = false;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzj() {
        this.f27143c = 1.0f;
        this.f27144d = 1.0f;
        zzcl zzclVar = zzcl.f26484e;
        this.f27145e = zzclVar;
        this.f27146f = zzclVar;
        this.f27147g = zzclVar;
        this.f27148h = zzclVar;
        ByteBuffer byteBuffer = zzco.f26781a;
        this.f27151k = byteBuffer;
        this.f27152l = byteBuffer;
        this.f27142b = -1;
        this.f27149i = false;
        this.f27150j = null;
        this.f27153m = 0L;
        this.n = 0L;
        this.o = false;
    }
}
