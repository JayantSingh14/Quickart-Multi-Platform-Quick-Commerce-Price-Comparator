package com.google.android.gms.internal.pal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* loaded from: classes4.dex */
final class zznw implements zzny {
    @Override // com.google.android.gms.internal.pal.zzny
    public final byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws GeneralSecurityException {
        if (bArr.length != 32) {
            throw new InvalidAlgorithmParameterException("Unexpected key length: 32");
        }
        zzmt zzmtVar = new zzmt(bArr);
        int length = bArr3.length;
        if (length > 2147483631) {
            throw new GeneralSecurityException("plaintext too long");
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length + 16);
        zzmtVar.b(byteBufferAllocate, bArr2, bArr3, bArr4);
        return byteBufferAllocate.array();
    }

    @Override // com.google.android.gms.internal.pal.zzny
    public final int zza() {
        return 32;
    }

    @Override // com.google.android.gms.internal.pal.zzny
    public final byte[] zzb() {
        return zzol.f37979k;
    }
}
