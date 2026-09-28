package com.google.android.gms.internal.pal;

import java.lang.reflect.Method;
import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final class zzdv {

    /* renamed from: a, reason: collision with root package name */
    public static zzjy f37647a;

    public static void a(zzdu zzduVar) throws GeneralSecurityException {
        Method methodC;
        if (f37647a != null) {
            return;
        }
        String str = (String) zzfv.f37741d.f37744c.a(zzgk.o);
        if (str == null || str.length() == 0) {
            str = null;
            if (zzduVar != null && (methodC = zzduVar.c("hwvIMOeohSBrCWT4pVkQok22g/l0cZbbqOTmNbjObWwcwhLlaFMNibQmd2cIB1Vb", "24f7+wNdQe8HQwz0gPH2QIzxUp8iQNA20yBU7Dg74Sc=")) != null) {
                str = (String) methodC.invoke(null, null);
            }
            if (str == null) {
                return;
            }
        }
        try {
            zzkm zzkmVarA = zzkr.a(zzbj.a(str, true));
            for (zzvw zzvwVar : zznn.f37945a.q()) {
                if (zzvwVar.r().isEmpty()) {
                    throw new GeneralSecurityException("Missing type_url.");
                }
                if (zzvwVar.q().isEmpty()) {
                    throw new GeneralSecurityException("Missing primitive_name.");
                }
                if (zzvwVar.p().isEmpty()) {
                    throw new GeneralSecurityException("Missing catalogue_name.");
                }
                if (!zzvwVar.p().equals("TinkAead") && !zzvwVar.p().equals("TinkMac") && !zzvwVar.p().equals("TinkHybridDecrypt") && !zzvwVar.p().equals("TinkHybridEncrypt") && !zzvwVar.p().equals("TinkPublicKeySign") && !zzvwVar.p().equals("TinkPublicKeyVerify") && !zzvwVar.p().equals("TinkStreamingAead") && !zzvwVar.p().equals("TinkDeterministicAead")) {
                    zzju zzjuVarA = zzlf.a(zzvwVar.p());
                    zzlf.f(zzjuVarA.zza());
                    zzlf.d(zzjuVarA.zzb(), zzvwVar.s());
                }
            }
            zzlf.f(new zzns());
            f37647a = (zzjy) zzkmVarA.b();
        } catch (IllegalArgumentException | GeneralSecurityException unused) {
        }
    }
}
