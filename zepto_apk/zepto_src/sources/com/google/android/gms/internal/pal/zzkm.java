package com.google.android.gms.internal.pal;

import androidx.fragment.app.e;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public final class zzkm {

    /* renamed from: a, reason: collision with root package name */
    public final zzwb f37892a;

    /* renamed from: b, reason: collision with root package name */
    public final zzrb f37893b = zzrb.f38039b;

    public zzkm(zzwb zzwbVar) {
        this.f37892a = zzwbVar;
    }

    public static final zzkm a(zzjz zzjzVar) throws GeneralSecurityException, IOException {
        try {
            zzwb zzwbVarA = zzjzVar.a();
            for (zzwa zzwaVar : zzwbVarA.t()) {
                if (zzwaVar.q().q() == zzvn.UNKNOWN_KEYMATERIAL || zzwaVar.q().q() == zzvn.SYMMETRIC || zzwaVar.q().q() == zzvn.ASYMMETRIC_PRIVATE) {
                    throw new GeneralSecurityException("keyset contains key material of type " + zzwaVar.q().q().name() + " for type url " + zzwaVar.q().t());
                }
            }
            if (zzwbVarA.p() > 0) {
                return new zzkm(zzwbVarA);
            }
            throw new GeneralSecurityException("empty keyset");
        } catch (zzadi unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }

    public final Object b() throws GeneralSecurityException {
        zzlc zzlcVar = (zzlc) zzlf.f37916f.get(zzjy.class);
        Class clsZza = zzlcVar == null ? null : zzlcVar.zza();
        if (clsZza == null) {
            throw new GeneralSecurityException("No wrapper found for ".concat(zzjy.class.getName()));
        }
        int i2 = zzlh.f37918a;
        zzwb zzwbVar = this.f37892a;
        int iQ = zzwbVar.q();
        boolean z = true;
        int i3 = 0;
        boolean z2 = false;
        for (zzwa zzwaVar : zzwbVar.t()) {
            if (zzwaVar.v() == 3) {
                if (!zzwaVar.u()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzwaVar.p())));
                }
                if (zzwaVar.w() == 2) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzwaVar.p())));
                }
                if (zzwaVar.v() == 2) {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzwaVar.p())));
                }
                if (zzwaVar.p() == iQ) {
                    if (z2) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z2 = true;
                }
                z &= zzwaVar.q().q() == zzvn.ASYMMETRIC_PUBLIC;
                i3++;
            }
        }
        if (i3 == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z2 && !z) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
        zzku zzkuVar = new zzku(clsZza);
        if (zzkuVar.f37896b == null) {
            throw new IllegalStateException("setAnnotations cannot be called after build");
        }
        zzkuVar.f37898d = this.f37893b;
        for (zzwa zzwaVar2 : zzwbVar.t()) {
            if (zzwaVar2.v() == 3) {
                zzvo zzvoVarQ = zzwaVar2.q();
                Object objB = ((zzki) zzlf.f37912b.get()).a(clsZza, zzvoVarQ.t()).b(zzvoVarQ.s());
                if (zzwaVar2.p() == zzwbVar.q()) {
                    zzkuVar.a(objB, zzwaVar2, true);
                } else {
                    zzkuVar.a(objB, zzwaVar2, false);
                }
            }
        }
        ConcurrentHashMap concurrentHashMap = zzkuVar.f37896b;
        if (concurrentHashMap == null) {
            throw new IllegalStateException("build cannot be called twice");
        }
        zzkv zzkvVar = zzkuVar.f37897c;
        zzrb zzrbVar = zzkuVar.f37898d;
        Class cls = zzkuVar.f37895a;
        zzlb zzlbVar = new zzlb(concurrentHashMap, zzkvVar, zzrbVar, cls);
        zzkuVar.f37896b = null;
        zzlc zzlcVar2 = (zzlc) zzlf.f37916f.get(zzjy.class);
        if (zzlcVar2 == null) {
            throw new GeneralSecurityException("No wrapper found for ".concat(cls.getName()));
        }
        if (zzlcVar2.zza().equals(cls)) {
            return zzlcVar2.a(zzlbVar);
        }
        throw new GeneralSecurityException(e.p("Wrong input primitive class, expected ", zzlcVar2.zza().toString(), ", got ", cls.toString()));
    }

    public final String toString() {
        int i2 = zzlh.f37918a;
        zzwd zzwdVarP = zzwg.p();
        zzwb zzwbVar = this.f37892a;
        int iQ = zzwbVar.q();
        if (zzwdVarP.f37406c) {
            zzwdVarP.k();
            zzwdVarP.f37406c = false;
        }
        ((zzwg) zzwdVarP.f37405b).zze = iQ;
        for (zzwa zzwaVar : zzwbVar.t()) {
            zzwe zzweVarP = zzwf.p();
            String strT = zzwaVar.q().t();
            if (zzweVarP.f37406c) {
                zzweVarP.k();
                zzweVarP.f37406c = false;
            }
            zzwf.q((zzwf) zzweVarP.f37405b, strT);
            int iV = zzwaVar.v();
            if (zzweVarP.f37406c) {
                zzweVarP.k();
                zzweVarP.f37406c = false;
            }
            zzwf.t((zzwf) zzweVarP.f37405b, iV);
            int iW = zzwaVar.w();
            if (zzweVarP.f37406c) {
                zzweVarP.k();
                zzweVarP.f37406c = false;
            }
            ((zzwf) zzweVarP.f37405b).zzh = zzwu.a(iW);
            int iP = zzwaVar.p();
            if (zzweVarP.f37406c) {
                zzweVarP.k();
                zzweVarP.f37406c = false;
            }
            ((zzwf) zzweVarP.f37405b).zzg = iP;
            zzwf zzwfVar = (zzwf) zzweVarP.h();
            if (zzwdVarP.f37406c) {
                zzwdVarP.k();
                zzwdVarP.f37406c = false;
            }
            zzwg.r((zzwg) zzwdVarP.f37405b, zzwfVar);
        }
        return ((zzwg) zzwdVarP.h()).toString();
    }
}
