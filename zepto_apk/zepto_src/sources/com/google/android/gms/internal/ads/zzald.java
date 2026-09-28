package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzald extends zzalm {
    public zzafb n;
    public zzalc o;

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void a(boolean z) {
        super.a(z);
        if (z) {
            this.n = null;
            this.o = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final long b(zzer zzerVar) {
        byte[] bArr = zzerVar.f30144a;
        if (bArr[0] != -1) {
            return -1L;
        }
        int i2 = (bArr[2] & 255) >> 4;
        if (i2 == 6) {
            zzerVar.G(4);
            zzerVar.o();
        } else if (i2 == 7) {
            i2 = 7;
            zzerVar.G(4);
            zzerVar.o();
        }
        int iB = zzaew.b(i2, zzerVar);
        zzerVar.E(0);
        return iB;
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final boolean c(zzer zzerVar, long j2, zzalk zzalkVar) {
        byte[] bArr = zzerVar.f30144a;
        zzafb zzafbVar = this.n;
        if (zzafbVar == null) {
            zzafb zzafbVar2 = new zzafb(bArr, 17);
            this.n = zzafbVar2;
            zzt zztVar = new zzt(zzafbVar2.b(Arrays.copyOfRange(bArr, 9, zzerVar.f30146c), null));
            zztVar.d("audio/ogg");
            zzalkVar.f23486a = new zzv(zztVar);
            return true;
        }
        byte b2 = bArr[0];
        if ((b2 & 127) == 3) {
            zzafa zzafaVarA = zzaey.a(zzerVar);
            zzafb zzafbVar3 = new zzafb(zzafbVar.f22904a, zzafbVar.f22905b, zzafbVar.f22906c, zzafbVar.f22907d, zzafbVar.f22908e, zzafbVar.f22910g, zzafbVar.f22911h, zzafbVar.f22913j, zzafaVarA, zzafbVar.f22915l);
            this.n = zzafbVar3;
            this.o = new zzalc(zzafbVar3, zzafaVarA);
            return true;
        }
        if (b2 != -1) {
            return true;
        }
        zzalc zzalcVar = this.o;
        if (zzalcVar != null) {
            zzalcVar.f23468c = j2;
            zzalkVar.f23487b = zzalcVar;
        }
        zzalkVar.f23486a.getClass();
        return false;
    }
}
