package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzfli implements zzijg {
    public static zzgyw a() {
        zzgyw zzgywVar;
        zzbgb zzbgbVar = zzbgk.v6;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            zzgywVar = zzcdo.f25984c;
        } else {
            zzgywVar = ((Boolean) zzbdVar.f21153c.a(zzbgk.u6)).booleanValue() ? zzcdo.f25982a : zzcdo.f25987f;
        }
        zzijo.a(zzgywVar);
        return zzgywVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* synthetic */ Object zzb() {
        return a();
    }
}
