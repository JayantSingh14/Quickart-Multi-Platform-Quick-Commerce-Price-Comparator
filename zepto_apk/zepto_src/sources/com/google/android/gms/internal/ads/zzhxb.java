package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzhxb implements zzgzq {

    /* renamed from: a, reason: collision with root package name */
    public final zzhgg f34459a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f34460b;

    public zzhxb(byte[] bArr, byte[] bArr2) {
        this.f34459a = new zzhgg(bArr);
        this.f34460b = bArr2;
    }

    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length < 40) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        return this.f34459a.b(ByteBuffer.wrap(bArr, 24, length - 24), Arrays.copyOf(bArr, 24), bArr2);
    }

    @Override // com.google.android.gms.internal.ads.zzgzq
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.f34460b;
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
