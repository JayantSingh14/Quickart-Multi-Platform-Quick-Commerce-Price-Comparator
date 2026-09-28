package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzalj extends zzalm {
    public static final byte[] o = {79, 112, 117, 115, 72, 101, 97, 100};
    public static final byte[] p = {79, 112, 117, 115, 84, 97, 103, 115};
    public boolean n;

    public static boolean e(zzer zzerVar, byte[] bArr) {
        if (zzerVar.B() < 8) {
            return false;
        }
        int i2 = zzerVar.f30145b;
        byte[] bArr2 = new byte[8];
        zzerVar.H(0, bArr2, 8);
        zzerVar.E(i2);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void a(boolean z) {
        super.a(z);
        if (z) {
            this.n = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final long b(zzer zzerVar) {
        byte[] bArr = zzerVar.f30144a;
        return (this.f23496i * zzafn.b(bArr[0], bArr.length > 1 ? bArr[1] : (byte) 0)) / 1000000;
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final boolean c(zzer zzerVar, long j2, zzalk zzalkVar) {
        if (e(zzerVar, o)) {
            byte[] bArrCopyOf = Arrays.copyOf(zzerVar.f30144a, zzerVar.f30146c);
            int i2 = bArrCopyOf[9] & 255;
            ArrayList arrayListA = zzafn.a(bArrCopyOf);
            if (zzalkVar.f23486a == null) {
                zzt zztVar = new zzt();
                zztVar.d("audio/ogg");
                zztVar.e("audio/opus");
                zztVar.D = i2;
                zztVar.E = 48000;
                zztVar.o = arrayListA;
                zzalkVar.f23486a = new zzv(zztVar);
                return true;
            }
        } else {
            if (!e(zzerVar, p)) {
                zzalkVar.f23486a.getClass();
                return false;
            }
            zzalkVar.f23486a.getClass();
            if (!this.n) {
                this.n = true;
                zzerVar.G(8);
                zzap zzapVarC = zzagg.c(zzgtd.s(zzagg.b(zzerVar, false, false).f22992a));
                if (zzapVarC != null) {
                    zzv zzvVar = zzalkVar.f23486a;
                    zzvVar.getClass();
                    zzt zztVar2 = new zzt(zzvVar);
                    zztVar2.f35573j = zzapVarC.b(zzalkVar.f23486a.f35689k);
                    zzalkVar.f23486a = new zzv(zztVar2);
                    return true;
                }
            }
        }
        return true;
    }
}
