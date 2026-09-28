package com.google.android.gms.internal.pal;

import android.util.Base64;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
final class zzbn {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f37547a = false;

    /* renamed from: b, reason: collision with root package name */
    public static MessageDigest f37548b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f37549c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static final Object f37550d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public static final CountDownLatch f37551e = new CountDownLatch(1);

    public static String a(zzaf zzafVar, String str) throws GeneralSecurityException {
        byte[] bArrD;
        byte[] bArrF = zzafVar.F();
        if (((Boolean) zzfv.f37741d.f37744c.a(zzgk.p)).booleanValue()) {
            int length = bArrF.length;
            Vector vector = null;
            if (length > 0) {
                int i2 = (length + 254) / 255;
                Vector vector2 = new Vector();
                for (int i3 = 0; i3 < i2; i3++) {
                    int i4 = i3 * 255;
                    try {
                        int length2 = bArrF.length;
                        if (length2 - i4 > 255) {
                            length2 = i4 + 255;
                        }
                        vector2.add(Arrays.copyOfRange(bArrF, i4, length2));
                    } catch (IndexOutOfBoundsException unused) {
                    }
                }
                vector = vector2;
            }
            if (vector == null || vector.size() == 0) {
                zzr zzrVarR = zzaf.R();
                zzrVarR.l(4096L);
                bArrD = d(str, ((zzaf) zzrVarR.h()).F(), true);
            } else {
                zzat zzatVarP = zzau.p();
                int size = vector.size();
                for (int i5 = 0; i5 < size; i5++) {
                    zzaby zzabyVarQ = zzaby.q(0, d(str, (byte[]) vector.get(i5), false), 256);
                    if (zzatVarP.f37406c) {
                        zzatVarP.k();
                        zzatVarP.f37406c = false;
                    }
                    zzau.q((zzau) zzatVarP.f37405b, zzabyVarQ);
                }
                byte[] bArrC = c(bArrF);
                zzaby zzabyVarQ2 = zzaby.q(0, bArrC, bArrC.length);
                if (zzatVarP.f37406c) {
                    zzatVarP.k();
                    zzatVarP.f37406c = false;
                }
                zzau.r((zzau) zzatVarP.f37405b, zzabyVarQ2);
                bArrD = ((zzau) zzatVarP.h()).F();
            }
        } else {
            if (zzdv.f37647a == null) {
                throw new GeneralSecurityException();
            }
            byte[] bArrZza = zzdv.f37647a.zza(bArrF, str != null ? str.getBytes() : new byte[0]);
            zzat zzatVarP2 = zzau.p();
            zzaby zzabyVarQ3 = zzaby.q(0, bArrZza, bArrZza.length);
            if (zzatVarP2.f37406c) {
                zzatVarP2.k();
                zzatVarP2.f37406c = false;
            }
            zzau.q((zzau) zzatVarP2.f37405b, zzabyVarQ3);
            if (zzatVarP2.f37406c) {
                zzatVarP2.k();
                zzatVarP2.f37406c = false;
            }
            zzau.s((zzau) zzatVarP2.f37405b);
            bArrD = ((zzau) zzatVarP2.h()).F();
        }
        return Base64.encodeToString(bArrD, 11);
    }

    public static void b() {
        synchronized (f37550d) {
            try {
                if (!f37547a) {
                    f37547a = true;
                    new Thread(new zzbm()).start();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static byte[] c(byte[] bArr) {
        byte[] bArrDigest;
        MessageDigest messageDigest;
        synchronized (f37549c) {
            try {
                b();
                MessageDigest messageDigest2 = null;
                try {
                    if (f37551e.await(2L, TimeUnit.SECONDS) && (messageDigest = f37548b) != null) {
                        messageDigest2 = messageDigest;
                    }
                } catch (InterruptedException unused) {
                }
                if (messageDigest2 == null) {
                    throw new NoSuchAlgorithmException("Cannot compute hash");
                }
                messageDigest2.reset();
                messageDigest2.update(bArr);
                bArrDigest = f37548b.digest();
            } finally {
            }
        }
        return bArrDigest;
    }

    public static byte[] d(String str, byte[] bArr, boolean z) {
        byte[] bArrArray;
        int i2 = true != z ? 255 : 239;
        if (bArr.length > i2) {
            zzr zzrVarR = zzaf.R();
            zzrVarR.l(4096L);
            bArr = ((zzaf) zzrVarR.h()).F();
        }
        int length = bArr.length;
        if (length < i2) {
            byte[] bArr2 = new byte[i2 - length];
            new SecureRandom().nextBytes(bArr2);
            bArrArray = ByteBuffer.allocate(i2 + 1).put((byte) length).put(bArr).put(bArr2).array();
        } else {
            bArrArray = ByteBuffer.allocate(i2 + 1).put((byte) length).put(bArr).array();
        }
        if (z) {
            bArrArray = ByteBuffer.allocate(256).put(c(bArrArray)).put(bArrArray).array();
        }
        byte[] bArr3 = new byte[256];
        zzbo[] zzboVarArr = new zzcn().G2;
        for (int i3 = 0; i3 < 12; i3++) {
            zzboVarArr[i3].zza(bArrArray, bArr3);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            zzabg zzabgVar = new zzabg(str.getBytes("UTF-8"));
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < 256; i6++) {
                i4 = (i4 + 1) & 255;
                byte[] bArr4 = zzabgVar.f37349a;
                byte b2 = bArr4[i4];
                i5 = (i5 + b2) & 255;
                bArr4[i4] = bArr4[i5];
                bArr4[i5] = b2;
                bArr3[i6] = (byte) (bArr4[(bArr4[i4] + b2) & 255] ^ bArr3[i6]);
            }
        }
        return bArr3;
    }
}
