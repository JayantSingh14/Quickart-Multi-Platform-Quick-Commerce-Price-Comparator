package com.google.android.gms.internal.ads;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes4.dex */
public final class zzhdd implements zzgzq {

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f33579c = new byte[0];

    /* renamed from: d, reason: collision with root package name */
    public static final Set f33580d;

    /* renamed from: a, reason: collision with root package name */
    public final String f33581a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgzq f33582b;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesEaxKey");
        f33580d = Collections.unmodifiableSet(hashSet);
    }

    public zzhdd(zzhpd zzhpdVar, zzgzq zzgzqVar) {
        if (!f33580d.contains(zzhpdVar.C())) {
            String strC = zzhpdVar.C();
            throw new IllegalArgumentException(android.support.v4.media.b.s(new StringBuilder(String.valueOf(strC).length() + 67), "Unsupported DEK key type: ", strC, ". Only Tink AEAD key types are supported."));
        }
        this.f33581a = zzhpdVar.C();
        zzhpc zzhpcVarH = zzhpd.H(zzhpdVar);
        zzhpcVarH.p(zzhpw.RAW);
        zzhat.a(((zzhpd) zzhpcVarH.l()).g());
        this.f33582b = zzgzqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzq
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            int i2 = byteBufferWrap.getInt();
            if (i2 <= 0 || i2 > 4096 || i2 > bArr.length - 4) {
                throw new GeneralSecurityException("length of encrypted DEK too large");
            }
            byte[] bArr3 = new byte[i2];
            byteBufferWrap.get(bArr3, 0, i2);
            byte[] bArr4 = new byte[byteBufferWrap.remaining()];
            byteBufferWrap.get(bArr4, 0, byteBufferWrap.remaining());
            byte[] bArrZza = this.f33582b.zza(bArr3, f33579c);
            String str = this.f33581a;
            zzhzl zzhzlVar = zzhzl.f34557b;
            return ((zzgzq) ((zzhjw) zzhjb.f33880b.f33881a.get()).a(zzhje.f33884b.e(zzhjz.a(str, zzhzl.v(0, bArrZza, bArrZza.length), zzhoz.SYMMETRIC, zzhpw.RAW, null)), zzgzq.class)).zza(bArr4, bArr2);
        } catch (IndexOutOfBoundsException e2) {
            e = e2;
            throw new GeneralSecurityException("invalid ciphertext", e);
        } catch (NegativeArraySizeException e3) {
            e = e3;
            throw new GeneralSecurityException("invalid ciphertext", e);
        } catch (BufferUnderflowException e4) {
            e = e4;
            throw new GeneralSecurityException("invalid ciphertext", e);
        }
    }
}
