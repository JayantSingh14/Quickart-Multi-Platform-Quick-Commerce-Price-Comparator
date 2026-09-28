package com.google.ads.interactivemedia.v3.internal;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
final class zzfs {
    static boolean zza = false;
    public static final /* synthetic */ int zzc = 0;
    private static MessageDigest zzd;
    private static final Object zze = new Object();
    private static final Object zzf = new Object();
    static final CountDownLatch zzb = new CountDownLatch(1);

    public static String zza(byte[] bArr, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] bArrZzg;
        Vector vectorZzb = zzb(bArr, 255);
        if (vectorZzb == null || vectorZzb.isEmpty()) {
            bArrZzg = zzg(zzf(4096).zzav(), str, true);
        } else {
            zzbo zzboVarZza = zzbp.zza();
            int size = vectorZzb.size();
            for (int i2 = 0; i2 < size; i2++) {
                zzboVarZza.zza(zzabn.zzs(zzg((byte[]) vectorZzb.get(i2), str, false), 0, 256));
            }
            byte[] bArrZze = zze(bArr);
            zzabn zzabnVar = zzabn.zzb;
            zzboVarZza.zzb(zzabn.zzs(bArrZze, 0, bArrZze.length));
            bArrZzg = ((zzbp) zzboVarZza.zzan()).zzav();
        }
        return zzfo.zza(bArrZzg, true);
    }

    public static Vector zzb(byte[] bArr, int i2) {
        int length = bArr.length;
        if (length <= 0) {
            return null;
        }
        int i3 = length + 254;
        Vector vector = new Vector();
        for (int i4 = 0; i4 < i3 / 255; i4++) {
            int i5 = i4 * 255;
            try {
                int length2 = bArr.length;
                if (length2 - i5 > 255) {
                    length2 = i5 + 255;
                }
                vector.add(Arrays.copyOfRange(bArr, i5, length2));
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    public static void zzd() {
        synchronized (zzf) {
            try {
                if (!zza) {
                    zza = true;
                    new Thread(new zzfr(null)).start();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static byte[] zze(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] bArrDigest;
        MessageDigest messageDigest;
        synchronized (zze) {
            try {
                zzd();
                MessageDigest messageDigest2 = null;
                try {
                    if (zzb.await(2L, TimeUnit.SECONDS) && (messageDigest = zzd) != null) {
                        messageDigest2 = messageDigest;
                    }
                } catch (InterruptedException unused) {
                }
                if (messageDigest2 == null) {
                    throw new NoSuchAlgorithmException("Cannot compute hash");
                }
                messageDigest2.reset();
                messageDigest2.update(bArr);
                bArrDigest = zzd.digest();
            } finally {
            }
        }
        return bArrDigest;
    }

    public static zzbc zzf(int i2) {
        zzaf zzafVarZza = zzbc.zza();
        zzafVarZza.zzD(4096L);
        return (zzbc) zzafVarZza.zzan();
    }

    private static byte[] zzg(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] bArrArray;
        int length = bArr.length;
        int i2 = true != z ? 255 : 239;
        if (length > i2) {
            bArr = zzf(4096).zzav();
        }
        int i3 = i2 + 1;
        int length2 = bArr.length;
        byte b2 = (byte) length2;
        if (length2 < i2) {
            byte[] bArr2 = new byte[i2 - length2];
            new SecureRandom().nextBytes(bArr2);
            bArrArray = ByteBuffer.allocate(i3).put(b2).put(bArr).put(bArr2).array();
        } else {
            bArrArray = ByteBuffer.allocate(i3).put(b2).put(bArr).array();
        }
        if (z) {
            bArrArray = ByteBuffer.allocate(256).put(zze(bArrArray)).put(bArrArray).array();
        }
        byte[] bArr3 = new byte[256];
        zzft[] zzftVarArr = new zzgs().zzcG;
        int length3 = zzftVarArr.length;
        for (int i4 = 0; i4 < 12; i4++) {
            zzftVarArr[i4].zza(bArrArray, bArr3);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzfm(str.getBytes("UTF-8")).zza(bArr3);
        }
        return bArr3;
    }
}
