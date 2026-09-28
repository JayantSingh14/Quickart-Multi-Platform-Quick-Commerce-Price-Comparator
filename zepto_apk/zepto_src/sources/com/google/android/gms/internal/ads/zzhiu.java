package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhiu implements zzhhz {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhiu f33868a = new zzhiu();

    @Override // com.google.android.gms.internal.ads.zzhhz
    public final zzgzx a(zzhan zzhanVar, Integer num) throws GeneralSecurityException {
        zzhhz zzhhzVar = zzhiv.f33869b;
        zzhpd zzhpdVar = ((zzhin) zzhanVar).f33863a.f33917b;
        zzhia zzhiaVar = zzhia.f33848d;
        zzgzy zzgzyVarD = zzhiaVar.d(zzhpdVar.C());
        if (!((Boolean) zzhiaVar.f33850b.get(zzhpdVar.C())).booleanValue()) {
            throw new GeneralSecurityException("Creating new keys is not allowed.");
        }
        zzhpa zzhpaVarB = zzgzyVarD.b(zzhpdVar.D());
        return new zzhim(zzhjz.a(zzhpaVarB.C(), zzhpaVarB.D(), zzhpaVarB.E(), zzhpdVar.E(), num));
    }
}
