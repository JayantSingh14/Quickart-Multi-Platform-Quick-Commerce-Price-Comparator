package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzxq {

    /* renamed from: a, reason: collision with root package name */
    public final zzaah f35859a;

    /* renamed from: b, reason: collision with root package name */
    public final zzer f35860b = new zzer(32);

    /* renamed from: c, reason: collision with root package name */
    public zzxp f35861c;

    /* renamed from: d, reason: collision with root package name */
    public zzxp f35862d;

    /* renamed from: e, reason: collision with root package name */
    public zzxp f35863e;

    /* renamed from: f, reason: collision with root package name */
    public long f35864f;

    public zzxq(zzaah zzaahVar) {
        this.f35859a = zzaahVar;
        zzxp zzxpVar = new zzxp(0L);
        this.f35861c = zzxpVar;
        this.f35862d = zzxpVar;
        this.f35863e = zzxpVar;
    }

    public static zzxp c(zzxp zzxpVar, zzih zzihVar, zzxr zzxrVar, zzer zzerVar) {
        int iL;
        if (zzihVar.b(1073741824)) {
            long j2 = zzxrVar.f35866b;
            zzerVar.y(1);
            zzxp zzxpVarE = e(zzxpVar, j2, zzerVar.f30144a, 1);
            long j3 = j2 + 1;
            byte b2 = zzerVar.f30144a[0];
            int i2 = b2 & 128;
            int i3 = b2 & 127;
            zzie zzieVar = zzihVar.f34828c;
            byte[] bArr = zzieVar.f34798a;
            if (bArr == null) {
                zzieVar.f34798a = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            boolean z = i2 != 0;
            zzxpVar = e(zzxpVarE, j3, zzieVar.f34798a, i3);
            long j4 = j3 + i3;
            if (z) {
                zzerVar.y(2);
                zzxpVar = e(zzxpVar, j4, zzerVar.f30144a, 2);
                j4 += 2;
                iL = zzerVar.L();
            } else {
                iL = 1;
            }
            int[] iArr = zzieVar.f34801d;
            if (iArr == null || iArr.length < iL) {
                iArr = new int[iL];
            }
            int[] iArr2 = zzieVar.f34802e;
            if (iArr2 == null || iArr2.length < iL) {
                iArr2 = new int[iL];
            }
            if (z) {
                int i4 = iL * 6;
                zzerVar.y(i4);
                zzxpVar = e(zzxpVar, j4, zzerVar.f30144a, i4);
                j4 += i4;
                zzerVar.E(0);
                for (int i5 = 0; i5 < iL; i5++) {
                    iArr[i5] = zzerVar.L();
                    iArr2[i5] = zzerVar.h();
                }
            } else {
                iArr[0] = 0;
                iArr2[0] = zzxrVar.f35865a - ((int) (j4 - zzxrVar.f35866b));
            }
            zzafz zzafzVar = zzxrVar.f35867c;
            String str = zzfj.f31254a;
            byte[] bArr2 = zzafzVar.f22975b;
            byte[] bArr3 = zzieVar.f34798a;
            zzieVar.f34803f = iL;
            zzieVar.f34801d = iArr;
            zzieVar.f34802e = iArr2;
            zzieVar.f34799b = bArr2;
            zzieVar.f34798a = bArr3;
            int i6 = zzafzVar.f22974a;
            zzieVar.f34800c = i6;
            int i7 = zzafzVar.f22976c;
            zzieVar.f34804g = i7;
            int i8 = zzafzVar.f22977d;
            zzieVar.f34805h = i8;
            MediaCodec.CryptoInfo cryptoInfo = zzieVar.f34806i;
            cryptoInfo.numSubSamples = iL;
            cryptoInfo.numBytesOfClearData = iArr;
            cryptoInfo.numBytesOfEncryptedData = iArr2;
            cryptoInfo.key = bArr2;
            cryptoInfo.iv = bArr3;
            cryptoInfo.mode = i6;
            zzid zzidVar = zzieVar.f34807j;
            zzidVar.getClass();
            MediaCodec.CryptoInfo.Pattern pattern = zzidVar.f34752b;
            pattern.set(i7, i8);
            zzidVar.f34751a.setPattern(pattern);
            long j5 = zzxrVar.f35866b;
            int i9 = (int) (j4 - j5);
            zzxrVar.f35866b = j5 + i9;
            zzxrVar.f35865a -= i9;
        }
        if (!zzihVar.b(268435456)) {
            zzihVar.d(zzxrVar.f35865a);
            return d(zzxpVar, zzxrVar.f35866b, zzihVar.f34829d, zzxrVar.f35865a);
        }
        zzerVar.y(4);
        zzxp zzxpVarE2 = e(zzxpVar, zzxrVar.f35866b, zzerVar.f30144a, 4);
        int iH = zzerVar.h();
        zzxrVar.f35866b += 4;
        zzxrVar.f35865a -= 4;
        zzihVar.d(iH);
        zzxp zzxpVarD = d(zzxpVarE2, zzxrVar.f35866b, zzihVar.f34829d, iH);
        zzxrVar.f35866b += iH;
        int i10 = zzxrVar.f35865a - iH;
        zzxrVar.f35865a = i10;
        ByteBuffer byteBuffer = zzihVar.f34832g;
        if (byteBuffer == null || byteBuffer.capacity() < i10) {
            zzihVar.f34832g = ByteBuffer.allocate(i10);
        } else {
            zzihVar.f34832g.clear();
        }
        return d(zzxpVarD, zzxrVar.f35866b, zzihVar.f34832g, zzxrVar.f35865a);
    }

    public static zzxp d(zzxp zzxpVar, long j2, ByteBuffer byteBuffer, int i2) {
        while (j2 >= zzxpVar.f35856b) {
            zzxpVar = zzxpVar.f35858d;
        }
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (zzxpVar.f35856b - j2));
            zzaaf zzaafVar = zzxpVar.f35857c;
            byte[] bArr = zzaafVar.f22583a;
            long j3 = j2 - zzxpVar.f35855a;
            zzaafVar.getClass();
            byteBuffer.put(bArr, (int) j3, iMin);
            i2 -= iMin;
            j2 += iMin;
            if (j2 == zzxpVar.f35856b) {
                zzxpVar = zzxpVar.f35858d;
            }
        }
        return zzxpVar;
    }

    public static zzxp e(zzxp zzxpVar, long j2, byte[] bArr, int i2) {
        while (j2 >= zzxpVar.f35856b) {
            zzxpVar = zzxpVar.f35858d;
        }
        int i3 = i2;
        while (i3 > 0) {
            int iMin = Math.min(i3, (int) (zzxpVar.f35856b - j2));
            zzaaf zzaafVar = zzxpVar.f35857c;
            byte[] bArr2 = zzaafVar.f22583a;
            long j3 = j2 - zzxpVar.f35855a;
            zzaafVar.getClass();
            System.arraycopy(bArr2, (int) j3, bArr, i2 - i3, iMin);
            i3 -= iMin;
            j2 += iMin;
            if (j2 == zzxpVar.f35856b) {
                zzxpVar = zzxpVar.f35858d;
            }
        }
        return zzxpVar;
    }

    public final void a(long j2) {
        zzxp zzxpVar;
        if (j2 != -1) {
            while (true) {
                zzxpVar = this.f35861c;
                if (j2 < zzxpVar.f35856b) {
                    break;
                }
                this.f35859a.b(zzxpVar.f35857c);
                zzxp zzxpVar2 = this.f35861c;
                zzxpVar2.f35857c = null;
                zzxp zzxpVar3 = zzxpVar2.f35858d;
                zzxpVar2.f35858d = null;
                this.f35861c = zzxpVar3;
            }
            if (this.f35862d.f35855a < zzxpVar.f35855a) {
                this.f35862d = zzxpVar;
            }
        }
    }

    public final int b(int i2) {
        zzxp zzxpVar = this.f35863e;
        if (zzxpVar.f35857c == null) {
            zzaaf zzaafVarZza = this.f35859a.zza();
            zzxp zzxpVar2 = new zzxp(this.f35863e.f35856b);
            zzxpVar.f35857c = zzaafVarZza;
            zzxpVar.f35858d = zzxpVar2;
        }
        return Math.min(i2, (int) (this.f35863e.f35856b - this.f35864f));
    }
}
