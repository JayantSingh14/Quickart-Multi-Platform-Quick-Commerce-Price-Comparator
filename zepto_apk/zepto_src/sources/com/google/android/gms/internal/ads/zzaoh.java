package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzaoh {

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f23871e = {0, 0, 1};

    /* renamed from: a, reason: collision with root package name */
    public boolean f23872a;

    /* renamed from: b, reason: collision with root package name */
    public int f23873b;

    /* renamed from: c, reason: collision with root package name */
    public int f23874c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f23875d;

    public final void a(byte[] bArr, int i2, int i3) {
        if (this.f23872a) {
            int i4 = i3 - i2;
            byte[] bArr2 = this.f23875d;
            int length = bArr2.length;
            int i5 = this.f23873b + i4;
            if (length < i5) {
                this.f23875d = Arrays.copyOf(bArr2, i5 + i5);
            }
            System.arraycopy(bArr, i2, this.f23875d, this.f23873b, i4);
            this.f23873b += i4;
        }
    }
}
