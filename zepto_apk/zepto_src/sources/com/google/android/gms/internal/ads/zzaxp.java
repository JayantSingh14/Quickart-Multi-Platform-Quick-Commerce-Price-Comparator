package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
final class zzaxp {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f24442a = false;

    /* renamed from: b, reason: collision with root package name */
    public static MessageDigest f24443b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f24444c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static final Object f24445d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public static final CountDownLatch f24446e = new CountDownLatch(1);

    public static void a() {
        synchronized (f24445d) {
            try {
                if (!f24442a) {
                    f24442a = true;
                    new Thread(new zzaxo()).start();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static zzaxf b(String str, byte[] bArr) {
        Vector vector;
        int length = bArr.length;
        if (length <= 0) {
            vector = null;
        } else {
            int i2 = length + 254;
            vector = new Vector();
            for (int i3 = 0; i3 < i2 / 255; i3++) {
                int i4 = i3 * 255;
                try {
                    int length2 = bArr.length;
                    if (length2 - i4 > 255) {
                        length2 = i4 + 255;
                    }
                    vector.add(Arrays.copyOfRange(bArr, i4, length2));
                } catch (IndexOutOfBoundsException unused) {
                }
            }
        }
        if (vector == null || vector.isEmpty()) {
            return null;
        }
        zzaxf zzaxfVarC = zzaxg.C();
        int size = vector.size();
        for (int i5 = 0; i5 < size; i5++) {
            zzhzl zzhzlVarV = zzhzl.v(0, d(str, (byte[]) vector.get(i5), false), 256);
            zzaxfVarC.j();
            ((zzaxg) zzaxfVarC.f34638b).D(zzhzlVarV);
        }
        byte[] bArrC = c(bArr);
        zzhzl zzhzlVar = zzhzl.f34557b;
        zzhzl zzhzlVarV2 = zzhzl.v(0, bArrC, bArrC.length);
        zzaxfVarC.j();
        ((zzaxg) zzaxfVarC.f34638b).E(zzhzlVarV2);
        return zzaxfVarC;
    }

    public static byte[] c(byte[] bArr) {
        byte[] bArrDigest;
        MessageDigest messageDigest;
        synchronized (f24444c) {
            try {
                a();
                MessageDigest messageDigest2 = null;
                try {
                    if (f24446e.await(2L, TimeUnit.SECONDS) && (messageDigest = f24443b) != null) {
                        messageDigest2 = messageDigest;
                    }
                } catch (InterruptedException unused) {
                }
                if (messageDigest2 == null) {
                    throw new NoSuchAlgorithmException("Cannot compute hash");
                }
                messageDigest2.reset();
                messageDigest2.update(bArr);
                bArrDigest = f24443b.digest();
            } finally {
            }
        }
        return bArrDigest;
    }

    public static byte[] d(String str, byte[] bArr, boolean z) {
        byte[] bArrArray;
        int length = bArr.length;
        int i2 = true != z ? 255 : 239;
        if (length > i2) {
            zzavs zzavsVarF0 = zzawp.F0();
            zzavsVarF0.o(4096L);
            bArr = ((zzawp) zzavsVarF0.l()).g();
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
            bArrArray = ByteBuffer.allocate(256).put(c(bArrArray)).put(bArrArray).array();
        }
        byte[] bArr3 = new byte[256];
        zzaxq[] zzaxqVarArr = new zzayd().G2;
        int length3 = zzaxqVarArr.length;
        for (int i4 = 0; i4 < 12; i4++) {
            zzaxqVarArr[i4].zza(bArrArray, bArr3);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            zzaxh zzaxhVar = new zzaxh(str.getBytes("UTF-8"));
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < 256; i7++) {
                i5 = (i5 + 1) & 255;
                byte[] bArr4 = zzaxhVar.f24430a;
                byte b3 = bArr4[i5];
                i6 = (i6 + b3) & 255;
                bArr4[i5] = bArr4[i6];
                bArr4[i6] = b3;
                bArr3[i7] = (byte) (bArr4[(bArr4[i5] + b3) & 255] ^ bArr3[i7]);
            }
        }
        return bArr3;
    }
}
