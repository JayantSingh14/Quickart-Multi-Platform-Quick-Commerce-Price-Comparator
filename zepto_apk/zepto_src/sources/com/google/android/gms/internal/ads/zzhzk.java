package com.google.android.gms.internal.ads;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzhzk extends OutputStream {

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f34551f = new byte[0];

    /* renamed from: c, reason: collision with root package name */
    public int f34554c;

    /* renamed from: e, reason: collision with root package name */
    public int f34556e;

    /* renamed from: a, reason: collision with root package name */
    public final int f34552a = 128;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f34553b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public byte[] f34555d = new byte[128];

    public final synchronized zzhzl a() {
        try {
            int i2 = this.f34556e;
            byte[] bArr = this.f34555d;
            if (i2 >= bArr.length) {
                this.f34553b.add(new zzhzj(this.f34555d));
                this.f34555d = f34551f;
            } else if (i2 > 0) {
                this.f34553b.add(new zzhzj(Arrays.copyOf(bArr, i2)));
            }
            this.f34554c += this.f34556e;
            this.f34556e = 0;
        } catch (Throwable th) {
            throw th;
        }
        return zzhzl.y(this.f34553b);
    }

    public final void b(int i2) {
        this.f34553b.add(new zzhzj(this.f34555d));
        int length = this.f34554c + this.f34555d.length;
        this.f34554c = length;
        this.f34555d = new byte[Math.max(this.f34552a, Math.max(i2, length >>> 1))];
        this.f34556e = 0;
    }

    public final String toString() {
        int i2;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        synchronized (this) {
            i2 = this.f34554c + this.f34556e;
        }
        return String.format("<ByteString.Output@%s size=%d>", hexString, Integer.valueOf(i2));
    }

    @Override // java.io.OutputStream
    public final synchronized void write(int i2) {
        try {
            if (this.f34556e == this.f34555d.length) {
                b(1);
            }
            byte[] bArr = this.f34555d;
            int i3 = this.f34556e;
            this.f34556e = i3 + 1;
            bArr[i3] = (byte) i2;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = this.f34555d;
        int length = bArr2.length;
        int i4 = this.f34556e;
        int i5 = length - i4;
        if (i3 <= i5) {
            System.arraycopy(bArr, i2, bArr2, i4, i3);
            this.f34556e += i3;
            return;
        }
        System.arraycopy(bArr, i2, bArr2, i4, i5);
        int i6 = i3 - i5;
        b(i6);
        System.arraycopy(bArr, i2 + i5, this.f34555d, 0, i6);
        this.f34556e = i6;
    }
}
