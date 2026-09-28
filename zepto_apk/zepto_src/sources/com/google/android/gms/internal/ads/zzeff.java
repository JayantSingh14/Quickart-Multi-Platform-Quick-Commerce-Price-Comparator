package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* loaded from: classes4.dex */
final class zzeff implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbyj f29210a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbys f29211b;

    public zzeff(zzefw zzefwVar, zzbys zzbysVar, zzbyj zzbyjVar) {
        this.f29211b = zzbysVar;
        this.f29210a = zzbyjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        try {
            zzbys zzbysVar = this.f29211b;
            Parcelable.Creator<com.google.android.gms.ads.internal.util.zzba> creator = com.google.android.gms.ads.internal.util.zzba.CREATOR;
            com.google.android.gms.ads.internal.client.zze zzeVarA = zzfjm.a(th);
            com.google.android.gms.ads.internal.util.zzba zzbaVar = new com.google.android.gms.ads.internal.util.zzba(zzgqr.a(th.getMessage()) ? zzeVarA.f21162b : th.getMessage(), zzeVarA.f21161a);
            Parcel parcelG = zzbysVar.g();
            zzbcd.c(parcelG, zzbaVar);
            zzbysVar.j1(2, parcelG);
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zze.l("Service can't call client", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zzb(Object obj) {
        String str = (String) obj;
        try {
            zzbys zzbysVar = this.f29211b;
            zzbyj zzbyjVar = this.f29210a;
            Parcel parcelG = zzbysVar.g();
            parcelG.writeString(str);
            zzbcd.c(parcelG, zzbyjVar);
            zzbysVar.j1(1, parcelG);
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zze.l("Service can't call client", e2);
        }
    }
}
