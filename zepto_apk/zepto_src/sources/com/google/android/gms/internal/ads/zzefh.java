package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzefh implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbza f29212a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbyr f29213b;

    public zzefh(zzefw zzefwVar, zzbza zzbzaVar, zzbyr zzbyrVar) {
        this.f29212a = zzbzaVar;
        this.f29213b = zzbyrVar;
        Objects.requireNonNull(zzefwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        try {
            zzbyr zzbyrVar = this.f29213b;
            Parcelable.Creator<com.google.android.gms.ads.internal.util.zzba> creator = com.google.android.gms.ads.internal.util.zzba.CREATOR;
            com.google.android.gms.ads.internal.client.zze zzeVarA = zzfjm.a(th);
            zzbyrVar.N7(new com.google.android.gms.ads.internal.util.zzba(zzgqr.a(th.getMessage()) ? zzeVarA.f21162b : th.getMessage(), zzeVarA.f21161a));
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zze.l("Service can't call client", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zzb(Object obj) {
        Bundle bundle;
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) obj;
        try {
            zzbgb zzbgbVar = zzbgk.z2;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            boolean zBooleanValue = ((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue();
            zzbyr zzbyrVar = this.f29213b;
            if (!zBooleanValue) {
                zzbyrVar.la(parcelFileDescriptor);
                return;
            }
            boolean zBooleanValue2 = ((Boolean) zzbdVar.f21153c.a(zzbgk.A2)).booleanValue();
            zzbza zzbzaVar = this.f29212a;
            if (zBooleanValue2 && (bundle = zzbzaVar.f25732m) != null) {
                bundle.putLong("binder-call-start", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
            }
            zzbyrVar.f8(parcelFileDescriptor, zzbzaVar);
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zze.l("Service can't call client", e2);
        }
    }
}
