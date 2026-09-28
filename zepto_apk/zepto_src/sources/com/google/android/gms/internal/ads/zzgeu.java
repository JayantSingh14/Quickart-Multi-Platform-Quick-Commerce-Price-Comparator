package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzgeu {

    /* renamed from: a, reason: collision with root package name */
    public static Cipher f32402a;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f32403b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static final Object f32404c = new Object();

    public static byte[] a(String str, byte[] bArr) throws zzget {
        byte[] bArrDoFinal;
        int length = bArr.length;
        try {
            byte[] bArrA = zzgay.a(str, false);
            int length2 = bArrA.length;
            if (length2 <= 16) {
                throw new zzget();
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length2);
            byteBufferAllocate.put(bArrA);
            byteBufferAllocate.flip();
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[length2 - 16];
            byteBufferAllocate.get(bArr2);
            byteBufferAllocate.get(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, CLConstants.AES_KEY_VAULT_KEY);
            synchronized (f32403b) {
                b().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                bArrDoFinal = b().doFinal(bArr3);
            }
            return bArrDoFinal;
        } catch (IllegalArgumentException | InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e2) {
            throw new zzget(e2);
        }
    }

    public static final Cipher b() {
        Cipher cipher;
        synchronized (f32404c) {
            try {
                if (f32402a == null) {
                    f32402a = Cipher.getInstance("AES/CBC/PKCS5Padding");
                }
                cipher = f32402a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cipher;
    }
}
