package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
public final class zzhvx implements zzgzq {

    /* renamed from: a, reason: collision with root package name */
    public final zzhvi f34407a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhws f34408b;

    /* renamed from: c, reason: collision with root package name */
    public final int f34409c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f34410d;

    public zzhvx(zzhvi zzhviVar, zzhws zzhwsVar, int i2, byte[] bArr) {
        this.f34407a = zzhviVar;
        this.f34408b = zzhwsVar;
        this.f34409c = i2;
        this.f34410d = bArr;
    }

    public static zzhvx a(zzhbl zzhblVar) {
        byte[] bArrB = zzhblVar.f33455b.f34463a.b();
        zzhbt zzhbtVar = zzhblVar.f33454a;
        zzhvi zzhviVar = new zzhvi(bArrB, zzhbtVar.f33485c);
        String strValueOf = String.valueOf(zzhbtVar.f33488f);
        zzhwr zzhwrVar = new zzhwr("HMAC".concat(strValueOf), new SecretKeySpec(zzhblVar.f33456c.f34463a.b(), "HMAC"));
        int i2 = zzhbtVar.f33486d;
        return new zzhvx(zzhviVar, new zzhws(zzhwrVar, i2), i2, zzhblVar.f33457d.b());
    }

    @Override // com.google.android.gms.internal.ads.zzgzq
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        byte[] bArr3 = this.f34410d;
        int length2 = bArr3.length;
        int i2 = this.f34409c;
        if (length < i2 + length2) {
            throw new GeneralSecurityException("Decryption failed (ciphertext too short).");
        }
        if (!zzhkl.c(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        int i3 = length - i2;
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, length2, i3);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, i3, length);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArrA = zzhvp.a(bArr2, bArrCopyOfRange, Arrays.copyOf(ByteBuffer.allocate(8).putLong(bArr2.length * 8).array(), 8));
        zzhws zzhwsVar = this.f34408b;
        byte[] bArr4 = zzhwsVar.f34436d;
        int length3 = bArr4.length;
        int i4 = zzhwsVar.f34434b;
        zzhmn zzhmnVar = zzhwsVar.f34433a;
        byte[] bArr5 = zzhwsVar.f34435c;
        if (!MessageDigest.isEqual(length3 > 0 ? zzhvp.a(bArr5, zzhmnVar.a(i4, zzhvp.a(bArrA, bArr4))) : zzhvp.a(bArr5, zzhmnVar.a(i4, bArrA)), bArrCopyOfRange2)) {
            throw new GeneralSecurityException("invalid MAC");
        }
        zzhvi zzhviVar = this.f34407a;
        int length4 = bArrCopyOfRange.length;
        int i5 = zzhviVar.f34383b;
        if (length4 < i5) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArr6 = new byte[i5];
        System.arraycopy(bArrCopyOfRange, 0, bArr6, 0, i5);
        int i6 = length4 - i5;
        byte[] bArr7 = new byte[i6];
        Cipher cipher = (Cipher) zzhvi.f34381d.get();
        byte[] bArr8 = new byte[zzhviVar.f34384c];
        System.arraycopy(bArr6, 0, bArr8, 0, i5);
        cipher.init(2, zzhviVar.f34382a, new IvParameterSpec(bArr8));
        if (cipher.doFinal(bArrCopyOfRange, i5, i6, bArr7, 0) == i6) {
            return bArr7;
        }
        throw new GeneralSecurityException("stored output's length does not match input's length");
    }
}
