package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class zzta extends zzcp {

    /* renamed from: i, reason: collision with root package name */
    public int f35577i;

    /* renamed from: j, reason: collision with root package name */
    public int f35578j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f35579k;

    /* renamed from: l, reason: collision with root package name */
    public int f35580l;

    /* renamed from: m, reason: collision with root package name */
    public byte[] f35581m = zzfj.f31255b;
    public int n;
    public long o;

    @Override // com.google.android.gms.internal.ads.zzco
    public final long a(long j2) {
        return Math.max(0L, j2 - zzfj.t(this.f26854b.f26485a, this.f35578j + this.f35577i));
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void b(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i2 = iLimit - iPosition;
        if (i2 == 0) {
            return;
        }
        int iMin = Math.min(i2, this.f35580l);
        this.o += iMin / this.f26854b.f26488d;
        this.f35580l -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.f35580l <= 0) {
            int i3 = i2 - iMin;
            int length = (this.n + i3) - this.f35581m.length;
            ByteBuffer byteBufferD = d(length);
            int i4 = this.n;
            String str = zzfj.f31254a;
            int iMax = Math.max(0, Math.min(length, i4));
            byteBufferD.put(this.f35581m, 0, iMax);
            int iMax2 = Math.max(0, Math.min(length - iMax, i3));
            byteBuffer.limit(byteBuffer.position() + iMax2);
            byteBufferD.put(byteBuffer);
            byteBuffer.limit(iLimit);
            int i5 = i3 - iMax2;
            int i6 = this.n - iMax;
            this.n = i6;
            byte[] bArr = this.f35581m;
            System.arraycopy(bArr, iMax, bArr, 0, i6);
            byteBuffer.get(this.f35581m, this.n, i5);
            this.n += i5;
            byteBufferD.flip();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final zzcl e(zzcl zzclVar) throws zzcn {
        if (!zzfj.a(zzclVar.f26487c)) {
            throw new zzcn("Unhandled input format:", zzclVar);
        }
        this.f35579k = true;
        return (this.f35577i == 0 && this.f35578j == 0) ? zzcl.f26484e : zzclVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final void f() {
        if (this.f35579k) {
            if (this.n > 0) {
                this.o += r0 / this.f26854b.f26488d;
            }
            this.n = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final void g() {
        if (this.f35579k) {
            this.f35579k = false;
            int i2 = this.f35578j;
            int i3 = this.f26854b.f26488d;
            this.f35581m = new byte[i2 * i3];
            this.f35580l = this.f35577i * i3;
        }
        this.n = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final void h() {
        this.f35581m = zzfj.f31255b;
    }

    @Override // com.google.android.gms.internal.ads.zzcp, com.google.android.gms.internal.ads.zzco
    public final ByteBuffer zzf() {
        int i2;
        if (super.zzg() && (i2 = this.n) > 0) {
            d(i2).put(this.f35581m, 0, this.n).flip();
            this.n = 0;
        }
        return super.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzcp, com.google.android.gms.internal.ads.zzco
    public final boolean zzg() {
        return super.zzg() && this.n == 0;
    }
}
