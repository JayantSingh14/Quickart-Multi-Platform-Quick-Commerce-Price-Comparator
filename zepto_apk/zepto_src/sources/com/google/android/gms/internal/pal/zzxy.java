package com.google.android.gms.internal.pal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzxy implements zzjt {

    /* renamed from: a, reason: collision with root package name */
    public final zzyk f38136a;

    /* renamed from: b, reason: collision with root package name */
    public final zzkq f38137b;

    public zzxy(zzyk zzykVar, zzkq zzkqVar) {
        this.f38136a = zzykVar;
        this.f38137b = zzkqVar;
    }

    @Override // com.google.android.gms.internal.pal.zzjt
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArrA = this.f38136a.a(bArr);
        return zzxo.c(bArrA, this.f38137b.a(zzxo.c(bArr2, bArrA, Arrays.copyOf(ByteBuffer.allocate(8).putLong(0L).array(), 8))));
    }
}
