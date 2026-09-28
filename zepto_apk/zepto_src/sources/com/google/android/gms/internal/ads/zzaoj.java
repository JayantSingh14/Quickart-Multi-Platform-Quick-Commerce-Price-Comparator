package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzaoj {

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f23889f = {0, 0, 1};

    /* renamed from: a, reason: collision with root package name */
    public boolean f23890a;

    /* renamed from: b, reason: collision with root package name */
    public int f23891b;

    /* renamed from: c, reason: collision with root package name */
    public int f23892c;

    /* renamed from: d, reason: collision with root package name */
    public int f23893d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f23894e;

    public final void a(byte[] bArr, int i2, int i3) {
        if (this.f23890a) {
            int i4 = i3 - i2;
            byte[] bArr2 = this.f23894e;
            int length = bArr2.length;
            int i5 = this.f23892c + i4;
            if (length < i5) {
                this.f23894e = Arrays.copyOf(bArr2, i5 + i5);
            }
            System.arraycopy(bArr, i2, this.f23894e, this.f23892c, i4);
            this.f23892c += i4;
        }
    }
}
