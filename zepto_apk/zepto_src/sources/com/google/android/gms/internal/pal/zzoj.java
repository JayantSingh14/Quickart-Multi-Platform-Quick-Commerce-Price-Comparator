package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
final class zzoj extends zzpq {
    @Override // com.google.android.gms.internal.pal.zzpq
    public final Object a(zzaef zzaefVar) {
        zzvj zzvjVar = (zzvj) zzaefVar;
        if (zzvjVar.u().f() == 0) {
            throw new IllegalArgumentException("HpkePublicKey.public_key is empty.");
        }
        zzvd zzvdVarQ = zzvjVar.q();
        return new zzob(zzvjVar, zzof.b(zzvdVarQ), zzof.c(zzvdVarQ), zzof.a(zzvdVarQ));
    }
}
