package com.google.android.gms.internal.pal;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Mac;

/* loaded from: classes4.dex */
final class zzoo implements zzoc {

    /* renamed from: a, reason: collision with root package name */
    public final zznx f37984a;

    public zzoo(zznx zznxVar) {
        this.f37984a = zznxVar;
    }

    @Override // com.google.android.gms.internal.pal.zzoc
    public final zzod a(byte[] bArr) throws GeneralSecurityException {
        byte[] bArrB = zzyt.b();
        byte[] bArrA = zzyt.a(bArrB, bArr);
        byte[] bArrC = zzyt.c(bArrB);
        byte[] bArrC2 = zzxo.c(bArrC, bArr);
        byte[] bArrC3 = zzxo.c(zzol.f37981m, zzol.f37970b);
        zznx zznxVar = this.f37984a;
        int macLength = Mac.getInstance(zznxVar.f37954a).getMacLength();
        Charset charset = StandardCharsets.UTF_8;
        byte[] bytes = "eae_prk".getBytes(charset);
        byte[] bArr2 = zzol.o;
        return new zzod(zznxVar.b(macLength, zznxVar.c(zzxo.c(bArr2, bArrC3, bytes, bArrA), null), zzxo.c(zzol.b(2, macLength), bArr2, bArrC3, "shared_secret".getBytes(charset), bArrC2)), bArrC);
    }

    @Override // com.google.android.gms.internal.pal.zzoc
    public final byte[] zzb() throws GeneralSecurityException {
        if (Arrays.equals(this.f37984a.a(), zzol.f37974f)) {
            return zzol.f37970b;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}
