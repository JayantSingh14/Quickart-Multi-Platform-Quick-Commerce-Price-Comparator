package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzaef implements zzaep {

    /* renamed from: b, reason: collision with root package name */
    public final zzhb f22870b;

    /* renamed from: c, reason: collision with root package name */
    public final long f22871c;

    /* renamed from: d, reason: collision with root package name */
    public long f22872d;

    /* renamed from: f, reason: collision with root package name */
    public int f22874f;

    /* renamed from: g, reason: collision with root package name */
    public int f22875g;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f22873e = new byte[65536];

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f22869a = new byte[4096];

    static {
        zzal.a("media3.extractor");
    }

    public zzaef(zzhb zzhbVar, long j2, long j3) {
        this.f22870b = zzhbVar;
        this.f22872d = j2;
        this.f22871c = j3;
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int b(int i2, byte[] bArr, int i3) throws EOFException, InterruptedIOException {
        zzaef zzaefVar;
        int i4 = this.f22875g;
        int i5 = 0;
        if (i4 != 0) {
            int iMin = Math.min(i4, i3);
            System.arraycopy(this.f22873e, 0, bArr, i2, iMin);
            h(iMin);
            i5 = iMin;
        }
        if (i5 == 0) {
            zzaefVar = this;
            i5 = zzaefVar.i(bArr, i2, i3, 0, true);
        } else {
            zzaefVar = this;
        }
        if (i5 != -1) {
            zzaefVar.f22872d += i5;
        }
        return i5;
    }

    public final boolean d(int i2, boolean z) throws EOFException, InterruptedIOException {
        int iMin = Math.min(this.f22875g, i2);
        h(iMin);
        int i3 = iMin;
        while (i3 < i2 && i3 != -1) {
            i3 = i(this.f22869a, -i3, Math.min(i2, i3 + 4096), i3, z);
        }
        if (i3 != -1) {
            this.f22872d += i3;
        }
        return i3 != -1;
    }

    public final int e(int i2, byte[] bArr, int i3) throws EOFException, InterruptedIOException {
        zzaef zzaefVar;
        int iMin;
        g(i3);
        int i4 = this.f22875g;
        int i5 = this.f22874f;
        int i6 = i4 - i5;
        if (i6 == 0) {
            zzaefVar = this;
            iMin = zzaefVar.i(this.f22873e, i5, i3, 0, true);
            if (iMin == -1) {
                return -1;
            }
            zzaefVar.f22875g += iMin;
        } else {
            zzaefVar = this;
            iMin = Math.min(i3, i6);
        }
        System.arraycopy(zzaefVar.f22873e, zzaefVar.f22874f, bArr, i2, iMin);
        zzaefVar.f22874f += iMin;
        return iMin;
    }

    public final boolean f(int i2, boolean z) throws EOFException, InterruptedIOException {
        g(i2);
        int i3 = this.f22875g - this.f22874f;
        while (i3 < i2) {
            int i4 = i2;
            boolean z2 = z;
            i3 = i(this.f22873e, this.f22874f, i4, i3, z2);
            if (i3 == -1) {
                return false;
            }
            this.f22875g = this.f22874f + i3;
            i2 = i4;
            z = z2;
        }
        this.f22874f += i2;
        return true;
    }

    public final void g(int i2) {
        int i3 = this.f22874f + i2;
        int length = this.f22873e.length;
        if (i3 > length) {
            String str = zzfj.f31254a;
            this.f22873e = Arrays.copyOf(this.f22873e, Math.max(65536 + i3, Math.min(length + length, i3 + 524288)));
        }
    }

    public final void h(int i2) {
        int i3 = this.f22875g - i2;
        this.f22875g = i3;
        this.f22874f = 0;
        byte[] bArr = this.f22873e;
        byte[] bArr2 = i3 < bArr.length + (-524288) ? new byte[65536 + i3] : bArr;
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        this.f22873e = bArr2;
    }

    public final int i(byte[] bArr, int i2, int i3, int i4, boolean z) throws EOFException, InterruptedIOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int iB = this.f22870b.b(i2 + i4, bArr, i3 - i4);
        if (iB != -1) {
            return i4 + iB;
        }
        if (i4 == 0 && z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.gms.internal.ads.zzaep
    public final void r(int i2) throws EOFException, InterruptedIOException {
        f(i2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzaep
    public final void s(int i2, byte[] bArr, int i3) {
        t(bArr, i2, i3, false);
    }

    @Override // com.google.android.gms.internal.ads.zzaep
    public final boolean t(byte[] bArr, int i2, int i3, boolean z) {
        if (!f(i3, z)) {
            return false;
        }
        System.arraycopy(this.f22873e, this.f22874f - i3, bArr, i2, i3);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaep
    public final void u(byte[] bArr, int i2, int i3) throws EOFException, InterruptedIOException {
        v(bArr, i2, i3, false);
    }

    @Override // com.google.android.gms.internal.ads.zzaep
    public final boolean v(byte[] bArr, int i2, int i3, boolean z) throws EOFException, InterruptedIOException {
        int iMin;
        int i4 = this.f22875g;
        if (i4 == 0) {
            iMin = 0;
        } else {
            iMin = Math.min(i4, i3);
            System.arraycopy(this.f22873e, 0, bArr, i2, iMin);
            h(iMin);
        }
        int i5 = iMin;
        while (i5 < i3 && i5 != -1) {
            i5 = i(bArr, i2, i3, i5, z);
        }
        if (i5 != -1) {
            this.f22872d += i5;
        }
        return i5 != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzaep
    public final void zzf(int i2) throws EOFException, InterruptedIOException {
        d(i2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzaep
    public final void zzl() {
        this.f22874f = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzaep
    public final long zzm() {
        return this.f22872d + this.f22874f;
    }

    @Override // com.google.android.gms.internal.ads.zzaep
    public final long zzn() {
        return this.f22872d;
    }

    @Override // com.google.android.gms.internal.ads.zzaep
    public final long zzo() {
        return this.f22871c;
    }
}
