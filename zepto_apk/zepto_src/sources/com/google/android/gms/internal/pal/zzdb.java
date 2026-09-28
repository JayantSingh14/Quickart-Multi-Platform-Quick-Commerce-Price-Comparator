package com.google.android.gms.internal.pal;

import android.util.Base64;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzdb {

    /* renamed from: a, reason: collision with root package name */
    public static Cipher f37605a;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f37606b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static final Object f37607c = new Object();

    public static String a(byte[] bArr, byte[] bArr2) throws zzda {
        byte[] bArrDoFinal;
        byte[] iv;
        int length = bArr.length;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, CLConstants.AES_KEY_VAULT_KEY);
            synchronized (f37606b) {
                c().init(1, secretKeySpec, (SecureRandom) null);
                bArrDoFinal = c().doFinal(bArr2);
                iv = c().getIV();
            }
            int length2 = bArrDoFinal.length + iv.length;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length2);
            byteBufferAllocate.put(iv).put(bArrDoFinal);
            byteBufferAllocate.flip();
            byte[] bArr3 = new byte[length2];
            byteBufferAllocate.get(bArr3);
            return Base64.encodeToString(bArr3, 2);
        } catch (InvalidKeyException e2) {
            throw new zzda(e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new zzda(e3);
        } catch (BadPaddingException e4) {
            throw new zzda(e4);
        } catch (IllegalBlockSizeException e5) {
            throw new zzda(e5);
        } catch (NoSuchPaddingException e6) {
            throw new zzda(e6);
        }
    }

    public static byte[] b(byte[] bArr, String str) throws zzda {
        byte[] bArrDoFinal;
        int length = bArr.length;
        try {
            byte[] bArrA = zzbj.a(str, false);
            int length2 = bArrA.length;
            if (length2 <= 16) {
                throw new zzda();
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length2);
            byteBufferAllocate.put(bArrA);
            byteBufferAllocate.flip();
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[length2 - 16];
            byteBufferAllocate.get(bArr2);
            byteBufferAllocate.get(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, CLConstants.AES_KEY_VAULT_KEY);
            synchronized (f37606b) {
                c().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                bArrDoFinal = c().doFinal(bArr3);
            }
            return bArrDoFinal;
        } catch (IllegalArgumentException e2) {
            throw new zzda(e2);
        } catch (InvalidAlgorithmParameterException e3) {
            throw new zzda(e3);
        } catch (InvalidKeyException e4) {
            throw new zzda(e4);
        } catch (NoSuchAlgorithmException e5) {
            throw new zzda(e5);
        } catch (BadPaddingException e6) {
            throw new zzda(e6);
        } catch (IllegalBlockSizeException e7) {
            throw new zzda(e7);
        } catch (NoSuchPaddingException e8) {
            throw new zzda(e8);
        }
    }

    public static final Cipher c() {
        Cipher cipher;
        synchronized (f37607c) {
            try {
                if (f37605a == null) {
                    f37605a = Cipher.getInstance("AES/CBC/PKCS5Padding");
                }
                cipher = f37605a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cipher;
    }
}
