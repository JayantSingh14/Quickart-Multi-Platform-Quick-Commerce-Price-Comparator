package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzpv {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f38009a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f38010b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f38011c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f38012d;

    public zzpv() {
        this.f38009a = new HashMap();
        this.f38010b = new HashMap();
        this.f38011c = new HashMap();
        this.f38012d = new HashMap();
    }

    public final void a(zzou zzouVar) throws GeneralSecurityException {
        zzouVar.getClass();
        zzpx zzpxVar = new zzpx(zzps.class, zzouVar.f37987a);
        HashMap map = this.f38010b;
        if (!map.containsKey(zzpxVar)) {
            map.put(zzpxVar, zzouVar);
            return;
        }
        zzou zzouVar2 = (zzou) map.get(zzpxVar);
        if (!zzouVar2.equals(zzouVar) || !zzouVar.equals(zzouVar2)) {
            throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzpxVar.toString()));
        }
    }

    public final void b(zzox zzoxVar) throws GeneralSecurityException {
        zzoxVar.getClass();
        zzpz zzpzVar = new zzpz(zzqe.class, zzps.class);
        HashMap map = this.f38009a;
        if (!map.containsKey(zzpzVar)) {
            map.put(zzpzVar, zzoxVar);
            return;
        }
        zzox zzoxVar2 = (zzox) map.get(zzpzVar);
        if (!zzoxVar2.equals(zzoxVar) || !zzoxVar.equals(zzoxVar2)) {
            throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzpzVar.toString()));
        }
    }

    public final void c(zzpm zzpmVar) throws GeneralSecurityException {
        zzpmVar.getClass();
        zzpx zzpxVar = new zzpx(zzpt.class, zzpmVar.f38001a);
        HashMap map = this.f38012d;
        if (!map.containsKey(zzpxVar)) {
            map.put(zzpxVar, zzpmVar);
            return;
        }
        zzpm zzpmVar2 = (zzpm) map.get(zzpxVar);
        if (!zzpmVar2.equals(zzpmVar) || !zzpmVar.equals(zzpmVar2)) {
            throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzpxVar.toString()));
        }
    }

    public final void d(zzpp zzppVar) throws GeneralSecurityException {
        zzppVar.getClass();
        zzpz zzpzVar = new zzpz(zzqj.class, zzpt.class);
        HashMap map = this.f38011c;
        if (!map.containsKey(zzpzVar)) {
            map.put(zzpzVar, zzppVar);
            return;
        }
        zzpp zzppVar2 = (zzpp) map.get(zzpzVar);
        if (!zzppVar2.equals(zzppVar) || !zzppVar.equals(zzppVar2)) {
            throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzpzVar.toString()));
        }
    }

    public zzpv(zzqb zzqbVar) {
        this.f38009a = new HashMap(zzqbVar.f38018a);
        this.f38010b = new HashMap(zzqbVar.f38019b);
        this.f38011c = new HashMap(zzqbVar.f38020c);
        this.f38012d = new HashMap(zzqbVar.f38021d);
    }
}
