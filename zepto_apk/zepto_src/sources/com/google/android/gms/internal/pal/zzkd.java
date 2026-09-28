package com.google.android.gms.internal.pal;

import androidx.fragment.app.e;
import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
class zzkd implements zzkb {

    /* renamed from: a, reason: collision with root package name */
    public final zzpa f37879a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f37880b;

    public zzkd(zzpa zzpaVar, Class cls) {
        if (!zzpaVar.f37992b.keySet().contains(cls) && !Void.class.equals(cls)) {
            throw new IllegalArgumentException(e.p("Given internalKeyMananger ", zzpaVar.toString(), " does not support primitive class ", cls.getName()));
        }
        this.f37879a = zzpaVar;
        this.f37880b = cls;
    }

    @Override // com.google.android.gms.internal.pal.zzkb
    public final Object a(zzacz zzaczVar) throws GeneralSecurityException {
        zzpa zzpaVar = this.f37879a;
        String strConcat = "Expected proto of type ".concat(zzpaVar.f37991a.getName());
        if (!zzpaVar.f37991a.isInstance(zzaczVar)) {
            throw new GeneralSecurityException(strConcat);
        }
        Class cls = this.f37880b;
        if (Void.class.equals(cls)) {
            throw new GeneralSecurityException("Cannot create a primitive for Void");
        }
        zzpaVar.e(zzaczVar);
        return zzpaVar.g(zzaczVar, cls);
    }

    @Override // com.google.android.gms.internal.pal.zzkb
    public final Object b(zzaby zzabyVar) throws GeneralSecurityException {
        zzpa zzpaVar = this.f37879a;
        try {
            zzaef zzaefVarC = zzpaVar.c(zzabyVar);
            Class cls = this.f37880b;
            if (Void.class.equals(cls)) {
                throw new GeneralSecurityException("Cannot create a primitive for Void");
            }
            zzpaVar.e(zzaefVarC);
            return zzpaVar.g(zzaefVarC, cls);
        } catch (zzadi e2) {
            throw new GeneralSecurityException("Failures parsing proto of type ".concat(zzpaVar.f37991a.getName()), e2);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzkb
    public final zzvo c(zzaby zzabyVar) throws GeneralSecurityException {
        zzpa zzpaVar = this.f37879a;
        try {
            zzaef zzaefVarA = new zzkc(zzpaVar.a()).a(zzabyVar);
            zzvl zzvlVarP = zzvo.p();
            String strD = zzpaVar.d();
            if (zzvlVarP.f37406c) {
                zzvlVarP.k();
                zzvlVarP.f37406c = false;
            }
            zzvo.u((zzvo) zzvlVarP.f37405b, strD);
            zzaby zzabyVarA = zzaefVarA.a();
            if (zzvlVarP.f37406c) {
                zzvlVarP.k();
                zzvlVarP.f37406c = false;
            }
            ((zzvo) zzvlVarP.f37405b).zzf = zzabyVarA;
            zzvn zzvnVarB = zzpaVar.b();
            if (zzvlVarP.f37406c) {
                zzvlVarP.k();
                zzvlVarP.f37406c = false;
            }
            zzvo.w((zzvo) zzvlVarP.f37405b, zzvnVarB);
            return (zzvo) zzvlVarP.h();
        } catch (zzadi e2) {
            throw new GeneralSecurityException("Unexpected proto", e2);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzkb
    public final zzaef d(zzaby zzabyVar) throws GeneralSecurityException {
        zzpa zzpaVar = this.f37879a;
        try {
            return new zzkc(zzpaVar.a()).a(zzabyVar);
        } catch (zzadi e2) {
            throw new GeneralSecurityException("Failures parsing proto of type ".concat(zzpaVar.a().f37990a.getName()), e2);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzkb
    public final Class zzc() {
        return this.f37880b;
    }

    @Override // com.google.android.gms.internal.pal.zzkb
    public final String zzf() {
        return this.f37879a.d();
    }
}
