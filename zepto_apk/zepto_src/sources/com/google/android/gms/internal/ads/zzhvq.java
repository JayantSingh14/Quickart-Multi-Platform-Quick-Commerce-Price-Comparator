package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzhvq implements zzgzq {

    /* renamed from: a, reason: collision with root package name */
    public final zzhgd f34395a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f34396b;

    public zzhvq(byte[] bArr, byte[] bArr2) {
        this.f34395a = new zzhgd(bArr);
        this.f34396b = bArr2;
    }

    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length < 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        return this.f34395a.b(ByteBuffer.wrap(bArr, 12, length - 12), Arrays.copyOf(bArr, 12), bArr2);
    }

    @Override // com.google.android.gms.internal.ads.zzgzq
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.f34396b;
        int length = bArr3.length;
        if (length == 0) {
            return a(bArr, bArr2);
        }
        if (zzhkl.c(bArr3, bArr)) {
            return a(Arrays.copyOfRange(bArr, length, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
    }
}
