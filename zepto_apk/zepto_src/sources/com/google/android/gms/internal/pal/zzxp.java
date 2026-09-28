package com.google.android.gms.internal.pal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzxp implements zzjt {

    /* renamed from: a, reason: collision with root package name */
    public final zzmt f38124a;

    public zzxp(byte[] bArr) {
        this.f38124a = new zzmt(bArr);
    }

    @Override // com.google.android.gms.internal.pal.zzjt
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + 28);
        byte[] bArrA = zzyq.a(12);
        byteBufferAllocate.put(bArrA);
        this.f38124a.b(byteBufferAllocate, bArrA, bArr, bArr2);
        return byteBufferAllocate.array();
    }
}
