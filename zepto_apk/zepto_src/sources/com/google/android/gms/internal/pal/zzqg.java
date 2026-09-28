package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzqg extends zzoz {
    @Override // com.google.android.gms.internal.pal.zzoz
    public final zzaef a(zzaef zzaefVar) {
        zzrp zzrpVar = (zzrp) zzaefVar;
        zzrl zzrlVarQ = zzrm.q();
        if (zzrlVarQ.f37406c) {
            zzrlVarQ.k();
            zzrlVarQ.f37406c = false;
        }
        ((zzrm) zzrlVarQ.f37405b).zze = 0;
        byte[] bArrA = zzyq.a(zzrpVar.p());
        zzaby zzabyVarQ = zzaby.q(0, bArrA, bArrA.length);
        if (zzrlVarQ.f37406c) {
            zzrlVarQ.k();
            zzrlVarQ.f37406c = false;
        }
        ((zzrm) zzrlVarQ.f37405b).zzf = zzabyVarQ;
        zzrs zzrsVarS = zzrpVar.s();
        if (zzrlVarQ.f37406c) {
            zzrlVarQ.k();
            zzrlVarQ.f37406c = false;
        }
        zzrm.w((zzrm) zzrlVarQ.f37405b, zzrsVarS);
        return (zzrm) zzrlVarQ.h();
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final /* synthetic */ zzaef b(zzaby zzabyVar) {
        return zzrp.r(zzabyVar, zzacm.a());
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final Map c() {
        HashMap map = new HashMap();
        zzro zzroVarQ = zzrp.q();
        zzroVarQ.l();
        zzrr zzrrVarQ = zzrs.q();
        zzrrVarQ.l();
        zzroVarQ.m((zzrs) zzrrVarQ.h());
        map.put("AES_CMAC", new zzoy((zzrp) zzroVarQ.h(), 1));
        zzro zzroVarQ2 = zzrp.q();
        zzroVarQ2.l();
        zzrr zzrrVarQ2 = zzrs.q();
        zzrrVarQ2.l();
        zzroVarQ2.m((zzrs) zzrrVarQ2.h());
        map.put("AES256_CMAC", new zzoy((zzrp) zzroVarQ2.h(), 1));
        zzro zzroVarQ3 = zzrp.q();
        zzroVarQ3.l();
        zzrr zzrrVarQ3 = zzrs.q();
        zzrrVarQ3.l();
        zzroVarQ3.m((zzrs) zzrrVarQ3.h());
        map.put("AES256_CMAC_RAW", new zzoy((zzrp) zzroVarQ3.h(), 3));
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final void d(zzaef zzaefVar) throws GeneralSecurityException {
        zzrp zzrpVar = (zzrp) zzaefVar;
        zzqh.h(zzrpVar.s());
        if (zzrpVar.p() != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }
}
