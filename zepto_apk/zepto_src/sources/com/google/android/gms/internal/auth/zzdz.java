package com.google.android.gms.internal.auth;

import android.support.v4.media.b;

/* loaded from: classes4.dex */
final class zzdz extends zzec {

    /* renamed from: d, reason: collision with root package name */
    public final int f36334d;

    public zzdz(byte[] bArr, int i2) {
        super(bArr);
        zzef.m(0, i2, bArr.length);
        this.f36334d = i2;
    }

    @Override // com.google.android.gms.internal.auth.zzec, com.google.android.gms.internal.auth.zzef
    public final byte b(int i2) {
        int i3 = this.f36334d;
        if (((i3 - (i2 + 1)) | i2) >= 0) {
            return this.f36335c[i2];
        }
        if (i2 < 0) {
            throw new ArrayIndexOutOfBoundsException(b.f(i2, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(b.d(i2, i3, "Index > length: ", ", "));
    }

    @Override // com.google.android.gms.internal.auth.zzec, com.google.android.gms.internal.auth.zzef
    public final byte d(int i2) {
        return this.f36335c[i2];
    }

    @Override // com.google.android.gms.internal.auth.zzec, com.google.android.gms.internal.auth.zzef
    public final int f() {
        return this.f36334d;
    }
}
