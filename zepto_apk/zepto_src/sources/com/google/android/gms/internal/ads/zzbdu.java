package com.google.android.gms.internal.ads;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzbdu extends zzbdm {

    /* renamed from: c, reason: collision with root package name */
    public MessageDigest f24812c;

    /* renamed from: d, reason: collision with root package name */
    public final int f24813d;

    /* renamed from: e, reason: collision with root package name */
    public final int f24814e;

    public zzbdu(int i2) {
        int i3 = i2 >> 3;
        this.f24813d = (i2 & 7) > 0 ? i3 + 1 : i3;
        this.f24814e = i2;
    }

    public final byte[] b(String str) {
        synchronized (this.f24803a) {
            try {
                MessageDigest messageDigestA = a();
                this.f24812c = messageDigestA;
                if (messageDigestA == null) {
                    return new byte[0];
                }
                messageDigestA.reset();
                this.f24812c.update(str.getBytes(StandardCharsets.UTF_8));
                byte[] bArrDigest = this.f24812c.digest();
                int length = bArrDigest.length;
                int i2 = this.f24813d;
                if (length > i2) {
                    length = i2;
                }
                byte[] bArr = new byte[length];
                System.arraycopy(bArrDigest, 0, bArr, 0, length);
                int i3 = this.f24814e & 7;
                if (i3 > 0) {
                    long j2 = 0;
                    for (int i4 = 0; i4 < length; i4++) {
                        if (i4 > 0) {
                            j2 <<= 8;
                        }
                        j2 += bArr[i4] & 255;
                    }
                    long j3 = j2 >>> (8 - i3);
                    while (true) {
                        i2--;
                        if (i2 < 0) {
                            break;
                        }
                        bArr[i2] = (byte) (255 & j3);
                        j3 >>>= 8;
                    }
                }
                return bArr;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
