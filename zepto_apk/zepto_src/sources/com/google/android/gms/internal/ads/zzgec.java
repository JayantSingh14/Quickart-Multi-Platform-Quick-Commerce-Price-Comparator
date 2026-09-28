package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes4.dex */
public final class zzgec {

    /* renamed from: a, reason: collision with root package name */
    public MessageDigest f32370a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgnc f32371b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f32372c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public boolean f32373d = false;

    /* renamed from: e, reason: collision with root package name */
    public SecureRandom f32374e;

    public zzgec(zzgnc zzgncVar) {
        this.f32371b = zzgncVar;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0039: INVOKE (r1 I:com.google.android.gms.internal.ads.zzgna) VIRTUAL call: com.google.android.gms.internal.ads.zzgna.c():void A[Catch: all -> 0x0037, MD:():void (m), TRY_ENTER] (LINE:58), block:B:25:0x0039 */
    public final void a() {
        boolean z;
        zzgna zzgnaVarC;
        synchronized (this) {
            z = this.f32373d;
        }
        if (z) {
            return;
        }
        SecureRandom secureRandom = new SecureRandom();
        synchronized (this) {
            try {
                zzgna zzgnaVarA = this.f32371b.a(202);
                try {
                    zzgnaVarA.a();
                    this.f32374e = secureRandom;
                    this.f32370a = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                    this.f32373d = true;
                } catch (NoSuchAlgorithmException e2) {
                    zzgnaVarA.b(e2);
                } catch (Throwable th) {
                    zzgnaVarA.b(th);
                    throw th;
                }
                zzgnaVarA.c();
            } catch (Throwable th2) {
                zzgnaVarC.c();
                throw th2;
            }
        }
    }

    public final byte[] b(String str, byte[] bArr, boolean z) {
        int length = bArr.length;
        int i2 = true != z ? 255 : 239;
        zzgqa.a(length <= i2);
        ByteBuffer byteBufferPut = ByteBuffer.allocate(i2 + 1).put((byte) length);
        if (length < i2) {
            int i3 = i2 - length;
            byte[] bArr2 = new byte[i3];
            this.f32374e.nextBytes(bArr2);
            bArr = Arrays.copyOf(bArr, length + i3);
            System.arraycopy(bArr2, 0, bArr, length, i3);
        }
        byte[] bArrArray = byteBufferPut.put(bArr).array();
        if (z) {
            bArrArray = ByteBuffer.allocate(256).put(c(bArrArray)).put(bArrArray).array();
        }
        byte[] bArr3 = new byte[256];
        zzgef[] zzgefVarArr = new zzges().G2;
        int length2 = zzgefVarArr.length;
        for (int i4 = 0; i4 < 12; i4++) {
            zzgefVarArr[i4].zza(bArrArray, bArr3);
        }
        if (!zzgpz.a(str)) {
            zzgee zzgeeVar = new zzgee(str.length() > 32 ? str.substring(0, 32).getBytes(StandardCharsets.UTF_8) : str.getBytes(StandardCharsets.UTF_8));
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < 256; i7++) {
                i5 = (i5 + 1) & 255;
                byte[] bArr4 = zzgeeVar.f32376a;
                byte b2 = bArr4[i5];
                i6 = (i6 + b2) & 255;
                bArr4[i5] = bArr4[i6];
                bArr4[i6] = b2;
                bArr3[i7] = (byte) (bArr4[(bArr4[i5] + b2) & 255] ^ bArr3[i7]);
            }
        }
        return bArr3;
    }

    public final byte[] c(byte[] bArr) {
        byte[] bArrDigest;
        synchronized (this.f32372c) {
            this.f32370a.reset();
            this.f32370a.update(bArr);
            bArrDigest = this.f32370a.digest();
        }
        return bArrDigest;
    }

    public final zzaxf d(String str, byte[] bArr) {
        zzaxf zzaxfVarC = zzaxg.C();
        byte[] bArrC = c(bArr);
        zzhzl zzhzlVar = zzhzl.f34557b;
        zzhzl zzhzlVarV = zzhzl.v(0, bArrC, bArrC.length);
        zzaxfVarC.j();
        ((zzaxg) zzaxfVarC.f34638b).E(zzhzlVarV);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            int length = bArr.length;
            if (i2 >= ((length - 1) / 255) + 1) {
                break;
            }
            int i3 = i2 * 255;
            int i4 = i3 + 255;
            if (length > i4) {
                length = i4;
            }
            arrayList.add(Arrays.copyOfRange(bArr, i3, length));
            i2++;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            zzhzl zzhzlVarV2 = zzhzl.v(0, b(str, (byte[]) it.next(), false), 256);
            zzaxfVarC.j();
            ((zzaxg) zzaxfVarC.f34638b).D(zzhzlVarV2);
        }
        return zzaxfVarC;
    }
}
