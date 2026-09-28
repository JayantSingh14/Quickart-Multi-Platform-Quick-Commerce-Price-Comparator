package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes4.dex */
final /* synthetic */ class zzva implements zzvb {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzv f35692a;

    public /* synthetic */ zzva(zzv zzvVar) {
        this.f35692a = zzvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final int zza(Object obj) {
        zzuj zzujVar = (zzuj) obj;
        HashMap map = zzvc.f35693a;
        zzujVar.getClass();
        zzv zzvVar = this.f35692a;
        String str = zzvVar.f35691m;
        String str2 = zzujVar.f35646b;
        return ((str2.equals(str) || str2.equals(zzvc.c(zzvVar))) && zzujVar.f(zzvVar, false) && zzujVar.g(zzvVar)) ? 1 : 0;
    }
}
