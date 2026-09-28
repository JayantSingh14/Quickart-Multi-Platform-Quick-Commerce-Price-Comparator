package com.google.android.gms.internal.pal;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzob implements zzjy {

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f37962e = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    public final zzvj f37963a;

    /* renamed from: b, reason: collision with root package name */
    public final zzoc f37964b;

    /* renamed from: c, reason: collision with root package name */
    public final zzny f37965c;

    /* renamed from: d, reason: collision with root package name */
    public final zznx f37966d;

    public zzob(zzvj zzvjVar, zzoc zzocVar, zznx zznxVar, zzny zznyVar) {
        this.f37963a = zzvjVar;
        this.f37964b = zzocVar;
        this.f37966d = zznxVar;
        this.f37965c = zznyVar;
    }

    @Override // com.google.android.gms.internal.pal.zzjy
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws IllegalStateException, GeneralSecurityException {
        byte[] bArrD;
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        zzvj zzvjVar = this.f37963a;
        zzoc zzocVar = this.f37964b;
        zznx zznxVar = this.f37966d;
        zzny zznyVar = this.f37965c;
        zzod zzodVarA = zzocVar.a(zzvjVar.u().r());
        byte[] bArr3 = zzodVarA.f37968b;
        byte[] bArr4 = zzodVarA.f37967a;
        byte[] bArrC = zzxo.c(zzol.n, zzocVar.zzb(), zznxVar.a(), zznyVar.zzb());
        byte[] bArr5 = zzol.f37980l;
        byte[] bArr6 = zznz.f37955d;
        Charset charset = StandardCharsets.UTF_8;
        byte[] bytes = "psk_id_hash".getBytes(charset);
        byte[] bArr7 = zzol.o;
        byte[] bArrC2 = zzxo.c(zzol.f37969a, zznxVar.c(zzxo.c(bArr7, bArrC, bytes, bArr6), bArr5), zznxVar.c(zzxo.c(bArr7, bArrC, "info_hash".getBytes(charset), bArr2), bArr5));
        byte[] bArrC3 = zznxVar.c(zzxo.c(bArr7, bArrC, "secret".getBytes(charset), bArr6), bArr4);
        int iZza = zznyVar.zza();
        byte[] bArrB = zznxVar.b(iZza, bArrC3, zzxo.c(zzol.b(2, iZza), bArr7, bArrC, "key".getBytes(charset), bArrC2));
        byte[] bArrB2 = zznxVar.b(12, bArrC3, zzxo.c(zzol.b(2, 12), bArr7, bArrC, "base_nonce".getBytes(charset), bArrC2));
        BigInteger bigInteger = BigInteger.ONE;
        zznz zznzVar = new zznz(bArr3, bArrB, bArrB2, bigInteger.shiftLeft(96).subtract(bigInteger), zznyVar);
        byte[] bArr8 = f37962e;
        synchronized (zznzVar) {
            try {
                byte[] byteArray = zznzVar.f37958c.toByteArray();
                int length = byteArray.length;
                if (length != 12) {
                    if (length > 13) {
                        throw new GeneralSecurityException("integer too large");
                    }
                    if (length != 13) {
                        byte[] bArr9 = new byte[12];
                        System.arraycopy(byteArray, 0, bArr9, 12 - length, length);
                        byteArray = bArr9;
                    } else {
                        if (byteArray[0] != 0) {
                            throw new GeneralSecurityException("integer too large");
                        }
                        byteArray = Arrays.copyOfRange(byteArray, 1, 13);
                    }
                }
                bArrD = zzxo.d(bArrB2, byteArray);
                if (zznzVar.f37958c.compareTo(zznzVar.f37957b) >= 0) {
                    throw new GeneralSecurityException("message limit reached");
                }
                zznzVar.f37958c = zznzVar.f37958c.add(bigInteger);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzxo.c(bArr3, zznzVar.f37956a.a(bArrB, bArrD, bArr, bArr8));
    }
}
