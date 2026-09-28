package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
final class zznx {

    /* renamed from: a, reason: collision with root package name */
    public final String f37954a;

    public zznx(String str) {
        this.f37954a = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] a() throws java.security.GeneralSecurityException {
        /*
            r5 = this;
            java.lang.String r0 = r5.f37954a
            int r1 = r0.hashCode()
            r2 = 984523022(0x3aaea10e, float:0.0013323145)
            r3 = 1
            r4 = 2
            if (r1 == r2) goto L2c
            r2 = 984524074(0x3aaea52a, float:0.0013324369)
            if (r1 == r2) goto L22
            r2 = 984525777(0x3aaeabd1, float:0.0013326352)
            if (r1 == r2) goto L18
            goto L36
        L18:
            java.lang.String r1 = "HmacSha512"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L36
            r0 = r4
            goto L37
        L22:
            java.lang.String r1 = "HmacSha384"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L36
            r0 = r3
            goto L37
        L2c:
            java.lang.String r1 = "HmacSha256"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L36
            r0 = 0
            goto L37
        L36:
            r0 = -1
        L37:
            if (r0 == 0) goto L4b
            if (r0 == r3) goto L48
            if (r0 != r4) goto L40
            byte[] r0 = com.google.android.gms.internal.pal.zzol.f37976h
            return r0
        L40:
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException
            java.lang.String r1 = "Could not determine HPKE KDF ID"
            r0.<init>(r1)
            throw r0
        L48:
            byte[] r0 = com.google.android.gms.internal.pal.zzol.f37975g
            return r0
        L4b:
            byte[] r0 = com.google.android.gms.internal.pal.zzol.f37974f
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zznx.a():byte[]");
    }

    public final byte[] b(int i2, byte[] bArr, byte[] bArr2) throws IllegalStateException, GeneralSecurityException {
        zzxz zzxzVar = zzxz.f38142f;
        String str = this.f37954a;
        Mac mac = (Mac) zzxzVar.a(str);
        if (i2 > mac.getMacLength() * 255) {
            throw new GeneralSecurityException("size too large");
        }
        byte[] bArr3 = new byte[i2];
        mac.init(new SecretKeySpec(bArr, str));
        byte[] bArrDoFinal = new byte[0];
        int i3 = 1;
        int i4 = 0;
        while (true) {
            mac.update(bArrDoFinal);
            mac.update(bArr2);
            mac.update((byte) i3);
            bArrDoFinal = mac.doFinal();
            int length = bArrDoFinal.length;
            int i5 = i4 + length;
            if (i5 >= i2) {
                System.arraycopy(bArrDoFinal, 0, bArr3, i4, i2 - i4);
                return bArr3;
            }
            System.arraycopy(bArrDoFinal, 0, bArr3, i4, length);
            i3++;
            i4 = i5;
        }
    }

    public final byte[] c(byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        zzxz zzxzVar = zzxz.f38142f;
        String str = this.f37954a;
        Mac mac = (Mac) zzxzVar.a(str);
        if (bArr2 == null || bArr2.length == 0) {
            mac.init(new SecretKeySpec(new byte[mac.getMacLength()], str));
        } else {
            mac.init(new SecretKeySpec(bArr2, str));
        }
        return mac.doFinal(bArr);
    }
}
