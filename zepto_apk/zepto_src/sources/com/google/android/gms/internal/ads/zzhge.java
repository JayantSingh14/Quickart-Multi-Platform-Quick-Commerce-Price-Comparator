package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import javax.crypto.AEADBadTagException;

/* loaded from: classes4.dex */
abstract class zzhge {

    /* renamed from: a, reason: collision with root package name */
    public final zzhgc f33752a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhgc f33753b;

    public zzhge(byte[] bArr) throws GeneralSecurityException {
        if (!zzhhb.a(1)) {
            throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
        }
        this.f33752a = a(1, bArr);
        this.f33753b = a(0, bArr);
    }

    public abstract zzhgc a(int i2, byte[] bArr);

    public final byte[] b(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() < 16) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        int iPosition = byteBuffer.position();
        byte[] bArr3 = new byte[16];
        byteBuffer.position(byteBuffer.limit() - 16);
        byteBuffer.get(bArr3);
        byteBuffer.position(iPosition);
        byteBuffer.limit(byteBuffer.limit() - 16);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        try {
            byte[] bArr4 = new byte[32];
            this.f33753b.c(0, bArr).get(bArr4);
            int length = bArr2.length;
            int i2 = length & 15;
            int i3 = i2 == 0 ? length : (length + 16) - i2;
            int iRemaining = byteBuffer.remaining();
            int i4 = iRemaining % 16;
            int i5 = (i4 == 0 ? iRemaining : (iRemaining + 16) - i4) + i3;
            ByteBuffer byteBufferOrder = ByteBuffer.allocate(i5 + 16).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.put(bArr2);
            byteBufferOrder.position(i3);
            byteBufferOrder.put(byteBuffer);
            byteBufferOrder.position(i5);
            byteBufferOrder.putLong(length);
            byteBufferOrder.putLong(iRemaining);
            if (!MessageDigest.isEqual(zzhgi.a(bArr4, byteBufferOrder.array()), bArr3)) {
                throw new GeneralSecurityException("invalid MAC");
            }
            byteBuffer.position(iPosition);
            zzhgc zzhgcVar = this.f33752a;
            zzhgcVar.getClass();
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
            if (bArr.length != zzhgcVar.b()) {
                int iB = zzhgcVar.b();
                throw new GeneralSecurityException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(iB).length() + 36), iB, "The nonce length (in bytes) must be "));
            }
            int iRemaining2 = byteBuffer.remaining();
            int i6 = iRemaining2 / 64;
            for (int i7 = 0; i7 < i6 + 1; i7++) {
                ByteBuffer byteBufferC = zzhgcVar.c(zzhgcVar.f33751b + i7, bArr);
                if (i7 == i6) {
                    zzhvp.c(byteBufferAllocate, byteBuffer, byteBufferC, iRemaining2 % 64);
                } else {
                    zzhvp.c(byteBufferAllocate, byteBuffer, byteBufferC, 64);
                }
            }
            return byteBufferAllocate.array();
        } catch (GeneralSecurityException e2) {
            throw new AEADBadTagException(e2.toString());
        }
    }
}
