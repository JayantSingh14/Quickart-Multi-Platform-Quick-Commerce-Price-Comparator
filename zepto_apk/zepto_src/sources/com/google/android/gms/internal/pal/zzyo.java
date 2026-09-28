package com.google.android.gms.internal.pal;

import java.security.InvalidAlgorithmParameterException;

/* loaded from: classes4.dex */
public final class zzyo implements zzkq {

    /* renamed from: a, reason: collision with root package name */
    public final zzrj f38159a;

    /* renamed from: b, reason: collision with root package name */
    public final int f38160b;

    public zzyo(zzrj zzrjVar, int i2) throws InvalidAlgorithmParameterException {
        this.f38159a = zzrjVar;
        this.f38160b = i2;
        if (i2 < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        zzrjVar.a(i2, new byte[0]);
    }

    @Override // com.google.android.gms.internal.pal.zzkq
    public final byte[] a(byte[] bArr) {
        return this.f38159a.a(this.f38160b, bArr);
    }
}
